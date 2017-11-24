/**
* auto-generated code
* Fri Aug 25 11:29:29 CST 2006
*/
package com.sunrise.boss.business.cms.waycompact.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.pub.tools.Sequence;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bchcontact.persistent.BchcontactListVO;
import com.sunrise.boss.business.cms.waycompact.persistent.WaycompactVO;
import com.sunrise.boss.business.cms.waycompact.persistent.WaycompactDAO;
import com.sunrise.boss.business.cms.waycompact.persistent.WaycompactListVO;

/**
 * <p>Title: WaycompactControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author yjr
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/boss/business/cms/waycompact/control/WaycompactControlBean"
*    name="WaycompactControl"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class WaycompactControlBean extends AbstractControlBean
    implements WaycompactControl {

    public WaycompactVO doCreate(WaycompactVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
         WaycompactDAO dao = (WaycompactDAO) DAOFactory.build(WaycompactDAO.class, user );
         if (dao.findByPk(vo.getWayid())!=null){
        	 throw new BusinessException("CMS-10001","已经存在相同的渠道编码:" + vo.getWayid());
         }  
         return (WaycompactVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(WaycompactVO vo, User user)
        throws Exception {
        try{
         WaycompactDAO dao = (WaycompactDAO) DAOFactory.build(WaycompactDAO.class, user );
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public WaycompactVO doUpdate(WaycompactVO vo, User user)
        throws Exception {
        try{
         WaycompactDAO dao = (WaycompactDAO) DAOFactory.build(WaycompactDAO.class, user );
            return (WaycompactVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public WaycompactVO doFindByPk(Serializable pk, User user)
        throws Exception {
         WaycompactDAO dao = (WaycompactDAO) DAOFactory.build(WaycompactDAO.class, user );
        return (WaycompactVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(WaycompactListVO params, User user)
        throws Exception {
         WaycompactDAO dao = (WaycompactDAO) DAOFactory.build(WaycompactDAO.class, user );
        return dao.query(params);
    }
    public DataPackage queryByOprcodeAndType(WaycompactListVO params, User user)
	throws Exception {
        WaycompactDAO dao = (WaycompactDAO) DAOFactory.build(WaycompactDAO.class, user );
        return dao.queryByOprcodeAndType(params,user.getWayid());
    }
}
