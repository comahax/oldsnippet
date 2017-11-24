/**
 * auto-generated code
 * Mon Sep 07 10:51:00 CST 2009
 */
package com.gmcc.pboss.control.base.operfunctionlog;

import java.io.Serializable;

import com.gmcc.pboss.business.base.operfunctionlog.OperfunctionlogDBParam;
import com.gmcc.pboss.business.base.operfunctionlog.OperfunctionlogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Operfunctionlog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public interface Operfunctionlog extends AbstractControl {
    public OperfunctionlogVO doCreate(OperfunctionlogVO vo) throws Exception;

    public void doRemoveByVO(OperfunctionlogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public OperfunctionlogVO doUpdate(OperfunctionlogVO vo) throws Exception;

    public OperfunctionlogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(OperfunctionlogDBParam params) throws Exception;

}
