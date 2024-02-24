package org.apache;

import javax.servlet.Servlet;
import java.io.FileReader;
import java.util.Properties;
import java.util.Scanner;

// �䵱 Tomcat �������Ŀ�����
public class Tomcat {
    public static void main(String[] args) throws Exception {
        System.out.println("Tomcat �����������ɹ�����ʼ�����û��ķ��ʡ�");

        // �򵥵�ʹ�� Scanner ��ģ��һ���û�������
        // �û����ʷ�������ͨ��������ϵġ�����·����
        // Ҳ����˵�û�����·����ͬ����ִ̨�е� Servlet ��ͬ��

        /*
         * /userList UserListServlet
         * /login    UserLoginServlet
         * /bank     BankServlet
         * ...
         * */
        System.out.println("���������ķ���·����");
        Scanner s = new Scanner(System.in);

        // �û�������·��
        String key = s.nextLine(); // Tomcat �������Ѿ���ȡ�����û�������·���ˡ�

        // Tomcat ������Ӧ��ͨ���û�������·���Ҷ�Ӧ�� xxxServlet
        // ����·���� xxxServlet ֮��Ĺ�ϵӦ����˭ָ���أ�
        // ���� Tomcat ��������˵��Ҫ���������ļ�
        FileReader reader = new FileReader("web.properties");
        Properties pro = new Properties();
        pro.load(reader);
        reader.close();

        // ͨ�� key ��ȡ value
        String className = pro.getProperty(key);
        // ͨ��������ƴ�������
        Class clazz = Class.forName(className);
        Object obj = clazz.newInstance(); // obj �����Ͷ��� Tomcat ������������Ա��˵��֪����

        // ���� Tomcat �������Ŀ�����֪������д�� xxxServlet һ��ʵ���� Servlet �ӿ�
        Servlet servlet = (Servlet) obj;
        servlet.service();
    }
}