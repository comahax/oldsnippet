package com.sunrise.boss.business.cms.distribute.cpexam.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.pub.tools.Sequence;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.business.cms.distribute.cpexam.persistent.CpexamVO;
import com.sunrise.boss.business.cms.distribute.cpexam.persistent.CpexamDAO;
import com.sunrise.boss.business.cms.distribute.cpexam.persistent.CpexamListVO;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: CpexamControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/distribute/cpexam/control/CpexamControlBean"
 name="CpexamControl"
 view-type="local"
 type="Stateless"
 @author zhangbinli
 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class CpexamControlBean extends AbstractControlBean
    implements CpexamControl {
    
    public CpexamVO doCreate(CpexamVO vo, User user) throws Exception {
        
        try{
        		CpexamDAO dao = (CpexamDAO) DAOFactory.build(CpexamDAO.class,user);
            vo = (CpexamVO) dao.create(vo);
            return vo;
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(CpexamVO vo, User user) throws Exception {
    	
        try {
        		CpexamDAO dao = (CpexamDAO) DAOFactory.build(CpexamDAO.class,user);
        		dao.remove(vo);
        }
        catch (Exception ex) {
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public CpexamVO doUpdate(CpexamVO vo, User user) throws Exception {
        try{
        		CpexamDAO dao = (CpexamDAO) DAOFactory.build(CpexamDAO.class,user);
            vo = (CpexamVO) dao.update(vo);
            return vo;
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    
    public CpexamVO doFindByPk(Serializable pk, User user)
        throws Exception {
    		CpexamDAO dao = (CpexamDAO) DAOFactory.build(CpexamDAO.class,user);
        return (CpexamVO) dao.findByPk(pk);
    }
    
    public DataPackage doQuery(CpexamListVO params, User user)
        throws Exception {
    		CpexamDAO dao = (CpexamDAO) DAOFactory.build(CpexamDAO.class,user);
        return dao.query(params);
    }
}
