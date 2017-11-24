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
            //checkactrate();
			addfield('form.cityid', '<s:text name="cityid"/>', 'c', false, 10);
			addfield('form.starlevel', '<s:text name="starlevel"/>', 'f', false, 2);
			addfield('form.brand', '<s:text name="brand"/>', 'c', false, 16);
			addfield('form.actratelow', '<s:text name="actratelow"/>', 'f', false, 1,2);
			addfield('form.actrateup', '<s:text name="actrateup"/>', 'f', false, 1,2);
			addfield('form.times', '<s:text name="times"/>', 'f', false, 3,2);
			addfield('form.effective', '<s:text name="effective"/>', 'f', false, 3);
			if(val_compare('form.actratelow','form.actrateup','激活率>　必须小于或等于　激活率<='))
				return;
			if(val_compare2('form.actratelow','form.actrateup','激活率> 　和　激活率<= 必须介于0和1之间（包括0和1）'))
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
        function val_compare2(element1,element2,errorMessage) {
        	var actratelow = document.all(element1).value;
        	var actrateup = document.all(element2).value;
        	if(actratelow != "" && actrateup != ""){
        		if(actratelow<0 || actratelow>1 || actrateup<0 || actrateup>1) {
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
        /**function checkactrate(){
        	errorMessageShow("");
        	if ((Number(document.getElementsByName("form.actratelow")[0].value) - 
                	Number(document.getElementsByName("form.actrateup")[0].value))>0 ){
				alertstr='<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[激活率]</span>激活率>必须不大于激活率<=</span>';
				errorMessageShow(alertstr);
				return false;
        	}
        }**/
    </script>
</head>
<body>
<div class="table_container">
<s:form action="monamtchgrule_save.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">
			
    <s:hidden name="CMD"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param._se_cityid"/>
    <s:hidden name="param._ne_starlevel"/>
    <s:hidden name="param._se_brand"/>
    <s:hidden name="param._ne_effective"/>
    <s:hidden name="form.ruleid"/>
	
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
                <td align="right"><s:text name="actratelow"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.actratelow" maxlength="4"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.actratelow" disabled="true"/>
					</s:else>
					<font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="actrateup"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.actrateup" maxlength="4"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.actrateup" disabled="true"/>
					</s:else>
					<font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="times"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.times" maxlength="6"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.times" disabled="true"/>
					</s:else>
					<font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="effective"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.effective" definition="$CH_VALIDFLAG" condition="dictid:0,1" />
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
                           value="<s:text name="button_save"/>" onclick="doSave('/sales/monamtchgrule_save.do')"
                           <s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if>
                           />
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/sales/monamtchgrule_list.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
</body>
</html>
