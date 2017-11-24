/**
 * auto-generated code
 * Thu Sep 17 15:15:04 CST 2009
 */
package com.gmcc.pboss.control.promotion.ppzlnptnrlog;

import java.io.Serializable;

import com.gmcc.pboss.business.promotion.ppzlnptnrlog.PpzlnptnrlogDBParam;
import com.gmcc.pboss.business.promotion.ppzlnptnrlog.PpzlnptnrlogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Ppzlnptnrlog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Ppzlnptnrlog extends AbstractControl {
    public PpzlnptnrlogVO doCreate(PpzlnptnrlogVO vo) throws Exception;

    public void doRemoveByVO(PpzlnptnrlogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public PpzlnptnrlogVO doUpdate(PpzlnptnrlogVO vo) throws Exception;

    public PpzlnptnrlogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(PpzlnptnrlogDBParam params) throws Exception;

}
