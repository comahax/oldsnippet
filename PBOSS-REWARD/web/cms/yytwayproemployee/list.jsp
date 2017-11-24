<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%
    String ID_1 = "";
    String ID_2 = "";
%>
<html>
<head>
    <title><bean:message bundle="Wayproemployee" key="titleList2"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/rescommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
        	addfield('_dnl_regdate', 'ע����ʼʱ��', 't', 'true', '7');
            addfield('_dnm_regdate', 'ע�����ʱ��', 't', 'true', '7');
            return (checkval(window) && compareDate());
        }
    function compareDate(){
        var startTime2 = document.getElementById('_dnl_regdate').value;
        var endTime2 = document.getElementById('_dnm_regdate').value;

       
       
        if(startTime2 != '' && endTime2 != '' && startTime2>endTime2){
	        var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[ע����ʼʱ��]</span> ���ܴ��� <span style=\'color:#F00; font-size:12px;\'>[ע�����ʱ��]</span>';
			errorMessageShow(alertstr);
	        return false;
       	}
        
   		return true;	
    }
		function doDelete(cmdDelete) {
		    var TO = true;
		    var sis = formList.all("_selectitem");
		    if (forincheck(TO,sis,"������Աɾ���󽫱��Ϊ��ְ״̬,ȷ���Ƿ���Ҫ���?")){
		    	formList.action = addParam(contextPath + cmdDelete, 'CMD', 'DELETE');
		    	formList.submit();
		    }  
		}
		
		function doImport(url){
			formList.action = contextPath + url + "?CMD=IMPORT";
         	formList.submit();
		}
		
		function doExport(url){
			formList.action = contextPath + url + "?CMD=TOTXT";
  			formList.submit();
  			formList.action = contextPath + url + "?CMD=LIST";
		}
					
		function doQuery2()
		{
			var citycompid = document.getElementById("citycompid").value;
			if(citycompid == "all")
			{
				alert("��������ԭ���޷����б���ʾ���е������ݣ�����������ť���������ݺ���к˶ԡ�");
				return;
			}
			doQuery();
		}
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/yytwayproemployee.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <!--##################################��ӱ�������##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="Wayproemployee" key="titleList2"/>
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
    			<td width="126" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="Wayproemployee" key="wayid"/>:
            	</td>
            	<td class="form_table_left">
            		<s:zoom definition="#WAY" property="_sk_wayid" condition="waytype:AG;waystate:1;" styleClass="form_input_1x" nameOnly="false" readonly="true"/>
            	</td>
    			<td width="165" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="Wayproemployee" key="employeename"/>:
            	</td>
            	<td class="form_table_left">
               	    <html:text styleClass="form_input_1x" property="_sk_employeename" />
            	</td>
            </tr>
            <tr>
    			<td width="126" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="Wayproemployee" key="isnet"/>:
            	</td>
            	<td class="form_table_left">
               	    <select name="_ne_isnet" disabled = "true"><option />
							<option value="0" >��Ա</option>
							<option value="1" >����</option>
							<option value="2" selected>�ƹ�רԱ</option>
							<option value="3" >������</option>
					</select>
            	</td>
            	<td width="165" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="Wayproemployee" key="empstatus"/>:
            	</td>
            	<td class="form_table_left">
               	   <html:select property="_ne_empstatus">
						<option />
							<s:Options definition="$CH_EMPSTATUS" />
					</html:select>
            	</td>
            </tr>
            <tr>
    			<td width="126" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="Wayproemployee" key="telephone"/>:
            	</td>
            	<td class="form_table_left">
            		<html:text styleClass="form_input_1x" property="_sk_telephone" />
            	</td>
            	<td width="165" height="20" align="right" class="form_table_right" >
            		<bean:message bundle="Wayproemployee" key="isunpb"/>:
            	</td>
            	<td class="form_table_left">
            		<html:select property="_ne_state">
						<option />
							<s:Options definition="#ISUNPB"/>
					</html:select>
            	</td>
            </tr>
            <tr>
    			<td width="126" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="Wayproemployee" key="citycompany" />:
            	</td>
            	<td class="form_table_left">
            		<html:select property="_ne_citycompid" styleId="citycompid">
						<option />
						<option value="all">ȫ��</option>
							<s:Options definition="#CITYCOMPANY" />
					</html:select>
            	</td>
            	<td width="165" height="20" align="right" class="form_table_right" >
            		<bean:message bundle="Wayproemployee" key="istenseed"/>:
            	</td>
            	<td class="form_table_left">
            		<html:select property="_ne_istenseed" styleId="istenseed">
						<option />
							<s:Options definition="#IS_UNV_YN" />
					</html:select>
            	</td>
            </tr>
            <tr>
    			<td width="126" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="Wayproemployee" key="isinternal"/>:
            	</td>
            	<td class="form_table_left">
            		<html:select property="_ne_isinternal" styleId="isinternal">
						<option />
							<s:Options definition="#IS_UNV_YN" />
					</html:select>
            	</td>
            	<td width="165" height="20" align="right" class="form_table_right" >
            		<bean:message bundle="Wayproemployee" key="emplevel"/>:
            	</td>
            	<td class="form_table_left">
            		<html:select property="_ne_emplevel" styleId="emplevel">
						<option />
							<s:Options definition="$CH_BBCUNPBLEVEL" />
					</html:select>
            	</td>
            </tr>
            <tr>
             <td width="126" height="20" align="right" class="form_table_right" >ע����ʼʱ��>=:</td>
                <td class="form_table_left">
               	<html:text styleClass="form_input_1x" property="_dnl_regdate"
									onclick="this.value=selectDate();" ></html:text>
                </td>
           
                <td width="165" height="20" align="right" class="form_table_right" >ע�����ʱ��<=:</td>
                <td class="form_table_left">
               	<html:text styleClass="form_input_1x" property="_dnm_regdate"
									onclick="this.value=selectDate();" ></html:text>
                </td>
    			
            </tr>
             <tr>
    			<td width="126" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="Wayproemployee" key="empattr"/>:
            	</td>
            	<td class="form_table_left">
            		<html:select property="_se_empattr" styleId="isinternal">
						<option />
							<s:Options definition="#EMPROLE" />
					</html:select>
            	</td>
            	<td width="165" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="Wayproemployee" key="empattr2"/>:
            	</td>
            	<td class="form_table_left">
               	    <html:select property="_ne_empattr2" styleId="empattr2">
						<option />
							<s:Options definition="$CH_EMPATTR2" />
					</html:select>
            	</td>
            </tr>
            <tr>
    			<td width="126" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="Wayproemployee" key="oprcode2"/>:
            	</td>
            	<td class="form_table_left">
            		<html:text styleClass="form_input_1x" property="_sk_oprcode2" />
            	</td>
             	<td colspan="2">&nbsp;</td>
            </tr>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                		<input type="button" class="query"onmouseover="buttonover(this);" onclick="doQuery2();" 
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_search"/>" />
                         <input type="button" class="button_2" onmouseover="buttonover(this);" onclick="doExport('/cms/yytwayproemployee.do')" 
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_export"/>" />    
                		<c:choose>
                			<c:when test="${requestScope.CALC=='TRUE'}">
		             				 <input type="button" class="button_2" onmouseover="buttonover(this);" disabled="true" 
		                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
		                                value="<bean:message bundle="public" key="button_import"/>" /> 
			                        <input type="button" name="btnNew"  class="add" disabled="true" 
			                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
			                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/yytwayproemployee.do')">
			                        <input type="button" name="btnDelete" class="delete" disabled="true" 
			                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
			                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/yytwayproemployee.do')">
                			</c:when>
                			<c:otherwise>
		             				 <input type="button" class="button_2" onmouseover="buttonover(this);" onclick="doImport('/cms/yytwayproemployee.do')" 
		                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
		                                value="<bean:message bundle="public" key="button_import"/>" /> 
			                        <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
			                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
			                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/yytwayproemployee.do')">
			                        <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
			                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
			                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/yytwayproemployee.do')">
                			</c:otherwise>
                		</c:choose>
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
                    <a href="javascript:doOrderby('employeeid')"><bean:message bundle="Wayproemployee" key="employeeid"/></a>
                    <s:OrderImg form="/cms/yytwayproemployee/YYTWayproemployeeForm" field="employeeid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('wayid')"><bean:message bundle="Wayproemployee" key="wayid"/></a>
                    <s:OrderImg form="/cms/yytwayproemployee/YYTWayproemployeeForm" field="wayid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('employeename')"><bean:message bundle="Wayproemployee" key="employeename"/></a>
                    <s:OrderImg form="/cms/yytwayproemployee/YYTWayproemployeeForm" field="employeename"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('isnet')"><bean:message bundle="Wayproemployee" key="isnet"/></a>
                    <s:OrderImg form="/cms/yytwayproemployee/YYTWayproemployeeForm" field="isnet"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('subname')"><bean:message bundle="Wayproemployee" key="subname"/></a>
                    <s:OrderImg form="/cms/yytwayproemployee/YYTWayproemployeeForm" field="subname"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('empstatus')"><bean:message bundle="Wayproemployee" key="empstatus"/></a>
                    <s:OrderImg form="/cms/yytwayproemployee/YYTWayproemployeeForm" field="empstatus"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('cardid')"><bean:message bundle="Wayproemployee" key="cardid"/></a>
                    <s:OrderImg form="/cms/yytwayproemployee/YYTWayproemployeeForm" field="cardid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('telephone')"><bean:message bundle="Wayproemployee" key="telephone"/></a>
                    <s:OrderImg form="/cms/yytwayproemployee/YYTWayproemployeeForm" field="telephone"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('pvtemail')"><bean:message bundle="Wayproemployee" key="pvtemail"/></a>
                    <s:OrderImg form="/cms/yytwayproemployee/YYTWayproemployeeForm" field="pvtemail"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('intime')"><bean:message bundle="Wayproemployee" key="intime"/></a>
                    <s:OrderImg form="/cms/yytwayproemployee/YYTWayproemployeeForm" field="intime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('outtime')"><bean:message bundle="Wayproemployee" key="outtime"/></a>
                    <s:OrderImg form="/cms/yytwayproemployee/YYTWayproemployeeForm" field="outtime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('state')"><bean:message bundle="Wayproemployee" key="isunpb"/></a>
                    <s:OrderImg form="/cms/yytwayproemployee/YYTWayproemployeeForm" field="_ne_state"/>
                </td>
                 <td>
                 	<a href="javascript:doOrderby('istenseed')"><bean:message bundle="Wayproemployee" key="istenseed"/></a>
                 	<s:OrderImg form="/cms/yytwayproemployee/YYTWayproemployeeForm" field="istenseed"/>
                </td>
                 <td>
                    <a href="javascript:doOrderby('istenseed')"><bean:message bundle="Wayproemployee" key="isinternal"/></a>
                 	<s:OrderImg form="/cms/yytwayproemployee/YYTWayproemployeeForm" field="isinternal"/>
                </td>
                 <td>
                    <bean:message bundle="Wayproemployee" key="emplevel"/>
                </td>
                <td>
                    <bean:message bundle="Wayproemployee" key="empattr"/>
                </td>
                <td>
                    <bean:message bundle="Wayproemployee" key="empattrmemo"/>
                </td>
                <td>
                    <bean:message bundle="Wayproemployee" key="empattr2"/>
                </td>
                <td>
                    <bean:message bundle="Wayproemployee" key="oprcode2"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
            	 <c:url value="/cms/yytwayproemployee.do?CMD=EDIT" var="urlContent">
                     <c:param name="PK" value="${item.employeeid}"/>
                 </c:url>
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'" >
                 	 <td>
                        <c:if test="${item.empstatus == 0}">
                        	 <input type="checkbox" name="_selectitem" value="<c:out value='${item.employeeid}' />"
                            	    onclick="checkOne();" class="table_checkbox">
                        </c:if>
                        <c:if test="${item.empstatus == 1}">
                        	<input type="checkbox" name="_selectitem" value="<c:out value='${item.employeeid}' />"
                            	    onclick="checkOne();" class="table_checkbox" disabled="disabled">
                        </c:if>
                     </td>
                     <td>
                     	<c:choose>
                     	<c:when test="${requestScope.CALC=='TRUE'}">
                     		<c:out value="${item.employeeid}"/>
                     	</c:when>
                     	<c:otherwise>
	                     	<a href='<c:out value="${urlContent}"/>'>
	                         	<c:out value="${item.employeeid}"/>
	                        </a>
                        </c:otherwise>
                        </c:choose>
                     </td>
                     <td><c:out value="${item.wayid}"/></td>
                     <td><c:out value="${item.employeename}"/></td>
                     <td><s:Code2Name code="${item.isnet}" definition="$CH_ISNET"/></td>
                     <td><c:out value="${item.subname}"/></td>
                     <td><s:Code2Name code="${item.empstatus}" definition="$CH_EMPSTATUS"/></td>
                     <td><c:out value="${item.cardid}"/></td>
                     <td><c:out value="${item.telephone}"/></td>
                     <td><c:out value="${item.pvtemail}"/></td>
                     <td>
                     	<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.intime}" />
                     </td>
                     <td>
                     	<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.outtime}" />
                     </td>
                     <td>
                     	<s:Code2Name code="${item.state}" definition="#ISUNPB"/>
                     </td>
                     <td>
                     	<s:Code2Name code="${item.istenseed}" definition="#IS_UNV_YN"/>
                     </td>
                     <td>
                     	<s:Code2Name code="${item.isinternal}" definition="#IS_UNV_YN"/>
                     </td>
                     <td>
                     	<s:Code2Name code="${item.emplevel}" definition="$CH_BBCUNPBLEVEL"/>
                     </td>
                     <td>
                     	<s:Code2Name code="${item.empattr}" definition="#EMPROLE"/>
                     </td>
                     <td><c:out value="${item.empattrmemo}"/></td>
                     <td>
                     	<s:Code2Name code="${item.empattr2}" definition="$CH_EMPATTR2"/>
                     </td>
                     <td><c:out value="${item.oprcode2}"/></td>
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
