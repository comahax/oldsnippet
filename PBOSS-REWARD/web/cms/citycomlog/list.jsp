<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A6FBT3" />
</jsp:include>
<html>
<head>
    <title><bean:message bundle="citycomlog" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
        
            return checkval(window);
        }
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/citycomlog.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
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
    			<bean:message bundle="citycomlog" key="titleList"/>
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
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="citycomlog" key="optime"/>&gt;=:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnl_optime" onclick="this.value=selectDatetime();" readonly="true"/>
                </td>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="citycomlog" key="optime"/>&lt;=:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnm_optime" onclick="this.value=selectDatetime();" readonly="true"/>
                </td>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="citycomlog" key="oprcode"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_sk_oprcode"></html:text>
                </td>
            </tr>
            <tr>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="citycomlog" key="oprtype"/>:</td>
                <td class="form_table_left">
                     <html:select property="_se_oprtype"> <option></option>	<s:Options  definition="$OPRTYPE"/>  </html:select> 
                </td>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="citycomlog" key="success"/>:</td>
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
                    <a href="javascript:doOrderby('logid')"><bean:message bundle="citycomlog" key="logid"/></a>
                    <s:OrderImg form="/cms/citycomlog/citycomlogForm" field="logid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('optime')"><bean:message bundle="citycomlog" key="optime"/></a>
                    <s:OrderImg form="/cms/citycomlog/citycomlogForm" field="optime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('oprcode')"><bean:message bundle="citycomlog" key="oprcode"/></a>
                    <s:OrderImg form="/cms/citycomlog/citycomlogForm" field="oprcode"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('oprtype')"><bean:message bundle="citycomlog" key="oprtype"/></a>
                    <s:OrderImg form="/cms/citycomlog/citycomlogForm" field="oprtype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('success')"><bean:message bundle="citycomlog" key="success"/></a>
                    <s:OrderImg form="/cms/citycomlog/citycomlogForm" field="success"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('citycompid')"><bean:message bundle="citycomlog" key="citycompid"/></a>
                    <s:OrderImg form="/cms/citycomlog/citycomlogForm" field="citycompid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('centerid')"><bean:message bundle="citycomlog" key="centerid"/></a>
                    <s:OrderImg form="/cms/citycomlog/citycomlogForm" field="centerid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('citycompname')"><bean:message bundle="citycomlog" key="citycompname"/></a>
                    <s:OrderImg form="/cms/citycomlog/citycomlogForm" field="citycompname"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('citycomptype')"><bean:message bundle="citycomlog" key="citycomptype"/></a>
                    <s:OrderImg form="/cms/citycomlog/citycomlogForm" field="citycomptype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('agent')"><bean:message bundle="citycomlog" key="agent"/></a>
                    <s:OrderImg form="/cms/citycomlog/citycomlogForm" field="agent"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('billingcode')"><bean:message bundle="citycomlog" key="billingcode"/></a>
                    <s:OrderImg form="/cms/citycomlog/citycomlogForm" field="billingcode"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('areacode')"><bean:message bundle="citycomlog" key="areacode"/></a>
                    <s:OrderImg form="/cms/citycomlog/citycomlogForm" field="areacode"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('adacode')"><bean:message bundle="citycomlog" key="adacode"/></a>
                    <s:OrderImg form="/cms/citycomlog/citycomlogForm" field="adacode"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('longitude')"><bean:message bundle="citycomlog" key="longitude"/></a>
                    <s:OrderImg form="/cms/citycomlog/citycomlogForm" field="longitude"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('latitude')"><bean:message bundle="citycomlog" key="latitude"/></a>
                    <s:OrderImg form="/cms/citycomlog/citycomlogForm" field="latitude"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/citycomlog.do?CMD=EDIT" var="urlContent">
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
                     <td><c:out value="${item.citycompid}"/></td>
                     <td><s:Code2Name code="${item.centerid}"  definition="#AREACENTER"/></td>
                     <td><c:out value="${item.citycompname}"/></td>
                     <td><s:Code2Name code="${item.citycomptype}"  definition="$CH_CITYCOMPTYPE"/></td>
                     <td><c:out value="${item.agent}"/></td>
                     <td><c:out value="${item.billingcode}"/></td>
                     <td><c:out value="${item.areacode}"/></td>
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
