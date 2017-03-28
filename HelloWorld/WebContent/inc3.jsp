<%@ page contentType="text/html;charset=gbk"%>
<html>
<head>
	<title>inc3.jsp</title>
</head>
<body>
<center>
<% String url="code3.jsp"; %>
<jsp:include page="<%=url %>">
	<jsp:param name="nam" value="jacky"/>
</jsp:include>
</center>
</body>
</html>