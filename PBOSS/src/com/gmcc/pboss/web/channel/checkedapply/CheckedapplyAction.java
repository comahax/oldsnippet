/**
 * auto-generated code
 * Sat Jun 09 10:21:12 CST 2012
 */
 package com.gmcc.pboss.web.channel.checkedapply;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.gmcc.pboss.business.channel.checkedapply.CheckedapplyDBParam;
import com.gmcc.pboss.business.channel.checkedapply.CheckedapplyVO;
import com.gmcc.pboss.business.channel.checkedapplydetail.CheckedapplydetailDBParam;
import com.gmcc.pboss.business.channel.checkedapplydetail.CheckedapplydetailVO;
import com.gmcc.pboss.business.channel.way.WayDBParam;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.common.ftp.FtpAccess;
import com.gmcc.pboss.common.ftp.FtpBusUtils;
import com.gmcc.pboss.common.ftp.FtpInfo;
import com.gmcc.pboss.control.base.operright.Operright;
import com.gmcc.pboss.control.base.operright.OperrightBO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.checkedapply.Checkedapply;
import com.gmcc.pboss.control.channel.checkedapply.CheckedapplyBO;
import com.gmcc.pboss.control.channel.checkedapplydetail.Checkedapplydetail;
import com.gmcc.pboss.control.channel.checkedapplydetail.CheckedapplydetailBO;
import com.gmcc.pboss.control.channel.nosect.Nosect;
import com.gmcc.pboss.control.channel.nosect.NosectBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.struts2.BaseAction;
 

/**
 * <p>Title: CheckedapplyAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class CheckedapplyAction extends BaseAction{
	
	private String remotepath = "checkedapply";
	//excel文件
	private File appathDoc;
	private String appathDocFileName;
	private String appathDocType;
	//ppt文件
	private File pptpathDoc;
	private String pptpathDocFileName;
	private String pptpathDocType;
	// 拥有分公司令牌
	private boolean CH_CHECKED_COUNTY;
	// 拥有市公司初审令牌
	private boolean CH_CHECKED_MIDCITY;
	// 系统参数：授权网点几层审核流程
	private boolean paramvalue;
	
	public boolean isCH_CHECKED_COUNTY() {
		return CH_CHECKED_COUNTY;
	}

	public void setCH_CHECKED_COUNTY(boolean ch_checked_county) {
		CH_CHECKED_COUNTY = ch_checked_county;
	}

	public CheckedapplyAction() {
		super();

		//以下几个方法是必须的
		this.setForm(new CheckedapplyForm());
		this.setParam(new CheckedapplyDBParam());

        //指定VO类
        setClsVO(CheckedapplyVO.class);
        //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
        this.pkNameArray=new String[]{"applyno"};
		this.setClsControl(Checkedapply.class);
		this.setClsQueryParam(CheckedapplyDBParam.class) ;

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}
	
	/**
	 * 1、判断市公司是否配置了系统参数【授权网点几层审核流程】(systemid=83, paramtype=’channel’)并且值为1
	 * 2、判断当前登录用户是否拥有分公司令牌
	 * 3、判断当前登录用户是否拥有市公司初审令牌
	 * @throws Exception
	 */
	private void getSysParme() throws Exception {
		Sysparam sysparam = (Sysparam) BOFactory.build(SysparamBO.class, getDBAccessUser());
		String value = sysparam.doFindByID("83", "channel");
		if (value != null && value.equals("1")) {
			paramvalue = true;
		}
		
		Operright operright = (Operright) BOFactory.build(OperrightBO.class, DBAccessUser.getInnerUser());
		boolean ch_checked_county = operright.doCheckPermission(getDBAccessUser().getOprcode(), "CH_CHECKED_COUNTY");
		setCH_CHECKED_COUNTY(ch_checked_county);
		
		boolean ch_checked_midcity = operright.doCheckPermission(getDBAccessUser().getOprcode(), "CH_CHECKED_MIDCITY");
		this.setCH_CHECKED_MIDCITY(ch_checked_midcity);
	}
	
	//查询授权网点申请表信息
	public String doList() throws Exception {
		CheckedapplyDBParam params = (CheckedapplyDBParam) getParam();
		if(flag){    //申请开始时间默认为当月第一天的当天数据
			Date mdate = new Date();
			SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-");
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
			String stockdate = myformat.format(mdate)+"01 00:00:00";
			String currdate = format.format(mdate)+" 23:59:59";
			params.set_dnl_aptime(stockdate);
			params.set_dnm_aptime(currdate);
		}
		
		/*
		 * 判断市公司是否配置了系统参数【授权网点几层审核流程】并且值为1
		 * 判断当前登录用户是否拥有分公司令牌
		 * 判断当前登录用户是否拥有市公司初审令牌
		 */
		getSysParme();
		/*
		 * 拥有分公司令牌【CH_CHECKED_COUNTY】查询STATUS为 2 和 3 的申请
		 * 拥有市公司初审令牌【CH_CHECKED_MIDCITY】查询STATUS为 1 和 2 的申请
		 */
		if (paramvalue && CH_CHECKED_COUNTY) {
			params.set_sql_or("status = 2 or status = 3");
		} else if (paramvalue && CH_CHECKED_MIDCITY) {
			params.set_sql_or("status = 0 or status = 1");
		}
		params.set_se_oprcode(getDBAccessUser().getOprcode());
		params.set_orderby("applyno");
		params.set_desc("1");
		return super.doList();
	}
	
	/**
	 * 进入批量导入页面
	 */
	public String doBatch() throws Exception {
		CheckedapplyDBParam params = (CheckedapplyDBParam) getParam(); 
		HttpServletRequest request = getRequest();
		request.getSession().setAttribute("checkparam", params);

		return "batchapply";
	}
	
	/**
	 * 从批量导入页面返回
	 * @return
	 * @throws Exception
	 */
	public String doRetrunfrombatch() throws Exception {
		//取得导入页面返回的时候的参数值
		HttpServletRequest request = getRequest();
		CheckedapplyDBParam batchparams = (CheckedapplyDBParam)request.getSession().getAttribute("checkparam");
		String applyno = batchparams.getApplyeno();
		CheckedapplyDBParam params = (CheckedapplyDBParam) getParam();
		
		// 设置返回页面
		String result = "";
		if (applyno == null || "".equals(applyno)) {
			BeanUtils.copyProperties(params, batchparams);
			result = this.doNew();
		} else {
			BeanUtils.copyProperties(params, batchparams);
			result = this.doApplydeatilinfo();
		}
		return result;
	}
	/**
	 *详细数据页面列表分页
	 */
	  public String doSplitPage() throws Exception{
		//取得导入页面返回的时候的参数值
			HttpServletRequest request = getRequest();
			String applyno = request.getParameter("param.applyeno"); 
			if (applyno == null || "".equals(applyno)) { 
				this.doNew();
			} else { 
				 this.doApplydeatilinfo();
			}
			//this.setDp(dp);
		  return "editlist";
	  }
	
	
	//新增初始化授权网点申请表信息数据
	public String doNew() throws Exception{
		/*
		 * 判断市公司是否配置了系统参数【授权网点几层审核流程】并且值为1
		 * 判断当前登录用户是否拥有分公司令牌
		 * 判断当前登录用户是否拥有市公司初审令牌
		 */
		getSysParme();
		
		HttpServletRequest request = getRequest(); 
	    CheckedapplyDBParam params = (CheckedapplyDBParam) getParam(); 
	    // 设置申请时间
	    if (null==params.getAptime())
	    	params.setAptime(new Date());
	    // 设置申请地市
	    if (null==params.getCityid())
	    	params.setCityid(getDBAccessUser().getCityid());
	    // 设置申请人工号
	    if (null==params.getOprcode())
	    	params.setOprcode(getDBAccessUser().getOprcode());
		request.getSession().setAttribute("NewParms",params) ;
		CheckedapplydetailDBParam param = new CheckedapplydetailDBParam(); 
		param.set_pageno(params.get_pageno());
		param.set_pagesize(params.get_pagesize());
		param.set_se_oprcode(getDBAccessUser().getOprcode()); 
		param.set_se_applyno(params.getApplyeno());
		//设置申请类型
		param.set_se_applytype(params.getApplytype());
		
		DataPackage dp = null;
		Checkedapplydetail checkedapplydetailBO = (Checkedapplydetail) BOFactory.build(CheckedapplydetailBO.class, getDBAccessUser());
		if (paramvalue && CH_CHECKED_COUNTY) {
			dp = checkedapplydetailBO.doQueryInfoForInsert_COUNTY(param);
		} else if (paramvalue && CH_CHECKED_MIDCITY) {
			dp = checkedapplydetailBO.doQueryInfoForInsert_MIDCITY(param);
		} else {
			dp = checkedapplydetailBO.doQueryInfoForInsert(param);
		}
		
        this.setDp(dp);
		return "editlist"; 
	}
	//编辑初始化授权网点申请表信息数据
	public String doApplydeatilinfo() throws Exception{ 
		 HttpServletRequest request = getRequest(); 
		 Checkedapply checkedapply = (Checkedapply)BOFactory.build(CheckedapplyBO.class,getDBAccessUser());
		 CheckedapplyDBParam params = (CheckedapplyDBParam) getParam();
		 
		 //设置申请单号
		 String applyno = "";
		 if (request.getParameter("param._pk")!=null)
			 applyno = request.getParameter("param._pk");
		 if ("".equals(applyno))
			 applyno = params.getApplyeno();
		 CheckedapplyVO checkedapplyVO = checkedapply.doFindByPk(Long.parseLong(applyno));
		 CheckedapplyForm form = new CheckedapplyForm();
		 BeanUtils.copyProperties(form, checkedapplyVO);
		
		 //设置页面数值
		 BeanUtils.copyProperties(params, checkedapplyVO);
		 //如果申请单号为空
		 if (params.getApplyeno()==null)
			 params.setApplyeno(checkedapplyVO.getApplyno().toString());
		 this.setForm(form);
		 CheckedapplydetailDBParam param = new CheckedapplydetailDBParam(); 
		 param.set_pageno(params.get_pageno()); 
	    // param.set_pagesize(params.get_pagesize());
		 param.set_pagesize("0");
		 param.set_se_applyno(checkedapplyVO.getApplyno().toString()); 
		 param.set_se_applytype(params.getApplytype());
		 Checkedapplydetail checkedapplydetailBO = (Checkedapplydetail) BOFactory.build(CheckedapplydetailBO.class, getDBAccessUser()); 
		 DataPackage dp = checkedapplydetailBO.doQueryInfoForUpdate(param);  
         this.setDp(dp);
         //更新的时候申请类型不可变
         this.setADDUP("1");
		return "editlist";
	}
	
	//保存授权网点申请表信息
	public String doSave()throws Exception{
		String savecmd = "0";
	   try {
		HttpServletRequest request = getRequest(); 
		CheckedapplyDBParam params = (CheckedapplyDBParam) getParam();

		// 检查手机号跟申请人在同一个地市
		Nosect control = (Nosect) BOFactory.build(NosectBO.class, getDBAccessUser());
		String cityid = control.doQueryCityID(params.getMobileno());
		if (!getDBAccessUser().getCityid().equals(cityid)) {
			throw new Exception("手机号码所属地市: "+cityid+" 与登录工号所属地市不一致");
		}
		Checkedapply checkedapply = (Checkedapply)BOFactory.build(CheckedapplyBO.class,getDBAccessUser());
		CheckedapplyVO checkedapplyVO = new CheckedapplyVO();
		BeanUtils.copyProperties(checkedapplyVO, params);

			if ((null != getAppathDocFileName() && !"".equals(this
					.getAppathDocFileName()))
					|| (null != getPptpathDocFileName() && !"".equals(this
							.getPptpathDocFileName()))) {
				FtpInfo ftpInfo = FtpInfo.getInstance();
				FtpAccess ftp = new FtpAccess(ftpInfo);
				if (null != getAppathDocFileName()
						&& !"".equals(this.getAppathDocFileName())) {
					// 上传的文件用本地文件类型
					String filename =changeFilename(getAppathDocFileName(),"Y");
					String appath = ftp.uploadFile(this.appathDoc, remotepath,
							true, filename);
					checkedapplyVO.setAppath(appath);
					params.setAppath(appath);
				}
				if (getPptpathDocFileName() != null
						&& !"".equals(this.getPptpathDocFileName())) {
					// 上传的文件用本地文件类型
					String filename =changeFilename(getPptpathDocFileName(),"N");
					String pptpath = ftp.uploadFile(this.pptpathDoc,
							remotepath, true, filename);
					checkedapplyVO.setPptpath(pptpath);
					params.setPptpath(pptpath);
				}
			}
			
			/*
			 * 判断市公司是否配置了系统参数【授权网点几层审核流程】并且值为1
			 * 判断当前登录用户是否拥有分公司令牌
			 * 判断当前登录用户是否拥有市公司初审令牌
			 */
			getSysParme();
			if (paramvalue && CH_CHECKED_COUNTY) {
				//配置了系统参数【授权网点几层审核流程】值为1，并且拥有分公司令牌
				checkedapplyVO.setStatus("2");
			} else if (paramvalue && CH_CHECKED_MIDCITY) {
				//配置了系统参数【授权网点几层审核流程】值为1，并且拥有市公司初审令牌
				checkedapplyVO.setStatus("0");
			} else {
				checkedapplyVO.setStatus("0");
			}
			
			if(null==params.getApplyeno() || "".equals(params.getApplyeno())){
			      //新增
				CheckedapplyVO chvo = null;
				if (paramvalue) {
					chvo = checkedapply.doAddCheckedapply(checkedapplyVO, CH_CHECKED_COUNTY, CH_CHECKED_MIDCITY);
				} else {
					chvo = checkedapply.doAddCheckedapply(checkedapplyVO);
				}
				
				if (chvo.getApplyno()!=null) {
					params.setApplyeno(chvo.getApplyno().toString());
				}				
			    this.doNew();
			    this.setCMDFLAG("1");
			    setActionMessage("保存成功");
			}else{
			      //更新
				savecmd = "1";
				// 更新的时候重新获取申请类型
				String applytype = request.getParameter("applytype");
				checkedapplyVO.setApplytype(applytype);
				checkedapplyVO.setApplyno(Long.parseLong(params.getApplyeno()));
			    checkedapply.doUpdateCheckedapply(checkedapplyVO);
			    this.doApplydeatilinfo();
			    this.setCMDFLAG("1");
			    setActionMessage("保存成功");
			}
			
	} catch (Exception e) { 
		if ("0".equals(savecmd)) {
			this.doNew();
		} else {
			this.doApplydeatilinfo();
		}		
		setActionMessage(e.getMessage());
	}
		return "editlist"; 
	}
	
	//删除授权网点申请明细表
	public String doDelete() throws Exception{
		String[] selectArray = ((DBQueryParam) getParam()).get_selectitem();
		Checkedapplydetail checkedapplydetailBO = (Checkedapplydetail) BOFactory.build(CheckedapplydetailBO.class, getDBAccessUser()); 
		for(int i=0;i<selectArray.length;i++){
			checkedapplydetailBO.doRemoveByPK(Long.parseLong(selectArray[i]));
		}
		CheckedapplyDBParam params = (CheckedapplyDBParam) getParam();
		if(null==params.getApplyeno() || "".equals(params.getApplyeno())){
			this.doNew();
		} else {
			this.doApplydeatilinfo();
		}		
		return "editlist";
	}
	
	//申请文件上传
	public String doDownload() throws Exception{
			try {
				HttpServletRequest request=ServletActionContext.getRequest(); 
				String url = request.getParameter("file");
				// 文件名中文乱码转换
				String result = new String(url.getBytes("iso-8859-1"), "gb2312");
				url = result;
				FtpAccess ftpAccess = new FtpAccess(FtpInfo.getInstance());
				String localPath =ServletActionContext.getServletContext().getRealPath("/") ;
				System.out.println("----->localPath：" + localPath + "\n" + "----->url：" + url);
				//localPath="D:\\yl\\123";
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
	
	//选择申请网店
	public String doChooseapplyway()throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest(); 
		String applytype = request.getParameter("applytype");
		String applyeno = request.getParameter("applyeno");
		Checkedapplydetail ckdetail = (Checkedapplydetail)BOFactory.build(CheckedapplydetailBO.class, getDBAccessUser());
		CheckedapplyDBParam ckparams = (CheckedapplyDBParam) getParam();
		// 设置申请单号
		if (ckparams.getApplyeno()==null)
		ckparams.setApplyeno(applyeno);
		
		WayDBParam params = new WayDBParam();
		params.set_pageno(ckparams.get_pageno());//设置页码翻页用
		params.set_pagesize(ckparams.get_pagesize());
		params.set_se_cityid(getDBAccessUser().getCityid());
		DataPackage dp = null; 
		if (applytype.equals("1")){  //申请类型为退出
			dp= ckdetail.doQueryWayinfoForExitway(params);
			this.setDp(dp);
		 return "applyexit";
		}else{                     //申请类型为准入
			dp = ckdetail.doQueryWayinfoForapplyway(params);
			this.setDp(dp);
		 return "applyenter";
		} 
	}
	
	//申请类型为退出
	public String doQueryWayinfoForExitway()throws Exception{
		
		Checkedapplydetail ckdetail = (Checkedapplydetail)BOFactory.build(CheckedapplydetailBO.class, getDBAccessUser());
		WayDBParam params = new WayDBParam();
		CheckedapplyDBParam ckparams = (CheckedapplyDBParam) getParam();
		params.set_se_wayid(ckparams.get_sk_wayid());
		params.set_sk_wayname(ckparams.get_sk_wayname());
		params.set_pageno(ckparams.get_pageno());//设置页码翻页用
		params.set_pagesize(ckparams.get_pagesize());
		
		params.set_se_cityid(getDBAccessUser().getCityid());
		DataPackage dp = null; 
		dp= ckdetail.doQueryWayinfoForExitway(params);
		this.setDp(dp);
		
		return "applyexit";
	}
	
	//申请类型为准入
	public String doQueryWayinfoForapplyway()throws Exception{
		
		Checkedapplydetail ckdetail = (Checkedapplydetail)BOFactory.build(CheckedapplydetailBO.class, getDBAccessUser());
		WayDBParam params = new WayDBParam();
		CheckedapplyDBParam ckparams = (CheckedapplyDBParam) getParam();
		params.set_se_wayid(ckparams.get_sk_wayid());
		params.set_sk_wayname(ckparams.get_sk_wayname());
		params.set_pageno(ckparams.get_pageno());//设置页码翻页用
		params.set_pagesize(ckparams.get_pagesize());
		
		params.set_se_cityid(getDBAccessUser().getCityid());
		DataPackage dp = null; 
		dp= ckdetail.doQueryWayinfoForapplyway(params);
		this.setDp(dp);
		
		return "applyenter";
	}
	
	public String doCheckchained(){
		try{
			String result = "";
			//取得勾选的网点
			String select = ((CheckedapplyDBParam) getParam()).getSelectw();
			String[] selectArray = select.split("\\|");
			String chktype = ((CheckedapplyDBParam) getParam()).getChktype();
			
			Way way = (Way) BOFactory.build(WayBO.class, getDBAccessUser());
			if (("1").equals(chktype)){
					for (int i = 0; i < selectArray.length; i++) {
						WayVO wayVO = way.doFindByPk(selectArray[i]);
						if (wayVO == null || null == wayVO.getChainhead()|| "".equals(wayVO.getChainhead())) {
							result = "网点" + selectArray[i]+ "的所属合作商没有设置，请到社会网点信息管理页面设置。";
							break;
						}
					}					
			}
 
			super.getResponse().getWriter().write(result);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	//保存授权网点明细信息
	public String doSavedetail()throws Exception{
		 try {
			Checkedapplydetail checkedapplydetailBO = (Checkedapplydetail) BOFactory.build(CheckedapplydetailBO.class, getDBAccessUser());
			String[] selectArray = ((DBQueryParam) getParam()).get_selectitem();
			// 取得考核方式
			String chktype = ((CheckedapplyDBParam) getParam()).getChktype();
			// 渠道调整类型
			String chgtype = ((CheckedapplyDBParam) getParam()).getChgtype();
			HttpServletRequest request=ServletActionContext.getRequest(); 
			// 取得申请类型
			String applytype = request.getParameter("applytype");
			// 申请单号
			String applyno = ((CheckedapplyDBParam) getParam()).getApplyeno();
			Way way = (Way) BOFactory.build(WayBO.class, getDBAccessUser());
			CheckedapplydetailVO vo = new CheckedapplydetailVO();
			
			getSysParme();
			if (paramvalue && CH_CHECKED_COUNTY) {
				vo.setIsflag(Short.parseShort("0"));
			} else if (paramvalue && CH_CHECKED_MIDCITY) {
				vo.setIsflag(Short.parseShort("1"));
			}

			vo.setChktype(chktype);//设置考核方式
			//申请类型设置为前一个页面选择的申请类型
			vo.setApplytype(applytype);
			
			for (int i = 0; i < selectArray.length; i++) {
				WayVO wayVO = way.doFindByPk(selectArray[i]);
				WayDBParam wayDBParam = new WayDBParam();
				wayDBParam.set_se_wayid(selectArray[i]);
				DataPackage dp1 = way.doQueryWaytype(wayDBParam);
				 if(("1").equals(wayVO.getIstop())){
					 vo.setWtype("1");
				 }else if(null != dp1 && dp1.getDatas().size()>0){
//					 WayVO wayvo1 = (WayVO)dp1.getDatas().get(0);
//					 if (("2").equals(wayvo1.getIstietong())){
					 vo.setWtype("2");
//					 }else{
//						 vo.setWtype("3");
//					 }
				 } else {
					 vo.setWtype("3");
				 }
				 // 申请单号
				 if (!"".equals(applyno) && applyno != null) {
					 vo.setApplyno(Long.parseLong(applyno));
				 }
				 //申请人设置为当前登录人工号
				 vo.setOprcode(getDBAccessUser().getOprcode());
				 // 申请地市设置为当前登录地市
				 vo.setCityid(getDBAccessUser().getCityid());
				 //渠道编码设置为勾选的渠道编码
				 vo.setWayid(selectArray[i]);
				 //调整内容设置为页面选择的调整内容
				 vo.setChgtype(chgtype);
				 checkedapplydetailBO.doCreate(vo); 
			}
			
		} catch (Exception e) {
			String result = this.doChooseapplyway();
			setActionMessage(e.getMessage());
			return result;
		}
		String result = this.doChooseapplyway();
		this.setCMDFLAG("1");
		setActionMessage("保存成功");
		return result;
	}
	
	//根据申请类型查询申请表数据
	public String doQueryByapplytype() throws Exception{
		HttpServletRequest request = getRequest(); 
		CheckedapplyDBParam params = (CheckedapplyDBParam) getParam(); 
		CheckedapplyDBParam checkedapplyDBParam = (CheckedapplyDBParam)request.getSession().getAttribute("NewParms");
		Checkedapplydetail checkedapplydetailBO = (Checkedapplydetail) BOFactory.build(CheckedapplydetailBO.class, getDBAccessUser());
		CheckedapplydetailDBParam param = new CheckedapplydetailDBParam();   
		String applytype = request.getParameter("applytype");
		param.set_se_oprcode(getDBAccessUser().getOprcode()); 
		param.set_se_applyno(checkedapplyDBParam.get_ne_applyno());
		param.set_se_applytype(applytype);
	    params.setCityid(checkedapplyDBParam.getCityid());
	    params.setOprcode(checkedapplyDBParam.getOprcode());
	    params.setApplytype(applytype);
	    params.setAptime(checkedapplyDBParam.getAptime());
	    
	    /*
		 * 判断市公司是否配置了系统参数【授权网点几层审核流程】并且值为1
		 * 判断当前登录用户是否拥有分公司令牌
		 * 判断当前登录用户是否拥有市公司初审令牌
		 */
		getSysParme();
	    DataPackage dp = null;
	    if (paramvalue && CH_CHECKED_COUNTY) {
			dp = checkedapplydetailBO.doQueryInfoForInsert_COUNTY(param);
		} else if (paramvalue && CH_CHECKED_MIDCITY) {
			dp = checkedapplydetailBO.doQueryInfoForInsert_MIDCITY(param);
		} else {
			dp = checkedapplydetailBO.doQueryInfoForInsert(param);
		}
        this.setDp(dp); 
		return "editlist"; 
	}
	
    /**
     * 将文件名改名为英文的文件名
     * @param filename 原文件名称
     * @param type 文件类型
     * @return 新文件名称
     */
    public String changeFilename(String filename, String type){
        if (filename == null || filename.equals("")) return filename;
        int pos = filename.indexOf(".");
        if (pos < 0) return filename;
        else{
            // 当上传文件为申请表文件时
            if ("Y".equals(type)) {
            	return "APPFILE"  + filename.substring(pos);
            	
            	// 当上传文件为PPT文件时
            } else {
            	return "PPTFILE"  + filename.substring(pos);
            }           
        }
    }	
	
	//保存状态控制标识
	private String CMDFLAG;
	//更新/新增标识
	private String ADDUP;
	
	private boolean flag=true;

	public boolean getFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public String getAppathDocFileName() {
		return appathDocFileName;
	}
	public void setAppathDocFileName(String appathDocFileName) {
		this.appathDocFileName = appathDocFileName;
	}
	public String getAppathDocType() {
		return appathDocType;
	}
	public void setAppathDocType(String appathDocType) {
		this.appathDocType = appathDocType;
	}
	public String getPptpathDocFileName() {
		return pptpathDocFileName;
	}
	public void setPptpathDocFileName(String pptpathDocFileName) {
		this.pptpathDocFileName = pptpathDocFileName;
	}
	public String getPptpathDocType() {
		return pptpathDocType;
	}
	public void setPptpathDocType(String pptpathDocType) {
		this.pptpathDocType = pptpathDocType;
	}

	public String getCMDFLAG() {
		return CMDFLAG;
	}

	public void setCMDFLAG(String cmdflag) {
		CMDFLAG = cmdflag;
	}

	public String getADDUP() {
		return ADDUP;
	}

	public void setADDUP(String addup) {
		ADDUP = addup;
	}

	public File getAppathDoc() {
		return appathDoc;
	}

	public void setAppathDoc(File appathDoc) {
		this.appathDoc = appathDoc;
	}

	public File getPptpathDoc() {
		return pptpathDoc;
	}

	public void setPptpathDoc(File pptpathDoc) {
		this.pptpathDoc = pptpathDoc;
	}

	public boolean isCH_CHECKED_MIDCITY() {
		return CH_CHECKED_MIDCITY;
	}

	public void setCH_CHECKED_MIDCITY(boolean ch_checked_midcity) {
		CH_CHECKED_MIDCITY = ch_checked_midcity;
	}

	public boolean isParamvalue() {
		return paramvalue;
	}

	public void setParamvalue(boolean paramvalue) {
		this.paramvalue = paramvalue;
	}
}