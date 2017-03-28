<%@ page contentType="text/html;charset=gbk"%>
<%!
	private int count=7;
	public String show(String str){
		String s="";
		for(int i=1;i<count;i++){
			s+="<h"+i+">";
			s+=str;
			s+="</h"+i+">\n";
		}
		return s;
	}
%>