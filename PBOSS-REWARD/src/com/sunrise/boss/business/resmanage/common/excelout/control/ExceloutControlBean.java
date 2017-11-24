package com.sunrise.boss.business.resmanage.common.excelout.control;

import java.sql.ResultSet;
import java.util.List;

import com.sunrise.boss.business.resmanage.common.excelout.ExceloutRet;
import com.sunrise.boss.business.resmanage.common.excelout.persistent.ExceloutDAO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.ui.commons.User;

/**
 * @ejb.bean local-jndi-name="com/sunrise/boss/business/resmanage/common/excelout/control/ExceloutControlBean"
 *           name="ExceloutControl" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class ExceloutControlBean extends AbstractControlBean implements
		ExceloutControl {
	public ExceloutRet doQuery(Object params, List queryFields,Class voClass,ResultSet rs,User user) throws Exception{
		ExceloutDAO dao = new ExceloutDAO(voClass,user);
		if (rs != null){
			return dao.getMoreDatas(queryFields, rs);
		}else {
			return dao.query(params, queryFields);
		}
	}
	
	public int count(Object params, Class voClass,User user) throws Exception{
		ExceloutDAO dao = new ExceloutDAO(voClass,user);
		return dao.count(params);
	}
}
