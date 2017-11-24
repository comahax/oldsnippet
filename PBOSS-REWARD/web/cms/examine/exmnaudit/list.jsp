<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
    String ID_1 = "CH_VIEWFOREXMNAUDIT";
    String ID_2 = "00010702";
    String ID_3 = "00010703";
    String ID_4 = "00010704";
%>
<html>
<head>
    <title><bean:message bundle="exmnaudit" key="titleList"/></title>
    <script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
	 <script type="text/javascript" src="<%=contextPath%>/js/jquery/jquery-1.3.2.js"></script>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_ne_seqid', '<bean:message bundle="exmnaudit" key="seqid"/>', 'f', 'false', '14');
            addfield('_se_presenter', '<bean:message bundle="exmnaudit" key="presenter"/>', 'c', 'false', '16');
            if(document.getElementsByName("_dnl_submissiontime")[0].value!=""){
            	if(!checkDateByMask(document.getElementsByName("_dnl_submissiontime")[0].value,'yyyy-MM-dd HH:mm:ss',1)){
					var alertstr='<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[<bean:message bundle="exmnaudit" key="submissiontime"/>>=]</span>日期格式不对，格式应为yyyy-MM-dd HH:mm:ss</span>';
					errorMessageShow(alertstr);
					return false;
				}
			}
			if(document.getElementsByName("_dnm_submissiontime")[0].value!=""){
				if(!checkDateByMask(document.getElementsByName("_dnm_submissiontime")[0].value,'yyyy-MM-dd HH:mm:ss',1)){
						var alertstr='<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[<bean:message bundle="exmnaudit" key="submissiontime"/><=]</span>日期格式不对，格式应为yyyy-MM-dd HH:mm:ss</span>';
						errorMessageShow(alertstr);
						return false;
				}
			}
            addfield('_se_state', '<bean:message bundle="exmnaudit" key="state"/>', 'c', 'false', '32');
            addfield('_se_wayid', '<bean:message bundle="exmnaudit" key="wayid"/>', 'c', 'false', '32');
            addfield('_ne_exmnid', '<bean:message bundle="exmnaudit" key="exmnid"/>', 'f', 'false', '6');
            addfield('_ne_exmnstdid', '<bean:message bundle="exmnaudit" key="exmnstdid"/>', 'f', 'false', '6');
            addfield('_snm_exmnperiod', '<bean:message bundle="exmnaudit" key="_snm_exmnperiod"/>', 'c', 'false', '6');
            addfield('_snl_exmnperiod', '<bean:message bundle="exmnaudit" key="_snl_exmnperiod"/>', 'c', 'false', '6');
            return checkval(window);
        }
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/examine/exmnaudit.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/examine/exmnaudit/ExmnauditForm']}"/>
	<input type="hidden" id="opercode" name="opercode" value="<c:out value="${_USER.opercode}"/>"/>
    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>
    			<bean:message bundle="exmnaudit" key="titleList"/>
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
               
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="exmnaudit" key="presenter"/>:</td>
                <td width="30%" class="form_table_left">
                    <s:zoom definition="#OPERATORNAME" property="_se_presenter" styleClass="form_input_1x" />
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="exmnaudit" key="auditor"/>:</td>
                <td width="30%" class="form_table_left">
                	<s:RewardPurChk controlid="<%=ID_1%>" disableChild="true">
                    <s:zoom definition="#OPERATORNAME" property="_se_auditor" styleClass="form_input_1x" />
                    </s:RewardPurChk>
                </td>
            </tr>
              <tr>
            	<td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="exmnaudit" key="wayid"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_wayid"></html:text>
                     <input type="button" value="..." class="clickbutton"
								onclick="showSelectWay3(this,'_se_wayid','','','AG');this.value='...';" />
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="exmnaudit" key="state"/>:</td>
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
            	<td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="exmnaudit" key="_snl_exmnperiod"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_snl_exmnperiod"  ></html:text>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="exmnaudit" key="_snm_exmnperiod"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_snm_exmnperiod" ></html:text>
                </td>
            </tr>
            <tr>
            	<td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="exmnaudit" key="_dnl_submissiontime"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnl_submissiontime"  onclick="this.value=selectDatetime();"></html:text>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><bean:message bundle="exmnaudit" key="_dnm_submissiontime"/>:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_dnm_submissiontime"  onclick="this.value=selectDatetime();"></html:text>
                </td>
            </tr>
           
          
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                        <input type="button" id="btnSubmit" name="btnSubmit" class="button_2" onmouseover="buttonover(this);"
                        	onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                       		 value="<bean:message bundle="public" key="button_submit"/>" onClick="doBtnsubmit('/cms/examine/exmnaudit.do?CMD=Submitaudit')">
                       		 
		                  <input type="button" id="btnAllsubmit" name="btnAllsubmit" class="button_4" onmouseover="buttonover(this);"
		                     onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
		                     value="<bean:message bundle="public" key="button_allSubmit"/>" onClick="doAllsubmit('/cms/examine/exmnaudit.do?CMD=Submitaudit')">
		                  
		                  <input type="button" id="btnCallback" name="btnCallback" class="button_2" onmouseover="buttonover(this);"
		                     onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
		                     value="<bean:message bundle="public" key="button_callback"/>" onClick="doCallback('/cms/examine/exmnaudit.do?CMD=Callback')">
		                     
		                  <input type="button" id="btnAllCallback" name="btnAllCallback" class="button_4" onmouseover="buttonover(this);"
		                     onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
		                     value="<bean:message bundle="public" key="button_allCallback"/>" onClick="doAllCallback('/cms/examine/exmnaudit.do?CMD=Callback')">
                          <input type="button" id="btnAudit" name="btnAudit" class="button_2" onmouseover="buttonover(this);"
		                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
		                        value="<bean:message bundle="public" key="button_audit"/>" onClick="doAudit('/cms/examine/exmnaudit.do?CMD=Audit')">
                     
                     	 <input type="button" id="btnAllAudit" name="btnAllAudit" class="button_4" onmouseover="buttonover(this);"
		                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
		                        value="<bean:message bundle="public" key="button_allAudit"/>" onClick="doAllAudit('/cms/examine/exmnaudit.do?CMD=Audit')">
                          
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
                    <a href="javascript:doOrderby('seqid')"><bean:message bundle="exmnaudit" key="seqid"/></a>
                    <s:OrderImg form="/cms/examine/exmnaudit/ExmnauditForm" field="seqid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('presenter')"><bean:message bundle="exmnaudit" key="presenter"/></a>
                    <s:OrderImg form="/cms/examine/exmnaudit/ExmnauditForm" field="presenter"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('submissiontime')"><bean:message bundle="exmnaudit" key="submissiontime"/></a>
                    <s:OrderImg form="/cms/examine/exmnaudit/ExmnauditForm" field="submissiontime"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('auditor')"><bean:message bundle="exmnaudit" key="auditor"/></a>
                    <s:OrderImg form="/cms/examine/exmnaudit/ExmnauditForm" field="auditor"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('auditopinion')"><bean:message bundle="exmnaudit" key="exmnname"/></a>
                    <s:OrderImg form="/cms/examine/exmnaudit/ExmnauditForm" field="exmnid"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('itemgradedid')"><bean:message bundle="exmnaudit" key="exmnstdname"/></a>
                    <s:OrderImg form="/cms/examine/exmnaudit/ExmnauditForm" field="exmnstdid"/>
                </td>
                 <td>
                    <a href="javascript:doOrderby('itemgradedid')"><bean:message bundle="exmnaudit" key="exmnperiod"/></a>
                    <s:OrderImg form="/cms/examine/exmnaudit/ExmnauditForm" field="exmnperiod"/>
                </td>
                 <td>
                    <a href="javascript:doOrderby('itemgradedid')"><bean:message bundle="exmnaudit" key="penalmark"/></a>
                    <s:OrderImg form="/cms/examine/exmnaudit/ExmnauditForm" field="penalmark"/>
                </td>
                <td>
                    <a href="javascript:doOrderby('state')"><bean:message bundle="exmnaudit" key="state"/></a>
                    <s:OrderImg form="/cms/examine/exmnaudit/ExmnauditForm" field="state"/>
                </td>
            </tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <c:url value="/cms/examine/exmnaudit.do?CMD=EDIT" var="urlContent">
                     <%//this param name must "PK" %>
                     <c:param name="PK" value="${item.seqid}"/>
                     <%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
                 </c:url>
                 <tr class="table_style_content" align="center">
                     <td>
                         <input type="checkbox" name="_selectitem" value="<c:out value='${item.seqid}' />,<c:out value='${item.itemgradedid}' />"
                           auditor="<c:out value='${item.auditor}' />"   exmnperiod="<c:out value='${item.exmnperiod}' />" state="<c:out value='${item.state}' />"  onclick="checkOne();" class="table_checkbox">
                     </td>
                     <td>
                         <c:out value="${item.seqid}"/>
                     </td>
                     <td><s:Code2Name definition="#OPERATORNAME" code="${item.presenter}"/></td>
                     <td><c:out value="${item.submissiontime}"/></td>
                     <td><s:Code2Name definition="#OPERATORNAME" code="${item.auditor}"/></td>
                     <td><s:Code2Name definition="#EXAMINE" code="${item.exmnid}"/></td>
                     <td><s:Code2Name definition="#EXAMINESTD" code="${item.exmnstdid}"/></td>
                     <td><c:out value="${item.exmnperiod}"/></td>
                     <td><c:out value="${item.penalmark}"/></td>
                     <td><s:Code2Name definition="$CH_AUDITSTATE" code="${item.state}"/></td>
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
		 var now= new Date(); 
		 var year=now.getYear();
		 var month=now.getMonth()+1;
		 if(month<10)
		 	month="0"+month;
		 var yyyymm=year+""+month;
		 var selectitems="";
		 var opercode=$("#opercode").val();
		checkedBoxs.each(function(i) {
			if(jQuery(this).attr("state")!='1'||jQuery(this).attr("exmnperiod")!=yyyymm || jQuery(this).attr("auditor")!=opercode){
				jQuery(this).attr("checked",false);
				if(submitState){
					submitState=false;
				}
			}
			if(selectitems=="")
				selectitems=jQuery(this).val();
			else
				selectitems+="|"+jQuery(this).val()
		});
		if(!submitState){
			alert("只能选择考核周期为当月通过状态并且审核人为当前用户的记录进行提交,请核实后再操作!");
			return;
		}
		//判断“考核信息登记”的“状态[STATE]”为通过，并判断该当前人是否该“考核信息登记”的最新审核人，
		jQuery.ajax({
			type:"POST",
			url:"<%=contextPath %>/cms/examine/exmnaudit.do?CMD=Submitvalidate",
			async:false, //同步
			data:"selectitems="+selectitems,			
			success:function(msg){
				if(msg=='YES'){
					var returnValue=window.showModalDialog('<%=contextPath %>/cms/examine/itemgraded.do?CMD=auditingRoleList',window,"dialogWidth=500px;dialogHeight=430px;status:no;scroll=yes;");
					if(returnValue!=undefined){
						var strs=returnValue.split(",");
						formList.action = contextPath + url+"&operid="+strs[0]+"&opername="+strs[1];
			    		formList.submit();
					}
				}
				if(msg=='NO'){
					alert("只能提交一次或您不是最新的审核人,请核实后再操作!");
					return;
				}
			}
		});
		
		
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
			if(jQuery(this).attr("state")!='0' || jQuery(this).attr("auditor")!=opercode){
				jQuery(this).attr("checked",false);
				if(callbackState)
					callbackState=false;
			}
		});
		if(!callbackState){
			alert("只能选择未审核状态并且审核人为当前用户的记录进行收回,请核实后再操作!");
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
	/*
	*审核
	*/
	function doAudit(url){
		var checkedBoxs=$(":checkbox[name='_selectitem']:checked");
		if(checkedBoxs.length==0){
			alert("请选择记录！");
			return;
		}
		var callbackState=true;
		var opercode=$("#opercode").val();
		checkedBoxs.each(function(i) {
			if(jQuery(this).attr("state")!='0' || jQuery(this).attr("auditor")!=opercode){
				jQuery(this).attr("checked",false);
				if(callbackState)
					callbackState=false;
			}
		});
		if(!callbackState){
			alert("只能选择未审核状态并且审核人为当前用户的记录进行审核,请核实后再操作!");
			return;
		}
		var returnValue=window.showModalDialog('<%=contextPath %>/cms/examine/exmnaudit/audit.jsp',window);
		if(returnValue!=undefined){
			var strs=returnValue.split(",");
			formList.action = contextPath + url+"&state="+strs[0]+"&auditopinion="+strs[1];
    		formList.submit();
		}
	}
	/*
	*全部审核
	*/
	function doAllAudit(url){
		var returnValue=window.showModalDialog('<%=contextPath %>/cms/examine/exmnaudit/audit.jsp',window);
		if(returnValue!=undefined){
		var strs=returnValue.split(",");
			formList.action = contextPath + url+"&auditType=all&state="+strs[0]+"&auditopinion="+strs[1];
	    	formList.submit();
    	}
	}
</script> 
</html>
