<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A6FBT4" />
</jsp:include>
<html>
<head>
    <title><bean:message bundle="cntycomlog" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
         
            return checkval(window);
        }
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/cntycomlog.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">

    <!--##################################��ӱ�������##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="cntycomlog" key="titleList"/>
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
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="cntycomlog" key="optime"/>&gt;=:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnl_optime" onclick="this.value=selectDatetime();" readonly="true"/>
                </td>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="cntycomlog" key="optime"/>&lt;=:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnm_optime" onclick="this.value=selectDatetime();" readonly="true"/>
                </td>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="cntycomlog" key="oprcode"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_sk_oprcode"></html:text>
                </td>
            </tr>
            <tr>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="cntycomlog" key="oprtype"/>:</td>
                <td class="form_table_left">
                     <html:select property="_se_oprtype"> <option></option>	<s:Options  definition="$OPRTYPE"/>  </html:select> 
                </td>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="cntycomlog" key="success"/>:</td>
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
                    <a href="javascript:doOrderby('logid')"><bean:message bundle="cntycomlog" key="logid"/></a>
                    <s:OrderImg form="/cms/cntycomlog/cntycomlogForm" field="logid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('optime')"><bean:message bundle="cntycomlog" key="optime"/></a>
                    <s:OrderImg form="/cms/cntycomlog/cntycomlogForm" field="optime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('oprcode')"><bean:message bundle="cntycomlog" key="oprcode"/></a>
                    <s:OrderImg form="/cms/cntycomlog/cntycomlogForm" field="oprcode"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('oprtype')"><bean:message bundle="cntycomlog" key="oprtype"/></a>
                    <s:OrderImg form="/cms/cntycomlog/cntycomlogForm" field="oprtype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('success')"><bean:message bundle="cntycomlog" key="success"/></a>
                    <s:OrderImg form="/cms/cntycomlog/cntycomlogForm" field="success"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('countycompid')"><bean:message bundle="cntycomlog" key="countycompid"/></a>
                    <s:OrderImg form="/cms/cntycomlog/cntycomlogForm" field="countycompid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('citycompid')"><bean:message bundle="cntycomlog" key="citycompid"/></a>
                    <s:OrderImg form="/cms/cntycomlog/cntycomlogForm" field="citycompid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('countycompname')"><bean:message bundle="cntycomlog" key="countycompname"/></a>
                    <s:OrderImg form="/cms/cntycomlog/cntycomlogForm" field="countycompname"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('countycomptype')"><bean:message bundle="cntycomlog" key="countycomptype"/></a>
                    <s:OrderImg form="/cms/cntycomlog/cntycomlogForm" field="countycomptype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('agent')"><bean:message bundle="cntycomlog" key="agent"/></a>
                    <s:OrderImg form="/cms/cntycomlog/cntycomlogForm" field="agent"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('billingcode')"><bean:message bundle="cntycomlog" key="billingcode"/></a>
                    <s:OrderImg form="/cms/cntycomlog/cntycomlogForm" field="billingcode"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('adacode')"><bean:message bundle="cntycomlog" key="adacode"/></a>
                    <s:OrderImg form="/cms/cntycomlog/cntycomlogForm" field="adacode"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('longitude')"><bean:message bundle="cntycomlog" key="longitude"/></a>
                    <s:OrderImg form="/cms/cntycomlog/cntycomlogForm" field="longitude"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('latitude')"><bean:message bundle="cntycomlog" key="latitude"/></a>
                    <s:OrderImg form="/cms/cntycomlog/cntycomlogForm" field="latitude"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/cntycomlog.do?CMD=EDIT" var="urlContent">
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
                     <td><c:out value="${item.countycompid}"/></td>
                     <td><s:Code2Name code="${item.citycompid}"  definition="#CITYCOMPANY"/></td>
                     <td><c:out value="${item.countycompname}"/></td>
                     <td><s:Code2Name code="${item.countycomptype}"  definition="$CH_COUNTYCOMPTYPE"/></td>
                     <td><c:out value="${item.agent}"/></td>
                     <td><c:out value="${item.billingcode}"/></td>
                     <td><c:out value="${item.adacode}"/></td>
                     <td><c:out value="${item.longitude}"/></td>
                     <td><c:out value="${item.latitude}"/></td>
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
