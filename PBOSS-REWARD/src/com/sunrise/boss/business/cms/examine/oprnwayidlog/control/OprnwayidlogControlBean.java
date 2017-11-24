/**
* auto-generated code
* Wed Nov 18 10:52:23 CST 2009
*/
package com.sunrise.boss.business.cms.examine.oprnwayidlog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.examine.oprnwayidlog.persistent.OprnwayidlogVO;
import com.sunrise.boss.business.cms.examine.oprnwayidlog.persistent.OprnwayidlogDAO;
import com.sunrise.boss.business.cms.examine.oprnwayidlog.persistent.OprnwayidlogListVO;

/**
 * <p>Title: OprnwayidlogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/examine/oprnwayidlog/control/OprnwayidlogControlBean"
 name="OprnwayidlogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class OprnwayidlogControlBean extends AbstractControlBean
    implements OprnwayidlogControl {

    public OprnwayidlogVO doCreate(OprnwayidlogVO vo, User user)
        throws Exception {
        try{
			OprnwayidlogDAO dao = (OprnwayidlogDAO) DAOFactory.build(OprnwayidlogDAO.class, user);
            // TODO  set the pk */
            return (OprnwayidlogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(OprnwayidlogVO vo, User user)
        throws Exception {
        try{
			OprnwayidlogDAO dao = (OprnwayidlogDAO) DAOFactory.build(OprnwayidlogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public OprnwayidlogVO doUpdate(OprnwayidlogVO vo, User user)
        throws Exception {
        try{
			OprnwayidlogDAO dao = (OprnwayidlogDAO) DAOFactory.build(OprnwayidlogDAO.class, user);
            return (OprnwayidlogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public OprnwayidlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
			OprnwayidlogDAO dao = (OprnwayidlogDAO) DAOFactory.build(OprnwayidlogDAO.class, user);
        return (OprnwayidlogVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(OprnwayidlogListVO params, User user)
        throws Exception {
			OprnwayidlogDAO dao = (OprnwayidlogDAO) DAOFactory.build(OprnwayidlogDAO.class, user);
        return dao.query(params);
    }
}
