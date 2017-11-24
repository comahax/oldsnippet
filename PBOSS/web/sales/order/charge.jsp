<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A6FBT14" />
</jsp:include>
<html>
<head>
    <title><s:text name="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
        /*
            addfield('form.orderid', '<s:text name="orderid"/>', 'c', false, 18);
			addfield('form.flowid', '<s:text name="flowid"/>', 'f', true, 14);
			addfield('form.wayid', '<s:text name="wayid"/>', 'c', true, 18);
			addfield('form.countyid', '<s:text name="countyid"/>', 'c', true, 18);
			addfield('form.cooptype', '<s:text name="cooptype"/>', 'c', true, 16);
			addfield('form.starlevel', '<s:text name="starlevel"/>', 'f', true, 2);
			addfield('form.orderave', '<s:text name="orderave"/>', 'c', true, 16);
			addfield('form.storarea', '<s:text name="storarea"/>', 'c', true, 16);
			addfield('form.createtime', '<s:text name="createtime"/>', 't', true, 7);
			addfield('form.orderstate', '<s:text name="orderstate"/>', 'c', true, 16);
			addfield('form.statechgtime', '<s:text name="statechgtime"/>', 't', true, 7);
			
			addfield('form.delitype', '<s:text name="delitype"/>', 'c', true, 16);
			addfield('form.recamt', '<s:text name="recamt"/>', 'f', true, 16);
			addfield('form.actamt', '<s:text name="actamt"/>', 'f', true, 16);
			addfield('form.posstream', '<s:text name="posstream"/>', 'c', true, 32);
			addfield('form.bossworkfid', '<s:text name="bossworkfid"/>', 'c', true, 32);
			addfield('form.memo', '<s:text name="memo"/>', 'c', true, 256);
			*/
			
			var paytype = document.getElementById('form.paytype').value;
			if("POS" == paytype){
				addfield('form.posstream', '<s:text name="posstream"/>', 'c', false, 20);
			}
			addfield('form.paytype', '<s:text name="paytype"/>', 'c', false, 16);
			
			addfield('form.actamt', '<s:text name="actamt"/>', 'f', false, 10,2);
            if(checkval(window)){
            disabledAllButton();
            return true;
            }
            return false;
        }
        
        //是否显示POS机流水号
        function showFlowid(payType){
        	if('POS' == payType){
        		document.getElementById('posstream').style.display="";
        	}else{
        		document.getElementById('posstream').style.display="none";
        	}
        }
        
        function showSaveBut(orderState){
        	if('CHARGED' == orderState){
        		document.getElementById('btnSave').disabled="";
        	}else{
        	document.getElementById('btnSave').disabled="none";
        	}
        }
        
        function showNextBut(orderState){
        	if('CHARGED' == orderState){
        		document.getElementById('btnNext').disabled="";
        	}else{
        	document.getElementById('btnNext').disabled="none";
        	}
        }
        
        function disabledAllButton(){
        	document.getElementById('btnNext').disabled="none";
        	document.getElementById('btnSave').disabled="none";
        	document.getElementById('btnReturn').disabled="none";
        }
        
        function doNext(actionUrl){
        	var orderid = document.getElementById('form.orderid').value;
        	$.post("<%=contextPath%>"+actionUrl,
	        {'form.orderid':orderid},
			     function(data){
			     var result = data.split(',');
			     if('0' == result[0]){
			     window.location.href ="<%=contextPath%>"+result[1]+"?param._pk="+orderid+"&param._se_orderid="+orderid;
			     	//window.open(result[1]+"?param._pk="+orderid+"&param._se_orderid="+orderid);
			     }else{
				     var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>'+result[1]+'</span> ';
					errorMessageShow(alertstr);
			     }
			       
			     }   
	        ); 
        }

    </script>
</head>
<body>
<div class="table_container">
<s:form action="order_save.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">
			
    <s:hidden name="CMD"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param._se_orderid"/>
    <s:hidden name="param._se_wayid"/>
    <s:hidden name="param._se_orderave"/>
    <s:hidden name="param._dnm_createtime"/>
    <s:hidden name="param._dnl_createtime"/>
    <s:hidden name="param._se_orderstate"/>
    <s:hidden name="param._pk"/>
	
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="sales"/> </span>
			<span class="table_toparea_xi">></span>
			</s:i18n>
			<span class="table_toparea"><s:text name="titleList"/></span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea_h">订单收费</span>
			<span class="button_Help" onclick="openword('<s:text name="helpTitle"/>','<s:text name="helpContent"/>')"><s:i18n name="public"><s:text name="help"/></s:i18n></span>
		</div>
	</div>

	<div class="error_text" >
		<table class="error_text">
			<s:actionerror /><s:actionmessage/>
		</table>
	</div>
	
    <div class="table_div">
        <table class="table_normal">
        <s:hidden name="form.orderid"/>
        <s:hidden name="form.flowid"/>
        <s:hidden name="form.orderstate"/>
         <s:hidden name="form.delitype"/>
         <s:hidden name="form.Signstate"/>
             
            <tr>
            	<td align="right"><s:text name="orderid"/>:&nbsp</td>
                <td align="left">
						<s:property value="form.orderid"/>				
                </td>
                <td align="right"><s:text name="createtime"/>:&nbsp</td>
                <td align="left">
						<s:date name="form.createtime" format="yyyy-MM-dd"/>
                </td>
                <td align="right"><s:text name="orderstate"/>:&nbsp</td>
                <td align="left">
						<j:code2Name definition="$FX_ORDERFSTATE" code="form.orderstate"/>
                </td>
             </tr>
             <tr> 
                 <td align="right"><s:text name="wayid"/>:&nbsp</td>
                <td align="left">
						<s:property value="form.wayid"/>
                </td>
                 <td align="right">合作商名称:&nbsp</td>
                <td align="left">
						<j:code2Name definition="#WAYIDINFO" code="form.wayid"/>
                </td>
                
                <td align="right"><s:text name="orderave"/>:&nbsp</td>
                <td align="left">
						<j:code2Name definition="$FX_ORDERAVE" code="form.orderave"/>
                </td> 
            </tr>
            <tr>
            	<td align="right"><s:text name="countyid"/>:&nbsp</td>
                <td align="left">
						<j:code2Name definition="#CNTYCOMPANY" code="form.countyid"/>
                </td>
                <td align="right"><s:text name="cooptype"/>:&nbsp</td>
                <td align="left">
						<s:property value="form.custwaytypename" />
                </td>
                <td align="right"><s:text name="starlevel"/>:&nbsp</td>
                <td align="left">
						<j:code2Name definition="$CH_STARLEVEL" code="form.starlevel"/>
                </td>
            </tr>
            <tr>
            	<td align="right"><s:text name="paytype"/>:&nbsp</td>
                <td align="left">
						<j:code2Name definition="$FX_PAYTYPE" code="form.paytype" />
                </td>
                <td align="right"><s:text name="delitype"/>:&nbsp</td>
                <td align="left">
						<j:code2Name definition="$FX_DELITYPE" code="form.delitype"/>
                </td>
                <td align="right"><s:text name="posstream"/>:&nbsp</td>
                <td align="left">
						<s:property value="form.posstream"/>
                </td> 
            </tr>
            <tr>
            	 <td align="right"><s:text name="bossworkfid"/>:&nbsp</td>
                <td align="left">
						<s:property value="form.bossworkfid"/>
                </td>
            	 <td align="right"><s:text name="recamt"/>:&nbsp</td>
                <td align="left">
						<s:property value="form.recamt"/>
                </td>
                <td align="right"><s:text name="actamt"/>:&nbsp</td>
                <td align="left">
						<s:property value="form.actamt"/>
                </td>
            </tr>
           
            <tr>
                <td align="right"><s:text name="paytime"/>:&nbsp</td>
                <td align="left">
					<s:date name="form.paytime" format="yyyy-MM-dd HH:mm:ss"/>
                </td>
                <td align="right"><s:text name="deductstate"/>:&nbsp</td>
                <td align="left">
					<j:code2Name definition="$FX_DEDUCTSTATE" code="form.deductstate"/>
                </td>
                <td align="right"><s:text name="discomcode"/>:&nbsp</td>
                <td align="left">
					<j:code2Name definition="#WAYIDINFO" code="form.discomcode"/>
                </td>
              </tr>
              
               <tr>
               <td align="right"><s:text name="signstate"/>:&nbsp</td>
                <td align="left" >
               	 <j:code2Name definition="$FX_SIGNSTATE" code="form.signstate"/>
                </td>
               <td align="right"><s:text name="orderinfo"/>:&nbsp</td>
                <td align="left" colspan="3">
						<s:property value="form.orderInfo"/>
                </td>
                
            </tr>
              <tr>
                <td align="right"><s:text name="memo"/>:&nbsp</td>
                <td align="left" colspan="5">
						<s:property value="form.memo"/>
                </td>
            </tr>
        </table>
    </div>

	<div class="table_div">
        <table class="table_normal">
        	<tr style="line-height:20px;">
        		<td align="right"><s:text name="paytype"/>:&nbsp</td>
        		<td>
						<j:selector definition="$FX_PAYTYPE" name="form.paytype" onchange="showFlowid(this.value);" disabled="true"/>
					<span id="posstream" style="display:none">
						<s:text name="posstream"/>:&nbsp              
						<s:textfield name="form.posstream"/>	
					</span>					
                </td>
        	</tr>
        	<tr>
        		<td align="right"><s:text name="actamt" />:&nbsp</td>
                <td align="left">
					<s:textfield name="form.actamt" value="%{form.recamt }"/>
                </td>
        	</tr>
        </table>
    </div>
    <div class="table_div">
        <table class="table_button_list">
            <tr>
                <td width="100%" align="center">
                   	<s:i18n name="public">
                    <input type="button" id="btnSave" name="btnSave" class="button_4" onmouseover="buttonover(this);" 
                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="确认收费" onclick="doSave('/sales/order_charge.do');"
                           <s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if>
                           />
                           
                           <input type="button" id="btnNext" name="btnNext" class="button_4" onmouseover="buttonover(this);" 
                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="下一步处理" onclick="doNext('/sales/order_nextProcess.do')"
                           />
                           
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturnInFrame('/sales/order_list.do?backFlag=true');">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
</body>
</html>
<script type="text/javascript">
<!--
showSaveBut('<s:property value="form.flowOutstate"/>');
showNextBut('<s:property value="form.orderstate"/>');
showFlowid('<s:property value="form.paytype"/>');
//-->
</script>
