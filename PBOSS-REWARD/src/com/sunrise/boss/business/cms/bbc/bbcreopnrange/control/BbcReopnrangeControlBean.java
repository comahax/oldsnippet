/**
* auto-generated code
* Sun Aug 15 11:34:09 CST 2010
*/
package com.sunrise.boss.business.cms.bbc.bbcreopnrange.control;

import java.io.Serializable;

import com.sunrise.boss.business.cms.bbc.bbcreopnrange.persistent.BbcReopnrangeDAO;
import com.sunrise.boss.business.cms.bbc.bbcreopnrange.persistent.BbcReopnrangeListVO;
import com.sunrise.boss.business.cms.bbc.bbcreopnrange.persistent.BbcReopnrangeVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: BbcReopnrangeControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/bbc/bbcreopnrange/control/BbcReopnrangeControlBean"
 name="BbcReopnrangeControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class BbcReopnrangeControlBean extends AbstractControlBean
    implements BbcReopnrangeControl {

    public BbcReopnrangeVO doCreate(BbcReopnrangeVO vo, User user)
        throws Exception {
        try{
			BbcReopnrangeDAO dao = (BbcReopnrangeDAO) DAOFactory.build(BbcReopnrangeDAO.class, user);
            // TODO  set the pk */
            return (BbcReopnrangeVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(BbcReopnrangeVO vo, User user)
        throws Exception {
        try{
			BbcReopnrangeDAO dao = (BbcReopnrangeDAO) DAOFactory.build(BbcReopnrangeDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public BbcReopnrangeVO doUpdate(BbcReopnrangeVO vo, User user)
        throws Exception {
        try{
			BbcReopnrangeDAO dao = (BbcReopnrangeDAO) DAOFactory.build(BbcReopnrangeDAO.class, user);
            return (BbcReopnrangeVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public BbcReopnrangeVO doFindByPk(Serializable pk, User user)
        throws Exception {
			BbcReopnrangeDAO dao = (BbcReopnrangeDAO) DAOFactory.build(BbcReopnrangeDAO.class, user);
        return (BbcReopnrangeVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(BbcReopnrangeListVO params, User user)
        throws Exception {
			BbcReopnrangeDAO dao = (BbcReopnrangeDAO) DAOFactory.build(BbcReopnrangeDAO.class, user);
        return dao.query(params);
    }
    
    public DataPackage doQueryopnid(BbcReopnrangeListVO params,String opnid, String resertype, User user) throws Exception {
    	BbcReopnrangeDAO dao = (BbcReopnrangeDAO) DAOFactory.build(BbcReopnrangeDAO.class, user);
		//
		return dao.getRangeByOpnid(params, opnid, resertype);
	}
    
    public DataPackage doQueryrange(BbcReopnrangeListVO params,String resertype, User user)throws Exception{
    	BbcReopnrangeDAO dao = (BbcReopnrangeDAO) DAOFactory.build(BbcReopnrangeDAO.class, user);
    	return dao.getRangeByResertype(params, resertype);
    }
}
