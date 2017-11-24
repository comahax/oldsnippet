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
    <title><bean:message bundle="vchpdrprewardrecord" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() { 
            addfield('_se_cityid', '<bean:message bundle="vchpdrprewardrecord" key="cityid"/>', 'c', false, '4');
            return checkval(window);
        }
         function doExport(url){
			if (ev_check()) {
				formList.action = contextPath + url + "?CMD=EXCEL";
	  			formList.submit();
	  			formList.action="<%=contextPath%>/cms/provagent/vchpdrprewardrecord.do?CMD=LIST";
			}
		}
		function doImport(url){
			if (ev_check()) {
				formList.action = contextPath + url + "?CMD=IMPORT";
	  			formList.submit();
	  			formList.action="<%=contextPath%>/cms/provagent/vchpdrprewardrecord.do?CMD=LIST";
			}
		}
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/provagent/vchpdrprewardrecord.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="query" value="true"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/provagent/vchpdrprewardrecord/VChPdRprewardrecordForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="vchpdrprewardrecord" key="titleList"/>
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
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="vchpdrprewardrecord" key="cityid"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:select styleClass="form_input_1x" property="_se_cityid">
                        <option/>
						<s:Options definition="#REGIONNAME"/>
					</html:select>&nbsp;<font color='red'>*</font>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="vchpdrprewardrecord" key="provagentid"/>:</td>
                <td width="30%" class="form_table_left">
                     <html:select styleClass="form_input_1x" property="_se_provagentid">
                    	<option></option>
						<s:Options definition="#CH_PD_AGENT"/>
					</html:select>
                </td>
               
            </tr>
            <tr>
                 <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="vchpdrprewardrecord" key="prodid"/>:</td>
                <td width="30%" class="form_table_left">
                  <s:myzoom definition="#CH_PD_ENTPRODUCT" property="_se_prodid" styleClass="form_input_1x" readonly="false" />
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="vchpdrprewardrecord" key="rewardmonth"/>:</td>
                <td width="30%" class="form_table_left">
                      <html:text styleClass="form_input_1x" property="_se_rewardmonth" onclick="this.value=selectDateYYYYMM();"></html:text>
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
                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/provagent/vchpdrprewardrecord.do')">
                         
                     
                            <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/provagent/vchpdrprewardrecord.do')"> 
                            
                             <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="导入" onClick="doImport('/cms/provagent/vchpdrprewardrecord.do')">
                            
                            <input type="button" class="button_4" onmouseover="buttonover(this);" 
            		        onclick="doExport('/cms/provagent/vchpdrprewardrecord.do')" 
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_export_excel"/>" /> 
                             
                       
                       
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
                    <a href="javascript:doOrderby('rpseqid')"><bean:message bundle="vchpdrprewardrecord" key="rpseqid"/></a>
                    <s:OrderImg form="/cms/provagent/vchpdrprewardrecord/VChpdrprewardrecordForm" field="rpseqid"/>
                </td>
                 <td>
                    <a href="javascript:doOrderby('cityid')"><bean:message bundle="vchpdrprewardrecord" key="cityid"/></a>
                    <s:OrderImg form="/cms/provagent/vchpdrprewardrecord/VChpdrprewardrecordForm" field="cityid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('provagentid')"><bean:message bundle="vchpdrprewardrecord" key="provagentid"/></a>
                    <s:OrderImg form="/cms/provagent/vchpdrprewardrecord/VChpdrprewardrecordForm" field="provagentid"/>
                </td>
                <td>代理商名称</td>
                <td>
                    <a href="javascript:doOrderby('prodno')"><bean:message bundle="vchpdrprewardrecord" key="prodno"/></a>
                    <s:OrderImg form="/cms/provagent/vchpdrprewardrecord/VChpdrprewardrecordForm" field="prodno"/>
                </td>
                 <td>
                    <a href="javascript:doOrderby('prodid')"><bean:message bundle="vchpdrprewardrecord" key="prodid"/></a>
                    <s:OrderImg form="/cms/provagent/vchpdrprewardrecord/VChpdrprewardrecordForm" field="prodid"/>
                </td>
                 <td>
                     集团产品名称
                </td>
                <td>
                    <a href="javascript:doOrderby('phase')"><bean:message bundle="vchpdrprewardrecord" key="phase"/></a>
                    <s:OrderImg form="/cms/provagent/vchpdrprewardrecord/VChpdrprewardrecordForm" field="phase"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('rewardmonth')"><bean:message bundle="vchpdrprewardrecord" key="rewardmonth"/></a>
                    <s:OrderImg form="/cms/provagent/vchpdrprewardrecord/VChpdrprewardrecordForm" field="rewardmonth"/>
                </td>  
                <td>
                    <a href="javascript:doOrderby('rpmoney')"><bean:message bundle="vchpdrprewardrecord" key="rpmoney"/></a>
                    <s:OrderImg form="/cms/provagent/vchpdrprewardrecord/VChpdrprewardrecordForm" field="rpmoney"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('adcrewardid')"><bean:message bundle="vchpdrprewardrecord" key="adcrewardid"/></a>
                    <s:OrderImg form="/cms/provagent/vchpdrprewardrecord/VChpdrprewardrecordForm" field="adcrewardid"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                  
                      <c:url value="/cms/provagent/vchpdrprewardrecord.do?CMD=EDIT" var="urlContent">
                          
                         <c:param name="rpseqid" value="${item.rpseqid}"/>
                         <c:param name="cityid" value="${item.cityid}"/> 
                      </c:url>
                 
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.rpseqid}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td>
                     <c:choose> 
                       <c:when test="${item.adcrewardid ==null }">
                           <a href='<c:out value="${urlContent}"/>'><c:out value="${item.rpseqid}"/></a>
                       </c:when> 
                       <c:otherwise> 
                           <c:out value="${item.rpseqid}"/>
                       </c:otherwise>
                     </c:choose>
             
                     </td>
                     <td><s:Code2Name code="${item.cityid}" definition="#REGIONNAME"/></td>  
                     <td><c:out value="${item.provagentid}"/></td> 
                      <td><s:Code2Name code="${item.provagentid}" definition="#CH_PD_AGENT"/></td>
                     <td><c:out value="${item.prodno}"/></td>
                     <td><c:out value="${item.prodid}"/></td>
                     <td><s:Code2Name code="${item.prodid}" definition="#CH_PD_ENTPRODUCT"/></td> 
                     <td><c:out value="${item.phase}"/></td>
                     <td><c:out value="${item.rewardmonth}"/></td> 
                     <td><fmt:formatNumber pattern="0.00" value="${item.rpmoney}" /></td>
                     <td><c:out value="${item.adcrewardid}"/></td>  
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
