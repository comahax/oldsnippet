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
    <title><bean:message bundle="waystarmonth" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            return checkval(window);
        }
        function exports(){
			var form=document.forms[0];
			form.action="<%=contextPath%>/cms/waystarmonth.do?CMD=TXT";
			form.submit();
			form.action="<%=contextPath%>/cms/waystarmonth.do?CMD=LIST";
		}
		function goTo(cmdNew) {
		    var url = contextPath + cmdNew;
		    formList.action = url;
		    formList.submit();
		}
    </script>
   	<script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
	<script type="text/javascript" src="<%=contextPath%>/js/bus/rescommon.js"></script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/waystarmonth.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby" />
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/waystarmonth/WaystarmonthForm']}"/>

    <!--##################################��ӱ�������##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="waystarmonth" key="titleList"/>
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
                	<bean:message bundle="waystarmonth" key="wayid" />:
            	</td>
            	<td width="30%" class="form_table_left">
               	 	<html:text styleClass="form_input_1x" property="_se_wayid" />
               	 	<input type="button" value="..." class="clickbutton" onclick="showSelectWay3(this,'_se_wayid','','','AG');this.value='...';" />
            	</td>
    			<td width="20%" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="waystarmonth" key="eftmonth" />:
            	</td>
            	<td width="30%" class="form_table_left">
               	 	<html:text styleClass="form_input_1x" property="_se_eftmonth" onclick="this.value=selectDateYYYYMM(this.value);"/>
            	</td>
            </tr>
            <tr>
    			<td width="20%" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="waystarmonth" key="opcode" />:
            	</td>
            	<td width="30%" class="form_table_left">
               	 	<html:text styleClass="form_input_1x" property="_se_opcode" />
            	</td>
    			<td width="20%" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="waystarmonth" key="slv" />:
            	</td>
            	<td width="30%" class="form_table_left">
            		<html:select property="_ne_slv">
           			<option />
           				<s:Options definition="$CH_STARLEVEL" />
           			</html:select>
            	</td>
            </tr>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                		<input type="button" name="btnNew2" class="button_8" value="�����׿���������" onClick="goTo('/cms/waystarcsale.do?CMD=LIST&_orderby=')">
						<input type="button" name="btnAuditing" class="button_2" value='���' onClick="goTo('/cms/waitaudit.do?CMD=LIST&ISAUDIT=WAYSTARMONTH')">
						<input type="button" name="btnQuery" class="button_2" value="����" onclick="goTo('/cms/waystarmonth/batchupfile.jsp');" />
                		<input type="button" name="btnQuery" class="button_2" value="����" onclick="exports();" />
                        <input type="button" class="query" onmouseover="buttonover(this);" onclick="doQuery();"
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_search"/>" />
                        <input type="button" name="btnQuery" class="back" value="����" onclick="goTo('/cms/wayhznx.do?CMD=LIST&_orderby=');" />
                </td>
			</tr>
		</table>
	</div>

    <div class="table_div">
      <div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
                <td>
                    <bean:message bundle="waystarmonth" key="wayid"/>
                </td>
                <td>
                    <bean:message bundle="waystarmonth" key="wayname"/>
                </td>
                <td>
                    <bean:message bundle="waystarmonth" key="eftmonth"/>
                </td>
                <td>
                    <bean:message bundle="waystarmonth" key="slv"/>
                </td>
                <td>
                    <bean:message bundle="waystarmonth" key="busivalue"/>
                </td>
                <td>
                    <bean:message bundle="waystarmonth" key="opcode"/>
                </td>
                <td>
                    <bean:message bundle="waystarmonth" key="oprtime"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/waystarmonth.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.eftmonth}|${item.wayid}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <c:out value="${item.wayid}"/>
                     </td>
                     <td>
                     	 <s:Code2Name code="${item.wayid}" definition="#WAY" />
                     </td>
                     <td>
                         <c:out value="${item.eftmonth}"/>
                     </td>
                     <td><s:Code2Name code="${item.slv}" definition="$CH_STARLEVEL" /></td>
                     <td><c:out value="${item.busivalue}"/></td>
                     <td><c:out value="${item.opcode}"/></td>
                     <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.oprtime}" /></td>
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
