<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%@page import="com.sunrise.boss.common.base.db.DataPackage"%>
<%
	String ID_1 = "CH_PW_REWARD||CH_PW_REWARD_EDIT";
    String ID_2 = "CH_PW_REWARD||CH_PW_REWARD_VIEW";
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
		<title><bean:message bundle="faildataquery" key="titleList" />
		</title>
		<script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
		<script type="text/javascript" src="<%=contextPath%>/js/bus/rescommon.js"></script>
		<script language="JavaScript" type="text/JavaScript">
        function ev_check() {
        
        	addfield('backcalmonth', '校验失败数据后台导出结算月份', 'c', false, '6');
            addfield('_se_rewardtype', '<bean:message bundle="faildataquery" key="rewardtype"/>', 'c', true, '255');
            addfield('_se_opnid', '<bean:message bundle="faildataquery" key="opnid"/>', 'c', true, '18');
            addfield('_se_wayid', '<bean:message bundle="faildataquery" key="wayid"/>', 'c', true, '18');
            addfield('_dnl_oprtime', '<bean:message bundle="faildataquery" key="oprtime"/>', 'dt', true, '19');
            addfield('_dnm_oprtime', '<bean:message bundle="faildataquery" key="oprtime"/>', 'dt', true, '19');
            addfield('_se_oprcode', '<bean:message bundle="faildataquery" key="oprcode"/>', 'c', true, '15');
            addfield('_se_mobile', '<bean:message bundle="faildataquery" key="mobile"/>', 'l', true, '15');
            addfield('_sk_adtremark', '<bean:message bundle="faildataquery" key="adtremark"/>', 'c', true, '255');
            return checkval(window);
        }
        function selectAdtremark(adttype){
        	var strUrl ="<%=contextPath%>/cms/reward/faildataquery.do?CMD=SELECT";
        	if(typeof(adttype)!='undefined' && adttype.length>0){
			strUrl = strUrl + "&adttype=" + adttype;
			}
			var arg = new Array();
			var returnValue= window.showModalDialog(strUrl,arg,"dialogWidth:600px; dialogHeight:390px; status:no;resizable:yes;");
			return returnValue;
		 }
		 function showWindow(cmd){
		 	if(!isValidYYYYMM(formList.backcalmonth.value)){
		 		alert("请填写正确格式的校验失败数据后台导出结算月份，例如200908");
		 		return;
		 	}
    		var purflag=cmd.substr(cmd.length-1,cmd.length);
    		var url ='<%=contextPath%>/cms/reward/faildataquery/downSelect.jsp?flag='+purflag;
    		var rtn=window.showModalDialog(url , 1 , "dialogWidth=300px;dialogHeight=180px;status:no;scroll=yes;");
    		if(rtn=="" || rtn==null){
    		 	return false;
    		}
   		    formList.action = '<%=contextPath%>'+cmd+'&'+rtn;
   			formList.submit();
   			formList.action="<%=contextPath%>/cms/reward/faildataquery.do?CMD=LIST";
	    }
	    /*
		function doQuery1(){
			resetPage();
			var obj=document.all("checked");
			
			if(obj.checked==true)
			{
				formList.action="<%=contextPath%>/cms/reward/faildataquery.do?CMD=SHOW";
				formList.submit();
			}else if(obj.checked==false) {
				formList.action="<%=contextPath%>/cms/reward/faildataquery.do?CMD=SHOW";
				formList.submit();
			}
		}
		*/
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
				formList.action="<%=contextPath%>/cms/reward/faildataquery.do?CMD=SHOW";
				formList.submit();
			}else{
				formList.action="<%=contextPath%>/cms/reward/faildataquery.do?CMD=SHOW&UNCHECK=" + 'TRUE';
				formList.submit();
			}
		}
		
		
		
		
		function doExport(){
			var form=document.forms[0];
			form.action="<%=contextPath%>/cms/reward/faildataquery.do?CMD=TXT";
			form.submit();
			form.action="<%=contextPath%>/cms/reward/faildataquery.do?CMD=LIST";
		}
    </script>
	</head>

	<body onload="if(window.loadforiframe) loadforiframe();">
		<div class="table_container">
			<html:form action="/cms/reward/faildataquery.do?CMD=LIST" styleId="formList"
				method="post" onsubmit="return ev_check();">
				<html:hidden property="_orderby" />
				<html:hidden property="_desc" />
				<html:hidden property="_pageno" />
				<html:hidden property="_pagesize" value="20"/>
				
				<input type="hidden" name="_rowcount"
					value="<c:out value='${requestScope.LIST.rowCount}' />">

				<!--##################################添加标题内容##################################################-->
				<div class="table_div">
					<table class="top_table">
						<tr>
							<td>
								校验失败数据查询
							</td>
						</tr>
					</table>
				</div>
				<div class="table_div">
					<table width="100%" class="error_text">
						<html:errors />
						<s:Msg />
					</table>
				</div>
				<div class="table_div">
					<table class="form_table">
						<tr>
							<!-- <c:choose>
							<c:when test="${requestScope.ischeck=='true'}">
							<td width="126" height="20" align="right" class="form_table_right">
								<bean:message bundle="faildataquery" key="rewardtype" />
								:
							</td>
							
							<td class="form_table_left">
								<html:select property="_se_rewardtype"><!-- disabled="true" --><!-- 
									<html:option value="5">服务业务基本酬金</html:option>
									<html:option value="6">服务业务奖励酬金</html:option>
								</html:select>
							</td>
							</c:when>
							<c:otherwise>
								<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="faildataquery" key="rewardtype" />
								:
							</td>
							
							<td class="form_table_left">
								<html:select property="_se_rewardtype">
									<html:option value="1">标准卡积分酬金</html:option>
									<html:option value="2">标准卡专门津贴</html:option>
									<html:option value="5">服务业务基本酬金</html:option>
									<html:option value="6">服务业务奖励酬金</html:option>
								</html:select>
							</td>
							</c:otherwise>
							</c:choose>
							 -->
							 
							 
				 <c:choose>
                <c:when test="${requestScope.ischeck=='mango'}">
    			<td width="126" height="20" align="right" class="form_table_right">
                	<bean:message bundle="faildataquery" key="rewardtype" />:
            	</td>
            	<td class="form_table_left">
               	    <html:select property="_se_rewardtype"><!-- disabled="true" -->
						<html:option value="55">服务业务基本酬金</html:option>
						<html:option value="66">服务业务考核酬金</html:option>
					</html:select>
            	</td>
            	</c:when>
            	<c:when test="${requestScope.ischeck=='apple'}">
    			<td width="126" height="20" align="right" class="form_table_right">
                <bean:message bundle="faildataquery" key="rewardtype" />:
            	</td>
            	<td class="form_table_left">
               	    <html:select property="_se_rewardtype"><!-- disabled="true" -->
						<html:option value="11">服务业务一期酬金</html:option>
						<html:option value="22">服务业务二期酬金</html:option>
						<html:option value="33">服务业务三期酬金</html:option>
					</html:select>
            	</td>
            	</c:when>
            	<c:when test="${requestScope.ischeck=='orange'}">
    			<td width="126" height="20" align="right" class="form_table_right">
                	<bean:message bundle="faildataquery" key="rewardtype" />:
            	</td>
            	<td class="form_table_left">
               	    <html:select property="_se_rewardtype"><!-- disabled="true" -->
						<html:option value="55">服务业务基本酬金</html:option>
						<html:option value="44">服务业务考核酬金</html:option>
					</html:select>
            	</td>
            	</c:when>
            	<c:when test="${requestScope.ischeck=='banana'}">
    			<td width="126" height="20" align="right" class="form_table_right">
                	<bean:message bundle="faildataquery" key="rewardtype" />:
            	</td>
            	<td class="form_table_left">
               	    <html:select property="_se_rewardtype"><!-- disabled="true" -->
						<html:option value="55">服务业务基本酬金</html:option>
						<html:option value="44">服务业务考核酬金</html:option>
					</html:select>
            	</td>
            	</c:when>
            	<c:when test="${requestScope.ischeck=='lemon'}">
    			<td width="126" height="20" align="right" class="form_table_right">
                	<bean:message bundle="faildataquery" key="rewardtype" />:
            	</td>
            	<td class="form_table_left">
               	    <html:select property="_se_rewardtype"><!-- disabled="true" -->
               	    	<html:option value="90">基本校验</html:option>
						<html:option value="91">一期销售酬金</html:option>
						<html:option value="92">二期销售酬金</html:option>
						<html:option value="93">三期销售酬金</html:option>
					</html:select>
            	</td>
            	</c:when>
            		<c:when test="${requestScope.ischeck=='newtd'}">
    			<td width="126" height="20" align="right" class="form_table_right">
                	<bean:message bundle="faildataquery" key="rewardtype" />:
            	</td>
            	<td class="form_table_left">
               	    <html:select property="_se_rewardtype"><!-- disabled="true" -->
               	    	<html:option value="113">&nbsp;</html:option>
               	    	<html:option value="111">T、T+1、T+2一期酬金60%</html:option>
               	    	<html:option value="112">T+3二期酬金40%</html:option>  
					</html:select>
            	</td>
            	</c:when>
            	<c:otherwise>
					<td width="126" height="20" align="right"
					class="form_table_right">
					<bean:message bundle="faildataquery" key="rewardtype" />
					:
				</td>
				<td class="form_table_left">
					<html:select property="_se_rewardtype">
						<html:option value="1">标准卡积分酬金</html:option>
						<html:option value="2">标准卡专门津贴</html:option>
						<html:option value="5">服务业务基本酬金</html:option>
						<html:option value="6">服务业务奖励酬金</html:option>
					</html:select>
				</td>
				</c:otherwise>
				</c:choose>
							 
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="faildataquery" key="oprcode" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_se_oprcode"></html:text>
							</td>
						</tr>
						<tr>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="faildataquery" key="opnid" />
								:
							</td>
							<td class="form_table_left">
							    <html:text  property="_se_opnid" styleClass="form_input_1x"/>
                   				 <input type="button" value="..." class="clickbutton" onclick="showOpnTree2(this, '_se_opnid' , 'busi' )">                   
                 		    </td>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="faildataquery" key="wayid" />
								:
							</td>
							<td class="form_table_left">
							<s:AuditPurChk controlid="2B7G1A1A_JHQUERYRGT" type="WAY1">
								<html:text styleClass="form_input_1x" property="_se_wayid"></html:text>
							</s:AuditPurChk>
							</td>
						</tr>
						<tr>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="faildataquery" key="oprtime" />
								&gt;=:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_dnl_oprtime"
									onclick="this.value=selectDatetime();"></html:text>
							</td>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="faildataquery" key="oprtime" />
								&lt;=:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_dnm_oprtime"
									onclick="this.value=selectDatetime();"></html:text>
							</td>
						</tr>
						<tr>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="faildataquery" key="mobile" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_se_mobile"></html:text>
							</td>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="faildataquery" key="adtremark" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="_sk_adtremark"></html:text>
								<input type="button" value="..." class="clickbutton"
								onclick="_sk_adtremark.value=selectAdtremark('AG');">
							</td>
						</tr>
						<tr>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="faildataquery" key="backcalmonth" />
								:
							</td>
							<td class="form_table_left">
								<html:text styleClass="form_input_1x" property="backcalmonth" onclick="this.value=selectDateYYYYMM(this.value)"/>(例如:200809)
							</td>
							<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="faildataquery" key="rewardflag"/>:
							</td>
							<td class="form_table_left">
								<html:select property="_ne_rewardflag">
									<option />
										<s:Options definition="$CH_REWARDFLAG" />
								</html:select>
							</td>
						</tr>
						<tr>
			    			<td width="126" height="20" align="right"
								class="form_table_right">
			                	<bean:message bundle="faildataquery" key="batchno"/>:
			            	</td>
			            	<td class="form_table_left">
			               	    <html:text styleClass="form_input_1x" property="_se_batchno" />
			            	</td>
			            	<td width="126" height="20" align="right"
								class="form_table_right">
			            		<bean:message bundle="faildataquery" key="repairmonth"/>:
			            	</td>
			            	<td class="form_table_left">
			            		<html:text styleClass="form_input_1x" property="_se_repairmonth" onclick="this.value=selectDateYYYYMM(this.value)"/>
			            	</td>
			            </tr>
			            <tr>
			            
			            <!-- 
			    			<td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="faildataquery" key="rewarddefine" />
								:
			            	</td>
			            	<td class="form_table_left">
			               	    <html:checkbox property="checked"  onclick="doQuery1();"/>
			            	</td>
			            	<td width="126" height="20" align="right"
								class="form_table_right">
			            		 &nbsp;
			            	</td>
			            	<td class="form_table_left">
			            		&nbsp;
			            	</td>
			            	-->
			            	
<%--			            <td width="126" height="20" align="right"
								class="form_table_right">
								<bean:message bundle="faildataquery" key="rewarddefine" />:</td>
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
						<input type="checkbox" name="checked" value ="newtd" checked="true" onclick="doQuery1('newtd');"/>2014年新终端酬金<br>
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
            	</c:choose> 
            	<td width="126" height="20" align="right"
					class="form_table_right">
            		 &nbsp;
            	</td>
            	<td class="form_table_left">
            		&nbsp;
            	</td>--%>
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
								<input type="button" class="query" onclick="doQuery();" 
									onmouseover="buttonover(this);" onmouseout="buttonout(this);"
									onfocus="buttonover(this)" onblur="buttonout(this)"
									value="<bean:message bundle="public" key="button_search"/>" />
								<input type="button" class="button_2" onclick="doExport();" 
									onmouseover="buttonover(this);" onmouseout="buttonout(this);"
									onfocus="buttonover(this)" onblur="buttonout(this)"
									value="<bean:message bundle="public" key="button_export"/>" />	
								<c:choose>
		                         	<c:when test="${requestScope.purview=='A'}">
		                         		<input type="button" class="button_6" value="后台文件导出" class="comfir"  
		                         		onmouseover="buttonover(this)" onclick="showWindow('/cms/reward/faildataquery.do?CMD=DOWNLOAD&PURVIEW=A');"
		                         		onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)" >
		                         	</c:when>
		                         	<c:when test="${requestScope.purview=='B'}">
		                         		<input type="button" class="button_6" value="后台文件导出" class="comfir"  
		                         		onmouseover="buttonover(this)" onclick="showWindow('/cms/reward/faildataquery.do?CMD=DOWNLOAD&PURVIEW=B');"
		                         		onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)">
		                         	</c:when>
		                         	<c:when test="${requestScope.purview=='C'}">
		                         	<input type="button" class="button_6" value="后台文件导出" class="comfir"  
		                         		onmouseover="buttonover(this)" onclick="showWindow('/cms/reward/faildataquery.do?CMD=DOWNLOAD&PURVIEW=C');"
		                         		onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)">
		                         	</c:when>
									<c:otherwise>
										<input type="button" class="button_6" onmouseover="buttonover(this);"
		                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
		                                value="后台文件导出" disabled="true"/>
									</c:otherwise>                         	
		                         </c:choose>
							</td>
						</tr>
					</table>
				</div>
				<div class="table_div">
					<div class="table_LongTable">
						<table class="table_style" ID="Table2">
							<tr class="table_style_head">
								<td>
									<a href="javascript:doOrderby('seq')"><bean:message bundle="faildataquery" key="seq" /></a>
									<s:OrderImg form="/cms/reward/FaildataqueryForm" field="seq"/>
								</td>
								<td>
									<a href="javascript:doOrderby('rewardtype')"><bean:message bundle="faildataquery" key="rewardtype" /></a>
									<s:OrderImg form="/cms/reward/FaildataqueryForm" field="rewardtype"/>
								</td>
								<td>
									<a href="javascript:doOrderby('calcmonth')"><bean:message bundle="faildataquery" key="calcmonth" /></a>
									<s:OrderImg form="/cms/reward/FaildataqueryForm" field="calcmonth"/>
								</td>
								<td>
									<a href="javascript:doOrderby('opnid')"><bean:message bundle="faildataquery" key="opnid" /></a>
									<s:OrderImg form="/cms/reward/FaildataqueryForm" field="opnid"/>
								</td>
								<td>
									<a href="javascript:doOrderby('name')"><bean:message bundle="faildataquery" key="name" /></a>
									<s:OrderImg form="/cms/reward/FaildataqueryForm" field="name"/>
								</td>
								<td>
									<a href="javascript:doOrderby('wayid')"><bean:message bundle="faildataquery" key="wayid" /></a>
									<s:OrderImg form="/cms/reward/FaildataqueryForm" field="wayid"/>
								</td>
								<td>
									<a href="javascript:doOrderby('wayname')"><bean:message bundle="faildataquery" key="wayname" /></a>
									<s:OrderImg form="/cms/reward/FaildataqueryForm" field="wayname"/>
								</td>
								<td>
									<a href="javascript:doOrderby('oprcode')"><bean:message bundle="faildataquery" key="oprcode" /></a>
									<s:OrderImg form="/cms/reward/FaildataqueryForm" field="oprcode"/>
								</td>
								<td>
									<a href="javascript:doOrderby('mobile')"><bean:message bundle="faildataquery" key="mobile" /></a>
									<s:OrderImg form="/cms/reward/FaildataqueryForm" field="mobile"/>
								</td>
								<td>
									<a href="javascript:doOrderby('oprtime')"><bean:message bundle="faildataquery" key="oprtime" /></a>
									<s:OrderImg form="/cms/reward/FaildataqueryForm" field="oprtime"/>
								</td>
								<td>
									<a href="javascript:doOrderby('creattime')"><bean:message bundle="faildataquery" key="creattime" /></a>
									<s:OrderImg form="/cms/reward/FaildataqueryForm" field="creattime"/>
								</td>
								<td>
									<a href="javascript:doOrderby('ruleid')"><bean:message bundle="faildataquery" key="ruleid" /></a>
									<s:OrderImg form="/cms/reward/FaildataqueryForm" field="ruleid"/>
								</td>
								<td>
									<a href="javascript:doOrderby('adtflag')"><bean:message bundle="faildataquery" key="adtflag" /></a>
									<s:OrderImg form="/cms/reward/FaildataqueryForm" field="adtflag"/>
								</td>
								<td>
									<a href="javascript:doOrderby('adtcode')"><bean:message bundle="faildataquery" key="adtcode" /></a>
									<s:OrderImg form="/cms/reward/FaildataqueryForm" field="adtcode"/>
								</td>
								<td>
									<a href="javascript:doOrderby('adtremark')"><bean:message bundle="faildataquery" key="adtremark" /></a>
									<s:OrderImg form="/cms/reward/FaildataqueryForm" field="adtremark"/>
								</td>
								<td>
									<a href="javascript:doOrderby('batchno')"><bean:message bundle="faildataquery" key="batchno" /></a>
									<s:OrderImg form="/cms/reward/FaildataqueryForm" field="batchno"/>
								</td>
								<td>
									<a href="javascript:doOrderby('rewardflag')"><bean:message bundle="faildataquery" key="rewardflag" /></a>
									<s:OrderImg form="/cms/reward/FaildataqueryForm" field="rewardflag"/>
								</td>
								<td>
									<a href="javascript:doOrderby('repairmonth')"><bean:message bundle="faildataquery" key="repairmonth" /></a>
									<s:OrderImg form="/cms/reward/FaildataqueryForm" field="repairmonth"/>
								</td>
								<td>
									<a href="javascript:doOrderby('bakinfo')"><bean:message bundle="faildataquery" key="bakinfo" /></a>
									<s:OrderImg form="/cms/reward/FaildataqueryForm" field="bakinfo"/>
								</td>
								<td >
            	                     商品ID
            	               </td>
            	              <td>
            	                  商品协议价
            	              </td>
            	              <td>
									<a href="javascript:doOrderby('wrapfee')"><bean:message bundle="faildataquery" key="wrapfee" /></a>
									<s:OrderImg form="/cms/reward/FaildataqueryForm" field="wrapfee"/>
							  </td>
							  <td>稽核结果标识</td>
							  <td>商品名称</td>
							    <td>产品ID</td>
								<td>
									基准价
								</td>
								<td>
									酬金点数
								</td>
								<td>
									终端制式
								</td>
								<td>
									流量
								</td>
								<td>
									ARPU值
								</td>
								<td>
									优质客户
								</td>
								<td>
									终端类型
								</td>
							</tr>
							<c:forEach var="item" items="${requestScope.LIST.datas}">
								<tr class="table_style_content" align="center">
									<td>
										<c:out value="${item.seq}" />
									</td>
									<td> 
										<s:Code2Name code="${item.rewardtype}" definition="$CH_REWARDTYPE" />
									</td>
									<td>
										<c:out value="${item.calcmonth}" />
									</td>
									<td>
										<c:out value="${item.opnid}" />
									</td>
									<td>
										<c:out value="${item.name}" />
									</td>
									<td>
										<c:out value="${item.wayid}" />
									</td>
									<td>
										<c:out value="${item.wayname}" />
									</td>
									<td>
										<c:out value="${item.oprcode}" />
									</td>
									<td>
										<c:out value="${item.mobile}" />
									</td>
									<td>
										<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"  value="${item.oprtime}" />
									</td>
									<td>
										<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"  value="${item.creattime}" />
									</td>
									<td>
										<c:out value="${item.ruleid}" />
									</td>
									<td>
										<s:Code2Name code="${item.adtflag}" definition="#CH_ADTFLAG" />
									</td>
									<td>
										<c:out value="${item.adtcode}" />
									</td>
									<td>
										<c:out value="${item.adtremark}" />
									</td>
									<td>
										<c:out value="${item.batchno}" />
									</td>
									<td>
										<s:Code2Name code="${item.rewardflag}" definition="$CH_REWARDFLAG" />
									</td>
									<td>
										<c:out value="${item.repairmonth}" />
									</td>
									<td>
										<c:out value="${item.bakinfo}" />
									</td>
									<td><c:out value="${item.bakinfo2}"/></td>
                                    <td><c:out value="${item.bakinfo3}"/></td>
                                    <td><c:out value="${item.wrapfee}"/></td>
                                    <td><c:out value="${item.adtflag}"/></td>
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
