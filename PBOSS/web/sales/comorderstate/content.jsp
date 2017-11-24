<%@ page language="java" contentType="text/html;charset=GBK"%>
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
			addfield('form.cityid', '<s:text name="cityid"/>', 'c', true, 20);
			addfield('form.comcategory', '<s:text name="comcategory"/>', 'c', false, 20);
			addfield('form.orderstate', '<s:text name="orderstate"/>', 'c', false, 16);
			if($("#orderstate").val()!="NORMAL"&&$("#orderstate").val()!="")
			{
				addfield('form.msgcontent', '<s:text name="msgcontent"/>', 'c', false, 256);
			}
			else
			{
				addfield('form.msgcontent', '<s:text name="msgcontent"/>', 'c', true, 256);
			}
			addfield('form.memo', '<s:text name="memo"/>', 'c', true, 256);
            return checkval(window);
        }
		
    </script>
</head>
<body>
<div class="table_container">
<s:form action="comorderstate_save.do" cssStyle="formList" key="formItem"
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
			<span class="table_toparea"><s:text name="sales"/> </span>
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
                <td colspan="2">带<font color=red>*</font>的为必填:&nbsp</td>
            </tr>
            <tr>
                <td align="right"><s:text name="recid"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.recid" disabled="true"/>
					<font color=red>*</font>
					<s:text name="label1"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="city"/>:&nbsp</td>
                <td align="left">
					<j:selector definition="#CITYCOMPANY" mode="selector" name="form.cityid" condition="citycompid:${cityid}" value="${cityid}" disabled="true"/>
					<font color=red>*</font>
					<s:text name="label2"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="comcategory"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="$IM_FXCOMCATEGORY" name="form.comcategory" mode="picker"/>
						<font color=red>*</font>
					</s:if>
					<s:else>
						<j:selector definition="$IM_FXCOMCATEGORY" name="form.comcategory" mode="picker" disabled="true"/>
						<font color=red>*</font>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="orderstate"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="$FX_COMORDERSTATE" id="orderstate" mode="selector" name="form.orderstate"/>
						<font color=red>*</font>
					</s:if>
					<s:else>
						<j:selector definition="$FX_COMORDERSTATE" mode="selector" name="form.orderstate" disabled="true"/>
						<font color=red>*</font>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="msgcontent"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textarea name="form.msgcontent" cssStyle="style_input" rows="8" cols="80" maxlength="256"></s:textarea>
						<br><s:text name="label3"/>
					</s:if>
					<s:else>
						<s:textarea name="form.msgcontent" cssStyle="style_input" rows="8" cols="80" maxlength="256" disabled="true"></s:textarea>
						<br><s:text name="label3"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="memo"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.memo" maxlength="256"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.memo" disabled="true"/>
					</s:else>
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
                           value="<s:text name="button_save"/>" onclick="doSave('/sales/comorderstate_save.do')"
                           <s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if>
                           />
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/sales/comorderstate_list.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
</body>
</html>
