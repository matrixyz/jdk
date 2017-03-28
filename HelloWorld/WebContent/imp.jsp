<%@ page contentType="text/html;charset=gbk"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.Calendar"%>
<%@ page import="java.util.List,java.util.ArrayList"%>
<%@ page import="java.awt.*"%>
<html>
<head>
	<title>imp</title>
</head>
<body>
<center>
<%
	Calendar c=Calendar.getInstance();
	List list=new ArrayList();
	list.add("apple");
	list.add("orange");
	for(int i=0;i<list.size();i++){
		out.println(list.get(i)+"&nbsp;");
	}
 %>
<br>
当前日期时间：<%=new Date().toLocaleString() %><br>
是本周第<%=c.get(Calendar.DAY_OF_WEEK) %>天

</center>
</body>
</html>