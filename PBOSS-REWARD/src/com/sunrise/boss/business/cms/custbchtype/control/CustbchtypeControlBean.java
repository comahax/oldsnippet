/**
* auto-generated code
* Fri Aug 25 11:26:23 CST 2006
*/
package com.sunrise.boss.business.cms.custbchtype.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.custbchtype.persistent.CustbchtypeVO;
import com.sunrise.boss.business.cms.custbchtype.persistent.CustbchtypeDAO;
import com.sunrise.boss.business.cms.custbchtype.persistent.CustbchtypeListVO;
import com.sunrise.boss.business.cms.wayagentbch.control.WayagentbchControl;
import com.sunrise.boss.business.cms.wayagentbch.control.WayagentbchControlBean;
import com.sunrise.boss.business.cms.wayentitybch.control.WayentitybchControl;
import com.sunrise.boss.business.cms.wayentitybch.control.WayentitybchControlBean;

/**
 * <p>Title: CustbchtypeControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author yjr
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/boss/business/cms/custbchtype/control/CustbchtypeControlBean"
*    name="CustbchtypeControl"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class CustbchtypeControlBean extends AbstractControlBean
    implements CustbchtypeControl {

    public CustbchtypeVO doCreate(CustbchtypeVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
         CustbchtypeDAO dao = (CustbchtypeDAO) DAOFactory.build(CustbchtypeDAO.class, user );
            return (CustbchtypeVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(CustbchtypeVO vo, User user)
        throws Exception {
        try{
         CustbchtypeDAO dao = (CustbchtypeDAO) DAOFactory.build(CustbchtypeDAO.class, user );
         
         WayagentbchControl wayagentbchControl = (WayagentbchControl)ControlFactory.build( WayagentbchControlBean.class);
         DataPackage wayagentbch = wayagentbchControl.getByBchtype(vo.getBchtypecode(), user);
         if(wayagentbch.getDatas().size() > 0)
        	 throw new BusinessException("","网点资料(代理渠道)引用了该自定义网点类别，不能删除");
         
         WayentitybchControl wayentitybchControl = (WayentitybchControl)ControlFactory.build( WayentitybchControlBean.class);
         DataPackage wayentitybch = wayentitybchControl.getByBchtype(vo.getBchtypecode(), user);
         if(wayentitybch.getDatas().size() > 0)
        	 throw new BusinessException("","网点资料(实体渠道)引用了该自定义网点类别，不能删除");
         
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public CustbchtypeVO doUpdate(CustbchtypeVO vo, User user)
        throws Exception {
        try{
         CustbchtypeDAO dao = (CustbchtypeDAO) DAOFactory.build(CustbchtypeDAO.class, user );
            return (CustbchtypeVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public CustbchtypeVO doFindByPk(Serializable pk, User user)
        throws Exception {
         CustbchtypeDAO dao = (CustbchtypeDAO) DAOFactory.build(CustbchtypeDAO.class, user );
        return (CustbchtypeVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(CustbchtypeListVO params, User user)
        throws Exception {
         CustbchtypeDAO dao = (CustbchtypeDAO) DAOFactory.build(CustbchtypeDAO.class, user );
        return dao.query(params);
    }
    
    public DataPackage doFindByCitycompany(String cityid, User user)
       throws Exception {
     CustbchtypeDAO dao = (CustbchtypeDAO) DAOFactory.build(CustbchtypeDAO.class, user );
     CustbchtypeListVO listVO = new CustbchtypeListVO();
     listVO.set_se_citycompid(cityid);
    return dao.query(listVO);
    } 
}
