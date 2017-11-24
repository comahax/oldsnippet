/**
 * auto-generated code
 * Thu Sep 17 15:17:36 CST 2009
 */
package com.gmcc.pboss.control.promotion.ppzlnres;

import java.io.Serializable;

import com.gmcc.pboss.business.promotion.ppzlnres.PpzlnresDBParam;
import com.gmcc.pboss.business.promotion.ppzlnres.PpzlnresVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Ppzlnres </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Ppzlnres extends AbstractControl {
    public PpzlnresVO doCreate(PpzlnresVO vo) throws Exception;

    public void doRemoveByVO(PpzlnresVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public PpzlnresVO doUpdate(PpzlnresVO vo) throws Exception;

    public PpzlnresVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(PpzlnresDBParam params) throws Exception;
    
    public DataPackage doQueryComcategory(PpzlnresDBParam params) throws Exception;
    
    public PpzlnresVO doFindByVO(PpzlnresVO vo) throws Exception;

}
