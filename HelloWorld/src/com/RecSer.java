package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RecSer extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String coder;
	public void init(ServletConfig sc) throws ServletException {
		coder=sc.getInitParameter("coder");
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding(coder);
		String nam=request.getParameter("nam");
		String[] secs=request.getParameterValues("sec");
		response.setContentType("text/html;charset="+coder);
		PrintWriter out=response.getWriter();
		out.println("Äã½Ð:"+nam+"<br>");
		out.println("ÄãµÄ°®ºÃÊÇ:<br>");
		for(int i=0;i<secs.length;i++){
			out.println(secs[i]+"<br>");
		}
	}
	public void destroy() {}
}
