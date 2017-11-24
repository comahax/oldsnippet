/**
* auto-generated code
* Thu Aug 24 15:33:39 CST 2006
*/
package com.sunrise.boss.business.zifee.plandisccode.control;

import java.io.Serializable;

import javax.ejb.*;
import com.sunrise.boss.business.zifee.feedisc.persistent.FeediscDAO;
import com.sunrise.boss.business.zifee.feedisc.persistent.FeediscListVO;
import com.sunrise.boss.business.zifee.feedisc.persistent.FeediscVO;
import com.sunrise.boss.business.zifee.plandisccode.persistent.PlandisccodeDAO;
import com.sunrise.boss.business.zifee.plandisccode.persistent.PlandisccodeListVO;
import com.sunrise.boss.business.zifee.plandisccode.persistent.PlandisccodeVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
/**
 * <p>Title: PlandisccodeControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author plandisccode
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/boss/business/zifee/plandisccode/control/PlandisccodeControlBean"
*    name="PlandisccodeControl"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class PlandisccodeControlBean  extends AbstractControlBean implements PlandisccodeControl
 {
    //final private String TABLENAME = "PC_PS_PLANDISCCODE";
    public PlandisccodeVO doCreate(PlandisccodeVO vo, User user) throws Exception {
		// TODO Auto-generated method stub
		try{
			PlandisccodeDAO dao = (PlandisccodeDAO) DAOFactory.build(PlandisccodeDAO.class,user );

        	return (PlandisccodeVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
	}

	public void doRemove(PlandisccodeVO vo, User user) throws Exception {
		// TODO Auto-generated method stub
		try{
			PlandisccodeDAO dao = (PlandisccodeDAO) DAOFactory.build(PlandisccodeDAO.class,user );
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
	}

	public PlandisccodeVO doUpdate(PlandisccodeVO vo, User user) throws Exception {
		// TODO Auto-generated method stub
		try{
			PlandisccodeDAO dao = (PlandisccodeDAO) DAOFactory.build(PlandisccodeDAO.class,user );
	            return (PlandisccodeVO) dao.update(vo);
	        } catch(Exception ex){
	            sessionContext.setRollbackOnly();
	            throw ex;
	        }
	}

	public PlandisccodeVO doFindByPk(Serializable pk, User user) throws Exception {
		// TODO Auto-generated method stub
		PlandisccodeDAO dao = (PlandisccodeDAO) DAOFactory.build(PlandisccodeDAO.class,user );
        return (PlandisccodeVO) dao.findByPk(pk);
	} 

	public DataPackage doQuery(PlandisccodeListVO params, User user) throws Exception {
		// TODO Auto-generated method stub
		PlandisccodeDAO dao = (PlandisccodeDAO) DAOFactory.build(PlandisccodeDAO.class,user );
        return dao.query(params);
	}
}
