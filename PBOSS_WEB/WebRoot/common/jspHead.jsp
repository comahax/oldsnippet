<%@ page errorPage="/common/ErrorPage.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page import="com.gmcc.pboss.common.bean.LoginMember"%>
<%@page import="com.gmcc.pboss.common.dictionary.HttpDictionary"%>
<jsp:useBean id="jqac"  class="com.gmcc.pboss.common.dictionary.JQACKey" />

<c:set var="fmtDecimal2" value="#,##0.##"/>
<c:set var="fmtNumber" value="##0.##" />
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<script type="text/javascript">
  var contextRootPath = "${ctx}";
</script>
<%
	Object _obj = session.getAttribute(HttpDictionary.USER_NAME);
	LoginMember _member = (_obj != null)?(LoginMember)_obj:null;
%>