package com.sunrise.boss.ui.cms.reward.stdrewardut;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.admin.dictitem.persistent.DictitemVO;
import com.sunrise.boss.business.cms.reward.rulerel.persistent.RulerelListVO;
import com.sunrise.boss.business.cms.reward.rulerel.persistent.RulerelVO;
import com.sunrise.boss.business.cms.reward.stdrewardut.persistent.StdrewardutListVO;
import com.sunrise.boss.business.cms.reward.stdrewardut.persistent.StdrewardutVO;
import com.sunrise.boss.business.cms.reward.stdrewardut.persistent.VStdrewardutVO;
import com.sunrise.boss.business.cms.reward.vwaycompact.persistent.VwaycompactVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.delegate.admin.dictitem.DictitemDelegate;
import com.sunrise.boss.delegate.cms.provincialright.ProvincialrightDelegate;
import com.sunrise.boss.delegate.cms.reward.rulerel.RulerelDelegate;
import com.sunrise.boss.delegate.cms.reward.stdrewardut.StdrewardutDelegate;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.cms.salereward.SalerewardForm;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>
 * Title: StdrewardutAction
 * </p>
 * <p>
 * Description: ͳһ����ģʽ����׼����
 * </p>
 * <p>
 * Copyright: Copyright (c) 2007
 * </p>
 * <p>
 * Company: SUNRISE Tech Ltd.
 * </p>
 * 
 * @author LiZhaoLiang
 * @version 1.0 2010-10-8
 */

public class StdrewardutAction extends BaseDelegateAction {

	private static final String REWARD = "CH_PW_REWARD";

	private static final String PROVINCIAL = "CH_PW_REWARD_PROVINCIAL";

	private static final String CIVIC = "CH_PW_REWARD_CIVIC";

	public StdrewardutAction() throws Exception {
		// ���¼��������Ǳ����
		// ָ��VO��
		setVoClass(StdrewardutVO.class);
		// ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
		this.pkNameArray = new String[3];
		pkNameArray[0] = "rewardid";
		pkNameArray[1] = "region";
		pkNameArray[2] = "wayid";
	}

	/**
	 * 
	 */
	public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		// TODO Auto-generated method stub
		try {
			DataPackage dp = null;
			StdrewardutForm form = (StdrewardutForm) actionForm;
			Page.setPageSize(request, form);
			StdrewardutListVO listVO = new StdrewardutListVO();
			StdrewardutDelegate delegate = new StdrewardutDelegate();
			if("999".equals(form.get_se_region())){
				form.set_se_region(null);
			}
			setListVO(listVO, form);
			ProvincialrightDelegate provdelegate = new ProvincialrightDelegate();
			Boolean hasRewardPurview = Boolean.valueOf(provdelegate
					.checkPurview(user, REWARD));
			Boolean hasProvincialPurview = Boolean.valueOf(provdelegate
					.checkPurview(user, PROVINCIAL));
			Boolean hasCivicPurview = Boolean.valueOf(provdelegate
					.checkPurview(user, CIVIC));
			if (hasRewardPurview || hasProvincialPurview) {
				dp = delegate.doQuerylist(listVO, user);
			} else if (hasCivicPurview) {
				form.set_se_region(user.getCityid());
				listVO.set_se_region(user.getCityid());
				dp = delegate.doQuerylist(listVO, user);
			} else {
				return (actionMapping.findForward("list"));
			}
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
		}
		return (actionMapping.findForward("list"));
	}

	/**
	 * 
	 */
	public ActionForward doListcity(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		// TODO Auto-generated method stub
		try {
			DataPackage dp = null;
			StdrewardutForm form = (StdrewardutForm) actionForm;
			Page.setPageSize(request, form);
			StdrewardutListVO listVO = new StdrewardutListVO();
			StdrewardutDelegate delegate = new StdrewardutDelegate();
			ProvincialrightDelegate provdelegate = new ProvincialrightDelegate();
			setListVO(listVO, actionForm);
			Boolean hasRewardPurview = Boolean.valueOf(provdelegate
					.checkPurview(user, REWARD));
			Boolean hasProvincialPurview = Boolean.valueOf(provdelegate
					.checkPurview(user, PROVINCIAL));
			Boolean hasCivicPurview = Boolean.valueOf(provdelegate
					.checkPurview(user, CIVIC));
			if (hasRewardPurview || hasProvincialPurview) {
				listVO.set_se_cityid(SessionFactoryRouter.conversionCityid(form.get_se_cityid()));
				dp = delegate.doQuerycitylist(listVO, user);
			} else if (hasCivicPurview) {
				form.set_se_cityid(user.getCityid());
				listVO.set_se_cityid(SessionFactoryRouter.conversionCityid(user.getCityid()));
				dp = delegate.doQuerycitylist(listVO, user);
			} else {
				return (actionMapping.findForward("list"));
			}
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
		}
		return (actionMapping.findForward("citylist"));
	}

	/**
	 * ʡ��˾����׼����-����
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doNew(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		StdrewardutForm form = (StdrewardutForm) actionForm;
		// 51 - רӪ�������
		form.setRewardtype_51(new Short("51"));
		// 52 - ���۴����
		form.setRewardtype_52(new Short("52"));
		// 53 - ���۳�����
		form.setRewardtype_53(new Short("53"));
		String command = getCommandString(request);
		((BaseActionForm) actionForm).setCmdState(command);
		request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,
				WebConstant.COMMAND_STRING_EDIT);
		return (actionMapping.findForward("content"));
	}

	/**
	 * ʡ��˾����׼����-����
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			StdrewardutForm form = (StdrewardutForm) actionForm;
			StdrewardutDelegate delegate = new StdrewardutDelegate();
			VStdrewardutVO vo = new VStdrewardutVO();
			// ��ȡ��ѡ���б�ʶ
			String[] selectcity = form.getSelectcity();
			setSaveVO(vo, form);
			// �����ֳ��ֵ
			ArrayList list51 = this.getlist51(form);
			ArrayList list52 = this.getlist52(form);
			ArrayList list53 = this.getlist53(form);
			String cmdState = form.getCmdState();

			if (WebConstant.COMMAND_STRING_EDIT.equals(cmdState)) {
				// �޸�
				delegate.doBatchupdate(vo, selectcity, list51, list52, list53,
						user);
			} else {
				// ����
				delegate.doBatchcreate(vo, selectcity, list51, list52, list53,
						user);
			}
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����ɹ�");
			request.setAttribute(WebConstant.COMMAND_STRING_NEW, "FALSE");
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
			request.setAttribute(WebConstant.COMMAND_STRING_NEW, "TRUE");
			return (actionMapping.findForward("content"));
		}
		return (actionMapping.findForward("content"));
	}

	/**
	 * ʡ��˾����׼����-�༭
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doEdit(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		// TODO Auto-generated method stub
		String pk = request.getParameter("PK");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		StdrewardutDelegate delegate = new StdrewardutDelegate();
		StdrewardutForm form = (StdrewardutForm) actionForm;
		StdrewardutListVO params = new StdrewardutListVO();
		VStdrewardutVO contentVO = new VStdrewardutVO();
		params.set_se_region(pk);
		DataPackage dp = delegate.doQuerylist(params, user);
		if (dp.getRowCount() > 0) {
			for (Iterator it = dp.getDatas().iterator(); it.hasNext();) {
				contentVO = (VStdrewardutVO) it.next();
				// Ԥ������ҳ����ʾ
				if (contentVO.getRewardtype() == 51) {
					form.setRewardname_51(contentVO.getRewardname());
					form.setRewardtype_51(contentVO.getRewardtype());
					form.setStartdate_51(format
							.format(contentVO.getStartdate()));
					form.setStopdate_51(format.format(contentVO.getStopdate()));
					form.setRewardstd_51(contentVO.getRewardstd());
					form.setIntvmonth_51(contentVO.getIntvmonth());
					String[] city = { SessionFactoryRouter
							.conversionCityid2Num(contentVO.getRegion()) };
					form.setSelectcity(city);
				} else if (contentVO.getRewardtype() == 52) {
					form.setRewardname_52(contentVO.getRewardname());
					form.setRewardtype_52(contentVO.getRewardtype());
					form.setStartdate_52(format
							.format(contentVO.getStartdate()));
					form.setStopdate_52(format.format(contentVO.getStopdate()));
					form.setRewardstd_52(contentVO.getRewardstd());
					form.setIntvmonth_52(contentVO.getIntvmonth());
					form.setIntegralnum_52(contentVO.getIntegralnum());
					String[] city = { SessionFactoryRouter
							.conversionCityid2Num(contentVO.getRegion()) };
					form.setSelectcity(city);
				} else if (contentVO.getRewardtype() == 53) {
					form.setRewardname_53(contentVO.getRewardname());
					form.setRewardtype_53(contentVO.getRewardtype());
					form.setStartdate_53(format
							.format(contentVO.getStartdate()));
					form.setStopdate_53(format.format(contentVO.getStopdate()));
					form.setRewardstd_53(contentVO.getRewardstd());
					form.setIntvmonth_53(contentVO.getIntvmonth());
					form.setUnitprice_53(contentVO.getUnitprice());
					String[] city = { SessionFactoryRouter
							.conversionCityid2Num(contentVO.getRegion()) };
					form.setSelectcity(city);
				}
			}
		}
		String command = getCommandString(request);
		((BaseActionForm) actionForm).setCmdState(command);
		request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,
				WebConstant.COMMAND_STRING_EDIT);
		request.setAttribute(WebConstant.COMMAND_STRING_NEW, "FALSE");
		return (actionMapping.findForward("content"));
	}

	/**
	 * ʡ��˾����׼����-ɾ��
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doDelete(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		// TODO Auto-generated method stub
		try {
			String tempcity = "";
			String city = "";
			boolean cando = true;
			DictitemVO dictvo = new DictitemVO();
			DictitemDelegate dictdelegate = new DictitemDelegate();
			VStdrewardutVO contentVO = new VStdrewardutVO();
			StdrewardutListVO utparams = new StdrewardutListVO();
			StdrewardutListVO queryparams = new StdrewardutListVO();
			StdrewardutDelegate delegate = new StdrewardutDelegate();
			ArrayList regionlist = new ArrayList();
			String[] selectArray = ((StdrewardutForm) actionForm)
					.get_selectitem();
			// ������ɾ�������б�
			regionlist.add(selectArray[0]);
			for (int i = 1; i < selectArray.length; i++) {
				if (selectArray[i - 1].equals(selectArray[i])) {
				} else {
					regionlist.add(selectArray[i]);
				}
			}
			if (regionlist.size() > 0) {
				for (int i = 0; i < regionlist.size(); i++) {
					utparams.set_se_region(regionlist.get(i).toString());
					DataPackage dp = delegate.doQuerylist(utparams, user);
					if (dp.getRowCount() > 0) {
						for (Iterator it = dp.getDatas().iterator(); it
								.hasNext();) {
							contentVO = (VStdrewardutVO) it.next();
							// У���Ƿ���ڹ������м�����׼
							queryparams.set_ne_rewardid(contentVO.getRewardid()
									.toString());
							queryparams.set_se_region(contentVO.getRegion());
							queryparams.set_ne_islimt("1");
							DataPackage querydp = delegate.doQuery(queryparams,
									user);
							// ����������ɾ������
							if (querydp.getRowCount() > 0) {
								cando = false;
								dictvo.setDictid(contentVO.getRegion());
								dictvo.setGroupid("region");
								dictvo = dictdelegate.doFindByPk(dictvo, user);
								tempcity = tempcity + dictvo.getDictname()
										+ ",";
								break;
							}
						}
						if (!"".equals(tempcity)) {
							city = tempcity.substring(0, tempcity.length() - 1);
						}
					}
				}
				// �����ڹ������м�����׼������ɾ��
				if (cando) {
					delegate.doBatchremove(regionlist, user);
				} else {
					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
							"����ʧ��,������ʶ�¹������м�[" + city + "]����׼,����ɾ��!");
					return this.doList(actionMapping, actionForm, request,
							response, user);
				}
			}
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
		}
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "ɾ���ɹ�!");
		return this.doList(actionMapping, actionForm, request, response, user);// super.doDelete(actionMapping,
																				// actionForm,
																				// request,
		// response, user);
	}

	// רӪ�������
	public ArrayList getlist51(StdrewardutForm form) throws Exception {
		ArrayList createlist51 = new ArrayList();
		createlist51.add(form.getRewardname_51());
		createlist51.add(form.getRewardtype_51());
		createlist51.add(form.getStartdate_51());
		createlist51.add(form.getStopdate_51());
		createlist51.add(form.getRewardstd_51());
		createlist51.add(form.getIntvmonth_51());
		createlist51.add(form.getIntegralnum_51());
		createlist51.add(form.getUnitprice_51());
		return createlist51;
	}

	// ���۴����
	public ArrayList getlist52(StdrewardutForm form) throws Exception {
		ArrayList createlist52 = new ArrayList();
		createlist52.add(form.getRewardname_52());
		createlist52.add(form.getRewardtype_52());
		createlist52.add(form.getStartdate_52());
		createlist52.add(form.getStopdate_52());
		createlist52.add(form.getRewardstd_52());
		createlist52.add(form.getIntvmonth_52());
		createlist52.add(form.getIntegralnum_52());
		createlist52.add(form.getUnitprice_52());
		return createlist52;
	}

	// ���۳�����
	public ArrayList getlist53(StdrewardutForm form) throws Exception {
		ArrayList createlist53 = new ArrayList();
		createlist53.add(form.getRewardname_53());
		createlist53.add(form.getRewardtype_53());
		createlist53.add(form.getStartdate_53());
		createlist53.add(form.getStopdate_53());
		createlist53.add(form.getRewardstd_53());
		createlist53.add(form.getIntvmonth_53());
		createlist53.add(form.getIntegralnum_53());
		createlist53.add(form.getUnitprice_53());
		return createlist53;
	}
	/**
	 * �й�˾����׼����-����
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doNewcity(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		StdrewardutForm form = (StdrewardutForm) actionForm;
		//51 - רӪ�������
		form.setRewardtype_51(new Short("51"));
		//52 - ���۴����
		form.setRewardtype_52(new Short("52"));
		//53 - ���۳�����
		form.setRewardtype_53(new Short("53"));
		String command = getCommandString(request);
		((BaseActionForm) actionForm).setCmdState(command);
		request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,
				WebConstant.COMMAND_STRING_EDIT);
		return (actionMapping.findForward("citycontent"));
	}
	/**
	 * �й�˾����׼����-����
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doSavecity(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			StdrewardutForm form = (StdrewardutForm) actionForm;
			StdrewardutDelegate delegate = new StdrewardutDelegate();
			StdrewardutVO vo = new StdrewardutVO();
			setSaveVO(vo, form);
			delegate.doSavecity(vo,user);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����ɹ�");
			request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
			request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
			return (actionMapping.findForward("citycontent"));
		}
		return (actionMapping.findForward("citycontent"));
	}
	/**
	 * �й�˾����׼����-�༭
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doEditcity(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try{
			//ȡ��form
			StdrewardutForm form = (StdrewardutForm) actionForm;
			// TODO Auto-generated method stub
			String pk = null;
			pk = request.getParameter("PK");
			if(pk==null){
				String[] selectArray = ((BaseActionForm) actionForm).get_selectitem();
				pk = selectArray[0];
			}
			VwaycompactVO waycompactVO=null;
			StdrewardutListVO listVO = new StdrewardutListVO();
			StdrewardutDelegate stdrewardutDelegate = new StdrewardutDelegate();
			listVO.set_se_wayid(pk);
			DataPackage dpway=stdrewardutDelegate.doQuerycitylist(listVO, user);
			Iterator itResult=dpway.getDatas().iterator();
			if(itResult.hasNext())
			{
				waycompactVO=(VwaycompactVO)itResult.next();
			}
			
			//��δ�ж��Ƿ���Ч����.
			if(waycompactVO==null)
			{
				throw new Exception("��������Ϊ:"+pk+"��������ϵͳ��δ�ܻ�ȡ��Ч����");
			}else if(waycompactVO.getCityid()==null)
			{
				throw new Exception("��������Ϊ:"+pk+"��������ϵͳ�в��ܻ�ȡ���б�־");
			}else
			{
				form.setRegion(waycompactVO.getCityid());
				form.setWayid(waycompactVO.getWayid());
				form.setWayname(waycompactVO.getWayname());
				//
				form.setCalcumode(String.valueOf(waycompactVO.getCalcumode()));
				form.setUniformtime(waycompactVO.getUniformtime());
			}
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			StdrewardutDelegate delegate = new StdrewardutDelegate();
			
			StdrewardutListVO params = new StdrewardutListVO();
			VStdrewardutVO contentVO = new VStdrewardutVO();
			params.set_se_region(waycompactVO.getCityid());
			DataPackage dp = delegate.doQuerylist(params, user);
			StdrewardutVO pkVO=new StdrewardutVO();
			if (dp.getRowCount() > 0) {
				for (Iterator it = dp.getDatas().iterator(); it.hasNext();) {
					contentVO = (VStdrewardutVO) it.next();
					//Ԥ������ҳ����ʾ
					if (contentVO.getRewardtype() == 51) {
						form.setRewardid_51(contentVO.getRewardid());
						form.setRewardname_51(contentVO.getRewardname());
						form.setRewardtype_51(contentVO.getRewardtype());
						form.setStartdate_51(format
								.format(contentVO.getStartdate()));
						form.setStopdate_51(format.format(contentVO.getStopdate()));
						form.setRewardstd_51(contentVO.getRewardstd());
						form.setIntvmonth_51(contentVO.getIntvmonth());
						//��ѯרӪ�������.
						pkVO.setRegion(waycompactVO.getCityid());
						pkVO.setRewardid(contentVO.getRewardid());
						pkVO.setWayid(waycompactVO.getWayid());
						pkVO=delegate.doFindByPk(pkVO, user);
						if(pkVO!=null)
						{
							form.setRewardstdcity_51(pkVO.getRewardstd());
							form.setIntvmonthcity_51(pkVO.getIntvmonth());
						}
						pkVO=null;
					} else if (contentVO.getRewardtype() == 52) {
						form.setRewardid_52(contentVO.getRewardid());
						form.setRewardname_52(contentVO.getRewardname());
						form.setRewardtype_52(contentVO.getRewardtype());
						form.setStartdate_52(format
								.format(contentVO.getStartdate()));
						form.setStopdate_52(format.format(contentVO.getStopdate()));
						form.setRewardstd_52(contentVO.getRewardstd());
						form.setIntvmonth_52(contentVO.getIntvmonth());
						form.setIntegralnum_52(contentVO.getIntegralnum());
						//��ѯ���۴����
						pkVO=new StdrewardutVO();
						pkVO.setRegion(waycompactVO.getCityid());
						pkVO.setRewardid(contentVO.getRewardid());
						pkVO.setWayid(waycompactVO.getWayid());
						pkVO=delegate.doFindByPk(pkVO, user);
						if(pkVO!=null)
						{
							form.setRewardstdcity_52(pkVO.getRewardstd());
							form.setIntegralnumcity_52(pkVO.getIntegralnum());
							form.setIntvmonthcity_52(pkVO.getIntvmonth());
						}
						pkVO=null;
						
					} else if (contentVO.getRewardtype() == 53) {
						form.setRewardid_53(contentVO.getRewardid());
						form.setRewardname_53(contentVO.getRewardname());
						form.setRewardtype_53(contentVO.getRewardtype());
						form.setStartdate_53(format
								.format(contentVO.getStartdate()));
						form.setStopdate_53(format.format(contentVO.getStopdate()));
						form.setRewardstd_53(contentVO.getRewardstd());
						form.setIntvmonth_53(contentVO.getIntvmonth());
						form.setUnitprice_53(contentVO.getUnitprice());
						//��ѯ���۳�����.
						pkVO=new StdrewardutVO();
						pkVO.setRegion(waycompactVO.getCityid());
						pkVO.setRewardid(contentVO.getRewardid());
						pkVO.setWayid(waycompactVO.getWayid());
						pkVO=delegate.doFindByPk(pkVO, user);
						if(pkVO!=null)
						{
							form.setRewardstdcity_53(pkVO.getRewardstd());
							form.setUnitpricecity_53(pkVO.getUnitprice());
							form.setIntvmonthcity_53(pkVO.getIntvmonth());
						}
					}
				}
			}else
			{
				throw new Exception("δ��ѯ����Ӧ��ʡ��˾����׼����");
			}
			String command = getCommandString(request);
			((BaseActionForm) actionForm).setCmdState(command);
			request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,
					WebConstant.COMMAND_STRING_EDIT);
			request.setAttribute(WebConstant.COMMAND_STRING_NEW, "FALSE");
			return (actionMapping.findForward("citycontent"));
		}
		catch(Exception ex)
		{
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex.getMessage());
			request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,
					WebConstant.COMMAND_STRING_EDIT);
			return (actionMapping.findForward("citylist"));
		}
	}
	/**
	 * �й�˾����׼����-ɾ��
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doDeletecity(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		// TODO Auto-generated method stub
		try {
			String[] selectArray = ((BaseActionForm) actionForm).get_selectitem();
			StdrewardutDelegate delegate = new StdrewardutDelegate();
			for (int i = 0; i < selectArray.length; i++) {
					delegate.doDeletecity(selectArray[i], user);
			}
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,"ɾ���ɹ�!");
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
		}
		return this.doListcity(actionMapping, actionForm, request, response, user);
	}
	
	// ��ѯ
   	public ActionForward doDetails(ActionMapping actionMapping,
   			ActionForm actionForm, HttpServletRequest request,
   			HttpServletResponse response, User user) throws Exception {
   		
//   		��ӵĲ���
   		RulerelDelegate rulerelDelegate=new RulerelDelegate();
//   		RulerelListVO rulerellistvo = new RulerelListVO();
//   		DataPackage dp2= rulerelDelegate.doQuery5(rulerellistvo, user);
   		RulerelListVO rulerellistvo = new RulerelListVO();
   		rulerellistvo.set_se_ruleid("STAR_REWARD");
   		DataPackage dp2= rulerelDelegate.doQueryByRuleid(rulerellistvo, user);
//   		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
   		Iterator it = dp2.getDatas().iterator();
   		while(it.hasNext()){
   			RulerelVO vo=(RulerelVO)(it.next());
   			rulerellistvo.set_se_ruleitemid(vo.getRuleitemid());
   			rulerellistvo.set_se_ruleid(vo.getRuleid());
   			rulerellistvo.set_se_cityid(user.getCityid());
   			DataPackage dp3=rulerelDelegate.doQuery(rulerellistvo, user);
   			Iterator itor = dp3.getDatas().iterator();
   			if (itor.hasNext()) {
//   				RulerelVO vo=(RulerelVO)(itor.next());
   				vo.setParamercityvalue(((RulerelVO)(itor.next())).getParamer());
   			}
   		}
   		request.setAttribute("dp2", dp2);
   		
   		return (actionMapping.findForward("listdetails"));
   	}
   	
   	public ActionForward doSave2(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
   		StdrewardutForm form=(StdrewardutForm)actionForm;
		String ruleitemids[] = getRuleitemids(form); // ������ѡ��RULEITEMID
//		String paramervalues[] =getParamervalues(form); // �����ϵ�paramer
		RulerelDelegate rulerelDelegate = new RulerelDelegate();
		RulerelVO rulerelVO=null;
		try {
			for (int i = 0; i < ruleitemids.length; i++) {
				rulerelVO=new RulerelVO();
				rulerelVO.setRuleid("STAR_REWARD");
				rulerelVO.setRulemodeid(Long.parseLong("0"));
				rulerelVO.setCityid(user.getCityid());
				rulerelVO.setRuleitemid(ruleitemids[i]);
				
				//��ѯ"999"��paramer ,�м����ָ���"|",����Ĳ����Ƿ���ͬ���ĸ���
				RulerelListVO rulerelListVO1=new RulerelListVO();
				rulerelListVO1.set_se_ruleid("STAR_REWARD");
				rulerelListVO1.set_se_cityid("999");
				rulerelListVO1.set_se_ruleitemid(ruleitemids[i]);
				DataPackage dp2=rulerelDelegate.doQuery(rulerelListVO1, user);
				String sp1="";
				try {
					sp1 = ((RulerelVO)dp2.getDatas().iterator().next()).getParamer();
				} catch (RuntimeException e) {
					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "ʡ��˾û�д������͵�ҵ��!");
					return doDetails(actionMapping,actionForm, request,response,user);
				}
				String sp2=form.getParamervalues()[i];
				if( StringUtils.splitPreserveAllTokens(sp1, "|").length!= StringUtils.splitPreserveAllTokens(sp2, "|").length||!("".equals(StringUtils.splitPreserveAllTokens(sp2, "|")[StringUtils.splitPreserveAllTokens(sp2, "|").length-1])) ){
					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "��"+(i+1)+"������Ĳ���ֵ������һ��,����Ҫ��'|'�ָ�!");
					return doDetails(actionMapping,actionForm, request,response,user);
				}
				
				
				rulerelVO.setParamer(form.getParamervalues()[i]);
				
				//��ѯ��û��,�о��޸�
				RulerelListVO rulerelListVO=new RulerelListVO();
				rulerelListVO.set_se_ruleid("STAR_REWARD");
				rulerelListVO.set_se_cityid(user.getCityid());
				rulerelListVO.set_ne_rulemodeid(Long.parseLong("0"));
				rulerelListVO.set_se_ruleitemid(ruleitemids[i]);
				DataPackage dp=rulerelDelegate.doQuery(rulerelListVO, user);
				Iterator itor = dp.getDatas().iterator();
				if (itor.hasNext()) {
					rulerelVO.setParamer(form.getParamervalues()[i]);
					rulerelDelegate.doUpdate2(rulerelVO, user);
				}else{
					rulerelDelegate.doCreate(rulerelVO, user);
				}
			}
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����ɹ�");
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
		}
		
//		return (actionMapping.findForward("listdetails"));
		return doDetails(actionMapping,actionForm, request,response,user);
	}
	
   	/**
	 * ֻ����������ѡ�������
	 * 
	 * @param form
	 * @return
	 */
	private String[] getRuleitemids(StdrewardutForm form) {
		String[] ids = form.getRuleitemids();
		if (ids == null || ids.length == 0) {
			return new String[0];
		}
		String[] ruleitemids = new String[ids.length];
		for (int i = 0; i < ids.length; i++) {
			String id = ids[i];
			String tempid[] = id.split("\\|");
			ruleitemids[i] = tempid[0];
		}
		return ruleitemids;
	}
   	
}