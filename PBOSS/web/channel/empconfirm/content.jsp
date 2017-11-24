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
<s:form action="empconfirm_save.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">
			
    <s:hidden name="CMD"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param._se_employeeid"/>
    <s:hidden name="param._se_wayid"/>
    <s:hidden name="param._ne_empstatus"/>
    <s:hidden name="param._ne_confirmid"/>
    <s:hidden name="param._ne_smsstatus"/>
    <s:hidden name="param._dnm_smscreattime"/>
    <s:hidden name="param._dnl_smscreattime"/>
	
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
                <td align="right"><s:text name="employeeid"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.employeeid" maxlength="15"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.employeeid" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="oprcode"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.oprcode" maxlength="15"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.oprcode" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="employeename"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.employeename" maxlength="30"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.employeename" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="birthday"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.birthday" maxlength="7"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.birthday" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="sex"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.sex" maxlength="3"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.sex" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="edulevel"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.edulevel" maxlength="3"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.edulevel" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="nativehome"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.nativehome" maxlength="20"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.nativehome" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="polivisage"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.polivisage" maxlength="3"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.polivisage" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="department"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.department" maxlength="18"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.department" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="servoffice"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.servoffice" maxlength="18"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.servoffice" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="station"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.station" maxlength="14"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.station" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="joblevel"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.joblevel" maxlength="3"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.joblevel" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="intime"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.intime" maxlength="7"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.intime" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="worktime"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.worktime" maxlength="3"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.worktime" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="hereworktime"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.hereworktime" maxlength="3"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.hereworktime" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="employtype"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.employtype" maxlength="3"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.employtype" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="company"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.company" maxlength="50"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.company" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="telephone"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.telephone" maxlength="15"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.telephone" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="officetel"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.officetel" maxlength="12"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.officetel" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="outtime"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.outtime" maxlength="7"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.outtime" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="outresult"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.outresult" maxlength="255"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.outresult" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="homeaddr"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.homeaddr" maxlength="255"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.homeaddr" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="cardid"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.cardid" maxlength="18"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.cardid" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="wayid"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.wayid" maxlength="18"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.wayid" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="waytype"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.waytype" maxlength="4"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.waytype" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="pvtemail"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.pvtemail" maxlength="128"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.pvtemail" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="ofcphone"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.ofcphone" maxlength="64"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.ofcphone" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="ofcemail"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.ofcemail" maxlength="128"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.ofcemail" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="speciality"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.speciality" maxlength="16"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.speciality" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="cityid"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.cityid" maxlength="14"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.cityid" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="countyid"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.countyid" maxlength="14"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.countyid" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="svccode"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.svccode" maxlength="14"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.svccode" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="posittype"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.posittype" maxlength="16"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.posittype" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="contacttype"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.contacttype" maxlength="2"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.contacttype" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="empstatus"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.empstatus" maxlength="2"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.empstatus" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="actbank"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.actbank" maxlength="64"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.actbank" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="actno"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.actno" maxlength="32"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.actno" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="actname"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.actname" maxlength="32"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.actname" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="actpid"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.actpid" maxlength="20"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.actpid" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="bail"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.bail" maxlength="12"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.bail" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="gradschool"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.gradschool" maxlength="40"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.gradschool" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="gradtime"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.gradtime" maxlength="7"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.gradtime" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="ismarried"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.ismarried" maxlength="2"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.ismarried" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="outreason"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.outreason" maxlength="2"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.outreason" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="trainlevel"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.trainlevel" maxlength="20"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.trainlevel" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="hobby"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.hobby" maxlength="255"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.hobby" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="character"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.character" maxlength="255"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.character" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="asses"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.asses" maxlength="255"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.asses" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="workhistry"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.workhistry" maxlength="255"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.workhistry" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="prizeorpunish"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.prizeorpunish" maxlength="255"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.prizeorpunish" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="empass"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.empass" maxlength="20"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.empass" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="right"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.right" maxlength="2"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.right" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="isnet"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.isnet" maxlength="2"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.isnet" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="netpass"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.netpass" maxlength="6"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.netpass" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="isopen"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.isopen" maxlength="2"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.isopen" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="selectmobile"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.selectmobile" maxlength="12"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.selectmobile" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="subname"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.subname" maxlength="40"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.subname" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="regdate"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.regdate" maxlength="7"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.regdate" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="empattr"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.empattr" maxlength="50"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.empattr" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="empattrmemo"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.empattrmemo" maxlength="512"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.empattrmemo" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="confirmid"/>:&nbsp</td>
                <td align="left">
			        <s:if test="CMD == WEB_CMD_NEW">
                        <s:textfield cssStyle="style_input" name="form.confirmid" maxlength="14"/>
                        <font color=red>*</font>
			        </s:if>
			        <s:elseif test="CMD == WEB_CMD_EDIT">
			        	<s:textfield cssStyle="style_input" name="form.confirmid" disabled="true"/>
						<font color=red>*</font>
					</s:elseif>
			        <s:else>
						<s:textfield cssStyle="style_input" name="form.confirmid" disabled="true"/>
						<font color=red>*</font>
			        </s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="smsstatus"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.smsstatus" maxlength="3"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.smsstatus" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="smscreattime"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.smscreattime" maxlength="7"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.smscreattime" disabled="true"/>
					</s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="smsconfirmtime"/>:&nbsp</td>
                <td align="left">
					<s:if test="CMD != WEB_CMD_SAVE">
						<s:textfield cssStyle="style_input" name="form.smsconfirmtime" maxlength="7"/>
					</s:if>
					<s:else>
						<s:textfield cssStyle="style_input" name="form.smsconfirmtime" disabled="true"/>
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
                           value="<s:text name="button_save"/>" onclick="doSave('/channel/empconfirm_save.do')"
                           <s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if>
                           />
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/channel/empconfirm_list.do')">
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
		addfield('form.employeeid', '<s:text name="employeeid"/>', 'c', true, 15);
		addfield('form.oprcode', '<s:text name="oprcode"/>', 'c', true, 15);
		addfield('form.employeename', '<s:text name="employeename"/>', 'c', true, 30);
		addfield('form.birthday', '<s:text name="birthday"/>', 't', true, 7);
		addfield('form.sex', '<s:text name="sex"/>', 'f', true, 3);
		addfield('form.edulevel', '<s:text name="edulevel"/>', 'f', true, 3);
		addfield('form.nativehome', '<s:text name="nativehome"/>', 'c', true, 20);
		addfield('form.polivisage', '<s:text name="polivisage"/>', 'f', true, 3);
		addfield('form.department', '<s:text name="department"/>', 'c', true, 18);
		addfield('form.servoffice', '<s:text name="servoffice"/>', 'c', true, 18);
		addfield('form.station', '<s:text name="station"/>', 'f', true, 14);
		addfield('form.joblevel', '<s:text name="joblevel"/>', 'f', true, 3);
		addfield('form.intime', '<s:text name="intime"/>', 't', true, 7);
		addfield('form.worktime', '<s:text name="worktime"/>', 'f', true, 3);
		addfield('form.hereworktime', '<s:text name="hereworktime"/>', 'f', true, 3);
		addfield('form.employtype', '<s:text name="employtype"/>', 'f', true, 3);
		addfield('form.company', '<s:text name="company"/>', 'c', true, 50);
		addfield('form.telephone', '<s:text name="telephone"/>', 'c', true, 15);
		addfield('form.officetel', '<s:text name="officetel"/>', 'c', true, 12);
		addfield('form.outtime', '<s:text name="outtime"/>', 't', true, 7);
		addfield('form.outresult', '<s:text name="outresult"/>', 'c', true, 255);
		addfield('form.homeaddr', '<s:text name="homeaddr"/>', 'c', true, 255);
		addfield('form.cardid', '<s:text name="cardid"/>', 'c', true, 18);
		addfield('form.wayid', '<s:text name="wayid"/>', 'c', true, 18);
		addfield('form.waytype', '<s:text name="waytype"/>', 'c', true, 4);
		addfield('form.pvtemail', '<s:text name="pvtemail"/>', 'c', true, 128);
		addfield('form.ofcphone', '<s:text name="ofcphone"/>', 'c', true, 64);
		addfield('form.ofcemail', '<s:text name="ofcemail"/>', 'c', true, 128);
		addfield('form.speciality', '<s:text name="speciality"/>', 'c', true, 16);
		addfield('form.cityid', '<s:text name="cityid"/>', 'c', true, 14);
		addfield('form.countyid', '<s:text name="countyid"/>', 'c', true, 14);
		addfield('form.svccode', '<s:text name="svccode"/>', 'c', true, 14);
		addfield('form.posittype', '<s:text name="posittype"/>', 'c', true, 16);
		addfield('form.contacttype', '<s:text name="contacttype"/>', 'f', true, 2);
		addfield('form.empstatus', '<s:text name="empstatus"/>', 'f', true, 2);
		addfield('form.actbank', '<s:text name="actbank"/>', 'c', true, 64);
		addfield('form.actno', '<s:text name="actno"/>', 'c', true, 32);
		addfield('form.actname', '<s:text name="actname"/>', 'c', true, 32);
		addfield('form.actpid', '<s:text name="actpid"/>', 'c', true, 20);
		addfield('form.bail', '<s:text name="bail"/>', 'f', true, 12);
		addfield('form.gradschool', '<s:text name="gradschool"/>', 'c', true, 40);
		addfield('form.gradtime', '<s:text name="gradtime"/>', 't', true, 7);
		addfield('form.ismarried', '<s:text name="ismarried"/>', 'f', true, 2);
		addfield('form.outreason', '<s:text name="outreason"/>', 'f', true, 2);
		addfield('form.trainlevel', '<s:text name="trainlevel"/>', 'c', true, 20);
		addfield('form.hobby', '<s:text name="hobby"/>', 'c', true, 255);
		addfield('form.character', '<s:text name="character"/>', 'c', true, 255);
		addfield('form.asses', '<s:text name="asses"/>', 'c', true, 255);
		addfield('form.workhistry', '<s:text name="workhistry"/>', 'c', true, 255);
		addfield('form.prizeorpunish', '<s:text name="prizeorpunish"/>', 'c', true, 255);
		addfield('form.empass', '<s:text name="empass"/>', 'c', true, 20);
		addfield('form.right', '<s:text name="right"/>', 'f', true, 2);
		addfield('form.isnet', '<s:text name="isnet"/>', 'f', true, 2);
		addfield('form.netpass', '<s:text name="netpass"/>', 'c', true, 6);
		addfield('form.isopen', '<s:text name="isopen"/>', 'f', true, 2);
		addfield('form.selectmobile', '<s:text name="selectmobile"/>', 'c', true, 12);
		addfield('form.subname', '<s:text name="subname"/>', 'c', true, 40);
		addfield('form.regdate', '<s:text name="regdate"/>', 't', true, 7);
		addfield('form.empattr', '<s:text name="empattr"/>', 'c', true, 50);
		addfield('form.empattrmemo', '<s:text name="empattrmemo"/>', 'c', true, 512);
		addfield('form.confirmid', '<s:text name="confirmid"/>', 'f', false, 14);
		addfield('form.smsstatus', '<s:text name="smsstatus"/>', 'f', true, 3);
		addfield('form.smscreattime', '<s:text name="smscreattime"/>', 't', true, 7);
		addfield('form.smsconfirmtime', '<s:text name="smsconfirmtime"/>', 't', true, 7);
		return checkval(window);
	}
</script>