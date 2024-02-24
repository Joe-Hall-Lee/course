package com.bjpowernode.oa.web.action;

import com.bjpowernode.oa.bean.User;
import com.bjpowernode.oa.utils.DBUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Servlet 负责业务的处理
// JSP 负责页面的展示。
@WebServlet({"/user/login", "/user/exit"})
public class UserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String servletPath = request.getServletPath();
        if ("/user/login".equals(servletPath)) {
            doLogin(request, response);
        } else if ("/user/exit".equals(servletPath)) {
            doExit(request, response);
        }
    }

    protected void doExit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取 session 对象，销毁 session
        HttpSession session = request.getSession(false);

        if (session != null) {

            // 从 session 域中删除 user 对象
            session.removeAttribute("user");

            // 手动销毁 session 对象。
            session.invalidate();

            // 销毁 cookie（退出系统将所有的 cookie 全部销毁）
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {

                for (Cookie cookie : cookies) {
                    // 设置 cookie 的有效期为 0，表示删除该 cookie
                    cookie.setMaxAge(0);
                    // 设置一下 cookie 的路径
                    cookie.setPath(request.getContextPath()); // 删除 cookie 的时候注意路径问题。
                    // 响应 cookie 给浏览器，浏览器会将之前的 cookie 覆盖。
                    response.addCookie(cookie);
                }
            }

            /*
            // 换一种方案
            Cookie cookie1 = new Cookie("username", "");
            cookie1.setMaxAge(0);
            cookie1.setPath(request.getContextPath());

            Cookie cookie2 = new Cookie("password", "");
            cookie2.setMaxAge(0);
            cookie2.setPath(request.getContextPath());

            response.addCookie(cookie1);
            response.addCookie(cookie2);
            */


            // 跳转到登录页面
            response.sendRedirect(request.getContextPath());
        }
    }

    // cookie username  /oa
    // cookie username  /oa/user

    protected void doLogin(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        boolean success = false;
        // 你要做一件什么事儿？验证用户名和密码是否正确。
        // 获取用户名和密码
        // 前端是这样提交的：username=admin&password=123
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 连接数据库验证用户名和密码
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select * from t_user where username = ? and password = ?";
            // 编译 SQL
            ps = conn.prepareStatement(sql);
            // 给 ? 传值
            ps.setString(1, username);
            ps.setString(2, password);
            // 执行 SQL
            rs = ps.executeQuery();
            // 这个结果集当中最多只有一条数据。
            if (rs.next()) { // 不需要 while 循环
                // 登录成功
                success = true;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(conn, ps, rs);
        }
        // 登录成功/失败
        if (success) {
            // 获取 session 对象（这里的要求是，必须获取到 session，没有 session 也要新建一个 session 对象。）
            HttpSession session = request.getSession(); // session 对象一定不是 null
            // session.setAttribute("username", username);

            User user = new User(username, password);
            session.setAttribute("user", user);

            // 登录成功了，并且用户确实选择了“十天内免登录”功能。
            String f = request.getParameter("f");
            if ("1".equals(f)) {
                // 创建 Cookie 对象存储登录名
                Cookie cookie1 = new Cookie("username", username);
                // 创建 Cookie 对象存储密码
                Cookie cookie2 = new Cookie("password", password); // 真实情况下是加密的。
                // 设置 cookie 的有效期为十天
                cookie1.setMaxAge(60 * 60 * 24 * 10);
                cookie2.setMaxAge(60 * 60 * 24 * 10);
                // 设置 cookie 的 path（只要访问这个应用，浏览器就一定要携带这两个 cookie)
                cookie1.setPath(request.getContextPath());
                cookie2.setPath(request.getContextPath());
                // 响应 cookie 给浏览器
                response.addCookie(cookie1);
                response.addCookie(cookie2);
            }

            // 成功，跳转到用户列表页面
            response.sendRedirect(request.getContextPath() + "/dept/list");
        } else {
            // 失败，跳转到失败页面
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }
}
