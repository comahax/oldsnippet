package com.sunrise.boss.business.common;

import java.io.Serializable;

import com.sunrise.boss.business.common.managelog.persistent.ManageLogDAO;
import com.sunrise.boss.business.common.managelog.persistent.OperAction;
import com.sunrise.boss.business.common.managelog.persistent.OperState;
import com.sunrise.boss.business.fee.common.FEEUtils;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
* @ejb.bean
*    local-jndi-name="com/sunrise/boss/business/common/CommonControlBean"
*    name="CommonControl"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class CommonControlBean extends AbstractControlBean implements CommonControl {

    public Object doCreate(Object vo, Class voClass, User user) throws Exception {

        BaseDAO ordinaryDAO = new BaseDAO(voClass,user.getCityid());
        try {
            vo = ordinaryDAO.create(vo);
            return vo;
        }
        catch (Exception ex) {
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemoveByVO(Object vo, Class voClass, User user) throws Exception {
        BaseDAO ordinaryDAO = new BaseDAO(voClass,user.getCityid());
        try {
            ordinaryDAO.remove(vo);
        }
        catch (Exception ex) {
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemoveByPK(Serializable pk, Class voClass, User user) throws Exception {
        BaseDAO ordinaryDAO = new BaseDAO(voClass,user.getCityid());
        try {
            ordinaryDAO.removeByPk(pk);
        }
        catch (Exception ex) {
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public Object doUpdate(Object vo, Class voClass, User user) throws Exception {
        BaseDAO ordinaryDAO = new BaseDAO(voClass,user.getCityid());
        try {
            vo = ordinaryDAO.update(vo);
            return vo;
        }
        catch (Exception ex) {
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public Object doUpdateWithModifyPK(Object oldVO, Object newVO, Class voClass, User user) throws Exception {
        BaseDAO ordinaryDAO = new BaseDAO(voClass,user.getCityid());
        try {
            newVO = ordinaryDAO.create(newVO);
            ordinaryDAO.remove(oldVO);
            return newVO;
        }
        catch (Exception ex) {
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public Object doFindByPk(Serializable pk, Class voClass, User user) throws Exception {
        BaseDAO ordinaryDAO = new BaseDAO(voClass,user.getCityid());
        return ordinaryDAO.findByPk(pk);
    }

    public DataPackage doQuery(Object params, Class voClass, User user) throws Exception {
        BaseDAO ordinaryDAO = new BaseDAO(voClass,user.getCityid());
        return ordinaryDAO.query(params);
    }
   
    /**
     * 
     */
    public DataPackage doQuery(Object params, Class voClass, User user,boolean getRcdCount) throws Exception {
        BaseDAO ordinaryDAO = new BaseDAO(voClass,user.getCityid());
        return ordinaryDAO.query(params,getRcdCount);
    }

    //--------------------------for log--------------------------------------------
    public Object doCreate(Object vo, Class voClass, Object logvo, Class logVoClass, User user) throws Exception {

        BaseDAO ordinaryDAO = new BaseDAO(voClass,user.getCityid());
        BaseDAO logDAO = new BaseDAO(logVoClass,user.getCityid());
        try {
            vo = ordinaryDAO.create(vo);
            logDAO.create(logvo);
            return vo;
        }
        catch (Exception ex) {
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemoveByVO(Object vo, Class voClass, Object logvo, Class logVoClass, User user) throws Exception {
        BaseDAO ordinaryDAO = new BaseDAO(voClass,user.getCityid());
        BaseDAO logDAO = new BaseDAO(logVoClass,user.getCityid());
        try {
            ordinaryDAO.remove(vo);
            logDAO.create(logvo);
        }
        catch (Exception ex) {
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemoveByPK(Serializable pk, Class voClass, Object logvo, Class logVoClass, User user) throws Exception {
        BaseDAO ordinaryDAO = new BaseDAO(voClass,user.getCityid());
        BaseDAO logDAO = new BaseDAO(logVoClass,user.getCityid());
        try {
            ordinaryDAO.removeByPk(pk);
            logDAO.create(logvo);
        }
        catch (Exception ex) {
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public Object doUpdate(Object vo, Class voClass, Object logvo, Class logVoClass, User user) throws Exception {
        BaseDAO ordinaryDAO = new BaseDAO(voClass,user.getCityid());
        BaseDAO logDAO = new BaseDAO(logVoClass,user.getCityid());
        try {
            vo = ordinaryDAO.update(vo);
            logDAO.create(logvo);
            return vo;
        }
        catch (Exception ex) {
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public Object doUpdate2(Object vo, Class voClass, Object oldLogvo, Object newLogvo, Class logVoClass, User user) throws Exception {
        BaseDAO ordinaryDAO = new BaseDAO(voClass,user.getCityid());
        BaseDAO logDAO = new BaseDAO(logVoClass,user.getCityid());
        try {
            vo = ordinaryDAO.update(vo);
            logDAO.create(oldLogvo);
            logDAO.create(newLogvo);
            return vo;
        }
        catch (Exception ex) {
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public int doCount(Class voClass, Object params, User user) throws Exception{
        BaseDAO ordinaryDAO = new BaseDAO(voClass,user.getCityid());
        return ordinaryDAO.count(params);
    }

    //  --------------------for manage log --------------------------
    public Object doCreateWithManageLog(Object vo, Class voClass, User user) throws Exception {
        ManageLogDAO mdao = (ManageLogDAO) DAOFactory.build(ManageLogDAO.class, user.getCityid());
        BaseDAO ordinaryDAO = new BaseDAO(voClass,user.getCityid());
        try {
            vo = ordinaryDAO.create(vo);
            mdao.manageLog(user, vo.getClass().getName(), OperAction.INSERT, null,
			  		 vo, OperState.SUCCESS);
            return vo;
        }
        catch (Exception ex) {
            sessionContext.setRollbackOnly();
            throw ex;
        }
	}

	public void doRemoveByPkWithManageLog(Serializable pk, Class voClass, User user) throws Exception {
        ManageLogDAO mdao = (ManageLogDAO) DAOFactory.build(ManageLogDAO.class, user.getCityid());
		BaseDAO ordinaryDAO = new BaseDAO(voClass,user.getCityid());
        try {
        	Object vo = ordinaryDAO.findByPk(pk);
        	mdao.manageLog(user, vo.getClass().getName(), OperAction.DELETE, null,
			  		 vo, OperState.SUCCESS);
        	ordinaryDAO.removeByPk(pk);

        }
        catch (Exception ex) {
            sessionContext.setRollbackOnly();
            throw ex;
        }

	}

	public void doRemoveByVoWithManageLog(Object vo, Class voClass, User user) throws Exception {
        ManageLogDAO mdao = (ManageLogDAO) DAOFactory.build(ManageLogDAO.class, user.getCityid());
		BaseDAO ordinaryDAO = new BaseDAO(voClass,user.getCityid());
        try {
        	mdao.manageLog(user, vo.getClass().getName(), OperAction.DELETE, null,
			  		 vo, OperState.SUCCESS);
        	ordinaryDAO.remove(vo);

        }
        catch (Exception ex) {
            sessionContext.setRollbackOnly();
            throw ex;
        }

	}

	public Object doUpdateWithManageLog(Object vo, Class voClass, User user) throws Exception {
        ManageLogDAO mdao = (ManageLogDAO) DAOFactory.build(ManageLogDAO.class, user.getCityid());
		BaseDAO ordinaryDAO = new BaseDAO(voClass,user.getCityid());
        try {
        	mdao.manageLog(user, vo.getClass().getName(), OperAction.UPDATE, null,
			  		 vo, OperState.SUCCESS);
        	vo =ordinaryDAO.update(vo);
            return vo;
        }
        catch (Exception ex) {
            sessionContext.setRollbackOnly();
            throw ex;
        }
	}

	public Long getSequence(String sequence, User user) throws Exception {
		return new Long(FEEUtils.getSequence(sequence, user));
	}
}
