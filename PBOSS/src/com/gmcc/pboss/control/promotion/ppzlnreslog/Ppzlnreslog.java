/**
 * auto-generated code
 * Thu Sep 17 15:18:01 CST 2009
 */
package com.gmcc.pboss.control.promotion.ppzlnreslog;

import java.io.Serializable;

import com.gmcc.pboss.business.promotion.ppzlnreslog.PpzlnreslogDBParam;
import com.gmcc.pboss.business.promotion.ppzlnreslog.PpzlnreslogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Ppzlnreslog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Ppzlnreslog extends AbstractControl {
    public PpzlnreslogVO doCreate(PpzlnreslogVO vo) throws Exception;

    public void doRemoveByVO(PpzlnreslogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public PpzlnreslogVO doUpdate(PpzlnreslogVO vo) throws Exception;

    public PpzlnreslogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(PpzlnreslogDBParam params) throws Exception;

}
