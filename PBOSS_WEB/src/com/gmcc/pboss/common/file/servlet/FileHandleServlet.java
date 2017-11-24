package com.gmcc.pboss.common.file.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.gmcc.pboss.biz.communi.service.CommunicateReplyService;
import com.gmcc.pboss.biz.communi.support.CommunicateReplyParameter;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.file.IFileHandle;
import com.gmcc.pboss.common.file.bean.FileHandleConfig;
import com.gmcc.pboss.common.file.bean.FileHandleResult;
import com.gmcc.pboss.common.file.bean.FileUploadBean;
import com.gmcc.pboss.common.file.bean.ServerInfoBean;
import com.gmcc.pboss.common.file.dictionary.FileHandleRetCode;
import com.gmcc.pboss.common.file.dictionary.FileHandleType;
import com.gmcc.pboss.common.file.impl.FTPFileHandleImpl;
import com.gmcc.pboss.common.file.util.FileHandleUtil;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceRetCode;
import com.gmcc.pboss.common.service.ServiceType;
import com.gmcc.pboss.common.servlet.BaseServlet;

/**
 * 从兴公司电子渠道业务部
 * @author tangzhu
 * @date 2009-10-21
 * 所属项目：PBOSS
 * 所属模块：门户网站
 * 描述：负责文件处理的Action类
 */
public class FileHandleServlet extends BaseServlet {
	/**
	 * 负责文件处理的Action类
	 */
	private static final long serialVersionUID = 2539628145764000468L;
	private static Logger logger = Logger.getLogger(FileHandleServlet.class);
	private static final String UPLOAD_TYPE = "uploadType";
	
	/**
	 * 上传
	 * by zhangsiwei
	 * @since 2010-01-22 修改为上传到FTP服务器
	 */
	public FileHandleResult doUpload(HttpServletRequest request,String uploadType){
		
		String userName = "COMMON";
		FileHandleResult result = null;
		
		//读取配置文件
		FileHandleConfig uploadConfig = FileHandleUtil.getUploadConfig();
		FileUploadBean config = (FileUploadBean)uploadConfig.getUploadFiles().get(uploadType);
		ServerInfoBean ftpInfo = uploadConfig.getServer();
		if(config == null){
			result = new FileHandleResult(FileHandleType.UPLOAD);
			result.setSuccess(false);
			result.setRetCode(FileHandleRetCode.UPLOAD_LOADINGFAIL);
			
			return result;
		}
		
		LoginMember member = getLoginMember(request);
		//上传是否需要登录
		if(config.isNeedLogin() && member == null){
			result = new FileHandleResult(FileHandleType.UPLOAD);
			result.setSuccess(false);
			result.setRetCode(FileHandleRetCode.UNLOGIN);
		}
		else{
			//调用上传文件接口
			userName = (member != null)?member.getWayid():userName;
			IFileHandle handle = new FTPFileHandleImpl(userName,FileHandleType.UPLOAD);
			result = handle.upload(request, config, ftpInfo);
			
			//上传文件成功
			if(result.isSuccess()){
				String advinfoid = this.getRequestParameter(request, "advinfoid");
				String file = (String)result.getRetObj();
				
				ServiceResult serviceResult = saveQuesionareAffix(member, file, new Long(advinfoid));
				result.setMessage(serviceResult.getMessage());
				result.setSuccess(serviceResult.isSuccess());
				result.setRetCode(serviceResult.getRetCode());
				
				//更新数据库失败删除掉上传的文件
				if(!serviceResult.isSuccess()){
					FileHandleUtil.deleteFileByPath(file);
				}
			}
		}
		
		
		return result;
	}
	/**
	 * 保存调查问卷上传文件
	 * @param member
	 * @param file
	 * @return
	 */
	public ServiceResult saveQuesionareAffix(LoginMember member, String file, Long advinfoid){
		ServiceResult result = new ServiceResult();
		
		try {
		
			//CommunicateReplyService service = (CommunicateReplyService)ContextUtil.getContext().getBean("communicateReplyService");
			//在Spring容器中得到Service对象
			WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext()); 
			CommunicateReplyService service = (CommunicateReplyService)ctx.getBean("communicateReplyService");
			
			//创建Parameter
			CommunicateReplyParameter parameter = new CommunicateReplyParameter();
			parameter.setAdvinfoid(advinfoid);
			parameter.setAffix(file);
			parameter.setOid(member.getEmployeeid());
		
		
			result = service.transactionProcessing(member, parameter, ServiceType.INITIATE);
		} 
		catch (Exception e) {
			result.setSuccess(false);
			result.setRetCode(ServiceRetCode.EXCEPTION);
			
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 入口
	 */
	public String perform(HttpServletRequest request,
			HttpServletResponse response, LoginMember member, String operation) {
		// TODO Auto-generated method stub
		FileHandleResult result = null;
		if(operation.equalsIgnoreCase(FileHandleType.UPLOAD)){
			String uploadType = getRequestParameter(request, UPLOAD_TYPE);
			result = this.doUpload(request, uploadType);
		}
		returnResult(response, operation, result);
		return null;
	}
	
	/**
	 * 返回客户端
	 * @param response
	 * @param result
	 */
	private void returnResult(HttpServletResponse response, String operation, FileHandleResult result){
		
		response.setCharacterEncoding("GBK");
		try {
			if(operation.equalsIgnoreCase(FileHandleType.UPLOAD)){
				response.getWriter().print(
					"<script>parent.f_uploadCallback( "+result.isSuccess()+","
													 +result.getRetCode()+",'"
													 +result.getMessage()+"')</script>");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

	
}
