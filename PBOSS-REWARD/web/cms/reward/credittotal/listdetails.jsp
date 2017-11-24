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
    <title><bean:message bundle="credittotal" key="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
    <script type="text/javascript" src="<%= contextPath%>/js/bus/rescommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        
        function checkRuleitem(checkvalue){
        	
        	//if (ev_checkval()) {
       	 	//	enable();
       	 	var sis = formList.all("ruleitemids");
       	 	var pv= formList.all("paramervalues");
        	var checkedNum = 0;
        	var id = '';
        	if (sis.length == undefined) {
        		if (sis.value != '') {
        			if (sis.type == 'checkbox'&& sis.checked ) {
        				checkedNum++;
        				id = sis.value;
        				pv.disabled=false;
        			}
        			if (sis.type == 'checkbox'&& !(sis.checked) ) {
        				pv.disabled=true;
        				
        			}
        		}
        	} else {
        		for (var i=0; i<sis.length; i++) {
        			
        			if (sis[i].type == 'checkbox'&& sis[i].checked ) {
        			
        				checkedNum++;
        				id = sis[i].value;
        				pv[i].disabled=false;
        			}
        			
        			if (sis[i].type == 'checkbox'&& !(sis[i].checked) ) {
        				pv[i].disabled=true;
        				
        			}
        		}
        	}
        	
  			<%-- 
  			ajaxAnywhere.submitByURL( '/cms/reward/salecreditstd.do?CMD=CANCELRULEITEM&ruleitemid='+checkvalue);  
  			formList.action=contextPath+"/cms/reward/salecreditstd.do?CMD=LIST";
  			--%>
  	
        }
        
        function doSave() {
    		//if (ev_checkval()) {
       	 	//	enable();
       	 	
        	/*
        	if (checkedNum == 0) {
        		alert('<bean:message bundle="rule" key="remindOnBusi"/>');
        		return;
        	}
        	*/
			var a=new Array();
			var sis = formList.all("ruleitemids");
       	 	var pv= formList.all("paramervalues");
        	var id = '';
        	if (sis.length == undefined) {
        		if (sis.value != '') {
        			if (sis.type == 'checkbox'&& sis.checked ) {
        				a[0]= sis.value+";"+pv.value;
        			}
        			
        		}
        	} else {
        		for (var i=0; i<sis.length; i++) {
        			
        			if (sis[i].type == 'checkbox'&& sis[i].checked ) {
        			
        				a[i]= sis[i].value+";"+pv[i].value;
        			}
        			
        		}
        	}
			
       		 formList.action ="<%=contextPath%>/cms/reward/credittotal.do?CMD=SAVE2&a="+a;
       		 formList.submit();
   			// }
   		 //	return false;
		}
        
        
         function doDetails(){
	    	formList.action="<%=contextPath%>/cms/reward/credittotal.do?CMD=DETAILS";
	    	formList.submit();
	    }
	    
        
        function doBack(){
	    	formList.action="<%=contextPath%>/cms/reward/credittotal/list.jsp";
	    	formList.submit();
	    }
        
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();checkRuleitem(this);">
<div class="table_container">
<html:form action="/cms/reward/credittotal.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'DETAILS')}"/>
    <c:set var="form" scope="request" value="${requestScope['/cms/reward/credittotal/CredittotalForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="credittotal" key="titleList"/>
   			</td>
    	</tr>
    </table>
    </div>
    <!-- 添加的部分 开始-->
    
    <div class="table_div">	
   		 <table width="100%" class="error_text">
    		<html:errors/><s:Msg />
    	</table>
    	
    	<table class="table_style" ID="Table3">
            <tr class="table_style_head">          
            	<td>
            	操作
            	</td>
                <td>
                    规则编码
                </td>
                <td>
                    规则名称
                </td>
                <td>
                   参数
                </td>
            </tr>
	
            <c:forEach var="item2" items="${requestScope.dp2.datas}">
                 <c:url value="" var="urlContent">
                     <%//this param name must "PK" %>
                     <%-- <c:param name="PK" value="${formvalue._se_cityid}|${formvalue._se_ruleid}|${item[1].ruleitemid}"/>
                     <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                 	  <td >
       					<c:if test="${item2.isdefault == 1}">
       						<input type="checkbox" name="ruleitemids"  <c:out value='${item2.ruleitemid}' /> value="<c:out value='${item2.ruleitemid}' />"
				               checked="checked"  disabled="true"    onclick="checkRuleitem(this);" class="table_checkbox">
				            <input type="hidden"   name="ruleitemids0" value="<c:out value="${item2.ruleitemid}"/>"   />
       					</c:if>
               		
               			<c:if test="${empty item2.isdefault }" >
               				<c:choose>
					        <c:when test="${item2.isSelected == 1 }" >
		        			<input type="checkbox" name="ruleitemids"  <c:out value='${item2.ruleitemid}' /> value="<c:out value='${item2.ruleitemid}' />"
				                checked="checked"      onclick="checkRuleitem(this);" class="table_checkbox">
				        	</c:when>
				        	<c:otherwise>
			        			<input type="checkbox" name="ruleitemids"  <c:out value='${item2.ruleitemid}' /> value="<c:out value='${item2.ruleitemid}' />"
					                     onclick="checkRuleitem(this);" class="table_checkbox">
				        	</c:otherwise>
				        	</c:choose>
				        </c:if>
				        <c:if test="${item2.isdefault == 0}">
				       	 	<c:choose>
					        <c:when test="${item2.isSelected == 1 }" >
		        			<input type="checkbox" name="ruleitemids"  <c:out value='${item2.ruleitemid}' /> value="<c:out value='${item2.ruleitemid}' />"
				                checked="checked"      onclick="checkRuleitem(this);" class="table_checkbox">
				        	</c:when>
				        	<c:otherwise>
			        			<input type="checkbox" name="ruleitemids"  <c:out value='${item2.ruleitemid}' /> value="<c:out value='${item2.ruleitemid}' />"
					                     onclick="checkRuleitem(this);" class="table_checkbox">
				        	</c:otherwise>
				        	</c:choose>
       					</c:if>
			         </td>
                     <td >
                         <c:out value="${item2.ruleitemid}"/>
                     </td>
                     <td width="400">
                        <%--   <c:out value="${item2.ruleitemname}"/> --%>
                         <s:Code2Name code="${item2.ruleitemid}" definition="#CHADTRULEITEM"/>
                     </td>
                     <td >
                     	<c:if test="${!empty item2.paramer }" >
                     	<!-- <c:out value="${item2.paramer}"/>  -->
                     	<c:out value="${item2.paramer}" escapeXml="false"/>
                     	<br>
			        			<!--  
			        			<input type="textarea" name="paramervalues" value="<c:out value="${item2.paramercityvalue}"  />  " 
			        			disabled="false" size="60"
			        			 />
			        			 -->
			        			 <textarea name="paramervalues" rows="3" cols="45" align="left"  ><c:out value="${item2.paramercityvalue}"  /></textarea>
			        			<input type="hidden"   name="linkid" value="<c:out value="${item2.ruleitemid}"/>"   />
                     	</c:if>
                     	<c:if test="${empty item2.paramer }" >
                     	<!-- <c:out value="${item2.paramer}"/> 
                     	item2.paramer:<c:out value="${item2.paramer}"/>
                     	 -->
                     	<br>
			        			<input type="text" style="display:none"  name="paramervalues" value="<c:out value="no value"/>" 
			        			disabled="false"  maxlength="30" />
			        			<input type="hidden"   name="linkid" value="<c:out value="${item2.ruleitemid}"/>"   />
                     	<!-- 
                     	<input type="text" style="display:none" name="paramervalues" value="<c:out value="没有参数"/>" disabled="false" maxlength="30"  />
                     	 -->
                     	</c:if>
                     </td>
                 </tr>
             </c:forEach>

        </table>
    	
    </div>
    </aa:zone>
    <div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                <c:choose>
                    <c:when test="${updateState}">
						<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
	                         name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
	                         value="<bean:message bundle="public" key="button_save"/>" class="submit"
	                         onclick="doSave()"/>
                    </c:when>
                    <c:otherwise>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
	                         name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
	                         value="<bean:message bundle="public" key="button_save"/>" class="submit"
	                     disabled="true"    onclick="doSave()"/>
	                </c:otherwise>
                 </c:choose>
                  <input type="button" id="btnExportexcel" name="btnExportexcel" class="button_4" onmouseover="buttonover(this);"
                       onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                       value="返回" onClick="doBack()"> 
                </td>
			</tr>
		</table>
	</div>
    
    <!-- 添加的部分 结束 -->
    
   
</html:form>
</div>
</body>
</html>
