package com.sunrise.jop.common.commoncontrol;

import java.io.Serializable;

import com.sunrise.boss.business.fee.common.FEEUtils;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.BaseDAO;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;


/**
* @ejb.bean
*    local-jndi-name="com/sunrise/boss/business/common/CommonBO"
*    name="CommonControl"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class CommonBO extends AbstractControlBean implements CommonControl {
	
	private Class voClass;
	
	public Object doCreate(Object vo) throws Exception {
        BaseDAO ordinaryDAO = DAOFactory.buildCommonDAO(voClass, user);
        try {
            vo = ordinaryDAO.create(vo);
            return vo;
        }
        catch (Exception ex) {
        	throw new JOPException(ex);
        }
    }

    public void doRemoveByVO(Object vo) throws Exception {
        BaseDAO ordinaryDAO = DAOFactory.buildCommonDAO(voClass, user);
        try {
            ordinaryDAO.remove(vo);
        }
        catch (Exception ex) {
        	throw new JOPException(ex);
        }
    }

    public void doRemoveByPK(Serializable pk) throws Exception {
        BaseDAO ordinaryDAO = DAOFactory.buildCommonDAO(voClass, user);
        try {
            ordinaryDAO.removeByPk(pk);
        }
        catch (Exception ex) {
        	throw new JOPException(ex);
        }
    }

    public Object doUpdate(Object vo) throws Exception {
        BaseDAO ordinaryDAO = DAOFactory.buildCommonDAO(voClass, user);
        try {
            vo = ordinaryDAO.update(vo);
            return vo;
        }
        catch (Exception ex) {
        	throw new JOPException(ex);
        }
    }

    

    /**
	 * @ejb.interface-method view-type = "local"
	 * @ejb.transaction type="NotSupported"
     */
    public Object doFindByPk(Serializable pk) throws Exception {
        BaseDAO ordinaryDAO = DAOFactory.buildCommonDAO(voClass, user);
        return ordinaryDAO.findByPk(pk);
    }

    /**
	 * @ejb.interface-method view-type = "local"
	 * @ejb.transaction type="NotSupported"
     */
    public DataPackage doQuery(Object params) throws Exception {
        BaseDAO ordinaryDAO = DAOFactory.buildCommonDAO(voClass, user);
        return ordinaryDAO.query(params);
    }
    
	public Class getVoClass() {
		return voClass;
	}

	public void setVoClass(Class voClass) {
		this.voClass = voClass;
	}
	
	public long getSequence(String sequencename) throws Exception {
		return FEEUtils.getSequence(sequencename, user);
	}

}
