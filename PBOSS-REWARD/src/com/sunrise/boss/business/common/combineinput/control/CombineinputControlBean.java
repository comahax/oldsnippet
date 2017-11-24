package com.sunrise.boss.business.common.combineinput.control;

import com.sunrise.boss.business.common.combineinput.persistent.CombineinputDAO;
import com.sunrise.boss.business.common.combineinput.persistent.CombineinputListVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: CombineinputControlBean </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: Sunrise Tech Ltd.</p>
 * @author Zhang Fengchao
 * @since 1.0
 * @version 1.0
 * @date 2007-11-19
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/common/combineinput/control/CombineinputControlBean"
 name="CombineinputControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class CombineinputControlBean extends AbstractControlBean implements
		CombineinputControl {
	public DataPackage queryAcctJoin(CombineinputListVO listVO, User user)
			throws Exception {
		CombineinputDAO dao = (CombineinputDAO) DAOFactory.build(CombineinputDAO.class, user);
		return dao.queryAcctJoin(listVO, user);
	}

	public DataPackage queryDictitem(CombineinputListVO listVO, User user) throws Exception {
		CombineinputDAO dao = (CombineinputDAO) DAOFactory.build(CombineinputDAO.class, user);
		return dao.queryDictitem(listVO, user);
	}
	public DataPackage queryByNamedSqlQuery(CombineinputListVO listVO,String sqlName, User user) throws Exception {
		CombineinputDAO dao = (CombineinputDAO) DAOFactory.build(CombineinputDAO.class, user);
		return dao.queryByNamedSqlQuery(listVO,sqlName ,user);
	}
}
