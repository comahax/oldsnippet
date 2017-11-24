function AutoSize(adaptedDomId){
	var el = document.getElementById(adaptedDomId)
	window.onload = function(){
		window.resizeTo(el.clientWidth, el.clientHeight);
	}
}