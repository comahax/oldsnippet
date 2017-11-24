package com.sunrise.boss.ui.commons.taglib.code2name.impl;



import java.io.Serializable;

import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.business.cms.waytype.persistent.WaytypeVO;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.delegate.cms.waytype.WaytypeDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.taglib.code2name.Code2name;

public class WayId2WayTypeName implements Code2name {

	public String translate(Object code, User user) throws Exception {
		WayDelegate waydelegate = new WayDelegate();
		WaytypeDelegate waytypedelegate = new WaytypeDelegate();
		WayVO vo = waydelegate.doFindByPk((Serializable)code,user);
		if(vo ==null) return "";
		WaytypeVO typevo =waytypedelegate.doFindByPk(vo.getWaytype(),user);
		if(typevo == null) return "";
		 return typevo.getWaytypename();
	
	}
	
}
