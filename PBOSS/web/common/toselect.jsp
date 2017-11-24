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
        
        //����ѡ��
        function operItem()
        {  
    		addItem();
        }
        
		//���Ӳ���ѡ��
        function addItem() {
			var str = "";
			if($("#s1").val()!=null)
			{
				//���ѡȡ��ֵ����","ƴ�ӳ��ַ������������ظ���ѡ��
				var valStr = "";
				var nameStr = "";
				
				var dataLength = $("#s2").children().length;
				var dataArray = new Array(dataLength);
				$("#s2").children().each(function(i){
					dataArray[i] = this.value;
				});
				
				//�ظ���ʶ
				var hasMul; 
				
				//��ȡѡȡֵ�ַ���
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
				    	
				    	//�����ظ��������ѡ���ַ���
				    	if(!hasMul)
				    	{
				    		valStr = valStr + this.value + ",";
				   			nameStr = nameStr + this.dictname + ",";
				    	}
				    }
				});
				
				//����ѡȡֵ����ѡ��
				if(valStr.length>0)
				{
					//ȥ��ĩβ��","
					valStr = valStr.substring(0,valStr.length-1);
					nameStr = nameStr.substring(0,nameStr.length-1);
					
					//��̬����ѡ��
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
        
        //����ȫ��ѡ��
        function addAllItem() {
			$("#s1").children().each(function(i){
				$(this).attr("selected",true);
			});
			addItem();
			$("#s1").children().each(function(i){
				$(this).attr("selected",false);
			});
        }
        
        //�Ƴ�����ѡ��
        function outItem() {
			$("#s2").children().each(function(i){
				if(this.selected)
			    {
			    	$(this).remove();
			    }
			});
        }
        
        //�Ƴ�ȫ��ѡ��
        function outAllItem() {
			$("#s2").children().each(function(i){
				$(this).remove();
			});
        }
        
        //����
		window.returnValue = '';
		function doConfirm() {
			var str = "";
			$("#s2").children().each(function(i){
				str = str + this.dictname + ",";
			});
			window.returnValue = str;
			window.close();
		}
		
		//ȡ��
		function doClose() {
			window.returnValue = 'NULL';
			window.close();
		}  
		
		//�ص�����
	   
       // ajaxAnywhere.onAfterResponseProcessing = nativeCallBack;
       // function nativeCallBack()
      //   {  
      //   		$("#s1").prepend('<option value="-1">...</option>'); 
      //  }
		
		$(document).ready(function(){ 
			//��ȡѡ������
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
			                           value="ȷ��" onclick="doConfirm()"/>
			                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
			                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
			                           value="�ر�" onclick="doClose()"/>
							</td>
					</table>
				</div>
			</div>
		</s:form>
	</body>
</html>
