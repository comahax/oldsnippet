/**
 * auto-generated code
 * 2006.08.08
 */
package com.sunrise.boss.business.fee.integral.custintedeta.control;

import com.sunrise.boss.business.fee.integral.custintedeta.persistent.CustInteDetaListVO;
import com.sunrise.boss.business.fee.integral.custintedeta.persistent.CustInteDetaVO;
import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * Title: CustInteDetaControl Description: Copyright: Copyright (c) 2006 
 * Company: sunrise Tech Ltd.
 * 
 * @author mys
 * @version 1.0
 */
public interface CustInteDetaControl extends AbstractControl {


	public CustInteDetaVO findByObj(CustInteDetaVO params, User user)
	throws Exception;
	
	public DataPackage doQuery(CustInteDetaListVO params, User user) throws Exception;
	public DataPackage doQuery1(CustInteDetaListVO params, User user) throws Exception;
	
	public CustInteDetaVO doUpdate(CustInteDetaVO params, User user)throws Exception;
	 
	
	
	public void doBatch(CustInteDetaVO params, User user)throws Exception ;
}
