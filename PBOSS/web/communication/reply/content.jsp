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
            addfield('form.replyid', '<s:text name="replyid"/>', 'f', false, 14);
			addfield('form.advinfoid', '<s:text name="advinfoid"/>', 'f', true, 14);
			addfield('form.replytime', '<s:text name="replytime"/>', 't', true, 7);
			addfield('form.replycontent', '<s:text name="replycontent"/>', 'c', true, 256);
			addfield('form.affix', '<s:text name="affix"/>', 'c', true, 40);
			addfield('form.oid', '<s:text name="oid"/>', 'c', true, 18);
            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<s:form action="reply_save.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">
			
    <s:hidden name="isNew"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param._ne_replyid"/>
    <s:hidden name="param._ne_advinfoid"/>
    <s:hidden name="param._dnm_replytime"/>
    <s:hidden name="param._de_replytime"/>
    <s:hidden name="param._dnl_replytime"/>
    <s:hidden name="param._se_affix"/>
    <s:hidden name="param._se_oid"/>
	
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
                <td align="right"><s:text name="replyid"/>:&nbsp</td>
                <td align="left">
			        <s:if test="isNew">
                        <s:textfield cssStyle="style_input" name="form.replyid" maxlength="14"/>
                        <font color=red>*</font>
			        </s:if>
			        <s:else>
						<s:textfield cssStyle="style_input" name="form.replyid" disabled="true"/>
						<font color=red>*</font>
			        </s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="advinfoid"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.advinfoid" maxlength="14"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="replytime"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.replytime" maxlength="7"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="replycontent"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.replycontent" maxlength="256"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="affix"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.affix" maxlength="40"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="oid"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.oid" maxlength="18"/>
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
                           value="<s:text name="button_save"/>" onclick="doSave('/communication/reply_save.do')"/>
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/communication/reply_list.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
</body>
</html>
