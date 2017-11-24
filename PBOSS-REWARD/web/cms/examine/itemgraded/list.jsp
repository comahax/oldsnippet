<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
    String ID_1 = "CH_EXMNVIEW";
    String ID_2 = "00010702";
    String ID_3 = "00010703";
    String ID_4 = "00010704";
%>
<html>
<head>
    <title><bean:message bundle="itemgraded" key="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
	 <script type="text/javascript" src="<%=contextPath%>/js/jquery/jquery-1.3.2.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_se_wayid', '<bean:message bundle="itemgraded" key="wayid"/>', 'c', 'false', '32');
            addfield('_ne_exmnid', '<bean:message bundle="itemgraded" key="exmnid"/>', 'f', 'false', '6');
            addfield('_ne_exmnstdid', '<bean:message bundle="itemgraded" key="exmnstdid"/>', 'f', 'false', '6');
            addfield('_snm_exmnperiod', '<bean:message bundle="itemgraded" key="_snm_exmnperiod"/>', 'c', 'false', '6');
            addfield('_snl_exmnperiod', '<bean:message bundle="itemgraded" key="_snl_exmnperiod"/>', 'c', 'false', '6');
            addfield('_se_exmnperiod', '<bean:message bundle="itemgraded" key="exmnperiod"/>', 'c', 'false', '6');
            addfield('_se_state', '<bean:message bundle="itemgraded" key="state"/>', 'c', 'false', '2');
            addfield('_se_curauditor', '<bean:message bundle="itemgraded" key="_se_registercode"/>', 'c', 'false', '32');
            return checkval(window);
        }
        function doExcel(){
        	formList.action="<%=contextPath%>/cms/examine/itemgraded.do?CMD=Excel";
        	formList.submit();
        	formList.action="<%=contextPath%>/cms/examine/itemgraded.do?CMD=LIST";
        }
        function goTo(cmdNew) {
		    var url = contextPath + cmdNew;
		    formList.action = url;
		    formList.submit();
		}
		
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/examine/itemgraded.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/examine/itemgraded/ItemgradedForm']}"/>
     <input type="hidden" id="paramvalue" name="paramvalue" value="<c:out value='${paramvalue}' />">
	<input type="hidden" id="opercode" name="opercode" value="<c:out value="${_USER.opercode}"/>"/>
    <!--##################################添加标题内容##################################################-->
  
    <div class="table_div">	
   		 <table width="100%" class="error_text">
    		<html:errors/><s:Msg />
    	</table>
    </div>
	<div class="table_div">
        <table class="form_table">
            <tr>
               
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="itemgraded" key="wayid"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_wayid"></html:text>
                     <input type="button" value="..." class="clickbutton"
								onclick="showSelectWay3(this,'_se_wayid','','','AG');this.value='...';" />
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="itemgraded" key="state"/>:</td>
                <td width="30%" class="form_table_left">
                     <html:select property="_se_state">
               		    <option/>
               		    <s:Options definition="$CH_AUDITSTATE"/>
               		</html:select>
                </td>
            </tr>
            <tr>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="itemgraded" key="exmnid"/>:</td>
                <td width="30%" class="form_table_left">
                      <s:zoom definition="#EXAMINE" property="_ne_exmnid" styleClass="form_input_1x" />
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="itemgraded" key="exmnstdid"/>:</td>
                <td width="30%" class="form_table_left">
                    <s:zoom definition="#EXAMINESTD" property="_ne_exmnstdid" styleClass="form_input_1x" />
                </td>
            </tr>
            <tr>
            	 <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="itemgraded" key="_snl_exmnperiod"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_snl_exmnperiod"></html:text>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="itemgraded" key="_snm_exmnperiod"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_snm_exmnperiod"></html:text>
                </td>
               
            </tr>
            <tr>
                
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="itemgraded" key="registercode"/>:</td>
                <td width="30%" class="form_table_left">
                	<s:RewardPurChk controlid="<%=ID_1%>" disableChild="true">
                    <s:zoom definition="#OPERATORNAME" property="_se_registercode" styleClass="form_input_1x" />
                   	</s:RewardPurChk>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" >&nbsp;</td>
                <td width="30%" class="form_table_left">
                    &nbsp;
                </td>
            </tr>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                            <input type="button" name="btnNew"  class="add" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_new"/>" onClick="doNew('/cms/examine/itemgraded.do')">
                            
                            <input type="button" name="btnNew2" class="button_4" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
							onfocus="buttonover(this)" onblur="buttonout(this)" value="<bean:message bundle="itemgraded" key="batch"/>" onClick="goTo('/cms/examine/itemgraded/upload.do')">
							
							<input type="button" name="btnExcel" class="button_6" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
							onfocus="buttonover(this)" onblur="buttonout(this)" value="<bean:message bundle="itemgraded" key="doExcel"/>" onClick="doExcel();">
							
                        <c:if test="${paramvalue != '0'}">
                           <input type="button" id="btnSubmit" name="btnSubmit" class="button_2" onmouseover="buttonover(this);"
                        	onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                       		 value="<bean:message bundle="public" key="button_submit"/>" onClick="doBtnsubmit('/cms/examine/itemgraded.do?CMD=Submitaudit')">
                       		 
		                  <input type="button" id="btnAllsubmit" name="btnAllsubmit" class="button_4" onmouseover="buttonover(this);"
		                     onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
		                     value="<bean:message bundle="public" key="button_allSubmit"/>" onClick="doAllsubmit('/cms/examine/itemgraded.do?CMD=Submitaudit')">
		                  
		                  <input type="button" id="btnCallback" name="btnCallback" class="button_2" onmouseover="buttonover(this);"
		                     onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
		                     value="<bean:message bundle="public" key="button_callback"/>" onClick="doCallback('/cms/examine/itemgraded.do?CMD=Callback')">
		                     
		                  <input type="button" id="btnAllCallback" name="btnAllCallback" class="button_4" onmouseover="buttonover(this);"
		                     onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
		                     value="<bean:message bundle="public" key="button_allCallback"/>" onClick="doAllCallback('/cms/examine/itemgraded.do?CMD=Callback')">
                     	</c:if>
                            <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                            onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                            value="<bean:message bundle="public" key="button_delete"/>" onClick="doDelete('/cms/examine/itemgraded.do')">
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
                    <a href="javascript:doOrderby('seqid')"><bean:message bundle="itemgraded" key="seqid"/></a>
                    <s:OrderImg form="/cms/examine/itemgraded/ItemgradedForm" field="seqid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('wayid')"><bean:message bundle="itemgraded" key="wayid"/></a>
                    <s:OrderImg form="/cms/examine/itemgraded/ItemgradedForm" field="wayid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('wayid')"><bean:message bundle="itemgraded" key="wayname"/></a>
                    <s:OrderImg form="/cms/examine/itemgraded/ItemgradedForm" field="wayid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('exmnid')"><bean:message bundle="itemgraded" key="exmnname"/></a>
                    <s:OrderImg form="/cms/examine/itemgraded/ItemgradedForm" field="exmnid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('exmnstdid')"><bean:message bundle="itemgraded" key="exmnstdname"/></a>
                    <s:OrderImg form="/cms/examine/itemgraded/ItemgradedForm" field="exmnstdid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('exmnperiod')"><bean:message bundle="itemgraded" key="exmnperiod"/></a>
                    <s:OrderImg form="/cms/examine/itemgraded/ItemgradedForm" field="exmnperiod"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('penalmark')"><bean:message bundle="itemgraded" key="penalmark"/></a>
                    <s:OrderImg form="/cms/examine/itemgraded/ItemgradedForm" field="penalmark"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('registercode')"><bean:message bundle="itemgraded" key="registercode"/></a>
                    <s:OrderImg form="/cms/examine/itemgraded/ItemgradedForm" field="registercode"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('state')"><bean:message bundle="itemgraded" key="state"/></a>
                    <s:OrderImg form="/cms/examine/itemgraded/ItemgradedForm" field="state"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('curauditor')"><bean:message bundle="itemgraded" key="curauditor"/></a>
                    <s:OrderImg form="/cms/examine/itemgraded/ItemgradedForm" field="curauditor"/>
                </td>
                 <td>
                    <a href="javascript:doOrderby('curauditor')"><bean:message bundle="itemgraded" key="auditInfo"/></a>
                    <s:OrderImg form="/cms/examine/itemgraded/ItemgradedForm" field="seqid"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/examine/itemgraded.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.seqid}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <c:url value="/cms/examine/exmnaudit.do?CMD=Auditlist" var="urlAuditlist">
                     <c:param name="_ne_itemgradedid" value="${item.seqid}"/>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                     	<c:if test="${item.state=='1'}">
                         <input type="checkbox" name="_selectitem_no" value="<c:out value='${item.seqid}' />" state="<c:out value='${item.state}' />" 
                              onclick="checkOne();" class="table_checkbox" disabled="disabled">
                        </c:if>
                        <c:if test="${item.state!='1'}">
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.seqid}' />" state="<c:out value='${item.state}' />" 
                             registercode="<c:out value='${item.registercode}' />"     onclick="checkOne();" class="table_checkbox">
                        </c:if>
                     </td>
                     <td>
                         <a href='<c:out value="${urlContent}"/>'><c:out value="${item.seqid}"/></a>
                     </td>
                     <td><c:out value="${item.wayid}"/></td>
                     <td><s:Code2Name definition="#WAY" code="${item.wayid}"/></td>
                     <td><s:Code2Name definition="#EXAMINE" code="${item.exmnid}"/></td>
                     <td><s:Code2Name definition="#EXAMINESTD" code="${item.exmnstdid}"/></td>
                     <td><c:out value="${item.exmnperiod}"/></td>
                     <td><c:out value="${item.penalmark}"/></td>
                     <td><s:Code2Name definition="#OPERATORNAME" code="${item.registercode}"/></td>
                     <td><s:Code2Name definition="$CH_AUDITSTATE" code="${item.state}"/></td>
                     <td><s:Code2Name definition="#OPERATORNAME" code="${item.curauditor}"/></td>
                     <td><a href='<c:out value="${urlAuditlist}"/>'><bean:message bundle="itemgraded" key="clickInfo"/></a></td>
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
<script language="javascript"> 
	/*
	*	提交
	*/
	function doBtnsubmit(url){
		var checkedBoxs=$(":checkbox[name='_selectitem']:checked");
		if(checkedBoxs.length==0){
			alert("请选择记录！");
			return;
		}
		var submitState=true;
		var opercode=$("#opercode").val();
		checkedBoxs.each(function(i) {
			if(jQuery(this).attr("state")!='99'|| jQuery(this).attr("registercode")!=opercode){
				jQuery(this).attr("checked",false);
				if(submitState)
					submitState=false;
			}
		});
		if(!submitState){
			alert("只能选择未提交状态并且录入人为当前用户的记录进行提交,请核实后再操作!");
			return;
		}
		var returnValue=window.showModalDialog('<%=contextPath %>/cms/examine/itemgraded.do?CMD=auditingRoleList',window,"dialogWidth=500px;dialogHeight=430px;status:no;scroll=yes;");
		if(returnValue!=undefined){
			var strs=returnValue.split(",");
			formList.action = contextPath + url+"&operid="+strs[0]+"&opername="+strs[1];
    		formList.submit();
		}
		
	}
	/*
	*	全部提交
	*/
	function doAllsubmit(url){
		var returnValue=window.showModalDialog('<%=contextPath %>/cms/examine/itemgraded.do?CMD=auditingRoleList',window,"dialogWidth=500px;dialogHeight=430px;status:no;scroll=yes;");
		if(returnValue!=undefined){
			var strs=returnValue.split(",");
			formList.action = contextPath + url+"&submitType=all&operid="+strs[0]+"&opername="+strs[1];
    		formList.submit();
		}
	}
	/*
	*	回收
	*/
	function doCallback(url){
		var checkedBoxs=$(":checkbox[name='_selectitem']:checked");
		if(checkedBoxs.length==0){
			alert("请选择记录！");
			return;
		}
		var callbackState=true;
		var opercode=$("#opercode").val();
		checkedBoxs.each(function(i) {
			if(jQuery(this).attr("state")!='0' || jQuery(this).attr("registercode")!=opercode){
				jQuery(this).attr("checked",false);
				if(callbackState)
					callbackState=false;
			}
		});
		if(!callbackState){
			alert("只能选择未审核状态并且录入人为当前用户的记录进行收回,请核实后再操作!");
			return;
		}
		formList.action = contextPath + url;
    	formList.submit();
	}
	/*
	*	全部回收
	*/
	function doAllCallback(url){
		formList.action = contextPath + url+"&callbackType=all";
    	formList.submit();
	}
</script>
</html>
