/**
 * auto-generated code
 * Fri Feb 01 18:12:16 CST 2008
 */
package com.sunrise.boss.ui.cms.stdrewardbs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ajaxanywhere.AAUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.reward.ruleitem.persistent.RuleitemListVO;
import com.sunrise.boss.business.cms.reward.ruleitem.persistent.RuleitemVO;
import com.sunrise.boss.business.cms.reward.rulerel.persistent.RulerelListVO;
import com.sunrise.boss.business.cms.reward.rulerel.persistent.RulerelVO;
import com.sunrise.boss.business.cms.stdreward.persistent.StdrewardListVO;
import com.sunrise.boss.business.cms.stdreward.persistent.StdrewardVO;
import com.sunrise.boss.business.cms.stdrewardbs.persistent.StdrewardbsListVO;
import com.sunrise.boss.business.cms.stdrewardbs.persistent.StdrewardbsVO;
import com.sunrise.boss.business.cms.stdrewardbs.persistent.StdrewardbsdVO;
import com.sunrise.boss.business.cms.stdrewardbs.persistent.V_StdrewardbsVO;
import com.sunrise.boss.business.cms.stdrewardbss.persistent.StdrewardbssListVO;
import com.sunrise.boss.business.cms.stdrewardbss.persistent.StdrewardbssVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.delegate.cms.reward.ruleitem.RuleitemDelegate;
import com.sunrise.boss.delegate.cms.reward.rulerel.RulerelDelegate;
import com.sunrise.boss.delegate.cms.stdreward.StdrewardDelegate;
import com.sunrise.boss.delegate.cms.stdrewardbs.StdrewardbsDelegate;
import com.sunrise.boss.delegate.cms.stdrewardbss.StdrewardbssDelegate;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.cms.reward.stdrewardut.StdrewardutForm;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p> 
 * Title: StdrewardbsAction
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author
 * @version 1.0
 */
public class StdrewardbsAction extends BaseDelegateAction {
	public StdrewardbsAction() {
		// ���¼��������Ǳ����
		// ָ��VO��
		setVoClass(StdrewardbsVO.class);
		// ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
		this.pkNameArray = new String[1];
		// pkNameArray[0] = "islimt";
		// pkNameArray[1] = "region";
		pkNameArray[0] = "rewardid";
	}

	public ActionForward doShow(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		return actionMapping.findForward("list");
	}

	public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		// Page.setPageSize(request, (BaseActionForm) actionForm);
		try {
			StdrewardDelegate delegate = new StdrewardDelegate();
			Page.setPageSize(request, (BaseActionForm) actionForm);
			StdrewardListVO listVO = new StdrewardListVO();
			setListVO(listVO, actionForm); // ���ú�listVO����Ϊ��ѯ����
			listVO.set_ne_rewardtype("7");
			if(StringUtils.isEmpty(listVO.get_orderby())){
			listVO.set_orderby("rewardid");
			}
			DataPackage pack = (DataPackage) delegate.doQuery(listVO, user);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, pack);
		} catch (BusinessException e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
		} catch (Exception e) {
			throw e;
		}
		return (actionMapping.findForward("list"));
	}

	// ����
	public ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		String cmdState = ((BaseActionForm) actionForm).getCmdState();
		StdrewardbsDelegate delegate = new StdrewardbsDelegate();
		StdrewardbsVO StdrewardbsVO = new StdrewardbsVO();
		StdrewardVO stdrewardVO = new StdrewardVO();
		DataPackage packstart = new DataPackage();
		try {
			com.sunrise.boss.common.utils.bean.BeanUtils.copyProperties(
					stdrewardVO, actionForm);
			List liststar = new ArrayList();
			//List liststartvo = new ArrayList();
			List v_liststarvo=new ArrayList();
			
			if (request.getSession().getAttribute("STARLIST") != null) {
				packstart = (DataPackage) request.getSession().getAttribute(
						"STARLIST");
				if(packstart.getDatas().size()==0){
					request.setAttribute("STARLIST", packstart);
					throw new BusinessException("", "�Ǽ���������б���Ϣ����Ϊ��");
				}
				liststar = packstart.toList(StdrewardbsForm.class);
				Iterator star = liststar.iterator();
				while (star.hasNext()) {
					StdrewardbsForm ob = (StdrewardbsForm) star.next();
					V_StdrewardbsVO unionVO = new V_StdrewardbsVO();
					com.sunrise.boss.common.utils.bean.BeanUtils
							.copyProperties(unionVO, ob);
					v_liststarvo.add(unionVO);
				}
			}
			
			if (stdrewardVO.getRewardid() != null
					&& !"".equals(stdrewardVO.getRewardid().toString())) {
				delegate.doUpdate(stdrewardVO, v_liststarvo, user);
				BeanUtils.copyProperties(actionForm, StdrewardbsVO);
				BeanUtils.copyProperties(actionForm, stdrewardVO);// �Ѹ��º��ֵ����form������web��ʾ
				request
						.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
								"����ɹ�");
				request.setAttribute("isSubmit","true");
			} else {
				stdrewardVO.setRewardtype(new Short((short) 7));
				delegate.doCreate(stdrewardVO, v_liststarvo, user);
				BeanUtils.copyProperties(actionForm, stdrewardVO);
				BeanUtils.copyProperties(actionForm, StdrewardbsVO); // �Ѹ��º��ֵ����form������web��ʾ
				request
						.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
								"����ɹ�");
				request.setAttribute("isSubmit","true");
			}
		} catch (Exception ex) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex
					.getMessage());
			//request.getSession().removeAttribute("STARLIST");
		}
		request.setAttribute("STARLIST", packstart);
		return (actionMapping.findForward("content"));
	}

	public ActionForward doShowframe(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {

		String command = request.getParameter("truecmd");
		request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, command);
		request.setAttribute("rewardid", request.getParameter("PK"));

		return (actionMapping.findForward("frame"));
	}

	// �����й�˾����׼
	public ActionForward doSavest(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		String cmdState = ((BaseActionForm) actionForm).getCmdState();
		StdrewardbsDelegate delegate = new StdrewardbsDelegate();
		StdrewardbsVO stdrewardbsVO = new StdrewardbsVO();
//		StdrewardbsVO stdrewardbsVO1 = new StdrewardbsVO();
		StdrewardVO stdrewardVO = new StdrewardVO();
		StdrewardbsdVO stdrewardbsdVO = new StdrewardbsdVO();
		try {
			com.sunrise.boss.common.utils.bean.BeanUtils.copyProperties(
					stdrewardbsVO, actionForm);
			com.sunrise.boss.common.utils.bean.BeanUtils.copyProperties(
					stdrewardVO, actionForm);
//			stdrewardbsVO1.setRewardid(stdrewardbsVO.getRewardid());
//			stdrewardbsVO1.setRegion(user.getCityid());
//			stdrewardbsVO1.setIslimt(new Short((short) 1));
			stdrewardbsdVO.setStdrewardbsVO(stdrewardbsVO);
			stdrewardbsdVO.setStdrewardVO(stdrewardVO);
//			if (stdrewardbsVO.getCitystd().floatValue() > ((StdrewardbsVO) delegate
//					.doCheck(stdrewardbsVO1, user)).getCitystd().floatValue()) {
//				throw new BusinessException("", "�й�˾����������׼Ӧ�ò�����ʡ��˾����������׼!");
//			} else if (stdrewardbsVO.getCountrystd().floatValue() > ((StdrewardbsVO) delegate
//					.doCheck(stdrewardbsVO1, user)).getCountrystd()
//					.floatValue()) {
//				throw new BusinessException("", "�й�˾�����н���׼Ӧ�ò�����ʡ��˾�����н���׼!");
//			} else {
				delegate.doUpdatestar(stdrewardbsdVO, user);
				BeanUtils.copyProperties(actionForm, stdrewardbsVO);
				BeanUtils.copyProperties(actionForm, stdrewardVO);// �Ѹ��º��ֵ����form������web��ʾ
				request
						.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
								"����ɹ�");
//			}
		} catch (Exception ex) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex
					.getMessage());
		}
		String str = request.getParameter("STR");
		return (actionMapping.findForward(str));
	}
	
	// �����й�˾�Ǽ�רҵ����׼
	public ActionForward doSavests(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		StdrewardbssDelegate delegate = new StdrewardbssDelegate();
		StdrewardbssVO stdrewardbssVO = new StdrewardbssVO();
		
		StdrewardVO stdrewardVO = new StdrewardVO();
		StdrewardbsVO stdrewardbsVO = new StdrewardbsVO();
		try {
			com.sunrise.boss.common.utils.bean.BeanUtils.copyProperties(
					stdrewardbssVO, actionForm);
			com.sunrise.boss.common.utils.bean.BeanUtils.copyProperties(
					stdrewardVO, actionForm);
			com.sunrise.boss.common.utils.bean.BeanUtils.copyProperties(
					stdrewardbsVO, actionForm);
			
			// ����ֵУ��	
			// ����רӪ����������ޣ�Ԫ��MPCITYSTD+���۴�����������ޣ�Ԫ��MPCITYSTD<=ʡ��˾���ñ����е�ǰ�Ǽ�����������
			if ((stdrewardbssVO.getMpcitystd()+stdrewardbssVO.getSecitystd()) > stdrewardbsVO.getCitystd()) {
				String message = "��ֵ���󣬺���רӪ�����������+���۴�����������޲��ܴ���"+stdrewardbsVO.getCitystd();
				BeanUtils.copyProperties(actionForm, stdrewardbsVO);
				BeanUtils.copyProperties(actionForm, stdrewardVO);
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
						message);
				String str = request.getParameter("STR");
				return (actionMapping.findForward(str));
			}
			
			// ���۴�����н����ޣ�Ԫ��MPCITYSTD+���۴�����н����ޣ�Ԫ��MPCITYSTD<=ʡ��˾���ñ����е�ǰ�Ǽ����н�����
			if ((stdrewardbssVO.getMpcountrystd()+stdrewardbssVO.getSecountrystd()) > stdrewardbsVO.getCountrystd()) {
				String message = "��ֵ���󣬺���רӪ����н�����+���۴�����н����޲��ܴ���"+stdrewardbsVO.getCountrystd();
				BeanUtils.copyProperties(actionForm, stdrewardbsVO);
				BeanUtils.copyProperties(actionForm, stdrewardVO);
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
						message);
				String str = request.getParameter("STR");
				return (actionMapping.findForward(str));
			}
			StdrewardbssListVO listvo = new StdrewardbssListVO();
			listvo.set_ne_rewardid(stdrewardbssVO.getRewardid().toString());
			listvo.set_se_region(stdrewardbssVO.getRegion());
			listvo.set_se_slv(stdrewardbssVO.getSlv());
			DataPackage dp = delegate.doQuery(listvo, user);
			if (dp == null || dp.getDatas().size()==0) {
				delegate.doCreate(stdrewardbssVO, user);
			} else {
				delegate.doUpdate(stdrewardbssVO, user);
			}	
			BeanUtils.copyProperties(actionForm, stdrewardbsVO);
			BeanUtils.copyProperties(actionForm, stdrewardVO);// �Ѹ��º��ֵ����form������web��ʾ
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
							"����ɹ�");
		} catch (Exception ex) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex
					.getMessage());
		}
		String str = request.getParameter("STR");
		return (actionMapping.findForward(str));
	}

	protected ActionForward doNew(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		setNewForm(actionForm);
		String command = getCommandString(request);
		((BaseActionForm) actionForm).setCmdState(command);
		request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,
				WebConstant.COMMAND_STRING_EDIT);
		String str = request.getParameter("str");
		request.getSession().removeAttribute("STARLIST");
		return (actionMapping.findForward(str));
	}

	protected ActionForward doDelete(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			String[] selectArray = ((StdrewardbsForm) actionForm)
					.get_selectitem();
			StdrewardbsDelegate delegate = new StdrewardbsDelegate();
			for (int i = 0; i < selectArray.length; i++) {

				StdrewardVO stdrewardvo = new StdrewardVO();
				stdrewardvo.setRewardid(new Long(selectArray[i]));
				if (selectArray[0].indexOf('|') == -1) { // ��һ����
					delegate.doRemove(stdrewardvo, user);
				}
			}
		} catch (Exception ex) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "ɾ��ʧ��:"
					+ ex.getMessage());
		}
		return doList(actionMapping, actionForm, request, response, user);
	}

	protected ActionForward doEdit(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		StdrewardbsForm form = (StdrewardbsForm)actionForm;
		String str = request.getParameter("str");
		try {
			StdrewardbsDelegate delegate = new StdrewardbsDelegate();
			StdrewardbsdVO stdrewardbsdVO = new StdrewardbsdVO();
			StdrewardbsVO stdrewardbsVO = new StdrewardbsVO();
			
			V_StdrewardbsVO unionVO=new V_StdrewardbsVO();
			
			stdrewardbsVO.setIslimt(new Short((short) 1));
			StdrewardVO stdrewardVO = new StdrewardVO();
			String pk = request.getParameter("PK");
			stdrewardbsVO.setRewardid(new Long(pk));
			stdrewardVO.setRewardid(new Long(pk));
			if ("content1".equals(str)) {
				StdrewardbsListVO listvo = new StdrewardbsListVO();
				listvo.set_ne_rewardid(pk.toString());
				listvo.set_se_region(user.getCityid());
				listvo.set_ne_islimt("1");

				DataPackage pack = new DataPackage();
				pack = delegate.doQuery(listvo, user);
				if (pack.getDatas().size() > 0) {
					//��ȡʡ������
					Iterator itt = pack.getDatas().iterator();
					StdrewardbsVO tmpvo = (StdrewardbsVO) itt.next();
					form.setProcitystd(tmpvo.getCitystd());
					form.setProcountrystd(tmpvo.getCountrystd());
					form.setProbasicsalenum(tmpvo.getBasicsalenum());
					form.setProtopsalenum(tmpvo.getTopsalenum());
					form.setProcitystdlow(tmpvo.getCitystd());
					form.setProcountrystdlow(tmpvo.getCountrystd());
					form.setProcitystdmid(tmpvo.getCitystd());   
					form.setProcountrystdmid(tmpvo.getCountrystd());
					form.setProcitystdtop(tmpvo.getCitystd());
					form.setProcountrystdtop(tmpvo.getCountrystd());
					
					listvo.set_ne_islimt("0");
					pack = delegate.doQuery(listvo, user);
					if (pack.getDatas().size() > 0) {
						stdrewardbsVO.setIslimt(new Short((short) 0));
					} else {
						stdrewardbsVO.setIslimt(new Short((short) 1));
					}
					stdrewardbsdVO.setStdrewardbsVO(stdrewardbsVO);
					stdrewardbsdVO.setStdrewardVO(stdrewardVO);
					stdrewardbsdVO = delegate.doFindByPkcity(stdrewardbsdVO,
							user);
					BeanUtils.copyProperties(actionForm, stdrewardbsdVO
							.getStdrewardVO());
					if (stdrewardbsdVO.getStdrewardbsVO() != null) {
						BeanUtils.copyProperties(actionForm, stdrewardbsdVO
								.getStdrewardbsVO());
					}
				} else {
					// start 20111128 add by liuchao ��������Ϣ����ʧ��
					stdrewardbsdVO.setStdrewardbsVO(stdrewardbsVO);
					stdrewardbsdVO.setStdrewardVO(stdrewardVO);
					
					stdrewardbsdVO.setUnionVO(unionVO);
					
					stdrewardbsdVO = delegate.doFindByPk(stdrewardbsdVO, user);
					BeanUtils.copyProperties(actionForm, stdrewardbsdVO
							.getStdrewardVO());
					if (stdrewardbsdVO.getStdrewardbsVO() != null) {
						BeanUtils.copyProperties(actionForm, stdrewardbsdVO
								.getStdrewardbsVO());
					}
					// end 20111128 add by liuchao ��������Ϣ����ʧ��
					throw new BusinessException("",
							"��ʡ��˾�Ǽ�����׼�У�û�����õı��й�˾�Ǽ�����׼������ϵʡ��˾�����Ա!");
				}
			} else if ("content2".equals(str)) {
				StdrewardbsListVO listvo = new StdrewardbsListVO();
				listvo.set_ne_rewardid(pk.toString());
				listvo.set_se_region(user.getCityid());
				listvo.set_ne_islimt("1");

				DataPackage pack = new DataPackage();
				pack = delegate.doQuery(listvo, user);
				if (pack.getDatas().size() > 0) {
					//��ȡʡ������
					Iterator itt = pack.getDatas().iterator();
					StdrewardbsVO tmpvo = (StdrewardbsVO) itt.next();
					form.setCitystd(tmpvo.getCitystd());
					form.setCountrystd(tmpvo.getCountrystd());
					// ȡ��רӪ����������ޣ��й�˾�������۳���н����ޣ��й�˾��
					StdrewardbssDelegate dgate = new StdrewardbssDelegate();
					StdrewardbssListVO listsvo = new StdrewardbssListVO();
					if (tmpvo.getRewardid() != null)
					listsvo.set_ne_rewardid(tmpvo.getRewardid().toString());// ����ʶ
					listsvo.set_se_region(tmpvo.getRegion());// ����
					listsvo.set_se_slv(tmpvo.getSlv());// �Ǽ�
					DataPackage dp = new DataPackage();
					dp = dgate.doQuery(listsvo, user);
					if (dp.getDatas().size() > 0) {
						Iterator ttd = dp.getDatas().iterator();
						StdrewardbssVO tmpsvo = (StdrewardbssVO) ttd.next();
						// ����רӪ����������ޣ�Ԫ��
						form.setMpcitystd(tmpsvo.getMpcitystd());
						// ����רӪ����н����ޣ�Ԫ��
						form.setMpcountrystd(tmpsvo.getMpcountrystd());
						// ���۴�����������ޣ�Ԫ��
						form.setSecitystd(tmpsvo.getSecitystd());
						// ���۴�����н����ޣ�Ԫ��
						form.setSecountrystd(tmpsvo.getSecountrystd());
						// ����רӪ������·ݣ��£�
						if (tmpsvo.getMpintvmonth() != null)
						form.setMpintvmonth(tmpsvo.getMpintvmonth().toString());
						// ���۴�������·ݣ��£�
						if (tmpsvo.getSeintvmonth() != null) 
						form.setSeintvmonth(tmpsvo.getSeintvmonth().toString());
					}
					
					listvo.set_ne_islimt("0");
					pack = delegate.doQuery(listvo, user);
					if (pack.getDatas().size() > 0) {
						stdrewardbsVO.setIslimt(new Short((short) 0));
					} else {
						stdrewardbsVO.setIslimt(new Short((short) 1));
					}
					stdrewardbsdVO.setStdrewardbsVO(stdrewardbsVO);
					stdrewardbsdVO.setStdrewardVO(stdrewardVO);
					stdrewardbsdVO = delegate.doFindByPkcity(stdrewardbsdVO,
							user);
					BeanUtils.copyProperties(actionForm, stdrewardbsdVO
							.getStdrewardVO());
					if (stdrewardbsdVO.getStdrewardbsVO() != null) {
						BeanUtils.copyProperties(actionForm, stdrewardbsdVO
								.getStdrewardbsVO());
					}
				} else {
					// start 20111128 add by liuchao ��������Ϣ����ʧ��
					stdrewardbsdVO.setStdrewardbsVO(stdrewardbsVO);
					stdrewardbsdVO.setStdrewardVO(stdrewardVO);
					
					stdrewardbsdVO.setUnionVO(unionVO);
					
					stdrewardbsdVO = delegate.doFindByPk(stdrewardbsdVO, user);
					BeanUtils.copyProperties(actionForm, stdrewardbsdVO
							.getStdrewardVO());
					if (stdrewardbsdVO.getStdrewardbsVO() != null) {
						BeanUtils.copyProperties(actionForm, stdrewardbsdVO
								.getStdrewardbsVO());
					}
					// end 20111128 add by liuchao ��������Ϣ����ʧ��
					throw new BusinessException("",
							"��ʡ��˾�Ǽ�����׼�У�û�����õı��й�˾�Ǽ�����׼������ϵʡ��˾�����Ա!");
				}
			} else {
				stdrewardbsdVO.setStdrewardbsVO(stdrewardbsVO);
				stdrewardbsdVO.setStdrewardVO(stdrewardVO);
				
				stdrewardbsdVO.setUnionVO(unionVO);
				
				stdrewardbsdVO = delegate.doFindByPk(stdrewardbsdVO, user);
				BeanUtils.copyProperties(actionForm, stdrewardbsdVO
						.getStdrewardVO());
				if (stdrewardbsdVO.getStdrewardbsVO() != null) {
					BeanUtils.copyProperties(actionForm, stdrewardbsdVO
							.getStdrewardbsVO());
				}
				request.getSession().removeAttribute("STARLIST");
				DataPackage packlist = new DataPackage();
				DataPackage packlist1 = new DataPackage();
				List listvo = new ArrayList();
				List listvo1 = new ArrayList();
				packlist = stdrewardbsdVO.getPack();
				listvo = packlist.toList(V_StdrewardbsVO.class);
				Iterator ob = listvo.iterator();
				while (ob.hasNext()) {
					String strslv = null;
					StringBuffer str1 = new StringBuffer();
					V_StdrewardbsVO vo = (V_StdrewardbsVO) ob.next();
					strslv = vo.getSlv();
					for (int i = 0; i < strslv.length(); i++) {
						if ("1".equals(strslv.substring(i, i + 1))) {
							str1.append(i + 1 + "�Ǽ�" + ",");
						}
					}
					strslv = str1.toString();
					strslv = strslv.substring(0, strslv.lastIndexOf(","));
					vo.setSlvtc(strslv);
					// ȡ��רӪ����������ޣ��й�˾�������۳���н����ޣ��й�˾��
					StdrewardbssDelegate dgate = new StdrewardbssDelegate();
					StdrewardbssListVO listsvo = new StdrewardbssListVO();
					if (vo.getRewardid() != null)
					listsvo.set_ne_rewardid(vo.getRewardid().toString());// ����ʶ
					listsvo.set_se_region(vo.getRegion());// ����
					listsvo.set_se_slv(vo.getSlv());// �Ǽ�
					DataPackage dp = new DataPackage();
					dp = dgate.doQuery(listsvo, user);
					if (dp.getDatas().size() > 0) {
						Iterator ttd = dp.getDatas().iterator();
						StdrewardbssVO tmpsvo = (StdrewardbssVO) ttd.next();
						// רӪ����������ޣ��й�˾��
						if (tmpsvo.getMpcitystd() != null) {
							vo.setMpcitystd(tmpsvo.getMpcitystd());
						} else {
							vo.setMpcitystd(Double.valueOf("-1"));
						}
						// רӪ����н����ޣ��й�˾��
						if (tmpsvo.getMpcountrystd() != null) {
							vo.setMpcountrystd(tmpsvo.getMpcountrystd());
						} else {
							vo.setMpcountrystd(Double.valueOf("-1"));
						}
						// ���۳���������ޣ��й�˾��
						if (tmpsvo.getSecitystd() != null) {
							vo.setSecitystd(tmpsvo.getSecitystd());
						} else {
							vo.setSecitystd(Double.valueOf("-1"));
						}
						// ���۳���н����ޣ��й�˾��
						if (tmpsvo.getSecountrystd() != null) {
							vo.setSecountrystd(tmpsvo.getSecountrystd());
						} else {
							vo.setSecountrystd(Double.valueOf("-1"));
						}
					} else {
						vo.setMpcitystd(Double.valueOf("-1"));
						vo.setMpcountrystd(Double.valueOf("-1"));
						vo.setSecitystd(Double.valueOf("-1"));
						vo.setSecountrystd(Double.valueOf("-1"));
					}
					listvo1.add(vo);
				}
				packlist1.setDatas(listvo1);
				request.getSession().setAttribute("STARLIST", packlist1);
				request.setAttribute("STARLIST", packlist1);
			}
			String command = getCommandString(request);
			((BaseActionForm) actionForm).setCmdState(command);
			request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,
					WebConstant.COMMAND_STRING_EDIT);
			
		} catch (Exception ex) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ""
					+ ex.getMessage());
		}
		return (actionMapping.findForward(str));
	}

	public ActionForward doSavestar(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		StdrewardbsForm stdrewardbsForm = new StdrewardbsForm();
		try {
			com.sunrise.boss.common.utils.bean.BeanUtils.copyProperties(
					stdrewardbsForm, actionForm);
			List liststar = new ArrayList();
			DataPackage packstar = new DataPackage();
			packstar.setDatas(liststar);
			if (request.getSession().getAttribute("STARLIST") != null) {
				packstar = (DataPackage) request.getSession().getAttribute(
						"STARLIST");
				liststar = packstar.toList(StdrewardbsForm.class);
			}
			String str = null;
			StringBuffer str1 = new StringBuffer();
			str = stdrewardbsForm.getSlv();
			int flag = 0;
			for (int i = 0; i < str.length(); i++) {
				if ("1".equals(str.substring(i, i + 1))) {
					flag = 1;
					str1.append(i + 1 + "�Ǽ�" + ",");
				}
			}
			str = str1.toString();
			if(flag == 1) {
				str = str.substring(0, str.lastIndexOf(","));
			}
			stdrewardbsForm.setSlvtc(str);
			Iterator list = liststar.iterator();
			if (stdrewardbsForm.getRegion() == null
					|| "".equals(stdrewardbsForm.getRegion())) {
				// throw new BusinessException("", "ϵͳ���Ѿ�������ͬ����ļ�¼!");
			}
			while (list.hasNext()) {
				StdrewardbsForm ob = (StdrewardbsForm) list.next();
				if (ob.getRegion() != null
						&& ob.getRegion().equals(stdrewardbsForm.getRegion())) {
					request.getSession().setAttribute("STARLIST", packstar);
					request.setAttribute("STARLIST", packstar);
					throw new BusinessException("", "������ʶ�Ѵ��ڸ�������Ǽ����ޱ�׼!");
				}
			}

			// �ж�ͬһ�������Ƿ������ͬ���Ǽ�����
			List liststartmp = new ArrayList();
			StdrewardbsDelegate delegate = new StdrewardbsDelegate();
			DataPackage packstartmp = new DataPackage();
			String strtmp;
			strtmp = stdrewardbsForm.getSlv();
			//����listvo�Ĳ�ѯ����,�����ݿ��в��ҷǱ���ʶ�ı���������Ϊ1�ļ���
			StdrewardbsListVO listvotmp = new StdrewardbsListVO();
			listvotmp.set_ne_islimt("1");
			listvotmp.set_se_region(stdrewardbsForm.getRegion());
			if(stdrewardbsForm.getRewardid()!=null){
				listvotmp.set_snk_rewardid(stdrewardbsForm.getRewardid().toString());
			}
			packstartmp = delegate.doQuery(listvotmp, user);
			liststartmp = packstartmp.toList(StdrewardbsForm.class);
			
			int slv=Integer.valueOf(stdrewardbsForm.getSlv()).intValue();
			
			Iterator listtmp = liststartmp.iterator();
			if (strtmp != null) {
				while (listtmp.hasNext()) {
					StdrewardbsForm obtmp = (StdrewardbsForm) listtmp.next();
					slv += Integer.valueOf(obtmp.getSlv()).intValue();
					if (String.valueOf(slv).indexOf("2")!=-1) {
								request.getSession().setAttribute("STARLIST",
										packstar);
								request.setAttribute("STARLIST", packstar);
								throw new BusinessException("",
										"��ϵͳ��,����ʶΪ["+obtmp.getRewardid()+"]�ĸ������Ѿ�������ͬ��"+(int)(String.valueOf(slv).indexOf("2")+1)+"�Ǽ�����!");
					}
				}
			} 
			if (stdrewardbsForm.getRegion() != null
					&& !"".equals(stdrewardbsForm.getRegion())) {
				stdrewardbsForm.setCitystd2(new Double(-1.0));
				stdrewardbsForm.setCountrystd2(new Double(-1.0));
				liststar.add(stdrewardbsForm);
				packstar.setDatas(liststar);
				request.getSession().setAttribute("STARLIST", packstar);
				request.setAttribute("STARLIST", packstar);
			} else {
				packstar.setDatas(liststar);
				request.getSession().setAttribute("STARLIST", packstar);
				request.setAttribute("STARLIST", packstar);
			}
			com.sunrise.boss.common.utils.bean.BeanUtils.copyProperties(
					actionForm, stdrewardbsForm);
		} catch (Exception ex) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ""
					+ ex.getMessage());
		}
		return actionMapping.findForward("content");
	}

	public ActionForward doEditstar(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			StdrewardbsForm stdrewardbsForm = new StdrewardbsForm();
			StdrewardbsForm stdrewardbsForm1 = new StdrewardbsForm();
			com.sunrise.boss.common.utils.bean.BeanUtils.copyProperties(
					stdrewardbsForm, actionForm);
			com.sunrise.boss.common.utils.bean.BeanUtils.copyProperties(
					stdrewardbsForm1, actionForm);
			List liststar = new ArrayList();
			DataPackage packstart = new DataPackage();
			String pk = request.getParameter("PK");
			if (request.getSession().getAttribute("STARLIST") != null) {
				packstart = (DataPackage) request.getSession().getAttribute(
						"STARLIST");
				liststar = packstart.toList(StdrewardbsForm.class);
				Iterator star = liststar.iterator();
				while (star.hasNext()) {
					StdrewardbsForm ob = (StdrewardbsForm) star.next();
					if (ob.getRegion() != null && ob.getRegion().equals(pk)) {
						stdrewardbsForm = ob;
					}
				}
			}
			request.setAttribute("STARLIST", packstart);
			request.getSession().setAttribute("STARLIST", packstart);
			com.sunrise.boss.common.utils.bean.BeanUtils.copyProperties(
					actionForm, stdrewardbsForm);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return actionMapping.findForward("content");
	}

	public ActionForward doSavestarlist(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			StdrewardbsForm stdrewardbsForm = new StdrewardbsForm();
			com.sunrise.boss.common.utils.bean.BeanUtils.copyProperties(
					stdrewardbsForm, actionForm);
			if(stdrewardbsForm.getNeworedit()==null||stdrewardbsForm.getNeworedit().equals("NEW")){
				return this.doSavestar(actionMapping, actionForm, request, response, user);
			}
			List liststar = new ArrayList();
			List liststar1 = new ArrayList();
			String pk = request.getParameter("PK");
			DataPackage packstart = new DataPackage();
			Double citystd2=new Double(-1.0);
			Double countrystd2=new Double(-1.0);
			// רӪ����������ޣ��й�˾�������۳���н����ޣ��й�˾��
			Double mpcitystd=new Double(-1.0);
			Double mpcountrystd=new Double(-1.0);
			Double secitystd=new Double(-1.0);
			Double secountrystd=new Double(-1.0);
			if (request.getSession().getAttribute("STARLIST") != null) {
				packstart = (DataPackage) request.getSession().getAttribute(
						"STARLIST");
				liststar = packstart.toList(StdrewardbsForm.class);
				Iterator star = liststar.iterator();
				while (star.hasNext()) {
					StdrewardbsForm ob = (StdrewardbsForm) star.next();
					if (ob.getRegion() != null && ob.getRegion().equals(pk)) {
						//std2�ֶ�Ϊ��׼<std�ֶ�Ϊ���� ��¼�±�׼��ֵ
						if((ob.getCitystd2()!=null&&ob.getCitystd2().doubleValue()<=stdrewardbsForm.getCitystd().doubleValue())&&
								(ob.getCountrystd2()!=null&&ob.getCountrystd2().doubleValue()<=stdrewardbsForm.getCountrystd().doubleValue())){
							citystd2=ob.getCitystd2();
							countrystd2=ob.getCountrystd2();
							// רӪ����������ޣ��й�˾�������۳���н����ޣ��й�˾��
							mpcitystd=ob.getMpcitystd();
							mpcountrystd=ob.getMpcountrystd();
							secitystd=ob.getSecitystd();
							secountrystd=ob.getSecountrystd();
						}
						liststar1.add(ob);
					}
				}
			}
			Iterator it = liststar1.iterator();
			while (it.hasNext()) {
				liststar.remove(it.next());
			}
			String str = null;
			StringBuffer str1 = new StringBuffer();
			str = stdrewardbsForm.getSlv();
			for (int i = 0; i < str.length(); i++) {
				if ("1".equals(str.substring(i, i + 1))) {
					str1.append(i + 1 + "�Ǽ�" + ",");
				}
			}
			str = str1.toString();
			str = str.substring(0, str.lastIndexOf(","));
			stdrewardbsForm.setSlvtc(str);
			stdrewardbsForm.setRegion(pk);
			
			stdrewardbsForm.setCitystd2(citystd2);
			stdrewardbsForm.setCountrystd2(countrystd2);
			// רӪ����������ޣ��й�˾�������۳���н����ޣ��й�˾��
			stdrewardbsForm.setMpcitystd(mpcitystd);
			stdrewardbsForm.setMpcountrystd(mpcountrystd);
			stdrewardbsForm.setSecitystd(secitystd);
			stdrewardbsForm.setSecountrystd(secountrystd);
			
			liststar.add(stdrewardbsForm);
			packstart.setDatas(liststar);
			request.getSession().removeAttribute("STARLIST");
			request.setAttribute("STARLIST", packstart);
			request.getSession().setAttribute("STARLIST", packstart);
			com.sunrise.boss.common.utils.bean.BeanUtils.copyProperties(
					actionForm, stdrewardbsForm);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return actionMapping.findForward("content");
	}

	public ActionForward doDeletestar(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			StdrewardbsForm stdrewardbsForm = new StdrewardbsForm();
			com.sunrise.boss.common.utils.bean.BeanUtils.copyProperties(
					stdrewardbsForm, actionForm);
			List liststar = new ArrayList();
			List liststar1 = new ArrayList();
			DataPackage packstart = new DataPackage();
			String[] selectArray = ((StdrewardbsForm) actionForm)
					.get_selectitem();
			if (request.getSession().getAttribute("STARLIST") != null) {
				packstart = (DataPackage) request.getSession().getAttribute(
						"STARLIST");
				liststar = packstart.toList(StdrewardbsForm.class);
				for (int i = 0; i < selectArray.length; i++) {

					Iterator star = liststar.iterator();
					while (star.hasNext()) {
						StdrewardbsForm ob = (StdrewardbsForm) star.next();
						if (ob.getRegion() != null
								&& ob.getRegion().equals(selectArray[i])) {
							liststar1.add(ob);
						}
					}
				}
			}
			Iterator it = liststar1.iterator();
			while (it.hasNext()) {
				liststar.remove(it.next());
			}
			request.getSession().removeAttribute("STARLIST");
			packstart.setDatas(liststar);
			request.setAttribute("STARLIST", packstart);
			request.getSession().setAttribute("STARLIST", packstart);
			com.sunrise.boss.common.utils.bean.BeanUtils.copyProperties(
					actionForm, stdrewardbsForm);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return actionMapping.findForward("content");
	}
	
	public ActionForward doCheckdelete(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			boolean result=false;
			List liststar = new ArrayList();
			DataPackage packstart = new DataPackage();
			String[] selectArray = ((StdrewardbsForm) actionForm)
					.get_selectitem();
			if (request.getSession().getAttribute("STARLIST") != null) {
				packstart = (DataPackage) request.getSession().getAttribute(
						"STARLIST");
				liststar = packstart.toList(StdrewardbsForm.class);
				for (int i = 0; i < selectArray.length; i++) {

					Iterator star = liststar.iterator();
					while (star.hasNext()) {
						StdrewardbsForm ob = (StdrewardbsForm) star.next();
						if (ob.getRegion() != null
								&& ob.getRegion().equals(selectArray[i])) {
							if(ob.getCitystd2().doubleValue()!=-1.0&&ob.getCountrystd2().doubleValue()!=-1.0){
								result=true;
								break;
							}
						}
					}
				}
			}
			if(result && AAUtils.isAjaxRequest(request)){
				request.setAttribute("showfunction","<script>showmessage();</script>");
				AAUtils.addZonesToRefresh(request, "showerror");
			}else{
				doDeletestar(actionMapping, actionForm, request, response, user);
				AAUtils.addZonesToRefresh(request, "sessionlist");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return actionMapping.findForward("content");
	}
	
	// ��ѯ
   	public ActionForward doDetails(ActionMapping actionMapping,
   			ActionForm actionForm, HttpServletRequest request,
   			HttpServletResponse response, User user) throws Exception {
   		
   		List ruleitemlist=new ArrayList();
   		
//   		��ӵĲ���
   		RulerelDelegate rulerelDelegate=new RulerelDelegate();
//   		RulerelListVO rulerellistvo = new RulerelListVO();
//   		DataPackage dp2= rulerelDelegate.doQuery5(rulerellistvo, user);
   		RulerelListVO rulerellistvo = new RulerelListVO();
   		rulerellistvo.set_pagesize("");
   		rulerellistvo.set_se_ruleid("STAR_REWARD");
   		DataPackage dp2= rulerelDelegate.doQueryByRuleid(rulerellistvo, user);
//   		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
   		Iterator it = dp2.getDatas().iterator();
   		while(it.hasNext()){
   			RulerelVO vo=(RulerelVO)(it.next());
   			
   			ruleitemlist.add(vo.getRuleitemid());
   			
   			rulerellistvo.set_se_ruleitemid(vo.getRuleitemid());
   			rulerellistvo.set_se_ruleid(vo.getRuleid());
   			rulerellistvo.set_se_cityid(user.getCityid());
   			DataPackage dp3=rulerelDelegate.doQuery(rulerellistvo, user);
   			Iterator itor = dp3.getDatas().iterator();
   			if (itor.hasNext()) {
//   				RulerelVO vo=(RulerelVO)(itor.next());
   				String vvv = ((RulerelVO)(itor.next())).getParamer();
				if(!"".equals(vvv)&&null!=vvv){
					
//					System.out.println("======rr===="+vvv.trim()+"GGG");
					vo.setParamercityvalue(vvv.trim());
				}
   				vo.setIsSelected(new Short("1"));
   			}
   		}
   		Set ruleitemsetnew=new HashSet();
		for(int i=0;i<ruleitemlist.size();i++){
			Set set =new HashSet();
			RuleitemDelegate delegate =new RuleitemDelegate();
			RuleitemListVO listVO=new RuleitemListVO();
			listVO.set_pagesize("");
			listVO.set_se_ruleitemid((String)ruleitemlist.get(i));
			DataPackage ruleitemdp=delegate.doQuery(listVO, user);
			Iterator it1 = ruleitemdp.getDatas().iterator();
			if(it1.hasNext()){
				String vvv = ((RuleitemVO)(it1.next())).getVcityid();
				if(!"".equals(vvv)&&null!=vvv){
					String[] vcityid=vvv.trim().split("\\|");
					for(int j=0;j<vcityid.length;j++){
						set.add(vcityid[j]);
					}
				}
			}
			if(set.contains("999")||set.contains(user.getCityid())){
				ruleitemsetnew.add(ruleitemlist.get(i));
			}
			
		}
		DataPackage newdp=new DataPackage();
		
		Collection datas=new ArrayList();
		Iterator it3 = dp2.getDatas().iterator();
		while(it3.hasNext()){
			RulerelVO vo=(RulerelVO)(it3.next());
			if(ruleitemsetnew.contains(vo.getRuleitemid())){
				datas.add(vo);
			}
		}
		newdp.setDatas(datas);
		request.setAttribute("dp2", newdp);
   		
   		return (actionMapping.findForward("listdetails"));
   	}
   	
   	
	public ActionForward doSave2(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
//   		StdrewardutForm form=(StdrewardutForm)actionForm;
   		StdrewardbsForm form = (StdrewardbsForm)actionForm;
   		
   		String a=request.getParameter("a");
		String[] idAndValue=a.split(",");
		
		List list=new ArrayList();
		for(int i=0;i<idAndValue.length;i++){
			if(!"".equals(idAndValue[i]))
				list.add(idAndValue[i]);
				
		}
		
		RulerelDelegate rulerelDelegate = new RulerelDelegate();
		try {
			
			for (int i = 0; i <list.size(); i++) {
				
				//��ѯ"999"��paramer ,�м����ָ���"|",����Ĳ����Ƿ���ͬ���ĸ���
				RulerelListVO rulerelListVO1=new RulerelListVO();
				rulerelListVO1.set_pagesize("");
				rulerelListVO1.set_se_ruleid("STAR_REWARD");
				rulerelListVO1.set_se_cityid("999");
				String[] ss=list.get(i).toString().split(";");
				rulerelListVO1.set_se_ruleitemid(ss[0]);
				DataPackage dp2=rulerelDelegate.doQuery(rulerelListVO1,user);
				String sp1=((RulerelVO)dp2.getDatas().iterator().next()).getParamer();
				//���û����дֵ,ss�ĳ��Ⱦ���1,���뱨��
				if(ss.length==1){
					throw new Exception( ss[0] + "�Ĳ���ֵû����д!");
				}else{
					//˵����������û�в����Ͳ��ò��������ֵ�ڶ�Ӧ�ĵ��еĹ�����
					if(sp1!=null){
						String sp2=ss[1];
						int length1=StringUtils.splitPreserveAllTokens(sp1, "|").length;
						int length2=StringUtils.splitPreserveAllTokens(sp2, "|").length;
						if( length1!=length2|| !("".equals(StringUtils.splitPreserveAllTokens(sp2.trim(), "|")[length2-1]))  ){
////					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����Ĳ���ֵ������һ��,����Ҫ��'|'�ָ��ͽ�β!");
							throw new Exception( ss[0] + "����Ĳ���ֵ������һ��,����Ҫ��'|'�ָ��ͽ�β!");
							
						}
					}
				}
			}
			
		rulerelDelegate.doSave(list,"STAR_REWARD", user);
		
		
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����ɹ�");
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
		}
		
		return doDetails(actionMapping,actionForm, request,response,user);
	}
//		String ruleitemids[] = getRuleitemids(form); // ������ѡ��RULEITEMID
////		String paramervalues[] =getParamervalues(form); // �����ϵ�paramer
//		RulerelDelegate rulerelDelegate = new RulerelDelegate();
//		RulerelVO rulerelVO=null;
//		try {
//			for (int i = 0; i < ruleitemids.length; i++) {
//				rulerelVO=new RulerelVO();
//				rulerelVO.setRuleid("STAR_REWARD");
//				rulerelVO.setRulemodeid(Long.parseLong("0"));
//				rulerelVO.setCityid(user.getCityid());
//				rulerelVO.setRuleitemid(ruleitemids[i]);
//				
//				//��ѯ"999"��paramer ,�м����ָ���"|",����Ĳ����Ƿ���ͬ���ĸ���
//				RulerelListVO rulerelListVO1=new RulerelListVO();
//				rulerelListVO1.set_se_ruleid("STAR_REWARD");
//				rulerelListVO1.set_se_cityid("999");
//				rulerelListVO1.set_se_ruleitemid(ruleitemids[i]);
//				DataPackage dp2=rulerelDelegate.doQuery(rulerelListVO1, user);
//				String sp1="";
//				try {
//					sp1 = ((RulerelVO)dp2.getDatas().iterator().next()).getParamer();
//				} catch (RuntimeException e) {
//					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "ʡ��˾û�д������͵�ҵ��!");
//					return doDetails(actionMapping,actionForm, request,response,user);
//				}
//				String sp2=form.getParamervalues()[i];
//				if( StringUtils.splitPreserveAllTokens(sp1, "|").length!= StringUtils.splitPreserveAllTokens(sp2, "|").length||!("".equals(StringUtils.splitPreserveAllTokens(sp2, "|")[StringUtils.splitPreserveAllTokens(sp2, "|").length-1])) ){
//					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "��"+(i+1)+"������Ĳ���ֵ������һ��,����Ҫ��'|'�ָ�!");
//					return doDetails(actionMapping,actionForm, request,response,user);
//				}
//				
//				
//				rulerelVO.setParamer(form.getParamervalues()[i]);
//				
//				//��ѯ��û��,�о��޸�
//				RulerelListVO rulerelListVO=new RulerelListVO();
//				rulerelListVO.set_se_ruleid("STAR_REWARD");
//				rulerelListVO.set_se_cityid(user.getCityid());
//				rulerelListVO.set_ne_rulemodeid(Long.parseLong("0"));
//				rulerelListVO.set_se_ruleitemid(ruleitemids[i]);
//				DataPackage dp=rulerelDelegate.doQuery(rulerelListVO, user);
//				Iterator itor = dp.getDatas().iterator();
//				if (itor.hasNext()) {
//					rulerelVO.setParamer(form.getParamervalues()[i]);
//					rulerelDelegate.doUpdate2(rulerelVO, user);
//				}else{
//					rulerelDelegate.doCreate(rulerelVO, user);
//				}
//			}
//			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����ɹ�");
//		} catch (Exception e) {
//			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
//		}
//		
////		return (actionMapping.findForward("listdetails"));
//		return doDetails(actionMapping,actionForm, request,response,user);
//	}
	
   	/**
	 * ֻ����������ѡ�������
	 * 
	 * @param form
	 * @return
	 */
	private String[] getRuleitemids(StdrewardbsForm form) {
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
