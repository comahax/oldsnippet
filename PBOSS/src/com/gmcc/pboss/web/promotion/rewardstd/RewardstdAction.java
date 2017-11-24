/**
 * auto-generated code
 * Mon Sep 14 16:39:35 CST 2009
 */
package com.gmcc.pboss.web.promotion.rewardstd;

import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.promotion.rewardstd.RewardstdDBParam;
import com.gmcc.pboss.business.promotion.rewardstd.RewardstdVO;
import com.gmcc.pboss.control.promotion.rewardstd.Rewardstd;
import com.gmcc.pboss.control.promotion.rewardstd.RewardstdBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.struts2.BaseAction;

/**
 * <p>Title: RewardstdAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public class RewardstdAction extends BaseAction {

	public RewardstdAction() {
		super();

		//���¼��������Ǳ����
		this.setForm(new RewardstdForm());
		this.setParam(new RewardstdWebParam());

		//ָ��VO��
		setClsVO(RewardstdVO.class);
		//ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
		this.pkNameArray = new String[] { "comcategory", "ruleid" };
		this.setClsControl(Rewardstd.class);
		this.setClsQueryParam(RewardstdDBParam.class);

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}

	public String doNew() throws Exception {
		RewardstdForm form = (RewardstdForm) getForm();
		form.setPid(new Long(ServletActionContext.getRequest()
				.getParameter("pk")));
		setCMD(WEB_CMD_NEW);
		return WEB_RESULT_CONTENT;
	}

	/**
	 * ��ѯ��Ӧ������ʶ�µĹ����ʶ����ļ�¼
	 */
	public String doList() throws Exception {
		try {
			RewardstdForm rform = (RewardstdForm) getForm();
			if (ServletActionContext.getRequest()
					.getParameter("pk") != null) {
				rform.setRuleid(new Long(ServletActionContext.getRequest()
						.getParameter("pk")));
				rform.setPid(new Long(ServletActionContext.getRequest()
						.getParameter("pk1")));
				rform.setIsEnabled(ServletActionContext.getRequest()
						.getParameter("isActive"));
			}
			RewardstdDBParam params = (RewardstdDBParam) this.getParam();
			RewardstdBO rbo = (RewardstdBO) BOFactory.build(RewardstdBO.class,
					getDBAccessUser());
			params.set_ne_ruleid(rform.getRuleid().toString());

			DataPackage rdp = rbo.doQuery(params);
			if (rdp != null && rdp.getDatas().size() > 0) {
				this.setDp(rdp);
				return "list";
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			setActionMessage(ex.getMessage());
		}
		return "list";
	}
	
	@Override
	public String doSave() throws Exception {
		RewardstdForm rform = (RewardstdForm) getForm();
		super.doSave();
		rform.setPid(new Long(ServletActionContext.getRequest()
				.getParameter("pk1")));
		return "content";
	}
	
	@Override
	public String doEdit() throws Exception {
		RewardstdForm rform = (RewardstdForm) getForm();
		RewardstdDBParam param = (RewardstdDBParam) getParam();
		super.doEdit();
		rform.setPid(new Long(param.getPid()));
		return "content";
	}
}