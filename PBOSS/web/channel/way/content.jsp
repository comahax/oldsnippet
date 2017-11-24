<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<html>
<head>
    <title><s:text name="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('form.wayid', '<s:text name="wayid"/>', 'c', false, 18);
			addfield('form.shortname', '<s:text name="shortname"/>', 'c', true, 32);
			addfield('form.svbrchcode', '<s:text name="svbrchcode"/>', 'c', true, 14);
			addfield('form.svccode', '<s:text name="svccode"/>', 'c', true, 14);
			addfield('form.mareacode', '<s:text name="mareacode"/>', 'c', true, 14);
			addfield('form.buztypecode', '<s:text name="buztypecode"/>', 'f', true, 2);
			addfield('form.adtypecode', '<s:text name="adtypecode"/>', 'f', true, 2);
			addfield('form.address', '<s:text name="address"/>', 'c', true, 128);
			addfield('form.logiscode', '<s:text name="logiscode"/>', 'c', true, 18);
			addfield('form.latitude', '<s:text name="latitude"/>', 'c', true, 15);
			addfield('form.longtitude', '<s:text name="longtitude"/>', 'c', true, 15);
			addfield('form.adacode', '<s:text name="adacode"/>', 'c', true, 18);
			addfield('form.waymagcode', '<s:text name="waymagcode"/>', 'c', true, 18);
			addfield('form.catetype', '<s:text name="catetype"/>', 'f', true, 2);
			addfield('form.formtype', '<s:text name="formtype"/>', 'f', true, 2);
			addfield('form.starttime', '<s:text name="starttime"/>', 't', true, 13);
			addfield('form.buzarea', '<s:text name="buzarea"/>', 'f', true, 5);
			addfield('form.mainlayer', '<s:text name="mainlayer"/>', 'f', true, 2);
			addfield('form.sublayer', '<s:text name="sublayer"/>', 'f', true, 2);
			addfield('form.buzphoneno', '<s:text name="buzphoneno"/>', 'c', true, 14);
			addfield('form.wayname', '<s:text name="wayname"/>', 'c', true, 256);
			addfield('form.cooperator', '<s:text name="cooperator"/>', 'f', true, 2);
			addfield('form.waytype', '<s:text name="waytype"/>', 'c', true, 4);
			addfield('form.waysubtype', '<s:text name="waysubtype"/>', 'c', true, 4);
			addfield('form.custtype', '<s:text name="custtype"/>', 'c', true, 4);
			addfield('form.upperwayid', '<s:text name="upperwayid"/>', 'c', true, 18);
			addfield('form.busicode', '<s:text name="busicode"/>', 'c', true, 10);
			addfield('form.countyid', '<s:text name="countyid"/>', 'c', true, 14);
			addfield('form.cityid', '<s:text name="cityid"/>', 'c', true, 14);
			addfield('form.centerid', '<s:text name="centerid"/>', 'c', true, 14);
			addfield('form.citylevel', '<s:text name="citylevel"/>', 'f', true, 3);
			addfield('form.waylevel', '<s:text name="waylevel"/>', 'f', true, 3);
			addfield('form.bchlevel', '<s:text name="bchlevel"/>', 'c', true, 4);
			addfield('form.function', '<s:text name="function"/>', 'c', true, 255);
			addfield('form.miscode', '<s:text name="miscode"/>', 'c', true, 12);
			addfield('form.createtime', '<s:text name="createtime"/>', 't', true,13);
			addfield('form.disabletime', '<s:text name="disabletime"/>', 't', true,13);
			addfield('form.waystate', '<s:text name="waystate"/>', 'f', true, 3);
			addfield('form.runbyself', '<s:text name="runbyself"/>', 'c', true, 4);
			addfield('form.depotdet', '<s:text name="depotdet"/>', 'c', true, 20);
			addfield('form.isshare', '<s:text name="isshare"/>', 'c', true, 32);
			addfield('form.alarmbizamount', '<s:text name="alarmbizamount"/>', 'f', true, 10);
			addfield('form.prtsource', '<s:text name="prtsource"/>', 'f', true, 2);
			addfield('form.isconnected', '<s:text name="isconnected"/>', 'f', true, 2);
			addfield('form.connecttype', '<s:text name="connecttype"/>', 'f', true, 2);
			addfield('form.runmode', '<s:text name="runmode"/>', 'f', true, 2);
			addfield('form.iscoreway', '<s:text name="iscoreway"/>', 'f', true, 2);
			addfield('form.starlevel', '<s:text name="starlevel"/>', 'f', true, 2);
			addfield('form.pt', '<s:text name="pt"/>', 'f', true, 2);
			addfield('form.chainhead', '<s:text name="chainhead"/>', 'c', true, 18);
			addfield('form.signstatus', '<s:text name="signstatus"/>', 'f', true, 2);
			addfield('form.empnumber', '<s:text name="empnumber"/>', 'f', true, 4);
			addfield('form.magnumber', '<s:text name="magnumber"/>', 'f', true, 4);
			addfield('form.terminumber', '<s:text name="terminumber"/>', 'f', true, 4);
			addfield('form.updatedate', '<s:text name="updatedate"/>', 't', true,13);
			addfield('form.isstraitprd', '<s:text name="isstraitprd"/>', 'f', true, 2);
			addfield('form.taxtype', '<s:text name="taxtype"/>', 'f', true, 2);
            return checkval(window);
        }
    </script>
</head>
<body>
<s:form action="way_save.do" cssStyle="formList" key="formItem"
			method="post" theme="simple" onsubmit="return ev_checkval();">
			
    <s:hidden name="isNew"/>
    <s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param._se_wayid"/>
    <s:hidden name="param._se_wayname"/>
    <s:hidden name="param._se_waytype"/>
    <s:hidden name="param._ne_waystate"/>
	
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
		</div>
	</div>

	<aa:zone name="errorZone">
		<div class="error_text" >
			<table class="error_text">
				<s:actionerror /><s:actionmessage/>
			</table>
		</div>
	</aa:zone>
	
	<aa:zone name="contentZone">
    <div class="table_div">
        <table class="table_normal">
            <tr>
                <td align="right"><s:text name="wayid"/>:&nbsp</td>
                <td align="left">
			        <s:if test="isNew">
                        <s:textfield cssStyle="style_input" name="form.wayid" maxlength="18"/>
                        <font color=red>*</font>
			        </s:if>
			        <s:else>
						<s:textfield cssStyle="style_input" name="form.wayid" disabled="true"/>
						<font color=red>*</font>
			        </s:else>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="shortname"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.shortname" maxlength="32"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="svbrchcode"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.svbrchcode" maxlength="14"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="svccode"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.svccode" maxlength="14"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="mareacode"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.mareacode" maxlength="14"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="buztypecode"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.buztypecode" maxlength="2"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="adtypecode"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.adtypecode" maxlength="2"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="address"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.address" maxlength="128"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="logiscode"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.logiscode" maxlength="18"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="latitude"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.latitude" maxlength="15"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="longtitude"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.longtitude" maxlength="15"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="adacode"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.adacode" maxlength="18"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="waymagcode"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.waymagcode" maxlength="18"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="catetype"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.catetype" maxlength="2"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="formtype"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.formtype" maxlength="2"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="starttime"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.starttime" maxlength="13"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="buzarea"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.buzarea" maxlength="5"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="mainlayer"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.mainlayer" maxlength="2"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="sublayer"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.sublayer" maxlength="2"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="buzphoneno"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.buzphoneno" maxlength="14"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="wayname"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.wayname" maxlength="256"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="cooperator"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.cooperator" maxlength="2"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="waytype"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.waytype" maxlength="4"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="waysubtype"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.waysubtype" maxlength="4"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="custtype"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.custtype" maxlength="4"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="upperwayid"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.upperwayid" maxlength="18"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="busicode"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.busicode" maxlength="10"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="countyid"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.countyid" maxlength="14"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="cityid"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.cityid" maxlength="14"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="centerid"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.centerid" maxlength="14"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="citylevel"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.citylevel" maxlength="3"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="waylevel"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.waylevel" maxlength="3"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="bchlevel"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.bchlevel" maxlength="4"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="function"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.function" maxlength="255"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="miscode"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.miscode" maxlength="12"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="createtime"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.createtime" maxlength="13"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="disabletime"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.disabletime" maxlength="13"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="waystate"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.waystate" maxlength="3"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="runbyself"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.runbyself" maxlength="4"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="depotdet"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.depotdet" maxlength="20"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="isshare"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.isshare" maxlength="32"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="alarmbizamount"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.alarmbizamount" maxlength="10"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="prtsource"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.prtsource" maxlength="2"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="isconnected"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.isconnected" maxlength="2"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="connecttype"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.connecttype" maxlength="2"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="runmode"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.runmode" maxlength="2"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="iscoreway"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.iscoreway" maxlength="2"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="starlevel"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.starlevel" maxlength="2"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="pt"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.pt" maxlength="2"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="chainhead"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.chainhead" maxlength="18"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="signstatus"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.signstatus" maxlength="2"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="empnumber"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.empnumber" maxlength="4"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="magnumber"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.magnumber" maxlength="4"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="terminumber"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.terminumber" maxlength="4"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="updatedate"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.updatedate" maxlength="13"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="isstraitprd"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.isstraitprd" maxlength="2"/>
                </td>
            </tr>
            <tr>
                <td align="right"><s:text name="taxtype"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.taxtype" maxlength="2"/>
                </td>
            </tr>
        </table>
    </div>
	</aa:zone>

    <div class="table_div">
        <table class="table_button_list">
            <tr>
                <td width="100%" align="center">
                   	<s:i18n name="public">
                    <input type="button" id="btnSave" name="btnSave" class="button_Save" onmouseover="buttonover(this);" 
                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_save"/>" onclick="doSave('/channel/way_save.do')"/>
                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<s:text name="button_return"/>" onclick="doReturn('/channel/way_list.do')">
					</s:i18n>
                </td>
            </tr>
        </table>
    </div>
</s:form>
<script language="javascript"> 
	ajaxAnywhere.getZonesToReload = function(url,submitButton) {
		return "errorZone,listZone";  
	}
	ajaxAnywhere.substituteFormSubmitFunction();ajaxAnywhere.formURL = formList.action;  
	ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnSave");
</script>
</body>
</html>
