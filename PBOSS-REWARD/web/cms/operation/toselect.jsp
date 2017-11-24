<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ taglib uri="http://ajaxanywhere.sourceforge.net/" prefix="aa" %>
<%@ include file="/inc/listhead.inc" %>

<html>
	<head>
		<title><bean:message bundle="operation" key="title"/></title>
		<script type="text/javascript" src="<%=contextPath%>/js/bus/waycommon.js"></script>
		<script type="text/javascript" src="<%=contextPath%>/js/jquery/jquery-1.3.2.js"></script>
		<script type="text/javascript" src="<%=contextPath%>/js/aa.js"></script>
		<script language="JavaScript" type="text/JavaScript">
        
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
				str = str + this.value + "-"+this.dictname + ",";
			});
			window.returnValue = str;
			window.close();
		}
		
		//ȡ��
		function doClose() {
			window.returnValue = 'NULL';
			window.close();
		}  
		$(document).ready(function(){ 
			//��ȡѡ������
			//var selectedStr = window.dialogArguments.document.getElementById("_sin_opnid").value; 
			var selectedStr;
			var _sin_opnid = window.dialogArguments.document.getElementById("_sin_opnid");
			if(_sin_opnid!=null){//�˵������г����ϸ�ϴ��������������й�˾���ȷ�Ϸ�������
				selectedStr = _sin_opnid.value;
			}else{//�˵�����������ϸ��ѯ��
				selectedStr = window.dialogArguments.document.getElementById("_se_opnid").value; 
			}
			 
			document.getElementById('selectedStr').value=selectedStr;
		  if(selectedStr!="")
			{  
				ajaxAnywhere.submitByURL("/cms/cityrecord.do?CMD=ALLFIFTHOPNIDSSEL"); 
			}
		}); 
      function dosubmit(){
	       ajaxAnywhere.submitByURL("/cms/cityrecord.do?CMD=ALLFIFTHOPNIDS"); 
        }
    	</script>
	</head>

	<body>
		<html:form action="/cms/cityrecord.do?CMD=ALLFIFTHOPNIDS"  styleId="formList"  method="post" >
			<html:hidden property="_orderby"/>
		    <html:hidden property="_desc"/>
		    <html:hidden property="_pageno"/>
		    <html:hidden property="_pagesize"/>
		    <html:hidden property="selectedStr"/>
			<c:set var="form" scope="request" value="${requestScope['/cms/operation/OperationForm']}"/>
			<iframe name='hidden_frame' id="hidden_frame" style="display:none"></iframe>
			<div class="error_text">
				<table class="error_text">
					<html:errors/><s:Msg />
				</table>
			</div>  
			
			<div class="table_div">
		        <table class="form_table">
		            <tr>
		            	<td width="30%" class="form_table_right">ҵ�����:</td>
		                <td width="45%" class="form_table_left">
		                    <html:text styleClass="form_input_1x" property="_sk_opnid"  maxlength="18"></html:text>
		                </td>
		                <td width="25%" >
		                 	<input type="button" class="query" onmouseover="buttonover(this);"
		                                onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
		                                value="<bean:message bundle="public" key="button_search"/>" onclick="dosubmit()"/>
		        		</td>
		            </tr>
		        </table>
		    </div>
			
			
			<div class="table_container">
				<div class="table_div">
					<table class="table_style">
						<tr class="table_style_content">
							<td align=left>
								��ѡ��
							</td>
							<td align=left></td>
							<td align=left>
								��ѡ��
							</td>
						</tr>
						<tr class="table_style_content">
							<td align=left>
								<aa:zone name="zoneData">
								<div>
									<select name="s1" id="s1" class="multi" multiple="true" size="20" style="width:300px;height:300px;" ondblclick="operItem(this);">
										 <c:forEach var="item" items="${requestScope.objList.datas}">
										 	<option value="<c:out value="${item.opnid}"/>" dictname="<c:out value="${item.name}"/>" leafFlag="1">
												<c:out value="${item.opnid}"/>-<c:out value="${item.name}"/>
											</option>
										 </c:forEach>
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
								<aa:zone name="zoneResource">
								<select name="s2" id="s2" class="multi" multiple="true" size="20" style="width:300px;height:300px;" ondblclick="outItem(this);">
									<c:forEach var="item" items="${requestScope.dataList.datas}">
										 	<option value="<c:out value="${item.opnid}"/>" dictname="<c:out value="${item.name}"/>" leafFlag="1">
												<c:out value="${item.opnid}"/>-<c:out value="${item.name}"/>
											</option>
									</c:forEach>
								</select>
								</aa:zone>
							</td>
						</tr>
						<tr class="form_table_right">
							<td colspan="3" align="center">
								<input type="button" id="btnSave" name="btnSave" class="button_Save" onmouseover="buttonover(this);" 
			                           onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
			                           value="ȷ��" onclick="doConfirm()"/>
			                    <input type="button" id="btnReturn" name="btnReturn" class="button_Back" onmouseover="buttonover(this);" 
			                    	   onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
			                           value="�ر�" onclick="doClose()"/>
							</td>
						</tr>
					</table>
				</div>
			</div>
		</html:form>
	</body>
</html>
