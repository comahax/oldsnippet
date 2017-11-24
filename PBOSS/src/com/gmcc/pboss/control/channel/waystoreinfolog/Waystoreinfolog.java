package com.gmcc.pboss.control.channel.waystoreinfolog;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.waystoreinfolog.WaystoreinfologDBParam;
import com.gmcc.pboss.business.channel.waystoreinfolog.WaystoreinfologVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Waystoreinfolog </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author a-biao
 * @version 1.0
 */
public interface Waystoreinfolog extends AbstractControl {
    public WaystoreinfologVO doCreate(WaystoreinfologVO vo) throws Exception;

    public void doRemoveByVO(WaystoreinfologVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public WaystoreinfologVO doUpdate(WaystoreinfologVO vo) throws Exception;

    public WaystoreinfologVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(WaystoreinfologDBParam params) throws Exception;

}
