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
    <title><bean:message bundle="mapping" key="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_ne_seqid', '<bean:message bundle="mapping" key="seqid"/>', 'f', 'false', '14');
            addfield('_ne_exmnid', '<bean:message bundle="mapping" key="exmnid"/>', 'f', 'false', '6');
            addfield('_se_cityid', '<bean:message bundle="mapping" key="cityid"/>', 'c', 'false', '2');
            return checkval(window);
        }
         function doMyDelete(url){
        	var selectitem=document.getElementsByName("_selectitem");
        	var provincialright=document.getElementById("provincialright").value;
        	for(var i=0;i<selectitem.length;i++){
        		if(selectitem[i].checked==true){
	        		var cityid=selectitem[i].getAttribute("cityid");
	        		if(provincialright=='YES' && cityid!='GD'){//省公司，但不是省公司考核
		     			var alertstr="<span class=\'errorkey\'>所有的考核记录含有地市特有，您无法删除！</span>";
						errorMessageShow(alertstr);
						return false;
		     		}else if(provincialright!='YES'&& cityid=='GD'){//不是省公司，是省公司的考核
		     				var alertstr="<span class=\'errorkey\'>所有的考核记录含有省公司设置，您无法删除</span>";
							errorMessageShow(alertstr);
							return false;
		     		}
		     	}
        	}
        	
     			doDelete(url);
		}
         function doCheck(cmdSave){
          	if(document.getElementsByName("_ne_exmnid")[0].value==""){
          		alert("请输入要检查的考核ID");
          		return ;
          	}
        	formList.action =contextPath + cmdSave;
    		formList.submit();
        }
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/examine/mapping.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/examine/mapping/MappingForm']}"/>
	<input type="hidden" id="provincialright" name="provincialright" value="<c:out value="${provincialright}"/>">
    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="mapping" key="titleList"/>
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
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="mapping" key="exmnid"/>:</td>
                <td width="30%" class="form_table_left">
                     <s:zoom definition="#EXAMINE" property="_ne_exmnid"
											styleClass="form_input_1x" />
                </td>
                 <c:if test="${provincialright=='YES'}">
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="mapping" key="cityid"/>:</td>
                <td width="30%" class="form_table_left">
                     <html:select property="_se_cityid">
                   		    <option/>
                   		    <s:Options definition="#CITYNAME"/>
                     </html:select>
                </td>
                </c:if>
            </tr>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                            <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/examine/mapping.do')">
                           	<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnCheck" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_check"/>" class="close"
                           onclick="doCheck('/cms/examine/mapping.do?CMD=CHECK')">
                         <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doMyDelete('/cms/examine/mapping.do')">
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
                    <a href="javascript:doOrderby('seqid')"><bean:message bundle="mapping" key="seqid"/></a>
                    <s:OrderImg form="/cms/examine/mapping/MappingForm" field="seqid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('exmnid')"><bean:message bundle="mapping" key="exmnname"/></a>
                    <s:OrderImg form="/cms/examine/mapping/MappingForm" field="exmnid"/>
                </td>
                 <c:if test="${provincialright=='YES'}">
                <td>
                    <a href="javascript:doOrderby('cityid')"><bean:message bundle="mapping" key="cityid"/></a>
                    <s:OrderImg form="/cms/examine/mapping/MappingForm" field="cityid"/>
                </td>
                </c:if>
                <td>
                    <a href="javascript:doOrderby('mmode')"><bean:message bundle="mapping" key="mmode"/></a>
                    <s:OrderImg form="/cms/examine/mapping/MappingForm" field="mmode"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('markul')"><bean:message bundle="mapping" key="markul"/></a>
                    <s:OrderImg form="/cms/examine/mapping/MappingForm" field="markul"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('markll')"><bean:message bundle="mapping" key="markll"/></a>
                    <s:OrderImg form="/cms/examine/mapping/MappingForm" field="markll"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('coeforbase')"><bean:message bundle="mapping" key="coeforbase"/></a>
                    <s:OrderImg form="/cms/examine/mapping/MappingForm" field="coeforbase"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/examine/mapping.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.seqid}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.seqid}' />"
                                onclick="checkOne();" cityid="<c:out value='${item.cityid}' />" class="table_checkbox">
                     </td>
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.seqid}"/></a>
                     </td>
                     <td><s:Code2Name definition="#EXAMINE" code="${item.exmnid}"/></td>
                      <c:if test="${provincialright=='YES'}">
                     <td><s:Code2Name definition="#CITYNAME" code="${item.cityid}"/></td>
					</c:if>
                     <td><s:Code2Name definition="$CH_MMODE" code="${item.mmode}"/></td>
                     <td><c:out value="${item.markul}"/></td>
                     <td><c:out value="${item.markll}"/></td>
                     <td><c:out value="${item.coeforbase}"/></td>
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
