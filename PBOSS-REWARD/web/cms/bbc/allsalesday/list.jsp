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
    <title><bean:message bundle="allsalesday" key="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_se_opnid', '<bean:message bundle="allsalesday" key="opnid"/>', 'c', 'true', '18');
            addfield('_se_opnname', '<bean:message bundle="allsalesday" key="opnname"/>', 'c', 'true', '50');
            addfield('_se_wayid', '<bean:message bundle="allsalesday" key="wayid"/>', 'c', 'true', '18');
            addfield('_dnm_oprtime', '<bean:message bundle="allsalesday" key="oprtime"/>', 't', 'false', '7');
            addfield('_dnl_oprtime', '<bean:message bundle="allsalesday" key="oprtime"/>', 't', 'false', '7');
            addfield('_se_oprcode', '<bean:message bundle="allsalesday" key="oprcode"/>', 'c', 'true', '15');
            addfield('_ne_empattr2', '<bean:message bundle="allsalesday" key="empattr2"/>', 'f', 'true', '3');
            return (checkval(window) && compareDate());
        }
        
        function compareDate(){
	        var startTime2 = document.getElementById('_dnl_oprtime').value;
	        var endTime2 = document.getElementById('_dnm_oprtime').value;       
       
	        if(startTime2 != '' && endTime2 != '' && startTime2>endTime2){
		        var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[业务发生时间>=]</span> 不能大于 <span style=\'color:#F00; font-size:12px;\'>[业务发生时间<=]</span>';
				errorMessageShow(alertstr);
		        return false;
	       	}
	        
	   		return true;	
    	}
    	
    	function doExport(cmd){      		
      		var url="<%=contextPath%>/cms/bbc/allsalesday.do?CMD="+cmd;
        	formList.action=url;
        	formList.submit();
        	formList.action="<%=contextPath%>/cms/bbc/allsalesday.do?CMD=LIST";
		}
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/bbc/allsalesday.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/bbc/allsalesday/AllsalesdayForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="allsalesday" key="titleList"/>
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
                <td width="13%" height="20" align="right" class="form_table_right" ><bean:message bundle="allsalesday" key="opnid"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_opnid"></html:text>
                </td>
                <td width="13%" height="20" align="right" class="form_table_right" ><bean:message bundle="allsalesday" key="opnname"/>:</td>
                <td width="20%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_sk_opnname"></html:text>
                </td>
                <td width="13%" height="20" align="right" class="form_table_right" ><bean:message bundle="allsalesday" key="oprcode"/>:</td>
                <td width="21%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_oprcode"></html:text>
                </td>
                
            </tr>
            <tr>
                <td width="13%" height="20" align="right" class="form_table_right" ><bean:message bundle="allsalesday" key="oprtime"/>&gt;=:</td>
                <td width="20%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnl_oprtime" onclick="this.value=selectDate();"></html:text>
                </td>
                <td width="13%" height="20" align="right" class="form_table_right" ><bean:message bundle="allsalesday" key="oprtime"/>&lt;=:</td>
                <td width="20%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnm_oprtime" onclick="this.value=selectDate();"></html:text>
                </td>
                <td width="13%" height="20" align="right" class="form_table_right" ><bean:message bundle="allsalesday" key="empattr2"/>:</td>
                <td width="21%" class="form_table_left">
                    <html:select property="_ne_empattr2" styleId="empattr2">
						<option />
							<s:Options definition="$CH_EMPATTR2" />
					</html:select>
                </td>
            </tr>
            <tr>
                <td width="13%" height="20" align="right" class="form_table_right" ><bean:message bundle="allsalesday" key="wayid"/>:</td>
                <td width="20%" class="form_table_left">
					<!--s:zoom definition="#WAY" property="_se_wayid" condition="waytype:ET;" styleClass="form_input_1x" nameOnly="false" readonly="true"/-->
					<html:text styleClass="form_input_1x" property="_se_wayid"></html:text>
                    <input type="button" value="..." class="clickbutton" onclick="showSelectWay3(this,'_se_wayid','','','ET');this.value='...';" />
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
                    <a href="javascript:doOrderby('ruleid')"><bean:message bundle="allsalesday" key="ruleid"/></a>
                    <s:OrderImg form="/cms/bbc/allsalesday/AllsalesdayForm" field="ruleid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('opnid')"><bean:message bundle="allsalesday" key="opnid"/></a>
                    <s:OrderImg form="/cms/bbc/allsalesday/AllsalesdayForm" field="opnid"/>
                </td>
                <td>
                    <bean:message bundle="allsalesday" key="opnname"/>
                    <s:OrderImg form="/cms/bbc/allsalesday/AllsalesdayForm" field="opnname"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('calcopnid')"><bean:message bundle="allsalesday" key="calcopnid"/></a>
                    <s:OrderImg form="/cms/bbc/allsalesday/AllsalesdayForm" field="calcopnid"/>
                </td>
                <td>
                    <bean:message bundle="allsalesday" key="calopnname"/>
                    <s:OrderImg form="/cms/bbc/allsalesday/AllsalesdayForm" field="calopnname"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('calcmonth')"><bean:message bundle="allsalesday" key="calcmonth"/></a>
                    <s:OrderImg form="/cms/bbc/allsalesday/AllsalesdayForm" field="calcmonth"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('wayid')"><bean:message bundle="allsalesday" key="wayid"/></a>
                    <s:OrderImg form="/cms/bbc/allsalesday/AllsalesdayForm" field="wayid"/>
                </td>
                <td>
                    <bean:message bundle="allsalesday" key="wayname"/>
                    <s:OrderImg form="/cms/bbc/allsalesday/AllsalesdayForm" field="wayname"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('oprtime')"><bean:message bundle="allsalesday" key="oprtime"/></a>
                    <s:OrderImg form="/cms/bbc/allsalesday/AllsalesdayForm" field="oprtime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('oprcode')"><bean:message bundle="allsalesday" key="oprcode"/></a>
                    <s:OrderImg form="/cms/bbc/allsalesday/AllsalesdayForm" field="oprcode"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('mobile')"><bean:message bundle="allsalesday" key="mobile"/></a>
                    <s:OrderImg form="/cms/bbc/allsalesday/AllsalesdayForm" field="mobile"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('busivalue')"><bean:message bundle="allsalesday" key="busivalue"/></a>
                    <s:OrderImg form="/cms/bbc/allsalesday/AllsalesdayForm" field="busivalue"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('rewardtype')"><bean:message bundle="allsalesday" key="rewardtype"/></a>
                    <s:OrderImg form="/cms/bbc/allsalesday/AllsalesdayForm" field="rewardtype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('ossrc')"><bean:message bundle="allsalesday" key="ossrc"/></a>
                    <s:OrderImg form="/cms/bbc/allsalesday/AllsalesdayForm" field="ossrc"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('empattr2')"><bean:message bundle="allsalesday" key="empattr2"/></a>
                    <s:OrderImg form="/cms/bbc/allsalesday/AllsalesdayForm" field="empattr2"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('srcseq')"><bean:message bundle="allsalesday" key="srcseq"/></a>
                    <s:OrderImg form="/cms/bbc/allsalesday/AllsalesdayForm" field="srcseq"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
                     <td><c:out value="${item.ruleid}"/></td>
                     <td><c:out value="${item.opnid}"/></td>
                     <td><c:out value="${item.opnname}"/></td>
                     <td><c:out value="${item.calcopnid}"/></td>
                     <td><c:out value="${item.calopnname}"/></td>
                     <td><c:out value="${item.calcmonth}"/></td>
                     <td><c:out value="${item.wayid}"/></td>
                     <td><c:out value="${item.wayname}"/></td>
                     <td>
                     	<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.oprtime}" />
                     </td>
                     <td><c:out value="${item.oprcode}"/></td>
                     <td><c:out value="${item.mobile}"/></td>
                     <td><c:out value="${item.busivalue}"/></td>
                     <td>
                     	<s:Code2Name definition="$CH_BBCREWARDTYPE" code="${item.rewardtype}" />
                     </td>
                     <td>
                     	<s:Code2Name code="${item.ossrc}" definition="#CH_UNV_OSSRC" />
                     </td>
                     <td>
                     	<s:Code2Name code="${item.empattr2}" definition="$CH_EMPATTR2"/>
                     </td>
                     <td><c:out value="${item.srcseq}"/></td>
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
