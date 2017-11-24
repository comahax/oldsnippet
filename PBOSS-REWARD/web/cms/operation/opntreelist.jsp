<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
    String ID_1 = "CH_PW_REWARD||CH_PW_REWARD_PROVINCIAL";
%>
<html>
<head>
    <title>全省统一业务分类树管理</title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            return checkval(window);
        }
        
        function doDel(cmdDelete){
        		var sis = formList.all("_selectitem");
        		var TO = true;
        		if (forincheck(TO,sis,msgConfirmDelete)){
        		formList.action = addParam(contextPath + cmdDelete, 'CMD', 'Deleteopntree');
    			formList.submit();
    			}
        }
        function doImport(url){
			formList.action = contextPath + url + "?CMD=IMPORT";
       		formList.submit();
		}
		
		function showtree(){
		var url = contextPath + "/cms/operation.do?CMD=Selectopntree2&style=nobusi";
		window.showModalDialog(url, "", "dialogWidth=680px;dialogHeight=430px;status:no;scroll=yes;");
		}
		
		function saveDB(){
			 var vl = document.getElementsByName("_se_parentid")[0].value;
			 if(vl == ''){
			   alert("请选择上级编码!");
			 }else{
				document.forms[0].action='cms/operation.do?CMD=Newtopntree';
				document.forms[0].submit();
			}		
		}
		
		
		
    </script>
    <script type="text/javascript" src="<%= contextPath %>/js/bus/waycommon.js"></script>
	<script type="text/javascript" src="<%= contextPath %>/js/baseframe.js"></script>
	<script type="text/javascript" src="<%= contextPath%>/js/bus/rescommon.js"></script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/operation.do?CMD=queryallsubopn" styleId="formList" method="post" onsubmit="return ev_check();">
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
    			全省统一业务分类树管理
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
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="operation" key="_se_opnid"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_opnid"></html:text>
                </td>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="operation" key="_sk_name"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_sk_name"></html:text>
                </td>
              
            </tr>
            <tr>
              <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="operation" key="parentid"/>:</td>
                <td class="form_table_left"> 
               <!-- <input type="text" id="_se_parentid" name="_se_parentid" value='<c:out value="${requestScope._se_parentid}"/>"  />-->
                     <html:text styleClass="form_input_1x" property="_se_parentid" readonly="true"></html:text> 
                </td> 
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="operation" key="opnlevel"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_ne_opnlevel"></html:text>
                </td>
            </tr>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                        <s:RewardPurChk controlid="<%=ID_1%>">
                            <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_new"/>" onClick="saveDB();">
                        </s:RewardPurChk>
                        <s:RewardPurChk controlid="<%=ID_1%>">
                            <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDel('/cms/operation.do')">
                        </s:RewardPurChk>
                        <input type="button" class="query"onmouseover="buttonover(this);" onclick="doQuery();" 
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_search"/>" />
                       	<input type="button" class="button_2" onmouseover="buttonover(this);"
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="预览" onclick="showtree();"/>
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
                    <a href="javascript:doOrderby('opnid')"><bean:message bundle="operation" key="opnid"/></a>
                    <s:OrderImg form="/cms/operation/operationForm" field="opnid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('name')"><bean:message bundle="operation" key="name"/></a>
                    <s:OrderImg form="/cms/operation/operationForm" field="name"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('businesstype')"><bean:message bundle="operation" key="businesstype"/></a>
                    <s:OrderImg form="/cms/operation/operationForm" field="businesstype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('state')"><bean:message bundle="operation" key="state"/></a>
                    <s:OrderImg form="/cms/operation/operationForm" field="state"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/operation.do?CMD=Edittopntree" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.opnid}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.opnid}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.opnid}"/></a>
                     </td>
                     <td><c:out value="${item.name}"/></td>
                     <td><s:Code2Name code="${item.parentid}" definition="#OPERATION"/>-<c:out value="${item.parentid }"/></td>
                     <td><s:Code2Name code="${item.state}" definition="$CH_VALIDFLAG"/></td>
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
