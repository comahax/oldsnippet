var menu = document.getElementById("MenuBarC"),
	tmpUL = menu.getElementsByTagName("ul")[0],
	menuTops = [];
		
		
	//过滤子节点，保证子节点是li元素
	for(var i=0; i<tmpUL.childNodes.length; i++)
	{
		if(tmpUL.childNodes[i].tagName == "LI")
			menuTops.push(tmpUL.childNodes[i]);
	}
	
	for(var i=0; i<menuTops.length; i++)
	{
		if(menuTops[i].getElementsByTagName("ul")[0] !== undefined)
		{
			menuTops[i].onmouseover = function(){
				this.getElementsByTagName("ul")[0].style.display="block";
			}
			menuTops[i].getElementsByTagName("ul")[0].onmouseout = function(){
				this.style.display="none";
			}
		}
	}