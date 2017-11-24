/**
* auto-generated code
* Wed Nov 25 11:16:38 CST 2009
*/
package com.sunrise.boss.business.cms.examine.exmnitemdtl.control;

import java.io.Serializable;
import java.util.Iterator;

import com.sunrise.boss.business.cms.examine.exmnitemdtl.persistent.ExmnitemdtlDAO;
import com.sunrise.boss.business.cms.examine.exmnitemdtl.persistent.ExmnitemdtlListVO;
import com.sunrise.boss.business.cms.examine.exmnitemdtl.persistent.ExmnitemdtlVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

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
public class ExmnitemdtlControlBean extends AbstractControlBean
    implements ExmnitemdtlControl {

    public ExmnitemdtlVO doCreate(ExmnitemdtlVO vo, User user)
        throws Exception {
        try{
			ExmnitemdtlDAO dao = (ExmnitemdtlDAO) DAOFactory.build(ExmnitemdtlDAO.class, user);
            // TODO  set the pk */
            return (ExmnitemdtlVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ExmnitemdtlVO vo, User user)
        throws Exception {
        try{
			ExmnitemdtlDAO dao = (ExmnitemdtlDAO) DAOFactory.build(ExmnitemdtlDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ExmnitemdtlVO doUpdate(ExmnitemdtlVO vo, User user)
        throws Exception {
        try{
			ExmnitemdtlDAO dao = (ExmnitemdtlDAO) DAOFactory.build(ExmnitemdtlDAO.class, user);
            return (ExmnitemdtlVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ExmnitemdtlVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ExmnitemdtlDAO dao = (ExmnitemdtlDAO) DAOFactory.build(ExmnitemdtlDAO.class, user);
        return (ExmnitemdtlVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ExmnitemdtlListVO params, User user)
        throws Exception {
			ExmnitemdtlDAO dao = (ExmnitemdtlDAO) DAOFactory.build(ExmnitemdtlDAO.class, user);
        return dao.query(params);
    }
    public boolean doCheckBeingstcrtcl(ExmnitemdtlVO vo, User user)
    throws Exception{
    	ExmnitemdtlDAO dao = (ExmnitemdtlDAO) DAOFactory.build(ExmnitemdtlDAO.class, user);
        return dao.doCheckBeingstcrtcl(vo, user);
    }
    public void doRemoveDtl(Serializable pk,String cityid, User user)
    throws Exception {
    	try {
			ExmnitemdtlDAO dao = (ExmnitemdtlDAO) DAOFactory.build(ExmnitemdtlDAO.class, user);
			if("GD".equals(cityid)){//省公司的考核
				ExmnitemdtlListVO listVO=new ExmnitemdtlListVO();
				listVO.set_ne_pseqid(pk+"");
				Iterator it=this.doQuery(listVO, user).getDatas().iterator();//查询地市公司针对该考核项明细设置的指标值
				while(it.hasNext()){
					this.doRemove((ExmnitemdtlVO)it.next(),user);//删除地市公司针对该考核项明细设置的指标值
				}
				
			}
			ExmnitemdtlVO vo=this.doFindByPk(pk, user);
			this.doRemove(vo, user);//删除考核指标
		} catch (Exception ex) {
			 sessionContext.setRollbackOnly();
	         throw ex;
		}
    }
}
