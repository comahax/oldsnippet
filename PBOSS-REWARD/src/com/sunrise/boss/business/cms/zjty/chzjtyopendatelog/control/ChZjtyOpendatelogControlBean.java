/**
* auto-generated code
* Mon Feb 16 10:04:17 CST 2009
*/
package com.sunrise.boss.business.cms.zjty.chzjtyopendatelog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.chzjtyopendatelog.persistent.ChZjtyOpendatelogVO;
import com.sunrise.boss.business.cms.zjty.chzjtyopendatelog.persistent.ChZjtyOpendatelogDAO;
import com.sunrise.boss.business.cms.zjty.chzjtyopendatelog.persistent.ChZjtyOpendatelogListVO;

/**
 * <p>Title: ChZjtyOpendatelogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wanghua
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/zjty/chzjtyopendatelog/control/ChZjtyOpendatelogControlBean"
 name="ChZjtyOpendatelogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ChZjtyOpendatelogControlBean extends AbstractControlBean
    implements ChZjtyOpendatelogControl {

    public ChZjtyOpendatelogVO doCreate(ChZjtyOpendatelogVO vo, User user)
        throws Exception {
        try{
			ChZjtyOpendatelogDAO dao = (ChZjtyOpendatelogDAO) DAOFactory.build(ChZjtyOpendatelogDAO.class, user);
            // TODO  set the pk */
            return (ChZjtyOpendatelogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(ChZjtyOpendatelogVO vo, User user)
        throws Exception {
        try{
			ChZjtyOpendatelogDAO dao = (ChZjtyOpendatelogDAO) DAOFactory.build(ChZjtyOpendatelogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public ChZjtyOpendatelogVO doUpdate(ChZjtyOpendatelogVO vo, User user)
        throws Exception {
        try{
			ChZjtyOpendatelogDAO dao = (ChZjtyOpendatelogDAO) DAOFactory.build(ChZjtyOpendatelogDAO.class, user);
            return (ChZjtyOpendatelogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public ChZjtyOpendatelogVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ChZjtyOpendatelogDAO dao = (ChZjtyOpendatelogDAO) DAOFactory.build(ChZjtyOpendatelogDAO.class, user);
        return (ChZjtyOpendatelogVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(ChZjtyOpendatelogListVO params, User user)
        throws Exception {
			ChZjtyOpendatelogDAO dao = (ChZjtyOpendatelogDAO) DAOFactory.build(ChZjtyOpendatelogDAO.class, user);
        return dao.query(params);
    }
}
