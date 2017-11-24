/**
 * auto-generated code
 * Fri Mar 20 16:55:40 CST 2015
 */
package com.gmcc.pboss.control.communication.chpwcomsrcvobj;

import java.io.Serializable;

import com.gmcc.pboss.business.communication.chpwcomsrcvobj.ChPwComsrcvobjDBParam;
import com.gmcc.pboss.business.communication.chpwcomsrcvobj.ChPwComsrcvobjVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: ChPwComsrcvobj </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public interface ChPwComsrcvobj extends AbstractControl {
    public ChPwComsrcvobjVO doCreate(ChPwComsrcvobjVO vo) throws Exception;

    public void doRemoveByVO(ChPwComsrcvobjVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public ChPwComsrcvobjVO doUpdate(ChPwComsrcvobjVO vo) throws Exception;

    public ChPwComsrcvobjVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(ChPwComsrcvobjDBParam params) throws Exception;

}
