<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<html>
	<head>
		<title><s:text name="titleList" />
		</title>
		<script type="text/javascript">
		 function doImport(){			
			formList.action = "<%=contextPath%>/channel/checkedapply_batch.do";
      		formList.submit();
		}
		function doChoosewayid(){
		    var applytype = document.getElementById('param.applytype').value; 
		    var applyeno = document.getElementById('param.applyeno').value;
		    if (applytype=="") {
		      alert('请选择申请类型');
		      return ;
		    }
			
			var strUrl = "<%=contextPath%>/channel/checkedapply/checkedapply_chooseapplyway.do?applytype="+applytype+"&applyeno="+applyeno+"&x="+new Date().getTime();
	     	window.showModalDialog(strUrl , window , "dialogWidth=800px;dialogHeight=680px;status:no;scroll=yes;");
	     	if (applyeno=="") {
	     		formList.action = "<%=contextPath%>/channel/checkedapply_queryByapplytype.do?applytype="+applytype; 
	     	} else {
	     		formList.action = "<%=contextPath%>/channel/checkedapply_applydeatilinfo.do"; 
	     	}	     	
	     	formList.submit();		    
		} 
		function doDelete(){
		  var chooseway = document.getElementsByName("param._selectitem"); 
		   var flag = false;
		      for(var i=0;i<chooseway.length;i++){
			      if(chooseway[i].checked){ 
			        flag=true;
			      }
		      }
		      if(flag==false){
		       alert('必须选择至少一条数据');
		       return;
		      }
		 formList.action = "<%=contextPath%>/channel/checkedapply_delete.do";
      	 formList.submit();
		}
		function doSave(url){
		 var applytype = document.getElementById('param.applytype').value; 
		    if (applytype=="") {
		      alert('申请类型不能为空');
		      return ;
		    }
		 var mobileno = document.getElementById('param.mobileno').value; 
		    if (mobileno=="") {
		      alert('手机号码不能为空');
		      return ;
		    } 
		 formList.action = "<%=contextPath%>"+url+"?applytype="+applytype;
      	 formList.submit();
		}
		
		function doQueryByapplytype(){
		
		var applytype = document.getElementById('param.applytype').value;  
		if (applytype==1 || applytype==0 ){  
		window.location = "<%=contextPath%>/channel/checkedapply/checkedapply_queryByapplytype.do?applytype="+applytype; 
		 }
		}
		</script>

	</head>

	<body class="list_body"
		onload="if(window.loadforiframe) loadforiframe();">
		<div class="table_container">
			<s:form action="checkedapply_splitPage.do" key="formList"
				cssStyle="formList" enctype="multipart/form-data"
			method="post" theme="simple" onsubmit="return ev_check();">
				<%//下面的控件给Action提供数据，用来分页%>
				<aa:zone name="hiddenZone">
					<s:hidden name="param._orderby" />
					<s:hidden name="param._desc" />
					<s:hidden name="param._pageno" />
					<s:hidden name="param._pagesize" />
					<s:hidden name="param.queryAll" />
					<input type="hidden" name="_rowcount"
						value="<s:property value="dp.rowCount" />" /> 
					<input type="hidden" name="applywayid"/>	
					<input type="hidden" name="param.applyeno" value="<s:property value="param.applyeno" />"/>
					<input type="hidden" name="param.appath" value="<s:property value="param.appath" />"/>
					<input type="hidden" name="param.pptpath" value="<s:property value="param.pptpath" />"/>
				</aa:zone>

				<div class="table_top">
					<div class="table_topleft"></div>
					<div class="table_toparea_w">
						<s:i18n name="public">
							<span class="table_toparea"><s:text name="currentPos" />
							</span>
							<span class="table_toparea_xi">></span>
							<span class="table_toparea"><s:text name="channel" /> </span>
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

				<aa:zone name="errorZone">
					<div class="error_text">
						<table class="error_text">
							<s:actionerror />
							<s:actionmessage />
						</table>
					</div>
				</aa:zone>

				<div class="table_div">
					<table class="table_normal">
						<tr>
							<td align="right">
								<s:text name="applytype" />
								:&nbsp
							</td>
							<td align="left">
								<s:if test="ADDUP == 1">
									<j:selector definition="$CH_CHECKTYPE" name="param.applytype" disabled="true"/>
								</s:if> 
								<s:else>
									<s:if test="CMDFLAG == 1">
										<j:selector definition="$CH_CHECKTYPE" name="param.applytype" onchange="doQueryByapplytype();" disabled="true"/>
									</s:if>
									<s:else>
										<j:selector definition="$CH_CHECKTYPE" name="param.applytype" onchange="doQueryByapplytype();" />
									</s:else>									 
								</s:else>
								<font color=red>*</font>
							</td>
							<td align="right">
								<s:text name="cityid" />
								:&nbsp
							</td>
							<td align="left" cssStyle="style_input">
								<j:code2Name code="param.cityid" definition="#CITYCOMPANY" />
							</td>

						</tr>

						<tr>
							<td align="right">
								<s:text name="aptime" />
								:&nbsp
							</td>
							<td align="left">
								<input type="hidden" name="param.aptime" value="<s:date name="param.aptime" format="yyyy-MM-dd HH:mm:ss" />"/>
								<s:date name="param.aptime" format="yyyy-MM-dd HH:mm:ss" />
							</td>
							<td align="right">
								<s:text name="mobileno" />
								:&nbsp
							</td>
							<td align="left">
								<s:textfield cssStyle="style_input" name="param.mobileno"
									maxlength="15" />
								<font color=red>*</font>
							</td>
						</tr>

						<tr>
							
							<td align="right">
								<s:text name="oprcode" />
								:&nbsp
							</td>
							<td align="left">
								<s:property value="param.oprcode" />
							</td>
							<td align="right">
								
							</td>
							<td align="left">
								
							</td>
						</tr>

						<tr>
							<td align="right">
								<s:text name="appath" />
								:&nbsp
							</td>
							<td align="left" colspan="3">
								<s:file name="appathDoc" label="File" />
								<a
									href='<%=contextPath%>/channel/checkedapply/checkedapply_download.do?file=<s:property value="param.appath"/>'
									target="_blank"><s:property value="param.appath"/></a>
							</td>
						</tr>
						<tr>
							<td align="right">
								<s:text name="pptpath" />
								:&nbsp
							</td>
							<td align="left" colspan="3">
								<s:file name="pptpathDoc" label="File" />
								<a
									href='<%=contextPath%>/channel/checkedapply/checkedapply_download.do?file=<s:property value="param.pptpath"/>'
									target="_blank"><s:property value="param.pptpath"/></a>
							</td>
						</tr>
						<tr>
							<td align="right">
								申报表模版:&nbsp
							</td>
							<td align="left" colspan="3">
								<a href="<%=contextPath%>/channel/checkedapply/applymodel.xls">申报表模版.xls</a>
							</td>
						</tr>
						<tr>
							<td align="right">
								申报PPT模版:&nbsp
							</td>
							<td align="left" colspan="3">
								<a
									href="<%=contextPath%>/channel/checkedapply/applypptmodel.ppt">申报PPT模版.ppt</a>
							</td>
						</tr>
						<tr>
							<td align="right">
								<s:text name="memo" />
								:&nbsp
							</td>
							<td align="left" colspan="3">
								<s:if test="CMD != WEB_CMD_SAVE">
									<s:textarea cssStyle="style_input" name="param.memo" cols="64"
										rows="5"></s:textarea>
								</s:if>
								<s:else>
									<s:textarea cssStyle="style_input" name="param.memo" cols="64"
										rows="5"></s:textarea>
								</s:else>
							</td>
						</tr>
					</table>
				</div>

				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td>
								<s:i18n name="public"> 
								 <s:if test="form.status == 1 || form.status == 3">
								   <input type="button" id="btnSelect" name="btnSelect"
										class="button_6" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" onfocus="buttonover(this)"
										onblur="buttonout(this)" value="选择申请网点"
										onClick="doChoosewayid();" disabled="true"/>
										
									<input type="button" id="btnBatch" name="btnBatch"
											class="button_4" onmouseover="buttonover(this);"
											onmouseout="buttonout(this);" onfocus="buttonover(this)"
											onblur="buttonout(this)" value="批量导入" onClick="doImport();" disabled="true"/>
										
									<input type="button" id="btnDelete" name="btnDelete"
										class="button_Delete" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" onfocus="buttonover(this)"
										onblur="buttonout(this)"
										value="<s:text name="button_delete"/>"
										onclick="doReturn('/channel/checkedapply_delete.do')" disabled="true"/>
									  </s:if> 
									  <s:else>
										<input type="button" id="btnSelect" name="btnSelect"
											class="button_6" onmouseover="buttonover(this);"
											onmouseout="buttonout(this);" onfocus="buttonover(this)"
											onblur="buttonout(this)" value="选择申请网点"
											onClick="doChoosewayid();"
											<s:if test="CMDFLAG == 1">disabled = "true"</s:if>/>

										<input type="button" id="btnBatch" name="btnBatch"
											class="button_4" onmouseover="buttonover(this);"
											onmouseout="buttonout(this);" onfocus="buttonover(this)"
											onblur="buttonout(this)" value="批量导入" onClick="doImport();"
											<s:if test="CMDFLAG == 1">disabled = "true"</s:if>
											/>
										
										<input type="button" id="btnDelete" name="btnDelete"
											class="button_Delete" onmouseover="buttonover(this);"
											onmouseout="buttonout(this);" onfocus="buttonover(this)"
											onblur="buttonout(this)"
											value="<s:text name="button_delete"/>"
											onclick="doDelete()"
											<s:if test="CMDFLAG == 1">disabled = "true"</s:if>/>
										</s:else>
								</c:choose>
								</s:i18n>
							</td>
						</tr>
					</table>
				</div>

				<aa:zone name="listZone">
					<div class="table_div">
						<div class="table_LongTable">
							<table class="table_style">
								<tr class="table_style_head">
								    <td title="<s:text name="list_title_select"/>">
										<input type="checkbox" name="allbox" onclick="checkAll();"
											class="table_checkbox">
									</td>
									<td>
										 地市公司
									</td>
									<td>
										网点类型
									</td>
									<td>
										所属合作商
									</td>
									<td>
										网店名称
									</td>
									<td>
										渠道编码
									</td>
									<td>
										详细地址
									</td>
									<td>
										商圈类型
									</td>
									<td>
									    考核方式
									</td>
									<td>
									    星级评定
									</td>
									<td>
									   申请类型
									</td>
								</tr>
								<s:iterator value="dp.datas" id="XXXXXXXXXXXXXX">
									<tr class="table_style_content" align="center"
										onMouseMove="this.bgColor='F0F5F9'"
										onMouseOut="this.bgColor='#ffffff'">
										<td>
										<input type="checkbox" name="param._selectitem"
											value="<s:property value="seq"/>" onclick="checkOne();">
									</td>
										<td> 
											<j:code2Name code="cityid" definition="#CITYCOMPANY" />
										</td>
										<td> 
											<j:code2Name code="wtype" definition="$CH_WTYPE"/>
										</td>
										<td>
											<j:code2Name code="chainhead" definition="#WAYIDINFO"/>
										</td>
										<td>
											<s:property value="wayname" />
										</td>
										<td>
											<s:property value="wayid" />
										</td>
										<td>
											<s:property value="address"/>
										</td>
										<td>
											<j:code2Name code="buztypecode" definition="$CH_BUZTYPE" />
										</td>
										<td>
											<j:code2Name code="chktype" definition="$CH_ASSESSMTHD" />
										</td>
										<td>
											<j:code2Name code="starlevel" definition="$CH_STARLEVEL" />
										</td>
										<td>
											<j:code2Name code="applytype" definition="$CH_CHECKTYPE" />
										</td>
										
									</tr>
								</s:iterator>
							</table>
						</div>
					</div>
					<div class="table_div">
						<%@ include file="/common/pageNav.jsp"%>
					</div>
					<div class="table_div">
					<table >
						<tr>
							<td>
									<s:i18n name="public">
										<s:if test="form.status == 1 || form.status == 3">
											<input type="button" id="btnSubmit" name="btnCmmit"
												class="button_Save" onmouseover="buttonover(this);"
												onmouseout="buttonout(this);" onfocus="buttonover(this)"
												onblur="buttonout(this)" value="提交"
												onClick="doSave('/channel/checkedapply_save.do');"
												disabled="true"/>
										</s:if>
										<s:else>
											<input type="button" id="btnSubmit" name="btnCmmit"
												class="button_Save" onmouseover="buttonover(this);"
												onmouseout="buttonout(this);" onfocus="buttonover(this)"
												onblur="buttonout(this)" value="提交"
												onClick="doSave('/channel/checkedapply_save.do');"
												<s:if test="CMDFLAG == 1">disabled = "true"</s:if>/>
										</s:else>
										   <input type="button" id="btnReturn" name="btnReturn"
											    class="button_Back" onmouseover="buttonover(this);"
											    onmouseout="buttonout(this);" onfocus="buttonover(this)"
											    onblur="buttonout(this)"
											    value="<s:text name="button_return"/>"
											    onclick="doReturn('/channel/checkedapply_list.do')">
									</s:i18n>
								</td>
						</tr>
					</table>
				</div>
				</aa:zone>
			</s:form>
		</div>
	</body>
</html>
<script language="javascript"> 
	ajaxAnywhere.getZonesToReload = function(url,submitButton) {
		return "errorZone,listZone,hiddenZone";  
	}
	ajaxAnywhere.substituteFormSubmitFunction();  
	ajaxAnywhere.formURL = formList.action;
	//ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnQuery,btnDelete");
</script>
<script language="JavaScript" type="text/JavaScript">
	function ev_check() {
		addfield('param._ne_applyno', '<s:text name="applyno"/>', 'f', true, '14');
		addfield('param._se_cityid', '<s:text name="cityid"/>', 'c', true, '3'); 
		addfield('param._se_applytype', '<s:text name="applytype"/>', 'c', false, '2');
		addfield('form.applytype','<s:text name="form.applytype"/>','f',true,'2');
		return checkval(window);
	}
</script>
