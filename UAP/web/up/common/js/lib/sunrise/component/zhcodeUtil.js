function autoTabsHeight(_this,tagsid,iframeids){
	var tabIdx = _this.parentNode.getAttribute("index");
	var tags = $su(tagsid);
	var contentNode = tags.contents[tabIdx];
	var varFrameElement;
	setTimeout(
		function(){
			if(iframeids!=null){
				document.getElementById(iframeids).style.height 
				= window.frames[iframeids].document.body.scrollHeight;
			}

			//resetAllWinHeight(window.frameElement);
			resetAllWinHeight(document.getElementById(iframeids));
		},
		100
	);
}