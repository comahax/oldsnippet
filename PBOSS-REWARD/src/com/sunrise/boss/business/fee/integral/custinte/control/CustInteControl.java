/**
 * auto-generated code
 * 2006.08.08
 */
package com.sunrise.boss.business.fee.integral.custinte.control;

import java.util.TreeMap;

import com.sunrise.boss.business.fee.integral.custinte.persistent.CustInteListVO;
import com.sunrise.boss.business.fee.integral.custinte.persistent.CustInteVO;
import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * Title: CustInteControl Description: Copyright: Copyright (c) 2006 
 * Company: sunrise Tech Ltd.
 * 
 * @author mys 
 * @version 1.0
 */
public interface CustInteControl extends AbstractControl {

	public boolean doTransferInte(CustInteListVO params,User user) throws Exception;

	public DataPackage doQuery(CustInteListVO params,User user) throws Exception;
	
	public boolean doBatch(CustInteListVO params, User user) throws Exception ;
	
	public Long[] doTototal(CustInteListVO params, User user) throws Exception;

	public CustInteVO doAdj(CustInteVO vo, Long adjint, Integer intchgrsn, String memo, User user) throws Exception;
	
}