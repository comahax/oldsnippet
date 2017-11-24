/**
 * auto-generated code
 * Tue Oct 13 09:30:24 CST 2009
 */
package com.gmcc.pboss.control.sales.chargesum;

import java.io.Serializable;
import java.util.Map;

import com.gmcc.pboss.business.sales.chargesum.ChargesumDBParam;
import com.gmcc.pboss.business.sales.chargesum.ChargesumVO;
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
public interface Chargesum extends AbstractControl {
    public ChargesumVO doCreate(ChargesumVO vo) throws Exception;

    public void doRemoveByVO(ChargesumVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public ChargesumVO doUpdate(ChargesumVO vo) throws Exception;

    public ChargesumVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(ChargesumDBParam params) throws Exception;
    
    public DataPackage doQueryChargesum(Map<String,String> conditionMap, ChargesumDBParam param) throws Exception;
}
