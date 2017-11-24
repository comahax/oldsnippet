package com.sunrise.boss.business.common.combineinput.control;

import com.sunrise.boss.business.common.combineinput.persistent.CombineinputListVO;
import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

public interface CombineinputControl extends AbstractControl {
	public DataPackage queryDictitem(CombineinputListVO listVO, User user)
			throws Exception;

	public DataPackage queryAcctJoin(CombineinputListVO listVO, User user)
			throws Exception;
	
	public DataPackage queryByNamedSqlQuery(CombineinputListVO listVO,
			String sqlName, User user) throws Exception;
}
