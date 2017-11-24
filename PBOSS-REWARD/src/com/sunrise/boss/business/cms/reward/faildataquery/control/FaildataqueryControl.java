package com.sunrise.boss.business.cms.reward.faildataquery.control;

import java.io.Serializable;

import com.sunrise.boss.business.cms.reward.adtcode.persistent.AdtcodeListVO;
import com.sunrise.boss.business.cms.reward.faildataquery.persistent.FaildataqueryListVO;
import com.sunrise.boss.business.cms.reward.faildataquery.persistent.FaildataqueryVO;
import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
public interface FaildataqueryControl extends AbstractControl {
    public FaildataqueryVO doCreate(FaildataqueryVO vo, User user)
        throws Exception;

    public void doRemove(FaildataqueryVO vo, User user)
        throws Exception;

    public FaildataqueryVO doUpdate(FaildataqueryVO vo, User user)
        throws Exception;

    public FaildataqueryVO doFindByPk(Serializable pk, User user)
        throws Exception;
    
    public DataPackage doQuery(FaildataqueryListVO params, User user) 
    	throws Exception;
}
