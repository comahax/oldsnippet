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
    <title><bean:message bundle="zjtydataquery" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            return checkval(window);
        }
        
        function doQuery() {
        	var url = contextPath + '/cms/zjty/zjtydataquery.do?CMD=Tmnalsucc';
        	formList.action = url;
		    formList.submit();
        }
    </script>
    <script type="text/javascript"
			src="<%=contextPath%>/js/bus/waycommon.js"></script>
	<script type="text/javascript"
			src="<%=contextPath%>/js/bus/rescommon.js"></script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/zjty/zjtydataquery.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/zjty/zjtydataquery/ZjtyDataqueryForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="zjtydataquery" key="titleListTmnalsucc"/>
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
                	<bean:message bundle="zjtydataquery" key="opnid"/>
            	</td>
            	<td width="30%" class="form_table_left">
               	 	<s:myzoom definition="#ZJTY_OPERATION" property="_se_opnid" condition="isbusi:1;" styleClass="form_input_1x"/>
            	</td>
    			<td width="20%" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="zjtydataquery" key="wayid"/>
            	</td>
            	<td width="30%" class="form_table_left">
               	 	<html:text styleClass="form_input_1x" property="_se_wayid" /><input type="button" value="..." class="clickbutton"
						onclick="showSelectWay3(this,'_se_wayid','','','AG','ZJTY','1');this.value='...';" />
            	</td>
            </tr>
            <tr>
				<td width="20%" height="20" align="right" class="form_table_right">
						<bean:message bundle="zjtydataquery" key="oprtime" />
						&gt;=:
				</td>
				<td class="form_table_left">
						<html:text styleClass="form_input_1x" property="_dnl_oprtime"
									onclick="this.value=selectDatetime();"></html:text>
				</td>
				<td width="20%" height="20" align="right" class="form_table_right">
						<bean:message bundle="zjtydataquery" key="oprtime" />
						&lt;=:
				</td>
				<td class="form_table_left">
						<html:text styleClass="form_input_1x" property="_dnm_oprtime" onclick="this.value=selectDatetime();"></html:text>
				</td>
			</tr>
			 <tr>
				<td width="20%" height="20" align="right" class="form_table_right">
						<bean:message bundle="zjtydataquery" key="oprcode" />
						:
				</td>
				<td class="form_table_left">
						<html:text styleClass="form_input_1x" property="_se_oprcode"></html:text>
				</td>
				<td width="20%" height="20" align="right" class="form_table_right">
						<bean:message bundle="zjtydataquery" key="mobile" />
						:
				</td>
				<td class="form_table_left">
						<html:text styleClass="form_input_1x" property="_ne_mobile"></html:text>
				</td>
			</tr>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
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
                    <bean:message bundle="zjtydataquery" key="seq"/>
                    <s:OrderImg form="/cms/zjty/zjtydataquery/ZjtydataqueryForm" field="seq"/>
                </td>
                <td>
                    <bean:message bundle="zjtydataquery" key="srcseq"/>
                </td>
                <td>
                    <bean:message bundle="zjtydataquery" key="cityid"/>
                </td>
                <td>
                    <bean:message bundle="zjtydataquery" key="opnid"/>
                </td>
                <td>
                    <bean:message bundle="zjtydataquery" key="wayid"/>
                </td>
                <td>
                    <bean:message bundle="zjtydataquery" key="oprcode"/>
                </td>
                <td>
                    <bean:message bundle="zjtydataquery" key="oprtime"/>
                </td>
                <td>
                    <bean:message bundle="zjtydataquery" key="mobile"/>
                </td>
                <td>
                    <bean:message bundle="zjtydataquery" key="busivalue"/>
                </td>
                <td>
                    <bean:message bundle="zjtydataquery" key="brand"/>
                </td>
                <td>
                    <bean:message bundle="zjtydataquery" key="creattime"/>
                </td>
                <td>
                    <bean:message bundle="zjtydataquery" key="adttime"/>
                </td>
                <td>
                    <bean:message bundle="zjtydataquery" key="src"/>
                </td>
                <td>
                    <bean:message bundle="zjtydataquery" key="calcopnid"/>
                </td>
                <td>
                    <bean:message bundle="zjtydataquery" key="calcmonth"/>
                </td>
                <td>
                    <bean:message bundle="zjtydataquery" key="ruleid"/>
                </td>
                <td>
                    <bean:message bundle="zjtydataquery" key="ruleitemid"/>
                </td>
                <td>
                    <bean:message bundle="zjtydataquery" key="adtflag"/>
                </td>
                <td>
                    <bean:message bundle="zjtydataquery" key="adtcode"/>
                </td>
                <td>
                    <bean:message bundle="zjtydataquery" key="adtremark"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/zjty/zjtydataquery.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.seq}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                   	 <td>
                         <c:out value="${item.seq}"/>
                     </td>
                     <td><c:out value="${item.srcseq}"/></td>
                     <td><c:out value="${item.cityid}"/></td>
                     <td><c:out value="${item.opnid}"/></td>
                     <td><c:out value="${item.wayid}"/></td>
                     <td><c:out value="${item.oprcode}"/></td>
                     <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.oprtime}"/></td>
                     <td><c:out value="${item.mobile}"/></td>
                     <td><c:out value="${item.busivalue}"/></td>
                     <td><c:out value="${item.brand}"/></td>
                     <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.creattime}"/></td>
                     <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.adttime}"/></td>
                     <td><c:out value="${item.src}"/></td>
                     <td><s:Code2Name code="${item.calcopnid}" definition="#ZJTY_OPERATION"/></td>
                     <td><c:out value="${item.calcmonth}"/></td>
                     <td><c:out value="${item.ruleid}"/></td>
                     <td><c:out value="${item.ruleitemid}"/></td>
                     <td><c:out value="${item.adtflag}"/></td>
                     <td><c:out value="${item.adtcode}"/></td>
                     <td><c:out value="${item.adtremark}"/></td>
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
