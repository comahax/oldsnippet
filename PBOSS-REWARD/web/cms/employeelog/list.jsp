<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A6FBT9" />
</jsp:include>
<html>
<head>
    <title><bean:message bundle="employeelog" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
      
            return checkval(window);
        }
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/employeelog.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="employeelog" key="titleList"/>
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
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="employeelog" key="optime"/>&gt;=:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnl_optime" onclick="this.value=selectDatetime();" readonly="true"/>
                </td>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="employeelog" key="optime"/>&lt;=:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnm_optime" onclick="this.value=selectDatetime();" readonly="true"/>
                </td>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="employeelog" key="oprcode"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_sk_oprcode"></html:text>
                </td>
            </tr>
            <tr>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="employeelog" key="oprtype"/>:</td>
                <td class="form_table_left">
                     <html:select property="_se_oprtype"> <option></option>	<s:Options  definition="$OPRTYPE"/>  </html:select> 
                </td>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="employeelog" key="success"/>:</td>
                <td class="form_table_left">
                     <html:select property="_se_success">  <option></option>	 <s:Options  definition="$OPRRESULT"/>  </html:select> 
                </td>
    			<td width="80" height="20" align="right" class="form_table_right" >
                	&nbsp;
            	</td>
            	<td class="form_table_left">
               	 &nbsp;
            	</td>
            </tr>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                        <input type="button" class="query"onmouseover="buttonover(this);" onclick="doQuery();" 
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_search"/>" />
                </td>
			</tr>
		</table>
	</div>

    <div class="table_div">
      <div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
                <td>
                    <a href="javascript:doOrderby('logid')"><bean:message bundle="employeelog" key="logid"/></a>
                    <s:OrderImg form="/cms/employeelog/employeelogForm" field="logid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('optime')"><bean:message bundle="employeelog" key="optime"/></a>
                    <s:OrderImg form="/cms/employeelog/employeelogForm" field="optime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('oprcode')"><bean:message bundle="employeelog" key="oprcode"/></a>
                    <s:OrderImg form="/cms/employeelog/employeelogForm" field="oprcode"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('oprtype')"><bean:message bundle="employeelog" key="oprtype"/></a>
                    <s:OrderImg form="/cms/employeelog/employeelogForm" field="oprtype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('success')"><bean:message bundle="employeelog" key="success"/></a>
                    <s:OrderImg form="/cms/employeelog/employeelogForm" field="success"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('employeeid')"><bean:message bundle="employeelog" key="employeeid"/></a>
                    <s:OrderImg form="/cms/employeelog/employeelogForm" field="employeeid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('oprcode2')"><bean:message bundle="employeelog" key="oprcode2"/></a>
                    <s:OrderImg form="/cms/employeelog/employeelogForm" field="oprcode2"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('employeename')"><bean:message bundle="employeelog" key="employeename"/></a>
                    <s:OrderImg form="/cms/employeelog/employeelogForm" field="employeename"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('birthday')"><bean:message bundle="employeelog" key="birthday"/></a>
                    <s:OrderImg form="/cms/employeelog/employeelogForm" field="birthday"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('sex')"><bean:message bundle="employeelog" key="sex"/></a>
                    <s:OrderImg form="/cms/employeelog/employeelogForm" field="sex"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('edulevel')"><bean:message bundle="employeelog" key="edulevel"/></a>
                    <s:OrderImg form="/cms/employeelog/employeelogForm" field="edulevel"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('nativehome')"><bean:message bundle="employeelog" key="nativehome"/></a>
                    <s:OrderImg form="/cms/employeelog/employeelogForm" field="nativehome"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('polivisage')"><bean:message bundle="employeelog" key="polivisage"/></a>
                    <s:OrderImg form="/cms/employeelog/employeelogForm" field="polivisage"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('department')"><bean:message bundle="employeelog" key="department"/></a>
                    <s:OrderImg form="/cms/employeelog/employeelogForm" field="department"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('servoffice')"><bean:message bundle="employeelog" key="servoffice"/></a>
                    <s:OrderImg form="/cms/employeelog/employeelogForm" field="servoffice"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('station')"><bean:message bundle="employeelog" key="station"/></a>
                    <s:OrderImg form="/cms/employeelog/employeelogForm" field="station"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('joblevel')"><bean:message bundle="employeelog" key="joblevel"/></a>
                    <s:OrderImg form="/cms/employeelog/employeelogForm" field="joblevel"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('intime')"><bean:message bundle="employeelog" key="intime"/></a>
                    <s:OrderImg form="/cms/employeelog/employeelogForm" field="intime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('worktime')"><bean:message bundle="employeelog" key="worktime"/></a>
                    <s:OrderImg form="/cms/employeelog/employeelogForm" field="worktime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('hereworktime')"><bean:message bundle="employeelog" key="hereworktime"/></a>
                    <s:OrderImg form="/cms/employeelog/employeelogForm" field="hereworktime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('employtype')"><bean:message bundle="employeelog" key="employtype"/></a>
                    <s:OrderImg form="/cms/employeelog/employeelogForm" field="employtype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('company')"><bean:message bundle="employeelog" key="company"/></a>
                    <s:OrderImg form="/cms/employeelog/employeelogForm" field="company"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('telephone')"><bean:message bundle="employeelog" key="telephone"/></a>
                    <s:OrderImg form="/cms/employeelog/employeelogForm" field="telephone"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('officetel')"><bean:message bundle="employeelog" key="officetel"/></a>
                    <s:OrderImg form="/cms/employeelog/employeelogForm" field="officetel"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('outtime')"><bean:message bundle="employeelog" key="outtime"/></a>
                    <s:OrderImg form="/cms/employeelog/employeelogForm" field="outtime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('outresult')"><bean:message bundle="employeelog" key="outresult"/></a>
                    <s:OrderImg form="/cms/employeelog/employeelogForm" field="outresult"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('homeaddr')"><bean:message bundle="employeelog" key="homeaddr"/></a>
                    <s:OrderImg form="/cms/employeelog/employeelogForm" field="homeaddr"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('cardid')"><bean:message bundle="employeelog" key="cardid"/></a>
                    <s:OrderImg form="/cms/employeelog/employeelogForm" field="cardid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('wayid')"><bean:message bundle="employeelog" key="wayid"/></a>
                    <s:OrderImg form="/cms/employeelog/employeelogForm" field="wayid"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/employeelog.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.logid}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <c:out value="${item.logid}"/>
                     </td>
                     <td> <fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.optime}"/> </td>
                     <td><c:out value="${item.oprcode}"/></td>
                     <td> <s:Code2Name code="${item.oprtype}" definition="$OPRTYPE"/> </td>
                     <td> <s:Code2Name code="${item.success}" definition="$OPRRESULT"/> </td>
                     <td><c:out value="${item.employeeid}"/></td>
                     <td><c:out value="${item.oprcode2}"/></td>
                     <td><c:out value="${item.employeename}"/></td>
                     <td><c:out value="${item.birthday}"/></td>
                     <td><s:Code2Name code="${item.sex}"  definition="$CH_SEX"/></td>
                     <td><c:out value="${item.edulevel}"/></td>
                     <td><s:Code2Name code="${item.nativehome}"  definition="$CH_NATIVE"/></td>
                     <td><s:Code2Name code="${item.polivisage}"  definition="$CH_POLIVISAGE"/></td>
                     <td><c:out value="${item.department}"/></td>
                     <td><c:out value="${item.servoffice}"/></td>
                     <td><s:Code2Name code="${item.station}"  definition="#CH_POSTINFO"/></td>
                     <td><c:out value="${item.joblevel}"/></td>
                     <td><c:out value="${item.intime}"/></td>
                     <td><c:out value="${item.worktime}"/></td>
                     <td><c:out value="${item.hereworktime}"/></td>
                     <td><c:out value="${item.employtype}"/></td>
                     <td><c:out value="${item.company}"/></td>
                     <td><c:out value="${item.telephone}"/></td>
                     <td><c:out value="${item.officetel}"/></td>
                     <td><c:out value="${item.outtime}"/></td>
                     <td><c:out value="${item.outresult}"/></td>
                     <td><c:out value="${item.homeaddr}"/></td>
                     <td><c:out value="${item.cardid}"/></td>
                     <td><s:Code2Name code="${item.wayid}"  definition="#WAY"/></td>                     
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
