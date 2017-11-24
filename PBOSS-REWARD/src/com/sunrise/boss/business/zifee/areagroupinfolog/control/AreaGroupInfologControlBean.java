/**
* auto-generated code
* Tue Oct 24 16:57:25 CST 2006
*/
package com.sunrise.boss.business.zifee.areagroupinfolog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.zifee.areagroupinfolog.persistent.AreaGroupInfologVO;
import com.sunrise.boss.business.zifee.areagroupinfolog.persistent.AreaGroupInfologDAO;
import com.sunrise.boss.business.zifee.areagroupinfolog.persistent.AreaGroupInfologListVO;

/**
 * <p>Title: AreaGroupInfologControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/zifee/areagroupinfolog/control/AreaGroupInfologControlBean"
 name="AreaGroupInfologControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class AreaGroupInfologControlBean extends AbstractControlBean
    implements AreaGroupInfologControl {

    public AreaGroupInfologVO doCreate(AreaGroupInfologVO vo, User user)
        throws Exception {
        try{
			AreaGroupInfologDAO dao = (AreaGroupInfologDAO) DAOFactory.build(AreaGroupInfologDAO.class, user.getCityid());
            // TODO  set the pk */
            return (AreaGroupInfologVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(AreaGroupInfologVO vo, User user)
        throws Exception {
        try{
			AreaGroupInfologDAO dao = (AreaGroupInfologDAO) DAOFactory.build(AreaGroupInfologDAO.class, user.getCityid());
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public AreaGroupInfologVO doUpdate(AreaGroupInfologVO vo, User user)
        throws Exception {
        try{
			AreaGroupInfologDAO dao = (AreaGroupInfologDAO) DAOFactory.build(AreaGroupInfologDAO.class, user.getCityid());
            return (AreaGroupInfologVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public AreaGroupInfologVO doFindByPk(Serializable pk, User user)
        throws Exception {
			AreaGroupInfologDAO dao = (AreaGroupInfologDAO) DAOFactory.build(AreaGroupInfologDAO.class, user.getCityid());
        return (AreaGroupInfologVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(AreaGroupInfologListVO params, User user)
        throws Exception {
			AreaGroupInfologDAO dao = (AreaGroupInfologDAO) DAOFactory.build(AreaGroupInfologDAO.class, user.getCityid());
        return dao.query(params);
    }
}
