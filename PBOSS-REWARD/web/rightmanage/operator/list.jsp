<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<%
	String ID_1 = null;
	String ID_2 = null;
	String ID_3 = null;
	String ID_4 = null;
%>
<html>
<head>
    <title><bean:message bundle="operator" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_se_operid', '<bean:message bundle="operator" key="operid"/>', 'c', true, 20);
            addfield('_ne_region', '<bean:message bundle="operator" key="region"/>', 'c', true, 20);
            addfield('_se_opername', '<bean:message bundle="operator" key="opername"/>', 'c', true, 20);
            addfield('_se_password', '<bean:message bundle="operator" key="password"/>', 'c', true, 20);
            addfield('_se_passchgdate', '<bean:message bundle="operator" key="passchgdate"/>', 'c', true, 20);
            addfield('_se_opergroup', '<bean:message bundle="operator" key="opergroup"/>', 'c', true, 20);
            addfield('_se_opertype', '<bean:message bundle="operator" key="opertype"/>', 'c', true, 20);
            addfield('_se_operlevel', '<bean:message bundle="operator" key="operlevel"/>', 'c', true, 20);
            addfield('_ne_ismanager', '<bean:message bundle="operator" key="ismanager"/>', 'c', true, 20);
            addfield('_se_contactphone', '<bean:message bundle="operator" key="contactphone"/>', 'c', true, 20);
            addfield('_se_orgid', '<bean:message bundle="operator" key="orgid"/>', 'c', true, 20);
            addfield('_se_isrestrict', '<bean:message bundle="operator" key="isrestrict"/>', 'c', true, 20);
            addfield('_se_starttime', '<bean:message bundle="operator" key="starttime"/>', 'c', true, 20);
            addfield('_se_endtime', '<bean:message bundle="operator" key="endtime"/>', 'c', true, 20);
            addfield('_se_enablegprs', '<bean:message bundle="operator" key="enablegprs"/>', 'c', true, 20);
            addfield('_se_gprsstarttime', '<bean:message bundle="operator" key="gprsstarttime"/>', 'c', true, 20);
            addfield('_se_gprsendtime', '<bean:message bundle="operator" key="gprsendtime"/>', 'c', true, 20);
            addfield('_se_ischkmac', '<bean:message bundle="operator" key="ischkmac"/>', 'c', true, 20);
            addfield('_se_mac', '<bean:message bundle="operator" key="mac"/>', 'c', true, 20);
            addfield('_se_notes', '<bean:message bundle="operator" key="notes"/>', 'c', true, 20);
            addfield('_se_createdate', '<bean:message bundle="operator" key="createdate"/>', 'c', true, 20);
            addfield('_se_status', '<bean:message bundle="operator" key="status"/>', 'c', true, 20);
            addfield('_se_statusdate', '<bean:message bundle="operator" key="statusdate"/>', 'c', true, 20);
            
            return checkval(window);
        }
    </script>
</head>

<body onload="loadforiframe()">
<div class="table_container">
<html:form action="/operator.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <div class="table_div">
	   <table class="top_table">
			<tr>
				<td>
					<bean:message bundle="operator" key="titleList"/>
				</td>
			</tr>
		</table>
	</div>
	<div class="table_div">
		<table width="100%">
			<html:errors />
		</table>
	</div>
	<div class="table_div">
        <table class="form_table">
            <tr>
                <td width="126" height="20" align="right" class="form_table_right"><bean:message bundle="operator" key="operid"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_operid"></html:text>
                </td>
                <td width="126" height="20" align="right" class="form_table_right"><bean:message bundle="operator" key="region"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_ne_region"></html:text>
                </td>
                <td width="126" height="20" align="right" class="form_table_right"><bean:message bundle="operator" key="opername"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_opername"></html:text>
                </td>  
            </tr>
            <tr>      
                <td width="126" height="20" align="right" class="form_table_right"><bean:message bundle="operator" key="opergroup"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_opergroup"></html:text>
                </td>
                <td width="126" height="20" align="right" class="form_table_right"><bean:message bundle="operator" key="opertype"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_opertype"></html:text>
                </td>
                <td width="126" height="20" align="right" class="form_table_right"><bean:message bundle="operator" key="operlevel"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_operlevel"></html:text>
                </td>
            </tr>
            <tr>
                <td width="126" height="20" align="right" class="form_table_right"><bean:message bundle="operator" key="ismanager"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_ne_ismanager"></html:text>
                </td>
                <td width="126" height="20" align="right" class="form_table_right"><bean:message bundle="operator" key="orgid"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_orgid"></html:text>
                </td>
            </tr>
        </table>
  </div>
	<div class="table_div">		
		<table class="table_button_list">
			<tr> 
              <td>
                  <s:PurChk controlid="<%=ID_1%>">
                      <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
                      onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                      value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/operator.do')">
                  </s:PurChk>
                  <s:PurChk controlid="<%=ID_2%>">
                      <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                      onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                      value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/operator.do')">
                  </s:PurChk>
                 <input type="button" class="query" onmouseover="buttonover(this);"
                      onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                      value="<bean:message bundle="public" key="button_search"/>" onClick="doQuery();">
				</td>
			</tr>
		</table>
	</div>	

	<div class="table_div">
	<div class="table_LongTable">
		<table class="table_style">
			  <tr class="table_style_head">
                <td title="<bean:message bundle="public" key="list_title_select"/>">
                    <input type="checkbox" name="allbox" onclick="checkAll();" class="table_checkbox">
                </td>
                <td>
                    <a href="javascript:doOrderby('operid')"><bean:message bundle="operator" key="operid"/></a>
                    <s:OrderImg form="/rightmanage/Operator/OperatorForm" field="operid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('region')"><bean:message bundle="operator" key="region"/></a>
                    <s:OrderImg form="/rightmanage/Operator/OperatorForm" field="region"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('opername')"><bean:message bundle="operator" key="opername"/></a>
                    <s:OrderImg form="/rightmanage/Operator/OperatorForm" field="opername"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('password')"><bean:message bundle="operator" key="password"/></a>
                    <s:OrderImg form="/rightmanage/Operator/OperatorForm" field="password"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('passchgdate')"><bean:message bundle="operator" key="passchgdate"/></a>
                    <s:OrderImg form="/rightmanage/Operator/OperatorForm" field="passchgdate"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('opergroup')"><bean:message bundle="operator" key="opergroup"/></a>
                    <s:OrderImg form="/rightmanage/Operator/OperatorForm" field="opergroup"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('opertype')"><bean:message bundle="operator" key="opertype"/></a>
                    <s:OrderImg form="/rightmanage/Operator/OperatorForm" field="opertype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('operlevel')"><bean:message bundle="operator" key="operlevel"/></a>
                    <s:OrderImg form="/rightmanage/Operator/OperatorForm" field="operlevel"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('ismanager')"><bean:message bundle="operator" key="ismanager"/></a>
                    <s:OrderImg form="/rightmanage/Operator/OperatorForm" field="ismanager"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('contactphone')"><bean:message bundle="operator" key="contactphone"/></a>
                    <s:OrderImg form="/rightmanage/Operator/OperatorForm" field="contactphone"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('orgid')"><bean:message bundle="operator" key="orgid"/></a>
                    <s:OrderImg form="/rightmanage/Operator/OperatorForm" field="orgid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('isrestrict')"><bean:message bundle="operator" key="isrestrict"/></a>
                    <s:OrderImg form="/rightmanage/Operator/OperatorForm" field="isrestrict"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('starttime')"><bean:message bundle="operator" key="starttime"/></a>
                    <s:OrderImg form="/rightmanage/Operator/OperatorForm" field="starttime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('endtime')"><bean:message bundle="operator" key="endtime"/></a>
                    <s:OrderImg form="/rightmanage/Operator/OperatorForm" field="endtime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('enablegprs')"><bean:message bundle="operator" key="enablegprs"/></a>
                    <s:OrderImg form="/rightmanage/Operator/OperatorForm" field="enablegprs"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('gprsstarttime')"><bean:message bundle="operator" key="gprsstarttime"/></a>
                    <s:OrderImg form="/rightmanage/Operator/OperatorForm" field="gprsstarttime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('gprsendtime')"><bean:message bundle="operator" key="gprsendtime"/></a>
                    <s:OrderImg form="/rightmanage/Operator/OperatorForm" field="gprsendtime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('ischkmac')"><bean:message bundle="operator" key="ischkmac"/></a>
                    <s:OrderImg form="/rightmanage/Operator/OperatorForm" field="ischkmac"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('mac')"><bean:message bundle="operator" key="mac"/></a>
                    <s:OrderImg form="/rightmanage/Operator/OperatorForm" field="mac"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('notes')"><bean:message bundle="operator" key="notes"/></a>
                    <s:OrderImg form="/rightmanage/Operator/OperatorForm" field="notes"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('createdate')"><bean:message bundle="operator" key="createdate"/></a>
                    <s:OrderImg form="/rightmanage/Operator/OperatorForm" field="createdate"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('status')"><bean:message bundle="operator" key="status"/></a>
                    <s:OrderImg form="/rightmanage/Operator/OperatorForm" field="status"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('statusdate')"><bean:message bundle="operator" key="statusdate"/></a>
                    <s:OrderImg form="/rightmanage/Operator/OperatorForm" field="statusdate"/>
                </td>
                
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/operator.do?CMD=EDIT" var="urlContent">
                     <c:param name="PK" value="${item.operid}"/>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.operid}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.operid}"/></a>
                     </td>
                     <td><c:out value="${item.region}"/></td>
                     <td><c:out value="${item.opername}"/></td>
                     <td><c:out value="${item.password}"/></td>
                     <td><c:out value="${item.passchgdate}"/></td>
                     <td><c:out value="${item.opergroup}"/></td>
                     <td><c:out value="${item.opertype}"/></td>
                     <td><c:out value="${item.operlevel}"/></td>
                     <td><c:out value="${item.ismanager}"/></td>
                     <td><c:out value="${item.contactphone}"/></td>
                     <td><c:out value="${item.orgid}"/></td>
                     <td><c:out value="${item.isrestrict}"/></td>
                     <td><c:out value="${item.starttime}"/></td>
                     <td><c:out value="${item.endtime}"/></td>
                     <td><c:out value="${item.enablegprs}"/></td>
                     <td><c:out value="${item.gprsstarttime}"/></td>
                     <td><c:out value="${item.gprsendtime}"/></td>
                     <td><c:out value="${item.ischkmac}"/></td>
                     <td><c:out value="${item.mac}"/></td>
                     <td><c:out value="${item.notes}"/></td>
                     <td><c:out value="${item.createdate}"/></td>
                     <td><c:out value="${item.status}"/></td>
                     <td><c:out value="${item.statusdate}"/></td>
                     
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
