package com.sunrise.boss.delegate.resmanage.fileitem;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.resmanage.fileitem.persistent.FileitemVO;
import com.sunrise.boss.business.resmanage.fileitem.persistent.FileitemListVO;
import com.sunrise.boss.business.resmanage.fileitem.control.FileitemControlBean;
import com.sunrise.boss.business.resmanage.fileitem.control.FileitemControl;

import java.io.Serializable;

public class FileitemDelegate {

	private static FileitemControl control;

	public FileitemDelegate() throws Exception {
		control = (FileitemControl) ControlFactory
				.build(FileitemControlBean.class);
		if (null == control) {
			throw new DelegateException(this.getClass() + " initialize failed");
		}
	}

	public FileitemVO doCreate(FileitemVO vo, User user) throws Exception {
		return control.doCreate(vo, user);
	}

	public void doRemove(FileitemVO vo, User user) throws Exception {
		control.doRemove(vo, user);
	}

	public FileitemVO doUpdate(FileitemVO vo, User user) throws Exception {
		return control.doUpdate(vo, user);
	}

	public FileitemVO doFindByPk(Serializable pk, User user) throws Exception {
		return (FileitemVO) control.doFindByPk(pk, user);
	}

	public DataPackage doQuery(FileitemListVO params, User user)
			throws Exception {
		return control.doQuery(params, user);
	}

	public DataPackage doQuery(FileitemListVO params, User user,
			boolean getRcdCount) throws Exception {
		return control.doQuery(params, user, getRcdCount);
	}
}
