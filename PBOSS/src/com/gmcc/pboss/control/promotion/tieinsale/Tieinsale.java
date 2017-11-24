/**
 * auto-generated code
 * Mon Sep 14 16:46:42 CST 2009
 */
package com.gmcc.pboss.control.promotion.tieinsale;

import java.io.Serializable;

import com.gmcc.pboss.business.promotion.tieinsale.TieinsaleDBParam;
import com.gmcc.pboss.business.promotion.tieinsale.TieinsaleVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Tieinsale </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public interface Tieinsale extends AbstractControl {
    public TieinsaleVO doCreate(TieinsaleVO vo) throws Exception;

    public void doRemoveByVO(TieinsaleVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public TieinsaleVO doUpdate(TieinsaleVO vo) throws Exception;

    public TieinsaleVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(TieinsaleDBParam params) throws Exception;

}
