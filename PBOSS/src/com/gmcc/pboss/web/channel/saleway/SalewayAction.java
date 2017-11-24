package com.gmcc.pboss.web.channel.saleway;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.channel.bchcontact.BchcontactVO;
import com.gmcc.pboss.business.channel.changelog.ChangelogDBParam;
import com.gmcc.pboss.business.channel.changelog.ChangelogVO;
import com.gmcc.pboss.business.channel.cooperator.CooperatorVO;
import com.gmcc.pboss.business.channel.employee.EmployeeDBParam;
import com.gmcc.pboss.business.channel.employee.EmployeeVO;
import com.gmcc.pboss.business.channel.flowname.FlownameVO;
import com.gmcc.pboss.business.channel.way.AGWayVO;
import com.gmcc.pboss.business.channel.way.WayDBParam;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.channel.wayaccount.WayaccountDBParam;
import com.gmcc.pboss.business.channel.wayaccount.WayaccountVO;
import com.gmcc.pboss.business.channel.wayapply.WayapplyVO;
import com.gmcc.pboss.business.channel.waybusicircle.WaybusicircleDBParam;
import com.gmcc.pboss.business.channel.waybusicircle.WaybusicircleVO;
import com.gmcc.pboss.business.channel.waycompact.WaycompactVO;
import com.gmcc.pboss.business.channel.wayprovince.WayprovinceVO;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.common.ftp.FtpAccess;
import com.gmcc.pboss.common.ftp.FtpBusUtils;
import com.gmcc.pboss.common.ftp.FtpInfo;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.bchcontact.Bchcontact;
import com.gmcc.pboss.control.channel.bchcontact.BchcontactBO;
import com.gmcc.pboss.control.channel.changelog.Changelog;
import com.gmcc.pboss.control.channel.changelog.ChangelogBO;
import com.gmcc.pboss.control.channel.cooperator.Cooperator;
import com.gmcc.pboss.control.channel.cooperator.CooperatorBO;
import com.gmcc.pboss.control.channel.employee.Employee;
import com.gmcc.pboss.control.channel.employee.EmployeeBO;
import com.gmcc.pboss.control.channel.flowname.Flowname;
import com.gmcc.pboss.control.channel.flowname.FlownameBO;
import com.gmcc.pboss.control.channel.way.AGWay;
import com.gmcc.pboss.control.channel.way.AGWayBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.channel.wayaccount.Wayaccount;
import com.gmcc.pboss.control.channel.wayaccount.WayaccountBO;
import com.gmcc.pboss.control.channel.wayapply.Wayapply;
import com.gmcc.pboss.control.channel.wayapply.WayapplyBO;
import com.gmcc.pboss.control.channel.waybusicircle.Waybusicircle;
import com.gmcc.pboss.control.channel.waybusicircle.WaybusicircleBO;
import com.gmcc.pboss.control.channel.waycompact.Waycompact;
import com.gmcc.pboss.control.channel.waycompact.WaycompactBO;
import com.gmcc.pboss.control.channel.wayprovince.Wayprovince;
import com.gmcc.pboss.control.channel.wayprovince.WayprovinceBO;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.common.utils.lang.InterfaceUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.filter.PermissionChecker;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

public class SalewayAction extends BaseAction {
	private String remotepath = "saleway";
	private File compactDoc; // 文本
	private String compactDocFileName;
	private String compactDocType;

	private File licenceDoc; // 合同
	private String licenceDocFileName;
	private String licenceDocType;
	private String CH_PW_STARLEVEL = "CH_PW_STARLEVEL";//星级修改权限令牌
	public String hasFlag;// 判断星级是否可修改
	
	public String param75;//是否填写退出原因判断
	
	public String memo;//退出原因
	
	private String flag;// 用于判断是否需要申请审批
	
	private String has3Gright;//3G、2G页面显示控制
	
	/**批量导出时的可选导出字段*/
	private String[][] optionFields = new String[][]{
			{"wayid","渠道编码"},{"wayname","渠道名称"},{"waysubtype","零售渠道类别"},{"upperwayid","上级渠道编码"},{"upperwayid","上级渠道名称"},
			{"starlevel","星级"},{"pt","排他性"},{"waystate","状态"},{"cityid","地市公司"},{"countyid","分公司"},
			{"svccode","服务销售中心"},{"mareacode","微区域"},{"isstraitprd","是否直供"},{"adtypecode","区域类型"},
			{"adacode","行政区划"},{"formtype","业态类型"},{"starttime","合作开始时间"},{"buzarea","营业面积"},
			{"logiscode","所属物流商"},{"waymagcode","所属渠道经理人员工号"},{"bchlevel","分级"},{"officetel","公务机号码"},
			{"alarmbizamount","业务预警量"},{"address","详细地址"},{"latitude","地理纬度"},{"longtitude","地理经度"},{"checked","是否授权"},
			{"principal","业主姓名"},{"principaltel","业主电话"},{"principalphone","业主固定电话"},{"principalemail","业主电子信箱"},
			{"sendaddr","送货地址"},{"recpers","收货联系人"},{"recconntel","收货联系号码"},{"reccertno","收货人证件号码"},
			{"compacttype","签约类型"},{"compactno","合同编码"},{"compactname","合同协议名称"},{"signtime","签署合同时间"},
			{"begintime","合同协议生效时间"},{"cmpendtime","合同到期日"},{"licenceno","营业执照编号"},{"licvalidate","营业执照有效期"},
			{"bail","保证金金额"},{"bailstatus","保证金押金状态"},{"baillwrlmt","保证金下限"},{"bankname","酬金支付开户银行"},
			{"acctno","酬金支付银行账号"},{"acctname","酬金支付帐号名称"},{"acctfid","开户人身份证号码"},{"signstatus","签约状态"},
			{"bailtype","保证金交付形式"},{"servbound","经营范围"},{"provcode","全省代码"},{"deacctno","卡类购销划扣银行帐号"},
			{"deacctname","卡类购销划扣账号名称"},{"debankname","卡类购销划扣开户银行"},{"chainhead","合作商编码"},{"isb2m","是否加入B2M模式"},
			{"accttype","账号类型"},{"debankid","卡类购销划扣银行标识"},{"destate","卡类购销划扣银行状态"},{"custtype","合作类型"},{"starlev","星级分层"},
			{"istop","是否TOP网点"},{"buztypecode","商圈类型"},
			{"rewardkind","社会渠道类型"},{"buscno","所属商圈编码"},{"wayattr","连锁加盟渠道属性"},{"waymod","连锁加盟渠道系数"},
			{"creditlevel","信用等级"},{"taxcertificate","税务资质"}
			
	};
	public File getCompactDoc() {
		return compactDoc;
	}
	public void setCompactDoc(File compactDoc) {
		this.compactDoc = compactDoc;
	}
	public String getCompactDocFileName() {
		return compactDocFileName;
	}
	public void setCompactDocFileName(String compactDocFileName) {
		this.compactDocFileName = compactDocFileName;
	}
	public String getCompactDocType() {
		return compactDocType;
	}
	public void setCompactDocType(String compactDocType) {
		this.compactDocType = compactDocType;
	}
	public File getLicenceDoc() {
		return licenceDoc;
	}
	public void setLicenceDoc(File licenceDoc) {
		this.licenceDoc = licenceDoc;
	}
	public String getLicenceDocFileName() {
		return licenceDocFileName;
	}
	public void setLicenceDocFileName(String licenceDocFileName) {
		this.licenceDocFileName = licenceDocFileName;
	}
	public String getLicenceDocType() {
		return licenceDocType;
	}
	public void setLicenceDocType(String licenceDocType) {
		this.licenceDocType = licenceDocType;
	}
	public SalewayAction() {
		super();
		this.setForm(new SalewayForm());
		this.setParam(new WayDBParam());
		setClsVO(AGWayVO.class);
		this.pkNameArray = new String[] { "wayid" };
		this.setClsQueryParam(WayDBParam.class) ;
	}

	public String doList() throws Exception {
		try {
			HttpServletRequest request = getRequest();
			User user = (User) request.getSession().getAttribute(
					WebConstant.SESSION_ATTRIBUTE_USER);
			Sysparam sysparamBO = (SysparamBO)BOFactory.build(SysparamBO.class,user);
			//1:退出时需要填写原因 0:不用填写退出原因 空:不用填写退出原因
			param75 = sysparamBO.doFindByID("75", "channel");			
			request.getSession().setAttribute("param75",param75);//批量导入用到
			
			// 检查权限令牌
			String paramvalue = sysparamBO.doFindByID(new Long("77"), "channel");
			// 如果paramvalue查到记录并且值为1，则需要用新的固定参数显示步骤ID下拉框
			if ("1".equals(paramvalue)) {
				this.setFlag("yes");
			}
			
			WayDBParam param = (WayDBParam)getParam();
			if (param.get_se_rewardkind() != null && param.get_ne_starlevel() != null) {
				if (param.get_se_rewardkind().equals("1")
						&& !param.get_ne_starlevel().equals("")
						&& !param.get_ne_starlevel().equals("7")) {
					super.addActionError("社会渠道类型选择为3G时渠道时，星级只能选择3G渠道专用星级");
					return ("list");
				} else if (param.get_se_rewardkind().equals("0")
						&& param.get_ne_starlevel().equals("7")) {
					super.addActionError("社会渠道类型选择为2G时渠道时，星级不能选择3G渠道专用星级");
					return ("list");
				} else if (param.get_se_rewardkind().equals("2")
						&& !param.get_ne_starlevel().equals("")
						&& !param.get_ne_starlevel().equals("8")) {
					super.addActionError("社会渠道类型选择为连锁加盟渠道时，星级只能选择 8 连锁加盟渠道星级");
					return ("list");
				}else if (param.get_se_rewardkind().equals("3")
						&& !param.get_ne_starlevel().equals("")
						&& !param.get_ne_starlevel().equals("9")) {
					super.addActionError("社会渠道类型选择为4G渠道时，星级只能选择 9 （4G渠道专用星级）");
					return ("list");
				}
				
				if (param.get_se_rewardkind().equals("0") && param.get_ne_starlevel().equals("")) {
					param.set_sql_starlevel("starlevel != 7 and STARLEVEL != 8 and STARLEVEL != 9 or starlevel is null");
				} else if (param.get_se_rewardkind().equals("1")) {
					param.set_ne_starlevel("7");
				}else if (param.get_se_rewardkind().equals("2")) {
					param.set_ne_starlevel("8");
				}else if (param.get_se_rewardkind().equals("3")) {
					param.set_ne_starlevel("9");
				}
			}
			
			//param.set_pagesize("20");
			Way way = (Way) BOFactory.build(WayBO.class, getDBAccessUser());
			DataPackage dp=null;
			if(param.get_se_officetel()==null || "".equals(param.get_se_officetel())){
			 dp = way.doQuerysaleway(param, user);
			}else
			{
				dp = way.doQuerysalewayWithOfficetel(param, user);
			}
			setDp(dp);
		} catch (Exception e) {
			e.printStackTrace();
			setActionMessage(e.getMessage());
		}
		return "list";
	}
	
	public String doQueryWayAndSubwayDetailInfo() throws Exception {
		try {
			HttpServletRequest request = getRequest();
			User user = (User) request.getSession().getAttribute(
					WebConstant.SESSION_ATTRIBUTE_USER);
			WayDBParam wayParam = (WayDBParam)getParam();
			WayaccountDBParam param = new WayaccountDBParam();
			BeanUtils.copyProperties(param, wayParam);
			param.set_pagesize(wayParam.get_pagesize());
			param.set_pageno(wayParam.get_pageno());
			Wayaccount waBo = (Wayaccount) BOFactory.build(WayaccountBO.class, getDBAccessUser());
			DataPackage dp = waBo.doQueryWayAndSubwayDetailInfo(param, user.getWayid());
			setDp(dp);
		} catch (Exception e) {
			e.printStackTrace();
			setActionMessage(e.getMessage());
		}
		return "list";
	}
	
	public String doDownload() throws Exception{
			try {
				HttpServletRequest request=ServletActionContext.getRequest();
				
				String url = request.getParameter("file");
				FtpAccess ftpAccess = new FtpAccess(FtpInfo.getInstance());
				String localPath =ServletActionContext.getServletContext().getRealPath("/") ;//FtpBusUtils.getDownloadRealPath(ServletActionContext.getServletContext());
				String file = ftpAccess.downloadFile(localPath, url);
				if (file == null) {
					throw new Exception("下载失败！");
				}
				request.setAttribute("filename", FtpBusUtils.getFilenameFromPath(url));
			} catch (Exception ex) {
				ex.printStackTrace();
				super.addActionError(ex.getMessage());
			}
			return "download";
	}
	public String doSave() throws Exception {
		HttpServletRequest request=ServletActionContext.getRequest();
		SalewayForm form = (SalewayForm) getForm();
		DBAccessUser user = this.getDBAccessUser();
		Way wayBO = (Way)BOFactory.build(WayBO.class, user);
		WayDBParam wayDBParam=new WayDBParam();
		wayDBParam.getQueryConditions().put("_sne_wayid", form.getWayid());
		wayDBParam.set_se_latitude(form.getLatitude());
		wayDBParam.set_se_longtitude(form.getLongtitude());
		if(wayBO.doQuery(wayDBParam).getDatas().size()>0){
			super.addActionError("经度"+form.getLatitude()+",纬度"+form.getLongtitude()+"，已经存在.如网点确实同一经纬度,建议修改小数点后第6位以示区分");
			return "content";
		}
		
		/*
		 * dengxingxin add
		 * 根据系统参数【是否填写退出原因判断】来判断，是否增加
		 * 渠道变动记录表 (ch_pw_changelog)记录
		 */
		Sysparam sysparamBO = (SysparamBO)BOFactory.build(SysparamBO.class,getDBAccessUser());
		//1:退出时需要填写原因 0:不用填写退出原因 空:不用填写退出原因
		param75 = sysparamBO.doFindByID("75", "channel");
		if("1".equals(param75)){
			Short waystate = form.getWaystate();
			if (waystate == Short.parseShort("1")) {
				
			} else {
				if(memo == null || "".equals(memo)){					
					super.addActionError("备注不能为空，请填写");
					return ("content");
				}else{
					Changelog changelogBO = (ChangelogBO)BOFactory.build(ChangelogBO.class, getDBAccessUser());
					ChangelogVO clVO = new ChangelogVO();
					clVO.setOptime(new Date());//操作时间
					clVO.setOprcode(getDBAccessUser().getOprcode());//操作员工号
					clVO.setOprtype("update");//操作类型
					clVO.setWayid(form.getWayid());//渠道编码
					clVO.setChangetype(Short.parseShort("2"));//变动类型
					if ("EDIT".equals(CMD)) {
						clVO.setOldvalue(""+wayBO.doFindByPk(form.getWayid()).getWaystate());//变动前值
					} else {
						clVO.setOldvalue("");
					}
					clVO.setNowvalue(""+form.getWaystate());//变动后值
					clVO.setMemo(memo);//备注
										
					changelogBO.doCreate(clVO);
				}
			}
		}
				
		/*
		 * dengxingxin add
		 */
		try {
			String uwi = form.getUniquewayid() == null ? "" : form.getUniquewayid();
			String wi = form.getWayid() == null ? "" : form.getWayid();
			WayprovinceVO wpVO = new WayprovinceVO();
			BeanUtils.copyProperties(wpVO, form);
			
			Wayprovince wayprovince = (Wayprovince) BOFactory.build(WayprovinceBO.class, user);			
			List wList = wayprovince.doQueryWpByWayid(wpVO.getWayid());
			List uList = wayprovince.doQueryWpByUniquewayid(wpVO.getUniquewayid());
						
			if(wList != null && !"".equals(wList) && wList.size()>0){
				//更新
				if(uList != null && !"".equals(uList) && uList.size()>0){
					//存在全网统一渠道编码
					WayprovinceVO wVO1 = (WayprovinceVO)uList.get(0);
					if(wi.equals(wVO1.getWayid())){
						//相同wayid记录才能更新
						WayprovinceVO wVO = (WayprovinceVO)wList.get(0);
						BeanUtils.copyProperties(wVO, wpVO);
						wayprovince.doUpdate(wVO);
					}else{
						super.addActionError(wVO1.getWayid() + "  已经存在全网统一渠道编码：" + wVO1.getUniquewayid() + "");
						return "content";
					}
				}else{
					//没有“全网统一渠道编码”，可以直接更新
					WayprovinceVO wVO = (WayprovinceVO)wList.get(0);
					BeanUtils.copyProperties(wVO, wpVO);
					wayprovince.doUpdate(wVO);
				}				
			}else{
				//新增
				if(uList != null && !"".equals(uList) && uList.size()>0){
					//存在全网统一渠道编码
					WayprovinceVO wVO1 = (WayprovinceVO)uList.get(0);
					super.addActionError(wVO1.getWayid() + "  已经存在全网统一渠道编码：" + wVO1.getUniquewayid() + "");
					return "content";
				}else{
					//没有“全网统一渠道编码”，可以直接新增
					wayprovince.doCreate(wpVO);
				}
				
			}
		} catch (Exception e) {
			super.addActionError(e.getMessage());
			return ("content");
		}
						
		try {
			if ((getCompactDocFileName()!=null && !"".equals(this.getCompactDocFileName()))
					|| (getLicenceDocFileName()!=null &&!"".equals(this.getLicenceDocFileName()))) {
				FtpInfo ftpInfo = FtpInfo.getInstance();
				FtpAccess ftp = new FtpAccess(ftpInfo);
				if (getCompactDocFileName()!=null && !"".equals(this.getCompactDocFileName())) {
					String compact = ftp.uploadFile(this.compactDoc,
							remotepath, true);
					form.setCompactpath(compact);
				}
				if (getLicenceDocFileName()!=null && !"".equals(this.getLicenceDocFileName())) {
					String licence = ftp.uploadFile(this.licenceDoc,
							remotepath, true);
					form.setLicencepath(licence);
				}
			}
		} catch (Exception e) {
			super.addActionError(e.getMessage());
			return ("content");
		}
		
		/*
		 * dengxingxin add
		 * 渠道状态   上级渠道状态字段设置为‘0:暂停营业、-1:已关店’时，要更新其子渠道都为相应状态。
		 */
		User wuser = (User) request.getSession().getAttribute(
				WebConstant.SESSION_ATTRIBUTE_USER);
		Way way = (Way) BOFactory.build(WayBO.class, getDBAccessUser());
		DataPackage dp=null;
		WayDBParam wparams = new WayDBParam();
		wparams.set_se_wayid(form.getWayid());
		wparams.setDataOnly(true);
		wparams.set_pagesize("0");
		dp = way.doQuerySubSaleway(wparams, wuser);
		if(dp != null && !"".equals(dp)
				&& dp.getDatas() != null && !"".equals(dp.getDatas())
				&& dp.getDatas().size() > 0){
			Way wwayBO = (WayBO) BOFactory.build(WayBO.class, user);
			for(int k=0 ; k<dp.getDatas().size() ; k++){
				WayVO wayVO = (WayVO)dp.getDatas().get(k);
				if(form.getWaystate() == 0 || form.getWaystate() == -1){
					if(!form.getWayid().equals(wayVO.getWayid())){//不等于自己才更新
						wayVO.setWaystate(form.getWaystate());
						wwayBO.doUpdateNotCon(wayVO);
					}
				}else{
					
				}
			}
		}
				
		int cando = -1;
		try {
			AGWay agway = (AGWay)BOFactory.build(AGWayBO.class, user);
			AGWayVO wayVO = new AGWayVO();
			BeanUtils.copyProperties(wayVO, form);
			wayVO.setBuzphoneno(form.getSmsmobileno());
			// 普通代理渠道
			wayVO.setWaytype("AG");
			String upperwayid = form.getUpperwayid();
			WayVO upperVO = agway.doFindByPk(upperwayid, user);
			if (!"DIS".equals(upperVO.getWaysubtype())
					&& !"GMPT".equals(upperVO.getWaysubtype())
					&& !"G100".equals(upperVO.getWaysubtype())
					&& !"D4S".equals(upperVO.getWaysubtype())
					&& !"D5S".equals(upperVO.getWaysubtype())
					&& !"D6S".equals(upperVO.getWaysubtype())

			) {
				throw new Exception("录入的上级渠道只能是连锁经营合作商，移动部门/科室或服务厅");
			}
			if (StringUtils.equals(wayVO.getWaytype(), "AG")
					&& StringUtils.equals(wayVO.getWaysubtype(), "DIS")) {
				form.setChainhead(wayVO.getWayid());
			}
			if ("EDIT".equals(CMD)) {
				if ("1".equals(form.getSendFlag())){
					wayVO.setSendFlag(form.getSendFlag());
					wayVO.setSmsMsg(form.getSmsMsg());
				}
				User users = (User) getDBAccessUser();
				//this.checkUpdateStartLevel(wayVO,users);
				//取消根据星级修改开始合作时间
				wayVO.setStarttime(form.getStarttime());
				cando = agway.doUpdate(wayVO, user);
//				if (!StringUtils.isEmpty(form.getOldValueStr())){
//					form.setOldValueStr(null);
//				}
			} else {
				WayVO tempVO = agway.doFindByPk(form.getWayid(), user);
				if (tempVO != null) {
					// form.setCmdState(WebConstant.COMMAND_STRING_EDIT);
					super.addActionError("相同记录已存在");
					return ("content");
				} else { 
//					this.checkAddStartLevel(wayVO);
					//取消根据星级修改开始合作时间
					wayVO.setStarttime(form.getStarttime());
					cando = agway.doCreate(wayVO, user);
					//request.setAttribute("newSVWayPk", wayVO.getWayid());
				}
			}
			BeanUtils.copyProperties(form, wayVO);
			wayVO.setBuzphoneno(form.getSmsmobileno());
			if("1".equals(wayVO.getRewardkind())){
				has3Gright = "false";
			}else if("3".equals(wayVO.getRewardkind())){
				has3Gright = "false";
			}else{
				has3Gright = "true";
			}
			if (cando == 0) {
				super.addActionMessage("保存成功");
			} else {
				super.addActionMessage("操作成功");
			}			
			this.setCMD(WEB_CMD_SAVE);
		} catch (Exception e) {
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return ("content");
	}
	
	/**
	 * 网点提交申请
	 */
	public String doAgapply() throws Exception {
		SalewayForm form = (SalewayForm) getForm();
		DBAccessUser user = this.getDBAccessUser();
		Way wayBO = (Way)BOFactory.build(WayBO.class, user);
		WayDBParam wayDBParam=new WayDBParam();
		wayDBParam.getQueryConditions().put("_sne_wayid", form.getWayid());
		wayDBParam.set_se_latitude(form.getLatitude());
		wayDBParam.set_se_longtitude(form.getLongtitude());
		if(wayBO.doQuery(wayDBParam).getDatas().size()>0){
			super.addActionError("经度"+form.getLatitude()+",纬度"+form.getLongtitude()+"，已经存在.如网点确实同一经纬度,建议修改小数点后第6位以示区分");
			this.setFlag("yes");
			return "content";
		}
		
		// 审批的数据
		WayapplyVO applyvo = new WayapplyVO();
		
		AGWay delegate = (AGWay)BOFactory.build(AGWayBO.class, getDBAccessUser());
		WayVO oldVO = delegate.doFindByPk(form.getWayid(), getDBAccessUser());
		
		// 查询下一步处理人是否存在
		Flowname flowname = (Flowname)BOFactory.build(FlownameBO.class, getDBAccessUser());
		String pk = null;
		if (oldVO == null) {
			pk = "WAY_ADD_AUDIT1";
		} else {
			pk = "WAY_UPDATE_AUDIT1";
		}
		FlownameVO flvo = flowname.doFindByPk(pk);
		if (flvo == null || (flvo.getOprcode() == null || "".equals(flvo.getOprcode().trim()))) {
			super.addActionError("下一步处理人没有定义！");
			this.setFlag("yes");
			return "content";
		}
		String oprcode = flvo.getOprcode();
		
		// 检查全网统一编码
		try {
			String uwi = form.getUniquewayid() == null ? "" : form.getUniquewayid();
			String wi = form.getWayid() == null ? "" : form.getWayid();
			WayprovinceVO wpVO = new WayprovinceVO();
			BeanUtils.copyProperties(wpVO, form);
			
			Wayprovince wayprovince = (Wayprovince) BOFactory.build(WayprovinceBO.class, user);			
			List wList = wayprovince.doQueryWpByWayid(wpVO.getWayid());
			List uList = wayprovince.doQueryWpByUniquewayid(wpVO.getUniquewayid());
						
			if(wList != null && !"".equals(wList) && wList.size()>0){
				//更新
				if(uList != null && !"".equals(uList) && uList.size()>0){
					//存在全网统一渠道编码
					WayprovinceVO wVO1 = (WayprovinceVO)uList.get(0);
					if(!wi.equals(wVO1.getWayid())){
						super.addActionError(wVO1.getWayid() + "  已经存在全网统一渠道编码：" + wVO1.getUniquewayid() + "");
						this.setFlag("yes");
						return "content";
					}
				}				
			}else{
				//新增
				if(uList != null && !"".equals(uList) && uList.size()>0){
					//存在全网统一渠道编码
					WayprovinceVO wVO1 = (WayprovinceVO)uList.get(0);
					super.addActionError(wVO1.getWayid() + "  已经存在全网统一渠道编码：" + wVO1.getUniquewayid() + "");
					this.setFlag("yes");
					return "content";
				}				
			}
		} catch (Exception e) {
			super.addActionError(e.getMessage());
			this.setFlag("yes");
			return ("content");
		}
		
		// 上传ftp的文件
		try {
			if ((getCompactDocFileName()!=null && !"".equals(this.getCompactDocFileName()))
					|| (getLicenceDocFileName()!=null &&!"".equals(this.getLicenceDocFileName()))) {
				FtpInfo ftpInfo = FtpInfo.getInstance();
				FtpAccess ftp = new FtpAccess(ftpInfo);
				if (getCompactDocFileName()!=null && !"".equals(this.getCompactDocFileName())) {
					String compact = ftp.uploadFile(this.compactDoc,
							remotepath, true);
					form.setCompactpath(compact);
				}
				if (getLicenceDocFileName()!=null && !"".equals(this.getLicenceDocFileName())) {
					String licence = ftp.uploadFile(this.licenceDoc,
							remotepath, true);
					form.setLicencepath(licence);
				}
			}
		} catch (Exception e) {
			super.addActionError(e.getMessage());
			this.setFlag("yes");
			return ("content");
		}
		
		try {
			AGWay agway = (AGWay)BOFactory.build(AGWayBO.class, user);
			AGWayVO wayVO = new AGWayVO();
			BeanUtils.copyProperties(wayVO, form);
			wayVO.setBuzphoneno(form.getSmsmobileno());
			// 普通代理渠道
			wayVO.setWaytype("AG");
			String upperwayid = form.getUpperwayid();
			WayVO upperVO = agway.doFindByPk(upperwayid, user);
			if (!"DIS".equals(upperVO.getWaysubtype())
					&& !"GMPT".equals(upperVO.getWaysubtype())
					&& !"G100".equals(upperVO.getWaysubtype())
					&& !"D4S".equals(upperVO.getWaysubtype())
					&& !"D5S".equals(upperVO.getWaysubtype())
					&& !"D6S".equals(upperVO.getWaysubtype())

			) {
				throw new Exception("录入的上级渠道只能是连锁经营合作商，移动部门/科室或服务厅");
			}
			if (StringUtils.equals(wayVO.getWaytype(), "AG")
					&& StringUtils.equals(wayVO.getWaysubtype(), "DIS")) {
				form.setChainhead(wayVO.getWayid());
			}
			if ("EDIT".equals(CMD)) {
				if ("1".equals(form.getSendFlag())){
					wayVO.setSendFlag(form.getSendFlag());
					wayVO.setSmsMsg(form.getSmsMsg());
				}
				User users = (User) getDBAccessUser();
				//this.checkUpdateStartLevel(wayVO,users);
				//取消根据星级修改开始合作时间
				wayVO.setStarttime(form.getStarttime());
				
			} else {
				WayVO tempVO = agway.doFindByPk(form.getWayid(), user);
				if (tempVO != null) {
					super.addActionError("相同记录已存在");
					this.setFlag("yes");
					return ("content");
				} else {					
//					this.checkAddStartLevel(wayVO);
					//取消根据星级修改开始合作时间
					wayVO.setStarttime(form.getStarttime());
				}
			}
			BeanUtils.copyProperties(form, wayVO);
			wayVO.setBuzphoneno(form.getSmsmobileno());
			
			// 数据复制到审批表
			Wayapply apply = (Wayapply)BOFactory.build(WayapplyBO.class,getDBAccessUser());
			BeanUtils.copyProperties(applyvo, form);
			applyvo.setEndtime(form.getCmpendtime());
			if (oldVO == null) {
				apply.doWayapply(oprcode, applyvo, getDBAccessUser(), "add");	
			} else {
				apply.doWayapply(oprcode, applyvo, getDBAccessUser(), "update");	
			}
			this.setFlag("yes");
			super.addActionMessage("提交申请成功！");
			
			this.setCMD(WEB_CMD_SAVE);
		} catch (Exception e) {
			e.printStackTrace();
			this.setFlag("yes");
			super.addActionError(e.getMessage());
		}
				
		return "content";
	}
	
	/**
	 * 对社会网点进行逻辑删除（waystate 0 已关闭）
	 */
	public String doDelete() throws Exception {
		try {
			String[] selectArray = ((DBQueryParam) getParam()).get_selectitem();
			if(selectArray == null) {
				addActionError("无法获取选中项目！");
				return "list";
			}
			AGWay agway = (AGWay)BOFactory.build(AGWayBO.class, getDBAccessUser());
			for (int i = 0; i < selectArray.length; i++) {
				WayVO wayVO = agway.doFindByPk(selectArray[i], getDBAccessUser());
				agway.doDelete(wayVO, getDBAccessUser());
			}
		} catch (Exception e) {
			e.printStackTrace();
			setActionMessage(e.getMessage());
		}
		return doList();
	}
	
	// 网点申请退出
	public String doAgdeleteapply() throws Exception{
		try{
			String[] selectArray = ((DBQueryParam) getParam()).get_selectitem();
			if(selectArray == null) {
				addActionError("无法获取选中项目！");
				return "list";
			}
			Flowname flowname = (Flowname)BOFactory.build(FlownameBO.class, getDBAccessUser());
			FlownameVO flvo = flowname.doFindByPk("WAY_REMOVE_AUDIT1");
			if (flvo == null || (flvo.getOprcode() == null || "".equals(flvo.getOprcode().trim()))) {
				super.addActionError("下一步处理人没有定义！");
				return "list";
			}
			String oprcode = flvo.getOprcode();
			
			Way way = (Way)BOFactory.build(WayBO.class, getDBAccessUser());
			Wayapply apply = (Wayapply)BOFactory.build(WayapplyBO.class,getDBAccessUser());
			WayapplyVO vo = null;
			for (int i = 0; i < selectArray.length; i++) {
				vo = way.doGetsaleeidt(selectArray[i],getDBAccessUser());
				apply.doWayapply(oprcode, vo, getDBAccessUser(), "remove");
			}
			super.addActionMessage("网点退出申请成功！");
		}catch(Exception e){
			super.addActionError(e.getMessage());
		}
		return this.doList();
	}
	
	/**
	 * 对社会网点进行逻辑删除（waystate 0 已关闭）
	 */
	public String doDeleteByMemo() throws Exception {
		try {
			String[] selectArray = (String[])this.getRequest().getSession().getAttribute("selectArray");
			//String memo = this.getRequest().getParameter("memo");
			
			if(selectArray == null) {
				addActionError("无法获取选中项目！");
				return "toDelete";
			}
			Sysparam sysparamBO = (SysparamBO)BOFactory.build(SysparamBO.class,getDBAccessUser());
			//1:退出时需要填写原因 0:不用填写退出原因 空:不用填写退出原因
			param75 = sysparamBO.doFindByID("75", "channel");
			Date now = new Date();
			AGWay agway = (AGWay)BOFactory.build(AGWayBO.class, getDBAccessUser());
			Changelog changelogBO = (ChangelogBO)BOFactory.build(ChangelogBO.class, getDBAccessUser());
			for (int i = 0; i < selectArray.length; i++) {
				WayVO wayVO = agway.doFindByPk(selectArray[i], getDBAccessUser());
				
				ChangelogVO clVO = new ChangelogVO();
				clVO.setOptime(now);//操作时间
				clVO.setOprcode(getDBAccessUser().getOprcode());//操作员工号
				clVO.setOprtype("update");//操作类型
				clVO.setWayid(selectArray[i]);//渠道编码
				clVO.setChangetype(Short.parseShort("2"));//变动类型
				clVO.setOldvalue(""+wayVO.getWaystate());//变动前值 
				clVO.setNowvalue("0");//变动后值
				clVO.setMemo(memo);//备注 
			 
				agway.doDelete(wayVO, getDBAccessUser()); 
				changelogBO.doCreate(clVO);
			}
			this.getRequest().getSession().setAttribute("selectArray", null);
		} catch (Exception e) {
			this.getRequest().getSession().setAttribute("selectArray", null);
			e.printStackTrace();
			setActionMessage(e.getMessage());
		}
		return doList();
	}
	
	/**
	 * 填写退出原因
	 * @return
	 * @throws Exception
	 */
	public String doToDelete() throws Exception {
		String wayids = this.getRequest().getParameter("wayids");
		wayids=wayids.substring(1);
		String[] selectArray = wayids.split("\\|");
		
		this.getRequest().getSession().setAttribute("selectArray", selectArray);
		return "toDelete";
	}
	
	/**
	 * 社会网点基本信息，沟通信息，账户信息，合同信息的修改
	 */
	public String doEdit() throws Exception {
		try {
			HttpServletRequest request = getRequest();
			String wayid = request.getParameter("param._pk");
			SalewayForm form = (SalewayForm) getForm();
			
			//设置【是否授权网点】为灰色不能修改，包括新增、修改
			if(form.getChecked() == null || "".equals(form.getChecked()))
				form.setChecked("N");
			
			WayDBParam param = (WayDBParam)getParam();
			DBAccessUser user = getDBAccessUser();
			
			Sysparam sysparamBO = (SysparamBO)BOFactory.build(SysparamBO.class,getDBAccessUser());
			//1:退出时需要填写原因 0:不用填写退出原因 空:不用填写退出原因
			param75 = sysparamBO.doFindByID("75", "channel");
			request.setAttribute("request", param75); 
			// 检查权限令牌
			String paramvalue1 = sysparamBO.doFindByID(new Long("77"), "channel");
			// 如果paramvalue查到记录并且值为1，则需要用新的固定参数显示步骤ID下拉框
			if ("1".equals(paramvalue1)) {
				this.setFlag("yes");
			}
			Wayprovince wayprovince = (Wayprovince) BOFactory.build(WayprovinceBO.class, user);
			List wList = wayprovince.doQueryWpByWayid(wayid);
			if(wList != null && !"".equals(wList) && wList.size()>0){
				WayprovinceVO wVO = (WayprovinceVO)wList.get(0);
				BeanUtils.copyProperties(form, wVO);				
			} 
			
			// String canEditMainLayer = "Y";
			Date starttime=null;
			if (wayid == null || "".equals(wayid)) {
				has3Gright = "true";
				if (param.get_se_upperwayid() == null
						|| "".equals(param.get_se_upperwayid())) {
//					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
//							"CMS-11002:必须指定上级或上级渠道");
//					return "list";
					addActionMessage("必须指定上级或上级渠道");
					return this.doList();
					
				}
				Way way = (Way)BOFactory.build(WayBO.class, user);
				WayVO wayVO = way.doFindByPk(param.get_se_upperwayid());
				/*
				 * if("ET".equals(wayVO.getWaytype())){ canEditMainLayer = "Y";
				 * }else if("AG".equals(wayVO.getWaytype())){ canEditMainLayer =
				 * "N"; }
				 */
				
				if(wayVO == null) {
					super.addActionMessage("必须选择一个上级渠道，只能在连锁经营合作商，移动部门/科室或服务厅下添加社会网点");
					return this.doList();
				}
				// 只能在渠道经销商或服务厅下添加社会网点
				if ("DIS".equals(wayVO.getWaysubtype())
						|| "GMPT".equals(wayVO.getWaysubtype())
						|| "G100".equals(wayVO.getWaysubtype())
						|| "D4S".equals(wayVO.getWaysubtype())
						|| "D5S".equals(wayVO.getWaysubtype())
						|| "D6S".equals(wayVO.getWaysubtype())) {
					form.setUpperwayid(wayVO.getWayid());
					form.setCityid(wayVO.getCityid());
					form.setCountyid(wayVO.getCountyid());
					form.setSvccode(wayVO.getSvccode());
					form.setMareacode(wayVO.getMareacode());
					form.setCenterid(wayVO.getCenterid());
					form.setWaylevel(wayVO.getWaylevel());
				} else {
					super.addActionMessage("必须选择一个上级渠道，只能在连锁经营合作商，移动部门/科室或服务厅下添加社会网点");
					form.setUpperwayid("");
					form.setCityid("");
					form.setCountyid("");
					form.setSvccode("");
					form.setMareacode("");
					form.setCenterid("");
				}
				if (StringUtils.equals(wayVO.getWaytype(), "AG")
						&& StringUtils.equals(wayVO.getWaysubtype(), "DIS")) {
					form.setChainhead(wayVO.getWayid());
				}
				this.setCMD("NEW");
			} else {
				//查询【社会渠道类型】
				Waybusicircle waybusicircleBO = (WaybusicircleBO)BOFactory.build(WaybusicircleBO.class,getDBAccessUser());
				WaybusicircleDBParam waybusicircleDBParam = new WaybusicircleDBParam();
				waybusicircleDBParam.set_se_wayid(form.getWayid());
				DataPackage WaybusicircleDP = waybusicircleBO.doQuery(waybusicircleDBParam);
				if(WaybusicircleDP != null && !"".equals(WaybusicircleDP)
						&& WaybusicircleDP.getDatas() != null && !"".equals(WaybusicircleDP.getDatas())
						&& WaybusicircleDP.getDatas().size() > 0){//存在
					WaybusicircleVO wbVO = (WaybusicircleVO)WaybusicircleDP.getDatas().get(0);
					
					form.setRewardkind(""+wbVO.getRewardkind());
					form.setBuscno(wbVO.getBuscno());
					form.setWayattr(wbVO.getWayattr());
					if(wbVO.getWaymod() != null && !"".equals(wbVO.getWaymod()))
						form.setWaymod(""+wbVO.getWaymod());
				}
				if("0".equals(form.getRewardkind())){
					has3Gright = "true";
				}else if("2".equals(form.getRewardkind())){
					has3Gright = "true";
				}else{
					has3Gright = "false";
				}
				
				//查询之前最新的备注				
				Changelog changelogBO = (ChangelogBO)BOFactory.build(ChangelogBO.class, getDBAccessUser());
				ChangelogDBParam changelogDBParam = new ChangelogDBParam();
				changelogDBParam.set_se_wayid(param.get_pk());
				changelogDBParam.set_ne_changetype("2");
				changelogDBParam.set_orderby("optime");
				changelogDBParam.set_desc("1");
				DataPackage clDp= changelogBO.doQuery(changelogDBParam);
				if(clDp.getRowCount()>0){
					ChangelogVO changelogVO = (ChangelogVO)clDp.getDatas().get(0);
					memo = changelogVO.getMemo();
				}
				Way way = (Way)BOFactory.build(WayBO.class, user);
				Bchcontact bchcontact = (Bchcontact)BOFactory.build(BchcontactBO.class, user);
				Waycompact waycompact = (Waycompact)BOFactory.build(WaycompactBO.class, user);
				Wayaccount wayaccount = (Wayaccount)BOFactory.build(WayaccountBO.class, user);
				Cooperator cooperator =(Cooperator)BOFactory.build(CooperatorBO.class, user);
				Employee employee = (Employee)BOFactory.build(EmployeeBO.class, user);

				WayVO wayVO = way.doFindByPk(wayid);
				if(wayVO!=null)
				{
					starttime=wayVO.getStarttime();
				}
				/*
				 * if("DIS".equals(upperVO.getWaysubtype())){ canEditMainLayer =
				 * "N"; }else{ canEditMainLayer = "Y"; }
				 */
				BchcontactVO bchcontactVO = bchcontact.doFindByPk(
						wayid);
				WaycompactVO waycompactVO = waycompact.doFindByPk(
						wayid);
				WayaccountVO wayaccountVO = new WayaccountVO();
				wayaccountVO.setWayid(wayid);
				wayaccountVO.setAccid(new Integer(0));
				wayaccountVO = wayaccount
						.doFindByPk(wayaccountVO);
				CooperatorVO cooperatorVO = cooperator.doFindByPk(
						wayid);
				EmployeeDBParam listVO = new EmployeeDBParam();
				listVO.set_se_wayid(wayid);
				listVO.set_ne_isnet("1");
				listVO.set_ne_empstatus("0");
				Iterator iterator = employee.doQuery(listVO)
						.getDatas().iterator();
				if (iterator.hasNext()) {
					form.setOfficetel(((EmployeeVO) iterator.next())
							.getOfficetel());
				}

//				AuditUtils utils = new AuditUtils();
//				String[] waypk = { "wayid" };
//				wayVO = (WayVO) utils.doGetAuditvalue(wayVO, "CH_PW_WAY",
//						"CH_PW_SALEWAY", waypk, user);
//
//				bchcontactVO = (BchcontactVO) utils.doGetAuditvalue(
//						bchcontactVO, "CH_PW_BCHCONTACT", "CH_PW_SALEWAY",
//						waypk, user);
//
//				waycompactVO = (WaycompactVO) utils.doGetAuditvalue(
//						waycompactVO, "CH_PW_WAYCOMPACT", "CH_PW_SALEWAY",
//						waypk, user);
//				wayaccountVO = (WayaccountVO) utils.doGetAuditvalue(
//						wayaccountVO, "CH_PW_WAYACCOUNT", "CH_PW_SALEWAY",
//						waypk, user);

				if (bchcontactVO != null) {
					BeanUtils.copyProperties(form, bchcontactVO);
					form.setAddress(null);// 以渠道表的address为准.
				}
				//设置【是否授权网点】，设置回原来的值
				form.setChecked(null);
				BeanUtils.copyProperties(form, wayVO);
				if (waycompactVO != null) {
					BeanUtils.copyProperties(form, waycompactVO);
					form.setCmpendtime(waycompactVO.getEndtime());
				}
				if (wayaccountVO != null) {
					BeanUtils.copyProperties(form, wayaccountVO);
				}
				if (cooperatorVO != null) {
					cooperatorVO.setCityid(form.getCityid());
					cooperatorVO.setCountyid(form.getCountyid());
					cooperatorVO.setSvccode(form.getSvccode());
					cooperatorVO.setMareacode(form.getMareacode());
					BeanUtils.copyProperties(form, cooperatorVO);
				}
				form.setStarttime(starttime);
				form.setOldstate(wayVO.getWaystate());
				this.setCMD("EDIT");
				// 检查权限令牌
				Sysparam sysparam = (Sysparam)BOFactory.build(SysparamBO.class, user);
				String paramvalue = sysparam.doFindByID(new Long("72"), "channel");
				// 如果paramvalue查到记录并且值为1，则视为要检查权限令牌
				if ("1".equals(paramvalue)) {
					boolean hasPermission = false;
					PermissionChecker checker = (PermissionChecker) InterfaceUtils.getInstance().createImplObject(PermissionChecker.class);
					hasPermission = checker.checkPermission( user.getOprcode() , CH_PW_STARLEVEL);
					if (!hasPermission) {
						this.setHasFlag("false");
					}
				}
			}
			if(form.getWaymod() == null || "".equals(form.getWaymod())){
				form.setWaymod("1");
			}
			if(form.getBuscno() == null || "".equals(form.getBuscno())){
				form.setBuscno("0000");
			}
			if(form.getCreditlevel() == null || "".equals(form.getCreditlevel())){
				form.setCreditlevel("0");
			}
		} catch (Exception e) {
			setActionMessage(e.getMessage());
		}
		return "content";
	}
	
	//开通服务
	public String doSetservice() throws Exception {
		try {
			AGWay delegate = (AGWay)BOFactory.build(AGWayBO.class, getDBAccessUser());
			HttpServletRequest request = getRequest();
			String wayid = request.getParameter("wayid");
			delegate.doSetservice(wayid, getDBAccessUser());
			super.addActionMessage("渠道信息服务开通需要一段时间，请稍后查看是否开通成功");
		} catch (Exception e) {
			setActionMessage(e.getMessage());
		}
		return this.doList();
	}
	
	//导出TXT
	public String doExportTxt(){
		try{
			User user = (User) getDBAccessUser();
			CommonExportBean export = new CommonExportBean(user);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			super.getParam().setQueryAll(true);
			export.setFileName("社会网点信息导出");
			String selectedFields = getRequest().getParameter("selectedFields");
			// sfArray包含 ：每个已选字段在optionFields中一维元素的下标值
			String[] sfArray = selectedFields.split(",");
			// titleArray 已选字段中文名称
			String[] titleArray = new String[sfArray.length];
			for(int i = 0;i < sfArray.length;i++) {
				int k = Integer.parseInt(sfArray[i]);
				if(k == (int)(15+1) || k==(int)((36+1)+1) || k==(int)((37+1)+1) || k==(int)((38+1)+1) || k==(int)((40+1)+1)){
					export.addOutputProperty(optionFields[k][0],optionFields[k][1],CommonExportBean.DATE,"yyyy-MM-dd");
					titleArray[i] = optionFields[k][1];
				}else if(k==(int)4){
					export.addOutputProperty(optionFields[k][0],optionFields[k][1],CommonExportBean.CODE2NAME,"#WAY");
					titleArray[i] = optionFields[k][1];
				}else if(k==(int)71){
					export.addOutputProperty(optionFields[k][0],optionFields[k][1],CommonExportBean.CODE2NAME,"$CH_TAXCERTIFICATE");
					titleArray[i] = optionFields[k][1];
				}
				else{
					export.addOutputProperty(optionFields[k][0],optionFields[k][1]);
					titleArray[i] = optionFields[k][1];
				}
			}
//			for(int i = 0;i < sfArray.length;i++) {
//				int k = Integer.parseInt(sfArray[i]);
//				if(k == (int)15 || k==(int)(36+1) || k==(int)(37+1) || k==(int)(38+1) || k==(int)(40+1)){
//					export.addOutputProperty(optionFields[k][0],optionFields[k][1],CommonExportBean.DATE,"yyyy-MM-dd");
//					titleArray[i] = optionFields[k][1];
//				}else
//				{
//					export.addOutputProperty(optionFields[k][0],optionFields[k][1]);
//					titleArray[i] = optionFields[k][1];
//				}
//			}
			
			/*export.addOutputProperty("wayid", "渠道编码");
			export.addOutputProperty("wayname", "渠道名称");
			export.addOutputProperty("officetel", "采集平台捆绑手机号");
			export.addOutputProperty("isopen", "开通标志",export.CODE2NAME,"$CH_ISOPEN");
			export.addOutputProperty("waysubtype", "零售渠道类别 ",export.CODE2NAME,"WAYSUBTYPE");
			export.addOutputProperty("upperwayid", "上级渠道",export.CODE2NAME,"#WAY");
			export.addOutputProperty("latitude", "地理纬度");
			export.addOutputProperty("longtitude", "地理经度");
			export.addOutputProperty("starlevel", "星级",export.CODE2NAME,"$CH_STARLEVEL");
			export.addOutputProperty("pt", "排他性",export.CODE2NAME,"$CH_PT");
			export.addOutputProperty("isstraitprd", "是否直供",export.CODE2NAME,"$CH_STRAITPRD");
			export.addOutputProperty("catetype", "连锁性质",export.CODE2NAME,"$CH_CATETYPE");
			export.addOutputProperty("cityid", "地市公司",export.CODE2NAME,"#CITYCOMPANY");
			export.addOutputProperty("countyid", "分公司",export.CODE2NAME,"#CNTYCOMPANY");
			export.addOutputProperty("svccode", "服务销售中心",export.CODE2NAME,"#CH_SERVCENT");
			export.addOutputProperty("mareacode", "微区域",export.CODE2NAME,"#CH_MICROAREA");
			export.addOutputProperty("adtypecode", "区域类型",export.CODE2NAME,"$CH_ADTYPE");
			export.addOutputProperty("adacode", "行政区划",export.CODE2NAME,"#CH_ADIMAREA");
			export.addOutputProperty("formtype", "业态类型",export.CODE2NAME,"$CH_FORMTYPE");
			export.addOutputProperty("starttime", "合作开始时间",export.DATE,"yyyy-MM-dd");
			export.addOutputProperty("logiscode", "所属物流商");
			export.addOutputProperty("waymagcode", "所属渠道经理人员工号");
			export.addOutputProperty("bchlevel", "分级",export.CODE2NAME,"$CH_BCHLEVEL");
			export.addOutputProperty("waystate", "渠道状态",export.CODE2NAME,"$CH_VALIDFLAG");
			export.addOutputProperty("address", "详细地址");*/
			
			export.voClassArray = new Class[] {AGWayVO.class};
			prepareResponse(export.getFileName());
			export.queryMethodName = "doQueryWayAndSubwayDetailInfo";

			export.writeTxtTitle(getResponse().getOutputStream(), titleArray);
			super.ExportQuery(getForm(), getRequest(), getResponse(), user, export);
		}catch(Exception e){
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return null;
	}
	
	//exportExcel
	//导出Excel
	public String doExportExcel(){
		try{
			User user = (User) getDBAccessUser();
			CommonExportBean export = new CommonExportBean(user);
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			super.getParam().setQueryAll(true);
			export.setFileName("社会网点信息导出");
			String selectedFields = getRequest().getParameter("selectedFields");
			// sfArray包含 ：每个已选字段在optionFields中一维元素的下标值
			String[] sfArray = selectedFields.split(",");
			// titleArray 已选字段中文名称
			String[] titleArray = new String[sfArray.length];
			for(int i = 0;i < sfArray.length;i++) {
				int k = Integer.parseInt(sfArray[i]);
				if(k == (int)(15+1) || k==(int)((36+1)+1) || k==(int)((37+1)+1) || k==(int)((38+1)+1) || k==(int)((40+1)+1)){
					export.addOutputProperty(optionFields[k][0],optionFields[k][1],CommonExportBean.DATE,"yyyy-MM-dd");
					titleArray[i] = optionFields[k][1];
				}else if(k==(int)4){
					export.addOutputProperty(optionFields[k][0],optionFields[k][1],CommonExportBean.CODE2NAME,"#WAY");
					titleArray[i] = optionFields[k][1];
				}else if(k==(int)71){
					export.addOutputProperty(optionFields[k][0],optionFields[k][1],CommonExportBean.CODE2NAME,"$CH_TAXCERTIFICATE");
					titleArray[i] = optionFields[k][1];
				}
				else{
					export.addOutputProperty(optionFields[k][0],optionFields[k][1]);
					titleArray[i] = optionFields[k][1];
				}
			}
//			for(int i = 0;i < sfArray.length;i++) {
//				int k = Integer.parseInt(sfArray[i]);
//				if(k == (int)15 || k==(int)(36+1) || k==(int)(37+1) || k==(int)(38+1) || k==(int)(40+1)){
//					export.addOutputProperty(optionFields[k][0],optionFields[k][1],CommonExportBean.DATE,"yyyy-MM-dd");
//					titleArray[i] = optionFields[k][1];
//				}else
//				{
//					export.addOutputProperty(optionFields[k][0],optionFields[k][1]);
//					titleArray[i] = optionFields[k][1];
//				}
//			}
			
			export.voClassArray = new Class[] {AGWayVO.class};
			//prepareResponse(export.getFileName());
			export.queryMethodName = "doQueryWayAndSubwayDetailInfo";
			
//			export.writeTxtTitle(getResponse().getOutputStream(), titleArray);
//			export.writeExcelEndLine(getResponse().getOutputStream(), titleArray);
			
			//export.wri
			this.getRequest().setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
			super.doExcel();
			
			///super.ExportQuery(getForm(), getRequest(), getResponse(), user, export);
		}catch(Exception e){
			e.printStackTrace();
			super.addActionError(e.getMessage());
		}
		return null;
	}
	
	
	public String  doCheckupperway() throws Exception {
		Way way = (Way) BOFactory.build(WayBO.class, getDBAccessUser());
		SalewayForm form = (SalewayForm) getForm();
		WayVO uppwayVO = way.doFindByPk(form.getUpperwayid());
		if(uppwayVO==null)
		{
			throw new Exception("所选渠道在PBOSS系统没有找到!");
		}
		
		//设置【是否授权网点】，设置回原来的值
		WayVO wayVO = way.doFindByPk(form.getWayid());
		if(wayVO!=null)
		{
			form.setChecked(wayVO.getChecked());
		}else{//新增调成否
			form.setChecked("N");
		}
		
		// 社会网点的上级渠道必须是合作商，移动部门/科室或服务厅下添加社会网点
		if ("DIS".equals(uppwayVO.getWaysubtype())
				|| "GMPT".equals(uppwayVO.getWaysubtype())
				|| "G100".equals(uppwayVO.getWaysubtype())) {
			form.setCityid(uppwayVO.getCityid());
			form.setCountyid(uppwayVO.getCountyid());
			form.setSvccode(uppwayVO.getSvccode());
			form.setMareacode(uppwayVO.getMareacode());
		} else {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
					"录入的上级渠道只能是连锁经营合作商，移动部门/科室或服务厅");
			form.setUpperwayid("");
			form.setCityid("");
			form.setCountyid("");
			form.setSvccode("");
			form.setMareacode("");
		}
		if (form.getWayid()==null || way.doFindByPk(form.getWayid())==null) {
			this.setCMD("NEW");
		} else {
			this.setCMD("EDIT");
		}
		if(StringUtils.equals(uppwayVO.getWaytype(), "AG") && StringUtils.equals(uppwayVO.getWaysubtype(), "DIS"))
		{
			form.setChainhead(uppwayVO.getWayid());
		}
		else
		{
			form.setChainhead("");
		}
		return "content";
	}
	public String getHasFlag() {
		return hasFlag;
	}
	public void setHasFlag(String hasFlag) {
		this.hasFlag = hasFlag;
	}
	//修改的星级修改做判断
	public void checkUpdateStartLevel(AGWayVO wayVO,User user) throws Exception
	{
		if(wayVO != null)
		{
			String wayid = wayVO.getWayid();
			//User user = (User) getDBAccessUser();
			AGWayBO wayBO = (AGWayBO)BOFactory.build(AGWayBO.class, user);
			WayVO wayvo = wayBO.doFindByPk(wayid, user);
			
			Long starLevel=wayVO.getStarlevel();
			Long beforeStarLevel = wayvo.getStarlevel();
			
			if(starLevel != null && beforeStarLevel != null) {
				if(beforeStarLevel == 1 || beforeStarLevel == 2){					
					if(starLevel>=3){
						wayVO.setStarttime(new Date());
					}					
				}
				if(beforeStarLevel >= 3){
					if(starLevel == 1 || starLevel == 2){
						wayVO.setStarttime(null);
					}
				}
			}
		}
	}
	
	
	//新增的星级修改做判断
	public void checkAddStartLevel(AGWayVO wayVO) throws Exception
	{
		if(wayVO != null)
		{
			Long starLevel=wayVO.getStarlevel();
			if(starLevel >= 3){
				wayVO.setStarttime(new Date());
			}
			if(starLevel == 1 || starLevel == 2){
				wayVO.setStarttime(null);
			}	
		}
	}
	public String getParam75() {
		return param75;
	}
	public void setParam75(String param75) {
		this.param75 = param75;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getHas3Gright() {
		return has3Gright;
	}
	public void setHas3Gright(String has3Gright) {
		this.has3Gright = has3Gright;
	}
}
