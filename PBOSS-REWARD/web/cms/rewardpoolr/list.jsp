<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
   String ID_1 = "CH_PW_REWARD||CH_PW_REWARD_PROVINCIAL||CH_PW_REWARD_CIVIC";
   String ID_2 = "CH_PW_REWARD||CH_PW_REWARD_VIEW";
%>
<html>
<head>
    <title><bean:message bundle="rewardpoolr" key="titleList"/></title>
    <script type="text/javascript"
			src="<%=contextPath%>/js/bus/waycommon.js"></script>
		<script type="text/javascript"
			src="<%=contextPath%>/js/bus/rescommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_ne_rewardtype', '<bean:message bundle="rewardpoolr" key="rewardtype"/>', 'f', true, '5');
            addfield('_se_region', '<bean:message bundle="rewardpoolr" key="region"/>', 'c', true, '10');
            addfield('_dnl_startdate', '<bean:message bundle="rewardpoolr" key="startdate"/>', 't', true, '25');
            addfield('_dnm_stopdate', '<bean:message bundle="rewardpoolr" key="stopdate"/>', 't', true, '25');
            return checkval(window);
        }
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/rewardpoolr.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
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
    			<bean:message bundle="rewardpoolr" key="titleList"/>
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
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="rewardpoolr" key="rewardtype"/>:</td>
                <td class="form_table_left">
                     <html:select property="_ne_rewardtype">
									<option />
										<s:Options definition="$CH_REWARDTYPE" />
					</html:select>
                </td>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="rewardpoolr" key="region"/>:</td>
                <td class="form_table_left">
				<c:choose>
					<c:when test="${showCityList eq '1'}">
						<html:select property="_se_region">
													 <html:option value=""></html:option>
		                        		  			  <s:Options definition="$region"/>
		                        					  </html:select>
					</c:when>
					<c:otherwise>
						<html:select property="_se_region" disabled="true">
													 <html:option value=""></html:option>
		                        		  			  <s:Options definition="$region"/>
		                        					  </html:select>
					</c:otherwise>
				</c:choose>
                </td>
            </tr>
            <tr>
          	    <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="rewardpoolr" key="startdate"/>:</td>
                <td class="form_table_left">
			<html:text styleClass="form_input_1x" property="_dnl_startdate"
									onclick="this.value=selectDate();" readonly="true"></html:text>
                </td>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="rewardpoolr" key="stopdate"/>:</td>
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
                            <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/rewardpoolr.do')">
                        </s:RewardPurChk>
                        <s:RewardPurChk controlid="<%=ID_1%>">
                            <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/rewardpoolr.do')">
                        </s:RewardPurChk>
                        <s:PurChk controlid="<%=ID_1%>">
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
                   <a href="javascript:doOrderby('rewardtype')"><bean:message bundle="rewardpoolr" key="rewardtype"/></a>
                   <s:OrderImg form="/cms/rewardpoolr/RewardpoolrForm" field="rewardtype" />
                </td>
                <td>
                    <a href="javascript:doOrderby('region')"><bean:message bundle="rewardpoolr" key="region"/></a>
                    <s:OrderImg form="/cms/rewardpoolr/RewardpoolrForm" field="region" />
                </td>
<!--                <td>-->
<!--                    <a href="javascript:doOrderby('slv')"><bean:message bundle="rewardpoolr" key="slv"/></a>-->
<!--                    <s:OrderImg form="/cms/rewardpoolr/RewardpoolrForm" field="slv" />-->
<!--                </td>-->
                <td>
                   <bean:message bundle="rewardpoolr" key="startdate"/>
                 
                </td>
                <td>
                  <bean:message bundle="rewardpoolr" key="stopdate"/>
                    
                </td>
                <td>
                   <bean:message bundle="rewardpoolr" key="memo"/>
                   
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/rewardpoolr.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.region}|${item.rewardtype}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.region}|${item.rewardtype}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><s:Code2Name code="${item.rewardtype}"
											definition="$CH_REWARDTYPE" /></a>
                     </td>
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><s:Code2Name code="${item.region}" definition="$region" /></a>
                     </td>
                     
<!--                     <td><c:out value="${item.slv}"/></td>-->
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
