/**
 * auto-generated code
 * Thu Jul 12 15:24:43 CST 2012
 */
package com.sunrise.boss.ui.cms.zjty.chzjtyrewfilenote;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.cms.zjty.chzjtyrewfilenote.persistent.ChZjtyRewfilenoteListVO;
import com.sunrise.boss.business.cms.zjty.chzjtyrewfilenote.persistent.ChZjtyRewfilenoteVO;
import com.sunrise.boss.business.common.sysparam.persistent.SysparamVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.utils.sysinfo.SysInfo;
import com.sunrise.boss.delegate.cms.zjty.chzjtyrewfilenote.ChZjtyRewfilenoteDelegate;
import com.sunrise.boss.delegate.common.sysparam.SysparamDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.ui.commons.ftp.FtpAccess;
import com.sunrise.boss.ui.commons.ftp.FtpBusUtils;
import com.sunrise.boss.ui.commons.ftp.FtpInfo;
import com.sunrise.boss.ui.resmanage.common.ResPubUtil;

/**
 * <p>Title: ChZjtyRewfilenoteAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxx
 * @version 1.0
 */
public class ChZjtyRewfilenoteAction extends BaseAction {
	public ChZjtyRewfilenoteAction() {
		setVoClass(ChZjtyRewfilenoteVO.class);
		// TODO: 给出主键的名字数组
		this.pkNameArray = new String[1];
		pkNameArray[0] = "seqid";
	}

	/**
	 * 查询
	 */
	public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		
		ChZjtyRewfilenoteForm chZjtyRewfilenoteForm = (ChZjtyRewfilenoteForm)actionForm;
		chZjtyRewfilenoteForm.set_se_cityid(SessionFactoryRouter.conversionCityid(user.getCityid()).toUpperCase());
		super.doList(actionMapping, chZjtyRewfilenoteForm, request, response, user);
		return (actionMapping.findForward("list"));
	}

	/**
	 * 新增
	 */
	public ActionForward doNew(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {

		setPara82(request, user);
		ChZjtyRewfilenoteForm chZjtyRewfilenoteForm = (ChZjtyRewfilenoteForm) actionForm;
		chZjtyRewfilenoteForm.setNewOrUpdate("NEW");
		return (actionMapping.findForward("content"));
	}

	public ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {

		return (actionMapping.findForward("content"));
	}

	/**
	 * 删除
	 */
	public ActionForward doDelete(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			//ftp目录
			//String remotePath = SysInfo.FTP_REWARDUPLOAD+ "/"+ SessionFactoryRouter.conversionCityid(user.getCityid()).toLowerCase();
			String[] selectArray = ((BaseActionForm) actionForm).get_selectitem();
			ChZjtyRewfilenoteDelegate delegate = new ChZjtyRewfilenoteDelegate();
			for (int i = 0; i < selectArray.length; i++) {
				ChZjtyRewfilenoteVO chZjtyRewfilenoteVO = delegate.doFindByPk(
						Long.parseLong(selectArray[i]), user);
				String oldFileName = chZjtyRewfilenoteVO.getFilename();
				String remotePath = chZjtyRewfilenoteVO.getFilepath();
				FtpInfo ftpInfo = null;
				FtpAccess ftp;
				ftpInfo = ResPubUtil.getFtpInfo(user);
				ftp = new FtpAccess(ftpInfo);

				boolean delFlag = ftp.deleteFilename(remotePath + "/"+ oldFileName);
				if (delFlag) {
					delegate.doRemove(chZjtyRewfilenoteVO, user);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
		}
		return doList(actionMapping, actionForm, request, response, user);
	}

	public ActionForward doEdit(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		//查询该记录

		super.doEdit(actionMapping, actionForm, request, response, user);
		ChZjtyRewfilenoteForm chZjtyRewfilenoteForm = (ChZjtyRewfilenoteForm) actionForm;

		if (!user.getOpercode().equals(chZjtyRewfilenoteForm.getUploadcode())) {
			this.doList(actionMapping, actionForm, request, response, user);
			throw new Exception("该工号不能进行文档修改操作。");
		}
		setPara82(request, user);

		chZjtyRewfilenoteForm.setNewOrUpdate("UPDATE");

		return (actionMapping.findForward("content"));
	}

	private String setPara82(HttpServletRequest request, User user)
			throws Exception {
		SysparamDelegate sysparamDelegate = new SysparamDelegate();
		SysparamVO sysparamVO = new SysparamVO();
		sysparamVO.setSystemid(82L);
		sysparamVO.setParamtype("channel");
		sysparamVO = sysparamDelegate.doFindByPk(sysparamVO, user);
		request.getSession().setAttribute("sysparam82",
				sysparamVO.getParamvalue());

		return sysparamVO.getParamvalue();
	}

	/**
	 * 重新上传 按钮
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doReuploadreport(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			ChZjtyRewfilenoteForm chZjtyRewfilenoteForm = (ChZjtyRewfilenoteForm) actionForm;

			FormFile tmpTheFile = chZjtyRewfilenoteForm.getTheFile();
			String tmpFileName = tmpTheFile.getFileName();
			String tmpRewardmonth = chZjtyRewfilenoteForm.getRewardmonth();
			String tmpMemo = chZjtyRewfilenoteForm.getMemo();
			String fileInPath = "";
			//文件格式及文件大小检查
			if("".equals(tmpFileName) || tmpFileName == null){
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,"请选择上传文件。");
				return (actionMapping.findForward("content"));
			}
			try{
				UploadCheck(tmpFileName, request, user, tmpTheFile, "update");
			}catch(Exception e){
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,e.getMessage());
				return (actionMapping.findForward("content"));
			}
			
			//重命名文件名
			String last4 = tmpFileName.substring(tmpFileName.length()-4);
			tmpFileName = "ZjtyReport_" + SessionFactoryRouter.conversionCityid(user.getCityid()).toUpperCase() + "_" + tmpRewardmonth + last4; 
			
			ChZjtyRewfilenoteDelegate delegate = new ChZjtyRewfilenoteDelegate();
			//不再检查该文件是否存在，因为修改上传文件也要重命名(相同名)
			/*ChZjtyRewfilenoteListVO listvo = new ChZjtyRewfilenoteListVO();
			listvo.set_se_filename(tmpFileName);
			listvo.set_pagesize("0");
			listvo.set_se_cityid(SessionFactoryRouter.conversionCityid(user.getCityid()).toUpperCase());
			DataPackage dp = delegate.doQuery(listvo, user);
			if(dp.getRowCount()>0){
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,"对应文件名的文件已存在。");
				return (actionMapping.findForward("content"));
			}	*/
			
			ChZjtyRewfilenoteVO chZjtyRewfilenoteVO = delegate.doFindByPk(
					chZjtyRewfilenoteForm.getSeqid(), user);

			String oldFileName = tmpTheFile.getFileName();
			if (tmpFileName == null || "".equals(tmpFileName)) {
				//修改备注
				chZjtyRewfilenoteVO.setMemo(tmpMemo);

				delegate.doUpdate(chZjtyRewfilenoteVO, user);
			} else {
				FtpInfo ftpInfo = null;
				FtpAccess ftp;
				ftpInfo = ResPubUtil.getFtpInfo(user);
				ftp = new FtpAccess(ftpInfo);
				ftp.ftp.setFileType(ftp.ftp.BINARY_FILE_TYPE);
				//ftp目录
				String remotePath = SysInfo.FTP_REWARDUPLOAD+ "/"+ SessionFactoryRouter.conversionCityid(user.getCityid()).toLowerCase();
				fileInPath = chZjtyRewfilenoteForm.getFileAndPath();//文件名，包括本地全路径
				//上传文件
				boolean genFileName = false;
				//String localFileName = fileInPath;
				String localFileName = null;//
				try{
					localFileName = this.buildServerFullFileName(tmpTheFile,tmpFileName);//WAS上文件的全路径名
				}catch(Exception e){
					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,e.getMessage());
					return (actionMapping.findForward("content"));
				}
				String succ = ftp.uploadFile(localFileName, remotePath,
						genFileName);

				if (succ != null) {
					//上传成功后，删除原文件
					//ftp = new FtpAccess(ftpInfo);
					//boolean delFlag = ftp.deleteFilename(chZjtyRewfilenoteVO.getFilepath() + "/"
					//		+ oldFileName);
					//更新表记录
					//String filePath = localFileName.substring(0, localFileName.length()- tmpFileName.length()); 
					chZjtyRewfilenoteVO.setUploadtime(new Date());
					chZjtyRewfilenoteVO.setMemo(tmpMemo);
					chZjtyRewfilenoteVO.setFilename(tmpFileName);
					chZjtyRewfilenoteVO.setFilepath(remotePath);
					chZjtyRewfilenoteVO.setOldfilename(oldFileName);
					delegate.doUpdate(chZjtyRewfilenoteVO, user);
				}else{
					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,"重新上传文件失败");
					return (actionMapping.findForward("content"));
				}				
			} 
			chZjtyRewfilenoteForm.setNewOrUpdate("UPDATE");
			BeanUtils.copyProperties(actionForm, chZjtyRewfilenoteVO);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "重新上传成功");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
		}
		return (actionMapping.findForward("content"));
	}

	/**
	 * 下载 按钮
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doDownloadreport(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			String PK = request.getParameter("PK");
			ChZjtyRewfilenoteDelegate delegate = new ChZjtyRewfilenoteDelegate();
			ChZjtyRewfilenoteVO chZjtyRewfilenoteVO = delegate.doFindByPk(Long
					.parseLong(PK), user);

			//ftp目录
			String remotePath = SysInfo.FTP_REWARDUPLOAD+ "/"+ SessionFactoryRouter.conversionCityid(user.getCityid()).toLowerCase(); 
			FtpInfo ftpInfo = null;
			FtpAccess ftp;
			String fileInPath = chZjtyRewfilenoteVO.getFilepath() + "/"+ chZjtyRewfilenoteVO.getFilename();

			ftpInfo = ResPubUtil.getFtpInfo(user);
			ftp = new FtpAccess(ftpInfo);
			ftp.ftp.setFileType(ftp.ftp.BINARY_FILE_TYPE);
			String localPath = FtpBusUtils.getDownloadRealPath(servlet);

			localPath = ftp.downloadFile(localPath, fileInPath);
			if (localPath == null) {
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
						"服务器文件不存在，下载失败！" + ftp.ftp.getReplyString());
			} else {
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
						"文件下载到：" + localPath);
				request.setAttribute("filename", FtpBusUtils
						.getDownloadFilename(servlet, fileInPath));
			}
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
			e.printStackTrace();
		}
		this.doList(actionMapping, actionForm, request, response, user);
		return (actionMapping.findForward("down"));
	}

	/**
	 * 上传 按钮
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doUploadreport(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		ChZjtyRewfilenoteDelegate delegate = new ChZjtyRewfilenoteDelegate();

		ChZjtyRewfilenoteForm chZjtyRewfilenoteForm = (ChZjtyRewfilenoteForm) actionForm;
		chZjtyRewfilenoteForm.setNewOrUpdate("NEW");
		FormFile tmpTheFile = chZjtyRewfilenoteForm.getTheFile();
		String tmpFileName = tmpTheFile.getFileName();
		String tmpRewardmonth = chZjtyRewfilenoteForm.getRewardmonth();
		String tmpMemo = chZjtyRewfilenoteForm.getMemo();
		String fileInPath = "";
		//文件格式及文件大小检查
		if("".equals(tmpFileName) || tmpFileName == null){
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,"请选择上传文件。");
			return (actionMapping.findForward("content"));
		}
		try{
			UploadCheck(tmpFileName, request, user, tmpTheFile, "new");
		}catch(Exception e){
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,e.getMessage());
			return (actionMapping.findForward("content"));
		}
		
		//计酬月份检查
		if (tmpRewardmonth == null || "".equals(tmpRewardmonth)) {

			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
					"计酬月份不允许为空。");
			return (actionMapping.findForward("content"));
		} else {
			ChZjtyRewfilenoteListVO params = new ChZjtyRewfilenoteListVO();
			params.set_se_rewardmonth(tmpRewardmonth);
			params.set_se_cityid(SessionFactoryRouter.conversionCityid(user.getCityid()).toUpperCase());
			DataPackage crDP = delegate.doQuery(params, user);
			if (crDP.getRowCount() > 0) {
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
						"该计酬月份已存在文档。");
				return (actionMapping.findForward("content"));
			}
		}
		
		//重命名文件名
		String last4 = tmpFileName.substring(tmpFileName.length()-4);
		tmpFileName = "ZjtyReport_" + SessionFactoryRouter.conversionCityid(user.getCityid()).toUpperCase() + "_" + tmpRewardmonth + last4; 
		
		//ChZjtyRewfilenoteDelegate delegate = new ChZjtyRewfilenoteDelegate();
		ChZjtyRewfilenoteListVO listvo = new ChZjtyRewfilenoteListVO();
		listvo.set_se_filename(tmpFileName);
		listvo.set_se_cityid(SessionFactoryRouter.conversionCityid(user.getCityid()).toUpperCase());
		listvo.set_pagesize("0");
		DataPackage dp = delegate.doQuery(listvo, user);
		if(dp.getRowCount()>0){
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,"对应文件名的文件已存在。");
			return (actionMapping.findForward("content"));
		}

		//文件上传
		String remotePath = SysInfo.FTP_REWARDUPLOAD+ "/"+ SessionFactoryRouter.conversionCityid(user.getCityid()).toLowerCase();
		FtpInfo ftpInfo = null;
		FtpAccess ftp;
		try {
			fileInPath = chZjtyRewfilenoteForm.getFileAndPath();//文件名，包括本地全路径
			//String localFileName = fileInPath;
			String localFileName = "";//
			try{
				localFileName = this.buildServerFullFileName(tmpTheFile,tmpFileName);//WAS上文件的全路径名
			}catch(Exception e){
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,e.getMessage());
				return (actionMapping.findForward("content"));
			}
			ftpInfo = ResPubUtil.getFtpInfo(user);
			ftp = new FtpAccess(ftpInfo);
			ftp.ftp.setFileType(ftp.ftp.BINARY_FILE_TYPE);
			boolean ifexists = ftp.ftp.changeWorkingDirectory(remotePath);
			if (!ifexists) { 
					ftp.ftp.makeDirectory(remotePath);
			}

			boolean genFileName = false;
			String succ = ftp.uploadFile(localFileName, remotePath, genFileName);

			if (succ == null) {
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
						"上传文件失败");
				return (actionMapping.findForward("content"));
			} else {
				//上传完成后将计酬月份、上传人工号、上传时间、备注、文档路径，
				//文档名称记录到酬金报表文档记录表(CH_ZJTY_REWFILENOTE)中，并记录相应的日志信息。

				ChZjtyRewfilenoteVO chZjtyRewfilenoteVO = new ChZjtyRewfilenoteVO();
				String oldFileName = tmpTheFile.getFileName();
				//路径（无文件名）
				chZjtyRewfilenoteVO.setFilename(tmpFileName);
				chZjtyRewfilenoteVO.setFilepath(remotePath);
				chZjtyRewfilenoteVO.setUploadcode(user.getOpercode());
				chZjtyRewfilenoteVO.setUploadtime(new Date());
				chZjtyRewfilenoteVO.setRewardmonth(tmpRewardmonth);
				chZjtyRewfilenoteVO.setMemo(tmpMemo);
				chZjtyRewfilenoteVO.setCityid(SessionFactoryRouter.conversionCityid(user.getCityid()).toUpperCase());
				chZjtyRewfilenoteVO.setOldfilename(oldFileName);
				
				delegate.doCreate(chZjtyRewfilenoteVO, user);
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
			return (actionMapping.findForward("content"));
		}

		//写酬金报表文档记录表

		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "上传文件成功");
		return (actionMapping.findForward("content"));
	}
	
	private String buildServerFullFileName(FormFile fileform,String reNameFile) throws Exception{
		String location = this.getServlet().getServletConfig().getInitParameter("uploadlocation");
		if (location == null || location.equals("")) {
			throw new Exception("文件路径没有设置，请检阅web.xml中uploadlocation的配置!");
		}		
		int strLength = location.length();
		String pathSeperator = location.substring(strLength - 1, strLength);
		location = this.getServlet().getServletContext().getRealPath(location);
		if (!location.endsWith(pathSeperator)) {
			location = location + pathSeperator;
		}
		location = location.replace('\\', '/');
		String filename = reNameFile;//fileform.getFilename();
		String fullfilename = location + filename;
		
		try {
			// 新的上传文件名路径
			InputStream stream = fileform.getInputStream();//new FileInputStream(fileform.getFileAndPath());
			OutputStream bos = new FileOutputStream(fullfilename);
			int bytesRead = 0;
			byte[] buffer = new byte[8192];
			while ((bytesRead = stream.read(buffer, 0, 8192)) != -1) {
				bos.write(buffer, 0, bytesRead);
			}
			bos.close();
			stream.close();
		} catch (FileNotFoundException fnfe) {
			throw new Exception("源文件没找到!");
		} catch (IOException ioe) {
			throw new Exception("文件读写错误");
		} catch (Exception e) {
			throw e;
		}
		
		return fullfilename;
	}

	public void UploadCheck(String tmpFileName, HttpServletRequest request,
			User user, FormFile tmpTheFile, String type) throws Exception {

		//上传文件检查
		if (type.equals("add")) {
			if (tmpFileName == null || "".equals(tmpFileName)) {
				throw new Exception("新增上传文件不允许为空。");
			}
			if (tmpFileName.length() <= 4) {
				throw new Exception("文件格式不对.");
			} else { 
				String last4str = tmpFileName.substring(tmpFileName.length() - 4);
				if (".rar".equals(last4str) || ".zip".equals(last4str)) {

				} else {
					throw new Exception("文件格式不对.");
				}
			}
		} else {
			if (!"".equals(tmpFileName) && null!= tmpFileName){
			      if (tmpFileName.length() <= 4) {
				        throw new Exception("文件格式不对.");
			       } else {
				         String last4str = tmpFileName.substring(tmpFileName.length() - 4);
				         if (".rar".equals(last4str) || ".zip".equals(last4str)) { 
				          } else {
				         	  	throw new Exception("文件格式不对.");
				          }
			      }
			} 
		}

		//限定上传文档大小,检查
		String para82 = setPara82(request, user);
		int fileMaxSize = 100 * 1024 * 1024;
		int fileSize = tmpTheFile.getFileSize();//取得文件尺寸
		if (para82 != null && !"".equals(para82)) {
			int para82int = Integer.parseInt(para82);
			fileMaxSize = para82int * 1024 * 1024;//文件最大限额 
		}

		if (fileSize > fileMaxSize) {
			throw new Exception("您上传的文档超过限定的大小" + para82 + "M");
		}
	}
}
