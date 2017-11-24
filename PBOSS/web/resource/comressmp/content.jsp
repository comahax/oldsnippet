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
            addfield('form.comresid', '<s:text name="comresid"/>', 'c', false, 32);
            addfield('form.comid', '<s:text name="comid"/>', 'f', false, 18);
			addfield('form.batchno', '<s:text name="batchno"/>', 'c', true, 30);
			addfield('form.comstate', '<s:text name="comstate"/>', 'f', true, 3);
			addfield('form.wayid', '<s:text name="wayid"/>', 'c', true, 18);
			addfield('form.oprcode', '<s:text name="oprcode"/>', 'c', true, 15);
			addfield('form.starttime', '<s:text name="starttime"/>', 't', true, 7);
			addfield('form.validperiod', '<s:text name="validperiod"/>', 't', true, 7);
			addfield('form.comkeep', '<s:text name="comkeep"/>', 't', true, 7);
			addfield('form.comdisc', '<s:text name="comdisc"/>', 'f', true, 14);
			addfield('form.price', '<s:text name="price"/>', 'f', true, 14);
			addfield('form.comactive', '<s:text name="comactive"/>', 't', true, 7);
			addfield('form.comsource', '<s:text name="comsource"/>', 'f', true, 8);
			addfield('form.stockprice', '<s:text name="stockprice"/>', 'f', true, 14);
			addfield('form.simprice', '<s:text name="simprice"/>', 'f', true, 14);
			addfield('form.isopen', '<s:text name="isopen"/>', 'f', true, 3);
			addfield('form.iccid', '<s:text name="iccid"/>', 'c', true, 21);
			addfield('form.brand', '<s:text name="brand"/>', 'c', true, 16);
			addfield('form.boxnum', '<s:text name="boxnum"/>', 'c', true, 100);
			addfield('form.entertime', '<s:text name="entertime"/>', 't', true, 7);
			addfield('form.numbertype', '<s:text name="numbertype"/>', 'c', true, 10);
			addfield('form.resuse', '<s:text name="resuse"/>', 'c', true, 20);
			addfield('form.storarea', '<s:text name="storarea"/>', 'c', true, 10);
            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<s:form action="comressmp_save.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">
			
    <s:hidden name="CMD"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param._se_wayid"/>
    <s:hidden name="param._se_brand"/>
	
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="resource"/> </span>
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
                <td align="right"><s:text name="comresid"/>:&nbsp</td>
                <td align="left">
			        <s:if test="CMD == WEB_CMD_NEW">
                        <s:textfield cssStyle="style_input" name="form.comresid" maxlength="32"/>
                        <font color=red>*</font>
			        </s:if>
			        <s:else>
						<s:textfield cssStyle="style_input" name="form.comresid" disabled="true"/>
						<font color=red>*</font>
			        </s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="comid"/>:&nbsp</td>
                <td align="left">
			        <s:if test="CMD == WEB_CMD_NEW">
                        <s:textfield cssStyle="style_input" name="form.comid" maxlength="18"/>
                        <font color=red>*</font>
			        </s:if>
			        <s:else>
						<s:textfield cssStyle="style_input" name="form.comid" disabled="true"/>
						<font color=red>*</font>
			        </s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="batchno"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.batchno" maxlength="30"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="comstate"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.comstate" maxlength="3"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="wayid"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.wayid" maxlength="18"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="oprcode"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.oprcode" maxlength="15"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="starttime"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.starttime" maxlength="7"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="validperiod"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.validperiod" maxlength="7"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="comkeep"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.comkeep" maxlength="7"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="comdisc"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.comdisc" maxlength="14"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="price"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.price" maxlength="14"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="comactive"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.comactive" maxlength="7"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="comsource"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.comsource" maxlength="8"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="stockprice"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.stockprice" maxlength="14"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="simprice"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.simprice" maxlength="14"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="isopen"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.isopen" maxlength="3"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="iccid"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.iccid" maxlength="21"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="brand"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.brand" maxlength="16"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="boxnum"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.boxnum" maxlength="100"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="entertime"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.entertime" maxlength="7"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="numbertype"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.numbertype" maxlength="10"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="resuse"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.resuse" maxlength="20"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="storarea"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.storarea" maxlength="10"/>
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
                           value="<s:text name="button_save"/>" onclick="doSave('/resource/comressmp_save.do')" <s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if>/>
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/resource/comressmp_list.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
</body>
</html>
