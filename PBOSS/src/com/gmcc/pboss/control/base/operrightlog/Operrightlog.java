/**
 * auto-generated code
 * Mon Sep 07 10:51:49 CST 2009
 */
package com.gmcc.pboss.control.base.operrightlog;

import java.io.Serializable;

import com.gmcc.pboss.business.base.operrightlog.OperrightlogDBParam;
import com.gmcc.pboss.business.base.operrightlog.OperrightlogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Operrightlog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public interface Operrightlog extends AbstractControl {
    public OperrightlogVO doCreate(OperrightlogVO vo) throws Exception;

    public void doRemoveByVO(OperrightlogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public OperrightlogVO doUpdate(OperrightlogVO vo) throws Exception;

    public OperrightlogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(OperrightlogDBParam params) throws Exception;

}
