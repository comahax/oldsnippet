<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<html>
	<head>
		<title><s:text name="titleUpdate" /></title>
		<script type="text/javascript" src="<%=contextPath%>/js/bus/pwaycommon.js"></script>
		<script language="JavaScript" type="text/JavaScript">
        function ev_checkval() {
        	addfield('form.wayid', '<s:text name="wayid"/>', 'c', true, '32');
            return checkval(window);
            
        }
        
        function doReturn(str){
        	formItem.action = "<%=contextPath%>/promotion/ppzlnptnr_list.do?param._pk="+str;
        	formItem.submit();
        }
        function changeMode(val){
        	
        	if(val == 0){
        		document.getElementById("single").style.display = "";
        		document.getElementById("condition").style.display = "none";
        		document.getElementById("button").style.display = "";
        		document.getElementById("buttonReturn").style.display = "none";
        	}else if(val == 1){
        		document.getElementById("single").style.display = "none";
        		document.getElementById("condition").style.display = "";
        		document.getElementById("button").style.display = "";
        		document.getElementById("buttonReturn").style.display = "none";
        	}else if(val==-1){
        		document.getElementById("single").style.display = "none";
        		document.getElementById("condition").style.display = "none";
        		document.getElementById("button").style.display = "none";
        		document.getElementById("buttonReturn").style.display = "";
        	}
        }
        
        function checkProcess(str){
			var filename = formItem.path.value;
			if(filename != null || filename != ""){
	    		formItem.buttonProcess.disabled=true;
				window.location.href="<%=contextPath%>/promotion/ppzlnptnr_import.do?filename="+filename+"&beanname=com.gmcc.pboss.web.promotion.ppzlnptnr.PpzlnptnrTaskBean&pk="+str;
			}
		}
		
		function Upload(){
			formItem.action = "<%=contextPath%>/promotion/ppzlnptnr_upload.do";
			formItem.submit();
		}
    </script>
	</head>
	<body onload="if(window.loadforiframe) loadforiframe();">
		<div class="table_container">
			<s:form action="ppzlnptnr_save.do" cssStyle="formList" key="formItem"
				method="post" theme="simple" onsubmit="return ev_checkval();">

				<s:hidden name="form.pid" />
				<input type="hidden" name="filename" value='<s:property value="fileName"/>'>
   				<input type="hidden" name="path" value='<s:property value="filepath"/>'>
   				<input type="hidden" name="iCheckFormat" value="com.gmcc.pboss.web.promotion.ppzlnptnr.PpzlnptnrCheck">

				<div class="table_top">
					<div class="table_topleft"></div>
					<div class="table_toparea_w">
						<s:i18n name="public">
							<span class="table_toparea"><s:text name="currentPos" />
							</span>
							<span class="table_toparea_xi">></span>
							<span class="table_toparea"><s:text name="promotion" /> </span>
							<span class="table_toparea_xi">></span>
						</s:i18n>
						<span class="table_toparea_h"><s:text name="titleList" />
						</span>
						<span class="button_Help"
							onclick="openword('<s:text name="helpTitle"/>','<s:text name="helpContent1"/>')"><s:i18n
								name="public">
								<s:text name="help" />
							</s:i18n> </span>
					</div>
				</div>
				 
				<div class="error_text">
					<table class="error_text">
						<s:actionerror />
						<s:actionmessage />
					</table>
				</div>

				<div class="table_div">
					<table class="table_normal">
						<tr>
							<td align="right" width="25%">
								请选择新增模式:&nbsp
							</td>
							<td align="left">
								<s:if test="CMD == WEB_CMD_NEW">
								<s:select name="form.forMode" theme="simple" listKey="key"
									listValue="value" cssStyle="select"
									list="#{'-1':'', '0':'单笔新增', '1':'条件新增'}"
									onchange="changeMode(this.value);loadforiframe();" />
								<font color=red>*</font>
								</s:if>
								<s:else>
									<s:select name="form.forMode" theme="simple" listKey="key"
									listValue="value"
									list="#{'-1':'', '0':'单笔新增', '1':'条件新增'}"
									onchange="changeMode(this.value)" disabled="true" cssStyle="select"/>
								</s:else>
							</td>
						</tr>
					</table>
				</div>
				<div class="table_div">
					<table class="table_normal" id="single" style="display:none">
						<tr>
							<td align="right" width="25%">
								渠道代码:&nbsp
							</td>
							<td aligh="left">
								<s:textfield cssStyle="style_input" name="form.wayid" /><input type="button" value="..." class="picker_button" onclick="pshowSelectWay3(this,'form.wayid','','','AG');this.value='...';" />
							</td>
					</table>
				</div>
				<div class="table_div">
					<table class="table_normal" id="condition" style="display:none">
						<tr>
							<td align="right" width="25%">
								分公司编码:&nbsp
							</td>
							<td aligh="left">
								<j:selector definition="#CNTYCOMPANY" name="form.countyid" condition="countycompid:${dBAccessUser.cityid }" />
							</td>
						</tr>
						<tr>
							<td align="right" width="25%">
								渠道星级:&nbsp
							</td>
							<td aligh="left">
								<j:selector definition="$CH_STARLEVEL" name="form.starlevel"
									cssStyle="select" />
							</td>
						</tr>
					</table>
				</div>
				
				<div class="table_div">
					<table class="table_button_list" id="buttonReturn" >
						<tr>
							<td width="100%" align="center">
								<s:i18n name="public">
									<input type="button" id="btnReturn" name="btnReturn"
										class="button_Back" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" onfocus="buttonover(this)"
										onblur="buttonout(this)"
										value="<s:text name="button_return"/>"
										onclick="doReturn(document.all['form.pid'].value)">
								</s:i18n>
							</td>
						</tr>
					</table>
				</div>

				<div class="table_div">
					<table class="table_button_list" id="button" style="display:none">
						<tr>
							<td width="100%" align="center">
								<s:i18n name="public">
									<input type="button" id="btnSave" name="btnSave"
										class="button_Save" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" onfocus="buttonover(this)"
										onblur="buttonout(this)" value="<s:text name="button_save"/>"
										onclick="doSave('/promotion/ppzlnptnr_save.do');loadforiframe();" 
										<s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if>
										/>
									<input type="button" id="btnReturn" name="btnReturn"
										class="button_Back" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" onfocus="buttonover(this)"
										onblur="buttonout(this)"
										value="<s:text name="button_return"/>"
										onclick="doReturn(document.all['form.pid'].value)">
								</s:i18n>
							</td>
						</tr>
					</table>
				</div>
			</s:form>
		</div>
	</body>
</html>
