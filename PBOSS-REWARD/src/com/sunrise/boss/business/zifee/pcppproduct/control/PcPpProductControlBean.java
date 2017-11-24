/**
* auto-generated code
* Wed Aug 16 15:21:29 CST 2006
*/
package com.sunrise.boss.business.zifee.pcppproduct.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.pub.tools.Sequence;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.business.zifee.pcppproduct.persistent.PcPpProductVO;
import com.sunrise.boss.business.zifee.pcppproduct.persistent.PcPpProductDAO;
import com.sunrise.boss.business.zifee.pcppproduct.persistent.PcPpProductListVO;
import com.sunrise.boss.ui.commons.User;
/**
 * <p>Title: PcPpProductControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/boss/business/zifee/pcppproduct/control/PcPpProductControlBean"
*    name="PcPpProductControl"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class PcPpProductControlBean extends AbstractControlBean
    implements PcPpProductControl {
    
    public PcPpProductVO doCreate(PcPpProductVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
        	PcPpProductDAO dao = (PcPpProductDAO) DAOFactory.build(PcPpProductDAO.class,user );
            return (PcPpProductVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(PcPpProductVO vo, User user)
        throws Exception {
        try{
        	PcPpProductDAO dao = (PcPpProductDAO) DAOFactory.build(PcPpProductDAO.class,user );
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public PcPpProductVO doUpdate(PcPpProductVO vo, User user)
        throws Exception {
        try{
        	PcPpProductDAO dao = (PcPpProductDAO) DAOFactory.build(PcPpProductDAO.class,user );
        	return (PcPpProductVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public PcPpProductVO doFindByPk(Serializable pk, User user)
        throws Exception {
    	PcPpProductDAO dao = (PcPpProductDAO) DAOFactory.build(PcPpProductDAO.class,user );
        return (PcPpProductVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(PcPpProductListVO params, User user)
        throws Exception {
    	PcPpProductDAO dao = (PcPpProductDAO) DAOFactory.build(PcPpProductDAO.class,user );
        return dao.query(params);
    }
}
