<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://ajaxanywhere.sourceforge.net/" prefix="aa"%>
<%
	String ID_1 = "CH_PW_REWARD||CH_PW_REWARD_PROVINCIAL";
%>
<html>
	<head>
		<title><bean:message bundle="stdrewardbs" key="titleUpdate" />
		</title>

		<script type="text/javascript" src="<%=contextPath%>/js/pub/list.js"></script>
		<script type="text/javascript" src="<%=contextPath%>/js/aa.js"></script>
		<script type="text/javascript" language="javascript">
    	var msgNoSelected="<bean:message bundle="public" key="msgNoSelected"/>"
    	var msgConfirmDelete="<bean:message bundle="public" key="msgConfirmDelete"/>"
    	var str = "REGIONSTAR";
    	<c:forEach var="item" items="${requestScope.STARLIST.datas}">
		str = <c:out value="${item.region}" />;
		</c:forEach>
		</script>
		<script language="JavaScript">
		 function forcheck(ob){
		 var TO=true;
    	 if (ob != null) {
         if (ob.length != null) {
            for (var i = 0; i < ob.length; i++) {
                var e = ob[i];
                if (e.type == 'checkbox') {
                    if (e.checked)
                        TO = false;
                }
            }
        } else {
            var e = ob;
            if (e.type == 'checkbox') {
                if (e.checked)
                    TO = false;
            }
        }
 	   }
  	  if (TO) { 
        return false;
   	 }
  	  return true;
	}
        function ev_checkval() {
        	//var ob = formItem.all("seleteSlv");
        	addfield('rewardname', '<bean:message bundle="stdreward" key="rewardname"/>', 'c', false, '40');
            addfield('rewardproj', '<bean:message bundle="stdreward" key="rewardproj"/>', 'i', true, '3');
            addfield('startdate', '<bean:message bundle="stdreward" key="startdate"/>', 't', false, '25');
            addfield('stopdate', '<bean:message bundle="stdreward" key="stopdate"/>', 't', false, '25');
            addfield('memo', '<bean:message bundle="stdreward" key="memo"/>', 'c', true, '512');
           	if(str=="REGIONSTAR") {
      	 	errorMessageShow('<span class=\'errorkey\'><span style=\'color:#F00; font-weight:900;\'>[星级酬金上限]</span>星级酬金上限列表信息不能为空</span>');  
        	return false;
            }
            
            return checkval(window); 
        }
        function checkstar() {
          var ob = formItem.all("seleteSlv"); 
         // alert("ob="+ob);
         // if(!forcheck(ob)){
      	 // errorMessageShow('<span class=\'errorkey\'><span style=\'color:#F00; font-weight:900;\'>[<bean:message bundle="stdrewardbs" key="slv"/>]</span><bean:message bundle="stdrewardbs" key="slv"/>不能为空</span>');     
         // return false; 
         // }seleteSlv
          addfield('seleteSlv', '星级', 'f', false, '14','4');
          addfield('region', '<bean:message bundle="stdrewardbs" key="region"/>', 'c', false, '10');
          addfield('citystd', '<bean:message bundle="stdrewardbs" key="citystd"/>', 'f', false, '14','4');
          addfield('countrystd', '<bean:message bundle="stdrewardbs" key="countrystd"/>', 'f', false, '14','4');
          addfield('citycorelimit', '城区核心业务量下限', 'l', false, '14');
          addfield('cityaccountlimit', '城区业务积分值下限', 'l', false, '14');
          addfield('countycorelimit', '郊区核心业务量下限', 'l', false, '14');
          addfield('countyaccountlimit', '郊区积分业务量下限', 'l', false, '14');
          return checkval(window); 
        }
        function doReturn(url){
    	window.parent.document.location=contextPath + url;
		}
		function add(){
		var ob = formItem.all("seleteSlv"); 
		//for(var i=0;i<ob.length;i++){
		//	var obj=ob[i];
		//	obj.checked=false;
		//	obj.disabled=false;
		//}
		ob.value="";
		ob.disabled=false;
		var ob1 = formItem.all("region"); 
		ob1.value="";
		ob1.disabled=false;
		var ob2 = formItem.all("citystd"); 
		ob2.value="";
		ob2.disabled=false;
		var ob3 = formItem.all("countrystd"); 
		ob3.value="";
		ob3.disabled=false;
		var ob4 = formItem.all("citycorelimit"); 
		ob4.value="";
		ob4.disabled=false;
		var ob5 = formItem.all("cityaccountlimit"); 
		ob5.value="";
		ob5.disabled=false;
		var ob5 = formItem.all("countycorelimit"); 
		ob5.value="";
		ob5.disabled=false;
		var ob6 = formItem.all("countyaccountlimit"); 
		ob6.value="";
		ob6.disabled=false;
		var neworedit = formItem.all("neworedit"); 
		neworedit.value="NEW";
		}
		function saveStar(){ 
		if(checkstar()){
		
			var form=document.forms[0];
			for (var i = 0; i < form.elements.length; i++) {
            if (form.elements(i).disabled == true && form.elements(i).name != 'DNPTS')
            	form.elements(i).disabled = false;
   		 	}
			var pk = formItem.region.value;  
			var citystd=formItem.citystd.value;
			var countrystd=formItem.countrystd.value;
			var citystd2;
			var countrystd2;
			<c:forEach var="item" items="${requestScope.STARLIST.datas}">
			if(pk==<c:out value="${item.region}" />){
				citystd2=<c:out value="${item.citystd2}" />;
				countrystd2=<c:out value="${item.countrystd2}" />;
			}
			</c:forEach>
			if(citystd2!=-1&&countrystd2!=-1){
				if((citystd<citystd2)||(countrystd<countrystd2)){
					var isSubmit=window.confirm("修改该区域星级酬金上限和市公司设置的标准冲突，是否继续？如果您选择继续，系统会强制将市公司设置的标准删除。");
					if(isSubmit){
						form.action="<%=contextPath%>/cms/stdrewardbs.do?CMD=SAVESTARLIST&PK="+pk;
						form.submit();
					}else{
						return false;
					}
				}else{
					form.action="<%=contextPath%>/cms/stdrewardbs.do?CMD=SAVESTARLIST&PK="+pk;
					form.submit();
				}
			}else{
				form.action="<%=contextPath%>/cms/stdrewardbs.do?CMD=SAVESTARLIST&PK="+pk;
				form.submit();
			}			
		}
		else {
			return false;
		}
		}
		function changeStar(str){ 
	      var neworedit = formItem.all("neworedit"); 
		  neworedit.value="EDIT";
          formItem.action = str;
          formItem.submit();  
		}
		
		function deleteStar(){
		var form=document.forms[0];
		form.action="<%=contextPath%>/cms/stdrewardbs.do?CMD=DELETESTAR";
		form.submit();
		}
		
		function doDelete(cmdDelete) {
  		  var T = true;
  		   var sis = formItem.all("_selectitem");
   		   if (forincheck(T,sis,msgConfirmDelete)){
    		ajaxAnywhere.submitByURL('/cms/stdrewardbs.do?CMD=CHECKDELETE');
    		//parent.frames[0].document.location.reload();
         	}  
    	}
    function doSave(cmdSave) {
    var form=document.forms[0];
    if (ev_checkval()) {
      	//enable();
        form.action = contextPath + cmdSave;
        form.submit();
  	 }else{
 	 return false;
 	 }
	}
	function showmessage(){
		if(confirm("删除该区域星级酬金上限设置，会同时查询市公司原有设置的标准，是否继续?")){
			formItem.action = addParam(contextPath + '/cms/stdrewardbs.do', 'CMD', 'DELETESTAR');	
	    	formItem.submit();
		}
	}
	function isSubmit(){
		var isSubmit=<%=request.getAttribute("isSubmit")==null?"false":request.getAttribute("isSubmit")%>;
		if(isSubmit==true){
			var btn1=document.getElementById("button4");
			btn1.disabled=true;
			var button1=document.getElementById("button1");
			button1.disabled=true;
			var button2=document.getElementById("button2");
			button2.disabled=true;
			var button3=document.getElementById("button3");
			button3.disabled=true;
		}
	}
    </script>
    <aa:zone name="showerror">
    	<%=request.getAttribute("showfunction")==null?"":request.getAttribute("showfunction")%>
    </aa:zone>
    
	</head>
	<body onload="if(window.loadforiframe) {loadforiframe();}isSubmit();">
		<div class="table_container">
			<html:form action="/cms/stdrewardbs.do?CMD=SAVE" styleId="formItem"
				method="post">
				<html:hidden property="cmdState" />
				<html:hidden property="_orderby" />
				<html:hidden property="_desc" />
				<html:hidden property="_pageno" />
				<html:hidden property="_pagesize" />
				<html:hidden property="_ne_rewardid" />
				<html:hidden property="_se_region" />
				<html:hidden property="_se_slv" />

				<html:hidden property="_sk_rewardname" />
				<html:hidden property="_dnl_startdate" />
				<html:hidden property="_dnm_stopdate" />
				<html:hidden property="rewardid" />
				<html:hidden property="islimt" />
				<html:hidden property="rewardtype" />
				<html:hidden property="rewardproj" />
				<html:hidden property="neworedit" />
				<html:hidden property="acctype" value="11"/>
				<html:hidden property="intvmonth" value="0" />
				
				
				<c:set var="edtState" scope="request"
					value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW' or param.CMD eq 'SAVESTAR' or param.CMD eq 'DELETESTAR' or param.CMD eq 'EDITSTAR' or param.CMD eq 'SAVESTARLIST')}" />
				<c:set var="edtStateStar" scope="request"
					value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW' or param.CMD eq 'SAVESTAR' or param.CMD eq 'DELETESTAR')}" />

				<c:set var="updateState" scope="request"
					value="${!empty param.CMD and (param.CMD eq 'EDIT')}" />

				<!--##################################添加标题内容##################################################-->
				<div class="table_div">
					<table class="top_table">
						<tr>
							<td>
								<bean:message bundle="stdrewardbs" key="titleList" />
							</td>
						</tr>
					</table>
				</div>
				<div class="table_div">
					<table width="100%" class="error_text">
						<html:errors />
						<s:Msg />
					</table>
				</div>
				<FIELDSET>
					<legend name="organizeinfo">
						<bean:message bundle="stdreward" key="titleList1" />
					</legend>
					<div class="table_div">
						<table class="form_table">
							<tr>
								<td colspan="4">
									<bean:message bundle="stdrewardbs" key="tishi" />
								</td>
							</tr>
							<tr>
								<td width="20%" align="right" class="form_table_right">
									<div class="field-require">
										<bean:message bundle="stdreward" key="rewardid" />
										:
									</div>
								</td>
								<td width="30%" colspan="4">
									<c:choose>
										<c:when test="${edtState}">
											<c:out
												value="${requestScope['/cms/stdrewardbs/StdrewardbsForm'].rewardid}" />
										</c:when>
										<c:otherwise>
											<c:out
												value="${requestScope['/cms/stdrewardbs/StdrewardbsForm'].rewardid}" />
										</c:otherwise>
									</c:choose>
								</td>
							</tr>
							<tr>
								<td width="20%" align="right" class="form_table_right">
									<div class="field-require">
										<bean:message bundle="stdreward" key="rewardname" />
										:
									</div>
								</td>
								<td width="30%" colspan="4">
									<c:choose>
										<c:when test="${edtState}">
											<html:text styleClass="form_input_1x" property="rewardname"
												maxlength="40" />
										</c:when>
										<c:otherwise>
											<html:text styleClass="form_input_1x" property="rewardname"
												disabled="true" />
										</c:otherwise>
									</c:choose>
									<font color=red>&nbsp;*</font>
								</td>
							</tr>
							<tr>
								<td width="20%" align="right" class="form_table_right">
									<div class="field-require">
										<bean:message bundle="stdreward" key="startdate" />
										:
									</div>
								</td>
								<td width="30%" align="left" class="form_table_left">
									<c:choose>
										<c:when test="${edtState}">

											<input class="form_input_1x" type="text" name="startdate"
												value="<fmt:formatDate value="${requestScope['/cms/stdrewardbs/StdrewardbsForm'].startdate}"
											pattern="yyyy-MM-dd" />"
												onclick="this.value=selectDate();" readonly="true" />
										</c:when>
										<c:otherwise>
											<input class="form_input_1x" type="text" name="startdate"
												value="<fmt:formatDate value="${requestScope['/cms/stdrewardbs/StdrewardbsForm'].startdate}"
											pattern="yyyy-MM-dd" />"
												onclick="this.value=selectDate();" disabled="true" />
										</c:otherwise>
									</c:choose>
									<font color=red>&nbsp;*</font>
								</td>
								<td width="20%" align="right" class="form_table_right">
									<div class="field-require">
										<bean:message bundle="stdreward" key="stopdate" />
										:
									</div>
								</td>
								<td width="30%" align="left" class="form_table_left">
									<c:choose>
										<c:when test="${edtState}">
											<input class="form_input_1x" type="text" name="stopdate"
												value="<fmt:formatDate value="${requestScope['/cms/stdrewardbs/StdrewardbsForm'].stopdate}"
											pattern="yyyy-MM-dd" />"
												onclick="this.value=selectDate();" readonly="true" />
										</c:when>
										<c:otherwise>

											<input class="form_input_1x" type="text" name="stopdate"
												value="<fmt:formatDate value="${requestScope['/cms/stdrewardbs/StdrewardbsForm'].stopdate}"
											pattern="yyyy-MM-dd" />"
												onclick="this.value=selectDate();" disabled="true" />
										</c:otherwise>
									</c:choose>
									<font color=red>&nbsp;*</font>
							</tr>
							<tr>
								<td width="20%" align="right" class="form_table_right">
									<div class="field-require">
										<bean:message bundle="stdreward" key="memo" />
										:
									</div>
								</td>
								<td width="30%" align="left" class="form_table_left" colspan="4">
									<c:choose>
										<c:when test="${edtState}">

											<html:textarea property="memo" rows="3" cols="70" />
										</c:when>
										<c:otherwise>
											<html:textarea property="memo" rows="3" cols="70"
												readonly="true" />
										</c:otherwise>
									</c:choose>
								</td>
							</tr>
						</table>
					</div>
				</FIELDSET>
				<!--##################################添加标题内容##################################################-->
				<FIELDSET>
					<legend name="organizeinfo">
						<bean:message bundle="stdrewardbs" key="titleList2" />
					</legend>
					<div class="table_div">
						<table class="form_table">
							<tr>
								<td colspan="4">
									<bean:message bundle="stdrewardbs" key="tishi" />
								</td>
							</tr>
							<tr>
								<td width="8%" align="right" class="form_table_right">
									<div class="field-require">
										<bean:message bundle="stdrewardbs" key="slv" />
										:
									</div>
								</td>
								<td width="42%" align="left" class="form_table_left">
									<c:choose>
									<c:when test="${edtStateStar}">
											<html:select property="seleteSlv">
												<html:option value=""></html:option>
												<html:option value="1">一星级</html:option>
												<html:option value="2">二星级</html:option>
												<html:option value="3">三星级</html:option>
												<html:option value="4">四星级</html:option>
												<html:option value="5">五星级</html:option>
												<html:option value="6">六星级</html:option>
												
											</html:select>
										</c:when>
										<c:otherwise>
											<html:select property="seleteSlv" disabled="true">
												<html:option value=""></html:option>
												<html:option value="1">一星级</html:option>
												<html:option value="2">二星级</html:option>
												<html:option value="3">三星级</html:option>
												<html:option value="4">四星级</html:option>
												<html:option value="5">五星级</html:option>
												<html:option value="6">六星级</html:option>
											</html:select>
										</c:otherwise>
										
									</c:choose>
									<font color=red>&nbsp;*</font>
								</td>

								<td width="12%" align="right" class="form_table_right">
									<div class="field-require">
										<bean:message bundle="stdrewardbs" key="region" />
										:
									</div>
								</td>
								<td width="38%" align="left" class="form_table_left">
									<c:choose>
										<c:when test="${edtStateStar}">
											<html:select property="region">
												<html:option value=""></html:option>
												<s:Options definition="#CITYIDNUM2NMAME" />
											</html:select>
										</c:when>
										<c:otherwise>
											<html:select property="region" disabled="true">
												<html:option value=""></html:option>
												<s:Options definition="#CITYIDNUM2NMAME" />
											</html:select>
										</c:otherwise>
									</c:choose>
									<font color=red>&nbsp;*</font>
								</td>
							</tr>
							<tr>
								<td width="12%" align="right" class="form_table_right">
									<div class="field-require">
										<bean:message bundle="stdrewardbs" key="_ne_citystd" />
										:
									</div>
								</td>
								<td width="38%" align="left" class="form_table_left">
									<c:choose>
										<c:when test="${edtState}">
											<html:text styleClass="form_input_1x" property="citystd"
												maxlength="16" />
										</c:when>
										<c:otherwise>
											<html:text styleClass="form_input_1x" property="citystd"
												disabled="true" />
										</c:otherwise>
									</c:choose>
									<font color=red>&nbsp;*</font>
								</td>
								<td width="12%" align="right" class="form_table_right">
									<div class="field-require">
										<bean:message bundle="stdrewardbs" key="_ne_countrystd" />
										:
									</div>
								</td>
								<td width="38%" align="left" class="form_table_left">
									<c:choose>
										<c:when test="${edtState}">
											<html:text styleClass="form_input_1x" property="countrystd"
												maxlength="16" />
										</c:when>
										<c:otherwise>
											<html:text styleClass="form_input_1x" property="countrystd"
												disabled="true" />
										</c:otherwise>
									</c:choose>
									<font color=red>&nbsp;*</font>
								</td>
							</tr>
							<tr>
								<td width="12%" align="right" class="form_table_right">
									<div class="field-require">
										城区核心业务量下限:
									</div>
								</td>
								<td width="38%" align="left" class="form_table_left">
									<c:choose>
										<c:when test="${edtState}">
											<html:text styleClass="form_input_1x" property="citycorelimit"
												maxlength="16" />
										</c:when>
										<c:otherwise>
											<html:text styleClass="form_input_1x" property="citycorelimit"
												disabled="true" />
										</c:otherwise>
									</c:choose>
									<font color=red>&nbsp;*</font>
								</td>
								<td width="12%" align="right" class="form_table_right">
									<div class="field-require">
										城区业务积分值下限:
									</div>
								</td>
								<td width="38%" align="left" class="form_table_left">
									<c:choose>
										<c:when test="${edtState}">
											<html:text styleClass="form_input_1x" property="cityaccountlimit"
												maxlength="16" />
										</c:when>
										<c:otherwise>
											<html:text styleClass="form_input_1x" property="cityaccountlimit"
												disabled="true" />
										</c:otherwise>
									</c:choose>
									<font color=red>&nbsp;*</font>
								</td>
							</tr>
							<tr>
								<td width="12%" align="right" class="form_table_right">
									<div class="field-require">
										郊区核心业务量下限:
									</div>
								</td>
								<td width="38%" align="left" class="form_table_left">
									<c:choose>
										<c:when test="${edtState}">
											<html:text styleClass="form_input_1x" property="countycorelimit"
												maxlength="16" />
										</c:when>
										<c:otherwise>
											<html:text styleClass="form_input_1x" property="countycorelimit"
												disabled="true" />
										</c:otherwise>
									</c:choose>
									<font color=red>&nbsp;*</font>
								</td>
								<td width="12%" align="right" class="form_table_right">
									<div class="field-require">
										郊区积分业务量下限:
									</div>
								</td>
								<td width="38%" align="left" class="form_table_left">
									<c:choose>
										<c:when test="${edtState}">
											<html:text styleClass="form_input_1x" property="countyaccountlimit"
												maxlength="16" />
										</c:when>
										<c:otherwise>
											<html:text styleClass="form_input_1x" property="countyaccountlimit"
												disabled="true" />
										</c:otherwise>
									</c:choose>
									<font color=red>&nbsp;*</font>
								</td>
							</tr>

						</table>
					</div>

					<div class="table_div">
						<table class="table_button_list">
							<tr>
								<td align=right>
									<s:RewardPurChk controlid="<%=ID_1%>" disableChild="true">
										<input type="button"
											value="<bean:message bundle="stdrewardbs" key="add"/>"
											class="add" onclick="add()" onmouseover="buttonover(this)"
											onmouseout="buttonout(this)" onfocus="buttonover(this)"
											onblur="buttonout(this)" id="button1">
									</s:RewardPurChk>
									<s:RewardPurChk controlid="<%=ID_1%>" disableChild="true">
										<input type="button"
											value="<bean:message bundle="stdrewardbs" key="save"/>"
											class="save" onclick="saveStar()"
											onmouseover="buttonover(this)" onmouseout="buttonout(this)"
											onfocus="buttonover(this)" onblur="buttonout(this)" id="button2">
									</s:RewardPurChk>
									<s:RewardPurChk controlid="<%=ID_1%>" disableChild="true">
										<input type="button"
											value="<bean:message bundle="stdrewardbs" key="delete"/>"
											class="delete" onclick="doDelete('/cms/stdrewardbs.do')"
											onmouseover="buttonover(this)" onmouseout="buttonout(this)"
											onfocus="buttonover(this)" onblur="buttonout(this)" id="button3">
									</s:RewardPurChk>
								</td>
							</tr>
						</table>
					</div>
				
				<aa:zone name="sessionlist">
					<div class="table_div">
						<div class="table_LongTable">
							<table class="table_style" ID="Table2">
								<tr class="table_style_head">
									<td
										title="<bean:message bundle="public" key="list_title_select"/>">
										<input type="checkbox" name="allbox" onclick="checkAll('formItem');"
											class="table_checkbox">
									</td>
									<td>
										<bean:message bundle="stdrewardbs" key="op" />
									</td>
									<td>
										<bean:message bundle="stdrewardbs" key="slv" />
									</td>
									<td>
										<bean:message bundle="stdrewardbs" key="region" />
									</td>
									<td>
										<bean:message bundle="stdrewardbs" key="citystd" />
									</td>
									<td>
										<bean:message bundle="stdrewardbs" key="countrystd" />
									</td>
									<td>
										<bean:message bundle="stdrewardbs" key="citystd2" />
									</td>
									<td>
										<bean:message bundle="stdrewardbs" key="countrystd2" />
									</td>
									<td>
										<bean:message bundle="stdrewardbs" key="acctype" />
									</td>
									<td>
										<bean:message bundle="stdrewardbs" key="mpcitystd" />
									</td>
									<td>
										<bean:message bundle="stdrewardbs" key="mpcountrystd" />
									</td>
									<td>
										<bean:message bundle="stdrewardbs" key="secitystd" />
									</td>
									<td>
										<bean:message bundle="stdrewardbs" key="secountrystd" />
									</td>
									<td>
										城区核心业务量下限
									</td>
									<td>
										城区业务积分值下限
									</td>
									<td>
										郊区核心业务量下限
									</td>
									<td>
										郊区积分业务量下限
									</td>
								</tr>
								<c:forEach var="item" items="${requestScope.STARLIST.datas}">
									<c:url value="/cms/stdrewardbs.do?CMD=EDITSTAR"
										var="urlContent">
										<%
										//this param name must "PK"
										%>
										<c:param name="PK" value="${item.region}" />
										<%-- <c:param name="PK" value="'${item.id}|${item.id2}'"/> --%>
									</c:url>
									<tr class="table_style_content" align="center">
										<td>
											<input type="checkbox" name="_selectitem"
												value="<c:out value='${item.region}' />"
												onclick="checkOne('formItem');" class="table_checkbox">
										</td>
										<td>
											<a href='#'	onclick="changeStar('<c:out value="${urlContent}"/>');return false;" target="_self"><bean:message bundle="stdrewardbs" key="edit" /></a>
											<!-- <a href='#' onclick="changeStar(<c:out value="${urlContent}"/>);return false;"  target="_self"><bean:message bundle="stdrewardbs" key="edit" /></a>  -->
										</td>
										<td>
											<c:out value="${item.slvtc}" />
										</td>
										<td>
											<s:Code2Name code="${item.region}" definition="$RegionList" />
										</td>
										<td>
											<c:out value="${item.citystd}" />
										</td>
										<td>
											<c:out value="${item.countrystd}" />
										</td>
										<td>
											<c:set var="citystd2" scope="request"
												value="${item.citystd2 eq -1}"></c:set>
											<c:choose>
												<c:when test="${citystd2}">
                     							未指定
                     						</c:when>
												<c:otherwise>
													<c:out value="${item.citystd2}" />
												</c:otherwise>
											</c:choose>
										</td>
										<td>
											<c:set var="countrystd2" scope="request"
												value="${item.countrystd2 eq -1}"></c:set>
											<c:choose>
												<c:when test="${countrystd2}">
                     							未指定
                     						</c:when>
												<c:otherwise>
													<c:out value="${item.countrystd2}" />
												</c:otherwise>
											</c:choose>
										</td>
										<td>
											<s:Code2Name code="${item.acctype}" definition="$CH_BSACCTYPE" />
										</td>
										<td>
											<c:set var="mpcitystd" scope="request"
												value="${item.mpcitystd eq -1}"></c:set>
											<c:choose>
												<c:when test="${mpcitystd}">
                     							未指定
                     						</c:when>
												<c:otherwise>
													<c:out value="${item.mpcitystd}" />
												</c:otherwise>
											</c:choose>
										</td>
										<td>
											<c:set var="mpcountrystd" scope="request"
												value="${item.mpcountrystd eq -1}"></c:set>
											<c:choose>
												<c:when test="${mpcountrystd}">
                     							未指定
                     						</c:when>
												<c:otherwise>
													<c:out value="${item.mpcountrystd}" />
												</c:otherwise>
											</c:choose>
										</td>
										<td>
											<c:set var="secitystd" scope="request"
												value="${item.secitystd eq -1}"></c:set>
											<c:choose>
												<c:when test="${secitystd}">
                     							未指定
                     						</c:when>
												<c:otherwise>
													<c:out value="${item.secitystd}" />
												</c:otherwise>
											</c:choose>
										</td>
										<td>
											<c:set var="secountrystd" scope="request"
												value="${item.secountrystd eq -1}"></c:set>
											<c:choose>
												<c:when test="${secountrystd}">
                     							未指定
                     						</c:when>
												<c:otherwise>
													<c:out value="${item.secountrystd}" />
												</c:otherwise>
											</c:choose>
										</td>
										<td>
											<c:out value="${item.citycorelimit}" />
										</td>
										<td>
											<c:out value="${item.cityaccountlimit}" />
										</td>
										<td>
											<c:out value="${item.countycorelimit}" />
										</td>
										<td>
											<c:out value="${item.countyaccountlimit}" />
										</td>
										
									</tr>
								</c:forEach>
							</table>
						</div>
					</div>
				</aa:zone>
					<div class="table_div">
						<s:PageNav dpName="LIST" />
					</div>

				</FIELDSET>
				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td>
								<s:RewardPurChk controlid="<%=ID_1%>" disableChild="true">
									<input type="button" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="<bean:message bundle="public" key="button_save"/>"
										class="save"
										onclick="doSave('/cms/stdrewardbs.do?CMD=SAVE&STR=content');" id="button4"/>
								</s:RewardPurChk>

								<input type="button" onmouseover="buttonover(this);"
									onmouseout="buttonout(this);" name="btnReturn"
									onfocus="buttonover(this)" onblur="buttonout(this)"
									value="<bean:message bundle="public" key="button_return"/>"
									class="close"
									onclick="doReturn('/cms/stdrewardbs.do?CMD=LIST')">
							</td>
							<td>
								&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
							</td>
						</tr>
					</table>
				</div>
			</html:form>
		</div>
	</body>
</html>

