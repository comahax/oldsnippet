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
			      throw new Exception("��ѡ����ȷ��ʽ���ļ��ϴ�!");
			}
			ICheckFormat iCheckFormat = uploadFileForm.getCheckFormat();
			file = getFile(uploadFileForm.getTheFile(), request, opercode);// ������ļ���
			//��������д��parameterMap�ͱ��ļ�����
			HashMap parameterMap=serializeParameter(file,request,form);
			 //����ļ����ʹ�С��,������
			iCheckFormat.checkFile(uploadFileForm.getTheFile(),parameterMap);
			checkFile(uploadFileForm.getTheFile(), file, iCheckFormat);// ����ļ�ÿ�и�ʽ
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
