/**
* auto-generated code
* Fri Oct 09 16:20:49 CST 2009
*/
package com.sunrise.boss.business.cms.faildataoplog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.faildataoplog.persistent.FaildataoplogVO;
import com.sunrise.boss.business.cms.faildataoplog.persistent.FaildataoplogDAO;
import com.sunrise.boss.business.cms.faildataoplog.persistent.FaildataoplogListVO;

/**
 * <p>Title: FaildataoplogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/faildataoplog/control/FaildataoplogControlBean"
 name="FaildataoplogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class FaildataoplogControlBean extends AbstractControlBean
    implements FaildataoplogControl {

    public FaildataoplogVO doCreate(FaildataoplogVO vo, User user)
        throws Exception {
        try{
			FaildataoplogDAO dao = (FaildataoplogDAO) DAOFactory.build(FaildataoplogDAO.class, user);
            // TODO  set the pk */
            return (FaildataoplogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(FaildataoplogVO vo, User user)
        throws Exception {
        try{
			FaildataoplogDAO dao = (FaildataoplogDAO) DAOFactory.build(FaildataoplogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public FaildataoplogVO doUpdate(FaildataoplogVO vo, User user)
        throws Exception {
        try{
			FaildataoplogDAO dao = (FaildataoplogDAO) DAOFactory.build(FaildataoplogDAO.class, user);
            return (FaildataoplogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public FaildataoplogVO doFindByPk(Serializable pk, User user)
        throws Exception {
			FaildataoplogDAO dao = (FaildataoplogDAO) DAOFactory.build(FaildataoplogDAO.class, user);
        return (FaildataoplogVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(FaildataoplogListVO params, User user)
        throws Exception {
			FaildataoplogDAO dao = (FaildataoplogDAO) DAOFactory.build(FaildataoplogDAO.class, user);
        return dao.query(params);
    }
}
