<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@ include file="/inc/listhead.inc" %>
<%--link href="<%=contextPath%>/css/css_1/rhrule.css" rel="stylesheet" type="text/css"/--%>
<link href="<%=contextPath%>/fee/billing/rhtouchrule/css/list.css" rel="stylesheet" type="text/css" media="all" />
<html xmlns="http://www.w3.org/1999/xhtml"-->
<head>
    <title><bean:message bundle="accounting" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
    
    	
    	//是否有权限标志
    	function isPurChk() {
    		var purchk = false;
	        <s:PurChk2 controlid="ACCOUNTING" disableChild="true">		    
	            purchk = true;     	
	        </s:PurChk2> 
            if(!purchk){
            	alter('您的工号没有权限操作！');
            	return false；
            }
        }
    	
        function ev_check() {
            return checkval(window);
        }
        
        function showAccBill(simple) {
        	var validbillcyc = document.formList._ne_validbillcyc.value	;		
 			var regiongroup = document.formList.regiongroup.value;
 			
        	if('simple' == simple){
    			document.all.loadframe1.src = contextPath + '/fee/billing/rhtouchrule.do?CMD=SIMPLEINFO1' + '&_REGIONGROUP=' + regiongroup + '&_VALIDBILLCYC=' + validbillcyc;  

    		}else{
    			formList.action="<%= contextPath%>/fee/billing/rhtouchrule.do?CMD=CITY";
        		formList.submit(); 
    		}	
            	
		}

        function showAccBilling(step,simple,boolean) {
			var batchnum = '01';
			var validbillcyc = document.formList._ne_validbillcyc.value	;		
 			var regiongroup = document.formList.regiongroup.value;
 			
    		if (regiongroup != null && "" != regiongroup && validbillcyc != null && "" != validbillcyc
    				&& batchnum != null && "" != batchnum ){
    			if('simple' == simple && boolean != 'false'){
    				document.all.loadframe1.src = contextPath + '/fee/billing/rhtouchrule_simpleinfo.do?_BATCHNUM=' + batchnum + '&_REGIONGROUP=' + regiongroup + '&_VALIDBILLCYC=' + validbillcyc + '&_STEP=' + step ;  

    			}else{	
    				if(step == 51 || step == 50 || step == 80 || step == 75 
    					|| step == 102 || step == 103 || step == 104 || step == 105 ){
    					if(null != parent.document.formList.startupbt){  
			          		parent.document.formList.startupbt.disabled = false;
			          	}
    				}
    				var url =  contextPath + '/fee/billing/rhtouchrule.do?_BATCHNUM=' + batchnum + '&_REGIONGROUP=' + regiongroup + '&_VALIDBILLCYC=' + validbillcyc + '&_STEP=' + step ;   	    			
    				document.location.href = url;    
    			}			
    			
    		}  else{
    			alert("请先查询!");
    		}								
		}
		
		function reloadiframe(chlidhigh) {
			if (document.all("loadframe1") != null) {
				document.all("loadframe1").style.posHeight = chlidhigh;
			}
			if (parent.document.all("loadframe1") != null) {	
				parent.document.all("loadframe1").style.posHeight = document.body.scrollHeight + chlidhigh;	
			}
		}
		function autoRefresh(){
        	var validbillcyc = formList._ne_validbillcyc.value;
	        var regiongroup = formList.regiongroup.value
        	if(validbillcyc != "" && regiongroup != ""){
        		formList.submit();
        	}
    	}						
		setInterval("autoRefresh()",1000*60*1);
	
    </script>

</head>

<body onload="loadforiframe1();">

<html:form action="/fee/billing/rhtouchrule.do?CMD=SHOW" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    
	<html:hidden property="_ne_validbillcyc"/>
    <html:hidden property="regiongroup"/>

	

	

	<c:set var="item1" scope="request" value="${requestScope.LIST}" />	
	<c:set var="item2" scope="request" value="${requestScope.ACCB_LIST}" />	
	
	<div class="accbllbg">
	    <div class="bg_1 ">
	    	<div class="table_div">
				<table class="error_text">
				
					<html:errors />
					<s:Msg />
				</table>
			</div>
			
			<div class="k1 mcolor3">计 费</div>
			<div style="cursor:hand;" onclick="showAccBill('<c:out value="${simple}"/>')" class="k2 kcolor<c:out value="${item1[0] + 0}"/>">分 流</div>
			<div style="cursor:hand;" onclick="showAccBill('<c:out value="${simple}"/>')" class="k5 kcolor<c:out value="${item1[1] + 0}"/>">累帐解析</div>
			<div style="cursor:hand;" onclick="showAccBill('<c:out value="${simple}"/>')" class="k7 kcolor<c:out value="${item1[2] + 0}"/>">实时累帐</div>
			
			<div style="cursor:hand;" onclick="showAccBilling('fullist','<c:out value="${simple}"/>','false')" class="L1 mcolor3">营 帐</div>			
			
			<div style="cursor:hand;" onclick="showAccBilling('101','<c:out value="${simple}"/>')" class="L4 mcolor<c:out value="${item2[0] + 0}"/>">全球通固定费</div>
			<div style="cursor:hand;" onclick="showAccBilling('102','<c:out value="${simple}"/>')" class="L2 mcolor<c:out value="${item2[3] + 0}"/>">用户出账</div>
			<div style="cursor:hand;" onclick="showAccBilling('103','<c:out value="${simple}"/>')" class="L6 mcolor<c:out value="${item2[4] + 0}"/>">帐户出帐</div>
			<div style="cursor:hand;" onclick="showAccBilling('104','<c:out value="${simple}"/>')" class="L5 mcolor<c:out value="${item2[5] + 0}"/>">出帐确认</div>
			<div style="cursor:hand;" onclick="showAccBilling('105','<c:out value="${simple}"/>')" class="L7 mcolor<c:out value="${item2[6] + 0}"/>">销帐信控</div>
			
			<div style="cursor:hand;" onclick="showAccBilling('80','<c:out value="${simple}"/>')" class="L3 mcolor<c:out value="${item2[7] + 0}"/>">账单优惠</div>
			<div style="cursor:hand;" onclick="showAccBilling('75','<c:out value="${simple}"/>')" class="L9 mcolor<c:out value="${item2[8] + 0}"/>">无主回捞</div>
			<div style="cursor:hand;" onclick="showAccBilling('1010','<c:out value="${simple}"/>')" class="L8 mcolor<c:out value="${item2[9] + 0}"/>">预付费固定费</div>
			<div style="cursor:hand;" onclick="showAccBilling('50','<c:out value="${simple}"/>')" class="L10 mcolor<c:out value="${item2[1] + 0}"/>">固定费确认</div>
			<div style="cursor:hand;" onclick="showAccBilling('51','<c:out value="${simple}"/>')" class="L11 mcolor<c:out value="${item2[2] + 0}"/>">预处理确认</div>
			
				<!--<div class="s1 sqd1" onclick="doBatchStartUp('NUL','无主回捞')" onmouseover="this.className='s1 sqd2'" onmouseout="this.className='s1 sqd1'" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>&nbsp;</div>
				<div class="s2 sqd1" onclick="doBatchStartUp('RED','优惠处理')" onmouseover="this.className='s2 sqd2'" onmouseout="this.className='s2 sqd1'" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>&nbsp;</div>
				
				<div class="s3 sqd1" onclick="doBatchStartUp('USR','用户出账')" onmouseover="this.className='s3 sqd2'" onmouseout="this.className='s3 sqd1'" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>&nbsp;</div>
				<div class="s4 sqd1" onclick="doBatchStartUp('ACC','帐户出账')" onmouseover="this.className='s4 sqd2'" onmouseout="this.className='s4 sqd1'" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>&nbsp;</div>				
				<div class="s5 sqd1" onclick="doBatchStartUp('CFM','出账确认')" onmouseover="this.className='s5 sqd2'" onmouseout="this.className='s5 sqd1'" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>&nbsp;</div>
				<div class="s6 sqd1" onclick="doBatchStartUp('WOF','销账信控')" onmouseover="this.className='s6 sqd2'" onmouseout="this.className='s6 sqd1'" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>&nbsp;</div>	
				-->
			</div>
	</div>
		
</html:form>
<div>
<iframe  frameborder="0" class="loadframe" style="height:100px;" id="loadframe1" scrolling="no" src=""/>
</div>

<script type="text/javascript">
	
</script>
</body>
</html>





























