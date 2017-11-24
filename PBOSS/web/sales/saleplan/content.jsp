<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<jsp:include page="/inc/acl.jsp">
	<jsp:param name="PID" value="2B1A6FBT14" />
</jsp:include>
<html>
	<head>
		<title><s:text name="titleUpdate" />
		</title>
		<script language="JavaScript">
	function ev_checkval() {
		//addfield('form.recid', '<s:text name="recid"/>', 'f', false, 14);
		
		addfield('form.plancode', '<s:text name="plancode"/>', 'c', false, 256);
		addfield('form.planname', '<s:text name="planname"/>', 'c', false, 512);
		addfield('form.begindate', '<s:text name="begindate"/>', 't', false, 7);
		addfield('form.enddate', '<s:text name="enddate"/>', 't', false, 7);
		addfield('form.comcategory', '<s:text name="comcategory"/>', 'c', false, 512);
		addfield('form.premode', '<s:text name="premode"/>', 'c', false, 20);
		addfield('form.prevalue', '<s:text name="prevalue"/>', 'f', false,13,2);
		addfield('form.memo', '<s:text name="memo"/>', 'c', true, 512);
		return (checkval(window) && compareDate());
	}
	
	
	  function compareDate(){
        var startTime = document.getElementById('form.begindate').value;
        var endTime = document.getElementById('form.enddate').value;

        if(startTime != '' && endTime != '' &&  startTime>endTime){
        var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[<s:text name="begindate"/> ]</span> 不能大于 <span style=\'color:#F00; font-size:12px;\'>[<s:text name="enddate"/>]</span>';
			errorMessageShow(alertstr);
			return false;
		}
       return true;
       }
	
	
		function choose_category() {
	  
	   var categorycode = $("#comcategory").get(0);
	   
	   var categorycodeValue = categorycode.value;
	  
	   //获取标识符字符串
	    var str = "";
	    if(categorycodeValue != ""){
	     var valArray = categorycodeValue.split(",");
	      
	     for(var i=0;i<valArray.length;i++){  
	       if (valArray[i].split(" ")[0].length==0) {  
	           str = str+ valArray[i].split(" ")[0]; 
	       }else if (valArray[i].split(" ")[0].length>0){  
	           str = str + valArray[i].split(" ")[0]+",";
	       }
	     } 
	    }  
	   	$("#selectedStr").val(str);
	   	var strUrl = contextPath + "/common/productcategoryselect_categoryList.do";
	   	var ret = window.showModalDialog(strUrl, self, "dialogWidth:700px; dialogHeight:450px; status:no; resizable:no;");  
	    
	   	if (ret.length>0 && 'NULL'!=ret) { 
				categorycode.value = ret;
		}else if(ret.length==0){ 
				categorycode.value = str;
		}
	}
	
</script>
	</head>
	<body>
		<div class="table_container">
			<s:form action="saleplan_save.do" cssStyle="formList" key="formItem"
				method="post" theme="simple" onsubmit="return ev_checkval();">
   <s:hidden name="form.selectedStr" id="selectedStr"/>
				<s:hidden name="CMD" />
				<s:hidden name="param._orderby" />
				<s:hidden name="param._desc" />
				<s:hidden name="param._pageno" />
				<s:hidden name="param._pagesize" />
				<s:hidden name="param._se_plancode" />
				<s:hidden name="param._se_planname" />
				<s:hidden name="param._dnm_begindate" />
				<s:hidden name="param._dnl_begindate" />
				<s:hidden name="form.cityid" />

				<div class="table_top">
					<div class="table_topleft"></div>
					<div class="table_toparea_w">
						<s:i18n name="public">
							<span class="table_toparea"><s:text name="currentPos" /> </span>
							<span class="table_toparea_xi">></span>
							<span class="table_toparea"><s:text name="sales"/> </span>
							<span class="table_toparea_xi">></span>
						</s:i18n>
						<span class="table_toparea_h"><s:text name="titleList" />
						</span>
						<span class="button_Help"
							onclick="openword('<s:text name="helpTitle"/>','<s:text name="helpContent"/>')"><s:i18n
								name="public">
								<s:text name="help" />
							</s:i18n>
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
								<s:text name="recid" />
								:&nbsp
							</td>
							<td align="left">
								<s:if test="CMD == WEB_CMD_NEW">
									<s:textfield cssStyle="style_input" name="form.recid"
										maxlength="14" readonly="true" onfocus="this.blur()"/>
									<font color=red>*</font>
								</s:if>
								<s:elseif test="CMD == WEB_CMD_EDIT">
									<s:textfield cssStyle="style_input" name="form.recid"
										disabled="true"  onfocus="this.blur()"/>
									<font color=red>*</font>
								</s:elseif>
								<s:else>
									<s:textfield cssStyle="style_input" name="form.recid"
										disabled="true"  onfocus="this.blur()"/>
									<font color=red>*</font>
								</s:else>
							自动生成
							</td>
							
						</tr>
						<tr>
							<td align="right">
								<s:text name="plancode" />
								:&nbsp
							</td>
							<td align="left">
								<s:if test="CMD != WEB_CMD_SAVE">
									<s:textfield cssStyle="style_input" name="form.plancode"
										maxlength="256" />
								</s:if>
								<s:else>
									<s:textfield cssStyle="style_input" name="form.plancode"
										disabled="true" />
								</s:else>
								<font color=red>*</font>
							</td>
						</tr>
						<tr>
							<td align="right">
								<s:text name="planname" />
								:&nbsp
							</td>
							<td align="left">
								<s:if test="CMD != WEB_CMD_SAVE">
									<s:textfield cssStyle="style_input" name="form.planname"
										maxlength="512" />
								</s:if>
								<s:else>
									<s:textfield cssStyle="style_input" name="form.planname"
										disabled="true" />
								</s:else>
								<font color=red>*</font>
							</td>
						</tr>
						<tr>
							<td align="right">
								<s:text name="begindate" />
								:&nbsp
							</td>
							<td align="left">
								<s:if test="CMD != WEB_CMD_SAVE">
										<input class="style_input" name="form.begindate" value="<s:property value="form.begindate!=null?getText('format.date',{form.begindate}):''"/>" onclick="selectDate();"/>
								</s:if>
								<s:else>
									<input class="style_input" name="form.begindate" value="<s:property value="form.begindate!=null?getText('format.date',{form.begindate}):''"/>" disabled="true" />
								</s:else>
								<font color=red>*</font>
							</td>
						</tr>
						<tr>
							<td align="right">
								<s:text name="enddate" />
								:&nbsp
							</td>
							<td align="left">
								<s:if test="CMD != WEB_CMD_SAVE">
										<input class="style_input" name="form.enddate" value="<s:property value="form.enddate!=null?getText('format.date',{form.enddate}):''"/>" onclick="selectDate();"/>
								</s:if>
								<s:else>
									<input class="style_input" name="form.enddate" value="<s:property value="form.enddate!=null?getText('format.date',{form.enddate}):''"/>" onclick="selectDate();"
										disabled="true" />
								</s:else>
								<font color=red>*</font>
							</td>
						</tr>
						<tr>
							<td align="right">
								<s:text name="comcategory" />
								:&nbsp
							</td>
							<td align="left">
								<s:if test="CMD != WEB_CMD_SAVE">
									<s:textfield cssStyle="style_input" name="form.comcategory"  id="comcategory"
										maxlength="512" />
										<input type="button" class="picker_button" value="..."
										onClick="javascript:choose_category()" />
								</s:if>
								<s:else>
									<s:textfield cssStyle="style_input" name="form.comcategory"
										disabled="true" />
								</s:else>
								<font color=red>*</font>
							</td>
						</tr>
						
						<tr>
							<td align="right">
								<s:text name="premode" />
								:&nbsp
							</td>
							<td align="left">
								<s:if test="CMD != WEB_CMD_SAVE">
									<j:selector definition="$FX_PRICEPREMODE"  name="form.premode"/>
								</s:if>
								<s:else>
									<j:selector definition="$FX_PRICEPREMODE"  name="form.premode"
										disabled="true" />
								</s:else>
								<font color=red>*</font>
							</td>
						</tr>
						<tr>
							<td align="right">
								<s:text name="prevalue" />
								:&nbsp
							</td>
							<td align="left">
								<s:if test="CMD != WEB_CMD_SAVE">
									<s:textfield cssStyle="style_input" name="form.prevalue"
										maxlength="512" />
								</s:if>
								<s:else>
									<s:textfield cssStyle="style_input" name="form.prevalue"
										disabled="true" />
								</s:else>
								<font color=red>*</font>
							</td>
						</tr>
						
						
						<tr>
							<td align="right">
								<s:text name="memo" />
								:&nbsp
							</td>
							<td align="left">
								<s:if test="CMD != WEB_CMD_SAVE">
									<s:textarea name="form.memo"
										cssStyle="style_input" rows="4" cols="40" maxlength="512"></s:textarea>
									
								</s:if>
								<s:else>
									<s:textarea name="form.memo" 
										cssStyle="style_input" rows="4" cols="40" maxlength="512"
										disabled="true"></s:textarea>
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
										onclick="doSave('/sales/saleplan_save.do')"
										<s:if test="CMD == WEB_CMD_SAVE">disabled = "true"</s:if> />
									<input type="button" id="btnReturn" name="btnReturn"
										class="button_Back" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" onfocus="buttonover(this)"
										onblur="buttonout(this)"
										value="<s:text name="button_return"/>"
										onclick="doReturn('/sales/saleplan_list.do')">
								</s:i18n>
							</td>
						</tr>
					</table>
				</div>
			</s:form>
		</div>
	</body>
</html>