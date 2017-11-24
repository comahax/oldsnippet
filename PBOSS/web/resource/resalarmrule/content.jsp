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
		//addfield('form.recid', '<s:text name="recid"/>', 'f', false, 14);
		addfield('form.cityid', '<s:text name="cityid"/>', 'c', false, 10);
		addfield('form.countyid', '<s:text name="countyid"/>', 'c', false, 14);
		addfield('form.comcategory', '<s:text name="comcategory"/>', 'c', false, 20);
		addfield('form.lowstock', '<s:text name="lowstock"/>', 'f', false, 10);
		addfield('form.upactrate', '<s:text name="upactrate"/>', 'f', true, 1,2,0,0,1);
		addfield('form.handlercode', '<s:text name="handlercode"/>', 'c', false, 16);
		return checkval(window);
	}
</script>
</head>
<body >
<div class="table_container">
<s:form action="resalarmrule_save.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">
			
    <s:hidden name="CMD"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param._se_cityid"/>
    <s:hidden name="param._se_countyid"/>
    <s:hidden name="param._se_comcategory"/>
    <s:hidden name="param._se_handlercode"/>
	
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
                <td align="right"><s:text name="recid"/>:&nbsp</td>
                <td align="left">
		        	<s:textfield cssStyle="style_input" name="form.recid" disabled="true"/>
					<font color=red>*</font>自动生成
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="cityid"/>:&nbsp</td>
                <td align="left">
					<j:selector definition="#CITYCOMPANY" condition="citycompid:${USER.cityid}"  value="${USER.cityid}" name="form.cityid" mode="selector" disabled="true"/>
					<font color=red>*</font>系统默认
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="countyid"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="#CNTYCOMPANY"  condition="citycompid:${USER.cityid}" name="form.countyid" mode="selector" />
					</s:if>
					<s:else>
						<j:selector definition="#CNTYCOMPANY"  condition="citycompid:${USER.cityid}" name="form.countyid" mode="selector" disabled="true"/>
					</s:else>
					<font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="comcategory"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.comcategory" definition="$IM_FXCOMCATEGORY" mode="picker"/> 
					</s:if>
					<s:else>
						<j:selector name="form.comcategory" definition="$IM_FXCOMCATEGORY" mode="picker" disabled="true"/> 
					</s:else>
					<font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="lowstock"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.lowstock" maxlength="10"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.lowstock" disabled="true"/>
					</s:else>
					<font color=red>*</font>单位：（套/张）
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="upactrate"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.upactrate" maxlength="16"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.upactrate" disabled="true"/>
					</s:else>
					介于0-1之间的数字，最多两位小数，商品种类为套卡时必须填写
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="handlercode"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="#OPERATOR" name="form.handlercode" condition='region:${dBAccessUser.hwcityid }' readonly="true"/>
					</s:if>
					<s:else>
						<j:selector definition="#OPERATOR" name="form.handlercode" condition='region:${dBAccessUser.hwcityid }' disabled="true"/>
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
                           value="<s:text name="button_save"/>" onclick="doSave('/resource/resalarmrule_save.do')"
                           <s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if>
                           />
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/resource/resalarmrule_list.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
</body>
</html>
