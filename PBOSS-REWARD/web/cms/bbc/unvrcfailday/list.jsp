<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
    String ID_1 = "UNPN_DIGITAL_BUSI_EXPORT";
    String ID_2 = "00010702";
    String ID_3 = "00010703";
    String ID_4 = "00010704";
%>
<html>
<head>
    <title><bean:message bundle="unvrcfailday" key="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_se_rcno', '<bean:message bundle="unvrcfailday" key="rcno"/>', 'c', 'true', '15');
            addfield('_se_opnid', '<bean:message bundle="unvrcfailday" key="opnid"/>', 'c', 'true', '18');
            addfield('_dnm_rcdate', '<bean:message bundle="unvrcfailday" key="rcdate"/>', 't', 'false', '7');
            addfield('_dnl_rcdate', '<bean:message bundle="unvrcfailday" key="rcdate"/>', 't', 'false', '7');
            addfield('_se_wayid', '<bean:message bundle="unvrcfailday" key="wayid"/>', 'c', 'true', '18');
            return (checkval(window) && compareDate());
        }
        
        function compareDate(){
	        var startTime2 = document.getElementById('_dnl_rcdate').value;
	        var endTime2 = document.getElementById('_dnm_rcdate').value;       
       
	        if(startTime2 != '' && endTime2 != '' && startTime2>endTime2){
		        var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[推荐时间>=]</span> 不能大于 <span style=\'color:#F00; font-size:12px;\'>[推荐时间<=]</span>';
				errorMessageShow(alertstr);
		        return false;
	       	}
	        
	   		return true;	
    	}
        
        function doExport(cmd){      		
      		var url="<%=contextPath%>/cms/bbc/unvrcfailday.do?CMD="+cmd;
        	formList.action=url;
        	formList.submit();
        	formList.action="<%=contextPath%>/cms/bbc/unvrcfailday.do?CMD=LIST";
		}
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/bbc/unvrcfailday.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/bbc/unvrcfailday/UnvrcfaildayForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="unvrcfailday" key="titleList"/>
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
                <td width="13%" height="20" align="right" class="form_table_right" ><bean:message bundle="unvrcfailday" key="rcno"/>:</td>
                <td width="20%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_rcno"></html:text>
                </td>
                <td width="13%" height="20" align="right" class="form_table_right" ><bean:message bundle="unvrcfailday" key="opnid"/>:</td>
                <td width="20%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_opnid"></html:text>
                </td>
                <td width="13%" height="20" align="right" class="form_table_right" ><bean:message bundle="unvrcfailday" key="opnname"/>:</td>
                <td width="21%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_sk_opnname"></html:text>
                </td>
            </tr>
            <tr>
                <td width="13%" height="20" align="right" class="form_table_right" ><bean:message bundle="unvrcfailday" key="rcdate"/>&gt;=:</td>
                <td width="20%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnl_rcdate" onclick="this.value=selectDate();"></html:text>
                </td>
                <td width="13%" height="20" align="right" class="form_table_right" ><bean:message bundle="unvrcfailday" key="rcdate"/>&lt;=:</td>
                <td width="20%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnm_rcdate" onclick="this.value=selectDate();"></html:text>
                </td>
                <td width="13%" height="20" align="right" class="form_table_right" ><bean:message bundle="unvrcfailday" key="wayid"/>:</td>
                <td width="21%" class="form_table_left">
					<!--s:zoom definition="#WAY" property="_se_wayid" condition="waytype:ET;" styleClass="form_input_1x" nameOnly="false" readonly="true"/-->
					<html:text styleClass="form_input_1x" property="_se_wayid"></html:text>
                    <input type="button" value="..." class="clickbutton" onclick="showSelectWay3(this,'_se_wayid','','','ET');this.value='...';" />
                </td>
            </tr>
            <tr>
            	<td width="13%" height="20" align="right" class="form_table_right" ><bean:message bundle="unvrcfailday" key="empattr2"/>:</td>
                <td width="20%" class="form_table_left">
                    <html:select property="_ne_empattr2" styleId="empattr2">
						<option />
							<s:Options definition="$CH_EMPATTR2" />
					</html:select>
                </td>
    			<td width="13%" height="20" align="right" class="form_table_right" >
                	&nbsp;
            	</td>
            	<td width="20%" class="form_table_left">
               	 &nbsp;
            	</td>
            	<td width="13%" height="20" align="right" class="form_table_right" >
                	&nbsp;
            	</td>
            	<td width="21%" class="form_table_left">
               	 &nbsp;
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
                                value="<bean:message bundle="public" key="button_search"/>" />
                        <s:RewardPurChk controlid="<%=ID_1%>" disableChild="true">
                        <input type="button" class="button_4" onmouseover="buttonover(this);" onclick="doExport('TOTXT')" 
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_export_txt"/>" /> 
                        </s:RewardPurChk>
                </td>
			</tr>
		</table>
	</div>

    <div class="table_div">
      <div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
                <td>
                    <a href="javascript:doOrderby('rcno')"><bean:message bundle="unvrcfailday" key="rcno"/></a>
                    <s:OrderImg form="/cms/bbc/unvrcfailday/UnvrcfaildayForm" field="rcno"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('mobileno')"><bean:message bundle="unvrcfailday" key="mobileno"/></a>
                    <s:OrderImg form="/cms/bbc/unvrcfailday/UnvrcfaildayForm" field="mobileno"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('opnid')"><bean:message bundle="unvrcfailday" key="opnid"/></a>
                    <s:OrderImg form="/cms/bbc/unvrcfailday/UnvrcfaildayForm" field="opnid"/>
                </td>
                <td>
                    <bean:message bundle="unvrcfailday" key="opnname"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('rcmonth')"><bean:message bundle="unvrcfailday" key="rcmonth"/></a>
                    <s:OrderImg form="/cms/bbc/unvrcfailday/UnvrcfaildayForm" field="rcmonth"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('rcdate')"><bean:message bundle="unvrcfailday" key="rcdate"/></a>
                    <s:OrderImg form="/cms/bbc/unvrcfailday/UnvrcfaildayForm" field="rcdate"/>
                </td>
                <td>
                   <bean:message bundle="unvrcfailday" key="reason"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('ossrc')"><bean:message bundle="unvrcfailday" key="ossrc"/></a>
                    <s:OrderImg form="/cms/bbc/unvrcfailday/UnvrcfaildayForm" field="ossrc"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('wayid')"><bean:message bundle="unvrcfailday" key="wayid"/></a>
                    <s:OrderImg form="/cms/bbc/unvrcfailday/UnvrcfaildayForm" field="wayid"/>
                </td>
                <td>
                    <bean:message bundle="unvrcfailday" key="wayname"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('empattr2')"><bean:message bundle="unvrcfailday" key="empattr2"/></a>
                    <s:OrderImg form="/cms/bbc/unvrcfailday/UnvrcfaildayForm" field="empattr2"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
                     <td><c:out value="${item.rcno}"/></td>
                     <td><c:out value="${item.mobileno}"/></td>
                     <td><c:out value="${item.opnid}"/></td>
                     <td><c:out value="${item.opnname}"/></td>
                     <td><c:out value="${item.rcmonth}"/></td>
                     <td>
                     	<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.rcdate}" />
                     </td>
                     <td><c:out value="${item.reason}"/></td>
                     <td>
                     	<s:Code2Name code="${item.ossrc}" definition="#CH_UNV_OSSRC" />                     
                     </td>
                     <td><c:out value="${item.wayid}"/></td>
                     <td><c:out value="${item.wayname}"/></td>
                     <td>
                     	<s:Code2Name code="${item.empattr2}" definition="$CH_EMPATTR2"/>
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
