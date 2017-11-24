/**
 * auto-generated code
 * Mon Mar 23 12:58:46 CST 2015
 */
package com.gmcc.pboss.control.communication.chpwcomsadvinfo;

import java.io.Serializable;

import com.gmcc.pboss.business.communication.chpwcomsadvinfo.ChPwComsadvinfoDBParam;
import com.gmcc.pboss.business.communication.chpwcomsadvinfo.ChPwComsadvinfoVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: ChPwComsadvinfo </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public interface ChPwComsadvinfo extends AbstractControl {
    public ChPwComsadvinfoVO doCreate(ChPwComsadvinfoVO vo) throws Exception;

    public void doRemoveByVO(ChPwComsadvinfoVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public ChPwComsadvinfoVO doUpdate(ChPwComsadvinfoVO vo) throws Exception;

    public ChPwComsadvinfoVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(ChPwComsadvinfoDBParam params) throws Exception;

    public ChPwComsadvinfoVO doRelease(ChPwComsadvinfoVO advinfoVO) throws Exception;

    public void doUpdateAdvinfo(ChPwComsadvinfoVO vo) throws Exception;

    public DataPackage doCityList(ChPwComsadvinfoDBParam params) throws Exception;

}
