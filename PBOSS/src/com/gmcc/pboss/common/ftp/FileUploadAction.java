package com.gmcc.pboss.common.ftp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Random;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 *处理文件上传的Action类
 * 
 * @authorqiujy
 *@version1.0
 */
public class FileUploadAction extends ActionSupport implements
		ServletContextAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4841554408005764493L;
	private static final int BUFFER_SIZE = 16 * 1024;
	// 文件标题
	private ServletContext context;
	private String title;

	public File getDoc() {
		return doc;
	}

	public void setDoc(File doc) {
		this.doc = doc;
	}

	public String getFileName() {
		return fileName;
	}

	public void setDocFileName(String fileName) {
		this.fileName = fileName;
	}

	private File doc;
	private String fileName;
	private String contentType;

	public String getContentType() {
		return contentType;
	}

	public void setDocContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	// 上传文件域对象
	private File upload;
	// 上传文件名
	private String uploadFileName;
	// 上传文件类型
	private String uploadContentType;
	// 保存文件的目录路径(通过依赖注入)
	private String savePath;

	// 以下省略getter和setter......
	// 自己封装的一个把源文件对象复制成目标文件对象
	private static void copy(File src, File dst) {
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new BufferedInputStream(new FileInputStream(src), BUFFER_SIZE);
			out = new BufferedOutputStream(new FileOutputStream(dst),
					BUFFER_SIZE);
			byte[] buffer = new byte[BUFFER_SIZE];
			int len = 0;
			while ((len = in.read(buffer)) > 0) {
				out.write(buffer, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != in) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != out) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public String execute() throws Exception {
		// 根据服务器的文件保存地址和原文件名创建目录文件全路径
		String dstPath = ServletActionContext.getServletContext().getRealPath(
				"/upload")
				+ "\\" + uploadFileName;

		System.out.println("上传的文件的类型：" + this.getUploadContentType());

		File dstFile = new File(dstPath);
		copy(this.upload, dstFile);
		return SUCCESS;
	}

	private String generateFileName(String fileName) {
		DateFormat format = new SimpleDateFormat("yyMMddHHmmss");
		String formatDate = format.format(new Date());

		int random = new Random().nextInt(10000);

		int position = fileName.lastIndexOf(".");
		String extension = fileName.substring(position);

		return formatDate + random + extension;
	}

	public void setServletContext(ServletContext context) {
		this.context = context;

	}
}