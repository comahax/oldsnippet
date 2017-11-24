package com.sunrise.boss.ui.commons.taglib.code2name.impl;



import java.io.Serializable;

import com.sunrise.boss.business.cms.distribute.cooperator.persistent.CooperatorVO;
import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.business.cms.waytype.persistent.WaytypeVO;
import com.sunrise.boss.delegate.cms.distribute.cooperator.CooperatorDelegate;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.delegate.cms.waytype.WaytypeDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.taglib.code2name.Code2name;

public class CooperatorID2Name implements Code2name {

	public String translate(Object code, User user) throws Exception {
		CooperatorDelegate delegate = new CooperatorDelegate();
		CooperatorVO vo = delegate.doFindByPk((Serializable)code,user);
		if(vo ==null)
			return "";
		 return vo.getCooperaname();
	
	}
	
}
