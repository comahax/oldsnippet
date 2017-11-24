package com.gmcc.pboss.web.common.batch.upload;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import com.gmcc.pboss.common.PbossConstant;
import com.opensymphony.xwork2.ActionSupport;
import com.sunrise.jop.common.utils.i18n.I18nMessage;
import com.sunrise.jop.ui.struts2.BaseAction;

public class UploadAction extends BaseAction{

	private File upload[];				//上传的文件数据
	private String[] uploadFileName;	//上传的文件名称(临时)
	private String[] uploadContentType;	//文件类型
	
	
	private String forward;				//转发
	private String[] fileName;
	
	public String doUpload(){
		String tempName;
		String realName;
		String suffix;
		int count = 0;//成功数
		List fileNameList = new ArrayList();
		for(int i = upload.length-1;i>=0;i--){
			try{
				tempName = upload[i].getName();
				tempName = tempName.substring(0,tempName.lastIndexOf('.'));//获取STRUTS2生成的临时文件名称
				suffix = uploadFileName[i].substring(uploadFileName[i].lastIndexOf('.'));//获取文件格式（后缀）
				realName = tempName+suffix;
				File realFile = new File(PbossConstant.SAVE_FILE_DIR+realName);
				copy(upload[i],realFile);//把文件从临时文件拷贝到指定文件中
				fileNameList.add(realName);//记录成功拷贝的文件名（指定目录下的文件名）
				count++;
			}catch(Exception e){
				e.printStackTrace();
				super.addActionError(I18nMessage.getPublicString("error_detail_msg")+"["+uploadFileName[i]+"]:"+e.getMessage());
			}
		}
		fileName = (String[])fileNameList.toArray(new String[fileNameList.size()]);
		
		super.addActionMessage("成功上传文件数["+count+"]");
		return forward;
	}

	public String doGoUploadPage(){
		return forward;
	}
	
	
	
	/**
	 * 拷贝文件
	 * @param src 源文件
	 * @param dst 目标文件
	 * @throws Exception
	 */
	 private void copy(File src, File dst) throws Exception {     
	        InputStream in = null;
	        OutputStream out = null;
	        try{                
	            in = new BufferedInputStream( new FileInputStream(src));
	            out = new BufferedOutputStream( new FileOutputStream(dst)); 
	            
	            byte [] buffer = new byte [1024];    
	            while (in.read(buffer) > 0 )    
	                out.write(buffer);      
	            in.close();
	            out.close(); 
	        }catch (Exception e){    
	            e.printStackTrace();
	            throw e;
	        }     
	            
	    }

	
	public File[] getUpload() {
		return upload;
	}

	public void setUpload(File[] upload) {
		this.upload = upload;
	}

	public String[] getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String[] uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String[] getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String[] uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getForward() {
		return forward;
	}

	public void setForward(String forward) {
		this.forward = forward;
	}

	public String[] getFileName() {
		return fileName;
	}

	public void setFileName(String[] fileName) {
		this.fileName = fileName;
	}


}
