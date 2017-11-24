package com.sunrise.boss.business.common.batchlog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.business.common.batchlog.persistent.BatchlogVO;
import com.sunrise.boss.business.common.batchlog.persistent.BatchlogListVO;
import com.sunrise.boss.ui.commons.User;
import java.io.Serializable;
import java.rmi.RemoteException;

/**
 * @author liminghao
 * @version 1.0
 */
public interface BatchlogControl extends AbstractControl {
    public BatchlogVO doCreate(BatchlogVO vo, User user) throws Exception;
    
    public BatchlogVO doUpdate(BatchlogVO vo, User user) throws Exception;

    public BatchlogVO doFindByPk(Serializable pk, User user) throws Exception;

    public DataPackage doQuery(BatchlogListVO params, User user) throws Exception;
        
    public void doRemove(BatchlogVO vo, User user) throws Exception;

}
