/**
 * auto-generated code
 * Mon Sep 14 17:09:30 CST 2009
 */
package com.gmcc.pboss.control.promotion.presentinga;

import java.io.Serializable;

import com.gmcc.pboss.business.promotion.presentinga.PresentingaDBParam;
import com.gmcc.pboss.business.promotion.presentinga.PresentingaVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Presentinga </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public interface Presentinga extends AbstractControl {
    public PresentingaVO doCreate(PresentingaVO vo) throws Exception;

    public void doRemoveByVO(PresentingaVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public PresentingaVO doUpdate(PresentingaVO vo) throws Exception;

    public PresentingaVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(PresentingaDBParam params) throws Exception;

}
