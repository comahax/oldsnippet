/**
* auto-generated code
* Sat Aug 26 11:33:48 CST 2006
*/
package com.sunrise.boss.business.cms.wayagentbch.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.pub.tools.Sequence;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.wayagentbch.persistent.WayagentbchVO;
import com.sunrise.boss.business.cms.wayagentbch.persistent.WayagentbchDAO;
import com.sunrise.boss.business.cms.wayagentbch.persistent.WayagentbchListVO;

/**
 * <p>Title: WayagentbchControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/boss/business/cms/wayagentbch/control/WayagentbchControlBean"
*    name="WayagentbchControl"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class WayagentbchControlBean extends AbstractControlBean
    implements WayagentbchControl {

    public WayagentbchVO doCreate(WayagentbchVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
         WayagentbchDAO dao = (WayagentbchDAO) DAOFactory.build(WayagentbchDAO.class, user );
            return (WayagentbchVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(WayagentbchVO vo, User user)
        throws Exception {
        try{
         WayagentbchDAO dao = (WayagentbchDAO) DAOFactory.build(WayagentbchDAO.class, user );
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public WayagentbchVO doUpdate(WayagentbchVO vo, User user)
        throws Exception {
        try{
         WayagentbchDAO dao = (WayagentbchDAO) DAOFactory.build(WayagentbchDAO.class, user );
            return (WayagentbchVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public WayagentbchVO doFindByPk(Serializable pk, User user)
        throws Exception {
         WayagentbchDAO dao = (WayagentbchDAO) DAOFactory.build(WayagentbchDAO.class, user );
        return (WayagentbchVO) dao.findByPk(pk);
    }
    
    public DataPackage doQuery(WayagentbchListVO params, User user)
        throws Exception {
         WayagentbchDAO dao = (WayagentbchDAO) DAOFactory.build(WayagentbchDAO.class, user );
        return dao.query(params);
    }
    
    public DataPackage getByBchtype(String bchtype, User user)
        throws Exception {
        WayagentbchDAO dao = (WayagentbchDAO) DAOFactory.build(WayagentbchDAO.class, user );
        WayagentbchListVO listVO = new WayagentbchListVO();
        listVO.set_se_bchtype(bchtype);
    return dao.query(listVO);
    }
}
