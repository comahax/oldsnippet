<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<%@ taglib prefix="j" uri="/jop-tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
	<head>
		<title><s:text name="title"/></title>
		<base target="_self" />
		<script type="text/javascript" src="<%=contextPath%>/js/bus/pwaycommon.js"></script>
		<script language="JavaScript" type="text/JavaScript">
		function ev_check() {
            addfield('form.groupid', '<s:text name="groupid"/>', 'l', true, 14);
            return checkval(window);
        }
        
        //操作选项
        function operItem()
        {
        	//返回上一层级
        	if($("#s1").val()=="-1")
    		{
    			goback();
    			return;
    		}
        
        	//到下一层级或者增加选项
        	var type = $("#type").val();
        	var level = $("#level").val();
        	
        	if(type=="1" && level=="0")
        	{
        		$("#level").val("1");
        		$("#wayidIn").val($("#s1").val());
        		url = "/common/multiselect_showwayobj.do";
				ajaxAnywhere.submitByURL(contextPath + url);
        	}
        	else if(type=="2" && level=="0")
        	{
        		$("#level").val("1");
        		$("#groupidIn").val($("#s1").val());
        		url = "/common/multiselect_showgroupobj.do";
				ajaxAnywhere.submitByURL(contextPath + url);
        	}
        	else
        	{
        		addItem();
        	}
        }
        
		//增加部分选项
        function addItem() {
			var str = "";
			if($("#s1").val()!=null)
			{
				//获得选取的值，以","拼接成字符串，并过滤重复的选项
				var valStr = "";
				var nameStr = "";
				
				var dataLength = $("#s2").children().length;
				var dataArray = new Array(dataLength);
				$("#s2").children().each(function(i){
					dataArray[i] = this.value;
				});
				
				//重复标识
				var hasMul;
				//层级标识
				var level = $("#level").val();
				
				//获取选取值字符串
				$("#s1").children().each(function(i){
					if(this.selected && this.value!="-1" && this.leafFlag=="1")
				    {
				    	hasMul = false;
				    	for(var j=0; j<dataLength; j++)
				    	{
				    		if(this.value==dataArray[j])
				    		{
				    			hasMul = true;
				    		}
				    	}
				    	
				    	//将不重复的添加至选择字符串
				    	if(!hasMul)
				    	{
				    		valStr = valStr + this.value + ",";
				   			nameStr = nameStr + this.employeename + ",";
				    	}
				    }
				});
				
				//根据选取值生成选项
				if(valStr.length>0)
				{
					//去掉末尾的","
					valStr = valStr.substring(0,valStr.length-1);
					nameStr = nameStr.substring(0,nameStr.length-1);
					
					//动态生成选项
					var valArray = valStr.split(",");
					var nameArray = nameStr.split(",");
					for(var i=0; i<valArray.length; i++)
					{
						str = str + "<option value=\"" + valArray[i] + "\" employeename=\"" + nameArray[i] + "\">" + valArray[i] + " [" +nameArray[i] + "]" + "</option>";
					}
					$("#s2").append(str);
				}
			}
			
        }
        
        //增加全部选项
        function addAllItem() {
			$("#s1").children().each(function(i){
				$(this).attr("selected",true);
			});
			addItem();
			$("#s1").children().each(function(i){
				$(this).attr("selected",false);
			});
        }
        
        //移除部分选项
        function outItem() {
			$("#s2").children().each(function(i){
				if(this.selected)
			    {
			    	$(this).remove();
			    }
			});
        }
        
        //移除全部选项
        function outAllItem() {
			$("#s2").children().each(function(i){
				$(this).remove();
			});
        }
        
        //返回
		window.returnValue = '';
		function doConfirm() {
			var str = "";
			$("#s2").children().each(function(i){
				str = str + this.value + " " + this.employeename + ",";
			});
			window.returnValue = str;
			window.close();
		}
		
		//取消
		function doClose() {
			window.returnValue = 'NULL';
			window.close();
		}
		
		function searchItem()
		{
			if(ev_check())
			{
				//层级置为"0"
				$("#level").val("0");
				
				var type = $("#type").val();
				
				var url = "";
				if(type=="0")
				{
					$("#objTable").show();
					$("#wayTable").hide();
					$("#groupTable").hide();
					url = "/common/multiselect_showopr.do";
					ajaxAnywhere.submitByURL(contextPath + url);
				}
				else if(type=="1")
				{
					$("#objTable").hide();
					$("#wayTable").show();
					$("#groupTable").hide();
					url = "/common/multiselect_showway.do";
					ajaxAnywhere.submitByURL(contextPath + url);
				}
				else if(type=="2")
				{
					$("#objTable").hide();
					$("#wayTable").hide();
					$("#groupTable").show();
					url = "/common/multiselect_showgroup.do";
					ajaxAnywhere.submitByURL(contextPath + url);
				}
			}
		}
		
		function showItem()
		{
			//判断选择的类型是否有变化
			var changeFlag = getChangeFlag();
			if(changeFlag)
			{
				//重置参数
				resetParam();
				
				//查询列表
				searchItem();
			}
		}
		
		//判断选择的类型是否有变化
		function getChangeFlag()
		{
			var type = $("#type").val();
			var changeFlag = false;
			$("#paramTypeTd .paramType").each(function(i){
				if(this.checked)
				{
					if(type!=this.value)
					{
						changeFlag = true;
						$("#type").val(this.value);
						return;
					}
				}
			});
			return changeFlag;
		}
		
		function resetParam()
		{
			//重置参数
			$("#employeeid").val("");
			$("#employeename").val("");
			$("#isnet").val("");
			$("#officetel").val("");
			
			$("#wayid").val("");
			$("#wayname").val("");
			
			$("#groupid").val("");
			$("#groupname").val("");
				
			//层级置为"0"
			$("#level").val("0");
			
			//清空列表
			$("#s1").html("");
		}
		
		function goback()
		{
			//清空
			$("#s1").html("");
			
			//层级置为"0"
			$("#level").val("0");
			
			searchItem();
		}
		
		//回调处理
        ajaxAnywhere.onAfterResponseProcessing = nativeCallBack;
        function nativeCallBack()
        {
        	if($("#level").val()!="0")
        	{
        		$("#s1").prepend('<option value="-1">...</option>');
        	}
        }
		
		$(document).ready(function(){
			//初始化类型为"0"，即为渠道人员选择
			$("#type").val("0");
			
			//初始化选框层级为"0"
			$("#level").val("0");
			
			//获取选择数据
			var selectedStr = window.dialogArguments.document.getElementById("selectedStr").value;
			$("#selectedStr").val(selectedStr);
			if(selectedStr!="")
			{
				url = "/common/multiselect_showoprSel.do";
				ajaxAnywhere.submitByURL(contextPath + url);
			}
		});
    	</script>
	</head>

	<body>
		<s:form action="/commons/multiselect_showopr.do" key="formList" cssStyle="formList" theme="simple" method="post" enctype="multipart/form-data">
			<s:hidden name="form.selectedStr" id="selectedStr"/>
			
			<s:hidden name="type" id="type"/>
			<s:hidden name="level" id="level"/>
			<s:hidden name="form.wayidIn" id="wayidIn"/>
			<s:hidden name="form.groupidIn" id="groupidIn"/>
			
			<iframe name='hidden_frame' id="hidden_frame" style="display:none"></iframe>
			<div class="error_text">
				<table class="error_text">
					<s:actionerror /><s:actionmessage/>
				</table>
			</div>
			
			<div class="table_div">
				<table class="table_normal">
		            <tr>
		                <td align="left" id="paramTypeTd">
		                	<input type="radio" name="form.paramType" class="paramType" value="0" onclick="showItem()" checked="checked">渠道负责人及店员
		                	<input type="radio" name="form.paramType" class="paramType" value="1" onclick="showItem()">渠道
		                	<input type="radio" name="form.paramType" class="paramType" value="2" onclick="showItem()">群组
		                </td>
		            </tr>
		        </table>
		    </div>
			<div class="table_div">
		        <table class="table_normal" id="objTable">
		            <tr>
		                <td align="center" width="20%"><s:text name="objid"/>:</td>
		                <td align="left" width="30%">
		                	<input class="style_input" name="form.employeeid" id="employeeid"/>
		                </td>
		                <td align="center" width="20%"><s:text name="objname"/>:</td>
		                <td align="left" width="30%">
		                	<input class="style_input" name="form.employeename" id="employeename"/>
		                </td>
		            </tr>
		            <tr>
		                <td align="center"><s:text name="isnet"/>:</td>
		                <td align="left">
		                	<j:selector definition="$CH_ISNET" theme="simple" name="form.isnet" id="isnet"/>
		                </td>
		                <td align="center"><s:text name="officetel"/>:</td>
		                <td align="left">
		                	<input class="style_input" name="form.officetel" id="officetel"/>
		                </td>
		            </tr>
		        </table>
		        <table class="table_normal" id="wayTable" style="display: none">
		            <tr>
		                <td align="center" width="20%"><s:text name="wayid"/>:</td>
		                <td align="left" width="30%">
		                	<input class="style_input" name="form.wayid" id="wayid"/>
		                	<input type="button" value="..." class="picker_button" onclick="pshowSelectWay3(this,'form.wayid','','','AG');this.value='...';" />
		                </td>
		                <td align="center" width="20%"><s:text name="wayname"/>:</td>
		                <td align="left" width="30%">
		                	<input class="style_input" name="form.wayname" id="wayname"/>
		                </td>
		            </tr>
		        </table>
		        <table class="table_normal" id="groupTable" style="display: none">
		            <tr>
		                <td align="center" width="20%"><s:text name="groupid"/>:</td>
		                <td align="left" width="30%">
		                	<input type="text" name="form.groupid" id="groupid"/>
		                	<input type="button" name="form.groupid_button" class="picker_button" value="..." onclick="javascript:openPicker(this,'#ADVGROUP','');">
		                </td>
		                <td align="center" width="20%"><s:text name="groupname"/>:</td>
		                <td align="left" width="30%">
		                	<input class="style_input" name="form.groupname" id="groupname"/>
		                </td>
		            </tr>
		        </table>
		    </div>
		    
		    <div class="table_div">
				<table class="table_button_list">
					<tr>
						<td>
		                	<s:i18n name="public">
		                		<input type="button" id="btnQuery" name="btnQuery" class="button_Query" onmouseover="buttonover(this);"
		                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
		                        value="<s:text name="button_search"/>" onClick="searchItem()">
		                   </s:i18n>
						</td>
					</tr>
				</table>
			</div>
			
			<div class="table_container">
				<div class="table_div">
					<table class="table_style">
						<tr class="table_style_content">
							<td align=left>
								<s:text name="selectItem"/>
							</td>
							<td align=left></td>
							<td align=left>
								<s:text name="selectedItem"/>
							</td>
						</tr>
						<tr class="table_style_content">
							<td align=left>
								<aa:zone name="zoneSource">
								<div>
									<select name="s1" id="s1" class="multi" multiple="true" size="20" style="width:280px;height:180px;" ondblclick="operItem(this);">
										<s:iterator value="#request.wayList">
											<option value="<s:property value="wayid"/>" wayname="<s:property value="wayname"/>" leafFlag="0">
												<s:property value="wayid"/> [<s:property value="wayname"/>]
											</option>
										</s:iterator>
										<s:iterator value="#request.groupList">
											<option value="<s:property value="groupid"/>" groupname="<s:property value="groupname"/>" leafFlag="0">
												<s:property value="groupid"/> [<s:property value="groupname"/>]
											</option>
										</s:iterator>
										<s:iterator value="#request.objList">
											<option value="<s:property value="employeeid"/>" employeename="<s:property value="employeename"/>" leafFlag="1">
												<s:property value="employeeid"/> [<s:property value="employeename"/>]
											</option>
										</s:iterator>
									</select>
								</div>
								</aa:zone>
							</td>
							<td align=left>
								<br />
								<input type="button" value=">" style="width:50px; height:20px; background-color:#ffffff" onclick="addItem()" />
								<br />
								<input type="button" value=">>" style="width:50px; height:20px; background-color:#ffffff" onclick="addAllItem()" />
								<br />
								<br />
								<input type="button" value="<" style="width:50px; height:20px; background-color:#ffffff" onclick="outItem()" />
								<br />
								<input type="button" value="<<" style="width:50px; height:20px; background-color:#ffffff" onclick="outAllItem()" />
								<br />
							</td>
							<td align="left">
								<aa:zone name="zoneData">
								<select name="s2" id="s2" class="multi" multiple="true" size="20" style="width:280px;height:180px;" ondblclick="outItem(this);">
									<s:iterator value="#request.dataList">
										<option value="<s:property value="employeeid"/>" employeename="<s:property value="employeename"/>">
											<s:property value="employeeid"/> [<s:property value="employeename"/>]
										</option>
									</s:iterator>
								</select>
								</aa:zone>
							</td>
						</tr>
						<tr class="table_style_content">
							<td colspan="3" align="center">
								<input type="button" id="btnSave" name="btnSave" class="button_Save" onmouseover="buttonover(this);" 
			                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
			                           value="确定" onclick="doConfirm()"/>
			                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
			                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
			                           value="关闭" onclick="doClose()"/>
							</td>
					</table>
				</div>
			</div>
		</s:form>
	</body>
</html>
