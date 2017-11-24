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
    <title><bean:message bundle="exmnaudit" key="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
	 <script type="text/javascript" src="<%=contextPath%>/js/jquery/jquery-1.3.2.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_ne_seqid', '<bean:message bundle="exmnaudit" key="seqid"/>', 'f', 'false', '14');
            addfield('_se_presenter', '<bean:message bundle="exmnaudit" key="presenter"/>', 'c', 'false', '16');
            if(!checkDateByMask(document.getElementsByName("_dnm_submissiontime")[0].value,'yyyy-MM-dd ',1)){
            	
            }
             if(document.getElementsByName("_dnl_submissiontime")[0].value!=""){
            	if(!checkDateByMask(document.getElementsByName("_dnl_submissiontime")[0].value,'yyyy-MM-dd HH:mm:ss',1)){
					var alertstr='<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[<bean:message bundle="exmnaudit" key="submissiontime"/>>=]</span>日期格式不对，格式应为yyyy-MM-dd HH:mm:ss</span>';
					errorMessageShow(alertstr);
					return false;
				}
			}
			if(document.getElementsByName("_dnm_submissiontime")[0].value!=""){
				if(!checkDateByMask(document.getElementsByName("_dnm_submissiontime")[0].value,'yyyy-MM-dd HH:mm:ss',1)){
						var alertstr='<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[<bean:message bundle="exmnaudit" key="submissiontime"/><=]</span>日期格式不对，格式应为yyyy-MM-dd HH:mm:ss</span>';
						errorMessageShow(alertstr);
						return false;
				}
			}
            addfield('_se_state', '<bean:message bundle="exmnaudit" key="state"/>', 'c', 'false', '32');
            return checkval(window);
        }
         function doReturn(cmdReturn) {
        	document.getElementsByName("_ne_itemgradedid")[0].value="";
		    formList.action = contextPath + cmdReturn;
		    formList.submit();
		}
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/examine/exmnaudit.do?CMD=AUDITLIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_ne_itemgradedid"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/examine/exmnaudit/ExmnauditForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="exmnaudit" key="titleList"/>
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
               
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="exmnaudit" key="presenter"/>:</td>
                <td width="30%" class="form_table_left">
                     <s:zoom definition="#OPERATORNAME" property="_se_presenter" styleClass="form_input_1x" />
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="exmnaudit" key="auditor"/>:</td>
                <td width="30%" class="form_table_left">
                    <s:zoom definition="#OPERATORNAME" property="_se_auditor" styleClass="form_input_1x" />
                </td>
            </tr>
            <tr>
            	<td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="exmnaudit" key="_dnl_submissiontime"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnl_submissiontime"  onclick="this.value=selectDatetime();"></html:text>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="exmnaudit" key="_dnm_submissiontime"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnm_submissiontime"  onclick="this.value=selectDatetime();"></html:text>
                </td>
            </tr>
           <tr>
           		 <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="exmnaudit" key="state"/>:</td>
                <td width="30%" class="form_table_left">
                     <html:select property="_se_state">
               		    <option/>
               		    <s:Options definition="$CH_AUDITSTATE"/>
               		</html:select>
                </td>
           		 <td width="20%" height="20" align="right" class="form_table_right" >&nbsp;</td>
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
                       
                          <input type="button" class="query" onmouseover="buttonover(this);" onclick="doQuery();"
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_search"/>" />
                           <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                            name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_return"/>" class="close"
                            onclick="doReturn('/cms/examine/itemgraded.do?CMD=LIST')">
                </td>
			</tr>
		</table>
	</div>

    <div class="table_div">
      <div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
                <td title="<bean:message bundle="public" key="list_title_select"/>">
                    <input type="checkbox" name="allbox" onclick="checkAll();" class="table_checkbox">
                </td>
                <td>
                    <a href="javascript:doOrderby('seqid')"><bean:message bundle="exmnaudit" key="seqid"/></a>
                    <s:OrderImg form="/cms/examine/exmnaudit/ExmnauditForm" field="seqid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('presenter')"><bean:message bundle="exmnaudit" key="presenter"/></a>
                    <s:OrderImg form="/cms/examine/exmnaudit/ExmnauditForm" field="presenter"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('submissiontime')"><bean:message bundle="exmnaudit" key="submissiontime"/></a>
                    <s:OrderImg form="/cms/examine/exmnaudit/ExmnauditForm" field="submissiontime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('auditor')"><bean:message bundle="exmnaudit" key="auditor"/></a>
                    <s:OrderImg form="/cms/examine/exmnaudit/ExmnauditForm" field="auditor"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('auditopinion')"><bean:message bundle="exmnaudit" key="auditopinion"/></a>
                    <s:OrderImg form="/cms/examine/exmnaudit/ExmnauditForm" field="auditopinion"/>
                </td>
               
                <td>
                    <a href="javascript:doOrderby('state')"><bean:message bundle="exmnaudit" key="state"/></a>
                    <s:OrderImg form="/cms/examine/exmnaudit/ExmnauditForm" field="state"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/examine/exmnaudit.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.seqid}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.seqid}' />"
                               onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td>
                         <c:out value="${item.seqid}"/>
                     </td>
                     <td><c:out value="${item.presenter}"/></td>
                     <td><c:out value="${item.submissiontime}"/></td>
                     <td><c:out value="${item.auditor}"/></td>
                     <td><c:out value="${item.auditopinion}"/></td>
                     <td><s:Code2Name definition="$CH_AUDITSTATE" code="${item.state}"/></td>
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
