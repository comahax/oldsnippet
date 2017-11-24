<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ page import="org.ajaxanywhere.AAUtils" %>
<%@ page import="com.sunrise.boss.business.cms.way.persistent.WayVO"%>
<%//  contenthead.inc是content.jsp的文件头，声明了JS、CSS等的引用，所有content.jsp必须引用这个文件头%>
<%@ include file="/inc/contenthead.inc" %>
<%@ taglib uri="http://ajaxanywhere.sourceforge.net/" prefix="aa" %>

<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A3CAA" />
</jsp:include>
<%
	//业务控制点标识，暂时没用上，先保留  
    String PID = "2B1A3CAA";
    String ID_1 = PID + "BT1";
    String ID_2 = PID + "BT2";
    String ID_3 = PID + "BT3";    
    String canSave = (String)request.getAttribute("canSave");
    if(canSave == null){
    	canSave = "yes";
    }
%>
<html:html>
<head>
    <title><bean:message bundle="Way" key="titleUpdate"/></title>
    <%
    	if(AAUtils.isAjaxRequest(request)){
    		//AAUtils.addZonesToRefresh(request,"zoneWaysubtype");
    		AAUtils.addZonesToRefresh(request,"zoneCenter");
    		AAUtils.addZonesToRefresh(request,"zoneCity");
    		AAUtils.addZonesToRefresh(request,"zoneCounty");
    	}
    %>
    <script type="text/javascript" src="<%=contextPath%>/js/aa.js"></script>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
    <script language="JavaScript">
        <%//录入数据的校检%>
        function ev_checkval() {
        
            if(document.all("waytype").value!="" && document.all("waytype").value!=null)
            {
	            if(!document.all("waysubtype").value=="TEMI" && !document.all("waysubtype").value=="ITF"&& !document.all("waysubtype").value=="ECF")
	            {
	              var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-weight:900;\'>[社会网点，合作商]类别</span>' + '请去专门的渠道菜单进行录入!' + '</span>';
	              errorMessageShow(alertstr);
            	  return false;
	            }
            }
            	if(document.all("longtitude").value*1<100 ||document.all("latitude").value*1>130 || !document.all("longtitude").value.match("[0-9]{2}(.?)[0-9]{6}")){
        		var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-weight:900;\'>[地理经度]</span>' + '经度值必须在100 － 130 之间并且精确到小数后6位!' + '</span>';
        		errorMessageShow(alertstr);
            	return false;
            }
            if(document.all("latitude").value*1<18 ||document.all("latitude").value*1>26 || !document.all("latitude").value.match("[0-9]{1}(.?)[0-9]{6}")){
            	var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-weight:900;\'>[地理纬度]</span>' + '纬度值必须在18 － 26 之间并且精确到小数后6位!' + '</span>';
            	errorMessageShow(alertstr);
            	return false;
            }
            addfield('wayid', '<bean:message bundle="Way" key="wayid"/>', 'c', false , 18);
            addfield('wayname', '<bean:message bundle="Way" key="wayname"/>', 'c', false, 256);
            addfield('waytype', '<bean:message bundle="Way" key="waytype"/>', 'c', false , 4);
            addfield('waysubtype', '<bean:message bundle="Way" key="waysubtype"/>', 'c', true, 4);
            addfield('custtype', '<bean:message bundle="Way" key="custtype"/>', 'c', true, 4);
            addfield('upperwayID', '<bean:message bundle="Way" key="upperwayID"/>', 'c', true, 18);
            addfield('countyid', '<bean:message bundle="Way" key="countyid"/>', 'c', true, 14);
            addfield('cityid', '<bean:message bundle="Way" key="cityid"/>', 'c', true, 14);
            addfield('centerid', '<bean:message bundle="Way" key="centerid"/>', 'c', true, 14 );
            addfield('citylevel', '<bean:message bundle="Way" key="citylevel"/>', 'i', true, 3);
            
            addfield('bchlevel', '<bean:message bundle="Way" key="bchlevel"/>', 'c', true, 4);
            addfield('function', '<bean:message bundle="Way" key="function"/>', 'c', true, 255);            
            addfield('miscode', '<bean:message bundle="Way" key="miscode"/>', 'c', true, 12);            
            addfield('createTime', '<bean:message bundle="Way" key="createTime"/>', 'd', true, 12);
            addfield('disableTime', '<bean:message bundle="Way" key="disableTime"/>', 'c', true, 12);
            addfield('waystate', '<bean:message bundle="Way" key="waystate"/>', 'i', true, 3);    
            addfield('runbyself', '<bean:message bundle="Way" key="runbyself"/>', 'c', true, 4);   
            addfield('depotdet', '<bean:message bundle="Way" key="depotdet"/>', 'c', true, 20);     
            addfield('isshare', '<bean:message bundle="Way" key="isshare"/>', 'c', true, 32); 
            addfield('chainhead', '<bean:message bundle="Way" key="chainhead"/>', 'c', true, 18); 
            addfield('empnumber', '<bean:message bundle="Way" key="empnumber"/>', 'i', true, 4); 
            addfield('magnumber', '<bean:message bundle="Way" key="magnumber"/>', 'i', true, 4); 
            addfield('terminumber', '<bean:message bundle="Way" key="terminumber"/>', 'i', true, 4); 
            addfield('longtitude', '<bean:message bundle="Way" key="longtitude"/>', 'd', false, '10');
            addfield('latitude', '<bean:message bundle="Way" key="latitude"/>', 'd', false, '9');             

            return checkval(window);
        }
        var isChanged = false;
        var canSave = '<%=canSave%>'=='yes'?true:false;
        function setChanged(){
        	isChanged = true;
        }
        function save(){
        	if(!canSave){
        		alert("上级渠道不能是省公司/区域中心");
        	}
        	doSave('/cms/way.do?CMD=SAVE');
        }
        
        function selectWay(obj){
        	showSelectWay(obj);
        	//formItem.action = '/cms/way.do?CMD=NEW';
        	ajaxAnywhere.submitByURL( '/cms/way.do?CMD=NEW');
        	setChanged();
        }
    </script>
</head>
<body onload="loadforiframe()">
<div class="table_container">
<html:form action="/cms/way.do?CMD=SAVE" styleId="formItem" method="post" >
    <html:hidden property="cmdState"/>
    <%//查询页面的参数，有了这些就能在增加，编辑时返回编辑前的正确页面%>
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden  property="_se_centerid"/>
    <html:hidden  property="_se_cityid"/>
    <html:hidden  property="_se_countyid" />
    <html:hidden  property="_se_upperwayid"/>          
    <c:set var="edtOnlyState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' and !( param.CMD eq 'NEW'))}"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="way" scope="request" value="${requestScope['/cms/way/WayForm']}"/>
    		
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
        	<tr >
				<td align=left colspan="4">
					&nbsp;&nbsp;<bean:message bundle="public" key="msgRequired"/>												
				</td>			
			</tr>
			<tr >
				<td width="15%" align="right"><div class="field-require"> <bean:message bundle="Way" key="upperwayid"/>:</div></td>
				<td align=left colspan="3">	
					<c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="upperwayid" maxlength="18" onclick="selectWay(this)" readonly="true"/>
                            <font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="upperwayid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
				</td>
			</tr>
            <tr >
                <td width="15%" align="right"><div class="field-require"><bean:message bundle="Way" key="wayid"/>:</div></td>
                <td width="20%" align="left" class="form_table_left">
                    <c:choose>
                    	 <c:when test="${edtOnlyState}">
                            <html:text styleClass="form_input_1x" property="wayid" maxlength="18" readonly="true"/><font color=red>&nbsp;*</font>
                        </c:when>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="wayid" maxlength="18" /><font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="wayid" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td  td width="12%" align="right"><div class="field-require"><bean:message bundle="Way" key="wayname"/>:</div></td>
                <td width="20%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="wayname"/><font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="wayname" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                
           
            </tr>
            
            <tr >
                <td width="15%" align="right"><div class="field-require"><bean:message bundle="Way" key="busicode"/>:</div></td>
                <td width="20%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="busicode" />
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="busicode" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td  align="right"><div class="field-require"><bean:message bundle="Way" key="isshare"/>:</div></td>
                <td width="20%" align="left" >
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:select property="isshare">
                        		<s:Options definition="$CH_DSTISKEYSTEP"/>
                    		</html:select>  
                        </c:when>
                        <c:otherwise>
                            <html:select property="isshare" disabled="true">
                        		<s:Options definition="$CH_DSTISKEYSTEP"/>
                    		</html:select> 
                        </c:otherwise>
                    </c:choose>                	
                </td>
            </tr>
            
            <tr >     
            	<td  width="12%" align="right"><div class="field-require"><bean:message bundle="Way" key="waytype"/>:</div></td>
                <td width="20%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">        
                        	<html:select property="waytype" onchange="ajaxAnywhere.submitByURL( '/cms/way.do?CMD=NEW'); ">
                        		<option/>
                        		<s:Options definition="#WAYTYPE" condition="uppercode:${'-1'};_sql_waytypecode:waytypecode<>'ET'"/>
                        	</html:select><font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>	
                        	<html:select property="waytype" disabled="true" >
                        		<option/>
                        		<s:Options definition="#WAYTYPE" condition="uppercode:${'-1'}"/>
                        	</html:select>                                
                        </c:otherwise>
                    </c:choose>
                </td>
                          
                <td  align="right"><div class="field-require"><bean:message bundle="Way" key="waysubtype"/>:</div></td>
                <td width="20%" align="left" >
	               	 <aa:zone name="zoneWaysubtype">
	                   <div> <c:choose>
	                        <c:when test="${edtState}">
	                           	<html:select property="waysubtype">
	                        		<option/>
		                        		<c:if test="${!empty param.waytype}">
		                        			<s:Options definition="#WAYTYPE" condition="uppercode:${param.waytype}"/>
		                        		</c:if>
		                        		<c:if test="${empty param.waytype}">
		                        			<s:Options definition="#WAYTYPE" condition="uppercode:${way.waytype};"/>
		                        		</c:if>
	                        	</html:select>                         	 
	                        </c:when>
	                        <c:otherwise>
	                            <html:select property="waysubtype" disabled="true">
	                        		<option/>
		                        		<c:if test="${!empty param.waytype}">
		                        			<s:Options definition="#WAYTYPE" condition="uppercode:${param.waytype};"/>
		                        		</c:if>
		                        		<c:if test="${empty param.waytype}">
		                        			<s:Options definition="#WAYTYPE" condition="uppercode:${way.waytype};"/>
		                        		</c:if>
	                        	</html:select>   
	                        </c:otherwise>
	                    </c:choose>
	                    </div>
	                 </aa:zone>                  	   
                </td>
            </tr>

             <tr >   
                 
                 <td  align="right" nowrap><div class="field-require"><bean:message bundle="Way" key="custtype"/>:</div></td>
                <td width="20%" align="left" >
                     <c:choose>
	                        <c:when test="${edtState}">
	                           	<html:select property="custtype">
	                        		<option/>
	                        		<s:Options definition="#CUSTWAYTYPE" />
	                        	</html:select>                         	 
	                        </c:when>
	                        <c:otherwise>
	                            <html:select property="custtype" disabled="true">
	                        		<option/>
	                        		<s:Options definition="#CUSTWAYTYPE"/>
	                        	</html:select>  
	                        </c:otherwise>
	                </c:choose>
                </td>
                
                <td  align="right"><div class="field-require"><bean:message bundle="Way" key="centerid"/>:</div></td>
                <td width="20%" align="left" >
                	<aa:zone name="zoneCenter">
	                	<s:Code2Name code="${way.centerid}" definition="#AREACENTER"/>
	                	<html:hidden property="centerid" />
                	</aa:zone>
                </td>
               </tr> 
               
              <tr >    
                <td  align="right"><div class="field-require"><bean:message bundle="Way" key="cityid"/>:</div></td>
                <td width="20%" align="left" >
                	<aa:zone name="zoneCity">
	                	<s:Code2Name code="${way.cityid}" definition="#CITYCOMPANY"/>
	                    <html:hidden property="cityid" />
                    </aa:zone>
                </td>
                
               <td  align="right"><div class="field-require"><bean:message bundle="Way" key="countyid"/>:</div></td>
                <td width="20%" align="left" >
                	<aa:zone name="zoneCounty">
	                	<s:Code2Name code="${way.countyid}" definition="#CNTYCOMPANY"/>
	                    <html:hidden property="countyid" />
                    </aa:zone>
                </td>
                
                </tr>
                
               <tr >   
                 <td  align="right"><div class="field-require"><bean:message bundle="Way" key="citylevel"/>:</div></td>
                <td width="20%" align="left" >
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:select property="citylevel">
                        		<option/>
                        		<s:Options definition="$CH_CITYLEVEL"/>
                        	</html:select>                        	
                        </c:when>
                        <c:otherwise>
                            <html:select property="citylevel" disabled="true">
                        		<option/>
                        		<s:Options definition="$CH_CITYLEVEL"/>
                        	</html:select>
                        </c:otherwise>
                    </c:choose>
                </td>
                
                <td  align="right"><div class="field-require"><bean:message bundle="Way" key="waylevel"/>:</div></td>
                <td width="20%" align="left" >
                	<aa:zone name="zoneWaylevel">
                	 <c:out value="${way.waylevel}"></c:out>
                	 <html:hidden property="waylevel" /> 
                	 </aa:zone>                   
                </td>
            </tr>
        
           
            <tr >               
                <td  align="right" nowrap><div class="field-require"><bean:message bundle="Way" key="bchlevel"/>:</div></td>
                <td width="20%" align="left" >
                    <c:choose>
                        <c:when test="${edtState}">                        	
                        	  <html:select property="bchlevel">
                        		<option/>
                        		<s:Options definition="$CH_BCHLEVEL"/>
                        	</html:select>
                        </c:when>
                        <c:otherwise>
                              <html:select property="bchlevel" disabled="true">
                        		<option/>
                        		<s:Options definition="$CH_BCHLEVEL"/>
                        	</html:select> 
                        </c:otherwise>
                    </c:choose>
                </td>         
                
                 <td  align="right"><div class="field-require"><bean:message bundle="Way" key="miscode"/>:</div></td>
                <td width="20%" align="left" >
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="miscode"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="miscode" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                       
           </tr>
           
           
           
           
           <tr >                       
                <td  align="right"><div class="field-require"><bean:message bundle="Way" key="prtsource"/>:</div></td>
                <td width="20%" align="left" >
                    <c:choose>
                        <c:when test="${edtState}">
                        	<html:select property="prtsource">
                        		<option/>
                        		<s:Options definition="$CH_PRTSOURCE"/>
                        	</html:select>                            
                        </c:when>
                        <c:otherwise>
                            <html:select property="prtsource" disabled="true">
                            	<option/>
                        		<s:Options definition="$CH_PRTSOURCE"/>
                        	</html:select>
                        	
                        </c:otherwise>
                    </c:choose>
                </td>
                <td  align="right"><div class="field-require"><bean:message bundle="Way" key="isconnected"/>:</div></td>
                <td width="20%" align="left" >
                    <c:choose>
                        <c:when test="${edtState}">
                        	<html:select property="isconnected">
                        		<option/>
                        		<s:Options definition="$CH_ISCONNECTED"/>
                        	</html:select>                            
                        </c:when>
                        <c:otherwise>
                            <html:select property="isconnected" disabled="true">
                            	<option/>
                        		<s:Options definition="$CH_ISCONNECTED"/>
                        	</html:select>
                        	
                        </c:otherwise>
                    </c:choose>
                </td>
           </tr>
           <tr >                       
                <td  align="right"><div class="field-require"><bean:message bundle="Way" key="connecttype"/>:</div></td>
                <td width="20%" align="left" >
                    <c:choose>
                        <c:when test="${edtState}">
                        	<html:select property="connecttype">
                        		<option/>
                        		<s:Options definition="$CH_CONNECTTYPE"/>
                        	</html:select>                            
                        </c:when>
                        <c:otherwise>
                            <html:select property="connecttype" disabled="true">
                            	<option/>
                        		<s:Options definition="$CH_CONNECTTYPE"/>
                        	</html:select>
                        	
                        </c:otherwise>
                    </c:choose>
                </td>
                <td  align="right"><div class="field-require"><bean:message bundle="Way" key="runmode"/>:</div></td>
                <td width="20%" align="left" >
                    <c:choose>
                        <c:when test="${edtState}">
                        	<html:select property="runmode">
                        		<option/>
                        		<s:Options definition="$CH_RUNMODE"/>
                        	</html:select>                            
                        </c:when>
                        <c:otherwise>
                            <html:select property="runmode" disabled="true">
                            	<option/>
                        		<s:Options definition="$CH_RUNMODE"/>
                        	</html:select>
                        	
                        </c:otherwise>
                    </c:choose>
                </td>
           </tr>
           <tr >                       
                <td  align="right"><div class="field-require"><bean:message bundle="Way" key="iscoreway"/>:</div></td>
                <td width="20%" align="left" >
                    <c:choose>
                        <c:when test="${edtState}">
                        	<html:select property="iscoreway">
                        		<option/>
                        		<s:Options definition="$CH_ISCOREWAY"/>
                        	</html:select>                            
                        </c:when>
                        <c:otherwise>
                            <html:select property="iscoreway" disabled="true">
                            	<option/>
                        		<s:Options definition="$CH_ISCOREWAY"/>
                        	</html:select>
                        	
                        </c:otherwise>
                    </c:choose>
                </td>
                <td  align="right"><div class="field-require"><bean:message bundle="Way" key="starlevel"/>:</div></td>
                <td width="20%" align="left" >
                    <c:choose>
                        <c:when test="${edtState}">
                        	<html:select property="starlevel">
                        		<option/>
                        		<s:Options definition="$CH_STARLEVEL"/>
                        	</html:select>                            
                        </c:when>
                        <c:otherwise>
                            <html:select property="starlevel" disabled="true">
                            	<option/>
                        		<s:Options definition="$CH_STARLEVEL"/>
                        	</html:select>
                        	
                        </c:otherwise>
                    </c:choose>
                </td>
           </tr>
           <tr >                       
                <td  align="right"><div class="field-require"><bean:message bundle="Way" key="pt"/>:</div></td>
                <td width="20%" align="left" >
                    <c:choose>
                        <c:when test="${edtState}">
                        	<html:select property="pt">
                        		<option/>
                        		<s:Options definition="$CH_PT"/>
                        	</html:select>                            
                        </c:when>
                        <c:otherwise>
                            <html:select property="pt" disabled="true">
                            	<option/>
                        		<s:Options definition="$CH_PT"/>
                        	</html:select>
                        	
                        </c:otherwise>
                    </c:choose>
                </td>
                
                <td  align="right"><div class="field-require"><bean:message bundle="Way" key="chainhead"/>:</div></td>
                <td width="20%" align="left" >
                   <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="chainhead"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="chainhead" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
             </tr>
             
             <tr>
             	<td  align="right"><div class="field-require"><bean:message bundle="Way" key="signstatus"/>:</div></td>
                <td width="20%" align="left" >
                    <c:choose>
                        <c:when test="${edtState}">
                        	<html:select property="signstatus">
                        		<option/>
                        		<s:Options definition="$CH_SIGNSTATUS"/>
                        	</html:select>                            
                        </c:when>
                        <c:otherwise>
                            <html:select property="signstatus" disabled="true">
                            	<option/>
                        		<s:Options definition="$CH_SIGNSTATUS"/>
                        	</html:select>
                        	
                        </c:otherwise>
                    </c:choose>
                </td>     
            	<td  align="right"><div class="field-require"><bean:message bundle="Way" key="empnumber"/>:</div></td>
                <td width="20%" align="left" >
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="empnumber"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="empnumber" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td  align="right"><div class="field-require"><bean:message bundle="Way" key="magnumber"/>:</div></td>
                <td width="20%" align="left" >
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="magnumber"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="magnumber" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td  align="right"><div class="field-require"><bean:message bundle="Way" key="terminumber"/>:</div></td>
                <td width="20%" align="left" >
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="terminumber"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="terminumber" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td  align="right"><div class="field-require"><bean:message bundle="Way" key="latitude"/>:</div></td>
                <td width="20%" align="left" >
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="latitude" maxlength="9"/><font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="latitude" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td  align="right"><div class="field-require"><bean:message bundle="Way" key="longtitude"/>:</div></td>
                <td width="20%" align="left" >
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="longtitude" maxlength="10"/><font color=red>&nbsp;*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="longtitude" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>

           <tr >                       
                <td  align="right"><div class="field-require"><bean:message bundle="Way" key="waystate"/>:</div></td>
                <td width="20%" align="left" >
                    <c:choose>
                    
                    	<c:when test="${edtOnlyState }">
                    	<html:select property="waystate">
                        		<s:Options definition="$CH_VALIDFLAG"/>
                        	</html:select>  
                    	</c:when>
                        <c:when test="${edtState}" >
                        	<html:select property="waystate"  value="1">
                        		<s:Options definition="$CH_VALIDFLAG"/>
                        	</html:select>                            
                        </c:when>
                        <c:otherwise>
                            <html:select property="waystate" disabled="true">
                        		<s:Options definition="$CH_VALIDFLAG"/>
                        	</html:select>
                        	
                        </c:otherwise>
                    </c:choose>
                </td>
                
                <td  align="right"><div class="field-require"><bean:message bundle="Way" key="depotdet"/>:</div></td>
                <td width="20%" align="left" >
                   <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="depotdet"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="depotdet" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
             </tr>
             
             <tr>     
            	<td  align="right"><div class="field-require"><bean:message bundle="Way" key="function"/>:</div></td>
                <td  align="left" colspan="3">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_3x" property="function"/>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_3x" property="function" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            
             <tr>                       
                <td  align="right"><div class="field-require"><bean:message bundle="Way" key="createtime"/>:</div></td>
                <td width="20%" align="left" >
                	<fmt:formatDate value="${way.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>                 	
                </td>
                
                <td  align="right"><div class="field-require"><bean:message bundle="Way" key="runbyself"/>:</div></td>
                <td width="20%" align="left" >
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:select property="runbyself">
                        		<option/>
                        		<s:Options definition="$CH_WAY_RUNTYPE"/>
                    		</html:select>  
                        </c:when>
                        <c:otherwise>
                            <html:select property="runbyself" disabled="true">
                        		<option/>
                        		<s:Options definition="$CH_WAY_RUNTYPE"/>
                    		</html:select> 
                        </c:otherwise>
                    </c:choose>                	
                </td>
               <!-- <td  align="right"><div class="field-require"><bean:message bundle="Way" key="disabletime"/>:</div></td>
                <td width="20%" align="left" >
               		<fmt:formatDate value="${way.disabletime}" pattern="yyyy-MM-dd HH:mm:ss"/>                		
                </td>
                -->
             </tr>
             <tr>                       
                <td  align="right"><div class="field-require"><bean:message bundle="Way" key="updatedate"/>:</div></td>
                <td  align="left" colspan="3">
                	<fmt:formatDate value="${way.updatedate}" pattern="yyyy-MM-dd HH:mm:ss"/>                 	
                </td>
            </tr>
            <tr>    
                <td  align="center" colspan="4"><div class="field-require"><bean:message bundle="Way" key="exp"/></div></td>
             </tr>
        </table>
    </div>
    
   <div class="table_div">
				<table class="table_button_list">
					<tr>
						<td>
						<s:PurChk controlid="<%=ID_1%>">
						 <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_save"/>" class="submit"
                           onclick="save()"/>
                        </s:PurChk>   
                        <s:PurChk controlid="<%=ID_2%>">
	                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
	                           name="btnPrint" onfocus="buttonover(this)" onblur="buttonout(this)"
	                           value="<bean:message bundle="public" key="button_print"/>" class="print" onclick="doPrint()">
	                     </s:PurChk> 
	                     
	                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
	                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
	                           value="<bean:message bundle="public" key="button_return"/>" class="close"
	                           onclick="doReturn('/cms/way.do?CMD=LIST')">
					</td>
				</tr>
			</table>
	</div>
 </html:form>  
</div> 
</body>
</html:html>
