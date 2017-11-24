package com.gmcc.pboss.control.reward.setcard;

import java.io.Serializable;

import com.gmcc.pboss.business.reward.setcard.SetcardDBParam;
import com.gmcc.pboss.business.reward.setcard.SetcardVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>
 * Title: Payment
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2010
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author a-biao
 * @version 1.0
 */
public interface Setcard extends AbstractControl {
	public SetcardVO doCreate(SetcardVO vo) throws Exception;

	public void doRemoveByVO(SetcardVO vo) throws Exception;

	public void doRemoveByPK(Serializable pk) throws Exception;

	public SetcardVO doUpdate(SetcardVO vo) throws Exception;

	public SetcardVO doFindByPk(Serializable pk) throws Exception;

	public DataPackage doQuery(SetcardDBParam params) throws Exception;

	//public DataPackage doQueryBySql(SetcardDBParam params, String qrySql)
	//		throws Exception;

}
