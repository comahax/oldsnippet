package com.sunrise.boss.business.common;

import java.io.Serializable;


import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.ui.commons.User;

public interface CommonControl extends AbstractControl {

    public Object doCreate(Object vo, Class voClass, User user) throws Exception;

    public void doRemoveByVO(Object vo, Class voClass, User user) throws Exception;

    public void doRemoveByPK(Serializable pk, Class voClass, User user) throws Exception;

    public Object doUpdate(Object vo, Class voClass, User user) throws Exception;

    public Object doFindByPk(Serializable pk, Class voClass, User user) throws Exception;

    public DataPackage doQuery(Object params, Class voClass, User user) throws Exception;
    
    /**added by Ge Aiping***/
    public DataPackage doQuery(Object params, Class voClass, User user,boolean getRcdCount) throws Exception;
    
    public Object doUpdateWithModifyPK(Object oldVO, Object newVO, Class voClass, User user) throws Exception ;

    public int doCount(Class voClass, Object params, User user) throws Exception;


    //--------------for log---------------------
    public Object doCreate(Object vo, Class voClass, Object logvo, Class logVoClass, User user) throws Exception;

    public void doRemoveByVO(Object vo, Class voClass, Object logvo, Class logVoClass, User user) throws Exception;

    public void doRemoveByPK(Serializable pk, Class voClass, Object logvo, Class logVoClass, User user) throws Exception;

    public Object doUpdate(Object vo, Class voClass, Object logvo, Class logVoClass, User user) throws Exception;

    public Object doUpdate2(Object vo, Class voClass, Object oldLogvo, Object newLogvo, Class logVoClass, User user) throws Exception;
    
    //--------------------for manage log --------------------------
    public Object doCreateWithManageLog(Object vo, Class voClass, User user) throws Exception;

    public void doRemoveByVoWithManageLog(Object vo, Class voClass, User user) throws Exception;

    public void doRemoveByPkWithManageLog(Serializable pk, Class voClass, User user) throws Exception;

    public Object doUpdateWithManageLog(Object vo, Class voClass, User user) throws Exception;

	public Long getSequence(String sequence, User user) throws Exception;

}
