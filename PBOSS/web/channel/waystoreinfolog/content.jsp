<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ include file="/inc/contenthead.inc"%>

<html>
<head>
    <title><s:text name="titleUpdate"/></title>
</head>
<body>

<s:form action="waystoreinfolog_save.do" name="formItem" id="formItem" method="post" theme="simple">
			
    <s:hidden name="CMD" id="cmd"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param._ne_logid"/>
    <s:hidden name="param._dnm_optime"/>
    <s:hidden name="param._dnl_optime"/>
    <s:hidden name="param._se_oprtype"/>
    <s:hidden name="param._se_success"/>
    <s:hidden name="param._se_wayid"/>
    <s:hidden name="param._se_cityid"/>
    <s:hidden name="param._ne_zqtype"/>
    <s:hidden name="param._ne_doortype"/>
    <s:hidden name="param._dnm_createtime"/>
    <s:hidden name="param._dnl_createtime"/>
	
	<div class="title_div">
		<div class="title_left_div">
			<s:i18n name="public">
				<s:text name="currentPos" />>
				<s:text name="channel" />>
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
            <td class="content_table_td_left"><s:text name="oprcode"/>:&nbsp;</td>
            <td class="content_table_td_right">
                <s:textfield name="form.oprcode" cssClass="form_text edit" maxlength="15"/>    
            </td>
        </tr>
        <tr>
            <td class="content_table_td_left"><s:text name="optime"/>:&nbsp;</td>
            <td class="content_table_td_right">
                <s:textfield name="form.optime" cssClass="form_text edit" maxlength="7"/>    
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
            <td class="content_table_td_left"><s:text name="wayid"/>:&nbsp;</td>
            <td class="content_table_td_right">
                <s:textfield name="form.wayid" cssClass="form_text edit" maxlength="18"/>    
            </td>
        </tr>
        <tr>
            <td class="content_table_td_left"><s:text name="area"/>:&nbsp;</td>
            <td class="content_table_td_right">
                <s:textfield name="form.area" cssClass="form_text edit" maxlength="14"/>    
            </td>
        </tr>
        <tr>
            <td class="content_table_td_left"><s:text name="cityid"/>:&nbsp;</td>
            <td class="content_table_td_right">
                <s:textfield name="form.cityid" cssClass="form_text edit" maxlength="14"/>    
            </td>
        </tr>
        <tr>
            <td class="content_table_td_left"><s:text name="zqtype"/>:&nbsp;</td>
            <td class="content_table_td_right">
                <s:textfield name="form.zqtype" cssClass="form_text edit" maxlength="2"/>    
            </td>
        </tr>
        <tr>
            <td class="content_table_td_left"><s:text name="zqpic"/>:&nbsp;</td>
            <td class="content_table_td_right">
                <s:textfield name="form.zqpic" cssClass="form_text edit" maxlength="225"/>    
            </td>
        </tr>
        <tr>
            <td class="content_table_td_left"><s:text name="zqarea"/>:&nbsp;</td>
            <td class="content_table_td_right">
                <s:textfield name="form.zqarea" cssClass="form_text edit" maxlength="14"/>    
            </td>
        </tr>
        <tr>
            <td class="content_table_td_left"><s:text name="zqpanel"/>:&nbsp;</td>
            <td class="content_table_td_right">
                <s:textfield name="form.zqpanel" cssClass="form_text edit" maxlength="2"/>    
            </td>
        </tr>
        <tr>
            <td class="content_table_td_left"><s:text name="zqcupboard"/>:&nbsp;</td>
            <td class="content_table_td_right">
                <s:textfield name="form.zqcupboard" cssClass="form_text edit" maxlength="4"/>    
            </td>
        </tr>
        <tr>
            <td class="content_table_td_left"><s:text name="zqcards"/>:&nbsp;</td>
            <td class="content_table_td_right">
                <s:textfield name="form.zqcards" cssClass="form_text edit" maxlength="4"/>    
            </td>
        </tr>
        <tr>
            <td class="content_table_td_left"><s:text name="zqpricetag"/>:&nbsp;</td>
            <td class="content_table_td_right">
                <s:textfield name="form.zqpricetag" cssClass="form_text edit" maxlength="4"/>    
            </td>
        </tr>
        <tr>
            <td class="content_table_td_left"><s:text name="zqrack"/>:&nbsp;</td>
            <td class="content_table_td_right">
                <s:textfield name="form.zqrack" cssClass="form_text edit" maxlength="4"/>    
            </td>
        </tr>
        <tr>
            <td class="content_table_td_left"><s:text name="zqinad"/>:&nbsp;</td>
            <td class="content_table_td_right">
                <s:textfield name="form.zqinad" cssClass="form_text edit" maxlength="2"/>    
            </td>
        </tr>
        <tr>
            <td class="content_table_td_left"><s:text name="zqoutad"/>:&nbsp;</td>
            <td class="content_table_td_right">
                <s:textfield name="form.zqoutad" cssClass="form_text edit" maxlength="2"/>    
            </td>
        </tr>
        <tr>
            <td class="content_table_td_left"><s:text name="zqhead"/>:&nbsp;</td>
            <td class="content_table_td_right">
                <s:textfield name="form.zqhead" cssClass="form_text edit" maxlength="2"/>    
            </td>
        </tr>
        <tr>
            <td class="content_table_td_left"><s:text name="zqpaste"/>:&nbsp;</td>
            <td class="content_table_td_right">
                <s:textfield name="form.zqpaste" cssClass="form_text edit" maxlength="2"/>    
            </td>
        </tr>
        <tr>
            <td class="content_table_td_left"><s:text name="zqtablecard"/>:&nbsp;</td>
            <td class="content_table_td_right">
                <s:textfield name="form.zqtablecard" cssClass="form_text edit" maxlength="4"/>    
            </td>
        </tr>
        <tr>
            <td class="content_table_td_left"><s:text name="zqdecca"/>:&nbsp;</td>
            <td class="content_table_td_right">
                <s:textfield name="form.zqdecca" cssClass="form_text edit" maxlength="4"/>    
            </td>
        </tr>
        <tr>
            <td class="content_table_td_left"><s:text name="zqbill"/>:&nbsp;</td>
            <td class="content_table_td_right">
                <s:textfield name="form.zqbill" cssClass="form_text edit" maxlength="4"/>    
            </td>
        </tr>
        <tr>
            <td class="content_table_td_left"><s:text name="doorpic"/>:&nbsp;</td>
            <td class="content_table_td_right">
                <s:textfield name="form.doorpic" cssClass="form_text edit" maxlength="225"/>    
            </td>
        </tr>
        <tr>
            <td class="content_table_td_left"><s:text name="doortype"/>:&nbsp;</td>
            <td class="content_table_td_right">
                <s:textfield name="form.doortype" cssClass="form_text edit" maxlength="2"/>    
            </td>
        </tr>
        <tr>
            <td class="content_table_td_left"><s:text name="outwallad"/>:&nbsp;</td>
            <td class="content_table_td_right">
                <s:textfield name="form.outwallad" cssClass="form_text edit" maxlength="14"/>    
            </td>
        </tr>
        <tr>
            <td class="content_table_td_left"><s:text name="outwallpic"/>:&nbsp;</td>
            <td class="content_table_td_right">
                <s:textfield name="form.outwallpic" cssClass="form_text edit" maxlength="2"/>    
            </td>
        </tr>
        <tr>
            <td class="content_table_td_left"><s:text name="tdmonopoly"/>:&nbsp;</td>
            <td class="content_table_td_right">
                <s:textfield name="form.tdmonopoly" cssClass="form_text edit" maxlength="2"/>    
            </td>
        </tr>
        <tr>
            <td class="content_table_td_left"><s:text name="busimonopoly"/>:&nbsp;</td>
            <td class="content_table_td_right">
                <s:textfield name="form.busimonopoly" cssClass="form_text edit" maxlength="2"/>    
            </td>
        </tr>
        <tr>
            <td class="content_table_td_left"><s:text name="storeconduct"/>:&nbsp;</td>
            <td class="content_table_td_right">
                <s:textfield name="form.storeconduct" cssClass="form_text edit" maxlength="4"/>    
            </td>
        </tr>
        <tr>
            <td class="content_table_td_left"><s:text name="modulus"/>:&nbsp;</td>
            <td class="content_table_td_right">
                <s:textfield name="form.modulus" cssClass="form_text edit" maxlength="4"/>    
            </td>
        </tr>
        <tr>
            <td class="content_table_td_left"><s:text name="unit"/>:&nbsp;</td>
            <td class="content_table_td_right">
                <s:textfield name="form.unit" cssClass="form_text edit" maxlength="2"/>    
            </td>
        </tr>
        <tr>
            <td class="content_table_td_left"><s:text name="createtime"/>:&nbsp;</td>
            <td class="content_table_td_right">
                <s:textfield name="form.createtime" cssClass="form_text edit" maxlength="7"/>    
            </td>
        </tr>
    </table>

	<div class="title_center_div" id="buttonDiv">
		<s:i18n name="public">
			<input type="button" class="form_button edit" value="<s:text name="button_save"/>"
				onclick="doSave('/channel/waystoreinfolog_save.do')"/>
			<input type="button" class="form_button" value="<s:text name="button_return"/>"
				onclick="doReturn('/channel/waystoreinfolog_list.do')">
		</s:i18n>
	</div>
</s:form>
</body>
</html>
