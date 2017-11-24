package com.sunrise.boss.business.common.managelog.control;

import java.io.Serializable;

import com.sunrise.boss.business.common.managelog.persistent.ManageLogDBParam;
import com.sunrise.boss.business.common.managelog.persistent.ManageLogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;


public interface ManageLog extends AbstractControl {
    public ManageLogVO doCreate(ManageLogVO vo, User user)
    throws Exception;

//public void doRemove(ManageLogVO vo, User user)
//    throws Exception;
//
//public ManageLogVO doUpdate(ManageLogVO vo, User user)
//    throws Exception;

public ManageLogVO doFindByPk(Serializable pk, User user)
    throws Exception;

public DataPackage doQuery(ManageLogDBParam params, User user)
    throws Exception;

//public void manageLog(User user, String oprtype, String action,
//        Object voOld, Object voNew, Integer state)
//throws Exception;
}
