package com.powernode.bank.mvc;

import com.powernode.bank.exceptions.AppException;
import com.powernode.bank.exceptions.MoneyNotEnoughException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/*
 * 账户小程序
 * AccountServlet 是一个司令官。他负责调度其他组件来完成任务。
 * */
@WebServlet("/transfer")
public class AccountServlet extends HttpServlet { // AccountServlet 作为 Controller

    AccountService accountService = new AccountService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 接收数据
        String fromActno = request.getParameter("fromActno");
        String toActno = request.getParameter("toActno");
        double money = Double.parseDouble(request.getParameter("money"));

        try {
            // 调用业务方法处理业务（调用 Model 处理业务）
            accountService.transfer(fromActno, toActno, money);
            // 执行到这里了，说明成功了。
            // 显示处理结果（调度 View 做页面展示）
            response.sendRedirect(request.getContextPath() + "/success.jsp");
        } catch (MoneyNotEnoughException e) {
            // 执行到这里了，说明失败了。（余额不足）
            // 显示处理结果（调度 View 做页面展示）
            response.sendRedirect(request.getContextPath() + "/moneynotenough.jsp");
        } catch (Exception e) {
            // 执行到这里了，说明失败了。
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }


    }
}
