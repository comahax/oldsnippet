package com.sunrise.boss.ui.resmanage.task;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.resmanage.task.persistent.TaskVO;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.ui.commons.ftp.FtpAccess;
import com.sunrise.boss.ui.commons.ftp.FtpBusUtils;
import com.sunrise.boss.ui.commons.ftp.FtpInfo;
import com.sunrise.boss.ui.resmanage.common.ResPubUtil;

public class TaskAction extends BaseAction {

	public TaskAction() {
		this.voClass = TaskVO.class;
		this.pkNameArray = new String[] { "taskid" };
	}

	public ActionForward doShow(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {

		TaskForm form = (TaskForm) actionForm;
		Page.setPageSize(request, (BaseActionForm) actionForm);
		form.set_se_oprcode(user.getOpercode());
		form.set_se_wayid(user.getWayid());
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String today = df.format(new Date(System.currentTimeMillis()));
		form.set_dnl_createtime(today + " 00:00:00");
		form.set_dnm_createtime(today + " 23:59:59");
		form.set_orderby("taskid");
		form.set_desc("1");
		return doList(actionMapping, actionForm, request, response, user);

	}

	public ActionForward doDownload(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			String filename = request.getParameter("down");
			if (filename == null || "".equals(filename.trim())) {
				throw new Exception("文件路径为空！");
			}
			FtpInfo ftpInfo = ResPubUtil.getFtpInfo(user);
			FtpAccess ftp = new FtpAccess(ftpInfo);
			String localPath = FtpBusUtils.getDownloadRealPath(servlet);
			localPath = ftp.downloadFile(localPath, filename);
			if (localPath == null) {
				throw new Exception("下载失败！" + ftp.ftp.getReplyString());
			}
			request.setAttribute("filename", FtpBusUtils.getDownloadFilename(
					servlet, filename));
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
			return doList(actionMapping, actionForm, request, response, user);
		}
		return (actionMapping.findForward("down"));
	}

	/**
	 * 
	 */
	public ActionForward doExcel(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("批量处理任务查询 ");
		export.addOutputProperty("taskid", "任务标识");
		export.addOutputProperty("filecode","文件类型",CommonExportBean.CODE2NAME,"#FILEDEF");
		export.addOutputProperty("subsystem","归属子系统",CommonExportBean.CODE2NAME,"#SUBSYSTEM");
		export.addOutputProperty("taskstate","任务状态",CommonExportBean.CODE2NAME,"$IM_TASKSTATE");
		export.addOutputProperty("createtime","创建时间");
		export.addOutputProperty("exectime","执行时间");
		export.addOutputProperty("endtime","结束时间");
		export.addOutputProperty("oprcode","操作员工号");
		export.addOutputProperty("wayid","渠道",CommonExportBean.CODE2NAME,"#WAY");
		export.addOutputProperty("taskfilecount","任务文件数量 ");
		export.addOutputProperty("totalcount","总记录数");
		export.addOutputProperty("currentcount","已处理记录数");
		export.addOutputProperty("successcount","成功记录数");
		export.addOutputProperty("memo","备注");
		
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super
				.doExcel(actionMapping, actionForm, request, response, user);
	}

	public ActionForward doTxt(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("批量处理任务查询");
		export.addOutputProperty("taskid");
		export.addOutputProperty("filecode",CommonExportBean.CODE2NAME,"#FILEDEF");
		export.addOutputProperty("subsystem",CommonExportBean.CODE2NAME,"#SUBSYSTEM");
		export.addOutputProperty("taskstate",CommonExportBean.CODE2NAME,"$IM_TASKSTATE");
		export.addOutputProperty("createtime");
		export.addOutputProperty("exectime");
		export.addOutputProperty("endtime");
		export.addOutputProperty("oprcode");
		export.addOutputProperty("wayid",CommonExportBean.CODE2NAME,"#WAY");
		export.addOutputProperty("taskfilecount");
		export.addOutputProperty("totalcount");
		export.addOutputProperty("currentcount");
		export.addOutputProperty("successcount");
		export.addOutputProperty("memo");
		export.voClassArray = new Class[] { TaskVO.class };
		
		response.setCharacterEncoding("GBK");
		response.setHeader("pragma", "no-cache");
		response.setHeader("Cache-control", "public");
		response.setHeader("Expires", "01 Apr 1995 01:10:10 GMT");
		String fn = "attachment; filename=" + export.getFileName() + ".txt";
		response.setHeader("Content-Disposition", new String(
				fn.getBytes("GBK"), "ISO-8859-1"));
		response.setContentType("text/plain;charset=gbk");
		export.writeTxtTitle(response.getOutputStream(), new String[] {
				"任务标识", "文件类型", "归属子系统", "任务状态", "创建时间", "执行时间", "结束时间", "操作员工号",
				"渠道", "任务文件数量", "总记录数", "已处理记录数", "成功记录数", "备注"});
		super.ExportQuery(actionMapping, actionForm, request, response, user,
				export);
		return actionMapping.findForward(null);
	}

}
