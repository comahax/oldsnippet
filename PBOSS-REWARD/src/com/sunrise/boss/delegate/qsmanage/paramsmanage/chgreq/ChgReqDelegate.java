/**
* auto-generated code
* Fri Jul 11 10:08:49 CST 2008
*/
package com.sunrise.boss.delegate.qsmanage.paramsmanage.chgreq;

import com.sunrise.boss.business.qsmanage.paramsmanage.chgreq.control.ChgReqControl;
import com.sunrise.boss.business.qsmanage.paramsmanage.chgreq.control.ChgReqControlBean;
import com.sunrise.boss.business.qsmanage.paramsmanage.chgreq.persistent.ChgReqVO;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: ChgReqDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ChgReqDelegate {

    private static ChgReqControl control;

    public ChgReqDelegate() throws Exception {
        control = (ChgReqControl) ControlFactory.build(ChgReqControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

	
	public void doUpdate(ChgReqVO vo,User user) throws Exception{
		control.doUpdate(vo, user);
	}
	
	public void doBatch(ChgReqVO vo,User user) throws Exception{
		control.doBatch(vo, user);
	}
}
