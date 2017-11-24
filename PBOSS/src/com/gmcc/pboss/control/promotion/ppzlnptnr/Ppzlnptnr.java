/**
 * auto-generated code
 * Thu Sep 17 15:14:35 CST 2009
 */
package com.gmcc.pboss.control.promotion.ppzlnptnr;

import java.io.Serializable;
import java.util.List;

import com.gmcc.pboss.business.promotion.ppzlnptnr.PpzlnptnrDBParam;
import com.gmcc.pboss.business.promotion.ppzlnptnr.PpzlnptnrVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Ppzlnptnr </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Ppzlnptnr extends AbstractControl {
    public PpzlnptnrVO doCreate(PpzlnptnrVO vo) throws Exception;

    public void doRemoveByVO(PpzlnptnrVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public PpzlnptnrVO doUpdate(PpzlnptnrVO vo) throws Exception;

    public PpzlnptnrVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(PpzlnptnrDBParam params) throws Exception;
    
    public List<String> doQueryWayVo(String countyid, String starlevel) throws Exception;
    
    public PpzlnptnrVO doFindByVO(PpzlnptnrVO vo) throws Exception;
    
}
