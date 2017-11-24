package com.sunrise.boss.ui.cms.reward.backgroundfileexport;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.faildataoplog.persistent.FaildataoplogVO;
import com.sunrise.boss.business.cms.reward.adtcode.persistent.AdtcodeListVO;
import com.sunrise.boss.business.cms.reward.faildataquery.persistent.FaildataqueryVO;
import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.cms.faildataoplog.FaildataoplogDelegate;
import com.sunrise.boss.delegate.cms.provincialright.ProvincialrightDelegate;
import com.sunrise.boss.delegate.cms.reward.adtcode.AdtcodeDelegate;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.cms.reward.rewardrecord.RewardrecordForm;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.ui.commons.ftp.FtpAccess;
import com.sunrise.boss.ui.commons.ftp.FtpBusUtils;
import com.sunrise.boss.ui.commons.ftp.FtpInfo;
import com.sunrise.boss.ui.resmanage.common.ResPubUtil;

/**
 * <p>
 * Title: FaildataqueryAction
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2008
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author	Linli
 * @version 1.0
 */
public class BackgroundfileexportAction extends BaseDelegateAction {
	
	private ProvincialrightDelegate delegate;
	private String purview = null;
	private static final String PROVINCE_PURVIEW_A = "CH_PW_REWARD_PROVINCIAL";
	private static final String PROVINCE_PURVIEW_A2 = "CH_PW_REWARD";
	private static final String CITY_PURVIEW_B= "CH_PW_REWARD_CIVIC";
	
	public BackgroundfileexportAction() throws Exception {
		// 以下几个方法是必须的
		// 指定VO类
//		setVoClass(BackgroundfileexportVO.class);
//		// 指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
//		this.pkNameArray = new String[1];
//		pkNameArray[0] = "seq";
		delegate = new ProvincialrightDelegate();
	}
	
	public ActionForward doShow(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		
		BackgroundfileexportForm form = (BackgroundfileexportForm) actionForm;
		getPurview(user);
//		form.setCityid("SZ");
//		form.setCalcmonth("201106");
		if("B".equals(purview))
			form.setCityid(SessionFactoryRouter.conversionCityid(user.getCityid()));
		return actionMapping.findForward("list");
		
	}
	
	public ActionForward doDownload(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		
		BackgroundfileexportForm form = (BackgroundfileexportForm) actionForm;
		
		String filename = null;
		try {
			String chCityid = SessionFactoryRouter.conversionCityid(user.getCityid());
			if (chCityid == null || "".equals(chCityid)) {
				throw new Exception("该工号不属于任何地市！");
			}
			filename = getFilePath(actionForm, user, request);
			if (filename == null || "".equals(filename.trim())) {
				throw new Exception("文件路径为空！");
			}
			FtpInfo ftpInfo =null;
			if("A".equals(purview))
			{
				User user2=new User();
				BeanUtils.copyProperties(user2, user);
				String cityid2=form.getCityid();
				if(cityid2!=null)
				{
					user2.setCityid(SessionFactoryRouter.conversionCityid2Num(cityid2));
				}
				 ftpInfo = ResPubUtil.getFtpInfo(user2);
			}else
			{
				 ftpInfo = ResPubUtil.getFtpInfo(user);
			}
			FtpAccess ftp = new FtpAccess(ftpInfo);
			String localPath = FtpBusUtils.getDownloadRealPath(servlet);
			ftp.ftp.setFileType(ftp.ftp.BINARY_FILE_TYPE);
			localPath = ftp.downloadFile(localPath, filename);
			if (localPath == null) {
				throw new Exception("服务器文件不存在，下载失败！" + ftp.ftp.getReplyString());
			}
			
			
			request.setAttribute("filename", FtpBusUtils.getDownloadFilename(
					servlet, filename.trim()));
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
			
			return doShow(actionMapping, actionForm, request, response, user);
		}
		return (actionMapping.findForward("down"));
	}
	
	/**
	 * A-省级权限，B-地市权限
	 * 
	 * @param user
	 */
	private void getPurview(User user) throws Exception {
		if (delegate.checkPurview(user, PROVINCE_PURVIEW_A)) {
			purview = "A";
			return;
		}
		if (delegate.checkPurview(user, PROVINCE_PURVIEW_A2)) {
			purview = "A";
			return;
		}
		if (delegate.checkPurview(user, CITY_PURVIEW_B)) {
			purview = "B";
			return;
		}
		
		purview="";
	}
	
	private String getFilePath(ActionForm actionForm,User user,
			HttpServletRequest request)throws Exception{
		
		StringBuffer filepath=new StringBuffer("");
		BackgroundfileexportForm form = (BackgroundfileexportForm) actionForm;
		String month=form.getCalcmonth();
		String chCityid=form.getCityid();
		filepath.append("/appdata/fileftp/ch/adt/");
		filepath.append(chCityid.toLowerCase()).append("/");
		filepath.append("std/collect/boss/bak/zhlstd_");
		filepath.append(month+"_");
		filepath.append(chCityid.toUpperCase()).append("_");
		filepath.append("0.txt.gz");
		return filepath.toString();
		
	}
	
}
