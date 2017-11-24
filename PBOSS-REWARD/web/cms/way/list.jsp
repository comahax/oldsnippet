<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ page import="com.sunrise.boss.delegate.cms.way.WayDelegate" %>
<%@ page import="com.sunrise.boss.ui.commons.User" %>
<%@ page import="com.sunrise.boss.ui.commons.WebConstant" %>
<%@ taglib uri="http://ajaxanywhere.sourceforge.net/" prefix="aa" %>
<%//    head.inc是List.jsp的文件头，声明了JS、CSS等的引用，所有list.jsp必须引用这个文件头%>
<%@ include file="/inc/listhead.inc" %>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A3C" />
</jsp:include>
<%
    //业务控制点标识，暂时没用上，先保留  
    String PID = "2B1A3C";
    String ID_1 = PID + "BT1";
    String ID_2 = PID + "BT2";
    String ID_3 = PID + "BT3";
    String ID_4 = PID + "BT4";
    String ID_5 = "CH_PW_WAY_BATCH";
    String centerid = (String)request.getAttribute("centerid");
    String cityid = (String)request.getAttribute("cityid");
    String countyid = (String)request.getAttribute("countyid");
    
    pageContext.setAttribute("centerid",centerid);
    pageContext.setAttribute("cityid",cityid);
    pageContext.setAttribute("countyid",countyid);
%>
<html>
<head>
    <title><bean:message bundle="Way" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        <%//查询条件的校检%>
        function ev_check() {
            addfield('_se_wayid', '<bean:message bundle="Way" key="wayid"/>', 'c', true, 20);
            addfield('_sk_wayname', '<bean:message bundle="Way" key="wayname"/>', 'c', true, 64);
            return checkval(window);
        }
        function batch()
        {	
        	var url="<%=contextPath%>/cms/way.do?CMD=batch";
        	formList.action=url;
        	formList.submit();
        }
         function excel()
        {	
        	var url="<%=contextPath%>/cms/way.do?CMD=excel";
        	formList.action=url;
        	formList.submit();
        	formList.action="<%=contextPath%>/cms/way.do?CMD=LIST";
        }
    </script>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
    <script type="text/javascript" src="<%=contextPath%>/js/aa.js"></script>
</head>

<body >
<div class="table_container">

<html:form action="/cms/way.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    
<!--##################################添加标题内容，里面可以放置按钮##################################################-->		
	<div class="table_div">				
		<table class="top_table">
			<tr> 
				<td>
					<bean:message bundle="Way" key="titleList"/>
				</td>
			</tr>
		</table>
	</div>
	
	<div class="table_div">	
		<table width="100%" class="error_text">
		    <html:errors/><s:Msg />
	    </table>	
    </div>
	
	<!--#################################添加标题内容，里面可以放置按钮###################################################-->
	<div class="table_div">
        <table class="form_table">
        	 <tr>
                 <td width="80" height="20" align="right" class="form_table_right" nowrap>
                	<bean:message bundle="Way" key="centerid"/>:
               	</td>
                <td class="form_table_left">                  
                   <html:select property="_se_centerid" onchange="ajaxAnywhere.submitByURL( '/cms/way.do?CMD=LIST'); " >
                    	<option/>
                    	<s:Options definition="#AREACENTER" />
                   </html:select>                  
                </td>
                <td width="80" height="20" align="right" class="form_table_right" nowrap>
                	<bean:message bundle="Way" key="cityid"/>:
                </td>
                <td class="form_table_left">    
                	<aa:zone name="zoneCitycompany">  	                	
	                    <html:select property="_se_cityid" onchange="ajaxAnywhere.submitByURL( '/cms/way.do?CMD=LIST'); " >
	                  		<option/>
	                		<s:Options definition="#CITYCOMPANY" condition="centerid:${param._se_centerid}" />
		                 </html:select>	   
                    </aa:zone>
                </td>
               
              
            </tr>
            
            <tr>
            	 <td width="80" height="20" align="right" class="form_table_right" nowrap>
                	<bean:message bundle="Way" key="countyid"/>:
               	</td>
                <td class="form_table_left">
                	<aa:zone name="zoneCountycompany"> 	                	
	                     <html:select property="_se_countyid">
	                  		<option/>
	                		<s:Options definition="#CNTYCOMPANY" condition="citycompid:${param._se_cityid}"/>
		                 </html:select>	
                    </aa:zone>
                </td>
               
                <td width="80" height="20" align="right" class="form_table_right" nowrap>
                	<bean:message bundle="Way" key="upperwayid"/>:
               	</td>
                <td class="form_table_left">
                	<html:text styleClass="form_input_1x" property="_se_upperwayid"  onclick="showSelectWay(this,'_se_upperwayid')"/>
                	                	
                	<%--<s:Code2Name code="${requestScope['/cms/way/WayForm']._se_upperwayid}" definition="#WAY"/>                 
                    html:hidden styleClass="form_input_1x" property="upperwayid" /--%>
                </td>
            </tr>
            
            <tr>              
                <td width="80" height="20" align="right" class="form_table_right" nowrap>
                	<bean:message bundle="Way" key="wayid"/>:
                </td>
                <td class="form_table_left">
                    <html:text property="_sk_wayid" styleClass="form_input_1x"/>                   
                </td>
                <td width="80" height="20" align="right" class="form_table_right" nowrap>
                	<bean:message bundle="Way" key="wayname"/>:
               	</td>
                <td class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_sk_wayname" />
                </td>
              
            </tr>
            <tr >     
            	<td  width="80" align="right"><div class="field-require"><bean:message bundle="Way" key="waytype"/>:</div></td>
			    <td  align="left" class="form_table_left">
                <html:select property="_se_waytype" onchange="ajaxAnywhere.submitByURL( '/cms/way.do?CMD=LIST'); ">
                       <option/>
                       <s:Options definition="#WAYTYPE" condition="uppercode:${'-1'}"/>
                </html:select>
                </td>
                          
                <td  align="right"><div class="field-require"><bean:message bundle="Way" key="waysubtype"/>:</div></td>
				     <td width="20%" align="left" >
	            	<aa:zone name="zoneWaysubtype">
		 	       <div> 
	               <html:select property="_se_waysubtype">
	                   <option/>
		               <s:Options definition="#WAYTYPE" condition="uppercode:${requestScope['/cms/way/WayForm']._se_waytype}"/>
	               </html:select>                         	 
			       </div>
	    			</aa:zone>                  	   
                </td>
            </tr>
            
        </table>
    </div>  
	
	<div class="table_div">
				<table class="table_button_list">
					<tr>
						<td>
						<!--按钮的左中右位置分别为 form_table_left、form_table_center、form_table_right-->
						 
                        <s:PurChk controlid="<%=ID_1%>">
                            <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/way.do')">
                        </s:PurChk>
                        <s:PurChk controlid="<%=ID_2%>">
                            <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/way.do')">
                        </s:PurChk>
                        
                        <s:PurChk controlid="<%=ID_3%>">                        
                        <input type="button" class="query"onmouseover="buttonover(this);" onclick="doQuery();" 
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_search"/>" >
                        </s:PurChk>  
                        <input type="button" name="btnBatch"  class="add" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="导出" onClick="excel()">
                        <s:PurChk controlid="<%=ID_4%>">      
	                         <input type="reset" class="query"onmouseover="buttonover(this);"
	                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                                value="<bean:message bundle="public" key="button_reset"/>" >        
						</s:PurChk>  
						 <s:PurChk2 controlid="<%=ID_5%>" disableChild="true">      
	                         <input type="button" class="button_4" onmouseover="buttonover(this);"
	                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
	                                value="批量导入" onclick="batch()">        
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
                <td title="<bean:message bundle="public" key="list_title_select"/>">
                    <input type="checkbox" name="allbox" onclick="checkAll();" class="table_checkbox">
                </td>
                <td nowrap>
                    <a href="javascript:doOrderby('wayid')"><bean:message bundle="Way" key="wayid"/></a>
                    <s:OrderImg form="/cms/way/WayForm" field="wayid"/>
                </td>
                <td nowrap>
                    <a href="javascript:doOrderby('wayname')"><bean:message bundle="Way" key="wayname"/></a>
                    <s:OrderImg form="/cms/way/WayForm" field="wayname"/>
                </td>
                <td nowrap><bean:message bundle="Way" key="waytype"/></td>
                <td nowrap><bean:message bundle="Way" key="waysubtype"/></td>
             <%--   <td nowrap><bean:message bundle="Way" key="countyid"/></td>
                <td nowrap><bean:message bundle="Way" key="cityid"/></td>
                <td nowrap><bean:message bundle="Way" key="centerid"/></td>
               --%> 
                <td nowrap><bean:message bundle="Way" key="citylevel"/></td>
                <td nowrap><bean:message bundle="Way" key="waylevel"/></td>
           <%--     <td nowrap><bean:message bundle="Way" key="bchlevel"/></td>
                <td nowrap><bean:message bundle="Way" key="miscode"/></td>  --%> 
                <td nowrap><bean:message bundle="Way" key="waystate"/></td>    
                <td nowrap><bean:message bundle="Way" key="runbyself"/></td>
              	<td nowrap><bean:message bundle="Way" key="depotdet"/></td>
              	<td nowrap><bean:message bundle="Way" key="isshare"/></td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/way.do?CMD=EDIT" var="urlContent">
                     <%//这个param名称必须是“PK”%>
                     <c:param name="PK" value="${item.wayid}"/>
                     <%//如果是复合主键，需要这样写”%>
                     <%--<c:param name="PK" value="'${item.id}|${item.id2}'"/>--%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                 	 <td nowrap> <a href="cms/way.do?CMD=MAGINFO&PK=<c:out value="${item.wayid}"/>&wayid=<c:out value="${item.wayid}"/>" target="_parent"><bean:message bundle="Way" key="wayinfo"/></a> </td>                   
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.wayid}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td>
                       <c:choose>
                        <c:when test="${item.waytype eq 'ET'}">
                          <c:out value="${item.wayid}"/>
                        </c:when>
                        <c:when test="${item.waytype eq 'AG' && (item.waysubtype eq 'TEMI' || item.waysubtype eq 'ITF' || item.waysubtype eq 'ECF')}">
                          <a href='<c:out value="${urlContent}"/>'><c:out value="${item.wayid}"/></a>
                        </c:when>  
                        <c:otherwise>
                          <a href='<c:out value="${urlContent}"/>'><c:out value="${item.wayid}"/></a>
                        </c:otherwise>
                       </c:choose> 
                     </td>
                     <td nowrap="nowrap"> <c:out value="${item.wayname}"/> </td>
                     <td> <s:Code2Name code="${item.waytype}"  definition="#WAYTYPE"/> </td>
                     <td> <s:Code2Name code="${item.waysubtype}"  definition="#WAYTYPE"/> </td>
                  <%--    <td><c:out value="${item.countyid}"/></td>
                     <td><c:out value="${item.cityid}"/></td>
                     <td><c:out value="${item.centerid}"/></td>                     
                    --%> 
                    
                     <td>  <s:Code2Name code="${item.citylevel}"  definition="$CH_CITYLEVEL"/> </td>
                     <td>  <c:out value="${item.waylevel}" /> </td>
                       <%--<td><c:out value="${item.bchlevel}"/> </td>   --%> 
                      
                  <%--<td><s:Code2Name code="${item.bchlevel}"  definition="$CH_BCHLEVEL"/> </td>  
                     <td>  <c:out value="${item.miscode}"/></td>
                   --%> 
                    <td>  <s:Code2Name code="${item.waystate}"  definition="$CH_VALIDFLAG"/> </td>
                   	 <td>  <s:Code2Name code="${item.runbyself}"  definition="$CH_WAY_RUNTYPE"/> </td>
                   	  <td>  <c:out value="${item.depotdet}"/> </td>
                   	   <td>  <s:Code2Name code="${item.isshare}"  definition="$CH_DSTISKEYSTEP"/> </td>
                    
                   
                    
                     
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
