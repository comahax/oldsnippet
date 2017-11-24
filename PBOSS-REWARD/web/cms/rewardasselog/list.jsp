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
    <title><bean:message bundle="rewardasselog" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            return checkval(window);
        }
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/rewardasselog.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
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
    			<bean:message bundle="rewardasselog" key="titleList"/>
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
            	<td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="rewardasselog" key="wayid"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_wayid" onclick="showSelectWay(this,'_se_wayid')" readonly="true"></html:text>
                </td>
                <td width="126" height="20" align="right" class="form_table_right" >>=<bean:message bundle="rewardasselog" key="optime"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnl_optime" onclick="this.value=selectDate();"></html:text>
                </td>
                <td width="126" height="20" align="right" class="form_table_right" ><=<bean:message bundle="rewardasselog" key="optime"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnm_optime" onclick="this.value=selectDate();"></html:text>
                </td>
                
            </tr>
            <tr>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="rewardasselog" key="success"/>:</td>
                <td class="form_table_left">
                    <html:select property="_se_success">
									<option></option>
									<s:Options definition="$OPRRESULT" />
								</html:select>
                </td>
    			<td width="80" height="20" align="right" class="form_table_right" >
                	&nbsp;
            	</td>
            	<td class="form_table_left">
               	 &nbsp;
            	</td>
    			<td width="80" height="20" align="right" class="form_table_right" >
                	&nbsp;
            	</td>
            	<td class="form_table_left">
               	 &nbsp;
            	</td>
            </tr>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                        <s:PurChk controlid="<%=ID_3%>">
                        <input type="button" class="query"onmouseover="buttonover(this);" onclick="doQuery();" 
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_search"/>" />
                        </s:PurChk>
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
                    <a href="javascript:doOrderby('logid')"><bean:message bundle="rewardasselog" key="logid"/></a>
                    <s:OrderImg form="/cms/rewardasselog/rewardasselogForm" field="logid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('optime')"><bean:message bundle="rewardasselog" key="optime"/></a>
                    <s:OrderImg form="/cms/rewardasselog/rewardasselogForm" field="optime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('oprcode')"><bean:message bundle="rewardasselog" key="oprcode"/></a>
                    <s:OrderImg form="/cms/rewardasselog/rewardasselogForm" field="oprcode"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('oprtype')"><bean:message bundle="rewardasselog" key="oprtype"/></a>
                    <s:OrderImg form="/cms/rewardasselog/rewardasselogForm" field="oprtype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('success')"><bean:message bundle="rewardasselog" key="success"/></a>
                    <s:OrderImg form="/cms/rewardasselog/rewardasselogForm" field="success"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('wayid')"><bean:message bundle="rewardasselog" key="wayid"/></a>
                    <s:OrderImg form="/cms/rewardasselog/rewardasselogForm" field="wayid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('assemonth')"><bean:message bundle="rewardasselog" key="assemonth"/></a>
                    <s:OrderImg form="/cms/rewardasselog/rewardasselogForm" field="assemonth"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('rewardtype')"><bean:message bundle="rewardasselog" key="rewardtype"/></a>
                    <s:OrderImg form="/cms/rewardasselog/rewardasselogForm" field="rewardtype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('assegrade')"><bean:message bundle="rewardasselog" key="assegrade"/></a>
                    <s:OrderImg form="/cms/rewardasselog/rewardasselogForm" field="assegrade"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('memo')"><bean:message bundle="rewardasselog" key="memo"/></a>
                    <s:OrderImg form="/cms/rewardasselog/rewardasselogForm" field="memo"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/rewardasselog.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.logid}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.logid}' />"
                                onclick="checkOne(this);" class="table_checkbox">
                     </td>
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.logid}"/></a>
                     </td>
                     <td><c:out value="${item.optime}"/></td>
                     <td><c:out value="${item.oprcode}"/></td>
                     <td>
                     <s:Code2Name code="${item.oprtype}" definition="$OPRTYPE" />
                     </td>
                     <td><s:Code2Name code="${item.success}" definition="$OPRRESULT" /></td>
                     <td><c:out value="${item.wayid}"/></td>
                     <td><c:out value="${item.assemonth}"/></td>
                     <td><s:Code2Name code="${item.rewardtype}" definition="$CH_REWARDTYPE"/></td>
                     <td><c:out value="${item.assegrade}"/></td>
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
