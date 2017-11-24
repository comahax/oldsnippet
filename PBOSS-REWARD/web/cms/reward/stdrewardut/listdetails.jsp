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
    <title>规则明细设置</title>
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
        
        function doSave(cmdSave) {
    		//if (ev_checkval()) {
       	 	//	enable();
       	 	
        	/*
        	if (checkedNum == 0) {
        		alert('<bean:message bundle="rule" key="remindOnBusi"/>');
        		return;
        	}
        	*/
			
       		 formList.action = contextPath + cmdSave;
       		 formList.submit();
   			// }
   		 //	return false;
		}
        
        
        
        function doBack(){
	    	formList.action="<%=contextPath%>/cms/reward/stdrewardut/citylist.jsp";
	    	formList.submit();
	    }
        
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/reward/stdrewardut.do?CMD=LISTCITY" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/reward/stdrewardut/StdrewardutForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			规则明细设置
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
       
               		
		        		<input type="checkbox" name="ruleitemids"  <c:out value='${item2.ruleitemid}' /> value="<c:out value='${item2.ruleitemid}' />"
				                     onclick="checkRuleitem(this);" class="table_checkbox">
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
                     	<c:out value="${item2.paramer}"/>
                     	<br>
                     	<input type="text" name="paramervalues" value="<c:out value="${item2.paramercityvalue}"/>"  disabled="true" maxlength="30" />
                     	</c:if>
                     	<c:if test="${empty item2.paramer }" >
                     	<!-- <c:out value="${item2.paramer}"/>  -->
                     	<c:out value="${item2.paramer}"/>
                     	<br>
                     	<input type="hidden" name="paramervalues" value="<c:out value="${item2.paramercityvalue}"/>"  disabled="true" maxlength="30"  />
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
					<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                         name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
                         value="<bean:message bundle="public" key="button_save"/>" class="submit"
                         onclick="doSave('/cms/reward/stdrewardut.do?CMD=SAVE2')"/>
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
