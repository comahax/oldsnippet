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
    <title><bean:message bundle="Wayproemployee" key="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/rescommon.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            return checkval(window);
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
<html:form action="/cms/empconfirm.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
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
    			<bean:message bundle="Wayproemployee" key="titlelist2"/>
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
    			<td width="80" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="Wayproemployee" key="wayid"/>:
            	</td>
            	<td class="form_table_left">
            		<s:zoom definition="#WAY" property="_sk_wayid" condition="waytype:AG;" styleClass="form_input_1x" nameOnly="false" readonly="true"/>
            	</td>
    			<td width="126" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="Wayproemployee" key="employeename"/>:
            	</td>
            	<td class="form_table_left">
               	    <html:text styleClass="form_input_1x" property="_sk_employeename" />
            	</td>
            </tr>
            <tr>
    			<td width="80" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="Wayproemployee" key="isnet"/>:
            	</td>
            	<td class="form_table_left">
               	    <html:select property="_ne_isnet">
						<option />
							<s:Options definition="$CH_ISNET" />
					</html:select>
            	</td>
            	<td width="126" height="20" align="right" class="form_table_right" >
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
    			<td width="80" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="Wayproemployee" key="telephone"/>:
            	</td>
            	<td class="form_table_left">
            		<html:text styleClass="form_input_1x" property="_sk_telephone" />
            	</td>
            	<td width="126" height="20" align="right" class="form_table_right" >
            		<bean:message bundle="Wayproemployee" key="isunpb"/>:
            	</td>
            	<td class="form_table_left">
            		<html:select property="_ne_state">
						<option />
							<s:Options definition="#ISUNPB" />
					</html:select>
            	</td>
            </tr>
            <tr>
    			<td width="80" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="Wayproemployee" key="citycompany"/>:
            	</td>
            	<td class="form_table_left">
            		<html:select property="_ne_citycompid" styleId="citycompid">
						<option />
						<option value="all">ȫ��</option>
							<s:Options definition="#CITYCOMPANY" />
					</html:select>
            	</td>
            	<td width="126" height="20" align="right" class="form_table_right" >
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
    			<td width="80" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="Wayproemployee" key="empattr"/>:
            	</td>
            	<td class="form_table_left">
            		<html:select property="_se_empattr" >
						<option />
							<s:Options definition="#EMPROLE" />
					</html:select>
            	</td>
            	<td width="126" height="20" align="right" class="form_table_right" >
            		<bean:message bundle="Wayproemployee" key="smsstatus"/>:
            	</td>
            	<td class="form_table_left">
            		<html:select property="_ne_smsstatus" >
						<option />
						<s:Options definition="#SMSSTATUS" />
					</html:select>
            	</td>
            </tr>
             <tr>
    			<td width="80" height="20" align="right" class="form_table_right" >
                	<bean:message bundle="Wayproemployee" key="isinternal"/>:
            	</td>
            	<td class="form_table_left">
            		<html:select property="_ne_isinternal" styleId="isinternal">
						<option />
							<s:Options definition="#IS_UNV_YN" />
					</html:select>
            	</td>
            	<td width="126" height="20" align="right" class="form_table_right" >
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
                <td align=right>
                		<input type="button" class="query"onmouseover="buttonover(this);" onclick="doQuery2();" 
                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                                value="<bean:message bundle="public" key="button_search"/>" />
                </td>
			</tr>
		</table>
	</div>

    <div class="table_div">
      <div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
                <td>
                    <a href="javascript:doOrderby('employeeid')"><bean:message bundle="Wayproemployee" key="employeeid"/></a>
                    <s:OrderImg form="/cms/wayproemployee/WayproemployeeForm" field="employeeid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('wayid')"><bean:message bundle="Wayproemployee" key="wayid"/></a>
                    <s:OrderImg form="/cms/wayproemployee/WayproemployeeForm" field="wayid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('employeename')"><bean:message bundle="Wayproemployee" key="employeename"/></a>
                    <s:OrderImg form="/cms/wayproemployee/WayproemployeeForm" field="employeename"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('isnet')"><bean:message bundle="Wayproemployee" key="isnet"/></a>
                    <s:OrderImg form="/cms/wayproemployee/WayproemployeeForm" field="isnet"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('subname')"><bean:message bundle="Wayproemployee" key="subname"/></a>
                    <s:OrderImg form="/cms/wayproemployee/WayproemployeeForm" field="subname"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('empstatus')"><bean:message bundle="Wayproemployee" key="empstatus"/></a>
                    <s:OrderImg form="/cms/wayproemployee/WayproemployeeForm" field="empstatus"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('cardid')"><bean:message bundle="Wayproemployee" key="cardid"/></a>
                    <s:OrderImg form="/cms/wayproemployee/WayproemployeeForm" field="cardid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('telephone')"><bean:message bundle="Wayproemployee" key="telephone"/></a>
                    <s:OrderImg form="/cms/wayproemployee/WayproemployeeForm" field="telephone"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('pvtemail')"><bean:message bundle="Wayproemployee" key="pvtemail"/></a>
                    <s:OrderImg form="/cms/wayproemployee/WayproemployeeForm" field="pvtemail"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('intime')"><bean:message bundle="Wayproemployee" key="intime"/></a>
                    <s:OrderImg form="/cms/wayproemployee/WayproemployeeForm" field="intime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('outtime')"><bean:message bundle="Wayproemployee" key="outtime"/></a>
                    <s:OrderImg form="/cms/wayproemployee/WayproemployeeForm" field="outtime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('state')"><bean:message bundle="Wayproemployee" key="isunpb"/></a>
                    <s:OrderImg form="/cms/wayproemployee/WayproemployeeForm" field="_ne_state"/>
                </td>
                 <td>
                 	<a href="javascript:doOrderby('istenseed')"><bean:message bundle="Wayproemployee" key="istenseed"/></a>
                 	<s:OrderImg form="/cms/wayproemployee/WayproemployeeForm" field="istenseed"/>
                </td>
                 <td>
                    <a href="javascript:doOrderby('istenseed')"><bean:message bundle="Wayproemployee" key="isinternal"/></a>
                 	<s:OrderImg form="/cms/wayproemployee/WayproemployeeForm" field="isinternal"/>
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
                    <bean:message bundle="Wayproemployee" key="empstatus"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <tr class="table_style_content" align="center">
                     <td>
                     		<c:out value="${item.employeeid}"/>
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
                     <td><s:Code2Name code="${item.smsstatus}" definition="#SMSSTATUS"/></td>
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
