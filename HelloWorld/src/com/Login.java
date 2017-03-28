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
		System.out.println("初始化");
	}
	public void destroy() {
		System.out.println("销毁Servlet");
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet执行了");
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
			out.println("您的IP地址是："+request.getRemoteAddr());
		} else {
			out.println("<font color=red>登录失败</font>");
		}

	}
}
