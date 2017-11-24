/**
 * auto-generated code
 * Thu Sep 17 15:12:35 CST 2009
 */
package com.gmcc.pboss.web.promotion.ppzlnrule;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.promotion.ppzlnrule.PpzlnruleDBParam;
import com.gmcc.pboss.business.promotion.ppzlnrule.PpzlnruleVO;
import com.gmcc.pboss.business.promotion.rule.RuleDBParam;
import com.gmcc.pboss.business.promotion.rule.RuleVO;
import com.gmcc.pboss.business.promotion.ruleitem.RuleitemDBParam;
import com.gmcc.pboss.business.promotion.ruleitem.RuleitemVO;
import com.gmcc.pboss.business.promotion.spproposal.SpproposalVO;
import com.gmcc.pboss.control.promotion.ppzlnrule.Ppzlnrule;
import com.gmcc.pboss.control.promotion.ppzlnrule.PpzlnruleBO;
import com.gmcc.pboss.control.promotion.rule.RuleBO;
import com.gmcc.pboss.control.promotion.ruleitem.RuleitemBO;
import com.gmcc.pboss.control.promotion.spproposal.SpproposalBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.struts2.BaseAction;

/**
 * <p>
 * Title: PpzlnruleAction
 * </p>;
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
 * @author
 * @version 1.0
 */
public class PpzlnruleAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PpzlnruleAction() {
		super();

		// ���¼��������Ǳ����
		this.setForm(new PpzlnruleForm());
		this.setParam(new PpzlnruleWebParam());

		// ָ��VO��
		setClsVO(PpzlnruleVO.class);
		// ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
		this.pkNameArray = new String[] { "pid", "ruleid" };
		this.setClsControl(Ppzlnrule.class);
		this.setClsQueryParam(PpzlnruleDBParam.class);

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}

	/**
	 * �����Ӧ������ʶ�µķ������������, ��ͬʱ���浽�����
	 */
	public String doSave() throws Exception {
		try {
			PpzlnruleForm form = (PpzlnruleForm) super.getForm();
			Long ppzlnpid = form.getPid();
			PpzlnruleBO ppzlnrulebo = (PpzlnruleBO) BOFactory.build(
					PpzlnruleBO.class, getDBAccessUser());
			SpproposalBO sppbo = (SpproposalBO) BOFactory.build(
					SpproposalBO.class, getDBAccessUser());
			SpproposalVO sppvo = new SpproposalVO();
			List<Long> ruleidlist = new ArrayList<Long>();
			List<String> prilist = new ArrayList<String>();
			RuleVO rulevo = new RuleVO();
			ruleidlist = ppzlnrulebo.doQueryPpzlnruleVo(ppzlnpid);
			if (!ruleidlist.isEmpty()) {
				RuleBO rulebo = (RuleBO) BOFactory.build(RuleBO.class,
						getDBAccessUser());
				RuleDBParam ruleparam = new RuleDBParam();

				ruleparam.set_sin_ruleid(ruleidlist);
				DataPackage ruledp = rulebo.doQuery(ruleparam);
				if (ruledp != null && ruledp.getDatas().size() > 0) {
					int i = 0;
					for (i = 0; i < ruledp.getDatas().size(); i++) {
						rulevo = (RuleVO) ruledp.getDatas().get(i);
						prilist.add(rulevo.getPri());
					}
				}
			}
			int j = 0;
			sppvo = sppbo.doFindByPk(form.getPid());
			if (sppvo != null) {
				if (sppvo.getPfrtmode().equals("0")) {
					for (j = 0; j < prilist.size(); j++) {
						if (form.getPri().equals(prilist.get(j).toString())) {
							setActionMessage("���Żݷ�ʽΪ[����]ʱ, ӵ�д����ȼ�"
									+ form.getPri()
									+ "���Ĺ����Ѵ���, ͬһ���������¶������ġ����ȼ�[PRI]����������ͬ!");
							return "content";
						}
					}
				} else {
					if (!form.getPri().equals("5")) {
						setActionMessage("���Żݷ�ʽΪ[����]ʱ, ��������ȼ���ӦΪ5��!");
						return "content";
					}
				}
			}
			String rulename = form.getRulename();
			String pri = form.getPri();
			String memo = form.getMemo();
			Long pid = form.getPid();
			//ͬһ����ͬʱ����
			ppzlnrulebo.doBatchSave(rulename, pri, memo, pid);
			setActionMessage("����ɹ�!");
			setCMD(WEB_CMD_SAVE);
		} catch (Exception e) {
			e.printStackTrace();
			setActionMessage(e.getMessage());
		}
		return "content";
	}

	/**
	 * ��ʾ�����������뷽������������¼
	 */
	public String doList() throws Exception {

		try {
			PpzlnruleForm form = (PpzlnruleForm) super.getForm();
			if (form.getPid() == null) {
				form.setPid(new Long(ServletActionContext.getRequest()
						.getParameter("param._pk")));
				form.setIsEnabled(ServletActionContext.getRequest()
						.getParameter("isActive"));
			}
			Long ppzlnpid = form.getPid();
			SpproposalBO sppbo = (SpproposalBO) BOFactory.build(
					SpproposalBO.class, getDBAccessUser());
			SpproposalVO sppvo = new SpproposalVO();
			RuleDBParam ruleparam = new RuleDBParam();
			RuleBO rulebo = (RuleBO) BOFactory.build(RuleBO.class,
					getDBAccessUser());
			List<Long> pidlist = new ArrayList<Long>();
			PpzlnruleBO ppzlnrulebo = (PpzlnruleBO) BOFactory.build(
					PpzlnruleBO.class, getDBAccessUser());
			PpzlnruleDBParam params = (PpzlnruleDBParam) this.getParam();
			DataPackage ruledp = null;
			if (StringUtils.isEmpty(params.getQueryRuleid())
					&& StringUtils.isEmpty(params.get_sk_rulename())) {

				pidlist = ppzlnrulebo.doQueryPpzlnruleVo(ppzlnpid);

				if (!pidlist.isEmpty()) {

					ruleparam.set_sin_ruleid(pidlist);
					ruledp = rulebo.doQuery(ruleparam);
					super.setDp(ruledp);

					sppvo = sppbo.doFindByPk(form.getPid());
					if (sppvo != null) {
						form.setPtype(sppvo.getPtype());
						form.setPfrtmode(sppvo.getPfrtmode());
					} else {
						setActionMessage("�޶�Ӧ������ʶ!");
						return "list";
					}
				} else {
					return "list";
				}
			} else if (!StringUtils.isEmpty(params.getQueryRuleid())
					&& StringUtils.isEmpty(params.get_sk_rulename())) {
				PpzlnruleDBParam ppzlparamss = new PpzlnruleDBParam();
				ppzlparamss.set_ne_pid(ppzlnpid.toString());
				ppzlparamss.set_ne_ruleid(params.getQueryRuleid());
				DataPackage dp = ppzlnrulebo.doQuery(ppzlparamss);
				if (dp != null && dp.getDatas().size() > 0) {
					ruleparam.set_ne_ruleid(params.getQueryRuleid());
					ruleparam.set_sk_rulename(params.get_sk_rulename());
					DataPackage dp1 = rulebo.doQuery(ruleparam);
					this.setDp(dp1);
					return "list";
				} else {
					return "list";
				}
			} else if (StringUtils.isEmpty(params.getQueryRuleid())
					&& !StringUtils.isEmpty(params.get_sk_rulename())) {

				pidlist = ppzlnrulebo.doQueryPpzlnruleVo(ppzlnpid);
				ruleparam.set_sin_ruleid(pidlist);
				ruleparam.set_sk_rulename(params.get_sk_rulename());
				ruledp = rulebo.doQuery(ruleparam);
				this.setDp(ruledp);
				return "list";

			} else if (!StringUtils.isEmpty(params.getQueryRuleid())
					&& !StringUtils.isEmpty(params.get_sk_rulename())) {
				PpzlnruleVO pvo = new PpzlnruleVO();
				pvo.setPid(ppzlnpid);
				pvo.setRuleid(new Long(params.getQueryRuleid()));
				PpzlnruleVO qpvo = ppzlnrulebo.doFindByPk(pvo);
				if (qpvo != null) {
					ruleparam.set_ne_ruleid(qpvo.getRuleid().toString());
					ruleparam.set_sk_rulename(params.get_sk_rulename());
					DataPackage dp1 = rulebo.doQuery(ruleparam);
					this.setDp(dp1);
					return "list";
				} else {
					return "list";
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			super.addActionError(ex.getMessage());
		}
		return "list";
	}

	@Override
	public String doNew() throws Exception {
		setCMD(WEB_CMD_NEW);
		return WEB_RESULT_CONTENT;
	}

	@Override
	/**
	 * ɾ�����������, ����, ������ϸ����
	 */
	public String doDelete() throws Exception {

		try {
			PpzlnruleForm form = (PpzlnruleForm) super.getForm();
			String[] selectArray = ((DBQueryParam) getParam()).get_selectitem();
			if (selectArray == null) {
				addActionError("�޷���ȡѡ����Ŀ��");
				return "list";
			}
			int i = 0;
			for (i = 0; i < selectArray.length; i++) {
				PpzlnruleDBParam ppzlnruleparam = new PpzlnruleDBParam();
				PpzlnruleVO ppzlnrulevo = new PpzlnruleVO();
				PpzlnruleBO ppzlnrulebo = (PpzlnruleBO) BOFactory.build(
						PpzlnruleBO.class, getDBAccessUser());
				SpproposalBO sppbo = (SpproposalBO) BOFactory.build(
						SpproposalBO.class, getDBAccessUser());
				RuleitemDBParam itemparam = new RuleitemDBParam();
				RuleitemBO itembo = (RuleitemBO) BOFactory.build(
						RuleitemBO.class, getDBAccessUser());
				RuleitemVO itemvo = new RuleitemVO();
				List<Long> itemidlist = new ArrayList<Long>();
				ppzlnruleparam.set_ne_pid(form.getPid().toString());
				ppzlnruleparam.set_ne_ruleid(selectArray[i]);
				itemparam.set_ne_ruleid(selectArray[i]);
				DataPackage ppzlnruledp = ppzlnrulebo.doQuery(ppzlnruleparam);
				DataPackage itemdp = itembo.doQuery(itemparam);
				if (ppzlnruledp != null && ppzlnruledp.getDatas().size() > 0) {
					ppzlnrulevo = (PpzlnruleVO) ppzlnruledp.getDatas().get(0);
					if(itemdp != null && itemdp.getDatas().size() > 0){
					for (int j = 0; j < itemdp.getDatas().size(); j++) {
						itemvo = (RuleitemVO) itemdp.getDatas().get(j);
						itemidlist.add(new Long(itemvo.getItemid()));
						}
					}
					Long pid = ppzlnrulevo.getPid();
					Long ruleid = ppzlnrulevo.getRuleid();
					sppbo.doBatchRuleDelete(ruleid);
					ppzlnrulebo.doDeleteRule(ruleid, pid, itemidlist);
					setActionMessage("�����ɹ�!");
				
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			super.addActionError(ex.getMessage());
		}
		return doList();
	}
}