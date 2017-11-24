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
		addfield('form.cityid', '<s:text name="cityid"/>', 'c', false, 20);
		addfield('form.countyid', '<s:text name="countyid"/>', 'c', false, 14);
		addfield('form.extraexent', '<s:text name="extraexent"/>', 'c', false, 14);
		return checkval(window);
	}
</script>
</head>
<body>
<div class="table_container">
<s:form action="/sales/extraexent_save.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">
			
    <s:hidden name="CMD"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param._se_countyid"/>
    <s:hidden name="param._se_extraexent"/>
	
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea">分销管理</span>
			<span class="table_toparea_xi">></span>
			</s:i18n>
			<span class="table_toparea_h">
			
					<s:text name="titleList"/>
					
			
			
			</span>
			<span class="button_Help" onclick="openword('分公司资源抽取范围设置','分公司资源抽取范围设置')"><s:i18n name="public"><s:text name="help"/></s:i18n></span>
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
                <input type="hidden" name="form.cityid" value="${form.cityid }">
              		<input disabled="true" type="text" value='<j:code2Name definition="CITYNAME" code="form.cityid"/>'>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="countyid"/>:&nbsp</td>
                <td align="left">
			        <s:if test="CMD == WEB_CMD_NEW">
			         <j:selector definition="#CNTYCOMPANY" name="form.countyid" condition="citycompid:${USER.cityid}" readonly="true"/>
                        <font color=red>*</font>
			        </s:if>
			        <s:elseif test="CMD == WEB_CMD_EDIT">
			        <j:selector definition="#CNTYCOMPANY" name="form.countyid" disabled="true"/>
						<font color=red>*</font>
					</s:elseif>
			        <s:else>
			        <j:selector definition="#CNTYCOMPANY" name="form.countyid" disabled="true"/>
						<font color=red>*</font>
			        </s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="extraexent"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
					 <j:selector definition="$FX_EXTRAEXENT" name="form.extraexent"/>
					 <font color=red>*</font>
					</s:if>
					<s:else>
					 <j:selector definition="$FX_EXTRAEXENT" name="form.extraexent" disabled="true"/>
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
                           value="<s:text name="button_save"/>" onclick="doSave('/sales/extraexent_save.do')"
                           <s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if>
                           />
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/sales/extraexent_list.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
</body>
</html>