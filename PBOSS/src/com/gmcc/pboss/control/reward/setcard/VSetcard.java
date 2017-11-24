package com.gmcc.pboss.control.reward.setcard;

import com.gmcc.pboss.business.reward.setcard.VSetcardDBParam;
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
public interface VSetcard extends AbstractControl {

    public DataPackage doQueryBySql(VSetcardDBParam params) throws Exception;
}
