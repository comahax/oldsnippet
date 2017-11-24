<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<script type="text/javascript" src="<%=contextPath%>/js/pub/content.js"></script>
<%@ taglib prefix="j" uri="/jop-tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK" %>
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
			//addfield('form.content', '<s:text name="content"/>', 'c', false, 2048);
			addfield('form.releasetime', '<s:text name="releasetime"/>', 't', false, 7);
			addfield('form.plantime', '<s:text name="plantime"/>', 't', false, 7);
			addfield('form.enddate', '<s:text name="enddate"/>', 't', false, 7);
			addfield('form.smsnotify', '<s:text name="smsnotify"/>', 'f', false, 2);
			addfield('form.ndapproval', '<s:text name="ndapproval"/>', 'f', false, 2);
			addfield('form.oprcode', '<s:text name="oprcode"/>', 'c', false, 18);
			addfield('form.state', '<s:text name="state"/>', 'f', false, 3);
			addfield('form.desttype', '<s:text name="desttype"/>', 'f', false, 3);
            return checkval(window);
        }
        
               // 获取编辑器中文字内容
function getEditorTextContents(EditorName) { 
    var oEditor = FCKeditorAPI.GetInstance(EditorName); 
    return(oEditor.EditorDocument.body.innerText); 
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
			
			var arg = new Array();
			var strUrl = contextPath + "/common/multiselect_showopr.do?SELECTEDSTR=" + str;
			var ret = window.showModalDialog(strUrl, arg, "dialogWidth:800px; dialogHeight:500px; status:no; resizable:no;");
			if ('NULL' != ret && '' != ret) {
				opercode.value = ret;
			}
			return ret;
		}
		
		function objDisplay()
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
				$("#objinfo").val("");
			}
		}
		
		function removeFile(obj)
		{
			$("#delAffixs").val(obj.affixInfo);
			$(obj).parent().html('<input type="file" name="doc" />');
		}
		
		$(document).ready(function(){
			//移除全社会和渠道经理选项
			$("#desttype").children().eq(1).remove();
			$("#desttype").children().eq(5).remove();
			
			objDisplay();
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
	<%//下面的控件给Action提供数据，用来分页%>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param.queryAll"/>
    		
    <s:hidden name="CMD"/>
    <s:hidden name="form.type"/>
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
	
	<s:hidden name="downloadReturnActionName" value="questionnaire_View"/>
    <s:hidden name="downloadReturnMethod" value="doView"/>
    
	<s:hidden name="form.delAffixs" id="delAffixs"/>
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
			<span class="button_Help" onclick="openword('<s:text name="helpTitle"/>','<s:text name="helpContent"/>')"><s:i18n name="public"><s:text name="help"/></s:i18n></span>
		</div>
	</div>

	<div class="error_text" >
		<table class="error_text">
			<s:actionerror /><s:actionmessage/>
		</table>
	</div>
	
	<span>&nbsp;&nbsp;<s:text name="advtitle"/>:&nbsp</span>
    <div class="table_div">
        <table class="table_normal">
            <tr>
                <td align="right" width="20%"><s:text name="advinfoid"/>:&nbsp</td>
                <td align="left" width="80%" colspan="3">
                	<s:property value="form.advinfoid"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="title"/>:&nbsp</td>
                <td align="left" colspan="3">
                	<s:property value="form.title"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="content"/>:&nbsp</td>
                <td align="left" colspan="3">
                	<FCK:editor instanceName="form.content">
                	<jsp:attribute name="value"><s:property value="form.content" escape="false"/></jsp:attribute>
					</FCK:editor>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="state"/>:&nbsp</td>
                <td align="left" colspan="3">
                	<j:code2Name definition="$CH_ADVINFOSTATE" code="form.state"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="releasetime"/>:&nbsp</td>
                <td align="left">
                	<s:i18n name="public">
                		<s:property value="form.releasetime!=null?getText('format.date',{form.releasetime}):''"/>
					</s:i18n>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="enddate"/>:&nbsp</td>
                <td align="left">
                	<s:i18n name="public">
                		<s:property value="form.enddate!=null?getText('format.date',{form.enddate}):''"/>
					</s:i18n>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="releaseid"/>:&nbsp</td>
                <td align="left" colspan="3">
                	<s:property value="form.oprcode"/>
                </td>
            </tr>
        </table>
    </div>
    <span>&nbsp;&nbsp;<s:text name="filetitle2"/>:&nbsp</span>
    <div class="table_div">
        <table class="table_normal">
           	<s:if test="form.advaffixList.size>0">
           		<s:iterator value="form.advaffixList">
	            <tr>
	            	<td align="right" width="20%">
	                	<s:text name="affix"/>:
	                </td>
	                <td align="left" width="80%">
	                	<a href='javascript:doDownload("/communication/questionnaire_affixDownload.do?affixid=<s:property value="affixid"/>")'> 
							<s:property value="affixname"/>
						</a>
	                </td>
	            </tr>
            	</s:iterator>
           	</s:if>
           	<s:else>
           		<tr>
	                <td align="left">
	                	&nbsp;
	                </td>
            	</tr>
           	</s:else>
    	</table>
    </div>
	<span>&nbsp;&nbsp;<s:text name="replyinfo"/>:&nbsp</span>
	<aa:zone name="listZone">
    <div class="table_div">
        <table class="table_normal">
            <s:iterator value="dp.datas">
	            <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
	                <td align="left">
	                <s:i18n name="public">
                		<s:property value="replytime!=null?getText('format.datetime',{replytime}):''"/>
					</s:i18n>
	                </td>
	                <td align="left"><s:property value="oid"/><s:text name="reply"/>：
	                <a href='javascript:doDownload("/communication/questionnaire_affixDownloadByPath.do?filePath=<s:property value="affix"/>")'> 
	                	<s:property value="affix"/>
	                </a>
	                </td>
	            </tr>
            </s:iterator>
        </table>
    </div>
    <div class="table_div">
		<%@ include file="/common/pageNav.jsp"%>
   	</div>
    </aa:zone>
	
    <div class="table_div">
        <table class="table_button_list">
            <tr>
                <td width="100%" align="center">
                   	<s:i18n name="public">
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
<script language="javascript"> 
	ajaxAnywhere.getZonesToReload = function(url,submitButton) {
		return "listZone";  
	}
</script> 
</body>
</html>
