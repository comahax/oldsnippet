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
 * �Խ���Ӫ����������Ϣ����
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
//			throw new Exception("��ѡ������PBOSSϵͳû���ҵ�!");
			super.addActionError("��ѡ������PBOSSϵͳû���ҵ�!");
			return "content";
		}
		// ���������ϼ����������Ǻ����̣��ƶ�����/���һ������������������
//		if ("DIS".equals(uppwayVO.getWaysubtype())
//				|| "GMPT".equals(uppwayVO.getWaysubtype())
//				|| "G100".equals(uppwayVO.getWaysubtype())) {
			form.setCityid(uppwayVO.getCityid());
			form.setCountyid(uppwayVO.getCountyid());
			form.setSvccode(uppwayVO.getSvccode());
			form.setMareacode(uppwayVO.getMareacode());
//		} else {
//			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
//					"¼����ϼ�����ֻ����������Ӫ�����̣��ƶ�����/���һ������");
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
	 * �û��޸��ϼ�����
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
					"�ϼ�����״̬��������Ч��.");
//			super.addActionError("�ϼ�����״̬��������Ч��.");
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

	// ������ѡ��
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
	 * �Խ���Ӫ������Ϣ
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
		 
		//��ѯCH_PW_BCHCONTACT		
		//��ѯCH_PW_WAYCOMPACT				
		//��ѯch_pw_wayprovince				 
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
		//start 20111229����ǰҳ���ajax�ĳ���action���׳��쳣
		HttpServletRequest request = ServletActionContext.getRequest();
		ZjtywayinfoForm form = (ZjtywayinfoForm) getForm();
		form.setWaymagcode(null);
		Way delegate1 = (Way)BOFactory.build(WayBO.class, getDBAccessUser());
		
		WayDBParam wayDBParam=new WayDBParam();
		wayDBParam.getQueryConditions().put("_sne_wayid", form.getWayid());
		wayDBParam.set_se_latitude(form.getLatitude());
		wayDBParam.set_se_longtitude(form.getLongtitude());
		if(delegate1.doQuery(wayDBParam).getDatas().size()>0){
			super.addActionError("����"+form.getLatitude()+",γ��"+form.getLongtitude()+"���Ѿ�����.������ȷʵͬһ��γ��,�����޸�С������6λ��ʾ����");
			return "content";
		}
		
//		WayVO wayVO1 = (WayVO) delegate1.doFindByPk(form.getWayid());
//		if (wayVO1 != null && wayVO1.getWaystate().intValue() > -1) {
//			super.addActionError("������������Ϣ�Ѵ���");
//			return "content";
//		}
		if (!AuditUtils.doCheckWayidStyle(form.getWayid())
				&& StringUtils.isNotEmpty(form.getWayid())) {
			super.addActionError("���������ʽ����ȷ,ֻ������ĸ+���ֻ���'-'");
			return "content";
		}
		
		if (StringUtils.isNotEmpty(form.getAdacode())) {
			Adimarea adimareadelegate = (Adimarea)BOFactory.build(AdimareaBO.class, getDBAccessUser());
			AdimareaVO vo = (AdimareaVO) adimareadelegate.doFindByPk(form.getAdacode());
			if (vo == null) {
				super.addActionError("�����������벻����");
				return "content";
			}
		}
		//end 20111229����ǰҳ���ajax�ĳ���action���׳��쳣
		try {
//			ZjtywayinfoForm form = (ZjtywayinfoForm) getForm();
			form.set_se_cityid(CityMappingUtil.getCityid(this.getDBAccessUser().getCityid()));
			form.setMareacode(StringUtils.equals("��ѡ��", form.getMareacode()) ? "" : form.getMareacode());
			form.setSvccode(StringUtils.equals("��ѡ��", form.getSvccode()) ? ""
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
//			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����ɹ�!");
			setCMD(WEB_CMD_SAVE);
			addActionMessage("����ɹ�");
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
					"������������Ϣ�Ѵ���");
			request.setAttribute("isExit", "1");
		}
		if (!AuditUtils.doCheckWayidStyle(form.getWayid())
				&& StringUtils.isNotEmpty(form.getWayid())) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
					"���������ʽ����ȷ,ֻ������ĸ+���ֻ���'-'");
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
						"�����������벻����");
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
			bean.setFileName("�����Խ���Ӫ��Ϣ����");
			
			//��ӱ���
			addProperty(bean,user);
			
			bean.appendEndLine(new String[] { "��������:", user.getOprcode() });
			bean.appendEndLine(new String[] { "��������:", user.getWayid() });
			bean
					.appendEndBody("ʱ���ʽΪ��YYYY-MM-DD	" +
							"������ֻ������ĸ+���ֻ���'-'<br>	" +
							"���������0-��������������1-������������2-������ͨ��������3-����ͨ������,4-���������<br>" +
							"���й�˾��DG-��ݸ�й�˾ �ȵ�<br>" +
							"�Ǽ���0-δ���Ǽ���1-һ�Ǽ�  �ȵ�<br>" +
							"�Ƿ�������0-������1-δ����<br>" +
							"������ʽ��0-���£�1-2M���£�2-GPRS��3-CSD��4-����������5-�������ţ�6-ר�߽���BOSS��7-�������BOSS��8-���г�ֵƽ̨��9-��վ���룬99-����<br>" +
							"��ҵ��Դ���ࣺ0-����,2-���й�˾����,3-�����ҵ��������<br>" +
							"��Ȧ���ͣ�0-��ҵ��,1-������,2-��ͨ��Ŧ,3-סլ����,4-ѧУ����,5-����,6-����,7-����,99-����,8-���ξ���<br>" +
							"�������ͣ�0-����,1-����,2-һ������,3-��������,4-��������,5-������,99-����<br>" +
							"����״̬��0-��ͣӪҵ,1-����,-1-�ѹص�<br>	" +
							"�Ƿ�����������0-��1-��<br>" +
							"�Ƿ���0-��1-��<br>" +
							"������������:0-��ͨ��,1-Ʒ�Ƶ�,2-�콢��<br>" +
							"�Ƿ���������:0-��,1-��<br>" +
							"�����ŶӽкŻ�:0-��,1-��<br>" +
							"����POS��:0-��,1-��<br>" +
							"����24Сʱ����Ӫҵ��:0-��,1-��<br>" +
							"����VIPרϯ:0-��,1-��<br>" +
							"����VIP��:0-��,1-��<br>");
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
//		����|��������|�ϼ�����|���������|����������|������|���й�˾|�ֹ�˾|������������|
//		΢����|�Ǽ�|��Ӫģʽ|�Ƿ�����|������ʽ|��ҵ��Դ����|��Ȧ����|��������|��ϵ�绰|
//		��������|����γ��|������|��ϸ��ַ|����״̬|�Ƿ���������|�����̱���|�Ƿ���|
//		ȫ��ͳһ��������|����|������������|�Ƿ���������|ǰ̨Ӫҵ������O��|
//		�����ŶӽкŻ�|����POS��|����24Сʱ����Ӫҵ��|����VIPרϯ|����VIP��|
//		G3���������|ί�з���˾����|����ע���|���˴���|���֤����|ǩԼ���|
//		Э��ǩ����Чʱ��|Э���ֹʱ��|�����˵绰|Э������|ǩԼʱ��|
		
		export.appendHeadLine(new String[] { "��������:", user.getOprcode() });
		export
				.appendHeadLine(new String[] { "����ʱ��",
						format.format(new Date()) });
		export.addOutputProperty("wayid", "��������");
		export.addOutputProperty("wayname", "��������");
		export.addOutputProperty("upperwayid", "�ϼ�����");
		export.addOutputProperty("svbrchcode", "���������",CommonExportBean.CODE2NAME, "$CH_SVBRCHTYPE");
		export.addOutputProperty("bchlevel", "����������",CommonExportBean.CODE2NAME, "$CH_BCHLEVEL");
		export.addOutputProperty("waysubtype", "������");
		export.addOutputProperty("cityid", "���й�˾");
		export.addOutputProperty("countyid", "�ֹ�˾");
		export.addOutputProperty("svccode", "������������");
		export.addOutputProperty("mareacode", "΢����");
		export.addOutputProperty("starlevel", "�Ǽ�",CommonExportBean.CODE2NAME, "$CH_STARLEVEL");
		export.addOutputProperty("runmode", "��Ӫģʽ");
		export.addOutputProperty("isconnected", "�Ƿ�����",CommonExportBean.CODE2NAME, "$CH_ISCONNECTED");
		export.addOutputProperty("connecttype", "������ʽ",CommonExportBean.CODE2NAME, "$CH_CONNECTTYPE");
		export.addOutputProperty("prtsource", "��ҵ��Դ����",CommonExportBean.CODE2NAME, "$CH_PRTSOURCE");		
		export.addOutputProperty("buztypecode", "��Ȧ����",CommonExportBean.CODE2NAME, "$CH_BUZTYPE");
		export.addOutputProperty("adtypecode", "��������",CommonExportBean.CODE2NAME, "$CH_ADTYPE");
		export.addOutputProperty("buzphoneno", "���澭����ϵ�绰");
		export.addOutputProperty("adacode", "��������");
		export.addOutputProperty("latitude", "����γ��");
		export.addOutputProperty("longtitude", "������");
		export.addOutputProperty("address", "��ϸ��ַ");
		export.addOutputProperty("waystate", "����״̬",CommonExportBean.CODE2NAME, "$CH_WAYSTATE");
		export.addOutputProperty("iscoreway", "�Ƿ���������",CommonExportBean.CODE2NAME, "$CH_ISCOREWAY");
		export.addOutputProperty("cooperator", "�����̱���");
		export.addOutputProperty("isshare", "�Ƿ���",CommonExportBean.CODE2NAME, "$CH_DSTISKEYSTEP");
		export.addOutputProperty("uniquewayid", "ȫ��ͳһ��������");
		export.addOutputProperty("town", "����");
		export.addOutputProperty("provtype", "������������",CommonExportBean.CODE2NAME, "$CH_PROVTYPE");
		export.addOutputProperty("mobilemall","�Ƿ���������",CommonExportBean.CODE2NAME, "$CH_COMMONHAS");		
		export.addOutputProperty("frontarea", "ǰ̨Ӫҵ������O��");
		export.addOutputProperty("haswaitmach", "�����ŶӽкŻ�",CommonExportBean.CODE2NAME, "$CH_COMMONHAS");
		export.addOutputProperty("hasposmach", "����POS��",CommonExportBean.CODE2NAME, "$CH_COMMONHAS");
		export.addOutputProperty("has24mall", "����24Сʱ����Ӫҵ��",CommonExportBean.CODE2NAME, "$CH_COMMONHAS");
		export.addOutputProperty("hasvipseat", "����VIPרϯ",CommonExportBean.CODE2NAME, "$CH_COMMONHAS");
		export.addOutputProperty("hasviproom", "����VIP��",CommonExportBean.CODE2NAME, "$CH_COMMONHAS");
		export.addOutputProperty("g3area", "4G���������");
		export.addOutputProperty("company", "ί�з���˾����");
		export.addOutputProperty("busnum", "����ע���");		
		export.addOutputProperty("principaltel", "���˴���");
		export.addOutputProperty("certinum", "���֤����");
		export.addOutputProperty("compactno", "ǩԼ���");
		export.addOutputProperty("begintime", "Э��ǩ����Чʱ��", CommonExportBean.DATE,"yyyy-MM-dd");
		export.addOutputProperty("endtime", "Э���ֹʱ��", CommonExportBean.DATE,"yyyy-MM-dd");
		export.addOutputProperty("principaltel", "�����˵绰");
		export.addOutputProperty("compactname", "Э������");
		export.addOutputProperty("signtime", "ǩԼʱ��", CommonExportBean.DATE,"yyyy-MM-dd");
		
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
