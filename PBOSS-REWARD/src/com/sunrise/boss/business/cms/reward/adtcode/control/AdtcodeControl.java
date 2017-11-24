package com.sunrise.boss.business.cms.reward.adtcode.control;

import java.io.Serializable;

import com.sunrise.boss.business.cms.reward.adtcode.persistent.AdtcodeListVO;
import com.sunrise.boss.business.cms.reward.adtcode.persistent.AdtcodeVO;
import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
public interface AdtcodeControl extends AbstractControl {
    public AdtcodeVO doCreate(AdtcodeVO vo, User user)
        throws Exception;
    public void doRemove(AdtcodeVO vo, User user)
        throws Exception;
    public AdtcodeVO doUpdate(AdtcodeVO vo, User user)
        throws Exception;
    public AdtcodeVO doFindByPk(Serializable pk, User user)
        throws Exception;
    public DataPackage doQuery(AdtcodeListVO params, User user) 
    	throws Exception;
}
