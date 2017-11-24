/**
 * auto-generated code
 * Mon Sep 14 16:43:36 CST 2009
 */
package com.gmcc.pboss.control.promotion.pquantity;

import java.io.Serializable;

import com.gmcc.pboss.business.promotion.pquantity.PquantityDBParam;
import com.gmcc.pboss.business.promotion.pquantity.PquantityVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Pquantity </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public interface Pquantity extends AbstractControl {
    public PquantityVO doCreate(PquantityVO vo) throws Exception;

    public void doRemoveByVO(PquantityVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public PquantityVO doUpdate(PquantityVO vo) throws Exception;

    public PquantityVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(PquantityDBParam params) throws Exception;

}
