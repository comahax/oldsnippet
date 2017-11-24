<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ page import="com.sunrise.boss.common.base.db.DataPackage" %>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.Date"%>
<%@ page import="org.apache.commons.beanutils.BeanUtils"%>
<%@ page import="org.apache.commons.beanutils.PropertyUtils"%>
<%@ page import="com.sunrise.pub.tools.PublicUtils"%>
<%@ include file="/inc/listhead.inc"%>
<%
	DataPackage	 dp = (DataPackage)request.getAttribute("LIST");
	Iterator iter = dp.getDatas().iterator();
 %>
<html>
<head>
    <title><bean:message bundle="wydata" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            return checkval(window);
        }
        
    </script>
</head>

<body onload="loadforiframe();" >
<div class="table_container">
<html:form action="/bcss/syncdata/wydata.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby" value="indate"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize" />
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">

    <div class="table_div">
		<table class="top_table">
			<tr>
				<td width="210" class="AreaName" align="left" valign=middle>
					<bean:message bundle="wydata" key="titleList" />
				</td>
			</tr>
		</table>
	</div>
	<div class="table_div">
		<table width="100%" class="error_text">
			<html:errors />
			<s:Msg />
		</table>
	</div>

	<div class="table_div">
		<table class="form_table">
			<tr>
				<td align="right" class="form_table_right" nowrap>
					<bean:message bundle="wydata" key="filecode" />
					:
				</td>
				<td class="form_table_left" nowrap>
					<html:select property="_se_filecode">
						<s:Options definition='#BCSS_FILETYPE' nameOnly="true"></s:Options>
					</html:select>
				</td>
				<td align="right" class="form_table_right" >
					<bean:message bundle="wydata" key="_snl_indate" />
					:
				</td>
				<td class="form_table_left" nowrap>
					<html:text styleClass="form_input_1x" property="_dnl_indate"  onclick="this.value=selectDatetime()"/>
				</td>
				<td align="right" class="form_table_right" nowrap> 
					<bean:message bundle="wydata" key="_snm_indate" />
					:
				</td>
				<td class="form_table_left">
					<html:text styleClass="form_input_1x" property="_dnm_indate"  onclick="this.value=selectDatetime()"/>
				</td>
			</tr>
		</table>
	</div>
	<div class="table_div">
		<table class="table_button_list">
			<tr>
				<td>
					<input type="button" class="query" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
						onfocus="buttonover(this)" onblur="buttonout(this)"
						value="<bean:message bundle="public" key="button_search"/>" onClick="doQuery();" />
				</td>
			</tr>
		</table>
	</div>
	<div class="table_div">
	<div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
            	<%-- <td><bean:message bundle="wydata" key="serialno"/></td>--%>
            	<td><bean:message bundle="wydata" key="filetype"/></td>
            	<td><bean:message bundle="wydata" key="indate"/></td>
            	<%--<td><bean:message bundle="wydata" key="dataid"/></td>--%>
            	<%int i = 0; %>
            	<c:forEach var="item" items="${requestScope.fileitems.datas}">
            		<td><c:out value='${item.itemname}' /></td>
            		<%i++; %>
            	</c:forEach>
            </tr>
            <%
            	while (iter.hasNext()){
            		Object obj = iter.next();
            %>
            	<tr class="table_style_content" align="center">
            		<%--<td><%=BeanUtils.getProperty(obj,"serialno")%></td>--%>
            		<td><s:Code2Name definition="#BCSS_FILETYPE" code='<%=BeanUtils.getProperty(obj,"filecode")%>'></s:Code2Name></td>
            		<td><%=PublicUtils.utilDateToStr((Date)PropertyUtils.getProperty(obj,"indate"))%></td>
            		<%--<td><%=BeanUtils.getProperty(obj,"dataid")%></td>--%>
            		<%for (int j = 1; j <= i; j++){ %>
            			<td><%=BeanUtils.getProperty(obj,"field"+(j+1))==null ?"":BeanUtils.getProperty(obj,"field"+(j+1))%></td>
            		<%} %>
            	</tr>
             <%
            	}
             %>
        </table>
   </div>
   </div>
   <div class="table_div">
		<s:PageNav dpName="LIST"/>
   </div>
</html:form>
</div>
</body>
</html>
