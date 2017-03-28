<%@ page contentType="text/html;charset=gbk" %>
<html>
<head>
  <title>login.jsp</title>
</head>
<body>
<%
 	String nam=request.getParameter("nam");
    String pwd = request.getParameter("pwd");
	if(nam.equals("tom")&&pwd.equals("111")){
%>
		<font color=green>Welcome,<%=nam %></font>
<% } else { %>
		<font color=red>登录失败。<br>
		用户名或密码错误.</font>
<% } %>

</body>
</html>