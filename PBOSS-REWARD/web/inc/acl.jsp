<%@ page import="com.sunrise.boss.ui.commons.*"%>
<%@ page import="com.sunrise.boss.common.utils.sysinfo.*"%>
<%@ page import="com.sunrise.boss.delegate.admin.acl.ACLDelegate"%>
<%
	String pageId = request.getParameter("PID");
	/* sustain the cms flow */
	if (pageId == null) {
		pageId = (String) request.getAttribute("PID");
	}
	/* ----------- */
	User user = (User) session.getAttribute(WebConstant.SESSION_ATTRIBUTE_USER);
	boolean hasPermission = false;

	if (user == null) {
%>
	<jsp:forward page="/errorpage/nopermission.jsp" />
<%
	}
	String opercode = user.getOpercode();
	if (!SysInfo.IS_CHECK_PERMISSION) {
		hasPermission = true;
	} else {
		if(pageId.indexOf("_")>0){
			ACLDelegate delegate = new ACLDelegate();
			hasPermission = delegate.checkPermission(opercode, pageId);
		} else {
			hasPermission = true;
	    }
	}
	if (!hasPermission) {
%>
	<jsp:forward page="/errorpage/nopermission.jsp" />
<%
	}
%>
