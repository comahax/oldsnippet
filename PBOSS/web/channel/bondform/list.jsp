<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/pwaycommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
	function ev_check() {
		addfield('param._se_wayid', '<s:text name="wayid"/>', 'c', true, '18');
		addfield('param._se_bondtype', '<s:text name="bondtype"/>', 'c', true, '16');
		addfield('param._se_countyid', '<s:text name="countyid"/>', 'c', true, '14');
		addfield('param._ne_state', '<s:text name="state"/>', 'f', true, '4');
		addfield('param._ne_boneobjtype', '<s:text name="boneobjtype"/>', 'f', true, '2');
		return checkval(window);
	}
	
	
	 //审批人弹出框
	     function getAuditingRoleList(formid){
	     	var returnValue=window.showModalDialog('<%=contextPath %>/base/operator_auditingRoleList.do',window,"dialogWidth=500px;dialogHeight=430px;status:no;scroll=yes;");
		    if(returnValue!=undefined){
		    	//return returnValue;    	
		   		window.location.href="<%=contextPath%>/channel/bondform_submitboss.do?formid="+formid+"&&boss="+returnValue;
			}
	     }
	     
	     
	     function sendInfo(formid){
	     	if(confirm("是否确认发送短信？")){
	     		window.location.href="<%=contextPath%>/channel/bondform_sendinfor.do?formid="+formid;
	     	}
	     }
	     
	     function mvaccount(formid){
	     	if(confirm("是否确认划扣？")){
	     		window.location.href="<%=contextPath%>/channel/bondform_mvaccount.do?formid="+formid;
	     	}
	     }
	     
	     
	   
	
</script>
</head>

<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="bondform_list.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
	<%//下面的控件给Action提供数据，用来分页%>
	<aa:zone name="hiddenZone">
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param.queryAll"/>
    <input type="hidden" name="_rowcount" value="<s:property value="dp.rowCount" />"/>
	</aa:zone>
    
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="channel"/> </span>
			<span class="table_toparea_xi">></span>
			</s:i18n>
			<span class="table_toparea_h"><s:text name="titleList"/></span>
			<span class="button_Help" onclick="openword('<s:text name="helpTitle"/>','<s:text name="helpContent"/>')"><s:i18n name="public"><s:text name="help"/></s:i18n></span>
		</div>
	</div>
    
    <aa:zone name="errorZone">
		<div class="error_text" >
			<table class="error_text">
				<s:actionerror /><s:actionmessage/>
			</table>
		</div>
    </aa:zone>

	<div class="table_div">
        <table class="table_normal">
            <tr>
                <td align="center"><s:text name="wayid"/>:</td>
                <td align="left">                
                    <s:textfield cssStyle="style_input" name="param._se_wayid" />
                    <input type="button" value="..." class="picker_button"
									onclick="pshowSelectWay3(this,'param._se_wayid','','','AG');this.value='...';" />
                </td>
                <td align="center"><s:text name="countyid"/>:</td>
                <td align="left">
                <j:selector definition="#CNTYCOMPANY" name="param._se_countyid" />
                </td>
                  </tr>
                <tr>
                 <td align="center"><s:text name="boneobjtype"/>:</td>
                <td align="left">
                <j:selector definition="$CH_BONEOBJTYPE" name="param._ne_boneobjtype" mode="selector"/>
                </td>
                <td align="center"><s:text name="state"/>:</td>
                <td align="left">
                <j:selector definition="$CH_BONDSTATE" name="param._ne_state" mode="selector"/>
                </td>
                  </tr>
                <tr>
                <td align="center"><s:text name="bondtype"/>:</td>
                <td align="left">
                <j:selector definition="$CH_BONDTYPE" name="param._se_bondtype" mode="selector"/>
                </td>
                 <td align="center"></td>
                <td align="left">
                </td>
            </tr>
        </table>
    </div>
    
    <div class="table_div">
		<table class="table_button_list">
			<tr>
				<td>
                	<s:i18n name="public">
                	<input type="button" id="btnQuery" name="btnQuery" class="button_Query" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_search"/>" onClick="doQuery('/channel/bondform_list.do');">
                	
                    <input type="button" id="btnNew" name="btnNew" class="button_New" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_new"/>" onClick="doNew('/channel/bondform_new.do')">
                    
                    <input type="button" id="btnDelete" name="btnDelete" class="button_Delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_delete"/>" onClick="doDelete('/channel/bondform_delete.do')">
                   </s:i18n>
				</td>
			</tr>
		</table>
	</div>

	<aa:zone name="listZone">
    <div class="table_div">
    	<div class="table_LongTable">
        <table class="table_style">
            <tr class="table_style_head">
               	<s:i18n name="public">
                <td title="<s:text name="list_title_select"/>">
                    <input type="checkbox" name="allbox" onclick="checkAll();"/>
                </td>
                </s:i18n>
                <td>
                    <j:orderByImg href="javascript:doOrderby('formid')"><s:text name="formid"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('wayid')"><s:text name="wayid"/></j:orderByImg>                 
                </td>
                 <td>
                    <j:orderByImg href="javascript:doOrderby('countyid')"><s:text name="countyid"/></j:orderByImg>                 
                </td>
                 <td>
                    <j:orderByImg href="javascript:doOrderby('boneobjtype')"><s:text name="boneobjtype"/></j:orderByImg>                 
                </td>
              
                <td>
                    <j:orderByImg href="javascript:doOrderby('bondtype')"><s:text name="bondtype"/></j:orderByImg>                 
                </td>
               
                <td>
                    <j:orderByImg href="javascript:doOrderby('principal')"><s:text name="principal"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('principaltel')"><s:text name="principaltel"/></j:orderByImg>                 
                </td>
                  <td>
                    <j:orderByImg href="javascript:doOrderby('state')"><s:text name="state"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('paymentmode')"><s:text name="paymentmode"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('payamt')"><s:text name="payamt"/></j:orderByImg>                 
                </td>
              <td>
                    <j:orderByImg href="javascript:doOrderby('payno')"><s:text name="payno"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('confirmtime')"><s:text name="confirmtime"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('receiptno')"><s:text name="receiptno"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('receiptamt')"><s:text name="receiptamt"/></j:orderByImg>                 
                </td>
                <td>
                    <j:orderByImg href="javascript:doOrderby('createtime')"><s:text name="createtime"/></j:orderByImg>                 
                </td>
                <td>
                   操作             
                </td>
               
            </tr>
            <s:iterator value="dp.datas">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <%-- 复合主键用“|”间隔开 --%>
                     <td>
                      <s:if test="state==0">
							<input type="checkbox" name="param._selectitem" value="<s:property value="formid"/>" onclick="checkOne();"/>			
					</s:if>		
                   <s:else>
                     <input type="checkbox" name="param._selectitem" value="<s:property value="formid"/>" disabled="true" >
                   </s:else>
                     
                         
                     </td>
                     <td>
                       <s:if test="state==0 || state==2">
							   <a href='<s:url action="bondform_edit.do">
	                         <s:param name="param._pk" value="formid"/>
	                     	</s:url>'>
							<s:property value="formid"/>
                         </a>										
					</s:if>		
                   <s:else>
                      <a href='javascript:alert("此订单不允许修改!");'>
							<s:property value="formid"/>
                         </a>
                   </s:else>
					 </td>
                     <td><s:property value="wayid" /></td>
                     <td><j:code2Name definition="#CNTYCOMPANY" code="countyid" /></td>
                     <td><j:code2Name code="boneobjtype" definition="$CH_BONEOBJTYPE" /></td>
                     <td><j:code2Name code="bondtype" definition="$CH_BONDTYPE" /></td>                     
                     <td><s:property value="principal" /></td>
                     <td><s:property value="principaltel" /></td>
                     <td><j:code2Name code="state" definition="$CH_BONDSTATE" /></td>
                     <td><j:code2Name code="paymentmode" definition="$CH_PAYMENTMODE" /></td>
                     <td><s:property value="payamt" /></td>
                     <td><s:property value="payno" /></td>
                     <td><s:date name="confirmtime" format="yyyy-MM-dd HH:mm:ss"/></td>
                     <td><s:property value="receiptno" /></td>
                     <td><s:property value="receiptamt" /></td>
                     <td><s:date name="createtime" format="yyyy-MM-dd HH:mm:ss"/></td>                    
                     
                     <td>                     
                     
                     <s:if test="state==0 || state==2">
							<input type="button" class="button_2" value="提交" onClick='getAuditingRoleList(<s:property value="formid" />);'/>										
					</s:if>					
                     <s:elseif test="state==6">
                    	 <s:if test="paymentmode != 'CHECK'"> 
								<input type="button" class="button_2"  onClick='mvaccount(<s:property value="formid" />);' value="划扣"/>										
						</s:if>	
					</s:elseif>
                     <s:elseif test="bondtype == 'PAYFORM'">
                     	<s:if test="paymentmode != 'CHECK'"> 
                     	   <s:if test="state == 3 || state == 4 || state == 5">                     	
								<input type="button" class="button_2" onClick='sendInfo(<s:property value="formid" />);' value="发送短信"/>										
							</s:if>					
						</s:if>					
					</s:elseif>
					
                     </td>
                 </tr>
             </s:iterator>
        </table>
        </div>
    </div>
    <div class="table_div">
		<%@ include file="/common/pageNav.jsp"%>
   	</div>
    </aa:zone>
</s:form>
</div>
</body>
</html>
<script language="javascript"> 
	ajaxAnywhere.getZonesToReload = function(url,submitButton) {
		return "errorZone,listZone,hiddenZone";  
	}
	ajaxAnywhere.substituteFormSubmitFunction();  
	ajaxAnywhere.formURL = formList.action;
	ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnQuery,btnDelete");
</script> 
