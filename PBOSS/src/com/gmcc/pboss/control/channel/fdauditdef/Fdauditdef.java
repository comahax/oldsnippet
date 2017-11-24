/**
 * auto-generated code
 * Wed Oct 07 20:21:59 CST 2009
 */
package com.gmcc.pboss.control.channel.fdauditdef;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.fdauditdef.FdauditdefDBParam;
import com.gmcc.pboss.business.channel.fdauditdef.FdauditdefVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Fdauditdef </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public interface Fdauditdef extends AbstractControl {
    public FdauditdefVO doCreate(FdauditdefVO vo) throws Exception;

    public void doRemoveByVO(FdauditdefVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public FdauditdefVO doUpdate(FdauditdefVO vo) throws Exception;

    public FdauditdefVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(FdauditdefDBParam params) throws Exception;

}
