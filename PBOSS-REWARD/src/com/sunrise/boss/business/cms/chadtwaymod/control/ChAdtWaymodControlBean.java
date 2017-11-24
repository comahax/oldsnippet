/**
* auto-generated code
* Sat Jan 12 10:23:04 CST 2013
*/
package com.sunrise.boss.business.cms.chadtwaymod.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.chadtwaymod.persistent.ChAdtWaymodVO;
import com.sunrise.boss.business.cms.chadtwaymod.persistent.ChAdtWaymodDAO;
import com.sunrise.boss.business.cms.chadtwaymod.persistent.ChAdtWaymodListVO;
import com.sunrise.boss.business.cms.chpwwaybusicircle.control.ChPwWaybusicircleControl;
import com.sunrise.boss.business.cms.chpwwaybusicircle.persistent.ChPwWaybusicircleDAO;
import com.sunrise.boss.business.cms.chpwwaybusicircle.persistent.ChPwWaybusicircleVO;

/**
 * <p>Title: ChAdtWaymodControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/chadtwaymod/control/ChAdtWaymodControlBean"
 name="ChAdtWaymodControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class ChAdtWaymodControlBean extends AbstractControlBean
    implements ChAdtWaymodControl {

    public ChAdtWaymodVO doCreate(ChAdtWaymodVO vo, User user)
        throws Exception {
        try{
        	ChAdtWaymodDAO dao = (ChAdtWaymodDAO) DAOFactory.build(ChAdtWaymodDAO.class, user);
        	vo = (ChAdtWaymodVO) dao.create(vo);
        	
        	ChPwWaybusicircleDAO waybusicircleDAO = (ChPwWaybusicircleDAO) DAOFactory.build(ChPwWaybusicircleDAO.class, user);
        	ChPwWaybusicircleVO waybusicircleVO = (ChPwWaybusicircleVO) waybusicircleDAO.findByProperty("wayid", vo.getWayid());
        	if (waybusicircleVO != null) {
        		float mod = vo.getVi() + vo.getArea() + vo.getDoorhead() 
        			+ vo.getBackboard() + vo.getPropaganda();
        		waybusicircleVO.setWaymod(mod);
            	waybusicircleDAO.update(waybusicircleVO);
        	}
            return vo;
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(ChAdtWaymodVO vo, User user)
        throws Exception {
        try{
			ChAdtWaymodDAO dao = (ChAdtWaymodDAO) DAOFactory.build(ChAdtWaymodDAO.class, user);
			dao.remove(vo);
			
			ChPwWaybusicircleDAO waybusicircleDAO = (ChPwWaybusicircleDAO) DAOFactory.build(ChPwWaybusicircleDAO.class, user);
        	ChPwWaybusicircleVO waybusicircleVO = (ChPwWaybusicircleVO) waybusicircleDAO.findByProperty("wayid", vo.getWayid());
        	if (waybusicircleVO != null) {
        		waybusicircleVO.setWaymod(0f);
            	waybusicircleDAO.update(waybusicircleVO);
        	}
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChAdtWaymodVO doUpdate(ChAdtWaymodVO vo, User user)
        throws Exception {
        try{
			ChAdtWaymodDAO dao = (ChAdtWaymodDAO) DAOFactory.build(ChAdtWaymodDAO.class, user);
			vo = (ChAdtWaymodVO) dao.update(vo);
        	
        	ChPwWaybusicircleDAO waybusicircleDAO = (ChPwWaybusicircleDAO) DAOFactory.build(ChPwWaybusicircleDAO.class, user);
        	ChPwWaybusicircleVO waybusicircleVO = (ChPwWaybusicircleVO) waybusicircleDAO.findByProperty("wayid", vo.getWayid());
        	if (waybusicircleVO != null) {
        		float mod = vo.getVi() + vo.getArea() + vo.getDoorhead() 
        			+ vo.getBackboard() + vo.getPropaganda();
        		waybusicircleVO.setWaymod(mod);
            	waybusicircleDAO.update(waybusicircleVO);
        	}
            return vo;
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public ChAdtWaymodVO doFindByPk(Serializable pk, User user)
        throws Exception {
			ChAdtWaymodDAO dao = (ChAdtWaymodDAO) DAOFactory.build(ChAdtWaymodDAO.class, user);
        return (ChAdtWaymodVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(ChAdtWaymodListVO params, User user)
        throws Exception {
			ChAdtWaymodDAO dao = (ChAdtWaymodDAO) DAOFactory.build(ChAdtWaymodDAO.class, user);
        return dao.query(params);
    }
}
