<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<%@ taglib prefix="j" uri="/jop-tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
	<head>
		<title><s:text name="titleName"/></title>
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
    		addItem();
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
				   			nameStr = nameStr + this.dictname + ",";
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
						str = str + "<option value=\"" + valArray[i] + "\" dictname=\"" + nameArray[i] + "\">" + valArray[i] + "-" +nameArray[i]+ "</option>";
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
				str = str + this.dictname + ",";
			});
			window.returnValue = str;
			window.close();
		}
		
		//取消
		function doClose() {
			window.returnValue = 'NULL';
			window.close();
		}  
		
		//回调处理
	   
       // ajaxAnywhere.onAfterResponseProcessing = nativeCallBack;
       // function nativeCallBack()
      //   {  
      //   		$("#s1").prepend('<option value="-1">...</option>'); 
      //  }
		
		$(document).ready(function(){ 
			//获取选择数据
			var selectedStr = window.dialogArguments.document.getElementById("selectedStr").value;
			
			$("#selectedStr").val(selectedStr);
			if(selectedStr!="")
			{
				url = "/common/productcategoryselect_categoryListSel.do";
				ajaxAnywhere.submitByURL(contextPath + url); 
			}
		});
    	</script>
	</head>

	<body>
		<s:form action="/commons/productcategoryselect_categoryList.do" key="formList" cssStyle="formList" theme="simple" method="post" enctype="multipart/form-data">
			<s:hidden name="form.selectedStr" id="selectedStr"/> 
			
			<iframe name='hidden_frame' id="hidden_frame" style="display:none"></iframe>
			<div class="error_text">
				<table class="error_text">
					<s:actionerror /><s:actionmessage/>
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
									<select name="s1" id="s1" class="multi" multiple="true" size="20" style="width:300px;height:300px;" ondblclick="operItem(this);">
										<s:iterator value="#request.objList">
											<option value="<s:property value="dictid"/>" dictname="<s:property value="dictname"/>" leafFlag="1">
												<s:property value="dictid"/>-<s:property value="dictname"/>
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
								<select name="s2" id="s2" class="multi" multiple="true" size="20" style="width:300px;height:300px;" ondblclick="outItem(this);">
									<s:iterator value="#request.dataList">
										<option value="<s:property value="dictid"/>" dictname="<s:property value="dictname"/>">
											<s:property value="dictid"/>-<s:property value="dictname"/>
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
