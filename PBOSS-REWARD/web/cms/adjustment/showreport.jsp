<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
    String ID_1 = "00010701";
%>
<html>
<head>
    <title><bean:message bundle="adjustment" key="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/jquery/jquery-1.3.2.js"></script>
    <script language="JavaScript" type="text/JavaScript">
    function ev_check() {
    	var _hasupperopnid = document.getElementById('_hasupperopnid').value;
    	if(_hasupperopnid=='1'){
    		addfield('_se_rewardmonth', '<bean:message bundle="adjustment" key="rewardmonth"/>', 'c', 'false', '6');
    	}
        return (checkval(window));
    }
    function doCreatereport(){
    	var msg = "请再次确认实收发票金额是否一致,确认后该批数据不可再调整,第二天可在报表平台上导出酬金付款报表! ";
    	var paymonth;
    	if(jQuery("#supportPaymonth").val()=='true'){
    		paymonth = jQuery("#_paymonth").val();
    		if(paymonth == ''){
	        	var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[付款月份]</span> 不能为空 ';
				errorMessageShow(alertstr);
				return false;
        	}
    	}   
    	if(confirm(msg)){
    		jQuery("#btnreport").hide();
    		jQuery("#btnexport").hide();    		
    		var countypermited=document.getElementById('countypermited').value;
    		var _se_countyid=document.getElementById('_se_countyid').value;
    		var _hasupperopnid = document.getElementById('_hasupperopnid').value;
    		var url = contextPath + '/cms/adjustment.do?CMD=CREATEREPORT';
    		var success = function(data){
    			errorMessageShow(data);
    			if(_hasupperopnid=='1'){
    				jQuery("#btnreport").show().attr("disabled","true");
    		        jQuery("#btnexport").show().attr("disabled","true");
    			}
    		}    		
    		var ajaxparams;
    		if(_hasupperopnid=='1'){
    			var _se_rewardmonth = document.getElementById('_se_rewardmonth').value;
    			var _se_upperopnid = jQuery("#_se_upperopnid").attr("selected",true).val();
    			ajaxparams ={
    				'countypermited':countypermited,
    				'_se_countyid':_se_countyid,
    				'_hasupperopnid':_hasupperopnid,
    				'_se_rewardmonth':_se_rewardmonth,
    				'_se_upperopnid':_se_upperopnid
    			};    			
    		}else{
    			ajaxparams ={
    				'countypermited':countypermited,
    				'_se_countyid':_se_countyid,
    				'_hasupperopnid':_hasupperopnid
    			};
    		}  
    		if(jQuery("#supportPaymonth").val()=='true'){
    			ajaxparams['supportPaymonth']=jQuery("#supportPaymonth").val();
    			ajaxparams['_paymonth']=paymonth;
    		}
    		jQuery.post(url, ajaxparams, success, 'text');  		
    	}
    }
    function doExcel(){ 
		formList.action = "<%=contextPath%>/cms/adjustment.do?CMD=EXCEL";
	    formList.submit();
	    formList.action = "<%=contextPath%>/cms/adjustment.do?CMD=SHOWREPORT";		
	}
	function doReturn(){
    	window.location.href="<%=contextPath%>/cms/adjustment.do?CMD=SHOW";
    }
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/adjustment.do?CMD=SHOWREPORT" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="countypermited" styleId="countypermited"/>
    <html:hidden property="_se_countyid" styleId="_se_countyid"/>
    <html:hidden property="exporttype" value="2"/>
    <html:hidden property="_hasfees"/>
    <html:hidden property="_hasupperopnid" styleId="hasupperopnid"/>
    <html:hidden property="supportPaymonth" styleId="supportPaymonth"/>        
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/adjustment/AdjustmentForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="adjustment" key="titleListReport"/>
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
        <c:if test="${form.supportPaymonth}">        
			<tr>
				<td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="adjustment" key="paymonth"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" styleId="_paymonth" property="_paymonth" onclick="this.value=selectDateYYYYMM(this.value)"></html:text>
                </td>
                <td colspan="2" width="50%" height="20" align="right" class="form_table_right" >&nbsp;</td>
			</tr>	
		</c:if>	  
        <c:if test="${form._hasupperopnid==1}">      
			<tr>
				<td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="adjustment" key="rewardmonth"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_rewardmonth" onclick="this.value=selectDateYYYYMM(this.value)"></html:text>
                </td>
                <td rowspan="5" width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="adjustment" key="upperopnid"/>:</td>
                <td rowspan="5" width="30%" class="form_table_left">
                    <html:select property="_se_upperopnid" size="5" multiple="true" style="height:100px" styleId="_se_upperopnid">
                    	<option />
                    	<s:Options definition="#OPERATION" condition="opnlevel:1"/>
                    </html:select>
                </td>
			</tr>	
		</c:if>	
        </table>
    </div>
        	
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
			    <c:if test="${form._hasupperopnid!=1}">			
				<td align='left'><font color='red'>【确认出支付报表】操作涉及所有【已核对】状态的数据</font></td>
				</c:if>
                <td align='right'>
                		<c:if test="${form._hasupperopnid==1}">
                		<input type="button" class="query" onmouseover="buttonover(this);" onclick="doQuery();"
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_search"/>" />
                        </c:if>
                		<input id='btnexport' type="button" class="button_2" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
							onfocus="buttonover(this)" onblur="buttonout(this)" 
							value="<bean:message bundle="public" key="button_export"/>" onclick="doExcel()" 
							<c:if test="${requestScope.LIST.rowCount<=0}"> disabled  </c:if> />  
                        <input id="btnreport" type="button" name="btnDelete" class="button_8" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="确认出支付报表" onClick="doCreatereport()" 
                            <c:if test="${requestScope.LIST.rowCount<=0}"> disabled  </c:if> >  
                        <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           		name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           		value="<bean:message bundle="public" key="button_return"/>" class="button_4"
                           		onclick="doReturn()">                      
                </td>
			</tr>
		</table>
	</div>

    <div class="table_div">
      <div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
                <td>
                    <a href="javascript:doOrderby('id')"><bean:message bundle="adjustment" key="id"/></a>
                    <s:OrderImg form="/cms/adjustment/AdjustmentForm" field="id"/>
                </td>    
                <td>
                    <a href="javascript:doOrderby('countyid')"><bean:message bundle="adjustment" key="countyid"/></a>
                    <s:OrderImg form="/cms/adjustment/AdjustmentForm" field="countyid"/>
                </td>            
                <td>
                    <bean:message bundle="adjustment" key="rewardmonth"/>
                </td>                
                <td>
                    <a href="javascript:doOrderby('wayid')"><bean:message bundle="adjustment" key="wayid"/></a>
                    <s:OrderImg form="/cms/adjustment/AdjustmentForm" field="wayid"/>
                </td>
                <td>
                    <bean:message bundle="adjustment" key="wayname"/>
                </td>
                <td>
                    <bean:message bundle="adjustment" key="starlevel"/>
                </td>
                <c:if test="${form._hasupperopnid==1}">
                <td>
		            <bean:message bundle="adjustment" key="upperopnid"/>
		        </td>
                </c:if>
                <td>
                    <bean:message bundle="adjustment" key="paysum"/>
                </td>
                <td>
                    <bean:message bundle="adjustment" key="rpmoney"/>
                </td>
                <td>
                    <bean:message bundle="adjustment" key="invoicesum"/>
                </td>
                <td>
                    <bean:message bundle="adjustment" key="taxmoney"/>
                </td>
                <c:if test="${form._hasfees==1}">
                      <td>
		                    <bean:message bundle="adjustment" key="fees"/>
		              </td>
                 </c:if> 
                <td>
                    <bean:message bundle="adjustment" key="realpay"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='#99FFCC'" onMouseOut="this.bgColor='#ffffff'">
                     <td>
                         <c:out value="${item.id}"/>
                     </td>
                     <td><s:Code2Name code="${item.countyid}" definition="#CNTYCOMPANY" /></td>
                     <td><c:out value="${item.rewardmonth}"/></td>
                     <td><c:out value="${item.wayid}"/></td>
                     <td><c:out value="${item.wayname}"/></td>
                     <td><s:Code2Name code="${item.starlevel}" definition="$CH_STARLEVEL" /></td>
                     <c:if test="${form._hasupperopnid==1}">
                     	<td><s:Code2Name code="${item.upperopnid}" definition="#OPERATION" /></td>
                     </c:if>
                     <td><fmt:formatNumber pattern="0.0000" value="${item.paysum}" /></td>
                     <td><fmt:formatNumber pattern="0.0000" value="${item.rpmoney}" /></td>
                     <td><fmt:formatNumber pattern="0.0000" value="${item.invoicesum}" /></td>
                     <td><fmt:formatNumber pattern="0.0000" value="${item.taxmoney}" /></td>
                     
                     <c:if test="${form._hasfees==1}">
                     	<td><fmt:formatNumber pattern="0.0000" value="${item.fees}" /></td>
                     </c:if>   
                     <td><fmt:formatNumber pattern="0.0000" value="${item.realpay}" /></td>                  
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
