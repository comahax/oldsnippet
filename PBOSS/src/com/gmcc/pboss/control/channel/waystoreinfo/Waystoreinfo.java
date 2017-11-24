package com.gmcc.pboss.control.channel.waystoreinfo;

import java.io.Serializable;
import com.gmcc.pboss.business.channel.waystoreinfo.WaystoreinfoDBParam;
import com.gmcc.pboss.business.channel.waystoreinfo.WaystoreinfoVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Waystoreinfo </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author a-biao
 * @version 1.0
 */
public interface Waystoreinfo extends AbstractControl {
    public WaystoreinfoVO doCreate(WaystoreinfoVO vo) throws Exception;

    public void doRemoveByVO(WaystoreinfoVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public WaystoreinfoVO doUpdate(WaystoreinfoVO vo) throws Exception;

    public WaystoreinfoVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(WaystoreinfoDBParam params) throws Exception;
    
    public DataPackage doWaystoreinfoList(WaystoreinfoDBParam params) throws Exception;

}
