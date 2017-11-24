//elCell - 单元格对象(JQ),oRecord - 数据源,oData - 原数据,oColumnSet - 显示列对象 
//@@声用一定要在使用之前
var sPaln = null;
var chkRadix=-1;//订购基数
var fmtLink = function(elCell, oRecord, oData,oColumnSet) {
	var rtn = oData;
	var o = oRecord.batchNo;
	if(oColumnSet.key=="addCar"){
		//对于查询，只保存包号和批次号
		//saveGoods.id=oRecord.id&saveGoods.name=oRecord.name&saveGoods.comType=oRecord&saveGoods.orderCount=oRecord
		rtn = '<SPAN id="link_'+ oRecord.id +"-"+oRecord.name +'" style="display:'+ (oRecord.inCar?'none':'block')  +'"><a href="#shopping" onclick="doAdd(\''+oRecord.id+'\',\''+oRecord.name+'\',\''+oRecord.comType+'\',\''+oRecord.orderCount
			+'\')"><img src="/images/shopping.jpg" alt="加入购物车" border="0"></a></span>';
		rtn += '<SPAN id="linked_'+ oRecord.id +"-"+oRecord.name +'" style="display:'+ (oRecord.inCar?'block':'none')  +'"><img src="/images/shopping.jpg" alt="不能重复加到购物车" border="0"></span>';
	}
	if(oColumnSet.key=="type"){
		//卡类型
		rtn = '<SPAN id="type_'+ oRecord.id +"-"+oRecord.name +'"'+ (oRecord.inCar?' class="red_01"':'') +'>' + oData +'</SPAN>'
	}
	if (oColumnSet.key=="name"){
		//包号
		rtn = '<SPAN id="name_'+ oRecord.id +"-"+oRecord.name +'"'+ (oRecord.inCar?' class="red_01"':'') +'>' + oData +'</SPAN>'
	}
	return rtn;
}
var querySuccees = function(josnObj){
	if (josnObj["isSuccess"]){
		$('#showTips').show();
	}
}

var openDtl=function(url){
	openDlg(url,"商品明细",600,400,true);
};
//调用查询
var doQuery = function() {
	if (!canOrder) return;
	//验证选择
	if ($("#comType").val() == ""){
		alert("请选择商品类型!");
		$("#comType").focus();
		return;
	}
	optin.succeesFn = querySuccees;
	var qorderCount= $("#orderCount").val();
	if (chkOrderCount(qorderCount)) 
		$("#showTbl").queryTable(optin);
	else
		 $("#orderCount").focus();
};

var chkOrderCount = function(qorderCount){
	if (qorderCount == ''){
		alert("订购套数只能是数字！")
		return false;
	}
	if(!$.Validation.fIsAllNumeric(qorderCount)){
		alert("订购套数只能是数字！")
		return false;
	}
	if (chkRadix>0){
		if (qorderCount%chkRadix!=0){
			alert("订购套数只能是"+ chkRadix +"的倍数！")
			return false;
		}
	};

	return true;
}
var setToTable = function(datas,stats){
		var setTbl = $("#showGoodsDtls");
		var setObj = $("#setDtls tr");
		setTbl.empty();
		for (var i =0; i<datas.length; i++){
			var good = datas[i];
			var row = setObj.clone();
			row.find("#showGdsType").html(good.type);
			row.find("#showGdsId").html('<a href="javascript:openDtl(\''+ contextRootPath
				+'/goods/goodsDetail.do?carKey='+ good.key +'\');" >'+good.name+'</a>');
			row.find("#showOrderCount").html(good.orderCount);
			var imgObj = row.find("#showGdsImg")
			var imgHtml = imgObj.html();
			while(imgHtml.indexOf("$[key]")>-1){
				imgHtml = imgHtml.replace("$[key]", good.key);
			}
			while(imgHtml.indexOf("$[id]")>-1){
				imgHtml = imgHtml.replace("$[id]", good.id);
			}
			while(imgHtml.indexOf("$[packageNo]")>-1){
				imgHtml = imgHtml.replace("$[packageNo]", good.name);
			}
			imgObj.html(imgHtml);
			//添加到表格中
			row.appendTo(setTbl);
		}//for
		setTbl.show();
		
		var setStatTbl = $("#setGoodsStats");
		var setStatObj = $("#setStatsData tr");
		setStatTbl.empty();
		var allPckgCnt=0,allDtlCnt=0;
		for (var i =0; i<stats.length; i++){
			var stat = stats[i];
			var row = setStatObj.clone();
			row.find("#showType").html(stat.type + '：');
			row.find("#showDesc").html('<font class="red_01">'+ stat.pckgCnt  +'</font>包（<font class="red_01">'+ stat.dtlCnt +'</font>套）');
			allPckgCnt += stat.pckgCnt;
			allDtlCnt += stat.dtlCnt;
			//添加到表格中
			row.appendTo(setStatTbl);
		}//for
		if (stats.length>0){
			var row = setStatObj.clone();
			row.find("#showType").html('您共选购了：');
			row.find("#showDesc").html('<font class="red_01">'+ allPckgCnt +'</font>包（<font class="red_01">'+ allDtlCnt +'</font>套）');
			//添加到表格中
			row.appendTo(setStatTbl);
		}
		setStatTbl.show();
}
var setMarkResoure = function(action,id,packageNo){
	//加上批次号
	//debugger;
	var type = $("#type_"+id+"-"+packageNo);
	var name = $("#name_"+id+"-"+packageNo);
	var link = $("#link_"+id+"-"+packageNo);
	var linked = $("#linked_"+id+"-"+packageNo);
	var sClass = "";
	if (action == 'add'){
		sClass = "red_01";
	}
	if (type.length>0){
		//卡类型位置
		type[0].className = sClass;
	}
	if (name.length>0){
		//包号位置
		name[0].className = sClass;
	}
	//增加到购物车图标
	if (action == 'add'){
		link.hide();
		linked.show();
	}else{
		link.show();
		linked.hide();
	}

};
var doAjax = function(url,action,id,name){
	$.ajax({
		type: "POST",	//提交方式
		url:url ,
		cache: false,		//不使用IE缓存
		dataType: "json",	
		success: function(json){
			if (json["isSuccess"]){
				var datas = json["datas"];
				var stats = json["stats"];
				setToTable(datas,stats);
				setMarkResoure(action,id,name);
			}else{
				alert(json.message);
			}
			if (sPaln != null){
				sPaln.close();
			}
		}
	});
}
//加到购物车中
//batchNo - 批次号（id）,packageNo - 包号（name）,comType,orderCount
var doAdd = function(batchNo,packageNo,comType,orderCount){
//	addGoods.do?saveGoods.id='+ oRecord.id +'&saveGoods.name='+ oRecord.name+'&saveGoods.comType='+ oRecord.comType +'&saveGoods.orderCount=
//	$.getJSON('addGoods.do?saveGoods.id='+batchNo+'&saveGoods.name='+ packageNo +'&saveGoods.comType='+ comType +'&saveGoods.orderCount='+ orderCount, 
//		function(json){
//	  alert('dd');
//	});

	if (!canOrder) return;
	sPaln = f_showPlan("正在处理中，请稍候。");
	doAjax('addGoods.do?saveGoods.id='+batchNo+'&saveGoods.name='+ packageNo +'&saveGoods.comType='+ comType +'&saveGoods.orderCount='+ orderCount,
		'add',batchNo,packageNo);
}
var doDel = function(key,id,packageNo){
	
	if (!canOrder) return;
	sPaln = f_showPlan("正在处理中，请稍候。");
	doAjax('delGoods.do?saveGoods.key='+key,'del',id,packageNo);
}

var doSumnit = function(){
	if (!canOrder) return;
	var carAll = $("#showGoodsDtls tr").length;
	if (carAll<1){
		f_showEMsg("购物车不能为空！");
		return;
	}
	sPaln = f_showPlan("正在处理中，请稍候。");
	window.location='submit.do';
}

var doGoodsPriceRadix = function(){
	if (!canOrder) return;
	var selComType = $("#comType");
	var qBtn = $("#btnQuery");
	var aBtn = $("#btnAddToCar");
	var qTxt = $("#orderCount");
	selComType.attr("disabled",true);
	qBtn.attr("disabled",true);
	aBtn.attr("disabled",true);
	qTxt.attr("disabled",true);
	var selComTypeVal = selComType.val();
	//@@ 测试
	//qTxt.val('');

	if (selComTypeVal && selComTypeVal!='' ){
		$('#comTypeDscrp').html('查询中，请稍等...');
		//@@ 未加上缓存处理
		//ajax请求
		$.ajax({
			type: "POST",	//提交方式
			url:'getPriceRadix.do?comType='+selComTypeVal ,//本地地址
			cache: false,		//不使用IE缓存
			dataType: "json",	
			success: function(json){
				if (json["isSuccess"]){
					var goodsInfo = json["rtnObject"];
					var str = '单价：<font class="red_01">'+ goodsInfo.price +'</font>元。';
					if (goodsInfo.radix >0){
						str += '订购套数必须是<font class="red_01">'+ goodsInfo.radix +'</font>的倍数。';
					}//if
					$('#comTypeDscrp').html("（"+ str +"）");
					chkRadix=goodsInfo.radix ;//设置检查基数
					if (isQuery){
						if (goodsInfo.comrescard){//充值卡时不用去查，直接用
							$("#queryDiv").hide();
							$("#addDiv").show();
						}else{
							//非充值卡时
							$("#queryDiv").show();
							$("#addDiv").hide();
						}
					}//if
					qBtn.attr("disabled",false);
					aBtn.attr("disabled",false);
					qTxt.attr("disabled",false);
				}else{
					$('#comTypeDscrp').html('（请选择商品类型!）');
					alert(json.message);
				}
			}
		});//ajax
	}	
	qTxt.val('');
	selComType.attr("disabled",false);
}
var doAddToCar = function(){
	if (!canOrder) return;
	var comType = $("#comType").val();
	//验证选择
	if (comType == ""){
		alert("请选择商品类型!");
		$("#comType").focus();
		return;
	}
	
	var qorderCount= $("#orderCount").val();

	if (chkOrderCount(qorderCount)){
		sPaln = f_showPlan("正在处理中，请稍候。");//显示提示中
		doAjax('addGoods.do?saveGoods.comType='+ comType +'&saveGoods.orderCount='+ qorderCount);	
	} 

}
//页面初始化完成时调用
$(document).ready(function() {
	//f_showMenu(1,0,0);
	//显示表格
	dTable = getTable($("#showTbl"),optin);
	var _tBodyMark = dTable.find("#jqTblBodyMark tr td");
	_tBodyMark.hide();

	//绑定按钮
	$("#btnQuery").click(doQuery);
	$("#btnAddToCar").click(doAddToCar);//增加按钮
	$("#comType").change(doGoodsPriceRadix);
});