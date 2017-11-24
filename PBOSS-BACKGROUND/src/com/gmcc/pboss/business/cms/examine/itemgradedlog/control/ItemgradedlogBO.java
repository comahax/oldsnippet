package com.gmcc.pboss.business.cms.examine.itemgradedlog.control;


import java.io.Serializable;

import com.gmcc.pboss.business.cms.examine.itemgradedlog.persistent.ItemgradedlogListVO;
import com.gmcc.pboss.business.cms.examine.itemgradedlog.persistent.ItemgradedlogVO;
import com.gmcc.pboss.business.cms.examine.itemgradedlog.persistent.ItemgradedlogDAO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

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
public class ItemgradedlogBO extends AbstractControlBean
    implements Itemgradedlog {

    public ItemgradedlogVO doCreate(ItemgradedlogVO vo)
        throws Exception {
        try{
			ItemgradedlogDAO dao = (ItemgradedlogDAO) DAOFactory.build(ItemgradedlogDAO.class, user);
            // TODO  set the pk */
            return (ItemgradedlogVO) dao.create(vo);
        } catch(Exception ex){
            
            throw ex;
        }
    }

    public void doRemove(ItemgradedlogVO vo)
        throws Exception {
        try{
			ItemgradedlogDAO dao = (ItemgradedlogDAO) DAOFactory.build(ItemgradedlogDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            throw ex;
        }
    }

    public ItemgradedlogVO doUpdate(ItemgradedlogVO vo)
        throws Exception {
        try{
			ItemgradedlogDAO dao = (ItemgradedlogDAO) DAOFactory.build(ItemgradedlogDAO.class, user);
            return (ItemgradedlogVO) dao.update(vo);
        } catch(Exception ex){
            throw ex;
        }
    }

    public ItemgradedlogVO doFindByPk(Serializable pk)
        throws Exception {
			ItemgradedlogDAO dao = (ItemgradedlogDAO) DAOFactory.build(ItemgradedlogDAO.class, user);
        return (ItemgradedlogVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ItemgradedlogListVO params)
        throws Exception {
			ItemgradedlogDAO dao = (ItemgradedlogDAO) DAOFactory.build(ItemgradedlogDAO.class, user);
        return dao.query(params);
    }
}
