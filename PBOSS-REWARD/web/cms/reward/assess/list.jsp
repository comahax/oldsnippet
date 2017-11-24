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
    <title><bean:message bundle="assess" key="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
        
        	var form=document.forms[0];
        	var time1=form.all['_se_calcmonth'].value;
        	if(time1.length>0&&!isDateYYYYMM(time1)){
        	alert("请输入正确的日期格式:YYYYMM");
        	return false;
        	}
        	
            addfield('_se_wayid', '<bean:message bundle="assess" key="wayid"/>', 'c', 'false', '20');
            addfield('_ne_assesstype', '<bean:message bundle="assess" key="assesstype"/>', 'f', 'false', '22');
            addfield('_ne_value', '<bean:message bundle="assess" key="value"/>', 'f', 'false', '10');
            addfield('_se_opercode', '<bean:message bundle="assess" key="opercode"/>', 'c', 'false', '20');
            addfield('_se_opertype', '<bean:message bundle="assess" key="opertype"/>', 'c', 'false', '1');
            addfield('_dnm_oprtime', '<bean:message bundle="assess" key="oprtime"/>', 't', 'false', '7');
            addfield('_dnl_oprtime', '<bean:message bundle="assess" key="oprtime"/>', 't', 'false', '7');
            addfield('_se_calcmonth', '<bean:message bundle="assess" key="calcmonth"/>', 'c', 'false', '6');
            return checkval(window);
        }
        
        function doImport(url){
        	formList.action=contextPath + url + "?CMD=IMPORT";
			formList.submit();
		}
        
        function isDateYYYYMM(str) {
		var reg = /^(\d{1,4})(\d{1,2})/;
		var r = str.match(reg);
		if (r == null) {
		return false;
		} else {
		var d = new Date(r[1], r[2] - 1);
		if (d.getFullYear() == r[1] && (d.getMonth() + 1) == r[2]) {
			return true;
		} else {
			return false;
		}
		}
		}
        
        function doReturnList(){
    		window.location.href="<%=contextPath%>/cms/reward/credittotal/list.jsp";
    	}	
        
        
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/reward/assess.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/reward/assess/AssessForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="assess" key="titleList"/>
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
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="assess" key="wayid"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_wayid"></html:text>
                    <input type="button" value="..." class="clickbutton" onclick="showSelectWay3(this,'_se_wayid','','','AG');this.value='...';" />
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="assess" key="assesstype"/>:</td>
                <td width="30%" class="form_table_left">
                    <!--    <html:text styleClass="form_input_1x" property="_ne_assesstype"></html:text> -->
                    <html:select property="_ne_assesstype">
                    	<option value=""></option>
<%--                    		<s:Options definition="#CH_TYPEINFO" condition="facetype:1;cityid:${sessionScope._USER.cityid}"/>--%>
                    		<s:Options definition="#CH_TYPEINFO" condition="facetype:1;cityid:${cityid}"/>
<%--						 <c:forEach var="item1" items="${requestScope.dpselected.datas}">--%>
<%--	                     	<option value="<c:out value="${item1.type}"/>"><c:out value="${item1.typename}"/></option>--%>
<%--                         </c:forEach>--%>
                    </html:select>
                </td>
            </tr>
            <tr>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="assess" key="value"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_ne_value"></html:text>
                </td>
                <!-- 
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="assess" key="opercode"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_opercode"></html:text>
                </td>
                 -->
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="assess" key="opertype"/>:</td>
                <td width="30%" class="form_table_left">
                    <!-- <html:text styleClass="form_input_1x" property="_se_opertype"></html:text>  -->
                    <html:select property="_se_opertype">
                    	<option value=""></option>
                    	<s:Options definition="$Oprtype" />
                    </html:select>
                </td>
            </tr>
            <!-- 
            <tr>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="assess" key="oprtime"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnm_oprtime"></html:text>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="assess" key="oprtime"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnl_oprtime"></html:text>
                </td>
            </tr>
             -->
            <tr>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="assess" key="calcmonth"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_calcmonth"  onclick="this.value=selectDateYYYYMM(this.value);" maxlength="6" ></html:text>
                </td>
    			<td width="20%" height="20" align="right" class="form_table_right" >
                	&nbsp;
            	</td>
            	<td width="30%" class="form_table_left">
               	 &nbsp;
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
                        <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/reward/assess.do')">
                       <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/reward/assess.do')">
                        <input type="button" class="button_4" onmouseover="buttonover(this);" onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                              	value="<bean:message bundle="costcard" key="buttonBatch"/>" 
                                onclick="doImport('/cms/reward/assess.do')"/>
                        <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           		name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           		value="<bean:message bundle="public" key="button_return"/>" class="button_4"
                           		onclick="doReturnList()">
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
                    <a href="javascript:doOrderby('seq')"><bean:message bundle="assess" key="seq"/></a>
                    <s:OrderImg form="/cms/reward/assess/AssessForm" field="seq"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('wayid')"><bean:message bundle="assess" key="wayid"/></a>
                    <s:OrderImg form="/cms/reward/assess/AssessForm" field="wayid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('assesstype')"><bean:message bundle="assess" key="assesstype"/></a>
                    <s:OrderImg form="/cms/reward/assess/AssessForm" field="assesstype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('value')"><bean:message bundle="assess" key="value"/></a>
                    <s:OrderImg form="/cms/reward/assess/AssessForm" field="value"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('remark')"><bean:message bundle="assess" key="remark"/></a>
                    <s:OrderImg form="/cms/reward/assess/AssessForm" field="remark"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('opercode')"><bean:message bundle="assess" key="opercode"/></a>
                    <s:OrderImg form="/cms/reward/assess/AssessForm" field="opercode"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('opertype')"><bean:message bundle="assess" key="opertype"/></a>
                    <s:OrderImg form="/cms/reward/assess/AssessForm" field="opertype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('oprtime')"><bean:message bundle="assess" key="oprtime"/></a>
                    <s:OrderImg form="/cms/reward/assess/AssessForm" field="oprtime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('calcmonth')"><bean:message bundle="assess" key="calcmonth"/></a>
                    <s:OrderImg form="/cms/reward/assess/AssessForm" field="calcmonth"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/reward/assess.do?CMD=EDIT" var="urlContent">
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
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.seq}"/></a>
                     </td>
                     <td><c:out value="${item.wayid}"/></td>
                     <td>
<%--                     <s:Code2Name code="${item.assesstype}" definition="#CH_TYPEINFO" />--%>
					 <c:out value="${item.assesstypename}"/>
                     </td>
                     <td><c:out value="${item.value}"/></td>
                     <td><c:out value="${item.remark}"/></td>
                     <td><c:out value="${item.opercode}"/></td>
                     <td>
                     <s:Code2Name code="${item.opertype}" definition="$Oprtype" />
                     </td>
                     <td>
                     <fmt:formatDate pattern="yyyy-MM-dd" value="${item.oprtime}"/>
                     </td>
                     <td><c:out value="${item.calcmonth}"/></td>
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
