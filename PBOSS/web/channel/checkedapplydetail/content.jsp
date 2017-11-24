<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A6FBT14" />
</jsp:include>
<html>
<head>
    <title><s:text name="titleUpdate"/></title>
</head>
<body>
<div class="table_container">
<s:form action="checkedapplydetail_save.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">
			
    <s:hidden name="CMD"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
	
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
	
    <div class="table_div">
        <table class="table_normal">
            <tr>
                <td align="right"><s:text name="seq"/>:&nbsp</td>
                <td align="left">
			        <s:textfield cssStyle="style_input" name="form.seq" disabled="true"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="applyno"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.applyno" disabled="true"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="oprcode"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.oprcode" disabled="true"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="applytype"/>:&nbsp</td>
                <td align="left">
                	<s:hidden name="form.applytype"/>
                	<j:code2Name code="form.applytype" definition="$CH_CHECKTYPE" />
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="wayid"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.wayid" disabled="true"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="chktype"/>:&nbsp</td>
                <td align="left">
					<j:selector definition="$CH_ASSESSMTHD"	name="form.chktype" />
					<font color="red">*</font>
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
                           value="<s:text name="button_save"/>" onclick="doSave('/channel/checkedapplydetail_save.do')"
                           <s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if>
                           <s:if test="status == 1 "> disabled="true" </s:if>
                           />
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/channel/checkedapplydetail_list.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
</body>
</html>
<script language="JavaScript">
	function ev_checkval() {
		addfield('form.seq', '<s:text name="seq"/>', 'f', false, 14);
		//addfield('form.applyno', '<s:text name="applyno"/>', 'f', true, 14);
		//addfield('form.cityid', '<s:text name="cityid"/>', 'c', true, 3);
		//addfield('form.aptime', '<s:text name="aptime"/>', 't', true, 7);
		//addfield('form.oprcode', '<s:text name="oprcode"/>', 'c', true, 30);
		//addfield('form.applytype', '<s:text name="applytype"/>', 'c', true, 2);
		addfield('form.wayid', '<s:text name="wayid"/>', 'c', true, 18);
		addfield('form.chktype', '<s:text name="chktype"/>', 'c', true, 2);
		//addfield('form.chgtype', '<s:text name="chgtype"/>', 'c', true, 2);
		return checkval(window);
	}
</script>