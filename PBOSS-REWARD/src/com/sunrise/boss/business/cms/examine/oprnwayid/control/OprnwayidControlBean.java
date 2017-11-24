/**
* auto-generated code
* Wed Nov 18 10:31:12 CST 2009
*/
package com.sunrise.boss.business.cms.examine.oprnwayid.control;

import java.io.Serializable;
import java.util.Iterator;

import org.apache.commons.beanutils.BeanUtils;

import com.sunrise.boss.business.cms.examine.oprnwayid.persistent.OprnwayidDAO;
import com.sunrise.boss.business.cms.examine.oprnwayid.persistent.OprnwayidListVO;
import com.sunrise.boss.business.cms.examine.oprnwayid.persistent.OprnwayidVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: OprnwayidControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/examine/oprnwayid/control/OprnwayidControlBean"
 name="OprnwayidControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class OprnwayidControlBean extends AbstractControlBean
    implements OprnwayidControl {

    public OprnwayidVO doCreate(OprnwayidVO vo, User user)
        throws Exception {
        try{
			OprnwayidDAO dao = (OprnwayidDAO) DAOFactory.build(OprnwayidDAO.class, user);
            // TODO  set the pk */
            return (OprnwayidVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(OprnwayidVO vo, User user)
        throws Exception {
        try{
			OprnwayidDAO dao = (OprnwayidDAO) DAOFactory.build(OprnwayidDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public OprnwayidVO doUpdate(OprnwayidVO vo, User user)
        throws Exception {
        try{
			OprnwayidDAO dao = (OprnwayidDAO) DAOFactory.build(OprnwayidDAO.class, user);
            return (OprnwayidVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public OprnwayidVO doFindByPk(Serializable pk, User user)
        throws Exception {
			OprnwayidDAO dao = (OprnwayidDAO) DAOFactory.build(OprnwayidDAO.class, user);
        return (OprnwayidVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(OprnwayidListVO params, User user)
        throws Exception {
			OprnwayidDAO dao = (OprnwayidDAO) DAOFactory.build(OprnwayidDAO.class, user);
        return dao.query(params);
    }
    /**
     * 渠道评分授权交接
     */
    public void doTransf(String oldoperid,String newoperid,User user)throws Exception{
    	try {
			OprnwayidListVO listVO=new OprnwayidListVO();
			listVO.set_se_operid(oldoperid);
			listVO.set_pagesize("0");
			Iterator it=this.doQuery(listVO, user).getDatas().iterator();
			OprnwayidVO oldvo=null;
			OprnwayidVO newvo=null;
			while(it.hasNext()){
				oldvo=(OprnwayidVO)it.next();
				newvo=new OprnwayidVO();
				BeanUtils.copyProperties(newvo, oldvo);
				newvo.setOperid(newoperid);
				if(this.doFindByPk(newvo,user)==null){//不存在则新增
					this.doCreate(newvo, user);
				}
				this.doRemove(oldvo, user);//删除原来记录
			}
		}  catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
}
