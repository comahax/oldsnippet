package com.sunrise.boss.ui.commons.taglib.code2name.impl;

import com.sunrise.boss.business.resmanage.com.persistent.ComVO;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.taglib.code2name.Code2name;

public class OtherComidOptions implements Code2name {
	
	public String translate(Object code, User user) throws Exception {
		CommonDelegate delegate = new CommonDelegate(ComVO.class);
		ComVO vo = (ComVO)delegate.doFindByPk(new Long(code.toString()),user);
		if(vo==null||vo.getComname()==null)
			return "";
		else 
			return vo.getComname();
	}
}
