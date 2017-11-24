/**
* auto-generated code
* Sat Aug 26 10:44:13 CST 2006
*/
package com.sunrise.boss.business.cms.wayaccount.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.wayaccount.persistent.WayaccountVO;
import com.sunrise.boss.business.cms.wayaccount.persistent.WayaccountDAO;
import com.sunrise.boss.business.cms.wayaccount.persistent.WayaccountListVO;

/**
 * <p>Title: WayaccountControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/boss/business/cms/wayaccount/control/WayaccountControlBean"
*    name="WayaccountControl"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class WayaccountControlBean extends AbstractControlBean
    implements WayaccountControl {

    public WayaccountVO doCreate(WayaccountVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
         WayaccountDAO dao = (WayaccountDAO) DAOFactory.build(WayaccountDAO.class, user );
         WayaccountListVO listVO = new WayaccountListVO();
         listVO.set_ne_accid(vo.getAccid());
         listVO.set_se_wayid(vo.getWayid());
         if (dao.query(listVO).getDatas().size()>0){
        	 throw new BusinessException("CMS-10001","已经存在相同的渠道编码:" + vo.getWayid()+"和帐户标识:"+vo.getAccid().toString());
         }    
         
         return (WayaccountVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(WayaccountVO vo, User user)
        throws Exception {
        try{
         WayaccountDAO dao = (WayaccountDAO) DAOFactory.build(WayaccountDAO.class, user );
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public WayaccountVO doUpdate(WayaccountVO vo, User user)
        throws Exception {
        try{
         WayaccountDAO dao = (WayaccountDAO) DAOFactory.build(WayaccountDAO.class, user );
            return (WayaccountVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public WayaccountVO doFindByPk(Serializable pk, User user)
        throws Exception {
         WayaccountDAO dao = (WayaccountDAO) DAOFactory.build(WayaccountDAO.class, user );
        return (WayaccountVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(WayaccountListVO params, User user)
        throws Exception {
         WayaccountDAO dao = (WayaccountDAO) DAOFactory.build(WayaccountDAO.class, user );
        return dao.query(params);
    }
    public DataPackage queryByOprcodeAndType(WayaccountListVO params, User user)
	throws Exception {
        WayaccountDAO dao = (WayaccountDAO) DAOFactory.build(WayaccountDAO.class, user );
        return dao.queryByOprcodeAndType(params,user.getWayid());	
    }
}
