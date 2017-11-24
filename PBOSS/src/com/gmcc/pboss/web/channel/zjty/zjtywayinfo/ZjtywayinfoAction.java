package com.gmcc.pboss.web.channel.zjty.zjtywayinfo;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.ajaxanywhere.AAUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.channel.adimarea.AdimareaVO;
import com.gmcc.pboss.business.channel.bchcontact.BchcontactVO;
import com.gmcc.pboss.business.channel.common.AuditUtils;
import com.gmcc.pboss.business.channel.way.WayDBParam;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.channel.waycompact.WaycompactVO;
import com.gmcc.pboss.business.channel.wayprovince.WayprovinceVO;
import com.gmcc.pboss.business.channel.zjty.zjtywayinfo.ZjtywayinfoVO;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.control.channel.adimarea.Adimarea;
import com.gmcc.pboss.control.channel.adimarea.AdimareaBO;
import com.gmcc.pboss.control.channel.bchcontact.Bchcontact;
import com.gmcc.pboss.control.channel.bchcontact.BchcontactBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.channel.way.WayDelegate;
import com.gmcc.pboss.control.channel.waycompact.Waycompact;
import com.gmcc.pboss.control.channel.waycompact.WaycompactBO;
import com.gmcc.pboss.control.channel.wayprovince.Wayprovince;
import com.gmcc.pboss.control.channel.wayprovince.WayprovinceBO;
import com.gmcc.pboss.control.channel.zjty.zjtywayinfo.Zjtywayinfo;
import com.gmcc.pboss.control.channel.zjty.zjtywayinfo.ZjtywayinfoBO;
import com.gmcc.pboss.web.channel.saleway.SalewayForm;
import com.gmcc.pboss.web.channel.way.AGWayForm;
import com.gmcc.pboss.web.channel.way.WayWebParam;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.CityMappingUtil;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

/**
 * 自建他营渠道基本信息管理
 * 
 * @author LiZhaoLiang
 * 
 */
public class ZjtywayinfoAction extends BaseAction {


	
	public static final String remotepath = "Upload/cms/way";

	AuditUtils utils = new AuditUtils();

	
	public ZjtywayinfoAction() {
		super();

		this.setForm(new ZjtywayinfoForm());
		this.setParam(new WayWebParam());

		setClsVO(WayVO.class);
		// TODO Auto-generated constructor stub
		this.pkNameArray = new String[] { "wayid" };
		this.setClsControl(Zjtywayinfo.class);
		this.setClsQueryParam(WayDBParam.class);
	}

	public String  doCheckupperway() throws Exception {
		Way way = (Way) BOFactory.build(WayBO.class, getDBAccessUser());
		ZjtywayinfoForm form = (ZjtywayinfoForm) getForm();
		WayVO uppwayVO = way.doFindByPk(form.getUpperwayid());
		if(uppwayVO==null)
		{
//			throw new Exception("所选渠道在PBOSS系统没有找到!");
			super.addActionError("所选渠道在PBOSS系统没有找到!");
			return "content";
		}
		// 社会网点的上级渠道必须是合作商，移动部门/科室或服务厅下添加社会网点
//		if ("DIS".equals(uppwayVO.getWaysubtype())
//				|| "GMPT".equals(uppwayVO.getWaysubtype())
//				|| "G100".equals(uppwayVO.getWaysubtype())) {
			form.setCityid(uppwayVO.getCityid());
			form.setCountyid(uppwayVO.getCountyid());
			form.setSvccode(uppwayVO.getSvccode());
			form.setMareacode(uppwayVO.getMareacode());
//		} else {
//			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
//					"录入的上级渠道只能是连锁经营合作商，移动部门/科室或服务厅");
//			form.setUpperwayid("");
//			form.setCityid("");
//			form.setCountyid("");
//			form.setSvccode("");
//			form.setMareacode("");
//		}
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
	
	/**
	 * 用户修改上级渠道
	 */ 
	public String doChangeupwayid() throws Exception {
		ZjtywayinfoForm form = (ZjtywayinfoForm) getForm();
//		form.setCmdState(request.getParameter("cmdstates"));
		this.setCMD(request.getParameter("cmdstates"));
//		WayDelegate delegate = new WayDelegate();
		Way delegate = (Way) BOFactory.build(WayBO.class, getDBAccessUser());
		WayVO wayVO = delegate.doFindByPk(form.getUpperwayid());
		form.setCityid(wayVO.getCityid());
		form.setCountyid(wayVO.getCountyid());
		if (StringUtils.isEmpty(wayVO.getCountyid())) {
			request.setAttribute("ischange", "1");
		}
		if (wayVO.getWaystate().intValue() == -1) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
					"上级渠道状态必须是有效的.");
//			super.addActionError("上级渠道状态必须是有效的.");
			request.setAttribute("isExit", "1");
		}
		form.setSvccode(wayVO.getSvccode());
		form.setMareacode(wayVO.getMareacode());
		if (AAUtils.isAjaxRequest(request)) {
			AAUtils.addZonesToRefresh(request, "getcityid");
			AAUtils.addZonesToRefresh(request, "getcountyid");
			AAUtils.addZonesToRefresh(request, "getsvccode");
			AAUtils.addZonesToRefresh(request, "getmareacode");
			AAUtils.addZonesToRefresh(request, "showerror");
			AAUtils.addZonesToRefresh(request, "showbutton");
		}
		return "content";
	}

	public String doSelectsv() throws Exception {
		ZjtywayinfoForm form = (ZjtywayinfoForm) getForm();

		request.setAttribute("FLAG", form.getRunmode());
		if (!new Long(1).equals(form.getRunmode())) {
			form.setChainhead(null);
		}

		if (AAUtils.isAjaxRequest(request)) {
			AAUtils.addZonesToRefresh(request, "sv");
		}
		return "content";
	}

	// 下拉框选择
	public String doGetcountid() throws Exception {
		ZjtywayinfoForm form = (ZjtywayinfoForm) getForm();
//		form.setCmdState(request.getParameter("cmdstates"));
		this.setCMD(request.getParameter("cmdstates"));
//		WayDelegate delegate = new WayDelegate();
		Way delegate = (Way) BOFactory.build(WayBO.class, getDBAccessUser());
		WayVO wayVO = new WayVO();
		if (StringUtils.isNotEmpty(form.getUpperwayid())) {
			wayVO = delegate.doFindByPk(form.getUpperwayid());
		}
		if (StringUtils.isEmpty(wayVO.getCountyid())) {
			request.setAttribute("ischange", "1");
		}
		String cmdvalue = request.getParameter("cmdvalue");
		if ("cityid".equals(cmdvalue)) {
			form.setCountyid("");
			form.setSvccode("");
			form.setMareacode("");
		} else if ("citycompid".equals(cmdvalue)) {
			form.setSvccode("");
			form.setMareacode("");
		}
		if (AAUtils.isAjaxRequest(request)) {
			AAUtils.addZonesToRefresh(request, "getcountyid");
			AAUtils.addZonesToRefresh(request, "getsvccode");
			AAUtils.addZonesToRefresh(request, "getmareacode");

		}

		return "content";
	}

	public String doShow() throws Exception {
//		ZjtywayinfoForm form = (ZjtywayinfoForm) actionForm;
		// form.set_se_wayid(user.getWayid());
		return "list";
	}
	
	/**
	 * 自建他营渠道信息
	 */
	public String doList() throws Exception {
//		WayDelegate delegate = new WayDelegate();
		ZjtywayinfoForm form = (ZjtywayinfoForm) getForm();
//		WayDelegate delegate = new WayDelegate();
//		WayListVO listvo = new WayListVO();
		WayDBParam param=(WayDBParam)getParam();
		BeanUtils.copyProperties(param, form);
		Way delegate = (Way) BOFactory.build(WayBO.class, getDBAccessUser());
//		WayDBParam param=(WayDBParam)getParam();
		param.set_se_waytype("AG");
		param.set_se_waysubtype("ZJTY");
		param.set_ne_runmode("1");
		param.set_se_cityid(this.getDBAccessUser().getCityid());
//		Zjtywayinfo  zjtywayinfo=(Zjtywayinfo)BOFactory.build(ZjtywayinfoBO.class,getDBAccessUser());
//		DataPackage zjtywaydp = zjtywayinfo.doQuery(param,getDBAccessUser());
//		DataPackage zjtywaydp = delegate.doQuery(listvo);
		DataPackage zjtywaydp = delegate.doQuery(param);
//		request.setAttribute("LIST", zjtywaydp);
		setDp(zjtywaydp);
		return "list";
	}

	
	public String doEdit()throws Exception {
		ZjtywayinfoForm zjtywayinfoform = (ZjtywayinfoForm) this.getForm();
//		WayprovinceDelegate wayprovincedelegate = new WayprovinceDelegate();
//		BchcontactDelegate bchcontactDelegate = new BchcontactDelegate();
//		WaycompactDelegate waycompactDelegate = new WaycompactDelegate();
		
		Wayprovince  wayprovince=(Wayprovince)BOFactory.build(WayprovinceBO.class,getDBAccessUser());
		Bchcontact  bchcontact=(Bchcontact)BOFactory.build(BchcontactBO.class,getDBAccessUser());
		Waycompact  waycompact=(Waycompact)BOFactory.build(WaycompactBO.class,getDBAccessUser());
		
		HttpServletRequest request = getRequest();
		String s = request.getParameter("param._pk");
		
//		WayDelegate delegate = new WayDelegate();
		Way way = (Way) BOFactory.build(WayBO.class, getDBAccessUser());
		WayprovinceVO wayprovincevo = wayprovince.doFindByPk(s);
		BchcontactVO bchcontactVO = bchcontact.doFindByPk(s);
		WaycompactVO waycompactVO = waycompact.doFindByPk(s);
		 
		//查询CH_PW_BCHCONTACT		
		//查询CH_PW_WAYCOMPACT				
		//查询ch_pw_wayprovince				 
		WayVO wayvo = way.doFindByPk(s);
		if(wayvo != null)
		BeanUtils.copyProperties(zjtywayinfoform, wayvo);
		
		if(wayprovincevo!=null){
		if(wayprovincevo.getUniquewayid()!=null)
		zjtywayinfoform.setUniquewayid(wayprovincevo.getUniquewayid());
		if(wayprovincevo.getTown()!=null)
		zjtywayinfoform.setTown(wayprovincevo.getTown());
		if(wayprovincevo.getProvtype()!=null)
		zjtywayinfoform.setProvtype(wayprovincevo.getProvtype());
		if(wayprovincevo.getFrontarea()!=null)
		zjtywayinfoform.setFrontarea(wayprovincevo.getFrontarea());
		if(wayprovincevo.getMobilemall()!=null)
		zjtywayinfoform.setMobilemall(wayprovincevo.getMobilemall());
		if(wayprovincevo.getHaswaitmach()!=null)
		zjtywayinfoform.setHaswaitmach(wayprovincevo.getHaswaitmach());
		if(wayprovincevo.getHasposmach()!=null)
		zjtywayinfoform.setHasposmach(wayprovincevo.getHasposmach());
		if(wayprovincevo.getHas24mall()!=null)
		zjtywayinfoform.setHas24mall(wayprovincevo.getHas24mall());
		if(wayprovincevo.getHasvipseat()!=null)
		zjtywayinfoform.setHasvipseat(wayprovincevo.getHasvipseat());
		if(wayprovincevo.getHasviproom()!=null)
		zjtywayinfoform.setHasviproom(wayprovincevo.getHasviproom());
		if(wayprovincevo.getG3area()!=null)
		zjtywayinfoform.setG3area(wayprovincevo.getG3area());
		if(wayprovincevo.getUniquewayid()!=null)
			zjtywayinfoform.setUniquewayid(wayprovincevo.getUniquewayid());
		}
		if(bchcontactVO!=null){
		if(bchcontactVO.getBusnum()!=null)
		zjtywayinfoform.setBusnum(bchcontactVO.getBusnum());
		if(bchcontactVO.getPrincipal()!=null)
		zjtywayinfoform.setPrincipal(bchcontactVO.getPrincipal());
		if(bchcontactVO.getCertinum()!=null)
		zjtywayinfoform.setCertinum(bchcontactVO.getCertinum());
		if(bchcontactVO.getCompany()!=null)
		zjtywayinfoform.setCompany(bchcontactVO.getCompany());
		if(bchcontactVO.getPrincipaltel()!=null)
		zjtywayinfoform.setPrincipaltel(bchcontactVO.getPrincipaltel());
		}
		if(waycompactVO!=null){
		if(waycompactVO.getCompactno()!=null)
		zjtywayinfoform.setCompactno(waycompactVO.getCompactno());
		if(waycompactVO.getBegintime()!=null)
		zjtywayinfoform.setBegintime(waycompactVO.getBegintime());
		if(waycompactVO.getEndtime()!=null)
		zjtywayinfoform.setEndtime(waycompactVO.getEndtime());
		if(waycompactVO.getSigntime()!=null)
		zjtywayinfoform.setSigntime(waycompactVO.getSigntime());
		if(waycompactVO.getCompactname()!=null)
		zjtywayinfoform.setCompactname(waycompactVO.getCompactname());
		}
		
//		String command = getCommandString(request);		
//		((BaseActionForm) actionForm).setCmdState(command);
//		request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
		String command=super.getCMD();
		this.setCMD("EDIT");
		return "content";
	}
	
	public String  doSave() throws Exception {
		//start 20111229把以前页面的ajax改成在action中抛出异常
		HttpServletRequest request = ServletActionContext.getRequest();
		ZjtywayinfoForm form = (ZjtywayinfoForm) getForm();
		form.setWaymagcode(null);
		Way delegate1 = (Way)BOFactory.build(WayBO.class, getDBAccessUser());
		
		WayDBParam wayDBParam=new WayDBParam();
		wayDBParam.getQueryConditions().put("_sne_wayid", form.getWayid());
		wayDBParam.set_se_latitude(form.getLatitude());
		wayDBParam.set_se_longtitude(form.getLongtitude());
		if(delegate1.doQuery(wayDBParam).getDatas().size()>0){
			super.addActionError("经度"+form.getLatitude()+",纬度"+form.getLongtitude()+"，已经存在.如网点确实同一经纬度,建议修改小数点后第6位以示区分");
			return "content";
		}
		
//		WayVO wayVO1 = (WayVO) delegate1.doFindByPk(form.getWayid());
//		if (wayVO1 != null && wayVO1.getWaystate().intValue() > -1) {
//			super.addActionError("该渠道基本信息已存在");
//			return "content";
//		}
		if (!AuditUtils.doCheckWayidStyle(form.getWayid())
				&& StringUtils.isNotEmpty(form.getWayid())) {
			super.addActionError("渠道编码格式不正确,只能是字母+数字或者'-'");
			return "content";
		}
		
		if (StringUtils.isNotEmpty(form.getAdacode())) {
			Adimarea adimareadelegate = (Adimarea)BOFactory.build(AdimareaBO.class, getDBAccessUser());
			AdimareaVO vo = (AdimareaVO) adimareadelegate.doFindByPk(form.getAdacode());
			if (vo == null) {
				super.addActionError("行政区划编码不存在");
				return "content";
			}
		}
		//end 20111229把以前页面的ajax改成在action中抛出异常
		try {
//			ZjtywayinfoForm form = (ZjtywayinfoForm) getForm();
			form.set_se_cityid(CityMappingUtil.getCityid(this.getDBAccessUser().getCityid()));
			form.setMareacode(StringUtils.equals("请选择", form.getMareacode()) ? "" : form.getMareacode());
			form.setSvccode(StringUtils.equals("请选择", form.getSvccode()) ? ""
					: form.getSvccode());
			form.setWaytype("AG");
//			ZjtywayinfoDelegate zjtydelegate = new ZjtywayinfoDelegate();
			Zjtywayinfo  zjtydelegate=(Zjtywayinfo)BOFactory.build(ZjtywayinfoBO.class,getDBAccessUser());
//			WayDelegate delegate = new WayDelegate();
			Way delegate = (Way)BOFactory.build(WayBO.class, getDBAccessUser());
			WayVO wayVO = (WayVO) delegate.doFindByPk(form.getWayid());
			if (WEB_CMD_NEW.equals(CMD) && wayVO == null) {
				
				ZjtywayinfoVO zjtywayinfoVO = new ZjtywayinfoVO();				
		        BeanUtils.copyProperties(zjtywayinfoVO, form);
		        
				zjtydelegate.doMulsave(zjtywayinfoVO,getDBAccessUser());
				request.setAttribute("wayid", form.getWayid());
			} else {
				
				ZjtywayinfoVO zjtywayinfoVO = new ZjtywayinfoVO();				
			     BeanUtils.copyProperties(zjtywayinfoVO, form);
				request.setAttribute("wayid", wayVO.getWayid());
				zjtydelegate.doMulupdate(zjtywayinfoVO,getDBAccessUser());
			}
//			request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,
//							"SAVE");
//			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存成功!");
			setCMD(WEB_CMD_SAVE);
			addActionMessage("保存成功");
			return "content";
		} catch (Exception e) {
//			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
//					.getMessage());
//			request
//					.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,
//							"EDIT");
			setCMD(WEB_CMD_EDIT);
			addActionMessage(e.getMessage());
			return "content";
		}
	}

	public String doDelete() throws Exception {
//		ZjtywayinfoForm form = (ZjtywayinfoForm) getForm();
		String[] selectArray = ((DBQueryParam) getParam()).get_selectitem();
//		SvwayinfoDelegate delegate = new SvwayinfoDelegate();
		Zjtywayinfo  delegate=(Zjtywayinfo)BOFactory.build(ZjtywayinfoBO.class,getDBAccessUser());
		Way ddd=(Way)BOFactory.build(WayBO.class,getDBAccessUser());
		for (int i = 0; i < selectArray.length; i++) {
			WayVO vo = (WayVO) ddd.doFindByPk(selectArray[i]);//.doFindByPk(selectArray[i], getDBAccessUser());
//			delegate.doRemove(vo,getDBAccessUser());
			vo.setWaystate(Short.valueOf("0"));
			try {
				ddd.doUpdate(vo);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				addActionMessage(e.getMessage());
//				e.printStackTrace();
			}
		}
		return this.doList();
	}

	public  String doNew() throws Exception {
		ZjtywayinfoForm form = (ZjtywayinfoForm) getForm();
		if (StringUtils.isNotEmpty(form.getUpperwayid())) {
			form.set_se_upperwayid(form.getUpperwayid());
			this.doChangeupwayid();
		}
		form.setCityid(getDBAccessUser().getCityid());
//		DBAccessUser user = getDBAccessUser();
//		this.getRequest().getSession().setAttribute("dBAccessUsercityid", user.getCityid());
		this.CMD = WEB_CMD_NEW;
		return WEB_RESULT_CONTENT;
	}


	public String doExistedwid() throws Exception {
		ZjtywayinfoForm form = (ZjtywayinfoForm) getForm();
//		SvwayinfoDelegate delegate = new SvwayinfoDelegate();
//		Svwayinfo  delegate=(Svwayinfo)BOFactory.build(SvwayinfoBO.class,getDBAccessUser());
//		WayVO wayVO = (WayVO) delegate.doFindByPk(form.getWayid(), user);
		Way delegate = (Way)BOFactory.build(WayBO.class, getDBAccessUser());
		WayVO wayVO = (WayVO) delegate.doFindByPk(form.getWayid());
		if (wayVO != null && wayVO.getWaystate().intValue() > -1) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
					"该渠道基本信息已存在");
			request.setAttribute("isExit", "1");
		}
		if (!AuditUtils.doCheckWayidStyle(form.getWayid())
				&& StringUtils.isNotEmpty(form.getWayid())) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
					"渠道编码格式不正确,只能是字母+数字或者'-'");
			request.setAttribute("isExit", "1");
			return "content";
		}
		if (AAUtils.isAjaxRequest(request)) {
			AAUtils.addZonesToRefresh(request, "showerror");
			AAUtils.addZonesToRefresh(request, "showbutton");
		}
		return "content";
	}

	public String doCheckada() throws Exception {
		ZjtywayinfoForm form = (ZjtywayinfoForm) getForm();
		if (StringUtils.isNotEmpty(form.getAdacode())) {
			Adimarea delegate = (Adimarea)BOFactory.build(AdimareaBO.class, getDBAccessUser());
			AdimareaVO vo = (AdimareaVO) delegate.doFindByPk(form.getAdacode());
			if (vo == null) {
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
						"行政区划编码不存在");
				request.setAttribute("isExit", "1");
				return "content";
			}
		}
		if (AAUtils.isAjaxRequest(request)) {
			AAUtils.addZonesToRefresh(request, "showerror");
			AAUtils.addZonesToRefresh(request, "showbutton");
		}
		return "content";
	}
	
	public String doExcel() throws Exception {
	try {
			User user = (User) getDBAccessUser();
			CommonExportBean bean = new CommonExportBean(user);
			param.set_pagesize("0");
			bean.setFileName("渠道自建他营信息管理");
			
			//添加标题
			addProperty(bean,user);
			
			bean.appendEndLine(new String[] { "导出工号:", user.getOprcode() });
			bean.appendEndLine(new String[] { "导出渠道:", user.getWayid() });
			bean
					.appendEndBody("时间格式为：YYYY-MM-DD	" +
							"渠道：只能是字母+数字或者'-'<br>	" +
							"服务厅类别：0-城区主服务厅，1-县主服务厅，2-城区普通服务厅，3-县普通服务厅,4-乡镇服务厅<br>" +
							"地市公司：DG-东莞市公司 等等<br>" +
							"星级：0-未定星级，1-一星级  等等<br>" +
							"是否联网：0-联网，1-未联网<br>" +
							"联网方式：0-光缆，1-2M电缆，2-GPRS，3-CSD，4-拨号上网，5-无线网桥，6-专线接入BOSS，7-宽带接入BOSS，8-空中充值平台，9-网站接入，99-其他<br>" +
							"物业来源分类：0-租赁,2-上市公司购建,3-社会物业（他建）<br>" +
							"商圈类型：0-商业区,1-商务区,2-交通枢纽,3-住宅社区,4-学校区域,5-厂矿,6-郊县,7-乡镇,99-其他,8-旅游景区<br>" +
							"区域类型：0-城区,1-郊县,2-一类乡镇,3-二类乡镇,4-三类乡镇,5-行政村,99-其它<br>" +
							"渠道状态：0-暂停营业,1-开店,-1-已关店<br>	" +
							"是否中心渠道：0-否，1-是<br>" +
							"是否共享：0-否，1-是<br>" +
							"渠道基础类型:0-普通厅,1-品牌店,2-旗舰店<br>" +
							"是否卖场加盟:0-否,1-是<br>" +
							"有无排队叫号机:0-无,1-有<br>" +
							"有无POS机:0-无,1-有<br>" +
							"有无24小时自助营业厅:0-无,1-有<br>" +
							"有无VIP专席:0-无,1-有<br>" +
							"有无VIP室:0-无,1-有<br>");
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, bean);

			bean.voClassArray = new Class[] { ZjtywayinfoVO.class };
			bean.queryMethodName = "queryAllZJTYWay";
			if (bean.headtitle == null) {
				bean.headtitle = bean.getFileName();
			}
			super.doExcel();
//			super.ExportQuery(getForm(), getRequest(), getResponse(), user, bean);
		} catch (Exception ex) {
			throw ex;
		}
		return null;
	}
	
	
	private void addProperty(CommonExportBean export,User user){
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//		渠道|渠道名称|上级渠道|服务厅类别|服务厅级别|子类型|地市公司|分公司|服务销售中心|
//		微区域|星级|经营模式|是否联网|联网方式|物业来源分类|商圈类型|区域类型|联系电话|
//		行政区划|地理纬度|地理经度|详细地址|渠道状态|是否中心渠道|合作商编码|是否共享|
//		全网统一渠道编码|乡镇|渠道基础类型|是否卖场加盟|前台营业面积（㎡）|
//		有无排队叫号机|有无POS机|有无24小时自助营业厅|有无VIP专席|有无VIP室|
//		G3体验区面积|委托方公司名称|工商注册号|法人代表|身份证号码|签约编号|
//		协议签署生效时间|协议截止时间|负责人电话|协议名称|签约时间|
		
		export.appendHeadLine(new String[] { "导出工号:", user.getOprcode() });
		export
				.appendHeadLine(new String[] { "导出时间",
						format.format(new Date()) });
		export.addOutputProperty("wayid", "渠道编码");
		export.addOutputProperty("wayname", "渠道名称");
		export.addOutputProperty("upperwayid", "上级渠道");
		export.addOutputProperty("svbrchcode", "服务厅类别",CommonExportBean.CODE2NAME, "$CH_SVBRCHTYPE");
		export.addOutputProperty("bchlevel", "服务厅级别",CommonExportBean.CODE2NAME, "$CH_BCHLEVEL");
		export.addOutputProperty("waysubtype", "子类型");
		export.addOutputProperty("cityid", "地市公司");
		export.addOutputProperty("countyid", "分公司");
		export.addOutputProperty("svccode", "服务销售中心");
		export.addOutputProperty("mareacode", "微区域");
		export.addOutputProperty("starlevel", "星级",CommonExportBean.CODE2NAME, "$CH_STARLEVEL");
		export.addOutputProperty("runmode", "经营模式");
		export.addOutputProperty("isconnected", "是否联网",CommonExportBean.CODE2NAME, "$CH_ISCONNECTED");
		export.addOutputProperty("connecttype", "联网方式",CommonExportBean.CODE2NAME, "$CH_CONNECTTYPE");
		export.addOutputProperty("prtsource", "物业来源分类",CommonExportBean.CODE2NAME, "$CH_PRTSOURCE");		
		export.addOutputProperty("buztypecode", "商圈类型",CommonExportBean.CODE2NAME, "$CH_BUZTYPE");
		export.addOutputProperty("adtypecode", "区域类型",CommonExportBean.CODE2NAME, "$CH_ADTYPE");
		export.addOutputProperty("buzphoneno", "店面经理联系电话");
		export.addOutputProperty("adacode", "行政区划");
		export.addOutputProperty("latitude", "地理纬度");
		export.addOutputProperty("longtitude", "地理经度");
		export.addOutputProperty("address", "详细地址");
		export.addOutputProperty("waystate", "渠道状态",CommonExportBean.CODE2NAME, "$CH_WAYSTATE");
		export.addOutputProperty("iscoreway", "是否中心渠道",CommonExportBean.CODE2NAME, "$CH_ISCOREWAY");
		export.addOutputProperty("cooperator", "合作商编码");
		export.addOutputProperty("isshare", "是否共享",CommonExportBean.CODE2NAME, "$CH_DSTISKEYSTEP");
		export.addOutputProperty("uniquewayid", "全网统一渠道编码");
		export.addOutputProperty("town", "乡镇");
		export.addOutputProperty("provtype", "渠道基础类型",CommonExportBean.CODE2NAME, "$CH_PROVTYPE");
		export.addOutputProperty("mobilemall","是否卖场加盟",CommonExportBean.CODE2NAME, "$CH_COMMONHAS");		
		export.addOutputProperty("frontarea", "前台营业面积（㎡）");
		export.addOutputProperty("haswaitmach", "有无排队叫号机",CommonExportBean.CODE2NAME, "$CH_COMMONHAS");
		export.addOutputProperty("hasposmach", "有无POS机",CommonExportBean.CODE2NAME, "$CH_COMMONHAS");
		export.addOutputProperty("has24mall", "有无24小时自助营业厅",CommonExportBean.CODE2NAME, "$CH_COMMONHAS");
		export.addOutputProperty("hasvipseat", "有无VIP专席",CommonExportBean.CODE2NAME, "$CH_COMMONHAS");
		export.addOutputProperty("hasviproom", "有无VIP室",CommonExportBean.CODE2NAME, "$CH_COMMONHAS");
		export.addOutputProperty("g3area", "4G体验区面积");
		export.addOutputProperty("company", "委托方公司名称");
		export.addOutputProperty("busnum", "工商注册号");		
		export.addOutputProperty("principaltel", "法人代表");
		export.addOutputProperty("certinum", "身份证号码");
		export.addOutputProperty("compactno", "签约编号");
		export.addOutputProperty("begintime", "协议签署生效时间", CommonExportBean.DATE,"yyyy-MM-dd");
		export.addOutputProperty("endtime", "协议截止时间", CommonExportBean.DATE,"yyyy-MM-dd");
		export.addOutputProperty("principaltel", "负责人电话");
		export.addOutputProperty("compactname", "协议名称");
		export.addOutputProperty("signtime", "签约时间", CommonExportBean.DATE,"yyyy-MM-dd");
		
	}
	
	public String queryAllZJTYWay() throws Exception {
		try {
			HttpServletRequest request = getRequest();
//			BaseActionForm baseactionform = (BaseActionForm) getForm();
//			baseactionform.setPage(0);
//			Page.setPageSize(request,baseactionform);
			ZjtywayinfoForm form = (ZjtywayinfoForm) getForm();
//			WayDelegate delegate = new WayDelegate();
			Way delegate = (Way) BOFactory.build(WayBO.class, getDBAccessUser());
//			WayListVO listvo = new WayListVO();
			WayDBParam listvo=(WayDBParam)getParam();
			BeanUtils.copyProperties(listvo, form);
			listvo.set_se_waytype("AG");
			listvo.set_se_waysubtype("ZJTY");
			listvo.set_ne_runmode("1");
			listvo.set_se_cityid(this.getDBAccessUser().getCityid());
//			listvo.set_se_cityid(CityMappingUtil.getCityid(this.getDBAccessUser().getCityid()));
			DataPackage zjtywaydp = delegate.doQuery(listvo);
			Collection coll = zjtywaydp.getDatas();
			Zjtywayinfo zjtywayinfodelegate = (Zjtywayinfo) BOFactory.build(ZjtywayinfoBO.class, getDBAccessUser());
			DataPackage pack = zjtywayinfodelegate.doQueryZjty(coll,getDBAccessUser());
//			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, pack);
			setDp(pack);
		} catch (Exception e) {
			throw e;
		}
//		return null;
		return "list";
	}
	
	
	
}
