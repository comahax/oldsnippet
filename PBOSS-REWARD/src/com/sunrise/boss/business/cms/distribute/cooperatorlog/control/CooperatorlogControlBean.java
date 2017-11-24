/**
* auto-generated code
* Thu Dec 28 19:50:30 CST 2006
*/
package com.sunrise.boss.business.cms.distribute.cooperatorlog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.distribute.cooperatorlog.persistent.CooperatorlogVO;
import com.sunrise.boss.business.cms.distribute.cooperatorlog.persistent.CooperatorlogDAO;
import com.sunrise.boss.business.cms.distribute.cooperatorlog.persistent.CooperatorlogListVO;

/**
 * <p>Title: CooperatorlogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/distribute/cooperatorlog/control/CooperatorlogControlBean"
 name="CooperatorlogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class CooperatorlogControlBean extends AbstractControlBean
    implements CooperatorlogControl {

    public CooperatorlogVO doCreate(CooperatorlogVO vo, User user)
        throws Exception {
        try{
			CooperatorlogDAO dao = (CooperatorlogDAO) DAOFactory.build(CooperatorlogDAO.class, user.getCityid());
            // TODO  set the pk */
            return (CooperatorlogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(CooperatorlogVO vo, User user)
        throws Exception {
        try{
			CooperatorlogDAO dao = (CooperatorlogDAO) DAOFactory.build(CooperatorlogDAO.class, user.getCityid());
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public CooperatorlogVO doUpdate(CooperatorlogVO vo, User user)
        throws Exception {
        try{
			CooperatorlogDAO dao = (CooperatorlogDAO) DAOFactory.build(CooperatorlogDAO.class, user.getCityid());
            return (CooperatorlogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public CooperatorlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
			CooperatorlogDAO dao = (CooperatorlogDAO) DAOFactory.build(CooperatorlogDAO.class, user.getCityid());
        return (CooperatorlogVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(CooperatorlogListVO params, User user)
        throws Exception {
			CooperatorlogDAO dao = (CooperatorlogDAO) DAOFactory.build(CooperatorlogDAO.class, user.getCityid());
        return dao.query(params);
    }
}
