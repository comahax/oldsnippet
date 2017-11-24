package com.sunrise.boss.business.fee.monternet.ibdatabusiinfo.control;

import java.io.Serializable;

import com.sunrise.boss.business.fee.monternet.ibdatabusiinfo.persistent.IbDataBusiinfoDBParam;
import com.sunrise.boss.business.fee.monternet.ibdatabusiinfo.persistent.IbDataBusiinfoVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: IbDataBusiinfo </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 赵武
 * @version 1.0
 */
public interface IbDataBusiinfo extends AbstractControl {
    public IbDataBusiinfoVO doCreate(IbDataBusiinfoVO vo) throws Exception;

    public void doRemoveByVO(IbDataBusiinfoVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public IbDataBusiinfoVO doUpdate(IbDataBusiinfoVO vo) throws Exception;

    public IbDataBusiinfoVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(IbDataBusiinfoDBParam params) throws Exception;

}
