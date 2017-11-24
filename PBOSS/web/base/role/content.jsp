<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%String ID_ADD = "CH_PW_SYSTEMROLE";%>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A6FBT14" />
</jsp:include>
<html>
<head>
    <title><s:text name="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('form.roleid', '<s:text name="roleid"/>', 'c', false, 32);
			addfield('form.rolename', '<s:text name="rolename"/>', 'c', false, 64);
			addfield('form.ispublic', '<s:text name="ispublic"/>', 'f', false, 1);
			addfield('form.statusdate', '<s:text name="statusdate"/>', 't', false, 7);
			addfield('form.memo', '<s:text name="memo"/>', 'c', true, 512);
            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<s:form action="role_save.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">
			
    <s:hidden name="CMD"/>
    <s:hidden name="form.createdate"/>
    <s:hidden name="form.orgid"/>
    <s:hidden name="form.operid"/>
    <s:hidden name="form.isback"/>
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
			<span class="button_Help" onclick="openword('<s:text name="helpTitle"/>','<s:text name="helpContent1"/>')"><s:i18n name="public"><s:text name="help"/></s:i18n></span>
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
                <td align="right"><s:text name="roleid"/>:&nbsp</td>
                <td align="left">
			        <s:if test="CMD == WEB_CMD_NEW">
                        <s:textfield cssStyle="style_input" name="form.roleid" maxlength="32"/>
                        <font color=red>*</font>
			        </s:if>
			        <s:else>
						<s:textfield cssStyle="style_input" name="form.roleid" disabled="true"/>
						<font color=red>*</font>
			        </s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="rolename"/>:&nbsp</td>
                <td align="left">
                <s:if test="CMD != WEB_CMD_SAVE">
					<s:textfield cssStyle="style_input" name="form.rolename" maxlength="64"/>
				</s:if>
				<s:else>
					<s:textfield cssStyle="style_input" name="form.rolename" maxlength="64" disabled="true"/>
				</s:else>
				<font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="ispublic2"/>:&nbsp</td>
                <td align="left">
                <s:if test="CMD != WEB_CMD_SAVE">
					<j:selector name="form.ispublic" definition="$IM_YESNO10" value="1"/>
				</s:if>
				<s:else>
					<j:selector name="form.ispublic" definition="$IM_YESNO10" disabled="true"/>
				</s:else>
				<font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="status"/>:&nbsp</td>
                <td align="left">
                <s:if test="CMD != WEB_CMD_SAVE">
					<j:selector name="form.status" definition="$CH_OPRSTATUS" />
				</s:if>
				<s:else>
					<j:selector name="form.status" definition="$CH_OPRSTATUS" disabled="true"/>
				</s:else>
				<font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="statusdate2"/>:&nbsp</td>
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
            <tr>
                <td align="right"><s:text name="memo"/>:&nbsp</td>
                <td align="left">
                <s:if test="CMD != WEB_CMD_SAVE">
					<s:textarea cssStyle="style_input" name="form.memo" maxlength="512" cols="64" rows="5"/>
				</s:if>
				<s:else>
					<s:textarea cssStyle="style_input" name="form.memo" maxlength="512" cols="64" rows="5" disabled="true"/>
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
                           value="<s:text name="button_save"/>" onclick="doSave('/base/role_save.do')" 
                           <s:if test="CMD == WEB_CMD_SAVE">disabled="true"</s:if>/>
                    </j:purChk>
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/base/role_list.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
</body>
</html>
