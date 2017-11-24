package com.sunrise.boss.ui.commons.taglib.code2name.impl;



import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.business.cms.distribute.cooperator.persistent.CooperatorVO;
import com.sunrise.boss.business.cms.fdauditdef.persistent.FdauditdefListVO;
import com.sunrise.boss.business.cms.fdauditdef.persistent.FdauditdefVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.cms.distribute.cooperator.CooperatorDelegate;
import com.sunrise.boss.delegate.cms.fdaudit.FdauditDelegate;
import com.sunrise.boss.delegate.cms.fdauditdef.FdauditdefDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.taglib.code2name.Code2name;


public class Fdauditfield2Name implements Code2name {

	public String translate(Object code, User user) throws Exception {
		FdauditdefDelegate delegate = new FdauditdefDelegate();
		FdauditdefListVO listVO=new FdauditdefListVO();
		String[] param=StringUtils.split(code.toString(),"//|");
		
		String tenp=param[0];
		listVO.set_se_typename(param[0]);
		listVO.set_se_field(param[1]);

		DataPackage pack=delegate.doQuery(listVO,user);
		if(pack==null || pack.getDatas().isEmpty())
			return param[1];
		List list=(List)pack.getDatas();
		
		FdauditdefVO vo=(FdauditdefVO)list.get(0);
		if(vo ==null || vo.getFieldchname()==null)
			return param[1];
		
		 return vo.getFieldchname();
	
	}
	
}
