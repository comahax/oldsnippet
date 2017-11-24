package com.sunrise.boss.delegate.resmanage.common.chkresduplicate;

import com.sunrise.boss.business.resmanage.common.chkresduplicate.control.ChkResDuplicateControl;
import com.sunrise.boss.business.resmanage.common.chkresduplicate.control.ChkResDuplicateControlBean;
import com.sunrise.boss.business.resmanage.common.chkresduplicate.persistent.ChkResDuplicateVO;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.commons.User;

public class ChkResDuplicateDelegate extends CommonDelegate {

	private ChkResDuplicateControl control;

	public ChkResDuplicateDelegate() throws Exception {
		control = (ChkResDuplicateControl) ControlFactory
				.build(ChkResDuplicateControlBean.class);
		if (null == control) {
			throw new DelegateException(this.getClass() + " initialize failed");
		}
	}

	public int doChkResDupl(ChkResDuplicateVO vo, User user) throws Exception {
		return control.doChkResDupl(vo, user);
	}
}
