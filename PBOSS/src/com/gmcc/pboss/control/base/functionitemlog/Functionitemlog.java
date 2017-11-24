/**
 * auto-generated code
 * Mon Sep 07 10:48:24 CST 2009
 */
package com.gmcc.pboss.control.base.functionitemlog;

import java.io.Serializable;

import com.gmcc.pboss.business.base.functionitemlog.FunctionitemlogDBParam;
import com.gmcc.pboss.business.base.functionitemlog.FunctionitemlogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Functionitemlog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public interface Functionitemlog extends AbstractControl {
    public FunctionitemlogVO doCreate(FunctionitemlogVO vo) throws Exception;

    public void doRemoveByVO(FunctionitemlogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public FunctionitemlogVO doUpdate(FunctionitemlogVO vo) throws Exception;

    public FunctionitemlogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(FunctionitemlogDBParam params) throws Exception;

}
