function defalutBlankHadle(){
    	if(document.getElementsByTagName("table")!=null){
    		var tables = document.getElementsByTagName("table");
    		for(var i=0;i<tables.length;i++){
    			if(tables[i].parentNode.className.indexOf("list_table")!=-1
    			&&tables[i].parentNode.className.indexOf("overflow_scroll")!=-1){
    				if(tables[i].getElementsByTagName("tbody")[0].childNodes.length==0){
	    				for(var j=0;j<3;j++){
	    					var newTR = tables[i].insertRow(tables[i].rows.length);
	    					var newNameTD=newTR.insertCell(0);
	    					var l = tables[i].getElementsByTagName("thead")[0].firstChild.childNodes.length;
		    				newNameTD.colSpan=l>1?l:1;
		    				if(j==1){
		    					//newNameTD.innerHTML = '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+
		    					newNameTD.innerHTML = '<div style="padding-left:'+(tables[i].parentNode.clientWidth/2-40)+';height:10px;">'+
		    					'<font color="gray" size=2><em>无&nbsp;数&nbsp;据&nbsp;</em></font></div>';
		    				}else{
		    					newNameTD.className="trbg_2";
		    					newNameTD.innerHTML = "&nbsp;&nbsp;";
		    				}
	    				}
	    				
    				}
    			}
    		}
    	}
    }
    
    function blankHadle(id){
    	var table = document.getElementById(id);
   		if(table.getElementsByTagName("tbody")[0].childNodes.length==0){
   			for(var j=0;j<3;j++){
  				var newTR = table.insertRow(tables[i].rows.length);
  				var newNameTD=newTR.insertCell(0);
   				var l = table.getElementsByTagName("thead")[0].firstChild.childNodes.length;
   				newNameTD.colSpan=l>1?l:1;
   				if(j==1){
   					//newNameTD.innerHTML = '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+
   					newNameTD.innerHTML = '<div style="padding-left:'+(table.parentNode.clientWidth/2-40)+';height:10px;">'+
   					'<font color="gray" size=2><em>无&nbsp;数&nbsp;据&nbsp;</em></font></div>';
   				}else{
   					newNameTD.className="trbg_2";
   					newNameTD.innerHTML = "&nbsp;&nbsp;";
   				}
   			}
		}
    }
    
    function blankTableHandle(id){
    	//alert(document.getElementsByTagName("table")[1].parentNode.className);
    	if(id){
    		blankHadle(id);
    	}else{
    		defalutBlankHadle();
    	}
    	
    }
    
    function findMainWindow(w){
		if(w==null){
			if(window.document.getElementById("dmanager")){
				return window;
			}else if(window.parent!=null){alert("1:"+window.parent);
				findMainWindow(window.parent);
			}
		}else if(w.document.getElementById("dmanager")){
			return w;
		}else if(w.parent!=null){
			findMainWindow(w.parent);
		}
	}
    
    //$(document).ready(function(){
		//blankTableHandle();
		//mainWindow = findMainWindow().id;
		//alert(mainWindow.document.getElementById("dmanager").id);
	//})