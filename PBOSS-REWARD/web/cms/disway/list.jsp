<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ taglib uri="http://ajaxanywhere.sourceforge.net/" prefix="aa" %>
<%@ include file="/inc/listhead.inc" %>


<%
    String ID_1 = "CH_PW_SOTYWAY_QUERY";
    String ID_2 = "CH_PW_SOTYWAY_ADD";
    String ID_3 = "CH_PW_SOTYWAY_DELETE";
    String ID_4 = "CH_PW_SOTYWAY_BATCHIMPORT";
    String ID_5 = "CH_PW_SOTYWAY_EXPORT";
    String ID_6 = "CH_PW_SOTYWAY_EDIT";
    String ID_7 = "CH_PW_SOTYWAY_AUDIT";
%>


<html>
<head>
    <title><bean:message bundle="Way" key="distitleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
    <script type="text/javascript" src="<%= contextPath%>/js/bus/rescommon.js"></script>
    <script type="text/javascript" src="<%=contextPath%>/js/aa.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_se_wayid', '<bean:message bundle="Way" key="wayid"/>', 'c', true, 20);
            addfield('_se_upperwayid', '<bean:message bundle="Way" key="upperwayid"/>', 'c', true, 20);
            addfield('_sk_wayname', '<bean:message bundle="Way" key="wayname"/>', 'c', true, 20);
            return checkval(window);
        }
        function ev_check2()
        {
         	var str=addfield('_se_upperwayid', '<bean:message bundle="Way" key="upperwayid"/>', 'c', false, 20);
         	return checkval(window);	
        }
        function doExport() {
           formList.action = contextPath + "/cms/disway.do?CMD=AGEXPORT";
           formList.submit();
           formList.action = contextPath+"/cms/disway.do?CMD=AGLIST";
        }
     function doNew(cmdNew) {
     if(document.all("_se_upperwayid").value==""){
   		 ev_check2();
   		 return false;
    }
    var url = addParam(contextPath + cmdNew, 'CMD', 'AGNEW');
    formList.action = url;
    formList.submit();
}
function doDelete(cmdDelete) {
    var TO = true;
    var sis = formList.all("_selectitem");
    if (forincheck(TO,sis,msgConfirmDelete)){
    	formList.action = addParam(contextPath + cmdDelete, 'CMD', 'AGDELETE');
    	formList.submit();
    	}  
}

       
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/disway.do?CMD=AGLIST" styleId="formList" method="post" onsubmit="return ev_check();">
	  <input type="hidden" name="_se_waysubtype" value="DIS" />
	  <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    
	<div class="table_div">				
		<table class="top_table">
			<tr> 
				<td>
					<bean:message bundle="Way" key="distitleList"/>
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
                <td width="80" height="20" align="right" class="form_table_right" nowrap>
                	<bean:message bundle="Way" key="WAYID"/>:
                </td>
                <td class="form_table_left" title="本树只显示合作商类别">
                     <s:WayPicker property="_sk_wayid" waytype='AG' waysubtype='DIS'/>              
                </td>
                <td width="80" height="20" align="right" class="form_table_right" nowrap>
                	<bean:message bundle="Way" key="WAYNAME"/>:
               	</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_sk_wayname" />
                </td>
            </tr>	 
            
            
            <tr>
                <td width="80" height="20" align="right" class="form_table_right" nowrap>
                	<bean:message bundle="Way" key="upperwayid"/>:
               	</td>
                <td class="form_table_left">
                    <s:WayPicker property="_se_upperwayid" />
                </td>    
                <td width="80" height="20" align="right" class="form_table_right" nowrap>
                	<bean:message bundle="Way" key="cooperator1"/>:
               	</td>
                <td class="form_table_left">
                   <html:select property="_ne_cooperator" >
                    	<option/>
                    	<s:Options definition="$CH_COOPERATOR" />
                   </html:select>  
                </td>
            </tr>	 
        	 
        	 <tr>
                <td width="80" height="20" align="right" class="form_table_right" nowrap>
                	<bean:message bundle="Way" key="cityid"/>:
                </td>
                <td class="form_table_left">
                <%--
                	<c:choose>
                		<c:when test="${requestScope.GDWAY eq 'NOTGD'}">
                			<s:Code2Name code="${requestScope['/cms/way/WayForm']._se_cityid}" definition="#CITYCOMPANY"/>
                		</c:when>
                		<c:otherwise>
                			<html:select property="_se_cityid" onchange="ajaxAnywhere.submitByURL( '/cms/disway.do?CMD=LIST');">
                  				<option/>
                				<s:Options definition="#CITYCOMPANY"/>
	                 		</html:select>
                		</c:otherwise>
                	</c:choose>       
                --%>
                	<html:text styleClass="form_input_1x" property="_se_cityid" />
                	<input type="button" value="..." class="clickbutton" onclick="showOrgTree(this,'_se_cityid','Citycom')">
                </td>
                
                 <td width="80" height="20" align="right" class="form_table_right" nowrap>
                	<bean:message bundle="Way" key="subcomp"/>:
               	</td>
                <td class="form_table_left"> 
                <%--                 
                 	<aa:zone name="zoneCountycompany"> 	                	
	                     <html:select property="_se_countyid" onchange="ajaxAnywhere.submitByURL( '/cms/disway.do?CMD=LIST'); ">
	                  		<option/>
	                		<s:Options definition="#CNTYCOMPANY" condition="citycompid:${requestScope['/cms/way/WayForm']._se_cityid}"/>
		                 </html:select>	
                  </aa:zone>
                --%>       
                	<html:text styleClass="form_input_1x" property="_se_countyid" />
                	<input type="button" value="..." class="clickbutton" onclick="showOrgTree(this,'_se_countyid','Cntycom')">         
                </td>
            </tr>
            
            <tr>
                <td width="80" height="20" align="right" class="form_table_right" nowrap>
                	<bean:message bundle="Way" key="svcname"/>:
               	</td>
                <td class="form_table_left">
                <%--
                 <aa:zone name="svccode">
                     <html:select property="_se_svccode" onchange="ajaxAnywhere.submitByURL( '/cms/disway.do?CMD=LIST'); ">
                					<option/>
		                        	<s:Options definition="#SERVCENT" condition="countyid:${param._se_countyid}"/>
                				</html:select>
                 </aa:zone>
                 --%>
                	<html:text styleClass="form_input_1x" property="_se_svccode" />
                	<input type="button" value="..." class="clickbutton" onclick="showOrgTree(this,'_se_svccode','Svc')"> 
                </td>    
                <td width="80" height="20" align="right" class="form_table_right" nowrap>
                	<bean:message bundle="Way" key="mareaname"/>:
               	</td>
                <td class="form_table_left">
                <%--
                 <aa:zone name="mareacode">
                   <html:select property="_se_mareacode">
                			<option/>
		                   	<s:Options definition="#MICROAREA" condition="svccode:${param._se_svccode}"/>
                		</html:select>
                 </aa:zone>
                --%>
                	<html:text styleClass="form_input_1x" property="_se_mareacode" />
                	<input type="button" value="..." class="clickbutton" onclick="showOrgTree(this,'_se_mareacode','Ma')"> 
                </td>
            </tr>	
             <tr>
                <td width="80" height="20" align="right" class="form_table_right" nowrap>
                	<bean:message bundle="Way" key="mainlayer"/>:
               	</td>
                <td class="form_table_left">
                   <html:select property="_ne_mainlayer" >
                    	<option/>
                    	<s:Options definition="$CH_COPLAYER" />
                   </html:select>  
                </td>
                <td width="80" height="20" align="right" class="form_table_right" nowrap>
                	&nbsp;
               	</td>
                <td class="form_table_left">
                    &nbsp;
                </td>  
            </tr>	  
            
        </table>
    </div>  
	
	<div class="table_div">
				<table class="table_button_list">
					<tr>
						<td>
							
                <s:PurChk2 controlid="<%=ID_1%>">                        
                <input type="button" class="query" onmouseover="buttonover(this);" onclick="doQuery();" 
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<bean:message bundle="public" key="button_search"/>" >
                </s:PurChk2> 
                
                <s:PurChk2 controlid="<%=ID_5%>">                        
                <input type="button" class="button_2" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<bean:message bundle="public" key="button_export"/>"  onClick="doExport()">
                </s:PurChk2>     
                	
                <s:PurChk2 controlid="<%=ID_2%>">
                    <input type="button" name="btnNew" class="add" onmouseover="buttonover(this);"
                    onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                    value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/disway.do')">
                </s:PurChk2>
                
                <s:PurChk2 controlid="<%=ID_4%>">                        
                <input type="button" class="button_2" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<bean:message bundle="public" key="button_import"/>"  onClick="location.href='<%=contextPath%>/cms/disway/batch.jsp'">
                </s:PurChk2>    
                
                <s:PurChk2 controlid="<%=ID_3%>">
                    <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                    onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                    value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/disway.do')">
                </s:PurChk2>
      
							</td>
				</tr>
			</table>
	</div>
	
    <div class="table_div">
    	<div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
                <td nowrap><bean:message bundle="public" key="column_operate"/></td> 
                <td nowrap><bean:message bundle="public" key="column_operate"/></td> 
                <td nowrap><bean:message bundle="Way" key="fdaudit"/></td>
                
                <td title="<bean:message bundle="public" key="list_title_select"/>">
                    <input type="checkbox" name="allbox" onclick="checkAll();" class="table_checkbox">
                </td>
                <td nowrap>
                    <a href="javascript:doOrderby('wayid')"><bean:message bundle="Way" key="WAYID"/></a>
                    <s:OrderImg form="/cms/way/WayForm" field="wayid"/>
                </td>
                <td nowrap>
                    <a href="javascript:doOrderby('wayname')"><bean:message bundle="Way" key="WAYNAME"/></a>
                    <s:OrderImg form="/cms/way/WayForm" field="wayname"/>
                </td>
                <td nowrap><bean:message bundle="Way" key="upperwayid"/></td>
                <td nowrap><bean:message bundle="Way" key="cooperator1"/></td>
                <td nowrap><bean:message bundle="Way" key="cityid"/></td>
                <td nowrap><bean:message bundle="Way" key="subcomp"/></td>
                <td nowrap><bean:message bundle="Way" key="svccode"/></td>
                <td nowrap><bean:message bundle="Way" key="mareacode"/></td> 
                <td nowrap><bean:message bundle="Way" key="taxtype"/></td>  
                <td nowrap><bean:message bundle="Way" key="mainlayer"/></td>
                <td nowrap><bean:message bundle="Way" key="adacode"/></td>
                <td nowrap><bean:message bundle="Way" key="waystate"/></td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <s:PurChk2 controlid="<%=ID_6%>">
                 <c:url value="/cms/disway.do?CMD=AGEDIT" var="urlContent">
                     <c:param name="PK" value="${item.wayid}"/>
                 </c:url>
                 </s:PurChk2>
                 <tr class="table_style_content" align="center">
                 	 <td nowrap> <a href="cms/disway/subindex.jsp?wayid=<c:out value="${item.wayid}"/>" target="_parent"><bean:message bundle="Way" key="wayinfo"/></a> </td>     
                 	 <td nowrap> <a href="cms/saleway/saleway.do?CMD=LIST&_se_chainhead=<c:out value="${item.wayid}"/>" ><bean:message bundle="Way" key="salelist"/></a> </td>                                 
                 	 
                 	 <td nowrap> 
                 	 <s:PurChk2 controlid="<%=ID_7%>" disableChild="true">
                            <s:WayAudit typename="CH_PW_STRBWAY" pk="${item.wayid}" url="/cms/disway.do?CMD=AGLIST&WAYSUBTYPE=DIS"/>
                             </s:PurChk2>					
                     	</td>    
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.wayid}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.wayid}"/></a>
                     </td>
                     <td nowrap="nowrap"> <c:out value="${item.wayname}"/> </td>
                     
                     <td>  <s:Code2Name code="${item.upperwayid}"  definition="#WAY"/> </td>
                     
                     <td>  <s:Code2Name code="${item.cooperator}"  definition="$CH_COOPERATOR"/> </td>
                     <td>  <s:Code2Name code="${item.cityid}"  definition="#CITYCOMPANY"/> </td>
                     <td>  <s:Code2Name code="${item.countyid}"  definition="#CNTYCOMPANY"/> </td>
                     <td>  <s:Code2Name code="${item.svccode}"  definition="#CH_SERVCENT"/> </td>
                     <td>  <s:Code2Name code="${item.mareacode}"  definition="#CH_MICROAREA"/> </td>
                     <td>  <s:Code2Name code="${item.taxtype}"  definition="$CH_STTAXTYPE"/> </td>
                     <td>  <s:Code2Name code="${item.mainlayer}"  definition="$CH_COPLAYER"/> </td>
                     <td>  <s:Code2Name code="${item.adacode}"  definition="#CH_ADIMAREA"/> </td>
                     <td>  <s:Code2Name code="${item.waystate}" definition="$CH_VALIDFLAG" /> </td>
                 </tr>
             </c:forEach>
        </table>
        </div>
    </div>
    
   <div class="table_div">
		  <s:PageNav dpName="LIST"/>
   </div>    
   
</html:form>
</body>
</html>
