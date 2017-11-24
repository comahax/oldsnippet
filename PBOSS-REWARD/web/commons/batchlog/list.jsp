<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="7G1A2B" />
</jsp:include>

<html>
<head>
    <title><bean:message bundle="batchlog" key="title"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            //addfield('_se_oprcode', '<bean:message bundle="batchlog" key="oprcode"/>', 'c', true, 20);
            return checkval(window);
        }
    </script>
</head>

<body>
<div class="table_container">
<html:form action="/commons/batchlog.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <div class="table_div">
	   <table class="top_table">
			<tr>
				<td>
					<bean:message bundle="batchlog" key="title"/>
				</td>
			</tr>
		</table>
	</div>
	<div class="table_div">
		<table width="100%" class="error_text">
			<html:errors />
			<s:Msg />
		</table>
	</div>
	<div class="table_div">
        <table class="form_table">
            <tr>
                <td width="126" height="20" align="right" class="form_table_right"><bean:message bundle="batchlog" key="oprcode"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_oprcode"></html:text>
                </td>
                <td width="126" height="20" align="right" class="form_table_right"><bean:message bundle="batchlog" key="oprwayid"/>:</td>
                <td class="form_table_left">
                	<html:text styleClass="form_input_1x" property="_se_oprwayid" onclick="showSelectWay(this);" readonly="false"/>
                </td>
             </tr> 
             <tr> 
                <td width="126" height="20" align="right" class="form_table_right"><bean:message bundle="batchlog" key="optime"/>>=:</td>
                <td class="form_table_left">
                	<html:text styleClass="form_input_1x" property="_dnl_optime" onclick="this.value=selectDatetime();" readonly="false"/>
                </td>
                <td width="126" height="20" align="right" class="form_table_right"><bean:message bundle="batchlog" key="optime"/><=:</td>
                <td class="form_table_left">
                	<html:text styleClass="form_input_1x" property="_dnm_optime" onclick="this.value=selectDatetime();" readonly="false"/>
                </td>
             </tr> 
             <tr>   
                <td width="126" height="20" align="right" class="form_table_right"><bean:message bundle="batchlog" key="success"/>:</td>
                <td class="form_table_left">
                	<html:select property="_se_success">
						<option value=""></option>
						<s:Options definition="#BATCHSUCCESS"></s:Options>
					</html:select>
                </td>
                <td width="126" height="20" align="right" class="form_table_right"><bean:message bundle="batchlog" key="batchname"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_sk_batchname"></html:text>
                </td>                
            </tr>
        </table>
  </div>
	<div class="table_div">		
		<table class="table_button_list">
			<tr> 
               <td>
                 <input type="button" class="query" onmouseover="buttonover(this);"
                      onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                      value="<bean:message bundle="public" key="button_search"/>" onClick="doQuery();">
			   </td>
			</tr>
		</table>
	</div>	

	<div class="table_div">
	<div class="table_LongTable">
		<table class="table_style">
			  <tr class="table_style_head">
                <td>
                    <a href="javascript:doOrderby('batchname')"><bean:message bundle="batchlog" key="batchname"/></a>
                    <s:OrderImg form="/commons/batchlog/BatchlogForm" field="batchname"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('optime')"><bean:message bundle="batchlog" key="optime"/></a>
                    <s:OrderImg form="/commons/batchlog/BatchlogForm" field="optime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('oprtype')"><bean:message bundle="batchlog" key="oprtype"/></a>
                    <s:OrderImg form="/commons/batchlog/BatchlogForm" field="oprtype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('oprcode')"><bean:message bundle="batchlog" key="oprcode"/></a>
                    <s:OrderImg form="/commons/batchlog/BatchlogForm" field="oprcode"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('oprwayid')"><bean:message bundle="batchlog" key="oprwayid"/></a>
                    <s:OrderImg form="/commons/batchlog/BatchlogForm" field="oprwayid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('success')"><bean:message bundle="batchlog" key="success"/></a>
                    <s:OrderImg form="/commons/batchlog/BatchlogForm" field="success"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('uploadpath')"><bean:message bundle="batchlog" key="uploadpath"/></a>
                    <s:OrderImg form="/commons/batchlog/BatchlogForm" field="uploadpath"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('resultpath')"><bean:message bundle="batchlog" key="resultpath"/></a>
                    <s:OrderImg form="/commons/batchlog/BatchlogForm" field="resultpath"/>
                </td>
                
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <tr class="table_style_content" align="center">
                     <td><c:out value="${item.batchname}"/></td>
                     <td> <fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.optime}"/> </td>
                     <td><c:out value="${item.oprtype}"/></td>
                     <td><c:out value="${item.oprcode}"/></td>
                     <td><s:Code2Name definition="#WAY" code="${item.oprwayid}" /></td>
                     <td><s:Code2Name definition="#BATCHSUCCESS" code="${item.success}" /></td>
                     <td><a href='<%=contextPath%>/commons/batchlog.do?CMD=DOWNLOAD&down=<c:out value="${item.uploadpath}"/>'>upload.txt </a></td>
                     <td><a href='<%=contextPath%>/commons/batchlog.do?CMD=DOWNLOAD&down=<c:out value="${item.resultpath}"/>'>result.txt</a></td>
                     <%--<td><a href='<%=contextPath%>/commons/batch/download.jsp?filename=<c:out value="${item.uploadpath}" />'>upload.txt </a></td>--%>
                     <%--<td><a href='<%=contextPath%>/commons/batch/download.jsp?filename=<c:out value="${item.resultpath}" />'>result.txt</a></td>--%>
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
