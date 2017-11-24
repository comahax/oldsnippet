<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A6FBT14" />
</jsp:include>
<html>
<head>
    <title><s:text name="titleUpdate"/></title>
    <script type="text/javascript"src="<%=contextPath%>/js/bus/pwaycommon.js"></script>
</head>
<body>
<div class="table_container">
<s:form action="resoperator_save.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">
			
    <s:hidden name="CMD"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param._se_wayid"/>
    <s:hidden name="param._se_operid"/>
	
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
                <td align="right"><s:text name="wayid"/>:&nbsp</td>
                <td align="left">
			        <s:if test="CMD == WEB_CMD_NEW">
                        <s:textfield cssStyle="style_input" name="form.wayid" maxlength="18" readonly="true"/><input type="button" value="..." class="picker_button"
									onclick="pshowSelectWay3(this,'form.wayid','','','AG');this.value='...';"/> 
                        <font color=red>*</font>
			        </s:if>
			        <s:else>
			        	<s:textfield cssStyle="style_input" name="form.wayid" disabled="true" readonly="true"/><input type="button" value="..." class="picker_button"
									onclick="pshowSelectWay3(this,'form.wayid','','','AG');this.value='...';" />
						<font color=red>*</font>
					</s:else> 
                </td>
            </tr>
            
            <tr>
                <td align="right"><s:text name="operid"/>:&nbsp</td>
                <td align="left">
					 <s:if test="CMD == WEB_CMD_NEW">
			        	<j:selector definition="#OPERATOR" name="form.operid" condition='region:${dBAccessUser.hwcityid };status:1' readonly="true"/>
                        <font color=red>*</font>
			        </s:if>
			        <s:else>
			        	<j:selector definition="#OPERATOR" name="form.operid" condition='region:${dBAccessUser.hwcityid };status:1' readonly="true" />
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
                           value="<s:text name="button_save"/>" onclick="doSave('/resource/resoperator_save.do')"
                           <s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if>
                           />
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/resource/resoperator_list.do')">
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
		addfield('form.wayid', '<s:text name="wayid"/>', 'c', false, 18); 
		addfield('form.operid', '<s:text name="operid"/>', 'c', false, 16);
		return checkval(window);
	}
</script>