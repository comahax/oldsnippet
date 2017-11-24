/**
 * auto-generated code
 * Wed Sep 02 14:03:48 CST 2009
 */
package com.gmcc.pboss.control.resource.emptysimlog;

import java.io.Serializable;

import com.gmcc.pboss.business.resource.emptysimlog.EmptysimlogDBParam;
import com.gmcc.pboss.business.resource.emptysimlog.EmptysimlogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Emptysimlog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Emptysimlog extends AbstractControl {
    public EmptysimlogVO doCreate(EmptysimlogVO vo) throws Exception;

    public void doRemoveByVO(EmptysimlogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public EmptysimlogVO doUpdate(EmptysimlogVO vo) throws Exception;

    public EmptysimlogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(EmptysimlogDBParam params) throws Exception;

}
