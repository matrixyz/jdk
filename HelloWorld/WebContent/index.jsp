<%@ page contentType="text/html;charset=gbk" isThreadSafe="false"%>
<html>
<head>
	<title>index</title>
</head>
<%!
	public class Users{
		private String nam;
		private int age;
		public Users(String nam,int age){
			this.nam=nam;
			this.age=age;
		}
		public void say(){
			System.out.println("I am "+nam);
		}
		
	}
	private int a=12;
	private String nam="tom";
	public int sum(int a,int b){
		return a+b;
	}
%>
<body>
<%a++; %>
<%=a+"" %>
<center>
<%--���ע���ڿͻ��˿����� --%>
��ǰʱ��:<%=new java.util.Date().toLocaleString() %>
<br>
<%
	String nam="jack";
	Users u=new Users(nam,16);
	/*fsfdsfds*/
	u.say();
	out.println("23+78="+sum(23,78));
 %>

</center>
</body>
</html>