/**
* auto-generated code
* Thu Feb 12 09:39:32 CST 2009
*/
package com.sunrise.boss.business.cms.wayhzwg.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.wayhzwg.persistent.WayhzwgVO;
import com.sunrise.boss.business.cms.wayhzwg.persistent.WayhzwgDAO;
import com.sunrise.boss.business.cms.wayhzwg.persistent.WayhzwgListVO;

/**
 * <p>Title: WayhzwgControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/wayhzwg/control/WayhzwgControlBean"
 name="WayhzwgControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class WayhzwgControlBean extends AbstractControlBean
    implements WayhzwgControl {

    public WayhzwgVO doCreate(WayhzwgVO vo, User user)
        throws Exception {
        try{
			WayhzwgDAO dao = (WayhzwgDAO) DAOFactory.build(WayhzwgDAO.class, user);
            // TODO  set the pk */
            return (WayhzwgVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(WayhzwgVO vo, User user)
        throws Exception {
        try{
			WayhzwgDAO dao = (WayhzwgDAO) DAOFactory.build(WayhzwgDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public WayhzwgVO doUpdate(WayhzwgVO vo, User user)
        throws Exception {
        try{
			WayhzwgDAO dao = (WayhzwgDAO) DAOFactory.build(WayhzwgDAO.class, user);
            return (WayhzwgVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public WayhzwgVO doFindByPk(Serializable pk, User user)
        throws Exception {
			WayhzwgDAO dao = (WayhzwgDAO) DAOFactory.build(WayhzwgDAO.class, user);
        return (WayhzwgVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(WayhzwgListVO params, User user)
        throws Exception {
			WayhzwgDAO dao = (WayhzwgDAO) DAOFactory.build(WayhzwgDAO.class, user);
        return dao.query(params);
    }
}
