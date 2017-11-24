/**
 * auto-generated code
 * Sat May 29 15:31:56 CST 2010
 */
package com.gmcc.pboss.control.resource.orderresstart;

import com.gmcc.pboss.business.resource.orderresstart.OrderresstartDBParam;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Orderresstart </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Orderresstart extends AbstractControl {
	
	public DataPackage doComresStat(OrderresstartDBParam param,String comstate,String batchno) throws Exception;

	public DataPackage doComresCardStat(OrderresstartDBParam param,String comstate,String batchno) throws Exception;
	
	public DataPackage doKBSIMStat(OrderresstartDBParam param,String comstate,String batchno) throws Exception;
	
	public void doStartSmlp(String batchno) throws Exception ;
	
	public void doStartCard(String batchno)throws Exception;
	
	public void doStartEmptyCard(String batchno)throws Exception;
}
