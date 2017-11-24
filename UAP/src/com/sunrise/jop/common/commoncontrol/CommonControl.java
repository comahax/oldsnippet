package com.sunrise.jop.common.commoncontrol;

import java.io.Serializable;

import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;



public interface CommonControl extends AbstractControl {
	
	public Class getVoClass() ;

	public void setVoClass(Class voClass) ;
	
    public Object doCreate(Object vo) throws Exception;

    public void doRemoveByVO(Object vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;

    public Object doUpdate(Object vo) throws Exception;

    public Object doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(Object params) throws Exception;
    
	public long getSequence(String sequencename) throws Exception;
    
//    public Object doUpdateWithModifyPK(Object oldVO, Object newVO) throws Exception ;
//
//    public int doCount(Class voClass, Object params, DBAccessUser user) throws Exception;
//
//	public DataPackage queryByNamedSqlQuery(Class voClass, String name, Object params, DBAccessUser user) throws Exception;
//
//	public Object queryUniqueByNamedSqlQuery(Class voClass, String name, Object params, Class returnType, DBAccessUser user) throws Exception;
//
//	public DataPackage queryBySql(Class voClass, String queryString, Object params, DBAccessUser user) throws Exception;
//

    //--------------for log---------------------
/*    public Object doCreate(Object vo, Class voClass, Object logvo, Class logVoClass, User user) throws Exception;

    public void doRemoveByVO(Object vo, Class voClass, Object logvo, Class logVoClass, User user) throws Exception;

    public void doRemoveByPK(Serializable pk, Class voClass, Object logvo, Class logVoClass, User user) throws Exception;

    public Object doUpdate(Object vo, Class voClass, Object logvo, Class logVoClass, User user) throws Exception;

    public Object doUpdate2(Object vo, Class voClass, Object oldLogvo, Object newLogvo, Class logVoClass, User user) throws Exception;
    
    //--------------------for manage log --------------------------
    public Object doCreateWithManageLog(Object vo, Class voClass, User user) throws Exception;

    public void doRemoveByVoWithManageLog(Object vo, Class voClass, User user) throws Exception;

    public void doRemoveByPkWithManageLog(Serializable pk, Class voClass, User user) throws Exception;

    public Object doUpdateWithManageLog(Object vo, Class voClass, User user) throws Exception;
 */
}
