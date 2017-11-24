/**
* auto-generated code
* Sun Aug 01 20:25:48 CST 2010
*/
package com.sunrise.boss.business.cms.reward.vbusyxplan.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.vbusyxplan.persistent.VbusyxplanVO;
import com.sunrise.boss.business.cms.reward.vbusyxplan.persistent.VbusyxplanDAO;
import com.sunrise.boss.business.cms.reward.vbusyxplan.persistent.VbusyxplanListVO;

/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/reward/vbusyxplan/control/VbusyxplanControlBean"
 name="VbusyxplanControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class VbusyxplanControlBean extends AbstractControlBean
    implements VbusyxplanControl {

    public DataPackage doQuery(VbusyxplanListVO params, User user)
        throws Exception {
			VbusyxplanDAO dao = (VbusyxplanDAO) DAOFactory.build(VbusyxplanDAO.class, user);
        return dao.queryBusyxplan(params);
    }
}
