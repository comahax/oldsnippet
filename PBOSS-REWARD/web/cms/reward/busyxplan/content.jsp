<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%
	String ID_1 = "CH_PW_REWARD||CH_PW_REWARD_PROVINCIAL";
	String ID_2 = "CH_PW_REWARD||CH_PW_REWARD_CIVIC";
%>
<html>
	<head>
		<title><bean:message bundle="busyxplan" key="titleUpdate" />
		</title>
		<script type="text/javascript"
			src="<%=contextPath%>/js/bus/waycommon.js"></script>
		<script language="JavaScript">
        function ev_checkval() {
            addfield('opnid', '<bean:message bundle="busyxplan" key="opnid"/>', 'c', false, '18');
            addfield('yxplanid', '<bean:message bundle="busyxplan" key="yxplanid"/>', 'i', true, '14');
            addfield('wrapfee', '<bean:message bundle="busyxplan" key="wrapfee"/>', 'd', false, '10','2');
            if(document.all("planbusitype").value=='WLAN')
			{
			addfield('wayid', '<bean:message bundle="Way" key="wayid"/>', 'c', false, '20');
			}
			else
			{
			addfield('wayid', '<bean:message bundle="Way" key="wayid"/>', 'c', true, '20');
			}
            addfield('cityid', '<bean:message bundle="busyxplan" key="cityid"/>', 'c', true, '4');
            addfield('noncyc', '<bean:message bundle="busyxplan" key="noncyc"/>', 'i', true, '2');
            var noncyc = document.getElementById('noncyc').value;
            if (null!=noncyc && ''!=noncyc) {
            if (noncyc > 12 || noncyc<1 ) {
              errorMessageShow('<font color=red><b>提示信息:</b></font>只允许填数字1-12,且最大期数为12'); 
              return false;
            }
            }
             var prodid = document.getElementById('prodid').value; 
             var yxplanid = document.getElementById('yxplanid').value;
              
            if ( (prodid==null || prodid=='') && (yxplanid==null || yxplanid=='') ){
            	
                errorMessageShow('<font color=red><b>提示信息:</b>营销方案标识和产品标识不能同时为空，请检查后重新保存</font>'); 
              return false;
            }
            
            return checkval(window);
        }
        function selectYxplan(){
			var arg = new Array();
			var strUrl ="<%=contextPath%>/cms/reward/busyxplan.do?CMD=SHOWYXPLANID";
			var returnValue= window.showModalDialog(strUrl,arg,"dialogWidth:600px; dialogHeight:390px; status:no;resizable:yes;");
			return returnValue;
		 }
		 function doChange(value)
		 {
		 	if('WLAN'==value)
		 	{
		 	  document.getElementById("showD").style.display=""; //显示
		 	}else
		 	{
		 	 document.getElementById("showD").style.display="none"; //隐藏
		 	}
		 }
    </script>
	</head>
	<body>
		<div class="table_container">
			<html:form action="/cms/reward/busyxplan.do?CMD=SAVE"
				styleId="formItem" method="post">
				<html:hidden property="cmdState" />

				<html:hidden property="_orderby" />
				<html:hidden property="_desc" />
				<html:hidden property="_pageno" />
				<html:hidden property="_pagesize" />
				<html:hidden property="_ne_yxplanid" />
				<html:hidden property="_se_cityid" />
				<html:hidden property="seq"/>
				<c:set var="edtState" scope="request"
					value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}" />
				<c:set var="updateState" scope="request"
					value="${!empty param.CMD and (param.CMD eq 'EDIT')}" />
				<s:RewardPurChk controlid="<%=ID_1%>">
					<c:set var="isPrivince" value="${'PRIV'}" />
				</s:RewardPurChk>
				<s:RewardPurChk controlid="<%=ID_2%>">
					<c:set var="isPrivince" value="${'CITY'}" />
				</s:RewardPurChk>
				<c:set var="idState" scope="request"
					value="${!empty param.FROM and param.FROM eq isPrivince} }" />
				<!--##################################添加标题内容##################################################-->
				<div class="table_div">
					<table class="top_table">
						<tr>
							<td>
								<bean:message bundle="busyxplan" key="titleList" />
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
					<table class="form_table">
					   		 
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="busyxplan" key="opnid" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<c:if test="${updateState}">
											<html:text styleClass="form_input_1x" property="opnid"
												maxlength="18"  disabled="true"/>
											<font color=red>&nbsp;*</font>
										</c:if>
										<c:if test="${!updateState}">
											<html:text styleClass="form_input_1x" property="opnid"
												></html:text>
											<input type="button" value="..." class="clickButton"
												onclick="showOpnTree2(this, 'opnid','busi' )">
											<font color=red>&nbsp;*</font>
										</c:if>
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="opnid"
											disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="busyxplan" key="yxplanid" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<c:if test="${updateState}">
											<html:text styleClass="form_input_1x" property="yxplanid"
												maxlength="14" disabled="true"/> 
												<input type="button" value="..." class="clickbutton"
												onclick="yxplanid.value=selectYxplan()">
											 
										</c:if>
										<c:if test="${!updateState}">
											<html:text styleClass="form_input_1x" property="yxplanid"
												maxlength="14"  />
											<input type="button" value="..." class="clickbutton"
												onclick="yxplanid.value=selectYxplan()">
											 
										</c:if>
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="yxplanid" disabled="true"
											 />
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
						<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="busyxplan" key="prodid" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<c:if test="${updateState}">
											<html:text styleClass="form_input_1x" property="prodid"
												maxlength="14" disabled="true"/> 
										</c:if>
										<c:if test="${!updateState}">
											<html:text styleClass="form_input_1x" property="prodid"
												maxlength="14"  /> 
											 
										</c:if>
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="prodid"
											disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="busyxplan" key="wrapfee" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<c:if test="${updateState}">
											<html:text styleClass="form_input_1x" property="wrapfee"
												maxlength="12" />
											<font color=red>&nbsp;*</font>
										</c:if>
										<c:if test="${!updateState}">
											<html:text styleClass="form_input_1x" property="wrapfee"
												maxlength="12" />
											<font color=red>&nbsp;*</font>
										</c:if>
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="wrapfee"
											disabled="true" />
									</c:otherwise>
								</c:choose>
							</td>
						</tr>

						<tr>

							<td width="20%" align="right" class="form_table_right">
								<bean:message bundle="Way" key="wayid" />
								:
							</td>
							<td width="75%" align="left" class="form_table_left">


								<c:choose>
									<c:when test="${edtState}">
										<c:if test="${updateState}">
											<%
														if (request.getAttribute("planbusitype").equals(
														"WLAN")) {
											%>
											<div id="showD" style="{display:""}">
												<html:text styleClass="form_input_1x" property="wayid"
													onclick="showSelectWay3(document.all('wayid'),'wayid',false,true,'AG','');" />
												<font color=red>&nbsp;*</font>
											</div>
											<%
											} else {
											%>
											<div id="showD" style="display:none">
												<html:text styleClass="form_input_1x" property="wayid"
													onclick="showSelectWay3(document.all('wayid'),'wayid',false,true,'AG','');" />
												<font color=red>&nbsp;*</font>
											</div>
											<%
											}
											%>
										</c:if>
										<c:if test="${!updateState}">
											<div id="showD" style="display:none">
												<html:text styleClass="form_input_1x" property="wayid"
													onclick="showSelectWay3(document.all('wayid'),'wayid',false,true,'AG','');" />
												<font color=red>&nbsp;*</font>
											</div>
										</c:if>
									</c:when>
									<c:otherwise>
										<%
										if (request.getAttribute("planbusitype").equals("WLAN")) {
										%>
										<html:text styleClass="form_input_1x" property="wayid"
											disabled="true" />
										<%
										}
										%>

									</c:otherwise>
								</c:choose>

							</td>
						</tr>


						<tr>
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="busyxplan" key="planbusitype" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left">
								<c:choose>
									<c:when test="${edtState}">
										<c:if test="${updateState}">
											<html:select property="planbusitype"
												onchange="doChange(this.value)">
												<s:Options definition="$CH_CBPLANBUSITYPE" />
											</html:select>
											<font color=red>&nbsp;*</font>
										</c:if>
										<c:if test="${!updateState}">
											<html:select property="planbusitype"
												onchange="doChange(this.value)">
												<html:option value=""></html:option>
												<s:Options definition="$CH_CBPLANBUSITYPE" />
											</html:select>
											<font color=red>&nbsp;*</font>
										</c:if>
									</c:when>
									<c:otherwise>
										<html:select property="planbusitype" disabled="true">
											<s:Options definition="$CH_CBPLANBUSITYPE" />
										</html:select>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
						<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="busyxplan" key="noncyc" />
									:
								</div>
							</td>
						 <td width="75%" align="left" class="form_table_left">
						 <c:choose>
                        <c:when test="${edtState}"> 
                            <c:if test="${updateState}">
											<html:text styleClass="form_input_1x" property="noncyc" maxlength="4"  /> 
										</c:if>
										<c:if test="${!updateState}">
											<html:text styleClass="form_input_1x" property="noncyc" maxlength="4" value="12" /> 
										</c:if>
                        </c:when>
                        <c:otherwise>
                            <html:text styleClass="form_input_1x" property="noncyc" disabled="true" />
                        </c:otherwise>
                    </c:choose>
						</td> 
						
						</tr>
						<tr>
                         <td  width="20%" align="right" class="form_table_right">界面说明：</td>
                          <td width="75%" align="left" class="form_table_left"> <font color='red'>营销方案标识和产品标识不能同时为空</font></td>
                         </tr>
					</table>
				</div>

				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td>
								<%
								if (request.getAttribute("SAVE").equals("TRUE")) {
								%>
								<input type="button" onmouseover="buttonover(this);"
									onmouseout="buttonout(this);" name="btnSave"
									onfocus="buttonover(this)" onblur="buttonout(this)"
									value="<bean:message bundle="public" key="button_save"/>"
									class="submit"
									onclick="doSave('/cms/reward/busyxplan.do?CMD=SAVE')" />
								<%
								} else {
								%>
								<input type="button" onmouseover="buttonover(this);"
									onmouseout="buttonout(this);" name="btnSave"
									onfocus="buttonover(this)" onblur="buttonout(this)"
									value="<bean:message bundle="public" key="button_save"/>"
									class="submit"
									onclick="doSave('/cms/reward/busyxplan.do?CMD=SAVE')"
									disabled="true" />
								<%
								}
								%>
								<input type="button" onmouseover="buttonover(this);"
									onmouseout="buttonout(this);" name="btnReturn"
									onfocus="buttonover(this)" onblur="buttonout(this)"
									value="<bean:message bundle="public" key="button_return"/>"
									class="close"
									onclick="doReturn('/cms/reward/busyxplan.do?CMD=SHOW')">
							</td>
						</tr>
					</table>
				</div>
			</html:form>
		</div>
	</body>
</html>
