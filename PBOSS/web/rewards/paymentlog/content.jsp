<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ include file="/inc/contenthead.inc"%>

<html>
<head>
    <title><s:text name="titleUpdate"/></title>
</head>
<body>

<s:form action="paymentlog_save.do" name="formItem" id="formItem" method="post" theme="simple">
			
    <s:hidden name="CMD" id="cmd"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param._dnm_optime"/>
    <s:hidden name="param._dnl_optime"/>
    <s:hidden name="param._se_oprcode"/>
    <s:hidden name="param._se_oprtype"/>
    <s:hidden name="param._se_optype"/>
    <s:hidden name="param._snm_opmonth"/>
    <s:hidden name="param._snl_opmonth"/>
    <s:hidden name="param._snm_paymonth"/>
    <s:hidden name="param._snl_paymonth"/>
	
	<div class="title_div">
		<div class="title_left_div">
			<s:i18n name="public">
				<s:text name="currentPos" />>
				<s:text name="reward" />>
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
            <td class="content_table_td_left"><s:text name="logid"/>:&nbsp;</td>
            <td class="content_table_td_right">
				<s:textfield name="form.logid" cssClass="form_text required edit" maxlength="14"/>
                <span class="font_required">*</span>
            </td>
        </tr>
        <tr>
            <td class="content_table_td_left"><s:text name="optime"/>:&nbsp;</td>
            <td class="content_table_td_right">
                <s:textfield name="form.optime" cssClass="form_text edit" maxlength="7"/>    
            </td>
        </tr>
        <tr>
            <td class="content_table_td_left"><s:text name="oprcode"/>:&nbsp;</td>
            <td class="content_table_td_right">
                <s:textfield name="form.oprcode" cssClass="form_text edit" maxlength="15"/>    
            </td>
        </tr>
        <tr>
            <td class="content_table_td_left"><s:text name="oprtype"/>:&nbsp;</td>
            <td class="content_table_td_right">
                <s:textfield name="form.oprtype" cssClass="form_text edit" maxlength="8"/>    
            </td>
        </tr>
        <tr>
            <td class="content_table_td_left"><s:text name="success"/>:&nbsp;</td>
            <td class="content_table_td_right">
                <s:textfield name="form.success" cssClass="form_text edit" maxlength="8"/>    
            </td>
        </tr>
        <tr>
            <td class="content_table_td_left"><s:text name="optype"/>:&nbsp;</td>
            <td class="content_table_td_right">
                <s:textfield name="form.optype" cssClass="form_text edit" maxlength="16"/>    
            </td>
        </tr>
        <tr>
            <td class="content_table_td_left"><s:text name="opmonth"/>:&nbsp;</td>
            <td class="content_table_td_right">
                <s:textfield name="form.opmonth" cssClass="form_text edit" maxlength="6"/>    
            </td>
        </tr>
        <tr>
            <td class="content_table_td_left"><s:text name="paymonth"/>:&nbsp;</td>
            <td class="content_table_td_right">
                <s:textfield name="form.paymonth" cssClass="form_text edit" maxlength="6"/>    
            </td>
        </tr>
        <tr>
            <td class="content_table_td_left"><s:text name="stype"/>:&nbsp;</td>
            <td class="content_table_td_right">
                <s:textfield name="form.stype" cssClass="form_text edit" maxlength="128"/>    
            </td>
        </tr>
        <tr>
            <td class="content_table_td_left"><s:text name="payee"/>:&nbsp;</td>
            <td class="content_table_td_right">
                <s:textfield name="form.payee" cssClass="form_text edit" maxlength="128"/>    
            </td>
        </tr>
        <tr>
            <td class="content_table_td_left"><s:text name="paysum"/>:&nbsp;</td>
            <td class="content_table_td_right">
                <s:textfield name="form.paysum" cssClass="form_text edit" maxlength="18"/>    
            </td>
        </tr>
        <tr>
            <td class="content_table_td_left"><s:text name="rewardstd"/>:&nbsp;</td>
            <td class="content_table_td_right">
                <s:textfield name="form.rewardstd" cssClass="form_text edit" maxlength="4000"/>    
            </td>
        </tr>
        <tr>
            <td class="content_table_td_left"><s:text name="rule"/>:&nbsp;</td>
            <td class="content_table_td_right">
                <s:textfield name="form.rule" cssClass="form_text edit" maxlength="4000"/>    
            </td>
        </tr>
        <tr>
            <td class="content_table_td_left"><s:text name="deduction"/>:&nbsp;</td>
            <td class="content_table_td_right">
                <s:textfield name="form.deduction" cssClass="form_text edit" maxlength="4000"/>    
            </td>
        </tr>
    </table>

	<div class="title_center_div" id="buttonDiv">
		<s:i18n name="public">
			<input type="button" class="form_button edit" value="<s:text name="button_save"/>"
				onclick="doSave('/reward/paymentlog_save.do')"/>
			<input type="button" class="form_button" value="<s:text name="button_return"/>"
				onclick="doReturn('/reward/paymentlog_list.do')">
		</s:i18n>
	</div>
</s:form>
</body>
</html>
