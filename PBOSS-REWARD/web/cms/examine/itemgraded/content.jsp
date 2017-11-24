<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%
    String ID_1 = "00010701";
    String ID_2 = "00010702";
    String ID_3 = "00010703";
    String ID_4 = "00010704";
%>
<html>
<head> 
    <title><bean:message bundle="itemgraded" key="titleUpdate"/></title>
     <script type="text/javascript" src="<%=contextPath%>/js/pub/xmlhttp.js"></script>
    
    <script language="JavaScript">
        function ev_checkval() {
            addfield('seqid', '<bean:message bundle="itemgraded" key="seqid"/>', 'f', true, '14');
            addfield('wayid', '<bean:message bundle="itemgraded" key="wayid"/>', 'c', false, '32');
            addfield('exmnid', '<bean:message bundle="itemgraded" key="exmnid"/>', 'f', false, '6');
            addfield('exmnstdid', '<bean:message bundle="itemgraded" key="exmnstdid"/>', 'f', false, '6');
            addfield('exmnperiod', '<bean:message bundle="itemgraded" key="exmnperiod"/>', 'c', false, '6');
            addfield('penalmark', '<bean:message bundle="itemgraded" key="penalmark"/>', 'f', false, '5','2');
            addfield('memo', '<bean:message bundle="itemgraded" key="memo"/>', 'c', true, '512');
            addfield('registercode', '<bean:message bundle="itemgraded" key="registercode"/>', 'c', true, '16');
            addfield('state', '<bean:message bundle="itemgraded" key="state"/>', 'c', true, '2');
            addfield('curauditor', '<bean:message bundle="itemgraded" key="curauditor"/>', 'c', true, '32');

            return (checkval(window)&& checkData());
        }
         function checkData(){
         	var penalmark=document.getElementsByName("penalmark")[0].value;
        	if(penalmark<0){
        		var alertstr="<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[<bean:message bundle="itemgraded" key="penalmark"/>]</span>必须为大于等0的实数</span></span>";
				errorMessageShow(alertstr);
				return false;
        	}
        	//判断考核周期输入格式YYYYMM
			if(!checkDateByMask(document.getElementsByName("exmnperiod")[0].value,'yyyyMM',1)){
				var alertstr='<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[<bean:message bundle="itemgraded" key="exmnperiod"/>]</span>日期格式不对，格式应为yyyyMM</span>';
				 errorMessageShow(alertstr);
				 return false;
			}
        	return true;
         }
        function showWayInfo(control, idCtlId, showParent, showOfCitycom, waytype, waysubtype,runmode) {
			var url = contextPath + "/cms/way.do?CMD=selectwaytree";
			if (showParent != null) {
				url = url + "&showParent=" + showParent; 
			}
			if (showOfCitycom != null) {
				url = url + "&showOfCitycom=" + showOfCitycom; 
			}
			if (waytype != null) {
				url = url + "&waytype=" + waytype; 
			}
			if (waysubtype != null) {
				url = url + "&waysubtype=" + waysubtype; 
			}
			if(runmode !=null){
				url = url + "&runmode=" + runmode; 
			}
			if (control.form.menuTokenId != null && control.form.menuTokenId.value != null) {
				url += "&menuTokenId=" + control.form.menuTokenId.value; 
			}
			var rtn = window.showModalDialog(url, control, "dialogWidth=405px;dialogHeight=430px;status:no;scroll=yes;");
			if (rtn != null && rtn.length) {
				control.value = idCtlId == null ? rtn[0] : rtn[0] + " " + rtn[1];  	//name   
				if (document.all(idCtlId) != null) {
					document.all(idCtlId).value = rtn[0]; 
					startAjax("<%=contextPath %>/cms/examine/itemgraded.do?CMD=GetWayinfo&wayid="+rtn[0],"callback()","text","GET",false); 
				} //id 
				return rtn;
			} else {
				if (rtn != null) {
					control.value = rtn; 
					return rtn;
				}
			}
		}
		function callback(){
			if(mypoint!=null){
				if(mypoint=='nooprnway'){
					alert("所选渠道没有渠道评分授权，请重新选择！");
					document.all("adtypecode").value="";
					document.all("starlevel").value="";
					document.getElementsByName("wayid")[0].value=""
					showWayInfo(document.getElementById("waybutton"),'wayid','','','AG') 
					return;
				}
				var rtns=mypoint.split(",");
				document.all("adtypecode").value=rtns[0];
				document.all("starlevel").value=rtns[1];
				
				if(document.getElementsByName("exmnstdid")[0].value!='')
        			document.getElementsByName("exmnstdid")[0].value="";
        		if(document.getElementsByName("exmnid")[0].value!='')
        			document.getElementsByName("exmnid")[0].value="";
			}
		}
		 function showExamineInfo(){
        	var adtype=document.getElementsByName("adtypecode")[0].value;
        	var starlevel=document.getElementsByName("starlevel")[0].value;
        	if(adtype==null || adtype==''){
        		alert("请先选择渠道后,再选考核标识!");
        		return;
        	}
        		
        	var returnValue=window.showModalDialog('<%=contextPath %>/cms/examine/examine.do?CMD=examinelist&_se_state=1&_sk_adtype='+adtype+'&_sk_starlevel='+starlevel,window,"dialogWidth=500px;dialogHeight=430px;status:no;scroll=yes;");
        	if(returnValue!=undefined){
        		var strs=returnValue.split(",");
        		document.getElementsByName("exmnid")[0].value=strs[0];
        		if(document.getElementsByName("exmnname")[0]){
        			document.getElementsByName("exmnname")[0].value=strs[1];
        		}
        		if(document.getElementsByName("exmnstdid")[0].value!='')
        			document.getElementsByName("exmnstdid")[0].value="";
        	}
        }
        function showExaminestdInfo(){
        	var exmnid=document.getElementsByName("exmnid")[0].value;
        	if(exmnid==null || exmnid==''){
        		alert("请先选择考核标识后,再选指标标识!");
        		//showExamineInfo();
        		return;
        	}
        	
        	var returnValue=window.showModalDialog('<%=contextPath %>/cms/examine/examinestd.do?CMD=examinestdList&exmnid='+exmnid,window,"dialogWidth=600px;dialogHeight=500px");
        	if(returnValue!=undefined){
        		var strs=returnValue.split(",");
        		document.getElementsByName("exmnstdid")[0].value=strs[0];
        		if(document.getElementsByName("exmnstdname")[0]){
        			document.getElementsByName("exmnstdname")[0].value=strs[1];
        		}
        	}
        }
    </script>
</head>
<body>
<div class="table_container">
<html:form action="/cms/examine/itemgraded.do?CMD=SAVE" styleId="formItem" method="post">
    <html:hidden property="cmdState"/>

    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize"/>
    <html:hidden property="_ne_seqid"/>
    <html:hidden property="_se_wayid"/>
    <html:hidden property="_ne_exmnid"/>
    <html:hidden property="_ne_exmnstdid"/>
    <html:hidden property="_snm_exmnperiod"/>
    <html:hidden property="_snl_exmnperiod"/>
    <html:hidden property="_se_state"/>
    <html:hidden property="_se_curauditor"/>
    <html:hidden property="adtypecode"/>
    <html:hidden property="starlevel"/>
    <html:hidden property="seqid"/>
     <html:hidden property="registercode"/>
     <html:hidden property="state"/>
     <html:hidden property="memo"/>
    <c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}"/>
    <c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}"/>
    <c:set var="form" scope="request" value="${requestScope['/cms/examine/itemgraded/ItemgradedForm']}"/>
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
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="itemgraded" key="wayid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}"> 
                            <html:text styleClass="form_input_1x" property="wayid" readonly="true"/>
                            <input type="button" value="..." class="clickbutton" id="waybutton"
								onclick="showWayInfo(this,'wayid','','','AG');this.value='...';" />
							<font color=red>*</font>
                        </c:when>
                        <c:otherwise> 
                            <html:text styleClass="form_input_1x" property="wayid" disabled="true"/>
                            <font color=red>*</font>
                        </c:otherwise>
                    </c:choose>
                    
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="itemgraded" key="exmnid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="exmnid" readonly="true"/>
                            <input type="button" value="..." class="clickbutton" id="exmnidbutton"
								onclick="showExamineInfo();this.value='...';" />
							<font color=red>*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="exmnid" disabled="true"/>
                            <font color=red>*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="itemgraded" key="exmnstdid"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="exmnstdid" readonly="true"/>
                            <input type="button" value="..." class="clickbutton" id="exmnstdidbutton"
								onclick="showExaminestdInfo();this.value='...';" />
							<font color=red>*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="exmnstdid" disabled="true"/>
                            <font color=red>*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="itemgraded" key="exmnperiod"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="exmnperiod" />
                            <font color=red>*</font>&nbsp;(格式：201002)
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="exmnperiod" disabled="true"/>
                            <font color=red>*</font>&nbsp;(格式：201002)
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="itemgraded" key="penalmark"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:text styleClass="form_input_1x" property="penalmark" />
                            <font color=red>*</font>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="penalmark" disabled="true"/>
                            <font color=red>*</font>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td width="20%" align="right" class="form_table_right"><div class="field-require"><bean:message bundle="itemgraded" key="memo"/>:</div></td>
                <td width="80%" align="left" class="form_table_left">
                    <c:choose>
                        <c:when test="${edtState}">
                            <html:textarea styleClass="form_textarea_on_4" property="memo"/>
                        </c:when>
                        <c:otherwise>
                             <html:textarea styleClass="form_textarea_on_4" property="memo" disabled="true"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </table>
    </div>

    <div class="table_div">
        <table class="table_button_list">
            <tr>
                <td width="100%" class="form_table_center">
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnSave" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_save"/>" class="submit"
                           onclick="doSave('/cms/examine/itemgraded.do?CMD=SAVE')"/>
                    <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)"
                           value="<bean:message bundle="public" key="button_return"/>" class="close"
                           onclick="doReturn('/cms/examine/itemgraded.do?CMD=LIST')">
                </td>
            </tr>
        </table>
    </div>
</html:form> 
</div>
</body>
 <script language="JavaScript">
     	if(document.getElementsByName("cmdState")[0].value=='EDIT'){//编辑的时候
     		var opercode=document.getElementById("opercode").value;
     		var registercode=document.getElementsByName("registercode")[0].value;
     		if(opercode!=registercode){//当录入工号不是当前工号时
     			document.getElementsByName("wayid")[0].disabled=true;
     			document.getElementById("waybutton").disabled=true;
     			document.getElementsByName("exmnid")[0].disabled=true;
     			document.getElementById("exmnidbutton").disabled=true;
     			document.getElementsByName("exmnstdid")[0].disabled=true;
     			document.getElementById("exmnstdidbutton").disabled=true;
     			document.getElementsByName("exmnperiod")[0].disabled=true;
     			document.getElementsByName("penalmark")[0].disabled=true;
     			document.getElementsByName("memo")[0].disabled=true;
     			document.getElementsByName("btnSave")[0].disabled=true;
     		}
     	}
     	
 </script>
  
</html>  
