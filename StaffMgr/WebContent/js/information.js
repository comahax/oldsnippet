var positionHTML;
function initEmpForm(){
	//positionHTML = $("#td2").html();
	$('#employeesform').form({
		url : rootPath + '/information/save.do',
		onSubmit : function() {
			// do some check
			if ($('#employeesform').form("validate")) {
				/*$.messager.alert('提示', '保存成功！');
				closeEmpForm();
				//刷新一下表格
				refreshUserGrid();*/
				return true;
	
			} else {
				// return false to prevent submit;
				return false;
			}
		},
		success : function(data) {
			var obj = eval("("+data+")");
			if(obj.retFlag){
				$.messager.alert('提示', '保存成功！');
				closeEmpForm();
				//刷新一下表格
				refreshUserGrid();
			}else{
				$.messager.alert('提示', obj.msg);
			}
			
		}
	});
}

function operstatesFormatter(value, row, index){
	if(value == '0'){
		return "在用";
	}
	if(value == '1'){
		return "停用";
	}

}


function operstaffattrFormatter(value, row, index){
	    if(value == '999') {
		    return "省公司本部";
	    }
	    if(value == '200'){
	        return "广州分公司";
	    }
	    if(value == '751'){
	   	    return "韶关分公司";
	    }
	    if(value == '755'){
	        return "深圳分公司";
	    }
	    if(value == '756'){
	    	return "珠海分公司";
	    }
	    if(value == '754'){
	    	return "汕头分公司";
	    }
	    if(value == '757'){
	    	return "佛山分公司";
	    }
	    if(value == '750'){
	    	return "江门分公司";
	    }
	    if(value == '759'){
	    	return "湛江分公司";
	    }
	    if(value == '668'){
	    	return "茂名分公司";
	    }
	    if(value == '758'){
	    	return "肇庆分公司";
	    }
	    if(value == '752'){
	    	return "惠州分公司";
	    }
	    if(value == '753'){
	    	return "梅州分公司";
	    }
	    if(value == '660'){
	    	return "汕尾分公司";
	    }
	    if(value == '762'){
	    	return "河源分公司";
	    }
	    if(value == '662'){
	    	return "阳江分公司";
	    }
	    if(value == '763'){
	    	return "清远分公司";
	    }
	    if(value == '769'){
	    	return "东莞分公司";
	    }
	    if(value == '760'){
	    	return "中山分公司";
	    }
	    if(value == '768'){
	    	return "潮州分公司";
	    }
	    if(value == '663'){
	    	return "揭阳分公司";
	    }
	    if(value == '766'){
	    	return "云浮分公司";
	    }
	    if(value == 'dgzx'){
	    	return "客服东莞中心";
	    }
	    if(value == 'fszx'){
	    	return "客服佛山中心";
	    }
	    if(value == 'jmzx'){
	    	return "客服江门中心";
	    }
	    if(value == 'stzx'){
	    	return "客服汕头中心";
	    }
	    if(value == 'szzx'){
	    	return "客服深圳中心";
	    }
	    if(value == 'gzzx'){
	    	return "客服广州中心";
	    }
	    if(value == 'www'){
	    	return "互联网公司";
	    }
	    if(value == 'nfjd'){
	    	return "南方基地";
	    }
	    if(value == 'zdgs'){
	    	return "终端公司";
	    }
	}
function opernumberattrFormatter(value, row, index){
	
		if(value == '200'){
	        return "广州";
	    }
	    if(value == '751'){
	   	    return "韶关";
	    }
	    if(value == '755'){
	        return "深圳";
	    }
	    if(value == '756'){
	    	return "珠海";
	    }
	    if(value == '754'){
	    	return "汕头";
	    }
	    if(value == '757'){
	    	return "佛山";
	    }
	    if(value == '750'){
	    	return "江门";
	    }
	    if(value == '759'){
	    	return "湛江";
	    }
	    if(value == '668'){
	    	return "茂名";
	    }
	    if(value == '758'){
	    	return "肇庆";
	    }
	    if(value == '752'){
	    	return "惠州";
	    }
	    if(value == '753'){
	    	return "梅州";
	    }
	    if(value == '660'){
	    	return "汕尾";
	    }
	    if(value == '762'){
	    	return "河源";
	    }
	    if(value == '662'){
	    	return "阳江";
	    }
	    if(value == '763'){
	    	return "清远";
	    }
	    if(value == '769'){
	    	return "东莞";
	    }
	    if(value == '760'){
	    	return "中山";
	    }
	    if(value == '768'){
	    	return "潮州";
	    }
	    if(value == '663'){
	    	return "揭阳";
	    }
	    if(value == '766'){
	    	return "云浮";
	    }
}

function operisprimaryFormatter(value, row, index){
		if(value == '0'){
			return "副";
			
		}
		if(value == '1'){
			return "主";
		}
}

function operstatusFormatter(value, row, index){
	    if(value == '0'){
	    	return "在职";
	    }
	    if(value == '1'){
	    	return "离职";
	    }
	    if(value == '2'){
	    	return "内退";
	    }
	    if(value == '3'){
	    	return "离退";
	    }
	    if(value == '4'){
	    	return "退休";
	    }
}

function deleteEmployees(){
	var selected=$("#employeesId").datagrid("getSelected");
	if(selected){
		$.messager.confirm('警告', '是否确认删除此用户?', function(r) {
			if (r) {
				$.post(rootPath+"/information/deletesEmployees.do",{"staffid":selected.staffid,
					"staffname":selected.staffname,"staffattr":selected.staffattr,"dept":selected.dept,
					"status":selected.status,"position":selected.position,"svrnum":selected.svrnum,
					"numberattr":selected.numberattr,"subsid":selected.subsid,"isprimary":selected.isprimary,"states":selected.states,
					"chgtime":selected.chgtime,"createtime":selected.createtime},function(obj){
					if(obj.retFlag){
						refreshUserGrid();
					}else{
						$.messager.alert('提示', obj.msg);
					}
				},"json");
			}
		});
	}else{
		$.messager.alert('提示','您未选择要操作的记录');
	}
	
}

function refreshUserGrid(){
	 $("#employeesId").datagrid('reload');
}



function showquery(){
	var formstr = $("#empform").serializeArray();
	formstr = formatArray(formstr);
	$('#employeesId').datagrid({
		url:rootPath + '/information/querys.do',
		queryParams:formstr
	});
	
}


function updateEmployees(){
	noneEmp();
	var birthYearAll=document.getElementById("numberattrs");   
	birthYearAll.onfocus = function() {      
	             var index = this.selectedIndex;      
	             this.onchange = function() {      
	                 //this.selectedIndex = index;      
	             };      
	         };  
	
	//设置手机号码不能编辑
	var obj = document.getElementById("svrnums");
    obj.setAttribute("readOnly",true);
    //设置员工编号不能编辑
    var obj1 = document.getElementById("staffids");
    obj1.setAttribute("readOnly",true);
//    //设置员工部门不能编辑
//    var obj2 = document.getElementById("depts");
//    obj2.setAttribute("readOnly",true);
	var selected = $("#employeesId").datagrid("getSelected");
	if(selected){
		if(selected.isprimary==0){
			//把副号的输入框隐藏
			$("#td1").hide();
			$("#td2").empty();
		}else{
			//显示副号的输入框
			$("#td1").show();
			$("#td2").html(positionHTML);
		}
		openUserForm();
		$("#employeesform").form('disableValidation');
		updateForm(selected);
		$("#employeesform").form('enableValidation');
		
	}else{
		$.messager.alert('提示','您未选择要操作的记录');
	}
}

function addEmployees(){
	
	showEmp();	
	openUserForm();

	//显示副号输入框
	//$("#td1").show();
	//$("#td2").html(positionHTML);
	document.getElementById("svrnums").readOnly=false;
	document.getElementById("staffids").readOnly=false;
//	document.getElementById("depts").readOnly=false;
	
	//关闭数据校验
	$("#employeesform").form('disableValidation');

	updateForm(null);
	
}

function updateForm(obj){
	if(obj){
		$("#staffids").val(obj.staffid);
		$("#staffnames").val(obj.staffname);
		$("#staffattrs").val(obj.staffattr);
		$("#depts").val(obj.dept);
		$('#statuss').val(obj.status);
		$('#positions').val(obj.position);
		$("#svrnums").val(obj.svrnum);
		$("#statesids").val(obj.states);
		$("#numberattrs").val(obj.numberattr);
		$("#isprimarys").val(obj.isprimary);
		$("#subsid").val(obj.subsid);
		$("#createtime").val(obj.createtime);
		$("#subsid").validatebox("validate");
		$("#staffid").validatebox("validate");
		$("#dept").validatebox("validate");
		$("#position").validatebox("validate");
		$("#svrnums").validatebox("validate");
	}else{
		$("#staffids").val('');
		$("#staffnames").val('');
		$("#staffattrs").val('999');
		$("#depts").val('');
		$('#statuss').val('0');
		$('#positions').val('');
		$("#svrnums").val('');
		$("#statesids").val('0');
		$("#numberattrs").val('200');
		$("#isprimarys").val('1');
		$("#subsid").val('');
		
		$("#subsid").validatebox("validate");
		$("#staffid").validatebox("validate");
		$("#dept").validatebox("validate");
		$("#position").validatebox("validate");
		$("#svrnums").validatebox("validate");
	}
	
}
//添加保存
function submitEmpForm(){
	$("#employeesform").form('enableValidation');
	if (!$("#svrnums").val().match(/^(13[0-9]|14[0-9]|15[0-9]|18[0-9])\d{8}$/)) { 
		alert("手机号码格式不正确");
		$("#svrnums").select();
		return;
	}
	document.getElementById("btns").disabled = true;
	if($("#employeesform").form('validate')){
		var params=$('#employeesform').serialize();
		$.post(rootPath+"/information/save.do",params,function(obj){
			if(obj.retFlag){
				$.messager.alert('提示','提交成功');
				closeEmpForm();
				refreshUserGrid();
			}else{
				document.getElementById("btns").disabled = false;
				$.messager.alert('提示', obj.msg);
			}
		},"json");
	}else{
		document.getElementById("btns").disabled = false;
	}
}



//修改保存
function submitEmpsForm(){

	document.getElementById("btnss").disabled = true;
	$("#employeesform").form('enableValidation');
	if($("#employeesform").form('validate')){
		var params=$('#employeesform').serialize();
		$.post(rootPath+"/information/update.do",params,function(obj){
			if(obj.retFlag){
				$.messager.alert('提示','提交成功');
				closeEmpForm();
				refreshUserGrid();
			}else{
				document.getElementById("btnss").disabled = false;
				$.messager.alert('提示', obj.msg);
			}
		},"json");
	}else{
		document.getElementById("btnss").disabled = false;
	}
}
//修改用于隐藏,显示按钮
function noneEmp(){
	$("#btns").hide();
	$("#btnss").show();
	//document.getElementById("btns").style.display='none';
	//document.getElementById("btnss").style.display='online';
}

function showEmp(){
	$("#btnss").hide();
	$("#btns").show();
	//document.getElementById("btnss").style.display='none';
	//document.getElementById("btns").style.display='online';
}

function submitNumberForm(){
	
	$('#numberform').form("enableValidation");
	if (!$("#svrnumss").val().match(/^(13[0-9]|14[0-9]|15[0-9]|18[0-9])\d{8}$/)) { 
		alert("手机号码格式不正确");
		$("#svrnumss").select();
		return;
	}
	document.getElementById("btn1").disabled = true;
	if($("#numberform").form('validate')){
		var params=$('#numberform').serialize();
		$.post(rootPath+"/information/saveNumber.do",params,function(obj){
			if(obj.retFlag){
				$.messager.alert('提示','提交成功');
				closeNumberForm();
				refreshUserGrid();
			}else{
				document.getElementById("btn1").disabled = false;
				$.messager.alert('提示', obj.msg);
			}
		},"json");
	}else{
		document.getElementById("btn1").disabled = false;
	}
	
}


function queryEmployees(){
	$('#employeesId').datagrid({
		url:rootPath + '/information/query.do'

	});
}

function Refresh(){
	$('#employeesId').datagrid({
		url:rootPath + '/information/querys.do'

	});
}

function closeEmpForm(){
	$('#empinfo').window("close");
}
function openUserForm(){
	$('#empinfo').window("open");
	$('#btnss').attr("disabled",false); 
	$('#btns').attr("disabled",true); 
	
}

function openNumberForm(){
	$('#empnumberinfo').window("open");
	document.getElementById("btn1").disabled = false;
}

function closeNumberForm(){
	$('#empnumberinfo').window("close");
}

function addEmployeesNumber(){
var selected = $("#employeesId").datagrid("getSelected");
	
	if(selected){
		openNumberForm();
		$("#empnumberinfo").form('disableValidation');
		updatesForm(selected);
		
	}else{
		$.messager.alert('提示','您未选择要操作的记录');
	}
	
function updatesForm(obj){
	$("#svrnumss").val('');
	$("#subsids").val('');
	$("#statesidss").val('0');
	$("#numberattrss").val('200');
	$("#isprimaryss").val('0');
	$("#staffnamess").val(obj.staffname);
	$("#staffidss").val(obj.staffid);
	$("#svrnumss").validatebox("validate");
	$("#subsids").validatebox("validate");
}







}
