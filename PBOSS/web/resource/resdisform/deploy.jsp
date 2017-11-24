<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<html>
<head>
<base target="_self">
    <title><s:text name="titleList"/></title>
    <script language="JavaScript" type="text/JavaScript">
    var isValidate = false;
    var disabledValue= false;
 	function doDeploy(cmdSave) {
 	disabledValue = true;
 		isValidate = true;  
        if(cmdSave != null && cmdSave !="")
			formList.action = contextPath + cmdSave;
		
	}

        function ev_check() {       
        var isSendSms = document.getElementById('isSendSms').checked; 
        
        if(isValidate){
	        if(!validate())
	        return false;
	        if(isSendSms){
	 			addfield('form.issuecode', '<s:text name="issuecode"/>', 'c', false, 16);
				addfield('form.issutime', '<s:text name="issutime"/>', 'dt', false, 20);
				addfield('form.smscontent', '<s:text name="smscontent"/>', 'c', false, 256);
	 		}
	 		if( !confirm("ȷ�Ϸ���") ){
	 			return false;
	 		}
        }	
        isValidate = false;	
         return checkval(window);            	
        }
 
 //ȫѡ��ȫ��ѡ
 function chooseAllItem(itemName,check){
 	select_item = document.getElementsByName(itemName);
 	for(var i = 0;i< select_item.length;i++){
 		select_item[i].checked = check;
 	}
 	
 	doDeployOrNot();
 }
 
 //����֪ͨ��ѡ�����������ܣ��ǹ�ѡ״̬ʱ���������ݿ�ȫ��ѡ����ť��ȫ��ȡ����ť�Ͷ���֪ͨ�б�Ϊ��Ч״̬��
 	//��ѡ״̬ʱ���������ݿ�ȫ��ѡ����ť��ȫ��ȡ����ť�Ͷ���֪ͨ�б�Ϊ��Ч״̬��
 	function canDeal(check){
	 	if(check){
	 		showOrNot('btnAllChose',false);
	 		showOrNot('btnAllCancel',false);
	 		showOrNot('employeeList',false);
	 		showOrNot('form.smscontent',false);
	 		$('#ttt').find('img').attr('style','');
	 		$('#ttt').find('a').click(function(){
	 		return true;
	 		});
	 	}else{
	 		showOrNot('btnAllChose',true);
	 		showOrNot('btnAllCancel',true);
	 		showOrNot('employeeList',true);
	 		showOrNot('form.smscontent',true);
	 		$('#ttt').find('img').attr('style','filter:progid:DXImageTransform.Microsoft.BasicImage(grayscale=1)');
	 		$('#ttt').find('a').click(function(){
	 		return false;
	 		});
	 	}	
 	}
 	
 	function showOrNot(objId,disabled){
 		document.getElementById(objId).disabled = disabled;
 	}
 	
 	function changeEmployee_itemAll(){
 		var flag = false;
 		select_item = document.getElementsByName('employee_item');
 		for(var i = 0;i<select_item.length;i++){
 			if(select_item[i].checked == true){
	 			flag = true;
	 			break;
 			}
 		}
 		var allbox = document.getElementsByName('allbox');
 		if(flag){
 			for(var i = 0;i<allbox.length;i++){
 				if(allbox[i].type='checkbox')
 					allbox[i].checked = true;
 			}			
 		}else{
 			for(var i = 0;i<allbox.length;i++){
 				if(allbox[i].type='checkbox')
 					allbox[i].checked = false;
 			}
 		} 		
 		doDeployOrNot();
 	}
 	
 	
 	
 	//��ҳ���ϵ���Ա�Ƿ񷢲��趨�����ѡ���򷢲���
 	//���򲻷���������״̬�ں�̨��SESSION���޸ģ�����״̬����Ҫ��
 function doDeployOrNot(){ 
 
 var select_item = document.getElementsByName('employee_item');
 	var selectValue = "";
 	var noSelectValue ="";
 	for(var i = 0;i< select_item.length;i++){
		if('checkbox' == select_item[i].type){
			if(select_item[i].checked == true){
				selectValue += select_item[i].value.split('|')[0]+";";//ѡ�п��ֵ �ֺ�(;)Ϊ���ֵ֮��ķָ���
			}else{
				noSelectValue += select_item[i].value.split('|')[0]+";";//δѡ�п��ֵ �ֺ�(;)Ϊ���ֵ֮��ķָ���
			}
		} 			
 	}	 
 	
 	var url = "<%=basePath%>resource/resdisform_deployOrNot.do"
	 	 $.post(url,
	     { selected: selectValue, notSelected: noSelectValue },
	     function(data){
	       
	     }   
	 );
 }
 
 
 function getSelectItemValue(objName){
 	
 }
    </script>
</head>

<body class="list_body" onload="setTime();">
<div class="table_container" id="allContent">
<s:form action="resdisform_queryEmployeeByPage.do" cssStyle="formList" key="formList"
			method="post" theme="simple" onsubmit="return ev_check();">
	<s:hidden name="param._orderby"/>
    <s:hidden name="param._desc"/>
    <s:hidden name="param._pageno"/>
    <s:hidden name="param._pagesize"/>
    <s:hidden name="param.queryAll"/>
    
	<s:hidden name="param._selectitem"/>
<input type="hidden" name="_rowcount" value="<s:property value="dp.rowCount" />"/>
 <s:hidden name="CMD"/>
 
	<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="resource"/> </span>
			<span class="table_toparea_xi">></span>
			</s:i18n>
			<span class="table_toparea_xi"><s:text name="titleList"/></span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea_h">��Դ����</span> 						
		</div>
	</div>
        
    <aa:zone name="errorZone">
		<div class="error_text" >
			<table class="error_text">
				<s:actionerror /><s:actionmessage/>
			</table>
		</div>
    </aa:zone>

<div class="table_div">
		<table class="table_button_list">
			<tr>
				<td>
                	<input type="button" id="btnDepoy" name="btnDepoy" class="button_New" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="����" onClick="doDeploy('/resource/resdisform_deploy.do');">
                        
                        <input type="button" id="btnBack" name="btnBack" class="button_back" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="����" onClick="doQuery('/resource/resdisform_list.do');">
				</td>
			</tr>
		</table>
	</div>

	<aa:zone name="listZone">
    <div class="table_div">
    	<div class="table_LongTable">
        <table class="table_style">
            <tr class="table_style_head">
               	<s:i18n name="public">
                
                </s:i18n>
                <td><s:text name="disid"/></td>
                <td><s:text name="discomcode"/></td>
                <td><s:text name="resamt"/></td>
                <td><s:text name="storarea"/></td>
                <td><s:text name="discode"/></td>
                <td><s:text name="distime"/></td>
                <td><s:text name="signcode"/></td>
                <td><s:text name="signtime"/></td>
                <td><s:text name="issuecode"/></td>
                <td><s:text name="issutime"/></td>
                <td><s:text name="disformstate"/></td>
                <td><s:text name="statinfo"/></td>
            </tr>
            <s:iterator value="#request.resdisformList">
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
					
                     <td><s:property value="disid"/></td>
                     <td><j:code2Name code="discomcode" definition="#WAYIDINFO"/></td>
                     <td><s:property value="resamt" /></td>
                     <td><j:code2Name code="storarea" definition="$IM_FXSTORAREA"/></td>
                     <td><s:property value="discode" /></td>
                     <td><s:date format="yyyy-MM-dd HH:mm:ss" name="distime"/></td>
                     <td><s:property value="signcode" /></td>
                     <td><s:date format="yyyy-MM-dd hh:mm:ss" name="signtime"/></td>
                     <td><s:property value="issuecode" /></td>
                     <td><s:date format="yyyy-MM-dd hh:mm:ss" name="issutime"/></td>
                     <td><j:code2Name code="disformstate" definition="$FX_DISFSTATE"/></td>
                     <td><s:property value="statinfo" /></td>
                 </tr>
             </s:iterator>
        </table>
        </div>
    </div>
    </aa:zone>  

<div class="table_div">
		<table class="table_button_list">
			<tr>
				<td>
                	<input type="button" id="btnAllChose" name="btnAllChose" class="button_4" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="ȫ��ѡ��" onClick="doQuery('/resource/resdisform_chooseOrCancelAll.do?type=choose');">
                        
                        <input type="button" id="btnAllCancel" name="btnAllCancel" class="button_4" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="ȫ��ȡ��" onClick="doQuery('/resource/resdisform_chooseOrCancelAll.do?type=cancel');">
				</td>
			</tr>
		</table>
	</div>

<aa:zone name="content">
    <div class="table_div">
        <table class="table_normal">

            <tr>
                <td align="right"><s:text name="issuecode"/>:&nbsp</td>
                <td align="left">
					<s:textfield cssStyle="style_input" name="form.issuecode" disabled="true" />
					<font color=red>*</font>
					ϵͳĬ��
                </td>

                <td align="right"><s:text name="issutime"/>:&nbsp</td>
                <td align="left">
                <s:i18n name="public">

					<s:textfield cssStyle="style_input" name="form.issutime" value="%{getText('format.datetime',{form.issutime})}" onclick="selectDatetime();" readonly="true"/>

					<font color=red>*</font>
					��ǰʱ��10����֮��
					</s:i18n>
                </td>
              </tr>
              <tr>
                <td align="right"><s:text name="issendsms"/>:&nbsp <input type="checkbox" name="form.isSendSms" id="isSendSms" value="send" checked="true" onclick="canDeal(this.checked)"/></td>

                <td align="left" colspan="3">
					<s:textfield cssStyle="style_input" name="form.smscontent" id="form.smscontent" size="80"/>
                </td>
            </tr>
        </table>
     </div>   
 </aa:zone>       
     
     
     <aa:zone name="listZone2">
    <div class="table_div" id="employeeList">
    	<div class="table_LongTable">
        <table class="table_style">
        
            <tr class="table_style_head">

                <td><input type="checkbox" name="allbox" id="allbox"  onclick="chooseAllItem('employee_item',this.checked)"  /></td>
                <td>��������</td>
                <td>�ֻ�����</td>
                <td>�����̱���</td>
                <td>����������</td>
                <td>����������</td>
            </tr>
            <s:iterator value="dp.datas" status="state">
                        
                 <tr class="table_style_content" align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">					
                     <td><input type="checkbox" name="employee_item" value="<s:property value="employeeid + '|' + deploy" />" onclick="changeEmployee_itemAll();"    <s:if test="deploy==1">checked = "true"</s:if>/></td>
                     <td><s:property value="employeename"/></td>
                     <td><s:property value="officeTel"/></td>
                     <td><s:property value="wayid"/></td>
                     <td><s:property value="wayname"/></td>
                     <td><s:property value="logiscode"/></td>
                 </tr>
             </s:iterator>
             
        </table>
        </div>
             <div class="table_div" id="ttt">
		<%@ include file="/common/pageNav.jsp"%>
   	</div>
    </div>
    

    </aa:zone>     
        
</s:form>

</div>

<script language="javascript"> 



	ajaxAnywhere.getZonesToReload = function(url,submitButton) {
	
	if( undefined != submitButton && 'btnDepoy' == submitButton.name){
		return "errorZone,listZone";
	}
		return "errorZone,listZone2";  
	}
	ajaxAnywhere.substituteFormSubmitFunction();ajaxAnywhere.formURL = formList.action;  
	ajaxAnywhere.substituteSubmitButtonsBehaviorByIDs(true,"btnDepoy,btnAllChose,btnAllCancel");
	
	//response��δ�����ڼ�����
	ajaxAnywhere.showLoadingMessage = function() {
		document.getElementById('allContent').disabled= disabledValue;
	}
	
	//ָ��ˢ��֮��Ķ���
	 ajaxAnywhere.onAfterResponseProcessing = function () {
	document.getElementById('allContent').disabled= false;
       disabledValue = false;
       document.formList.action = contextPath + '/resource/resdisform_queryEmployeeByPage.do';
    }
	
	
	var deplyTime;
	//����ʱ�䣺ʱ��Ի���ֻ����ϵͳĬ�ϵ�ǰʱ�䣬����ȡ�㣬�ǿա�
	function setTime(){
	var date = new Date();
	date.setTime(date.getTime());
	deplyTime = date.getTime();
	var year = date.getYear();
	var month = date.getMonth()+1;
	if(month<10)
		month = '0'+month;
	var day = date.getDate();
	if(day<10)
		day = '0'+day;
	var hour = date.getHours();
		if(hour<10)
			hour = '0'+hour;
	var min = date.getMinutes();
	if(min<10)
		min = '0'+min;
	document.getElementById('form.issutime').value=year+'-'+month+'-'+day+' '+hour+':00:00';
}

//�жϷ���ʱ���Ƿ�ϵͳ��ǰʱ���10���Ӻ� �Ƿ���TRUE������FALSE
function validate(){
	var date = new Date();
	var deplyTime = document.getElementById('form.issutime').value;
	if(deplyTime == null || '' == deplyTime){
		var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[����ʱ�� ]</span> �����ڵ�ǰʱ���10����֮��';
		errorMessageShow(alertstr);	
		return false;
	}
	var d1 = deplyTime.split(" ");//ȡ������,��ʱ�䲿��
	var d2 = d1[0].split("-");//��,��,��
	var d3 = d1[1].split(":");//ʱ����
	var deplyDate = new Date(d2[0],d2[1]-1,d2[2],d3[0],d3[1],d3[2]);

	if((deplyDate.getTime()-date.getTime())<600000){
		var alertstr = '<span class=\'errorkey\'><span style=\'color:#F00; font-size:12px;\'>[����ʱ�� ]</span> �����ڵ�ǰʱ���10����֮��';
		errorMessageShow(alertstr);
		return false;
	}else{
		return true;
	}
}
	</script> 
</body>
</html>
