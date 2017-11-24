<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>

<html>
<head>
    <title><bean:message bundle="chadtbaseprodid" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_se_prodid', '<bean:message bundle="chadtbaseprodid" key="prodid"/>', 'c', 'false', '32');
            addfield('_se_cityid', '<bean:message bundle="chadtbaseprodid" key="cityid"/>', 'c', 'false', '2');
            addfield('_se_type', '<bean:message bundle="chadtbaseprodid" key="type"/>', 'c', 'false', '2');
            addfield('_se_oprtype', '<bean:message bundle="chadtbaseprodid" key="oprtype"/>', 'c', 'false', '2');
            return checkval(window);
        } 
		function doExport(url){
        	formList.action=contextPath + url + "?CMD=EXPORT";
			formList.submit();
			formList.action=contextPath + url + "?CMD=LIST";
		}
		 function doImport(url){
        	formList.action=contextPath + url + "?CMD=IMPORT";
			formList.submit();
			formList.action=contextPath + url + "?CMD=LIST";
		}
		
		
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/reward/chadtbaseprodid.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/reward/chadtbaseprodid/ChAdtBaseprodidForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="chadtbaseprodid" key="titleList"/>
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
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chadtbaseprodid" key="prodid"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_prodid"></html:text>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chadtbaseprodid" key="cityid"/>:</td>
                <td width="30%" class="form_table_left">
                   <html:select property="_se_cityid" onchange="changecity()">
                   <html:option value=""></html:option>
					<s:Options definition="#CITYNAME3" />
				   </html:select>
                </td>
            </tr>
            <tr>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chadtbaseprodid" key="type"/>:</td>
                <td width="30%" class="form_table_left"> 
                    <html:select property="_se_type">
                	<option />
	                   	<s:Options definition="$BASEPRODID_TYPE"/>
                    </html:select>
                    
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chadtbaseprodid" key="oprtype"/>:</td>
                <td width="30%" class="form_table_left"> 
                     <html:select property="_se_oprtype">
                    <option />
	                   	<s:Options definition="$BASEPRODID_OPRTYPE"/>
                    </html:select>
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
                                
                            <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/reward/chadtbaseprodid.do')">
                        
                            <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/reward/chadtbaseprodid.do')"> 
                                
                            <input type="button" class="button_4" onmouseover="buttonover(this);" onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                              	value="<bean:message bundle="costcard" key="buttonBatch"/>" 
                                onclick="doImport('/cms/reward/chadtbaseprodid.do')"/>
                                
                            <input type="button" value="导出EXCEL" class="button_4" onclick="doExport('/cms/reward/chadtbaseprodid.do')">
                        
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
                    <a href="javascript:doOrderby('prodid')"><bean:message bundle="chadtbaseprodid" key="prodid"/></a>
                    <s:OrderImg form="/cms/chadtbaseprodid/ChadtbaseprodidForm" field="prodid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('cityid')"><bean:message bundle="chadtbaseprodid" key="cityid"/></a>
                    <s:OrderImg form="/cms/chadtbaseprodid/ChadtbaseprodidForm" field="cityid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('type')"><bean:message bundle="chadtbaseprodid" key="type"/></a>
                    <s:OrderImg form="/cms/chadtbaseprodid/ChadtbaseprodidForm" field="type"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('prodname')"><bean:message bundle="chadtbaseprodid" key="prodname"/></a>
                    <s:OrderImg form="/cms/chadtbaseprodid/ChadtbaseprodidForm" field="prodname"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('oprtype')"><bean:message bundle="chadtbaseprodid" key="oprtype"/></a>
                    <s:OrderImg form="/cms/chadtbaseprodid/ChadtbaseprodidForm" field="oprtype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('tertype')"><bean:message bundle="chadtbaseprodid" key="tertype"/></a>
                    <s:OrderImg form="/cms/chadtbaseprodid/ChadtbaseprodidForm" field="tertype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('wrapfee')"><bean:message bundle="chadtbaseprodid" key="wrapfee"/></a>
                    <s:OrderImg form="/cms/chadtbaseprodid/ChadtbaseprodidForm" field="wrapfee"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('createtime')"><bean:message bundle="chadtbaseprodid" key="createtime"/></a>
                    <s:OrderImg form="/cms/chadtbaseprodid/ChadtbaseprodidForm" field="createtime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('adtremark')"><bean:message bundle="chadtbaseprodid" key="adtremark"/></a>
                    <s:OrderImg form="/cms/chadtbaseprodid/ChadtbaseprodidForm" field="adtremark"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/reward/chadtbaseprodid.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.cityid}|${item.prodid}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.cityid}|${item.prodid}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.prodid}"/></a>
                     </td>
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><s:Code2Name code="${item.cityid}" definition="#CITYNAME"/></a>
                     </td>
                     <td><s:Code2Name definition="$BASEPRODID_TYPE" code="${item.type}"/> </td>
                     <td><c:out value="${item.prodname}"/></td>
                     <td> <s:Code2Name definition="$BASEPRODID_OPRTYPE" code="${item.oprtype}"/></td>
                     <td><s:Code2Name definition="$BASEPRODID_TERTYPE" code="${item.tertype}"/></td>
                     <td><c:out value="${item.wrapfee}"/></td>
                     <td><fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" value="${item.createtime}" /></td>
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
