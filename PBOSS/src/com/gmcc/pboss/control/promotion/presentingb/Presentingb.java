/**
 * auto-generated code
 * Mon Sep 14 17:07:50 CST 2009
 */
package com.gmcc.pboss.control.promotion.presentingb;

import java.io.Serializable;

import com.gmcc.pboss.business.promotion.presentingb.PresentingbDBParam;
import com.gmcc.pboss.business.promotion.presentingb.PresentingbVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Presentingb </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public interface Presentingb extends AbstractControl {
    public PresentingbVO doCreate(PresentingbVO vo) throws Exception;

    public void doRemoveByVO(PresentingbVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public PresentingbVO doUpdate(PresentingbVO vo) throws Exception;

    public PresentingbVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(PresentingbDBParam params) throws Exception;

}
