<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ include file="/inc/contenthead.inc"%>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A6FBT14" />
</jsp:include>
<%
	String ID_1 = "CH_PW_SALEWAY_ADD";
%>
<html>
<head>
    <title><s:text name="titleUpdate"/></title>
    <script type="text/javascript"
			src="<%=contextPath%>/js/bus/pwaycommon.js"></script>
    <script language="JavaScript">
        function ev_checkval() {
        	addfield('form.wayid', '<s:text name="wayid"/>', 'c', false, 18);
            addfield('form.wayname', '<s:text name="wayname"/>', 'c', false, 256);
            addfield('form.waysubtype', '<s:text name="waysubtype"/>', 'c', false, 18);
            addfield('form.chainhead', '<s:text name="chainhead"/>', 'c', false, 18);
            addfield('form.cityid', '<s:text name="cityid"/>', 'c', false, 14);
			addfield('form.waystate', '<s:text name="waystate"/>', 'c', false,3);
			addfield('form.starttime', '<s:text name="starttime"/>', 't', false, 18);
			addfield('form.disabletime', '<s:text name="disabletime"/>', 't', false, 18);
			
            return checkval(window);
        }
       
     	
     	
    </script>
</head>
<body onload="displayMemo();selectCheck();">
<div class="table_container">
<s:form action="financeway_save.do" cssStyle="formList" key="formItem" method="post" theme="simple" onsubmit="return ev_checkval();">
    <s:hidden name="CMD"/>
    <s:hidden name="flag"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
	<s:hidden name="form.createtime" value="%{getText('format.datetime',{form.createtime})}"/>
	<s:hidden name="form.waytype"/>
	
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="channel"/> </span>
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
                        <s:textfield cssStyle="style_input" name="form.wayid" maxlength="18"/>
                        <font color="red">*</font>
			        </s:if>
			        <s:elseif test="CMD == WEB_CMD_EDIT">
			        	<s:textfield cssStyle="style_input" name="form.wayid" readonly="true"/>
						<font color="red">*</font>
					</s:elseif>
			        <s:else>
						<s:textfield cssStyle="style_input" name="form.wayid" disabled="true"/>
						<font color="red">*</font>
			        </s:else>
                </td>
                <td align="right"><s:text name="wayname"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.wayname" maxlength="256"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.wayname" disabled="true"/>
					</s:else>
					<font color="red">*</font>
                </td>
            </tr>
            <tr>
            
             <td align="right"><s:text name="waysubtype"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.waysubtype" definition="FWAYSUBTYPE" />
						
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.waysubtype" disabled="true"/>
					</s:else>
					<font color="red">*</font>
                </td>
             <td align="right"><s:text name="chainhead"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.chainhead" definition="#WAY" readonly="true" 
							condition="waytype:EC;wayid:BANK;waystate:1;cityid:${dBAccessUser.cityid}"/>
						
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.chainhead" disabled="true"/>
						
					</s:else>
					<font color="red">*</font>
                </td>
            </tr>
             <tr>
              <td align="right"><s:text name="cityid"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.cityid" definition="CITYNAME" value="${dBAccessUser.cityid }" mode="selector" disabled="true"  />
					</s:if>
					<s:else>
						<j:selector name="form.cityid" definition="CITYNAME" disabled="true" />
					</s:else>
					<font color="red">*</font>
                </td>
               <td align="right"><s:text name="waystate"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<j:selector name="form.waystate" definition="$CH_WAYSTATE" />
						<font color="red">*</font>
					</s:if>
					<s:else>
						<j:selector name="form.waystate" definition="$CH_WAYSTATE" disabled="true" />
						<font color="red">*</font>
					</s:else>
                </td>
              
            </tr>
             <tr>
               <td align="right"><s:text name="starttime"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<input class="style_input" name="form.starttime" value="<s:property value="form.starttime!=null?getText('format.date',{form.starttime}):''"/>" onclick="selectDate();"/>
					</s:if>
					<s:else>
						<input class="style_input" name="form.starttime" value="<s:property value="form.starttime!=null?getText('format.date',{form.starttime}):''"/>" disabled="true"/>
					</s:else>
					<font color="red">*</font>
                </td>
               <td align="right"><s:text name="disabletime"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<input class="style_input" name="form.disabletime" value="<s:property value="form.disabletime!=null?getText('format.date',{form.disabletime}):''"/>" onclick="selectDate();"/>
					</s:if>
					<s:else>
						<input class="style_input" name="form.disabletime" value="<s:property value="form.disabletime!=null?getText('format.date',{form.disabletime}):''"/>" disabled="true"/>
					</s:else>
					<font color="red">*</font>
                </td>
            </tr>
        </table>
    </div>

    <div class="table_div">
        <table class="table_button_list">
            <tr>
                <td width="100%" align="center">
                   	<s:i18n name="public">
					<j:purChk permid="<%=ID_1%>" disableChild="true">
                    	<input type="button" id="btnSave" name="btnSave" class="button_Save" onmouseover="buttonover(this);" 
                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_save"/>" onclick="doSave('/channel/financeway_save.do')"
                           <s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if> />
                    </j:purChk>
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                   	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                       value="<s:text name="button_return"/>" onclick="doReturn('/channel/financeway_list.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
</body>
</html>
