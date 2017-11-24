package com.gmcc.pboss.business.cms.examine.itemgraded.control;


import java.io.Serializable;

import com.gmcc.pboss.business.cms.examine.itemgraded.persistent.ItemgradedListVO;
import com.gmcc.pboss.business.cms.examine.itemgraded.persistent.ItemgradedVO;
import com.gmcc.pboss.business.cms.examine.itemgraded.persistent.ItemgradedDAO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: ItemgradedControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/examine/itemgraded/control/ItemgradedControlBean"
 name="ItemgradedControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ItemgradedBO extends AbstractControlBean
    implements Itemgraded {

    public ItemgradedVO doCreate(ItemgradedVO vo)
        throws Exception {
        try{
			ItemgradedDAO dao = (ItemgradedDAO) DAOFactory.build(ItemgradedDAO.class, user);
            // TODO  set the pk */
            return (ItemgradedVO) dao.create(vo);
        } catch(Exception ex){
            throw new JOPException(ex);
        }
    }

    public void doRemove(ItemgradedVO vo)
        throws Exception {
        try{
			ItemgradedDAO dao = (ItemgradedDAO) DAOFactory.build(ItemgradedDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            throw new JOPException(ex);
        }
    }

    public ItemgradedVO doUpdate(ItemgradedVO vo)
        throws Exception {
        try{
			ItemgradedDAO dao = (ItemgradedDAO) DAOFactory.build(ItemgradedDAO.class, user);
            return (ItemgradedVO) dao.update(vo);
        } catch(Exception ex){
            throw new JOPException(ex);
        }
    }

    public ItemgradedVO doFindByPk(Serializable pk)
        throws Exception {
			ItemgradedDAO dao = (ItemgradedDAO) DAOFactory.build(ItemgradedDAO.class, user);
        return (ItemgradedVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ItemgradedListVO params)
        throws Exception {
			ItemgradedDAO dao = (ItemgradedDAO) DAOFactory.build(ItemgradedDAO.class, user);
        return dao.query(params);
    }
}
