package com.sunrise.boss.ui.resmanage.common;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.ui.commons.batch.upload.BatchResultForm;
import com.sunrise.boss.ui.commons.batch.upload.ICheckFormat;
import com.sunrise.boss.ui.commons.batch.upload.UploadFileAction;
import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

public class XMLUploadAction extends UploadFileAction{
	
	static final private String CONTENT_TYPE = "text/html; charset=GBK";
	
	public ActionForward execute(ActionMapping actionMapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType(CONTENT_TYPE);
		HttpSession session = request.getSession();
		BatchResultForm resultForm = new BatchResultForm();
		User user = (User) session
				.getAttribute(WebConstant.SESSION_ATTRIBUTE_USER);
		String opercode;
		String wayid;
		if (user != null) {
			opercode = user.getOpercode();
			wayid = user.getWayid();
		} else {
			opercode = "";
			wayid = "";
		}
		String file = "";
		try {
			UploadFileForm uploadFileForm = (UploadFileForm) form;
			if (uploadFileForm.getTheFile().getFileSize() == 0) {
			      throw new Exception("请选择正确格式的文件上传!");
			}
			ICheckFormat iCheckFormat = uploadFileForm.getCheckFormat();
			file = getFile(uploadFileForm.getTheFile(), request, opercode);// 获得新文件名
			//将表单数据写到parameterMap和表单文件当中
			HashMap parameterMap=serializeParameter(file,request,form);
			 //检查文件类型大小等,表单数据
			iCheckFormat.checkFile(uploadFileForm.getTheFile(),parameterMap);
			checkFile(uploadFileForm.getTheFile(), file, iCheckFormat);// 检查文件每行格式
			resultForm.setInFile(file);
			resultForm.setOpercode(opercode);
			resultForm.setWayid(wayid);
			
			request.setAttribute("updState","uploadSucess");
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_ITEM, resultForm);
			return actionMapping.findForward("success");
		} catch (Exception ex) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex.getMessage());
			return (actionMapping.findForward("error"));
		}
	}	
}
