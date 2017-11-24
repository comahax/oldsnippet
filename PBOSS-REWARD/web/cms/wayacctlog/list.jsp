<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A6FBT17" />
</jsp:include>
<html>
<head>
    <title><bean:message bundle="wayacctlog" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            return checkval(window);
        }
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/wayacctlog.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
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
    			<bean:message bundle="wayacctlog" key="titleList"/>
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
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="wayacctlog" key="optime"/>&gt;=:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnl_optime" onclick="this.value=selectDatetime();" readonly="true"/>
                </td>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="wayacctlog" key="optime"/>&lt;=:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnm_optime" onclick="this.value=selectDatetime();" readonly="true"/>
                </td>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="wayacctlog" key="oprcode"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_sk_oprcode"></html:text>
                </td>
            </tr>
            <tr>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="wayacctlog" key="oprtype"/>:</td>
                <td class="form_table_left">
                     <html:select property="_se_oprtype"> <option></option>	<s:Options  definition="$OPRTYPE"/>  </html:select> 
                </td>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="wayacctlog" key="success"/>:</td>
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
                    <a href="javascript:doOrderby('logid')"><bean:message bundle="wayacctlog" key="logid"/></a>
                    <s:OrderImg form="/cms/wayacctlog/wayacctlogForm" field="logid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('optime')"><bean:message bundle="wayacctlog" key="optime"/></a>
                    <s:OrderImg form="/cms/wayacctlog/wayacctlogForm" field="optime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('oprcode')"><bean:message bundle="wayacctlog" key="oprcode"/></a>
                    <s:OrderImg form="/cms/wayacctlog/wayacctlogForm" field="oprcode"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('oprtype')"><bean:message bundle="wayacctlog" key="oprtype"/></a>
                    <s:OrderImg form="/cms/wayacctlog/wayacctlogForm" field="oprtype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('success')"><bean:message bundle="wayacctlog" key="success"/></a>
                    <s:OrderImg form="/cms/wayacctlog/wayacctlogForm" field="success"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('accid')"><bean:message bundle="wayacctlog" key="accid"/></a>
                    <s:OrderImg form="/cms/wayacctlog/wayacctlogForm" field="accid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('wayid')"><bean:message bundle="wayacctlog" key="wayid"/></a>
                    <s:OrderImg form="/cms/wayacctlog/wayacctlogForm" field="wayid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('chargetype')"><bean:message bundle="wayacctlog" key="chargetype"/></a>
                    <s:OrderImg form="/cms/wayacctlog/wayacctlogForm" field="chargetype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('accttype')"><bean:message bundle="wayacctlog" key="accttype"/></a>
                    <s:OrderImg form="/cms/wayacctlog/wayacctlogForm" field="accttype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('acctno')"><bean:message bundle="wayacctlog" key="acctno"/></a>
                    <s:OrderImg form="/cms/wayacctlog/wayacctlogForm" field="acctno"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('acctname')"><bean:message bundle="wayacctlog" key="acctname"/></a>
                    <s:OrderImg form="/cms/wayacctlog/wayacctlogForm" field="acctname"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('bankname')"><bean:message bundle="wayacctlog" key="bankname"/></a>
                    <s:OrderImg form="/cms/wayacctlog/wayacctlogForm" field="bankname"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('dsbank')"><bean:message bundle="wayacctlog" key="dsbank"/></a>
                    <s:OrderImg form="/cms/wayacctlog/wayacctlogForm" field="dsbank"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('bankaddr')"><bean:message bundle="wayacctlog" key="bankaddr"/></a>
                    <s:OrderImg form="/cms/wayacctlog/wayacctlogForm" field="bankaddr"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('contact')"><bean:message bundle="wayacctlog" key="contact"/></a>
                    <s:OrderImg form="/cms/wayacctlog/wayacctlogForm" field="contact"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('contel')"><bean:message bundle="wayacctlog" key="contel"/></a>
                    <s:OrderImg form="/cms/wayacctlog/wayacctlogForm" field="contel"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('rectime')"><bean:message bundle="wayacctlog" key="rectime"/></a>
                    <s:OrderImg form="/cms/wayacctlog/wayacctlogForm" field="rectime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('starttime')"><bean:message bundle="wayacctlog" key="starttime"/></a>
                    <s:OrderImg form="/cms/wayacctlog/wayacctlogForm" field="starttime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('endtime')"><bean:message bundle="wayacctlog" key="endtime"/></a>
                    <s:OrderImg form="/cms/wayacctlog/wayacctlogForm" field="endtime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('memo')"><bean:message bundle="wayacctlog" key="memo"/></a>
                    <s:OrderImg form="/cms/wayacctlog/wayacctlogForm" field="memo"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('bossarea')"><bean:message bundle="wayacctlog" key="bossarea"/></a>
                    <s:OrderImg form="/cms/wayacctlog/wayacctlogForm" field="bossarea"/>
                </td>
                <td>
                	<a href="javascript:doOrderby('acctfid')"><bean:message bundle="wayacctlog" key="acctfid"/></a>
                    <s:OrderImg form="/cms/wayacctlog/wayacctlogForm" field="acctfid"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/wayacctlog.do?CMD=EDIT" var="urlContent">
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
                     <td><c:out value="${item.accid}"/></td>
                     <td><c:out value="${item.wayid}"/></td>
                     <td><s:Code2Name code="${item.chargetype}" definition="$CH_CHARGETYPE"/></td>
                     <td><s:Code2Name code="${item.accttype}" definition="$CH_ACCOUNTTYPE"/></td>
                     <td><c:out value="${item.acctno}"/></td>
                     <td><c:out value="${item.acctname}"/></td>
                     <td><c:out value="${item.bankname}"/></td>
                     <td><c:out value="${item.dsbank}"/></td>
                     <td><c:out value="${item.bankaddr}"/></td>
                     <td><c:out value="${item.contact}"/></td>
                     <td><c:out value="${item.contel}"/></td>
                     <td><c:out value="${item.rectime}"/></td>
                     <td><c:out value="${item.starttime}"/></td>
                     <td><c:out value="${item.endtime}"/></td>
                     <td><c:out value="${item.memo}"/></td>
                     <td><c:out value="${item.bossarea}"/></td>
                     <td><c:out value="${item.acctfid}" /></td>
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
