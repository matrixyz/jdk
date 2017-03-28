<%@ page contentType="text/html;charset=gbk"%>
<html>
<head>
	<title>table.jsp</title>
</head>
<body>
<center>
<table width=500 border=1>
<%for(int i=0;i<3;i++){%>
		<tr>
		<%for(int j=0;j<5;j++){%>
			<td>
				<%="第"+i+"行,第"+j+"列" %>
			</td>
		<%}%>
		</tr>
<%}%>
</table>
</center>
</body>
</html>