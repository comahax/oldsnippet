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
    String ID_1 = "CH_WAY_QUERYALLWAYS";

    
    String centerid = (String)request.getAttribute("centerid");
    String cityid = (String)request.getAttribute("cityid");
    String countyid = (String)request.getAttribute("countyid");
    
    pageContext.setAttribute("centerid",centerid);
    pageContext.setAttribute("cityid",cityid);
    pageContext.setAttribute("countyid",countyid);
%>
<html>
<head>
    <title><bean:message bundle="Way" key="wayquery"/></title>
    <script language="JavaScript" type="text/JavaScript">
        <%//查询条件的校检%>
        function ev_check() {
            addfield('_sk_wayid', '<bean:message bundle="Way" key="wayid"/>', 'c', true, 20);
            addfield('_sk_wayname', '<bean:message bundle="Way" key="wayname"/>', 'c', true, 64);
            return checkval(window);
        }
        function doBatch()
        {
        	var url="<%=contextPath%>/cms/way.do?CMD=EXCEL2";
        	formList.action=url;
        	formList.submit();
        	formList.action="<%=contextPath%>/cms/way.do?CMD=SEARCH";
        }
    </script>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
    <script type="text/javascript" src="<%=contextPath%>/js/aa.js"></script>
</head>

<body >
<div class="table_container">

<html:form action="/cms/way.do?CMD=SEARCH" styleId="formList" method="post" onsubmit="return ev_check();">
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
					<bean:message bundle="Way" key="wayquery"/>
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
                   <html:select property="_se_centerid" onchange="ajaxAnywhere.submitByURL( '/cms/way.do?CMD=SEARCH'); " >
                    	<option/>
                    	<s:Options definition="#AREACENTER" />
                   </html:select>                  
                </td>
                <td width="80" height="20" align="right" class="form_table_right" nowrap>
                	<bean:message bundle="Way" key="cityid"/>:
                </td>
                <td class="form_table_left">    
                	<aa:zone name="zoneCitycompany">  	                	
	                    <html:select property="_se_cityid" onchange="ajaxAnywhere.submitByURL( '/cms/way.do?CMD=SEARCH'); " >
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
                	<html:text styleClass="form_input_1x" property="_se_upperwayid" maxlength="18" onclick="showSelectWay(this)"/>
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
        </table>
    </div>  
	
	<div class="table_div">
				<table class="table_button_list">
					<tr>
						<td>
						<!--按钮的左中右位置分别为 form_table_left、form_table_center、form_table_right-->
                       
                        <s:PurChk controlid="<%=ID_1%>">                        
                        <input type="submit" class="query"onmouseover="buttonover(this);"
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_search"/>" >
                        </s:PurChk>  
                         <input type="button" class="query" onmouseover="buttonover(this);" onclick="doBatch();" 
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="导出" >
				</tr>
			</table>
	</div>
	
    <div class="table_div">
    	<div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
                <td nowrap>
                    <a href="javascript:doOrderby('upperwayid')"><bean:message bundle="Way" key="upperwayid"/></a>
                    <s:OrderImg form="/cms/way/WayForm" field="upperwayid"/>
                </td>
                <td nowrap>
                    <a href="javascript:doOrderby('wayid')"><bean:message bundle="Way" key="wayid"/></a>
                    <s:OrderImg form="/cms/way/WayForm" field="wayid"/>
                </td>
                <td nowrap>
                    <a href="javascript:doOrderby('wayname')"><bean:message bundle="Way" key="wayname"/></a>
                    <s:OrderImg form="/cms/way/WayForm" field="wayname"/>
                </td>
                <td nowrap><bean:message bundle="Way" key="busicode"/></td>
                <td nowrap><bean:message bundle="Way" key="waytype"/></td>

                <td nowrap><bean:message bundle="Way" key="waysubtype"/></td>
                <td nowrap><bean:message bundle="Way" key="custtype"/></td>

                <td nowrap><bean:message bundle="Way" key="centerid"/></td>
                <td nowrap><bean:message bundle="Way" key="cityid"/></td>

                <td nowrap><bean:message bundle="Way" key="countyid"/></td>    
                <td nowrap><bean:message bundle="Way" key="citylevel"/></td>
                
                <td nowrap><bean:message bundle="Way" key="waylevel"/></td>
                <td nowrap><bean:message bundle="Way" key="bchlevel"/></td>
                <td nowrap><bean:message bundle="Way" key="miscode"/></td>
                <td nowrap><bean:message bundle="Way" key="waystate"/></td>
                <td nowrap><bean:message bundle="Way" key="function"/></td>
                <td nowrap><bean:message bundle="Way" key="createtime"/></td>
              	<td nowrap><bean:message bundle="Way" key="isshare"/></td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <tr class="table_style_content" align="center">
                     <td nowrap="nowrap">
                         <s:Code2Name code="${item.upperwayid}" definition="#WAY"/> 
                     </td>
                     <td nowrap="nowrap"> <c:out value="${item.wayid}"/> </td>
                     <td nowrap="nowrap"> <c:out value="${item.wayname}"/> </td>
                                      
                     <td>  <c:out value="${item.busicode}"/></td>
                     <td> <s:Code2Name code="${item.waytype}"  definition="#WAYTYPE"/> </td>
                     <td> <s:Code2Name code="${item.waysubtype}"  definition="#WAYTYPE"/> </td>

					<td> <s:Code2Name code="${item.custtype}"  definition="#CUSTWAYTYPE"/> </td>
					
					<TD><s:Code2Name code="${item.centerid}" definition="#AREACENTER"/></TD>
					<TD><s:Code2Name code="${item.cityid}" definition="#CITYCOMPANY"/></TD>
					
					<td> <s:Code2Name code="${item.countyid}" definition="#CNTYCOMPANY"/></td>
					
                     <td>  <s:Code2Name code="${item.citylevel}"  definition="$CH_CITYLEVEL"/> </td>
                     <td>  <c:out value="${item.waylevel}"/> </td>
                     <td>  <s:Code2Name code="${item.bchlevel}"  definition="$CH_BCHLEVEL"/> </td>
                     <td>  <c:out value="${item.miscode}"/></td>

                     <td>  <s:Code2Name code="${item.waystate}"  definition="$CH_VALIDFLAG"/> </td>
                    <td>  <c:out value="${item.function}"/></td>
                    <td>  <c:out value="${item.createtime}"/></td>
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
