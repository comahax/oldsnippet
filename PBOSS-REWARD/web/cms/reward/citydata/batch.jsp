<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<jsp:include page="/inc/acl.jsp">
	<jsp:param name="PID" value="7F1A1A" />
</jsp:include>

<html>
	<head>
		<title><bean:message bundle="citydata" key="titleList" />
		</title>
		<script language="JavaScript">
	function checkfilename() {
	   	  var filename = document.all.theFile.value;
	   	  if(filename != "") {
	   	   	var arrys = filename.split(".");
		    var filetype = arrys[arrys.length-1];
		    if(filetype.toUpperCase() != "TXT" && filetype.toUpperCase() != "DOC"){
		      errorMessageShow('<bean:message bundle="citydata" key="invalidFileCompose"/>');
		      return false;
		    }
		   }else{
		   	if(filename == ""){
		   		errorMessageShow('<bean:message bundle="citydata" key="selectfile"/>');
		   		return false;
		   	}
		   }
		   return true; 
	   }
	   
		function check() {
            addfield('remark', '<bean:message bundle="citydata" key="remark"/>', 'c', false, 30);
            if(!checkval(window)){
            	return;
            }
            if (checkfilename() == false) {
            	return;
            }
			var citytype=document.getElementById('citydatatype').value
			if('ARPUDATA'==citytype){
			var falg = false;
			var selectitems = eval("document.formItem").all("_selectitem");
			for(var i = 0 ; i<selectitems.length ; i++){
			if(selectitems[i].checked == true)
			falg = true;
			}
			if(!falg){
			 errorMessageShow('<font color="red">提示信息:影响酬金类型必须选择一个或多个。</font>');
			 return;
			}
			}
            formItem.action = contextPath + '/cms/citydata.do?CMD=CHECK';
            formItem.submit();
		}
		
		function upload(result){
			if(result ==  1 && !confirm("本月已经导入过数据并未处理，是否继续再导入一次，作废上次导入的未处理数据？")){
				return;
			}
			formItem.target = '';
			formItem.action = contextPath + '/cms/citydata/batchintask.do';
			document.all("buttonUpload").disabled = true;
			formItem.submit();
		}
		function showdiv(select){
			var oDiv = select.value;
			var noDiv=(select.value=='BUSIVALIDDATA'?'ARPUDATA':'BUSIVALIDDATA');

			for(var i=0;i<4;i++){
				document.getElementById(oDiv+i).style.display="block";
				document.getElementById(noDiv+i).style.display="none";
			}
			if(oDiv=='ARPUDATA'){
				document.getElementById('ARPUDATA4').style.display="block";
			}else{
				document.getElementById('ARPUDATA4').style.display="none";
			}
		}
		function getRewarBussValues(definition,obj) {
			var originalValue = event.srcElement.value;
			var sis = formItem.all("_selectitem");
        	var rewardtype = '';
        	if (sis.length == undefined) {
        		if (sis.value != '') {
        			rewardtype = sis.value;
        		}
        	} else {
        		for (var i=0; i<sis.length; i++) {
        			if (sis[i].type == 'checkbox' && sis[i].checked) {
        				rewardtype = rewardtype+sis[i].value;
        			}
        		}
        	}
        	
        	if(rewardtype=="" || rewardtype=="7" || rewardtype=="8" || rewardtype=="78" ){
				return;
			}
			var arg = new Array();
			var strUrl = contextPath + "/commons/rewardopr.do?CMD=select&definition=" + definition + "&originalStr=" + originalValue+"&EXTEND1="+rewardtype;
			var ret = window.showModalDialog(strUrl, arg, "dialogWidth:720px; dialogHeight:360px; status:no; resizable:no;");
			if (ret == null || ret == '') {
				ret = '';
				//ret = originalValue;
			}
		
			obj.value=ret;
		}
    </script>
	</head>
	<body onload="loadforiframe();showdiv(document.getElementById('citydatatype'))">
		<div class="table_container">
			<html:form action="/cms/citydata/batchintask.do" styleId="formItem" method="post" target="hidden_frame" enctype="multipart/form-data">
				<iframe name='hidden_frame' id="hidden_frame" style="display:none"></iframe>
				<input type="hidden" name="filename" value="<c:out value='${requestScope.ITEM.inFile}'/>">

				<div class="table_div">
					<table class="top_table">
						<tr>
							<td>
								<bean:message bundle="citydata" key="titleList" />
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
					<table class="form_table" width="95%">
						<tr>
							<td width=12% align=right height=25>
								<div class="field-require">
									<bean:message bundle="citydata" key="dataFile" />
									:
								</div>
							</td>
							<td width="75%" align="left" class="form_table_left" colspan=3>
								<html:file styleClass="form_input_files" property="theFile" />
							</td>
						</tr>
						<tr>
							<td align=right height=25>
								<bean:message bundle="upload" key="filetype" />
							</td>
							<td align=left colspan=3>
								<bean:message bundle="upload" key="typevalue" />
							</td>
						</tr>
						<tr>
							<td align=right height=25>
								地市导入数据类型:
							</td>
							<td align=left colspan=3>

								<html:select property="citydatatype" onchange="showdiv(this)">
								<s:Options  definition="$CH_ADTCITYDATATYPE"/>
								</html:select>
							</td>
						</tr>
						<tr id="BUSIVALIDDATA0">
							<td align=right height=25>
								<bean:message bundle="citydata" key="fielFmt" />
							</td>
							<td align=left colspan=3>
								<bean:message bundle="citydata" key="contentFmt" />
							</td>
						</tr>
						<tr id="ARPUDATA0" style="display:none">
							<td align=right height=25>
								<bean:message bundle="citydata" key="fielFmt" />
							</td>
							<td align=left colspan=3>
								<font color="red">号码|</font>
							</td>
						</tr>
						<tr id="BUSIVALIDDATA1">
							<td align=right height=25>
								<bean:message bundle="citydata" key="example" />
							</td>
							<td align=left colspan=3>
								<bean:message bundle="citydata" key="contentExample" />
							</td>
						</tr>
						<tr id="ARPUDATA1" style="display:none">
							<td align=right height=25>
								<bean:message bundle="citydata" key="example" />
							</td>
							<td align=left colspan=3>
								<font color="red">138001388888|</font>
							</td>
						</tr>
						<tr id="ARPUDATA2" style="display:none">
							<td align=right height=25>
								影响酬金类型:
							</td>
							<td align=left colspan=3>
								<c:forEach var="item" items="${requestScope.LIST}" varStatus="items">
								<html:multibox property="_selectitem">
									<c:out value='${item.dictid}'/>
								</html:multibox>
								<c:out value="${item.dictname }"/>
								<c:if test="${items.index>0 && items.index % 2 ==0 }">
								<br>
								</c:if>
								</c:forEach>
								<font color='red'>*</font>
							</td>
						</tr>
						<tr class="table_style_content" id="ARPUDATA4">
							<td align="right" height=25>
								<div class="field-require">
									<bean:message bundle="citydata" key="infectionbuss" />
									:
								</div>
							</td>
							<td align="left" colspan=3>
								<TEXTAREA name="infectionbuss" rows="3" styleClass="form_textarea_on_4" readonly="true" onclick="getRewarBussValues('REWARDBUSSSELECTS',this)" type="_moz">
								</TEXTAREA>
								点击输入框进行选择业务，此框如果为空则表示影响指定酬金的所有业务
							</td>
						</tr>
						
						<tr>
							<td align="right" height=25>
								<div class="field-require">
									<bean:message bundle="citydata" key="remark" />
									:
								</div>
							</td>
							<td align="left" colspan=3>
								<html:textarea property="remark" styleClass="form_textarea_on_4"></html:textarea> <font color="red">*</font>
							</td>
						</tr>

						<tr class="table_style_content" id="BUSIVALIDDATA2">
							<td width="20%" align="right" class="form_table_right">
								<div class="field-require">
									<bean:message bundle="citydata" key="ps" />
									:
								</div>
							</td>
							<td width="75%" align="left" colspan=3>
								<bean:message bundle="citydata" key="psinfo" />
							</td>
						</tr>
						<tr class="table_style_content">
							<td align=right height=25>
								<bean:message bundle="citydata" key="guide" />
							</td>
							<td align=left>
								<a href="<%=contextPath%>/cms/common/importguide.htm"><bean:message bundle="citydata" key="guide" />
								</a>
							</td>
						</tr>
						<tr class="table_style_content" id="BUSIVALIDDATA3">
							<td align=right height=25>
								<bean:message bundle="citydata" key="model" />
							</td>
							<td align=left>
								<a href="<%=contextPath%>/cms/reward/citydata/citydataimport.xls"><bean:message bundle="citydata"
										key="modelname" />
								</a>
								<bean:message bundle="citydata" key="hint" />
							</td>
						</tr>
						
						<tr class="table_style_content" id="ARPUDATA3" stype="display:none">
							<td align=right height=25>
								<bean:message bundle="citydata" key="model" />
							</td>
							<td align=left>
								<a href="<%=contextPath%>/cms/reward/citydata/citydataimport2.xls"><bean:message bundle="citydata"
										key="modelname" />2
								</a>
								<bean:message bundle="citydata" key="hint" />
							</td>
						</tr>
					</table>
				</div>

				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td>
								<input type="button" value="<bean:message bundle="upload" key="upload" />" class="button_2"
									onmouseover="buttonover(this)" onmouseout="buttonout(this)" onfocus="buttonover(this)" onblur="buttonout(this)"
									ID="buttonUpload" NAME="buttonUpload" onClick="check()" />
							</td>
						</tr>
					</table>
				</div>
			</html:form>
		</div>
	</body>
</html>
