/**
* auto-generated code
* Thu Dec 24 14:26:29 CST 2009
*/
package com.sunrise.boss.business.cms.zjty.zjtycompcoeflog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtycompcoeflog.persistent.ZjtyCompcoeflogVO;
import com.sunrise.boss.business.cms.zjty.zjtycompcoeflog.persistent.ZjtyCompcoeflogDAO;
import com.sunrise.boss.business.cms.zjty.zjtycompcoeflog.persistent.ZjtyCompcoeflogListVO;

/**
 * <p>Title: ZjtyCompcoeflogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/zjty/zjtycompcoeflog/control/ZjtyCompcoeflogControlBean"
 name="ZjtyCompcoeflogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ZjtyCompcoeflogControlBean extends AbstractControlBean
    implements ZjtyCompcoeflogControl {

    public ZjtyCompcoeflogVO doCreate(ZjtyCompcoeflogVO vo, User user)
        throws Exception {
        try{
			ZjtyCompcoeflogDAO dao = (ZjtyCompcoeflogDAO) DAOFactory.build(ZjtyCompcoeflogDAO.class, user);
            // TODO  set the pk */
            return (ZjtyCompcoeflogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ZjtyCompcoeflogVO vo, User user)
        throws Exception {
        try{
			ZjtyCompcoeflogDAO dao = (ZjtyCompcoeflogDAO) DAOFactory.build(ZjtyCompcoeflogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ZjtyCompcoeflogVO doUpdate(ZjtyCompcoeflogVO vo, User user)
        throws Exception {
        try{
			ZjtyCompcoeflogDAO dao = (ZjtyCompcoeflogDAO) DAOFactory.build(ZjtyCompcoeflogDAO.class, user);
            return (ZjtyCompcoeflogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ZjtyCompcoeflogVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ZjtyCompcoeflogDAO dao = (ZjtyCompcoeflogDAO) DAOFactory.build(ZjtyCompcoeflogDAO.class, user);
        return (ZjtyCompcoeflogVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ZjtyCompcoeflogListVO params, User user)
        throws Exception {
			ZjtyCompcoeflogDAO dao = (ZjtyCompcoeflogDAO) DAOFactory.build(ZjtyCompcoeflogDAO.class, user);
        return dao.query(params);
    }
}
