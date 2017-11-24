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
    <title><bean:message bundle="chadtclassplatformtdstd" key="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
	<script type="text/javascript" src="<%=contextPath%>/js/bus/rescommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_ne_comid', '<bean:message bundle="chadtclassplatformtdstd" key="comid"/>', 'f', 'true', '36');
            addfield('_ne_rewardtype', '<bean:message bundle="chadtclassplatformtdstd" key="rewardtype"/>', 'f', 'true', '3');
            addfield('_ne_citycode', '<bean:message bundle="chadtclassplatformtdstd" key="citycode"/>', 'f', 'true', '3');
            return checkval(window);
        }
    function doImport(url){
        	formList.action=contextPath + url + "?CMD=IMPORT";
			formList.submit();
		}    
        
        
	function doExcel(){
	    	formList.action="<%=contextPath%>/cms/chadtclassplatformtdstd.do?CMD=EXCEL";
	    	formList.submit();
	    	formList.action="<%=contextPath%>/cms/chadtclassplatformtdstd.do?CMD=LIST";
	    }
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/chadtclassplatformtdstd.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_ne_citycode"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/chadtclassplatformtdstd/ChadtclassplatformtdstdForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="chadtclassplatformtdstd" key="titleList"/>
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
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chadtclassplatformtdstd" key="comid"/>:</td>
                <td width="30%" class="form_table_left">
                <s:Comidtree styleClass="form_input_1x" property="_ne_comid" condition="comclassid:2;comclassid:5;comclassid:6;comclassid:99;comclassid:1" definition="#COMSYSTEM" nameOnly="false"/>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chadtclassplatformtdstd" key="rewardtype"/>:</td>
                <td width="30%" class="form_table_left">
                <html:select property="_ne_rewardtype">
									<html:option value=""></html:option>
									<s:Options definition="$CH_CPFTDREWARDTYPE" />
				</html:select>
                </td>
            </tr>
           <!--  <tr>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="chadtclassplatformtdstd" key="citycode"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:select property="_ne_citycode">
								<option />
									<s:Options definition="#CITYIDNUM2NMAME" />
							</html:select>
                </td>
    			<td width="20%" height="20" align="right" class="form_table_right" >
                	&nbsp;
            	</td>
            	<td width="30%" class="form_table_left">
               	 &nbsp;
            	</td>
            </tr> -->
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
                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/chadtclassplatformtdstd.do')">
                            <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/chadtclassplatformtdstd.do')">
                            
                            
<input type="button" class="button_4" onmouseover="buttonover(this);" onclick="doExcel();"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<bean:message bundle="public" key="button_export_excel"/>" />
                       <input type="button" class="button_4" onmouseover="buttonover(this);" onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                              	value="批量导入" 
                                onclick="doImport('/cms/chadtclassplatformtdstd.do')"/>
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
                    <a href="javascript:doOrderby('comid')"><bean:message bundle="chadtclassplatformtdstd" key="comid"/></a>
                    <s:OrderImg form="/cms/chadtclassplatformtdstd/ChadtclassplatformtdstdForm" field="comid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('rewardtype')"><bean:message bundle="chadtclassplatformtdstd" key="rewardtype"/></a>
                    <s:OrderImg form="/cms/chadtclassplatformtdstd/ChadtclassplatformtdstdForm" field="rewardtype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('acctype')"><bean:message bundle="chadtclassplatformtdstd" key="acctype"/></a>
                    <s:OrderImg form="/cms/chadtclassplatformtdstd/ChadtclassplatformtdstdForm" field="acctype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('saleslower')"><bean:message bundle="chadtclassplatformtdstd" key="saleslower"/></a>
                    <s:OrderImg form="/cms/chadtclassplatformtdstd/ChadtclassplatformtdstdForm" field="saleslower"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('salesupper')"><bean:message bundle="chadtclassplatformtdstd" key="salesupper"/></a>
                    <s:OrderImg form="/cms/chadtclassplatformtdstd/ChadtclassplatformtdstdForm" field="salesupper"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('rewardstd')"><bean:message bundle="chadtclassplatformtdstd" key="rewardstd"/></a>
                    <s:OrderImg form="/cms/chadtclassplatformtdstd/ChadtclassplatformtdstdForm" field="rewardstd"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('citycode')"><bean:message bundle="chadtclassplatformtdstd" key="citycode"/></a>
                    <s:OrderImg form="/cms/chadtclassplatformtdstd/ChadtclassplatformtdstdForm" field="citycode"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/chadtclassplatformtdstd.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.seq}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.seq}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td> <a href='<c:out value="${urlContent}"/>'><c:out value="${item.comid}"/></a></td>
                     <td><s:Code2Name code="${item.rewardtype}" definition="$CH_CPFTDREWARDTYPE" /></td>
                     <td><s:Code2Name code="${item.acctype}" definition="#CLASSPLATFORMTDSTD_ACCTYPE" /></td>
                     <td><c:out value="${item.saleslower}"/></td>
                     <td><c:out value="${item.salesupper}"/></td>
                     <td><c:out value="${item.rewardstd}"/></td>
                     <td><s:Code2Name code="${item.citycode}" definition="#CITYIDNUM2NMAME" /></td>
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
