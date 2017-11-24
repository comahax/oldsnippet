/**
 * auto-generated code
 * Wed Sep 02 17:20:17 CST 2009
 */
package com.gmcc.pboss.control.resource.comcategoryrelalog;

import java.io.Serializable;

import com.gmcc.pboss.business.resource.comcategoryrelalog.ComcategoryrelalogDBParam;
import com.gmcc.pboss.business.resource.comcategoryrelalog.ComcategoryrelalogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Comcategoryrelalog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Comcategoryrelalog extends AbstractControl {
    public ComcategoryrelalogVO doCreate(ComcategoryrelalogVO vo) throws Exception;

    public void doRemoveByVO(ComcategoryrelalogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public ComcategoryrelalogVO doUpdate(ComcategoryrelalogVO vo) throws Exception;

    public ComcategoryrelalogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(ComcategoryrelalogDBParam params) throws Exception;

}
