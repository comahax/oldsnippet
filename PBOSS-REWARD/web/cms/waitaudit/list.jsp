<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%@ taglib uri="/WEB-INF/commons" prefix="s" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%
    String ID_AUDIT = "CH_PW_WAITAUDIT_AUDIT";
    String ID_REWARDAUDIT = "CH_PW_REWARD_ADJUST||CH_PW_REWARD";
    String ID_B2MAUDIT = "CH_B2M_REWARD_ADJAUDIT||CH_B2M_REWARD";
    String ID_WAYSTARMONTHAUDIT = "CH_PW_WAITAUDIT_AUDIT||CH_PW_REWARD";
    String ID_3 = "00010703";
    String ID_4 = "00010704";
%>
<html>
<head>
    <title><bean:message bundle="waitaudit" key="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_ne_taskid', '<bean:message bundle="waitaudit" key="taskid"/>', 'f', true, '10');
            addfield('_ne_subsystem', '<bean:message bundle="waitaudit" key="subsystem"/>', 'f', true, '2');
            addfield('_ne_taskstate', '<bean:message bundle="waitaudit" key="taskstate"/>', 'f', true, '2');
            addfield('_se_oprcode', '<bean:message bundle="waitaudit" key="oprcode"/>', 'c', true, '15');
            addfield('_se_wayid', '<bean:message bundle="waitaudit" key="wayid"/>', 'c', true, '18');
            addfield('_dnl_createtime', '<bean:message bundle="waitaudit" key="createtime"/>', 'dt', true, '25');
            addfield('_dnm_createtime', '<bean:message bundle="waitaudit" key="createtime"/>', 'dt', true, '25');
            addfield('_se_auditoprcode', '<bean:message bundle="waitaudit" key="auditoprcode"/>', 'c', true, '15');
            addfield('_se_auditwayid', '<bean:message bundle="waitaudit" key="auditwayid"/>', 'c', true, '18');
            addfield('_dnl_audittime', '<bean:message bundle="waitaudit" key="audittime"/>', 'dt', true, '25');
            addfield('_dnm_audittime', '<bean:message bundle="waitaudit" key="audittime"/>', 'dt', true, '25');
            return checkval(window);
        }
        function doAudit(cmd)
        {	
        	formList.action=cmd;
        	formList.submit();
        	formList.action="<%=contextPath%>/cms/waitaudit.do?CMD=LIST";
        }
        function doDisable(cmd)
        {
        	if(confirm('确实要作废当前批次的所有酬金调整记录吗？'))
        	{
        	formList.action=cmd;
        	formList.submit();
        	}
        	formList.action="<%=contextPath%>/cms/waitaudit.do?CMD=LIST";
        }
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/waitaudit.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
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
    			<bean:message bundle="waitaudit" key="titleList"/>
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
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="waitaudit" key="taskid"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_ne_taskid"></html:text>
                </td>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="waitaudit" key="subsystem"/>:</td>
                <td class="form_table_left">
                    <html:select property="_ne_subsystem">
                    	<html:options  collection="AUDITOPTION" property="value" labelProperty="label"/> 
                    </html:select>
                </td>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="waitaudit" key="taskstate"/>:</td>
                <td class="form_table_left">
                    <html:select property="_ne_taskstate">
                    	<option />
                    	<s:Options definition="$CH_AUDITSTATUS" />
                    </html:select>
                </td>
            </tr>
            <tr>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="waitaudit" key="oprcode"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_oprcode"></html:text>
                </td>
                 <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="waitaudit" key="createtime"/>&gt;=</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnl_createtime" onclick="this.value=selectDatetime()"></html:text>
                </td>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="waitaudit" key="createtime"/>&lt;=</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnm_createtime" onclick="this.value=selectDatetime()"></html:text>
                </td>
            </tr>
            <tr>
            	<td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="waitaudit" key="wayid"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_wayid" onclick="showSelectWay(_se_wayid)"></html:text>
                </td>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="waitaudit" key="auditwayid"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_auditwayid" onclick="showSelectWay(_se_auditwayid)"></html:text>
                </td>
                <td width="80" height="20" align="right" class="form_table_right" >
                	&nbsp;
            	</td>
            	<td class="form_table_left">
               		&nbsp;
            	</td>
            </tr>
            <tr>
            	<td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="waitaudit" key="auditoprcode"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_auditoprcode"></html:text>
                </td>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="waitaudit" key="audittime"/>&gt;=</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnl_audittime" onclick="this.value=selectDatetime()"></html:text>
                </td>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="waitaudit" key="audittime"/>&lt;=</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnm_audittime" onclick="this.value=selectDatetime()"></html:text>
                </td>
             </tr>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                        <%-- 
                        <s:PurChk controlid="<%=ID_1%>">
                            <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/waitaudit.do')">
                        </s:PurChk>
                        <s:PurChk controlid="<%=ID_2%>">
                            <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/waitaudit.do')">
                        </s:PurChk>
                        <a href='<c:out value="${editurl}"/>'>
							<c:out value="${item.wayid}" />
						</a>
                       --%>
                        <s:PurChk controlid="<%=ID_3%>">
                        <input type="submit" class="query"onmouseover="buttonover(this);"
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
                <td title="审核">
                    &nbsp;
                </td>
                <td>
                    <bean:message bundle="waitaudit" key="taskid"/>
                </td>
                <td>
                    <bean:message bundle="waitaudit" key="filecode"/>
                </td>
                <td>
					<bean:message bundle="waitaudit" key="subsystem"/>
                </td>
                <td>
					<bean:message bundle="waitaudit" key="logfile"/>
                </td>
                <td>
					<bean:message bundle="waitaudit" key="taskstate"/>
                </td>
                <td>
                   <bean:message bundle="waitaudit" key="oprcode"/>
                </td>
                <td>
                   <bean:message bundle="waitaudit" key="wayid"/>
                </td>
                <td>
                    <bean:message bundle="waitaudit" key="createtime"/>
                </td>
                <td>
                    <bean:message bundle="waitaudit" key="auditoprcode"/>
                </td>
                <td>
                    <bean:message bundle="waitaudit" key="auditwayid"/>
                </td>
                <td>
                    <bean:message bundle="waitaudit" key="audittime"/>
                </td>
                <td>
                    <bean:message bundle="waitaudit" key="totalcount"/>
                </td>
                <td>
                    <bean:message bundle="waitaudit" key="currentcount"/>
                </td>
                <td>
                    <bean:message bundle="waitaudit" key="successcount"/>
                </td>
                <td>
                    <bean:message bundle="waitaudit" key="resultfile"/>
                </td>
                 <td>
                    <bean:message bundle="waitaudit" key="errorfile"/>
                </td>
                <td>
                    <bean:message bundle="waitaudit" key="memo"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/waitaudit.do?CMD=EDIT" var="urlContent">
                     <c:param name="PK" value="${item.taskid}"/>
                 </c:url>
                 <c:url value="/cms/waitaudit.do?CMD=DISABLE" var="urlContent2">
                     <c:param name="PK" value="${item.taskid}"/>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                     <c:choose>
                     	<c:when test="${item.taskstate==0 }">
                     		<c:if test="${sessionScope['_USER'].opercode!=item.oprcode}" >
                     			<c:if test="${item.subsystem eq '0' or item.subsystem eq '1'}">
	                     			<s:RewardPurChk controlid="<%=ID_AUDIT%>" disableChild="true">
	                     			 <input type="button" name="btn"  class="button_2" onmouseover="buttonover(this);"
			                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
			                            onclick="doAudit('<c:out value="${urlContent}"/>')"
			                            value='<bean:message bundle="waitaudit" key="audit"/>' />
	                     			</s:RewardPurChk>
	                     		</c:if>
	                     		<c:if test="${item.subsystem eq '2'}">
	                     			<s:RewardPurChk controlid="<%=ID_REWARDAUDIT%>" disableChild="true">
	                     			 <input type="button" name="btn"  class="button_2" onmouseover="buttonover(this);"
			                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
			                            onclick="doAudit('<c:out value="${urlContent}"/>')"
			                            value='<bean:message bundle="waitaudit" key="audit"/>' />
	                     			</s:RewardPurChk>
	                     		</c:if>
	                     		<c:if test="${item.subsystem eq '3'}">
	                     			<s:RewardPurChk controlid="<%=ID_B2MAUDIT%>" disableChild="true">
	                     			 <input type="button" name="btn"  class="button_2" onmouseover="buttonover(this);"
			                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
			                            onclick="doAudit('<c:out value="${urlContent}"/>')"
			                            value='<bean:message bundle="waitaudit" key="audit"/>' />
	                     			</s:RewardPurChk>
	                     		</c:if>
	                     		<c:if test="${item.subsystem eq '4'}">
	                     			<s:RewardPurChk controlid="<%=ID_WAYSTARMONTHAUDIT%>" disableChild="true">
	                     			 <input type="button" name="btn"  class="button_2" onmouseover="buttonover(this);"
			                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
			                            onclick="doAudit('<c:out value="${urlContent}"/>')"
			                            value='<bean:message bundle="waitaudit" key="audit"/>' />
	                     			</s:RewardPurChk>
	                     		</c:if>
	                     		<c:if test="${item.subsystem eq '5'}">
	                     			<s:RewardPurChk controlid="<%=ID_WAYSTARMONTHAUDIT%>" disableChild="true">
	                     			 <input type="button" name="btn"  class="button_2" onmouseover="buttonover(this);"
			                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
			                            onclick="doAudit('<c:out value="${urlContent}"/>')"
			                            value='<bean:message bundle="waitaudit" key="audit"/>' />
	                     			</s:RewardPurChk>
	                     		</c:if>
	                     		<c:if test="${item.subsystem eq '6'}">
	                     			<s:RewardPurChk controlid="<%=ID_WAYSTARMONTHAUDIT%>" disableChild="true">
	                     			 <input type="button" name="btn"  class="button_2" onmouseover="buttonover(this);"
			                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
			                            onclick="doAudit('<c:out value="${urlContent}"/>')"
			                            value='<bean:message bundle="waitaudit" key="audit"/>' />
	                     			</s:RewardPurChk>
	                     		</c:if>
	                     		<c:if test="${item.subsystem eq '7'}">
	                     			<s:RewardPurChk controlid="<%=ID_B2MAUDIT%>" disableChild="true">
	                     			 <input type="button" name="btn"  class="button_2" onmouseover="buttonover(this);"
			                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
			                            onclick="doAudit('<c:out value="${urlContent}"/>')"
			                            value='<bean:message bundle="waitaudit" key="audit"/>' />
	                     			</s:RewardPurChk>
	                     		</c:if>
	                     		<c:if test="${item.subsystem eq '8'}">
	                     			<s:RewardPurChk controlid="<%=ID_B2MAUDIT%>" disableChild="true">
	                     			 <input type="button" name="btn"  class="button_2" onmouseover="buttonover(this);"
			                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
			                            onclick="doAudit('<c:out value="${urlContent}"/>')"
			                            value='<bean:message bundle="waitaudit" key="audit"/>' />
	                     			</s:RewardPurChk>
	                     		</c:if>
                     		</c:if>
                     		<c:if test="${sessionScope['_USER'].opercode==item.oprcode}" >
                     			<s:PurChk2 controlid="!@#@%%^" disableChild="true">
                     			 <input type="button" name="btn"  class="button_2" onmouseover="buttonover(this);"
		                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
		                            onclick="doAudit('<c:out value="${urlContent}"/>')"
		                            value='<bean:message bundle="waitaudit" key="audit"/>' />
                     			</s:PurChk2>
                     		</c:if>
                     	</c:when>
                     	<c:when test="${item.taskstate==1 }">
                       		 <c:if test="${item.subsystem eq '2'}">
	                     			<s:RewardPurChk controlid="<%=ID_REWARDAUDIT%>" disableChild="true">
	                     			 <input type="button" name="btn"  class="delete" onmouseover="buttonover(this);"
			                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
			                            onclick="doDisable('<c:out value="${urlContent2}"/>')"
			                            value='<bean:message bundle="waitaudit" key="invalid"/>' />
	                     			</s:RewardPurChk>
	                     	 </c:if> 
                     	</c:when>
                     	<c:otherwise>
                     	</c:otherwise>
                     </c:choose>
                       
                     </td>
                     <td>
                          <c:out value="${item.taskid}"/> 
                     </td>
                     <td><c:out value="${item.filecode}"/></td>
                     <td>
                     	<s:Code2Name code="${item.subsystem}" definition="$CH_WAITAUDITMENU"/>
                     </td>
                     <td>
                     	<c:if test="${!empty item.logfile}">
                     		<a href='<%=contextPath%>/cms/waitaudit.do?CMD=DOWNLOAD&down=<c:out value="${item.logfile}"/>'>
							    <img height=10 src="<%=contextPath%>/images/file.png" width=10 border=0> 
							</a>
						</c:if>
                     </td>
                     <td>
                    	<s:Code2Name code="${item.taskstate}" definition="$CH_AUDITSTATUS"/>
                     </td>
                     <td><c:out value="${item.oprcode}"/></td>
                     <td>
                     	<s:Code2Name code="${item.wayid}" definition="#WAY"/>
                     </td>
                     <td>
                      <fmt:formatDate type="date" 
                     			pattern="yyyy-MM-dd HH:mm:ss" value="${item.createtime}" />
                     </td>
                     <td><c:out value="${item.auditoprcode}"/></td>
                     <td>
                    	<s:Code2Name code="${item.auditwayid}" definition="#WAY"/>
                     </td>
                     <td>
                      <fmt:formatDate type="date" 
                     			pattern="yyyy-MM-dd HH:mm:ss" value="${item.audittime}" />
                     </td>
                     <td><c:out value="${item.totalcount}"/></td>
                     <td><c:out value="${item.currentcount}"/></td>
                     <td><c:out value="${item.successcount}"/></td>
                     <td>
                     	<c:if test="${!empty item.resultfile}">
							<a href='<%=contextPath%>/cms/waitaudit.do?CMD=DOWNLOAD&down=<c:out value="${item.resultfile}"/>'>
							    <img height=10 src="<%=contextPath%>/images/file.png" width=10 border=0> 
							</a>
						</c:if>
                     </td>
                     <td>
                     	<c:if test="${!empty item.errorfile}">
							<a href='<%=contextPath%>/cms/waitaudit.do?CMD=DOWNLOAD&down=<c:out value="${item.errorfile}"/>'>
							    <img height=10 src="<%=contextPath%>/images/file.png" width=10 border=0> 
							</a>
						</c:if>
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
