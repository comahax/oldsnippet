/**
 * auto-generated code
 * Wed Sep 02 16:29:57 CST 2009
 */
package com.gmcc.pboss.control.resource.comressmplog;

import java.io.Serializable;

import com.gmcc.pboss.business.resource.comressmplog.ComressmplogDBParam;
import com.gmcc.pboss.business.resource.comressmplog.ComressmplogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Comressmplog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Comressmplog extends AbstractControl {
    public ComressmplogVO doCreate(ComressmplogVO vo) throws Exception;

    public void doRemoveByVO(ComressmplogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public ComressmplogVO doUpdate(ComressmplogVO vo) throws Exception;

    public ComressmplogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(ComressmplogDBParam params) throws Exception;

}
