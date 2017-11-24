/**
 * auto-generated code
 * Wed Sep 10 11:22:49 CST 2008
 */
package com.sunrise.boss.ui.cms.reward.rulerel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ajaxanywhere.AAUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.reward.ruleexp.persistent.RuleexpListVO;
import com.sunrise.boss.business.cms.reward.ruleexp.persistent.RuleexpVO;
import com.sunrise.boss.business.cms.reward.ruleitem.persistent.RuleitemListVO;
import com.sunrise.boss.business.cms.reward.ruleitemrl.persistent.RuleitemrlListVO;
import com.sunrise.boss.business.cms.reward.ruleitemrl.persistent.RuleitemrlVO;
import com.sunrise.boss.business.cms.reward.rulerel.persistent.RulerelListVO;
import com.sunrise.boss.business.cms.reward.rulerel.persistent.RulerelVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.cms.reward.ruleexp.RuleexpDelegate;
import com.sunrise.boss.delegate.cms.reward.ruleitemrl.RuleitemrlDelegate;
import com.sunrise.boss.delegate.cms.reward.rulerel.RulerelDelegate;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>
 * Title: RulerelAction
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
public class RulerelAction extends BaseDelegateAction {
	public RulerelAction() {
		// ���¼��������Ǳ����
		// ָ��VO��
		setVoClass(RulerelVO.class);
		// ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
		this.pkNameArray = new String[4];
		pkNameArray[0] = "cityid";
		pkNameArray[1] = "ruleid";
		pkNameArray[2] = "ruleitemid";
		pkNameArray[3] = "rulemodeid";
	}

	public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		RulerelForm form = (RulerelForm) actionForm;
		// String ruleitemids[]=form.getRuleitemids(); //������ѡ��RULEITEMID
		// Page.setPageSize(request,form);
		
		// start ����Ruleexp��
		RuleexpListVO expListvo = new RuleexpListVO();
		setListVO(expListvo, form);
		expListvo.set_ne_state("1");
		expListvo.set_ne_rulemodeid(form.getRulemodeid()==null?null:form.getRulemodeid().toString());
		RuleexpDelegate expDelegate = new RuleexpDelegate();
		DataPackage expDp = expDelegate.doQuery(expListvo, user);
		if(expDp.getDatas().size() != 0){
			RuleexpVO vo =  (RuleexpVO) expDp.toList(RuleexpVO.class).get(0);
			form.setRuleitemexp(vo.getRuleitemexp());
			form.setRemark(vo.getRemark());
			form.setHasRuleexp(true);
		}else{
			form.setHasRuleexp(false);
		}// end
		
		String settype = form.get_se_cityid();
		RulerelDelegate rulerelDelegate = new RulerelDelegate();
		RuleitemrlDelegate ruleitemrlDelegate = new RuleitemrlDelegate();
		RulerelListVO params1 = new RulerelListVO();
		setListVO(params1, form); // ���ú�listVO����Ϊ��ѯ����
		params1.set_se_cityid("999");
		// params1.set_se_ruleid(form.get_se_ruleid());
		RuleitemListVO params2 = new RuleitemListVO();
		setListVO(params2, form); // ���ú�listVO����Ϊ��ѯ����
		// ����
		if (form.get_orderby().equals("ruleitemname")) {
			params2.set_orderby("ruleitemname");
			params1.set_orderby(null);
		}
		// params2.set_desc(form.get_desc());
		params2.set_pagesize("0");
		// params1.set_pagesize("0");

		// ����RULEITEM
		DataPackage pack = (DataPackage) rulerelDelegate.doQuery2(params1,
				params2, user);

		if (settype.equals("999")) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, pack);
			return (actionMapping.findForward("list"));

		} else {
			List allRulerels = (List) pack.getDatas();
			for (Iterator it0 = allRulerels.iterator(); it0.hasNext();) {
				Object[] object = (Object[]) it0.next();
				RulerelVO rulerel = (RulerelVO) object[0];
				try {
					findRuleItemRlConflict(form.get_se_ruleid(), rulerel
							.getRuleitemid(), user);
				} catch (Exception e) {
					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
							.getMessage());
					request.setAttribute("INVALID", "false");
					return (actionMapping.findForward("list2"));
				}
			}

			params1.set_se_cityid(form.get_se_cityid());
			params1.set_ne_rulemodeid(form.getRulemodeid());
			// ����RULEITEM
			DataPackage pack2 = (DataPackage) rulerelDelegate.doQuery(params1,
					user);
			// Iterator cityRulerels=pack2.getDatas().iterator();
			List cityRulerels = (List) pack2.getDatas();

			// ��������
			List list = new ArrayList();
			for (Iterator it1 = allRulerels.iterator(); it1.hasNext();) {
				Object[] object = (Object[]) it1.next();
				RulerelVO allrulerel = (RulerelVO) object[0];
				boolean contain = false;
				for (Iterator it0 = cityRulerels.iterator(); it0.hasNext();) {
					RulerelVO cityrulerel = (RulerelVO) it0.next();
					if (allrulerel.getRuleitemid().equals(
							cityrulerel.getRuleitemid())) {
						allrulerel.setChecked("Checked");
						contain = true;
						break;
					}
				}
				if (contain) {
					list.add(object);
				} else {
					if (!allrulerel.getState().toString().equals("0")) {
						list.add(object);
					}
				}
			}
			// ������
			for (Iterator it1 = list.iterator(); it1.hasNext();) {
				Object[] object = (Object[]) it1.next();
				RulerelVO allrulerel = (RulerelVO) object[0];
				// boolean contain=false;
				for (Iterator it0 = cityRulerels.iterator(); it0.hasNext();) {
					RulerelVO cityrulerel = (RulerelVO) it0.next();
					DataPackage pack3 = ruleitemrlDelegate
							.doQueryRuleItemRlTypeChain(allrulerel.getRuleid(),
									cityrulerel.getRuleitemid(), Short
											.parseShort("0"), user);
					List list3 = (List) pack3.getDatas();
					for (Iterator it2 = list3.iterator(); it2.hasNext();) {
						Object[] object1 = (Object[]) it2.next();
						String tempid1 = object1[0].toString();
						if (!cityrulerel.getRuleitemid().equals(tempid1)) {
							if (tempid1.equals(allrulerel.getRuleitemid())) {
								allrulerel.setDisabled("Disabled");
							}
						}
					}
				}
			}

			pack.setDatas(list);
			pack.setRowCount(list.size());
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, pack);
			if (AAUtils.isAjaxRequest(request)) {
				AAUtils.addZonesToRefresh(request, "zoneCityRule");
			}
			return (actionMapping.findForward("list2"));
		}
	}

	/**
	 * ruleitemid ������ѡ���RULEITEM
	 */
	private void doSelectRuleItem(String ruleid, String ruleitemid, List list,
			User user) throws Exception {
		RuleitemrlDelegate ruleitemrlDelegate = new RuleitemrlDelegate();
		DataPackage pack3 = ruleitemrlDelegate.doQueryRuleItemRlIsleaderChain(
				ruleid, ruleitemid, Short.parseShort("1"), Short
						.parseShort("1"), user);
		List isleader = (List) pack3.getDatas();
		for (Iterator it1 = isleader.iterator(); it1.hasNext();) {
			Object[] object = (Object[]) it1.next();
			String tempid = object[0].toString();
			for (Iterator it2 = list.iterator(); it2.hasNext();) {
				Object[] object2 = (Object[]) it2.next();
				RulerelVO temprulerel = (RulerelVO) object2[0];
				if (tempid.equals(temprulerel.getRuleitemid())) {
					temprulerel.setChecked("Checked");
					// continue;
				}
			}
		}
		if (!isleader.isEmpty()) {
			for (Iterator it1 = isleader.iterator(); it1.hasNext();) {
				Object[] object = (Object[]) it1.next();
				String tempid = object[0].toString();
				DataPackage pack4 = ruleitemrlDelegate
						.doQueryRuleItemRlTypeChain(ruleid, tempid, Short
								.parseShort("0"), user);
				List mutex = (List) pack4.getDatas();
				for (Iterator it = mutex.iterator(); it.hasNext();) {
					Object[] object1 = (Object[]) it.next();
					String tempid1 = object1[0].toString();
					if (tempid1.equals(tempid)) {
						continue;
					}
					for (Iterator it2 = list.iterator(); it2.hasNext();) {
						Object[] object2 = (Object[]) it2.next();
						RulerelVO temprulerel = (RulerelVO) object2[0];
						if (tempid1.equals(temprulerel.getRuleitemid())) {
							temprulerel.setDisabled("Disabled");
						}
					}
				}
			}
		} else {
			DataPackage pack4 = ruleitemrlDelegate.doQueryRuleItemRlTypeChain(
					ruleid, ruleitemid, Short.parseShort("0"), user);
			List mutex = (List) pack4.getDatas();
			for (Iterator it = mutex.iterator(); it.hasNext();) {
				Object[] object1 = (Object[]) it.next();
				String tempid1 = object1[0].toString();
				if (tempid1.equals(ruleitemid)) {
					continue;
				}
				for (Iterator it2 = list.iterator(); it2.hasNext();) {
					Object[] object2 = (Object[]) it2.next();
					RulerelVO temprulerel = (RulerelVO) object2[0];
					if (tempid1.equals(temprulerel.getRuleitemid())) {
						temprulerel.setDisabled("Disabled");
					}
				}
			}
		}
	}

	/**
	 * ���ҹ����ͻ,��rulerel�����
	 * @param ruleid
	 * @param ruleitemid
	 * @param user
	 * @throws Exception
	 */
	private void findRuleItemRlConflict(String ruleid, String ruleitemid,
			User user) throws Exception {
		RuleitemrlDelegate ruleitemrlDelegate = new RuleitemrlDelegate();
		// ����ָ�����͵�����
		List list0 = (List) ruleitemrlDelegate.doQueryRuleItemRlTypeChain(
				ruleid, ruleitemid, Short.parseShort("0"), user).getDatas();
		List list1 = (List) ruleitemrlDelegate.doQueryRuleItemRlTypeChain(
				ruleid, ruleitemid, Short.parseShort("1"), user).getDatas();
		RuleitemrlListVO ruleitemrlList = new RuleitemrlListVO();
		ruleitemrlList.set_se_ruleid(ruleid);
		ruleitemrlList.set_ne_rltype("0");
		ruleitemrlList.set_orderby("groupid");
		List list2 = (List) ruleitemrlDelegate.doQuery(ruleitemrlList, user)
				.getDatas();

		boolean first = false;
		boolean second = false;
		for (Iterator it1 = list1.iterator(); it1.hasNext();) {
			if (first && second) {
				break;
			}
			Object[] ruleitemrlvo1 = (Object[]) it1.next();
			String ruleitemid1 = ruleitemrlvo1[0].toString();

			for (Iterator it0 = list0.iterator(); it0.hasNext();) {
				Object[] ruleitemrlvo0 = (Object[]) it0.next();
				String ruleitemid0 = ruleitemrlvo0[0].toString();
				// String retype0=ruleitemrlvo0.getRltype().toString();
				if (ruleitemid1.equals(ruleitemid0)) {
					if (!first) {
						first = true;
					} else {
						second = true;
					}
				}
			}
		}
		if (first && second) {
			throw new Exception("������ϸ�����д��ڳ�ͻ");
		} else {
			first = false;
			second = false;
		}
		if (list2.isEmpty()) {
			return;
		}
		RuleitemrlVO outruleitemrl = (RuleitemrlVO) list2.get(0);
		String outgroupid = outruleitemrl.getGroupid().toString();
		for (Iterator it2 = list2.iterator(); it2.hasNext();) {
			if (first && second) {
				break;
			}
			RuleitemrlVO innerruleitem = (RuleitemrlVO) it2.next();
			String innergroupid = innerruleitem.getGroupid().toString();
			String innerruleitemid = innerruleitem.getRuleitemid();
			if (!innergroupid.equals(outgroupid)) {
				first = false;
				second = false;
				outgroupid = innergroupid;
			}
			for (Iterator it1 = list1.iterator(); it1.hasNext();) {
				if (first && second) {
					break;
				}
				Object[] ruleitemrlvo1 = (Object[]) it1.next();
				String ruleitemid1 = ruleitemrlvo1[0].toString();
				if (ruleitemid1.equals(innerruleitemid)) {
					if (!first) {
						first = true;
					} else {
						second = true;
					}
				}

			}
		}
		if (first && second) {
			throw new Exception("������ϸ�����д��ڳ�ͻ");
		}
	}

	// �����Ƿ���ѡ��
	public boolean ruleItemSelected(String[] ruleitems, String ruleitem) {
		if (ruleitems == null || ruleitems.length == 0) {
			return false;
		}
		for (int i = 0; i < ruleitems.length; i++) {
			if (ruleitems[i].equals(ruleitem)) {
				return true;
			}
		}
		return false;
	}

	protected ActionForward doEdit(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		super.doEdit(actionMapping, actionForm, request, response, user);
		return (actionMapping.findForward("editstate"));
	}

	/**
	 * @deprecated �÷����Ѿ�����
	 */
	protected ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		RulerelForm form = (RulerelForm) actionForm;
		RulerelDelegate delegate = new RulerelDelegate();
		RulerelVO vo = new RulerelVO();
		setSaveVO(vo, form);
		delegate.doUpdate(vo, user);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����ɹ�!");
		return (actionMapping.findForward("editstate"));
	}

	public ActionForward doSave2(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		RulerelForm form = (RulerelForm) actionForm;
		try {
			RulerelDelegate rulerelDelegate = new RulerelDelegate();
			//�Ƚ�rulerel֮��Ĵ�С
			List relList = rulerelDelegate.doCheckRulerelOrder(form.get_se_ruleid(), user);
			
			int selfRewardtype = 0;
			String selfRewardruleid = form.get_se_ruleid();
			for(Iterator itt = relList.iterator(); itt.hasNext(); ){
				Object[] obj = (Object[]) itt.next();
				if(selfRewardruleid.equals(obj[0])){
					selfRewardtype = ((Integer)obj[1]).intValue();
				}
			}
			
			if(selfRewardtype == 4 || selfRewardtype == 6){ //���ڽ�������ʱ�������ж�
				StringBuffer sb = new StringBuffer();
				for(Iterator itt = relList.iterator(); itt.hasNext(); ){
					Object[] obj = (Object[]) itt.next();
					if(selfRewardtype > ((Integer)obj[1]).intValue()){
						RulerelListVO listvo = new RulerelListVO();
						listvo.set_se_ruleid((String)obj[0]);
						listvo.set_se_cityid(user.getCityid());
						DataPackage dp = rulerelDelegate.doQuery(listvo, user);
						if(dp == null || dp.getDatas().size() == 0){
							sb.append(obj[0]).append(",");
						}
					}
				}
				if(!StringUtils.isEmpty(sb.toString())){
					throw new Exception("��������"+sb.substring(0, sb.length()-1)+"����Ĺ�����ϸ!");
				}
			}
			
			String ruleitemids[] = getRuleitemids(form); // ������ѡ��RULEITEMID
			RulerelListVO params1 = new RulerelListVO();
			setListVO(params1, form); // ���ú�listVO����Ϊ��ѯ����
			params1.set_se_cityid(user.getCityid());
			params1.set_se_ruleid(form.get_se_ruleid());
			params1.set_ne_rulemodeid(form.getRulemodeid());
			// params1.set_pagesize("0");
			// params1.set_se_ruleitemid(ruleitemids[i]);

			List list = (List) rulerelDelegate.doQuery(params1, user)
					.getDatas();
			if (!list.isEmpty()) {
				for (Iterator it = list.iterator(); it.hasNext();) {
					RulerelVO rulerelVO = (RulerelVO) it.next();
					rulerelDelegate.doRemove(rulerelVO, user);
				}
			}
			for (int i = 0; i < ruleitemids.length; i++) {
				params1 = new RulerelListVO();
				params1.set_se_cityid("999");
				params1.set_se_ruleid(form.get_se_ruleid());
				params1.set_se_ruleitemid(ruleitemids[i]);
				List list1 = (List) rulerelDelegate.doQuery(params1, user)
						.getDatas();
				RulerelVO rulerelVO = (RulerelVO) list1.get(0);
				rulerelVO.setCityid(user.getCityid());
				rulerelVO.setRulemodeid(form.getRulemodeid());
				rulerelDelegate.doCreate(rulerelVO, user);
			}
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����ɹ�");
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
		}
		return doList(actionMapping, actionForm, request, response, user);
	}

	/**
	 * ѡ��RuleItem
	 * 
	 */

	public ActionForward doCheckruleitem(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		RulerelForm form = (RulerelForm) actionForm;
		String ruleitemids[] = getRuleitemids(form); // ������ѡ��RULEITEMID
		// Page.setPageSize(request,form);

		String settype = form.get_se_cityid();
		RulerelDelegate rulerelDelegate = new RulerelDelegate();
		RulerelListVO params1 = new RulerelListVO();
		setListVO(params1, form); // ���ú�listVO����Ϊ��ѯ����
		params1.set_se_cityid("999");
		// params1.set_se_ruleid(form.get_se_ruleid());
		RuleitemListVO params2 = new RuleitemListVO();
		setListVO(params2, form); // ���ú�listVO����Ϊ��ѯ����
		// ����
		if (form.get_orderby().equals("ruleitemname")) {
			params2.set_orderby("ruleitemname");
			params1.set_orderby(null);
		}
		// params2.set_desc(form.get_desc());
		// params2.set_pagesize("0");
		// params1.set_pagesize("0");
		// ����RULEITEM
		DataPackage pack = (DataPackage) rulerelDelegate.doQuery2(params1,
				params2, user);

		if (settype.equals("999")) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, pack);
			return (actionMapping.findForward("list"));

		} else {
			params1.set_se_cityid(form.get_se_cityid());
			// ����RULEITEM
			DataPackage pack2 = (DataPackage) rulerelDelegate.doQuery(params1,
					user);
			List cityRulerels = (List) pack2.getDatas();

			List allRulerels = (List) pack.getDatas();
			List list = new ArrayList();

			for (Iterator it1 = allRulerels.iterator(); it1.hasNext();) {
				Object[] object = (Object[]) it1.next();
				RulerelVO allrulerel = (RulerelVO) object[0];
				boolean contain = false;
				for (Iterator it0 = cityRulerels.iterator(); it0.hasNext();) {
					RulerelVO cityrulerel = (RulerelVO) it0.next();
					if (allrulerel.getRuleitemid().equals(
							cityrulerel.getRuleitemid())) {
						allrulerel.setChecked("Checked");
						contain = true;
						break;
					}
				}
				if (contain) {
					list.add(object);
				} else {
					if (!allrulerel.getState().toString().equals("0")) {
						list.add(object);
					}
				}
			}

			for (Iterator it1 = list.iterator(); it1.hasNext();) {
				Object[] object = (Object[]) it1.next();
				RulerelVO allrulerel = (RulerelVO) object[0];
				allrulerel.setChecked("");
				allrulerel.setDisabled("");
				// boolean contain=false;
				for (int i = 0; i < ruleitemids.length; i++) {
					// RulerelVO cityrulerel=(RulerelVO)cityRulerels.next();
					if (allrulerel.getState().toString().equals("0")) {
						if (ruleItemSelected(ruleitemids, allrulerel
								.getRuleitemid())) {
							allrulerel.setChecked("Checked");
						} else {
							allrulerel.setDisabled("Disabled");
						}
					} else {
						if (allrulerel.getRuleitemid().equals(ruleitemids[i])) {
							allrulerel.setChecked("Checked");
						}
					}
				}
			}

			for (int i = 0; i < ruleitemids.length; i++) {
				doSelectRuleItem(form.get_se_ruleid(), ruleitemids[i], list,
						user);

			}
			pack.setDatas(list);
			pack.setRowCount(list.size());
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, pack);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, null);

			if (AAUtils.isAjaxRequest(request)) {
				AAUtils.addZonesToRefresh(request, "zoneCityRule");
			}
			// if (AAUtils.isAjaxRequest(request)) {
			// AAUtils.addZonesToRefresh(request, "zoneCityRule1");
			// }
		}
		return (actionMapping.findForward("list2"));
	}

	/**
	 * ���RuleItem
	 * 
	 */

	public ActionForward doCancelruleitem(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		RulerelForm form = (RulerelForm) actionForm;

		String allruleitemids[] = getAllRuleitemids(form);
		String ruleitemids[] = getRuleitemids(form); // ������ѡ��RULEITEMID
		// Page.setPageSize(request,form);
		// for(int i=0;i<ruleitemids.length;i++){
		// / try{
		// findRuleItemRlConflict(form.get_se_ruleid(),ruleitemids[i],user);
		// }catch(Exception e){
		// request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
		// e.getMessage());
		// if (AAUtils.isAjaxRequest(request)) {
		// AAUtils.addZonesToRefresh(request, "zoneCityRule1");
		// }
		// return (actionMapping.findForward("list2"));
		// }
		// }

		String settype = form.get_se_cityid();
		RulerelDelegate rulerelDelegate = new RulerelDelegate();
		RulerelListVO params1 = new RulerelListVO();
		setListVO(params1, form); // ���ú�listVO����Ϊ��ѯ����
		params1.set_se_cityid("999");
		// params1.set_se_ruleid(form.get_se_ruleid());
		RuleitemListVO params2 = new RuleitemListVO();
		setListVO(params2, form); // ���ú�listVO����Ϊ��ѯ����
		// ����
		if (form.get_orderby().equals("ruleitemname")) {
			params2.set_orderby("ruleitemname");
			params1.set_orderby(null);
		}
		// ����RULEITEM
		DataPackage pack = (DataPackage) rulerelDelegate.doQuery2(params1,
				params2, user);

		if (settype.equals("999")) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, pack);
			return (actionMapping.findForward("list"));

		} else {
			params1.set_se_cityid(form.get_se_cityid());
			// ����RULEITEM
			DataPackage pack2 = (DataPackage) rulerelDelegate.doQuery(params1,
					user);
			List cityRulerels = (List) pack2.getDatas();

			List allRulerels = (List) pack.getDatas();
			List list = new ArrayList();

			// 1 ��ʼ��������ѡ������

			for (Iterator it1 = allRulerels.iterator(); it1.hasNext();) {
				Object[] object = (Object[]) it1.next();
				RulerelVO allrulerel = (RulerelVO) object[0];
				boolean contain = false;
				for (Iterator it0 = cityRulerels.iterator(); it0.hasNext();) {
					RulerelVO cityrulerel = (RulerelVO) it0.next();
					if (allrulerel.getRuleitemid().equals(
							cityrulerel.getRuleitemid())) {
						allrulerel.setChecked("Checked");
						contain = true;
						break;
					}
				}
				if (contain) {
					list.add(object);
				} else {
					if (!allrulerel.getState().toString().equals("0")) {
						list.add(object);
					}
				}
			}

			for (Iterator it1 = list.iterator(); it1.hasNext();) {
				Object[] object = (Object[]) it1.next();
				RulerelVO allrulerel = (RulerelVO) object[0];
				allrulerel.setChecked("");
				allrulerel.setDisabled("");
				// boolean contain=false;
				for (int i = 0; i < ruleitemids.length; i++) {
					// RulerelVO cityrulerel=(RulerelVO)cityRulerels.next();
					if (allrulerel.getState().toString().equals("0")) {
						if (ruleItemSelected(ruleitemids, allrulerel
								.getRuleitemid())) {
							allrulerel.setChecked("Checked");
						} else {
							allrulerel.setDisabled("Disabled");
						}
					} else {
						if (allrulerel.getRuleitemid().equals(ruleitemids[i])) {
							allrulerel.setChecked("Checked");
						}
					}
				}
			}

			// while(allRulerels.hasNext()){
			// Object[] object=(Object[])allRulerels.next();
			// RulerelVO allrulerel=(RulerelVO)object[0];
			// boolean contain=false;
			// for(int i=0;i<ruleitemids.length;i++){
			// //RulerelVO cityrulerel=(RulerelVO)cityRulerels.next();
			// if(allrulerel.getRuleitemid().equals(ruleitemids[i])){
			// if(allrulerel.getState().equals("0")){ //0 ��Ч 1 ��Ч
			// //�������û��ѡʧЧ��Item ������Ϊ��Checked�� ���ڡ�Disabled��
			// if(ruleItemSelected(ruleitemids,allrulerel.getRuleitemid())){
			// allrulerel.setChecked("Checked");
			// }else{
			// allrulerel.setDisabled("Disabled");
			// }
			// }else{
			// allrulerel.setChecked("Checked");
			// }
			// contain=true;
			// break;
			// }
			// }
			//				
			// if(contain){
			// list.add(object);
			// }else{
			// if(!allrulerel.getState().toString().equals("0")){
			// list.add(object);
			// }
			// }
			// }
			// 1 ��ԭ����
			for (int i = 0; i < allruleitemids.length; i++) {
				doSelectRuleItem(form.get_se_ruleid(), allruleitemids[i], list,
						user);
			}

			// 2 �����ϵ
			RuleitemrlDelegate ruleitemrlDelegate = new RuleitemrlDelegate();
			// for(int i=0;i<ruleitemids.length;i++){
			// �������
			DataPackage pack3 = ruleitemrlDelegate
					.doQueryRuleItemRlIsleaderChain(form.get_se_ruleid(), form
							.getRuleitemid(), Short.parseShort("1"), Short
							.parseShort("1"), user);
			List isleader = (List) pack3.getDatas();
			for (Iterator it1 = isleader.iterator(); it1.hasNext();) {
				Object[] object = (Object[]) it1.next();
				String tempid = object[0].toString();
				for (Iterator it2 = list.iterator(); it2.hasNext();) {
					Object[] object2 = (Object[]) it2.next();
					RulerelVO temprulerel = (RulerelVO) object2[0];
					if (tempid.equals(temprulerel.getRuleitemid())) {
						temprulerel.setChecked("");
						// continue;
					}
				}
			}

			// �ͷŻ��⣨���ⲻ���������뱻����
			if (!isleader.isEmpty()) {
				for (Iterator it1 = isleader.iterator(); it1.hasNext();) {
					Object[] object = (Object[]) it1.next();
					String tempid = object[0].toString();
					DataPackage pack4 = ruleitemrlDelegate
							.doQueryRuleItemRlTypeChain(form.get_se_ruleid(),
									tempid, Short.parseShort("0"), user);
					List mutex = (List) pack4.getDatas();

					for (Iterator it = mutex.iterator(); it.hasNext();) {
						Object[] object1 = (Object[]) it.next();
						String tempid1 = object1[0].toString();
						if (tempid1.equals(tempid)) {
							continue; // ���ü����������涯���������
						}
						for (Iterator it2 = list.iterator(); it2.hasNext();) {
							Object[] object2 = (Object[]) it2.next();
							RulerelVO temprulerel = (RulerelVO) object2[0];
							if (tempid1.equals(temprulerel.getRuleitemid())) {
								temprulerel.setDisabled("");
							}
						}
					}
				}
			} else {

				DataPackage pack4 = ruleitemrlDelegate
						.doQueryRuleItemRlTypeChain(form.get_se_ruleid(), form
								.getRuleitemid(), Short.parseShort("0"), user);
				List mutex = (List) pack4.getDatas();

				for (Iterator it = mutex.iterator(); it.hasNext();) {
					Object[] object1 = (Object[]) it.next();
					String tempid1 = object1[0].toString();
					if (tempid1.equals(form.getRuleitemid())) {
						continue; // ���ü����������涯���������
					}
					for (Iterator it2 = list.iterator(); it2.hasNext();) {
						Object[] object2 = (Object[]) it2.next();
						RulerelVO temprulerel = (RulerelVO) object2[0];
						if (tempid1.equals(temprulerel.getRuleitemid())) {
							temprulerel.setDisabled("");
						}
					}
				}
			}
			pack.setDatas(list);
			pack.setRowCount(list.size());
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, pack);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, null);

			if (AAUtils.isAjaxRequest(request)) {
				AAUtils.addZonesToRefresh(request, "zoneCityRule");
			}
			// if (AAUtils.isAjaxRequest(request)) {
			// AAUtils.addZonesToRefresh(request, "zoneCityRule1");
			// }
		}
		return (actionMapping.findForward("list2"));
	}

	/**
	 * ֻ����������ѡ�������
	 * 
	 * @param form
	 * @return
	 */
	private String[] getRuleitemids(RulerelForm form) {
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

	/**
	 * ����������ѡ������ݺͱ������������
	 * 
	 * @param form
	 * @return
	 */
	private String[] getAllRuleitemids(RulerelForm form) {
		String[] ids = form.getRuleitemids();
		String[] ruleitemids = null;
		String ruleitemid = form.getRuleitemid();
		if (ids == null || ids.length == 0) {
			if (ruleitemid != null && !ruleitemid.equals("")) {
				ruleitemids = new String[1];
				ruleitemids[0] = ruleitemid;
				return ruleitemids;
			} else {
				return new String[0];
			}
		} else {
			if (ruleitemid != null && !ruleitemid.equals("")) {
				ruleitemids = new String[ids.length + 1];
			} else {
				ruleitemids = new String[ids.length];
			}
		}

		for (int i = 0; i < ids.length; i++) {
			String id = ids[i];
			String tempid[] = id.split("\\|");
			ruleitemids[i] = tempid[0];
		}
		if (ruleitemid != null && !ruleitemid.equals("")) {
			ruleitemids[ids.length] = ruleitemid;
		} else {
			ruleitemids[ids.length - 1] = ruleitemid;
		}
		return ruleitemids;
	}

}
