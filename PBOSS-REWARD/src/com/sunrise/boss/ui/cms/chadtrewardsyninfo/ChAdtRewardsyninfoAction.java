/**
* auto-generated code
* Mon Apr 01 16:53:28 CST 2013
*/
package com.sunrise.boss.ui.cms.chadtrewardsyninfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.chadtrewardsyninfo.persistent.ChAdtRewardsyninfoListVO;
import com.sunrise.boss.business.cms.chadtrewardsyninfo.persistent.ChAdtRewardsyninfoVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.cms.chadtrewardsyninfo.ChAdtRewardsyninfoDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.ui.commons.ftp.FtpAccess;
import com.sunrise.boss.ui.commons.ftp.FtpBusUtils;
import com.sunrise.boss.ui.commons.ftp.FtpInfo;
import com.sunrise.boss.ui.resmanage.common.ResPubUtil;

/**
 * <p>Title: ChAdtRewardsyninfoAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public class ChAdtRewardsyninfoAction extends BaseAction {
    public ChAdtRewardsyninfoAction() {
            setVoClass(ChAdtRewardsyninfoVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "taskid"; 
    }

	@Override
	protected ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		ChAdtRewardsyninfoForm listForm = (ChAdtRewardsyninfoForm) actionForm;
		ChAdtRewardsyninfoListVO params = new ChAdtRewardsyninfoListVO();
		setListVO(params, listForm);
		ChAdtRewardsyninfoDelegate delegate = new ChAdtRewardsyninfoDelegate();
		DataPackage dp = delegate.doQuery(params, user);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		return actionMapping.findForward("list");
	}
    
	public ActionForward doDownload(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			String filename = request.getParameter("down");
			if (filename == null || "".equals(filename.trim())) {
				throw new BusinessException("", "文件路径为空！");
			}
			FtpInfo ftpInfo = ResPubUtil.getFtpInfo(user);
			FtpAccess ftp = new FtpAccess(ftpInfo);
			String localPath = FtpBusUtils.getDownloadRealPath(servlet);
			localPath = ftp.downloadFile(localPath, filename);
			if (localPath == null) {
				throw new BusinessException("", "下载失败！" + ftp.ftp.getReplyString());
			}
			request.setAttribute("filename", FtpBusUtils.getDownloadFilename(servlet, filename));
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
			return doList(actionMapping, actionForm, request, response, user);
		}
		return actionMapping.findForward("down");
	}
}
