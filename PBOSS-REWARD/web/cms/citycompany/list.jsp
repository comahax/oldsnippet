<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A1A30" />
</jsp:include>
<%
	String ID_QUERY = "CH_PW_CITYCOM_QUERY";
	String ID_ADD = "CH_PW_CITYCOM_ADD";
	String ID_DELETE = "CH_PW_CITYCOM_DELETE";
	String ID_EDIT = "CH_PW_CITYCOM_EDIT";
%>
<html>
<head>
    <title><bean:message bundle="citycompany" key="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_sk_citycompid', '<bean:message bundle="citycompany" key="citycompid"/>', 'c', true, 14);
            addfield('_sk_citycompname', '<bean:message bundle="citycompany" key="citycompname"/>', 'c', true, 64);
            addfield('_se_centerid', '<bean:message bundle="citycompany" key="centerid"/>', 'c', true, 14);
            addfield('_ne_citycomptype', '<bean:message bundle="citycompany" key="citycomptype"/>', 'i', true, 3);
            return checkval(window);
        }
    </script>
</head>

<body onload="loadforiframe();" >
<div class="table_container">

<html:form action="/cms/citycompany.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
<html:hidden property="_orderby"/>
<html:hidden property="_desc"/>
<html:hidden property="_pageno"/>
<html:hidden property="_pagesize"/>
<input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">

	<div class="table_div">
		<table class="top_table">
			<tr>
				<td>
					<bean:message bundle="citycompany" key="titleList"/>
				</td>
			</tr>
		</table>
	</div>	
	
	<div class="table_div">
	  <table width="100%" class="error_text">
    	<s:Msg />
    </table>	
  </div>
	
	<div class="table_div">
        <table class="form_table">
            <tr>
                <td width="126" height="20" align="right" class="form_table_right">
                	<bean:message bundle="citycompany" key="citycompid"/>:
                </td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_sk_citycompid"
										readonly="true"
										onclick="showOrgTree(this,'_sk_citycompid','Citycom')" />
                </td>
                <td width="126" height="20" align="right" class="form_table_right">
                	<bean:message bundle="citycompany" key="citycompname"/>:
               	</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_sk_citycompname" ></html:text>
                </td>
             </tr>
             <tr>
                <td width="126" height="20" align="right" class="form_table_right">
                	<bean:message bundle="citycompany" key="citycomptype"/>:
                </td>
                <td class="form_table_left">
                      <html:select property="_ne_citycomptype">
                      	<option/>
                      	<s:Options definition="$CH_CITYCOMPTYPE"/>
                      </html:select>
                </td>
                <td width="126" height="20" align="right" class="form_table_right">
                	<bean:message bundle="citycompany" key="centerid"/>:
               	</td>
                <td class="form_table_left">
            	   <html:select property="_se_centerid" >
                        	<option/>
                        	<s:Options definition="#AREACENTER" />
                   </html:select>
                </td>
            </tr>
        </table>
    </div>


		<div class="table_div">
			<table class="table_button_list">
				<tr>
					<td>
			  <s:PurChk2 controlid="<%=ID_QUERY%>">
                   <input type="button" class="query"onmouseover="buttonover(this);" onclick="doQuery();" 
                   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                   value="<bean:message bundle="public" key="button_search"/>" />
              </s:PurChk2>
              <s:PurChk2 controlid="<%=ID_ADD%>">
                  <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
                  onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                  value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/citycompany.do')">
              </s:PurChk2>
              <s:PurChk2 controlid="<%=ID_DELETE%>">
                  <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                  onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                  value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/citycompany.do')">
              </s:PurChk2>
              
					</td>
				</tr>
			</table>
		</div>

    <div class="table_div">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
                <td title="<bean:message bundle="public" key="list_title_select"/>">
                    <input type="checkbox" name="allbox" onclick="checkAll();" class="table_checkbox">
                </td>
                <td>
                    <a href="javascript:doOrderby('citycompid')"><bean:message bundle="citycompany" key="citycompid"/></a>
                    <s:OrderImg form="/cms/citycompany/AreacenterForm" field="citycompid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('citycompname')"><bean:message bundle="citycompany" key="citycompname"/></a>
                    <s:OrderImg form="/cms/citycompany/AreacenterForm" field="citycompname"/>
                </td>
                <td><bean:message bundle="citycompany" key="citycomptype"/></td>
                <td><bean:message bundle="citycompany" key="centerid"/></td>
                <td><bean:message bundle="citycompany" key="agent"/></td>
                <td><bean:message bundle="citycompany" key="billingcode"/></td>
                <td><bean:message bundle="citycompany" key="areacode"/></td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/citycompany.do?CMD=EDIT" var="urlContent">
                     <c:param name="PK" value="${item.citycompid}"/>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.citycompid}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td>
                     	 <s:PurChk2 controlid="<%=ID_EDIT%>" disableChild="true">
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.citycompid}"/></a>
                         </s:PurChk2>
                     </td>
                     <td><c:out value="${item.citycompname}"/></td>
                     <td><s:Code2Name code="${item.citycomptype}"  definition="$CH_CITYCOMPTYPE"/></td>
                     <td><s:Code2Name code="${item.centerid}"  definition="#AREACENTER"/></td>
                     <td><c:out value="${item.agent}"/></td>
                     <td><c:out value="${item.billingcode}"/></td>
                     <td><c:out value="${item.areacode}"/></td>
                 </tr>
             </c:forEach>
        </table>
    </div>
    
   <div class="table_div">
      <s:PageNav dpName="LIST"/>
   </div>
       
</html:form>
</div>
</body>
</html>
