/**
* auto-generated code
* Fri Jul 11 10:08:49 CST 2008
*/
package com.sunrise.boss.business.qsmanage.paramsmanage.chgreq.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.qsmanage.paramsmanage.chgreq.persistent.ChgReqVO;

/**
 * <p>Title: ChgReqControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface ChgReqControl extends AbstractControl {
	public void doUpdate(ChgReqVO vo, User user) throws Exception;
	public void doBatch(ChgReqVO vo,User user) throws Exception;
}
