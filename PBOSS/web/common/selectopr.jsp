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
        
        //����ѡ��
        function operItem()
        {
        	//������һ�㼶
        	if($("#s1").val()=="-1")
    		{
    			goback();
    			return;
    		}
        
        	//����һ�㼶��������ѡ��
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
				//�㼶��ʶ
				var level = $("#level").val();
				
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
				   			nameStr = nameStr + this.employeename + ",";
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
						str = str + "<option value=\"" + valArray[i] + "\" employeename=\"" + nameArray[i] + "\">" + valArray[i] + " [" +nameArray[i] + "]" + "</option>";
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
				str = str + this.value + " " + this.employeename + ",";
			});
			window.returnValue = str;
			window.close();
		}
		
		//ȡ��
		function doClose() {
			window.returnValue = 'NULL';
			window.close();
		}
		
		function searchItem()
		{
			if(ev_check())
			{
				//�㼶��Ϊ"0"
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
			//�ж�ѡ��������Ƿ��б仯
			var changeFlag = getChangeFlag();
			if(changeFlag)
			{
				//���ò���
				resetParam();
				
				//��ѯ�б�
				searchItem();
			}
		}
		
		//�ж�ѡ��������Ƿ��б仯
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
			//���ò���
			$("#employeeid").val("");
			$("#employeename").val("");
			$("#isnet").val("");
			$("#officetel").val("");
			
			$("#wayid").val("");
			$("#wayname").val("");
			
			$("#groupid").val("");
			$("#groupname").val("");
				
			//�㼶��Ϊ"0"
			$("#level").val("0");
			
			//����б�
			$("#s1").html("");
		}
		
		function goback()
		{
			//���
			$("#s1").html("");
			
			//�㼶��Ϊ"0"
			$("#level").val("0");
			
			searchItem();
		}
		
		//�ص�����
        ajaxAnywhere.onAfterResponseProcessing = nativeCallBack;
        function nativeCallBack()
        {
        	if($("#level").val()!="0")
        	{
        		$("#s1").prepend('<option value="-1">...</option>');
        	}
        }
		
		$(document).ready(function(){
			//��ʼ������Ϊ"0"����Ϊ������Աѡ��
			$("#type").val("0");
			
			//��ʼ��ѡ��㼶Ϊ"0"
			$("#level").val("0");
			
			//��ȡѡ������
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
		                	<input type="radio" name="form.paramType" class="paramType" value="0" onclick="showItem()" checked="checked">���������˼���Ա
		                	<input type="radio" name="form.paramType" class="paramType" value="1" onclick="showItem()">����
		                	<input type="radio" name="form.paramType" class="paramType" value="2" onclick="showItem()">Ⱥ��
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
