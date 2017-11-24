<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%
    String ID_1 = "CH_PW_REWARD||CH_PW_REWARD_PROVINCIAL";
    String ID_2 = "00010702";
    String ID_3 = "00010703";
    String ID_4 = "00010704";
%>
<html>
<head>
    <title><bean:message bundle="rule2" key="title"/></title>
    <script type="text/javascript"
			src="<%=contextPath%>/js/bus/waycommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_se_ruleid', '<bean:message bundle="rule2" key="ruleid"/>', 'c', true, '18');
            addfield('_sk_rulename', '<bean:message bundle="rule2" key="rulename"/>', 'c', true, '60');
            addfield('_dnl_startdate', '<bean:message bundle="rule2" key="startdate"/>', 'dt', true, '25');
            addfield('_dnm_startdate', '<bean:message bundle="rule2" key="startdate"/>', 'dt', true, '25');
            addfield('_dnl_enddate', '<bean:message bundle="rule2" key="enddate"/>', 'dt', true, '25');
            addfield('_dnm_enddate', '<bean:message bundle="rule2" key="enddate"/>', 'dt', true, '25');
            addfield('_se_opnid', '<bean:message bundle="rule2" key="opnid"/>', 'c', true, '18');
          	addfield('_se_regionid', '<bean:message bundle="rule2" key="region"/>', 'c', true, '10');
            return checkval(window);
        }
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/reward/rule2.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
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
    			<bean:message bundle="rule2" key="title"/>
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
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="rule2" key="ruleid"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_ruleid"></html:text>
                </td>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="rule2" key="rulename"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_sk_rulename"></html:text>
                </td>
              </tr>
              <!-- 
              <tr>  
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="rule2" key="startdate"/>>=:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnl_startdate" onclick="this.value=selectDatetime()"></html:text>
                </td>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="rule2" key="startdate"/><=:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnm_startdate" onclick="this.value=selectDatetime()"></html:text>
                </td>
              </tr>
            <tr>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="rule2" key="enddate"/>>=:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnl_enddate" onclick="this.value=selectDatetime()"></html:text>
                </td>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="rule2" key="enddate"/><=:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnm_enddate" onclick="this.value=selectDatetime()"></html:text>
                </td>
            </tr>
             -->
            <tr>
                <td width="126" height="20" align="right" class="form_table_right" ><bean:message bundle="rule2" key="opnid"/>:</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_opnid"></html:text>
                    <input type="button" value="..." class="clickbutton" onclick="showOpnTree2(this, '_se_opnid' , 'busi' )">
                </td>
    			<td width="126" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="rule2" key="region"/>:
            	</td>
            	<td class="form_table_left">
            	<s:RewardPurChk controlid="<%=ID_1%>" disableChild="true" >
               	 	<html:select property="_se_region">
               	 	 <html:option value=""></html:option>  
                     <s:Options definition="$region"/>
                    </html:select>
                </s:RewardPurChk>
            	</td>
            </tr>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                        <s:PurChk controlid="<%=ID_3%>">
                        <input type="button" class="query"onmouseover="buttonover(this);"  onclick="doQuery();" 
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
                <td>
                    <a href="javascript:doOrderby('ruleid')"><bean:message bundle="rule2" key="ruleid"/></a>
                    <s:OrderImg form="/cms/reward/rule2/Rule2Form" field="ruleid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('rulename')"><bean:message bundle="rule2" key="rulename"/></a>
                    <s:OrderImg form="/cms/reward/rule2/Rule2Form" field="rulename"/>
                </td>
               <!-- 
                <td>
                    <a href="javascript:doOrderby('startdate')"><bean:message bundle="rule2" key="startdate"/></a>
                    <s:OrderImg form="/cms/reward/rule2/Rule2Form" field="startdate"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('enddate')"><bean:message bundle="rule2" key="enddate"/></a>
                    <s:OrderImg form="/cms/reward/rule2/Rule2Form" field="enddate"/>
                </td>
                -->
                <td>
                    <a href="javascript:doOrderby('ruleitemid')"><bean:message bundle="rule2" key="ruleitemid"/></a>
                    <s:OrderImg form="/cms/reward/rule2/Rule2Form" field="ruleitemid"/>
                </td>
                
                <td>
                    <a href="javascript:doOrderby('ruleitemname')"><bean:message bundle="rule2" key="ruleitemname"/></a>
                    <s:OrderImg form="/cms/reward/rule2/Rule2Form" field="ruleitemname"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('ruleitemname')"><bean:message bundle="rule2" key="state"/></a>
                    <s:OrderImg form="/cms/reward/rule2/Rule2Form" field="state"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('opnid')"><bean:message bundle="rule2" key="opnid"/></a>
                    <s:OrderImg form="/cms/reward/rule2/Rule2Form" field="opnid"/>
                </td>
                <td>
                    业务说明
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <tr class="table_style_content" align="center">
                     <td>
                         <c:out value="${item.ruleid}"/> 
                     </td>
                     <td><c:out value="${item.rulename}"/></td>
                     <!-- 
                     <td> 
                     <fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.startdate}"/>
                     </td>
                     <td> 
                     <fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.enddate}"/></td>
                     -->
                     <td><c:out value="${item.ruleitemid}"/></td>
                     <td><c:out value="${item.ruleitemname}"/></td>
                     <td>
                     	<c:if test="${item.state eq '1'}">
                     		有效
                     	</c:if>
                     	<c:if test="${item.state ne '1'}">
							<font color="red">无效</font>                     	
                     	</c:if>
                     </td>
                     <td><c:out value="${item.opnid}"/></td>
                     <td><c:out value="${item.name }" /></td>
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
