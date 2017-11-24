package com.gmcc.pboss.business.cms.examine.exmnitem.control;


import java.io.Serializable;
import java.util.Iterator;

import org.apache.commons.beanutils.BeanUtils;

import com.gmcc.pboss.business.cms.examine.examinestd.persistent.ExaminestdListVO;
import com.gmcc.pboss.business.cms.examine.examinestd.persistent.ExaminestdVO;
import com.gmcc.pboss.business.cms.examine.exmnitem.persistent.ExmnitemDAO;
import com.gmcc.pboss.business.cms.examine.exmnitem.persistent.ExmnitemListVO;
import com.gmcc.pboss.business.cms.examine.exmnitem.persistent.ExmnitemVO;
import com.gmcc.pboss.business.cms.examine.exmnitemdtl.control.Exmnitemdtl;
import com.gmcc.pboss.business.cms.examine.exmnitemdtl.control.ExmnitemdtlBO;
import com.gmcc.pboss.business.cms.examine.exmnitemdtl.persistent.ExmnitemdtlDAO;
import com.gmcc.pboss.business.cms.examine.exmnitemdtl.persistent.ExmnitemdtlListVO;
import com.gmcc.pboss.business.cms.examine.exmnitemdtl.persistent.ExmnitemdtlVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;


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
public class ExmnitemBO extends AbstractControlBean
    implements Exmnitem {

    public ExmnitemVO doCreate(ExmnitemVO vo)
        throws Exception {
        try{
			ExmnitemDAO dao = (ExmnitemDAO) DAOFactory.build(ExmnitemDAO.class, user);
            // TODO  set the pk */
            return (ExmnitemVO) dao.create(vo);
        } catch(Exception ex){
            throw ex;
        }
    }

    public void doRemove(ExmnitemVO vo)
        throws Exception {
        try{
			ExmnitemDAO dao = (ExmnitemDAO) DAOFactory.build(ExmnitemDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            throw ex;
        }
    }

    public ExmnitemVO doUpdate(ExmnitemVO vo)
        throws Exception {
        try{
			ExmnitemDAO dao = (ExmnitemDAO) DAOFactory.build(ExmnitemDAO.class, user);
            return (ExmnitemVO) dao.update(vo);
        } catch(Exception ex){
            throw ex;
        }
    }

    public ExmnitemVO doFindByPk(Serializable pk)
        throws Exception {
			ExmnitemDAO dao = (ExmnitemDAO) DAOFactory.build(ExmnitemDAO.class, user);
        return (ExmnitemVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ExmnitemListVO params)
        throws Exception {
			ExmnitemDAO dao = (ExmnitemDAO) DAOFactory.build(ExmnitemDAO.class, user);
        return dao.query(params);
    }
    public DataPackage doQueryExmnitemList(ExmnitemListVO param)
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
    	DataPackage dp=dao.unionQuery(params, vos, joins);
    	param.set_sk_exmnstdname(examinestdListVO.get_sk_exmnstdname());
    	return dp;
    }


	public void doRemoveItem(Serializable pkVO, String itemcityid)
			throws Exception {
		// TODO Auto-generated method stub
		ExmnitemDAO dao = (ExmnitemDAO) DAOFactory.build(ExmnitemDAO.class, user);
    	Exmnitemdtl delegate = (ExmnitemdtlBO)BOFactory.build(ExmnitemdtlBO.class,user);
    	ExmnitemdtlListVO listVO=new ExmnitemdtlListVO();
	    listVO.set_ne_exmnid(BeanUtils.getProperty(pkVO, "exmnid"));
	    listVO.set_ne_exmnstdid(BeanUtils.getProperty(pkVO, "exmnstdid"));
	    listVO.set_nn_pseqid("null");
	    listVO.set_pagesize("0");
    	Iterator it=delegate.doQuery(listVO).getDatas().iterator();
    	while(it.hasNext()){
    		delegate.doRemoveDtl(((ExmnitemdtlVO)it.next()).getSeqid(),itemcityid);
		}
    	dao.removeByPk(pkVO);
	}
    
    
}
