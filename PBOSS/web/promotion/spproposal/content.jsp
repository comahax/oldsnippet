<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="j" uri="/jop-tags" %>
<%@ taglib prefix="aa" uri="http://ajaxanywhere.sourceforge.net/" %>
<html>
<head>
    <title><s:text name="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
			addfield('form.pname', '<s:text name="pname"/>', 'c', false, 50);
			addfield('form.ptype', '<s:text name="ptype"/>', 'c', false, 32);
			addfield('form.pstarttime', '<s:text name="pstarttime"/>', 't', false, 16);
			addfield('form.pendtime', '<s:text name="pendtime"/>', 't', false, 16);
			addfield('form.pfrtmode', '<s:text name="pfrtmode"/>', 'c', false, 32);
			addfield('form.memo', '<s:text name="memo"/>', 'c', true, 512);
			if(date_compare2("form.nowDate","form.pstarttime",'开始时间必须在当天时间之后!')) return;
			if(date_compare2("form.nowDate","form.pendtime",'结束时间必须在当天时间之后!')) return;
			if(date_compare("form.pstarttime","form.pendtime",'开始时间不能晚于结束时间!')) return;
			var ptype = document.all("form.ptype");
			if(ptype.value == 1){
				var forMode = document.all("form.forMode");
				var array = null;
				if(forMode.value == 0){
					array = document.all("form.forWeeks");
				}else{
					array = document.all("form.forDays");
				}
				var flag = true;
				for(var i = 0;i<array.length;i++){
			    	if(array[i].checked){
			    		flag = false;
			    		break;
			    	}
			    }
			    if(flag){
			    	alert('定期模式至少选择一项!');
			    	return false;
			    }
			}
            return checkval(window);
        }
        
        function date_compare2(element1,element2,errorMessage) {
			var beginTime = document.all(element1).value;
			var endTime = document.all(element2).value;
			if(beginTime != "" && endTime != ""){
				var dt_begin = (beginTime.split("."))[0];
				var dt_end = (endTime.split("."))[0];
				if(dt_begin >= dt_end) {
					if(errorMessage == null)errorMessage = "????????????";
					fields = new Array();
					alert(errorMessage);
					return true;
				}
				else{
					return false;
				}
			}
		}
        
        function showTable2(){
        	var ptype = document.all("form.ptype");
        	var pstarttime = document.all("form.pstarttime");
        	var pendtime = document.all("form.pendtime");
        	var flag = ptype.disabled;
        	ptype.disabled = false;
        	if(ptype.value != '' && pstarttime.value != '' && pendtime.value != '' ){
        		if(date_compare2("form.nowDate","form.pstarttime",'开始时间必须在当天时间之后!')){ptype.disabled = flag;return;}
				if(date_compare2("form.nowDate","form.pendtime",'结束时间必须在当天时间之后!')){ptype.disabled = flag;return;}
        		if(ptype.value == 1){
        			if(date_compare("form.pstarttime","form.pendtime",'开始时间不能晚于结束时间!')){
        				ptype.disabled = flag;
        				return;
        			}
        			document.getElementById("Table2").style.display = "";
        			ajaxAnywhere.submitByURL(contextPath+"/promotion/spproposal_refresh.do");
        		}else{
        			document.getElementById("Table2").style.display = "none";
        		}
        	}else{
        		document.getElementById("Table2").style.display = "none";
        	}
        	ptype.disabled = flag;
        }
        function changeMode(val){
        	if(val == 1){
        		document.getElementById("week").style.display = "none";
        		document.getElementById("day").style.display = "";
        	}else{
        		document.getElementById("week").style.display = "";
        		document.getElementById("day").style.display = "none";
        	}
        }
        
        function readyForLoad(){
       		var ptype = document.all("form.ptype");
       		if(ptype != null && ptype.value == '1'){
       			document.getElementById("Table2").style.display = "";
       			changeMode(ptype.value);
        	}
        }
        //自定义回调函数，用于刷新过滤条件区域
    	ajaxAnywhere.onAfterResponseProcessing = nativeCallback;
    	function nativeCallback()
    	{
			var paramNameStr = $("#paramNameStr").val();
			if(document.all("form.forMode").value == "0"){
				document.getElementById("week").style.display = "";
				document.getElementById("day").style.display = "none";
			}else{
				document.getElementById("week").style.display = "none";
				document.getElementById("day").style.display = "";
			}
			document.getElementById("Table2").style.display = "";
		}
	</script>
</head>
<body onload="readyForLoad();loadforiframe();">
<div class="table_container">
<s:form action="spproposal_save.do" cssStyle="formList" key="formItem" method="post" theme="simple" onsubmit="return ev_checkval();">
    <s:hidden name="CMD"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="form.pid" />
    <input type="hidden" name="form.nowDate" value="<s:date name="form.nowDate" format="yyyy-MM-dd" />"/>
	
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="promotion"/> </span>
			<span class="table_toparea_xi">></span>
			</s:i18n>
			<span class="table_toparea_h"><s:text name="titleList"/></span>
			<span class="button_Help" onclick="openword('<s:text name="helpTitle"/>','<s:text name="helpContent1"/>')"><s:i18n name="public"><s:text name="help"/></s:i18n></span>
		</div>
	</div>

	<div class="error_text" >
		<table class="error_text">
			<s:actionerror /><s:actionmessage/>
		</table>
	</div>
	
    <div class="table_div">
        <table class="table_normal">
            <tr>
                <td align="right"><s:text name="pname"/>:&nbsp</td>
                <td align="left">
	                <s:if test="CMD == WEB_CMD_NEW">
						<s:textfield cssStyle="width:290px" name="form.pname" maxlength="50"/>
						<font color="red">*</font>
					</s:if>
					<s:else>
						<s:textfield cssStyle="width:290px" name="form.pname" maxlength="50" disabled="true"/>
						<font color="red">*</font>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="ptype"/>:&nbsp</td>
                <td align="left">
                	<s:if test="CMD == WEB_CMD_NEW">
						<j:selector definition="$CH_PTYPE" name="form.ptype" cssStyle="select" onchange="showTable2();" mode="selector"/>
						<font color="red">*</font>
					</s:if>
					<s:else>
						<j:selector definition="$CH_PTYPE" name="form.ptype" cssStyle="select" onchange="showTable2();" mode="selector" disabled="true"/>
						<font color="red">*</font>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="pstarttime"/>:&nbsp</td>
                <td align="left">
                	<s:if test="CMD == WEB_CMD_NEW">
						<s:textfield cssStyle="style_input" name="form.pstarttime" onclick="selectDate();showTable2();" readonly="true"/>
						<font color="red">*</font>
					</s:if>
					<s:elseif test="CMD == WEB_CMD_EDIT">
	                	<s:i18n name="public">
							<s:textfield cssStyle="style_input" name="form.pstarttime" value="%{getText('format.date',{form.pstarttime})}" maxlength="10" onclick="selectDate();showTable2();"/>
							<font color="red">*</font>
						</s:i18n>
					</s:elseif>
					<s:else>
						<s:i18n name="public">
							<s:textfield cssStyle="style_input" name="form.pstarttime" value="%{getText('format.date',{form.pstarttime})}" maxlength="10" disabled="true"/>
							<font color="red">*</font>
						</s:i18n>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="pendtime"/>:&nbsp</td>
                <td align="left">
                	<s:if test="CMD == WEB_CMD_NEW">
                		<s:textfield cssStyle="style_input" name="form.pendtime" onclick="selectDate();showTable2();" readonly="true"/>
						<font color="red">*</font>
                	</s:if>
                	<s:elseif test="CMD == WEB_CMD_EDIT">
	                	<s:i18n name="public">
							<s:textfield cssStyle="style_input" name="form.pendtime" value="%{getText('format.date',{form.pendtime})}" maxlength="10" onclick="selectDate();showTable2();"/>
							<font color="red">*</font>
						</s:i18n>
					</s:elseif>
					<s:else>
						<s:i18n name="public">
							<s:textfield cssStyle="style_input" name="form.pendtime" value="%{getText('format.date',{form.pendtime})}" maxlength="10" disabled="true"/>
							<font color="red">*</font>
						</s:i18n>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="pfrtmode"/>:&nbsp</td>
                <td align="left">
                	<s:if test="CMD == WEB_CMD_NEW">
						<j:selector definition="$CH_PFRTMODE" name="form.pfrtmode" cssStyle="style_input" mode="selector"/>
						<font color="red">*</font>
					</s:if>
					<s:else>
						<j:selector definition="$CH_PFRTMODE" name="form.pfrtmode" cssStyle="style_input" mode="selector" disabled="true"/>
						<font color="red">*</font>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="memo"/>:&nbsp</td>
                <td align="left">
                	<s:if test="CMD != WEB_CMD_SAVE">
						<s:textarea cssStyle="style_input" name="form.memo" maxlength="512" cols="80" rows="6"/>
					</s:if>
					<s:else>
						<s:textarea cssStyle="style_input" name="form.memo" maxlength="512" cols="80" rows="6" disabled="true"/>
					</s:else>
                </td>
            </tr>
        </table>
    </div>
    
    <aa:zone name="refreshTable2">
    <input type="hidden" id="paramNameStr" value="<%=request.getAttribute("showjs")==null?"":(String)request.getAttribute("showjs")%>" />
    <div class="table_div" id="Table2" style="display:none">
    		<table class="table_normal">
	    		<tr>
	                <td align="right">定期模式:</td>
	                <td align="left">
	                	<s:if test="CMD != WEB_CMD_SAVE">
		                	<s:select name="form.forMode" theme="simple" listKey="key"  listValue="value"
		                	list="#{'0':'按周', '1':'按天'}" onchange="changeMode(this.value)"/> 
							<font color="red">*</font>
						</s:if>
						<s:else>
							<s:select name="form.forMode" theme="simple" listKey="key"  listValue="value"
		                	list="#{'0':'按周', '1':'按天'}" disabled="true"/> 
							<font color="red">*</font>
						</s:else>
	                </td>
	            </tr>
	            <tr>
	                <td align="left" colspan="2">
	                	<div id="week">
	                		<s:if test="CMD != WEB_CMD_SAVE">
	                			<j:selector definition="WEEKDAY" name="form.forWeeks" cssStyle="style_input" mode="multicheckbox"/>
	                		</s:if>
	                		<s:else>
	                			<j:selector definition="WEEKDAY" name="form.forWeeks" cssStyle="style_input" mode="multicheckbox" disabled="true"/>
	                		</s:else>
	                	</div>
	                	<div id="day">
	                		<s:if test="CMD != WEB_CMD_SAVE">
	                			<j:checkboxlist name="form.forDays" theme="simple" listKey="key" listValue="value" list="form.dayMap" />
	                		</s:if>
	                		<s:else>
	                			<j:checkboxlist name="form.forDays" theme="simple" listKey="key" listValue="value" list="form.dayMap" disabled="true"/>
	                		</s:else>
	                	</div>
	                </td>
	            </tr>
    		</table>
    </div>
    </aa:zone>


    <div class="table_div">
        <table class="table_button_list">
            <tr>
                <td width="100%" align="center">
                   	<s:i18n name="public">
                   	<s:if test="view == disabled">
                    <input type="button" id="btnSave" name="btnSave" class="button_Save" onmouseover="buttonover(this);" 
                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_save"/>" onclick="doSave('/promotion/spproposal_save.do')"
                           <s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if>
                           />
                    </s:if>
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturnInFrame('/promotion/spproposal_list.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
</body>
</html>
