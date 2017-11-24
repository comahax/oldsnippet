<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<jsp:include page="/inc/acl.jsp">
	<jsp:param name="PID" value="2B1A6FBT14" />
</jsp:include>
<html>
	<head>
		<title><s:text name="titleUpdate" /></title>
	</head>
	<body>
		<div class="table_container">
			<s:form action="smsobject_save.do" cssStyle="formList" key="formItem"
				method="post" theme="simple" onsubmit="return ev_checkval();">

				<s:hidden name="CMD" />
				<s:hidden name="param._orderby" />
				<s:hidden name="param._desc" />
				<s:hidden name="param._pageno" />
				<s:hidden name="param._pagesize" />
				<s:hidden name="param._se_countyid" />
				<s:hidden name="param._se_objecttype" />

				<div class="table_top">
					<div class="table_topleft"></div>
					<div class="table_toparea_w">
						<s:i18n name="public">
							<span class="table_toparea"><s:text name="currentPos" />
							</span>
							<span class="table_toparea_xi">></span>
							<span class="table_toparea"><s:text name="base" /> </span>
							<span class="table_toparea_xi">></span>
						</s:i18n>
						<span class="table_toparea_h"><s:text name="titleList" />
						</span>

					</div>
				</div>

				<div class="error_text">
					<table class="error_text">
						<s:actionerror />
						<s:actionmessage />
					</table>
				</div>

				<div class="table_div">
					<table class="table_normal">
						<tr>
							<td align="right">
								<s:text name="seqid" />
								:&nbsp
							</td>
							<td align="left">
								<s:if test="CMD == WEB_CMD_NEW">
									<s:textfield cssStyle="style_input" name="form.seqid"
										maxlength="14" disabled="true" />
									<font color=red>*&nbsp;系统生成</font>
								</s:if>
								<s:elseif test="CMD == WEB_CMD_EDIT">
									<s:textfield cssStyle="style_input" name="form.seqid"
										disabled="true" />
									<font color=red>*&nbsp;系统生成</font>
								</s:elseif>
								<s:else>
									<s:textfield cssStyle="style_input" name="form.seqid"
										disabled="true" />
									<font color=red>*</font>
								</s:else>
							</td>
						</tr>

						<tr>
							<td align="right">
								<s:text name="objecttype" />
								:&nbsp
							</td>
							<td align="left">
								<s:if test="CMD != WEB_CMD_SAVE">
									<j:selector cssStyle="style_input" name="form.objecttype"
										definition="$FX_OBJECTTYPE" onchange="setShow(this.value);" />
									<font color=red>*</font>
								</s:if>
								<s:else>
									<j:selector cssStyle="style_input" name="form.objecttype"
										definition="$FX_OBJECTTYPE" disabled="true"
										onchange="setShow(this.value);" />
									<font color=red>*</font>
								</s:else>
							</td>
						</tr>
						<tr>
							<td align="right">
								<s:text name="countyid" />
								:&nbsp
							</td>
							<td align="left">
								<s:if test="CMD != WEB_CMD_SAVE">
									<j:selector definition="#CNTYCOMPANY" mode="picker"
										name="form.countyid" condition="citycompid:${cityid}"
										readonly="true" />
									<span id="show"></span>
								</s:if>
								<s:else>
									<j:selector definition="#CNTYCOMPANY" mode="picker"
										name="form.countyid" condition="citycompid:${cityid}"
										readonly="true" />
									<span id="show"></span>
								</s:else>
							</td>
						</tr>
						<tr>
							<td align="right">
								<s:text name="name" />
								:&nbsp
							</td>
							<td align="left">
								<s:if test="CMD != WEB_CMD_SAVE">
									<s:textfield cssStyle="style_input" name="form.name"
										maxlength="32" />
									<font color=red>*</font>
								</s:if>
								<s:else>
									<s:textfield cssStyle="style_input" name="form.name"
										disabled="true" />
									<font color=red>*</font>
								</s:else>
							</td>
						</tr>
						<tr>
							<td align="right">
								<s:text name="mobile" />
								:&nbsp
							</td>
							<td align="left">
								<s:if test="CMD != WEB_CMD_SAVE">
									<s:textfield cssStyle="style_input" name="form.mobile"
										maxlength="11" />
									<font color=red>*</font>
								</s:if>
								<s:else>
									<s:textfield cssStyle="style_input" name="form.mobile"
										disabled="true" />
									<font color=red>*</font>
								</s:else>
							</td>
						</tr>
						<tr>
							<td align="right">
								<s:text name="busitype" />
								:&nbsp
							</td>
							<td align="left">
								<s:if test="CMD != WEB_CMD_SAVE">
									<j:selector cssStyle="style_input" name="form.busitype"
										definition="$FX_BUSITYPE" />
									<font color=red>*</font>
								</s:if>
								<s:else>
									<j:selector cssStyle="style_input" name="form.busitype"
										definition="$FX_BUSITYPE" disabled="true" />
									<font color=red>*</font>

								</s:else>
							</td>
						</tr>
					</table>
				</div>

				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td width="100%" align="center">
								<s:i18n name="public">
									<input type="button" id="btnSave" name="btnSave"
										class="button_Save" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" onfocus="buttonover(this)"
										onblur="buttonout(this)" value="<s:text name="button_save"/>"
										onclick="doSave('/base/smsobject_save.do')"
										<s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if> />
									<input type="button" id="btnReturn" name="btnReturn"
										class="button_Back" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" onfocus="buttonover(this)"
										onblur="buttonout(this)"
										value="<s:text name="button_return"/>"
										onclick="doReturn('/base/smsobject_list.do')">
								</s:i18n>
							</td>
						</tr>
					</table>
				</div>
			</s:form>
		</div>
	</body>
</html>
<script type="text/javascript"
	src="<%=contextPath%>/js/bus/pwaycommon.js"></script>
<script language="JavaScript">
	function ev_checkval() { 
	    var otype = document.getElementById('form.objecttype').value;  
		if (otype!="CITYDIRECTOR") {
		  addfield('form.countyid', '<s:text name="countyid"/>', 'c', false, 14); 
		}
		addfield('form.seqid', '<s:text name="seqid"/>', 'f', true, 14); 
		addfield('form.objecttype', '<s:text name="objecttype"/>', 'c', false, 16);
		addfield('form.name', '<s:text name="name"/>', 'c', false, 32);
		addfield('form.mobile', '<s:text name="mobile"/>', 'l', false, 11);
		addfield('form.busitype', '<s:text name="busitype"/>', 'c', false, 16);  
		return setSelectmobile() && checkval(window);
	}
 
	 function setSelectmobile(){
    	var mobile = document.getElementById('form.mobile').value;
       	var reg = /1[0-9]{10}/;
       	if(!reg.test(mobile) && '' != mobile){
        	var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[<s:text name="mobile"/> ]</span> 只能为11位的数字的手机号码 <span style=\'color:#F00; font-size:12px;\'></span>';
			errorMessageShow(alertstr);
			return false;
       	}
       	return true;
        
     }
     /**
     *根据不同的值觉得分公司是否显示必填
     */
     function setShow(value){
     	var show =document.getElementById("show");
	    var msg="";
	    if (value!="CITYDIRECTOR") {
		  msg="<font color='red'>*</font>";
		}else{
			msg="";
		}
		show.innerHTML=msg;
     }
</script>