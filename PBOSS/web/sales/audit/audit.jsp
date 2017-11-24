<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>

<html>
<head>
<%
String seqid = request.getParameter("seqid");
 %>
    <title><s:text name="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('param._ne_seqid', '<s:text name="seqid"/>', 'f', true, '14');
            addfield('param._se_presenter', '<s:text name="presenter"/>', 'c', true, '16');
            addfield('param._se_auditor', '<s:text name="auditor"/>', 'c', true, '16');
            addfield('param._se_orderid', '<s:text name="orderid"/>', 'c', true, '18');
            addfield('param._se_state', '<s:text name="state"/>', 'c', true, '32');
            return checkval(window);
        }
         function confirm(){
        	var state=$(":radio[name='state']:checked").val();
        	var opinion=$(":textarea[name='opinion']").val();
        	var seqid=<%=seqid%>
        	if(state==undefined){
        		alert("请选择批示!");
        		return;
        	}
        	if(state==2){
        		if(opinion==''){
        			alert("请填写审核意见!");
        			return;
        		}
        	}
        	//window.returnValue=state+","+opinion;
        	//window.close();
        	formList.action="<%=contextPath%>/sales/audit_audit.do?seqid="+seqid+"&state="+state+"&opinion="+opinion;
	    	formList.submit();
        }
    </script>
</head>

<body class="list_body">
<div class="table_container">
<s:form action="audit_showAuditPage.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">
	<%//下面的控件给Action提供数据，用来分页%>
	<aa:zone name="hiddenZone">
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param.queryAll"/>
    <input type="hidden" name="_rowcount" value="<s:property value="dp.rowCount" />"/>
	</aa:zone>
    <input type="hidden"  name="seqid" value="<%=seqid %>" />
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="sales"/> </span>
			<span class="table_toparea_xi">></span>
			</s:i18n>
			<span class="table_toparea_h">订单多级审核</span>
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
    	<div class="table_LongTable">
        <table class="table_style">
            <tr class="table_style_head">
                <td>
                   <s:text name="countyid"/>                
                </td>
                <td>
                    <s:text name="svccode"/>                 
                </td>
                  <td>
                    <s:text name="ordercomtype"/>                
                </td>
                <td>
                    <s:text name="comcategory"/>              
                </td>
                <td>
                    可售库存(套/张)                 
                </td>
                <td>
                    可分配库存(套/张)                 
                </td>
                <td>
                    分配量(套/张)                 
                </td>
            </tr>
            <s:iterator value="form.stockInfoList">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
                     <td>
							<j:code2Name definition="#CNTYCOMPANY" code="countyid"/>
					 </td>
                     <td><j:code2Name definition="#SERVCENT" code="svccode"/></td>
                     <td><j:code2Name definition="$FX_ORDERCOMTYPE" code="ordercomtype"/></td>
                     <td><j:code2Name definition="$IM_FXCOMCATEGORY" code="comcategory"/></td>
                     <td><s:property value="stocks" /></td>
                     <td><s:property value="assignStocks" /></td>
                     <td><s:property value="orderamt" /></td>
                 </tr>
             </s:iterator>
        </table>
        </div>
    </div>
    
    <aa:zone name="listZone">
    <div class="table_div">
    	<div class="table_LongTable">
        <table class="table_style">
            <tr class="table_style_head">
                <td><s:text name="orderid"/></td>
                <td>合作商名称</td>
                <td><s:text name="countyid"/></td>
                <td><s:text name="svccode"/></td>
                <td><s:text name="_se_mareacode"/></td>
                <td><s:text name="orderinfo"/></td>
            </tr>
            <s:iterator value="dp.datas">
            	<tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					 <td><s:property value="orderid"/></td>
                     <td><j:code2Name definition="#WAYIDINFO" code="wayid"/></td>
                     <td><j:code2Name definition="#CNTYCOMPANY" code="countyid"/></td>
                     <td><j:code2Name definition="#SERVCENT" code="svccode"/></td>
                     <td><j:code2Name definition="#MICROAREA" code="mareacode"/></td>
                     <td><s:property value="orderInfo"/></td>
                 </tr>
             </s:iterator>
        </table>
        </div>
    </div>
    <div class="table_div">
		<%@ include file="/common/pageNav.jsp"%>
   	</div>
   	</aa:zone>

	<div class="table_div">
        <table class="table_normal">
        	<tr>
        		<td align="right"><s:text name="presenter"/>:&nbsp</td>
		        <td align="left">
					<s:property value="form.presenter"/>
		        </td>
		        <td align="right"><s:text name="smsntime"/>:&nbsp</td>
		        <td align="left">
					<s:date name="form.smsntime" format="yyyy-MM-dd HH:mm:ss"/>
		        </td>
		    </tr>
		    <tr>
		        <td align="right"><s:text name="state"/>:&nbsp</td>
		        <td align="left">
					<j:code2Name definition="$CH_AUDITSTATE" code="form.state"/>
		        </td>
		        <td align="right"><s:text name="memo"/>:&nbsp</td>
		        <td align="left">
					<s:property value="form.memo"/>
		        </td>
		    </tr>
            <tr>
                <td align="right">批示:&nbsp</td>
                <td align="left">
                   	 <input type="radio" name="state" value="1" class="table_radio">通过 &nbsp;
                 	 <input type="radio" name="state" value="2" class="table_radio">不通过
                </td>
                <td align="right">审批意见:&nbsp</td>
                <td align="left">
                    <textarea class="form_textarea_on_4" name="opinion"></textarea>&nbsp<font color=red>*</font>
                </td>
            </tr>
        </table>
    </div>
    
    <div class="table_div">
		<table class="table_button_list">
			<tr>
				<td>
                	<s:i18n name="public">
                	<input type="button" id="btnconfirm"" name="btnconfirm"" class="button_2" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<s:text name="button_confirm"/>" onClick="confirm();" <s:if test="form.buttonflag == 'disable'" >disabled = "true"</s:if>>
                	
                    <input type="button" id="btnReturn" name="btnReturn" class="button_2" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/sales/audit_list.do?backFlag=true')">
                   </s:i18n>
				</td>
			</tr>
		</table>
	</div>

	
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
