<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%@ taglib prefix="j" uri="/jop-tags" %>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A6FBT14" />
</jsp:include>
<html>
<head>
    <title><s:text name="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('form.tablename', '<s:text name="tablename"/>', 'c', false, 32);
			addfield('form.tablechname', '<s:text name="tablechname"/>', 'c', false, 64);
            addfield('form.typename', '<s:text name="typename"/>', 'c', false, 32);
			addfield('form.typechname', '<s:text name="typechname"/>', 'c', false, 64);
            addfield('form.field', '<s:text name="field"/>', 'c', false, 32);
			addfield('form.fieldchname', '<s:text name="fieldchname"/>', 'c', false, 64);
			addfield('form.state', '<s:text name="state"/>', 'f', false, 2);
            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<s:form action="fdauditdef_save.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">
			
    <s:hidden name="CMD"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param._se_tablename"/>
    <s:hidden name="param._se_tablechname"/>
    <s:hidden name="param._se_typename"/>
    <s:hidden name="param._se_typechname"/>
    <s:hidden name="param._se_field"/>
    <s:hidden name="param._se_fieldchname"/>
    <s:hidden name="param._ne_state"/>
	<s:hidden  name="form.pkname"/>
	<s:hidden  name="form.pktype"  />
	<s:hidden  name="form.pkname2"/>
	<s:hidden  name="form.pktype2"  />
	<s:hidden  name="form.fieldtype"/>
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
        		<td colspan="4">
        			<s:text name="msgcontent" />
        		</td>
        	</tr>
            <tr>
                <td align="right"><s:text name="typename"/>:&nbsp</td>
                <td align="left">
			        <s:if test="CMD == WEB_CMD_NEW">
                        <s:textfield cssStyle="style_input" name="form.typename" maxlength="32"/>
                        <font color=red>*</font>
			        </s:if>
			        <s:elseif test="CMD == WEB_CMD_EDIT">
			        	<s:textfield cssStyle="style_input" name="form.typename" disabled="true"/>
						<font color=red>*</font>
					</s:elseif>
			        <s:else>
						<s:textfield cssStyle="style_input" name="form.typename" disabled="true"/>
						<font color=red>*</font>
			        </s:else>
                </td>
                <td align="right"><s:text name="typechname"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.typechname" maxlength="64"/>
						<font color=red>*</font>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.typechname" disabled="true"/>
						<font color=red>*</font>
					</s:else>
                </td>
            </tr>
             <tr>
                <td align="right"><s:text name="tablename"/>:&nbsp</td>
                <td align="left">
			        <s:if test="CMD == WEB_CMD_NEW">
                        <s:textfield cssStyle="style_input" name="form.tablename" maxlength="32"/>
                        <font color=red>*</font>
			        </s:if>
			        <s:elseif test="CMD == WEB_CMD_EDIT">
			        	<s:textfield cssStyle="style_input" name="form.tablename" disabled="true"/>
						<font color=red>*</font>
					</s:elseif>
			        <s:else>
						<s:textfield cssStyle="style_input" name="form.tablename" disabled="true"/>
						<font color=red>*</font>
			        </s:else>
                </td>
                <td align="right"><s:text name="tablechname"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.tablechname" maxlength="64"/>
						<font color=red>*</font>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.tablechname" disabled="true"/>
						<font color=red>*</font>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="field"/>:&nbsp</td>
                <td align="left">
			        <s:if test="CMD == WEB_CMD_NEW">
                        <s:textfield cssStyle="style_input" name="form.field" maxlength="32"/>
                        <font color=red>*</font>
			        </s:if>
			        <s:elseif test="CMD == WEB_CMD_EDIT">
			        	<s:textfield cssStyle="style_input" name="form.field" disabled="true"/>
						<font color=red>*</font>
					</s:elseif>
			        <s:else>
						<s:textfield cssStyle="style_input" name="form.field" disabled="true"/>
						<font color=red>*</font>
			        </s:else>
                </td>
                <td align="right"><s:text name="fieldchname"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.fieldchname" maxlength="64"/>
						<font color=red>*</font>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.fieldchname" disabled="true"/>
						<font color=red>*</font>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="state"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector definition="CH_STARTSTATE" name="form.state"/>
						<font color=red>*</font>
					</s:if>
					<s:else>
						<j:selector definition="CH_STARTSTATE" name="form.state" disabled="true"/>
						<font color=red>*</font>
					</s:else>
                </td>
                <td></td><td></td>
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
                           value="<s:text name="button_save"/>" onclick="doSave('/channel/fdauditdef_save.do')"
                           <s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if>
                           />
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/channel/fdauditdef_list.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
</body>
</html>
