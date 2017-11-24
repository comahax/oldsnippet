<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
	String ID_1 = "CH_PW_REWARD||CH_PW_REWARD_PROVINCIAL";//省级酬金管理令牌
	String ID_2 = "CH_PW_REWARD||CH_PW_REWARD_CIVIC";//市级酬金管理令牌
%>
<html>
<head>
    <title><bean:message bundle="stdrewardhz" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_ne_rewardid', '<bean:message bundle="stdrewardhz" key="rewardid"/>', 'f', true, '14');
            addfield('_sk_rewardname', '<bean:message bundle="stdrewardhz" key="rewardname"/>', 'c', true, '40');
            addfield('_dnl_startdate', '<bean:message bundle="stdrewardhz" key="startdate"/>', 't', true, '25');
            addfield('_dnm_startdate', '<bean:message bundle="stdrewardhz" key="startdate"/>', 't', true, '25');
            addfield('_dnl_stopdate', '<bean:message bundle="stdrewardhz" key="stopdate"/>', 't', true, '25');
            addfield('_dnm_stopdate', '<bean:message bundle="stdrewardhz" key="stopdate"/>', 't', true, '25');
            if(date_compare('_dnl_startdate','_dnm_startdate','执行时间设置有误')) return;
            if(date_compare('_dnl_stopdate','_dnm_stopdate','结束时间设置有误')) return;
            return checkval(window);
        }
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/stdrewardhz.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
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
    			<bean:message bundle="stdrewardhz" key="titleList"/>
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
    			<td width="20%" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="stdrewardhz" key="rewardid"/>:
            	</td>
            	<td width="30%" class="form_table_left">
               		<html:text styleClass="form_input_1x" property="_ne_rewardid" />
            	</td>
    			<td width="20%" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="stdrewardhz" key="rewardname"/>:
            	</td>
            	<td width="30%" class="form_table_left">
               	 	<html:text styleClass="form_input_1x" property="_sk_rewardname" />
            	</td>
            </tr>
            <tr>
    			<td width="20%" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="stdrewardhz" key="startdate"/>&gt;=
            	</td>
            	<td width="30%" class="form_table_left">
               		<html:text styleClass="form_input_1x" property="_dnl_startdate" onclick="this.value=selectDate()"/>
            	</td>
    			<td width="20%" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="stdrewardhz" key="startdate"/>&lt;=
            	</td>
            	<td width="30%" class="form_table_left">
               	 	<html:text styleClass="form_input_1x" property="_dnm_startdate" onclick="this.value=selectDate()" />
            	</td>
            </tr>
            <tr>
    			<td width="20%" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="stdrewardhz" key="stopdate"/>&gt;=
            	</td>
            	<td width="30%" class="form_table_left">
               		<html:text styleClass="form_input_1x" property="_dnl_stopdate" onclick="this.value=selectDate()"/>
            	</td>
    			<td width="20%" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="stdrewardhz" key="stopdate"/>&lt;=
            	</td>
            	<td width="30%" class="form_table_left">
               	 	<html:text styleClass="form_input_1x" property="_dnm_stopdate" onclick="this.value=selectDate()" />
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
                            value="<bean:message bundle="public" key="button_new"/>" onClick="javascript:window.location.href='<%=contextPath%>/cms/stdrewardhz/frame.jsp'"/>
                        </s:RewardPurChk>
                        <s:RewardPurChk controlid="<%=ID_1%>">
                            <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/stdrewardhz.do')"> 
                        </s:RewardPurChk>
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
                    <a href="javascript:doOrderby('rewardid')"><bean:message bundle="stdrewardhz" key="rewardid"/></a>
                    <s:OrderImg form="/cms/stdrewardhz/stdrewardhzForm" field="rewardid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('rewardname')"><bean:message bundle="stdrewardhz" key="rewardname"/></a>
                    <s:OrderImg form="/cms/stdrewardhz/stdrewardhzForm" field="rewardname"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('startdate')"><bean:message bundle="stdrewardhz" key="startdate"/></a>
                    <s:OrderImg form="/cms/stdrewardhz/stdrewardhzForm" field="startdate"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('stopdate')"><bean:message bundle="stdrewardhz" key="stopdate"/></a>
                    <s:OrderImg form="/cms/stdrewardhz/stdrewardhzForm" field="stopdate"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('memo')"><bean:message bundle="stdrewardhz" key="memo"/></a>
                    <s:OrderImg form="/cms/stdrewardhz/stdrewardhzForm" field="memo"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/stdrewardhz/frame.jsp" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.rewardid}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.rewardid}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td><a href='<c:out value="${urlContent}"/>'><c:out value="${item.rewardid}"/></a></td>
                     <td><c:out value="${item.rewardname}"/></td>
                     <td><fmt:formatDate pattern="yyyy-MM-dd" value="${item.startdate}" /></td>
                     <td><fmt:formatDate pattern="yyyy-MM-dd" value="${item.stopdate}" /></td>
                     <td><c:out value="${item.memo}"/></td>
                 </tr>
             </c:forEach>
        </table>
   </div>
   <div class="table_div">
		<s:PageNav dpName="LIST"/>
   </div>
</html:form>
</div>
</body>
</html>
