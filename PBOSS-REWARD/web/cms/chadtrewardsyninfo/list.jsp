<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<html>
<head>
    <title><bean:message bundle="chadtrewardsyninfo" key="titleList"/></title>
	<script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_se_rewardmonth', '<bean:message bundle="chadtrewardsyninfo" key="rewardmonth"/>', 'c', 'false', '6');
            addfield('_ne_systemflag', '<bean:message bundle="chadtrewardsyninfo" key="systemflag"/>', 'f', 'false', '3');
            addfield('_ne_taskstate', '<bean:message bundle="chadtrewardsyninfo" key="taskstate"/>', 'f', 'false', '1');
            addfield('_sk_operid', '<bean:message bundle="chadtrewardsyninfo" key="operid"/>', 'c', 'false', '16');
            addfield('_dnm_optime', '<bean:message bundle="chadtrewardsyninfo" key="optime"/>', 't', 'false', '7');
            addfield('_dnl_optime', '<bean:message bundle="chadtrewardsyninfo" key="optime"/>', 't', 'false', '7');
            return checkval(window);
        }
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/chadtrewardsyninfo.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/chadtrewardsyninfo/ChadtrewardsyninfoForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="chadtrewardsyninfo" key="titleList"/>
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
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chadtrewardsyninfo" key="rewardmonth"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_rewardmonth" onclick="this.value=selectDateYYYYMM(this.value)"></html:text>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chadtrewardsyninfo" key="systemflag"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:select property="_ne_systemflag">
                    	<option />
                    	<s:Options definition="#SYSTEMFLAG" />
                    </html:select>
                </td>
            </tr>
            <tr>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chadtrewardsyninfo" key="taskstate"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:select property="_ne_taskstate">
                    	<option />
                    	<s:Options definition="#CH_TASKSSTATUS" />
                    </html:select>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chadtrewardsyninfo" key="operid"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_sk_operid"></html:text>
                </td>
            </tr>
            <tr>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chadtrewardsyninfo" key="_dnl_optime"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" onclick="this.value=selectDate();" property="_dnl_optime"></html:text>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chadtrewardsyninfo" key="_dnm_optime"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" onclick="this.value=selectDate();" property="_dnm_optime"></html:text>
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
                </td>
			</tr>
		</table>
	</div>

    <div class="table_div">
      <div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
                <!-- <td title="<bean:message bundle="public" key="list_title_select"/>">
                    <input type="checkbox" name="allbox" onclick="checkAll();" class="table_checkbox">
                </td> -->
                <td>
                    <a href="javascript:doOrderby('taskid')"><bean:message bundle="chadtrewardsyninfo" key="taskid"/></a>
                    <s:OrderImg form="/cms/chadtrewardsyninfo/ChadtrewardsyninfoForm" field="taskid"/>
                </td>
                <td><bean:message bundle="chadtrewardsyninfo" key="rewardmonth"/></td>
                <td><bean:message bundle="chadtrewardsyninfo" key="systemflag"/></td>
                <td><bean:message bundle="chadtrewardsyninfo" key="countyid"/></td>
                <td><bean:message bundle="chadtrewardsyninfo" key="wayid"/></td>
                <td><bean:message bundle="chadtrewardsyninfo" key="chainhead"/></td>
                <td><bean:message bundle="chadtrewardsyninfo" key="mobile"/></td>
                <td><bean:message bundle="chadtrewardsyninfo" key="opnids"/></td>
                <td><bean:message bundle="chadtrewardsyninfo" key="taskstate"/></td>
                <td><bean:message bundle="chadtrewardsyninfo" key="operid"/></td>
                <td><bean:message bundle="chadtrewardsyninfo" key="optime"/></td>
                <td><bean:message bundle="chadtrewardsyninfo" key="resultfile"/></td>
                <td><bean:message bundle="chadtrewardsyninfo" key="finishtime"/></td>
                <td><bean:message bundle="chadtrewardsyninfo" key="totalcount"/></td>
                <td><bean:message bundle="chadtrewardsyninfo" key="successsum"/></td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/chadtrewardsyninfo.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.taskid}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <!-- <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.taskid}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td> -->
                     <td><c:out value="${item.taskid}"/></td>
                     <td><c:out value="${item.rewardmonth}"/></td>
                     <td><s:Code2Name code="${item.systemflag}" definition="#SYSTEMFLAG"/></td>
                     <td><s:Code2Name code="${item.countyid}" definition="#CNTYCOMPANY"/></td>
                     <td><c:out value="${item.wayid}"/></td>
                     <td><c:out value="${item.chainhead}"/></td>
                     <td><c:out value="${item.mobile}"/></td>
                     <td><c:out value="${item.opnids}"/></td>
                     <td><s:Code2Name code="${item.taskstate}" definition="#CH_TASKSSTATUS"/></td>
                     <td><c:out value="${item.operid}"/></td>
                     <td><fmt:formatDate type="date" pattern="yyyy-MM-dd HH:mm:ss" value="${item.optime}"/></td>
                     <td>
                     	<c:if test="${!empty item.resultfile}">
							<a href='<%=contextPath%>/cms/chadtrewardsyninfo.do?CMD=DOWNLOAD&down=<c:out value="${item.resultfile}"/>'>
							    <img height=10 src="<%=contextPath%>/images/file.png" width=10 border=0>
							</a>
						</c:if>
                     </td>
                     <td><fmt:formatDate type="date" pattern="yyyy-MM-dd HH:mm:ss" value="${item.finishtime}"/></td>
                     <td><c:out value="${item.totalcount}"/></td>
                     <td><c:out value="${item.successsum}"/></td>
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
