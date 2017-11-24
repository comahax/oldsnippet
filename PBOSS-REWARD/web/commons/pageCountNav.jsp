<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@page import="com.sunrise.boss.common.base.db.DataPackage"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%
	DataPackage bean = (DataPackage) pageContext.getRequest().getAttribute("LIST");
	if (null != bean && null != bean.getDatas()) {
		int currentPage = bean.getPageNo();
		int rowCount = bean.getRowCount();
		int totalPage = (int) Math.ceil(((double) rowCount) / ((double) bean.getPageSize()));
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("rowCount", rowCount);
		request.setAttribute("totalPage", totalPage);
	}
 %>
<c:choose>
    <c:when test="${!empty requestScope.LIST.datas}">
        <table class=" page_table">
			<tr valign=middle>
				<td align=left height=30>
					<c:if test="${currentPage>1}">
						<a href="javascript:showFirstPage();"><img src="images/first.gif" alt="<bean:message bundle="public" key="button_first_page"/>" width="59" height="18" border="0"></a>
						<a href="javascript:showPreviousPage();"><img src="images/preview.gif" alt="<bean:message bundle="public" key="button_forward"/>" width="59" height="18" border="0"></a>
					</c:if>
					<c:if test="${currentPage<totalPage}">
						<a href="javascript:showNextPage();"><img src="images/next.gif" alt="<bean:message bundle="public" key="button_next"/>" width="59" height="18" border="0"></a>
						<a href="javascript:showLastPage();"><img src="images/last.gif" alt="<bean:message bundle="public" key="button_last_page"/>" width="59" height="18" border="0"></a>
					</c:if>
					&nbsp;&nbsp;
				</td>
				<td align=right style="font-size:12px;">
					<bean:message bundle="public" key="button_total_page" />
					<font color="red"><c:out value='${rowCount}' /></font> ÏîÊý¾Ý
					&nbsp;
					<bean:message bundle="public" key="button_total_page" />
					<font color="red"><c:out value="${totalPage}" /></font>
					<bean:message bundle="public" key="button_page" />
					&nbsp;
					<bean:message bundle="public" key="button_current_page" />
					<font color="red"><c:out value="${currentPage}" /></font>
					<bean:message bundle="public" key="button_page" />
					&nbsp; <bean:message bundle="public" key="button_goto_page" />
					<input name="goto_page" type="text" size="2" ID="goto_page" value="<c:out value="${currentPage}" />">
					<bean:message bundle="public" key="button_page" /><a href="javascript:gotoPage();"><img src="images/go.gif" alt="<bean:message bundle="public" key="button_goto_page" />" width="16" height="14" border="0"></a>
				</td>
			</tr>
		</table>
    </c:when>
</c:choose>
