/**
* auto-generated code
* Mon Feb 16 10:03:38 CST 2009
*/
package com.sunrise.boss.business.cms.zjty.chzjtyempltotallog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.chzjtyempltotallog.persistent.ChZjtyEmpltotallogVO;
import com.sunrise.boss.business.cms.zjty.chzjtyempltotallog.persistent.ChZjtyEmpltotallogDAO;
import com.sunrise.boss.business.cms.zjty.chzjtyempltotallog.persistent.ChZjtyEmpltotallogListVO;

/**
 * <p>Title: ChZjtyEmpltotallogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wanghua
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/zjty/chzjtyempltotallog/control/ChZjtyEmpltotallogControlBean"
 name="ChZjtyEmpltotallogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ChZjtyEmpltotallogControlBean extends AbstractControlBean
    implements ChZjtyEmpltotallogControl {

    public ChZjtyEmpltotallogVO doCreate(ChZjtyEmpltotallogVO vo, User user)
        throws Exception {
        try{
			ChZjtyEmpltotallogDAO dao = (ChZjtyEmpltotallogDAO) DAOFactory.build(ChZjtyEmpltotallogDAO.class, user);
            // TODO  set the pk */
            return (ChZjtyEmpltotallogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(ChZjtyEmpltotallogVO vo, User user)
        throws Exception {
        try{
			ChZjtyEmpltotallogDAO dao = (ChZjtyEmpltotallogDAO) DAOFactory.build(ChZjtyEmpltotallogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public ChZjtyEmpltotallogVO doUpdate(ChZjtyEmpltotallogVO vo, User user)
        throws Exception {
        try{
			ChZjtyEmpltotallogDAO dao = (ChZjtyEmpltotallogDAO) DAOFactory.build(ChZjtyEmpltotallogDAO.class, user);
            return (ChZjtyEmpltotallogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public ChZjtyEmpltotallogVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ChZjtyEmpltotallogDAO dao = (ChZjtyEmpltotallogDAO) DAOFactory.build(ChZjtyEmpltotallogDAO.class, user);
        return (ChZjtyEmpltotallogVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(ChZjtyEmpltotallogListVO params, User user)
        throws Exception {
			ChZjtyEmpltotallogDAO dao = (ChZjtyEmpltotallogDAO) DAOFactory.build(ChZjtyEmpltotallogDAO.class, user);
        return dao.query(params);
    }
}
