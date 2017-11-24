var initDateByYear = function(textId,yearRange) {
	var jqTextObj = $("#"+textId);
	jqTextObj.attr("readOnly",true);

	var dateSetting = {
		showAnim:'slideDown',
		duration:'fast',
		dateFormat:"yy-mm-dd",
		buttonImage: '/images/date_icon.gif',
		buttonImageOnly: true,   
		showOn: 'both', 
		monthNames: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月'],
		monthNamesShort: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月'],
		dayNames: ['星期日', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六'],
		dayNamesMin: ['日', '一', '二', '三', '四', '五', '六'],
		dayNamesShort: ['日', '一', '二', '三', '四', '五', '六'],
		clearText:'清除',
		closeText:'关闭', 
		prevText:'前一月', 
		nextText:'后一月', 
		changeMonth: true,
		changeYear: true,
		yearRange: yearRange,
		onClose:function(dateText, inst){
		
		}
	};

	jqTextObj.datepicker(dateSetting);
};

var initDate = function(textId) {
  initDateByYear(textId,'-10:+10');
}