<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<table class=" page_table">
	<tr valign=middle>
		<td align=left height=30>
              <c:if test="${currentPage>1}">
				<a href="javascript:firstPage();"><img src="images/first.gif" alt="<bean:message bundle="public" key="button_first_page"/>" width="59" height="18" border="0"></a>			 
				<a href="javascript:showPreviousPage();"><img src="images/preview.gif" alt="<bean:message bundle="public" key="button_forward"/>" width="59" height="18" border="0"></a>
				 </c:if>
				<a href="javascript:nextPage();"><img src="images/next.gif" alt="<bean:message bundle="public" key="button_next"/>" width="59" height="18" border="0"></a>
			&nbsp;&nbsp;
		</td>
		<td align=right style="font-size:12px;">
			<bean:message bundle="public" key="button_current_page" />
			<font color="red"><c:out value="${currentPage}" /></font>
			<bean:message bundle="public" key="button_page" />
			&nbsp; <bean:message bundle="public" key="button_goto_page" />
			<input name="goto_page" type="text" size="2" ID="goto_page" value="<c:out value="${currentPage}" />">
			<bean:message bundle="public" key="button_page" /><a href="javascript:goPage();"><img src="images/go.gif" alt="" width="16" height="14" border="0"></a>
		</td>
	</tr>
</table>