/**
* auto-generated code
* Sat Apr 21 14:16:48 CST 2012
*/
package com.sunrise.boss.business.cms.bbc.subtractlog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.subtractlog.persistent.SubtractlogVO;
import com.sunrise.boss.business.cms.bbc.subtractlog.persistent.SubtractlogDAO;
import com.sunrise.boss.business.cms.bbc.subtractlog.persistent.SubtractlogListVO;

/**
 * <p>Title: SubtractlogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/bbc/subtractlog/control/SubtractlogControlBean"
 name="SubtractlogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class SubtractlogControlBean extends AbstractControlBean
    implements SubtractlogControl {

    public SubtractlogVO doCreate(SubtractlogVO vo, User user)
        throws Exception {
        try{
			SubtractlogDAO dao = (SubtractlogDAO) DAOFactory.build(SubtractlogDAO.class, user);
            // TODO  set the pk */
            return (SubtractlogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(SubtractlogVO vo, User user)
        throws Exception {
        try{
			SubtractlogDAO dao = (SubtractlogDAO) DAOFactory.build(SubtractlogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public SubtractlogVO doUpdate(SubtractlogVO vo, User user)
        throws Exception {
        try{
			SubtractlogDAO dao = (SubtractlogDAO) DAOFactory.build(SubtractlogDAO.class, user);
            return (SubtractlogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public SubtractlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
			SubtractlogDAO dao = (SubtractlogDAO) DAOFactory.build(SubtractlogDAO.class, user);
        return (SubtractlogVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(SubtractlogListVO params, User user)
        throws Exception {
			SubtractlogDAO dao = (SubtractlogDAO) DAOFactory.build(SubtractlogDAO.class, user);
        return dao.query(params);
    }
}
