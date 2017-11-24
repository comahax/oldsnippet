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
    <title><bean:message bundle="terminalrewardstd" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_ne_rewardtype', '<bean:message bundle="terminalrewardstd" key="rewardtype"/>', 'f', 'false', '2');
            return checkval(window);
        }
        
        function doImport(url){
        	formList.action=contextPath + url + "?CMD=IMPORT";
			formList.submit();
		}
		
		function changecity(){
			var region = document.getElementsByName("region")[0].value;
			var citycode = document.getElementsByName("_ne_citycode")[0].value;		
			
			if(region == citycode){
			document.getElementById("divdisplay2").style.display = "none";
			document.getElementById("divdisplay1").style.display = "block";
			}else{
			document.getElementById("divdisplay1").style.display = "none";
			document.getElementById("divdisplay2").style.display = "block";
			}
		}
        
        
         function doExcel(){
	    	formList.action="<%=contextPath%>/cms/terminalrewardstd.do?CMD=EXCEL";
	    	formList.submit();
	    	formList.action="<%=contextPath%>/cms/terminalrewardstd.do?CMD=LIST";
	    }
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/terminalrewardstd.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="region"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/terminalrewardstd/TerminalrewardstdForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="terminalrewardstd" key="titleList"/>
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
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="terminalrewardstd" key="rewardtype"/>:</td>
                <td width="30%" class="form_table_left">
                <!-- <html:text styleClass="form_input_1x" property="_ne_rewardtype"></html:text> -->
                    
                	<html:select property="_ne_rewardtype">
                	<option />
	                   	<s:Options definition="$CH_TERREWARDTYPE"/>
                    </html:select>
                    
                    
                </td>
                
                <td width="20%" height="20" align="right" class="form_table_right" >地市标识:</td>
                <td width="30%" class="form_table_left">
                 <c:choose>
                        <c:when test="${form.region == '999'}">
								<html:select property="_ne_citycode" onchange="changecity()">
									<s:Options definition="#CITYIDNUM2NMAME" />
								</html:select>
							</c:when>
                       	 <c:otherwise>
	                        <html:select property="_ne_citycode" onchange="changecity()">
										<option value="<c:out value='${form.region}'/>"/><s:Code2Name definition="#CITYIDNUM2NMAME" code="${form.region}"/>
										<option value="999">全省</option>
									</html:select>
                          </c:otherwise>
                    </c:choose>
				</td>
            </tr>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                
                <div id = "divdisplay1">
                <s:PurChk controlid="<%=ID_3%>">
                        <input type="button" class="query" onmouseover="buttonover(this);" onclick="doQuery();"
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_search"/>" />
                        </s:PurChk>
                        <s:PurChk controlid="<%=ID_1%>">
                            <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/terminalrewardstd.do')">
                        </s:PurChk>
                        <s:PurChk controlid="<%=ID_2%>">
                            <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/terminalrewardstd.do')">
                        </s:PurChk>
                        <input type="button" class="button_4" onmouseover="buttonover(this);" onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                              	value="<bean:message bundle="costcard" key="buttonBatch"/>" 
                                onclick="doImport('/cms/terminalrewardstd.do')"/>
                                    
                 <input type="button" class="button_4" onmouseover="buttonover(this);" onclick="doExcel();"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<bean:message bundle="public" key="button_export_excel"/>" />
                  </div>
                  <div id = "divdisplay2" style = "display:none">
                 <s:PurChk controlid="<%=ID_3%>">
                        <input type="button" class="query" onmouseover="buttonover(this);" onclick="doQuery();"
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_search"/>" />
                        </s:PurChk>
                            
                 <input type="button" class="button_4" onmouseover="buttonover(this);" onclick="doExcel();"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<bean:message bundle="public" key="button_export_excel"/>" />
                </div>
            
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
                    <a href="javascript:doOrderby('comid')"><bean:message bundle="terminalrewardstd" key="comid"/></a>
                    <s:OrderImg form="/cms/terminalrewardstd/TerminalrewardstdForm" field="comid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('rewardstd')"><bean:message bundle="terminalrewardstd" key="rewardstd"/></a>
                    <s:OrderImg form="/cms/terminalrewardstd/TerminalrewardstdForm" field="rewardstd"/>
                </td> 
                <td>
                    <a href="javascript:doOrderby('rewardtype')"><bean:message bundle="terminalrewardstd" key="rewardtype"/></a>
                    <s:OrderImg form="/cms/terminalrewardstd/TerminalrewardstdForm" field="rewardtype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('acctype')"><bean:message bundle="terminalrewardstd" key="acctype"/></a>
                    <s:OrderImg form="/cms/terminalrewardstd/TerminalrewardstdForm" field="acctype"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('adtremark')"><bean:message bundle="terminalrewardstd" key="adtremark"/></a>
                    <s:OrderImg form="/cms/terminalrewardstd/TerminalrewardstdForm" field="adtremark"/>
                </td>
                <td>基准价</td>
              
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/terminalrewardstd.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.citycode}|${item.comid}|${item.rewardtype}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <c:choose>
                        <c:when test="${item.citycode == form.region}">
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.citycode}|${item.comid}|${item.rewardtype}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.comid}"/></a>
                     </td>
                     <td><c:out value="${item.rewardstd}"/></td> 
                     <td>
                         <a href='<c:out value="${urlContent}"/>'>
                         <s:Code2Name definition="$CH_TERREWARDTYPE" code="${item.rewardtype}" />
                         </a>
                     </td>
                     <td>
                     <s:Code2Name definition="#CH_ACCTYPE" code="${item.acctype}" />
                     </td>
                     <td><c:out value="${item.adtremark}"/></td>
                     <td><c:out value="${item.standardprice}"/></td>
                    
                 </tr>
                 </c:when>
                        <c:otherwise>
                         <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.citycode}|${item.comid}|${item.rewardtype}' />"
                                onclick="checkOne();" class="table_checkbox" disabled = "true">
                     </td>
                     <td>
                         <c:out value="${item.comid}"/>
                     </td>
                     <td><c:out value="${item.rewardstd}"/></td>
                      
                     <td>
                         
                         <s:Code2Name definition="$CH_TERREWARDTYPE" code="${item.rewardtype}" />
                         
                     </td>
                     <td>
                     <s:Code2Name definition="#CH_ACCTYPE" code="${item.acctype}" />
                     </td>
                     <td><c:out value="${item.adtremark}"/></td>
                     <td><c:out value="${item.standardprice}"/></td>
                 </tr>
                        
                         </c:otherwise>
                    </c:choose>
                        
             </c:forEach>
        </table>
     </div>
   </div>

   <div class="table_div">
		<s:PageNav dpName="LIST"/>
   </div>
  <script language="JavaScript" type="text/JavaScript">
			var region = document.getElementsByName("region")[0].value;
			var citycode = document.getElementsByName("_ne_citycode")[0].value;		
			if(region == citycode){
			document.getElementById("divdisplay2").style.display = "none";
			document.getElementById("divdisplay1").style.display = "block";
			}else{
			document.getElementById("divdisplay1").style.display = "none";
			document.getElementById("divdisplay2").style.display = "block";
		}
        
    </script>
</html:form>
</div>
</body>
</html>
