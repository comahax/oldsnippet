/**
 * auto-generated code
 * Mon Sep 14 17:09:44 CST 2009
 */
package com.gmcc.pboss.control.promotion.presentingalog;

import java.io.Serializable;

import com.gmcc.pboss.business.promotion.presentingalog.PresentingalogDBParam;
import com.gmcc.pboss.business.promotion.presentingalog.PresentingalogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Presentingalog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public interface Presentingalog extends AbstractControl {
    public PresentingalogVO doCreate(PresentingalogVO vo) throws Exception;

    public void doRemoveByVO(PresentingalogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public PresentingalogVO doUpdate(PresentingalogVO vo) throws Exception;

    public PresentingalogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(PresentingalogDBParam params) throws Exception;

}
