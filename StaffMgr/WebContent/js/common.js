function showProgress(){
	$.messager.progress({
		title:'请稍后', 
		msg:'正在处理中...' 
	});
}

var loadSuccess = function(data){
	if(data.retFlag==0){
		$.messager.alert('提示', data.msg);
	}
}

function closeProgress(){
	$.messager.progress('close');
}

var tabUserManager;
$(document).ready(function(){
	
});


function selectTopTabs(){
	var tab = $("#toptabs").tabs("getSelected");
	var index = $('#toptabs').tabs('getTabIndex',tab);
	
	if(index != 0){
		//不在第一页
		$("#billTypeDialog").dialog('close');
	}
	
	if(index != 1){
		$("#userdataTypeDialog").dialog('close');
	}
}


function ajaxLoading(){ 
    $("<div class=\"datagrid-mask\"></div>").css({display:"block",width:"100%",height:$(window).height()}).appendTo("body"); 
    $("<div class=\"datagrid-mask-msg\"></div>").html("正在处理，请稍候。。。").appendTo("body").css({display:"block","font-size":"12px",left:($(document.body).outerWidth(true) - 190) / 2,top:($(window).height() - 45) / 2}); 
 } 
 function ajaxLoadEnd(){ 
     $(".datagrid-mask").remove(); 
     $(".datagrid-mask-msg").remove();             
} 


/*function openUserPassword(){
	$("#modifyPwdWindow").window("open");
}*/

/*function closeModifyPwdForm(){
	$("#modifyPwdWindow").window("close");
	$("#oripassword").val("");
	$("#changepassword").val("");
	$("#changepassword2").val("");
}*/


/*function submitModifyPwdForm(){
	var params = $("#modifyPwdForm").serialize();
	$.post(rootPath+"/user/modifyPwd.do",params,function(obj){
		if(obj.retFlag){
			closeModifyPwdForm();
			$("#oripassword").val("");
			$("#changepassword").val("");
			$("#changepassword2").val("");
			$.messager.alert('提示','成功修改密码');
		}else{
			$.messager.alert('提示', obj.msg);
		}
	},"json");
	
}*/

function logout(){
	$.messager.confirm('提示', '是否确认退出登录?', function(r) {
		if (r) {
			$.post(rootPath+"/index/logout.do",function(obj){
				if(obj.retFlag){
					window.location=rootPath;
				}else{
					$.messager.alert('提示', obj.msg);
				}
			},"json");
		}
	});
}

$.extend($.fn.validatebox.defaults.rules, {
	equals : {
		validator : function(value, param) {
			return value == $(param[0]).val();
		},
		message : '两个字段不匹配'
	}
});

function formatArray(arr){
	var newarr = {};
	for(var i=0;i<arr.length;i++){
		if(typeof arr[i].value != "undefined") {
			newarr[arr[i].name] = arr[i].value;
		}
	}
	return newarr;
}