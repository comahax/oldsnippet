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
<s:form action="busicircle_save.do" cssStyle="formList" key="formItem"
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
			<span class="table_toparea"><s:text name="channel"/> </span>
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
                <td align="right"><s:text name="buscno"/>:&nbsp</td>
                <td align="left">
			        <s:if test="CMD == WEB_CMD_NEW">
                        <s:textfield cssStyle="style_input" name="form.buscno" maxlength="18"/>
                        <font color=red>*</font>
			        </s:if>
			        <s:elseif test="CMD == WEB_CMD_EDIT">
			        	<s:textfield cssStyle="style_input" name="form.buscno" disabled="true"/>
						<font color=red>*</font>
					</s:elseif>
			        <s:else>
						<s:textfield cssStyle="style_input" name="form.buscno" disabled="true"/>
						<font color=red>*</font>
			        </s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="buscname"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.buscname" maxlength="256"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.buscname" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="buscelevel"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.buscelevel" definition="$CH_BUSCLEVEL"/>
					</s:if>
					<s:else>
						<j:selector name="form.buscelevel" definition="$CH_BUSCLEVEL" disabled="true"/>
					</s:else>
					<font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="countyid"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="#CNTYCOMPANY" name="form.countyid" condition="citycompid:${dBAccessUser.cityid }"/>
					</s:if>
					<s:else>
						<j:selector definition="#CNTYCOMPANY" name="form.countyid"
											disabled="true" />
					</s:else>
					<font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="cityid"/>:&nbsp</td>
                <td align="left">					
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="#CITYCOMPANY" name="form.cityid" mode="selector" condition="citycompid:${dBAccessUser.cityid }"   disabled="true" readonly="true"/>
					</s:if>
					<s:else>
						<j:selector definition="#CITYCOMPANY" name="form.cityid"
											disabled="true" />
					</s:else>
					<font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="buscaddr"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textarea cssStyle="style_input" name="form.buscaddr" maxlength="128"
						cols="50" rows="5"/>
					</s:if>
					<s:else>
						<s:textarea cssStyle="style_input" name="form.buscaddr" disabled="true"
						cols="50" rows="5"/>
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
                           value="<s:text name="button_save"/>" onclick="doSave('/channel/busicircle_save.do')"
                           <s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if>
                           />
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/channel/busicircle_list.do')">
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
		addfield('form.buscno', '<s:text name="buscno"/>', 'c', false, 18);
		addfield('form.buscname', '<s:text name="buscname"/>', 'c', true, 256);
		addfield('form.buscelevel', '<s:text name="buscelevel"/>', 'c', false, 3);
		addfield('form.countyid', '<s:text name="countyid"/>', 'c', false, 14);
		addfield('form.cityid', '<s:text name="cityid"/>', 'c', false, 14);
		addfield('form.buscaddr', '<s:text name="buscaddr"/>', 'c', true, 128); 
		addfield('form.createtime', '<s:text name="createtime"/>', 't', true, 7);
		return checkval(window);
	}
</script>