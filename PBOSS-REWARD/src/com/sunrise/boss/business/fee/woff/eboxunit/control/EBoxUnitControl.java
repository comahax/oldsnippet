package com.sunrise.boss.business.fee.woff.eboxunit.control;

import java.io.Serializable;

import com.sunrise.boss.business.fee.print.billebox.persistent.BillEboxVO;
import com.sunrise.boss.business.fee.woff.eboxunit.persistent.EBoxUnitVO;
import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: EBoxUnitControl</p>
 * <p>Description: 帐本科目业务处理类Control </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author xiefufeng
 * @version 1.0
 */

public interface EBoxUnitControl extends AbstractControl{
	public EBoxUnitVO doCreateWithManageLog(EBoxUnitVO vo, BillEboxVO billvo, User user) throws BusinessException;
	public void doRemoveByPkWithManageLog(Serializable pk, User user) throws BusinessException;
	public EBoxUnitVO doUpdateWithManageLog(EBoxUnitVO vo, User user) throws BusinessException;
	public Object doFindByPk(Serializable pk, Class voClass, User user) throws Exception;
}
