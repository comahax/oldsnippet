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
	 * 从文件中获取订单编号进行组装，用“,”分隔，查找系统参数44
	 * @return
	 * @throws Exception
	 */
	public String doGetSysParam() throws Exception {
		ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		DBAccessUser user = (DBAccessUser) ActionContext.getContext().getSession().get(WebConstant.SESSION_ATTRIBUTE_USER);
		Sysparam sysparam = (Sysparam) BOFactory.build(SysparamBO.class, user);
		String paramValue = sysparam.doFindByID("44", "pboss_fx");//获取系统参数id为44
		String resultString = paramValue;
		/*
		 * 订单审核时，是否对系统库存量进行检查，如库存不足则不能通过。1-是 0-否
		 * 如果是"否"时，就不需要从文件中取得订单号了。
		 */
		if("1".equals(paramValue)){
			//从文件中取得订单号，进行组装
			String filename = ServletActionContext.getRequest().getParameter("filename");
			File file = new File(filename);
			if (file == null || !file.exists()) {
				throw new JOPException("要处理的文件并不存在,请先上传");
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
