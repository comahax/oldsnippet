<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/inc/listhead.inc" %>

<link href="<%=contextPath%>/fee/billing/billstatus/list.css" rel="stylesheet" type="text/css" media="all" />

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
 			
    		parent.formList.action = contextPath + '/fee/billing/billstatus_showproc.do?' + '_PHASE=' + step + '&_REGIONGROUP=' + regiongroup + '&_VALIDBILLCYC=' + validbillcyc; 
    		parent.formList.submit(); 
    		
    		//window.parent.document.all.loadframe2.style.display="";    		
    		//window.parent.document.all.loadframe2.src = contextPath + '/fee/billing/billstatus_showlog.do?' + '_PHASE=' + step + '&_REGIONGROUP=' + regiongroup + '&_VALIDBILLCYC=' + validbillcyc;  
		}
		
		 function showAccBill(simple) {
        	var validbillcyc = document.getElementById('form._ne_validbillcyc').value;
 			var regiongroup = document.getElementById('form.regiongroup').value; 		
 			
        	if(validbillcyc == "" || regiongroup == ""){
        		alert("请先查询！");
        		return false;
        	}
 			
        	if('simple' == simple){
        		window.parent.document.all.loadframe2.style.display="";
    			window.parent.document.all.loadframe2.src = '<%= contextPath%>/fee/billing/rhtouchrule_simpleinfo1.do?_REGIONGROUP=' + regiongroup + '&_VALIDBILLCYC=' + validbillcyc;  
    			
    		}else{
    			formList.action="<%= contextPath%>/fee/billing/rhtouchrule_city.do";
        		formList.submit(); 
    		}	
            	
		}
		
		 function showAccBilling(step,simple,boolean) {
			var batchnum = '01';
			var validbillcyc = document.getElementById('form._ne_validbillcyc').value;
 			var regiongroup = document.getElementById('form.regiongroup').value;  			
 		
    		if (regiongroup != null && "" != regiongroup && validbillcyc != null && "" != validbillcyc
    				&& batchnum != null && "" != batchnum ){
    			// if('simple' == simple && boolean != 'false')
    			if('simple' == simple){
    			    //window.parent.document.getElementById("loadframe2").style.display = "";
    			    //window.parent.document.getElementById("loadframe2").location.href = '<%= contextPath%>/fee/billing/rhtouchrule_simpleinfo.do?_BATCHNUM=' + batchnum + '&_REGIONGROUP=' + regiongroup + '&_VALIDBILLCYC=' + validbillcyc + '&_STEP=' + step ;  
    				window.parent.document.all.loadframe2.style.display="";
    				window.parent.document.all.loadframe2.src = '<%= contextPath%>/fee/billing/rhtouchrule_simpleinfo.do?_BATCHNUM=' + batchnum + '&_REGIONGROUP=' + regiongroup + '&_VALIDBILLCYC=' + validbillcyc + '&_STEP=' + step ;  
    			}else{	
    				if(step == 106 || step == 50 || step == 80 || step == 75 
    					|| step == 102 || step == 103 || step == 104 || step == 105 ){
    					if(null != parent.document.formList.startupbt){  
			          		parent.document.formList.startupbt.disabled = false;
			          	}
    				}
    				var url = '<%= contextPath%>/fee/billing/rhtouchrule_accbillingdet.do?_BATCHNUM=' + batchnum + '&_REGIONGROUP=' + regiongroup + '&_VALIDBILLCYC=' + validbillcyc + '&_STEP=' + step ;   	    			
    				document.location.href = url;    
    			}			
    			
    		}  else{
    			alert("请先查询!");
    		}								
		}
		
		function forwdrh(){
			parent.formList.action = '<%= contextPath%>/fee/billing/billstatus_set.do'; 
    		parent.formList.submit(); 
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

<s:form action="/fee/billing/billstatus_show.do" key="formList" cssStyle="formList" theme="simple" method="post" onsubmit="return ev_check();">
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
	<s:hidden name="form._ne_validbillcyc"/>
    <s:hidden name="form.regiongroup"/>
    <s:hidden name="form.phase"/>
	
	<s:set value="#request.LIST" name="item"/>
	<s:set value="#request.ACCB" name="accb"/>
	<s:set value="#request.simple" name="simple"/>	
	<div style="padding:0 50px;">
	    <div style="position:relative;width:100%;"><img src="<%=contextPath%>/images/accounting/bgnew.gif" class="bga"/>
	    	<div class="table_div">
				<table class="error_text">
					<s:actionerror />		
					<s:actionmessage/>			
				</table>
			</div>
			<div style="cursor:hand;" class="weiqi1 mcolor3">清单累账</div> 
			<div style="cursor:hand;" onclick="showSubphase('B100,0')" class="weiqi2 mcolor${item[0]+0 }">月切</div>
			<div style="cursor:hand;" onclick="showSubphase('B101,0,1,2')" class="weiqi3 mcolor${item[1]+0 }">累账对账</div>
			<div style="cursor:hand;" onclick="showSubphase('B103,0,1,2')"  class="weiqi4 mcolor${item[2]+0 }">增量无主回捞</div>
			<div style="cursor:hand;" onclick="showSubphase('C101,0,1,2')"  class="weiqi5 mcolor${item[3]+0 }">账单优惠</div> 
			<div style="cursor:hand;" onclick="showSubphase('C102,0,1')"  class="weiqi6 mcolor${item[4]+0 }">月报表对账</div>
			<div style="cursor:hand;" onclick="showAccBilling('106','${simple }')"  class="weiqi7 mcolor${accb[2]+0 }">通信费核查确认</div>
			<div style="cursor:hand;" onclick="showSubphase('E100,0,1,2,3,4,5,6')"  class="weiqi15 mcolor${item[5]+0}">出账前导数</div>
			<div style="cursor:hand;" onclick="showSubphase('E101,0,1,2,3,4,5,6,7,8,9,10,11,12,13,14')"  class="weiqi8 mcolor${item[6]+0}">合账数据准备</div>
			
			<div style="cursor:hand;" onclick="showSubphase('A105,0,1,2,3,4,5')"  class="weiqi9 mcolor${item[7]+0 }">增量固定费计算</div>
			
			<div style="cursor:hand;" onclick="showAccBilling('50','${simple }')" class="weiqi10 mcolor${accb[1]+0}">固定费核查确认</div>
			
			<div style="cursor:hand;" onclick="showAccBilling('102','${simple }')"  class="weiqi11 mcolor${accb[3]+0}">用户出账</div> 
			<div style="cursor:hand;" onclick="showAccBilling('103','${simple }')"  class="weiqi12 mcolor${accb[4]+0 }">账户出账</div>
			<div style="cursor:hand;" onclick="showAccBilling('104','${simple }')"  class="weiqi13 mcolor${accb[5]+0 }">出账核查确认</div>
			<div style="cursor:hand;" onclick="showAccBilling('105','${simple }')"  class="weiqi14 mcolor${accb[6]+0}">销账信控</div>			
			
			<div style="cursor:hand;" onclick="showSubphase('Q101,0')"  class="weiqi16 mcolor${item[8]+0 }">积分计算</div>
			<div style="cursor:hand;" onclick="showSubphase('R101,0')"  class="weiqi17 mcolor${item[9]+0 }">积分入库</div>
		</div>
	</div>	
			
	
</s:form>
</body>
</html>





























