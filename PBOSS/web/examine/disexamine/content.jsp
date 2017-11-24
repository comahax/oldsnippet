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
<s:form action="disexamine_save.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">
			
    <s:hidden name="CMD"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param._se_discomcode"/>
    <s:hidden name="param._se_exmnperiod"/>
	
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="examine"/> </span>
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
       
          <tr style="display: none;">
                <td align="right"><s:text name="seqid"/>:&nbsp</td>
                <td align="left">
			        <s:if test="CMD == WEB_CMD_NEW">
                        <s:textfield cssStyle="style_input" name="form.seqid" maxlength="14"/>
                        <font color=red>*</font>
			        </s:if>
			        <s:elseif test="CMD == WEB_CMD_EDIT">
			        	<s:textfield cssStyle="style_input" name="form.seqid" disabled="true"/>
						<font color=red>*</font>
					</s:elseif>
			        <s:else>
						<s:textfield cssStyle="style_input" name="form.seqid" disabled="true"/>
						<font color=red>*</font>
			        </s:else>
                </td>
            </tr>
           
            <tr>
                <td align="right"><s:text name="discomcode"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD == WEB_CMD_NEW">
						 <j:selector name="form.discomcode" definition="#WAYIDINFO"  condition="waytype:AG;waysubtype:LOGS;cityid:${USER.cityid}"/>
						 <font color=red>*</font>
					</s:if>
					 <s:elseif test="CMD == WEB_CMD_EDIT">
					     <j:selector name="form.discomcode" definition="#WAYIDINFO"  condition="waytype:AG;waysubtype:LOGS;cityid:${USER.cityid}"    />
						 <font color=red>*</font>
					 </s:elseif>
					<s:else>
						 <j:selector name="form.discomcode" definition="#WAYIDINFO"  condition="waytype:AG;waysubtype:LOGS;cityid:${USER.cityid}"/>
						<font color=red>*</font>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="exmnperiod"/>:&nbsp</td>
                <td align="left">
                    <s:if test="CMD == WEB_CMD_NEW"> 
					 <s:textfield cssStyle="style_input" name="form.exmnperiod" onclick="selectDateYYYYMM();" readonly="true" />
						 <font color=red>*</font>
					</s:if>
					<s:elseif test="CMD == WEB_CMD_EDIT">
					  <s:textfield cssStyle="style_input" name="form.exmnperiod" onclick="selectDateYYYYMM();" readonly="true" disabled="true"/>
					</s:elseif>
					<s:else>
						 <s:textfield cssStyle="style_input" name="form.exmnperiod" onclick="selectDateYYYYMM();" readonly="true" disabled="true"/>
						 <font color=red>*</font>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="penalamt"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD == WEB_CMD_NEW">
						<s:textfield cssStyle="style_input" name="form.penalamt" maxlength="16"/>
						 <font color=red>*</font>单位:元
					</s:if>
					<s:elseif test="CMD == WEB_CMD_EDIT">
					      <s:textfield cssStyle="style_input" name="form.penalamt" maxlength="16"  />
						 <font color=red>*</font>单位:元
					 </s:elseif>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.penalamt" disabled="true"/>
						 <font color=red>*</font>单位:元
					</s:else>
                </td>
            </tr> 
            <tr>
                <td align="right"><s:text name="memo"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD == WEB_CMD_NEW">
						<s:textarea cssStyle="style_input" name="form.memo" maxlength="1000" rows="4" cols="40"/>
						 <font color=red>*</font>
					</s:if>
					<s:elseif test="CMD == WEB_CMD_EDIT">
					     <s:textarea cssStyle="style_input" name="form.memo" maxlength="1000" rows="4" cols="40"/>
						 <font color=red>*</font>
					 </s:elseif>
					<s:else>
						<s:textarea cssStyle="style_input" name="form.memo" rows="4" cols="40" disabled="true"/>
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
                           value="<s:text name="button_save"/>" onclick="doSave('/examine/disexamine_save.do')"
                           <s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if>
                           />
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/examine/disexamine_list.do')">
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
		addfield('form.discomcode', '<s:text name="discomcode"/>', 'c', false, 18);
		addfield('form.penalamt', '<s:text name="penalamt"/>', 'f', false, 16); 
		addfield('form.memo', '<s:text name="memo"/>', 'c', false, 1000);
		return checkval(window);
	}
</script>