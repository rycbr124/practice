<%@ tag body-content="scriptless"	pageEncoding="utf-8"	%>
<%@	 attribute name="length"	type="java.lang.Integer"	%>
<%@ attribute name="trail" %>
<%@ attribute name="trim" %>
<jsp:doBody var="content" scope="page"	/><%-- 몸체 내용을 context변수에 저장,context이름으로 setAttribute 됨 --%>
<%
	String content = (String) jspContext.getAttribute("content");
	if(trim!=null && trim.equals("true")){
		content=content.trim();		
	}
	content = content.replaceAll( "<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?>", "");//정규식,모든 html태그를 없앰
	//가독성 낮음,예외적인 케이스에서 사용
	if(length!=null && length.intValue()>0 && content.length()>length.intValue()){
		content=content.substring(0, length.intValue());//length 이상인 content는 자른다.
		if(trail!=null){
			content=content+trail;
		}
	}
%>
<%=content %>	
