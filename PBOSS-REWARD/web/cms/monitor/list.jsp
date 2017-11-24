<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
    String ID_1 = "CH_ADT_MONITOR_VIEW";
    String ID_2 = "CH_ADT_MONITOR_CON||CH_ADT_ADJUST_COUNTY";
    String ID_3 = "00010703";
    String ID_4 = "00010704";
%>
<html>
<head>
    <title><bean:message bundle="monitor" key="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/jquery/jquery-1.3.2.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_ne_cityid', '<bean:message bundle="monitor" key="cityid"/>', 'f', 'false', '3');
            addfield('_dnm_conoptime', '<bean:message bundle="monitor" key="conoptime"/>', 't', 'false', '7');
            addfield('_dnl_conoptime', '<bean:message bundle="monitor" key="conoptime"/>', 't', 'false', '7');
            return (checkval(window) && compareDate());
        }        
        function compareDate(){
	        var startTime2 = document.getElementById('_dnl_conoptime').value;
	        var endTime2 = document.getElementById('_dnm_conoptime').value;      
	        if(startTime2 != '' && endTime2 != '' && startTime2>endTime2){
		        var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[出帐确认时间>=]</span> 不能大于 <span style=\'color:#F00; font-size:12px;\'>[出帐确认时间<=]</span>';
				errorMessageShow(alertstr);
		        return false;
	       	}        
	   		return true;	
    	}
        function doExcel(){
        	if(ev_check()){
	        	formList.action = "<%=contextPath%>/cms/monitor.do?CMD=EXCEL";
	        	formList.submit();
	        	formList.action = "<%=contextPath%>/cms/monitor.do?CMD=LIST";
        	} 
		}
		function doReport(){
			var lastdate2 = document.getElementById('_lastdate2').value;
			var rewardmonth = document.getElementById('_rewardmonth').value;
			var supportPaymonth = jQuery('#supportPaymonth').val();
			var paymonth = '';
			if(lastdate2==null || lastdate2==''){
				var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[数据截止确认日期]</span> 不能为空';
				errorMessageShow(alertstr);
				return ;
			}
			if(supportPaymonth=='false'){
				if(rewardmonth==null || rewardmonth==''){
					var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[结算月份]</span> 不能为空 ';
					errorMessageShow(alertstr);
					return false;
				}
			}else{
				paymonth = jQuery('#_paymonth').val();
				if(rewardmonth=='' && paymonth==''){
					var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[结算月份][付款月份]</span> 不能同时为空 ';
					errorMessageShow(alertstr);
					return false;
				}
			}
			
			var countyid = document.getElementById('_countyid').value;			
			var upperopnid = document.getElementById('_upperopnid').value;
			var url = contextPath + '/cms/monitor.do?CMD=CREATEACCOUNT';
			var success = function(data){
				errorMessageShow(data);
			}
			jQuery.post(url, 
				{'_lastdate2':lastdate2,'_countyid':countyid,'_rewardmonth':rewardmonth,'_upperopnid':upperopnid,'_paymonth':paymonth},
				 success, "text");
		}
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/monitor.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="provpermited"/>
    <html:hidden property="citypermited"/>
    <html:hidden property="countypermited"/>
    <html:hidden property="supportPaymonth" styleId="supportPaymonth"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/monitor/MonitorForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="monitor" key="titleList"/>
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
            	<td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="monitor" key="rewardmonth"/>:</td>
                <td width="30%" class="form_table_left">
                	<html:text styleClass="form_input_1x" property="_rewardmonth" onclick="this.value=selectDateYYYYMM(this.value)" styleId="_rewardmonth"></html:text>		                    
                	<c:if test="${!form.supportPaymonth}"><font color=red>*</font></c:if>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="monitor" key="countyid"/>:</td>
                <td width="30%" class="form_table_left">                  	
                    <c:choose>
                	   <c:when test="${form.citypermited==1}">   
                	   <html:select property="_countyid" styleId="_countyid">             	   
						<option />
                    	<s:Options definition="#CNTYCOMPANY" condition="citycompid:${requestScope.cityid}"/>
                       </html:select>
                	   </c:when>
                	   <c:when test="${form.citypermited!=1 && form.countypermited==1 && form._countyid!=null}">
                	   <html:select property="_countyid" styleId="_countyid">
                    	<s:Options definition="#CNTYCOMPANY" condition="countycompid:${form._countyid}"/>
                       </html:select>
                	   </c:when>
                	</c:choose>                    
                </td>
            </tr>
            <tr>
            	<td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="monitor" key="upperopnid"/>:</td>
                <td width="30%" class="form_table_left">
                	<html:select property="_upperopnid" styleId="_upperopnid">
                    	<option />
                    	<s:Options definition="#OPERATION" condition="opnlevel:1"/>
                    </html:select>		                    
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="monitor" key="lastdate2"/>:</td>
                <td width="30%" class="form_table_left">
                	<html:text styleClass="form_input_1x" property="_lastdate2"  onclick="this.value=selectDate();" styleId="_lastdate2"></html:text>		                    
                	<font color=red>*</font>
                </td>
            </tr>
            <c:if test="${form.supportPaymonth}">
            <tr>
            	<td width="20%" height="20" align="right" class="form_table_right"><bean:message bundle="monitor" key="paymonth"/>:</td>
            	<td width="30%" class="form_table_left">
                	<html:text styleClass="form_input_1x" property="_paymonth" onclick="this.value=selectDateYYYYMM(this.value)" styleId="_paymonth"></html:text>		                    
                </td>
            	<td colspan='2'>&nbsp;</td>
            </tr>
            </c:if>
        </table>
    </div>
    <div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                		<s:RewardPurChk controlid="<%=ID_2%>" disableChild="true">   
                        <input type="button" class="button_4" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="monitor" key="report"/>" onClick="doReport()"> 
                        </s:RewardPurChk>                      
				</td>
			</tr>
		</table>
	</div>
	<div class="table_div">
        <table class="form_table">
            <tr>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="monitor" key="cityid"/>:</td>
                <td width="30%" class="form_table_left">
                	<html:select property="_ne_cityid" styleId="_ne_cityid" >                	
                	<c:choose>
                	   <c:when test="${form.provpermited==1}">                	   
						<option />
						<s:Options definition="#CITYCOMPANY_AREA"/>
                	   </c:when>
                	   <c:otherwise>
                	   <s:Options definition="#CITYCOMPANY_AREA" condition="areacode:${sessionScope._USER.cityid}"/>
                	   </c:otherwise>
                	</c:choose>		
                	</html:select>			                    
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" >
                <c:if test="${form.provpermited!=1}">
                <bean:message bundle="monitor" key="countyid"/>:
                </c:if>&nbsp;
                </td>
            	<td width="30%" class="form_table_left">					
                	<c:if test="${form.provpermited!=1}">   
                	   <c:choose>
                	   <c:when test="${form.citypermited==1}">   
                	   <html:select property="_se_countyid" styleId="_se_countyid">             	   
						<option />
                    	<s:Options definition="#CNTYCOMPANY" condition="citycompid:${requestScope.cityid}"/>
                       </html:select>
                	   </c:when>
                	   <c:when test="${form.citypermited!=1 && form.countypermited==1 && form._se_countyid!=null}">
                	   <html:select property="_se_countyid" styleId="_se_countyid">
                    	<s:Options definition="#CNTYCOMPANY" condition="countycompid:${form._se_countyid}"/>
                       </html:select>
                	   </c:when>
                	   </c:choose>                   	   
                	</c:if>&nbsp;
				 </td>
            </tr>
            <tr>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="monitor" key="conoptime"/>&gt;=:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnl_conoptime"  onclick="this.value=selectDate();"></html:text>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="monitor" key="conoptime"/>&lt;=:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnm_conoptime"  onclick="this.value=selectDate();"></html:text>
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
                        <input type="button" class="button_2" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_export"/>" onClick="doExcel()">                       
				</td>
			</tr>
		</table>
	</div>

    <div class="table_div">
      <div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
            	<td>
                    <bean:message bundle="monitor" key="cityid"/>
                </td>
                <td>
                    <bean:message bundle="monitor" key="abatchno"/>
                </td>   
                <td>
                    <bean:message bundle="monitor" key="conoprcode"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('conoptime')"><bean:message bundle="monitor" key="conoptime"/></a>
                    <s:OrderImg form="/cms/monitor/MonitorForm" field="conoptime"/>
                </td>             
                <td>
                    <bean:message bundle="monitor" key="rewardmonth"/>
                </td>
                <td>
                    <bean:message bundle="monitor" key="countyid"/>
                </td>
                <td>
                    <bean:message bundle="monitor" key="upperopnid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('lastdate')"><bean:message bundle="monitor" key="lastdate"/></a>
                    <s:OrderImg form="/cms/monitor/MonitorForm" field="lastdate"/>
                </td>
                <td>
                    <bean:message bundle="monitor" key="status"/>
                </td>
                <c:if test="${form.supportPaymonth}">
                <td>
                    <bean:message bundle="monitor" key="paymonth"/>
                </td>
                </c:if>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='#99FFCC'" onMouseOut="this.bgColor='#ffffff'">
                     <td><s:Code2Name code="${item.cityid}" definition="#CITYCOMPANY_AREA"/></td>
                     <td><c:out value="${item.abatchno}"/></td>
                     <td><c:out value="${item.conoprcode}"/></td>
                     <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.conoptime}" /></td>
                     <td><c:out value="${item.rewardmonth}"/></td>
                     <td><s:Code2Name code="${item.countyid}" definition="#CNTYCOMPANY"/></td>
                     <td><s:Code2Name code="${item.upperopnid}" definition="#OPERATION"/></td>
                     <td><fmt:formatDate pattern="yyyy-MM-dd" value="${item.lastdate}" /></td>
                     <td><s:Code2Name code="${item.status}" definition="#ADT_STATUS"/></td>
                     <c:if test="${form.supportPaymonth}">
                     <td><c:out value="${item.paymonth}"/></td>
                     </c:if>
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
