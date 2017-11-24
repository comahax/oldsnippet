/**
 * auto-generated code
 * Thu Sep 17 15:16:11 CST 2009
 */
package com.gmcc.pboss.web.promotion.ppzlncom;

import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.promotion.ppzlncom.PpzlncomVO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.gmcc.pboss.business.promotion.ppzlncom.PpzlncomDBParam;
import com.gmcc.pboss.control.promotion.ppzlncom.Ppzlncom;
import com.gmcc.pboss.control.promotion.ppzlncom.PpzlncomBO;
import com.gmcc.pboss.web.promotion.ppzlncom.PpzlncomForm;

/**
 * <p>
 * Title: PpzlncomAction
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
public class PpzlncomAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PpzlncomAction() {
		super();

		// 以下几个方法是必须的
		this.setForm(new PpzlncomForm());
		this.setParam(new PpzlncomWebParam());

		// 指定VO类
		setClsVO(PpzlncomVO.class);
		// 指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
		this.pkNameArray = new String[] { "comcategory", "pid" };
		this.setClsControl(Ppzlncom.class);
		this.setClsQueryParam(PpzlncomDBParam.class);

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}

	/**
	 * 查询对应方案标识下的方案与商品关系数据
	 */
	public String doList() throws Exception {
		try {

			PpzlncomForm form = (PpzlncomForm) super.getForm();
			PpzlncomDBParam comparam = (PpzlncomDBParam) getParam();
			PpzlncomBO combo = (PpzlncomBO) BOFactory.build(PpzlncomBO.class,
					getDBAccessUser());
			if (form.getPid() == null) {
				form.setPid(new Long(ServletActionContext.getRequest()
						.getParameter("param._pk")));
				form.setIsEnabled(ServletActionContext.getRequest()
						.getParameter("isActive"));
			}

			comparam.set_se_pid(form.getPid().toString());
			DataPackage comdp = combo.doQuery(comparam);
			if (comdp != null && comdp.getDatas().size() > 0) {
				this.setDp(comdp);
				return "list";
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			super.addActionError(ex.getMessage());
		}
		return "list";
	}

	/**
	 * 保存对应方案标识下的方案与商品关系数据
	 */
	public String doSave() throws Exception {
		try {
			PpzlncomForm form = (PpzlncomForm) super.getForm();
			PpzlncomVO comvo = new PpzlncomVO();
			comvo.setComcategory(form.getComcategory());
			comvo.setPid(form.getPid());
		} catch (Exception ex) {
			ex.printStackTrace();
			super.addActionError(ex.getMessage());
		}
		return super.doSave();
	}

	@Override
	public String doNew() throws Exception {
		setCMD(WEB_CMD_NEW);
		return WEB_RESULT_CONTENT;
	}

	/**
	 * 删除对应方案标识下的方案与商品关系数据
	 */
	public String doDelete() throws Exception {
		try {

			String[] selectArray = ((DBQueryParam) getParam()).get_selectitem();
			PpzlncomForm form = (PpzlncomForm) super.getForm();
			PpzlncomBO combo = (PpzlncomBO) BOFactory.build(PpzlncomBO.class,
					getDBAccessUser());
			PpzlncomDBParam comparam = new PpzlncomDBParam();
			PpzlncomVO comvo = new PpzlncomVO();
			// 如果没有勾选记录, 记录将全部删除, 在页面用javascript控制
			if (selectArray == null) {
				comparam.set_pagesize("0");
				comparam.set_se_pid(form.getPid().toString());
				DataPackage comdp = combo.doQuery(comparam);
				if (comdp != null && comdp.getDatas().size() > 0) {
					int j = 0;
					for (j = 0; j < comdp.getDatas().size(); j++) {
						comvo = (PpzlncomVO) comdp.getDatas().get(j);
						combo.doRemoveByVO(comvo);
					}
					setActionMessage("记录已全部删除!");
				}
				return doList();
			}
			// 仅删除勾选的记录
			int i = 0;
			for (i = 0; i < selectArray.length; i++) {
				comvo.setPid(form.getPid());
				comvo.setComcategory(selectArray[i]);
				combo.doRemoveByVO(comvo);
			}
			setActionMessage("删除成功!");
			return doList();
		} catch (Exception ex) {
			ex.printStackTrace();
			super.addActionError(ex.getMessage());
		}
		return "list";
	}
}