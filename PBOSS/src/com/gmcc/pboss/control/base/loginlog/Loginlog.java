/**
 * auto-generated code
 * Mon Dec 20 10:03:23 CST 2010
 */
package com.gmcc.pboss.control.base.loginlog;

import java.io.Serializable;

import com.gmcc.pboss.business.base.loginlog.LoginlogDBParam;
import com.gmcc.pboss.business.base.loginlog.LoginlogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Loginlog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Loginlog extends AbstractControl {
    public LoginlogVO doCreate(LoginlogVO vo) throws Exception;

    public void doRemoveByVO(LoginlogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public LoginlogVO doUpdate(LoginlogVO vo) throws Exception;

    public LoginlogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(LoginlogDBParam params) throws Exception;

}
