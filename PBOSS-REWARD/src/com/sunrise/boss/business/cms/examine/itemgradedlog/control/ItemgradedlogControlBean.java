/**
* auto-generated code
* Sat Nov 28 17:54:36 CST 2009
*/
package com.sunrise.boss.business.cms.examine.itemgradedlog.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.examine.itemgradedlog.persistent.ItemgradedlogVO;
import com.sunrise.boss.business.cms.examine.itemgradedlog.persistent.ItemgradedlogDAO;
import com.sunrise.boss.business.cms.examine.itemgradedlog.persistent.ItemgradedlogListVO;

/**
 * <p>Title: ItemgradedlogControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/examine/itemgradedlog/control/ItemgradedlogControlBean"
 name="ItemgradedlogControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ItemgradedlogControlBean extends AbstractControlBean
    implements ItemgradedlogControl {

    public ItemgradedlogVO doCreate(ItemgradedlogVO vo, User user)
        throws Exception {
        try{
			ItemgradedlogDAO dao = (ItemgradedlogDAO) DAOFactory.build(ItemgradedlogDAO.class, user);
            // TODO  set the pk */
            return (ItemgradedlogVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ItemgradedlogVO vo, User user)
        throws Exception {
        try{
			ItemgradedlogDAO dao = (ItemgradedlogDAO) DAOFactory.build(ItemgradedlogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ItemgradedlogVO doUpdate(ItemgradedlogVO vo, User user)
        throws Exception {
        try{
			ItemgradedlogDAO dao = (ItemgradedlogDAO) DAOFactory.build(ItemgradedlogDAO.class, user);
            return (ItemgradedlogVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ItemgradedlogVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ItemgradedlogDAO dao = (ItemgradedlogDAO) DAOFactory.build(ItemgradedlogDAO.class, user);
        return (ItemgradedlogVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ItemgradedlogListVO params, User user)
        throws Exception {
			ItemgradedlogDAO dao = (ItemgradedlogDAO) DAOFactory.build(ItemgradedlogDAO.class, user);
        return dao.query(params);
    }
}
