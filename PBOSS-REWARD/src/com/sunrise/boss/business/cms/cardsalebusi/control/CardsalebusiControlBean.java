/**
* auto-generated code
* Fri Aug 03 11:10:45 CST 2007
*/
package com.sunrise.boss.business.cms.cardsalebusi.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.pub.tools.Sequence;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.cardsalebusi.persistent.CardsalebusiVO;
import com.sunrise.boss.business.cms.cardsalebusi.persistent.CardsalebusiDAO;
import com.sunrise.boss.business.cms.cardsalebusi.persistent.CardsalebusiListVO;

/**
 * <p>Title: CardsalebusiControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/cardsalebusi/control/CardsalebusiControlBean"
 name="CardsalebusiControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class CardsalebusiControlBean extends AbstractControlBean
    implements CardsalebusiControl {

    public CardsalebusiVO doCreate(CardsalebusiVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
         CardsalebusiDAO dao = (CardsalebusiDAO) DAOFactory.build(CardsalebusiDAO.class, user);
            return (CardsalebusiVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(CardsalebusiVO vo, User user)
        throws Exception {
        try{
         CardsalebusiDAO dao = (CardsalebusiDAO) DAOFactory.build(CardsalebusiDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public CardsalebusiVO doUpdate(CardsalebusiVO vo, User user)
        throws Exception {
        try{
         CardsalebusiDAO dao = (CardsalebusiDAO) DAOFactory.build(CardsalebusiDAO.class, user);
            return (CardsalebusiVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public CardsalebusiVO doFindByPk(Serializable pk, User user)
        throws Exception {
         CardsalebusiDAO dao = (CardsalebusiDAO) DAOFactory.build(CardsalebusiDAO.class, user);
        return (CardsalebusiVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(CardsalebusiListVO params, User user)
        throws Exception {
         CardsalebusiDAO dao = (CardsalebusiDAO) DAOFactory.build(CardsalebusiDAO.class, user);
        return dao.query(params);
    }
}
