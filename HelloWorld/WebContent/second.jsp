<%@ page contentType="text/html;charset=gbk"%>
<%System.out.println("ת��ǰ."); %>
<jsp:forward page="third.jsp">
	<jsp:param name="p2" value="second"/>
</jsp:forward>
<%System.out.println("ת����(���ᱻִ��)."); %>