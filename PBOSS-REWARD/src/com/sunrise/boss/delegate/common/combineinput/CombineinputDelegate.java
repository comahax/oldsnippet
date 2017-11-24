package com.sunrise.boss.delegate.common.combineinput;

import com.sunrise.boss.business.common.combineinput.control.CombineinputControl;
import com.sunrise.boss.business.common.combineinput.control.CombineinputControlBean;
import com.sunrise.boss.business.common.combineinput.persistent.CombineinputListVO;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;

public class CombineinputDelegate {
	private CombineinputControl control;
	public static String SQL_QUERYJOIN = "boss.common.combineinput.queryOperationOption";

	public CombineinputDelegate() throws Exception {
		control = (CombineinputControl) ControlFactory
				.build(CombineinputControlBean.class);
		if (null == control) {
			throw new DelegateException(this.getClass() + " initialize failed");
		}
	}

	public DataPackage queryAcctJoin(CombineinputListVO listVO, User user)
			throws Exception {
		if (null == user) {
			throw new IllegalArgumentException();
		}

		return control.queryAcctJoin(listVO, user);
	}

	public DataPackage queryDictitem(CombineinputListVO listVO, User user)
			throws Exception {
		if (null == user) {
			throw new IllegalArgumentException();
		}

		return control.queryDictitem(listVO, user);
	}
	public DataPackage queryOperationOption(CombineinputListVO listVO, User user)
		throws Exception {
		if (null == user) {
			throw new IllegalArgumentException();
		}
		return control.queryByNamedSqlQuery(listVO, SQL_QUERYJOIN,user);
	}
	
}
