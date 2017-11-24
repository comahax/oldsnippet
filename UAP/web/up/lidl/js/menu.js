
function initMenu(menuid,contentid,ulid,domManager) {
  $(menuid+' dd').hide();
  var dtElement =$(menuid+' dt:first').next();
  while(dtElement.is('dd')){
	  dtElement.show();
	  dtElement = dtElement.next();
  }
  if($(menuid+' dt:first').get(0).getElementsByTagName("img").length>0){
	  $(menuid+' dt:first').get(0).getElementsByTagName("img")[0].src
	  =basePath+'sy/images/icondown.gif';
  }
  $(menuid+' dt').click(
    function() {
    	var checkElement = $(this).next();
      if((checkElement.is('dd')) && (checkElement.is(':visible'))) {
    	  this.getElementsByTagName("img")[0].src=basePath+'sy/images/icondown.gif';
        return ;
      }
      if((checkElement.is('dd')) && (!checkElement.is(':visible'))) {
    	  var dts = document.getElementById(menuid.substring(1)).getElementsByTagName("dt");
    	  for(var i=0;i<dts.length;i++){
    		  if(dts[i].getElementsByTagName("img").length>0){
    			  dts[i].getElementsByTagName("img")[0].src=basePath+'sy/images/iconright.gif';
    		  }
    	  }
    	  if(this.getElementsByTagName("img").length>0){
    		  this.getElementsByTagName("img")[0].src=basePath+'sy/images/icondown.gif';
    	  }
          $(menuid+' dd').hide();
        while(checkElement.is('dd')){
        	checkElement.show();
        	checkElement = checkElement.next();
        }
        return false;
        }
      
      tonclick(this.id,contentid,ulid,domManager);
      }
    );
  
  $(menuid+' dd').click(
	  function(){
		  tonclick(this.id,contentid,ulid,domManager);
	  }
   );
 }

function getHttpRequest(){
	var req;
	if(window.XMLHttpRequest){
		req = new XMLHttpRequest;
	}else if(window.ActiveXObject){
		req = new ActiveXObject("Microsoft.XMLHTTP");
	}
	return req;
}

function createMenu(url){
	req.open("GET", url, true);
	req.onreadystatechange=handleResponseText;
	req.send(null);
}

function createDT(parent,o){
	var dt = document.createElement("dt");
	dt.setAttribute("id", o.menuid);
	dt.innerHTML = o.menuname;
	parent.appendChild(dt);
	
}
function createDD(o,refChild){
	var imglist = refChild.getElementsByTagName("img");
	if(imglist.length<1){
		refChild.innerHTML = '<img src="'+basePath+'sy/images/iconright.gif" class="myimg2"/>'
		+refChild.innerHTML;
	}
	var dd = document.createElement("dd");
	dd.setAttribute("id", o.menuid);
	dd.className = "moutdd";
	dd.onmouseover = function(){this.className='movedd';};
	dd.onmouseout = function(){this.className='moutdd';};;
	dd.innerHTML = o.menuname;//o.funcname;
	insertAfter(dd, refChild);
	
}

function insertAfter(newElement,targetElement) {
	  var parent = targetElement.parentNode;
	  if (parent.lastChild == targetElement) {
	    // 如果最后的节点是目标元素，则直接添加。因为默认是最后
	    parent.appendChild(newElement);
	  } else {
		  parent.insertBefore(newElement,targetElement.nextSibling);
	//如果不是，则插入在目标元素的下一个兄弟节点的前面。也就是目标元素的后面。
	  }
}