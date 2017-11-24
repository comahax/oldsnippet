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
			addfield('form.cityid', '<s:text name="cityid"/>', 'c', false, 10);
			addfield('form.countyid', '<s:text name="countyid"/>', 'c', false, 14);
			addfield('form.cooptype', '<s:text name="cooptype"/>', 'c', false, 16);
			addfield('form.starlevel', '<s:text name="starlevel"/>', 'f', false, 2);
			addfield('form.brand', '<s:text name="brand"/>', 'c', false, 16);
			addfield('form.stdtype', '<s:text name="stdtype"/>', 'c', false, 16);
			addfield('form.loweststd', '<s:text name="loweststd"/>', 'f', false, 5,2);
			addfield('form.effective', '<s:text name="effective"/>', 'f', false, 3);
			if(val_compare2('form.loweststd','最低标准 必须介于0和1之间（包括0和1）'))
				return;
            return checkval(window);
        }
        function val_compare2(element1,errorMessage) {
        	var low = document.all(element1).value;
        	if(low != "" ){
        		if(low<0 || low>1 ) {
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
<s:form action="orderstd_save.do" cssStyle="formList" key="formItem"
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
    <s:hidden name="param._se_brand"/>
    <s:hidden name="param._se_stdtype"/>
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
                <td align="right"><s:text name="brand"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<p:smpBrand name="form.brand" mode="of" cssStyle="style_input" />
					</s:if>
					<s:else>
						<p:smpBrand name="form.brand" mode="of" disabled="true" />
					</s:else>
					<font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="stdtype"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.stdtype" definition="$FX_ORDERSTDTYPE" />
					</s:if>
					<s:else>
						<j:selector name="form.stdtype" definition="$FX_ORDERSTDTYPE" disabled="true"/>
					</s:else>
					<font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="loweststd"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.loweststd" maxlength="4"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.loweststd" disabled="true"/>
					</s:else>
					<font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="effective"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="$CH_VALIDFLAG" name="form.effective" condition="dictid:0,1" mode="selector" />
					</s:if>
					<s:else>
						<j:selector name="form.effective" definition="$CH_VALIDFLAG" disabled="true"/>
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
                           value="<s:text name="button_save"/>" onclick="doSave('/sales/orderstd_save.do')"
                           <s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if>
                           />
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/sales/orderstd_list.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
</body>
</html>
