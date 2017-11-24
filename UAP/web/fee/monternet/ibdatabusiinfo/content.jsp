<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ include file="/inc/contenthead.inc"%>

<html>
<head>
    <title><s:text name="titleUpdate"/></title>
</head>
<body>

<s:form action="ibdatabusiinfo_save.do" name="formItem" id="formItem" method="post" theme="simple">
			
    <s:hidden name="CMD" id="cmd"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param._ne_billcycle"/>
    <s:hidden name="param._se_filetype"/>
    <s:hidden name="param._se_spCode"/>
    <s:hidden name="param._se_opCode"/>
    <s:hidden name="param._se_port"/>
    <s:hidden name="param._ne_chargingtype"/>
    <s:hidden name="param._ne_fee"/>
    <s:hidden name="param._ne_acctitemIdlv1"/>
    <s:hidden name="param._ne_acctitemIdlv2"/>
	
	<div class="title_div">
		<div class="title_left_div">
			<s:i18n name="public">
				<s:text name="currentPos" />>
				<s:text name="monternet" />>
			</s:i18n>
			<s:text name="titleList" />
		</div >
        <div class="title_right_div">
        	<s:i18n name="public">
        		<input type="button" class="form_button" value="<s:text name="help"/>" 
        			onclick="openword('<s:text name="helpTitle"/>','<s:text name="helpContent"/>')">
        	</s:i18n>
        </div>
	</div>

	<div id="errorDiv" class="message_div" style="display:none">
		<s:actionerror />
		<s:actionmessage/>
	</div>
	
    <table class="content_table" id="contentTable">
        <tr>
            <td class="content_table_td_left"><s:text name="billcycle"/>:&nbsp;</td>
            <td class="content_table_td_right">
				<s:textfield name="form.billcycle" cssClass="form_text required edit" maxlength="6"/>
                <span class="font_required">*</span>
            </td>
        </tr>
        <tr>
            <td class="content_table_td_left"><s:text name="filetype"/>:&nbsp;</td>
            <td class="content_table_td_right">
				<s:textfield name="form.filetype" cssClass="form_text required edit" maxlength="2"/>
                <span class="font_required">*</span>
            </td>
        </tr>
        <tr>
            <td class="content_table_td_left"><s:text name="spCode"/>:&nbsp;</td>
            <td class="content_table_td_right">
                <s:textfield name="form.spCode" cssClass="form_text edit" maxlength="16"/>    
            </td>
        </tr>
        <tr>
            <td class="content_table_td_left"><s:text name="opCode"/>:&nbsp;</td>
            <td class="content_table_td_right">
                <s:textfield name="form.opCode" cssClass="form_text edit" maxlength="16"/>    
            </td>
        </tr>
        <tr>
            <td class="content_table_td_left"><s:text name="port"/>:&nbsp;</td>
            <td class="content_table_td_right">
				<s:textfield name="form.port" cssClass="form_text required edit" maxlength="24"/>
                <span class="font_required">*</span>
            </td>
        </tr>
        <tr>
            <td class="content_table_td_left"><s:text name="chargingtype"/>:&nbsp;</td>
            <td class="content_table_td_right">
				<s:textfield name="form.chargingtype" cssClass="form_text required edit" maxlength="2"/>
                <span class="font_required">*</span>
            </td>
        </tr>
        <tr>
            <td class="content_table_td_left"><s:text name="fee"/>:&nbsp;</td>
            <td class="content_table_td_right">
                <s:textfield name="form.fee" cssClass="form_text edit" maxlength="16"/>    
            </td>
        </tr>
        <tr>
            <td class="content_table_td_left"><s:text name="acctitemIdlv1"/>:&nbsp;</td>
            <td class="content_table_td_right">
                <s:textfield name="form.acctitemIdlv1" cssClass="form_text edit" maxlength="14"/>    
            </td>
        </tr>
        <tr>
            <td class="content_table_td_left"><s:text name="acctitemIdlv2"/>:&nbsp;</td>
            <td class="content_table_td_right">
                <s:textfield name="form.acctitemIdlv2" cssClass="form_text edit" maxlength="14"/>    
            </td>
        </tr>
    </table>

	<div class="title_center_div" id="buttonDiv">
		<s:i18n name="public">
			<input type="button" class="form_button edit" value="<s:text name="button_save"/>"
				onclick="doSave('/monternet/ibdatabusiinfo_save.do')"/>
			<input type="button" class="form_button" value="<s:text name="button_return"/>"
				onclick="doReturn('/monternet/ibdatabusiinfo_list.do')">
		</s:i18n>
	</div>
</s:form>
</body>
</html>
