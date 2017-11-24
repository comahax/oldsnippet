package com.gmcc.pboss.web.base.dictgroup;

import org.apache.commons.lang.ClassUtils;

import com.gmcc.pboss.business.base.dictgroup.DictgroupDBParam;
import com.gmcc.pboss.business.base.dictgroup.DictgroupVO;
import com.gmcc.pboss.control.base.dictgroup.Dictgroup;
import com.sunrise.jop.exception.system.ActionException;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.ui.struts2.BaseAction;

/**
 * <p>Title: DictgroupAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */

public class DictgroupAction extends BaseAction {

	public DictgroupAction() {
		super();

		this.setForm(new DictgroupForm());
		this.setParam(new DictgroupDBParam());

		setClsVO(DictgroupVO.class);

		this.pkNameArray = new String[1];
		pkNameArray[0] = "groupid";

		this.setClsControl(Dictgroup.class);
		this.setClsQueryParam(DictgroupDBParam.class);
	}

	public String doEdit() throws Exception {
		setForm(this.findVOFromDB());
		setCMD(WEB_CMD_EDIT);
		return "content";
	}

	protected BaseVO findVOFromDB() throws Exception {
		String pk = getParam().get_pk();
		if (pk == null)
			throw new ActionException("action.err.nullpk");
		BaseVO contentVO = null;
		if (!pk.trim().equalsIgnoreCase(""))
			if (pk.indexOf("|") == -1)
				contentVO = (BaseVO) executeDlgMethod(5, getSelectedPK(pk));
			else
				contentVO = (BaseVO) executeDlgMethod(5, getSelectedPkVO(pk));
		if (contentVO == null) {
			String param[] = { pk,
					ClassUtils.getShortClassName(getForm().getClass()) };
			throw new ActionException("action.err.recordnotfound", param, null);
		} else {
			return contentVO;
		}
	}

}
