/**
 * auto-generated code
 * Thu Sep 17 15:16:11 CST 2009
 */
package com.gmcc.pboss.control.promotion.ppzlncom;

import java.io.Serializable;

import com.gmcc.pboss.business.promotion.ppzlncom.PpzlncomDBParam;
import com.gmcc.pboss.business.promotion.ppzlncom.PpzlncomVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Ppzlncom </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Ppzlncom extends AbstractControl {
    public PpzlncomVO doCreate(PpzlncomVO vo) throws Exception;

    public void doRemoveByVO(PpzlncomVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public PpzlncomVO doUpdate(PpzlncomVO vo) throws Exception;

    public PpzlncomVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(PpzlncomDBParam params) throws Exception;
    
    public PpzlncomVO doFindByVO(PpzlncomVO vo) throws Exception;
    
}
