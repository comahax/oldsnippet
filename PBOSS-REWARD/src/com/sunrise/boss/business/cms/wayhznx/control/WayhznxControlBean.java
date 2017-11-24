/**
* auto-generated code
* Thu Feb 12 09:35:58 CST 2009
*/
package com.sunrise.boss.business.cms.wayhznx.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.wayhznx.persistent.WayhznxVO;
import com.sunrise.boss.business.cms.wayhznx.persistent.WayhznxDAO;
import com.sunrise.boss.business.cms.wayhznx.persistent.WayhznxListVO;

/**
 * <p>Title: WayhznxControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/wayhznx/control/WayhznxControlBean"
 name="WayhznxControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class WayhznxControlBean extends AbstractControlBean
    implements WayhznxControl {

    public WayhznxVO doCreate(WayhznxVO vo, User user)
        throws Exception {
        try{
			WayhznxDAO dao = (WayhznxDAO) DAOFactory.build(WayhznxDAO.class, user);
            // TODO  set the pk */
            return (WayhznxVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(WayhznxVO vo, User user)
        throws Exception {
        try{
			WayhznxDAO dao = (WayhznxDAO) DAOFactory.build(WayhznxDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public WayhznxVO doUpdate(WayhznxVO vo, User user)
        throws Exception {
        try{
			WayhznxDAO dao = (WayhznxDAO) DAOFactory.build(WayhznxDAO.class, user);
            return (WayhznxVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public WayhznxVO doFindByPk(Serializable pk, User user)
        throws Exception {
			WayhznxDAO dao = (WayhznxDAO) DAOFactory.build(WayhznxDAO.class, user);
        return (WayhznxVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(WayhznxListVO params, User user)
        throws Exception {
			WayhznxDAO dao = (WayhznxDAO) DAOFactory.build(WayhznxDAO.class, user);
        return dao.query(params);
    }
	public DataPackage doQuery2(Object[] params, Class[] vo, String[][] joins,
			User user) throws Exception {
		// TODO Auto-generated method stub
		WayhznxDAO dao = (WayhznxDAO) DAOFactory.build(WayhznxDAO.class, user);
		return dao.query2(params, vo, joins);
	}
}
