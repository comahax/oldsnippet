/**
* auto-generated code
* Thu Aug 24 11:07:55 CST 2006
*/
package com.sunrise.boss.business.cms.areacenter.control;

import java.io.Serializable;

import com.sunrise.boss.business.cms.areacenter.persistent.AreacenterDAO;
import com.sunrise.boss.business.cms.areacenter.persistent.AreacenterListVO;
import com.sunrise.boss.business.cms.areacenter.persistent.AreacenterVO;
import com.sunrise.boss.business.cms.citycompany.control.CitycompanyControl;
import com.sunrise.boss.business.cms.citycompany.control.CitycompanyControlBean;
import com.sunrise.boss.business.cms.way.control.WayControl;
import com.sunrise.boss.business.cms.way.control.WayControlBean;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: AreacenterControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/boss/business/cms/areacenter/control/AreacenterControlBean"
*    name="AreacenterControl"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class AreacenterControlBean extends AbstractControlBean
    implements AreacenterControl {

    public AreacenterVO doCreate(AreacenterVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
         AreacenterDAO dao = (AreacenterDAO) DAOFactory.build(AreacenterDAO.class, user);
            return (AreacenterVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(AreacenterVO vo, User user)
        throws Exception {
        try{
         AreacenterDAO dao = (AreacenterDAO) DAOFactory.build(AreacenterDAO.class, user);
         //TODO: 删除检查
         
         CitycompanyControl citycompanyControl = (CitycompanyControl)ControlFactory.build( CitycompanyControlBean.class);
         DataPackage citys = citycompanyControl.getCitycompanysOfCenter(vo.getCenterid(), user);
         if(citys.getDatas().size() > 0)
        	 //throw new BusinessException("CMS-10001","Center in use by citycom!");
        	 throw new BusinessException("","区域中心正在使用，不能删除");
         
         WayControl wayControl = (WayControl)ControlFactory.build(WayControlBean.class);
         DataPackage ways = wayControl.getWaysOfCenter( vo.getCenterid() , user);
         if(ways.getDatas().size() > 0)
        	 throw new BusinessException("","区域中心被渠道使用，不能删除");
        	 //throw new BusinessException("CMS-10002","Center in use by way!");
         
         dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public AreacenterVO doUpdate(AreacenterVO vo, User user)
        throws Exception {
        try{
         AreacenterDAO dao = (AreacenterDAO) DAOFactory.build(AreacenterDAO.class, user);
            return (AreacenterVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public AreacenterVO doFindByPk(Serializable pk, User user)
        throws Exception {
         AreacenterDAO dao = (AreacenterDAO) DAOFactory.build(AreacenterDAO.class, user);
        return (AreacenterVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(AreacenterListVO params, User user)
        throws Exception {
         AreacenterDAO dao = (AreacenterDAO) DAOFactory.build(AreacenterDAO.class, user);
        return dao.query(params);
    }
    
    public DataPackage getCenters(User user) throws Exception {
    	AreacenterDAO dao = (AreacenterDAO) DAOFactory.build(AreacenterDAO.class, user);
    	AreacenterListVO listVO = new AreacenterListVO();
    	listVO.set_pagesize("0");
    	return dao.query(dao);    	
    }
}
