<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
 	String ID_1="CH_PW_REWARD||CH_PW_REWARD_PROVINCIAL";
	String ID_2="CH_PW_REWARD||CH_PW_REWARD_CIVIC||CH_PW_REWARD_PROVINCIAL";
%>
<html>
<head>
    <title><bean:message bundle="stdreward" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_ne_rewardid', '<bean:message bundle="stdreward" key="rewardid"/>', 'f', true, '14');
            addfield('_sk_rewardname', '<bean:message bundle="stdreward" key="rewardname"/>', 'c', true, '40');
            addfield('_dnl_startdate', '<bean:message bundle="stdreward" key="startdate"/>', 't', true, '25');
            addfield('_dnm_stopdate', '<bean:message bundle="stdreward" key="stopdate"/>', 't', true, '25');
            return checkval(window);
        }
	    function add(){
		var form=document.forms[0];
		form.action="<%=contextPath%>/cms/stdrewardbs.do?CMD=SHOWFRAME&truecmd=NEW";
		form.submit();
		}
    </script> 
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/stdrewardbs.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
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
    			<bean:message bundle="stdreward" key="titleList"/>
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
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="stdreward" key="rewardid"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_ne_rewardid"></html:text>
                </td>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="stdreward" key="rewardname"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_sk_rewardname"></html:text>
                </td>
                
            </tr>
            <tr>
            	<td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="stdreward" key="startdate"/>:</td>
                <td class="form_table_left">
                      	<html:text styleClass="form_input_1x" property="_dnl_startdate"
									onclick="this.value=selectDate();" readonly="true"></html:text>
                </td>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="stdreward" key="stopdate"/>:</td>
                <td class="form_table_left">
                    	<html:text styleClass="form_input_1x" property="_dnm_stopdate"
									onclick="this.value=selectDate();" readonly="true"></html:text>
                </td>
    			
            </tr>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                        <s:RewardPurChk controlid="<%=ID_1%>">
                           <input type="button" value="<bean:message bundle="stdrewardbs" key="add"/>" class="add" onclick="add();" 
                           onmouseover="buttonover(this)" onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)">     
                         </s:RewardPurChk>
                        <s:RewardPurChk controlid="<%=ID_1%>">
                            <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/stdrewardbs.do')"> 
                        </s:RewardPurChk>

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
                <td title="<bean:message bundle="public" key="list_title_select"/>">
                    <input type="checkbox" name="allbox" onclick="checkAll();" class="table_checkbox">
                </td>
                <td>
                  <a href="javascript:doOrderby('rewardid')"><bean:message bundle="stdreward" key="rewardid"/></a>
                  <s:OrderImg form="/cms/stdrewardbs/StdrewardbsForm" field="rewardid" />
                </td>
                <td>
                   <a href="javascript:doOrderby('rewardname')"><bean:message bundle="stdreward" key="rewardname"/></a>
                   <s:OrderImg form="/cms/stdrewardbs/StdrewardbsForm" field="rewardname" />
                </td>
                <td>
                   <bean:message bundle="stdreward" key="startdate"/>
                   
                </td>
                <td>
                    <bean:message bundle="stdreward" key="stopdate"/>
                   
                </td>
                <td>
                    <bean:message bundle="stdreward" key="memo"/>
                   
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/stdrewardbs.do?CMD=SHOWFRAME&truecmd=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.rewardid}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.rewardid}' />"
                                onclick="checkOne(this);" class="table_checkbox">
                     </td>
                     <td>
                     	<s:RewardPurChk controlid="<%=ID_2%>" disableChild="true"> 
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.rewardid}"/></a>
                        </s:RewardPurChk>
                     </td>
                     <td><c:out value="${item.rewardname}"/></td>
                     <td><fmt:formatDate pattern="yyyy-MM-dd" value="${item.startdate}"/></td>
                     <td><fmt:formatDate pattern="yyyy-MM-dd" value="${item.stopdate}"/></td>
                     <td><c:out value="${item.memo}"/></td>
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
