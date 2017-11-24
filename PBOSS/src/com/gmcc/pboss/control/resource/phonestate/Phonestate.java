/**
 * auto-generated code
 * Mon Jul 04 16:25:21 CST 2011
 */
package com.gmcc.pboss.control.resource.phonestate;

import java.io.Serializable;

import com.gmcc.pboss.business.resource.phonestate.PhonestateDBParam;
import com.gmcc.pboss.business.resource.phonestate.PhonestateVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Phonestate </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author lyl
 * @version 1.0
 */
public interface Phonestate extends AbstractControl {
    public PhonestateVO doCreate(PhonestateVO vo) throws Exception;

    public void doRemoveByVO(PhonestateVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public PhonestateVO doUpdate(PhonestateVO vo) throws Exception;

    public PhonestateVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(PhonestateDBParam params) throws Exception; 
    
    public DataPackage doChooseData (PhonestateDBParam params) throws Exception; 
    
    public DataPackage QueryOrderidByComresid (String comsid) throws Exception;
}
