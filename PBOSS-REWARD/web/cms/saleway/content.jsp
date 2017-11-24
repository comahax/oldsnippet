<%@ page language="java" contentType="text/html;charset=GBK"%>
<%
//  contenthead.inc是content.jsp的文件头，声明了JS、CSS等的引用，所有content.jsp必须引用这个文件头
%>
<%@ include file="/inc/contenthead.inc"%>
<jsp:include page="/inc/acl.jsp">
	<jsp:param name="PID" value="2B1A3CBB70" />
</jsp:include>
<%
	String ID_1 = "CH_PW_SALEWAY_EDIT";
	String newSVWayPk = (String) request.getAttribute("newSVWayPk");
	newSVWayPk = newSVWayPk == null ? "" : newSVWayPk;
%>

<html:html>
<head>
	<title><bean:message bundle="saleway" key="titleUpdate" />
	</title>
	<script type="text/javascript"
		src="<%=contextPath%>/js/bus/waycommon.js"></script>
	<script language="JavaScript">
        <%//录入数据的校检%>
        function ev_checkval() {
            if(date_compare('begintime', 'cmpendtime', "合同到期日不能早于生效时间")){
            	return;
            }
            if(document.all("compactpath").value == ""){
            	document.all("compactpath").value = document.all("compactfile").value;
            }
            if(document.all("licencepath").value == ""){
            	document.all("licencepath").value = document.all("licencefile").value;
            }
            var strlat = document.all("latitude").value;
            var strlong = document.all("longtitude").value;
            if(strlat != ""){
            	if(strlat.substring(strlat.indexOf(".") + 1).length != 6){
            		alert("纬度值小数位必须为6位!");
            		return ;
            	}
            	if (strlat*1<18 ||strlat*1>26) {
            		alert("纬度值必须在18 － 26 之间!");
            		return ;
            		
            	}
            }
            if(strlong != ""){
            	if(strlong.substring(strlong.indexOf(".") + 1).length != 6){
            		alert("经度值小数位必须为6位!");
            		return ;
            	}
            	if (strlong*1<100 ||strlong.value*1>130 ) {
            		alert("经度值必须在100 － 130 之间!");
            		return ;
            	}
            }
              if(document.all("starlevel").value*1>=4){
              if(document.all("licenceno").value.length<=0)
              {
              alert('[营业执照编号]不能为空');
              return ;
              }
            }
            //way
            addfield('wayid', '<bean:message bundle="saleway" key="wayid"/>', 'c', false , 18);
            addfield('wayname', '<bean:message bundle="saleway" key="wayname"/>', 'c', false, 256);
            addfield('upperwayid', '<bean:message bundle="saleway" key="upperwayid"/>', 'c', false, 18);
            addfield('pt', '<bean:message bundle="saleway" key="pt"/>', 'i', false, 2);
            addfield('starlevel', '<bean:message bundle="saleway" key="starlevel"/>', 'i', false, 2);
            addfield('isstraitprd', '<bean:message bundle="saleway" key="isstraitprd"/>', 'i', false, 2);
            addfield('signstatus', '<bean:message bundle="saleway" key="signstatus"/>', 'i', false, 2);
            addfield('adtypecode', '<bean:message bundle="saleway" key="adtypecode"/>', 'i', false, 2);
            addfield('waystate', '<bean:message bundle="saleway" key="waystate"/>', 'i', false, 2);
            addfield('servbound', '<bean:message bundle="saleway" key="servbound"/>', 'i', false, 2);
			addfield('isb2m', '<bean:message bundle="saleway" key="isb2m"/>', 'i', false, 1);
			addfield('isunpb', '<bean:message bundle="saleway" key="isunpb"/>', 'i', false, 1);
			
            addfield('adacode', '<bean:message bundle="saleway" key="adacode"/>', 'c', true, 18);
            addfield('starttime', '<bean:message bundle="saleway" key="starttime"/>', 't', false);
            addfield('buzarea', '<bean:message bundle="saleway" key="buzarea"/>', 'i', false, 5 );
            addfield('mainlayer', '<bean:message bundle="saleway" key="mainlayer"/>', 'i', false, 2);
            addfield('formtype', '<bean:message bundle="saleway" key="formtype"/>', 'i', false, 2);
            addfield('waysubtype', '<bean:message bundle="saleway" key="waysubtype"/>', 'c', false, 4);
            addfield('bchlevel', '<bean:message bundle="saleway" key="bchlevel"/>', 'c', false, 4);
            addfield('logiscode', '<bean:message bundle="saleway" key="logiscode"/>', 'c', true, 18);
            addfield('waymagcode', '<bean:message bundle="saleway" key="waymagcode"/>', 'c', true, 18);
            addfield('alarmbizamount', '<bean:message bundle="saleway" key="alarmbizamount"/>', 'i', true, 10);
            //addfield('buzphoneno', '<bean:message bundle="saleway" key="buzphoneno"/>', 'i', false, 14);
            addfield('address', '<bean:message bundle="saleway" key="address"/>', 'c', false, 128);
            addfield('latitude', '<bean:message bundle="saleway" key="latitude"/>', 'd', false, 15, 6, null, 18, 26);
            addfield('longtitude', '<bean:message bundle="saleway" key="longtitude"/>', 'd', false, 15, 6, null, 100, 130);
            addfield('cityid', '<bean:message bundle="saleway" key="cityid"/>', 'c', false, '14');
            addfield('countyid', '<bean:message bundle="saleway" key="countyid"/>', 'c', false, '14');
            addfield('svccode', '<bean:message bundle="saleway" key="svccode"/>', 'c', true, '14');
            addfield('officetel', '<bean:message bundle="saleway" key="officetel"/>', 'c', false, '12');
            
            //contact    
            addfield('principal', '<bean:message bundle="saleway" key="principal"/>', 'c', false, 64);
            addfield('principaltel', '<bean:message bundle="saleway" key="principaltel"/>', 'c', false, 20);
            addfield('principalphone', '<bean:message bundle="saleway" key="principalphone"/>', 'c', true, 20);
            addfield('principalemail', '<bean:message bundle="saleway" key="principalemail"/>', 'm', true, 128);
            addfield('sendaddr', '<bean:message bundle="saleway" key="sendaddr"/>', 'c', true, 128);
            addfield('recpers', '<bean:message bundle="saleway" key="recpers"/>', 'c', true, 32);
            addfield('recconntel', '<bean:message bundle="saleway" key="recconntel"/>', 'c', true, 15);
            addfield('reccertno', '<bean:message bundle="saleway" key="reccertno"/>', 'c', true, 20);
            addfield('smsmobileno', '<bean:message bundle="saleway" key="smsmobileno"/>', 'i', true, 12);
            
            
            //compact
            addfield('compactno', '<bean:message bundle="saleway" key="compactno"/>', 'c', false, 17);
            addfield('compactname', '<bean:message bundle="saleway" key="compactname"/>', 'c', false, 255);
            addfield('begintime', '<bean:message bundle="saleway" key="begintime"/>', 't', false);
            addfield('cmpendtime', '<bean:message bundle="saleway" key="endtime"/>', 't', false);
            addfield('signtime', '<bean:message bundle="saleway" key="signtime"/>', 't', false);
            addfield('compacttype', '<bean:message bundle="saleway" key="compacttype"/>', 'i', false, 3);
            addfield('licenceno', '<bean:message bundle="saleway" key="licenceno"/>', 'c', true, 64);       
            addfield('bail', '<bean:message bundle="saleway" key="bail"/>', 'd', true, 18, 2);
            addfield('compactpath', '<bean:message bundle="saleway" key="compactpath"/>', 'c', true, 128);
            addfield('licencepath', '<bean:message bundle="saleway" key="licencepath"/>', 'c', true, 128);
            addfield('licvalidate', '<bean:message bundle="saleway" key="licvalidate"/>', 't', true);         
            addfield('baillwrlmt', '<bean:message bundle="saleway" key="baillwrlmt"/>', 'd', false, 18, 2);
            
            //account
            addfield('bankname', '<bean:message bundle="saleway" key="bankname"/>', 'c', false, 128);
            addfield('acctno', '<bean:message bundle="saleway" key="acctno"/>', 'c', false, 30);
            addfield('acctname', '<bean:message bundle="saleway" key="acctname"/>', 'c', false, 128);
            addfield('acctfid', '<bean:message bundle="saleway" key="acctfid"/>', 'c', false, 32);
            addfield('intime', '<bean:message bundle="saleway" key="intime"/>', 't', true);    
          
            return checkval(window);
        }
        
        function doCheckupper(obj){
        	showSelectWay(obj);
        	if(obj.value == null || obj.value == ""){
        		return;
        	}
        	enable();
        	formItem.action = contextPath + "/cms/saleway/saleway.do?CMD=CHECKUPPERWAY";
        	formItem.target = "_self";
        	formItem.submit();
        	formItem.action = contextPath + "/cms/saleway/saleway.do?CMD=SAVE";
        }
        
        function bodyOnload(){
        	if(window.loadforiframe){
        		loadforiframe();
        	}
        }
        
        function doReturnList(cmdReturn) {
    		formItem.action =contextPath + cmdReturn;
    		//formItem.target = "_parent";
    		formItem.submit();
		}
		
		function doUpdate(url){
			if(formItem.cmdState.value == 'NEW'){
				//formItem.target = "_parent";
			}
			doSave(url);
		}
    </script>
</head>
<body onload="bodyOnload()">
	<div class="table_container">
		<html:form action="/cms/saleway/saleway.do?CMD=SAVE"
			styleId="formItem" method="post" enctype="multipart/form-data">
			<html:hidden property="cmdState" />
			<%
			//查询页面的参数，有了这些就能在增加，编辑时返回编辑前的正确页面
			%>
			<html:hidden property="_orderby" />
			<html:hidden property="_desc" />
			<html:hidden property="_pageno" />
			<html:hidden property="_pagesize" />
			<html:hidden property="_se_cityid" />
			<html:hidden property="_se_countyid" />
			<html:hidden property="_se_svccode" />
			<html:hidden property="_se_mareacode" />
			<html:hidden property="_sk_wayid" />
			<html:hidden property="_sk_wayname" />
			<html:hidden property="_se_waysubtype" />
			<html:hidden property="_ne_starlevel" />
			<html:hidden property="_ne_mainlayer" />
			<html:hidden property="compactpath" />
			<html:hidden property="licencepath" />
			<html:hidden property="oldstate" />
			<html:hidden property="centerid" />
			<html:hidden property="waylevel" />
			<html:hidden property="sendFlag" />
			<html:hidden property="smsMsg" />
			<html:hidden property="oldValueStr" />
			<input type="hidden" name="printMsg"/>
			
			<c:set var="edtState" scope="request"
				value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW' or param.CMD eq 'CHECKUPPERWAY' or requestScope['cmdState'] eq 'EDIT' or requestScope['cmdState'] eq 'NEW')}" />
			<c:set var="item" scope="request"
				value="${requestScope['/cms/way/AGWayForm']}" />
		    <input type="hidden" value="<fmt:formatDate value='${item.createtime}' pattern='yyyy-MM-dd HH:mm:ss' />" name="createtime" />
			<c:set var="updateState" scope="request"
				value="${item.cmdState eq 'EDIT'}" />
			<div class="table_div">
				<table class="top_table">
					<tr>
						<td>
							<bean:message bundle="saleway" key="titleList" />
						</td>
					</tr>
				</table>
			</div>
			<div class="table_div">
				<table width="100%" class="error_text">
					<s:Msg />
				</table>
			</div>
			<div>
				<table class="form_table">
					<tr>
						<td align=left colspan="4">
							&nbsp;&nbsp;
							<bean:message bundle="public" key="msgRequired" />
						</td>
					</tr>
				</table>
			</div>
			<div class="table_div">
				<table class="form_table">
					<tr>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="wayid" />
								:
							</div>
						</td>
						<td nowrap width="25%" align="left" class="form_table_left">
							<c:choose>
								<c:when test="${edtState}">
									<c:if test="${updateState}">
										<html:text styleClass="form_input_1x" property="wayid"
											maxlength="18" readonly="true" />
									</c:if>
									<c:if test="${!updateState}">
										<html:text styleClass="form_input_1x" property="wayid"
											maxlength="18" />
										<font color=red> &nbsp;* </font>
									</c:if>
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="wayid"
										disabled="true" />
								</c:otherwise>
							</c:choose>
						</td>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="wayname" />
								:
							</div>
						</td>
						<td nowrap width="25%" align="left" class="form_table_left">
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="wayname"/>
									<font color=red> &nbsp;* </font>
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
								<bean:message bundle="saleway" key="starlevel" />
								:
							</div>
						</td>
						<td nowrap width="25%" align="left">
							<c:choose>
								<c:when test="${edtState}">
									<html:select property="starlevel">
										<option/>
										<s:Options definition="$CH_STARLEVEL"/>
									</html:select>
									<font color=red> &nbsp;* </font>
								</c:when>
								<c:otherwise>
									<html:select property="starlevel" disabled="true">
										<option/>
										<s:Options definition="$CH_STARLEVEL"/>
									</html:select>
								</c:otherwise>
							</c:choose>
						</td>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="pt" />
								:
							</div>
						</td>
						<td nowrap width="25%" align="left">
							<c:choose>
								<c:when test="${edtState}">
									<html:select property="pt">
										<option/>
										<s:Options definition="$CH_PT"/>
									</html:select>
									<font color=red> &nbsp;* </font>
								</c:when>
								<c:otherwise>
									<html:select property="pt" disabled="true">
										<option/>
										<s:Options definition="$CH_PT"/>
									</html:select>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="waymagcode" />
								:
							</div>
						</td>
						<td nowrap width="25%" align="left" class="form_table_left">
							<c:choose>
								<c:when test="${edtState}">
									<s:zoom   definition="#CH_EMPLOYEE" property="waymagcode"  styleClass="form_input_1x" readonly="false" nameOnly="false" condition="posittype:${1};empstatus:{0}"/>
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="waymagcode"
										disabled="true" />
								</c:otherwise>
							</c:choose>
						</td>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="isstraitprd" />
								:
							</div>
						</td>
						<td nowrap width="25%" align="left">
							<c:choose>
								<c:when test="${edtState}">
									<html:select property="isstraitprd">
										<option/>
										<s:Options definition="$CH_STRAITPRD" />
									</html:select>
									<font color=red> &nbsp;* </font>
								</c:when>
								<c:otherwise>
									<html:select property="isstraitprd" disabled="true">
										<option/>
										<s:Options definition="$CH_STRAITPRD" />
									</html:select>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="upperwayid" />
								:
							</div>
						</td>
						<td nowrap align=left>
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="upperwayid"
										maxlength="18" onclick="doCheckupper(this)" readonly="true" />
									<font color=red> &nbsp;* </font>
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="upperwayid"
										disabled="true" />
								</c:otherwise>
							</c:choose>
						</td>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="adacode" />
								:
							</div>
						</td>
						<td nowrap width="25%" align="left">
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="adacode"
										onclick="showAdaTree(this,'adacode');" readonly="true" />
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="adacode"
										disabled="true" />
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="catetype" />
								:
							</div>
						</td>
						<td nowrap width="25%" align="left" class="form_table_left">
							<c:choose>
								<c:when test="${edtState}">
									<html:select property="catetype">
										<option/>
										<s:Options definition="$CH_CATETYPE" />
									</html:select>
								</c:when>
								<c:otherwise>
									<html:select property="catetype" disabled="true">
										<option/>
										<s:Options definition="$CH_CATETYPE" />
									</html:select>
								</c:otherwise>
							</c:choose>
						</td>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="waysubtype" />
								:
							</div>
						</td>
						<td nowrap width="25%" align="left">
							<c:choose>
								<c:when test="${edtState}">
									<html:select property="waysubtype">
										<option/>
										<s:Options definition="#WAYTYPE"
											condition="waytypecode:${'SAGT'}" />
										<s:Options definition="#WAYTYPE"
											condition="waytypecode:${'PSAL'}" />
										<s:Options definition="#WAYTYPE"
											condition="waytypecode:${'FD'}" />	
									</html:select>
									<font color=red> &nbsp;* </font>
								</c:when>
								<c:otherwise>
									<html:select property="waysubtype" disabled="true">
										<option/>
										<s:Options definition="#WAYTYPE"
											condition="waytypecode:${'SAGT'}" />
										<s:Options definition="#WAYTYPE"
											condition="waytypecode:${'PSAL'}" />
									</html:select>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<td align="right" nowrap>
							<div class="field-require">
								<bean:message bundle="saleway" key="formtype" />
								:
							</div>
						</td>
						<td nowrap width="25%" align="left">
							<c:choose>
								<c:when test="${edtState}">
									<html:select property="formtype">
										<option/>
										<s:Options definition="$CH_FORMTYPE" />
									</html:select>
									<font color=red> &nbsp;* </font>
								</c:when>
								<c:otherwise>
									<html:select property="formtype" disabled="true">
										<option/>
										<s:Options definition="$CH_FORMTYPE" />
									</html:select>
								</c:otherwise>
							</c:choose>
						</td>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="starttime" />
								:
							</div>
						</td>
						<td nowrap width="25%" align="left">
							<c:choose>
								<c:when test="${edtState}">
									<input name="starttime" class="form_input_1x"
										value="<fmt:formatDate value="${item.starttime}" pattern="yyyy-MM-dd"/>"
										readonly onclick="this.value=selectDate();">
										<font color=red> &nbsp;* </font>
								</c:when>
								<c:otherwise>
									<input name="starttime" class="form_input_1x"
										value="<fmt:formatDate value="${item.starttime}" pattern="yyyy-MM-dd"/>"
										disabled>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="cityid" />
								:
							</div>
						</td>
						<td nowrap width="25%" align="left">
							<c:choose>
								<c:when test="${edtState}">
									<c:choose>
										<c:when test="${!empty item.cityid}">
											<html:text styleClass="form_input_1x" property="cityid" readonly="true"/>
									<font color=red> &nbsp;* </font>
										</c:when>
										<c:otherwise>
											<html:text styleClass="form_input_1x" property="cityid"/>
									<font color=red> &nbsp;* </font>
										</c:otherwise>
									</c:choose>
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="cityid" disabled="true"/>
								</c:otherwise>
							</c:choose>
						</td>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="countyid" />
								:
							</div>
						</td>
						<td nowrap width="25%" align="left">
							<c:choose>
								<c:when test="${edtState}">
									<c:choose>
										<c:when test="${!empty item.countyid}">
											<html:text styleClass="form_input_1x" property="countyid" readonly="true"/>
									<font color=red> &nbsp;* </font>
										</c:when>
										<c:otherwise>
											<html:text styleClass="form_input_1x" property="countyid"/>
									<font color=red> &nbsp;* </font>
										</c:otherwise>
									</c:choose>
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="countyid" disabled="true"/>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="svccode" />
								:
							</div>
						</td>
						<td nowrap width="25%" align="left">
							<c:choose>
								<c:when test="${edtState}">
									<c:choose>
										<c:when test="${!empty item.svccode}">
											<html:select property="svccode" disabled="true">
												<option/>										
												<s:Options definition="#CH_SERVCENT"
													condition="countyid:${item.countyid}" />
											</html:select>
										</c:when>
										<c:otherwise>
											<html:select property="svccode">
												<option/>
												<s:Options definition="#CH_SERVCENT"
													condition="countyid:${item.countyid}" />
											</html:select>
										</c:otherwise>
									</c:choose>
								</c:when>
								<c:otherwise>
									<html:select property="svccode" disabled="true">
										<option/>
										<s:Options definition="#CH_SERVCENT"
											condition="countyid:${item.countyid}" />
									</html:select>
								</c:otherwise>
							</c:choose>
						</td>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="mareacode" />
								:
							</div>
						</td>
						<td nowrap width="25%" align="left">

							<c:choose>
								<c:when test="${edtState}">
									<c:choose>
										<c:when test="${!empty item.mareacode}">
											<html:select property="mareacode" disabled="true">
												<option />
													<s:Options definition="#CH_MICROAREA"
														condition="svccode:${item.svccode}" />
											</html:select>
										</c:when>
										<c:otherwise>
												<html:select property="mareacode">
													<option />
														<s:Options definition="#CH_MICROAREA"
															condition="svccode:${item.svccode}" />
												</html:select>
										</c:otherwise>
									</c:choose>
								</c:when>
								<c:otherwise>
									<html:select property="mareacode" disabled="true">
										<option />
											<s:Options definition="#CH_MICROAREA"
												condition="svccode:${item.svccode}" />
									</html:select>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<td align="right" nowrap>
							<div class="field-require">
								<bean:message bundle="saleway" key="bchlevel" />
								:
							</div>
						</td>
						<td nowrap width="25%" align="left">
							<c:choose>
								<c:when test="${edtState}">
									<html:select property="bchlevel">
										<option/>
										<s:Options definition="$CH_BCHLEVEL" />
									</html:select><font color=red> &nbsp;* </font>
								</c:when>
								<c:otherwise>
									<html:select property="bchlevel" disabled="true">
										<option/>
										<s:Options definition="$CH_BCHLEVEL" />
									</html:select>
								</c:otherwise>
							</c:choose>
						</td>

						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="buzarea" />
								:
							</div>
						</td>
						<td nowrap width="25%" align="left">
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="buzarea" />
									<font color=red> &nbsp;* </font>
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="buzarea"
										disabled="true" />
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
						<td nowrap align="left">
							<c:choose>
								<c:when test="${edtState}">
									<c:if test="${updateState}">
										<html:select property="waystate">
											<s:Options definition="$CH_VALIDFLAG" />
										</html:select>
										<font color=red> &nbsp;* </font>
									</c:if>
									<c:if test="${!updateState}">
										<html:select property="waystate" value="1">
											<s:Options definition="$CH_VALIDFLAG" />
										</html:select>
									</c:if>
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
								<bean:message bundle="saleway" key="logiscode" />
								:
							</div>
						</td>
						<td nowrap width="25%" align="left">
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="logiscode" />
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="logiscode"
										disabled="true" />
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="alarmbizamount" />
								:
							</div>
						</td>
						<td nowrap align="left">
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="alarmbizamount" />
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="alarmbizamount"
										disabled="true" />
								</c:otherwise>
							</c:choose>
						</td>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="officetel" />
								:
							</div>
						</td>
						<td nowrap align="left">
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="officetel" />
									<font color=red> &nbsp;* </font>
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="officetel"
										disabled="true" />
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="address" />
								:
							</div>
						</td>
						<td nowrap align="left">
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="address" />
									<font color=red> &nbsp;* </font>
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="address"
										disabled="true" />
								</c:otherwise>
							</c:choose>
						</td>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="latitude" />
								:
							</div>
						</td>
						<td nowrap align="left">
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="latitude" />
									<font color=red> &nbsp;* </font>
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="latitude"
										disabled="true" />
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="longtitude" />
								:
							</div>
						</td>
						<td nowrap align="left">
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="longtitude" />
									<font color=red> &nbsp;* </font>
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="longtitude"
										disabled="true" />
								</c:otherwise>
							</c:choose>
						</td>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="adtypecode" />
								:
							</div>
						</td>
						<td nowrap width="25%" align="left" class="form_table_left">
							<c:choose>
								<c:when test="${edtState}">
									<html:select property="adtypecode">
										<option/>
										<s:Options definition="$CH_ADTYPE" />
									</html:select>
									<font color=red> &nbsp;* </font>
								</c:when>
								<c:otherwise>
									<html:select property="adtypecode" disabled="true">
										<option/>
										<s:Options definition="$CH_ADTYPE" />
									</html:select>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="signstatus" />
								:
							</div>
						</td>
						<td nowrap align="left">
							<c:choose>
								<c:when test="${edtState}">
									<html:select property="signstatus">
										<option/>
										<s:Options definition="$CH_SIGNSTATUS" />
									</html:select>
									<font color=red> &nbsp;* </font>
								</c:when>
								<c:otherwise>
									<html:select property="signstatus" disabled="true">
										<option/>
										<s:Options definition="$CH_SIGNSTATUS" />
									</html:select>
								</c:otherwise>
							</c:choose>
						</td>
						<td align="right">
							<bean:message bundle="saleway" key="provcode" />
								:
						</td>
						<td nowrap align="left">
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="provcode" />
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="provcode"
										disabled="true" />
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						
						<td align="right">
							<bean:message bundle="saleway" key="chainhead" />
								:
						</td>
					<%--<td colspan="3">
						<c:choose>
							<c:when test="${edtState}">
								<s:WayPicker property="chainhead" waytype="AG" waysubtype='DIS'/>	
							</c:when>
							<c:otherwise>
								<html:text styleClass="form_input_1x" property="chainhead"
									disabled="true" />
							</c:otherwise>
						</c:choose>
					</td>
				    --%><td>
								<div>
									<c:choose>
										<c:when
											test="${edtState}">
											<s:zoom definition="#WAY" property="chainhead"
												styleClass="form_input_1x" readonly="true" nameOnly="true"
												condition="waytype:AG;waysubtype:DIS;waystate:1" />
										</c:when>
										<c:otherwise>
											<html:text styleClass="form_input_1x" property="chainhead"
												readonly="true" />
										</c:otherwise>
									</c:choose>
								</div>
						</td>
						<td align="right">
							<bean:message bundle="saleway" key="istietong" />
								:
						</td>
						<td nowrap align="left">
							<c:choose>
								<c:when test="${edtState}">
									<c:if test="${updateState}">
									<html:select property="istietong">
										<html:option value=""></html:option>
										<html:option value="0">普通网点</html:option>
										<html:option value="1">原铁通网点</html:option>
										<html:option value="2">G3社会信息服务站</html:option>
									</html:select>
									</c:if>
									<c:if test="${!updateState}">
										<html:select property="istietong" value="0">
										<html:option value=""></html:option>
										<html:option value="0">普通网点</html:option>
										<html:option value="1">原铁通网点</html:option>
										<html:option value="2">G3社会信息服务站</html:option>
									</html:select>
									</c:if>
								</c:when>
								<c:otherwise>
									<html:select property="istietong" disabled="true">
										<option/>
										<s:Options definition="$CH_SPECWAYFLAG" />
									</html:select>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="buztypecode" />
								:
							</div>
						</td>
						<td nowrap align="left">
							<c:choose>
								<c:when test="${edtState}">
									<html:select property="buztypecode">
										<option/>
										<s:Options definition="$CH_BUZTYPE" />
									</html:select>
								</c:when>
								<c:otherwise>
									<html:select property="buztypecode" disabled="true">
										<option/>
										<s:Options definition="$CH_BUZTYPE" />
									</html:select>
								</c:otherwise>
							</c:choose>
						</td>
						<td align="right">
							<bean:message bundle="saleway" key="connecttype" />
								:
						</td>
						<td nowrap align="left">
							<c:choose>
								<c:when test="${edtState}">
									<html:select property="connecttype">
										<option/>
										<s:Options definition="$CH_CONNECTTYPE" />
									</html:select>
								</c:when>
								<c:otherwise>
									<html:select property="connecttype" disabled="true">
										<option/>
										<s:Options definition="$CH_CONNECTTYPE" />
									</html:select>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="secondsup" />
								:
							</div>
						</td>
						<td nowrap align="left">
							<c:choose>
								<c:when test="${edtState}">
									<html:select property="sublayer">
										<option/>
										<s:Options definition="$CH_CONNECTTYPE" />
									</html:select>
								</c:when>
								<c:otherwise>
									<html:select property="sublayer" disabled="true">
										<option/>
										<s:Options definition="$CH_CONNECTTYPE" />
									</html:select>
								</c:otherwise>
							</c:choose>
						</td>
						<td align="right">
							&nbsp;
						</td>
						<td nowrap align="left">
							&nbsp;
						</td>
					</tr>
					<tr>
						<td align="left" colspan="4">
							<font color="blue" ><bean:message bundle="Way" key="exp" /></font>
							
						</td>
					</tr>
					<tr>
						<td align="left" colspan="4">
							<font color="blue" >全省代码只用于国美、苏宁等省市级连锁合作商家下的网点，其它的网点不需要填写全省代码。</font>
						</td>
					</tr>
					<tr>
						<td align="right">
							&nbsp;
						</td>
						<td align="left" width="25%">
							&nbsp;
						</td>
						<td align="right">
							&nbsp;
						</td>
						<td align="left" width="25%">
							&nbsp;
						</td>
					</tr>
					<!-- contact start -->
					<tr>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="principal" />
								:
							</div>
						</td>
						<td nowrap width="25%" align="left" class="form_table_left">
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="principal"
										maxlength="24" />
									<font color=red> &nbsp;* </font>
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="principal"
										disabled="true" />
								</c:otherwise>
							</c:choose>
						</td>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="principaltel" />
								:
							</div>
						</td>
						<td nowrap width="25%" align="left" class="form_table_left">
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="principaltel"
										maxlength="24" />
									<font color=red> &nbsp;* </font>
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="principaltel"
										disabled="true" />
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="principalphone" />
								:
							</div>
						</td>
						<td width="25%" align="left" class="form_table_left">
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="principalphone" />
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="principalphone"
										disabled="true" />
								</c:otherwise>
							</c:choose>
						</td>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="principalemail" />
								:
							</div>
						</td>
						<td width="25%" align="left">
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="principalemail" />
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="principalemail"
										disabled="true" />
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="smsmobileno" />
								:
							</div>
						</td>
						<td width="25%" align="left" class="form_table_left">
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="smsmobileno" />
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="smsmobileno"
										disabled="true" />
								</c:otherwise>
							</c:choose>
						</td>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="recpers" />
								:
							</div>
						</td>
						<td width="25%" align="left">
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="recpers" />
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="recpers"
										disabled="true" />
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="recconntel" />
								:
							</div>
						</td>
						<td width="25%" align="left" class="form_table_left">
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="recconntel" />
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="recconntel"
										disabled="true" />
								</c:otherwise>
							</c:choose>
						</td>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="reccertno" />
								:
							</div>
						</td>
						<td width="25%" align="left">
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="reccertno" />
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="reccertno"
										disabled="true" />
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="bailtype" />
								:
							</div>
						</td>
						<td width="25%" align="left" class="form_table_left">
							<c:choose>
								<c:when test="${edtState}">
									<html:select property="bailtype">
										<option/>
										<s:Options definition="$CH_BAILTYPE"></s:Options>
									</html:select>
								</c:when>
								<c:otherwise>
									<html:select property="bailtype" disabled="true">
										<option/>
										<s:Options definition="$CH_BAILTYPE"></s:Options>
									</html:select>
								</c:otherwise>
							</c:choose>
						</td>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="servbound" />
								:
							</div>
						</td>
						<td width="25%" align="left">
							<c:choose>
								<c:when test="${edtState}">
									<html:select property="servbound">
										<option/>
										<s:Options definition="$CH_SERVBOUND"></s:Options>
									</html:select><font color=red> &nbsp;* </font>
								</c:when>
								<c:otherwise>
									<html:select property="servbound" disabled="true">
										<option/>
										<s:Options definition="$CH_SERVBOUND"></s:Options>
									</html:select>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="sendaddr" />
								:
							</div>
						</td>
						<td width="75%" align="left" class="form_table_left" colspan="3">
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_2x" property="sendaddr" />
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_2x" property="sendaddr"
										disabled="true" />
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<!-- contact end -->
					<tr>
						<td align="right">
							&nbsp;
						</td>
						<td align="left" width="25%">
							&nbsp;
						</td>
						<td align="right">
							&nbsp;
						</td>
						<td align="left" width="25%">
							&nbsp;
						</td>
					</tr>
					<!-- conpact start -->
					<tr>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="compactno" />
								:
							</div>
						</td>
						<td nowrap width="25%" align="left" class="form_table_left">
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="compactno"
										maxlength="24" />
									<font color=red> &nbsp;* </font>
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="compactno"
										disabled="true" />
								</c:otherwise>
							</c:choose>
						</td>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="compactname" />
								:
							</div>
						</td>
						<td nowrap width="25%" align="left" class="form_table_left">
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="compactname"
										maxlength="24" />
									<font color=red> &nbsp;* </font>
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="compactname"
										disabled="true" />
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="begintime" />
								:
							</div>
						</td>
						<td nowrap width="25%" align="left" class="form_table_left">
							<c:choose>
								<c:when test="${edtState}">
									<input class="form_input_1x" name="begintime"
										value="<fmt:formatDate value="${item.begintime}" pattern="yyyy-MM-dd"/>"
										readonly onclick="this.value=selectDate();">
									<font color=red> &nbsp;* </font>
								</c:when>
								<c:otherwise>
									<input class="form_input_1x" name="begintime"
										value="<fmt:formatDate value="${item.begintime}" pattern="yyyy-MM-dd"/>"
										disabled>
								</c:otherwise>
							</c:choose>
						</td>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="endtime" />
								:
							</div>
						</td>
						<td nowrap width="25%" align="left">
							<c:choose>
								<c:when test="${edtState}">
									<input class="form_input_1x" name="cmpendtime"
										value="<fmt:formatDate value="${item.cmpendtime}" pattern="yyyy-MM-dd"/>"
										readonly onclick="this.value=selectDate();">
									<font color=red> &nbsp;* </font>
								</c:when>
								<c:otherwise>
									<input class="form_input_1x" name="cmpendtime"
										value="<fmt:formatDate value="${item.cmpendtime}" pattern="yyyy-MM-dd"/>"
										disabled>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="signtime" />
								:
							</div>
						</td>
						<td nowrap width="25%" align="left">
							<c:choose>
								<c:when test="${edtState}">
									<input class="form_input_1x" name="signtime"
										value="<fmt:formatDate value="${item.signtime}" pattern="yyyy-MM-dd"/>"
										readonly onclick="this.value=selectDate();">
									<font color=red> &nbsp;* </font>
								</c:when>
								<c:otherwise>
									<input class="form_input_1x" name="signtime"
										value="<fmt:formatDate value="${item.signtime}" pattern="yyyy-MM-dd"/>"
										disabled>
								</c:otherwise>
							</c:choose>
						</td>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="compacttype" />
								:
							</div>
						</td>
						<td nowrap width="25%" align="left">
							<c:choose>
								<c:when test="${edtState}">
									<html:select property="compacttype">
										<option/>
										<s:Options definition="$CH_COMPACTTYPE"></s:Options>
									</html:select>
									<font color=red> &nbsp;* </font>
								</c:when>
								<c:otherwise>
									<html:select property="compacttype" disabled="true">
										<option/>
										<s:Options definition="$CH_COMPACTTYPE"></s:Options>
									</html:select>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="licenceno" />
								:
							</div>
						</td>
						<td nowrap width="25%" align="left">
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="licenceno" />
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="licenceno"
										disabled="true" />
								</c:otherwise>
							</c:choose>
						</td>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="bail" />
								:
							</div>
						</td>
						<td width="25%" align="left">
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="bail" />
									<font color=red></font>
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="bail"
										disabled="true" />
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="baillwrlmt" />
								:
							</div>
						</td>
						<td width="25%" align="left">
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="baillwrlmt" />
									<font color=red>&nbsp;*</font>
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="baillwrlmt"
										disabled="true" />
								</c:otherwise>
							</c:choose>
						</td>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="licvalidate" />
								:
							</div>
						</td>
						<td nowrap width="25%" align="left">
							<c:choose>
								<c:when test="${edtState}">
									<input class="form_input_1x" name="licvalidate"
										value="<fmt:formatDate value="${item.licvalidate}" pattern="yyyy-MM-dd"/>"
										readonly onclick="this.value=selectDate();">
								</c:when>
								<c:otherwise>
									<input class="form_input_1x" name="licvalidate"
										value="<fmt:formatDate value="${item.licvalidate}" pattern="yyyy-MM-dd"/>"
										disabled>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="bailstatus" />
								:
							</div>
						</td>
						<td width="25%" align="left">
							<c:choose>
								<c:when test="${edtState}">
									<html:select property="bailstatus">
										<option/>
										<s:Options definition="$CH_BAILSTATUS"></s:Options>
									</html:select>
								</c:when>
								<c:otherwise>
									<html:select property="bailstatus" disabled="true">
										<option/>
										<s:Options definition="$CH_BAILSTATUS"></s:Options>
									</html:select>
								</c:otherwise>
							</c:choose>
						</td>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="isb2m" />
								:
							</div>
						</td>
						<td width="25%" align="left">
							<c:choose>
								<c:when test="${edtState}">
									<html:select property="isb2m">
										<s:Options definition="#CH_ISDELAY"></s:Options>
									</html:select>
									<font color=red> &nbsp;* </font>
								</c:when>
								<c:otherwise>
									<html:select property="isb2m" disabled="true">
										<s:Options definition="#CH_ISDELAY"></s:Options>
									</html:select>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="isunpb" />
								:
							</div>
						</td>
						<td width="25%" align="left">
							<c:choose>
								<c:when test="${edtState}">
									<html:select property="isunpb">
										<s:Options definition="#CH_ISDELAY"></s:Options>
									</html:select>
									<font color=red> &nbsp;* </font>
								</c:when>
								<c:otherwise>
									<html:select property="isunpb" disabled="true">
										<s:Options definition="#CH_ISDELAY"></s:Options>
									</html:select>
								</c:otherwise>
							</c:choose>
						</td>
						<td align="right">
						</td>
						<td width="25%" align="left">
						</td>
					</tr>
					<tr>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="compactpath" />
								:
							</div>
						</td>
						<td nowrap align="left" colspan="3">
							<c:choose>
								<c:when test="${edtState}">
									<!--<html:file styleClass="form_input_files" property="compactfile" />-->
									<input class="form_input_2x" type="file" name="compactfile">
									<c:if test="${!empty item.compactpath}">
										<br />
										<a
											href='<%=contextPath%>/cms/saleway/saleway.do?CMD=DOWNLOAD&file=<c:out value="${item.compactpath}"/>'
											target="_blank"> <c:out value="${item.compactpath}" /> </a>
									</c:if>
								</c:when>
								<c:otherwise>
									<c:if test="${!empty item.compactpath}">
										<a
											href='<%=contextPath%>/cms/saleway/saleway.do?CMD=DOWNLOAD&file=<c:out value="${item.compactpath}"/>'
											target="_blank"> <c:out value="${item.compactpath}" /> </a>
									</c:if>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="licencepath" />
								:
							</div>
						</td>
						<td nowrap align="left" colspan="3">
							<c:choose>
								<c:when test="${edtState}">
									<!--<html:file styleClass="form_input_files" property="licencefile" />-->
									<input class="form_input_2x" type="file" name="licencefile">
									<c:if test="${!empty item.licencepath}">
										<br />
										<a
											href='<%=contextPath%>/cms/saleway/saleway.do?CMD=DOWNLOAD&file=<c:out value="${item.licencepath}"/>'
											target="_blank"> <c:out value="${item.licencepath}" /> </a>
									</c:if>
								</c:when>
								<c:otherwise>
									<c:if test="${!empty item.licencepath}">
										<a
											href='<%=contextPath%>/cms/saleway/saleway.do?CMD=DOWNLOAD&file=<c:out value="${item.licencepath}"/>'
											target="_blank"> <c:out value="${item.licencepath}" /> </a>
									</c:if>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<!-- conpact end -->
					<tr>
						<td align="right">
							&nbsp;
						</td>
						<td align="left" width="25%">
							&nbsp;
						</td>
						<td align="right">
							&nbsp;
						</td>
						<td align="left" width="25%">
							&nbsp;
						</td>
					</tr>
					<!-- account start -->
					<tr>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="acctno" />
								:
							</div>
						</td>
						<td nowrap width="25%" align="left">
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="acctno" />
									<font color=red> &nbsp;* </font>
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="acctno"
										disabled="true" />
								</c:otherwise>
							</c:choose>
						</td>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="acctname" />
								:
							</div>
						</td>
						<td nowrap width="25%" align="left">
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="acctname" />
									<font color=red> &nbsp;* </font>
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="acctname"
										disabled="true" />
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="bankname" />
								:
							</div>
						</td>
						<td nowrap width="25%" align="left">
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="bankname" />
									<font color=red> &nbsp;* </font>
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="bankname"
										disabled="true" />
								</c:otherwise>
							</c:choose>
						</td>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="acctfid" />
								:
							</div>
						</td>
						<td nowrap width="25%" align="left">
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="acctfid" />
									<font color=red> &nbsp;* </font>
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="acctfid"
										disabled="true" />
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					
					<tr>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="deacctno" />
								:
							</div>
						</td>
						<td nowrap width="25%" align="left">
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="deacctno" />
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="deacctno"
										disabled="true" />
								</c:otherwise>
							</c:choose>
						</td>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="deacctname" />
								:
							</div>
						</td>
						<td nowrap width="25%" align="left">
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="deacctname" />
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="deacctname"
										disabled="true" />
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="debankname" />
								:
							</div>
						</td>
						<td nowrap width="25%" align="left">
							<c:choose>
								<c:when test="${edtState}">
									<html:text styleClass="form_input_1x" property="debankname" />
								</c:when>
								<c:otherwise>
									<html:text styleClass="form_input_1x" property="debankname"
										disabled="true" />
								</c:otherwise>
							</c:choose>
						</td>
							<td align="right">
							<div class="field-require">
								<bean:message bundle="saleway" key="intime" />
								:
							</div>
						</td>
						<td nowrap width="25%" align="left">
							<c:choose>
								<c:when test="${edtState}">
									<input class="form_input_1x" name="intime"
										value="<fmt:formatDate value="${item.intime}" pattern="yyyy-MM-dd"/>"
										readonly onclick="this.value=selectDate();">
								</c:when>
								<c:otherwise>
									<input class="form_input_1x" name="intime"
										value="<fmt:formatDate value="${item.intime}" pattern="yyyy-MM-dd"/>"
										disabled>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<!-- account end -->
				</table>

			</div>
			<div class="table_div">
				<table class="table_button_list">
					<tr>
						<td>
							<s:PurChk2 controlid="<%=ID_1%>" disableChild="true">
								<input type="button" onmouseover="buttonover(this);"
									onmouseout="buttonout(this);" name="btnSave"
									onfocus="buttonover(this)" onblur="buttonout(this)"
									value="<bean:message bundle="public" key="button_save"/>"
									class="submit"
									onclick="doSave('/cms/saleway/saleway.do?CMD=SAVE')" />
							</s:PurChk2>
							<input type="button" onmouseover="buttonover(this);"
								onmouseout="buttonout(this);" name="btnReturn"
								onfocus="buttonover(this)" onblur="buttonout(this)"
								value="<bean:message bundle="public" key="button_return"/>"
								class="close"
								onclick="doReturnList('/cms/saleway/saleway.do?CMD=LIST')">
						</td>
					</tr>
				</table>
			</div>
		</html:form>
	</div>
</body>
<script language="JavaScript">
		var preObj,newObj,msgObj;
		var preMsg = "";
		var newMsg = "";
		var oldValueStr = "";
		var submitFlag = false;
		var submitImedia = true;
		function initObject(type){
			var obj;
			if (type == 0){
				preObj = new Object();
				msgObj = new Object();
				obj = 'preObj.';
			}else {
				newObj = new Object();
				obj = 'newObj.';
			}
			var elements = document.formItem.elements;
			for (var i=0; i<elements.length; i++){
				if (elements[i].type){
					if (elements[i].type == "text" || elements[i].nodeName.toUpperCase() == "SELECT"){
						var elementName = elements[i].name;
						var excutStr = obj + elementName + "=document.all('" + elementName + "').value";
						eval(excutStr);
						if (type == 0){
							oldValueStr += elementName + "=" + elements[i].value;
							if (optionProperties.indexOf(elementName) != -1){
								if (document.all(elementName).options){
									oldValueStr += "=" + document.all(elementName).options[document.all(elementName).selectedIndex].text;
									excutStr = "msgObj." + elementName + "=document.all('" + elementName + "').options[document.all('" + elementName + "').selectedIndex].text";
								}else {
									excutStr = "msgObj." + elementName + "=''";
									oldValueStr += "=" + '';
								}
								eval(excutStr);
							}
							oldValueStr += ";";
						}
						
					}			
				}
			}
			//alert(oldValueStr);
			if (type == 0){
				document.formItem.oldValueStr.value = oldValueStr;
			}
		}
		
		function formIsChange(){
			var name = "";
			var ret = false;
			preMsg = "";
			newMsg = "";
			for (name in newObj){
				if (newObj[name] != preObj[name]){
					var preValue,newValue;
					if (optionProperties.indexOf("'"+name+"'") != -1){
						preValue = msgObj[name];
						var selectElem = document.all(name);
						if (selectElem.options){
							newValue = selectElem.options[selectElem.selectedIndex].text;
						}
					}else {
						preValue = preObj[name];
						newValue = newObj[name];
					}
					
					if (preValue == undefined){
						preValue = "";
					}
					if (newValue == undefined){
						newValue = "";
					}
					preMsg += nameObj[name] + ":" + preValue + ";";
					newMsg += nameObj[name] + ":" + newValue + ";";
					ret = true;
				}
			}
			return ret;
		}
		
		function doSave(cmdSave) {
		    if (ev_checkval()) {
		        enable();
		        <c:if test="${updateState}">
					initObject(1);
					if (formIsChange()){
						//document.formItem.oldValueStr.value = oldValueStr;
						var url = contextPath + "/cms/saleway/confirm.jsp";
		        		var retValue = window.showModalDialog(url,"","dialogWidth:300px; dialogHeight:100px; status:no;resizable:yes;");
		        		if (retValue != ""){
		        			retValue = retValue.split("|");
		        			if (retValue.length && retValue.length > 1){
		        				if (retValue[0] == "1"){
		        					//alert('print');
		        					//alert("preMsg::" + preMsg);
		        					//alert("newMsg::" + newMsg);
		        					submitImedia = false;
		        					document.formItem.printMsg.value = preMsg + "|" + newMsg + "|" + preObj['wayid'] + "|" + preObj['wayname'];
		        					window.open( contextPath + "/cms/saleway/print.jsp",null,"width=600px; height=390px; scroll=yes;status=no;resizable=yes;");
		        				}
		        				if (retValue[1] =="1"){
		        					document.formItem.sendFlag.value = 1;
		        					document.formItem.smsMsg.value = " " + newMsg.slice(0,-1) + "。";
		        					//alert("sendMsg:" + document.formItem.smsMsg.value);
		        				}
		        			}
		        		}
		        	}
				</c:if>
		        formItem.action = contextPath + cmdSave;
		        if (submitImedia){
		        	formItem.submit();
		        }else {
			        //当需要打印时，由于打印窗口需要获得该窗口的相关值，不能马上提交刷新窗口，需要等待打印窗口更改submiFlag为true后，再提交
			        runID = window.setInterval('commit()',2000);
		        }
		    }
		    return false;
		}
		
		function commit(){
			if (submitFlag){
        		formItem.submit();
        		submitFlag = false;
        		runID = null;
        	}
		}
		var nameObj ={
			'catetype':'连锁性质',
			'mareacode':'微区域',
			'provcode':'全省代码',
			'chainhead':'合作商编码',
			'bailtype':'保证金交付形式',
			'bailstatus':'保证金押金状态',
			'deacctno':'卡类购销划扣银行账号',
			'deacctname':'卡类购销划扣帐号名称',
			'debankname':'卡类购销划扣开户银行',
			'wayid': '渠道编码',                                                  
			'wayname': '渠道名称',
			'upperwayid': '上级渠道',
			'pt': '排他性',
			'starlevel': '星级',
			'isstraitprd': '是否直供',
			'signstatus': '签约状态',
			'adtypecode': '区域类型',
			'waystate': '状态',
			'servbound': '经营范围',
			'adacode': '行政区划',
			'starttime': '合作开始时间',
			'buzarea': '营业面积',
			'formtype': '业态类型',
			'waysubtype': '零售渠道类别',
			'bchlevel': '分级',
			'logiscode': '所属物流商',
			'waymagcode': '所属渠道经理人员ID',
			'waymagcode_zoom': '所属渠道经理人员ID',
			'alarmbizamount': '业务预警量',
			'address': '详细地址',
			'latitude': '地理纬度',
			'longtitude': '地理经度',
			'cityid': '地市公司',
			'countyid': '分公司',
			'svccode': '服务销售中心',
			'officetel': '采集平台捆绑手机号',
			'principal': '业主姓名',
			'principaltel': '业主电话',
			'principalphone': '业主固定电话',
			'principalemail': '业主电子信箱',
			'sendaddr': '送货地址',
			'recpers': '收货联系人',
			'recconntel': '收货联系号码',
			'reccertno': '收货人证件号码',
			'smsmobileno': '短信通知号码',
			'compactno': '合同编码',
			'compactname': '合同协议名称',
			'begintime': '生效时间',
			'cmpendtime': '合同到期日',
			'signtime': '签署合同时间',
			'compacttype': '签约类型',
			'licenceno': '营业执照编号',    
			'bail': '保证金金额',
			'compactpath': '合同文本',
			'licencepath': '营业执照文件',
			'licvalidate': '营业执照有效期',   
			'baillwrlmt': '保证金下限>',
			'bankname': '酬金支付开户银行',
			'acctno': '酬金支付银行账号',
			'acctname': '酬金支付帐号名称',
			'acctfid': '开户人身份证号码',
			'intime': '开户日期',
			'isb2m': '是否加入B2M模式',
			'mainlayer': '合作层级'
		};
		
		var optionProperties = "'starlevel','pt','isstraitprd','waysubtype','catetype','formtype','svccode','mareacode','bchlevel','waystate','adtypecode','signstatus','bailtype','servbound','compacttype','bailstatus','isb2m'";
		//var zoomProperties = "'waymagcode'";
		<c:if test="${updateState}">
			oldValueStr = document.formItem.oldValueStr.value;
			if (!oldValueStr || oldValueStr=='null'){
				oldValueStr = "";
			}
			if (oldValueStr != ""){
				if (oldValueStr.charAt(oldValueStr.length-1) == ';'){
					oldValueStr = oldValueStr.slice(0,-1);
				}
				var oldValueStrArr = oldValueStr.split(";");
				//alert(oldValueStr);
				preObj = new Object();
				msgObj = new Object();
				for (var nameValue in oldValueStrArr){
					nameValue = oldValueStrArr[nameValue].split("=");
					if (nameValue.length && nameValue.length >1){
						eval("preObj." + nameValue[0] + "='" + nameValue[1] + "'");
						if (nameValue.length > 2){
							eval("msgObj." + nameValue[0] + "='" + nameValue[2] + "'");
						}
					}else {
						eval("preObj." + nameValue + "=''");
					}
				}
				//showObj(msgObj);
				
			}else {
				initObject(0);
			}
			//alert(oldValueStr);
		</c:if>
		
		function showObj(obj){
			var str="";
			for (var name in obj){
				str += name + ":" + obj[name] + ";";
			}
			alert(str);
		}
    </script>
</html:html>
