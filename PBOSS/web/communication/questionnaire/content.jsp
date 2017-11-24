<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK" %>
<%@ include file="/inc/contenthead.inc"%>
<%@ taglib prefix="j" uri="/jop-tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A6FBT14" />
</jsp:include>
<html>
<head>
    <title><s:text name="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
        var content = getEditorTextContents('form.content');
        	if(Trim(content).length == 0){
        	var errMsg ='<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[发布消息内容]</span> 不允许为空 </span>';
        	errorMessageShow(errMsg);
        	return false;
        	}
			addfield('form.title', '<s:text name="title"/>', 'c', false, 256);
			//addfield('form.content', '<s:text name="content"/>', 'c', false);
			addfield('form.releasetime', '<s:text name="releasetime"/>', 't', false, 7);
			addfield('form.plantime', '<s:text name="plantime"/>', 't', false, 7);
			addfield('form.enddate', '<s:text name="enddate"/>', 't', false, 7);
			addfield('form.smsnotify', '<s:text name="smsnotify"/>', 'f', false, 2);
			addfield('form.ndapproval', '<s:text name="ndapproval"/>', 'f', false, 2);
			addfield('form.oprcode', '<s:text name="oprcode"/>', 'c', false, 18);
			addfield('form.state', '<s:text name="state"/>', 'f', false, 3);
			addfield('form.desttype', '<s:text name="desttype"/>', 'f', false, 3);
			var desttype = $("#desttype").val();
			if(desttype=='4'||desttype=='5')
			{
				addfield('form.objinfo', '<s:text name="objselect"/>', 'c', false, 100000);
			}
            return (checkval(window) && compareDate());
        }
        
        
               // 获取编辑器中文字内容
function getEditorTextContents(EditorName) { 
    var oEditor = FCKeditorAPI.GetInstance(EditorName); 
    return(oEditor.EditorDocument.body.innerText); 
}
        
        function compareDate(){
        	var releasetime = document.getElementById('releasetime').value;
        	var enddate = document.getElementById('enddate').value;
        	
        	if(releasetime != '' && enddate != '' && releasetime > enddate){
	        	var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[<s:text name="enddate"/>]</span>不能小于<span style=\'color:#F00; font-size:12px;\'>[<s:text name="releasetime"/>]</span></span>';
				errorMessageShow(alertstr);
				return false;
        	}
        	
        	var currentdate = document.getElementById('currentdate').value;
        	
        	if(currentdate != '' && enddate != '' && currentdate > enddate){
	        	var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[<s:text name="enddate"/>]</span>不能小于<span style=\'color:#F00; font-size:12px;\'>[<s:text name="currentdate"/>]</span></span>';
				errorMessageShow(alertstr);
				return false;
        	}
        	return true;
        }
        
        function openPic(obj)
        {
        	var desttype = $("#desttype").val();
        	if(desttype=='4')
			{
				showMultiOpr();
			}
			else if(desttype=='5')
			{
				openPicker(obj,'#ADVGROUP','');
			}
        }
        
        function showMultiOpr() {
        	var opercode = $("#objinfo").get(0);
			var originalValue = opercode.value;
			//获取标识符字符串
			var str = "";
			if(originalValue!="")
			{
				var valArray = originalValue.split(",");
				for(var i=0; i<valArray.length; i++)
				{
					str = str + valArray[i].split(" ")[0] + ",";
				}
			}
			
			$("#selectedStr").val(str);
			var strUrl = contextPath + "/common/multiselect_showopr.do?SELECTEDSTR=" + str;
			var ret = window.showModalDialog(strUrl, self, "dialogWidth:800px; dialogHeight:500px; status:no; resizable:no;");
			if ('NULL' != ret) {
				opercode.value = ret;
			}
			return ret;
		}
		
		function objDisplay()
		{
			$("#objinfo").val("");
			objShow();
		}
		
		function objShow()
		{
			var desttype = $("#desttype").val();
			if(desttype=='4'||desttype=='5')
			{
				$("#objTd1").show();
				$("#objTd2").show();
			}
			else
			{
				$("#objTd1").hide();
				$("#objTd2").hide();
			}
		}
		
		function removeFile(obj)
		{
			$("#delAffixs").val(obj.affixInfo);
			$(obj).parent().html('<input type="file" name="doc" />');
		}
		
		$(document).ready(function(){
			if($("#cmd").val()!="NEW")
        	{
        		var smsnotify = $("#smsnotify").val();
        		$("#smsnotify").children().each(function(i){
        			if($(this).val() == smsnotify)
        			{
        				var str = $(this).html() + '<input type="hidden" name="form.smsnotify" value="' + smsnotify + '"/>';
        				$("#smsnotify").parent().html(str);
        			}
        		});
        	}
        	
			//移除全社会和渠道经理选项
			$("#desttype").children().eq(7).remove();
			$("#desttype").children().eq(6).remove();
			$("#desttype").children().eq(1).remove();
			objShow();
		}); 

		function doDownload(cmdDownload) {
      		formItem.action = contextPath + cmdDownload;
      	    formItem.submit();
      	}
    </script>

</head>
<body>
<div class="table_container">
<s:form action="questionnaire_save.do" cssStyle="formList" key="formItem" enctype="multipart/form-data"
			method="post" theme="simple" onsubmit="return ev_checkval();">
	<input type="hidden" id="selectedStr" />
			
    <s:hidden name="CMD" id="cmd"/>
    <s:hidden name="form.type"/>
    <s:hidden name="form.url"/>
    <s:hidden name="form.advinfoid"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param._ne_advinfoid"/>
    <s:hidden name="param._se_title"/>
    <s:hidden name="param._se_content"/>
    <s:hidden name="param._ne_type"/>
    <s:hidden name="param._de_releasetime"/>
    <s:hidden name="param._de_plantime"/>
    <s:hidden name="param._dnm_enddate"/>
    <s:hidden name="param._ne_desttype"/>
    <s:hidden name="param._ne_smsnotify"/>
    <s:hidden name="param._ne_ndapproval"/>
    <s:hidden name="param._se_oprcode"/>
    <s:hidden name="param._ne_state"/>
    <s:hidden name="param._pk"/>
	
	<s:hidden name="form.delAffixs" id="delAffixs"/>
	
	<s:hidden name="downloadReturnActionName" value="questionnaire_Edit"/>
    <s:hidden name="downloadReturnMethod" value="doEdit"/>
    
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="base"/> </span>
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
                <td align="left">
					&nbsp;&nbsp;带<font color=red>*</font>号为必填项，带<font color=red>#</font>号为系统生成项
                </td>
            </tr>
    	</table>
    </div> 
	<span>&nbsp;&nbsp;<s:text name="advtitle"/>:&nbsp</span>
    <div class="table_div">
        <table class="table_normal">
            
            <tr>
                <td align="right"><s:text name="title"/>:&nbsp</td>
                <td align="left" colspan="3">
					<s:textfield cssStyle="width:400px" name="form.title" maxlength="256"/>
					<font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="content"/>:&nbsp</td>
                <td align="left" colspan="3">
                	<FCK:editor instanceName="form.content">
                	<jsp:attribute name="value"><s:property value="form.content" escape="false"/></jsp:attribute>
					</FCK:editor>
					<font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td align="right" width="20%"><s:text name="releasetime"/>:&nbsp</td>
                <td align="left" width="30%">
                	<s:i18n name="public">
						<input class="style_input" id="releasetime" name="form.releasetime" value="<s:property value="form.releasetime!=null?getText('format.date',{form.releasetime}):''"/>"" maxlength="10" onclick="selectDate()"/>
						<font color=red>*</font>
					</s:i18n>
                </td>
                <td align="right" width="20%"><s:text name="enddate"/>:&nbsp</td>
                <td align="left" width="30%">
	                <s:i18n name="public">
	                	<input type="hidden" id="currentdate" value="<s:property value="form.currentdate!=null?getText('format.date',{form.currentdate}):''"/>" />
						<input class="style_input" id="enddate" name="form.enddate" value="<s:property value="form.enddate!=null?getText('format.date',{form.enddate}):''"/>" maxlength="10" onclick="selectDate()"/>
						<font color=red>*</font>
					</s:i18n>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="smsnotify"/>:&nbsp</td>
                <td align="left" colspan="3">
                	<j:selector definition="SMSNOTIFY" name="form.smsnotify" id="smsnotify" cssStyle="width:50px"/>
					<font color=red>*</font>
                </td>
            </tr>
        </table>
    </div>
    <span>&nbsp;&nbsp;<s:text name="filetitle"/>:&nbsp</span>
    <div class="table_div">
        <table class="table_normal">
        	<s:if test="CMD == WEB_CMD_EDIT">
	           	<s:if test="form.advaffixList.size>0">
	           		<s:iterator value="form.advaffixList">
			            <tr>
			                <td align="left" width="20%">
			                	<a href='javascript:doDownload("/communication/questionnaire_affixDownload.do?affixid=<s:property value="affixid"/>")'> 
									<s:property value="affixname"/>
								</a>
			                	<s:i18n name="public">
				                	<input type="button" id="btnDelete" name="btnDelete" class="button_Delete" onmouseover="buttonover(this);"
				                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
				                        value="<s:text name="button_delete"/>" affixInfo="<s:property value="affixid"/>,<s:property value="affixpath"/>" onClick="removeFile(this)">
			                    </s:i18n>
			                </td>
			            </tr>
		           	</s:iterator>
	           	</s:if>
            	<s:else>
            		<tr>
		                <td align="left" width="20%">
		                	<s:file name="doc" label="File" />
		                </td>
	            	</tr>
            	</s:else>
            </s:if>
            <s:elseif test="CMD == WEB_CMD_SAVE">
            	<s:if test="form.advaffixList.size>0">
            		<s:iterator value="form.advaffixList">
		            <tr>
		                <td align="left" width="20%">
		                	<a href='javascript:doDownload("/communication/questionnaire_affixDownload.do?affixid=<s:property value="affixid"/>")'> 
								<s:property value="affixname"/>
							</a>
		                </td>
		            </tr>
	            	</s:iterator>
            	</s:if>
            	<s:else>
            		<tr>
		                <td align="left" width="20%">
		                	<s:file name="doc" label="File" />
		                </td>
	            	</tr>
            	</s:else>
            </s:elseif>
            <s:elseif test="CMD == WEB_CMD_NEW">
	            <tr>
	                <td align="left" width="20%">
	                	<s:file name="doc" label="File" />
	                </td>
	            </tr>
            </s:elseif>
    	</table>
    </div>
	<span>&nbsp;&nbsp;<s:text name="objtitle"/>:&nbsp</span>
	<div class="table_div">
        <table class="table_normal">
            <tr>
                <td align="right" width="20%"><s:text name="desttype"/>:&nbsp</td>
                <td align="left">
                	<j:selector definition="$CH_ADVINFODESTTYPE" name="form.desttype" id="desttype" onchange="objDisplay()"/>
					<font color=red>*</font>
                </td>
                <td align="right" width="20%" id="objTd1" style="display:none"><s:text name="objselect"/>:&nbsp</td>
                <td align="left" id="objTd2" style="display:none">
					<s:textfield cssStyle="style_input" name="form.objinfo" cssClass="objinfo" id="objinfo"/>
					<input type="button" name="form.objinfo_button" class="picker_button" value="..." onclick="openPic(this)"/>
					<font color=red>*</font>
                </td>
            </tr>
    	</table>
    </div> 
    <div class="table_div">
        <table class="table_button_list">
            <tr>
                <td width="100%" align="center">
                   	<s:i18n name="public">
                    <input type="button" id="btnSave" name="btnSave" class="button_Save" onmouseover="buttonover(this);" 
                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_save"/>" onclick="doSave('/communication/questionnaire_save.do')"
							<s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if>
                           />
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/communication/questionnaire_list.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
</body>
</html>
