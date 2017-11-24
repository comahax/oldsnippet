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
    <title><bean:message bundle="rewardsms" key="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
    <script type="text/javascript" src="<%=contextPath%>/js/aa.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            
            return checkval(window);
        }
        function doSendtest(){
			var officetel = document.getElementById('officetel').value;
			if (officetel == '') {
				alert('短信下发测试号码 不能为空');
		        return false;
			}
			if (officetel.length != 11) {
				alert('短信下发测试号码 必须是11为的手机号');
		        return false;
			} 
        	//var form=document.forms[0];
			ajaxAnywhere.submitByURL("/cms/rewardsms.do?CMD=SENDTEST&no="+officetel); 
		}
		function doQuery(){
			resetPage();
			var form=document.forms[0];
			form.action="<%=contextPath%>/cms/rewardsms.do?CMD=LIST";
			form.submit();
		}
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/rewardsms.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
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
    			<bean:message bundle="rewardsms" key="titleList"/>
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
	        	<td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="rewardsms" key="officetel"/>:</td>
	            <td width="30%" class="form_table_left">
	                <html:text styleClass="form_input_1x" property="officetel" ></html:text>
	            </td>
	            <td  width="50%" height="20" align="right" class="form_table_right">
         		    <input type="button" name="btnSend" class="button_4" onmouseover="buttonover(this);"
                         onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                         value="测试发送" onClick="doSendtest();">
	            </td>
	            
            </tr>
      	</table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                        <s:PurChk controlid="<%=ID_3%>">
                        <input type="button" class="query" onmouseover="buttonover(this);" onclick="doQuery();"
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_search"/>" />
                        </s:PurChk>
                        <s:PurChk controlid="<%=ID_1%>">
                            <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/rewardsms.do')">
                        </s:PurChk>
                        <s:PurChk controlid="<%=ID_2%>">
                            <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/rewardsms.do')">
                        </s:PurChk>
                </td>
			</tr>
		</table>
	</div>
	<table width="100%" class="error_text">
    	酬金结果短信系统为处理任务
    </table>
    <div class="table_div">
      <div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
                <td title="<bean:message bundle="public" key="list_title_select"/>">
                    <input type="checkbox" name="allbox" onclick="checkAll();" class="table_checkbox">
                </td>
                <td>
                    <a href="javascript:doOrderby('seq')"><bean:message bundle="rewardsms" key="seq"/></a>
                    <s:OrderImg form="/cms/rewardsms/RewardsmsForm" field="seq"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('countyid')"><bean:message bundle="rewardsms" key="countyid"/></a>
                    <s:OrderImg form="/cms/rewardsms/RewardsmsForm" field="countyid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('sendtime')"><bean:message bundle="rewardsms" key="sendtime"/></a>
                    <s:OrderImg form="/cms/rewardsms/RewardsmsForm" field="sendtime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('calcmonth')"><bean:message bundle="rewardsms" key="calcmonth"/></a>
                    <s:OrderImg form="/cms/rewardsms/RewardsmsForm" field="calcmonth"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('opercode')"><bean:message bundle="rewardsms" key="opercode"/></a>
                    <s:OrderImg form="/cms/rewardsms/RewardsmsForm" field="opercode"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('opertime')"><bean:message bundle="rewardsms" key="opertime"/></a>
                    <s:OrderImg form="/cms/rewardsms/RewardsmsForm" field="opertime"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/rewardsms.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.seq}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.seq}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.seq}"/></a>
                     </td>
                     <td><s:Code2Name code="${item.countyid}" definition="#CNTYCOMPANY"/></td>
                     <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.sendtime}" /></td>
                     <td><c:out value="${item.calcmonth}"/></td>
                     <td><c:out value="${item.opercode}"/></td>
                     <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.opertime}" /></td>
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
