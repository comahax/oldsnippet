/**
* auto-generated code
* Fri Aug 25 11:28:40 CST 2006
*/
package com.sunrise.boss.business.cms.bchcontact.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.admin.dictitem.persistent.DictitemVO;
import com.sunrise.boss.business.cms.bchcontact.persistent.BchcontactVO;
import com.sunrise.boss.business.cms.bchcontact.persistent.BchcontactDAO;
import com.sunrise.boss.business.cms.bchcontact.persistent.BchcontactListVO;

/**
 * <p>Title: BchcontactControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author yjr
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/boss/business/cms/bchcontact/control/BchcontactControlBean"
*    name="BchcontactControl"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class BchcontactControlBean extends AbstractControlBean
    implements BchcontactControl {

    public BchcontactVO doCreate(BchcontactVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
         BchcontactDAO dao = (BchcontactDAO) DAOFactory.build(BchcontactDAO.class, user );
         if (dao.findByPk(vo.getWayid())!=null){
        	 throw new BusinessException("CMS-10001","已经存在相同的渠道编码:" + vo.getWayid());
         }  
         doCheck(vo, user);
         return (BchcontactVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(BchcontactVO vo, User user)
        throws Exception {
        try{
         BchcontactDAO dao = (BchcontactDAO) DAOFactory.build(BchcontactDAO.class, user );
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public BchcontactVO doUpdate(BchcontactVO vo, User user)
        throws Exception {
        try{
         BchcontactDAO dao = (BchcontactDAO) DAOFactory.build(BchcontactDAO.class, user );
         doCheck(vo, user);
            return (BchcontactVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public BchcontactVO doFindByPk(Serializable pk, User user)
        throws Exception {
         BchcontactDAO dao = (BchcontactDAO) DAOFactory.build(BchcontactDAO.class, user );
        return (BchcontactVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(BchcontactListVO params, User user)
        throws Exception {
         BchcontactDAO dao = (BchcontactDAO) DAOFactory.build(BchcontactDAO.class, user );
        return dao.query(params);
    }
    
    public DataPackage queryByOprcodeAndType(BchcontactListVO params,User user)
	throws Exception{
        BchcontactDAO dao = (BchcontactDAO) DAOFactory.build(BchcontactDAO.class, user );
        return dao.queryByOprcodeAndType(params,user.getWayid());
    }
    
    private void doCheck(BchcontactVO vo, User user) throws Exception{
    	if(null != vo.getServbound() && !doCheckSystemParam("CH_SERVBOUND", vo.getServbound().toString(), user)){
    		throw new Exception("经营范围:" + vo.getServbound() + "固定参数不存在");
    	}
    	
    	if(null != vo.getBailtype() && !doCheckSystemParam("CH_BAILTYPE", vo.getBailtype().toString(), user)){
    		throw new Exception("保证金交付形式:" + vo.getBailtype() + "固定参数不存在");
    	}
    }
	
	private boolean doCheckSystemParam(String groupid,String dictid,User user) throws Exception{
		DictitemVO vo=new DictitemVO();
		BaseDAO dao=new BaseDAO(DictitemVO.class,user.getCityid());;
		vo.setGroupid(groupid);
		vo.setDictid(dictid);
		vo = (DictitemVO) dao.findByPk(vo);
		if(vo==null){
			return false;
		}
			return true;
	}
}
