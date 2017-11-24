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
<s:form action="limitset_save.do" cssStyle="formList" key="formItem"
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
                <td align="right" width="20%"><s:text name="recid"/>:&nbsp</td>
                <td align="left">
                	<s:textfield cssStyle="style_input" name="form.recid" maxlength="14" disabled="true"/>
                    <font color=red>*</font>
                    &nbsp;<s:text name="label1"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="cityname"/>:&nbsp</td>
                <td align="left">
					<j:selector definition="#CITYCOMPANY" mode="selector" name="form.cityid" condition="citycompid:${form.cityid}" disabled="true"/>
					<font color=red>*</font>
					&nbsp;<s:text name="label2"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="countyname"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="#CNTYCOMPANY" mode="picker" name="form.countyid" condition="citycompid:${form.cityid}"/>
						<font color=red>*</font>
					</s:if>
					<s:else>
						<j:selector definition="#CNTYCOMPANY" mode="picker" name="form.countyid" condition="citycompid:${form.cityid}" disabled="true"/>
						<font color=red>*</font>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="starlevel"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="$CH_STARLEVEL" mode="selector" name="form.starlevel"/>
						<font color=red>*</font>
					</s:if>
					<s:else>
						<j:selector definition="$CH_STARLEVEL" mode="selector" name="form.starlevel" disabled="true"/>
						<font color=red>*</font>
					</s:else>
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
                <td align="right"><s:text name="stockscale"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.stockscale" maxlength="16"/>
						<font color=red>*</font>
						&nbsp;<s:text name="label3"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.stockscale" disabled="true"/>
						<font color=red>*</font>
						&nbsp;<s:text name="label3"/>
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
                           value="<s:text name="button_save"/>" onclick="doSave('/sales/limitset_save.do')"
                           <s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if>
                           />
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/sales/limitset_list.do')">
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
		addfield('form.recid', '<s:text name="recid"/>', 'f', true, 14);
		addfield('form.cityid', '<s:text name="cityname"/>', 'c', false, 10);
		addfield('form.countyid', '<s:text name="countyname"/>', 'c', false, 14);
		addfield('form.starlevel', '<s:text name="starlevel"/>', 'f', false, 2);
		addfield('form.comcategory', '<s:text name="comcategory"/>', 'c', false, 20);
		addfield('form.stockscale', '<s:text name="stockscale"/>', 'f', false, 16 ,2);
		
		var validate1 = checkval(window);
		var validate2 = true;
		if(document.all("form.stockscale").value!=""){
    		if(document.all("form.stockscale").value*1<0 ||document.all("form.stockscale").value*1>1){
    			var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[库存比例]</span>' + '必须是0到1之间的数字,包括0和1,最多两位小数!' + '</span>';
				var errorDiv = $("#msgDiv");
				if(document.getElementById("msgDiv"))
				{
					$("#msgDiv").append(alertstr);
				}
				else
				{
					errorMessageShow(alertstr);
				}
        		validate2 = false;
        	}
        }
		return validate1&&validate2;
	}
</script>