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
		<font color=red>��¼ʧ�ܡ�<br>
		�û������������.</font>
<% } %>

</body>
</html>