/**
 * auto-generated code
 * Wed Nov 14 09:58:49 CST 2012
 */
package com.gmcc.pboss.control.channel.waybusicircle;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.waybusicircle.WaybusicircleDBParam;
import com.gmcc.pboss.business.channel.waybusicircle.WaybusicircleVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Waybusicircle </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxingxin
 * @version 1.0
 */
public interface Waybusicircle extends AbstractControl {
    public WaybusicircleVO doCreate(WaybusicircleVO vo) throws Exception;

    public void doRemoveByVO(WaybusicircleVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public WaybusicircleVO doUpdate(WaybusicircleVO vo) throws Exception;

    public WaybusicircleVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(WaybusicircleDBParam params) throws Exception;

}
