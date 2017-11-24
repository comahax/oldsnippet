<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@ include file="/inc/listhead.inc" %>

<link href="<%=contextPath%>/fee/billing/billstatus/list.css" rel="stylesheet" type="text/css" media="all" />
<link href="<%=contextPath%>/fee/billing/rhtouchrule/css/list.css" rel="stylesheet" type="text/css" media="all" />

<%
  Object s=request.getAttribute("_REGIONGROUP");
%>
<html xmlns="http://www.w3.org/1999/xhtml"-->


<head>
    <title><s:text name ="titleList" /></title>
    <script language="JavaScript" type="text/JavaScript"> 
    	
        function ev_check() {
            return checkval(window);
        }
        
        function showSubphase(step) { 
        	
        	if(formList._ne_validbillcyc.value == "" || formList.regiongroup.value == ""){
        		alert("请先查询！");
        		return false;
        	}
        	var validbillcyc = document.formList._ne_validbillcyc.value;
 			var regiongroup = document.formList.regiongroup.value;
 			document.formList.phase.value = step;
    		parent.formList.action = contextPath + '/fee/billing/billstatus_showproc.do?' + '_PHASE=' + step + '&_REGIONGROUP=' + regiongroup + '&_VALIDBILLCYC=' + validbillcyc; 
    		parent.formList.submit(); 
		}
		
		function forwdrh(){
			parent.formList.action = contextPath + '/fee/billing/billstatus_set.do'; 
    		parent.formList.submit(); 
		}

		
		function autoRefresh(){
        	var validbillcyc = formList._ne_validbillcyc.value;
	        var regiongroup = formList.regiongroup.value;
        	if(validbillcyc != "" && regiongroup != ""){
        		formList.submit();
        	}
    	}						
		setInterval("autoRefresh()",1000*60*1);
		
		function isdisabled(){
		   
           var a= '<%=s%>';
           
           if(a == "SZ,"){
              sz.disabled = false;
           }
		}
	
    </script>

</head>

<body onload="loadforiframe1();isdisabled();">

<s:form action="/fee/billing/billstatus_show.do" key="formList" cssStyle="formList" theme="simple" method="post" onsubmit="return ev_check();">
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
	<s:hidden name="_ne_validbillcyc" value="20130500"/>
    <s:hidden name="regiongroup" value="DB_COMMON"/>
    <s:hidden name="phase"/>

	
	<s:iterator value="LIST" />
	<div class="accbllbg">
	    <div style="position:relative;width:100%;overflow-x:scroll;"><img src="<%= contextPath %>/images/accounting/bga.GIF" class="bga"/>
	    	<div class="table_div">
				<table class="error_text">
					<s:actionerror />
				</table>
			</div>
			<div class="weiq mcolor3">固定费出帐</div> <!-- <c:out value="${item[0] + 0}"/>  <c:out value="${item[2] + 0}"/>  <c:out value="${item[10] + 0}"/> <c:out value="${item[1] + 0}"/>  <c:out value="${item[3] + 0}-->
			<div style="cursor:hand;" onclick="showSubphase('A101,0,1,2')"  class="weiq1 mcolor${requestScope.LIST[0]+ 0 }">预出固定费</div>
			<div style="cursor:hand;" onclick="showSubphase('A103,0,1,2,3,4')"  class="weiq2 mcolor${requestScope.LIST[2]+ 0 }">全量固定费</div>
			<div id="sz"  disabled = true style="cursor:hand;" onclick="showSubphase('A106,0,1,2,3,4')"  class="weiq5 mcolor${requestScope.LIST[10]+ 0 }">月中预出</div>
			<div style="cursor:hand;" onclick="showSubphase('A102,0,1,2,3,4')"  class="weiq3 mcolor${requestScope.LIST[1]+ 0 }">预跑固定费</div>
			<div style="cursor:hand;" onclick="showSubphase('A104,0,1,2,3,4,5')"  class="weiq4 mcolor${requestScope.LIST[3]+ 0 }">增量固定费</div>
			
			<div class="chucuo mcolor3">通信费出帐</div>
			<div class="chucuoa mcolor3">合帐前检查</div>
			<div class="keqi mcolor${requestScope._YUEQIE + 0}">月切</div>
			<div style="cursor:hand;" onclick="showSubphase('B101,0,1,2')"  class="keqiw mcolor${requestScope.LIST[4] + 0}/>">融合累帐系统</div>
			<!--<div style="cursor:hand;" onclick="showSubphase('C101,0')"  class="yiwc mcolor<c:out value="${item[5] + 0}"/>">优惠资料上传</div>
			-->
			<div style="cursor:hand;" onclick="showSubphase('E101,0,1,2')"  class="keqi1 mcolor${requestScope.LIST[8] + 0}">全量无主回捞</div>
			<div style="cursor:hand;" onclick="showSubphase('F101,0,1,2,3,4,5')"  class="keqi2 mcolor${requestScope.LIST[9] + 0}">出帐数据准备</div>
			<div style="cursor:hand;" onclick="showSubphase('G101,0')"  class="qid mcolor${requestScope.LIST[7] + 0}">帐单对帐</div>
			<div style="cursor:hand;" onclick="showSubphase('D101,0,1,2,3')"  class="qid1 mcolor${requestScope.LIST[6] + 0}">优惠处理</div>
			<div style="cursor:hand;" onclick="forwdrh()"  class="keqi4 mcolor${requestScope._CONFIRMBILL + 0}">区域出帐</div>
		</div>
	</div>

</s:form>
</body>
</html>





























