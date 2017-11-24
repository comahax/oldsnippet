package com.sunrise.boss.business.resmanage.common.chkresduplicate.persistent;

import com.sunrise.boss.common.base.db.BaseDAO;

/**
 * 2.2.3.17 资源批量调拨重复性检查模块
 * 
 * @author David
 * 
 */
public class ChkResDuplicateDAO extends BaseDAO {

	public ChkResDuplicateDAO() {
		//因为voClass是动态的，这里先置为Object.class，获得DAO实例后再进行设置
		super(Object.class);
	}

}
