package com.sunrise.boss.business.cms.audit.waittmp.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.business.cms.audit.waittmp.persistent.WaittmpVO;
import com.sunrise.boss.business.cms.audit.waittmp.persistent.WaittmpListVO;
import com.sunrise.boss.ui.commons.User;
import java.io.Serializable;


/**
 * @author liminghao
 * @version 1.0
 */
public interface WaittmpControl extends AbstractControl {
    public WaittmpVO doCreate(WaittmpVO vo, User user) throws Exception;
    
    public WaittmpVO doUpdate(WaittmpVO vo, User user) throws Exception;

    public WaittmpVO doFindByPk(Serializable pk, User user) throws Exception;

    public DataPackage doQuery(WaittmpListVO params, User user) throws Exception;
        
    public void doRemove(WaittmpVO vo, User user) throws Exception;
    
    public boolean sendDx(int type,String orgCode,String desCode,User user) throws Exception;
}
