<%@ page contentType="text/html;charset=gbk"%>
<%@ page import="java.util.Calendar" %>
<%
	String nam=request.getParameter("nam");
	Calendar c=Calendar.getInstance();
	int h=c.get(c.HOUR_OF_DAY);
	if(h<7)out.print("凌晨好.");
	else if(h<12)out.print("上午好.");
	else if(h<14)out.print("中午好.");
	else if(h<19)out.print("下午好.");
	else if(h<=23)out.print("晚上好.");
	out.println(nam);
%>