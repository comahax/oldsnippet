package com.sunrise.boss.ui.commons.batchlog;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.common.batchlog.persistent.BatchlogVO;
import com.sunrise.boss.delegate.common.batchlog.BatchlogDelegate;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.ui.commons.ftp.FtpAccess;
import com.sunrise.boss.ui.commons.ftp.FtpInfo;
import com.sunrise.boss.ui.commons.ftp.FtpBusUtils;

/**
 * @author liminghao
 * @version 1.0
 */
public class BatchlogAction extends BaseDelegateAction {
	public BatchlogAction() {
		this.voClass = BatchlogVO.class;
		this.pkNameArray = new String[1];
		pkNameArray[0] = "logid";
	}

	protected Object getDelegate() throws Exception {
		return new BatchlogDelegate();
	}

	public ActionForward doShow(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		BatchlogForm form = (BatchlogForm) actionForm;
		Page.setPageSize(request, (BaseActionForm) actionForm);
		form.set_se_oprcode(user.getOpercode());
		form.set_se_oprwayid(user.getWayid());
		Calendar cld = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String day=df.format(cld.getTime());
		form.set_dnl_optime(day+" 00:00:00");
		form.set_dnm_optime(day+" 23:59:59");
		form.set_orderby("optime");
		form.set_desc("1");
		return doList(actionMapping, actionForm, request, response, user);
	}

	/**
	 * 格式化处理listVO的值，作为查询条件，listVO已初始为listForm的值
	 */
	protected void setListVO(Object listVO, final ActionForm listForm) {
		try {
			BeanUtils.copyProperties(listVO, listForm);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ActionForward doDownload(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			String filename = request.getParameter("down");
			if (filename == null || "".equals(filename.trim())) {
				throw new Exception("文件路径为空！");
			}
			FtpAccess ftp = new FtpAccess(FtpInfo.getInstance());
			String localPath = FtpBusUtils.getDownloadRealPath(servlet);
			localPath = ftp.downloadFile(localPath, filename);
			if (localPath == null){
				throw new Exception("下载失败！"+ftp.ftp.getReplyString());
			}
			request.setAttribute("filename", FtpBusUtils.getDownloadFilename(
					servlet, filename));
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
			return doShow(actionMapping, actionForm, request, response, user);
		}
		return (actionMapping.findForward("down"));
	}
}
