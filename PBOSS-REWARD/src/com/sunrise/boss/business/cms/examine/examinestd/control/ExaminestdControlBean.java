/**
* auto-generated code
* Tue Nov 17 16:06:35 CST 2009
*/
package com.sunrise.boss.business.cms.examine.examinestd.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.sunrise.boss.business.cms.examine.examinestd.persistent.ExaminestdDAO;
import com.sunrise.boss.business.cms.examine.examinestd.persistent.ExaminestdListVO;
import com.sunrise.boss.business.cms.examine.examinestd.persistent.ExaminestdVO;
import com.sunrise.boss.business.cms.examine.exmnitem.persistent.ExmnitemListVO;
import com.sunrise.boss.business.cms.examine.exmnitem.persistent.ExmnitemVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: ExaminestdControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/examine/examinestd/control/ExaminestdControlBean"
 name="ExaminestdControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ExaminestdControlBean extends AbstractControlBean
    implements ExaminestdControl {

    public ExaminestdVO doCreate(ExaminestdVO vo, User user)
        throws Exception {
        try{
			ExaminestdDAO dao = (ExaminestdDAO) DAOFactory.build(ExaminestdDAO.class, user);
            // TODO  set the pk */
            return (ExaminestdVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ExaminestdVO vo, User user)
        throws Exception {
        try{
			ExaminestdDAO dao = (ExaminestdDAO) DAOFactory.build(ExaminestdDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ExaminestdVO doUpdate(ExaminestdVO vo, User user)
        throws Exception {
        try{
			ExaminestdDAO dao = (ExaminestdDAO) DAOFactory.build(ExaminestdDAO.class, user);
            return (ExaminestdVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ExaminestdVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ExaminestdDAO dao = (ExaminestdDAO) DAOFactory.build(ExaminestdDAO.class, user);
        return (ExaminestdVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ExaminestdListVO params, User user)
        throws Exception {
			ExaminestdDAO dao = (ExaminestdDAO) DAOFactory.build(ExaminestdDAO.class, user);
        return dao.query(params);
    }
    /**
     * 验证SQL合法
     */
    public int doValidateSQL(String sql, User user)throws Exception{
    	ExaminestdDAO dao = (ExaminestdDAO) DAOFactory.build(ExaminestdDAO.class, user);
    	return dao.doValidateSQL(sql, user);
    }
    public DataPackage doQueryExaminestdList(String exmnid, ExaminestdListVO param, User user)
    throws Exception {
    	ExaminestdDAO dao = (ExaminestdDAO) DAOFactory.build(ExaminestdDAO.class, user);
    	ExmnitemListVO exmnitemListVO=new ExmnitemListVO();
    	exmnitemListVO.set_ne_exmnid(exmnid);
    	Object params[] = {
    			exmnitemListVO, param
   	        };
   	        Class vos[] = {
   	        		ExmnitemVO.class, ExaminestdVO.class
   	        };
   	        String joins[][] = {
   	            {
   	                "exmnstdid", "exmnstdid"
   	            }
   	        };
   	        DataPackage dp=dao.query2(params, vos, joins);
   	        Iterator it=dp.getDatas().iterator();
   	       Object[] objs=null;
   	       Collection datas=new ArrayList();
   	        while(it.hasNext()){
   	        	objs=(Object[])it.next();
   	        	if(objs[0] instanceof ExaminestdVO){
   	        		datas.add((ExaminestdVO)objs[0]);
   	        	}else{
   	        		datas.add((ExaminestdVO)objs[1]);
   	        	}
   	        }
   	        dp.setDatas(datas);
   	        return dp;
    }
}
