/**
 * auto-generated code
 * Wed Jul 08 11:41:20 CST 2009
 */
package com.gmcc.pboss.control.channel.waytype;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.waytype.WaytypeDBParam;
import com.gmcc.pboss.business.channel.waytype.WaytypeVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Waytype </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public interface Waytype extends AbstractControl {
    public WaytypeVO doCreate(WaytypeVO vo) throws Exception;

    public void doRemoveByVO(WaytypeVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public WaytypeVO doUpdate(WaytypeVO vo) throws Exception;

    public WaytypeVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(WaytypeDBParam params) throws Exception;

}
