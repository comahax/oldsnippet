package com.sunrise.boss.business.admin.code2name.control;

import java.util.Map;

import com.sunrise.boss.business.admin.code2name.persistent.Code2NameDAO;
import com.sunrise.boss.common.base.control.AbstractControlBean;

/**
* @ejb.bean
*    local-jndi-name="com/sunrise/boss/business/admin/code2name/control/Code2NameControlBean"
*    name="Code2NameControl"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class Code2NameControlBean extends AbstractControlBean implements
		Code2NameControl {

	public Object translateCode(String voName, String codeName,
			String nameName, Object codeValue, String dbFlag) throws Exception {
		// 这里比较特殊,Code2NameDAO没有继承BaseDAO，所以直接new一个DAO
		Code2NameDAO dao = new Code2NameDAO(dbFlag);
		return dao.translateCode(voName, codeName, nameName, codeValue);
	}

	public Map valueList(String voName, String codeName, String nameName, String dbFlag) throws Exception {
		// TODO Auto-generated method stub
		Code2NameDAO dao = new Code2NameDAO(dbFlag);
		return dao.valueList(voName, codeName, nameName );
	}

}
