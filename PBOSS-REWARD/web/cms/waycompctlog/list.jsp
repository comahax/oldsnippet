<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A6FBT16" />
</jsp:include>
<html>
<head>
    <title><bean:message bundle="waycompctlog" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
     
            return checkval(window);
        }
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/waycompctlog.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
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
    			<bean:message bundle="waycompctlog" key="titleList"/>
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
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="waycompctlog" key="optime"/>&gt;=:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnl_optime" onclick="this.value=selectDatetime();" readonly="true"/>
                </td>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="waycompctlog" key="optime"/>&lt;=:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnm_optime" onclick="this.value=selectDatetime();" readonly="true"/>
                </td>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="waycompctlog" key="oprcode"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_sk_oprcode"></html:text>
                </td>
            </tr>
            <tr>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="waycompctlog" key="oprtype"/>:</td>
                <td class="form_table_left">
                     <html:select property="_se_oprtype"> <option></option>	<s:Options  definition="$OPRTYPE"/>  </html:select> 
                </td>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="waycompctlog" key="success"/>:</td>
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
                    <a href="javascript:doOrderby('logid')"><bean:message bundle="waycompctlog" key="logid"/></a>
                    <s:OrderImg form="/cms/waycompctlog/waycompctlogForm" field="logid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('optime')"><bean:message bundle="waycompctlog" key="optime"/></a>
                    <s:OrderImg form="/cms/waycompctlog/waycompctlogForm" field="optime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('oprcode')"><bean:message bundle="waycompctlog" key="oprcode"/></a>
                    <s:OrderImg form="/cms/waycompctlog/waycompctlogForm" field="oprcode"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('oprtype')"><bean:message bundle="waycompctlog" key="oprtype"/></a>
                    <s:OrderImg form="/cms/waycompctlog/waycompctlogForm" field="oprtype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('success')"><bean:message bundle="waycompctlog" key="success"/></a>
                    <s:OrderImg form="/cms/waycompctlog/waycompctlogForm" field="success"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('wayid')"><bean:message bundle="waycompctlog" key="wayid"/></a>
                    <s:OrderImg form="/cms/waycompctlog/waycompctlogForm" field="wayid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('compactno')"><bean:message bundle="waycompctlog" key="compactno"/></a>
                    <s:OrderImg form="/cms/waycompctlog/waycompctlogForm" field="compactno"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('compactname')"><bean:message bundle="waycompctlog" key="compactname"/></a>
                    <s:OrderImg form="/cms/waycompctlog/waycompctlogForm" field="compactname"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('begintime')"><bean:message bundle="waycompctlog" key="begintime"/></a>
                    <s:OrderImg form="/cms/waycompctlog/waycompctlogForm" field="begintime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('endtime')"><bean:message bundle="waycompctlog" key="endtime"/></a>
                    <s:OrderImg form="/cms/waycompctlog/waycompctlogForm" field="endtime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('signtime')"><bean:message bundle="waycompctlog" key="signtime"/></a>
                    <s:OrderImg form="/cms/waycompctlog/waycompctlogForm" field="signtime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('coptype')"><bean:message bundle="waycompctlog" key="coptype"/></a>
                    <s:OrderImg form="/cms/waycompctlog/waycompctlogForm" field="coptype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('copbound')"><bean:message bundle="waycompctlog" key="copbound"/></a>
                    <s:OrderImg form="/cms/waycompctlog/waycompctlogForm" field="copbound"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('recomrule')"><bean:message bundle="waycompctlog" key="recomrule"/></a>
                    <s:OrderImg form="/cms/waycompctlog/waycompctlogForm" field="recomrule"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('compact')"><bean:message bundle="waycompctlog" key="compact"/></a>
                    <s:OrderImg form="/cms/waycompctlog/waycompctlogForm" field="compact"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/waycompctlog.do?CMD=EDIT" var="urlContent">
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
                     <td><c:out value="${item.wayid}"/></td>
                     <td><c:out value="${item.compactno}"/></td>
                     <td><c:out value="${item.compactname}"/></td>
                     <td><c:out value="${item.begintime}"/></td>
                     <td><c:out value="${item.endtime}"/></td>
                     <td><c:out value="${item.signtime}"/></td>
                     <td><s:Code2Name code="${item.coptype}"  definition="#COPTYPE"/></td>
                     <td><c:out value="${item.copbound}"/></td>
                     <td><c:out value="${item.recomrule}"/></td>
                     <td><c:out value="${item.compact}"/></td>
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
