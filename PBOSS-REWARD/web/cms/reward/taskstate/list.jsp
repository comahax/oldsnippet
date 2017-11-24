<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<%--link href="<%=contextPath%>/css/css_1/rhrule.css" rel="stylesheet" type="text/css"/--%>
<link href="<%=contextPath%>/cms/reward/taskstate/list.css" rel="stylesheet" type="text/css" media="all" />
<html xmlns="http://www.w3.org/1999/xhtml"-->
<head>
    <title><bean:message bundle="accounting" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
    
    	
    	
        function ev_check() {
            return checkval(window);
        }
        
        function showSubphase(step) { 
        //alert("先查询！");
        	if(formList._se_rewardmonth.value == "" || formList._se_cityid.value == ""){
        		alert("请先查询！");
        		return false;
        	}
        	var rewardmonth = document.formList._se_rewardmonth.value;
 			var cityid = document.formList._se_cityid.value;
    		parent.formList.action = contextPath + '/cms/reward/taskstate.do?CMD=SHOWPROC' + '&_TASKID=' + step + '&_CITYID=' + cityid + '&_REWARDMONTH=' + rewardmonth; 
    		parent.formList.submit(); 
    		//alert("请后查询！");
		}
		
		
		
	
    </script>

</head>

<body onload="loadforiframe1();">

<html:form action="/cms/reward/taskstate.do?CMD=SHOW" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
	<html:hidden property="_se_rewardmonth"/>
    <html:hidden property="_se_cityid"/>
    <html:hidden property="cityid"/>
    <html:hidden property="taskid"/>
      <html:hidden property="year"/>
        <html:hidden property="month"/>
	<c:set var="item" scope="request" value="${requestScope.LIST}" />	
	
	    <div class="bga">
	    <div class="table_div">
				<table class="error_text">
					<html:errors />
					<s:Msg />
				</table>
			</div>
			<div style="cursor:hand;" onclick="showSubphase('900000,900002')" class="weiq mcolor<c:out value="${item[0] + 0}"/>">社会渠道酬金</div>
			<div style="cursor:hand;" onclick="showSubphase('900002,910002,53,51,91')"  class="weiq1 mcolor<c:out value="${item[4] + 0}"/>">出酬时数据<br>清理采集</div>
			<div style="cursor:hand;" onclick="showSubphase('900002,260')"  class="weiq2 mcolor<c:out value="${item[6] + 0}"/>">待校验</div>
			<div style="cursor:hand;" onclick="showSubphase('900002,910003')"  class="weiq3 mcolor<c:out value="${item[5] + 0}"/>">业务数据采<br>集清洗校验</div>
			<div style="cursor:hand;" onclick="showSubphase('900002,240')"  class="weiq4 mcolor<c:out value="${item[8] + 0}"/>">入库</div>
			<div style="cursor:hand;" onclick="showSubphase('900000,900001')"  class="weiq5 mcolor<c:out value="${item[1] + 0}"/>">月初数据<br>备份采集</div>
			<div style="cursor:hand;" onclick="showSubphase('900001,910001,53,52,90')"  class="weiq6 mcolor<c:out value="${item[3] + 0}"/>">月初文件<br>备份采集</div>
			<div style="cursor:hand;" onclick="showSubphase('900001,50')"  class="weiq7 mcolor<c:out value="${item[2] + 0}"/>">备份上月<br>渠道信息</div>
			<div style="cursor:hand;" onclick="showSubphase('900002,250')"  class="weiq8 mcolor<c:out value="${item[7] + 0}"/>">文件生成</div>
			<div style="cursor:hand;" onclick="showSubphase('900002,270')"  class="weiq9 mcolor<c:out value="${item[9] + 0}"/>">二次校验</div>
			<div style="cursor:hand;" onclick="showSubphase('900002,604')"  class="weiq10 mcolor<c:out value="${item[12] + 0}"/>">合作年限<br>奖金计算</div>
			<div style="cursor:hand;" onclick="showSubphase('900002,601')"  class="weiq11 mcolor<c:out value="${item[10] + 0}"/>">计件酬金计算</div>
			<div style="cursor:hand;" onclick="showSubphase('900002,602')"  class="weiq12 mcolor<c:out value="${item[11] + 0}"/>">星级酬金计算</div>
			<div style="cursor:hand;" onclick="showSubphase('900002,606')"  class="weiq13 mcolor<c:out value="${item[13] + 0}"/>">酬金调整</div>
			<div style="cursor:hand;" onclick="showSubphase('900002,9600')"  class="weiq14 mcolor<c:out value="${item[14] + 0}"/>">酬金明细导出</div>
		</div>
</html:form>
</body>
</html>





























