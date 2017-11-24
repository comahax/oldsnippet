<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%
    String ID_1 = "00010701";
    String ID_2 = "00010702";
    String ID_3 = "00010703";
    String ID_4 = "00010704";
%>
<html>
<head>
    <title><bean:message bundle="waysnpt" key="titleUpdate"/></title>
    <script language="JavaScript">
        function ev_checkval() {
            addfield('calcmonth', '<bean:message bundle="waysnpt" key="calcmonth"/>', 'c', false, '6');
            addfield('wayid', '<bean:message bundle="waysnpt" key="wayid"/>', 'c', false, '18');
            addfield('starlevel', '<bean:message bundle="waysnpt" key="starlevel"/>', 'f', false, '2');
            addfield('wayname', '<bean:message bundle="waysnpt" key="wayname"/>', 'c', false, '256');
            addfield('waytype', '<bean:message bundle="waysnpt" key="waytype"/>', 'c', false, '4');
            addfield('waysubtype', '<bean:message bundle="waysnpt" key="waysubtype"/>', 'c', false, '4');
            addfield('custtype', '<bean:message bundle="waysnpt" key="custtype"/>', 'c', false, '4');
            addfield('upperwayid', '<bean:message bundle="waysnpt" key="upperwayid"/>', 'c', false, '18');
            addfield('busicode', '<bean:message bundle="waysnpt" key="busicode"/>', 'c', false, '10');
            addfield('countyid', '<bean:message bundle="waysnpt" key="countyid"/>', 'c', false, '14');
            addfield('cityid', '<bean:message bundle="waysnpt" key="cityid"/>', 'c', false, '14');
            addfield('centerid', '<bean:message bundle="waysnpt" key="centerid"/>', 'c', false, '14');
            addfield('citylevel', '<bean:message bundle="waysnpt" key="citylevel"/>', 'f', false, '3');
            addfield('waylevel', '<bean:message bundle="waysnpt" key="waylevel"/>', 'f', false, '3');
            addfield('bchlevel', '<bean:message bundle="waysnpt" key="bchlevel"/>', 'c', false, '4');
            addfield('function', '<bean:message bundle="waysnpt" key="function"/>', 'c', false, '255');
            addfield('runbyself', '<bean:message bundle="waysnpt" key="runbyself"/>', 'c', false, '4');
            addfield('depotdet', '<bean:message bundle="waysnpt" key="depotdet"/>', 'c', false, '20');
            addfield('shortname', '<bean:message bundle="waysnpt" key="shortname"/>', 'c', false, '64');
            addfield('svbrchcode', '<bean:message bundle="waysnpt" key="svbrchcode"/>', 'c', false, '14');
            addfield('svccode', '<bean:message bundle="waysnpt" key="svccode"/>', 'c', false, '14');
            addfield('mareacode', '<bean:message bundle="waysnpt" key="mareacode"/>', 'c', false, '14');
            addfield('buztypecode', '<bean:message bundle="waysnpt" key="buztypecode"/>', 'f', false, '2');
            addfield('adtypecode', '<bean:message bundle="waysnpt" key="adtypecode"/>', 'f', false, '2');
            addfield('logiscode', '<bean:message bundle="waysnpt" key="logiscode"/>', 'c', false, '18');
            addfield('latitude', '<bean:message bundle="waysnpt" key="latitude"/>', 'c', false, '15');
            addfield('longtitude', '<bean:message bundle="waysnpt" key="longtitude"/>', 'c', false, '15');
            addfield('adacode', '<bean:message bundle="waysnpt" key="adacode"/>', 'c', false, '18');
            addfield('waymagcode', '<bean:message bundle="waysnpt" key="waymagcode"/>', 'c', false, '18');
            addfield('catetype', '<bean:message bundle="waysnpt" key="catetype"/>', 'f', false, '2');
            addfield('formtype', '<bean:message bundle="waysnpt" key="formtype"/>', 'f', false, '2');
            addfield('mainlayer', '<bean:message bundle="waysnpt" key="mainlayer"/>', 'f', false, '2');
            addfield('sublayer', '<bean:message bundle="waysnpt" key="sublayer"/>', 'f', false, '2');
            addfield('buzphoneno', '<bean:message bundle="waysnpt" key="buzphoneno"/>', 'c', false, '14');
            addfield('cooperator', '<bean:message bundle="waysnpt" key="cooperator"/>', 'f', false, '2');
            addfield('alarmbizamount', '<bean:message bundle="waysnpt" key="alarmbizamount"/>', 'f', false, '10');
            addfield('prtsource', '<bean:message bundle="waysnpt" key="prtsource"/>', 'f', false, '2');
            addfield('isconnected', '<bean:message bundle="waysnpt" key="isconnected"/>', 'f', false, '2');
            addfield('connecttype', '<bean:message bundle="waysnpt" key="connecttype"/>', 'f', false, '2');
            addfield('runmode', '<bean:message bundle="waysnpt" key="runmode"/>', 'f', false, '2');
            addfield('iscoreway', '<bean:message bundle="waysnpt" key="iscoreway"/>', 'f', false, '2');
            addfield('pt', '<bean:message bundle="waysnpt" key="pt"/>', 'f', false, '2');
            addfield('chainhead', '<bean:message bundle="waysnpt" key="chainhead"/>', 'c', false, '18');
            addfield('signstatus', '<bean:message bundle="waysnpt" key="signstatus"/>', 'f', false, '2');
            addfield('empnumber', '<bean:message bundle="waysnpt" key="empnumber"/>', 'f', false, '4');
            addfield('magnumber', '<bean:message bundle="waysnpt" key="magnumber"/>', 'f', false, '4');
            addfield('terminumber', '<bean:message bundle="waysnpt" key="terminumber"/>', 'f', false, '4');
            addfield('taxtype', '<bean:message bundle="waysnpt" key="taxtype"/>', 'f', false, '2');
            addfield('updatedate', '<bean:message bundle="waysnpt" key="updatedate"/>', 't', false, '7');
            addfield('isstraitprd', '<bean:message bundle="waysnpt" key="isstraitprd"/>', 'f', false, '2');
            addfield('createtime', '<bean:message bundle="waysnpt" key="createtime"/>', 't', false, '7');
            addfield('disabletime', '<bean:message bundle="waysnpt" key="disabletime"/>', 't', false, '7');
            addfield('starttime', '<bean:message bundle="waysnpt" key="starttime"/>', 't', false, '7');
            addfield('waystate', '<bean:message bundle="waysnpt" key="waystate"/>', 'f', false, '3');
            addfield('isshare', '<bean:message bundle="waysnpt" key="isshare"/>', 'c', false, '32');
            addfield('address', '<bean:message bundle="waysnpt" key="address"/>', 'c', false, '128');
            addfield('miscode', '<bean:message bundle="waysnpt" key="miscode"/>', 'c', false, '12');
            addfield('buzarea', '<bean:message bundle="waysnpt" key="buzarea"/>', 'f', false, '5');

            return checkval(window);
        }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/reward/waysnpt.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    <c:set var="form" scope="request" value="${requestScope['/cms/reward/waysnpt/WaysnptForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="waysnpt" key="titleList"/>
   			</td>
    	</tr>
    </table>
    </div>
    <div class="table_div">	
   		 <table width="100%" class="error_text">
    		<html:errors/><s:Msg />
    	</table>
    </div>

    <div class="table_div">
        <table class="form_table">
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waysnpt" key="calcmonth"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                            <html:text styleClass="form_input_1x" property="calcmonth" readonly="true"/>
                        </c:if>
                        <c:if test="${!updateState}">
                            <html:text styleClass="form_input_1x" property="calcmonth" />
                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="calcmonth" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waysnpt" key="wayid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                        <c:if test="${updateState}">
                            <html:text styleClass="form_input_1x" property="wayid" readonly="true"/>
                        </c:if>
                        <c:if test="${!updateState}">
                            <html:text styleClass="form_input_1x" property="wayid" />
                        </c:if>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="wayid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waysnpt" key="starlevel"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="starlevel" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="starlevel" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waysnpt" key="wayname"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="wayname" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="wayname" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waysnpt" key="waytype"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="waytype" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="waytype" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waysnpt" key="waysubtype"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="waysubtype" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="waysubtype" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waysnpt" key="custtype"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="custtype" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="custtype" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waysnpt" key="upperwayid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="upperwayid" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="upperwayid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waysnpt" key="busicode"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="busicode" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="busicode" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waysnpt" key="countyid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="countyid" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="countyid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waysnpt" key="cityid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="cityid" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="cityid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waysnpt" key="centerid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="centerid" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="centerid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waysnpt" key="citylevel"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="citylevel" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="citylevel" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waysnpt" key="waylevel"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="waylevel" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="waylevel" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waysnpt" key="bchlevel"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="bchlevel" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="bchlevel" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waysnpt" key="function"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="function" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="function" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waysnpt" key="runbyself"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="runbyself" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="runbyself" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waysnpt" key="depotdet"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="depotdet" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="depotdet" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waysnpt" key="shortname"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="shortname" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="shortname" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waysnpt" key="svbrchcode"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="svbrchcode" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="svbrchcode" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waysnpt" key="svccode"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="svccode" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="svccode" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waysnpt" key="mareacode"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="mareacode" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="mareacode" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waysnpt" key="buztypecode"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="buztypecode" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="buztypecode" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waysnpt" key="adtypecode"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="adtypecode" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="adtypecode" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waysnpt" key="logiscode"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="logiscode" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="logiscode" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waysnpt" key="latitude"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="latitude" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="latitude" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waysnpt" key="longtitude"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="longtitude" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="longtitude" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waysnpt" key="adacode"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="adacode" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="adacode" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waysnpt" key="waymagcode"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="waymagcode" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="waymagcode" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waysnpt" key="catetype"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="catetype" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="catetype" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waysnpt" key="formtype"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="formtype" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="formtype" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waysnpt" key="mainlayer"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="mainlayer" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="mainlayer" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waysnpt" key="sublayer"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="sublayer" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="sublayer" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waysnpt" key="buzphoneno"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="buzphoneno" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="buzphoneno" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waysnpt" key="cooperator"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="cooperator" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="cooperator" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waysnpt" key="alarmbizamount"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="alarmbizamount" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="alarmbizamount" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waysnpt" key="prtsource"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="prtsource" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="prtsource" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waysnpt" key="isconnected"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="isconnected" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="isconnected" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waysnpt" key="connecttype"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="connecttype" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="connecttype" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waysnpt" key="runmode"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="runmode" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="runmode" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waysnpt" key="iscoreway"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="iscoreway" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="iscoreway" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waysnpt" key="pt"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="pt" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="pt" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waysnpt" key="chainhead"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="chainhead" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="chainhead" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waysnpt" key="signstatus"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="signstatus" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="signstatus" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waysnpt" key="empnumber"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="empnumber" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="empnumber" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waysnpt" key="magnumber"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="magnumber" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="magnumber" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waysnpt" key="terminumber"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="terminumber" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="terminumber" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waysnpt" key="taxtype"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="taxtype" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="taxtype" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waysnpt" key="updatedate"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="updatedate" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="updatedate" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waysnpt" key="isstraitprd"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="isstraitprd" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="isstraitprd" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waysnpt" key="createtime"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="createtime" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="createtime" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waysnpt" key="disabletime"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="disabletime" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="disabletime" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waysnpt" key="starttime"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="starttime" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="starttime" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waysnpt" key="waystate"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="waystate" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="waystate" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waysnpt" key="isshare"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="isshare" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="isshare" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waysnpt" key="address"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="address" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="address" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waysnpt" key="miscode"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="miscode" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="miscode" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="waysnpt" key="buzarea"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="buzarea" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="buzarea" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </table>
    </div>

    <div class="table_div">
        <table class="table_button_list">
            <tr>
                <td width="100%" class="form_table_center">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_save"/>" class="submit"
                           onclick="doSave('/cms/reward/waysnpt.do?CMD=SAVE')"/>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnPrint" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_print"/>" class="print" onclick="doPrint()">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/reward/waysnpt.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form>
</div>
</body>
</html>
