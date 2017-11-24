/**
* auto-generated code
* Tue Mar 10 18:21:48 CST 2009
*/
package com.sunrise.boss.business.zifee.prodservset.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.pub.tools.Sequence;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.zifee.prodservset.persistent.ProdservsetVO;
import com.sunrise.boss.business.zifee.prodservset.persistent.ProdservsetDAO;
import com.sunrise.boss.business.zifee.prodservset.persistent.ProdservsetListVO;

/**
 * <p>Title: ProdservsetControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/zifee/prodservset/control/ProdservsetControlBean"
 name="ProdservsetControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ProdservsetControlBean extends AbstractControlBean
    implements ProdservsetControl {

    public ProdservsetVO doCreate(ProdservsetVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
         ProdservsetDAO dao = (ProdservsetDAO) DAOFactory.build(ProdservsetDAO.class, user);
            return (ProdservsetVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(ProdservsetVO vo, User user)
        throws Exception {
        try{
         ProdservsetDAO dao = (ProdservsetDAO) DAOFactory.build(ProdservsetDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public ProdservsetVO doUpdate(ProdservsetVO vo, User user)
        throws Exception {
        try{
         ProdservsetDAO dao = (ProdservsetDAO) DAOFactory.build(ProdservsetDAO.class, user);
            return (ProdservsetVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public ProdservsetVO doFindByPk(Serializable pk, User user)
        throws Exception {
         ProdservsetDAO dao = (ProdservsetDAO) DAOFactory.build(ProdservsetDAO.class, user);
        return (ProdservsetVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(ProdservsetListVO params, User user)
        throws Exception {
         ProdservsetDAO dao = (ProdservsetDAO) DAOFactory.build(ProdservsetDAO.class, user);
        return dao.query(params);
    }
}
