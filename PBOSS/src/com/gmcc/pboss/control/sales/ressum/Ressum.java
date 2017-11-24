/**
 * auto-generated code
 * Tue Oct 13 09:30:24 CST 2009
 */
package com.gmcc.pboss.control.sales.ressum;

import java.io.Serializable;
import java.util.Map;

import com.gmcc.pboss.business.sales.ressum.RessumDBParam;
import com.gmcc.pboss.business.sales.ressum.RessumVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Comprice </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Ressum extends AbstractControl {
    public RessumVO doCreate(RessumVO vo) throws Exception;

    public void doRemoveByVO(RessumVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public RessumVO doUpdate(RessumVO vo) throws Exception;

    public RessumVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(RessumDBParam params) throws Exception;
    
    public DataPackage doQueryRessum(Map<String,String> conditionMap, RessumDBParam param) throws Exception;
}
