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
		monthNames: ['һ��', '����', '����', '����', '����', '����', '����', '����', '����', 'ʮ��', 'ʮһ��', 'ʮ����'],
		monthNamesShort: ['һ��', '����', '����', '����', '����', '����', '����', '����', '����', 'ʮ��', 'ʮһ��', 'ʮ����'],
		dayNames: ['������', '����һ', '���ڶ�', '������', '������', '������', '������'],
		dayNamesMin: ['��', 'һ', '��', '��', '��', '��', '��'],
		dayNamesShort: ['��', 'һ', '��', '��', '��', '��', '��'],
		clearText:'���',
		closeText:'�ر�', 
		prevText:'ǰһ��', 
		nextText:'��һ��', 
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