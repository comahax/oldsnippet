<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>

<html>
	<head>
		<title><s:text name="titleList" /></title>
		<script type="text/javascript"
			src="<%=contextPath%>/js/bus/pwaycommon.js"></script>
		<script language="JavaScript" type="text/JavaScript">
		function ev_check() {
            return checkval(window);
        }
         // 检查所属合作商是否存在      
        function checkchained(){
       	
        	var ckytype = document.all("param.chktype").value;
        	var selectitem = document.getElementsByName("param._selectitem");
        	var wayids = "";	
        	var wayid;//选中的渠道编码    
	        for (var i = 0; i < selectitem.length; i++) {
	        	var e = selectitem[i];
	        	if (e.type == 'checkbox') {
	            	if (e.checked){
	                	wayid = e.value;
	                    wayids=wayids+wayid+"|";
	                    
	                }
	            }
	        }
        	var resultFlag = true;
        	$.ajax({
			 type: "POST",
			 url: contextPath+"/channel/checkedapply/checkedapply_checkchained.do",
			 data:   "param.chktype="+ ckytype + "&param.selectw="+wayids,
			 async: false,
			 success: function(result){
				 if(result != ''){
	       				var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'> ' +result+ '</span> <span style=\'color:#F00; font-size:12px;\'></span>';
						errorMessageShow(alertstr);
						resultFlag = false;
				}		
			}
			});
			return resultFlag;
        }
        
		function doSelect(){
		   var chooseway = document.getElementsByName("param._selectitem"); 
		   var ckytype = document.all("param.chktype").value;
		   var flag = false;
		   var chflag = false;
		   for(var i=0;i<chooseway.length;i++){
		     if(chooseway[i].checked){ 
		           flag=true;
		      }
		   }
		   
		   if (ckytype==null || ckytype=='') {
		   		alert('考核方式不能为空');
		   } else {
			    if(flag == false){
			          alert('必须选择至少一条数据');
			    }else{
			    	if (checkchained()) {
					   	chflag = true;
					} 
			    	if (chflag) {
			    		formList.action = "<%=contextPath%>/channel/checkedapply/checkedapply_savedetail.do?applytype=0";  
			            formList.submit(); 
				        //window.close();
			    	}
			          
			   }
		   }
		}
		</script>
	</head>

	<body class="list_body">
		<div class="table_container">
			<s:form action="checkedapply_doQueryWayinfoForapplyway.do" key="formList" cssStyle="formList"
				theme="simple" onsubmit="return ev_check();">
				<s:hidden name="flag"/>
				<aa:zone name="hiddenZone">
					<s:hidden name="param._orderby" />
					<s:hidden name="param._desc" />
					<s:hidden name="param._pageno" />
					<s:hidden name="param._pagesize" />
					<s:hidden name="param.queryAll" />
					<s:hidden name="applytype" value="0"/>
					<input type="hidden" name="param.applyeno" value="<s:property value="param.applyeno" />"/>
					<input type="hidden" name="param.appath" value="<s:property value="param.appath" />"/>
					<input type="hidden" name="param.pptpath" value="<s:property value="param.pptpath" />"/>
					<input type="hidden" name="_rowcount"
						value="<s:property value="dp.rowCount" />" />
				</aa:zone>

				<!--##################################添加标题内容，里面可以放置按钮##################################################-->
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
						<span class="table_toparea_h">选择网点
						</span>
						<span class="button_Help"
							onclick="openword('<s:text name="helpTitle"/>','<s:text name="helpList"/>')"><s:i18n
								name="public">
								<s:text name="help" />
					</s:i18n> </span>
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

				<!--#################################添加标题内容，里面可以放置按钮###################################################-->
				<div class="table_div">
					<table class="table_normal">
						<tr>
							<td align="center">
								考核方式
								:
							</td>
							<td align="left">
								<j:selector definition="$CH_ASSESSMTHD"
									name="param.chktype" />
								<font color=red>*</font>
							</td>
							<td align="left" colspan="2"> 
							</td>
						</tr>
						<tr>
							<td align="center">
								<s:text name="wayid" />
								:
							</td>
							<td align="left">
								<s:textfield cssStyle="style_input" name="param._sk_wayid" />
								<input type="button" value="..." class="picker_button"
									onclick="pshowSelectWay3(this,'param._sk_wayid','','','AG');this.value='...';" />
							</td>
							<td align="center">
								<s:text name="wayname" />
								:
							</td>
							<td align="left">
								<s:textfield cssStyle="style_input" name="param._sk_wayname" />
							</td>
						</tr>
					</table>
				</div>
				
				<div class="table_div">
					<table class="table_button_list">
						<tr>
							<td>
								<s:i18n name="public">
									<!--按钮的左中右位置分别为 form_table_left、form_table_center、form_table_right-->
									<input type="button" id="btnQuery" name="btnQuery"
										class="button_Query" onmouseover="buttonover(this);"
										onmouseout="buttonout(this);" onfocus="buttonover(this)"
										onblur="buttonout(this)" value="查询"
										>
								</s:i18n>
							</td>
						</tr>
					</table>
				</div>
				
				<br/>
				<br/>
				<aa:zone name="listZone">
					<div class="table_div">
						<div class="table_LongTable">
							<table class="table_style">
								<tr class="table_style_head">
									<s:i18n name="public">
										<td title="<s:text name="list_title_select"/>">
											<input type="checkbox" name="allbox" onclick="checkAll();" />
										</td>
									</s:i18n>
									<td>
										渠道编码
									</td>
									<td>
										渠道名称
									</td>
									<td>
										渠道状态
									</td>
								</tr>
								<s:iterator value="dp.datas">
									<tr class="table_style_content" align="center"
										onMouseMove="this.bgColor='F0F5F9'"
										onMouseOut="this.bgColor='#ffffff'">
										<td>
											<input type="checkbox" name="param._selectitem"
												value="<s:property value="wayid"/>" onclick="checkOne();">
										</td>
										<td>
											<s:property value="wayid" />
										</td>
										<td>
											<s:property value="wayname" />
										</td>
										<td>
											<j:code2Name code="waystate" definition="$CH_WAYSTATE" />
										</td>
									</tr>
								</s:iterator>
							</table>
						</div>
					</div>

					<div class="table_div">
						<%@ include file="/common/pageNav.jsp"%>
					</div>
				</aa:zone>
			</s:form>
		</div>
		<div class="table_div">
			<table >
				<tr>
					<td align="center">
							<input type="button" id="btnSelect" name="btnSelect"
								class="button_4" onmouseover="buttonover(this);"
								onmouseout="buttonout(this);" onfocus="buttonover(this)"
								onblur="buttonout(this)"
								value="选择提交"
								onClick="doSelect();"
								<s:if test="CMDFLAG == 1">disabled = "true"</s:if>/>
					<input type="button" id="noticeOneCancel" name="noticeOneCancel" class="button_4" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="返回" onClick="window.close();"/>
					</td>
				</tr>
			</table>
		</div>
		<script language="javascript"> 
	ajaxAnywhere.getZonesToReload = function(url,submitButton) {
		return "errorZone,listZone,hiddenZone";  
	}
	ajaxAnywhere.substituteFormSubmitFunction();ajaxAnywhere.formURL = formList.action;  
	ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnQuery,btnDelete");
</script>
	</body>
</html>
