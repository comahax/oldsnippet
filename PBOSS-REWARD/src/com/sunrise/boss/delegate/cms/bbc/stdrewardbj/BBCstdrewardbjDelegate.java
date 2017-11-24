/**
* auto-generated code
* Tue Aug 26 20:17:18 CST 2008
*/
package com.sunrise.boss.delegate.cms.bbc.stdrewardbj;

import java.io.Serializable;
import java.util.List;

import com.sunrise.boss.business.cms.bbc.stdrewardbj.control.BBCstdrewardbjControl;
import com.sunrise.boss.business.cms.bbc.stdrewardbj.control.BBCstdrewardbjControlBean;
import com.sunrise.boss.business.cms.bbc.stdrewardbj.persistent.BBCstdrewardbjListVO;
import com.sunrise.boss.business.cms.bbc.stdrewardbj.persistent.BBCstdrewardbjVO;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: BBCstdrewardbjDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class BBCstdrewardbjDelegate {


	private static BBCstdrewardbjControl control;

	public BBCstdrewardbjDelegate() throws Exception {
		control = (BBCstdrewardbjControl) ControlFactory
				.build(BBCstdrewardbjControlBean.class);
		if (null == control) {
			throw new DelegateException(this.getClass() + " initialize failed");
		}
	}

	public BBCstdrewardbjVO doCreate(BBCstdrewardbjVO vo, User user) throws Exception {
		return control.doCreate(vo, user);
	}

	public void doRemove(BBCstdrewardbjVO vo, User user) throws Exception {
		control.doRemove(vo, user);
	}

	public BBCstdrewardbjVO doUpdate(BBCstdrewardbjVO vo, User user) throws Exception {
		return control.doUpdate(vo, user);
	}

	public BBCstdrewardbjVO doFindByPk(Serializable pk, User user)
			throws Exception {
		return (BBCstdrewardbjVO) control.doFindByPk(pk, user);
	}

	public DataPackage doQuery(BBCstdrewardbjListVO params, User user)
			throws Exception {
		return control.doQuery(params, user);
	}

	public void doSave(List list, User user) throws Exception {
		control.doSave(list, user);
	}

	public void doSavecity(List list, User user) throws Exception {
		control.doSavecity(list, user);
	}
}
