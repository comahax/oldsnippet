<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
    String ID_1 = "00010701";
    String ID_2 = "00010702";
    String ID_3 = "00010703";
    String ID_4 = "00010704";
%>
<html>
<head>
    <title><bean:message bundle="chpwregisterbroad" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            
            return checkval(window);
        }
        
        function upload(){
			var form=document.forms[0];
			form.action="<%=contextPath%>/cms/kdkhzl/chpwregisterbroad/batchupfile.jsp";
			form.submit();
		}
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/kdkhzl/chpwregisterbroad.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/kdkhzl/chpwregisterbroad/ChpwregisterbroadForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="chpwregisterbroad" key="titleList"/>
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
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chpwregisterbroad" key="telephone"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_telephone"></html:text>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chpwregisterbroad" key="wayid"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_wayid"></html:text>
                </td>
            </tr>
            
            <tr>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chpwregisterbroad" key="state"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:select property="_ne_state">
						<html:option value=""></html:option>
						<html:option value="0">登记</html:option>
						<html:option value="1">作废</html:option>
						<html:option value="2">已补录</html:option>
					</html:select>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chpwregisterbroad" key="regdate"/>:</td>
                <td width="30%" class="form_table_left">
                	<html:text styleClass="form_input_1x" property="_dnl_regdate" onclick="selectDate();" ></html:text>
                	到
                	<html:text styleClass="form_input_1x" property="_dnm_regdate" onclick="selectDate();" ></html:text>
                </td>
            </tr>
            
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                		<s:PurChk controlid="<%=ID_3%>">
                        <input type="button" class="query" onmouseover="buttonover(this);" onclick="doQuery();"
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_search"/>" />
                        </s:PurChk>
                        <s:PurChk controlid="<%=ID_1%>">
                            <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/kdkhzl/chpwregisterbroad.do')">
                        </s:PurChk>
                        <s:PurChk controlid="<%=ID_2%>">
                            <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/kdkhzl/chpwregisterbroad.do')">
                        </s:PurChk>
                        <input type="button" name="btnImport"  class="button_2" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="导入" onClick="upload();">
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
                    <a href="javascript:doOrderby('broadid')"><bean:message bundle="chpwregisterbroad" key="broadid"/></a>
                    <s:OrderImg form="/cms/kdkhzl/chpwregisterbroad/ChpwregisterbroadForm" field="broadid"/>
                </td>
                <td>
                    <bean:message bundle="chpwregisterbroad" key="wayid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('telephone')"><bean:message bundle="chpwregisterbroad" key="telephone"/></a>
                    <s:OrderImg form="/cms/kdkhzl/chpwregisterbroad/ChpwregisterbroadForm" field="telephone"/>
                </td>
                <td>
                    <bean:message bundle="chpwregisterbroad" key="opnid"/>
                </td>
                <td>
                    <bean:message bundle="chpwregisterbroad" key="opnname"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('mobile')"><bean:message bundle="chpwregisterbroad" key="mobile"/></a>
                    <s:OrderImg form="/cms/kdkhzl/chpwregisterbroad/ChpwregisterbroadForm" field="mobile"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('broadnum')"><bean:message bundle="chpwregisterbroad" key="broadnum"/></a>
                    <s:OrderImg form="/cms/kdkhzl/chpwregisterbroad/ChpwregisterbroadForm" field="broadnum"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('regdate')"><bean:message bundle="chpwregisterbroad" key="regdate"/></a>
                    <s:OrderImg form="/cms/kdkhzl/chpwregisterbroad/ChpwregisterbroadForm" field="regdate"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('state')"><bean:message bundle="chpwregisterbroad" key="state"/></a>
                    <s:OrderImg form="/cms/kdkhzl/chpwregisterbroad/ChpwregisterbroadForm" field="state"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/kdkhzl/chpwregisterbroad.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.broadid}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.broadid}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.broadid}"/></a>
                     </td>
                     <td><c:out value="${item.wayid}"/></td>
                     <td><c:out value="${item.telephone}"/></td>
                     <td><c:out value="${item.opnid}"/></td>
                     <td><c:out value="${item.opnname}"/></td>
                     <td><c:out value="${item.mobile}"/></td>
                     <td><c:out value="${item.broadnum}"/></td>
                     <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.regdate}" /></td>
                     <td><c:out value="${item.statename}"/></td>
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
