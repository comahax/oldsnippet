/**
 * auto-generated code
 * Wed Jul 01 17:29:43 CST 2009
 */
package com.gmcc.pboss.control.channel.waybussarea;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.waybussarea.WaybussareaDBParam;
import com.gmcc.pboss.business.channel.waybussarea.WaybussareaVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Waybussarea </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public interface Waybussarea extends AbstractControl {
    public WaybussareaVO doCreate(WaybussareaVO vo) throws Exception;

    public void doRemoveByVO(WaybussareaVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public WaybussareaVO doUpdate(WaybussareaVO vo) throws Exception;

    public WaybussareaVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(WaybussareaDBParam params) throws Exception;

}
