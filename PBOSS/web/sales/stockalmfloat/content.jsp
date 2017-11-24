<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A6FBT14" />
</jsp:include>
<html>
<head>
    <title><s:text name="titleUpdate"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/pwaycommon.js"></script>
    <script language="JavaScript">
	function ev_checkval() {
		addfield('form.cityid', '<s:text name="cityid"/>', 'c', false, 10);
		addfield('form.starlevel', '<s:text name="starlevel"/>', 'f', false, 2);
		addfield('form.brand', '<s:text name="brand"/>', 'c', false, 16);
		addfield('form.maxstockquotiety', '<s:text name="maxstockquotiety"/>', 'f', false, 3,2);
		addfield('form.yellowquotiety', '<s:text name="yellowquotiety"/>', 'f', false, 1,2);
		addfield('form.redquotiety', '<s:text name="redquotiety"/>', 'f', false, 1,2);
		addfield('form.actquotiety', '<s:text name="actquotiety"/>', 'f', false, 3,2);
		
		var validate1 = checkval(window);
		
		var validate2 = true;
		if(document.all("form.yellowquotiety").value!=""){
    		if(document.all("form.yellowquotiety").value*1<0 ||document.all("form.yellowquotiety").value*1>1){
    			var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[黄色预警系数]</span>' + '必须是0到1之间的数字,包括0和1,最多两位小数!' + '</span>';
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
        var validate3 = true;
		if(document.all("form.redquotiety").value!=""){
    		if(document.all("form.redquotiety").value*1<0 ||document.all("form.redquotiety").value*1>1){
    			var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[红色预警系数]</span>' + '必须是0到1之间的数字,包括0和1,最多两位小数!' + '</span>';
				var errorDiv = $("#msgDiv");
				if(document.getElementById("msgDiv"))
				{
					$("#msgDiv").append(alertstr);
				}
				else
				{
					errorMessageShow(alertstr);
				}
        		validate3 = false;
        	}
        }
		return validate1&&validate2&&validate3;
	}
</script>
</head>
<body>
<div class="table_container">
<s:form action="stockalmfloat_save.do" cssStyle="formList" key="formItem"
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
			<span class="table_toparea">分销管理 </span>
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
			        <s:if test="CMD == WEB_CMD_NEW">
                        <s:textfield cssStyle="style_input" name="form.recid" maxlength="14" disabled="true"/>
                        <font color=red>*</font>
			        </s:if>
			        <s:elseif test="CMD == WEB_CMD_EDIT">
			        	<s:textfield cssStyle="style_input" name="form.recid" readonly="true"/>
						<font color=red>*</font>
					</s:elseif>
			        <s:else>
						<s:textfield cssStyle="style_input" name="form.recid" readonly="true"/>
						<font color=red>*</font>
			        </s:else>
			        自动生成
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="starlevel"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="$CH_STARLEVEL" name="form.starlevel" />
					</s:if>
					<s:else>
						<j:selector definition="$CH_STARLEVEL" name="form.starlevel"  disabled="true"/>
					</s:else>
					<font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="brand"/>:&nbsp</td>
                <td align="left">
			        <s:if test="CMD != WEB_CMD_SAVE">
						 <p:smpBrand name="form.brand" mode="def" cssStyle="style_input" />
                        <font color=red>*</font>
					</s:if>
					<s:else>
						<p:smpBrand name="form.brand" mode="def" cssStyle="style_input"  disabled="true"  />
						<font color=red>*</font>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="maxstockquotiety"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.maxstockquotiety" maxlength="6"/>
						<font color=red>*</font>
						数字类型，要求大于零，整数位最多三位，小数位最多两位
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.maxstockquotiety" disabled="true"/>
						<font color=red>*</font>
						数字类型，要求大于零，整数位最多三位，小数位最多两位
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="actquotiety"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.actquotiety" />
						<font color=red>*</font>
						数字类型，要求大于零，整数位最多三位，小数位最多两位
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.actquotiety" disabled="true"/>
						<font color=red>*</font>
						数字类型，要求大于零，整数位最多三位，小数位最多两位
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="yellowquotiety"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.yellowquotiety" maxlength="4"/>
						<font color=red>*</font>
						数字类型，要求大于零且小于1，小数位最多两位
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.yellowquotiety" disabled="true"/>
						<font color=red>*</font>
						数字类型，要求大于零且小于1，小数位最多两位
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="redquotiety"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.redquotiety" maxlength="4"/>
						<font color=red>*</font>
						数字类型，要求大于零且小于1，小数位最多两位
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.redquotiety" disabled="true"/>
						<font color=red>*</font>
						数字类型，要求大于零且小于1，小数位最多两位
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
                   	<j:purChk permid="FX_RU_STOCKALARM"> 
                    <input type="button" id="btnSave" name="btnSave" class="button_Save" onmouseover="buttonover(this);" 
                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_save"/>" onclick="doSave('/sales/stockalmfloat_save.do')"
                           <s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if>
                           />
                     </j:purChk>
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/sales/stockalmfloat_list.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
</body>
</html>