package com.bjpowernode.servlet;

import javax.servlet.Servlet;

// �䵱�Ľ�ɫ�����˸ı䣺webapp ������
// ֻҪ������ webapp ������д�� xxxServlet ��Ҫʵ�� Servlet �ӿ�

public class UserLoginServlet implements Servlet {
    public void service() {
        System.out.println("UserLoginServlet's service...");
    }
}