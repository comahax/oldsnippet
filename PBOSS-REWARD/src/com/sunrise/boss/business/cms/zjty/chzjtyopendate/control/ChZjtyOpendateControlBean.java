/**
* auto-generated code
* Fri Feb 13 16:55:58 CST 2009
*/
package com.sunrise.boss.business.cms.zjty.chzjtyopendate.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.chzjtyopendate.persistent.ChZjtyOpendateVO;
import com.sunrise.boss.business.cms.zjty.chzjtyopendate.persistent.ChZjtyOpendateDAO;
import com.sunrise.boss.business.cms.zjty.chzjtyopendate.persistent.ChZjtyOpendateListVO;

/**
 * <p>Title: ChZjtyOpendateControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wanghua
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/zjty/chzjtyopendate/control/ChZjtyOpendateControlBean"
 name="ChZjtyOpendateControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ChZjtyOpendateControlBean extends AbstractControlBean
    implements ChZjtyOpendateControl {

    public ChZjtyOpendateVO doCreate(ChZjtyOpendateVO vo, User user)
        throws Exception {
        try{
			ChZjtyOpendateDAO dao = (ChZjtyOpendateDAO) DAOFactory.build(ChZjtyOpendateDAO.class, user);
            // TODO  set the pk */
            return (ChZjtyOpendateVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(ChZjtyOpendateVO vo, User user)
        throws Exception {
        try{
			ChZjtyOpendateDAO dao = (ChZjtyOpendateDAO) DAOFactory.build(ChZjtyOpendateDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public ChZjtyOpendateVO doUpdate(ChZjtyOpendateVO vo, User user)
        throws Exception {
        try{
			ChZjtyOpendateDAO dao = (ChZjtyOpendateDAO) DAOFactory.build(ChZjtyOpendateDAO.class, user);
            return (ChZjtyOpendateVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public ChZjtyOpendateVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ChZjtyOpendateDAO dao = (ChZjtyOpendateDAO) DAOFactory.build(ChZjtyOpendateDAO.class, user);
        return (ChZjtyOpendateVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(ChZjtyOpendateListVO params, User user)
        throws Exception {
			ChZjtyOpendateDAO dao = (ChZjtyOpendateDAO) DAOFactory.build(ChZjtyOpendateDAO.class, user);
        return dao.query(params);
    }
}
