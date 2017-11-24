package com.gmcc.pboss.web.channel.impway;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import com.gmcc.pboss.business.channel.way.WayDBParam;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.web.channel.way.WayForm;
import com.gmcc.pboss.web.channel.way.WayWebParam;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

/**
 * 
 * @author hejw
 * �������������
 */
public class ImpWayAction extends BaseAction {
	public ImpWayAction() {
		super();

		this.setForm(new WayForm());
		this.setParam(new WayWebParam());

		setClsVO(WayVO.class);
		this.pkNameArray = new String[] { "wayid" };
		this.setClsControl(Way.class);
		this.setClsQueryParam(WayDBParam.class);
	}
	
	public String doList() throws Exception {
		HttpServletRequest request = getRequest();
		User user = (User) request.getSession().getAttribute(WebConstant.SESSION_ATTRIBUTE_USER);
		Way way = (Way) BOFactory.build(WayBO.class, getDBAccessUser());
		WayDBParam params = (WayDBParam)getParam();
		DataPackage dp = way.doQueryImpWay(params, user);
		setDp(dp);
		return "list";
	}
	
	public String doDelete() throws Exception{
		String[] selectArray = ((DBQueryParam) getParam()).get_selectitem();
		Way way = (Way) BOFactory.build(WayBO.class, getDBAccessUser());
		for (int i = 0; i < selectArray.length; i++) {
			WayVO vo = way.doFindByPk(getSelectedPK(selectArray[i]));
			vo.setWaystate(new Short("0"));
			way.doRemove(vo);
		}
		return doList();
	}
	
	public String doSave() throws Exception{
		WayForm wayForm = (WayForm) getForm();
		Way way = (Way) BOFactory.build(WayBO.class, getDBAccessUser());
		// �ж����������ʽ
		String path = "^[a-zA-Z][a-zA-z0-9-]{0,18}$";
		Pattern pattern = Pattern.compile(path);
		Matcher matcher = pattern.matcher(wayForm.getWayid());
		if (!matcher.find()) {
			super.addActionError("���������ʽ����ȷ,ֻ������ĸ+���ֻ���-");
			return "content";
		}
		// �ж���������Ψһ��
		WayVO vo = way.doFindByPk(getSelectedPK(wayForm.getWayid()));
		if (vo != null && !CMD.equals("EDIT")) {
			super.addActionError("��" + wayForm.getWayid() + "���Ѵ��ڸ���������");
			return "content";
			
		}
		// �ж��Ƿ������ͬ�ľ���γ��
		WayDBParam params = new WayDBParam();
		params.set_se_longtitude(wayForm.getLongtitude());
		params.set_se_latitude(wayForm.getLatitude());
		DataPackage dp = way.doQueryWayByParams(params);
		if (dp.getDatas() != null && dp.getDatas().size() > 0 && !CMD.equals("EDIT")) {
			super.addActionError("�Ѿ����ھ�γ�ȡ�" + wayForm.getLongtitude() + "," 
					+ wayForm.getLatitude() + "��.������ȷʵͬһ��γ��,�����޸�С������6λ��ʾ����");
			return "content";
		}
		// �ж��ϼ�������Ч��
		vo = way.doFindByPk(getSelectedPK(wayForm.getUpperwayid()));
		if (vo != null && (vo.getWaystate() == 0 || vo.getWaystate() == -1)) {
			super.addActionError("�ϼ�����״̬ΪʧЧ����ɾ��,��ȷ��");
			return "content";
		}
		// �жϵ��й�˾�Ƿ����ϼ������еĵ��й�˾һ��
		if (vo != null && !vo.getCityid().equals(wayForm.getCityid())) {
			super.addActionError("���й�˾Ӧ�����ϼ������еĵ��й�˾����һ��");
			return "content";
		}
		// �жϷֹ�˾�Ƿ����ϼ������зֹ�˾һ��
		if (vo != null && vo.getCountyid() != null && !vo.getCountyid().equals(wayForm.getCountyid())) {
			super.addActionError("�ֹ�˾Ӧ�����ϼ������еķֹ�˾����һ��");
			return "content";
		}
		// �ж����������̱����Ƿ����
		if (wayForm.getChainhead() != null
				&& !wayForm.getChainhead().equals("")
				&& !wayForm.getChainhead().equals("0000")) {
			params = new WayDBParam();
			params.set_se_wayid(wayForm.getChainhead());
			params.set_se_waytype("AG");
			params.set_se_waysubtype("DIS");
			params.set_ne_waystate("1");
			dp = way.doQueryWayByParams(params);
			if (dp.getDatas() == null || dp.getDatas().size() == 0) {
				super.addActionError("���������̱��롾" + wayForm.getChainhead() + "�������ڻ��߲���������Ӫ������");
				return "content";
			}
		}
		if (CMD.equals("NEW")) {
			wayForm.setWaytype("IMP");
			wayForm.setWaystate(new Short("1"));
			wayForm.setCreatetime(new Date());
			WayVO wayVO = new WayVO();
			BeanUtils.copyProperties(wayVO, wayForm);
			wayVO = way.doSave(wayVO);
			BeanUtils.copyProperties(getForm(), wayVO);
		} else if (CMD.equals("EDIT")) {
			WayVO wayVO = way.doFindByPk(getSelectedPK(wayForm.getWayid()));
			BeanUtils.copyProperties(wayVO, wayForm);
			wayVO = way.doUpdateImpWay(wayVO);
			BeanUtils.copyProperties(getForm(), wayVO);
		}
		this.CMD = WEB_CMD_SAVE;
		setActionMessage("�����ɹ�!");
		return "content";
	}
	
	public String doExportExcel() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("�����������Ϣ");
		export.appendHeadLine(new String[] { "��������:", user.getOprcode() });
		export.appendHeadLine(new String[] { "����ʱ��", format.format(new Date())});
		export.addOutputProperty("wayid", "��������");
		export.addOutputProperty("wayname", "��������");
		export.addOutputProperty("upperwayid", "�ϼ�����");
		export.addOutputProperty("waysubtype", "������", CommonExportBean.CODE2NAME, "waysubtype");
		export.addOutputProperty("cityid", "���й�˾", CommonExportBean.CODE2NAME, "#CITYCOMPANY");
		export.addOutputProperty("countyid", "�ֹ�˾", CommonExportBean.CODE2NAME, "#CNTYCOMPANY");
		export.addOutputProperty("svccode", "������������", CommonExportBean.CODE2NAME, "#SERVCENT");
		export.addOutputProperty("mareacode", "΢����", CommonExportBean.CODE2NAME, "#MICROAREA");
		export.addOutputProperty("starlevel", "�Ǽ�", CommonExportBean.CODE2NAME, "$CH_STARLEVEL");
		export.addOutputProperty("runmode", "��Ӫģʽ", CommonExportBean.CODE2NAME, "$CH_RUNMODE");
		export.addOutputProperty("isconnected", "�Ƿ�����", CommonExportBean.CODE2NAME, "$CH_ISCONNECTED");
		export.addOutputProperty("connecttype", "������ʽ", CommonExportBean.CODE2NAME, "$CH_CONNECTTYPE");
		export.addOutputProperty("prtsource", "��ҵ��Դ����", CommonExportBean.CODE2NAME, "$CH_PRTSOURCE");
		export.addOutputProperty("buztypecode", "��Ȧ����", CommonExportBean.CODE2NAME, "$CH_BUZTYPE");
		export.addOutputProperty("adtypecode", "��������", CommonExportBean.CODE2NAME, "$CH_ADTYPE");
		export.addOutputProperty("buzphoneno", "���澭����ϵ�绰");
		export.addOutputProperty("adacode", "������������", CommonExportBean.CODE2NAME, "#CH_ADIMAREA");
		export.addOutputProperty("isshare", "�Ƿ���", CommonExportBean.CODE2NAME, "$CH_DSTISKEYSTEP");
		
		// ����VO��
		export.voClassArray = new Class[] { WayVO.class };
		
		// ���ò�ѯ����
		export.queryMethodName = "doList";
		WayDBParam params = (WayDBParam) getParam();
		params.setQueryAll(true);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}
	
	public String  doCheckupperway() throws Exception {
		Way way = (Way) BOFactory.build(WayBO.class, getDBAccessUser());
		WayForm form = (WayForm) getForm();
		if (form.getUpperwayid() == null || form.getUpperwayid().equals("")) {
			return "content";
		}
		WayVO uppwayVO = way.doFindByPk(form.getUpperwayid());
		if (uppwayVO == null) {
			throw new Exception("�ϼ��������롾" + form.getUpperwayid() + "�����������ݣ���ȷ�����������Ƿ���ȷ!");
		}

		// ���á��Ƿ���Ȩ���㡿�����û�ԭ����ֵ
		WayVO wayVO = way.doFindByPk(form.getWayid());
		if (wayVO != null) {
			form.setChecked(wayVO.getChecked());
		} else {// �������ɷ�
			form.setChecked("N");
		}
		
		// ���������ϼ����������Ǻ����̣��ƶ�����/���һ������������������
		if ( !"IMP".equals(uppwayVO.getWaysubtype()) && 1==uppwayVO.getWaystate()) {
			form.setCityid(uppwayVO.getCityid());
			form.setCountyid(uppwayVO.getCountyid());
			form.setSvccode(uppwayVO.getSvccode());
			form.setMareacode(uppwayVO.getMareacode());
		} else {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
					"¼����ϼ�����ֻ������Ч�ķ�������������");
			form.setUpperwayid("");
			form.setCityid("");
			form.setCountyid("");
			form.setSvccode("");
			form.setMareacode("");
		}
		if(StringUtils.equals(uppwayVO.getWaytype(), "AG") && StringUtils.equals(uppwayVO.getWaysubtype(), "DIS")) {
			form.setChainhead(uppwayVO.getWayid());
		} else {
			form.setChainhead("");
		}
		return "content";
	}
}
