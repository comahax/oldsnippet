<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A6FBT6" />
</jsp:include>
<html>
<head>
    <title><bean:message bundle="custwtypelog" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
         
            return checkval(window);
        }
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/custwtypelog.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
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
    			<bean:message bundle="custwtypelog" key="titleList"/>
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
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="custwtypelog" key="optime"/>&gt;=:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnl_optime" onclick="this.value=selectDatetime();" readonly="true"/>
                </td>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="custwtypelog" key="optime"/>&lt;=:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnm_optime" onclick="this.value=selectDatetime();" readonly="true"/>
                </td>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="custwtypelog" key="oprcode"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_sk_oprcode"></html:text>
                </td>
            </tr>
            <tr>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="custwtypelog" key="oprtype"/>:</td>
                <td class="form_table_left">
                     <html:select property="_se_oprtype"> <option></option>	<s:Options  definition="$OPRTYPE"/>  </html:select> 
                </td>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="custwtypelog" key="success"/>:</td>
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
                    <a href="javascript:doOrderby('logid')"><bean:message bundle="custwtypelog" key="logid"/></a>
                    <s:OrderImg form="/cms/custwtypelog/custwtypelogForm" field="logid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('optime')"><bean:message bundle="custwtypelog" key="optime"/></a>
                    <s:OrderImg form="/cms/custwtypelog/custwtypelogForm" field="optime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('oprcode')"><bean:message bundle="custwtypelog" key="oprcode"/></a>
                    <s:OrderImg form="/cms/custwtypelog/custwtypelogForm" field="oprcode"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('oprtype')"><bean:message bundle="custwtypelog" key="oprtype"/></a>
                    <s:OrderImg form="/cms/custwtypelog/custwtypelogForm" field="oprtype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('success')"><bean:message bundle="custwtypelog" key="success"/></a>
                    <s:OrderImg form="/cms/custwtypelog/custwtypelogForm" field="success"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('custwaytypecode')"><bean:message bundle="custwtypelog" key="custwaytypecode"/></a>
                    <s:OrderImg form="/cms/custwtypelog/custwtypelogForm" field="custwaytypecode"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('citycompid')"><bean:message bundle="custwtypelog" key="citycompid"/></a>
                    <s:OrderImg form="/cms/custwtypelog/custwtypelogForm" field="citycompid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('custwaytypename')"><bean:message bundle="custwtypelog" key="custwaytypename"/></a>
                    <s:OrderImg form="/cms/custwtypelog/custwtypelogForm" field="custwaytypename"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('notusebysub')"><bean:message bundle="custwtypelog" key="notusebysub"/></a>
                    <s:OrderImg form="/cms/custwtypelog/custwtypelogForm" field="notusebysub"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('description')"><bean:message bundle="custwtypelog" key="description"/></a>
                    <s:OrderImg form="/cms/custwtypelog/custwtypelogForm" field="description"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/custwtypelog.do?CMD=EDIT" var="urlContent">
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
                     <td><c:out value="${item.custwaytypecode}"/></td>
                     <td><s:Code2Name code="${item.citycompid}"  definition="#CITYCOMPANY"/></td>
                     <td><c:out value="${item.custwaytypename}"/></td>
                     <td><s:Code2Name code="${item.notusebysub}"  definition="#NOTUSEBYSUB"/></td>
                     <td><c:out value="${item.description}"/></td>
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
