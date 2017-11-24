package com.sunrise.boss.business.common.dictitem.control;

import com.sunrise.jop.business.base.dictitem.DictitemDAO;
import com.sunrise.jop.business.base.dictitem.DictitemDBParam;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

public class DictitemBO extends AbstractControlBean implements Dictitem{

	public DataPackage doQuery(DictitemDBParam param,User user) throws Exception 
	{
		DictitemDAO dao = (DictitemDAO)DAOFactory.build(DictitemDAO.class, user);
		return dao.query(param);
	}

	public DataPackage doQueryDescription(String dictid,String groupid, User user) throws Exception {
		DictitemDAO dao = (DictitemDAO)DAOFactory.build(DictitemDAO.class, user);
		DictitemDBParam param = new DictitemDBParam();
		param.getQueryConditions().put("dictid", dictid);
		param.getQueryConditions().put("groupid", groupid);
		param.setSelectFieldsString("dictid,dictname,description");
		DataPackage dp = dao.queryByNamedSqlQuery("queryDescription",param);
		return dp;
	}
}
