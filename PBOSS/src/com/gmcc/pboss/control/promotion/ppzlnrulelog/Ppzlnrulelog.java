/**
 * auto-generated code
 * Thu Sep 17 15:13:36 CST 2009
 */
package com.gmcc.pboss.control.promotion.ppzlnrulelog;

import java.io.Serializable;

import com.gmcc.pboss.business.promotion.ppzlnrulelog.PpzlnrulelogDBParam;
import com.gmcc.pboss.business.promotion.ppzlnrulelog.PpzlnrulelogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Ppzlnrulelog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Ppzlnrulelog extends AbstractControl {
    public PpzlnrulelogVO doCreate(PpzlnrulelogVO vo) throws Exception;

    public void doRemoveByVO(PpzlnrulelogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public PpzlnrulelogVO doUpdate(PpzlnrulelogVO vo) throws Exception;

    public PpzlnrulelogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(PpzlnrulelogDBParam params) throws Exception;

}
