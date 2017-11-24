<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<table class=" page_table">
	<tr valign=middle>
		<td align=left height=30>
				<a href="javascript:ttprePage();"><img src="images/preview.gif" alt="<bean:message bundle="public" key="button_forward"/>" width="59" height="18" border="0"></a>
				<a href="javascript:ttnextPage();"><img src="images/next.gif" alt="<bean:message bundle="public" key="button_next"/>" width="59" height="18" border="0"></a>
			&nbsp;&nbsp;
		</td>
		<td align=right style="font-size:12px;">
			<bean:message bundle="public" key="button_current_page" />
			<font color="red"><c:out value="${ttcurPage}" /></font>
			<bean:message bundle="public" key="button_page" />
		</td>
	</tr>
</table>