function doShowDetail(wayid,opnid2,rewardtype,rewardmonth,oprmonth,supportPaymonth,paymonth){
	var url="/managerView/cityrecordList.do";
	url=url+"?parameter.wayid="+wayid;
	url=url+"&parameter.opnid2="+opnid2;
	url=url+"&parameter.rewardtype="+rewardtype;
	url=url+"&parameter.month="+rewardmonth;
	url=url+"&parameter.oprmonth="+oprmonth;
	url=url+"&parameter.supportPaymonth="+supportPaymonth;
	url=url+"&parameter.paymonth="+paymonth;
	var rtn=window.showModalDialog(url,null,"dialogWidth:910px;dialogHeight:325px;status:no;menubar=no;scrollbars=yes;resizable:yes;");
}
function f_waySelect(){
	var url="/magSaleDetail/waySelect.do";
	var rtn=window.showModalDialog(url,null,"dialogWidth:900px; dialogHeight:450px; status:no; resizable:no;");
    if (rtn != null && rtn.length) {
	   document.getElementById("wayid").value = rtn;//[0]
	   return rtn;
	}
}
function doSubmit(){// onsubmit="return doSubmit();"
	var wayid = $('#wayid').val();
	if(wayid==null || wayid==''){
		alert("[渠道编码]不能为空。");	
		return false;
	}
	var month = $('#month').val();
	var supportPaymonth = $('#supportPaymonth').val();
	var oprmonth = $('#oprmonth').val();
	if(supportPaymonth=='true'){
		var paymonth = $('#paymonth').val();
			if( (month==null || month=='') && (paymonth==null || paymonth=='') && (oprmonth==null || oprmonth=='') ){
			alert("[结算月份]、[付款月份]、[业务发生月]不能同时为空");
			return false;
		}
	}else{
		if((month==null || month=='') && (oprmonth==null || oprmonth=='')){
			alert("[结算月份]、[业务发生月]不能同时为空不能为空。");	
			return false;
		}
	}
	return true;
}