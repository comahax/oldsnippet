package com.gmcc.pboss.web.channel.checkedapply;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.channel.checkedapply.CheckedapplyDBParam;
import com.gmcc.pboss.common.batch.upload.UploadFileAction;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.WebConstant;

public class BatchTaskAction extends UploadFileAction {
	public static final String BATCH_TASK_ACTION = "BATCH";
	public static final String UPLOAD_TASK_ACTION = "UPLOAD";

	public String getShow() {
		return show;
	}

	public void setShow(String show) {
		this.show = show;
	}

	private String show;

	public String execute() throws Exception {
		if (getCommandString(ServletActionContext.getRequest()).equals(
				BATCH_TASK_ACTION)) {
			try {
				return doProcess();
			} catch (Exception ex) {
				String msg = ex.getMessage();
				if (ex instanceof FileNotFoundException) {// �����ļ�·��
					msg = "ϵͳ�Ҳ���ָ�����ļ�";
				}
				addActionError(msg);
				return ERROR;
			}
		} else {
			return super.execute();
		}
	}

	protected String getCommandString(HttpServletRequest request) {
		String cmd = request.getParameter(WebConstant.PAGE_ATTRIBUTE_COMMAND);
		return (cmd == null) ? BATCH_TASK_ACTION : cmd;
	}

	/**
	 * ����bean����
	 */
	protected String doProcess() throws Exception {
		try {
			String filename = ServletActionContext.getRequest().getParameter(
					"filename");
			File file = new File(filename);
			if (!file.exists()) {
				throw new JOPException("Ҫ������ļ���������,�����ϴ�");
			}
			String beanname = ServletActionContext.getRequest().getParameter(
					"beanname");
			HttpSession session = ServletActionContext.getRequest()
					.getSession();
			ServletActionContext.getRequest().setAttribute("show", "true");
			CheckedapplyTaskBean bean = (CheckedapplyTaskBean) Class
					.forName(beanname).newInstance();
			// BeanUtils.copyProperties(bean, getForm());
			if (filename != null && !filename.trim().equals("")) {
				bean.setFilename(filename);
			}
			User user = (User) ServletActionContext.getRequest().getSession()
					.getAttribute("USER");
			CheckedapplyDBParam batchparams = (CheckedapplyDBParam)ServletActionContext.getRequest().getSession().getAttribute("checkparam");
			bean.setApplyno(batchparams.getApplyeno());
			// changed by liwenjing
			// if(user==null){ //������ģ��,�Ժ�Ҫ���δ˴���
			// user=new User();
			// user.setLogintime(new Date());
			// user.setOpercode("sunriseOpercode");
			// user.setOpername("sunriseOpername");
			// user.setWayid("sunriseWayid");
			// }
			// ��ȡ���ļ�����,��ֵ����,������Ϻ�ı���ʾ���ϴ�ʱ�ı�һ��
			String parameterFileName = filename.replaceFirst("\\.txt$",
					UploadFileAction.PARAMETER + ".txt");
			parameterFileName = parameterFileName.replaceFirst("\\.xls$",
					UploadFileAction.PARAMETER + ".txt");
			FileInputStream in = new FileInputStream(parameterFileName);
			ObjectInputStream oi = new ObjectInputStream(in);
			HashMap parameterMap = (HashMap) oi.readObject();
			parameterMap.put("filename", filename);
			Object hasTitle = parameterMap.get("hasTitle");
			try{
				if(null != hasTitle)
				bean.setHasTitle(new Boolean((String)hasTitle));//�����Ƿ��б�����
			}catch(Exception e){
				
			}
			ServletActionContext.getRequest().setAttribute("parameterMap",
					parameterMap);
			setShow("true");
			// BeanUtils.copyProperties(getForm(), parameterMap);
			oi.close();
			in.close();
			// ɾ�����ļ�o
			File parameterFile = new File(parameterFileName);
			parameterFile.delete();
			// �����߳�����
			bean.setUser(user);
			bean.setParameterMap(parameterMap);
			// bean.setForm((ActionForm) getForm());
			Thread thread = new Thread(bean);
			// ��bean���ַ���beanMap,�Ա�׼ȷ��ʾ����
			HashMap beanMap = (HashMap) session.getAttribute("beanMap");
			if (beanMap == null) {// ��һ����������ʱΪ��
				beanMap = new HashMap();
				session.setAttribute("beanMap", beanMap);
			}
			beanMap.put(beanname, bean);
			thread.start();
			return SUCCESS;
		} catch (Exception ex) {
			addActionError(ex.getMessage());
			ex.printStackTrace();
			return ERROR;
		}
	}
}
