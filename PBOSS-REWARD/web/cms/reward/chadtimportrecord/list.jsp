<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%@ page import="com.sunrise.boss.common.base.db.SessionFactoryRouter,com.sunrise.boss.ui.commons.User;"%>
<%
    String ID_1 = "00010701";
    String ID_2 = "00010702";
    String ID_3 = "00010703";
    String ID_4 = "00010704";
    request.setAttribute("cityid", SessionFactoryRouter.conversionCityid(((User)request.getSession().getAttribute("_USER")).getCityid()));
%>
<html>
<head>
    <title><bean:message bundle="chadtimportrecord" key="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_se_wayid', '<bean:message bundle="chadtimportrecord" key="wayid"/>', 'c', 'false', '20');
            addfield('_dnm_oprtime', '<bean:message bundle="chadtimportrecord" key="oprtime"/>', 't', 'false', '7');
            addfield('_dnl_oprtime', '<bean:message bundle="chadtimportrecord" key="oprtime"/>', 't', 'false', '7');
            addfield('_ne_importtype', '<bean:message bundle="chadtimportrecord" key="importtype"/>', 'f', 'false', '22');
            return (checkval(window) && compareDate());
        }
        
	    function compareDate(){
	        var startTime2 = document.getElementById('_dnl_oprtime').value;
	        var endTime2 = document.getElementById('_dnm_oprtime').value;
	
	        if (startTime2 == ''&&endTime2 != '') {
	        	var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[办理结束时间已经填写了,办理起始时间]</span> 不能为空';
	        	errorMessageShow(alertstr);
		        return false;
	        }
	        if (endTime2 == ''&& startTime2 != '') {
	        	var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[办理起始时间已经填写了,办理结束时间]</span> 不能为空';
	        	errorMessageShow(alertstr);
		        return false;
	        }
	        
	        if(startTime2 != '' && endTime2 != '' &&  startTime2>endTime2){
		        var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[办理起始时间]</span> 不能大于 <span style=\'color:#F00; font-size:12px;\'>[办理结束时间]</span>';
				errorMessageShow(alertstr);
		        return false;
	       	}
	   		return true;	
	    }
        
        function doImport(url){
        	formList.action=contextPath + url + "?CMD=IMPORT";
			formList.submit();
		}
		
		function doExport(url){
        	formList.action=contextPath + url + "?CMD=EXPORT";
			formList.submit();
		}
        
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/reward/chadtimportrecord.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/reward/chadtimportrecord/ChadtimportrecordForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="chadtimportrecord" key="titleList"/>
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
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chadtimportrecord" key="wayid"/>:</td>
                <td width="30%" class="form_table_left">
                   <!--    <html:text styleClass="form_input_1x" property="_se_wayid"></html:text>  -->
                	<html:text styleClass="form_input_1x" property="_se_wayid"></html:text>
                    <input type="button" value="..." class="clickbutton" onclick="showSelectWay3(this,'_se_wayid','','','AG');this.value='...';" />
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chadtimportrecord" key="importtype"/>:</td>
                <td width="30%" class="form_table_left">
                    <!-- <html:text styleClass="form_input_1x" property="_ne_importtype"></html:text>  -->
                    <html:select property="_ne_importtype">
                    	<option value=""></option>
<%--                    	<s:Options definition="$CH_CREDIT_ACCOUNT" />--%>
							<s:Options definition="#CH_TYPEINFO" condition="facetype:2;cityid:${cityid}"/>
                    </html:select>
                </td>
            </tr>
            <tr>
                <td width="20%" height="20" align="right" class="form_table_right" >办理起始时间:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnl_oprtime" onclick="selectDate();" ></html:text>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" >办理结束时间:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnm_oprtime" onclick="selectDate();" ></html:text>
                </td>
            </tr>
            
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                        	<input type="button" class="query" onmouseover="buttonover(this);" onclick="doQuery();"
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_search"/>" />
                                
                            <input type="button" class="button_4" onmouseover="buttonover(this);" onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                              	value="<bean:message bundle="costcard" key="buttonBatch"/>" 
                                onclick="doImport('/cms/reward/chadtimportrecord.do')"/>
                            <input type="button" value="批量删除" 
								class="button_4" onclick="doExport('/cms/reward/chadtimportrecord.do')" onmouseover="buttonover(this)"
								onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)">
                        	<input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/reward/chadtimportrecord.do')">
                </td>
			</tr>
		</table>
	</div>

    <div class="table_div">
      <div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
               <td title="<bean:message bundle="public" key="list_title_select"/>">
                    <input type="checkbox" name="allbox" onclick="checkAll();" class="table_checkbox">
                </td>
                <td>
                    <a href="javascript:doOrderby('seq')"><bean:message bundle="chadtimportrecord" key="seq"/></a>
                    <s:OrderImg form="/cms/reward/chadtimportrecord/ChadtimportrecordForm" field="seq"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('wayid')"><bean:message bundle="chadtimportrecord" key="wayid"/></a>
                    <s:OrderImg form="/cms/reward/chadtimportrecord/ChadtimportrecordForm" field="wayid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('mobile')"><bean:message bundle="chadtimportrecord" key="mobile"/></a>
                    <s:OrderImg form="/cms/reward/chadtimportrecord/ChadtimportrecordForm" field="mobile"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('opnid')"><bean:message bundle="chadtimportrecord" key="opnid"/></a>
                    <s:OrderImg form="/cms/reward/chadtimportrecord/ChadtimportrecordForm" field="opnid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('oprtime')"><bean:message bundle="chadtimportrecord" key="oprtime"/></a>
                    <s:OrderImg form="/cms/reward/chadtimportrecord/ChadtimportrecordForm" field="oprtime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('importtype')"><bean:message bundle="chadtimportrecord" key="importtype"/></a>
                    <s:OrderImg form="/cms/reward/chadtimportrecord/ChadtimportrecordForm" field="importtype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('runtime')"><bean:message bundle="chadtimportrecord" key="runtime"/></a>
                    <s:OrderImg form="/cms/reward/chadtimportrecord/ChadtimportrecordForm" field="runtime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('opercode')"><bean:message bundle="chadtimportrecord" key="opercode"/></a>
                    <s:OrderImg form="/cms/reward/chadtimportrecord/ChadtimportrecordForm" field="opercode"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('assegrade')"><bean:message bundle="chadtimportrecord" key="assegrade"/></a>
                    <s:OrderImg form="/cms/reward/chadtimportrecord/ChadtimportrecordForm" field="assegrade"/>
                </td>
                <td>
					 办理金额
                </td>
                <td>
                    <bean:message bundle="chadtimportrecord" key="remark"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/reward/chadtimportrecord.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.seq}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.seq}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td>
                         <c:out value="${item.seq}"/>
                     </td>
                     <td><c:out value="${item.wayid}"/></td>
                     <td><c:out value="${item.mobile}"/></td>
                     <td>
                     <c:out value="${item.opnname}"/>
<%--                     <s:Code2Name code="${item.opnid}" definition="#OPERATION" />--%>
                     </td>
                     <td>
                     <fmt:formatDate pattern="yyyy-MM-dd" value="${item.oprtime}"/>
                     </td>
                     <td>
<%--                 	 <s:Code2Name code="${item.importtype}" definition="#CH_TYPEINFO" />--%>
					 <c:out value="${item.typename}"/>
                     </td>
                     <td>
                     <fmt:formatDate pattern="yyyy-MM-dd" value="${item.runtime}"/>
                     </td>
                     <td><c:out value="${item.opercode}"/></td>
                     <td><fmt:formatNumber pattern="0.0000" value="${item.assegrade}" /></td>
                     <td>
                     <fmt:formatNumber pattern="0.00" value="${item.amt}" />
                     </td>
                     <td><c:out value="${item.remark}"/></td>
                 </tr>
             </c:forEach>
        </table>
     </div>
   </div>

   <div class="table_div">
		<s:PageNav dpName="LIST"/>
   </div>
</html:form>
</div>
</body>
</html>
                     