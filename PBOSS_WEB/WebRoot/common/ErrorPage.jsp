<%@  page contentType="text/html; charset=GBK" isErrorPage="true"%>
<%@ page import="com.gmcc.pboss.common.util.ExceptionHelper" %>
<%@page import="com.gmcc.pboss.common.bean.LoginMember"%>
<%@page import="com.gmcc.pboss.common.dictionary.HttpDictionary"%>
<%@page import="com.gmcc.pboss.common.action.PageInfo"%>
<%-- struts tag --%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
ExceptionHelper eh = new ExceptionHelper();
eh.process(request,response,exception);
Object _obj = session.getAttribute(HttpDictionary.USER_NAME);
LoginMember _member = (_obj != null)?(LoginMember)_obj:null;
request.setAttribute("logMem", _member);
%>
<html>
<head>
<jsp:include page="/common/meta_allcss.jsp"/>
<jsp:include page="/common/meta_js.jsp"/>
</head>
<body>
	<!-- ͷ�������� -->
	<jsp:include page="/common/include/inc_head.jsp"/>
	<div class="divspan">
		<!--��׼���ݿ�ʼ-->		
		<div class="menu">
			<IMG SRC="/images/img/messages.jpg" ALT="��Ϣ��ʾ">
		</div>
		<div class="context">
			<div class="listboxtitle">������ʾ</div>
			<div class="messageshow">
			<IMG SRC="/images/icon_wrong.gif" WIDTH="18" HEIGHT="18" BORDER="0" ALT="">${title}
			<TEXTAREA NAME="" ROWS="20" style="width:100%">${exceptionStack}</TEXTAREA>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<!--  onmouseover="shover(this,'btn_blue_75_02')" onMouseOut="shover(this,'btn_blue_75')" //-->
				<button type="button" class="btn_blue_75"onClick="window.history.back();">����</button>
					
			</div>
			<div class="messageshowbutton">
			
			</div>
		</div>
			<!--��׼���ݽ���-->
	</div>
	
	<jsp:include page="/common/include/inc_foot.jsp"/>
</body>
</html>