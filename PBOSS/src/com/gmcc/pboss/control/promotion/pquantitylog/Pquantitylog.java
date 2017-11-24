/**
 * auto-generated code
 * Mon Sep 14 16:45:04 CST 2009
 */
package com.gmcc.pboss.control.promotion.pquantitylog;

import java.io.Serializable;

import com.gmcc.pboss.business.promotion.pquantitylog.PquantitylogDBParam;
import com.gmcc.pboss.business.promotion.pquantitylog.PquantitylogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Pquantitylog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public interface Pquantitylog extends AbstractControl {
    public PquantitylogVO doCreate(PquantitylogVO vo) throws Exception;

    public void doRemoveByVO(PquantitylogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public PquantitylogVO doUpdate(PquantitylogVO vo) throws Exception;

    public PquantitylogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(PquantitylogDBParam params) throws Exception;

}
