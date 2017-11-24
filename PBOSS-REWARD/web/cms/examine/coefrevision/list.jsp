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
    <title><bean:message bundle="coefrevision" key="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
    <script type="text/javascript" src="<%= contextPath%>/js/bus/rescommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_ne_seqid', '<bean:message bundle="coefrevision" key="seqid"/>', 'f', 'false', '14');
            addfield('_ne_exmnid', '<bean:message bundle="coefrevision" key="exmnid"/>', 'f', 'false', '6');
            addfield('_se_wayid', '<bean:message bundle="coefrevision" key="wayid"/>', 'c', 'false', '32');
            addfield('_snm_exmnperiod', '<bean:message bundle="coefrevision" key="exmnperiod"/>', 'c', 'false', '6');
            addfield('_se_exmnperiod', '<bean:message bundle="coefrevision" key="exmnperiod"/>', 'c', 'false', '6');
            addfield('_snl_exmnperiod', '<bean:message bundle="coefrevision" key="exmnperiod"/>', 'c', 'false', '6');
            addfield('_ne_coefficient', '<bean:message bundle="coefrevision" key="coefficient"/>', 'f', 'false', '10');
            return checkval(window);
        }
        
        function showExamineInfo(){
        	var returnValue=window.showModalDialog('<%=contextPath %>/cms/examine/examine.do?CMD=examinelist',window,"dialogWidth=500px;dialogHeight=430px;status:no;scroll=yes;");
        	if(returnValue!=undefined){
        		var strs=returnValue.split(",");
        		document.getElementsByName("_ne_exmnid")[0].value=strs[0];
  			}
  		}
        
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/examine/coefrevision.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/examine/coefrevision/CoefrevisionForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="coefrevision" key="titleList"/>
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
            	<td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="coefrevision" key="wayid"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_wayid" /><input type="button" value="..." class="clickbutton"
									onclick="showSelectWay3(this,'_se_wayid','','','AG');this.value='...';" />
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="coefrevision" key="exmnid"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_ne_exmnid" /><input type="button" value="..." class="clickbutton"
								onclick="showExamineInfo();this.value='...';" />
                    
                </td>
            </tr>
            <tr>
            	<td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="coefrevision" key="_snl_exmnperiod"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_snl_exmnperiod" onclick="this.value=selectDateYYYYMM(this.value);" readonly="true"></html:text>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="coefrevision" key="_snm_exmnperiod"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_snm_exmnperiod" onclick="this.value=selectDateYYYYMM(this.value);" readonly="true"></html:text>
                </td>
            </tr>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                            <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/examine/coefrevision.do')">
                            <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/examine/coefrevision.do')">
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
                <td title="<bean:message bundle="public" key="list_title_select"/>">
                    <input type="checkbox" name="allbox" onclick="checkAll();" class="table_checkbox">
                </td>
                <td>
                    <a href="javascript:doOrderby('seqid')"><bean:message bundle="coefrevision" key="seqid"/></a>
                    <s:OrderImg form="/cms/examine/coefrevision/CoefrevisionForm" field="seqid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('wayid')"><bean:message bundle="coefrevision" key="wayid"/></a>
                    <s:OrderImg form="/cms/examine/coefrevision/CoefrevisionForm" field="wayid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('wayid')"><bean:message bundle="coefrevision" key="wayid1"/></a>
                    <s:OrderImg form="/cms/examine/coefrevision/CoefrevisionForm" field="wayid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('exmnid')"><bean:message bundle="coefrevision" key="exmnname"/></a>
                    <s:OrderImg form="/cms/examine/coefrevision/CoefrevisionForm" field="exmnid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('exmnperiod')"><bean:message bundle="coefrevision" key="exmnperiod"/></a>
                    <s:OrderImg form="/cms/examine/coefrevision/CoefrevisionForm" field="exmnperiod"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('coefficient')"><bean:message bundle="coefrevision" key="coefficient"/></a>
                    <s:OrderImg form="/cms/examine/coefrevision/CoefrevisionForm" field="coefficient"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/examine/coefrevision.do?CMD=EDIT" var="urlContent">
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
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.seqid}"/></a>
                     </td>
                     <td><c:out value="${item.wayid}"/></td>
                     <td><s:Code2Name definition="#WAY" code="${item.wayid}"/></td>
                     <td><s:Code2Name definition="#EXAMINE" code="${item.exmnid}"/></td>
                    
                     <td><c:out value="${item.exmnperiod}"/></td>
                     <td><c:out value="${item.coefficient}"/></td>
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
