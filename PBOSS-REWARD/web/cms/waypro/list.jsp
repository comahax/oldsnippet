<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<%
    String ID_1 = "";
    String ID_2 = "";
%>
<html>
<head>
    <title><bean:message bundle="Waypro" key="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
    <script type="text/javascript" src="<%= contextPath%>/js/bus/rescommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            return checkval(window);
        }
        function exports(){
			formList.action="<%=contextPath%>/cms/waypro.do?CMD=EXCEL";
			formList.submit();
			formList.action="<%=contextPath%>/cms/waypro.do?CMD=LIST";
		}
		function doDelete(cmdDelete) {
		    var TO = true;
		    var sis = formList.all("_selectitem");
		    if (forincheck(TO,sis,"省级渠道删除后将变更为无效状态,确认是否需要变更?")){
		    	formList.action = addParam(contextPath + cmdDelete, 'CMD', 'DELETE');
		    	formList.submit();
		    }  
		}
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/waypro.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="Waypro" key="titleList"/>
   			</td>
    	</tr>
    </table>
    </div>
    <div class="table_div">	
   		 <table width="100%" class="error_text">
    		<html:errors/><s:Msg />
    	</table>
    </div>
	<div class="table_div">
        <table class="form_table">
        	<tr>
    			<td width="80" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="Waypro" key="wayid"/>:
            	</td>
            	<td class="form_table_left">
               		<html:text styleClass="form_input_1x" onclick="showUnvSelectMsgBox(this,'_sk_wayid')" property="_sk_wayid" />
            	</td>
    			<td width="80" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="Waypro" key="wayname"/>:
            	</td>
            	<td class="form_table_left">
               	    <html:text styleClass="form_input_1x" property="_sk_wayname" />
            	</td>
            </tr>
            <tr>
    			<td width="80" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="Waypro" key="waystate"/>:
            	</td>
            	<td class="form_table_left">
               	    <html:select property="_ne_waystate">
               	    	<option />
                    	<s:Options definition="$CH_VALIDFLAG"/>
                    </html:select>  
            	</td>
            	<td width="80" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="Waypro" key="waysubtype"/>:
            	</td>
            	<td class="form_table_left">
               	   <html:select property="_se_waysubtype">
						<option />
						<s:Options definition="#UNV_REWARDKIND" />
					</html:select>
            	</td>
            </tr>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                        <input type="button" class="query"onmouseover="buttonover(this);" onclick="doQuery();" 
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_search"/>" />
                        <input type="button" class="button_4" onmouseover="buttonover(this);"
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="批量导出" onclick="exports()"/>
                        <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/waypro.do')">
                        <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/waypro.do')">
                </td>
			</tr>
		</table>
	</div>

    <div class="table_div">
      <div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
            	<td title="<bean:message bundle="public" key="list_title_select"/>">
                    <input type="checkbox" name="allbox" onclick="checkAll();" class="table_checkbox">
                </td>
                <td>
                    <a href="javascript:doOrderby('wayid')"><bean:message bundle="Waypro" key="wayid"/></a>
                    <s:OrderImg form="/cms/waypro/WayproForm" field="wayid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('wayname')"><bean:message bundle="Waypro" key="wayname"/></a>
                    <s:OrderImg form="/cms/waypro/WayproForm" field="wayname"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('waysubtype')"><bean:message bundle="Waypro" key="waysubtype"/></a>
                    <s:OrderImg form="/cms/waypro/WayproForm" field="waysubtype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('address')"><bean:message bundle="Waypro" key="address"/></a>
                    <s:OrderImg form="/cms/waypro/WayproForm" field="address"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('createtime')"><bean:message bundle="Waypro" key="createtime"/></a>
                    <s:OrderImg form="/cms/waypro/WayproForm" field="createtime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('waystate')"><bean:message bundle="Waypro" key="waystate"/></a>
                    <s:OrderImg form="/cms/waypro/WayproForm" field="waystate"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('signstatus')"><bean:message bundle="Waypro" key="signstatus"/></a>
                    <s:OrderImg form="/cms/waypro/WayproForm" field="signstatus"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('starttime')"><bean:message bundle="Waypro" key="starttime"/></a>
                    <s:OrderImg form="/cms/waypro/WayproForm" field="starttime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('disabletime')"><bean:message bundle="Waypro" key="disabletime"/></a>
                    <s:OrderImg form="/cms/waypro/WayproForm" field="disabletime"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
            	 <c:url value="/cms/waypro.do?CMD=EDIT" var="urlContent">
                     <c:param name="PK" value="${item.wayid}"/>
                 </c:url>
                 <tr class="table_style_content" align="center">
                 	 <td>
                 	 	<c:if test="${item.waystate == 1}">
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.wayid}' />"
                                onclick="checkOne();" class="table_checkbox">
                        </c:if>
                        <c:if test="${item.waystate == 0}">
                        <input type="checkbox" name="_selectitem" value="<c:out value='${item.wayid}' />"
                                onclick="checkOne();" class="table_checkbox" disabled="disabled">
                        </c:if>
                     </td>
                     <td>
                     	<a href='<c:out value="${urlContent}"/>'>
                         	<c:out value="${item.wayid}"/>
                         </a>
                     </td>
                     <td><c:out value="${item.wayname}"/></td>
                     <td><s:Code2Name code="${item.waysubtype}"  definition="#UNV_REWARDKIND"/></td>
                     <td><c:out value="${item.address}"/></td>
                     <td>
                     	<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.createtime}" />
                     </td>
                     <td><s:Code2Name code="${item.waystate}"  definition="$CH_VALIDFLAG"/></td>
                     <td><s:Code2Name code="${item.signstatus}"  definition="$CH_SIGNSTATUS"/></td>
                     <td>
	                    <fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.starttime}" />
                     </td> 
                     <td>
                     	<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.disabletime}" />
                     </td>
                 </tr>
             </c:forEach>
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
