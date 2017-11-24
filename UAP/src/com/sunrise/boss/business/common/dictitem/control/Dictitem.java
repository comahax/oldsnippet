package com.sunrise.boss.business.common.dictitem.control;

import com.sunrise.jop.business.base.dictitem.DictitemDBParam;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

public interface Dictitem extends AbstractControl{

	public DataPackage doQuery(DictitemDBParam param,User user) throws Exception;
	
	
	public DataPackage doQueryDescription(String dictid,String groupid,User user) throws Exception;
	
}
