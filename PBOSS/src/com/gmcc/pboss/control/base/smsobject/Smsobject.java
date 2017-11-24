/**
 * auto-generated code
 * Tue Jul 05 09:55:04 CST 2011
 */
package com.gmcc.pboss.control.base.smsobject;

import java.io.Serializable;

import com.gmcc.pboss.business.base.smsobject.SmsobjectDBParam;
import com.gmcc.pboss.business.base.smsobject.SmsobjectVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Smsobject </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author lyl
 * @version 1.0
 */
public interface Smsobject extends AbstractControl {
    public SmsobjectVO doCreate(SmsobjectVO vo) throws Exception;

    public void doRemoveByVO(SmsobjectVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public SmsobjectVO doUpdate(SmsobjectVO vo) throws Exception;

    public SmsobjectVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(SmsobjectDBParam params) throws Exception;

}
