package com.sunrise.boss.ui.cms.commons;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.upload.FormFile;

import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>
 * Title: UploadFile
 * </p>
 * <p>
 * Description:上传文件
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: Sunrise
 * </p>
 * 
 * @author yjr
 * @version 1.0
 */
public class UploadFile {

	/**
	 * 上传
	 * @param savePath
	 * @param ff
	 * @throws Exception
	 */
	public static boolean doUpLoadFile(String savePath, FormFile ff,HttpServletRequest request)
			throws Exception {
        
        int fileMaxSize = 1024 * 1024;//文件最大限额
        int fileSize = ff.getFileSize();//取得文件尺寸

        if (fileSize > fileMaxSize) {
        	request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "上传文件不能超过1M,请重试!");
        	return false;
        }

		/* 如果指定的文件夹不存在就创建文件夹 */
		try {
			if (!(new File(savePath).isDirectory())) {
				new File(savePath).mkdirs();
			}
		} catch (SecurityException e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "创建文件夹出错");
		}
		
		/* 上传文件到指定的文件夹 */
		try {
			InputStream in = null;
			in = ff.getInputStream();
			OutputStream out = new FileOutputStream(savePath + ff.getFileName());
			int bytesRead = 0;
			byte[] buffer = new byte[8192];
			while ((bytesRead = in.read(buffer, 0, 8192)) != -1) {
				out.write(buffer, 0, bytesRead);
			}
			out.close();
			in.close();
		} catch (Exception ex) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "上传文件出错");
		}
		
		return true;
	}

	/**
	 * 下载
	 * @param savePath
	 * @param ff
	 * @throws Exception
	 */
	public static void doDownLoad(String filePath, String fileName,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

        File file   =   new File(filePath + fileName);   
        if(!file.exists()){
        	request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "对不起!您下载的文件已经不存在");
        	return;
        }
        	
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			response.reset();
			response.setContentType(UploadFile.getContentType(fileName));
			response.setHeader("Content-disposition", "attachment;filename="+ URLEncoder.encode(fileName, "utf-8"));
			bis = new BufferedInputStream(new FileInputStream(filePath + fileName));
			bos = new BufferedOutputStream(response.getOutputStream());

			int bytesRead = 0;
			byte[] buffer = new byte[5 * 1024];
			while ((bytesRead = bis.read(buffer)) != -1) {
				bos.write(buffer, 0, bytesRead);// 将文件发送到客户端
			}
		} catch (IOException e) {
			response.reset();
			// 设置文件物理下载时出现的错误信息
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "下载文件出错");
		} finally {
			try {
				if (bos != null) {
					bos.close();
				}
				if (bis != null) {
					bis.close();
				}
			} catch (IOException e) {
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,"下载文件出错");
			}
		}
	}

	/**
	 * 文件类型判断
	 * @param fileName
	 * @return
	 */
	public static String getContentType(String fileName) {
		String fileNameTmp = fileName.toLowerCase();
		String ret = "";
		if (fileNameTmp.endsWith("txt")) {
			ret = "text/plain";
		}
		if (fileNameTmp.endsWith("gif")) {
			ret = "image/gif";
		}
		if (fileNameTmp.endsWith("jpg")) {
			ret = "image/jpeg";
		}
		if (fileNameTmp.endsWith("jpeg")) {
			ret = "image/jpeg";
		}
		if (fileNameTmp.endsWith("jpe")) {
			ret = "image/jpeg";
		}
		if (fileNameTmp.endsWith("zip")) {
			ret = "application/zip";
		}
		if (fileNameTmp.endsWith("rar")) {
			ret = "application/rar";
		}
		if (fileNameTmp.endsWith("doc")) {
			ret = "application/msword";
		}
		if (fileNameTmp.endsWith("ppt")) {
			ret = "application/vnd.ms-powerpoint";
		}
		if (fileNameTmp.endsWith("xls")) {
			ret = "application/vnd.ms-excel";
		}
		if (fileNameTmp.endsWith("html")) {
			ret = "text/html";
		}
		if (fileNameTmp.endsWith("htm")) {
			ret = "text/html";
		}
		if (fileNameTmp.endsWith("tif")) {
			ret = "image/tiff";
		}
		if (fileNameTmp.endsWith("tiff")) {
			ret = "image/tiff";
		}
		if (fileNameTmp.endsWith("pdf")) {
			ret = "application/pdf";
		}
		return ret;
	}
}
