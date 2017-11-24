package com.sunrise.boss.delegate.admin.purview;

import com.sunrise.boss.business.admin.purview.control.PurviewControl;
import com.sunrise.boss.business.admin.purview.control.PurviewControlBean;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.exception.delegate.DelegateException;

public class PurviewDelegate {
	private PurviewControl control;

	public PurviewDelegate() throws Exception {
		control = (PurviewControl) ControlFactory
				.build(PurviewControlBean.class);
		if (null == control) {
			throw new DelegateException(this.getClass() + " initialize failed");
		}
	}

	public boolean checkPurview(String operId, String PurviewId)
			throws Exception {
		return control.checkPurview(operId,PurviewId);
	}

}
