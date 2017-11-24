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
            addfield('form.seqid', '<s:text name="seqid"/>', 'f', false, 14);
			addfield('form.worktype', '<s:text name="worktype"/>', 'c', true, 256);
			addfield('form.applyno', '<s:text name="applyno"/>', 'f', true, 14);
			addfield('form.stepid', '<s:text name="stepid"/>', 'c', true, 64);
			addfield('form.createtime', '<s:text name="createtime"/>', 't', true, 7);
			addfield('form.oprcode', '<s:text name="oprcode"/>', 'c', true, 15);
			addfield('form.optime', '<s:text name="optime"/>', 't', true, 7);
			addfield('form.content', '<s:text name="content"/>', 'c', true, 512);
			addfield('form.auditstatus', '<s:text name="auditstatus"/>', 'f', true, 2);
            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<s:form action="auditwork_save.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">
			
    <s:hidden name="isNew"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param._ne_seqid"/>
    <s:hidden name="param._se_worktype"/>
    <s:hidden name="param._sk_worktype"/>
    <s:hidden name="param._se_stepid"/>
    <s:hidden name="param._dnm_createtime"/>
    <s:hidden name="param._dnl_createtime"/>
    <s:hidden name="param._se_oprcode"/>
    <s:hidden name="param._ne_auditstatus"/>
	
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
			<span class="button_Help" onclick="openword('<s:text name="helpTitle"/>','<s:text name="helpContentWay"/>')"><s:i18n name="public"><s:text name="help"/></s:i18n></span>
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
                <td align="right"><s:text name="seqid"/>:&nbsp</td>
                <td align="left">
			        <s:if test="CMD=='NEW'">
                        <s:textfield cssStyle="style_input" name="form.seqid" maxlength="14"/>
                        <font color=red>*</font>
			        </s:if>
			        <s:else>
						<s:textfield cssStyle="style_input" name="form.seqid" disabled="true"/>
						<font color=red>*</font>
			        </s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="worktype"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.worktype" maxlength="256"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="applyno"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.applyno" maxlength="14"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="stepid"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.stepid" maxlength="64"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="createtime"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.createtime" maxlength="10"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="oprcode"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.oprcode" maxlength="15"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="optime"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.optime" maxlength="7"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="content"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.content" maxlength="512"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="auditstatus"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.auditstatus" maxlength="2"/>
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
                           value="<s:text name="button_save"/>" onclick="doSave('/channel/auditwork_save.do')"/>
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/channel/auditwork_list.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
</body>
</html>
