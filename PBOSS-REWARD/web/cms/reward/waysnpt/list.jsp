<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
    String ID_1 = "CH_PW_REWARD||CH_PW_REWARD_PROVINCIAL||CH_PW_REWARD_CIVIC";
    String ID_2 = "00010702";
    String ID_3 = "00010703";
    String ID_4 = "00010704";
%>
<html>
<head>
    <title><bean:message bundle="waysnpt" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            return checkval(window);
        }
        function exports(){
        	var form=document.forms[0];
			form.action="<%=contextPath%>/cms/reward/waysnpt.do?CMD=EXCEL";
			form.submit();
			form.action="<%=contextPath%>/cms/reward/waysnpt.do?CMD=LIST";
        }
    </script>
    <script type="text/javascript"
			src="<%=contextPath%>/js/bus/waycommon.js"></script>
		<script type="text/javascript"
			src="<%=contextPath%>/js/bus/rescommon.js"></script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/reward/waysnpt.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
   
    
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/reward/waysnpt/WaysnptForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="waysnpt" key="titleList"/>
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
                	<bean:message bundle="waysnpt" key="wayid" />
								:
            	</td>
            	<td width="30%" class="form_table_left">
               	 <html:text styleClass="form_input_1x" property="_se_wayid"
									/>
            	</td>
    			<td width="20%" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="waysnpt" key="calcmonth" />
								:
            	</td>
            	<td width="30%" class="form_table_left">
               	 <html:select property="_se_calcmonth">
						<html:options collection="calcmonthset" property="code" labelProperty="name"/>
				</html:select>
            	</td>
            </tr>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                	<s:RewardPurChk controlid="<%=ID_1%>" disableChild="true">
                		<input type="button" class="button_2" onmouseover="buttonover(this);"
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="导出" onclick="exports()"/>
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
                <td>
                    <a href="javascript:doOrderby('wayid')"><bean:message bundle="waysnpt" key="wayid"/></a>
                    <s:OrderImg form="/cms/reward/waysnpt/WaysnptForm" field="wayid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('wayname')"><bean:message bundle="waysnpt" key="wayname"/></a>
                    <s:OrderImg form="/cms/reward/waysnpt/WaysnptForm" field="wayname"/>
                </td>
                 <td>
                    <a href="javascript:doOrderby('countyid')"><bean:message bundle="waysnpt" key="countyid"/></a>
                    <s:OrderImg form="/cms/reward/waysnpt/WaysnptForm" field="countyid"/>
                </td>
                 <td>
                    <a href="javascript:doOrderby('countyid')"><bean:message bundle="waysnpt" key="countyid1"/></a>
                    <s:OrderImg form="/cms/reward/waysnpt/WaysnptForm" field="countyid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('adtypecode')"><bean:message bundle="waysnpt" key="adtypecode"/></a>
                    <s:OrderImg form="/cms/reward/waysnpt/WaysnptForm" field="adtypecode"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('starttime')"><bean:message bundle="waysnpt" key="starttime"/></a>
                    <s:OrderImg form="/cms/reward/waysnpt/WaysnptForm" field="starttime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('createtime')"><bean:message bundle="waysnpt" key="createtime"/></a>
                    <s:OrderImg form="/cms/reward/waysnpt/WaysnptForm" field="createtime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('waystate')"><bean:message bundle="waysnpt" key="waystate"/></a>
                    <s:OrderImg form="/cms/reward/waysnpt/WaysnptForm" field="waystate"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('starlevel')"><bean:message bundle="waysnpt" key="starlevel"/></a>
                    <s:OrderImg form="/cms/reward/waysnpt/WaysnptForm" field="starlevel"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('chainhead')"><bean:message bundle="waysnpt" key="chainhead"/></a>
                    <s:OrderImg form="/cms/reward/waysnpt/WaysnptForm" field="chainhead"/>
                </td>
                 <td>
                    <a href="javascript:doOrderby('chainhead')"><bean:message bundle="waysnpt" key="chainhead1"/></a>
                    <s:OrderImg form="/cms/reward/waysnpt/WaysnptForm" field="chainhead"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('calcmonth')"><bean:message bundle="waysnpt" key="calcmonth"/></a>
                    <s:OrderImg form="/cms/reward/waysnpt/WaysnptForm" field="calcmonth"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/reward/waysnpt.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.calcmonth}|${item.wayid}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <c:out value="${item.wayid}"/>
                     </td>
                     <td><c:out value="${item.wayname}"/></td>
                     <td><c:out value="${item.countyid}"/></td>
                     <td><s:Code2Name code="${item.countyid}" definition="#CNTYCOMPANY" /></td>
                     <td><c:out value="${item.adtypecode}"/></td>
                     <td><c:out value="${item.starttime}"/></td>
                     <td><c:out value="${item.createtime}"/></td>
                     <td><s:Code2Name code="${item.waystate}" definition="$CH_VALIDFLAG" /></td>
                     <td><s:Code2Name code="${item.starlevel}" definition="$CH_STARLEVEL" /></td>
                     <td><c:out value="${item.chainhead}"/></td>
                     <td><s:Code2Name code="${item.chainhead}" definition="#WAY" /></td>
                     <td><c:out value="${item.calcmonth}"/></td>
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
