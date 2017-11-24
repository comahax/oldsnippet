package com.sunrise.boss.delegate.common.batchlog;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.business.common.batchlog.persistent.BatchlogVO;
import com.sunrise.boss.business.common.batchlog.persistent.BatchlogListVO;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.common.batchlog.control.BatchlogControl;
import com.sunrise.boss.business.common.batchlog.control.BatchlogControlBean;
import java.io.Serializable;

/**
 * @author liminghao
 * @version 1.0
 */
public class BatchlogDelegate {

	private static BatchlogControl control;

	public BatchlogDelegate() throws Exception {
		control = (BatchlogControl) ControlFactory
				.build(BatchlogControlBean.class);
		if (null == control) {
			throw new DelegateException(this.getClass() + " initialize failed");
		}
	}

	public BatchlogVO doCreate(BatchlogVO vo, User user) throws Exception {
		return control.doCreate(vo, user);
	}

	public void doRemove(BatchlogVO vo, User user) throws Exception {
		if (null == vo || null == user) {
			throw new IllegalArgumentException();
		} else {
			control.doRemove(vo, user);
		}
	}

	public BatchlogVO doUpdate(BatchlogVO vo, User user) throws Exception {
		return control.doUpdate(vo, user);
	}

	public BatchlogVO doFindByPk(Serializable pk, User user) throws Exception {
		return (BatchlogVO) control.doFindByPk(pk, user);
	}

	public DataPackage doQuery(BatchlogListVO params, User user)
			throws Exception {
		return control.doQuery(params, user);
	}
}
