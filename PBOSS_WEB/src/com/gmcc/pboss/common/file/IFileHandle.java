package com.gmcc.pboss.common.file;

import javax.servlet.http.HttpServletRequest;

import com.gmcc.pboss.common.file.bean.FileHandleResult;
import com.gmcc.pboss.common.file.bean.FileUploadBean;
import com.gmcc.pboss.common.file.bean.ServerInfoBean;


/**
 * 从兴公司电子渠道业务部
 * @author tangzhu
 * @date 2009-10-21
 * 所属项目：PBOSS
 * 所属模块：门户网站
 * 描述：文件处理接口
 */
public interface IFileHandle {
	/**
	 * 文件上传
	 * @param request用户请求
	 * @param uploadConfig 上传文件配置信息
	 * @param ftpInfo FTP服务器信息
	 */
	public FileHandleResult upload(HttpServletRequest request,
			FileUploadBean uploadConfig, ServerInfoBean ftpInfo);
}
