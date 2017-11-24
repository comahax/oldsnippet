/**
 * auto-generated code
 * Mon Sep 14 14:22:16 CST 2009
 */
package com.gmcc.pboss.web.promotion.elmttmpl;

import com.gmcc.pboss.business.promotion.elmttmpl.ElmttmplDBParam;
import com.gmcc.pboss.business.promotion.elmttmpl.ElmttmplVO;
import com.gmcc.pboss.control.promotion.elmttmpl.Elmttmpl;
import com.gmcc.pboss.control.promotion.elmttmpl.ElmttmplBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.struts2.BaseAction;

/**
 * <p>
 * Title: ElmttmplAction
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
 * @author linli
 * @version 1.0
 */
public class ElmttmplAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ElmttmplAction() {
		super();

		// 以下几个方法是必须的
		this.setForm(new ElmttmplForm());
		this.setParam(new ElmttmplWebParam());

		// 指定VO类
		setClsVO(ElmttmplVO.class);
		// 指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
		this.pkNameArray = new String[] { "tmplid" };
		this.setClsControl(Elmttmpl.class);
		this.setClsQueryParam(ElmttmplDBParam.class);
	}

	/**
	 * 更新元素模版状态(失效/有效)
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doUpdate() throws Exception {
		try {
			ElmttmplForm form = (ElmttmplForm) this.getForm();
			Elmttmpl bo = (Elmttmpl) BOFactory.build(ElmttmplBO.class,
					getDBAccessUser());

			ElmttmplVO vo = bo.doFindByPk(form.getTmplid());
			if (vo != null) {
				// "1" 有效, "0" 失效
				if (vo.getState().equals("1")) {
					vo.setState("0");
				} else {
					vo.setState("1");
				}
				bo.doUpdate(vo);
			}
			return super.doList();
		} catch (Exception ex) {
			String msg = ex.getMessage();
			addActionError(msg);
			return ERROR;
		}
	}

	/**
	 * 保存
	 */
	public String doSave() throws Exception {
		ElmttmplForm form = (ElmttmplForm) this.getForm();

		String colinfo = form.getColumnsinfo();
		String regex = "^(((地市标识\\|)?)((渠道代码\\|)?)(商品种类\\|)?(资源标识\\|)?(业务量\\|)?)$";
		//正确格式为地市标识|渠道代码|商品种类|资源标识|业务量|有其中一项且仅出现一次
		if(!colinfo.matches(regex)){
			addActionError("字段信息至少要有 地市标识|渠道代码|商品种类|资源标识|业务量|中的一个或多个关键字,并以'半角竖线[ | ]'结束!");
			return "content";
		}
		return super.doSave();
	}
}