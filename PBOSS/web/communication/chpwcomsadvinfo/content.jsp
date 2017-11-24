<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
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
	addfield('form.rcvobjtype', '<s:text name="rcvobjtype"/>', 'c', false, 32);
	return checkval(window);
}

function getEditorTextContents(EditorName) { 
    var oEditor = FCKeditorAPI.GetInstance(EditorName); 
    return(oEditor.EditorDocument.body.innerText); 
}

function doAffixDownload() {
	formItem.action = "<%=contextPath %>/communication/chpwcomsadvinfo_affixDownload.do";
    formItem.submit();
    formItem.action = "<%=contextPath %>/communication/chpwcomsadvinfo_save.do";
}
</script>
</head>
<body>
<div class="table_container">
<s:form action="chpwcomsadvinfo_save.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();" enctype="multipart/form-data">
			
    <s:hidden name="CMD"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param._sk_title"/>
    <s:hidden name="param._dnm_releasetime"/>
    <s:hidden name="param._dnl_releasetime"/>
    <s:hidden name="param._ne_state"/>
    <s:hidden name="form.advinfoid"/>
    <s:hidden name="form.releasetime"/>
    <s:hidden name="form.affixname"/>
    <s:hidden name="form.affixpath"/>
    <s:hidden name="form.releasecode"/>
    <s:hidden name="form.state"/>
	
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="communication"/> </span>
			<span class="table_toparea_xi">></span>
			</s:i18n>
			<span class="table_toparea_h"><s:text name="titleList"/></span>
			<span class="button_Help" onclick="openword('<s:text name="helpTitle"/>','<s:text name="helpContent"/>')"><s:i18n name="public"><s:text name="help"/></s:i18n></span>
		</div>
	</div>

	<div class="error_text" >
		<table class="error_text">
			<font color=red><s:actionerror /></font><s:actionmessage/>
		</table>
	</div>
	
    <div class="table_div">
        <table class="table_normal">
            <tr>
                <td align="right"><s:text name="title"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="width:400px" name="form.title" maxlength="256"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="width:400px" name="form.title" disabled="true"/>
					</s:else>
					<font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="content"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<FCK:editor instanceName="form.content">
	                	 <jsp:attribute name="value"><s:property value="form.content" escape="false"/></jsp:attribute>
						</FCK:editor>
					</s:if>
					<s:else>
						<FCK:editor instanceName="form.content">
	                	 <jsp:attribute name="value"><s:property value="form.content" escape="false"/></jsp:attribute>
						</FCK:editor>
					</s:else>
					<font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="affix"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE && (form.state == 1 || form.state == null)">
						<s:file name="affix"></s:file>
					</s:if>
					<a href="javascript:doAffixDownload();"><s:property value="form.affixname" /></a>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="smsnotify"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:select name="form.smsnotify" theme="simple" listKey="key"
							listValue="value" list="#{'0':'否', '1':'是'}" cssStyle="select"/>
					</s:if>
					<s:else>
						<s:select name="form.smsnotify" theme="simple" listKey="key"
							listValue="value" list="#{'0':'否', '1':'是'}" cssStyle="select" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="rcvobjtype"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.rcvobjtype" definition="COMSRCVOBJ_RCVOBJTYPE" cssStyle="select" />
					</s:if>
					<s:else>
						<j:selector name="form.rcvobjtype" definition="COMSRCVOBJ_RCVOBJTYPE" cssStyle="select" disabled="true" />
					</s:else>
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
                           value="<s:text name="button_save"/>" onclick="doSave('/communication/chpwcomsadvinfo_save.do')"
                           <s:if test="form.state == 2 || form.state == 3 || CMD == WEB_CMD_SAVE">disabled = "true"</s:if>
                           />
                    <input type="button" id="btnSave" name="btnSave" class="button_New" onmouseover="buttonover(this);" 
                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="发布" onclick="doSave('/communication/chpwcomsadvinfo_saveRelease.do')"
                           <s:if test="form.state == 2 || form.state == 3">disabled = "true"</s:if>
                           />
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/communication/chpwcomsadvinfo_list.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
</body>
</html>