/**
 * auto-generated code
 * Tue Jul 12 17:07:47 CST 2011
 */
package com.gmcc.pboss.control.channel.wayrechargeno;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.wayrechargeno.WayrechargenoDBParam;
import com.gmcc.pboss.business.channel.wayrechargeno.WayrechargenoVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Wayrechargeno </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Wayrechargeno extends AbstractControl {
    public WayrechargenoVO doCreate(WayrechargenoVO vo) throws Exception;

    public void doRemoveByVO(WayrechargenoVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public WayrechargenoVO doUpdate(WayrechargenoVO vo) throws Exception;

    public WayrechargenoVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(WayrechargenoDBParam params) throws Exception;

}
