<%@ tag body-content="empty"	pageEncoding="utf-8"	%>
<%@ tag trimDirectiveWhitespaces="true"	%>
<%@	 attribute name="title"	required="true"	%><!-- 없으면 에러 -->
<%@	 attribute name="level"	type="java.lang.Integer"	%>
<%
	String headStartTag =null;
	String headEndTag=null;
	if(level==null){
		headStartTag = "<h1>"; 
		headEndTag = "</h1>";
	}else if(level==1){
		headStartTag = "<h1>"; 
		headEndTag = "</h1>";
	}else if(level==2){
		headStartTag = "<h2>"; 
		headEndTag = "</h2>"; 
	}else if(level==3){
		headStartTag = "<h3>"; 
		headEndTag = "</h3>"; 
	}
%>
<%=headStartTag %> <!--실제 Tag를 통해 표시되는 부분 -->
${title}
<%=headEndTag%>