package com.sunrise.boss.business.common.managelog.control;

import java.io.Serializable;


import com.sunrise.boss.business.common.managelog.persistent.ManageLogListVO;
import com.sunrise.boss.business.common.managelog.persistent.ManageLogVO;
import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

public interface ManageLogControl extends AbstractControl {
    public ManageLogVO doCreate(ManageLogVO vo, User user)
    throws Exception;

//public void doRemove(ManageLogVO vo, User user)
//    throws Exception;
//
//public ManageLogVO doUpdate(ManageLogVO vo, User user)
//    throws Exception;

public ManageLogVO doFindByPk(Serializable pk, User user)
    throws Exception;

public DataPackage doQuery(ManageLogListVO params, User user)
    throws Exception;

//public void manageLog(User user, String oprtype, String action,
//        Object voOld, Object voNew, Integer state)
//throws Exception;
}
