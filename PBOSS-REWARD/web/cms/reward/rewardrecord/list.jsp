<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%@page import="com.sunrise.boss.common.base.db.DataPackage"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<%
    String ID_1 = "CH_PW_REWARD||CH_PW_REWARD_QUERYALLCH||CH_PW_REWARD_PROVINCIAL||CH_PW_REWARD_CIVICEXPOT||CH_PW_REWARD_COUNTY";
    String ID_2= "CH_PW_REWARD_CIVIC";
%>
<%
	DataPackage bean1 = (DataPackage) pageContext.getRequest().getAttribute("LIST");
	if (null != bean1 && null != bean1.getDatas()) {
		int currentPage1 = bean1.getPageNo();
		int rowCount1 = bean1.getRowCount();
		int totalPage1 = (int) Math.ceil(((double) rowCount1) / ((double) bean1.getPageSize()));
		request.setAttribute("currentPage1", currentPage1);
		request.setAttribute("rowCount1", rowCount1);
		request.setAttribute("totalPage1", totalPage1);
	}
 %>
<html>
<head>
    <title><bean:message bundle="rewardrecord" key="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
    <script type="text/javascript" src="<%= contextPath%>/js/bus/rescommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
        	 var hasRight=0;
        	 <s:RewardPurChk controlid="<%=ID_1%>">hasRight=1;</s:RewardPurChk>
        	 if(hasRight==0){
        	 	addfield('_sk_wayid', '<bean:message bundle="rewardrecord" key="wayid"/>', 'c', false, '255');
        	 }else{
        	 	addfield('_sk_wayid', '<bean:message bundle="rewardrecord" key="wayid"/>', 'c', true, '255');
        	 }
        	 addfield('_se_rewardmonth', '<bean:message bundle="rewardrecord" key="rewardmonth"/>', 'd', false, '6');
        	 addfield('_ne_assegrade', '<bean:message bundle="rewardrecord" key="assegrade"/>', 'd', true, '1','6');
        	 addfield('_se_opermobile', '<bean:message bundle="rewardrecord" key="opermobile"/>', 'c', true, '15');
            return checkval(window);
        }
        function exports(){
             var hasRight=0;
        	 <s:RewardPurChk controlid="<%=ID_1%>">hasRight=1;</s:RewardPurChk>
        	 if(hasRight==0){
        	 	addfield('_sk_wayid', '<bean:message bundle="rewardrecord" key="wayid"/>', 'c', false, '255');
        	 }else{
        	 	addfield('_sk_wayid', '<bean:message bundle="rewardrecord" key="wayid"/>', 'c', true, '255');
        	 }
        	 if(　checkval(window) == false ) {
        	 	return ;
        	 }
			var form=document.forms[0];
			form.action="<%=contextPath%>/cms/rewardrecord.do?CMD=EXCEL";
			form.submit();
			form.action="<%=contextPath%>/cms/rewardrecord.do?CMD=LIST";
		}
		
		function selectbatchno(){
			if(ev_check()){
				var form=document.forms[0];
				var url = contextPath + '/cms/reward/batchno.do?CMD=Selectbatchno&_rewardmonth=' + form._se_rewardmonth.value;
				var returnValue = window.showModalDialog(url, "", "dialogWidth=550px;dialogHeight=450px;status=no;resizable:no;");
				if(typeof(returnValue) == 'undefined') {
					return '';
				}
				return returnValue;
			}else{
				return '';
			}
		}
		
		
		function doDown(cmdDown) {
		    var TO = true;
		    var sis = formList.all("_selectitem");
		    formList.action = contextPath + cmdDown;
		    formList.submit(); 
		    form.action="<%=contextPath%>/cms/rewardrecord.do?CMD=LIST";
		}
		function showWindow(cmd)
	    	{
	    		var purflag=cmd.substr(cmd.length-1,cmd.length);
	    		var url;
	    		if(purflag=='A')
	      		{
	      		 url='<%=contextPath%>/cms/reward/rewardrecord/select.jsp';
	      		}else
	      		{
	      		url='<%=contextPath%>/cms/reward/rewardrecord/select2.jsp';
	      		}
	    		var rtn=window.showModalDialog(url , 1 , "dialogWidth=300px;dialogHeight=180px;status:no;scroll=yes;");
	    		if(rtn=="" || rtn==null)
	    		{
	    		 return false;
	    		}
    		    formList.action = '<%=contextPath%>'+cmd+'&'+rtn;
     			formList.submit();
     			formList.action="<%=contextPath%>/cms/rewardrecord.do?CMD=LIST";
	    	}
	    function doQuery1(type){
			resetPage();
			var obj=document.all("checked");
			
			var bol = false;
			for(var i=0;i<5;i++){
				if(obj[i].checked == true){ 
					if(obj[i].value != type){
						obj[i].checked = false;
					}else{
					bol = true;
					}							
				}
			}
			
			
			
			
			if(bol)
			{ 
				formList.action="<%=contextPath%>/cms/rewardrecord.do?CMD=SHOW";
				formList.submit();
			}else{
				formList.action="<%=contextPath%>/cms/rewardrecord.do?CMD=SHOW&UNCHECK=" + 'TRUE';
				formList.submit();
			}
		}
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/rewardrecord.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="rewardrecord" key="titleList"/>
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
    			<td width="20%" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="rewardrecord" key="wayid"/>:
            	</td>
            	<td class="form_table_left">
               		<html:text styleClass="form_input_1x" onclick="showSelectWay(this,'_sk_wayid')" property="_sk_wayid" />
            	</td>
    			<td width="20%" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="rewardrecord" key="rewardid"/>:
            	</td>
            	<td class="form_table_left">
               	    <html:text styleClass="form_input_1x" property="_ne_rewardid" />
            	</td>
            </tr>
            <tr>
            	<c:choose>
                <c:when test="${requestScope.ischeck=='mango'}">
    			<td width="20%" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="rewardrecord" key="rewardtype"/>:
            	</td>
            	<td class="form_table_left">
               	    <html:select property="_ne_noncyc"><!-- disabled="true" -->
               	    	<html:option value=" ">&nbsp;</html:option>
						<html:option value="1">服务业务基本酬金</html:option>
						<html:option value="2">服务业务考核酬金</html:option>
					</html:select>
            	</td>
            	</c:when>
            	<c:when test="${requestScope.ischeck=='apple'}">
    			<td width="20%" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="rewardrecord" key="rewardtype"/>:
            	</td>
            	<td class="form_table_left">
               	    <html:select property="_ne_noncyc"><!-- disabled="true" -->
               	    	<html:option value=" ">&nbsp;</html:option>
						<html:option value="1">服务业务一期酬金</html:option>
						<html:option value="2">服务业务二期酬金</html:option>
						<html:option value="3">服务业务三期酬金</html:option>
					</html:select>
            	</td>
            	</c:when>
            	<c:when test="${requestScope.ischeck=='orange'}">
    			<td width="20%" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="rewardrecord" key="rewardtype"/>:
            	</td>
            	<td class="form_table_left">
               	    <html:select property="_ne_noncyc"><!-- disabled="true" -->
               	    	<html:option value=" ">&nbsp;</html:option>
						<html:option value="1">服务业务基本酬金</html:option>
						<html:option value="2">服务业务考核酬金</html:option>
					</html:select>
            	</td>
            	</c:when>
            	<c:when test="${requestScope.ischeck=='banana'}">
    			<td width="20%" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="rewardrecord" key="rewardtype"/>:
            	</td>
            	<td class="form_table_left">
               	    <html:select property="_ne_noncyc"><!-- disabled="true" -->
               	    	<html:option value=" ">&nbsp;</html:option>
						<html:option value="1">服务业务基本酬金</html:option>
						<html:option value="2">服务业务考核酬金</html:option>
					</html:select>
            	</td>
            	</c:when>
            	<c:when test="${requestScope.ischeck=='lemon'}">
    			<td width="20%" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="rewardrecord" key="rewardtype"/>:
            	</td>
            	<td class="form_table_left">
               	    <html:select property="_ne_noncyc"><!-- disabled="true" -->
               	    	<html:option value=" ">&nbsp;</html:option>
						<html:option value="1">一期销售酬金</html:option>
						<html:option value="2">二期销售酬金</html:option>
						<html:option value="3">三期销售酬金</html:option>
					</html:select>
            	</td>
            	</c:when>
            	<c:when test="${requestScope.ischeck=='newtd'}">
    			<td width="20%" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="rewardrecord" key="rewardtype"/>:
            	</td>
            	<td> 
               	    <html:select property="_ne_noncyc"  style="width: 200"><!-- disabled="true" -->
               	    <html:option value=" ">&nbsp;</html:option>
               	    <html:option value="1">T、T+1、T+2一期酬金60%</html:option>
                    <html:option value="2">T+2优质客户预发二期酬金40%</html:option>
                    <html:option value="3"> T+3二期酬金40%</html:option>
                    <html:option value="4">T+3低价值扣罚酬金</html:option>
                    <html:option value="5">T+4IVR外呼补发酬金</html:option>
					</html:select>
            	</td>
            	</c:when>
            	<c:otherwise>
            		<td width="20%" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="rewardrecord" key="rewardtype"/>:
            	</td>
            	<td class="form_table_left">
               	    <html:select property="_ne_rewardtype">
						<option />
							<s:Options definition="$CH_REWARDTYPE"/>
					</html:select>
            	</td>
            	</c:otherwise>
            	</c:choose>
            	<td width="20%" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="rewardrecord" key="slv"/>:
            	</td>
            	<td class="form_table_left">
               	   <html:select property="_ne_slv">
						<option />
							<s:Options definition="#CH_STARLEVEL" />
					</html:select>
            	</td>
            </tr>
            <tr>
    			<td width="20%" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="rewardrecord" key="rewardmonth"/>:
            	</td>
            	<td class="form_table_left">
               	    <html:text styleClass="form_input_1x" property="_se_rewardmonth" onclick="this.value=selectDateYYYYMM(this.value);" maxlength="6"/>
            	</td>
            	<td width="20%" height="20" align="right" class="form_table_right" >
            		<bean:message bundle="rewardrecord" key="rewardflag"/>:
            	</td>
            	<td class="form_table_left">
            		 <html:select property="_ne_rewardflag">
						<option />
							<s:Options definition="$CH_REWARDFLAG" />
					</html:select>
            	</td>
            </tr>
            <tr>
    			<td width="20%" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="rewardrecord" key="paymonth"/>:
            	</td>
            	<td class="form_table_left">
               	    <html:text styleClass="form_input_1x" property="_se_paymonth" onclick="this.value=selectDateYYYYMM(this.value);" maxlength="6"/>
            	</td>
            	<td width="20%" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="rewardrecord" key="assegrade"/>:
            	</td>
            	<td class="form_table_left">
            		 <html:text styleClass="form_input_1x" property="_ne_assegrade"/>
            	</td>
            </tr>
            <tr>
    			<td width="20%" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="rewardrecord" key="opermobile"/>:
            	</td>
            	<td class="form_table_left">
               	    <html:text styleClass="form_input_1x" property="_se_opermobile" />
            	</td>
            	<td width="20%" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="rewardrecord" key="mobile2"/>:
            	</td>
            	<td class="form_table_left">
               	    <html:text styleClass="form_input_1x" property="_se_mobile" />
            	</td>
            </tr>
            <tr>
            	<td width="20%" height="20" align="left" class="form_table_right" >
            		<bean:message bundle="rewardrecord" key="opnid"/>:
            	</td>
            	<td class="form_table_left">
            		<html:text styleClass="form_input_1x" property="_sk_opnid" /><input type="button" value="..." class="clickbutton" onclick="showOpnTree2(this, '_sk_opnid' , 'busi' )">
            	</td>
    			<td width="20%" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="rewardrecord" key="batchno"/>:
            	</td>
            	<td class="form_table_left">
               	    <html:text styleClass="form_input_1x" property="_se_batchno" onclick="this.value = selectbatchno();"/>
            	</td>
            	
            </tr>
            <tr>
            	<td width="20%" height="20" align="left" class="form_table_right" >
            		<bean:message bundle="rewardrecord" key="repairmonth"/>:
            	</td>
            	<td class="form_table_left">
            		<html:text styleClass="form_input_1x" property="_se_repairmonth" onclick="this.value=selectDateYYYYMM(this.value);"/>
            	</td>
            	<td width="20%" height="20" align="left" class="form_table_right" >
            		
            	</td>
            	<td class="form_table_left">
            		
            	</td>
<%--    			<td width="20%" height="20" align="right" class="form_table_right" >
    				终端酬金:
            	</td>
            	<c:choose>
	                <c:when test="${requestScope.ischeck=='mango'}">
	    			<td class="form_table_left">
	            		<!--  <html:checkbox property="checked" onclick="doQuery1();"/> -->
	            		<input type="checkbox" name="checked" value ="mango"  checked="true" onclick="doQuery1('mango');" />合约终端酬金<br>
	            		<input type="checkbox" name="checked" value ="apple" onclick="doQuery1('apple');" />零合约终端酬金<br>
						<input type="checkbox" name="checked" value ="orange" onclick="doQuery1('orange');"/>裸机终端酬金<br>
						<input type="checkbox" name="checked" value ="banana" onclick="doQuery1('banana');"/>类平台裸机终端酬金<br>
	            		<input type="checkbox" name="checked" value ="lemon" onclick="doQuery1('lemon');"/>裸机流量套餐酬金<br>
	            		<input type="checkbox" name="checked" value ="newtd" onclick="doQuery1('newtd');"/>2014年新终端酬金<br>
	            	</td>
	            	</c:when>
	            	<c:when test="${requestScope.ischeck=='apple'}">
	    			<td class="form_table_left">
	            		<!--  <html:checkbox property="checked" onclick="doQuery1();"/> -->
	            		<input type="checkbox" name="checked" value ="mango"  onclick="doQuery1('mango');" />合约终端酬金<br>
	            		<input type="checkbox" name="checked" value ="apple"  checked="true" onclick="doQuery1('apple');" />零合约终端酬金<br>
						<input type="checkbox" name="checked" value ="orange" onclick="doQuery1('orange');"/>裸机终端酬金<br>
						<input type="checkbox" name="checked" value ="banana" onclick="doQuery1('banana');"/>类平台裸机终端酬金<br>
	            		<input type="checkbox" name="checked" value ="lemon" onclick="doQuery1('lemon');"/>裸机流量套餐酬金<br>
	            		<input type="checkbox" name="checked" value ="newtd" onclick="doQuery1('newtd');"/>2014年新终端酬金<br>
	            	</td>
	            	</c:when>
	            	<c:when test="${requestScope.ischeck=='orange'}">
	    			<td class="form_table_left">
	            		<!--  <html:checkbox property="checked" onclick="doQuery1();"/> -->
	            		<input type="checkbox" name="checked" value ="mango"   onclick="doQuery1('mango');" />合约终端酬金<br>
	            		<input type="checkbox" name="checked" value ="apple" onclick="doQuery1('apple');" />零合约终端酬金<br>
						<input type="checkbox" name="checked" value ="orange" checked="true" onclick="doQuery1('orange');"/>裸机终端酬金<br>
						<input type="checkbox" name="checked" value ="banana" onclick="doQuery1('banana');"/>类平台裸机终端酬金<br>
	            		<input type="checkbox" name="checked" value ="lemon" onclick="doQuery1('lemon');"/>裸机流量套餐酬金<br>
	            		<input type="checkbox" name="checked" value ="newtd" onclick="doQuery1('newtd');"/>2014年新终端酬金<br>
	            	</td>
	            	</c:when>
	            	<c:when test="${requestScope.ischeck=='banana'}">
	    			<td class="form_table_left">
	            		<!--  <html:checkbox property="checked" onclick="doQuery1();"/> -->
	            		<input type="checkbox" name="checked" value ="mango"   onclick="doQuery1('mango');" />合约终端酬金<br>
	            		<input type="checkbox" name="checked" value ="apple" onclick="doQuery1('apple');" />零合约终端酬金<br>
						<input type="checkbox" name="checked" value ="orange" onclick="doQuery1('orange');"/>裸机终端酬金<br>
						<input type="checkbox" name="checked" value ="banana" checked="true" onclick="doQuery1('banana');"/>类平台裸机终端酬金<br>
	            		<input type="checkbox" name="checked" value ="lemon" onclick="doQuery1('lemon');"/>裸机流量套餐酬金<br>
	            		<input type="checkbox" name="checked" value ="newtd" onclick="doQuery1('newtd');"/>2014年新终端酬金<br>
	            	</td>
	            	</c:when>
	            	<c:when test="${requestScope.ischeck=='lemon'}">
	    			<td class="form_table_left">
	            		<!--  <html:checkbox property="checked" onclick="doQuery1();"/> -->
	            		<input type="checkbox" name="checked" value ="mango"   onclick="doQuery1('mango');" />合约终端酬金<br>
	            		<input type="checkbox" name="checked" value ="apple" onclick="doQuery1('apple');" />零合约终端酬金<br>
						<input type="checkbox" name="checked" value ="orange" onclick="doQuery1('orange');"/>裸机终端酬金<br>
						<input type="checkbox" name="checked" value ="banana" onclick="doQuery1('banana');"/>类平台裸机终端酬金<br>
	            		<input type="checkbox" name="checked" value ="lemon" checked="true" onclick="doQuery1('lemon');"/>裸机流量套餐酬金<br>
	            		<input type="checkbox" name="checked" value ="newtd" onclick="doQuery1('newtd');"/>2014年新终端酬金<br>
	            	</td>
	            	</c:when>
	            	<c:when test="${requestScope.ischeck=='newtd'}">
	    			<td class="form_table_left">
	            		<!--  <html:checkbox property="checked" onclick="doQuery1();"/> -->
	            		<input type="checkbox" name="checked" value ="mango"   onclick="doQuery1('mango');" />合约终端酬金<br>
	            		<input type="checkbox" name="checked" value ="apple" onclick="doQuery1('apple');" />零合约终端酬金<br>
						<input type="checkbox" name="checked" value ="orange" onclick="doQuery1('orange');"/>裸机终端酬金<br>
						<input type="checkbox" name="checked" value ="banana" onclick="doQuery1('banana');"/>类平台裸机终端酬金<br>
	            		<input type="checkbox" name="checked" value ="lemon" onclick="doQuery1('lemon');"/>裸机流量套餐酬金<br>
	            		<input type="checkbox" name="checked" value ="newtd"  checked="true" onclick="doQuery1('newtd');"/>2014年新终端酬金<br>
	            	</td>
	            	</c:when>
            	 <c:otherwise>
            		<td class="form_table_left">
            		<!--  <html:checkbox property="checked" onclick="doQuery1();"/> -->
            		<input type="checkbox" name="checked" value ="mango" onclick="doQuery1('mango');" />合约终端酬金<br>
            		<input type="checkbox" name="checked" value ="apple"  onclick="doQuery1('apple');" />零合约终端酬金<br>
					<input type="checkbox" name="checked" value ="orange" onclick="doQuery1('orange');" />裸机终端酬金<br>
					<input type="checkbox" name="checked" value ="banana" onclick="doQuery1('banana');" />类平台裸机终端酬金<br>
					<input type="checkbox" name="checked" value ="lemon" onclick="doQuery1('lemon');"/>裸机流量套餐酬金<br>
					<input type="checkbox" name="checked" value ="newtd" onclick="doQuery1('newtd');"/>2014年新终端酬金<br>
            	</td>
            	</c:otherwise>
            	</c:choose>--%>
            </tr>
        </table>
    </div>
	<div class="table_div">
		<table style="width: 98%; font-size: 12px; border:#72FF00 solid 0px; margin-bottom:3px;">
			<tr> 
                <td align="left">
                <c:choose>
				    <c:when test="${!empty requestScope.LIST.datas}">
						<bean:message bundle="public" key="button_total_page" />
						<font color="red"><c:out value='${rowCount1}' /></font> 项数据
						&nbsp;
						<bean:message bundle="public" key="button_total_page" />
						<font color="red"><c:out value="${totalPage1}" /></font>
						<bean:message bundle="public" key="button_page" />
						&nbsp;
						<bean:message bundle="public" key="button_current_page" />
						<font color="red"><c:out value="${currentPage1}" /></font>
						<bean:message bundle="public" key="button_page" />
				    </c:when>
				</c:choose>
				</td>
                <td align=right>
                        <input type="button" class="query"onmouseover="buttonover(this);" onclick="doQuery();" 
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_search"/>" />
                        <input type="button" class="button_6" onmouseover="buttonover(this);"
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="文本文件导出" onclick="exports()"/>
                         <c:choose>
                         	<c:when test="${requestScope.purview=='A'}">
                         		<input type="button" class="button_6" value="后台文件导出" class="comfir"  
                         		onmouseover="buttonover(this)" onclick="showWindow('/cms/rewardrecord.do?CMD=DOWNLOAD&PURVIEW=A');"
                         		onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)" >
                         	</c:when>
                         	<c:when test="${requestScope.purview=='B'}">
                         		<input type="button" class="button_6" value="后台文件导出" class="comfir"  
                         		onmouseover="buttonover(this)" onclick="showWindow('/cms/rewardrecord.do?CMD=DOWNLOAD&PURVIEW=B');"
                         		onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)">
                         	</c:when>
                         	<c:when test="${requestScope.purview=='C'}">
                         	<input type="button" class="button_6" value="后台文件导出" class="comfir"  
                         		onmouseover="buttonover(this)" onclick="showWindow('/cms/rewardrecord.do?CMD=DOWNLOAD&PURVIEW=C');"
                         		onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)">
                         	</c:when>
							<c:otherwise>
								<input type="button" class="button_6" onmouseover="buttonover(this);"
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="后台文件导出" disabled="true"/>
							</c:otherwise>                         	
                         </c:choose>
                        <input type="button" class="button_8" onmouseover="buttonover(this);"
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="地市个性化报表下载" onclick="doOther('/cms/rewardrecord.do?CMD=DOWNLOAD2')"/>
                </td>
			</tr>
		</table>
	</div>

    <div class="table_div">
      <div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
                <td>
                    <a href="javascript:doOrderby('rewardlistid')"><bean:message bundle="rewardrecord" key="rewardlistid"/></a>
                    <s:OrderImg form="/cms/rewardrecord/rewardrecordForm" field="rewardlistid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('operseq')"><bean:message bundle="rewardrecord" key="operseq"/></a>
                    <s:OrderImg form="/cms/rewardrecord/rewardrecordForm" field="operseq"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('opnid')"><bean:message bundle="rewardrecord" key="opnid"/></a>
                    <s:OrderImg form="/cms/rewardrecord/rewardrecordForm" field="opnid"/>
                </td>
                <td>
                   		业务名称
                </td>
                <td>
                    <a href="javascript:doOrderby('wayid')"><bean:message bundle="rewardrecord" key="wayid"/></a>
                    <s:OrderImg form="/cms/rewardrecord/rewardrecordForm" field="wayid"/>
                </td>
                <td>
                   		渠道名称
                </td>
                <td>
                    <a href="javascript:doOrderby('wayoprcode')"><bean:message bundle="rewardrecord" key="wayoprcode"/></a>
                    <s:OrderImg form="/cms/rewardrecord/rewardrecordForm" field="wayoprcode"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('slv')"><bean:message bundle="rewardrecord" key="slv"/></a>
                    <s:OrderImg form="/cms/rewardrecord/rewardrecordForm" field="slv"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('rewardid')"><bean:message bundle="rewardrecord" key="rewardid"/></a>
                    <s:OrderImg form="/cms/rewardrecord/rewardrecordForm" field="rewardid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('rewardtype')"><bean:message bundle="rewardrecord" key="rewardtype"/></a>
                    <s:OrderImg form="/cms/rewardrecord/rewardrecordForm" field="rewardtype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('rewardmonth')"><bean:message bundle="rewardrecord" key="rewardmonth"/></a>
                    <s:OrderImg form="/cms/rewardrecord/rewardrecordForm" field="rewardmonth"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('isbudget')"><bean:message bundle="rewardrecord" key="isbudget"/></a>
                    <s:OrderImg form="/cms/rewardrecord/rewardrecordForm" field="isbudget"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('mobile')"><bean:message bundle="rewardrecord" key="mobile"/></a>
                    <s:OrderImg form="/cms/rewardrecord/rewardrecordForm" field="mobile"/>
                </td>
                <td>
                	业务发生时间
                </td>
                <td>
                    <a href="javascript:doOrderby('acctype')"><bean:message bundle="rewardrecord" key="acctype"/></a>
                    <s:OrderImg form="/cms/rewardrecord/rewardrecordForm" field="acctype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('rewardstd')"><bean:message bundle="rewardrecord" key="rewardstd"/></a>
                    <s:OrderImg form="/cms/rewardrecord/rewardrecordForm" field="rewardstd"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('totalsum')"><bean:message bundle="rewardrecord" key="totalsum"/></a>
                    <s:OrderImg form="/cms/rewardrecord/rewardrecordForm" field="totalsum"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('paysum')"><bean:message bundle="rewardrecord" key="paysum"/></a>
                    <s:OrderImg form="/cms/rewardrecord/rewardrecordForm" field="paysum"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('paymonth1')"><bean:message bundle="rewardrecord" key="paymonth1"/></a>
                    <s:OrderImg form="/cms/rewardrecord/rewardrecordForm" field="paymonth1"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('paymoney1')"><bean:message bundle="rewardrecord" key="paymoney1"/></a>
                    <s:OrderImg form="/cms/rewardrecord/rewardrecordForm" field="paymoney1"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('paymonth2')"><bean:message bundle="rewardrecord" key="paymonth2"/></a>
                    <s:OrderImg form="/cms/rewardrecord/rewardrecordForm" field="paymonth2"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('paymoney2')"><bean:message bundle="rewardrecord" key="paymoney2"/></a>
                    <s:OrderImg form="/cms/rewardrecord/rewardrecordForm" field="paymoney2"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('paymonth3')"><bean:message bundle="rewardrecord" key="paymonth3"/></a>
                    <s:OrderImg form="/cms/rewardrecord/rewardrecordForm" field="paymonth3"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('paymoney3')"><bean:message bundle="rewardrecord" key="paymoney3"/></a>
                    <s:OrderImg form="/cms/rewardrecord/rewardrecordForm" field="paymoney3"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('runtime')"><bean:message bundle="rewardrecord" key="runtime"/></a>
                    <s:OrderImg form="/cms/rewardrecord/rewardrecordForm" field="runtime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('assegrade')"><bean:message bundle="rewardrecord" key="assegrade"/></a>
                    <s:OrderImg form="/cms/rewardrecord/rewardrecordForm" field="assegrade"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('opermobile')"><bean:message bundle="rewardrecord" key="opermobile"/></a>
                    <s:OrderImg form="/cms/rewardrecord/rewardrecordForm" field="opermobile"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('batchno')"><bean:message bundle="rewardrecord" key="batchno"/></a>
                    <s:OrderImg form="/cms/rewardrecord/rewardrecordForm" field="batchno"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('rewardflag')"><bean:message bundle="rewardrecord" key="rewardflag"/></a>
                    <s:OrderImg form="/cms/rewardrecord/rewardrecordForm" field="rewardflag"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('repairmonth')"><bean:message bundle="rewardrecord" key="repairmonth"/></a>
                    <s:OrderImg form="/cms/rewardrecord/rewardrecordForm" field="repairmonth"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('noncyc')"><bean:message bundle="rewardrecord" key="noncyc"/></a>
                    <s:OrderImg form="/cms/rewardrecord/rewardrecordForm" field="noncyc"/>
                </td>
                <td>
                	附加属性(IMEI)
                </td>
                <td >
            	 商品ID
            	</td>
            	<td>
            	 商品协议价
            	</td>
            	<td>
                    <a href="javascript:doOrderby('wrapfee')"><bean:message bundle="rewardrecord" key="wrapfee"/></a>
                    <s:OrderImg form="/cms/rewardrecord/rewardrecordForm" field="wrapfee"/>
                </td>
                <td>调整类型</td>
                <td>稽核结果标识</td>
                <td>考核系数2</td>
                <td>商品名称</td>
                 <td>产品ID</td>
                <td>基准价</td>
                <td>酬金点数</td>
                <td>终端制式</td>
                <td>流量</td>
                <td>ARPU值</td>
                <td>优质客户</td>
                <td>终端类型</td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <tr class="table_style_content" align="center">
                     <td>
                         <c:out value="${item.rewardlistid}"/>
                     </td>
                     <td><c:out value="${item.operseq}"/></td>
                     <td><c:out value="${item.opnid}"/></td>
                     <td><s:Code2Name code="${item.opnid }" definition="#OPERATION" /></td>
                     <td><c:out value="${item.wayid}"/></td>
                     <td><s:Code2Name code="${item.wayid }" definition="#WAY" /></td>
                     <td><c:out value="${item.wayoprcode}"/></td>
                     <td><s:Code2Name code="${item.slv }" definition="#CH_STARLEVEL" /></td>
                     <td><c:out value="${item.rewardid}"/></td>            
                     <td><s:Code2Name code="${item.rewardtype}" definition="$CH_REWARDTYPE" /></td>
                     <td><c:out value="${item.rewardmonth}"/></td>
                     <td>                  
                     	<s:Code2Name code="${item.isbudget }" definition="#CH_ISBUDGET" />
                     </td>
                     
                     <td><c:out value="${item.mobile}"/></td>
                     <td>
	                     <fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.oprtime}" />
                     </td> 
                     <td>
                 	  	<s:Code2Name code="${item.acctype}" definition="#CH_ACCTYPE" />
                     </td>
                     <td>
	                     <c:choose>
	                     	<c:when test="${item.acctype eq 2}">
	                     		<fmt:formatNumber pattern="0.00%" value="${item.rewardstd}"></fmt:formatNumber>
	                     	</c:when>
	                     	<c:otherwise>
	                     		<c:out value="${item.rewardstd}"/>
	                     	</c:otherwise>
	                     </c:choose>
                     </td>
                     <td><fmt:formatNumber pattern="0.000000###" value="${item.totalsum}"/></td>
                     <td><fmt:formatNumber pattern="0.000000###" value="${item.paysum}"/></td>
                     <td><c:out value="${item.paymonth1}"/></td>
                     <td><fmt:formatNumber pattern="0.000000000" value="${item.paymoney1}"/></td>
                     <td><c:out value="${item.paymonth2}"/></td>
                     <td><fmt:formatNumber pattern="0.000000000" value="${item.paymoney2}"/></td>
                     <td><c:out value="${item.paymonth3}"/></td>
                     <td><fmt:formatNumber pattern="0.000000000" value="${item.paymoney3}"/></td>
                     <td>
	                     <fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.runtime}" />
                     </td> 
                     <td>
	                    <fmt:formatNumber pattern="0.000000" value="${item.assegrade}"/>
                     </td>
                     <td>
	                     <c:out value="${item.opermobile}"/>
                     </td>
                     <td><c:out value="${item.batchno}"/></td>
                     <td><s:Code2Name code="${item.rewardflag}" definition="$CH_REWARDFLAG" /></td>
                     <td><c:out value="${item.repairmonth}"/></td>
                     <td><c:out value="${item.noncyc}"/></td>
                     <td><c:out value="${item.bakinfo}"/></td>
                     <td><c:out value="${item.bakinfo2}"/></td>
                     <td><c:out value="${item.bakinfo3}"/></td>
                     <td><c:out value="${item.wrapfee}"/></td>
                     <td><s:Code2Name code="${item.adjustkind }" definition="$CH_ADJUSTKIND" /></td>
                     <td><c:out value="${item.adtflag}"/></td>
                     <td><c:out value="${item.assegrade2}"/></td>
                     <td><s:Code2Name code="${item.bakinfo2 }" definition="#IM_PR_COM" /></td>
                     <td><c:out value="${item.prodid}"/></td>
                     <td><c:out value="${item.bakinfo4}"/></td>
                     <td><c:out value="${item.bakinfo5}"/></td>
                     <td><s:Code2Name code="${item.bakinfo6}" definition="$ZD_SYSTEM" /></td>
                     <td><c:out value="${item.bakinfo7}"/></td>
                     <td><c:out value="${item.bakinfo8}"/></td>
                     <td><c:out value="${item.bakinfo9}"/></td>
                     <td><s:Code2Name code="${item.bakinfo10}" definition="$ZD_TYPE" /></td> 
                 </tr>
             </c:forEach>
        </table>
     </div>
   </div>

   <div class="table_div">
		<%@ include file="/commons/pageCountNav.jsp"%>
   </div>
</html:form>
</div>
</body>
</html>
