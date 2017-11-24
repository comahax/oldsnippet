<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%@ page import="com.sunrise.boss.ui.commons.User"%>
<%@ page import="com.sunrise.boss.ui.commons.WebConstant"%>
<%@ page import="java.util.Collection"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="com.sunrise.boss.business.admin.dictitem.persistent.DictitemVO"%>
<%@ page import="com.sunrise.boss.common.base.db.DataPackage"%>
<jsp:include page="/inc/acl.jsp">
	<jsp:param name="PID" value="3C3C1ABB" />
</jsp:include>

<%
	String ID_1 = "3C3C1ABBBT1";
	String ID_2 = "3C3C1ABBBT2";

	String AREACODE_A = "AREACODE_A";
	String AREACODE_B = "AREACODE_B";
	String AREACODE_C = "AREACODE_C";
	Collection list = ((DataPackage) request.getAttribute("detail"))
			.getDatas();
%>
<html:html>
<head>
	<title><bean:message bundle="yxplan" key="titleCopy" />
	</title>
	<style>
	.loadingdiv {
		display:none;
		font-size:12px;
		width:130px;
		height:30px;
		border:#1083B8 solid 1px;
		margin-left:45%;
		margin-top:20%;
		padding-top:8px;
		padding-left:8px;
	}
	.contentdiv {
		display:block;
		width:100%;
		height:100px;
	}
	</style>
	<script language="JavaScript">
		function loadfun () {
			loading.style.display='block';
			content.style.display='none';
		}
		var s1,s2,s3,s4,s5,s6,s7;
        function ev_checkval() {
        	addfield('orgyxplanid', '<bean:message bundle="yxplan" key="orgyxplanid"/>', 'c', false, 14);
        	addfield('areacode', '<bean:message bundle="yxplan" key="areacode"/>', 'c', false, 30);
        	addfield('yxplanid', '<bean:message bundle="yxplan" key="yxplanid"/>', 'c', false, 14);
            addfield('yxplanname', '<bean:message bundle="yxplan" key="yxplanname"/>', 'c', false, 128);
            addfield('startdate', '<bean:message bundle="yxplan" key="startdate"/>', 'dt', false, 20);
            addfield('yxplangroupid', '<bean:message bundle="yxplan" key="yxplangroupid"/>', 'i', true, 20);
            addfield('stopdate', '<bean:message bundle="yxplan" key="stopdate"/>', 'dt', false, 20);
            if(date_compare("startdate","stopdate",'<bean:message bundle="fee" key="timeCompare"/>')) return false;
            addfield('checkercode', '<bean:message bundle="yxplan" key="checkercode"/>', 'c', true, 15);
            addfield('operatorcode', '<bean:message bundle="yxplan" key="operatorcode"/>', 'c', true, 15);
          	addfield('discoffset', '<bean:message bundle="yxplan" key="discoffset"/>', 'l', true, 22);
            addfield('couldusetimes', '<bean:message bundle="yxplan" key="couldusetimes"/>', 'l', true, 10);
            addfield('mindisccycle', '<bean:message bundle="yxplan" key="mindisccycle"/>', 'l', true, 22);
            addfield('privelgepro', '<bean:message bundle="yxplan" key="privelgepro"/>', 'i', false, 2);
            addfield('discscope', '<bean:message bundle="yxplan" key="discscope"/>', 'c', true, 8);
            addfield('feecomment', '<bean:message bundle="yxplan" key="feecomment"/>', 'c', true, 255);
            addfield('remark', '<bean:message bundle="yxplan" key="remark"/>', 'c', true, 2000);
            addfield('yxplancode', '<bean:message bundle="yxplan" key="yxplancode"/>', 'c', true, 40);
            addfield('uploadcalcfeekind', '<bean:message bundle="yxplan" key="uploadcalcfeekind"/>', 'i', false, 1);
                        addfield('plantype', '<bean:message bundle="yxplan" key="plantype"/>', 'c', false,10);
            if(dod('<bean:message bundle="yxplan" key="s1"/>','<bean:message bundle="yxplan" key="s2"/>','<bean:message bundle="yxplan" key="s3"/>','<bean:message bundle="yxplan" key="s4"/>','<bean:message bundle="yxplan" key="s5"/>','<bean:message bundle="yxplan" key="s6"/>','<bean:message bundle="yxplan" key="s7"/>')){
			
			}else{
			return false;
			}
            return checkval(window);
        }
       function dod(str1,str2,str3,str4,str5,str6,str7) {
			var endpoint;
			Reg = new RegExp("^([a-z|A-Z]{2})([01]{4})([012]{1})(20\\d{2}(0[0-9]{1}|1[012]{1})(0[0-9]{1}|[12]{1}\\d{1}|3[01]{1}))(\\d{3})(\\d{6})(\\d{2})$","g");
			if (Reg.exec(document.all("formItem").yxplancode.value)) {
				return true;
			}else if(""!=document.all("yxplancode").value){
				Reg = new RegExp("(20\\d{2}(0[0-9]{1}|1[012]{1})(0[0-9]{1}|[12]{1}\\d{1}|3[01]{1}))","g");
				if (Reg.exec(document.all("formItem").yxplancode.value) == null) {
					alert(str4);return false;
				}
				endpoint = RegExp.index;
				if (RegExp.index == 7) {
					Reg = new RegExp("^([a-z|A-Z]{2})","g");
					if (!(Reg.exec(document.all("formItem").yxplancode.value) != null)) {
						alert(str1);return false;
					}
					Reg = new RegExp("^([a-z|A-Z]{2})([01]{4})","g");
					if (!(Reg.exec(document.all("formItem").yxplancode.value) != null)) {
						alert(str2);return false;
					}
					Reg = new RegExp("^([a-z|A-Z]{2})([01]{4})([012]{1})","g");
					if (!(Reg.exec(document.all("formItem").yxplancode.value) != null)) {
						alert(str3);return false;
					}
					Reg = new RegExp("^([a-z|A-Z]{2})([01]{4})([012]{1})(20\\d{2}(0[0-9]{1}|1[012]{1})(0[0-9]{1}|[12]{1}\\d{1}|3[01]{1}))(\\d{3})","g");
					if (!(Reg.exec(document.all("formItem").yxplancode.value) != null)) {
						alert(str5);return false;
					}
					Reg = new RegExp("^([a-z|A-Z]{2})([01]{4})([012]{1})(20\\d{2}(0[0-9]{1}|1[012]{1})(0[0-9]{1}|[12]{1}\\d{1}|3[01]{1}))(\\d{3})(\\d{6})$","g");
					if (!(Reg.exec(document.all("formItem").yxplancode.value) != null)) {
						alert(str6);return false;
					}
					Reg = new RegExp("^([a-z|A-Z]{2})([01]{4})([012]{1})(20\\d{2}(0[0-9]{1}|1[012]{1})(0[0-9]{1}|[12]{1}\\d{1}|3[01]{1}))(\\d{3})(\\d{6})(\\d{2})$","g");
					if (!(Reg.exec(document.all("formItem").yxplancode.value) != null)) {
						alert(str7);return false;
					}
				}else{
					Reg = new RegExp("^([a-z|A-Z]{2})","g");
					if (!(Reg.exec(document.all("formItem").yxplancode.value.substring(0,endpoint)) != null)) {
						alert(str1);return false;
					}
					Reg = new RegExp("^([a-z|A-Z]{2})([01]{4})","g");
					if (!(Reg.exec(document.all("formItem").yxplancode.value.substring(0,endpoint)) != null)) {
						alert(str2);return false;
					}
					Reg = new RegExp("^([a-z|A-Z]{2})([01]{4})([012]{1})","g");
					if (!(Reg.exec(document.all("formItem").yxplancode.value.substring(0,endpoint)) != null)) {
						alert(str3);return false;
					}
				}
			}
			return true;
		}


        function doGetyxplanid(){	
			var strUrl;
			var arg = new Array();
			strUrl = "<%=contextPath%>/admin/dictitem.do?CMD=LIST";
			strUrl = strUrl + "&_pagesize=0&_se_groupid=PC_YXPLANAREACODE";            
            <%
            	String pid = "1";  //1  2 3 
            	if(pid.equals("1")) {
            	User user = (User)request.getSession().getAttribute( WebConstant.SESSION_ATTRIBUTE_USER);
            	if(user.isProvinceUser()){
            	%>
            		
            		   	 var strUrl0 = strUrl;
            		   	 strUrl0 = strUrl0;
            		  <%}else{%>
            		   	
            		   	  var strUrl0 = strUrl;
            		   	  strUrl0 = strUrl0 + "&_se_dictid=" + "<%=user.getCityid()%>";
            					 
            	<%
            	}
            	}
            %>
            
            var hWnd = window.showModalDialog(strUrl0,arg,"dialogWidth:600px; dialogHeight:390px; status:no;resizable:yes;");
			if(hWnd != null && hWnd != ""){
				formItem.action = contextPath + "/zifee/yxplan.do?CMD=GENYXPLANID&hWnd=" + hWnd;
            	formItem.submit();						
				//document.all.areacode.value = hWnd;	
			}	
        }
        
         function selch()
		{
			
			if(document.all("formItem").stopuserrentflag.value == "1"){
				alert("<bean:message bundle="yxplan" key="stopuserrentflagstr"/>");
			}
		}
		function doDiscscopeMsg(){
		  window.open(contextPath + "/zifee/yxplan/tip.jsp", '', 'Width=800;Height=500;status=no;scroll=yes;resizable=yes;');
		}
		
		function showNote(){
		  window.open(contextPath + "/zifee/yxplan/note.jsp", '', 'Width=800;Height=500;status=no;scroll=yes;resizable=yes;');
		}
		
		function doYxplanidMsg(){
		  window.open(contextPath + "/zifee/yxplan/yxid.jsp", '', 'Width=800;Height=1800;status=yes;scroll=no;resizable=yes;');
		}
		
		function getCopyitem(){
			var items = formItem.chb;
			var ret = "";
			try{
				if(items != null){
					var count = items.length;
					for(var i = 0; i<count; i++){
						if(items[i].checked){
							var dictid = items[i].id;
							ret = ret + "," + dictid.substring(3);
						}
					}
				}
				if(ret != ""){
					ret = ret.substring(1);
				}
			}catch(e){
				alert(e.description);
			}
			return ret;
		}
		function doSingleCopy(url){
			if(!ev_checkval()){
				return;
			}
			formItem.btnCopy.disabled = true;
			loadfun();
			formItem.copyitem.value = getCopyitem();
			formItem.action = contextPath + url;
			formItem.submit();
		}
		function selectYxplan(){
			var arg = new Array();
			var strUrl ="<%=contextPath%>/zifee/yxplan.do?CMD=SELECT";
			var returnValue= window.showModalDialog(strUrl,arg,"dialogWidth:600px; dialogHeight:390px; status:no;resizable:yes;");
			
			if(returnValue == ""){
				return;
			}
			formItem.orgyxplanid.value = returnValue;
			formItem.action = "<%=contextPath%>/zifee/yxplan.do?CMD=GETYXPLANDT";
			formItem.submit();
		 }
		 function checkSpecialFlagChange(){
        	var item=document.all("selectSpecialflag");
        	var decisionBox=item[0];
        	for(var i=1;i<item.length;i++){
        		var otherBox=item[i]; 
				if (decisionBox.checked == true) {otherBox.checked=false;otherBox.disabled = true;}
   				else if(decisionBox.checked==false){ otherBox.disabled = false;}
        	}
        }
    </script>
</head>
<body onload="if(window.loadforiframe) loadforiframe();">
	<div id="loading" class="loadingdiv">
		<bean:message bundle="yxplan" key="loading" />
	</div>
	<div id="content" class="contentdiv">
		<div class="table_container">
			<html:form action="/zifee/yxplan.do?CMD=SAVE" styleId="formItem" method="post">
				<html:hidden property="cmdState" />
				<html:hidden property="_orderby" />
				<html:hidden property="_desc" />
				<html:hidden property="_pageno" />
				<html:hidden property="_pagesize" />
				<html:hidden property="_ne_yxplanid" />
				<html:hidden property="copyitem" />
				<input type="hidden" name="groupflag" value="0">
				<c:set var="cpState" scope="request"
					value="${!empty param.CMD and (param.CMD eq 'GETYXPLANDT' or param.CMD eq 'SINGLE' or param.CMD eq 'SINGLECOPY' or param.CMD eq 'GENYXPLANID')}" />
				<c:set var="item" scope="request" value="${requestScope['/zifee/yxplan/YxPlanActionForm']}" />
				<div class="table_div">
					<!--####################################################################################-->
					<table class="top_table" border=0>
						<tr>
							<td>
								<bean:message bundle="yxplan" key="titleCopy" />
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

				<!--####################################################################################-->
				<div class="table_div">
					<table class="form_table">
						<tr>
							<td align=left colspan="4">
								&nbsp;&nbsp;
								<bean:message bundle="public" key="msgRequired" />
							</td>
						</tr>
						<tr>
							<td align="right">
								&nbsp;&nbsp;
								<bean:message bundle="yxplan" key="orgyxplanid" />
								:
							</td>
							<td align="left" colspan="3">
								<c:choose>
									<c:when test="${cpState}">
										<html:text styleClass="form_input_1x" property="orgyxplanid" readonly="true" onclick="selectYxplan()" />
										<font color=red> &nbsp;* </font>
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="orgyxplanid" disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<td align="right">
								<div class="field-require">
									<bean:message bundle="yxplan" key="areacode" />
									:
								</div>
							</td>
							<td align="left">
								<c:choose>
									<c:when test="${cpState}">
										<html:text styleClass="form_input_1x" property="areacode" readonly="true" />
										<font color=red> &nbsp;* </font>
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="areacode" disabled="true" onclick="doGetyxplanid()" />
									</c:otherwise>
								</c:choose>
							</td>
							<td align="right">
								<div class="field-require">
									<bean:message bundle="yxplan" key="yxplanid" />
									:
								</div>
							</td>
							<td align="left">
								<c:choose>
									<c:when test="${cpState}">
										<html:text styleClass="form_input_1x" property="yxplanid" />
										<input type="button" value="..." onclick="doYxplanidMsg()">
										<font color=red>&nbsp;*</font>
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="yxplanid" disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<td align="right">
								<div class="field-require">
									<bean:message bundle="yxplan" key="yxplanname" />
									:
								</div>
							</td>
							<td align="left" colspan="3">
								<c:choose>
									<c:when test="${cpState}">
										<html:text styleClass="form_input_3x" property="yxplanname" />
										<font color=red> &nbsp;* </font>
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_3x" property="yxplanname" disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>

							<td align="right">
								<div class="field-require">
									<bean:message bundle="yxplan" key="startdate" />
									:
								</div>
							</td>
							<td align="left">
								<c:choose>
									<c:when test="${cpState}">
										<input name="startdate" value="<fmt:formatDate value="${item.startdate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
											readonly onclick="this.value=selectDatetime();">
										<font color=red> &nbsp;* </font>
									</c:when>
									<c:otherwise>
										<input name="startdate" value="<fmt:formatDate value="${item.startdate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
											disabled onclick="this.value=selectDatetime();">
									</c:otherwise>
								</c:choose>
							</td>

							<td align="right">
								<div class="field-require">
									<bean:message bundle="yxplan" key="stopdate" />
									:
								</div>
							</td>
							<td align="left">
								<c:choose>
									<c:when test="${cpState}">
										<input name="stopdate" value="<fmt:formatDate value="${item.stopdate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
											readonly onclick="this.value=selectDatetime();">
										<font color=red> &nbsp;* </font>

									</c:when>
									<c:otherwise>
										<input name="stopdate" value="<fmt:formatDate value="${item.stopdate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
											disabled onclick="this.value=selectDatetime();">

									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<td align="right">
								<div class="field-require">
									<bean:message bundle="yxplan" key="bindpackageflag" />
									:
								</div>
							</td>
							<td align="left">
								<c:choose>
									<c:when test="${cpState}">
										<html:select property="bindpackageflag">
											<s:Options definition="#ZIFEE_YON" />
										</html:select>
									</c:when>
									<c:otherwise>
										<html:select property="bindpackageflag" disabled="true">
											<s:Options definition="#ZIFEE_YON" />
										</html:select>
									</c:otherwise>
								</c:choose>
							</td>
							<td align="right">
								<div class="field-require">
									<bean:message bundle="yxplan" key="bindmonths" />
									:
								</div>
							</td>
							<td align="left">
								<c:choose>
									<c:when test="${cpState}">
										<html:text styleClass="form_input_1x" property="bindmonths" />
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="bindmonths" disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<td align="right">
								<div class="field-require">
									<bean:message bundle="yxplan" key="yxplancode" />
									:
								</div>
							</td>
							<td align="left">
								<c:choose>
									<c:when test="${cpState}">
										<html:text styleClass="form_input_1x" property="yxplancode">
										</html:text>

									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="yxplancode" disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>
							<td align="right">
								<div class="field-require">
									<bean:message bundle="yxplan" key="yxplangroupid" />
									:
								</div>
							</td>
							<td align="left">
								<c:choose>
									<c:when test="${cpState}">
										<html:text styleClass="form_input_1x" property="yxplangroupid" maxlength="24" />
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="yxplangroupid" disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>
						<tr>
							<td align="right">
								<div class="field-require">
									<bean:message bundle="yxplan" key="checkercode" />
									:
								</div>
							</td>
							<td align="left">
								<c:choose>
									<c:when test="${cpState}">
										<html:text styleClass="form_input_1x" property="checkercode" maxlength="24" readonly="true" />
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="checkercode" disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>
							<td align="right">
								<div class="field-require">
									<bean:message bundle="yxplan" key="operatorcode" />
									:
								</div>
							</td>
							<td align="left">
								<c:choose>
									<c:when test="${cpState}">
										<html:text styleClass="form_input_1x" property="operatorcode" readonly="true" />
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="operatorcode" disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<td align="right">
							<div class="field-require">
								<bean:message bundle="yxplan" key="planbigkind" />
								:
							</div>
						</td>
						<td align="left">
							<c:choose>
								<c:when test="${cpState}">
									<html:select property="planbigkind">
										<s:Options definition="$PC_BIGKIND" />
									</html:select>
								</c:when>
								<c:otherwise>
									<html:select property="planbigkind" disabled="true">
										<option>
											<s:Options definition="$PC_BIGKIND" />
									</html:select>
								</c:otherwise>
							</c:choose>
						</td>
							<td align="right">
								<div class="field-require">
									<bean:message bundle="yxplan" key="plankind" />
									:
								</div>
							</td>
							<td align="left">
								<c:choose>
									<c:when test="${cpState}">
										<html:select property="plankind">
											<s:Options definition="$PC_YXPLANKIND" />
										</html:select>
									</c:when>
									<c:otherwise>
										<html:select property="plankind" disabled="true">
											<option>
												<s:Options definition="$PC_YXPLANKIND" />
										</html:select>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
					
						<tr>
							<td align="right">
								<div class="field-require">
									<bean:message bundle="yxplan" key="discoffset" />
									:
								</div>
							</td>
							<td align="left">
								<c:choose>
									<c:when test="${cpState}">
										<html:text styleClass="form_input_1x" property="discoffset" maxlength="24" />
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="discoffset" disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>
										<html:hidden styleClass="form_input_1x" property="minconsume"  />
										<html:hidden styleClass="form_input_1x" property="consumecycle"  />
							<td align="right">
								<div class="field-require">
									<bean:message bundle="yxplan" key="mindisccycle" />
									:
								</div>
							</td>
							<td align="left">
								<c:choose>
									<c:when test="${cpState}">
										<html:text styleClass="form_input_1x" property="mindisccycle" />
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="mindisccycle" disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
						<td align="right">
							<div class="field-require"><bean:message bundle="yxplan" key="privelgepro" />:</div>
						</td>
						<td align="left">
							<c:choose>
								<c:when test="${cpState}">
									<html:select property="privelgepro">
										<option value=""></option>
										<s:Options definition="$PC_PRIVELGEPRO" />
									</html:select>
									<font color=red>&nbsp;*</font>
								</c:when>
								<c:otherwise>
									<html:select property="privelgepro" disabled="true">
										<option value=""></option>
										<s:Options definition="$PC_PRIVELGEPRO" />
									</html:select>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
						<tr>
							<td align="right">
								<div class="field-require">
									<bean:message bundle="yxplan" key="starttimetype" />
									:
								</div>
							</td>
							<td align="left">
								<c:choose>
									<c:when test="${cpState}">
										<html:select property="starttimetype">
											<s:Options definition="#ZIFEE_STARTIMETYPE" />
										</html:select>
									</c:when>
									<c:otherwise>
										<html:select property="starttimetype" disabled="true">
											<s:Options definition="#ZIFEE_STARTIMETYPE" />
										</html:select>
									</c:otherwise>
								</c:choose>
							</td>

							<td align="right">
								<div class="field-require">
									<bean:message bundle="yxplan" key="timeunit" />
									:
								</div>
							</td>
							<td align="left">
								<c:choose>
									<c:when test="${cpState}">
										<html:select property="timeunit">
											<s:Options definition="$PC_TIMEUNIT" />
										</html:select>
									</c:when>
									<c:otherwise>
										<html:select property="timeunit" disabled="true">
											<s:Options definition="$PC_TIMEUNIT" />
										</html:select>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<td align="right">
								<div class="field-require">
									<bean:message bundle="yxplan" key="recfeeprivflag" />
									:
								</div>
							</td>
							<td align="left">
								<c:choose>
									<c:when test="${cpState}">
										<html:select property="recfeeprivflag">
											<s:Options definition="#ZIFEE_YON" />
										</html:select>
									</c:when>
									<c:otherwise>
										<html:select property="recfeeprivflag" disabled="true">
											<s:Options definition="#ZIFEE_YON" />
										</html:select>
									</c:otherwise>
								</c:choose>
							</td>
							<td align="right">
								<div class="field-require">
									<bean:message bundle="yxplan" key="feecalcprivflag" />
									:
								</div>
							</td>
							<td align="left">
								<c:choose>
									<c:when test="${cpState}">
										<html:select property="feecalcprivflag">
											<s:Options definition="#ZIFEE_YON" />
										</html:select>
									</c:when>
									<c:otherwise>
										<html:select property="feecalcprivflag" disabled="true">
											<s:Options definition="#ZIFEE_YON" />
										</html:select>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>

						<tr>
							<td align="right">
								<div class="field-require">
									<bean:message bundle="yxplan" key="printflag" />
									:
								</div>
							</td>
							<td align="left">
								<c:choose>
									<c:when test="${cpState}">
										<html:select property="printflag">
											<s:Options definition="#ZIFEE_YON" />
										</html:select>
									</c:when>
									<c:otherwise>
										<html:select property="printflag" disabled="true">
											<s:Options definition="#ZIFEE_YON" />
										</html:select>
									</c:otherwise>
								</c:choose>
							</td>
							<td align="right">
								<div class="field-require">
									<bean:message bundle="yxplan" key="backupflag" />
									:
								</div>
							</td>
							<td align="left">
								<c:choose>
									<c:when test="${cpState}">
										<html:select property="backupflag">
											<s:Options definition="#ZIFEE_YON" />
										</html:select>
									</c:when>
									<c:otherwise>
										<html:select property="backupflag" disabled="true">
											<s:Options definition="#ZIFEE_YON" />
										</html:select>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<td align="right">
								<div class="field-require">
									<bean:message bundle="yxplan" key="isoutmemberpriv" />
									:
								</div>
							</td>
							<td align="left">
								<c:choose>
									<c:when test="${cpState}">
										<html:select property="isoutmemberpriv">
											<s:Options definition="#ZIFEE_YON" />
										</html:select>
									</c:when>
									<c:otherwise>
										<html:select property="isoutmemberpriv" disabled="true">
											<s:Options definition="#ZIFEE_YON" />
										</html:select>
									</c:otherwise>
								</c:choose>
							</td>
							<td align="right">
								<div class="field-require">
									<bean:message bundle="yxplan" key="discscope" />
									:
								</div>
							</td>
							<td align="left">
								<c:choose>
									<c:when test="${cpState}">
										<html:text styleClass="form_input_1x" property="discscope" />
										<input type="button" value="..." onclick="doDiscscopeMsg()">
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="discscope" disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>
						</tr>

						<tr>
							<td align="right">
								<div class="field-require">
									<bean:message bundle="yxplan" key="uploadcalcfeekind" />
									:
								</div>
							</td>
							<td align="left">
								<c:choose>
									<c:when test="${cpState}">
										<html:select property="uploadcalcfeekind">
											<html:option value=""></html:option>
											<s:Options definition="$PC_UPLOADCALCFEEKIND" />
										</html:select>
										<input type="button" value="..." onclick="showNote()">
										<font color="red">*</font>
									</c:when>
									<c:otherwise>
										<html:select property="uploadcalcfeekind" disabled="true">
											<html:option value=""></html:option>
											<s:Options definition="$PC_UPLOADCALCFEEKIND" />
										</html:select>
									</c:otherwise>
								</c:choose>
							</td>
							<td align="right">
								<div class="field-require">
									<bean:message bundle="yxplan" key="plantype" />
									:
								</div>
							</td>
							<td align="left">
								<c:choose>
									<c:when test="${cpState}">
										<html:select property="plantype">
											<html:option value=""></html:option>
											<s:Options definition="$PC_PLANTYPE" />
										</html:select><font color="red">*</font>
									</c:when>
									<c:otherwise>
										<html:select property="plantype" disabled="true">
											<html:option value=""></html:option>
											<s:Options definition="$PC_PLANTYPE" />
										</html:select>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<td align="right">
								<bean:message bundle="yxplan" key="feeprio" />
								:
							</td>
							<td align="left">
								<c:choose>
									<c:when test="${cpState}">
										<html:select property="feeprio" title="aaa">
											<s:Options definition="$PC_FEEPRIO" />
										</html:select>
										<input name="temp" value="..." title="��ѡ���������ֶ��еش�ҵ���ײͿ۷�����״��!(����Ʒ����ʱ���ã���Ĭ��ѡ�ؿ��ײ�)" size="2" disabled="true">
									</c:when>
									<c:otherwise>
										<html:select property="feeprio" disabled="true">
											<s:Options definition="$PC_FEEPRIO" />
										</html:select>
									</c:otherwise>
								</c:choose>
							</td>
							<td align="right">
								<div class="field-require">
									<bean:message bundle="yxplan" key="couldusetimes" />
									:
								</div>
							</td>
							<td align="left">
								<c:choose>
									<c:when test="${cpState}">
										<html:text styleClass="form_input_1x" property="couldusetimes" />
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="couldusetimes" disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>

						</tr>
						<tr>
							<td align="right">
								<div class="field-require">
									<bean:message bundle="yxplan" key="billingcode" />
									:
								</div>
							</td>
							<td align="left" colspan="3">
								<c:choose>
									<c:when test="${cpState}">
										<html:text styleClass="form_input_1x" property="billingcode" />
										<bean:message bundle="yxplan" key="billingcodemsg" />
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="billingcode" disabled="true" />
										<bean:message bundle="yxplan" key="billingcodemsg" />
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
						<td align="right">
								<div class="field-require">
									<bean:message bundle="yxplan" key="bookflag" />
									:
								</div>
							</td>
							<td align="left">
								<c:choose>
									<c:when test="${cpState}">
										<html:select property="bookflag">
											<s:Options definition="$PC_BOOKFLAG" />
										</html:select>
									</c:when>
									<c:otherwise>
										<html:select property="bookflag" disabled="true">
											<s:Options definition="$PC_BOOKFLAG" />
										</html:select>
									</c:otherwise>
								</c:choose>
							</td>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="yxplan" key="checkus" />
								:
							</div>
						</td>
						<td align="left" colspan="3">
							<c:choose>
								<c:when test="${cpState}">
									<html:select property="checkus">
										<s:Options definition="#ZIFEE_YON" />
									</html:select><font color="red">*</font>
								</c:when>
								<c:otherwise>
									<html:select property="checkus" disabled="true">
										<html:option value=""></html:option>
										<s:Options definition="#ZIFEE_YON" />
									</html:select>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
							<td align="right">
								<div class="field-require">
									<bean:message bundle="yxplan" key="userstausflag" />
									:
								</div>
							</td>
							<td align="left" colspan="3">
								<c:choose>
									<c:when test="${cpState}">
										<table class="form_table" border=0>
											<tr>
												<c:forEach var="name" items="${item.userstausflagName}" varStatus="vars">
													<td>
														<html:multibox property="selectuserstausflag">
															<c:out value="${item.userstausflagValue[vars.index]}" />
														</html:multibox>

														<c:out value="${name}" />
													</td>
													<c:if test="${(vars.index+1)%4==0}">
											</tr>

											<tr>
												</c:if>
												</c:forEach>
												
											</tr>
										</table>

									</c:when>
									<c:otherwise>
										<table class="form_table" border=0>
											<tr>
												<c:forEach var="name" items="${item.userstausflagName}" varStatus="vars">
													<td>
														<html:multibox property="selectuserstausflag" disabled='true'>
															<c:out value="${item.userstausflagValue[vars.index]}" />
														</html:multibox>
														<c:out value="${name}" />
													</td>
													<c:if test="${(vars.index+1)%4==0}">
											</tr>
											<tr>
												</c:if>
												</c:forEach>
											</tr>
										</table>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
											<tr>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="yxplan" key="yxplanshortname" />
								:
							</div>
						</td>
						<td align="left" >
							<c:choose>
								<c:when test="${cpState}">
									<html:text styleClass="form_input_1x" property="yxplanshortname" />
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="yxplanshortname" disabled="true" />
								</c:otherwise>
							</c:choose>
						</td>
						<td align="right">
							<div class="field-require">
								�ײ���Ч����
								:
							</div>
						</td>
						<td align="left" >
							<c:choose>
								<c:when test="${cpState}">
									<html:text styleClass="form_input_1x" property="usedbillcyc" />
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="usedbillcyc" disabled="true" />
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
						
						<tr>
							<td align="right">
								<div class="field-require">
									<bean:message bundle="yxplan" key="fixfeespecflag" />
									:
								</div>
							</td>
							<td align="left" colspan="5">
								<c:choose>
									<c:when test="${cpState}">
										<table class="form_table" border=0>
											<tr>
												<c:forEach var="item" items="${requestScope['/zifee/yxplan/YxPlanActionForm'].fixfeespecflags}"
													varStatus="vars">
													<td>
														<html:multibox property="seletefixfees" styleClass="table_checkbox">
															<c:out value="${item}" />
														</html:multibox>

														<c:out value="${item}" />
													</td>
													<c:if test="${(vars.index+1)%4==0}">
											</tr>
											<tr>
												</c:if>
												</c:forEach>
											</tr>
										</table>
									</c:when>
									<c:otherwise>
										<table class="form_table" border=0>
											<tr>
												<c:forEach var="item" items="${requestScope['/zifee/yxplan/YxPlanActionForm'].fixfeespecflags}"
													varStatus="vars">
													<td>
														<html:multibox property="seletefixfees" disabled="true" styleClass="table_checkbox">
															<c:out value="${item}" />
														</html:multibox>

														<c:out value="${item}" />
													</td>
													<c:if test="${(vars.index+1)%4==0}">
											</tr>
											<tr>
												</c:if>
												</c:forEach>
											</tr>
										</table>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
							<html:hidden property="specialflag" />

						<tr>
							<td align="right">
								<div class="field-require">
									<bean:message bundle="yxplan" key="specialflag" />
									:
								</div>
							</td>
							<td align="left" colspan="3">
								<html:hidden property="specialflag" />
								<c:choose>
									<c:when test="${cpState}">
										<table class="form_table" border=0>
											<tr>
												<c:forEach var="item" items="${requestScope[\'/zifee/yxplan/YxPlanActionForm\'].specialflagName}"
													varStatus="vars">
													<td>
														<html:multibox property="selectSpecialflag" onclick="checkSpecialFlagChange()">
															<c:out value="${requestScope.VALUE[vars.index]}" />
														</html:multibox>
														<c:out value="${item}" />
													</td>
													<c:if test="${(vars.index+1)%4==0}">
											</tr>
											<tr>
												</c:if>
												</c:forEach>
											</tr>
										</table>
									</c:when>
									<c:otherwise>
										<table class="form_table" border=0>
											<tr>
												<c:forEach var="item" items="${requestScope[\'/zifee/yxplan/YxPlanActionForm\'].specialflagName}"
													varStatus="vars">
													<td>
														<html:multibox property="selectSpecialflag" disabled="true" onclick="checkSpecialFlagChange()">
															<c:out value="${requestScope.VALUE[vars.index]}" />
														</html:multibox>
														<c:out value="${item}" />
													</td>
													<c:if test="${(vars.index+1)%4==0}">
											</tr>
											<tr>
												</c:if>
												</c:forEach>
											</tr>
										</table>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<td align="right">
								<div class="field-require">
									<bean:message bundle="yxplan" key="feecomment" />
									:
								</div>
							</td>
							<td align="left" colspan="5">
								<c:choose>
									<c:when test="${cpState}">
										<html:textarea styleClass="form_textarea_on_4" property="feecomment" />
									</c:when>
									<c:otherwise>
										<html:textarea styleClass="form_textarea_on_4" property="feecomment" disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<td align="right">
								<div class="field-require">
									<bean:message bundle="yxplan" key="remark" />
									:
								</div>
							</td>
							<td align="left" colspan="5">
								<c:choose>
									<c:when test="${cpState}">
										<html:textarea styleClass="form_textarea_on_4" property="remark" />
									</c:when>
									<c:otherwise>
										<html:textarea styleClass="form_textarea_on_4" property="remark" disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr style="display: none;">
							<td align="right">
								<div class="field-require">
									<bean:message bundle="yxplan" key="titleCopydt" />
									:
								</div>
							</td>
							<td align="left" colspan="3">
								<div style="overflow: auto; height: 100px">
									<TABLE class="form_table" border=0>
										<TR>
											<%
													if (list != null && list.size() > 0) {
													Iterator iterator = list.iterator();
													int count = 0;
													while (iterator.hasNext()) {
														DictitemVO dictitemVO = (DictitemVO) iterator
														.next();
											%>
											<td align="right">
												<input class="table_checkbox" type="checkbox" id="chb<%=dictitemVO.getDictid()%>" name="chb" checked>
											<td>
											<td align="left">
												<div class="field-require">
													<LABEL for="chb<%=dictitemVO.getDictid()%>">
														<%=dictitemVO.getDictname()%>
													</LABEL>
												</div>
											<td>
												<%
												if ((count + 1) % 3 == 0) {
												%>
											
										</TR>
										<TR>
											<%
														}
														count++;
													}
														}
											%>
										</TR>
									</TABLE>
								</div>
							</td>
						</tr>
					</table>
				</div>
				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td>
								<s:PurChk controlid="<%=ID_1%>">
									<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);" name="btnCopy"
										onfocus="buttonover(this)" onblur="buttonout(this)" value="<bean:message bundle="yxplan" key="button_copy"/>"
										class="submit" onclick="doSingleCopy('/zifee/yxplan.do?CMD=SINGLECOPY')" />
								</s:PurChk>
								<s:PurChk controlid="<%=ID_2%>">
									<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);" name="btnPrint"
										onfocus="buttonover(this)" onblur="buttonout(this)" value="<bean:message bundle="public" key="button_print"/>"
										class="print" onclick="doPrint()">
								</s:PurChk>
								<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);" name="btnReturn"
									onfocus="buttonover(this)" onblur="buttonout(this)" value="<bean:message bundle="public" key="button_return"/>"
									class="close" onclick="doReturn('/zifee/yxplan.do?CMD=LIST')">
							</td>
						</tr>
					</table>
				</div>
			</html:form>
		</div>
	</div>
</body>
</html:html>
