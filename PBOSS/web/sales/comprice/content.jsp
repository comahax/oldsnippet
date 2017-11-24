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
            addfield('form.recid', '<s:text name="recid"/>', 'f', true, 14);
			addfield('form.cityid', '<s:text name="cityid"/>', 'c', false, 10);
			addfield('form.countyid', '<s:text name="countyid"/>', 'c', false, 18);
			addfield('form.cooptype', '<s:text name="cooptype"/>', 'c', false, 16);
			addfield('form.comcategory', '<s:text name="comcategory"/>', 'c', false, 20);
			addfield('form.pricediftype', '<s:text name="pricediftype"/>', 'c', false, 16);
			var pricediftype = $("#pricediftype").val();
        	if(pricediftype=="NODIF")
        	{
				addfield('form.price1', '<s:text name="price1"/>', 'd', false, 5, 2);
        	}
        	else if(pricediftype=="ACCOUNT")
        	{
				addfield('form.price2', '<s:text name="price2"/>', 'd', false, 5, 2);
				addfield('form.price3', '<s:text name="price3"/>', 'd', false, 5, 2);
        	}
        	else if(pricediftype=="INVOICE") 
        	{
				addfield('form.price4', '<s:text name="price4"/>', 'd', false, 5, 2);
				addfield('form.price5', '<s:text name="price5"/>', 'd', false, 5, 2);
        	}
			
            return checkval(window);
        }
        
        //根据不同的售价区分方式，显示不同的价格
        function getPrice()
        {
        	var pricediftype = $("#pricediftype").val();
        	if(pricediftype=="NODIF")
        	{
        		$("#price1Tr").show();
        		$("#price2Tr").hide();
        		$("#price3Tr").hide();
        		$("#price4Tr").hide();
        		$("#price5Tr").hide();
        	}
        	else if(pricediftype=="ACCOUNT")
        	{
        		$("#price1Tr").hide();
        		$("#price2Tr").show();
        		$("#price3Tr").show();
        		$("#price4Tr").hide();
        		$("#price5Tr").hide();
        	}
        	else if(pricediftype=="INVOICE") 
        	{
        		$("#price1Tr").hide();
        		$("#price2Tr").hide();
        		$("#price3Tr").hide();
        		$("#price4Tr").show();
        		$("#price5Tr").show();
        	}
        }
        
        $(document).ready(function(){
			var value = $("#cityidHid").val();
			if(value!="")
			{
				$("#cityid").val(value);
			}
			
			//显示价格
			getPrice();
		});
    </script>
</head>
<body>
<div class="table_container">
<s:form action="comprice_save.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">
	<input type="hidden" id="cityidHid" value="${cityid}">
			
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
                <td align="right" width="20%"><s:text name="recid"/>:&nbsp</td>
                <td align="left" width="80%">
					<s:textfield cssStyle="style_input" name="form.recid" disabled="true"/>
					<font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="city"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="#CITYCOMPANY" mode="selector" id="cityid" name="form.cityid" condition="citycompid:${cityid}" value="${cityid}" disabled="true"/>
						<font color=red>*</font>
						<s:text name="label2"/>
					</s:if>
					<s:else>
						<j:selector definition="#CITYCOMPANY" mode="selector" id="cityid" name="form.cityid" condition="citycompid:${cityid}" value="${cityid}" disabled="true"/>
						<font color=red>*</font>
						<s:text name="label2"/>
					</s:else>
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
						<j:selector definition="#CNTYCOMPANY" mode="picker" name="form.countyid" condition="citycompid:${cityid}" readonly="true" disabled="true"/>
						<font color=red>*</font>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="starlevel"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="$CH_STARLEVEL2" mode="selector" name="form.starlevel"/>
						<font color=red>*</font>
					</s:if>
					<s:else>
						<j:selector definition="$CH_STARLEVEL2" mode="selector" name="form.starlevel" disabled="true"/>
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
                <td align="right"><s:text name="pricediftype"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="$FX_PRICEDIFTYPE" name="form.pricediftype" id="pricediftype" onchange="getPrice()"/>
						<font color=red>*</font>
					</s:if>
					<s:else>
						<j:selector definition="$FX_PRICEDIFTYPE" name="form.pricediftype" id="pricediftype" disabled="true"/>
						<font color=red>*</font>
					</s:else>
                </td>
            </tr>
            <tr id="price1Tr" style="display: none;">
                <td align="right"><s:text name="price1"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.price1" maxlength="8"/>
						<font color=red>*</font>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.price1" disabled="true"/>
						<font color=red>*</font>
					</s:else>
                </td>
            </tr>
            <tr id="price2Tr" style="display: none;">
                <td align="right"><s:text name="price2"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.price2" maxlength="8"/>
						<font color=red>*</font>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.price2" disabled="true"/>
						<font color=red>*</font>
					</s:else>
                </td>
            </tr>
            <tr id="price3Tr" style="display: none;">
                <td align="right"><s:text name="price3"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.price3" maxlength="8"/>
						<font color=red>*</font>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.price3" disabled="true"/>
						<font color=red>*</font>
					</s:else>
                </td>
            </tr>
            <tr id="price4Tr" style="display: none;">
                <td align="right"><s:text name="price4"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.price4" maxlength="8"/>
						<font color=red>*</font>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.price4" disabled="true"/>
						<font color=red>*</font>
					</s:else>
                </td>
            </tr>
            <tr id="price5Tr" style="display: none;">
                <td align="right"><s:text name="price5"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.price5" maxlength="8"/>
						<font color=red>*</font>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.price5" disabled="true"/>
						<font color=red>*</font>
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
                           value="<s:text name="button_save"/>" onclick="doSave('/sales/comprice_save.do')"
                           <s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if>
                           />
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/sales/comprice_list.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
</body>
</html>
