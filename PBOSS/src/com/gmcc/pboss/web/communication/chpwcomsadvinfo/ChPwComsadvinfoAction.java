/**
 * auto-generated code
 * Mon Mar 23 12:58:46 CST 2015
 */
package com.gmcc.pboss.web.communication.chpwcomsadvinfo;

import java.io.File;
import java.util.Date;
import org.apache.commons.beanutils.BeanUtils;
import com.gmcc.pboss.business.communication.chpwcomsadvinfo.ChPwComsadvinfoVO ;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.struts2.BaseAction ;
import com.gmcc.pboss.business.communication.chpwcomsadvinfo.ChPwComsadvinfoDBParam;
import com.gmcc.pboss.business.communication.chpwcomsrcvobj.ChPwComsrcvobjVO;
import com.gmcc.pboss.common.ftp.FtpAccess;
import com.gmcc.pboss.common.ftp.FtpInfo;
import com.gmcc.pboss.common.utils.tools.FileUtil;
import com.gmcc.pboss.control.communication.chpwcomsadvinfo.ChPwComsadvinfo ;
import com.gmcc.pboss.control.communication.chpwcomsadvinfo.ChPwComsadvinfoBO;
import com.gmcc.pboss.control.communication.chpwcomsrcvobj.ChPwComsrcvobj;
import com.gmcc.pboss.control.communication.chpwcomsrcvobj.ChPwComsrcvobjBO;

/**
 * <p>Title: ChPwComsadvinfoAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public class ChPwComsadvinfoAction extends BaseAction{

	private File affix;
	private String affixFileName;
	private String affixContentType;

	public ChPwComsadvinfoAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new ChPwComsadvinfoForm());
		this.setParam(new ChPwComsadvinfoDBParam());

        //指定VO类
        setClsVO(ChPwComsadvinfoVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"advinfoid"};
		this.setClsControl(ChPwComsadvinfo.class);
		this.setClsQueryParam(ChPwComsadvinfoDBParam.class) ;

	}

	public String doSave() throws Exception {
		ChPwComsadvinfoForm form = (ChPwComsadvinfoForm) getForm();
		if (form.getAdvinfoid() != null && form.getState() == 2) {
			addActionError("已发布状态的公告不能修改！");
			return WEB_RESULT_CONTENT;
		}
		String affixpath = uploadFile();
		if (WEB_CMD_NEW.equals(CMD)) {
			form.setReleasetime(new Date());
			form.setReleasecode(this.getDBAccessUser().getOprcode());
			form.setState(Short.valueOf("1"));
			form.setAffixname(affixFileName);
			form.setAffixpath(affixpath);
		} else {
			if (affix != null) {
				form.setAffixname(affixFileName);
				form.setAffixpath(affixpath);
			}
		}
		return super.doSave();
	}

	public String doSaveRelease() throws Exception {
		ChPwComsadvinfoForm form = (ChPwComsadvinfoForm) getForm();
		if (form.getAdvinfoid() != null && form.getState() == 2) {
			addActionError("已发布状态的公告不能再次发布！");
			return WEB_RESULT_CONTENT;
		}
		String affixpath = uploadFile();
		if (WEB_CMD_NEW.equals(CMD)) {
			form.setReleasetime(new Date());
			form.setReleasecode(this.getDBAccessUser().getOprcode());
			form.setAffixname(affixFileName);
			form.setAffixpath(affixpath);
		} else {
			if (affix != null) {
				form.setAffixname(affixFileName);
				form.setAffixpath(affixpath);
			}
		}
		ChPwComsadvinfoVO vo = new ChPwComsadvinfoVO();
		BeanUtils.copyProperties(vo, form);
		ChPwComsadvinfo chPwComsadvinfo = (ChPwComsadvinfo) BOFactory.build(ChPwComsadvinfoBO.class, getDBAccessUser());
		chPwComsadvinfo.doRelease(vo);
		setForm(vo);
		CMD = WEB_CMD_SAVE;
		setActionMessage("发布成功!");
		return WEB_RESULT_CONTENT;
	}

	public String doRelease() throws Exception {
		ChPwComsadvinfoDBParam params = (ChPwComsadvinfoDBParam) this.getParam();
		ChPwComsadvinfo chPwComsadvinfo = (ChPwComsadvinfo) BOFactory.build(ChPwComsadvinfoBO.class, getDBAccessUser());
		ChPwComsadvinfoVO vo = chPwComsadvinfo.doFindByPk(Long.valueOf(params.get_pk()));
		chPwComsadvinfo.doRelease(vo);
		return this.doList();
	}

	public String doDelete() throws Exception {
		String[] selectArray = ((DBQueryParam) getParam()).get_selectitem();
		if(selectArray == null) {
			addActionError("无法获取选中项目！");
			return "list";
		}
		ChPwComsadvinfo chPwComsadvinfo = (ChPwComsadvinfo) BOFactory.build(ChPwComsadvinfoBO.class, getDBAccessUser());
		try{
			for (int i = 0; i < selectArray.length; i++) {
				ChPwComsadvinfoVO vo = chPwComsadvinfo.doFindByPk(Long.valueOf(selectArray[i]));
				if (vo.getState() != 3) {
					chPwComsadvinfo.doUpdateAdvinfo(vo);
				}
			}
		}catch (Exception e) {
			throw new Exception(e);
		}
		return doList();
	}

	public String doCityList() throws Exception {
		ChPwComsadvinfoDBParam params = (ChPwComsadvinfoDBParam) this.getParam();
		ChPwComsadvinfo chPwComsadvinfo = (ChPwComsadvinfo) BOFactory.build(ChPwComsadvinfoBO.class, getDBAccessUser());
		DataPackage dp = chPwComsadvinfo.doCityList(params);
		this.setDp(dp);
		return "citylist";
	}

	public String doShow() throws Exception {
		ChPwComsadvinfoDBParam params = (ChPwComsadvinfoDBParam) this.getParam();
		ChPwComsadvinfo chPwComsadvinfo = (ChPwComsadvinfo) BOFactory.build(ChPwComsadvinfoBO.class, getDBAccessUser());
		ChPwComsadvinfoVO advinfoVO = chPwComsadvinfo.doFindByPk(Long.valueOf(params.get_pk()));
		this.setForm(advinfoVO);
		
		ChPwComsrcvobj chPwComsrcvobj = (ChPwComsrcvobj) BOFactory.build(ChPwComsrcvobjBO.class, getDBAccessUser());
		ChPwComsrcvobjVO rcvobjVO = chPwComsrcvobj.doFindByPk(params.get_rvcobjid());
		if (rcvobjVO.getState() != 1) {
			rcvobjVO.setState(Short.valueOf("1"));
			rcvobjVO.setChecktime(new Date());
			chPwComsrcvobj.doUpdate(rcvobjVO);
		}
		return "show";
	}

	public String uploadFile() throws Exception {
		if (affix == null) {
			return "";
		}
		String remotePath = "comsadvinfo";
		String fileName = FileUtil.genFileName(affixFileName);
		String httpDestFilePath = FileUtil.createFilename(fileName, false);
		File httpDestFile = new File(httpDestFilePath);
		
		// 上传到本地http服务器
		FileUtil.copy(affix, httpDestFile);
		
		FtpInfo fi = FtpInfo.getInstance();
		FtpAccess fa = new FtpAccess(fi);
		// 上传到FTP服务器
		fa.doUploadFile(affix, fileName, remotePath);
		return remotePath + "/" + fileName;
	}

	/**
	 * 附件下载
	 */
	public void doAffixDownload() throws Exception {
		ChPwComsadvinfoForm form = (ChPwComsadvinfoForm) getForm();
		String downloadFilePath = form.getAffixpath();
		if (downloadFilePath != null && !"".equals(downloadFilePath)) {
			try {
				FtpInfo ftpInfo = FtpInfo.getInstance();
				FtpAccess.doDownloadFile(ftpInfo, downloadFilePath, getResponse());
			}catch(Exception ex) {
				addActionMessage(ex.getMessage());
			}
		}
	}

	public File getAffix() {
		return affix;
	}

	public void setAffix(File affix) {
		this.affix = affix;
	}

	public String getAffixFileName() {
		return affixFileName;
	}

	public void setAffixFileName(String affixFileName) {
		this.affixFileName = affixFileName;
	}

	public String getAffixContentType() {
		return affixContentType;
	}

	public void setAffixContentType(String affixContentType) {
		this.affixContentType = affixContentType;
	}

}