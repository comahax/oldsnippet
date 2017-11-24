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
    <title><bean:message bundle="chadtbusitoapprove" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_se_approveid', '<bean:message bundle="chadtbusitoapprove" key="approveid"/>', 'f', 'false', '28');
            addfield('_se_batchid', '<bean:message bundle="chadtbusitoapprove" key="batchid"/>', 'c', 'false', '16');
            addfield('_se_opnid', '<bean:message bundle="chadtbusitoapprove" key="opnid"/>', 'c', 'false', '18');
            addfield('_se_rewardtype', '<bean:message bundle="chadtbusitoapprove" key="rewardtype"/>', 'c', 'false', '5');
            addfield('_se_region', '<bean:message bundle="chadtbusitoapprove" key="region"/>', 'c', 'false', '10');
            addfield('_dnm_apptime', '<bean:message bundle="chadtbusitoapprove" key="_dnm_apptime"/>', 'dt', 'false', '7');
            addfield('_dnl_apptime', '<bean:message bundle="chadtbusitoapprove" key="_dnl_apptime"/>', 'dt', 'false', '7');
            return checkval(window);
        }
    </script>
    <script type="text/javascript" src="<%= contextPath %>/js/bus/waycommon.js"></script>
	<script type="text/javascript" src="<%= contextPath %>/js/baseframe.js"></script>
	<script type="text/javascript" src="<%= contextPath%>/js/bus/rescommon.js"></script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/chadtbusitoapprove.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/chadtbusitoapprove/ChadtbusitoapproveForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="chadtbusitoapprove" key="titleList"/>
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
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chadtbusitoapprove" key="opnid"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_opnid"  onclick="showOpnTree2(this,'_se_opnid','busi')"></html:text>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chadtbusitoapprove" key="rewardtype"/>:</td>
                <td width="30%" class="form_table_left">
                     <html:select property="_se_rewardtype">
	                   		    <option/>
	                   		    <s:Options definition="#REWARDTYPE"/>
                     		</html:select>
                </td>
            </tr>
             <tr>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chadtbusitoapprove" key="approveid"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_approveid" ></html:text>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chadtbusitoapprove" key="batchid"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_batchid"></html:text>
                </td>
            </tr>
            <tr>
                 <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chadtbusitoapprove" key="_dnl_apptime"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnl_apptime" onclick="selectDatetime();" ></html:text>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chadtbusitoapprove" key="_dnm_apptime"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnm_apptime" onclick="selectDatetime();" ></html:text>
                </td>
            </tr>
            <tr>
            	<td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chadtbusitoapprove" key="region"/>:</td>
                <td width="30%" class="form_table_left">
                <input type="text" value="<c:out value='${sessionScope.chadtregion}' />" styleClass="form_input_1x" disabled="true">
                   	
                </td>
               
    			<td width="20%" height="20" align="right" class="form_table_right" >当前生效审批编码:</td>
                <td width="30%" class="form_table_left">
                   <input type="checkbox" name="currentbatchid" value="1"> 
                </td>
            </tr>
            
         
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                  <input type="button" class="query" onmouseover="buttonover(this);" onclick="doQuery();"
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="查询" />
						<!-- 
                        <s:RewardPurChk controlid="<%=ID_1%>">
                            <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/chadtbusitoapprove.do')">
                        </s:RewardPurChk>
                        <s:RewardPurChk controlid="<%=ID_2%>">
                            <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/chadtbusitoapprove.do')">
                        </s:RewardPurChk>
                        <s:RewardPurChk controlid="<%=ID_3%>"> -->
                      
                      <!--   </s:RewardPurChk> -->
                </td>
			</tr>
		</table>
	</div>

    <div class="table_div">
      <div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
               
                <td>
                    <a href="javascript:doOrderby('approveid')"><bean:message bundle="chadtbusitoapprove" key="approveid"/></a>
                    <s:OrderImg form="/cms/chadtbusitoapprove/ChadtbusitoapproveForm" field="approveid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('batchid')"><bean:message bundle="chadtbusitoapprove" key="batchid"/></a>
                    <s:OrderImg form="/cms/chadtbusitoapprove/ChadtbusitoapproveForm" field="batchid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('opnid')"><bean:message bundle="chadtbusitoapprove" key="opnid"/></a>
                    <s:OrderImg form="/cms/chadtbusitoapprove/ChadtbusitoapproveForm" field="opnid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('opnname')"><bean:message bundle="chadtbusitoapprove" key="opnname"/></a>
                    <s:OrderImg form="/cms/chadtbusitoapprove/ChadtbusitoapproveForm" field="opnname"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('rewardtype')"><bean:message bundle="chadtbusitoapprove" key="rewardtype"/></a>
                    <s:OrderImg form="/cms/chadtbusitoapprove/ChadtbusitoapproveForm" field="rewardtype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('region')"><bean:message bundle="chadtbusitoapprove" key="region"/></a>
                    <s:OrderImg form="/cms/chadtbusitoapprove/ChadtbusitoapproveForm" field="region"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('startdate')"><bean:message bundle="chadtbusitoapprove" key="startdate"/></a>
                    <s:OrderImg form="/cms/chadtbusitoapprove/ChadtbusitoapproveForm" field="startdate"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('enddate')"><bean:message bundle="chadtbusitoapprove" key="enddate"/></a>
                    <s:OrderImg form="/cms/chadtbusitoapprove/ChadtbusitoapproveForm" field="enddate"/>
                </td>

            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/chadtbusitoapprove.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.approveid}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                   
                     <td>
	                 <!--         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.approveid}"/></a> -->
                         <c:out value="${item.approveid}"/>
                     </td>
                     <td><c:out value="${item.batchid}"/></td>
                     <td><c:out value="${item.opnid}"/></td>
                     <td><c:out value="${item.opnname}"/></td>
                     <td><s:Code2Name code="${item.rewardtype}" definition="#REWARDTYPE" /></td>
                     <td> <s:Code2Name code="${item.region}" definition="#CITYIDNUM2NMAME"/></td>
                     <td><c:out value="${item.startdate}"/></td>
                     <td><c:out value="${item.enddate}"/></td>

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
