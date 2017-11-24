<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc" %>
<html>
<head>
    <title><s:text name="titleUpdate"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/pwaycommon.js"></script>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('form.wayid', '<s:text name="wayid"/>', 'c', false, 18);
			addfield('form.batchno', '<s:text name="batchno"/>', 'c', false, 30);
			
            return checkval(window);
        }
    </script>
</head>
<body class="list_body" onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<s:form action="numtypedeflog_save.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">
			
	
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<span class="table_toparea_h"><s:text name="title_confirmresource"/></span>
			<span class="button_Help" onclick="openword('<s:text name="helpTitle"/>','<s:text name="packresource_help"/>')"><s:i18n name="public"><s:text name="help"/></s:i18n></span>
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
                <td align="right"><s:text name="res_wayid"/>:&nbsp;</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.wayid"   maxlength="18" readonly="true"/>
					<input type="button" value="..." class="picker_button"  onclick="pshowSelectWay3(this,'form.wayid');this.value='...';" />
                    <font color=red>*</font>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="batchno"/>:&nbsp;</td>
                <td align="left">
					  <s:textfield cssStyle="style_input" name="form.batchno"  maxlength="30"/>
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
                    <input type="button" id="btnSave" name="btnNext" class="button4" onmouseover="buttonover(this);" 
                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="ÏÂÒ»²½" onclick="doSave('/resource/compack_confirmResource.do')" />
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
</div>
</body>
</html>
