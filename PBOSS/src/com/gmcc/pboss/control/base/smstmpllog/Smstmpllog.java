/**
 * auto-generated code
 * Mon Dec 21 09:17:48 CST 2009
 */
package com.gmcc.pboss.control.base.smstmpllog;

import java.io.Serializable;

import com.gmcc.pboss.business.base.smstmpllog.SmstmpllogDBParam;
import com.gmcc.pboss.business.base.smstmpllog.SmstmpllogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Smstmpllog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Smstmpllog extends AbstractControl {
    public SmstmpllogVO doCreate(SmstmpllogVO vo) throws Exception;

    public void doRemoveByVO(SmstmpllogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public SmstmpllogVO doUpdate(SmstmpllogVO vo) throws Exception;

    public SmstmpllogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(SmstmpllogDBParam params) throws Exception;

}
