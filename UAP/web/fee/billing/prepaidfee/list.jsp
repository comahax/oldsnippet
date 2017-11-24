<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/inc/listhead.inc" %>

<link href="<%=contextPath%>/fee/billing/prepaidfee/list.css" rel="stylesheet" type="text/css" media="all" />

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <title><s:text name ="titleList" /></title>
    <script language="JavaScript" type="text/JavaScript"> 
    	
        function ev_check() {
            return checkval(window);
        }
        
        function showSubphase(step) { 
        	var validbillcyc = document.getElementById('form._ne_validbillcyc').value;
 			var regiongroup = document.getElementById('form.regiongroup').value; 		
        	if(validbillcyc == "" || regiongroup == ""){
        		alert("请先查询！");
        		return false;
        	}
 			document.getElementById("form.phase").value = step;  	
    		parent.formList.action = contextPath + '/fee/billing/billstatus_ShowprocFee.do?' + '_PHASE=' + step + '&_REGIONGROUP=' + regiongroup + '&_VALIDBILLCYC=' + validbillcyc; 
    		parent.formList.submit(); 
		}
        
        
        function showAccBilling(step,status) {
			var batchnum = '01';
			var validbillcyc = document.getElementById('form._ne_validbillcyc').value;
 			var regiongroup = document.getElementById('form.regiongroup').value;  			
    		if (regiongroup != null && "" != regiongroup && validbillcyc != null && "" != validbillcyc && batchnum != null && "" != batchnum ){
    			window.parent.document.all.loadframe2.style.display="";
    			window.parent.document.all.loadframe2.src = '<%= contextPath%>/fee/billing/rhtouchrule_BillinglogList.do?_BATCHNUM=' + batchnum + '&_REGIONGROUP=' + regiongroup + '&_VALIDBILLCYC=' + validbillcyc + '&_STEP=' + step+'&_STATUS='+ status;  
    		}else{
    			alert("请先查询!");
    		}								
		}
		
		
		function autoRefresh(){
        	var validbillcyc = document.getElementById('form._ne_validbillcyc').value;
 			var regiongroup = document.getElementById('form.regiongroup').value; 	
        	if(validbillcyc != "" && regiongroup != ""){
        		formList.submit();
        	}
    	}						
		setInterval("autoRefresh()",1000*60*1);
	
    </script>

</head>

<body onload="loadforiframe1();">

<s:form action="/fee/billing/billstatus_ShowPrepaidFee.do" key="formList" cssStyle="formList" theme="simple" method="post" onsubmit="return ev_check();">
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
	<s:hidden name="form._ne_validbillcyc"/>
    <s:hidden name="form.regiongroup"/>
    <s:hidden name="form.phase"/>
	
	<s:set value="#request.LIST" name="item"/>
	<div style="padding:0 50px;">
	    <div style="position:relative;width:100%;"><img src="<%=contextPath%>/images/accounting/bgnew2.gif" class="bga"/>
	    	<div class="table_div">
				<table class="error_text">
					<s:actionerror />		
					<s:actionmessage/>			
				</table>
			</div>
			<div style="cursor:hand;" class="weiqi1 mcolor3">清单累账</div> 
			<div style="cursor:hand;" onclick="showSubphase('B100,0')" class="weiqi2 mcolor${item[0]+0 }">月切</div>
			<div style="cursor:hand;" onclick="showSubphase('B101,0,1,2')" class="weiqi3 mcolor${item[1]+0 }">累账对账</div>
			<div style="cursor:hand;" onclick="showSubphase('B103,0,1,2')"  class="weiqi4 mcolor${item[2]+0 }">无主回捞</div>
			<div style="cursor:hand;" onclick="showSubphase('C100,0')"  class="weiqi5 mcolor${item[3]+0 }">账单优惠</div>
			<div style="cursor:hand;" onclick="showSubphase('E102,0,1,2,3')"  class="weiqi6 mcolor${item[4]+0 }">合账数据准备</div>
			<div style="cursor:hand;" onclick="showSubphase('A100,0')"  class="weiqi7 mcolor${item[5]+0 }">固定费生成</div>
			<div style="cursor:hand;" onclick="showSubphase('G100,0')"  class="weiqi8 mcolor${item[6]+0 }">低消计算</div>
			<div style="cursor:hand;" onclick="showAccBilling('H100',${item[6]+0})"  class="weiqi9 mcolor${item[7]+0 }">低消确认</div>
			<div style="cursor:hand;" onclick="showSubphase('I100,0')"  class="weiqi10 mcolor${item[8]+0 }">低消入ABM库</div>
		</div>
	</div>	
</s:form>
</body>
</html>





























