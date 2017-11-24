<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<jsp:include page="/inc/acl.jsp">
<jsp:param name="PID" value="3C4EBT3" />
</jsp:include>
<html>
<head>
    <title><bean:message bundle="yxplanlog" key="titleList"/></title>
    <link href="<%= contextPath %>/css/css_1/iframemenu.css" rel="stylesheet" type="text/css" media="all" />
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_dnl_optime', '<bean:message bundle="yxplanlog" key="optime"/>', 't', true, '7');
            addfield('_dnm_optime', '<bean:message bundle="yxplanlog" key="optime"/>', 't', true, '7');
            addfield('_sk_oprcode', '<bean:message bundle="yxplanlog" key="oprcode"/>', 'c', true, '10');
            addfield('_se_oprtype', '<bean:message bundle="yxplanlog" key="oprtype"/>', 'c', true, '8');
            addfield('_se_success', '<bean:message bundle="yxplanlog" key="success"/>', 'c', true, '8');
            return checkval(window);
        }
    </script>
    
</head>

<body onload="loadforiframe()" >
<div class="table_container">
<html:form action="/zifee/yxplanlog.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">

     <div class="table_div">
				<table class="top_table">
					<tr>
						<td>
							<bean:message bundle="yxplanlog" key="titleList"/>
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
                <td width="126" height="20" align="right" class="form_table_right"><bean:message bundle="yxplanlog" key="optime"/> >= :</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnl_optime" onclick="this.value=selectDate();"></html:text>
                </td>
                <td width="126" height="20" align="right" class="form_table_right"><bean:message bundle="yxplanlog" key="optime"/> <= :</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnm_optime" onclick="this.value=selectDate();"></html:text>
                </td>
            </tr>
            <tr>
                <td width="126" height="20" align="right" class="form_table_right"><bean:message bundle="yxplanlog" key="oprtype"/>:</td>
                <td class="form_table_left">
                	<html:select property="_se_oprtype">
		                		<option value=""  ></option>		                		
		                		<s:Options  definition="$OPRTYPE"/>
		            </html:select>                	
                </td>
                <td width="100" height="20" align="right" class="form_table_right"><bean:message bundle="yxplanlog" key="success"/>:</td>
                <td class="form_table_left">
                	<html:select property="_se_success">
		                		<option value=""  ></option>		                		
		                		<s:Options  definition="$OPRRESULT"/>
		            </html:select>                	
                </td>
            </tr>
            <tr>
        		<td width="126" height="20" align="right" class="form_table_right"><bean:message bundle="yxplanlog" key="oprcode"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_sk_oprcode"></html:text>
                </td>
                <td width="100" height="20" align="right" class="form_table_right">营销方案标识:</td> 
                <td class="form_table_left">
                <html:text styleClass="form_input_1x" property="_se_yxplanid"></html:text>
                </td>
        	</tr>
        	 <tr>
        		<td width="126" height="20" align="right" class="form_table_right">营销方案名称:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_sk_yxplanname"></html:text>
                </td>
                <td></td> 
                <td ></td>
        	</tr>
        </table>
    </div>
    
    
    <div class="table_div">
				<table class="table_button_list">
				<tr>
                    <td>
                       <input type="button" class="query"onmouseover="buttonover(this);"
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_search"/>" onClick="doQuery();"/>
                    </td>
                    </tr>
				</table>
	</div>
	
    <div class="table_div">
    <div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
                <td>
                    <a href="javascript:doOrderby('logid')"><bean:message bundle="yxplanlog" key="logid"/></a>
                    <s:OrderImg form="/zifee/yxplanlog/YxplanlogForm" field="logid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('optime')"><bean:message bundle="yxplanlog" key="optime"/></a>
                    <s:OrderImg form="/zifee/yxplanlog/YxplanlogForm" field="optime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('oprcode')"><bean:message bundle="yxplanlog" key="oprcode"/></a>
                    <s:OrderImg form="/zifee/yxplanlog/YxplanlogForm" field="oprcode"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('oprtype')"><bean:message bundle="yxplanlog" key="oprtype"/></a>
                    <s:OrderImg form="/zifee/yxplanlog/YxplanlogForm" field="oprtype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('success')"><bean:message bundle="yxplanlog" key="success"/></a>
                    <s:OrderImg form="/zifee/yxplanlog/YxplanlogForm" field="success"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('yxplanid')"><bean:message bundle="yxplanlog" key="yxplanid"/></a>
                    <s:OrderImg form="/zifee/yxplanlog/YxplanlogForm" field="yxplanid"/>
                </td>
                  <td>
                    <a href="javascript:doOrderby('yxplanname')"><bean:message bundle="yxplanlog" key="yxplanname"/></a>
                    <s:OrderImg form="/zifee/yxplanlog/YxplanlogForm" field="yxplanname"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('yxplancode')"><bean:message bundle="yxplanlog" key="yxplancode"/></a>
                    <s:OrderImg form="/zifee/yxplanlog/YxplanlogForm" field="yxplancode"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('startdate')"><bean:message bundle="yxplanlog" key="startdate"/></a>
                    <s:OrderImg form="/zifee/yxplanlog/YxplanlogForm" field="startdate"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('stopdate')"><bean:message bundle="yxplanlog" key="stopdate"/></a>
                    <s:OrderImg form="/zifee/yxplanlog/YxplanlogForm" field="stopdate"/>
                </td>
           </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/zifee/yxplanlog.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${logid}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                  	 <td nowrap><c:out value="${item.logid}"/></td>
                     <td nowrap><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.optime}"/></td>
                     <td nowrap><c:out value="${item.oprcode}"/></td>
                     <td nowrap><s:Code2Name code="${item.oprtype}" definition="$OPRTYPE"/></td>
                     <td nowrap><s:Code2Name code="${item.success}" definition="$OPRRESULT"/></td>
                     <td nowrap><c:out value="${item.yxplanid}"/></td>
                     <td nowrap><c:out value="${item.yxplanname}"/></td>
                     <td nowrap><c:out value="${item.yxplancode}"/></td>
                     <td nowrap><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.startdate}"/></td>
                     <td nowrap><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.stopdate}"/></td>
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
