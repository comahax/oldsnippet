<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A6FBT14" />
</jsp:include>
<html>
<head>
    <title><s:text name="titleList3"/></title>
    <script language="JavaScript">
        function ev_checkval() {
			addfield('form.cityid', '<s:text name="cityid"/>', 'c', false, 10);
			addfield('form.countyid', '<s:text name="countyid"/>', 'c', true, '14');
			addfield('form.cooptype', '<s:text name="cooptype"/>', 'c', false, 18);
			addfield('form.starlevel', '<s:text name="starlevel"/>', 'f', false, 2);
			addfield('form.comcategory', '<s:text name="comcategory"/>', 'c', false, 20);
			addfield('form.monlimit', '<s:text name="monlimit"/>', 'l', false, 10,0,0,1);
			addfield('form.daylimit', '<s:text name="daylimit"/>', 'l', false, 10,0,0,1);
			addfield('form.oncelimit', '<s:text name="oncelimit"/>', 'l', true, 10,0,0,0);
			if(val_compare('form.daylimit','form.monlimit','日订购量上限　必须小于或等于　月订购量上限'))
				return;
            return checkval(window);
        }
        function val_compare(element1,element2,errorMessage) {
        	var actratelow = document.all(element1).value;
        	var actrateup = document.all(element2).value;
        	if(actratelow != "" && actrateup != ""){
        		if(actratelow - actrateup > 0 ) {
        			if(errorMessage == null)errorMessage = "????????????";
        			fields = new Array();
        			alert(errorMessage);
        			return true;
        		}
        		else{
        			return false;
        		}
        	}
        }
    </script>
</head>
<body>
<div class="table_container">
<s:form action="orderuplimit_saveforemptysimorder.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">
			
    <s:hidden name="CMD"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param._se_cityid"/>
    <s:hidden name="param._se_countyid"/>
    <s:hidden name="param._se_cooptype"/>
    <s:hidden name="param._ne_starlevel"/>
    <s:hidden name="param._se_comcategory"/>
    <s:hidden name="form.recid"/>
	
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="sales"/> </span>
			<span class="table_toparea_xi">></span>
			</s:i18n>
			<span class="table_toparea_h">空白卡SIM订购量设置</span>
			<span class="button_Help" onclick="openword('<s:text name="helpTitle3"/>','<s:text name="helpContent3"/>')"><s:i18n name="public"><s:text name="help"/></s:i18n></span>
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
                <td align="right"><s:text name="cityid"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="#CITYCOMPANY" name="form.cityid" mode="selector" condition="citycompid:${dBAccessUser.cityid }" value="%{dBAccessUser.cityid}" disabled="true"/>
					</s:if>
					<s:else>
						<j:selector definition="#CITYCOMPANY" name="form.cityid" mode="selector" condition="citycompid:${dBAccessUser.cityid }" value="%{dBAccessUser.cityid}" disabled="true"/>
					</s:else>
					<font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="countyid"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="#CNTYCOMPANY" mode="picker" name="form.countyid" condition="citycompid:${cityid}" readonly="true"/>
						<font color=red>*</font>
					</s:if>
					<s:else>
						<j:selector definition="#CNTYCOMPANY" mode="picker" name="form.countyid" condition="citycompid:${cityid}" disabled="true"/>
						<font color=red>*</font>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="cooptype"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:select name="form.cooptype" list="#request.custwaytypeList" theme="simple" headerKey="" headerValue="" listKey="custwaytypecode" listValue="custwaytypename" />
						<font color=red>*</font>
					</s:if>
					<s:else>
						<s:select name="form.cooptype" list="#request.custwaytypeList" theme="simple" headerKey="" headerValue="" listKey="custwaytypecode" listValue="custwaytypename" disabled="true"/>
						<font color=red>*</font>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="starlevel"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.starlevel" definition="$CH_STARLEVEL" />
					</s:if>
					<s:else>
						<j:selector name="form.starlevel" definition="$CH_STARLEVEL" disabled="true"/>
					</s:else>
					<font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="comcategory"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
					<s:select name="form.comcategory" list="#request.emptysimtypeList" theme="simple" headerKey="" headerValue="" listKey="comcategory" listValue="dictname" />
						 
					</s:if>
					<s:else>
					<s:select name="form.comcategory" list="#request.emptysimtypeList" theme="simple" headerKey="" headerValue="" listKey="comcategory" listValue="dictname" disabled="true" />
					 
					</s:else>
					<font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="monlimit"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.monlimit" maxlength="10"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.monlimit" disabled="true"/>
					</s:else>
					<font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="daylimit"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.daylimit" maxlength="10"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.daylimit" disabled="true"/>
					</s:else>
					<font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="oncelimit"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD == 'NEW'">
						<s:textfield cssStyle="style_input" name="form.oncelimit" maxlength="10" value="0"/>
					</s:if>
					<s:if test="CMD == 'EDIT'">
						<s:textfield cssStyle="style_input" name="form.oncelimit" maxlength="10"/>
					</s:if>					
					<s:if test="CMD == 'SAVE'">
						<s:textfield cssStyle="style_input" name="form.oncelimit" disabled="true"/>
					</s:if>			
					&nbsp;该值为空或为零时，不检查单次订购上限。	
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
                           value="<s:text name="button_save"/>" onclick="doSave('/sales/orderuplimit_saveforemptysimorder.do')"
                           <s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if>
                           />
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/sales/orderuplimit_listforemptysimorder.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
</body>
</html>
