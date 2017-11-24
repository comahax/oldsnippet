<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ page import="com.sunrise.jop.infrastructure.db.CityMappingUtil,com.sunrise.jop.ui.User,com.opensymphony.xwork2.*,com.sunrise.jop.ui.struts2.*" %>
<%@ include file="/inc/contenthead.inc"%>
<%
User user = (User)ActionContext.getContext().getSession().get(WebConstant.SESSION_ATTRIBUTE_USER);
String citycode = CityMappingUtil.getCityid(user.getCityid());
citycode="citycompid:"+citycode;
 %>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A6FBT14" />
</jsp:include>
<html>
<head>
    <title><s:text name="titleUpdate"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/pwaycommon.js"></script>
    <script language="JavaScript">
        function ev_checkval() {
           // addfield('form.id', '<s:text name="id"/>', 'f', false, 18);
			addfield('form.cityid', '<s:text name="cityid"/>', 'c', false, 14);
			addfield('form.restype', '<s:text name="restype"/>', 'c', false, 32);
			addfield('form.receiveway', '<s:text name="receiveway"/>', 'c', false, 18);
            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<s:form action="resloadparam_save.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">
			
    <s:hidden name="CMD"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param._ne_id"/>
    <s:hidden name="param._se_cityid"/>
    <s:hidden name="param._se_restype"/>
	
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
                <td align="right"><s:text name="id"/>:&nbsp</td>
                <td align="left">
			        <s:if test="CMD == WEB_CMD_NEW">
                        <s:textfield cssStyle="style_input" name="form.id" maxlength="18" disabled="true"/>
                        <font color=red>*</font>
			        </s:if>
			        <s:else>
						<s:textfield cssStyle="style_input" name="form.id" disabled="true"/>
						<font color=red>*</font>
			        </s:else>自动生成
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="cityid"/>:&nbsp</td>
                <td align="left">
					 <j:selector name="form.cityid" definition="#CITYCOMPANY" condition="citycompid:${USER.cityid}"  mode="selector"  disabled="true"/>
					<font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="restype"/>:&nbsp</td>
                <td align="left">
					<j:selector name="form.restype" definition="$IM_FXRESTYPE" readonly="true"/>
					<font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="receiveway"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.receiveway" readonly="true"/><input type="button" value="..." class="picker_button" onclick="pshowSelectWay3(this,'form.receiveway');this.value='...';" />
					<font color=red>*</font>
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
                           value="<s:text name="button_save"/>" onclick="doSave('/resource/resloadparam_save.do')" <s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if>/>
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/resource/resloadparam_list.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
</body>
</html>
