<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
    String ID_PROVINCE = "CH_B2M_REWARD_PROVINCIAL";
    String ID_CITY = "CH_B2M_REWARD_CIVIC";
%>
<html>
<head>
    <title><bean:message bundle="vstdreward" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_sk_rewardname', '<bean:message bundle="vstdreward" key="rewardname"/>', 'c', true, '40');
            addfield('_se_opnid', '<bean:message bundle="vstdreward" key="opnid"/>', 'c', true, '18');
            addfield('_se_region', '<bean:message bundle="vstdreward" key="region"/>', 'c', true, '10');
            addfield('_ne_ossrc', '<bean:message bundle="vstdreward" key="ossrc"/>', 'f', true, '2');
            addfield('_dnl_startdate', '<bean:message bundle="vstdreward" key="startdate"/>', 't', true, '7');
            addfield('_dnm_stopdate', '<bean:message bundle="vstdreward" key="stopdate"/>', 't', true, '7');
            return checkval(window);
        }
        function getOpnId() {
			var arg = new Array();
			var strUrl ="<%=contextPath%>/cms/bbc/operation.do?CMD=SELECT";
			return window.showModalDialog(strUrl,arg,"dialogWidth:600px; dialogHeight:390px; status:no;resizable:yes;");
		}
		function doExcel()
		{
			 var url="<%=contextPath%>/cms/bbc/vstdreward.do?CMD=EXCEL";
			 document.formList.action=url;
			 document.formList.submit();
			 document.formList.action="<%=contextPath%>/cms/bbc/vstdreward.do?CMD=LIST";
		}
		
		function doReturnIndex(){
           self.location='<%=contextPath%>/cms/bbc/operation.do?CMD=LIST';
        }
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/bbc/vstdreward.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/bbc/VstdrewardForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="vstdreward" key="titleList"/>
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
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="vstdreward" key="rewardname"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_sk_rewardname"></html:text>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="vstdreward" key="opnid"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text  property="_se_opnid" styleClass="form_input_1x"/>
					<input type="button" value="..." class="clickbutton"
										onclick="_se_opnid.value=getOpnId();">
                </td>
            </tr>
            <tr>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="vstdreward" key="region"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:select property="_se_region">
                    	<option />
                    	<s:Options definition="$region"/>
                    </html:select>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="vstdreward" key="ossrc"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:select property="_ne_ossrc">
                    	<option/>
                    	<html:option value="0">社会渠道代理商</html:option>
                    	<html:option value="1">网盟</html:option>
                    	<html:option value="3">全员代理</html:option>
                    	<html:option value="4">新数据业务</html:option>
                    </html:select>
                </td>
            </tr>
            <tr>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="vstdreward" key="startdate"/>>=</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnl_startdate" onclick="this.value=selectDate()"></html:text>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="vstdreward" key="startdate"/><=</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnm_startdate"  onclick="this.value=selectDate()"></html:text>
                </td>
            </tr>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                        <s:RewardPurChk controlid="CH_B2M_REWARD_PROVINCIAL||CH_B2M_REWARD_CIVIC">
                        <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/bbc/vstdreward.do')">
                        </s:RewardPurChk>
                        <input type="button" class="query" onmouseover="buttonover(this);" onclick="doQuery();"
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_search"/>" />
                        <input type="button" name="btExcel" class="query" onmouseover="buttonover(this);" onclick="doExcel();"
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_export"/>" />
                        <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="返回" class="close"
                           onclick="doReturnIndex()">
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
                    <a href="javascript:doOrderby('rewardid')"><bean:message bundle="vstdreward" key="rewardid"/></a>
                    <s:OrderImg form="/cms/bbc/vstdreward/VstdrewardForm" field="rewardid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('rewardname')"><bean:message bundle="vstdreward" key="rewardname"/></a>
                    <s:OrderImg form="/cms/bbc/vstdreward/VstdrewardForm" field="rewardname"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('opnid')"><bean:message bundle="vstdreward" key="opnid"/></a>
                    <s:OrderImg form="/cms/bbc/vstdreward/VstdrewardForm" field="opnid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('region')"><bean:message bundle="vstdreward" key="region"/></a>
                    <s:OrderImg form="/cms/bbc/vstdreward/VstdrewardForm" field="region"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('ossrc')"><bean:message bundle="vstdreward" key="ossrc"/></a>
                    <s:OrderImg form="/cms/bbc/vstdreward/VstdrewardForm" field="ossrc"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('rewardtype')"><bean:message bundle="vstdreward" key="rewardtype"/></a>
                    <s:OrderImg form="/cms/bbc/vstdreward/VstdrewardForm" field="rewardtype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('intvmonth')"><bean:message bundle="vstdreward" key="intvmonth"/></a>
                    <s:OrderImg form="/cms/bbc/vstdreward/VstdrewardForm" field="intvmonth"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('rewardstd')"><bean:message bundle="vstdreward" key="rewardstd"/></a>
                    <s:OrderImg form="/cms/bbc/vstdreward/VstdrewardForm" field="rewardstd"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('startdate')"><bean:message bundle="vstdreward" key="startdate"/></a>
                    <s:OrderImg form="/cms/bbc/vstdreward/VstdrewardForm" field="startdate"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('stopdate')"><bean:message bundle="vstdreward" key="stopdate"/></a>
                    <s:OrderImg form="/cms/bbc/vstdreward/VstdrewardForm" field="stopdate"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('acctype')"><bean:message bundle="vstdreward" key="acctype"/></a>
                    <s:OrderImg form="/cms/bbc/vstdreward/VstdrewardForm" field="acctype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('ruleid')"><bean:message bundle="vstdreward" key="ruleid"/></a>
                    <s:OrderImg form="/cms/bbc/vstdreward/VstdrewardForm" field="ruleid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('memo')"><bean:message bundle="vstdreward" key="memo"/></a>
                    <s:OrderImg form="/cms/bbc/vstdreward/VstdrewardForm" field="memo"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
            	<c:url value="/cms/bbc/vstdreward.do?CMD=SHOW" var="urlContent">
						<c:param name="PK" value="${item.rewardid}|${item.region}|${item.ossrc}|${item.opnid}"/>
				</c:url>
            	<%-- liuchao
                 <c:url value="/cms/bbc/vstdreward.do?CMD=EDIT" var="urlContent"> --%>
                     <%//this param name must "PK" %>
                     <%--  <c:param name="PK" value="${item.rewardid}"/> --%>
                <%-- liuchao      <c:param name="PK" value="${item.rewardid}|${item.region}|${item.ossrc}|${item.opnid}"/>
                 </c:url> --%>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.rewardid}|${item.region}|${item.ossrc}|${item.opnid}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td>
                      <c:choose>
                         <c:when test="${item.region=='999'}">
                            <s:RewardPurChk controlid="CH_B2M_REWARD_PROVINCIAL||CH_B2M_REWARD_CIVIC" disableChild="true">
	                          <a href='<c:out value="${urlContent}"/>'><c:out value="${item.rewardid}"/></a>
	                        </s:RewardPurChk>
                         </c:when>
                         <c:otherwise>
                             <s:RewardPurChk controlid="CH_B2M_REWARD_CIVIC" disableChild="true">
	                          <a href='<c:out value="${urlContent}"/>'><c:out value="${item.rewardid}"/></a>
	                        </s:RewardPurChk>
                         </c:otherwise>
                   	  </c:choose>
                     </td>
                     <td><c:out value="${item.rewardname}"/></td>
                     <td>
                     <s:Code2Name definition="#BBC_OPERATION" code="${item.opnid}"  />
                     </td>
                     <td>
                     <s:Code2Name definition="$region" code="${item.region}"  />
                     </td>
                     <td>
                     	<c:choose>
                        <c:when test="${item.ossrc==0}">
                        	社会渠道代理商
                        </c:when>
                        <c:when test="${item.ossrc==1}">
                        	网盟
                        </c:when>
                        <c:when test="${item.ossrc==3}">
                        	全员代理
                        </c:when>
                        <c:otherwise>
                        	<c:out value="${item.ossrc}" />
                        </c:otherwise>
                        </c:choose>
                     </td>
                     <td>
                     <s:Code2Name definition="$CH_BBCREWARDTYPE" code="${item.rewardtype}"  />
                     </td>
                     <td><c:out value="${item.intvmonth}"/></td>
                     <td><c:out value="${item.rewardstd}"/></td>
                     <td>
                     <fmt:formatDate pattern="yyyy-MM-dd" value="${item.startdate}" />
                     </td>
                     <td> <fmt:formatDate pattern="yyyy-MM-dd" value="${item.stopdate}" />
                     </td>
                     <td> 
                     <s:Code2Name definition="$CH_ACCTYPE" code="${item.acctype}"  />
                     </td>
                     <td> 
                     <s:Code2Name definition="#CH_ADT_RULE" code="${item.ruleid}"  />
                     </td>
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
