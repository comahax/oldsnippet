function initwindow () {
	//h=window.screen.availHeight-20;
	//w=window.screen.availWidth;
	//par="width="+w+",height="+h+",top=0,left=0,location=no,menubar=no,status=no";
	//var loginMainWin = window.open("index.html",'loginMainWin',par);	
	//window.opener=null;	
	//window.close();
	window.location.href="index.html";
	}
function resizwindow () {
	//top.moveTo(-4,-4);
	var p = menuonleft.offsetWidth;
	var d = document.getElementsByTagName("BODY")[0].offsetWidth;
	if (d - 450 > 200 && d - 450 < document.all("menuonleft").firstChild.childNodes.length / 2 * 88  ) {
		menuonleft.style.posWidth = d - 450;
	}else if (d - 450 <= 200){
		menuonleft.style.posWidth = 200;
	}else {
		menuonleft.style.posWidth = document.all("menuonleft").firstChild.childNodes.length / 2 * 88 ;
		}
	
	}