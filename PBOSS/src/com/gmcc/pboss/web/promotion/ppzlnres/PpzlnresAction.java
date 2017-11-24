/**
 * auto-generated code
 * Thu Sep 17 15:17:36 CST 2009
 */
package com.gmcc.pboss.web.promotion.ppzlnres;

import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.promotion.ppzlnres.PpzlnresDBParam;
import com.gmcc.pboss.business.promotion.ppzlnres.PpzlnresVO;
import com.gmcc.pboss.business.resource.comressmp.ComressmpDBParam;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.gmcc.pboss.control.promotion.ppzlnres.PpzlnresBO;
import com.gmcc.pboss.control.promotion.ppzlnres.Ppzlnres;
import com.gmcc.pboss.control.resource.comressmp.ComressmpBO;
import com.gmcc.pboss.web.promotion.ppzlnres.PpzlnresForm;

/**
 * <p>
 * Title: PpzlnresAction
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
public class PpzlnresAction extends BaseAction {

	public PpzlnresAction() {
		super();

		// 以下几个方法是必须的
		this.setForm(new PpzlnresForm());
		this.setParam(new PpzlnresWebParam());

		// 指定VO类
		setClsVO(PpzlnresVO.class);
		// 指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
		this.pkNameArray = new String[] { "pid", "resid" };
		this.setClsControl(Ppzlnres.class);
		this.setClsQueryParam(PpzlnresDBParam.class);

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}

	public String doNew() throws Exception {
		setCMD(WEB_CMD_NEW);
		return WEB_RESULT_CONTENT;
	}

	/**
	 * 查询对应方案标识下的方案与资源数据
	 */
	public String doList() throws Exception {
		try {

			PpzlnresForm form = (PpzlnresForm) getForm();
			PpzlnresDBParam resparam = (PpzlnresDBParam) getParam();
			PpzlnresBO resbo = (PpzlnresBO) BOFactory.build(PpzlnresBO.class,
					getDBAccessUser());
			String pid = ServletActionContext.getRequest().getParameter(
					"param._pk");
			String isenable = ServletActionContext.getRequest().getParameter(
			"isActive");
			if (form.getPid() == null) {
				form.setPid(new Long(pid));
				form.setIsEnabled(isenable);
			}

			resparam.set_ne_pid(form.getPid().toString());

			DataPackage resdp = resbo.doQueryComcategory(resparam);
			if (resdp != null && resdp.getDatas().size() > 0) {
				this.setDp(resdp);
				return "list";
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			super.addActionError(ex.getMessage());
		}
		return "list";
	}

	/**
	 * 删除对应方案标识下的方案与资源数据
	 */
	public String doDelete() throws Exception {
		PpzlnresForm form = (PpzlnresForm) getForm();
		String[] selectArray = ((DBQueryParam) getParam()).get_selectitem();
		PpzlnresVO resvo = new PpzlnresVO();
		PpzlnresBO resbo = (PpzlnresBO) BOFactory.build(PpzlnresBO.class,
				getDBAccessUser());
		PpzlnresDBParam resparam = (PpzlnresDBParam) getParam();
		try {
			//如果没有勾选记录, 记录将全部删除, 在页面用javascript控制
			if (selectArray == null) {
				resparam.setQueryAll(true);
				resparam.set_ne_pid(form.getPid().toString());
				DataPackage resdp = resbo.doQuery(resparam);
				if (resdp != null && resdp.getDatas().size() > 0) {
					for (int j = 0; j < resdp.getDatas().size(); j++) {
						resvo = (PpzlnresVO) resdp.getDatas().get(j);
						resbo.doRemoveByVO(resvo);
					}
					setActionMessage("记录已全部删除!");
				}
				return doList();
			}
			//仅删除已勾选的记录
			int i = 0;
			for (i = 0; i < selectArray.length; i++) {
				resvo.setPid(form.getPid());
				resvo.setResid(selectArray[i]);
				resbo.doRemoveByVO(resvo);
			}
			setActionMessage("删除成功!");
			return doList();
		} catch (Exception ex) {
			ex.printStackTrace();
			super.addActionError(ex.getMessage());
		}
		return "list";
	}
	
	@Override
	/**
	 * 保存-判断资源标识是否存在
	 */
	public String doSave() throws Exception {
		PpzlnresForm form = (PpzlnresForm) getForm();
		ComressmpBO bo = (ComressmpBO) BOFactory.build(ComressmpBO.class, getDBAccessUser());
		ComressmpDBParam param = new ComressmpDBParam();
		param.set_se_comresid(form.getResid());
		DataPackage dp = bo.doQuery(param);
		if(dp==null||dp.getDatas().size()==0){
			setActionMessage("录入的资源标识不存在!");
			this.setCMD(WEB_CMD_NEW);
			return "content";
		}
		return super.doSave();
	}
}