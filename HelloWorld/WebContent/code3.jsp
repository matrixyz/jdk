<%@ page contentType="text/html;charset=gbk"%>
<%@ page import="java.util.Calendar" %>
<%
	String nam=request.getParameter("nam");
	Calendar c=Calendar.getInstance();
	int h=c.get(c.HOUR_OF_DAY);
	if(h<7)out.print("�賿��.");
	else if(h<12)out.print("�����.");
	else if(h<14)out.print("�����.");
	else if(h<19)out.print("�����.");
	else if(h<=23)out.print("���Ϻ�.");
	out.println(nam);
%>