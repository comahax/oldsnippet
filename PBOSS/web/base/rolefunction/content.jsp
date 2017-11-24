<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<% String ID_ADD = "CH_PW_SYSTEMROLE"; %>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A6FBT14" />
</jsp:include>
<html>
<head>
    <title><s:text name="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('form.itemid', '<s:text name="itemid"/>', 'c', false, 16);
            addfield('form.functionid', '<s:text name="functionid"/>', 'c', false, 32);
			addfield('form.status', '<s:text name="status"/>', 'f', false, 1);
			addfield('form.statusdate', '<s:text name="statusdate"/>', 't', false, 7);
            return checkval(window);
        }
        function doRoleSelect(){
        	var url="<%=contextPath%>/base/role_rolequerys.do";
        	var rtn=window.showModalDialog(url , self , "dialogWidth:800px; dialogHeight:500px; status:no; resizable:no;");
        	if (rtn != null && rtn.length) {
        		document.all('form.itemid').value = rtn;
        		return rtn;
        	}
		}
    </script>
</head>
<body>
<div class="table_container">
<s:form action="rolefunction_save.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">
			
    <s:hidden name="CMD"/>
    <s:hidden name="form.operatetype"/>
    <s:hidden name="form.createdate"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param._se_itemid"/>
    <s:hidden name="param._se_functionid"/>
    <s:hidden name="param._dnm_statusdate"/>
    <s:hidden name="param._dnl_statusdate"/>
	
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
                <td align="right"><s:text name="itemid"/>:&nbsp</td>
                <td align="left">
			        <s:if test="CMD == WEB_CMD_NEW">
                        <s:textfield class="style_input" name="form.itemid" readonly="true"/><input type="button" class="picker_button" value="..." onClick="doRoleSelect();"/>
                        <font color=red>*</font>
			        </s:if>
			        <s:else>
						<s:textfield class="style_input" name="form.itemid" disabled="true"/><input type="button" class="picker_button" value="..." onClick="doRoleSelect();" disabled="true"/>
						<font color=red>*</font>
			        </s:else>
                </td>
           
                <td align="right"><s:text name="functionid"/>:&nbsp</td>
                <td align="left">
			        <s:if test="CMD == WEB_CMD_NEW">
			        	<j:selector definition="#FUNCTIONITEM" name="form.functionid" condition="_snn_guiobject:notnull" readonly="true"/>
                        <font color=red>*</font>
			        </s:if>
			        <s:else>
			        	<j:selector definition="#FUNCTIONITEM" name="form.functionid" condition="_snn_guiobject:notnull" disabled="true"/>
						<font color=red>*</font>
			        </s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="status"/>:&nbsp</td>
                <td align="left">
                <s:if test="CMD != WEB_CMD_SAVE">
					<j:selector name="form.status" definition="$CH_OPRSTATUS" />
					<font color=red>*</font>
				</s:if>
				<s:else>
					<j:selector name="form.status" definition="$CH_OPRSTATUS" disabled="true"/>
					<font color=red>*</font>
				</s:else>
                </td>
            
                <td align="right"><s:text name="statusdate"/>:&nbsp</td>
                <td align="left">
			        <s:if test="CMD != WEB_CMD_SAVE">
			        	<input type="text" cssStyle="style_input" name="form.statusdate" onclick="selectDate();" value="<s:date name="form.statusdate" format="yyyy-MM-dd"/>"/>
                        <font color=red>*</font>
			        </s:if>
			        <s:else>
			        	<input type="text" cssStyle="style_input" name="form.statusdate" onclick="selectDate();" value="<s:date name="form.statusdate" format="yyyy-MM-dd"/>" disabled="true"/>
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
                   	<j:purChk permid="<%=ID_ADD%>">
                    <input type="button" id="btnSave" name="btnSave" class="button_Save" onmouseover="buttonover(this);" 
                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_save"/>" onclick="doSave('/base/rolefunction_save.do')"
                           <s:if test="CMD == WEB_CMD_SAVE">disabled="true"</s:if>/>
                    </j:purChk>
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/base/rolefunction_list.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
</body>
</html>
