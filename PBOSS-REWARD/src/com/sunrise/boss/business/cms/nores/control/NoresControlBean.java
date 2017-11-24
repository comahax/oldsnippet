/**
* auto-generated code
* Wed Nov 16 16:25:57 CST 2011
*/
package com.sunrise.boss.business.cms.nores.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.nores.persistent.NoresVO;
import com.sunrise.boss.business.cms.nores.persistent.NoresDAO;
import com.sunrise.boss.business.cms.nores.persistent.NoresListVO;

/**
 * <p>Title: NoresControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/nores/control/NoresControlBean"
 name="NoresControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class NoresControlBean extends AbstractControlBean
    implements NoresControl {

    public NoresVO doCreate(NoresVO vo, User user)
        throws Exception {
        try{
			NoresDAO dao = (NoresDAO) DAOFactory.build(NoresDAO.class, user);
            // TODO  set the pk */
            return (NoresVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(NoresVO vo, User user)
        throws Exception {
        try{
			NoresDAO dao = (NoresDAO) DAOFactory.build(NoresDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public NoresVO doUpdate(NoresVO vo, User user)
        throws Exception {
        try{
			NoresDAO dao = (NoresDAO) DAOFactory.build(NoresDAO.class, user);
            return (NoresVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public NoresVO doFindByPk(Serializable pk, User user)
        throws Exception {
			NoresDAO dao = (NoresDAO) DAOFactory.build(NoresDAO.class, user);
        return (NoresVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(NoresListVO params, User user)
        throws Exception {
			NoresDAO dao = (NoresDAO) DAOFactory.build(NoresDAO.class, user);
        return dao.query(params);
    }
}
