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
    <title><bean:message bundle="costcard" key="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
    	function checkMonth()
        {
        	var msg1="[结算月份]长度为6位!";
        	var msg2="[结算月份]格式为[YYYYMM]";
        	var yyyymm=document.all("_se_calcmonth").value;
        	if(yyyymm.length!=6 && yyyymm!="")
        	{
        		alert(msg1);
        		return false;
        	}
        	if(yyyymm.substring(0,4)-0<0)
        	{
        	  alert(msg2);
        	  return false;
        	}
        	if(yyyymm.substring(4,6)*1-12>0 || yyyymm.substring(4,6)*1<0)
        	{
        	  alert(msg2);
        	  return false;
        	}
        	return true;
        }
        function ev_check() {
            addfield('_se_wayid', '<bean:message bundle="costcard" key="wayid"/>', 'c', true, '18');
            addfield('_se_calcmonth', '<bean:message bundle="costcard" key="calcmonth"/>', 'i', true, '8');
            addfield('_se_opnid', '<bean:message bundle="costcard" key="opnid"/>', 'c', true, '18');
            if(!checkMonth())
            {
            return false;
            }
            return checkval(window);
        }
        function doBatch(){
        	var url='cms/costcard.do?CMD=BATCH';
        	formList.action=url;
        	formList.submit();
        }
    </script>

</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/costcard.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
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
    			<bean:message bundle="costcard" key="titleList"/>
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
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="costcard" key="wayid"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_wayid"></html:text><input type="button" value="..." 
                    	class="clickbutton" onclick="showSelectWay3(this,'_se_wayid','','','AG');this.value='...';" />
                </td>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="costcard" key="calcmonth"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_calcmonth" maxlength="6"></html:text>
                </td>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="costcard" key="opnid"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_opnid"></html:text>
                    <input type="button" value="..." class="clickbutton" onclick="showOpnTree2(this, '_se_opnid' , 'busi' )">
                </td>
            </tr>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                      <%--  屏蔽新增按钮
                        <s:PurChk controlid="<%=ID_1%>">
                            <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/costcard.do')">
                        </s:PurChk>
                       --%> 
                        <s:PurChk controlid="<%=ID_3%>">
                        <input type="button" class="query" onmouseover="buttonover(this);" onclick="doQuery();" 
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_search"/>" />
                        </s:PurChk>
                        <input type="button" class="button_4" onmouseover="buttonover(this);" onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                              	value="<bean:message bundle="costcard" key="buttonBatch"/>" 
                                onclick="doBatch()"/>
                </td>
			</tr>
		</table>
	</div>

    <div class="table_div">
      <div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
                <td>
                    <a href="javascript:doOrderby('wayid')"><bean:message bundle="costcard" key="wayid"/></a>
                    <s:OrderImg form="/cms/costcard/costcardForm" field="wayid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('calcmonth')"><bean:message bundle="costcard" key="calcmonth"/></a>
                    <s:OrderImg form="/cms/costcard/costcardForm" field="calcmonth"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('opnid')"><bean:message bundle="costcard" key="opnid"/></a>
                    <s:OrderImg form="/cms/costcard/costcardForm" field="opnid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('salenum')"><bean:message bundle="costcard" key="salenum"/></a>
                    <s:OrderImg form="/cms/costcard/costcardForm" field="salenum"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/costcard.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.calcmonth}|${item.opnid}|${item.wayid}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                 	 <td>
                         <a href='<c:out value="${urlContent}"/>'>
                         <s:Code2Name definition="#WAY" code="${item.wayid}" />
                         </a>
                     </td>
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.calcmonth}"/></a>
                     </td>
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.opnid}"/></a>
                     </td>
                    
                     <td><c:out value="${item.salenum}"/></td>
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
