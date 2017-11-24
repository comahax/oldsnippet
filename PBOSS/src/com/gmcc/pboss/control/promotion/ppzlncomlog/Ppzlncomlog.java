/**
 * auto-generated code
 * Thu Sep 17 15:16:39 CST 2009
 */
package com.gmcc.pboss.control.promotion.ppzlncomlog;

import java.io.Serializable;

import com.gmcc.pboss.business.promotion.ppzlncomlog.PpzlncomlogDBParam;
import com.gmcc.pboss.business.promotion.ppzlncomlog.PpzlncomlogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Ppzlncomlog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Ppzlncomlog extends AbstractControl {
    public PpzlncomlogVO doCreate(PpzlncomlogVO vo) throws Exception;

    public void doRemoveByVO(PpzlncomlogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public PpzlncomlogVO doUpdate(PpzlncomlogVO vo) throws Exception;

    public PpzlncomlogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(PpzlncomlogDBParam params) throws Exception;

}
