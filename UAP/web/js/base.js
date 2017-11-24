function initwindow () {
	h=window.screen.availHeight-20;
	w=window.screen.availWidth;
	par="width="+w+",height="+h+",top=0,left=0,location=no,menubar=no,status=no";
	var loginMainWin = window.open("index.jsp",'loginMainWin',par);	
	window.opener=null;	
	window.close();
	}
function resizwindow () {
	top.moveTo(-4,-4);
	}