/**
* auto-generated code
* Tue Oct 24 17:04:07 CST 2006
*/
package com.sunrise.boss.business.zifee.areagroupscalelog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.zifee.areagroupscalelog.persistent.AreaGroupScalelogVO;
import com.sunrise.boss.business.zifee.areagroupscalelog.persistent.AreaGroupScalelogDAO;
import com.sunrise.boss.business.zifee.areagroupscalelog.persistent.AreaGroupScalelogListVO;

/**
 * <p>Title: AreaGroupScalelogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/zifee/areagroupscalelog/control/AreaGroupScalelogControlBean"
 name="AreaGroupScalelogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class AreaGroupScalelogControlBean extends AbstractControlBean
    implements AreaGroupScalelogControl {

    public AreaGroupScalelogVO doCreate(AreaGroupScalelogVO vo, User user)
        throws Exception {
        try{
			AreaGroupScalelogDAO dao = (AreaGroupScalelogDAO) DAOFactory.build(AreaGroupScalelogDAO.class, user.getCityid());
            // TODO  set the pk */
            return (AreaGroupScalelogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(AreaGroupScalelogVO vo, User user)
        throws Exception {
        try{
			AreaGroupScalelogDAO dao = (AreaGroupScalelogDAO) DAOFactory.build(AreaGroupScalelogDAO.class, user.getCityid());
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public AreaGroupScalelogVO doUpdate(AreaGroupScalelogVO vo, User user)
        throws Exception {
        try{
			AreaGroupScalelogDAO dao = (AreaGroupScalelogDAO) DAOFactory.build(AreaGroupScalelogDAO.class, user.getCityid());
            return (AreaGroupScalelogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public AreaGroupScalelogVO doFindByPk(Serializable pk, User user)
        throws Exception {
			AreaGroupScalelogDAO dao = (AreaGroupScalelogDAO) DAOFactory.build(AreaGroupScalelogDAO.class, user.getCityid());
        return (AreaGroupScalelogVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(AreaGroupScalelogListVO params, User user)
        throws Exception {
			AreaGroupScalelogDAO dao = (AreaGroupScalelogDAO) DAOFactory.build(AreaGroupScalelogDAO.class, user.getCityid());
        return dao.query(params);
    }
}
