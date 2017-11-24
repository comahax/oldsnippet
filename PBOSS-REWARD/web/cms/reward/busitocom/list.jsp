<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%@ taglib uri="/WEB-INF/commons" prefix="s" %>
<%
    String ID_1 = "CH_PW_REWARD_PROVINCIAL||CH_PW_REWARD_CIVIC||CH_PW_REWARD";
    String ID_2 = "00010702";
    String ID_3 = "00010703";
    String ID_4 = "00010704";
%>
<html>
<head>
    <title><bean:message bundle="busitocom" key="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
	<script type="text/javascript" src="<%=contextPath%>/js/bus/rescommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            return checkval(window);
        }
        
       function doExport()
       {
       	 formList.action="<%=contextPath%>/cms/reward/busitocom.do?CMD=EXCEL";
       	 formList.submit();
       	 formList.action="<%=contextPath%>/cms/reward/busitocom.do?CMD=LIST";
       }
        
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/reward/busitocom.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/reward/busitocom/BusitocomForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="busitocom" key="titleList"/>
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
				<td width="126" height="20" align="right" class="form_table_right">
					<bean:message bundle="busitocom" key="opnid" />:
				</td>
				<td class="form_table_left">
					<html:text styleClass="form_input_1x" property="_sk_opnid"/><input type="button" value="..." class="clickbutton" onclick="showOpnTree2(this, '_sk_opnid' , 'busi')">
				</td>
				<td width="126" height="20" align="right" class="form_table_right">
					<bean:message bundle="busitocom" key="comtype" />:
				</td>
				<td class="form_table_left">
					<html:select property="_se_comtype">
						<option />
						<s:Options definition="$IM_COMTYPE" />
					</html:select>
				</td>
			</tr>
			<tr>
				<td width="126" height="20" align="right" class="form_table_right">
					<bean:message bundle="busitocom" key="comid" />:
				</td>
				<td class="form_table_left">
					<s:Comidtree styleClass="form_input_1x" property="_ne_comid" condition="comclassid:2;comclassid:5;comclassid:6;comclassid:99;comclassid:1" definition="#COMSYSTEM" nameOnly="false"/>
				</td>
				<td width="126" height="20" align="right" class="form_table_right">
					<bean:message bundle="busitocom" key="busitype" />:
				</td>
				<td class="form_table_left">
					<html:select property="_se_busitype">
						<option />
						<s:Options definition="$CH_TOCOMBUSITYPE" />
					</html:select>
				</td>
			</tr>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                		<input type="button" class="button_2" onmouseover="buttonover(this);" onclick="doExport()"
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value='<bean:message bundle="public" key="button_export"/>' />
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
                    <a href="javascript:doOrderby('opnid')"><bean:message bundle="busitocom" key="opnid"/></a>
                    <s:OrderImg form="/cms/reward/busitocom/BusitocomForm" field="opnid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('cityid')"><bean:message bundle="busitocom" key="cityid"/></a>
                    <s:OrderImg form="/cms/reward/busitocom/BusitocomForm" field="cityid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('comtype')"><bean:message bundle="busitocom" key="comtype"/></a>
                    <s:OrderImg form="/cms/reward/busitocom/BusitocomForm" field="comtype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('comid')"><bean:message bundle="busitocom" key="comid"/></a>
                    <s:OrderImg form="/cms/reward/busitocom/BusitocomForm" field="comid"/>
                </td>
                <td>
                	商品名称
                </td>
                <td>
                    <a href="javascript:doOrderby('pricelow')"><bean:message bundle="busitocom" key="pricelow"/></a>
                    <s:OrderImg form="/cms/reward/busitocom/BusitocomForm" field="pricelow"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('busitype')"><bean:message bundle="busitocom" key="busitype"/></a>
                    <s:OrderImg form="/cms/reward/busitocom/BusitocomForm" field="busitype"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/reward/busitocom.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.cityid}|${item.comid}|${item.comresid}|${item.comtype}|${item.opnid}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <c:out value="${item.opnid}"/>
                     </td>
                     <td>
                         <s:Code2Name code="${item.cityid}" definition="#CITYNAME" />
                     </td>
                     <td>
                         <s:Code2Name code="${item.comtype}" definition="$IM_COMTYPE" />
                     </td>
                     <td>
                         <c:out value="${item.comid}"/>
                     </td>
                     <td>
	                	 <s:Code2Name code="${item.comid}" definition="#COMSYSTEM" />
	                 </td>
                     <td><c:out value="${item.pricelow/100}"/></td>
                     <td><s:Code2Name code="${item.busitype}" definition="$CH_TOCOMBUSITYPE" /></td>
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
