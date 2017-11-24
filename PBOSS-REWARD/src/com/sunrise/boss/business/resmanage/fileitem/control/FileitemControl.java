package com.sunrise.boss.business.resmanage.fileitem.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.resmanage.fileitem.persistent.FileitemVO;
import com.sunrise.boss.business.resmanage.fileitem.persistent.FileitemListVO;

import java.io.Serializable;

public interface FileitemControl extends AbstractControl {

	public FileitemVO doCreate(FileitemVO vo, User user) throws Exception;

	public void doRemove(FileitemVO vo, User user) throws Exception;

	public FileitemVO doUpdate(FileitemVO vo, User user) throws Exception;

	public FileitemVO doFindByPk(Serializable pk, User user) throws Exception;

	public DataPackage doQuery(FileitemListVO params, User user)
			throws Exception;

	public DataPackage doQuery(FileitemListVO params, User user,
			boolean getRcdCount) throws Exception;
}
