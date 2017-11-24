<%@page import="com.sunrise.jop.ui.User"%>
<%@page import="com.sunrise.jop.ui.struts2.WebConstant"%>
<%@page import="com.gmcc.pboss.control.base.acl.ACLBO"%>
<%@page import="com.sunrise.jop.infrastructure.control.BOFactory"%>
<%@page import="com.gmcc.pboss.control.base.acl.ACL"%>
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
	String opercode = user.getOprcode();
		if(pageId.indexOf("_")>0){
			ACL ACLControl = (ACL)BOFactory.build(ACLBO.class,user);
			hasPermission = ACLControl.doCheckPermission(opercode, pageId);
		} else {
			hasPermission = true;
	    }
	if (!hasPermission) {
%>
	<jsp:forward page="/errorpage/nopermission.jsp" />
<%
	}
%>
