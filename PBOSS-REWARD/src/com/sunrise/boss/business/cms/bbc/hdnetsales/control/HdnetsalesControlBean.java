/**
* auto-generated code
* Thu Feb 25 14:28:35 CST 2010
*/
package com.sunrise.boss.business.cms.bbc.hdnetsales.control;

import java.io.Serializable;

import com.sunrise.boss.business.cms.bbc.hdnetsales.persistent.HdnetsalesDAO;
import com.sunrise.boss.business.cms.bbc.hdnetsales.persistent.HdnetsalesListVO;
import com.sunrise.boss.business.cms.bbc.hdnetsales.persistent.HdnetsalesVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: HdnetsalesControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/bbc/hdnetsales/control/HdnetsalesControlBean"
 name="HdnetsalesControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class HdnetsalesControlBean extends AbstractControlBean
    implements HdnetsalesControl {

    public HdnetsalesVO doCreate(HdnetsalesVO vo, User user)
        throws Exception {
        try{
			HdnetsalesDAO dao = (HdnetsalesDAO) DAOFactory.build(HdnetsalesDAO.class, user);
            // TODO  set the pk */
            return (HdnetsalesVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(HdnetsalesVO vo, User user)
        throws Exception {
        try{
			HdnetsalesDAO dao = (HdnetsalesDAO) DAOFactory.build(HdnetsalesDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public HdnetsalesVO doUpdate(HdnetsalesVO vo, User user)
        throws Exception {
        try{
			HdnetsalesDAO dao = (HdnetsalesDAO) DAOFactory.build(HdnetsalesDAO.class, user);
            return (HdnetsalesVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public HdnetsalesVO doFindByPk(Serializable pk, User user)
        throws Exception {
			HdnetsalesDAO dao = (HdnetsalesDAO) DAOFactory.build(HdnetsalesDAO.class, user);
        return (HdnetsalesVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(HdnetsalesListVO params, User user)
        throws Exception {
			HdnetsalesDAO dao = (HdnetsalesDAO) DAOFactory.build(HdnetsalesDAO.class, user);
        return dao.query(params);
    }
    
    public DataPackage doQuery2(Object[] params,Class[] classvo,String[][] joins, User user)
    	throws Exception {
			HdnetsalesDAO dao = (HdnetsalesDAO) DAOFactory.build(HdnetsalesDAO.class, user);
	    return dao.query2(params, classvo, joins);
    }
}
