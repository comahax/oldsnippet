/**
* auto-generated code
* Thu Mar 15 15:06:14 CST 2012
*/
package com.sunrise.boss.ui.cms.reward.adtrewardupload;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.reward.adtrewardupload.persistent.AdtRewarduploadVO;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.ui.commons.ftp.FtpAccess;
import com.sunrise.boss.ui.commons.ftp.FtpBusUtils;
import com.sunrise.boss.ui.commons.ftp.FtpInfo;
import com.sunrise.boss.ui.resmanage.common.ResPubUtil;

/**
 * <p>Title: AdtRewarduploadAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Qiu Zhi
 * @version 1.0
 */
public class AdtRewarduploadAction extends BaseDelegateAction {
    public AdtRewarduploadAction() {
            setVoClass(AdtRewarduploadVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "taskid"; 
    }
    
    public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
    	try {
    		AdtRewarduploadForm form = (AdtRewarduploadForm) actionForm;
    		form.set_orderby("taskid");
			form.set_desc("1");
	    	return super.doList(actionMapping, actionForm, request, response, user);
		} catch (BusinessException e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
			return (actionMapping.findForward("list"));
		}
    }
    
    public ActionForward doDownload(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			String filename = request.getParameter("down");
			if (filename == null || "".equals(filename.trim())) {
				throw new BusinessException("","文件路径为空！");
			}
			FtpInfo ftpInfo = ResPubUtil.getFtpInfo(user);
			FtpAccess ftp = new FtpAccess(ftpInfo);
			String localPath = FtpBusUtils.getDownloadRealPath(servlet);
			localPath = ftp.downloadFile(localPath, filename);
			if (localPath == null) {
				throw new BusinessException("","下载失败！" + ftp.ftp.getReplyString());
			}
			request.setAttribute("filename", FtpBusUtils.getDownloadFilename(
					servlet, filename));
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
//			log.debug("Exception in method doDownload", e);
			return doList(actionMapping, actionForm, request, response, user);
		}
		return (actionMapping.findForward("down"));
	}
    
}
