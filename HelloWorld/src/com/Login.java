package com;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void init(ServletConfig sc) throws ServletException {
		System.out.println("��ʼ��");
	}
	public void destroy() {
		System.out.println("����Servlet");
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGetִ����");
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String nam=request.getParameter("nam");
		String pwd= request.getParameter("pwd");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		if(nam.equals("tom")&&pwd.equals("111")){
			out.println("<font color=green>Hello,"+nam+"</font><br>");
			out.println("����IP��ַ�ǣ�"+request.getRemoteAddr());
		} else {
			out.println("<font color=red>��¼ʧ��</font>");
		}

	}
}
