/**
* auto-generated code
* Sat Aug 26 11:34:28 CST 2006
*/
package com.sunrise.boss.business.cms.wayentitybch.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.pub.tools.Sequence;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.wayentitybch.persistent.WayentitybchVO;
import com.sunrise.boss.business.cms.wayentitybch.persistent.WayentitybchDAO;
import com.sunrise.boss.business.cms.wayentitybch.persistent.WayentitybchListVO;

/**
 * <p>Title: WayentitybchControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/boss/business/cms/wayentitybch/control/WayentitybchControlBean"
*    name="WayentitybchControl"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class WayentitybchControlBean extends AbstractControlBean
    implements WayentitybchControl {

    public WayentitybchVO doCreate(WayentitybchVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
         WayentitybchDAO dao = (WayentitybchDAO) DAOFactory.build(WayentitybchDAO.class, user );
            return (WayentitybchVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(WayentitybchVO vo, User user)
        throws Exception {
        try{
         WayentitybchDAO dao = (WayentitybchDAO) DAOFactory.build(WayentitybchDAO.class, user );
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public WayentitybchVO doUpdate(WayentitybchVO vo, User user)
        throws Exception {
        try{
         WayentitybchDAO dao = (WayentitybchDAO) DAOFactory.build(WayentitybchDAO.class, user );
            return (WayentitybchVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public WayentitybchVO doFindByPk(Serializable pk, User user)
        throws Exception {
         WayentitybchDAO dao = (WayentitybchDAO) DAOFactory.build(WayentitybchDAO.class, user );
        return (WayentitybchVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(WayentitybchListVO params, User user)
        throws Exception {
         WayentitybchDAO dao = (WayentitybchDAO) DAOFactory.build(WayentitybchDAO.class, user );
        return dao.query(params);
    }
    public DataPackage getByBchtype(String bchtype, User user)
       throws Exception {
    	WayentitybchDAO dao = (WayentitybchDAO) DAOFactory.build(WayentitybchDAO.class, user );
    	WayentitybchListVO listVO = new WayentitybchListVO();
        listVO.set_se_bchtype(bchtype);
        return dao.query(listVO);
     }
}
