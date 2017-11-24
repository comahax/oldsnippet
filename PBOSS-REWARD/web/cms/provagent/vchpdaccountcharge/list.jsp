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
    <title><bean:message bundle="vchpdaccountcharge" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_se_cityid', '<bean:message bundle="vchpdaccountcharge" key="cityid"/>', 'c', false, '4');
            addfield('_se_prodno', '<bean:message bundle="vchpdaccountcharge" key="prodno"/>', 'c', 'false', '18');
            addfield('_se_provagentid', '<bean:message bundle="vchpdaccountcharge" key="provagentid"/>', 'c', 'false', '15');
            addfield('_se_prodid', '<bean:message bundle="vchpdaccountcharge" key="prodid"/>', 'c', 'false', '15');
            addfield('_se_feemonth', '<bean:message bundle="vchpdaccountcharge" key="feemonth"/>', 'c', 'false', '8');
            addfield('_dnm_incomstime', '<bean:message bundle="vchpdaccountcharge" key="incomstime"/>', 't', 'false', '7');
            addfield('_dnl_incomstime', '<bean:message bundle="vchpdaccountcharge" key="incomstime"/>', 't', 'false', '7');
            return (checkval(window) && compareDate());
        }
        function doExcel(){ 
		    if( ev_check() ){
		    	formList.action = "<%=contextPath%>/cms/provagent/vchpdaccountcharge.do?CMD=EXCEL";
	        	formList.submit();
	        	formList.action = "<%=contextPath%>/cms/provagent/vchpdaccountcharge.do?CMD=LIST";
		    }			
		}
        function compareDate(){
            var startTime = Date.parse(new Date(document.getElementById('_dnl_incomstime').value.replace(/-/g, "/")));
            var endTime = Date.parse(new Date(document.getElementById('_dnm_incomstime').value.replace(/-/g, "/")));
            if(startTime != '' && endTime != ''){
                if(startTime>endTime){
	    	        var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[采集起始时间]</span> 不能大于 <span style=\'color:#F00; font-size:12px;\'>[采集结束时间]</span>';
	    			errorMessageShow(alertstr);
	    	        return false;
                }else if((endTime-startTime)/(1000 * 60 * 60 * 24)>31){
               		var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[采集时间]</span> 时间跨度不能超过<span style=\'color:#F00; font-size:12px;\'>31天</span>';
        			errorMessageShow(alertstr);
        	        return false;
               	}
           	}
       		return true;	
        }
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/provagent/vchpdaccountcharge.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/provagent/vchpdaccountcharge/VChPdAccountchargeForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="vchpdaccountcharge" key="titleList"/>
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
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="vchpdaccountcharge" key="cityid"/>:</td>
                <td width="30%" class="form_table_left">
<%--                    <html:text styleClass="form_input_1x" property="_se_cityid"></html:text>--%>
                    <html:select property="_se_cityid">
						<option/>
						<s:Options definition="#REGIONNAME" />
					</html:select>
					<font color=red>&nbsp;*</font>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="vchpdaccountcharge" key="provagentid"/>:</td>
                <td width="30%" class="form_table_left">
<%--                    <html:text styleClass="form_input_1x" property="_se_provagentid"></html:text>--%>
                    <html:select property="_se_provagentid" >
						<option />
						<s:Options definition="#CH_PD_AGENT"></s:Options>
					</html:select>
                </td>
            </tr>
            <tr>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="vchpdaccountcharge" key="prodid"/>:</td>
                <td width="30%" class="form_table_left">
<%--                    <html:text styleClass="form_input_1x" property="_se_prodid"></html:text>--%>
                    <s:myzoom definition="#CH_PD_ENTPRODUCT" property="_se_prodid" styleClass="form_input_1x" readonly="false" />
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="vchpdaccountcharge" key="_dnm_incomstime"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnm_incomstime" onclick="this.value=selectDate();"></html:text>
                </td>
            </tr>
            <tr>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="vchpdaccountcharge" key="_dnl_incomstime"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnl_incomstime" onclick="this.value=selectDate();"></html:text>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" >
                	&nbsp;
            	</td>
            	<td width="30%" class="form_table_left">
               	 &nbsp;
            	</td>
            </tr>
            <tr>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
<%--                        <s:PurChk controlid="<%=ID_1%>">--%>
<%--                            <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"--%>
<%--                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"--%>
<%--                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/provagent/vchpdaccountcharge.do')">--%>
<%--                        </s:PurChk>--%>
<%--                        <s:PurChk controlid="<%=ID_2%>">--%>
<%--                            <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"--%>
<%--                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"--%>
<%--                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/provagent/vchpdaccountcharge.do')">--%>
<%--                        </s:PurChk>--%>
                        <s:PurChk controlid="<%=ID_3%>">
                        <input type="button" class="query" onmouseover="buttonover(this);" onclick="doQuery();"
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_search"/>" />
                        </s:PurChk>
                        <input type="button" class="button_4" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
							onfocus="buttonover(this)" onblur="buttonout(this)" 
							value="导出EXCEL" onclick="doExcel()"/>
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
                    <a href="javascript:doOrderby('chargeid')"><bean:message bundle="vchpdaccountcharge" key="chargeid"/></a>
                    <s:OrderImg form="/cms/provagent/vchpdaccountcharge/VchpdaccountchargeForm" field="chargeid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('cityid')"><bean:message bundle="vchpdaccountcharge" key="cityid"/></a>
                    <s:OrderImg form="/cms/provagent/vchpdaccountcharge/VchpdaccountchargeForm" field="cityid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('prodno')"><bean:message bundle="vchpdaccountcharge" key="prodno"/></a>
                    <s:OrderImg form="/cms/provagent/vchpdaccountcharge/VchpdaccountchargeForm" field="prodno"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('provagentid')"><bean:message bundle="vchpdaccountcharge" key="provagentid"/></a>
                    <s:OrderImg form="/cms/provagent/vchpdaccountcharge/VchpdaccountchargeForm" field="provagentid"/>
                </td>
                <td>
                	代理商名称
                </td>
                <td>
                    <a href="javascript:doOrderby('prodid')"><bean:message bundle="vchpdaccountcharge" key="prodid"/></a>
                    <s:OrderImg form="/cms/provagent/vchpdaccountcharge/VchpdaccountchargeForm" field="prodid"/>
                </td>
                <td>
                	集团产品名称
                </td>
                <td>
                    <a href="javascript:doOrderby('custname')"><bean:message bundle="vchpdaccountcharge" key="custname"/></a>
                    <s:OrderImg form="/cms/provagent/vchpdaccountcharge/VchpdaccountchargeForm" field="custname"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('chargemoney')"><bean:message bundle="vchpdaccountcharge" key="chargemoney"/></a>
                    <s:OrderImg form="/cms/provagent/vchpdaccountcharge/VchpdaccountchargeForm" field="chargemoney"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('feemonth')"><bean:message bundle="vchpdaccountcharge" key="feemonth"/></a>
                    <s:OrderImg form="/cms/provagent/vchpdaccountcharge/VchpdaccountchargeForm" field="feemonth"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('incomstime')"><bean:message bundle="vchpdaccountcharge" key="incomstime"/></a>
                    <s:OrderImg form="/cms/provagent/vchpdaccountcharge/VchpdaccountchargeForm" field="incomstime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('phase')"><bean:message bundle="vchpdaccountcharge" key="phase"/></a>
                    <s:OrderImg form="/cms/provagent/vchpdaccountcharge/VchpdaccountchargeForm" field="phase"/>
                </td>
<%--                <td>--%>
<%--                    <a href="javascript:doOrderby('srcfile')"><bean:message bundle="vchpdaccountcharge" key="srcfile"/></a>--%>
<%--                    <s:OrderImg form="/cms/provagent/vchpdaccountcharge/VchpdaccountchargeForm" field="srcfile"/>--%>
<%--                </td>--%>
                <td>
                    <a href="javascript:doOrderby('rewardid')"><bean:message bundle="vchpdaccountcharge" key="rewardid"/></a>
                    <s:OrderImg form="/cms/provagent/vchpdaccountcharge/VchpdaccountchargeForm" field="rewardid"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/provagent/vchpdaccountcharge.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.chargeid}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.chargeid}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.chargeid}"/></a>
                     </td>
                     <td><s:Code2Name code="${item.cityid}" definition="#REGIONNAME"/></td>
                     <td><c:out value="${item.prodno}"/></td>
                     <td><c:out value="${item.provagentid}"/></td>
                     <td><s:Code2Name code="${item.provagentid}" definition="#CH_PD_AGENT"/></td>
                     <td><c:out value="${item.prodid}"/></td>
                     <td><s:Code2Name code="${item.prodid}" definition="#CH_PD_ENTPRODUCT"/></td>
                     <td><c:out value="${item.custname}"/></td>
                     <td><c:out value="${item.chargemoney}"/></td>
                     <td><c:out value="${item.feemonth}"/></td>
                     <td><fmt:formatDate value="${item.incomstime}" pattern="yyyy-MM-dd"/></td>
                     <td><c:out value="${item.phase}"/></td>
<%--                     <td><c:out value="${item.srcfile}"/></td>--%>
                     <td><c:out value="${item.rewardid}"/></td>
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
