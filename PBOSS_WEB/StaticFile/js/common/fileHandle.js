/*
 * �ļ�����JS
 */
 
 //�ļ��ϴ��ύ
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
 		alert("��ѡ���ϴ��ļ�");
 	}
 	//
 }
 
 /**
  * �õ��ļ���С
  */
function f_getFileSize(p){      
   var image=new Image();      
   image.dynsrc=p;      
   return (image.fileSize);      
}

/**
 * �ж��ļ��Ƿ����
 */
function f_fileIsExist(p){
	return true;
}

/**
 * �ж��ļ��Ƿ񳬳�����
 */
function f_fileIsOver(p,s){
	var y = false;
	
	if(!f_fileIsExist(p)){
		alert("�ϴ��ļ������ڡ�");
		y = true;	
	}
	/*
	else if(f_getFileSize(p) > s){
		alert("�����ļ��ϴ����ơ�");
		y = true;
	}
	*/
	
	return y;
}


 /*
  * �ļ��ϴ��ص�����
  * s���Ƿ�ɹ�
  * rc��������
  * m����ʾ��Ϣ
  */
 function f_uploadCallback(s,rc,m){
 	f_disabled('uploadButton',true);
 	if(s)
 		f_showSMsg(m);
 	else 
 		f_showEMsg(m);
 }