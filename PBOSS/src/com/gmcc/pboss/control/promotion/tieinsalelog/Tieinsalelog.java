/**
 * auto-generated code
 * Mon Sep 14 17:03:36 CST 2009
 */
package com.gmcc.pboss.control.promotion.tieinsalelog;

import java.io.Serializable;

import com.gmcc.pboss.business.promotion.tieinsalelog.TieinsalelogDBParam;
import com.gmcc.pboss.business.promotion.tieinsalelog.TieinsalelogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Tieinsalelog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public interface Tieinsalelog extends AbstractControl {
    public TieinsalelogVO doCreate(TieinsalelogVO vo) throws Exception;

    public void doRemoveByVO(TieinsalelogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public TieinsalelogVO doUpdate(TieinsalelogVO vo) throws Exception;

    public TieinsalelogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(TieinsalelogDBParam params) throws Exception;

}
