<%@ page contentType="text/html;charset=gbk" isThreadSafe="false"%>
<html>
<head>
	<title>safe</title>
</head>
<%!
	int a=10;
%>
<body>
<center>
<%
Thread.sleep(5000);
a++; %>
a=<%=a+"" %>
</center>
</body>
</html>