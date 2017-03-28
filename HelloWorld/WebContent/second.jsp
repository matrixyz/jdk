<%@ page contentType="text/html;charset=gbk"%>
<%System.out.println("转发前."); %>
<jsp:forward page="third.jsp">
	<jsp:param name="p2" value="second"/>
</jsp:forward>
<%System.out.println("转发后(不会被执行)."); %>