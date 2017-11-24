function showquerys(){
	$('#billform').form("enableValidation");
	if($('#billform').form("validate")){
		var svrnums = $("#svrnums").val();
		var billcycs=$("#billcycs").val();
		$('#billsId').datagrid({
			url:rootPath + '/bills/querys.do',
			queryParams:{
			svrnums:svrnums,
			billcycs:billcycs
			}
		});
	}
}

function initBillForm(){
	$('#billsId').datagrid({
		    showfooter:true,
		    fitColumns : true,
			rownumbers : true,
		    columns: [[
		               { field: 'svrnum', title: '号码', width: 50, align: 'center' },
		               { field: 'isprimary', title: '号码属性', width: 50, align: 'center',formatter:operisprimaryFormatter },
		               { field: 'numberattr', title: '归属地区', width: 50, align: 'center',formatter:opernumberattrFormatter },
		               { field: 'verification', title: '本月核销话费', width: 50, align: 'center'},
		               { field: 'pay', title: '本月非核销类话费', width: 50, align: 'center'},
		               { field: 'cumulative', title: '本月超额话费', width: 50, align: 'center'},
		               { field: 'balance', title: '本月应缴话费', width: 50, align: 'center'},
		               { field: 'fieldvalue',title: '本月业务明细',width: 50,align: 'center',formatter:operbusinessFormatter },
		               ]], 
		   onLoadSuccess:function(data){
			   if(data.retFlag==0){
					$.messager.alert('提示', data.msg);
					return false;
				}
			   if (data.rows.length > 0) {
				   appendSummaryData(data);
//				   mergeCellsByField("billsId", "cumulative,balance");
				   
			   }
		   }       
	});
	//账期选择控件
	showyearbox(".date_input");
}

//指定列求和
function compute(verification) {
	    var rows = $('#billsId').datagrid('getRows');
	    var total = 0;
	    for (var i = 0; i < rows.length; i++) {
	        total += parseFloat(rows[i][verification]);
	    }
	    return total;
}

function appendSummaryData(data){
		var list = data.rows;
		var verifications = 0;
		var pays=0
		var cumulatives = 0;
		var balances=0;
		for(var i=0;i<list.length;i++){
			verifications += list[i].verification; 
			pays += list[i].pay;
			cumulatives += list[i].cumulative;
			balances += list[i].balance;
		}
		
		$("#billsId").datagrid('appendRow',{
			svrnum: '合计：',
			verification: verifications,
			pay: pays,
			cumulative: cumulatives,
			balance: balances
		});
		
		$("#billsId").datagrid('mergeCells',{
			index:list.length-1,
			field:'svrnum',
			colspan:3
		});

}

//添加业务明细查询按钮
var operbusinessFormatter = function  operbusinessFormatter(value,row,index) {
	console.log(row);
	if(row.svrnum ==  "合计："){
		return "";
	}
	return '<a href="#" onclick="editBusiness();">查看明细</a>';
}


function editBusiness(){
	
	var selected = $("#billsId").datagrid("getSelected");
	var svrnums=selected.svrnum;
		$('#detailedId').datagrid({
			url:rootPath + '/bills/querysBusiness.do',
			queryParams:{
			svrnums:svrnums
			}
		});
		openBusinessForm();
		
		$('#detailedId').datagrid({
		    fitColumns : true,
			rownumbers : true,
			url:rootPath + '/bills/querysBusiness.do',
		    columns: [[
		               { field: 'staffid', title: '员工编号', width: 50, align: 'center' },
		               { field: 'svrnum', title: '员工号码', width: 50, align: 'center' },
		               { field: 'billcyc', title: '账期', width: 50, align: 'center'},
		               { field: 'flag', title: '减免标记', width: 50, align: 'center',formatter:operflagFormatter},
		               { field: 'acctid', title: '费项', width: 50, align: 'center'},
		               { field: 'acctname', title: '费项名称', width: 50, align: 'center'},
		               { field: 'amt', title: '费用金额', width: 50, align: 'center' },
		               ]],      
	    });
		
}

function openBusinessForm(){
	$('#detailedIdss').window("open");
	
}

function operflagFormatter(value, row, index){
	if(value == '1'){
		return "减免";
	}
	if(value == '0'){
		return "自付";
	}
}

function operisprimaryFormatter(value, row, index){
	if(value == '1'){
        return "主号";
    }
	if(value == '0'){
        return "副号";
    }
}

function opernumberattrFormatter(value, row, index){
	if(value == '020'){
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





