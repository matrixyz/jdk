<%@ page contentType="text/html;charset=gbk"%>
<%
	out.println("最终的页面，请求结束了。<br>");
	out.print("first.jsp传递过来的参数p1:");
	out.println(request.getParameter("p1")+"<br>");
	out.print("second.jsp传递过来的参数p2:");
	out.println(request.getParameter("p2")+"<br>");
%>