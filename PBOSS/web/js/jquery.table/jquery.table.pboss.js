/** 
 * jQuery Table Plugin
 * version: 1.1.3 bate (Jan. 2010)
 * 1.1.3b - For pboss内网专用（增加个性设定）
 * 1.1.3a - 增加出错自定义函数（succeesFn）--加上Pboss未登录处理[个性]
 * 1.1.2a - 增加调用成功之后回调的函数（succeesFn）
 * @requires jQuery v1.3.2 or later and jquery.form.js
 * @author Jimmy @revenco
 */
//测试用，Json对象 
//var jsonObj = [{"id":"2","username":"22","password":"21","description":"23"}];
var CRLR = "\n";
 ;(function($) {
	 //主方法
	 var jGenData = null;
	 $.fn.queryTable = function(optn) {
		 //设置默认配置
		this._defaults = {
			debug: false,
			tableID:"jqTbl",
			tableClass:"tb_comn",//表格的CSS
			tHeadClass:"",//表头的CSS
			tBodyClass:"",//表内CSS
			width:"100%",//表内CSS
			showTable:true,//是否生成表头,默认为true--显示
			useTH:false,//表头使用TH标志
			keepShowData:false,//保留出错信息之前的数据
			getTbaleFn:getTable,//提取表格函数
			getTbodyFn:setDatas,//提取内容函数
			showMsgFn:showMsg, //出错显示函数
			succeesFn:null,//调用成功之后回调的函数
			pageNo:1,//手动定义页码和页内大小(页码为初始化页码)
			pageSize:10,//页内大小
			pageQuery:0//翻页标识
		}

		var _optn = $.extend({}, this._defaults , optn);
		//设置调试模式
		if (_optn.debug!=null){
			$.fn.queryTable.debug = _optn.debug;
		}

		if (!this.length) {
			log('queryTable: skipping process - 没有找到指定的对象');
			return this;
		}
		//设置插件运行的值
		var $div = $(this);//jQuery对象本身
		//翻页位置
		var $navigation = null;
		if (!$.isUndefined(_optn.navigation) && _optn.navigation.length >0){
			$navigation = _optn.navigation;
			//清空
			$navigation.hide();
		}
		//查询表格
		var _queryFrom = _optn.queryFrom;

		//判断提取表格函数
		if (!$.isFunction(_optn.getTbaleFn)) {
			_optn.getTbaleFn = getTable;
		}
		//判断提取内容函数
		if (!$.isFunction(_optn.getTbodyFn)) {
			_optn.getTbodyFn = setDatas;
		}
		
		//出错显示函数
		if (!$.isFunction(_optn.showMsgFn)) {
			_optn.showMsgFn = showMsg;
		}
		
		//判断格式化函数
		var fnFmtLink = _fmtLink;//不存在使用默认函数
		if ($.isFunction(_optn.fmtLink)) {
			fnFmtLink = _optn.fmtLink;
		}
		//设置表格名
		if ($.isString(_optn.tableID) && _optn.tableID !=""){
			$.fn.queryTable.jqTableId = _optn.tableID;
		}
		//获取表格
		var _genTbl = _optn.getTbaleFn($div,_optn);

		executeQuery(_optn.pageNo,_optn.pageSize,_optn.pageQuery);
		
		//ajaxForm查询方法
		function executeQuery(pageNo,pageSize,pageQuery){
			//ajaxform 提交成功后方法
			if (optn.unableBtu){
				var btn = $(optn.unableBtu);
				btn.attr("disabled",true);
			}
			var formUrl = _queryFrom.attr("action");
//			var pagePrm = "ajaxPost=1&";
			var pagePrm = "";
			if (isNumber(pageNo)){
				pagePrm += "param._pageno="+pageNo;
			}
			if (isNumber(pageSize)){
				pagePrm += (pagePrm!=""?'&':'') + "param._pagesize="+pageSize;
			}
//			if (isNumber(pageQuery)){
//				pagePrm += (pagePrm!=""?'&':'') + "pageQuery="+pageQuery;
//			}
			if (pagePrm!=""){
				formUrl += (formUrl.indexOf('?') >= 0 ? '&' : '?')+pagePrm;
			}

			var fromSuccuss = function(josnObj) {
				if (!josnObj["isSuccess"]) {
					//业务出错
					//alert(josnObj["message"]+ "[retun code :"+ josnObj["retCode"] + "]");
					//不要Return code
					//showMsg(josnObj["message"]+ "[retun code :"+ josnObj["retCode"] + "]",_genTbl);
					_optn.showMsgFn(josnObj["message"],_genTbl,josnObj["retCode"]);
					if (optn.unableBtu){
						var btn = $(optn.unableBtu);
						btn.attr("disabled",false);
					}
					return;
				}else{
					//生成表格数据
					var datas = josnObj["datas"];
					//var dfatas = jsonObj;
					_optn.getTbodyFn(datas,_genTbl,$div,josnObj);
					if (josnObj["page"]){
						//设置翻页
						setNavigation(josnObj["page"],_optn.tableID);
					}
				}
				if ($.isFunction(optn.succeesFn)){
					//回调成功函数
					optn.succeesFn(josnObj);
				}//if
				if (optn.unableBtu){
					var btn = $(optn.unableBtu);
					btn.attr("disabled",false);
				}
			}//success

			//ajaxForm 配置
			var ajaxOpn = {
				dataType:'json',
				url:formUrl,
				success:fromSuccuss
			}
			_queryFrom.ajaxSubmit(ajaxOpn);
			//Datatable自带错误检查，不用原来的方式处理
			//sendAjaxReuqest(_queryFrom,ajaxOpn);
		}
		
		//在表格中显示出错信息
        function showMsg(msg,shTable,errCode) {
			//获取表格头
			if (_optn.keepShowData){
				//对未登录做特别处理
				if (errCode == 2){
					alert('未登录或者登录超时!');
					window.location = '/';
					return;
				}
				alert(msg);
				if (jGenData != null){
					//隐藏加载中提示
					var _tBodyMark = shTable.find("#jqTblBodyMark tr");
					_tBodyMark.hide();
					jGenData.appendTo(shTable);
					//显示翻页
					$navigation.show();
					return;
				}//if
			}
			var _tBodyMark = shTable.find("tbody");
			_tBodyMark.find("td").html(msg);
		}

		//生成表格数据
		//jsonObjs:返回Json对象,shTable表格的JQ对象
        function setDatas(jsonObjs,shTable) {
			//获取表格头
			var _tData =  shTable.find("#jqTblBodySet tr");
			var _tBodyMark = shTable.find("#jqTblBodyMark tr");
			//复制新Tbody对象
			var newBody = shTable.find('#jqTblBodySet');
			//清空Tbody
			//newBody.empty();
			//生成内容
			if (jsonObjs.length>0){
				for (var i=0;i< jsonObjs.length;i++){
					var dtl=jsonObjs[i];
					var row = _tData.clone();
					row.show();
					row.removeClass();
					//设置内容CSS
					if (_optn.tBodyClass && $.trim(_optn.tBodyClass) != ''){
						row.addClass(_optn.tBodyClass);
					}
					//生成内容(用JQ方法)
					$("td",row).each(function(index,tdObj){
						//debugger;
						var jqObj = $(tdObj);//生成JQ对象
						jqObj.removeAttr("id");//删除ID属性,需要时可以通过回写方法实现
						jqObj.html("");
						var sId=jqObj.attr("sId");
						var sIndex=jqObj.attr("sIndex");
						//var oDate = eval("dtl."+ showCols[index].dataKey);
						//var oDate = dtl[showCols[index].dataKey];
						var oDate = dtl[sId];

						var cellHtml = fnFmtLink(jqObj,dtl,oDate,_optn.showCols[sIndex],row);
						jqObj.html(cellHtml);
					});

//					for(var j=0;j<showCols.length;j++){
//						var cellObj = row.find("#"+showCols[j].key);
//
//						//格式化输出内容
//						var cellHtml = fnFmtLink(cellObj,dtl,dtl[showCols[j].dataKey],showCols[j])
//						cellObj.html(cellHtml);
//					}//内容
					row.attr("id","ready");//改变绑定好数据的行的id
					row.appendTo(newBody);//添加到模板的容器中
				}//行 for
				//隐藏加载中提示
				_tBodyMark.hide();
				newBody.appendTo(shTable);
				//备份旧数据
				if (_optn.keepShowData){
					jGenData = newBody.clone();
				}//备份旧数据
			}else{
				_tBodyMark.find("td").html("没有数据");
			}//if
		};//function setDatas
		
		//设置翻页
		function setNavigation(pageObj,tblId){
			if ($navigation!=null){
				$navigation.empty();

				var navigator = $.extend({}, $.fn.queryTable.navigator, {});

				//加上表格ID
				navigator.changeTextID +="_"+tblId;
				navigator.changeLinkID +="_"+tblId;
				navigator.firstLinkID +="_"+tblId;
				navigator.prevLinkID +="_"+tblId;
				navigator.nextLinkID +="_"+tblId;
				navigator.lastLinkID +="_"+tblId;

				//生成翻页设置
				var firstPageLink="",prevPageLink="",nextPageLink="",lastPageLink="";
				//首页、上页
				if (!pageObj.previous){
//					firstPageLink = " <span>["+ navigator.first +"]</span> " 
//					prevPageLink = " <span>["+ navigator.prev +"]</span> "
					firstPageLink = "";
					prevPageLink = "";
				}else{
					firstPageLink = "<a href='javascript:' style='text-decoration:none' id='"+ navigator.firstLinkID +"'><img border='0' src='images/first.gif' alt='第一页' /></a> "+CRLR;
					prevPageLink = "<a href='javascript:' style='text-decoration:none' id='"+ navigator.prevLinkID +"'><img border='0' src='images/preview.gif' alt='前一页' /></a> "+CRLR;
				}
				//下页、尾页
				if (!pageObj.next){
//					nextPageLink = " <span>["+ navigator.next +"]</span> " 
//					lastPageLink = " <span>["+ navigator.last +"]</span> "
					nextPageLink = "";
					lastPageLink = "";
				}else{
					nextPageLink = "<a href='javascript:' style='text-decoration:none' id='"+ navigator.nextLinkID +"'><img border='0' src='images/next.gif' alt='下一页' /></a>"+CRLR;
					lastPageLink = "<a href='javascript:' style='text-decoration:none' id='"+ navigator.lastLinkID +"'><img border='0' src='images/last.gif' alt='最后一页' /></a> "+CRLR;
				}
				var markup = "";
				markup += (firstPageLink + prevPageLink);
				markup += (nextPageLink + lastPageLink);
				markup += "总计<font color='red'>"+pageObj.numbers +"</font>页;当前第<font color='red'>"+ pageObj.current +"</font>页";
				markup += "&nbsp; 跳转至<input id='"+ navigator.changeTextID +"' name='"+ navigator.changeTextID +"' type='text' size='2' ID='goto_page' value='"+ pageObj.current +"'>页<a href='javascript:' style='text-decoration:none'><img src='/images/go.gif' alt='跳转至' width='16' height='14' border='0' id='"+ navigator.changeLinkID  +"'></a>"
				$navigation.html(markup);

				//注册翻页事件
				$("#"+navigator.firstLinkID).click(function(){
					//executeQuery(1,pageObj.pageSize);
					executePage(1,pageObj.size,_optn,$div);
				});//首页
				$("#"+navigator.prevLinkID).click(function(){
					//executeQuery(pageObj.currentPage-1,pageObj.pageSize);
					executePage(pageObj.current-1,pageObj.size,_optn,$div);
				});//上页
				$("#"+navigator.nextLinkID).click(function(){
					//executeQuery(pageObj.currentPage+1,pageObj.pageSize);
					executePage(pageObj.current+1,pageObj.size,_optn,$div);
				});//下一页
				$("#"+navigator.lastLinkID).click(function(){
					//executeQuery(pageObj.totalPage,pageObj.pageSize);
					executePage(pageObj.last,pageObj.size,_optn,$div);
				});//最后

				$("#"+navigator.changeLinkID).click(function(){
					//executeQuery(pageObj.totalPage,pageObj.pageSize);
					var newPage = $("#"+navigator.changeTextID).val()
					if (!isNumber(newPage) ){
						newPage = parseInt(newPage);
						executePage(newPage,pageObj.size,_optn,$div);
					}else{
						alert("请输入正确的页码!");
					}//if
				});//最后
				//显示翻页
				$navigation.show();
			}
		}//function setNavigation
		//用户自定义单元格内容
		//elCell - 单元格对象(JQ),oRecord - 数据源,oData - 原数据,oColumnSet - 显示列对象
		function _fmtLink(elCell, oRecord, oData,oColumnSet) { 
			return oData;
		}//function fmtLink

	 };//queryTable

	 //调试模式
	 $.fn.queryTable.debug = true;
	 
	//表格名
	$.fn.queryTable.jqTableId ="jqDateTbl"

	 //翻页用变量
	$.fn.queryTable.navigator = {
		page:"页",
		first:"首页",
		last:"尾页",
		prev:"上页",
		next:"下页",	
		records:"条记录",
		page:"页",
		//翻页连接设置
		changeTextID:"jqTxtChgPage",
		changeLinkID:"jqChangeLink",
		firstLinkID:"jqFirstLink",
		prevLinkID:"jqPrevLink",
		nextLinkID:"jqNextLink",
		lastLinkID:"jqLastLink"

//		CLASS_FIRSTPAGE:"jq-dt-firstlink",
//		CLASS_FIRSTLINK:"jq-dt-dtfirstpage",
	}

// helper fn for console logging
// set $.fn.queryTable.debug to true to enable debug logging
function log() {
    if ($.fn.queryTable.debug){
		if (window.console && window.console.log){
	        window.console.log('[jquery.queryTable] ' + Array.prototype.join.call(arguments,''));
		}else{
			alert('[jquery.queryTable] ' + Array.prototype.join.call(arguments,''));
		}
	}//debug
};

//翻页处理(以重建方式处理)
function executePage(pageNo,pageSize,optin,$div){
	//设置新的页
	optin.pageNo = pageNo;
	optin.pageSize = pageSize;
	optin.pageQuery = 1;
	$div.queryTable(optin);
};
//数据判断
function isNumber(o) {
	return typeof o === 'number' && isFinite(o);
};
})(jQuery);


//生成表格方法
//传参：$div:DIV的jq对象,_optn:配置对象
function getTable($div,optn) {
	this._defaults ={
		tableClass:"tb_comn",//表格的CSS
		showTable:true,//是否生成表头,默认为true--显示
		tHeadClass:"",//表头的CSS
		tBodyClass:"",//表内CSS
		width:"100%",//表内CSS
		useTH:false//表头使用TH标志
	}
	
	var _optn = $.extend({}, this._defaults , optn);
	//生成表格
	var allCols=0;
	var setCss = "";
	var headMark = _optn.useTH?"th":"td";
	var setWidth="";

	//设置表格CSS
	if (_optn.tableClass && $.trim(_optn.tableClass) != ''){
		setCss = " class=\""+ _optn.tableClass +"\"";
	}else{
		setCss = " border='1'";
	}
	if (_optn.width && _optn.width!=""){
		setCss += " width='"+ _optn.width +"'";
	}
	var table=" <table id='"+ $div.queryTable.jqTableId  +"' "+ setCss +" >"+CRLR; 
	
	if (_optn.showTable){
	//生成列头
	table+="<THead>"+CRLR; 
		//设置表头CSS
		setCss = "";
		if (_optn.tHeadClass && $.trim(_optn.tHeadClass) != ''){
			setCss = " class=\""+ _optn.tHeadClass +"\"";
		}
		table+="<tr"+ setCss +">"+CRLR; 
		//遍历showCols生成列头
		for(var i=0;i<_optn.showCols.length;i++){
			if (!_optn.showCols[i].nonShow){//不显示标识
				allCols++;
				setWidth="";
				//设置列宽
				if (_optn.showCols[i].width!=""){
					setWidth=" width='"+ _optn.showCols[i].width +"'";
				}

				table+="<"+headMark+" id='jqTblHead"+ _optn.showCols[i].key +"'"+ setWidth +">"+ _optn.showCols[i].name + "</"+ headMark + ">"+CRLR;
			}//if
		}//for

		table+="</tr>"+CRLR; 
		table+="</THead>"+CRLR;
		
	}
	//生成内容列
	var tbodySet = "<TBody id='jqTblBodySet'>" + CRLR;
	
	//设置表内CSS
	setCss = "";
	if (_optn.tBodyClass&& $.trim(_optn.tBodyClass) != ''){
		setCss = " class=\""+ _optn.tBodyClass+"\"";
	}
	tbodySet+="<tr"+ setCss +">"+CRLR;
	//生成预备内容

	//遍历showCols生成列头
	for(var i=0;i<_optn.showCols.length;i++){
		if (!_optn.showCols[i].nonShow){//不显示标识
			//设置列宽
			setWidth="";
			if (_optn.showCols[i].width!=""){
				setWidth=" width='"+ _optn.showCols[i].width +"'";
			}
			tbodySet += "<td sId='"+ _optn.showCols[i].key  +"' sIndex='"+ i +"'"+ setWidth +"></td>";
		}
	}
	tbodySet +="</tr>"+CRLR; 
	tbodySet += "</TBody>"+CRLR;

	table+=tbodySet;
	table+="<TBody id='jqTblBodyMark'><tr "+ setCss +"><td colspan='"+ allCols+"'>数据加载中...</td></tr></TBody>"+CRLR; 
	table+=" </table>"+CRLR; 

	//消空原DIV
	$div.empty();
	$div.append(table);
	var rtnTbale = $div.find("#"+$div.queryTable.jqTableId);
	//设置内容
	var _tBodySet = rtnTbale.find("#jqTblBodySet tr");
	_tBodySet.hide();
	return rtnTbale;
	//alert(_optn.cols);
};//function getTable
