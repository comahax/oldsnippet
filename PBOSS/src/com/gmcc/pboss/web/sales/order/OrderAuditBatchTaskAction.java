package com.gmcc.pboss.web.sales.order;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.common.batch.processfile.BatchTaskAction;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.opensymphony.xwork2.ActionContext;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.ui.struts2.WebConstant;

public class OrderAuditBatchTaskAction extends BatchTaskAction {

	/**
	 * ���ļ��л�ȡ������Ž�����װ���á�,���ָ�������ϵͳ����44
	 * @return
	 * @throws Exception
	 */
	public String doGetSysParam() throws Exception {
		ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		DBAccessUser user = (DBAccessUser) ActionContext.getContext().getSession().get(WebConstant.SESSION_ATTRIBUTE_USER);
		Sysparam sysparam = (Sysparam) BOFactory.build(SysparamBO.class, user);
		String paramValue = sysparam.doFindByID("44", "pboss_fx");//��ȡϵͳ����idΪ44
		String resultString = paramValue;
		/*
		 * �������ʱ���Ƿ��ϵͳ��������м�飬���治������ͨ����1-�� 0-��
		 * �����"��"ʱ���Ͳ���Ҫ���ļ���ȡ�ö������ˡ�
		 */
		if("1".equals(paramValue)){
			//���ļ���ȡ�ö����ţ�������װ
			String filename = ServletActionContext.getRequest().getParameter("filename");
			File file = new File(filename);
			if (file == null || !file.exists()) {
				throw new JOPException("Ҫ������ļ���������,�����ϴ�");
			}
			FileInputStream fileInputStream = new FileInputStream(filename);
			InputStreamReader read = new InputStreamReader(fileInputStream, "gbk");
			BufferedReader rin = new BufferedReader(read);
			StringBuffer orderidStr = new StringBuffer();
			try {
				String line;
				while ((line = rin.readLine()) != null) {
					if (null != line && line.trim().length() > 0) {
						orderidStr.append("," + line);
					}
				}
			} catch (Exception ex) {
				throw new Exception(ex);
			} finally {
				rin.close();
				read.close();
			}
			resultString += ";" + (orderidStr.length() > 0 ? orderidStr.substring(1) : "-1");
		}else{
			resultString = "0;-1";
		}
		out.write(resultString);
		return null;
	}

}
