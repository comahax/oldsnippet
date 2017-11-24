/*
 * 文件处理JS
 */
 
 //文件上传提交
 function f_submitUpload(){
 	var p = document.uploadForm.uploadFile.value;
 	
 	if(p != ""){
 		
 		var s = document.getElementById('fileSize').value;
 		if(!f_fileIsOver(p,s)){
 			
 			f_disabled('uploadButton',false);
 			document.uploadForm.submit();
 		}
 	}
 	else{
 		alert("请选择上传文件");
 	}
 	//
 }
 
 /**
  * 得到文件大小
  */
function f_getFileSize(p){      
   var image=new Image();      
   image.dynsrc=p;      
   return (image.fileSize);      
}

/**
 * 判断文件是否存在
 */
function f_fileIsExist(p){
	return true;
}

/**
 * 判断文件是否超出限制
 */
function f_fileIsOver(p,s){
	var y = false;
	
	if(!f_fileIsExist(p)){
		alert("上传文件不存在。");
		y = true;	
	}
	/*
	else if(f_getFileSize(p) > s){
		alert("超出文件上传限制。");
		y = true;
	}
	*/
	
	return y;
}


 /*
  * 文件上传回调方法
  * s：是否成功
  * rc：返回码
  * m：提示信息
  */
 function f_uploadCallback(s,rc,m){
 	f_disabled('uploadButton',true);
 	if(s)
 		f_showSMsg(m);
 	else 
 		f_showEMsg(m);
 }