/**
 * auto-generated code
 * Mon Sep 14 17:08:10 CST 2009
 */
package com.gmcc.pboss.control.promotion.presentingblog;

import java.io.Serializable;

import com.gmcc.pboss.business.promotion.presentingblog.PresentingblogDBParam;
import com.gmcc.pboss.business.promotion.presentingblog.PresentingblogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Presentingblog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public interface Presentingblog extends AbstractControl {
    public PresentingblogVO doCreate(PresentingblogVO vo) throws Exception;

    public void doRemoveByVO(PresentingblogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public PresentingblogVO doUpdate(PresentingblogVO vo) throws Exception;

    public PresentingblogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(PresentingblogDBParam params) throws Exception;

}
