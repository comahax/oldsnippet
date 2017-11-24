package com.sunrise.boss.business.fee.qsmanage.common.control;

import java.io.Serializable;
import java.util.HashMap;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.ui.commons.User;

public interface QsCommonControl extends AbstractControl {

    
	public Object doFindByPk(Serializable pk, Class voClass, User user) throws Exception;

    //--------------------for Qs log --------------------------
    public Object doCreateWithQsLog(Object vo, Class voClass, Long matchid, String chgreason, boolean isbatch, User user) throws Exception;

    public void doRemoveByVoWithQsLog(Object vo, Class voClass, User user) throws Exception;

    public void doRemoveByPkWithQsLog(Serializable pk, Class voClass, User user) throws Exception;

    public Object doUpdateWithQsLog(Object vo, Class voClass, User user) throws Exception;
    
    public void doBatch(HashMap map, Long matchid, String chgreason, User user) throws Exception;

}
