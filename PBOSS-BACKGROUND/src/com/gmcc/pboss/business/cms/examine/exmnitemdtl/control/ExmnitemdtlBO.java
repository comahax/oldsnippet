package com.gmcc.pboss.business.cms.examine.exmnitemdtl.control;

import java.io.Serializable;
import java.util.Iterator;

import com.gmcc.pboss.business.cms.examine.exmnitemdtl.persistent.ExmnitemdtlDAO;
import com.gmcc.pboss.business.cms.examine.exmnitemdtl.persistent.ExmnitemdtlListVO;
import com.gmcc.pboss.business.cms.examine.exmnitemdtl.persistent.ExmnitemdtlVO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;


/**
 * <p>Title: ExmnitemdtlControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/examine/exmnitemdtl/control/ExmnitemdtlControlBean"
 name="ExmnitemdtlControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ExmnitemdtlBO extends AbstractControlBean
    implements Exmnitemdtl {

    public ExmnitemdtlVO doCreate(ExmnitemdtlVO vo)
        throws Exception {
        try{
			ExmnitemdtlDAO dao = (ExmnitemdtlDAO) DAOFactory.build(ExmnitemdtlDAO.class, user);
            // TODO  set the pk */
            return (ExmnitemdtlVO) dao.create(vo);
        } catch(Exception ex){
            
            throw ex;
        }
    }

    public void doRemove(ExmnitemdtlVO vo)
        throws Exception {
        try{
			ExmnitemdtlDAO dao = (ExmnitemdtlDAO) DAOFactory.build(ExmnitemdtlDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            
            throw ex;
        }
    }

    public ExmnitemdtlVO doUpdate(ExmnitemdtlVO vo)
        throws Exception {
        try{
			ExmnitemdtlDAO dao = (ExmnitemdtlDAO) DAOFactory.build(ExmnitemdtlDAO.class, user);
            return (ExmnitemdtlVO) dao.update(vo);
        } catch(Exception ex){
            
            throw ex;
        }
    }

    public ExmnitemdtlVO doFindByPk(Serializable pk)
        throws Exception {
			ExmnitemdtlDAO dao = (ExmnitemdtlDAO) DAOFactory.build(ExmnitemdtlDAO.class, user);
        return (ExmnitemdtlVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ExmnitemdtlListVO params)
        throws Exception {
			ExmnitemdtlDAO dao = (ExmnitemdtlDAO) DAOFactory.build(ExmnitemdtlDAO.class, user);
        return dao.query(params);
    }

    public void doRemoveDtl(Serializable pk,String cityid)
    throws Exception {
    	try {
			ExmnitemdtlDAO dao = (ExmnitemdtlDAO) DAOFactory.build(ExmnitemdtlDAO.class, user);
			if("GD".equals(cityid)){//省公司的考核
				ExmnitemdtlListVO listVO=new ExmnitemdtlListVO();
				listVO.set_ne_pseqid(pk+"");
				Iterator it=this.doQuery(listVO).getDatas().iterator();//查询地市公司针对该考核项明细设置的指标值
				while(it.hasNext()){
					this.doRemove((ExmnitemdtlVO)it.next());//删除地市公司针对该考核项明细设置的指标值
				}
				
			}
			dao.removeByPk(pk);//删除考核指标
		} catch (Exception ex) {
	         throw ex;
		}
    }
}
