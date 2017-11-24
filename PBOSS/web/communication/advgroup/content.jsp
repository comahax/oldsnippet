<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A6FBT14" />
</jsp:include>
<html>
<head>
    <title><s:text name="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('form.groupid', '<s:text name="groupid"/>', 'f', true, 14);
			addfield('form.groupname', '<s:text name="groupname"/>', 'c', false, 40);
			addfield('form.objinfo', '<s:text name="groupobj"/>', 'c', false, 2048);
            return checkval(window);
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
			var strUrl = contextPath + "/common/multiselect_showopr.do";
			//window.open(strUrl);
			var ret = window.showModalDialog(strUrl, self, "dialogWidth:800px; dialogHeight:500px; status:no; resizable:no;");
			if ('NULL' != ret) {
				opercode.value = ret;
			}
			return ret;
		}
    </script>
</head>
<body>
<div class="table_container">
<s:form action="advgroup_save.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">
	<input type="hidden" id="selectedStr" />
			
    <s:hidden name="CMD" id="cmd"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param._ne_groupid"/>
    <s:hidden name="param._se_groupname"/>
    <s:hidden name="form.groupid"/>
	
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
	<span>&nbsp;&nbsp;<s:text name="titleGroup"/>:&nbsp</span>
	
    <div class="table_div">
        <table class="table_normal">
            
            <tr>
                <td align="right"><s:text name="groupname"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.groupname" maxlength="40"/>
					<font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="groupobj"/>:&nbsp</td>
                <td align="left">
                	<s:textarea name="form.objinfo" id="objinfo" cssStyle="style_input" rows="8" cols="80" maxlength="2048" disabled="true"></s:textarea><input type="button" class="picker_button" value="..." onClick="showMultiOpr()"/>
					<font color=red>*</font>
					<br><s:text name="formatDesc"/>
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
                           value="<s:text name="button_save"/>" onclick="doSave('/communication/advgroup_save.do')"
                           <s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if> 
                           />
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/communication/advgroup_list.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
</body>
</html>
