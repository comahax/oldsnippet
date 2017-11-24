/**
 * auto-generated code
 * Mon Mar 23 12:59:35 CST 2015
 */
package com.gmcc.pboss.control.communication.chpwcomsadvinfolog;

import java.io.Serializable;

import com.gmcc.pboss.business.communication.chpwcomsadvinfolog.ChPwComsadvinfologDBParam;
import com.gmcc.pboss.business.communication.chpwcomsadvinfolog.ChPwComsadvinfologVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: ChPwComsadvinfolog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public interface ChPwComsadvinfolog extends AbstractControl {
    public ChPwComsadvinfologVO doCreate(ChPwComsadvinfologVO vo) throws Exception;

    public void doRemoveByVO(ChPwComsadvinfologVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public ChPwComsadvinfologVO doUpdate(ChPwComsadvinfologVO vo) throws Exception;

    public ChPwComsadvinfologVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(ChPwComsadvinfologDBParam params) throws Exception;

}
