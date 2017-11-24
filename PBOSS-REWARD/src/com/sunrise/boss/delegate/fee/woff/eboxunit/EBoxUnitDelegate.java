package com.sunrise.boss.delegate.fee.woff.eboxunit;

import java.io.Serializable;

import com.sunrise.boss.business.fee.print.billebox.persistent.BillEboxVO;
import com.sunrise.boss.business.fee.woff.eboxunit.control.EBoxUnitControl;
import com.sunrise.boss.business.fee.woff.eboxunit.control.EBoxUnitControlBean;
import com.sunrise.boss.business.fee.woff.eboxunit.persistent.EBoxUnitVO;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: EBoxUnitDelegate</p>
 * <p>Description: 账本科目管理代理类</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author xiefufeng
 * @version 1.0
 */

public class EBoxUnitDelegate {
	private EBoxUnitControl control;
	
    public EBoxUnitDelegate() throws Exception {
        control = (EBoxUnitControl) ControlFactory.build(EBoxUnitControlBean.class);
        if (control == null ) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    
	public EBoxUnitVO doCreateWithManageLog(EBoxUnitVO vo, BillEboxVO billvo, User user) throws BusinessException{
		return control.doCreateWithManageLog( vo, billvo, user );
	}
	
	public void doRemoveByPkWithManageLog(Serializable pk, User user) throws BusinessException{
		control.doRemoveByPkWithManageLog( pk, user );
	}
	
	 public EBoxUnitVO doUpdateWithManageLog(EBoxUnitVO vo, User user) throws BusinessException {
		 return control.doUpdateWithManageLog( vo, user );
	 }
	 
	 public Object doFindByPk(Serializable pk, Class voClass, User user) throws Exception {
		 return control.doFindByPk( pk, voClass, user );
	 }
}
