/** 
 * jQuery Table Plugin
 * version: 1.1.3 bate (Jan. 2010)
 * 1.1.3b - For pboss����ר�ã����Ӹ����趨��
 * 1.1.3a - ���ӳ����Զ��庯����succeesFn��--����Pbossδ��¼����[����]
 * 1.1.2a - ���ӵ��óɹ�֮��ص��ĺ�����succeesFn��
 * @requires jQuery v1.3.2 or later and jquery.form.js
 * @author Jimmy @revenco
 */
//�����ã�Json���� 
//var jsonObj = [{"id":"2","username":"22","password":"21","description":"23"}];
var CRLR = "\n";
 ;(function($) {
	 //������
	 var jGenData = null;
	 $.fn.queryTable = function(optn) {
		 //����Ĭ������
		this._defaults = {
			debug: false,
			tableID:"jqTbl",
			tableClass:"tb_comn",//����CSS
			tHeadClass:"",//��ͷ��CSS
			tBodyClass:"",//����CSS
			width:"100%",//����CSS
			showTable:true,//�Ƿ����ɱ�ͷ,Ĭ��Ϊtrue--��ʾ
			useTH:false,//��ͷʹ��TH��־
			keepShowData:false,//����������Ϣ֮ǰ������
			getTbaleFn:getTable,//��ȡ�����
			getTbodyFn:setDatas,//��ȡ���ݺ���
			showMsgFn:showMsg, //������ʾ����
			succeesFn:null,//���óɹ�֮��ص��ĺ���
			pageNo:1,//�ֶ�����ҳ���ҳ�ڴ�С(ҳ��Ϊ��ʼ��ҳ��)
			pageSize:10,//ҳ�ڴ�С
			pageQuery:0//��ҳ��ʶ
		}

		var _optn = $.extend({}, this._defaults , optn);
		//���õ���ģʽ
		if (_optn.debug!=null){
			$.fn.queryTable.debug = _optn.debug;
		}

		if (!this.length) {
			log('queryTable: skipping process - û���ҵ�ָ���Ķ���');
			return this;
		}
		//���ò�����е�ֵ
		var $div = $(this);//jQuery������
		//��ҳλ��
		var $navigation = null;
		if (!$.isUndefined(_optn.navigation) && _optn.navigation.length >0){
			$navigation = _optn.navigation;
			//���
			$navigation.hide();
		}
		//��ѯ���
		var _queryFrom = _optn.queryFrom;

		//�ж���ȡ�����
		if (!$.isFunction(_optn.getTbaleFn)) {
			_optn.getTbaleFn = getTable;
		}
		//�ж���ȡ���ݺ���
		if (!$.isFunction(_optn.getTbodyFn)) {
			_optn.getTbodyFn = setDatas;
		}
		
		//������ʾ����
		if (!$.isFunction(_optn.showMsgFn)) {
			_optn.showMsgFn = showMsg;
		}
		
		//�жϸ�ʽ������
		var fnFmtLink = _fmtLink;//������ʹ��Ĭ�Ϻ���
		if ($.isFunction(_optn.fmtLink)) {
			fnFmtLink = _optn.fmtLink;
		}
		//���ñ����
		if ($.isString(_optn.tableID) && _optn.tableID !=""){
			$.fn.queryTable.jqTableId = _optn.tableID;
		}
		//��ȡ���
		var _genTbl = _optn.getTbaleFn($div,_optn);

		executeQuery(_optn.pageNo,_optn.pageSize,_optn.pageQuery);
		
		//ajaxForm��ѯ����
		function executeQuery(pageNo,pageSize,pageQuery){
			//ajaxform �ύ�ɹ��󷽷�
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
					//ҵ�����
					//alert(josnObj["message"]+ "[retun code :"+ josnObj["retCode"] + "]");
					//��ҪReturn code
					//showMsg(josnObj["message"]+ "[retun code :"+ josnObj["retCode"] + "]",_genTbl);
					_optn.showMsgFn(josnObj["message"],_genTbl,josnObj["retCode"]);
					if (optn.unableBtu){
						var btn = $(optn.unableBtu);
						btn.attr("disabled",false);
					}
					return;
				}else{
					//���ɱ������
					var datas = josnObj["datas"];
					//var dfatas = jsonObj;
					_optn.getTbodyFn(datas,_genTbl,$div,josnObj);
					if (josnObj["page"]){
						//���÷�ҳ
						setNavigation(josnObj["page"],_optn.tableID);
					}
				}
				if ($.isFunction(optn.succeesFn)){
					//�ص��ɹ�����
					optn.succeesFn(josnObj);
				}//if
				if (optn.unableBtu){
					var btn = $(optn.unableBtu);
					btn.attr("disabled",false);
				}
			}//success

			//ajaxForm ����
			var ajaxOpn = {
				dataType:'json',
				url:formUrl,
				success:fromSuccuss
			}
			_queryFrom.ajaxSubmit(ajaxOpn);
			//Datatable�Դ������飬����ԭ���ķ�ʽ����
			//sendAjaxReuqest(_queryFrom,ajaxOpn);
		}
		
		//�ڱ������ʾ������Ϣ
        function showMsg(msg,shTable,errCode) {
			//��ȡ���ͷ
			if (_optn.keepShowData){
				//��δ��¼���ر���
				if (errCode == 2){
					alert('δ��¼���ߵ�¼��ʱ!');
					window.location = '/';
					return;
				}
				alert(msg);
				if (jGenData != null){
					//���ؼ�������ʾ
					var _tBodyMark = shTable.find("#jqTblBodyMark tr");
					_tBodyMark.hide();
					jGenData.appendTo(shTable);
					//��ʾ��ҳ
					$navigation.show();
					return;
				}//if
			}
			var _tBodyMark = shTable.find("tbody");
			_tBodyMark.find("td").html(msg);
		}

		//���ɱ������
		//jsonObjs:����Json����,shTable����JQ����
        function setDatas(jsonObjs,shTable) {
			//��ȡ���ͷ
			var _tData =  shTable.find("#jqTblBodySet tr");
			var _tBodyMark = shTable.find("#jqTblBodyMark tr");
			//������Tbody����
			var newBody = shTable.find('#jqTblBodySet');
			//���Tbody
			//newBody.empty();
			//��������
			if (jsonObjs.length>0){
				for (var i=0;i< jsonObjs.length;i++){
					var dtl=jsonObjs[i];
					var row = _tData.clone();
					row.show();
					row.removeClass();
					//��������CSS
					if (_optn.tBodyClass && $.trim(_optn.tBodyClass) != ''){
						row.addClass(_optn.tBodyClass);
					}
					//��������(��JQ����)
					$("td",row).each(function(index,tdObj){
						//debugger;
						var jqObj = $(tdObj);//����JQ����
						jqObj.removeAttr("id");//ɾ��ID����,��Ҫʱ����ͨ����д����ʵ��
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
//						//��ʽ���������
//						var cellHtml = fnFmtLink(cellObj,dtl,dtl[showCols[j].dataKey],showCols[j])
//						cellObj.html(cellHtml);
//					}//����
					row.attr("id","ready");//�ı�󶨺����ݵ��е�id
					row.appendTo(newBody);//��ӵ�ģ���������
				}//�� for
				//���ؼ�������ʾ
				_tBodyMark.hide();
				newBody.appendTo(shTable);
				//���ݾ�����
				if (_optn.keepShowData){
					jGenData = newBody.clone();
				}//���ݾ�����
			}else{
				_tBodyMark.find("td").html("û������");
			}//if
		};//function setDatas
		
		//���÷�ҳ
		function setNavigation(pageObj,tblId){
			if ($navigation!=null){
				$navigation.empty();

				var navigator = $.extend({}, $.fn.queryTable.navigator, {});

				//���ϱ��ID
				navigator.changeTextID +="_"+tblId;
				navigator.changeLinkID +="_"+tblId;
				navigator.firstLinkID +="_"+tblId;
				navigator.prevLinkID +="_"+tblId;
				navigator.nextLinkID +="_"+tblId;
				navigator.lastLinkID +="_"+tblId;

				//���ɷ�ҳ����
				var firstPageLink="",prevPageLink="",nextPageLink="",lastPageLink="";
				//��ҳ����ҳ
				if (!pageObj.previous){
//					firstPageLink = " <span>["+ navigator.first +"]</span> " 
//					prevPageLink = " <span>["+ navigator.prev +"]</span> "
					firstPageLink = "";
					prevPageLink = "";
				}else{
					firstPageLink = "<a href='javascript:' style='text-decoration:none' id='"+ navigator.firstLinkID +"'><img border='0' src='images/first.gif' alt='��һҳ' /></a> "+CRLR;
					prevPageLink = "<a href='javascript:' style='text-decoration:none' id='"+ navigator.prevLinkID +"'><img border='0' src='images/preview.gif' alt='ǰһҳ' /></a> "+CRLR;
				}
				//��ҳ��βҳ
				if (!pageObj.next){
//					nextPageLink = " <span>["+ navigator.next +"]</span> " 
//					lastPageLink = " <span>["+ navigator.last +"]</span> "
					nextPageLink = "";
					lastPageLink = "";
				}else{
					nextPageLink = "<a href='javascript:' style='text-decoration:none' id='"+ navigator.nextLinkID +"'><img border='0' src='images/next.gif' alt='��һҳ' /></a>"+CRLR;
					lastPageLink = "<a href='javascript:' style='text-decoration:none' id='"+ navigator.lastLinkID +"'><img border='0' src='images/last.gif' alt='���һҳ' /></a> "+CRLR;
				}
				var markup = "";
				markup += (firstPageLink + prevPageLink);
				markup += (nextPageLink + lastPageLink);
				markup += "�ܼ�<font color='red'>"+pageObj.numbers +"</font>ҳ;��ǰ��<font color='red'>"+ pageObj.current +"</font>ҳ";
				markup += "&nbsp; ��ת��<input id='"+ navigator.changeTextID +"' name='"+ navigator.changeTextID +"' type='text' size='2' ID='goto_page' value='"+ pageObj.current +"'>ҳ<a href='javascript:' style='text-decoration:none'><img src='/images/go.gif' alt='��ת��' width='16' height='14' border='0' id='"+ navigator.changeLinkID  +"'></a>"
				$navigation.html(markup);

				//ע�ᷭҳ�¼�
				$("#"+navigator.firstLinkID).click(function(){
					//executeQuery(1,pageObj.pageSize);
					executePage(1,pageObj.size,_optn,$div);
				});//��ҳ
				$("#"+navigator.prevLinkID).click(function(){
					//executeQuery(pageObj.currentPage-1,pageObj.pageSize);
					executePage(pageObj.current-1,pageObj.size,_optn,$div);
				});//��ҳ
				$("#"+navigator.nextLinkID).click(function(){
					//executeQuery(pageObj.currentPage+1,pageObj.pageSize);
					executePage(pageObj.current+1,pageObj.size,_optn,$div);
				});//��һҳ
				$("#"+navigator.lastLinkID).click(function(){
					//executeQuery(pageObj.totalPage,pageObj.pageSize);
					executePage(pageObj.last,pageObj.size,_optn,$div);
				});//���

				$("#"+navigator.changeLinkID).click(function(){
					//executeQuery(pageObj.totalPage,pageObj.pageSize);
					var newPage = $("#"+navigator.changeTextID).val()
					if (!isNumber(newPage) ){
						newPage = parseInt(newPage);
						executePage(newPage,pageObj.size,_optn,$div);
					}else{
						alert("��������ȷ��ҳ��!");
					}//if
				});//���
				//��ʾ��ҳ
				$navigation.show();
			}
		}//function setNavigation
		//�û��Զ��嵥Ԫ������
		//elCell - ��Ԫ�����(JQ),oRecord - ����Դ,oData - ԭ����,oColumnSet - ��ʾ�ж���
		function _fmtLink(elCell, oRecord, oData,oColumnSet) { 
			return oData;
		}//function fmtLink

	 };//queryTable

	 //����ģʽ
	 $.fn.queryTable.debug = true;
	 
	//�����
	$.fn.queryTable.jqTableId ="jqDateTbl"

	 //��ҳ�ñ���
	$.fn.queryTable.navigator = {
		page:"ҳ",
		first:"��ҳ",
		last:"βҳ",
		prev:"��ҳ",
		next:"��ҳ",	
		records:"����¼",
		page:"ҳ",
		//��ҳ��������
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

//��ҳ����(���ؽ���ʽ����)
function executePage(pageNo,pageSize,optin,$div){
	//�����µ�ҳ
	optin.pageNo = pageNo;
	optin.pageSize = pageSize;
	optin.pageQuery = 1;
	$div.queryTable(optin);
};
//�����ж�
function isNumber(o) {
	return typeof o === 'number' && isFinite(o);
};
})(jQuery);


//���ɱ�񷽷�
//���Σ�$div:DIV��jq����,_optn:���ö���
function getTable($div,optn) {
	this._defaults ={
		tableClass:"tb_comn",//����CSS
		showTable:true,//�Ƿ����ɱ�ͷ,Ĭ��Ϊtrue--��ʾ
		tHeadClass:"",//��ͷ��CSS
		tBodyClass:"",//����CSS
		width:"100%",//����CSS
		useTH:false//��ͷʹ��TH��־
	}
	
	var _optn = $.extend({}, this._defaults , optn);
	//���ɱ��
	var allCols=0;
	var setCss = "";
	var headMark = _optn.useTH?"th":"td";
	var setWidth="";

	//���ñ��CSS
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
	//������ͷ
	table+="<THead>"+CRLR; 
		//���ñ�ͷCSS
		setCss = "";
		if (_optn.tHeadClass && $.trim(_optn.tHeadClass) != ''){
			setCss = " class=\""+ _optn.tHeadClass +"\"";
		}
		table+="<tr"+ setCss +">"+CRLR; 
		//����showCols������ͷ
		for(var i=0;i<_optn.showCols.length;i++){
			if (!_optn.showCols[i].nonShow){//����ʾ��ʶ
				allCols++;
				setWidth="";
				//�����п�
				if (_optn.showCols[i].width!=""){
					setWidth=" width='"+ _optn.showCols[i].width +"'";
				}

				table+="<"+headMark+" id='jqTblHead"+ _optn.showCols[i].key +"'"+ setWidth +">"+ _optn.showCols[i].name + "</"+ headMark + ">"+CRLR;
			}//if
		}//for

		table+="</tr>"+CRLR; 
		table+="</THead>"+CRLR;
		
	}
	//����������
	var tbodySet = "<TBody id='jqTblBodySet'>" + CRLR;
	
	//���ñ���CSS
	setCss = "";
	if (_optn.tBodyClass&& $.trim(_optn.tBodyClass) != ''){
		setCss = " class=\""+ _optn.tBodyClass+"\"";
	}
	tbodySet+="<tr"+ setCss +">"+CRLR;
	//����Ԥ������

	//����showCols������ͷ
	for(var i=0;i<_optn.showCols.length;i++){
		if (!_optn.showCols[i].nonShow){//����ʾ��ʶ
			//�����п�
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
	table+="<TBody id='jqTblBodyMark'><tr "+ setCss +"><td colspan='"+ allCols+"'>���ݼ�����...</td></tr></TBody>"+CRLR; 
	table+=" </table>"+CRLR; 

	//����ԭDIV
	$div.empty();
	$div.append(table);
	var rtnTbale = $div.find("#"+$div.queryTable.jqTableId);
	//��������
	var _tBodySet = rtnTbale.find("#jqTblBodySet tr");
	_tBodySet.hide();
	return rtnTbale;
	//alert(_optn.cols);
};//function getTable
