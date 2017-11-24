package com.sunrise.boss.ui.cms.bbc.stdrewardbj;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.bbc.operation.persistent.BBCoperationVO;
import com.sunrise.boss.business.cms.bbc.stdreward.persistent.BBCstdrewardVO;
import com.sunrise.boss.business.cms.bbc.stdrewardbj.persistent.BBCstdrewardbjListVO;
import com.sunrise.boss.business.cms.bbc.stdrewardbj.persistent.BBCstdrewardbjVO;
import com.sunrise.boss.business.common.sysparam.persistent.SysparamListVO;
import com.sunrise.boss.business.common.sysparam.persistent.SysparamVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.delegate.cms.bbc.operation.BBCoperationDelegate;
import com.sunrise.boss.delegate.cms.bbc.stdreward.BBCstdrewardDelegate;
import com.sunrise.boss.delegate.cms.bbc.stdrewardbj.BBCstdrewardbjDelegate;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.cms.bbc.constant.BBCRewardType;
import com.sunrise.boss.ui.cms.commons.CMSUtils;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.pub.tools.PublicUtils;
import com.sunrise.pub.tools.Sequence;
import com.sunrise.pub.tools.StringSplit;

/**
 * <p>
 * Title: BBCstdrewardbjAction
 * </p>
 * <p>
 * Description: �Ƽ�����׼����
 * </p>
 * <p>
 * Copyright: Copyright (c) 2007
 * </p>
 * <p>
 * Company: SUNRISE Tech Ltd.
 * </p>
 * 
 * @author Linli
 * @version 1.0 2008-08-26
 */
public class BBCstdrewardbjAction extends BaseDelegateAction {
	// ҵ�����
	public final static String BUSIBELONG = "BUSIBELONG";

	public final static String SELL_BUSIBELONG = "SELL"; // ����ҵ�����

	public final static String SELL_DATA_BUSIBELONG = "SELL_DATA";// ����ҵ��������

	public final static String SELL_SERVICE_BUSIBELONG = "SELL_SERVICE";// ����ҵ�������

	public final static String DATABUSI_BUSIBELONG = "DATABUSI"; // ����������

	public final static String CZ_BUSIBELONG = "CZ"; // ��ֵ������

	public final static String QUER_BUSIBELONG = "QUER"; // ��ѯ��

	public final static String ACTV_BUSIBELONG = "ACTV"; // ��Ծ��

	public final static String ACTV_NEW_BUSIBELONG = "ACTV_NEW";// ������վ��Ծ��

	public final static String ACTV_E100_BUSIBELONG = "ACTV_E100";// e100��Ծ��

	// �ָ��
	public final static String SEMICOLON = ";";

	public final static String VERTICAL = "|";

	public final static String DEFAULT_REGION = "999"; // Ĭ��ʡ��˾�������

	public final static String DEFAULT_ACCTYPE = "1"; // �Ƴ귽ʽ Ĭ�ϰ���������

	public final static String SCALE_ACCTYPE = "2"; // �Ƴ귽ʽ ����������

	// public final static String SELL_REWARDPROJ = "1"; // ��������

	// public final static String ACTV_NEW_REWARDPROJ = "2"; // ������վ��Ծ�ͻ����

	// public final static String ACTV_E100_REWARDPROJ = "3"; // ����e100��Ծ�ͻ����

	public final static String DATAFORMAT = "yyyy-MM-dd"; // ���ڸ�ʽ

	public final static String OLDLIST = "OLDLIST";

	public final static String NEWLIST = "NEWLIST";
	
	public final static String INTERFACTOR = "INTERFACTOR";

	private String reqbusibelong = null;// ҳ�洫�ݹ����ж�ҵ������ķ�֧

	private String default_rewardproj = "1";// ѡ���ʵ���rewardproj
	
	public final static String OSSRC = "OSSRC";
	private String reqOssrc = null;// ҳ�洫�ݹ����ж�ҵ������Դ�ķ�֧
	public final static String OSSRC_DEFAULT = "0"; //ҵ������Դ:Ĭ��
	public final static String OSSRC_INTER = "1";   //ҵ������Դ:������

	private int rewardtype_basic;
	private int rewardtype_encourage;
	
	public BBCstdrewardbjAction() throws Exception {
		setVoClass(BBCstdrewardbjVO.class);
		this.pkNameArray = new String[2];
		pkNameArray[0] = "region";
		pkNameArray[1] = "rewardid";
	}

	/**
	 * ��ʼ��ҳ�洫�ݹ��������ķ���
	 * 
	 * @param request
	 */
	public void initParam(HttpServletRequest request) throws Exception {
		// �����ݽ����Ĳ�����¼��ȫ�ֱ������� frame.jsp���ݱ���Ҫ��SELL|QUER|ACTV��Ϊ����С��Ĳ���
		if (StringUtils.isNotEmpty(request.getParameter(SELL_BUSIBELONG))) {

			this.rewardtype_basic = BBCRewardType.SELL_BASIC;
			this.rewardtype_encourage = BBCRewardType.SELL_ENCOURAGE;

		} else if (StringUtils.isNotEmpty(request.getParameter(QUER_BUSIBELONG))) {

			reqbusibelong = request.getParameter(QUER_BUSIBELONG);

		} else if (StringUtils.isNotEmpty(request.getParameter(ACTV_BUSIBELONG))) {
			
			reqbusibelong = request.getParameter(ACTV_BUSIBELONG);
			
			if (ACTV_NEW_BUSIBELONG.indexOf(reqbusibelong) != -1) {
				this.rewardtype_basic = BBCRewardType.ACTV_NEW_BASIC;
				this.rewardtype_encourage = BBCRewardType.ACTV_NEW_ENCOURAGE;
			} else if (ACTV_E100_BUSIBELONG.indexOf(reqbusibelong) != -1) {
				this.rewardtype_basic = BBCRewardType.ACTV_E100_BASIC;
				this.rewardtype_encourage = BBCRewardType.ACTV_E100_ENCOURAGE;
			} else {
				throw new Exception("��ʼ��ҳ�����ʧ��!");
			}
			
		} else {
			throw new Exception("��ʼ��ҳ�����ʧ��!");
		}
		
		if (StringUtils.isNotEmpty(request.getParameter(OSSRC))) {
			reqOssrc = request.getParameter(OSSRC);
		}else{
			throw new Exception("��ʼ��ҳ�����ʧ��!");
		}
		
	}

	/**
	 * ����ҵ�������ת����Ӧ����ҳ�� �Ƽ������������
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doShow(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {

		this.initParam(request);

		String opnid = request.getParameter("opnid");
		if (null == opnid || opnid.trim().length() == 0) {
			throw new Exception("ҵ��������Ϊ��");
		}
		BBCoperationDelegate bbcoperDelegate = new BBCoperationDelegate();
		BBCoperationVO bbcoperationVO = bbcoperDelegate.doFindByPk(opnid, user);
		if (null == bbcoperationVO) {
			throw new Exception("����ҵ�����[" + opnid + "]��ѯҵ����ϢΪ��");
		}
		BBCstdrewardbjForm form = (BBCstdrewardbjForm) actionForm;
		setDefaultFormValue(form, bbcoperationVO);

		BBCstdrewardbjDelegate bbcstdrewardbjDelegate = new BBCstdrewardbjDelegate();
		BBCstdrewardDelegate bbcstdrewardDelegate = new BBCstdrewardDelegate();
		BBCstdrewardbjListVO bbcstdrewardbjListVO = new BBCstdrewardbjListVO();
		
		bbcstdrewardbjListVO.set_se_opnid(opnid);
		bbcstdrewardbjListVO.set_se_region(DEFAULT_REGION);
		bbcstdrewardbjListVO.set_ne_ossrc(form.getOssrc());
		
		DataPackage dp = bbcstdrewardbjDelegate.doQuery(bbcstdrewardbjListVO,
				user);
		if (null != dp && null != dp.getDatas()) {
			for (Iterator iter = dp.getDatas().iterator(); iter.hasNext();) {
				BBCstdrewardbjVO item = (BBCstdrewardbjVO) iter.next();
				BBCstdrewardVO vo = bbcstdrewardDelegate.doFindByPk(item
						.getRewardid(), user);
				if (vo.getRewardtype().intValue() == rewardtype_basic
						|| vo.getRewardtype().intValue() == rewardtype_encourage) {
					setFormValue(form, vo, item, false, user);
				} else {
					continue;
				}
			}
		}
		form.getNewencouragelist().addAll(form.getOldencouragelist());
		request.getSession().setAttribute(OLDLIST, form.getOldencouragelist());
		request.getSession().setAttribute(NEWLIST, form.getNewencouragelist());
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, form
				.getNewencouragelist());
		return actionMapping
				.findForward(getForward(form.getBusibelong(), false, form.getOssrc().toString()));
	}

	//	
	/**
	 * ����ҵ�������ת����Ӧ����ҳ�� �й�˾�Ƽ������������
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doShowcity(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		
		this.initParam(request);
		
		String opnid = request.getParameter("opnid");
		if (null == opnid || opnid.trim().length() == 0) {
			throw new Exception("ҵ��������Ϊ��");
		}
		
		BBCoperationDelegate operDelegate = new BBCoperationDelegate();
		BBCoperationVO operationVO = operDelegate.doFindByPk(opnid, user);
		if (null == operationVO) {
			throw new Exception("����ҵ�����[" + opnid + "]��ѯҵ����ϢΪ��");
		}
		BBCstdrewardbjForm form = (BBCstdrewardbjForm) actionForm;
		setDefaultFormValue(form, operationVO);

		BBCstdrewardbjDelegate stdrewardbjDelegate = new BBCstdrewardbjDelegate();
		BBCstdrewardDelegate stdrewardDelegate = new BBCstdrewardDelegate();
		BBCstdrewardbjListVO stdrewardbjListVO = new BBCstdrewardbjListVO();
		stdrewardbjListVO.set_se_opnid(opnid);
		stdrewardbjListVO.set_se_region(user.getCityid());
		stdrewardbjListVO.set_ne_ossrc(form.getOssrc());
		
		DataPackage city = stdrewardbjDelegate.doQuery(stdrewardbjListVO, user);
		stdrewardbjListVO.set_se_region(DEFAULT_REGION);
		stdrewardbjListVO.set_ne_ossrc(new Short(OSSRC_DEFAULT));
		
		DataPackage province = stdrewardbjDelegate.doQuery(stdrewardbjListVO,user);

		List list = new ArrayList();
		for (Iterator iter = province.getDatas().iterator(); iter.hasNext();) {
			BBCstdrewardbjVO proItem = (BBCstdrewardbjVO) iter.next();

			boolean match = false;
			for (Iterator iter2 = city.getDatas().iterator(); iter2.hasNext();) {
				BBCstdrewardbjVO cityItem = (BBCstdrewardbjVO) iter2.next();
				if (proItem.getRewardid().equals(cityItem.getRewardid())) {
					BBCstdrewardVO vo = new BBCstdrewardDelegate().doFindByPk(
							cityItem.getRewardid(), user);
					if (vo.getRewardtype().intValue() == rewardtype_basic
							|| vo.getRewardtype().intValue() == rewardtype_encourage) {
						list.add(cityItem);
						match = true;
						break;
					}
				}
			}
			if (!match) {
				BBCstdrewardVO vo = new BBCstdrewardDelegate().doFindByPk(
						proItem.getRewardid(), user);
				if (vo.getRewardtype().intValue() == rewardtype_basic
						|| vo.getRewardtype().intValue() == rewardtype_encourage) {
					list.add(proItem);
				}
			}
		}

		for (Iterator iter = list.iterator(); iter.hasNext();) {
			BBCstdrewardbjVO item = (BBCstdrewardbjVO) iter.next();
			BBCstdrewardVO vo = stdrewardDelegate.doFindByPk(
					item.getRewardid(), user);
			setFormValue(form, vo, item, true, user);
		}

		form.getNewencouragelist().addAll(form.getOldencouragelist());
		request.getSession().setAttribute(OLDLIST, form.getOldencouragelist());
		request.getSession().setAttribute(NEWLIST, form.getNewencouragelist());
		request.getSession().setAttribute(INTERFACTOR, getInterfactor(user));
		
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, form
				.getNewencouragelist());
		return actionMapping
				.findForward(getForward(form.getBusibelong(), true, form.getOssrc().toString()));
	}

	/**
	 * �������������VO
	 * 
	 * @param form
	 * @return
	 */
	private BBCstdrewardbjVO buildBasicVO(BBCstdrewardbjForm form, String region)
			throws Exception {
		BBCstdrewardbjVO vo = new BBCstdrewardbjVO();
		vo.setRegion(region);
		vo.setRewardid(form.getRewardid_basic());
		vo.setOpnid(form.getOpnid());
		vo.setAcctype(new Short(DEFAULT_ACCTYPE));
		if (null != form.getAcctype_basic()) {
			vo.setAcctype(form.getAcctype_basic());
		}
		vo.setRewardstd(form.getRewardstd_basic());
		vo.setRuleid(form.getRuleid_basic());
		vo.setRewardname(form.getRewardname_basic());
		vo.setRewardtype(form.getRewardtype_basic());
		vo.setStartdate(PublicUtils.UtilStrToDate(form.getStartdate_basic(),DATAFORMAT));
		vo.setStopdate(PublicUtils.UtilStrToDate(form.getStopdate_basic(),DATAFORMAT));
		vo.setRewardproj(new Short(this.default_rewardproj));
		vo.setIntvmonth(new Integer(0));// �޸ļ���·�Ϊ0
		vo.setOssrc(form.getOssrc()); //ҵ������Դ

		if (!form.isBasicflag() && null != form.getRewardid_basic()) {
			vo.setDeleteflag(true);
		}
		return vo;
	}

	/**
	 * �������������List
	 * 
	 * @param oldlist
	 * @param newlist
	 * @return
	 */
	private List buildEncourageList(List oldlist, List newlist, Short ossrc) {
		if (null == oldlist) {
			oldlist = new ArrayList(0);
		}
		if (null == newlist) {
			newlist = new ArrayList(0);
		}

		// the delete values = old - new
		List list = new ArrayList();
		for (Iterator iter1 = oldlist.iterator(); iter1.hasNext();) {
			BBCstdrewardbjVO item1 = (BBCstdrewardbjVO) iter1.next();
			boolean match = false;
			for (Iterator iter2 = newlist.iterator(); iter2.hasNext();) {
				BBCstdrewardbjVO item2 = (BBCstdrewardbjVO) iter2.next();
				if (null == item2.getRewardid()) {
					continue;
				}
				if (item1.getRewardid().equals(item2.getRewardid())) {
					match = true;
					break;
				}
			}

			if (!match) {
				item1.setDeleteflag(true);
				list.add(item1);
			}
		}

		// the add or update values = all new values
		if (newlist.size() > 0) {
			list.addAll(newlist);
		}
		
		// refresh ossrc
		for (Iterator itt = list.iterator(); itt.hasNext();) {
			BBCstdrewardbjVO vo = (BBCstdrewardbjVO)itt.next();
			vo.setOssrc(ossrc);
		}
		
		return list;
	}

	/**
	 * �Ƽ�����������ñ��棬������ [����ҵ��] �� [����ҵ��]
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doSavedata(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		BBCstdrewardbjForm form = (BBCstdrewardbjForm) actionForm;
		form.setOldencouragelist((List) request.getSession().getAttribute(
				OLDLIST));
		form.setNewencouragelist((List) request.getSession().getAttribute(
				NEWLIST));
		List list = new ArrayList();

		if (form.isBasicflag() || null != form.getRewardid_basic()) {
			list.add(buildBasicVO(form, DEFAULT_REGION));
		}

		if (form.isEncourageflag()) {
			list.addAll(buildEncourageList(form.getOldencouragelist(), form
					.getNewencouragelist(), form.getOssrc()));
		} else if (null != form.getOldencouragelist()) {
			list.addAll(buildEncourageList(form.getOldencouragelist(),
					new ArrayList(0), form.getOssrc()));
		}

		// ����
		BBCstdrewardbjDelegate bbcstdrewardbjDelegate = new BBCstdrewardbjDelegate();
		bbcstdrewardbjDelegate.doSave(list, user);

		// ��ѯ��ʾ
		BBCoperationDelegate bbcoperDelegate = new BBCoperationDelegate();
		BBCoperationVO bbcoperationVO = bbcoperDelegate.doFindByPk(form
				.getOpnid(), user);

		form.getOldencouragelist().clear();
		form.getNewencouragelist().clear();

		setDefaultFormValue(form, bbcoperationVO);

		BBCstdrewardDelegate bbcstdrewardDelegate = new BBCstdrewardDelegate();
		BBCstdrewardbjListVO bbcstdrewardbjListVO = new BBCstdrewardbjListVO();

		bbcstdrewardbjListVO.set_se_opnid(form.getOpnid());
		bbcstdrewardbjListVO.set_se_region(DEFAULT_REGION);
		bbcstdrewardbjListVO.set_ne_ossrc(form.getOssrc());

		DataPackage dp = bbcstdrewardbjDelegate.doQuery(bbcstdrewardbjListVO,
				user);
		if (null != dp && null != dp.getDatas()) {
			for (Iterator iter = dp.getDatas().iterator(); iter.hasNext();) {
				BBCstdrewardbjVO item = (BBCstdrewardbjVO) iter.next();
				BBCstdrewardVO vo = bbcstdrewardDelegate.doFindByPk(item
						.getRewardid(), user);
				if (vo.getRewardtype().intValue() == rewardtype_basic
						|| vo.getRewardtype().intValue() == rewardtype_encourage) {
					setFormValue(form, vo, item, true, user);
				} else {
					continue;
				}
			}
		}

		form.getNewencouragelist().addAll(form.getOldencouragelist());
		request.getSession().setAttribute(OLDLIST, form.getOldencouragelist());
		request.getSession().setAttribute(NEWLIST, form.getNewencouragelist());
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, form
				.getNewencouragelist());
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "���ñ���ɹ�");
		return actionMapping
				.findForward(getForward(form.getBusibelong(), false, form.getOssrc().toString()));
	}

	/**
	 * �й�˾�Ƽ�����������ñ��棬������ [����ҵ��] �� [����ҵ��]
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doSavecitydata(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		BBCstdrewardbjForm form = (BBCstdrewardbjForm) actionForm;
		form.setOldencouragelist((List) request.getSession().getAttribute(
				OLDLIST));
		form.setNewencouragelist((List) request.getSession().getAttribute(
				NEWLIST));
		List list = new ArrayList();

		if (form.isBasicflag() || null != form.getRewardid_basic()) {
			list.add(buildBasicVO(form, user.getCityid()));
		}

		if (form.isEncourageflag()) {
			list.addAll(buildEncourageList(form.getOldencouragelist(), form
					.getNewencouragelist(), form.getOssrc()));
		} else if (null != form.getOldencouragelist()) {
			list.addAll(buildEncourageList(form.getOldencouragelist(),
					new ArrayList(0), form.getOssrc()));
		}

		// ����������Ƿ����ʡ��˾����
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			BBCstdrewardbjVO item = (BBCstdrewardbjVO) iter.next();
			BBCstdrewardbjVO provinceStd = getProvinceStd(item, user);
			
			if(form.getOssrc().equals(new Short(this.OSSRC_DEFAULT))){
				if (item.getRewardstd().compareTo(provinceStd.getRewardstd()) > 0) {
					String msg = "��� [" + item.getRewardname() + "] ���ܴ���ʡ��˾���ޱ�׼ ["
							+ provinceStd.getRewardstd() + "] ������������";
					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, msg);
					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, form
							.getNewencouragelist());
					return actionMapping
						.findForward(getForward(form.getBusibelong(), true, form.getOssrc().toString()));
				}
			}else{
				if (item.getRewardstd().compareTo(new Double(provinceStd.getRewardstd().doubleValue()*this.getInterfactor(user).doubleValue())) > 0) {
					String msg = "��� [" + item.getRewardname() + "] ���ܴ���ʡ��˾���ޱ�׼ ["
							+ provinceStd.getRewardstd() + "]��"+this.getInterfactor(user).doubleValue()*100+"% ������������";
					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, msg);
					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, form
							.getNewencouragelist());
					return actionMapping
						.findForward(getForward(form.getBusibelong(), true, form.getOssrc().toString()));
				}
			}
		}

		// ����
		BBCstdrewardbjDelegate stdrewardbjDelegate = new BBCstdrewardbjDelegate();
		stdrewardbjDelegate.doSavecity(list, user);

		// ��ѯ��ʾ
		BBCoperationDelegate operDelegate = new BBCoperationDelegate();
		BBCoperationVO operationVO = operDelegate.doFindByPk(form.getOpnid(),
				user);
		form.getOldencouragelist().clear();
		form.getNewencouragelist().clear();
		setDefaultFormValue(form, operationVO);

		BBCstdrewardDelegate stdrewardDelegate = new BBCstdrewardDelegate();
		BBCstdrewardbjListVO stdrewardbjListVO = new BBCstdrewardbjListVO();
		
		stdrewardbjListVO.set_se_opnid(form.getOpnid());
		stdrewardbjListVO.set_se_region(user.getCityid());
		stdrewardbjListVO.set_ne_ossrc(form.getOssrc());
		
		DataPackage city = stdrewardbjDelegate.doQuery(stdrewardbjListVO, user);
		stdrewardbjListVO.set_se_region(DEFAULT_REGION);
		stdrewardbjListVO.set_ne_ossrc(new Short(OSSRC_DEFAULT));
		
		DataPackage province = stdrewardbjDelegate.doQuery(stdrewardbjListVO,
				user);

		List result = new ArrayList();
		for (Iterator iter = province.getDatas().iterator(); iter.hasNext();) {
			BBCstdrewardbjVO provItem = (BBCstdrewardbjVO) iter.next();

			boolean match = false;
			for (Iterator iter2 = city.getDatas().iterator(); iter2.hasNext();) {
				BBCstdrewardbjVO cityItem = (BBCstdrewardbjVO) iter2.next();
				if (provItem.getRewardid().equals(cityItem.getRewardid())) {
					BBCstdrewardVO vo = new BBCstdrewardDelegate().doFindByPk(
							cityItem.getRewardid(), user);
					if (vo.getRewardtype().intValue() == rewardtype_basic
							|| vo.getRewardtype().intValue() == rewardtype_encourage) {
						result.add(cityItem);
						match = true;
						break;
					}
				}
			}
			if (!match) {
				BBCstdrewardVO vo = new BBCstdrewardDelegate().doFindByPk(
						provItem.getRewardid(), user);
				if (vo.getRewardtype().intValue() == rewardtype_basic
						|| vo.getRewardtype().intValue() == rewardtype_encourage) {
					result.add(provItem);
				}
			}
		}

		for (Iterator iter = result.iterator(); iter.hasNext();) {
			BBCstdrewardbjVO item = (BBCstdrewardbjVO) iter.next();
			BBCstdrewardVO vo = stdrewardDelegate.doFindByPk(
					item.getRewardid(), user);
			setFormValue(form, vo, item, true, user);
		}

		form.getNewencouragelist().addAll(form.getOldencouragelist());
		request.getSession().setAttribute(OLDLIST, form.getOldencouragelist());
		request.getSession().setAttribute(NEWLIST, form.getNewencouragelist());
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, form
				.getNewencouragelist());
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "���ñ���ɹ�");
		return actionMapping
				.findForward(getForward(form.getBusibelong(), true, form.getOssrc().toString()));
	}

	/**
	 * �༭�������
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doEditencourage(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		BBCstdrewardbjForm form = (BBCstdrewardbjForm) actionForm;
		String pk = request.getParameter(WebConstant.REQUEST_ATTRIBUTE_PK);
		if (pk == null) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
					"pk is required.");
			return actionMapping
				.findForward(getForward(form.getBusibelong(), false, form.getOssrc().toString()));
		}

		form.setOldencouragelist((List) request.getSession().getAttribute(
				OLDLIST));
		form.setNewencouragelist((List) request.getSession().getAttribute(
				NEWLIST));
		List list = form.getNewencouragelist();
		BBCstdrewardbjVO bbcstdrewardbjVO = null;

		String[] arr = StringSplit.split(pk, VERTICAL);
		String rewardid = arr[0];
		String temprewardid = "";
		if (arr.length >= 2) {
			temprewardid = arr[1];
		}
		if (null != rewardid && rewardid.length() > 0) {
			for (Iterator iter = list.iterator(); iter.hasNext();) {
				BBCstdrewardbjVO item = (BBCstdrewardbjVO) iter.next();
				if (null == item || null == item.getRewardid()) {
					continue;
				}
				if (item.getRewardid().toString().equals(rewardid)) {
					bbcstdrewardbjVO = item;
					break;
				}
			}
		} else if (null != temprewardid && temprewardid.length() > 0) {
			for (Iterator iter = list.iterator(); iter.hasNext();) {
				BBCstdrewardbjVO item = (BBCstdrewardbjVO) iter.next();
				if (null == item || null == item.getTemprewardid()) {
					continue;
				}
				if (item.getTemprewardid().toString().equals(temprewardid)) {
					bbcstdrewardbjVO = item;
					break;
				}
			}
		}

		if (null == bbcstdrewardbjVO) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
					"pk is error, nothing match.");
			return actionMapping.findForward(getForward(form.getBusibelong(),
					false, form.getOssrc().toString()));
		}

		if (null != bbcstdrewardbjVO.getRewardid()) {
			form.setRewardid_encourage(bbcstdrewardbjVO.getRewardid());
		} else {
			form.setRewardid_encourage(bbcstdrewardbjVO.getTemprewardid());
		}
		
		form.setRewardname_encourage(bbcstdrewardbjVO.getRewardname());
		form.setRewardtype_encourage(bbcstdrewardbjVO.getRewardtype());
		form.setStartdate_encourage(PublicUtils.formatUtilDate(bbcstdrewardbjVO.getStartdate(), DATAFORMAT));
		form.setStopdate_encourage(PublicUtils.formatUtilDate(bbcstdrewardbjVO.getStopdate(), DATAFORMAT));
		form.setRewardstd_encourage(bbcstdrewardbjVO.getRewardstd());
		form.setRuleid_encourage(bbcstdrewardbjVO.getRuleid());
		form.setIntvmonth_encourage(bbcstdrewardbjVO.getIntvmonth());
		form.setRewardname_encourage_temp(bbcstdrewardbjVO.getRewardname());

		request.getSession().setAttribute(OLDLIST, form.getOldencouragelist());
		request.getSession().setAttribute(NEWLIST, form.getNewencouragelist());
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, form.getNewencouragelist());
		request.setAttribute(WebConstant.COMMAND_STRING_EDIT, "TRUE");
		return actionMapping.findForward(getForward(form.getBusibelong(), false, form.getOssrc().toString()));
	}

	// /**
	// * �༭������� �й�˾
	// *
	// * @param actionMapping
	// * @param actionForm
	// * @param request
	// * @param response
	// * @param user
	// * @return
	// * @throws Exception
	// */
	public ActionForward doEditcityencourage(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		BBCstdrewardbjForm form = (BBCstdrewardbjForm) actionForm;
		String pk = request.getParameter(WebConstant.REQUEST_ATTRIBUTE_PK);
		if (pk == null) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
					"pk is required.");
			return actionMapping.findForward(getForward(form.getBusibelong(),
					true, form.getOssrc().toString()));
		}

		form.setOldencouragelist((List) request.getSession().getAttribute(OLDLIST));
		form.setNewencouragelist((List) request.getSession().getAttribute(NEWLIST));
		List list = form.getNewencouragelist();
		
		BBCstdrewardbjVO stdrewardbjVO = null;

		String[] arr = StringSplit.split(pk, VERTICAL);
		String rewardid = arr[0];
		String temprewardid = "";
		if (arr.length >= 2) {
			temprewardid = arr[1];
		}
		if (null != rewardid && rewardid.length() > 0) {
			for (Iterator iter = list.iterator(); iter.hasNext();) {
				BBCstdrewardbjVO item = (BBCstdrewardbjVO) iter.next();
				if (null == item || null == item.getRewardid()) {
					continue;
				}
				if (item.getRewardid().toString().equals(rewardid)) {
					stdrewardbjVO = item;
					break;
				}
			}
		} else if (null != temprewardid && temprewardid.length() > 0) {
			for (Iterator iter = list.iterator(); iter.hasNext();) {
				BBCstdrewardbjVO item = (BBCstdrewardbjVO) iter.next();
				if (null == item || null == item.getTemprewardid()) {
					continue;
				}
				if (item.getTemprewardid().toString().equals(temprewardid)) {
					stdrewardbjVO = item;
					break;
				}
			}
		}

		if (null == stdrewardbjVO) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
					"pk is error, nothing match.");
			return actionMapping.findForward(getForward(form.getBusibelong(),
					true, form.getOssrc().toString()));
		}

		if (null != stdrewardbjVO.getRewardid()) {
			form.setRewardid_encourage(stdrewardbjVO.getRewardid());
			BBCstdrewardbjVO vo2 = getProvinceStd(stdrewardbjVO, user);
			form.setMax_city_rewardstd(vo2.getRewardstd());
		} else {
			form.setRewardid_encourage(stdrewardbjVO.getTemprewardid());
		}
		
		form.setRewardname_encourage_temp(stdrewardbjVO.getRewardname());
		form.setRewardname_encourage(stdrewardbjVO.getRewardname());
		form.setRewardtype_encourage(stdrewardbjVO.getRewardtype());
		form.setStartdate_encourage(PublicUtils.formatUtilDate(stdrewardbjVO.getStartdate(), DATAFORMAT));
		form.setStopdate_encourage(PublicUtils.formatUtilDate(stdrewardbjVO.getStopdate(), DATAFORMAT));
		form.setRewardstd_encourage(stdrewardbjVO.getRewardstd());
		form.setRuleid_encourage(stdrewardbjVO.getRuleid());
		form.setIntvmonth_encourage(stdrewardbjVO.getIntvmonth());

		request.getSession().setAttribute(OLDLIST, form.getOldencouragelist());
		request.getSession().setAttribute(NEWLIST, form.getNewencouragelist());
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, form.getNewencouragelist());
		request.setAttribute(WebConstant.COMMAND_STRING_EDIT, "TRUE");
		return actionMapping
				.findForward(getForward(form.getBusibelong(), true, form.getOssrc().toString()));
	}

	/**
	 * �����������
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doNewencourage(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		BBCstdrewardbjForm form = (BBCstdrewardbjForm) actionForm;
		form.setOldencouragelist((List) request.getSession().getAttribute(
				OLDLIST));
		form.setNewencouragelist((List) request.getSession().getAttribute(
				NEWLIST));
		if (hasSameName(form.getRewardname_encourage(), form
				.getNewencouragelist())) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "������� ["
					+ form.getRewardname_encourage() + "] �Ѿ����ڣ����Ʋ������ظ������޸�");
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, form
					.getNewencouragelist());
			return actionMapping.findForward(getForward(form.getBusibelong(),
					false, form.getOssrc().toString()));
		}

		BBCstdrewardbjVO bbcstdrewardbjVO = new BBCstdrewardbjVO();
		bbcstdrewardbjVO.setTemprewardid(new Long(Sequence.getSequence()));
		bbcstdrewardbjVO.setRegion(DEFAULT_REGION);
		bbcstdrewardbjVO.setAcctype(new Short(DEFAULT_ACCTYPE));
		bbcstdrewardbjVO.setOpnid(form.getOpnid());
		bbcstdrewardbjVO.setRewardstd(form.getRewardstd_encourage());
		bbcstdrewardbjVO.setIntvmonth(form.getIntvmonth_encourage());
		bbcstdrewardbjVO.setRuleid(form.getRuleid_encourage());
		bbcstdrewardbjVO.setRewardname(form.getRewardname_encourage());
		bbcstdrewardbjVO.setRewardtype(form.getRewardtype_encourage());
		bbcstdrewardbjVO.setStartdate(PublicUtils.UtilStrToDate(form
				.getStartdate_encourage(), DATAFORMAT));
		bbcstdrewardbjVO.setStopdate(PublicUtils.UtilStrToDate(form
				.getStopdate_encourage(), DATAFORMAT));
		bbcstdrewardbjVO.setRewardproj(new Short(this.default_rewardproj));
		bbcstdrewardbjVO.setOssrc(form.getOssrc());

		// reset encourage values
		form.getNewencouragelist().add(bbcstdrewardbjVO);
		// form.setRewardname_encourage(form.getOpnname()
		// + getOpnname(form.getBusibelong()) + "�������");
		form.setStartdate_encourage(getDefaultBeginDate());
		form.setStopdate_encourage(getDefaultEndDate());
		form.setRewardstd_encourage(null);
		form.setIntvmonth_encourage(null);
		form.setRuleid_encourage("");

		request.getSession().setAttribute(OLDLIST, form.getOldencouragelist());
		request.getSession().setAttribute(NEWLIST, form.getNewencouragelist());
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, form.getNewencouragelist());
		
		return actionMapping.findForward(getForward(form.getBusibelong(), false, form.getOssrc().toString()));
	}

	/**
	 * ���潱�����
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doSaveencourage(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		BBCstdrewardbjForm form = (BBCstdrewardbjForm) actionForm;
		form.setOldencouragelist((List) request.getSession().getAttribute(
				OLDLIST));
		form.setNewencouragelist((List) request.getSession().getAttribute(
				NEWLIST));
		if (null == form.getRewardid_encourage()) {
			request
					.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
							"��������ʶΪ��");
			return actionMapping.findForward(getForward(form.getBusibelong(),
					false, form.getOssrc().toString()));
		}

		if (hasSameNameWhenEdit(form.getRewardname_encourage(), form
				.getRewardname_encourage_temp(), form.getNewencouragelist())) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "������� ["
					+ form.getRewardname_encourage() + "] �Ѿ����ڣ����Ʋ������ظ������޸�");
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, form
					.getNewencouragelist());
			return actionMapping.findForward(getForward(form.getBusibelong(),
					true, form.getOssrc().toString()));
		}

		String rewardid = form.getRewardid_encourage().toString();
		List list = form.getNewencouragelist();
		int matchIndex = -1;
		for (int i = 0; i < list.size(); i++) {
			BBCstdrewardbjVO item = (BBCstdrewardbjVO) list.get(i);
			if (null == item.getRewardid() && null == item.getTemprewardid()) {
				continue;
			}
			if (null != item.getRewardid()) {
				if (rewardid.equals(item.getRewardid().toString())) {
					matchIndex = i;
					break;
				}
			} else if (null != item.getTemprewardid()) {
				if (rewardid.equals(item.getTemprewardid().toString())) {
					matchIndex = i;
					break;
				}
			}
		}

		if (matchIndex < 0) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "��������ʶ["
					+ rewardid + "]ƥ����Ϊ��");
			return actionMapping.findForward(getForward(form.getBusibelong(),
					false, form.getOssrc().toString()));
		}

		// update encourage list value
		BBCstdrewardbjVO item = (BBCstdrewardbjVO) list.get(matchIndex);
		item.setRewardname(form.getRewardname_encourage());
		item.setStartdate(PublicUtils.UtilStrToDate(form
				.getStartdate_encourage(), DATAFORMAT));
		item.setStopdate(PublicUtils.UtilStrToDate(
				form.getStopdate_encourage(), DATAFORMAT));
		item.setRewardstd(form.getRewardstd_encourage());
		item.setIntvmonth(form.getIntvmonth_encourage());
		item.setRuleid(form.getRuleid_encourage());

		BBCstdrewardbjVO bbcstdrewardbjVO = new BBCstdrewardbjVO();
		BeanUtils.copyProperties(bbcstdrewardbjVO, item);
		list.remove(matchIndex);
		list.add(matchIndex, bbcstdrewardbjVO);

		// reset encourage values
		// form.setRewardname_encourage(form.getOpnname()
		// + getOpnname(form.getBusibelong()) + "�������");
		form.setStartdate_encourage(getDefaultBeginDate());
		form.setStopdate_encourage(getDefaultEndDate());
		form.setRewardstd_encourage(null);
		form.setIntvmonth_encourage(null);
		form.setRuleid_encourage("");

		request.getSession().setAttribute(OLDLIST, form.getOldencouragelist());
		request.getSession().setAttribute(NEWLIST, form.getNewencouragelist());
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, form
				.getNewencouragelist());
		return actionMapping
				.findForward(getForward(form.getBusibelong(), false, form.getOssrc().toString()));
	}

	/**
	 * ���潱����� �й�˾
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doSavecityencourage(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		BBCstdrewardbjForm form = (BBCstdrewardbjForm) actionForm;
		form.setOldencouragelist((List) request.getSession().getAttribute(
				OLDLIST));
		form.setNewencouragelist((List) request.getSession().getAttribute(
				NEWLIST));
		if (null == form.getRewardid_encourage()) {
			request
					.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
							"��������ʶΪ��");
			return actionMapping.findForward(getForward(form.getBusibelong(),
					true, form.getOssrc().toString()));
		}

		String rewardid = form.getRewardid_encourage().toString();
		List list = form.getNewencouragelist();
		int matchIndex = -1;
		for (int i = 0; i < list.size(); i++) {
			BBCstdrewardbjVO item = (BBCstdrewardbjVO) list.get(i);
			if (null == item.getRewardid() && null == item.getTemprewardid()) {
				continue;
			}
			if (null != item.getRewardid()) {
				if (rewardid.equals(item.getRewardid().toString())) {
					matchIndex = i;
					break;
				}
			} else if (null != item.getTemprewardid()) {
				if (rewardid.equals(item.getTemprewardid().toString())) {
					matchIndex = i;
					break;
				}
			}
		}

		if (matchIndex < 0) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "��������ʶ["
					+ rewardid + "]ƥ����Ϊ��");
			return actionMapping.findForward(getForward(form.getBusibelong(),
					true, form.getOssrc().toString()));
		}

		// ����������Ƿ����ʡ��˾����

//		BBCstdrewardbjVO provinceStd = getProvinceStd(item, user);
//		if (form.getRewardstd_encourage().compareTo(provinceStd.getRewardstd()) > 0) {
//			String msg = "��� [" + item.getRewardname() + "] ���ܴ���ʡ��˾���ޱ�׼ ["
//					+ provinceStd.getRewardstd() + "] ������������";
//			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, msg);
//			request.setAttribute(WebConstant.COMMAND_STRING_EDIT, "TRUE");
//			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, form
//					.getNewencouragelist());
//			return actionMapping.findForward(getForward(form.getBusibelong(),
//					true, form.getOssrc().toString()));
//		}

		// update encourage list value
		BBCstdrewardbjVO item = (BBCstdrewardbjVO) list.get(matchIndex);
		item.setRewardname(form.getRewardname_encourage());
		item.setStartdate(PublicUtils.UtilStrToDate(form
				.getStartdate_encourage(), DATAFORMAT));
		item.setStopdate(PublicUtils.UtilStrToDate(
				form.getStopdate_encourage(), DATAFORMAT));
		item.setRewardstd(form.getRewardstd_encourage());
		item.setIntvmonth(form.getIntvmonth_encourage());
		item.setRuleid(form.getRuleid_encourage());

		BBCstdrewardbjVO stdrewardbjVO = new BBCstdrewardbjVO();
		BeanUtils.copyProperties(stdrewardbjVO, item);
		list.remove(matchIndex);
		list.add(matchIndex, stdrewardbjVO);

		// reset encourage values
		form.setRewardname_encourage("");
		form.setStartdate_encourage("");
		form.setStopdate_encourage("");
		form.setRewardstd_encourage(null);
		form.setIntvmonth_encourage(null);
		form.setRuleid_encourage("");

		request.getSession().setAttribute(OLDLIST, form.getOldencouragelist());
		request.getSession().setAttribute(NEWLIST, form.getNewencouragelist());
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, form
				.getNewencouragelist());
		return actionMapping
				.findForward(getForward(form.getBusibelong(), true, form.getOssrc().toString()));
	}

	/**
	 * ɾ���������
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doDelencourage(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		BBCstdrewardbjForm form = (BBCstdrewardbjForm) actionForm;
		form.setOldencouragelist((List) request.getSession().getAttribute(
				OLDLIST));
		form.setNewencouragelist((List) request.getSession().getAttribute(
				NEWLIST));

		List list = form.getNewencouragelist();
		String[] arr = form.get_selectitem();
		for (int i = 0; i < arr.length; i++) {
			if (null == arr[i]) {
				continue;
			}

			String[] key = StringSplit.split(arr[i], VERTICAL);
			String rewardid = key[0];
			String temprewardid = "";
			if (key.length >= 2) {
				temprewardid = key[1];
			}
			int matchIndex = -1;
			for (int j = 0; j < list.size(); j++) {
				BBCstdrewardbjVO item = (BBCstdrewardbjVO) list.get(j);
				if (null != item.getRewardid()) {
					if (item.getRewardid().toString().equals(rewardid)) {
						matchIndex = j;
						break;
					}
				} else if (null != item.getTemprewardid()) {
					if (item.getTemprewardid().toString().equals(temprewardid)) {
						matchIndex = j;
						break;
					}
				}
			}

			if (matchIndex >= 0) {
				list.remove(matchIndex);
			}
		}

		request.getSession().setAttribute(OLDLIST, form.getOldencouragelist());
		request.getSession().setAttribute(NEWLIST, form.getNewencouragelist());
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, form
				.getNewencouragelist());
		return actionMapping
				.findForward(getForward(form.getBusibelong(), false, form.getOssrc().toString()));
	}

	/**
	 * ����ҵ�������λĿ��ҳ��
	 * 
	 * @param busibelong
	 *            ҵ�����
	 * @param cityflag
	 *            �Ƿ��й�˾
	 * @return
	 * @throws Exception
	 */
	private String getForward(String busibelong, boolean cityflag, String ossrc)
			throws Exception {
		StringBuffer returnbusibelong = new StringBuffer(busibelong);
		if (cityflag) {
			if (SELL_BUSIBELONG.equals(busibelong)
					|| DATABUSI_BUSIBELONG.equals(busibelong)
					|| CZ_BUSIBELONG.equals(busibelong)) {
				if(ossrc.equals(this.OSSRC_DEFAULT)){
					return "citysellcontent";
				}else if(ossrc.equals(this.OSSRC_INTER)){
					return "intersellcontent";
				}else{
					throw new Exception("����ҵ������Դ" + ossrc + "�޷���λĿ�����");
				}
			} else if (SELL_DATA_BUSIBELONG.equals(busibelong)) {
				if(ossrc.equals(this.OSSRC_DEFAULT)){
					return "citydatacontent";
				}else if(ossrc.equals(this.OSSRC_INTER)){
					return "interdatacontent";
				}else{
					throw new Exception("����ҵ������Դ" + ossrc + "�޷���λĿ�����");
				}
			} else if (SELL_SERVICE_BUSIBELONG.equals(busibelong)) {
				if(ossrc.equals(this.OSSRC_DEFAULT)){
					return "cityservcontent";
				}else if(ossrc.equals(this.OSSRC_INTER)){
					return "interservcontent";
				}else{
					throw new Exception("����ҵ������Դ" + ossrc + "�޷���λĿ�����");
				}
			} else if (ACTV_BUSIBELONG.equals(busibelong)) {
				returnbusibelong.append(reqbusibelong);
				if (returnbusibelong.toString().equals(ACTV_NEW_BUSIBELONG)) {
					if(ossrc.equals(this.OSSRC_DEFAULT)){
						return "cityactvnewcontent";
					}else if(ossrc.equals(this.OSSRC_INTER)){
						return "interactvnewcontent";
					}else{
						throw new Exception("����ҵ������Դ" + ossrc + "�޷���λĿ�����");
					}
				} else if (returnbusibelong.toString().equals(ACTV_E100_BUSIBELONG)) {
					if(ossrc.equals(this.OSSRC_DEFAULT)){
						return "cityactve100content";
					}else if(ossrc.equals(this.OSSRC_INTER)){
						return "interactve100content";
					}else{
						throw new Exception("����ҵ������Դ" + ossrc + "�޷���λĿ�����");
					}
				}
			} else {
				throw new Exception("����ҵ�����" + busibelong + "�޷���λĿ�����");
			}
		} else {
			if (SELL_BUSIBELONG.equals(busibelong)
					|| DATABUSI_BUSIBELONG.equals(busibelong)
					|| CZ_BUSIBELONG.equals(busibelong)) {
				return "sellcontent";
			} else if (QUER_BUSIBELONG.equals(busibelong.toString())) {
				return "quercontent";
			} else if (ACTV_BUSIBELONG.equals(busibelong.toString())) {// ACTV��Ծ����
				returnbusibelong.append(reqbusibelong);
				if (returnbusibelong.toString().equals(ACTV_NEW_BUSIBELONG)) {
					return "actvnewcontent";
				} else if (returnbusibelong.toString().equals(
						ACTV_E100_BUSIBELONG)) {
					return "actve100content";
				}
			} else {
				throw new Exception("����ҵ�����" + busibelong + "�޷���λĿ�����");
			}
		}
		return null;
	}

	/**
	 * ����ҵ�������ȡ����
	 * 
	 * @param busibelong
	 * @return
	 */
	private String getOpnname(String busibelong) {
		if (null == busibelong || busibelong.trim().length() == 0) {
			return "";
		}
		if (SELL_BUSIBELONG.equals(busibelong)
				|| DATABUSI_BUSIBELONG.equals(busibelong)
				|| CZ_BUSIBELONG.equals(busibelong)) {
			return "����ҵ��";
		} else if (QUER_BUSIBELONG.equals(busibelong)) {
			return "��ѯҵ��";
		} else if (ACTV_BUSIBELONG.equals(busibelong)) {
			return "��Ծҵ��";
		}
		return "";
	}

	/**
	 * ����form�г�����Ĭ��ֵ
	 * 
	 * @param form
	 * @param BBCoperationVO
	 */
	private void setDefaultFormValue(BBCstdrewardbjForm form,
			BBCoperationVO bbcoperationVO) throws Exception {
		if (null == bbcoperationVO.getBusibelong()
				|| bbcoperationVO.getBusibelong().trim().length() == 0) {
			return;
		}

		String beginDate = getDefaultBeginDate();
		String endDate = getDefaultEndDate();
		form.setOpnid(bbcoperationVO.getOpnid());
		form.setOpnname(bbcoperationVO.getName());
		form.setOpnstate(bbcoperationVO.getState());
		form.setBusibelong(bbcoperationVO.getBusibelong());
		
		form.setOssrc(new Short(reqOssrc));

		if (SELL_BUSIBELONG.equals(bbcoperationVO.getBusibelong())
				|| DATABUSI_BUSIBELONG.equals(bbcoperationVO.getBusibelong())
				|| CZ_BUSIBELONG.equals(bbcoperationVO.getBusibelong())) {
			form.setRewardname_basic(bbcoperationVO.getName() + "������������");
			form.setRewardtype_basic(new Short("" + BBCRewardType.SELL_BASIC));
			form.setStartdate_basic(beginDate);
			form.setStopdate_basic(endDate);
			form.setAcctype_basic(new Short(DEFAULT_ACCTYPE));

			form.setRewardname_encourage(bbcoperationVO.getName() + "�����ཱ�����");
			form.setRewardtype_encourage(new Short(""
					+ BBCRewardType.SELL_ENCOURAGE));
			form.setStartdate_encourage(beginDate);
			form.setStopdate_encourage(endDate);
		} else if (ACTV_NEW_BUSIBELONG.equals(bbcoperationVO.getBusibelong()
				+ reqbusibelong)) {
			form.setRewardname_basic(bbcoperationVO.getName() + "������վ��Ծ�ͻ��������");
			form.setRewardtype_basic(new Short(""
					+ BBCRewardType.ACTV_NEW_BASIC));
			form.setStartdate_basic(beginDate);
			form.setStopdate_basic(endDate);
			form.setAcctype_basic(new Short(DEFAULT_ACCTYPE));

			form.setRewardname_encourage(bbcoperationVO.getName()
					+ "������վ��Ծ�ͻ��������");
			form.setRewardtype_encourage(new Short(""
					+ BBCRewardType.ACTV_NEW_ENCOURAGE));
			form.setStartdate_encourage(beginDate);
			form.setStopdate_encourage(endDate);
		} else if (ACTV_E100_BUSIBELONG.equals(bbcoperationVO.getBusibelong()
				+ reqbusibelong)) {
			form.setRewardname_basic(bbcoperationVO.getName() + "e100��Ծ�ͻ��������");
			form.setRewardtype_basic(new Short(""
					+ BBCRewardType.ACTV_E100_BASIC));
			form.setStartdate_basic(beginDate);
			form.setStopdate_basic(endDate);
			form.setAcctype_basic(new Short(DEFAULT_ACCTYPE));

			form.setRewardname_encourage(bbcoperationVO.getName()
					+ "e100��Ծ�ͻ��������");
			form.setRewardtype_encourage(new Short(""
					+ BBCRewardType.ACTV_E100_ENCOURAGE));
			form.setStartdate_encourage(beginDate);
			form.setStopdate_encourage(endDate);
		}
	}

	/**
	 * ����form�г�����ֵ
	 * 
	 * @param form
	 * @param bbcstdrewardbjVO
	 * @param bbcstdrewardVO
	 * @param flag
	 */
	private void setFormValue(BBCstdrewardbjForm form,
			BBCstdrewardVO bbcstdrewardVO, BBCstdrewardbjVO bbcstdrewardbjVO,
			boolean flag, User user) throws Exception {
		if (null == bbcstdrewardVO || null == bbcstdrewardVO.getRewardtype()) {
			return;
		}
		switch (bbcstdrewardVO.getRewardtype().intValue()) {
		case BBCRewardType.SELL_BASIC: // ������������
		case BBCRewardType.ACTV_NEW_BASIC: // ������վ��Ծ�ͻ��������
		case BBCRewardType.ACTV_E100_BASIC: // e100��Ծ�ͻ��������
			form.setBasicflag(true);
			form.setRewardid_basic(bbcstdrewardVO.getRewardid());
			form.setRewardname_basic(bbcstdrewardVO.getRewardname());
			form.setRewardtype_basic(bbcstdrewardVO.getRewardtype());
			form.setStartdate_basic(PublicUtils.formatUtilDate(bbcstdrewardVO
					.getStartdate(), DATAFORMAT));
			form.setStopdate_basic(PublicUtils.formatUtilDate(bbcstdrewardVO
					.getStopdate(), DATAFORMAT));
			form.setRewardstd_basic(bbcstdrewardbjVO.getRewardstd());
			form.setRuleid_basic(bbcstdrewardbjVO.getRuleid());
			form.setAcctype_basic(bbcstdrewardbjVO.getAcctype());
			form.setRewardproj(bbcstdrewardVO.getRewardproj());
			if (flag) {
				BBCstdrewardbjVO vo = this.getProvinceStd(bbcstdrewardbjVO,
						user);
				form.setMax_rewardstd(vo.getRewardstd());
				form.setMax_intvmonth(vo.getIntvmonth());
			}
			break;
		case BBCRewardType.SELL_ENCOURAGE: // �����ཱ�����
		case BBCRewardType.ACTV_NEW_ENCOURAGE: // ������վ��Ծ�ͻ��������
		case BBCRewardType.ACTV_E100_ENCOURAGE: // e100��Ծ�ͻ��������
			form.setEncourageflag(true);
			bbcstdrewardbjVO.setRewardname(bbcstdrewardVO.getRewardname());
			bbcstdrewardbjVO.setRewardtype(bbcstdrewardVO.getRewardtype());
			bbcstdrewardbjVO.setStartdate(bbcstdrewardVO.getStartdate());
			bbcstdrewardbjVO.setStopdate(bbcstdrewardVO.getStopdate());
			bbcstdrewardbjVO.setRewardproj(bbcstdrewardVO.getRewardproj());
			form.getOldencouragelist().add(bbcstdrewardbjVO);
			break;
		}
	}

	/**
	 * �Ƿ�����ͬ������ƣ����򷵻�true�����򷵻�false
	 * 
	 * @param rewardname
	 * @param list
	 * @return
	 */
	private boolean hasSameName(String rewardname, List list) {
		if (null == list || list.size() == 0) {
			return false;
		}

		for (Iterator iter = list.iterator(); iter.hasNext();) {
			BBCstdrewardbjVO item = (BBCstdrewardbjVO) iter.next();
			if (null == item || null == item.getRewardname()) {
				continue;
			}
			if (item.getRewardname().equals(rewardname)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * ���༭�������Ҫ����Ự��ʱ���жϽ������Ƿ�����ͬ�ĳ������
	 * 
	 * @param rewardname
	 * @param list
	 * @return
	 */
	private boolean hasSameNameWhenEdit(String rewardname,
			String rewardname_temp, List list) throws Exception {
		if (null == list || list.size() == 0) {
			return false;
		}
		if (StringUtils.isEmpty(rewardname_temp)) {
			throw new Exception("δ�����༭��������ʹ�øñ��水ť");
		}
		// �µ����ֵ��ھɵ�����,��˵��û�Ķ�������
		if (rewardname.equals(rewardname_temp)) {
			return false;
		}
		// �µ����ֲ����ھɵ�����,������������ɼ�¼
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			BBCstdrewardbjVO item = (BBCstdrewardbjVO) iter.next();
			if (null == item || null == item.getRewardname()) {
				continue;
			}
			if (item.getRewardname().equals(rewardname)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * ��ȡĬ�Ͽ�ʼ���� ����
	 * 
	 * @return
	 */
	private static String getDefaultBeginDate() {
		return PublicUtils.formatUtilDate(new Date(), DATAFORMAT);
	}

	/**
	 * ��ȡĬ����ֹ���� 2099-01-01
	 * 
	 * @return
	 */
	private static String getDefaultEndDate() throws Exception {
		return "2099-01-01";
	}

	/**
	 * ��ȡʡ��˾�������
	 * 
	 * @param vo
	 * @param user
	 * @return
	 * @throws Exception
	 */
	private BBCstdrewardbjVO getProvinceStd(BBCstdrewardbjVO vo, User user)
			throws Exception {
		BBCstdrewardbjVO stdrewardbjVO = new BBCstdrewardbjVO();
		stdrewardbjVO.setRewardid(vo.getRewardid());
		stdrewardbjVO.setRegion(DEFAULT_REGION);
		stdrewardbjVO.setOssrc(new Short(OSSRC_DEFAULT));
		
		BBCstdrewardbjDelegate delegate = new BBCstdrewardbjDelegate();
		stdrewardbjVO = delegate.doFindByPk(stdrewardbjVO, user);
		return (BBCstdrewardbjVO) stdrewardbjVO;
	}
	
	/**
	 * B2M �������������
	 * @return
	 * @throws Exception
	 */
	public synchronized Double getInterfactor(User user) throws Exception{
		CommonDelegate delegate = new CommonDelegate(SysparamVO.class);
		SysparamListVO listvo = new SysparamListVO();
		listvo.set_ne_systemid("54");
		listvo.set_sk_paramtype("channel");
		DataPackage dp = delegate.doQuery(listvo, user, false);
		if (dp != null && dp.getDatas()!= null && dp.getDatas().size() == 1){
			Iterator it = dp.getDatas().iterator();
			if(it.hasNext()){
				SysparamVO vo = (SysparamVO) it.next();
				return new Double(vo.getParamvalue());
			}
		}
		throw new Exception("B2M����������׼ϵ��δ���û������ö���");
	}
}
