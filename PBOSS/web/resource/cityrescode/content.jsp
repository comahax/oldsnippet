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
<s:form action="cityrescode_save.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">
			
    <s:hidden name="CMD"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param._se_cityid"/>
    <s:hidden name="param._se_cityrescode"/>
	
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
                <td align="right"><s:text name="id"/>:&nbsp</td>
                <td align="left">
			        <s:if test="CMD == WEB_CMD_NEW">
                        <s:textfield cssStyle="style_input" name="form.id" maxlength="18" disabled="true"/>
                        <font color=red>*</font>自动生成
			        </s:if>
			        <s:elseif test="CMD == WEB_CMD_EDIT">
			        	<s:textfield cssStyle="style_input" name="form.id" disabled="true"/>
						<font color=red>*</font>自动生成
					</s:elseif>
			        <s:else>
						<s:textfield cssStyle="style_input" name="form.id" disabled="true"/>
						<font color=red>*</font>自动生成
			        </s:else>
                </td>
            </tr>
            <input type="hidden" name="form.cityid" value="${USER.cityid}"/> 
           
            
            <tr>
                <td align="right"><s:text name="cityrescode"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
					    <s:textfield cssStyle="style_input" name="form.cityrescode"/> <font color=red>*</font>
					</s:if>
					<s:else>
						 <s:textfield cssStyle="style_input" name="form.cityrescode" disabled="true" /> <font color=red>*</font>
					</s:else>
                </td>
            </tr> 
            <tr>
                <td align="right"><s:text name="category"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
					     <j:selector definition="$IM_FXCOMCATEGORY" name="form.comcategory" mode="picker"/> <font color=red>*</font>
					</s:if>
					<s:else> 
						 <j:selector definition="$IM_FXCOMCATEGORY" name="form.comcategory" mode="picker" disabled="true"/> <font color=red>*</font>
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
                           value="<s:text name="button_save"/>" onclick="doSave('/resource/cityrescode_save.do')"
                           <s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if>
                           />
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/resource/cityrescode_list.do')">
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
		addfield('form.id', '<s:text name="id"/>', 'f', true, 18);
		addfield('form.cityid', '<s:text name="cityid"/>', 'c', true, 14);
		addfield('form.cityrescode', '<s:text name="cityrescode"/>', 'c', false, 20);
		addfield('form.comcategory', '<s:text name="comcategory"/>', 'c', false, 20);
		return checkval(window);
	}
</script>