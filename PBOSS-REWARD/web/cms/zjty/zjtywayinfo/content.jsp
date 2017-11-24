<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%@ taglib uri="http://ajaxanywhere.sourceforge.net/" prefix="aa"%>
<html:html>
<head>
	<title><bean:message bundle="zjtywayinfo" key="svwayinfo" />
	</title>
	<script type="text/javascript"
		src="<%=contextPath%>/js/bus/waycommon.js"></script>
	<script type="text/javascript"
		src="<%=contextPath%>/js/bus/rescommon.js"></script>
	<script type="text/javascript" src="<%=contextPath%>/js/aa.js"></script>
	<script language="JavaScript">
        function ev_checkval() {
        	var form=document.forms[0];
        	if(form.latitude.value.length>0){
        	if(form.latitude.value.indexOf('.')==-1){
        	errorMessageShow('<span class=\'errorkey\'><span style=\'color:#F00; font-weight:900;\'>[<bean:message bundle="zjtywayinfo" key="latitude"/>]</span><bean:message bundle="zjtywayinfo" key="latitude"/>必须为小数</span>');
        	return false;
        	}else{
        	var decimal=form.latitude.value.split('.');
        	if(decimal[1].length<6){
        	errorMessageShow('<span class=\'errorkey\'><span style=\'color:#F00; font-weight:900;\'>[<bean:message bundle="zjtywayinfo" key="latitude"/>]</span><bean:message bundle="zjtywayinfo" key="latitude"/>小数点必须有6位</span>');
        	return false;
        	}
        	}
        	}
        	if(form.longtitude.value.length>0){
			if(form.longtitude.value.indexOf('.')==-1){
        	errorMessageShow('<span class=\'errorkey\'><span style=\'color:#F00; font-weight:900;\'>[<bean:message bundle="zjtywayinfo" key="longtitude"/>]</span><bean:message bundle="zjtywayinfo" key="longtitude"/>必须为小数</span>');
        	return false;
        	}else{
        	var decimal2=form.longtitude.value.split('.');
        	if(decimal2[1].length<6){
        	errorMessageShow('<span class=\'errorkey\'><span style=\'color:#F00; font-weight:900;\'>[<bean:message bundle="zjtywayinfo" key="longtitude"/>]</span><bean:message bundle="zjtywayinfo" key="longtitude"/>小数点必须有6位</span>');
        	return false;
        	}
        	}
        	}
        	
            addfield('wayid', '<bean:message bundle="revsumpaybill" key="wayid" />', 'c', false, 18);
            addfield('upperwayid', '<bean:message bundle="Way" key="upperwayid"/>', 'c', false, 18);
            addfield('bchlevel', '<bean:message bundle="zjtywayinfo" key="bchlevel"/>', 'c', false, 2);
            addfield('prtsource', '<bean:message bundle="zjtywayinfo" key="prtsource"/>', 'i', false, 2);            
			addfield('adtypecode', '<bean:message bundle="zjtywayinfo" key="adtypecode"/>', 'i', false, 2);            
            addfield('wayname', '<bean:message bundle="Way" key="wayname"/>', 'c', false, 256);
            addfield('latitude', '<bean:message bundle="zjtywayinfo" key="latitude"/>', 'f', false, 2,6,0,18,26);
            addfield('buzphoneno', '<bean:message bundle="zjtywayinfo" key="buzphoneno"/>', 'c', true, 14);
            addfield('longtitude', '<bean:message bundle="zjtywayinfo" key="longtitude"/>', 'f', false, 3,6,0,100,130);
            addfield('address', '<bean:message bundle="zjtywayinfo" key="address"/>', 'c', true, 128);
            return checkval(window);
        }
        function checkischar(levels){
        var form=document.forms[0];
        var str=/[a-zA-Z]/;
        if(!str.test(levels)){
         errorMessageShow('<span class=\'errorkey\'><span style=\'color:#F00; font-weight:900;\'>[<bean:message bundle="zjtywayinfo" key="bchlevel"/>]</span><bean:message bundle="zjtywayinfo" key="bchlevel"/>必须为字母</span>');
         return true;
        }
        if(levels.length>1){
        errorMessageShow('<span class=\'errorkey\'><span style=\'color:#F00; font-weight:900;\'>[<bean:message bundle="zjtywayinfo" key="bchlevel"/>]</span><bean:message bundle="zjtywayinfo" key="bchlevel"/>长度不能大于1</span>');
         return true;
        }
        }
        function doAjaxsubmit(obj){
        
        showSelectWay(obj);
		ajaxAnywhere.submitByURL("/cms/zjty/zjtywayinfo.do?CMD=Changeupwayid&cmdvalue=citycompid&cmdstates=<c:out value="${requestScope['/cms/zjty/zjtywayinfo/ZjtywayinfoForm'].cmdState}"/>"); 
		}
		
		function isExistedWid(){
		var form=document.forms[0];
		ajaxAnywhere.submitByURL("/cms/zjty/zjtywayinfo.do?CMD=Existedwid"); 
		}
		
		function isCheckada(){
		var form=document.forms[0];
		ajaxAnywhere.submitByURL("/cms/zjty/zjtywayinfo.do?CMD=Checkada"); 
		}
		
		function doGetList(cmdvalue){
			ajaxAnywhere.submitByURL("/cms/zjty/zjtywayinfo.do?CMD=GETCOUNTID&cmdvalue="+cmdvalue+"&cmdstates=<c:out value="${requestScope['/cms/zjty/zjtywayinfo/ZjtywayinfoForm'].cmdState}"/>"); 
		}
		function selectSv(){
        	ajaxAnywhere.submitByURL("/cms/zjtywayinfo/zjtywayinfo.do?CMD=SELECTSV"); 
        }
    </script>
</head>
<body onload="loadforiframe();">
	<div class="table_container">
	<html:form action="/cms/zjty/zjtywayinfo.do?CMD=SAVE"
		styleId="formItem" method="post">
		<html:hidden property="cmdState" />
		<html:hidden property="_orderby" />
		<html:hidden property="_desc" />
		<html:hidden property="_pageno" />
		<html:hidden property="_pagesize" />
		<html:hidden property="waysubtype" value="ZJTY" />
		<html:hidden property="runmode" value="1" />
		<c:set var="edtvalue" scope="request"
			value="${requestScope['/cms/zjty/zjtywayinfo/ZjtywayinfoForm'].cmdState}" />
		<c:set var="edtState" scope="request"
			value="${edtvalue eq 'EDIT' or edtvalue eq 'NEW'}" />
		<c:set var="newstate" scope="request" value="${edtvalue eq 'NEW' }" />
		<div class="table_div">
			<table class="top_table">
				<tr>
					<td>
						<bean:message bundle="zjtywayinfo" key="titleList" />
					</td>
				</tr>
			</table>
		</div>
		<aa:zone name="showerror">
			<div class="table_div">
				<table class="error_text" width="100%">
					<html:errors />
					<s:Msg />
				</table>
			</div>
		</aa:zone>
		<div class="table_div">
			<table class="form_table">
				<tr>
					<td class="form_table_right">
						<bean:message bundle="revsumpaybill" key="wayid" />
						:
					</td>
					<td class="form_table_left">
						<c:choose>
							<c:when test="${edtvalue eq 'NEW'}">
								<input type="text" name="wayid" class="form_input_1x"
									onBlur="isExistedWid()" />
								<font color=red>&nbsp;*</font>
							</c:when>
							<c:otherwise>
								<html:text styleClass="form_input_1x" property="wayid"
									readonly="true" />
							</c:otherwise>
						</c:choose>
					</td>

					<td class="form_table_right">
						<bean:message bundle="svwayinvms" key="wayname" />
						:
					</td>
					<td class="form_table_left">
						<c:choose>
							<c:when test="${edtState}">
								<html:text styleClass="form_input_1x" property="wayname" />
								<font color=red>&nbsp;*</font>
							</c:when>
							<c:otherwise>
								<html:text styleClass="form_input_1x" property="wayname"
									readonly="true" />
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
				<tr>
					<td class="form_table_right">
						<bean:message bundle="zjtywayinfo" key="upperwayid" />
						:
					</td>
					<td class="form_table_left">
						<c:choose>
							<c:when test="${edtState}">
								<html:text styleClass="form_input_1x" property="upperwayid"
									readonly="true" onclick="doAjaxsubmit(this)" />
								<font color=red>&nbsp;*</font>
							</c:when>
							<c:otherwise>
								<html:text styleClass="form_input_1x" property="upperwayid"
									readonly="true" />
							</c:otherwise>
						</c:choose>
					</td>

					<td class="form_table_right">
						<bean:message bundle="zjtywayinfo" key="svbrchcode" />
						:
					</td>
					<td class="form_table_left">
						<c:choose>
							<c:when test="${edtState}">
								<html:select property="svbrchcode">
									<option />
										<s:Options definition="$CH_SVBRCHTYPE" />
								</html:select>
							</c:when>
							<c:otherwise>
								<html:text styleClass="form_input_1x" property="svbrchcode"
									readonly="true" />
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
				<tr>
					<td class="form_table_right">
						<bean:message bundle="zjtywayinfo" key="bchlevel" />
						:
					</td>
					<td class="form_table_left">
						<c:choose>
							<c:when test="${edtState}">
								<html:select property="bchlevel">
									<option />
										<s:Options definition="$CH_BCHLEVEL" />
								</html:select>
								<font color=red>&nbsp;*</font>
							</c:when>
							<c:otherwise>
								<html:text styleClass="form_input_1x" property="bchlevel"
									readonly="true" />
								<font color=red>&nbsp;*</font>
							</c:otherwise>
						</c:choose>
					</td>
					<td class="form_table_right">
						<bean:message bundle="zjtywayinfo" key="waysubtype" />
						:
					</td>
					<td class="form_table_left">
						自建他营厅
					</td>
				</tr>
				<tr>
					<td class="form_table_right">
						<bean:message bundle="zjtywayinfo" key="cityid" />
						:
					</td>
					<td class="form_table_left">
						<aa:zone name="getcityid">
							<div>
								<c:choose>
									<c:when
										test="${ empty requestScope['/cms/zjty/zjtywayinfo/ZjtywayinfoForm'].cityid}">
										<html:select property="cityid" onchange="doGetList('cityid');">
											<option />
												<s:Options definition="#CITYCOMPANY" />
										</html:select>
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="cityid"
											readonly="true" />
									</c:otherwise>
								</c:choose>
							</div>
						</aa:zone>
					</td>
					<td class="form_table_right">
						<bean:message bundle="zjtywayinfo" key="countyid" />
						:
					</td>
					<td class="form_table_left">
						<aa:zone name="getcountyid">
							<div>
								<c:choose>
									<c:when
										test="${empty requestScope['/cms/zjty/zjtywayinfo/ZjtywayinfoForm'].countyid or requestScope.ischange eq '1'}">
										<html:select property="countyid"
											onchange="doGetList('citycompid');">
											<option />
												<s:Options definition="#CNTYCOMPANY"
													condition="citycompid:${requestScope['/cms/zjty/zjtywayinfo/ZjtywayinfoForm'].cityid}" />
										</html:select>
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="countyid"
											readonly="true" />
									</c:otherwise>
								</c:choose>
							</div>
						</aa:zone>
					</td>
				</tr>
				<tr>
					<td class="form_table_right">
						<bean:message bundle="zjtywayinfo" key="svccode" />
						:
					</td>
					<td class="form_table_left">
						<aa:zone name="getsvccode">
							<div>
								<c:choose>
									<c:when test="${edtState}">
										<html:select property="svccode" onchange="doGetList();">
											<option />
												<s:Options definition="#SERVCENT"
													condition="countyid:${requestScope['/cms/zjty/zjtywayinfo/ZjtywayinfoForm'].countyid}" />
										</html:select>
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="svccode"
											readonly="true" />
									</c:otherwise>
								</c:choose>
							</div>
						</aa:zone>
					</td>
					<td class="form_table_right">
						<bean:message bundle="zjtywayinfo" key="mareacode" />
						:
					</td>
					<td class="form_table_left">
						<aa:zone name="getmareacode">
							<div>
								<c:choose>
									<c:when test="${edtState}">
										<html:select property="mareacode">
											<option />
												<s:Options definition="#MICROAREA"
													condition="svccode:${requestScope['/cms/zjty/zjtywayinfo/ZjtywayinfoForm'].svccode}" />
										</html:select>
									</c:when>
									<c:otherwise>
										<html:text styleClass="form_input_1x" property="mareacode"
											readonly="true" />
									</c:otherwise>
								</c:choose>
							</div>
						</aa:zone>

					</td>
				</tr>
				<!-- 新增的字段 -->
				<tr>
					<td class="form_table_right">
						<bean:message bundle="zjtywayinfo" key="starlevel" />
						:
					</td>
					<td class="form_table_left">
						<c:choose>
							<c:when test="${edtState}">
								<html:select property="starlevel">
									<option />
										<s:Options definition="$CH_STARLEVEL" />
								</html:select>
							</c:when>
							<c:otherwise>
								<html:text styleClass="form_input_1x" property="starlevel"
									readonly="true" />
							</c:otherwise>
						</c:choose>
					</td>

					<td class="form_table_right">
						<bean:message bundle="zjtywayinfo" key="runmode" />
						:
					</td>
					<td class="form_table_left">
						自建他营
					</td>

				</tr>

				<tr>
					<td class="form_table_right">
						<bean:message bundle="zjtywayinfo" key="isconnected" />
						:
					</td>
					<td class="form_table_left">
						<c:choose>
							<c:when test="${edtState}">
								<html:select property="isconnected">
									<option />
										<s:Options definition="$CH_ISCONNECTED" />
								</html:select>
							</c:when>
							<c:otherwise>
								<html:text styleClass="form_input_1x" property="isconnected"
									readonly="true" />
							</c:otherwise>
						</c:choose>
					</td>
					<td class="form_table_right">
						<bean:message bundle="zjtywayinfo" key="connecttype" />
						:
					</td>
					<td class="form_table_left">
						<c:choose>
							<c:when test="${edtState}">
								<html:select property="connecttype">
									<option />
										<s:Options definition="$CH_CONNECTTYPE" />
								</html:select>
							</c:when>
							<c:otherwise>
								<html:text styleClass="form_input_1x" property="connecttype"
									readonly="true" />
							</c:otherwise>
						</c:choose>
					</td>

				</tr>
				<!-- 结束 -->
				<tr>
					<td class="form_table_right">
						<bean:message bundle="zjtywayinfo" key="prtsource" />
						:
					</td>
					<td class="form_table_left">
						<c:choose>
							<c:when test="${edtState}">
								<html:select property="prtsource">
									<option />
										<s:Options definition="$CH_PRTSOURCE" />
								</html:select>
								<font color=red>&nbsp;*</font>
							</c:when>
							<c:otherwise>
								<html:text styleClass="form_input_1x" property="prtsource"
									readonly="true" />
								<font color=red>&nbsp;*</font>
							</c:otherwise>
						</c:choose>
					</td>
					<td class="form_table_right">
						<bean:message bundle="zjtywayinfo" key="buztypecode" />
						:
					</td>
					<td class="form_table_left">
						<c:choose>
							<c:when test="${edtState}">
								<html:select property="buztypecode">
									<option />
										<s:Options definition="$CH_BUZTYPE" />
								</html:select>
							</c:when>
							<c:otherwise>
								<html:text styleClass="form_input_1x" property="buztypecode"
									readonly="true" />
							</c:otherwise>
						</c:choose>
					</td>

				</tr>

				<tr>
					<td class="form_table_right">
						<bean:message bundle="zjtywayinfo" key="adtypecode" />
						:
					</td>
					<td class="form_table_left">
						<c:choose>
							<c:when test="${edtState}">
								<html:select property="adtypecode">
									<option />
										<s:Options definition="$CH_ADTYPE" />
								</html:select>
								<font color=red>&nbsp;*</font>
							</c:when>
							<c:otherwise>
								<html:text styleClass="form_input_1x" property="adtypecode"
									readonly="true" />
								<font color=red>&nbsp;*</font>	
							</c:otherwise>
						</c:choose>
					</td>
					<td class="form_table_right">
						<bean:message bundle="zjtywayinfo" key="buzphoneno" />
						:
					</td>
					<td class="form_table_left">
						<c:choose>
							<c:when test="${edtState}">
								<html:text styleClass="form_input_1x" property="buzphoneno" />
							</c:when>
							<c:otherwise>
								<html:text styleClass="form_input_1x" property="buzphoneno"
									readonly="true" />
							</c:otherwise>
						</c:choose>
					</td>

				</tr>

				<tr>
					<td class="form_table_right">
						<bean:message bundle="zjtywayinfo" key="adacode" />
						:
					</td>
					<td class="form_table_left">
						<c:choose>
							<c:when test="${edtState}">
								<html:text property="adacode" styleClass="form_input_1x"
									onclick="showAdaTree(this,'adacode');" onblur="isCheckada();" />
							</c:when>
							<c:otherwise>
								<html:text styleClass="form_input_1x" property="adacode"
									readonly="true" />
							</c:otherwise>
						</c:choose>
					</td>
					<td class="form_table_right">
						<bean:message bundle="zjtywayinfo" key="latitude" />
						:
					</td>
					<td class="form_table_left">
						<c:choose>
							<c:when test="${edtState}">
								<html:text styleClass="form_input_1x" property="latitude" />
								<font color=red>&nbsp;*</font>
							</c:when>
							<c:otherwise>
								<html:text styleClass="form_input_1x" property="latitude"
									readonly="true" />
							</c:otherwise>
						</c:choose>
					</td>

				</tr>

				<tr>
					<td class="form_table_right">
						<bean:message bundle="zjtywayinfo" key="longtitude" />
						:
					</td>
					<td class="form_table_left">
						<c:choose>
							<c:when test="${edtState}">
								<html:text styleClass="form_input_1x" property="longtitude" />
								<font color=red>&nbsp;*</font>
							</c:when>
							<c:otherwise>
								<html:text styleClass="form_input_1x" property="longtitude"
									readonly="true" />
							</c:otherwise>
						</c:choose>
					</td>
					<td class="form_table_right">
						<bean:message bundle="zjtywayinfo" key="address" />
						:
					</td>
					<td class="form_table_left">
						<c:choose>
							<c:when test="${edtState}">
								<html:text styleClass="form_input_1x" property="address" />
							</c:when>
							<c:otherwise>
								<html:text styleClass="form_input_1x" property="address"
									readonly="true" />
							</c:otherwise>
						</c:choose>
					</td>

				</tr>

				<tr>
					<td class="form_table_right">
						<bean:message bundle="zjtywayinfo" key="waystate" />
						:
					</td>
					<td class="form_table_left">
						<c:choose>
							<c:when test="${newstate}">
								<html:select property="waystate" value="1">
									<option />
										<s:Options definition="$CH_VALIDFLAG" />
								</html:select>
							</c:when>
							<c:when test="${edtState}">
								<html:select property="waystate">
									<option />
										<s:Options definition="$CH_VALIDFLAG" />
								</html:select>
							</c:when>
							<c:otherwise>
								<html:text styleClass="form_input_1x" property="waystate"
									readonly="true" />
							</c:otherwise>
						</c:choose>
					</td>
					<td class="form_table_right">
						是否中心渠道:
					</td>
					<td class="form_table_left">
						<c:choose>
							<c:when test="${edtState}">
								<html:select property="iscoreway">
									<option />
										<s:Options definition="$CH_ISCOREWAY" />
								</html:select>
							</c:when>
							<c:otherwise>
								<html:text styleClass="form_input_1x" property="iscoreway"
									readonly="true" />
							</c:otherwise>
						</c:choose>
					</td>
				</tr>


				<tr>

					<td class="form_table_right">
						<bean:message bundle="saleway" key="chainhead" />
						:
					</td>
					<td class="form_table_left">
						<s:zoom definition="#WAY" property="chainhead"
								styleClass="form_input_1x" condition="waytype:${'AG'};waysubtype:${'DIS'};upperwayid:${'DIS-----'}"/>
					</td>

					<td colspan="2">
						<font color=red>（自建他营的服务厅可输入对应的合作商编码）</font>
					</td>
				</tr>
				<tr>
					<td class="form_table_right">
						<bean:message bundle="Way" key="isshare"/>
						:
					</td>
					<td>
						<c:choose>
							<c:when test="${edtState}">
								<html:select property="isshare">
									<option>
									<s:Options definition="$CH_DSTISKEYSTEP" />
								</html:select>
							</c:when>
							<c:otherwise>
								<html:text styleClass="form_input_1x" property="isshare"
									readonly="true" />
							</c:otherwise>
						</c:choose>
						
					</td>
					<td colspan=2>&nbsp;</td>
				</tr>

				<tr>
					<td class="form_table_right" colspan="8">
						<bean:message bundle="zjtywayinfo" key="note" />
					</td>
				</tr>
			</table>
		</div>

		<aa:zone name="showbutton">
			<div class="table_div">
				<table class="table_button_list">
					<tr>
						<td width="100%" class="form_table_center">
							<c:choose>
								<c:when test="${empty requestScope.isExit}">
									<input type="button" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" name="btnSave"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="<bean:message bundle="public" key="button_save"/>"
										class="submit"
										onclick="doSave('/cms/zjty/zjtywayinfo.do?CMD=SAVE')" />
								</c:when>
								<c:otherwise>
									<input type="button" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" name="btnSave"
										onfocus="buttonover(this)" onblur="buttonout(this)"
										value="<bean:message bundle="public" key="button_save"/>"
										class="submit"
										onclick="doSave('/cms/svwayinfo/svwayinfo.do?CMD=SAVE')"
										disabled="true" />
								</c:otherwise>
							</c:choose>

							<input type="button" onmouseover="buttonover(this);"
								onmouseout="buttonout(this);" name="btnReturn"
								onfocus="buttonover(this)" onblur="buttonout(this)"
								value="<bean:message bundle="public" key="button_return"/>"
								class="close"
								onclick="doReturn('/cms/zjty/zjtywayinfo.do?CMD=LIST')">
						</td>
					</tr>
				</table>
			</div>
		</aa:zone>
	</html:form>
	</div>
</body>
</html:html>
