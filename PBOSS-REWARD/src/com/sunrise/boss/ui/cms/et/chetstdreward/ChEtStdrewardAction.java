/**
 * auto-generated code
 * Tue Jul 17 16:46:57 CST 2012
 */
package com.sunrise.boss.ui.cms.et.chetstdreward;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.et.chetstdreward.persistent.ChEtStdrewardListVO;
import com.sunrise.boss.business.cms.et.chetstdreward.persistent.ChEtStdrewardVO;
import com.sunrise.boss.business.cms.reward.ruleitem.persistent.RuleitemListVO;
import com.sunrise.boss.business.cms.reward.ruleitem.persistent.RuleitemVO;
import com.sunrise.boss.business.cms.reward.rulerel.persistent.RulerelListVO;
import com.sunrise.boss.business.cms.reward.rulerel.persistent.RulerelVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.cms.et.chetstdreward.ChEtStdrewardDelegate;
import com.sunrise.boss.delegate.cms.reward.ruleitem.RuleitemDelegate;
import com.sunrise.boss.delegate.cms.reward.rulerel.RulerelDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>
 * Title: ChEtStdrewardAction
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author liyanling
 * @version 1.0
 */
public class ChEtStdrewardAction extends BaseAction {
	public ChEtStdrewardAction() {
		setVoClass(ChEtStdrewardVO.class);
		// TODO: ������������������
		this.pkNameArray = new String[1];
		pkNameArray[0] = "seq";
	}

	public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			ChEtStdrewardDelegate chetstdrewarddelegate = new ChEtStdrewardDelegate();
			ChEtStdrewardForm form = (ChEtStdrewardForm) actionForm;
			form.set_pagesize("20");
			ChEtStdrewardListVO listVO = new ChEtStdrewardListVO();
			setListVO(listVO, form);
			List ninCityid = new ArrayList();
			ninCityid.add("999");
			if (listVO.get_ne_cityid() == null
					|| "".equals(listVO.get_ne_cityid())) {
				ninCityid.add(user.getCityid());
			} else {
				ninCityid.add(listVO.get_ne_cityid());
			}
			listVO.set_nin_cityid(ninCityid);
			listVO.set_ne_cityid(null);
			DataPackage pack = chetstdrewarddelegate.doQuery(listVO, user);
			if (null != ninCityid.get(1)) {
				form.set_ne_cityid(ninCityid.get(1).toString());
			}
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, pack);
			if (null == form.get_pageno() || "".equals(form.get_pageno())) {
				form.set_pageno(String.valueOf(pack.getPageNo()));
			}
			request.setAttribute("cityid", form.get_ne_cityid());
		} catch (BusinessException e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
		} catch (Exception e) {
			throw e;
		}
		return (actionMapping.findForward("list"));
	}

	public ActionForward doNew(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		// TODO Auto-generated method stub
		request.setAttribute("cityid", user.getCityid());
		return super.doNew(actionMapping, actionForm, request, response, user);
	}

	public ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		ChEtStdrewardForm form = (ChEtStdrewardForm) actionForm;
		form.setCityid(new Short(user.getCityid()));
		return super.doSave(actionMapping, actionForm, request, response, user);
	}

	// ��ת������ϸ������ҳ��
	public ActionForward doShowruledetail(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {

		String pk = "";
		if (request.getParameter("PK") == null) {
			pk = (String) request.getAttribute("PK");
		} else {
			pk = request.getParameter("PK");
		}
		List ruleitemlist = new ArrayList();

		// ��ӵĲ���
		RulerelDelegate rulerelDelegate = new RulerelDelegate();
		RulerelListVO rulerellistvo = new RulerelListVO();
		rulerellistvo.set_pagesize("");
		rulerellistvo.set_se_ruleid(pk);
		DataPackage dp2 = rulerelDelegate.doQueryByRuleid(rulerellistvo, user);
		Iterator it = dp2.getDatas().iterator();
		while (it.hasNext()) {
			RulerelVO vo = (RulerelVO) (it.next()); 
			ruleitemlist.add(vo.getRuleitemid()); 
			rulerellistvo.set_se_ruleitemid(vo.getRuleitemid());
			rulerellistvo.set_se_ruleid(vo.getRuleid());
			rulerellistvo.set_se_cityid(user.getCityid());
			DataPackage dp3 = rulerelDelegate.doQuery(rulerellistvo, user);
			Iterator itor = dp3.getDatas().iterator();
			if (itor.hasNext()) {
				String vvv = ((RulerelVO) (itor.next())).getParamer();
				if (!"".equals(vvv) && null != vvv) {
					vo.setParamercityvalue(vvv.trim());
				}
				vo.setIsSelected(new Short("1"));
			}
		}
		Set ruleitemsetnew = new HashSet();
		for (int i = 0; i < ruleitemlist.size(); i++) {
			Set set = new HashSet();
			RuleitemDelegate delegate = new RuleitemDelegate();
			RuleitemListVO listVO = new RuleitemListVO();
			listVO.set_pagesize("");
			listVO.set_se_ruleitemid((String) ruleitemlist.get(i));
			DataPackage ruleitemdp = delegate.doQuery(listVO, user);
			Iterator it1 = ruleitemdp.getDatas().iterator();
			if (it1.hasNext()) {
				String vvv = ((RuleitemVO) (it1.next())).getVcityid();
				if (!"".equals(vvv) && null != vvv) {
					String[] vcityid = vvv.trim().split("\\|");
				for (int j = 0; j < vcityid.length; j++) {
						set.add(vcityid[j]);
					}
				}
			}
			if (set.contains("999") || set.contains(user.getCityid())) {
				ruleitemsetnew.add(ruleitemlist.get(i));
			}

		}
		DataPackage newdp = new DataPackage(); 
		Collection datas = new ArrayList();
		Iterator it3 = dp2.getDatas().iterator();
		while (it3.hasNext()) {
			RulerelVO vo = (RulerelVO) (it3.next());
			if (ruleitemsetnew.contains(vo.getRuleitemid())) {
				datas.add(vo);
			}
		}
		newdp.setDatas(datas);
		request.setAttribute("dp2", newdp);

		request.setAttribute("PK", pk);

		return (actionMapping.findForward("listdeatil"));
	}

	// ����ruleid, ������,ÿһ����ͬ�Ĺ���ϸ��
	public ActionForward doSaveruledetail(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {

		String a = request.getParameter("a");
		String[] idAndValue = a.split(",");

		List list = new ArrayList();
		for (int i = 0; i < idAndValue.length; i++) {
			if (!"".equals(idAndValue[i]))
				list.add(idAndValue[i]);

		}
		String pk = (String) request.getParameter("PK");
		String[] pks = pk.split("\\|");

		RulerelDelegate rulerelDelegate = new RulerelDelegate();
		try {

			for (int i = 0; i < list.size(); i++) {

				// ��ѯ"999"��paramer ,�м����ָ���"|",����Ĳ����Ƿ���ͬ���ĸ���
				RulerelListVO rulerelListVO1 = new RulerelListVO();
				rulerelListVO1.set_pagesize("");
				rulerelListVO1.set_se_ruleid(pks[0]);
				rulerelListVO1.set_se_cityid("999");
				String[] ss = list.get(i).toString().split(";");
				rulerelListVO1.set_se_ruleitemid(ss[0]);
				DataPackage dp2 = rulerelDelegate.doQuery(rulerelListVO1, user);
				String sp1 = ((RulerelVO) dp2.getDatas().iterator().next())
						.getParamer();
				// ���û����дֵ,ss�ĳ��Ⱦ���1,���뱨��
				if (ss.length == 1) {
					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
							ss[0] + "�Ĳ���ֵû����д!");
					request.setAttribute("PK", request.getParameter("PK"));
					return doShowruledetail(actionMapping, actionForm, request,
							response, user);
				} else {
					// ˵����������û�в����Ͳ��ò��������ֵ�ڶ�Ӧ�ĵ��еĹ�����
					if (sp1 != null) {
						String sp2 = ss[1];
						int length1 = StringUtils.splitPreserveAllTokens(sp1,
								"|").length;
						int length2 = StringUtils.splitPreserveAllTokens(sp2,
								"|").length;
						if (length1 != length2
								|| !(""
										.equals(StringUtils
												.splitPreserveAllTokens(sp2
														.trim(), "|")[length2 - 1]))) {
							request.setAttribute(
									WebConstant.PAGE_ATTRIBUTE_MESSAGE, ss[0]
											+ "����Ĳ���ֵ������һ��,����Ҫ��'|'�ָ��ͽ�β!");
							request.setAttribute("PK", request
									.getParameter("PK"));
							return doShowruledetail(actionMapping, actionForm,
									request, response, user);

						}
					}
				}
			}
			rulerelDelegate.doSave(list, pks[0], user);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����ɹ�");
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
		}
		request.setAttribute("PK", request.getParameter("PK"));
		return doShowruledetail(actionMapping, actionForm, request, response,
				user);
	}

}
