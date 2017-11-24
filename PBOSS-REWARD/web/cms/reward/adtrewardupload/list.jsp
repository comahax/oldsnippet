<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
    String ID_1 = "00010701";
    String ID_2 = "00010702";
    String ID_3 = "00010703";
    String ID_4 = "00010704";
%>
<html>
<head>
    <title><bean:message bundle="adtrewardupload" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_ne_taskid', '<bean:message bundle="adtrewardupload" key="taskid"/>', 'f', 'false', '10');
            addfield('_ne_taskstate', '<bean:message bundle="adtrewardupload" key="taskstate"/>', 'f', 'false', '1');
            addfield('_se_oprcode', '<bean:message bundle="adtrewardupload" key="oprcode"/>', 'c', 'false', '15');
            addfield('_dnm_uploadtime', '<bean:message bundle="adtrewardupload" key="uploadtime"/>', 't', 'false', '7');
            addfield('_dnl_uploadtime', '<bean:message bundle="adtrewardupload" key="uploadtime"/>', 't', 'false', '7');
            addfield('_se_mobile', '<bean:message bundle="adtrewardupload" key="mobile"/>', 'c', 'false', '13');
            return checkval(window);
        }
        function upload(){
			formList.action="<%=contextPath%>/cms/reward/adtrewardupload/batch.jsp";
			formList.submit();
		}
        function doReturn(){
    		window.location.href="<%=contextPath%>/cms/cityrecord.do?CMD=SHOW";
    	}	
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/reward/adtrewardupload.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/reward/adtrewardupload/AdtrewarduploadForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="adtrewardupload" key="titleList"/>
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
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="adtrewardupload" key="taskid"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_ne_taskid"></html:text>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="adtrewardupload" key="taskstate"/>:</td>
                <td width="30%" class="form_table_left">
<!--                    <html:text styleClass="form_input_1x" property="_ne_taskstate"></html:text>-->
                    <html:select property="_ne_taskstate">
                    	<option />
                    	<s:Options definition="#CH_TASKSSTATUS" />
                    </html:select>
                </td>
            </tr>
            <tr>
            	<td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="adtrewardupload" key="uploadtime"/>>=:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnl_uploadtime" onclick="this.value=selectDate();"></html:text>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="adtrewardupload" key="uploadtime"/><=:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnm_uploadtime" onclick="this.value=selectDate();"></html:text>
                </td>
            </tr>
            <tr>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="adtrewardupload" key="oprcode"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_oprcode"></html:text>
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
<!--                        <s:PurChk controlid="<%=ID_1%>">-->
<!--                            <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"-->
<!--                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"-->
<!--                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/reward/adtrewardupload.do')">-->
<!--                        </s:PurChk>-->
<!--                        <s:PurChk controlid="<%=ID_2%>">-->
<!--                            <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"-->
<!--                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"-->
<!--                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/reward/adtrewardupload.do')">-->
<!--                        </s:PurChk>-->
                        <s:PurChk controlid="<%=ID_3%>">
                        <input type="button" class="query" onmouseover="buttonover(this);" onclick="doQuery();"
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_search"/>" />
                        </s:PurChk>
                        <input type="button" value="文件上传" 
								class="button_4" onclick="upload();" onmouseover="buttonover(this)"
								onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)">
						<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           		name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           		value="<bean:message bundle="public" key="button_return"/>" class="button_4"
                           		onclick="doReturn()">
                </td>
			</tr>
		</table>
	</div>

    <div class="table_div">
      <div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
<!--                <td title="<bean:message bundle="public" key="list_title_select"/>">-->
<!--                    <input type="checkbox" name="allbox" onclick="checkAll();" class="table_checkbox">-->
<!--                </td>-->
                <td>
                    <a href="javascript:doOrderby('taskid')"><bean:message bundle="adtrewardupload" key="taskid"/></a>
                    <s:OrderImg form="/cms/reward/adtrewardupload/AdtrewarduploadForm" field="taskid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('taskstate')"><bean:message bundle="adtrewardupload" key="taskstate"/></a>
                    <s:OrderImg form="/cms/reward/adtrewardupload/AdtrewarduploadForm" field="taskstate"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('uploadfile')"><bean:message bundle="adtrewardupload" key="uploadfile"/></a>
                    <s:OrderImg form="/cms/reward/adtrewardupload/AdtrewarduploadForm" field="uploadfile"/>
                </td>
<!--                <td>-->
<!--                    <a href="javascript:doOrderby('totalcount')"><bean:message bundle="adtrewardupload" key="totalcount"/></a>-->
<!--                    <s:OrderImg form="/cms/reward/adtrewardupload/AdtrewarduploadForm" field="totalcount"/>-->
<!--                </td>-->
                <td>
                    <a href="javascript:doOrderby('oprcode')"><bean:message bundle="adtrewardupload" key="oprcode"/></a>
                    <s:OrderImg form="/cms/reward/adtrewardupload/AdtrewarduploadForm" field="oprcode"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('uploadtime')"><bean:message bundle="adtrewardupload" key="uploadtime"/></a>
                    <s:OrderImg form="/cms/reward/adtrewardupload/AdtrewarduploadForm" field="uploadtime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('resultfile')"><bean:message bundle="adtrewardupload" key="resultfile"/></a>
                    <s:OrderImg form="/cms/reward/adtrewardupload/AdtrewarduploadForm" field="resultfile"/>
                </td>                
                <td>
                    <a href="javascript:doOrderby('endtime')"><bean:message bundle="adtrewardupload" key="endtime"/></a>
                    <s:OrderImg form="/cms/reward/adtrewardupload/AdtrewarduploadForm" field="endtime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('currentcount')"><bean:message bundle="adtrewardupload" key="currentcount"/></a>
                    <s:OrderImg form="/cms/reward/adtrewardupload/AdtrewarduploadForm" field="currentcount"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('successcount')"><bean:message bundle="adtrewardupload" key="successcount"/></a>
                    <s:OrderImg form="/cms/reward/adtrewardupload/AdtrewarduploadForm" field="successcount"/>
                </td>
                <td>
                    <bean:message bundle="adtrewardupload" key="successsum"/>                    
                </td>
                <td>
                    <a href="javascript:doOrderby('failcount')"><bean:message bundle="adtrewardupload" key="failcount"/></a>
                    <s:OrderImg form="/cms/reward/adtrewardupload/AdtrewarduploadForm" field="failcount"/>
                </td>
<!--                <td>-->
<!--                    <a href="javascript:doOrderby('mobile')"><bean:message bundle="adtrewardupload" key="mobile"/></a>-->
<!--                    <s:OrderImg form="/cms/reward/adtrewardupload/AdtrewarduploadForm" field="mobile"/>-->
<!--                </td>-->
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/reward/adtrewardupload.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.taskid}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
<!--                     <td>-->
<!--                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.taskid}' />"-->
<!--                                onclick="checkOne();" class="table_checkbox">-->
<!--                     </td>-->
                     <td>
<!--                         <a href='<c:out value="${urlContent}"/>'>-->
                         <c:out value="${item.taskid}"/>
<!--                         </a>-->
                     </td>
<!--                     <td><c:out value="${item.taskstate}"/></td>-->
                     <td><s:Code2Name code="${item.taskstate}" definition="#CH_TASKSSTATUS"/></td>
                     <td>
<!--                     	<c:out value="${item.uploadfile}"/>-->
						<c:if test="${!empty item.uploadfile}">
							<a href='<%=contextPath%>/cms/reward/adtrewardupload.do?CMD=DOWNLOAD&down=<c:out value="${item.uploadfile}"/>'>
							    <img height=10 src="<%=contextPath%>/images/file.png" width=10 border=0> 
							</a>
						</c:if>
                     </td>
<!--                     <td><c:out value="${item.totalcount}"/></td>-->
                     <td><c:out value="${item.oprcode}"/></td>
                     <td><c:out value="${item.uploadtime}"/></td>
                     <td>
<!--					 	<c:out value="${item.resultfile}"/>-->
						<c:if test="${!empty item.resultfile}">
							<a href='<%=contextPath%>/cms/reward/adtrewardupload.do?CMD=DOWNLOAD&down=<c:out value="${item.resultfile}"/>'>
							    <img height=10 src="<%=contextPath%>/images/file.png" width=10 border=0> 
							</a>
						</c:if>
                     </td>
                     <td><c:out value="${item.endtime}"/></td>
                     <td><c:out value="${item.currentcount}"/></td>
                     <td><c:out value="${item.successcount}"/></td>
                     <td><fmt:formatNumber pattern="0.0000" value="${item.successsum}" /></td>
                     <td><c:out value="${item.failcount}"/></td>
<!--                     <td><c:out value="${item.mobile}"/></td>-->
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
