package com.sunrise.boss.business.resmanage.sheet.persistent;

import com.sunrise.boss.common.base.db.BaseDAO;

public class SheetDAO  extends BaseDAO {
	public SheetDAO(){
		super(SheetVO.class);
	}

	/**
	* ��ȡ��󹤵���
	*/
	public String getMaxSheetId() throws Exception {
		String val = (String)queryUniqueByNamedSqlQuery("maxSheetId", null ,String.class);
		return val;	
	}

}
