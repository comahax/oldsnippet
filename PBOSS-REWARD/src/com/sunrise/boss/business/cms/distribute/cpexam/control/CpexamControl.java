package com.sunrise.boss.business.cms.distribute.cpexam.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.business.cms.distribute.cpexam.persistent.CpexamVO;
import com.sunrise.boss.business.cms.distribute.cpexam.persistent.CpexamListVO;
import com.sunrise.boss.ui.commons.User;
import java.io.Serializable;
import java.rmi.RemoteException;

/**
 * @author zhangbinli
 * @version 1.0
 */
public interface CpexamControl extends AbstractControl {
    public CpexamVO doCreate(CpexamVO vo, User user) throws Exception;
    
    public CpexamVO doUpdate(CpexamVO vo, User user) throws Exception;

    public CpexamVO doFindByPk(Serializable pk, User user) throws Exception;

    public DataPackage doQuery(CpexamListVO params, User user) throws Exception;
        
    public void doRemove(CpexamVO vo, User user) throws Exception;

}
