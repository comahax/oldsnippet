/**
* auto-generated code
* Wed Sep 04 16:18:46 CST 2013
*/
package com.sunrise.boss.ui.cms.provagent.chpdreportitem;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.sunrise.boss.business.cms.provagent.chpdreportfile.persistent.ChPdReportfileListVO;
import com.sunrise.boss.business.cms.provagent.chpdreportfile.persistent.ChPdReportfileVO;
import com.sunrise.boss.business.cms.provagent.chpdreportitem.persistent.ChPdReportitemListVO;
import com.sunrise.boss.business.cms.provagent.chpdreportitem.persistent.ChPdReportitemVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.cms.provagent.chpdreportfile.ChPdReportfileDelegate;
import com.sunrise.boss.delegate.cms.provagent.chpdreportitem.ChPdReportitemDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.ui.commons.ftp.FtpAccess;
import com.sunrise.boss.ui.commons.ftp.FtpBusUtils;
import com.sunrise.boss.ui.commons.ftp.FtpInfo;
import com.sunrise.boss.ui.resmanage.common.ResPubUtil;

/**
 * <p>Title: ChPdReportitemAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public class ChPdReportitemAction extends BaseAction {
    public ChPdReportitemAction() {
            setVoClass(ChPdReportitemVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "itemid"; 
    }

	protected ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		ChPdReportitemForm form = (ChPdReportitemForm) actionForm;
		if (form.isQuery()) {
			ChPdReportitemListVO params = new ChPdReportitemListVO();
			setListVO(params, form);
			ChPdReportitemDelegate delegate = new ChPdReportitemDelegate();
			DataPackage dp = delegate.doQuery(params, user);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		}
		return actionMapping.findForward("list");
	}

	public ActionForward doExcel(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("代理商酬金报表数据查询");
		export.appendHeadLine(new String[] { "导出工号:", user.getOpercode() });
		export.appendHeadLine(new String[] { "导出时间:", format.format(new Date()) });
		export.addOutputProperty("itemid", "序号");
		export.addOutputProperty("cityid", "地市标识", export.CODE2NAME, "#REGIONNAME");
		export.addOutputProperty("provagentid", "代理商编码");
		export.addOutputProperty("provagentid", "代理商名称", export.CODE2NAME, "#CH_PD_AGENT");
		export.addOutputProperty("rewardmonth", "计酬月份");
		export.addOutputProperty("columncode", "细项标识");
		export.addOutputProperty("columnname", "细项名称");
		export.addOutputProperty("rewardsum", "酬金金额");
		
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		export.voClassArray = new Class[] {voClass};
		export.queryMethodName = "doList";
		if (export.headtitle == null) {
			export.headtitle = export.getFileName();
		}
		export.buildExcelPage(actionMapping, actionForm, request, response, user, this);
    	return null;
	}

	public ActionForward doReport(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		ChPdReportitemForm form = (ChPdReportitemForm) actionForm;
		ChPdReportfileListVO params = new ChPdReportfileListVO();
		params.set_se_provagentid(form.get_se_provagentid());
		params.set_se_rewardmonth(form.get_se_rewardmonth());
		ChPdReportfileDelegate delegate = new ChPdReportfileDelegate();
		DataPackage dp = delegate.doQuery(params, user);
		if (dp == null || dp.getDatas() == null || dp.getDatas().size() <= 0) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "报表尚未生成，请耐心等待。");
			return doList(actionMapping, actionForm, request, response, user);
		}
		if (dp.getDatas().size() > 1) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "后台存在多封报表，请联系开发商处理。");
			return doList(actionMapping, actionForm, request, response, user);
		}
		Iterator<ChPdReportfileVO> iter = dp.getDatas().iterator();
		if (iter.hasNext()) {
			ChPdReportfileVO reportFile = iter.next();
			String filePath = reportFile.getPathname();
			if (StringUtils.isBlank(filePath)) {
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "报表文件路径不存在，无法下载！");
				return doList(actionMapping, actionForm, request, response, user);
			}
			
			// 根据文件路径，通过FTP方式下载报表
			FtpInfo ftpInfo = ResPubUtil.getFtpInfo(user);
			FtpAccess ftp = new FtpAccess(ftpInfo);
			String localPath = FtpBusUtils.getDownloadRealPath(servlet);
			ftp.ftp.setFileType(ftp.ftp.BINARY_FILE_TYPE);
			localPath = ftp.downloadFile(localPath, filePath);
			if (localPath == null) {
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, 
						"服务器文件不存在，下载失败： " + ftp.ftp.getReplyString());
				return doList(actionMapping, actionForm, request, response, user);
			}
			
			response.setHeader("pragma", "no-cache");
			response.setHeader("Cache-control", "public");
			response.setHeader("Expires", "01 Apr 1995 01:10:10 GMT");
			String fn = "attachment; filename=" + getFileName(filePath);
			response.setHeader("Content-Disposition", new String(fn.getBytes("GBK"), "ISO-8859-1"));
			response.setContentType("application/x-msdownload");
			byte abyte[] = new byte[65000];
			int k = 0;
			java.io.File file = new java.io.File(localPath);
			FileInputStream fileinputstream = new FileInputStream(file);
			long l = file.length();
			while ((long) k < l) {
				int j = fileinputstream.read(abyte, 0, 65000);
				k += j;
				response.getOutputStream().write(abyte, 0, j);
			}
			response.getOutputStream().close();
			fileinputstream.close();
		}
		return null;
	}
	
	private String getFileName(String s) {
        int i = 0;
        i = s.lastIndexOf('/');
        if(i != -1)
            return s.substring(i + 1, s.length());
        i = s.lastIndexOf('\\');
        if(i != -1)
            return s.substring(i + 1, s.length());
        else
            return s;
    }
}
