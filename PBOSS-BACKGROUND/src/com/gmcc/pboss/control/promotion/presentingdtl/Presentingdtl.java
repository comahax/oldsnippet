/**
 * auto-generated code
 * Fri Sep 18 10:50:26 CST 2009
 */
package com.gmcc.pboss.control.promotion.presentingdtl;

import java.io.Serializable;

import com.gmcc.pboss.business.promotion.presentingdtl.PresentingdtlDBParam;
import com.gmcc.pboss.business.promotion.presentingdtl.PresentingdtlVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Presentingdtl </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Presentingdtl extends AbstractControl {
    public PresentingdtlVO doCreate(PresentingdtlVO vo) throws Exception;

    public void doRemoveByVO(PresentingdtlVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public PresentingdtlVO doUpdate(PresentingdtlVO vo) throws Exception;

    public PresentingdtlVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(PresentingdtlDBParam params) throws Exception;

}
