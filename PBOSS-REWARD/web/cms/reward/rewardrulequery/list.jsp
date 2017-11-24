<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<%
    String ID_1 = "CH_PW_REWARD||CH_PW_REWARD_PROVINCIAL";
%>
<html>
<head>
    <title><bean:message bundle="rewardrulequery" key="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
    <script type="text/javascript" src="<%= contextPath%>/js/bus/rescommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
        	addfield('_ne_rewardid', '<bean:message bundle="rewardrulequery" key="rewardmonth"/>', 'i', true, '14');
        	addfield('_se_region', '<bean:message bundle="rewardrulequery" key="rewardmonth"/>', 'c', true, '10');
        	addfield('_ne_rewardtype', '<bean:message bundle="rewardrulequery" key="rewardmonth"/>', 'i', true, '3');
        	addfield('_se_rewardname', '<bean:message bundle="rewardrulequery" key="rewardmonth"/>', 'c', true, '40');
            return checkval(window);
        }
       
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/rewardrulequery.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
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
    			<bean:message bundle="rewardrulequery" key="titleList"/>
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
    			<td width="80" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="rewardrulequery" key="rewardid"/>:
            	</td>
            	<td class="form_table_left">
               		<html:text styleClass="form_input_1x" property="_ne_rewardid" />
            	</td>
    			<td width="80" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="rewardrulequery" key="rewardname"/>:
            	</td>
            	<td class="form_table_left">
               	    <html:text styleClass="form_input_1x" property="_se_rewardname" />
            	</td>
            </tr>
            <tr>
    			<td width="80" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="rewardrulequery" key="rewardtype"/>:
            	</td>
            	<td class="form_table_left">
               	    <html:select property="_ne_rewardtype">
						<option />
							<s:Options definition="$CH_REWARDTYPE" />
					</html:select>
            	</td>
            	<td width="80" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="rewardrulequery" key="region2"/>:
            	</td>
            	<td class="form_table_left">
               	   <html:text styleClass="form_input_1x" property="_se_region" />
            	</td>
            </tr>
            
            
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                <s:RewardPurChk controlid="<%=ID_1%>">
                      <input type="button" class="query"onmouseover="buttonover(this);" onclick="doQuery();" 
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                         value="<bean:message bundle="public" key="button_search"/>" />
                    </s:RewardPurChk>
                </td>
			</tr>
		</table>
	</div>

    <div class="table_div">
      <div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
                <td>
                    <a href="javascript:doOrderby('rewardid')"><bean:message bundle="rewardrulequery" key="rewardid"/></a>
                    <s:OrderImg form="/cms/rewardrulequery/rewardrulequeryForm" field="rewardid"/>
                </td>
              <td>
                    <a href="javascript:doOrderby('rewardname')"><bean:message bundle="rewardrulequery" key="rewardname"/></a>
                    <s:OrderImg form="/cms/rewardrulequery/rewardrulequeryForm" field="rewardname"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('rewardtype')"><bean:message bundle="rewardrulequery" key="rewardtype"/></a>
                    <s:OrderImg form="/cms/rewardrulequery/rewardrulequeryForm" field="rewardtype"/>
            </td>
                
                <td>
                    <a href="javascript:doOrderby('region')"><bean:message bundle="rewardrulequery" key="region"/></a>
                    <s:OrderImg form="/cms/rewardrulequery/rewardrulequeryForm" field="region"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('opnid')"><bean:message bundle="rewardrulequery" key="opnid"/></a>
                    <s:OrderImg form="/cms/rewardrulequery/rewardrulequeryForm" field="opnid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('intvmonth')"><bean:message bundle="rewardrulequery" key="intvmonth"/></a>
                    <s:OrderImg form="/cms/rewardrulequery/rewardrulequeryForm" field="intvmonth"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('acctype')"><bean:message bundle="rewardrulequery" key="acctype"/></a>
                    <s:OrderImg form="/cms/rewardrulequery/rewardrulequeryForm" field="acctype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('rewardstd')"><bean:message bundle="rewardrulequery" key="rewardstd"/></a>
                    <s:OrderImg form="/cms/rewardrulequery/rewardrulequeryForm" field="rewardstd"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('startdate')"><bean:message bundle="rewardrulequery" key="startdate"/></a>
                    <s:OrderImg form="/cms/rewardrulequery/rewardrulequeryForm" field="startdate"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('stopdate')"><bean:message bundle="rewardrulequery" key="stopdate"/></a>
                    <s:OrderImg form="/cms/rewardrulequery/rewardrulequeryForm" field="stopdate"/>
                </td> 
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <tr class="table_style_content" align="center">
                  <td>
                         <c:out value="${item.rewardid}"/>
                     </td>
                      <td><c:out value="${item.rewardname}"/></td>
                     <td>
                       <s:Code2Name code="${item.rewardtype}" definition="$CH_REWARDTYPE" />
                     </td>
                      <td>
                       <c:out value="${item.region}"/>-<s:Code2Name code="${item.region}" definition="$RegionList" />
                     </td>
                      <td><c:out value="${item.opnid}"/></td>
                     <td><c:out value="${item.intvmonth}"/>          
                     </td>
                    <td>
                 	  	<s:Code2Name code="${item.acctype}" definition="#CH_ACCTYPE" />
                     </td>
                      <td>
                     <c:set var="acctype" scope="request"  value="${item.acctype eq 2}"></c:set>
                     <c:choose>
                     	<c:when test="${acctype}">
                     		<fmt:formatNumber pattern="0.00%" value="${item.rewardstd}"></fmt:formatNumber>
                     	</c:when>
                     	<c:otherwise>
                     		<c:out value="${item.rewardstd}"/>
                     	</c:otherwise>
                     </c:choose>
                     </td>
                     <td>
	                     <fmt:formatDate pattern="yyyy-MM-dd" value="${item.startdate}" />
                     </td> 
                     <td>
	                     <fmt:formatDate pattern="yyyy-MM-dd" value="${item.stopdate}" />
                     </td> 
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
