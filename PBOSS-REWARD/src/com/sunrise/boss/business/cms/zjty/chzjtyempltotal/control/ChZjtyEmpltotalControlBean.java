/**
* auto-generated code
* Fri Feb 13 16:49:58 CST 2009
*/
package com.sunrise.boss.business.cms.zjty.chzjtyempltotal.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.chzjtyempltotal.persistent.ChZjtyEmpltotalVO;
import com.sunrise.boss.business.cms.zjty.chzjtyempltotal.persistent.ChZjtyEmpltotalDAO;
import com.sunrise.boss.business.cms.zjty.chzjtyempltotal.persistent.ChZjtyEmpltotalListVO;

/**
 * <p>Title: ChZjtyEmpltotalControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wanghua
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/zjty/chzjtyempltotal/control/ChZjtyEmpltotalControlBean"
 name="ChZjtyEmpltotalControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ChZjtyEmpltotalControlBean extends AbstractControlBean
    implements ChZjtyEmpltotalControl {

    public ChZjtyEmpltotalVO doCreate(ChZjtyEmpltotalVO vo, User user)
        throws Exception {
        try{
			ChZjtyEmpltotalDAO dao = (ChZjtyEmpltotalDAO) DAOFactory.build(ChZjtyEmpltotalDAO.class, user);
            // TODO  set the pk */
            return (ChZjtyEmpltotalVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(ChZjtyEmpltotalVO vo, User user)
        throws Exception {
        try{
			ChZjtyEmpltotalDAO dao = (ChZjtyEmpltotalDAO) DAOFactory.build(ChZjtyEmpltotalDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public ChZjtyEmpltotalVO doUpdate(ChZjtyEmpltotalVO vo, User user)
        throws Exception {
        try{
			ChZjtyEmpltotalDAO dao = (ChZjtyEmpltotalDAO) DAOFactory.build(ChZjtyEmpltotalDAO.class, user);
            return (ChZjtyEmpltotalVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public ChZjtyEmpltotalVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ChZjtyEmpltotalDAO dao = (ChZjtyEmpltotalDAO) DAOFactory.build(ChZjtyEmpltotalDAO.class, user);
        return (ChZjtyEmpltotalVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(ChZjtyEmpltotalListVO params, User user)
        throws Exception {
			ChZjtyEmpltotalDAO dao = (ChZjtyEmpltotalDAO) DAOFactory.build(ChZjtyEmpltotalDAO.class, user);
        return dao.query(params);
    }
}
