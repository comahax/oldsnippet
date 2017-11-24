/**
* auto-generated code
* Thu Jul 26 17:37:14 CST 2007
*/
package com.sunrise.boss.business.cms.fdauditdef.control;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.pub.tools.Sequence;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.SessionUtil;
import com.sunrise.boss.ui.cms.fdauditdef.FdauditdefTreeBean;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.xtree.XTreeNode;
import com.sunrise.boss.business.cms.fdauditdef.persistent.FdauditdefVO;
import com.sunrise.boss.business.cms.fdauditdef.persistent.FdauditdefDAO;
import com.sunrise.boss.business.cms.fdauditdef.persistent.FdauditdefListVO;

/**
 * <p>Title: FdauditdefControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/fdauditdef/control/FdauditdefControlBean"
 name="FdauditdefControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class FdauditdefControlBean extends AbstractControlBean
    implements FdauditdefControl {

    public FdauditdefVO doCreate(FdauditdefVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
         FdauditdefDAO dao = (FdauditdefDAO) DAOFactory.build(FdauditdefDAO.class, user);
            return (FdauditdefVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(FdauditdefVO vo, User user)
        throws Exception {
        try{
         FdauditdefDAO dao = (FdauditdefDAO) DAOFactory.build(FdauditdefDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public FdauditdefVO doUpdate(FdauditdefVO vo, User user)
        throws Exception {
        try{
         FdauditdefDAO dao = (FdauditdefDAO) DAOFactory.build(FdauditdefDAO.class, user);
            return (FdauditdefVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public FdauditdefVO doFindByPk(Serializable pk, User user)
        throws Exception {
         FdauditdefDAO dao = (FdauditdefDAO) DAOFactory.build(FdauditdefDAO.class, user);
        return (FdauditdefVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(FdauditdefListVO params, User user)
        throws Exception {
         FdauditdefDAO dao = (FdauditdefDAO) DAOFactory.build(FdauditdefDAO.class, user);
        return dao.query(params);
    }
    public DataPackage queryAuditFields(String tablename,String typename,User user)
        throws Exception{
    	FdauditdefDAO dao = (FdauditdefDAO) DAOFactory.build(FdauditdefDAO.class, user);
    	FdauditdefListVO fdauditdefListVO = new FdauditdefListVO();
    	fdauditdefListVO.set_sk_tablename(tablename);
    	fdauditdefListVO.set_sk_typename(typename);
    	return dao.query(fdauditdefListVO);
    }
    public DataPackage queryAuditFields(String typename,User user)
    throws Exception{
    	FdauditdefDAO dao = (FdauditdefDAO) DAOFactory.build(FdauditdefDAO.class, user);
    	FdauditdefListVO fdauditdefListVO = new FdauditdefListVO();
    	fdauditdefListVO.set_sk_typename(typename);
    	return dao.query(fdauditdefListVO);
    }
    
    public DataPackage queryTypes(User user) throws Exception {    	
		FdauditdefDAO dao = (FdauditdefDAO) DAOFactory.build(FdauditdefDAO.class, user);	
		return dao.queryAllTypes();
    }
	public DataPackage queryBySQLname(String typename, User user) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}

