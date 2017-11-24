/**
* auto-generated code
* Wed Nov 25 11:12:10 CST 2009
*/
package com.sunrise.boss.business.cms.examine.exmnitem.control;

import java.io.Serializable;
import java.util.Iterator;

import org.apache.commons.beanutils.BeanUtils;

import com.sunrise.boss.business.cms.examine.examinestd.persistent.ExaminestdListVO;
import com.sunrise.boss.business.cms.examine.examinestd.persistent.ExaminestdVO;
import com.sunrise.boss.business.cms.examine.exmnitem.persistent.ExmnitemDAO;
import com.sunrise.boss.business.cms.examine.exmnitem.persistent.ExmnitemListVO;
import com.sunrise.boss.business.cms.examine.exmnitem.persistent.ExmnitemVO;
import com.sunrise.boss.business.cms.examine.exmnitemdtl.persistent.ExmnitemdtlListVO;
import com.sunrise.boss.business.cms.examine.exmnitemdtl.persistent.ExmnitemdtlVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.cms.examine.exmnitemdtl.ExmnitemdtlDelegate;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: ExmnitemControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/examine/exmnitem/control/ExmnitemControlBean"
 name="ExmnitemControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ExmnitemControlBean extends AbstractControlBean
    implements ExmnitemControl {

    public ExmnitemVO doCreate(ExmnitemVO vo, User user)
        throws Exception {
        try{
			ExmnitemDAO dao = (ExmnitemDAO) DAOFactory.build(ExmnitemDAO.class, user);
            // TODO  set the pk */
            return (ExmnitemVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ExmnitemVO vo, User user)
        throws Exception {
        try{
			ExmnitemDAO dao = (ExmnitemDAO) DAOFactory.build(ExmnitemDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ExmnitemVO doUpdate(ExmnitemVO vo, User user)
        throws Exception {
        try{
			ExmnitemDAO dao = (ExmnitemDAO) DAOFactory.build(ExmnitemDAO.class, user);
            return (ExmnitemVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ExmnitemVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ExmnitemDAO dao = (ExmnitemDAO) DAOFactory.build(ExmnitemDAO.class, user);
        return (ExmnitemVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ExmnitemListVO params, User user)
        throws Exception {
			ExmnitemDAO dao = (ExmnitemDAO) DAOFactory.build(ExmnitemDAO.class, user);
        return dao.query(params);
    }
    public DataPackage doQueryExmnitemList(ExmnitemListVO param, User user)
    throws Exception {
    	ExmnitemDAO dao = (ExmnitemDAO) DAOFactory.build(ExmnitemDAO.class, user);
    	ExaminestdListVO examinestdListVO=new ExaminestdListVO();
    	examinestdListVO.set_sk_exmnstdname(param.get_sk_exmnstdname());
    	param.set_sk_exmnstdname(null);
    	 Object params[] = {
    			 param, examinestdListVO
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
    	param.set_sk_exmnstdname(examinestdListVO.get_sk_exmnstdname());
    	return dp;
    }
    public void doRemoveItem(Serializable pkVO,String itemcityid, User user)
    throws Exception{
    	try{
	    	//ExmnitemDAO dao = (ExmnitemDAO) DAOFactory.build(ExmnitemDAO.class, user);
	    	ExmnitemdtlDelegate delegate =new ExmnitemdtlDelegate();
	    	ExmnitemdtlListVO listVO=new ExmnitemdtlListVO();
		    listVO.set_ne_exmnid(BeanUtils.getProperty(pkVO, "exmnid"));
		    listVO.set_ne_exmnstdid(BeanUtils.getProperty(pkVO, "exmnstdid"));
		    listVO.set_nn_pseqid("null");
		    listVO.set_pagesize("0");
	    	Iterator it=delegate.doQuery(listVO, user).getDatas().iterator();
	    	while(it.hasNext()){
	    		
	    		delegate.doRemoveDtl(((ExmnitemdtlVO)it.next()).getSeqid(),itemcityid,user);
			}
	    	ExmnitemVO vo=this.doFindByPk(pkVO, user);
	    	this.doRemove(vo, user);
    	 } catch(Exception ex){
             sessionContext.setRollbackOnly();
             throw ex;
         }
    }
}
