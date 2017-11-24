<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<%@ page import="org.ajaxanywhere.AAUtils"%>
<%@ include file="/inc/contenthead.inc"%>
<%@ taglib uri="http://ajaxanywhere.sourceforge.net/" prefix="aa"%>
<%
	String ID_1 = "CH_PW_SOTYWAY_EDIT";
	String ID_2 = "CH_PW_SOTYWAY_QUERY";
%>


<html:html>
<head>
	<title><bean:message bundle="Way" key="distitleList" />
	</title>
	<script type="text/javascript" src="<%=contextPath%>/js/aa.js"></script>
	<script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
	<script type="text/javascript" src="<%=contextPath%>/js/bus/rescommon.js"></script>
	<script language="JavaScript">
        function ev_checkval() {
 			if(date_compare('begintime', 'cmpendtime', "合同到期日不能早于生效时间")){
            	return false;
            }
            if(document.all("compactpath").value == ""){
            	document.all("compactpath").value = document.all("compactfile").value;
            }
            if(document.all("licencepath").value == ""){
            	document.all("licencepath").value = document.all("licencefile").value;
            }
            if(document.all("longtitude").value !="" ){
            	if ((document.all("longtitude").value*1<100 ||document.all("longtitude").value*1>130 )) {
            		alert("经度值必须在100 － 130 之间!");
            		return false;
            	}
            	var str = document.all("longtitude").value;
            	var substr = str.substring(4);
            	if (substr.length!=6) {
            		alert("经度值小数位必须为6位!");
            		return false;
            	}
            }
            if(document.all("latitude").value !="" ){
            	if (document.all("latitude").value*1<18 ||document.all("latitude").value*1>26) {
            		alert("纬度值必须在18 － 26 之间!");
            		return false;
            	}

            	var str = document.all("latitude").value;
            	var substr = str.substring(3);
            	if (substr.length!=6) {
            		alert("纬度值小数位必须为6位!");
            		return false;
            	}
            }
          addfield('wayid', '<bean:message bundle="Way" key="WAYID"/>', 'c', false , 18);
            addfield('wayname', '<bean:message bundle="Way" key="WAYNAME"/>', 'c', false, 256);
            addfield('upperwayid', '<bean:message bundle="Way" key="upperwayid"/>', 'c', false, 18);      
            
             addfield('principal', '<bean:message bundle="bchcontact" key="principal"/>', 'c', false, '20');
            addfield('principaltel', '<bean:message bundle="bchcontact" key="principaltel"/>', 'c', false, '15');
            addfield('linkman', '<bean:message bundle="bchcontact" key="linkman"/>', 'c', false, '32');
            addfield('linkmantel', '<bean:message bundle="bchcontact" key="linkmantel"/>', 'c', false, '15');
            addfield('principalemail', '<bean:message bundle="bchcontact" key="principalemail"/>', 'm', true, '64');
            addfield('linkmanemail', '<bean:message bundle="bchcontact" key="linkmanemail"/>', 'm', true, '64');
            
            addfield('compactno', '<bean:message bundle="waycompact" key="compactno"/>', 'c', false, '17');
            addfield('compactname', '<bean:message bundle="waycompact" key="compactname"/>', 'c', false, '32'); 
            addfield('cmpendtime', '<bean:message bundle="waycompact" key="endtime"/>', 't', false, '25');
            addfield('signtime', '<bean:message bundle="waycompact" key="signtime"/>', 't', false, '25');
            addfield('copbound', '<bean:message bundle="waycompact" key="copbound"/>', 'c', true, '40');
            addfield('licenceno', '<bean:message bundle="waycompact" key="licenceno"/>', 'c', false, '32');
            addfield('compactpath', '<bean:message bundle="waycompact" key="compactpath"/>', 'c', true, '128');
            addfield('licencepath', '<bean:message bundle="waycompact" key="licencepath"/>', 'c', true, '128');
            addfield('runareatype', '<bean:message bundle="waycompact" key="runareatype"/>', 'i', true, '2');
            addfield('bankname', '<bean:message bundle="wayaccount" key="bankname"/>', 'c', false, 128);   
            addfield('sendaddr', '<bean:message bundle="cooperator" key="sendaddr"/>', 'c', true, 128);
	    addfield('recpers', '<bean:message bundle="cooperator" key="recpers"/>', 'c',true, 32);
	    addfield('recconntel', '<bean:message bundle="cooperator" key="recconntel"/>', 'c', true, 15);
	    addfield('licvalidate', '<bean:message bundle="cooperator" key="licvalidate"/>', 't', false, 20);
	    addfield('baillwrlmt', '<bean:message bundle="cooperator" key="baillwrlmt"/>', 'd', false,16,2);
	    addfield('intime', '<bean:message bundle="cooperator" key="intime"/>', 't', false, 20);
	    addfield('buzphoneno', '<bean:message bundle="bchcontact" key="buzphoneno"/>', 'c', true, '12');
             //way
            addfield('adacode', '<bean:message bundle="Way" key="adacode"/>', 'c', true, 18);
            addfield('address', '<bean:message bundle="Way" key="address"/>', 'c', true, 128);
            addfield('latitude', '<bean:message bundle="Way" key="latitude"/>', 'd', false, 2,6);
            addfield('longtitude', '<bean:message bundle="Way" key="longtitude"/>', 'd', false, 3,6);
            addfield('cityid', '<bean:message bundle="Way" key="cityid"/>', 'c', true, '14');
            addfield('countyid', '<bean:message bundle="Way" key="countyid"/>', 'c', true, '14');
            addfield('svccode', '<bean:message bundle="Way" key="svccode"/>', 'c', true, '14');
            
            //contact    
           addfield('reccertno', '<bean:message bundle="cooperator" key="reccertno"/>', 'c', true, 20);
           addfield('company', '<bean:message bundle="Way" key="company"/>', 'c', true, 60);
           addfield('coplevel', '<bean:message bundle="Way" key="coplevel"/>', 'i', true, 3);
           addfield('busnum', '<bean:message bundle="Way" key="busnum"/>', 'c', true, 30);
           addfield('certitype', '<bean:message bundle="Way" key="certitype"/>', 'i', true, 3);
           addfield('certinum', '<bean:message bundle="Way" key="certinum"/>', 'c', true, 30);
           addfield('regadress', '<bean:message bundle="Way" key="regadress"/>', 'c', true, 128);
           addfield('regcapital', '<bean:message bundle="Way" key="regcapital"/>', 'i', true, 14);
            //compact
           addfield('regcapital', '<bean:message bundle="cooperator" key="reccertno"/>', 'c', true, 20);
           addfield('begintime', '<bean:message bundle="waycompact" key="begintime"/>', 't', false);
           addfield('signtime', '<bean:message bundle="waycompact" key="signtime"/>', 't', false);
          addfield('bail', '<bean:message bundle="waycompact" key="bail"/>', 'd', true, 18, 2);
            
            //account
            addfield('acctno', '<bean:message bundle="wayaccount" key="acctno"/>', 'c', false, 50);
            addfield('acctname', '<bean:message bundle="wayaccount" key="acctname"/>', 'c', false, 64);
            addfield('acctfid', '<bean:message bundle="wayaccount" key="acctfid"/>', 'c', true, 21);
            return checkval(window);
        }
        
         function changeWay(obj){
        	var control = document.getElementById("upperwayid");
        	showSelectWay(obj);
 			var cmd = '<%=request.getParameter("CMD")%>';
    		if(document.getElementById("upperwayid").value == ""){
    		if(cmd == "AGEDIT"){
    			

formItem.action="<%=contextPath%>/cms/disway.do?CMD=AGEDIT&PK="+document.getElementById("wayid").value;
	        	formItem.submit();
        		}else{
        		formItem.action="<%=contextPath%>/cms/disway.do?CMD=AGNEW";
        		formItem.submit();
        		}
        	
        	}else{
    				formItem.action="<%=contextPath%>/cms/disway.do?CMD=AGUPWAY";
        			formItem.submit();
        	}
        }   
         function doGetList(cmdvalue){
			ajaxAnywhere.submitByURL("/cms/distribute/cooperator.do?CMD=GETCOUNTID&cmdvalue="+cmdvalue+"&cmdstates=<c:out value="${requestScope['/cms/way/AGWayForm'].cmdState}"/>"); 
		}
    </script>
</head>
<body onload="if(window.loadforiframe) loadforiframe();">
	<div class="table_container">
		<html:form action="/cms/disway.do?CMD=AGSAVE" styleId="formItem"
			method="post" enctype="multipart/form-data">
			<input type="hidden" name="waysubtype" value="DIS" />
			<input type="hidden" name="centerid"
				value="<c:out value='${requestScope.centerid}'/>" />
			<html:hidden property="waylevel" />
			<html:hidden property="cmdState" />
			<html:hidden property="_orderby" />
			<html:hidden property="_desc" />
			<html:hidden property="_pageno" />
			<html:hidden property="_pagesize" />
			<html:hidden property="_sk_wayid" />
			<html:hidden property="_sk_wayname" />
			<html:hidden property="_se_upperwayid" />
			<html:hidden property="_ne_cooperator" />
			<html:hidden property="_se_cityid" />
			<html:hidden property="_se_countyid" />
			<html:hidden property="_se_svccode" />
			<html:hidden property="_se_mareacode" />
			<c:set var="edtState" scope="request"
				value="${(!empty param.CMD and (param.CMD eq 'AGEDIT' or param.CMD eq  'AGNEW' or param.CMD  eq  'AGUPWAY')) or( requestScope['cmdState'] eq 'EDIT')}" />
			<c:set var="updateState" scope="request"
				value="${!empty param.CMD and (param.CMD eq 'AGEDIT')}" />
			<c:set var="wayForm" scope="request"
				value="${requestScope['/cms/way/AGWayForm']}" />
			<div class="table_div">
				<table class="top_table">
					<tr>
						<td>
							<bean:message bundle="Way" key="distitleList" />
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

			<div class="table_div">
				<FIELDSET>
					<legend name="baseinfo">
						<bean:message bundle="Way" key="distitleList" />
					</legend>

					<table class="form_table">
						<tr>
							<td align=left colspan="4">
								&nbsp;&nbsp;
								<bean:message bundle="public" key="msgRequired" />


							</td>
						</tr>
						<tr>
							<td td align="right">
								<div class="field-require">
									<bean:message bundle="Way" key="upperwayid" />
									:
								</div>
							</td>
							<td align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">

										<%-- <html:text styleClass="form_input_1x" property="upperwayid"
											onclick="changeWay(this)" maxlength="18" readonly="true" />
										--%>
										<input type="text" class="form_input_1x" name="upperwayid"
										maxlength="18" readonly="true" value='<c:out value="${requestScope['/cms/way/AGWayForm']._se_upperwayid}" />'>
										<font color=red>&nbsp;*</font>
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="upperwayid"
											disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>
							<td td align="right">
								<div class="field-require">
									<bean:message bundle="Way" key="upperwayname" />
									:
								</div>
							</td>
							<td align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<%-- <s:zoom definition="#WAY" property="upperwayid"
											styleClass="form_input_1x" readonly="true" />
										--%>
										
										<input type="text" class="form_input_1x" name="upperwayname"
										maxlength="18" readonly="true" value='<s:Code2Name code="${requestScope['/cms/way/AGWayForm']._se_upperwayid}"  definition="#WAY"/>'><font color=red>&nbsp;*</font>
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="upperwayname" disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>

						</tr>

						<tr>
							<td align="right">
								<div class="field-require">
									<bean:message bundle="Way" key="WAYID" />
									:
								</div>
							</td>
							<td align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<c:if test="${updateState}">
											<html:text styleClass="form_input_1x" property="wayid"
												maxlength="18" />
											<font color=red>&nbsp;*</font>
										</c:if>
										<c:if test="${!updateState}">
											<html:text styleClass="form_input_1x" property="wayid"
												maxlength="18" />
											<font color=red>&nbsp;*</font>
										</c:if>
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="wayid"
											disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>
							<td td align="right">
								<div class="field-require">
									<bean:message bundle="Way" key="WAYNAME" />
									:
								</div>
							</td>
							<td align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<html:text styleClass="form_input_1x" property="wayname"/>
										<font color=red>&nbsp;*</font>
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="wayname"
											disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>



						</tr>

						<tr>
							<td align="right">
								<div class="field-require">
									<bean:message bundle="Way" key="cityid" />
									:
								</div>
							</td>
							<td nowrap align="left">
								<aa:zone name="getcityid">
									<div>
										<c:choose>
											<c:when test="${ empty requestScope['/cms/way/AGWayForm'].cityid}">
												<html:select property="cityid" onchange="doGetList('cityid');">
													<option />
														<s:Options definition="#CITYCOMPANY" />
												</html:select>
											</c:when>
											<c:otherwise>
												<html:text styleClass="form_input_1x" property="cityid" readonly="true"/>
											</c:otherwise>
										</c:choose>
									</div>
								</aa:zone>
							</td>
							<td align="right">
								<div class="field-require">
									<bean:message bundle="Way" key="countyid" />
									:
								</div>
							</td>
							<td nowrap align="left">
								<aa:zone name="getcountyid">
									<div>
										<c:choose>
											<c:when
												test="${empty requestScope['/cms/way/AGWayForm'].countyid or requestScope.ischange eq '1'}">
												<html:select property="countyid" onchange="doGetList('citycompid');">
													<option />
														<s:Options definition="#CNTYCOMPANY"
															condition="citycompid:${requestScope['/cms/way/AGWayForm'].cityid}" />
												</html:select>
											</c:when>
											<c:otherwise>
												<html:text styleClass="form_input_1x" property="countyid" readonly="true" />
											</c:otherwise>
										</c:choose>
									</div>
								</aa:zone>
							</td>
						</tr>
						<tr>
							<td align="right">
								<div class="field-require">
									<bean:message bundle="Way" key="svccode" />
									:
								</div>
							</td>
							<td nowrap align="left">
								<aa:zone name="getsvccode">
									<div>
										<c:choose>
											<c:when test="${edtState}">
												<html:select property="svccode" onchange="doGetList();">
													<option />
														<s:Options definition="#SERVCENT"
															condition="countyid:${requestScope['/cms/way/AGWayForm'].countyid}" />
												</html:select>
											</c:when>
											<c:otherwise>
												<html:text styleClass="form_input_1x" property="svccode" readonly="true" />
											</c:otherwise>
										</c:choose>
									</div>
								</aa:zone>
							</td> 
							<td align="right">
								<div class="field-require">
									<bean:message bundle="Way" key="mareacode" />
									:
								</div>
							</td>
							<td nowrap align="left">
								<aa:zone name="getmareacode">
					                <div>
					                    <c:choose>
					                        <c:when test="${edtState}">
					                		<html:select property="mareacode">
					                		 <option/>
					                		 <s:Options definition="#MICROAREA" condition="svccode:${requestScope['/cms/way/AGWayForm'].svccode}"/>
					                		 </html:select>
					                        </c:when>
					                        <c:otherwise>
					                            <html:text styleClass="form_input_1x" property="mareacode" readonly="true"/>
					                        </c:otherwise>
					                    </c:choose>
					                    </div>
					            </aa:zone>
							</td>
						</tr>
						<tr>
							<%--
							<td align="right">
								<div class="field-require">
									  <bean:message bundle="Way" key="taxttype" /> 
									:
								</div>
							</td>
							
							<td align="left" class="form_table_left">
								
								 <c:choose>
									<c:when test="${edtState}">
										<html:select property="taxtype">
												<s:Options definition="$CH_STTAXTYPE" />
										</html:select>
									</c:when>
									<c:otherwise>
										<input type="text" readonly="readonly" class="form_input_1x" disable="true" />
									</c:otherwise>
								</c:choose>
								
							</td>
							--%>
							<td align="right">
								<div class="field-require">
									<bean:message bundle="Way" key="mainlayer" />
									:
								</div>
							</td>
							<td align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<html:select property="mainlayer">
											<option />
												<s:Options definition="$CH_COPLAYER" />
										</html:select>
									</c:when>
									<c:otherwise>
										<html:select property="mainlayer" disabled="true">
											<option />
												<s:Options definition="$CH_COPLAYER" />
										</html:select>
									</c:otherwise>
								</c:choose>
							</td>
							<td align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="bchcontact" key="buzphoneno" />
									:
								</div>
							</td>
							<td align="left">
								<c:choose>
									<c:when test="${edtState}">
										<html:text styleClass="form_input_1x" property="buzphoneno"
											maxlength="128" />
										
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="buzphoneno"
											disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>

						</tr>

						<tr>
							<td align="right">
								<div class="field-require">
									<bean:message bundle="Way" key="cooperator1" />
									:
								</div>
							</td>
							<td align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<html:select property="cooperator">
											<option />
												<s:Options definition="$CH_COOPERATOR" />
										</html:select>
									</c:when>
									<c:otherwise>
										<html:select property="cooperator" disabled="true">
											<option />
												<s:Options definition="$CH_COOPERATOR" />
										</html:select>
									</c:otherwise>
								</c:choose>
							</td>

							<td align="right">
								<bean:message bundle="Way" key="adacode" />
								:
							</td>
							<td align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<s:zoom definition="#CH_ADIMAREA" property="adacode"
											styleClass="form_input_1x"></s:zoom>
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="adacode"
											readonly="true" />
									</c:otherwise>
								</c:choose>
							</td>
						</tr>

						<tr>
							<td align="right">
								<bean:message bundle="Way" key="latitude" />
								:
							</td>
							<td align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<html:text styleClass="form_input_1x" maxlength="9" property="latitude" />
										<font color=red>&nbsp;*</font>
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="latitude"
											readonly="true" />
									</c:otherwise>
								</c:choose>
							</td>
							<td align="right">
								<bean:message bundle="Way" key="longtitude" />
								:
							</td>
							<td align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<html:text styleClass="form_input_1x" maxlength="10" property="longtitude" />
										<font color=red>&nbsp;*</font>
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="longtitude"
											readonly="true" />
									</c:otherwise>
								</c:choose>
							</td>

						</tr>
						<tr>
							<td align="right">
								<div class="field-require">
									<bean:message bundle="Way" key="waystate" />
									:
								</div>
							</td>
							<td align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<html:select property="waystate" >
											<s:Options definition="$CH_VALIDFLAG" />
										</html:select>
									</c:when>
									<c:otherwise>
										<html:select property="waystate" disabled="true">
											<s:Options definition="$CH_VALIDFLAG" />
										</html:select>
									</c:otherwise>
								</c:choose>
							</td>
							<td align="right">
								<div class="field-require">
									<bean:message bundle="Way" key="signstatus" />
									:
								</div>
							</td>
							<td align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<html:select property="signstatus">
											<option />
												<s:Options definition="$CH_SIGNSTATUS" />
										</html:select>
									</c:when>
									<c:otherwise>
										<html:select property="signstatus" disabled="true">
											<option />
												<s:Options definition="$CH_SIGNSTATUS" />
										</html:select>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						
						<tr>
							<td align="right">
								<div class="field-require">
									<bean:message bundle="Way" key="taxtype" />
									:
								</div>
							</td>
							<td align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<html:select property="taxtype">
												<s:Options definition="$CH_STTAXTYPE" />
										</html:select>
									</c:when>
									<c:otherwise>
										<html:select property="taxtype" disabled="true">
												<s:Options definition="$CH_STTAXTYPE" />
										</html:select>
									</c:otherwise>
								</c:choose>
							</td>
							<td></td>
						</tr>
						<tr>
							<td align="right">
								<div class="field-require">
									<bean:message bundle="Way" key="address" />
									:
								</div>
							</td>
							<td align="left" colspan="3">
								<c:choose>
									<c:when test="${edtState}">
										<html:text styleClass="form_input_3x" style="width:503px"
											property="address"/>
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_3x" property="address"
											disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						
						<tr>
							<td align="left" colspan="4">
								<bean:message bundle="Way" key="exp" />
							</td>
						</tr>
					</table>
				</FIELDSET>

				<FIELDSET>
					<legend name="bchcontact">
						<bean:message bundle="bchcontact" key="distitleList" />
					</legend>
					<table class="form_table">
						<tr>
							<td align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="bchcontact" key="principal" />
									:
								</div>
							</td>
							<td align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<html:text styleClass="form_input_1x" property="principal"
											maxlength="32" />
										<font color=red>&nbsp;*</font>
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="principal"
											disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>
							<td align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="bchcontact" key="principaltel" />
									:
								</div>
							</td>
							<td align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<html:text styleClass="form_input_1x" property="principaltel"
											maxlength="20" />
										<font color=red>&nbsp;*</font>
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="principaltel"
											disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>
						</tr>

						<tr>
							<td align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="bchcontact" key="linkman" />
									:
								</div>
							</td>
							<td align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<html:text styleClass="form_input_1x" property="linkman"
											maxlength="64" />
										<font color=red>&nbsp;*</font>
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="linkman"
											disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>
							<td align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="bchcontact" key="linkmantel" />
									:
								</div>
							</td>
							<td align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<html:text styleClass="form_input_1x" property="linkmantel"
											maxlength="20" />
										<font color=red>&nbsp;*</font>
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="linkmantel"
											disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>
						</tr>

						<tr>
							<td align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="bchcontact" key="principalemail" />
									:
								</div>
							</td>
							<td align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<html:text styleClass="form_input_1x"
											property="principalemail" />
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x"
											property="principalemail" disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>
							<td align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="bchcontact" key="linkmanemail" />
									:
								</div>
							</td>
							<td align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<html:text styleClass="form_input_1x" property="linkmanemail"
											maxlength="128" />
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="linkmanemail"
											disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						
						<tr>
							<td align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="cooperator" key="recpers" />
									:
								</div>
							</td>
							<td align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<html:text styleClass="form_input_1x" property="recpers"
											maxlength="20" />
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="recpers"
											disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>
							<td align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="cooperator" key="reccertno" />
									:
								</div>
							</td>
							<td align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<html:text styleClass="form_input_1x" property="reccertno"
											maxlength="128" />
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="reccertno"
											disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>

						</tr>
						<tr>
							<td align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="cooperator" key="recconntel" />
									:
								</div>
							</td>
							<td align="left">
								<c:choose>
									<c:when test="${edtState}">
										<html:text styleClass="form_input_1x" property="recconntel"
											maxlength="128" />
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="recconntel"
											disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>
							<td align="right" class="form_table_right">
								<div class="field-require">
									&nbsp;
								</div>
							</td>
							<td align="left" class="form_table_left">
								&nbsp;
							</td>
						</tr>
						<tr>
							<td align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="cooperator" key="sendaddr" />
									:
								</div>
							</td>
							<td align="left" colspan="3">
								<c:choose>
									<c:when test="${edtState}">
										<html:text styleClass="form_input_3x" style="width:503px"
											property="sendaddr" />
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_3x" property="sendaddr"
											disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<td align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="Way" key="company" />
									:
								</div>
							</td>
							<td align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<div style="position:relative;">
										<span style="margin-left:100px;width:18px;overflow:hidden;">
										<select style="width:118px;margin-left:-100px"  onchange="this.parentNode.nextSibling.value=this.value">
											<option value="苏宁"> 苏宁 </option>
											<option value="国美"> 国美 </option>
											<option value="迪信通"> 迪信通 </option>
											<option value="青年中心"> 青年中心 </option>
											<option value="大地"> 大地 </option>
											<option value="中域"> 中域 </option>
											<option value="协亨">协亨 </option>
											<option value="恒波">恒波 </option>
											<option value="骏和"> 骏和 </option>
											<option value="龙粤"> 龙粤 </option>
										</select>
										</span>
										<input class="form_input_1x" name="company" style="width:100px;position:absolute;left:0px;" value="<c:out value='${requestScope["/cms/way/AGWayForm"].company}' />" />
										</div>
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x"
											property="company" disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>
							<td align="right" class="form_table_right"> 
								<div class="field-require">
									<bean:message bundle="Way" key="coplevel" />
									:
								</div>
							</td>
							 <td align="left" class="form_table_left">
								 <c:choose>
									<c:when test="${edtState}">
										<html:select property="coplevel" >
											<option />
											<s:Options definition="$CH_COPLEVEL" />
										</html:select>
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="coplevel" disabled="true" />
									</c:otherwise>
								</c:choose>
							 </td>
						</tr>
						<tr>
							<td align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="Way" key="busnum" />
									:
								</div>
							</td>
							<td align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<html:text styleClass="form_input_1x"
											property="busnum"  />
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x"
											property="busnum" disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>
							<td align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="Way" key="certitype" />
									:
								</div>
							</td>
							<td align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<html:select   property="certitype">
											<option />
											<s:Options definition="$IB_CERTITYPE" />
										</html:select>
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="certitype"
											disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<td align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="Way" key="regadress" />
									:
								</div>
							</td>
							<td align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<html:text styleClass="form_input_1x"
											property="regadress" maxlength="128" />
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x"
											property="regadress" disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>
							<td align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="Way" key="regcapital" />
									:
								</div>
							</td>
							<td align="left" class="form_table_left">
								 <c:choose>
									<c:when test="${edtState}">
										<html:text styleClass="form_input_1x" property="regcapital" />
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="regcapital"
											disabled="true" />
									</c:otherwise>
								</c:choose>
							 </td>
						</tr>
						<tr>
							<td align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="Way" key="certinum" />
									:
								</div>
							</td>
							<td align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<html:text styleClass="form_input_1x"
											property="certinum" />
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x"
											property="certinum" disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>
							<td align="right" class="form_table_right">
								<div class="field-require">
									&nbsp;
								</div>
							</td>
							<td align="left">
								&nbsp;
							</td>
						</tr>
					</table>
				</FIELDSET>







				<FIELDSET>
					<legend name="compact">
						<bean:message bundle="waycompact" key="distitleList" />
					</legend>


					<table class="form_table">


						<tr>
							<td align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="waycompact" key="compactname" />
									:
								</div>
							</td>
							<td align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<html:text styleClass="form_input_1x" property="compactname"
											maxlength="32" />
										<font color=red>&nbsp;*</font>
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="compactname"
											disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>
							<td align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="waycompact" key="licenceno" />
									:
								</div>
							</td>
							<td align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<html:text styleClass="form_input_1x" property="licenceno"
											maxlength="64" />
										<font color=red>&nbsp;*</font>
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="licenceno"
											disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>
						</tr>


						<tr>
							<td align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="waycompact" key="compactno" />
									:
								</div>
							</td>
							<td align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<html:text styleClass="form_input_1x" property="compactno"
											maxlength="17" />
										<font color=red>&nbsp;*</font>
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="compactno"
											disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>
							<td align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="waycompact" key="principal" />
									:
								</div>
							</td>
							<td align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<c:if test="${!updateState}">
											<c:out value="${wayForm.principal}" />
										</c:if>
									</c:when>
									<c:otherwise>
										<c:out value="${wayForm.principal}" />
									</c:otherwise>
								</c:choose>
							</td>
						</tr>

						<tr>
							<td align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="waycompact" key="begintime" />
									:
								</div>
							</td>
							<td align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<html:text styleClass="form_input_1x" property="begintime"
											onclick="this.value=selectDate()" maxlength="25" />
										<font color=red>&nbsp;*</font>
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="begintime"
											disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>
							<td align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="waycompact" key="endtime" />
									:
								</div>
							</td>
							<td align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<html:text styleClass="form_input_1x" property="cmpendtime"
											onclick="this.value=selectDate()" maxlength="25" />
										<font color=red>&nbsp;*</font>
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="cmpendtime"
											disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>
						</tr>

						<tr>
							<td align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="waycompact" key="copbound" />
									:
								</div>
							</td>
							<td align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<html:text styleClass="form_input_1x" property="copbound"
											maxlength="40" />
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="copbound"
											disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>
							<td align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="waycompact" key="runareatype" />
									:
								</div>
							</td>
							<td align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<html:select property="runareatype">
											<option />
												<s:Options definition="$CH_ORGTYPE"></s:Options>
										</html:select>
									</c:when>
									<c:otherwise>
										<html:select property="runareatype" disabled="true">
											<option />
												<s:Options definition="$CH_ORGTYPE"></s:Options>
										</html:select>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>

						<tr>
							<td align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="waycompact" key="bail" />
									:
								</div>
							</td>
							<td align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<html:text styleClass="form_input_1x" property="bail"
											maxlength="40" />
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="bail"
											disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>
							<td align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="cooperator" key="baillwrlmt" />
									:
								</div>
							</td>
							<td align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<html:text styleClass="form_input_1x" property="baillwrlmt"
											maxlength="40" />
										
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="baillwrlmt"
											disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<td align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="waycompact" key="compacttype" />
									:
								</div>
							</td>
							<td align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<html:select property="compacttype">
											<option />
												<s:Options definition="$CH_COMPACTTYPE"></s:Options>
										</html:select>
									</c:when>
									<c:otherwise>
										<html:select property="compacttype" disabled="true">
											<option />
												<s:Options definition="$CH_COMPACTTYPE"></s:Options>
										</html:select>
									</c:otherwise>
								</c:choose>


							</td>
							<td align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="waycompact" key="signtime" />
									:
								</div>
							</td>
							<td align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<html:text styleClass="form_input_1x" property="signtime"
											onclick="this.value=selectDate()" maxlength="25" />
										<font color=red>&nbsp;*</font>
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="signtime"
											disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>

						</tr>


						<tr>
							<td align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="waycompact" key="bailstatus" />
									:
								</div>
							</td>
							<td align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<html:select property="compacttype">
											<option />
												<s:Options definition="$CH_BAILSTATUS"></s:Options>
										</html:select>
									</c:when>
									<c:otherwise>
										<html:select property="compacttype" disabled="true">
											<option />
												<s:Options definition="$CH_BAILSTATUS"></s:Options>
										</html:select>
									</c:otherwise>
								</c:choose>
							<td align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="cooperator" key="licvalidate" />
									:
								</div>
							</td>
							<td align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<input class="form_input_1x" name="licvalidate"
											value="<fmt:formatDate 

value="${wayForm.licvalidate}" pattern="yyyy-MM-dd"/>"
											readonly onclick="this.value=selectDate();">
											<font color=red>&nbsp;*</font>
									</c:when>
									<c:otherwise>
										<input class="form_input_1x" name="licvalidate"
											value="<fmt:formatDate 

value="${wayForm.licvalidate}" pattern="yyyy-MM-dd"/>"
											disabled><font color=red>&nbsp;*</font>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>





						<tr>
							<td align="right" width="14%">
								<div class="field-require">
									<bean:message bundle="waycompact" key="compactpath" />
									:
								</div>
							</td>
							<td colspan="3" align="left" class="form_table_left">
								<html:file property="compactfile" styleClass="form_input_files"></html:file>
							</td>
						</tr>
						<tr>
							<td align="right" width="14%">
								<div class="field-require"></div>
							</td>
							<td colspan="3" align="left" class="form_table_left">
								<c:out value="${wayForm.compactpath}" />
								<html:hidden property="compactpath" />
							</td>
						</tr>

						<tr>
							<td align="right" width="14%">
								<div class="field-require">
									<bean:message bundle="waycompact" key="licencepath" />
									:
								</div>
							</td>
							<td colspan="3" align="left" class="form_table_left">
								<html:file property="licencefile" styleClass="form_input_files"></html:file>
							</td>
						</tr>
						<tr>
							<td align="right" width="14%">
								<div class="field-require"></div>
							</td>
							<td colspan="3" align="left" class="form_table_left">
								<c:out value="${wayForm.licencepath}" />
								<html:hidden property="licencepath" />

							</td>
						</tr>


					</table>


				</FIELDSET>




				<FIELDSET>
					<legend name="ccount">
						<bean:message bundle="wayaccount" key="distitleList" />
					</legend>
					<table class="form_table">

						<tr>


							<td align="right">
								<div class="field-require">
									<bean:message bundle="wayaccount" key="bankname" />
									:
								</div>
							</td>
							<td align="left">
								<c:choose>
									<c:when test="${edtState}">
										<html:text styleClass="form_input_1x" property="bankname" />
										<font color=red>&nbsp;*</font>
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="bankname"
											disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>
							<td align="right">
								<div class="field-require">
									<bean:message bundle="wayaccount" key="acctname" />
									:
								</div>
							</td>
							<td align="left">
								<c:choose>
									<c:when test="${edtState}">
										<html:text styleClass="form_input_1x" property="acctname" />
										<font color=red>&nbsp;*</font>
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="acctname"
											disabled="true" />
										<font color=red>&nbsp;*</font>
									</c:otherwise>
								</c:choose>
							</td>

						</tr>

						<tr>
							<td align="right">
								<div class="field-require">
									<bean:message bundle="wayaccount" key="acctno" />
									:
								</div>
							</td>
							<td align="left">
								<c:choose>
									<c:when test="${edtState}">
										<html:text styleClass="form_input_1x" property="acctno" />
										<font color=red>&nbsp;*</font>
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="acctno"
											disabled="true" />
										<font color=red>&nbsp;*</font>
									</c:otherwise>
								</c:choose>
							</td>



							<td align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="cooperator" key="intime" />
									:
								</div>
							</td>
							<td align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<input class="form_input_1x" name="intime"
											value="<fmt:formatDate 

value="${wayForm.intime}" pattern="yyyy-MM-dd"/>"
											readonly onclick="this.value=selectDate();">
										<font color=red>&nbsp;*</font>
									</c:when>
									<c:otherwise>
										<input class="form_input_1x" name="intime"
											value="<fmt:formatDate 

value="${wayForm.intime}" pattern="yyyy-MM-dd"/>"
											disabled>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>

						<tr>

							<td align="right">
								<div class="field-require">
									<bean:message bundle="wayaccount" key="acctfid" />
									:
								</div>
							</td>
							<td align="left" colspan="3">
								<c:choose>
									<c:when test="${edtState}">
										<html:text styleClass="form_input_1x" property="acctfid" />
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="acctfid"
											disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>
						</tr>


					</table>
				</FIELDSET>
			</div>

			<div class="table_div">
				<table class="table_button_list">
					<tr>
						<td>
							<s:PurChk2 controlid="<%=ID_1%>">
								<input type="button" onmouseover="buttonover(this);"
									onmouseout="buttonout(this);" name="btnSave"
									onfocus="buttonover(this)" onblur="buttonout(this)"
									value="<bean:message bundle="public" key="button_save"/>"
									class="submit" onclick="doSave('/cms/disway.do?CMD=AGSAVE');" />
							</s:PurChk2>

							<input type="button" onmouseover="buttonover(this);"
								onmouseout="buttonout(this);" name="btnReturn"
								onfocus="buttonover(this)" onblur="buttonout(this)"
								value="<bean:message bundle="public" key="button_return"/>"
								class="close"
								onclick="doReturn('/cms/disway.do?CMD=AGLIST&WAYSUBTYPE=DIS')">
						</td>
					</tr>
				</table>
			</div>
		</html:form>
	</div>
</body>
</html:html>
