/**
* auto-generated code
* 2006.08.08
*/
package com.sunrise.boss.business.fee.integral.custintechg.control;

import com.sunrise.boss.business.fee.integral.custintechg.persistent.CustInteChgListVO;
import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: CustInteChgControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author mys
 * @version 1.0
 */
public interface CustInteChgControl extends AbstractControl {
   
 
  
    public DataPackage doQueryInteLog(CustInteChgListVO params, User user)
        throws Exception;


	public void doInteback(Long logid, User user) throws Exception;



}
