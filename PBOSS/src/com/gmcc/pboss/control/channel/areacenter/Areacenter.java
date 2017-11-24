/**
 * auto-generated code
 * Wed Jul 08 10:21:09 CST 2009
 */
package com.gmcc.pboss.control.channel.areacenter;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.areacenter.AreacenterDBParam;
import com.gmcc.pboss.business.channel.areacenter.AreacenterVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Areacenter </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public interface Areacenter extends AbstractControl {
    public AreacenterVO doCreate(AreacenterVO vo) throws Exception;

    public void doRemoveByVO(AreacenterVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public AreacenterVO doUpdate(AreacenterVO vo) throws Exception;

    public AreacenterVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(AreacenterDBParam params) throws Exception;
    
    public DataPackage doGetCenters() throws Exception;

}
