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
    <title><bean:message bundle="exmnitem" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_ne_exmnid', '<bean:message bundle="exmnitem" key="exmnid"/>', 'f', 'false', '6');
            addfield('_ne_exmnstdid', '<bean:message bundle="exmnitem" key="exmnstdid"/>', 'f', 'false', '6');
            addfield('_se_isvoted', '<bean:message bundle="exmnitem" key="isvoted"/>', 'c', 'false', '1');
            return checkval(window);
        }
         function doReturn(cmdReturn) {
        	document.getElementsByName("_ne_exmnid")[0].value="";
		    formList.action = contextPath + cmdReturn;
		    formList.submit();
		}
		function doMyDelete(url){
			var provincialright=document.getElementById("provincialright").value;
     		var exmncityid=document.getElementById("exmncityid").value;
     		if(provincialright=='YES' && exmncityid!='GD'){//省公司，但不是省公司考核
     			var alertstr="<span class=\'errorkey\'>该考核记录为地市特有，您无法删除！</span>";
				errorMessageShow(alertstr);
				return false;
     		}else
     		 if(provincialright!='YES'&& exmncityid=='GD'){//不是省公司，是省公司的考核
     			var alertstr="<span class=\'errorkey\'>该考核记录为省公司设置，您无法删除</span>";
				errorMessageShow(alertstr);
				return false;
     		}else
     		if(provincialright=='YES' && exmncityid=='GD'){//省公司，是省公司考核
     			if(confirm("删除该考核项明细记录的同时，将删除地市公司针对该考核项明细设置的指标值?"))
     				doDelete(url+"?cityid="+exmncityid);
     		}else{
     			doDelete(url+"?cityid="+exmncityid);
     		}
		}
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/examine/exmnitem.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_ne_exmnid"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/examine/exmnitem/ExmnitemForm']}"/>
	<input type="hidden" id="provincialright" name="provincialright" value="<c:out value="${provincialright}"/>">
	<input type="hidden" id="exmncityid" name="exmncityid" value="<c:out value="${examineVO.cityid}"/>">
    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="exmnitem" key="titleList"/>
   			</td>
    	</tr>
    </table>
    </div>
    <div class="table_div">	
   		 <table width="100%" class="error_text">
    		<html:errors/><s:Msg />
    	</table>
    </div>
    <FIELDSET  class="table_content"><LEGEND>考核信息</LEGEND>
    	<div class="table_div">
    	 <table class="form_table">
            <tr>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="exmnitem" key="exmnname"/>:</td>
                <td width="30%" class="form_table_left" colspan="3">
                   		<c:out value="${examineVO.exmnname}"/>
                </td>
            </tr>
             <c:if test="${provincialright=='YES'and examineVO.cityid=='GD'}">
            <tr>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="exmnitem" key="state"/>:</td>
                <td width="30%" class="form_table_left">
                   		<s:Code2Name definition="$CH_KHSTATE" code="${examineVO.state}"/>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="exmnitem" key="rights"/>:</td>
                <td width="30%" class="form_table_left">
                   		是否允许地市公司修改占比： <c:if test="${examineVO.rights==1}">是</c:if><c:if test="${examineVO.rights==0}">否</c:if>
                </td>
            </tr>
            <tr>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="exmnitem" key="applycityid"/>:</td>
                <td width="30%" class="form_table_left" colspan="3">
                   		<s:MoreCode2Name definition="#CITYNAME" code="${examineVO.applycityid}"/>
                </td>
            </tr>
            </c:if>
            <c:if test="${examineVO.cityid!='GD'}">
            	<td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="exmnitem" key="state"/>:</td>
                <td width="30%" class="form_table_left" colspan="3">
                   		<s:Code2Name definition="$CH_KHSTATE" code="${examineVO.state}"/>
                </td>
            </c:if>
            <tr>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="exmnitem" key="adtype"/>:</td>
                <td width="30%" class="form_table_left" colspan="3">
                   	<s:MoreCode2Name definition="$CH_ADTYPE" code="${examineVO.adtype}"/>
                </td>
            </tr>
           	<tr>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="exmnitem" key="starlevel"/>:</td>
                <td width="30%" class="form_table_left" colspan="3">
                   		<s:MoreCode2Name definition="$CH_STARLEVEL" code="${examineVO.starlevel}"/>
                </td>
            </tr>
            <tr>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="exmnitem" key="memo"/>:</td>
                <td width="30%" class="form_table_left" colspan="3">
                   		<c:out value="${examineVO.memo}"/>
                </td>
            </tr>
        </table>
         </div>
    </FIELDSET>
   
    <FIELDSET class="table_content"><LEGEND>考核指标列表</LEGEND>
	<div class="table_div">
        <table class="form_table">
            <tr>
               
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="exmnitem" key="exmnstdid"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_ne_exmnstdid"></html:text>
                </td>
                 <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="exmnitem" key="exmnstdname"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_sk_exmnstdname"></html:text>
                </td>
            </tr>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                		<c:if test="${(provincialright=='YES' and examineVO.cityid=='GD') or (provincialright!='YES' and examineVO.cityid!='GD') }">
                            <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/examine/exmnitem.do')">
                            <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doMyDelete('/cms/examine/exmnitem.do')">
                        </c:if>
                        <input type="button" class="query" onmouseover="buttonover(this);" onclick="doQuery();"
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
                <td title="<bean:message bundle="public" key="list_title_select"/>">
                    <input type="checkbox" name="allbox" onclick="checkAll();" class="table_checkbox">
                </td>
              
                <td>
                    <a href="javascript:doOrderby('exmnstdid')"><bean:message bundle="exmnitem" key="exmnstdid"/></a>
                    <s:OrderImg form="/cms/examine/exmnitem/ExmnitemForm" field="exmnstdid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('exmnid')"><bean:message bundle="exmnitem" key="exmnstdname"/></a>
                    <s:OrderImg form="/cms/examine/exmnitem/ExmnitemForm" field="exmnstdname"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('isvoted')"><bean:message bundle="exmnitem" key="isvoted"/></a>
                    <s:OrderImg form="/cms/examine/exmnitem/ExmnitemForm" field="isvoted"/>
                </td>
                 <td>
                    <a href="javascript:doOrderby('markmode')"><bean:message bundle="examinestd" key="markmode"/></a>
                    <s:OrderImg form="/cms/examine/examinestd/ExaminestdForm" field="markmode"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('exmnscore')"><bean:message bundle="exmnitem" key="exmnscore"/></a>
                    <s:OrderImg form="/cms/examine/exmnitem/ExmnitemForm" field="exmnscore"/>
                </td>
                 <td>
                    <a href="javascript:doOrderby('exmnstdid')"><bean:message bundle="exmnitem" key="setExmnitemdtl"/></a>
                    <s:OrderImg form="/cms/examine/exmnitem/ExmnitemForm" field="exmnstdid"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/examine/exmnitem.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item[0].exmnid}|${item[0].exmnstdid}"/>
                     <c:param name="_ne_exmnid" value="${item[0].exmnid}"/>
                 </c:url>
                  <c:url value="/cms/examine/exmnitemdtl.do?CMD=LIST" var="urlLookDtl">
                     <c:param name="_ne_exmnstdid" value="${item[0].exmnstdid}"/>
                     <c:param name="_ne_exmnid" value="${item[0].exmnid}"/>
                 </c:url>
                  <c:url value="/cms/examine/exmnitemdtl.do?CMD=NEW" var="urlAddDtl">
                     <c:param name="_ne_exmnstdid" value="${item[0].exmnstdid}"/>
                     <c:param name="_ne_exmnid" value="${item[0].exmnid}"/>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item[0].exmnid}|${item[0].exmnstdid}' />"
                                onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item[0].exmnstdid}"/></a>
                     </td>
                     <td>
                         <c:out value="${item[1].exmnstdname}"/>
                     </td>
                     
                     <td><s:Code2Name definition="#ISVOTED" code="${item[0].isvoted}"/></td>
                      <td><s:Code2Name definition="$CH_MARKMODE" code="${item[1].markmode}"/></td>
                     <td><c:out value="${item[0].exmnscore}"/></td>
                     <td>
                     	 <a href='<c:out value="${urlLookDtl}"/>'><bean:message bundle="exmnitem" key="look"/></a>
                     	 <c:if test="${(provincialright=='YES' and examineVO.cityid=='GD') or (provincialright!='YES' and examineVO.cityid!='GD')}">
                     	 |
                     	 <a href='<c:out value="${urlAddDtl}"/>'><bean:message bundle="exmnitem" key="add"/></a>
                     	 </c:if>
                     </td>
                 </tr>
             </c:forEach>
        </table>
     </div>
   </div>

   <div class="table_div">
		<s:PageNav dpName="LIST"/>
   </div>
   
   </FIELDSET>
   <div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                            <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                            name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_return"/>" class="close"
                            onclick="doReturn('/cms/examine/examine.do?CMD=LIST')">
                </td>
			</tr>
		</table>
	</div>
</html:form>
</div>
</body>
</html>
