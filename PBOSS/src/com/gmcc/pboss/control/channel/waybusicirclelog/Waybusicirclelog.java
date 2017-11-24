/**
 * auto-generated code
 * Wed Nov 14 09:59:20 CST 2012
 */
package com.gmcc.pboss.control.channel.waybusicirclelog;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.waybusicirclelog.WaybusicirclelogDBParam;
import com.gmcc.pboss.business.channel.waybusicirclelog.WaybusicirclelogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Waybusicirclelog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxingxin
 * @version 1.0
 */
public interface Waybusicirclelog extends AbstractControl {
    public WaybusicirclelogVO doCreate(WaybusicirclelogVO vo) throws Exception;

    public void doRemoveByVO(WaybusicirclelogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public WaybusicirclelogVO doUpdate(WaybusicirclelogVO vo) throws Exception;

    public WaybusicirclelogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(WaybusicirclelogDBParam params) throws Exception;

}
