/**
 * auto-generated code
 * Wed Oct 07 14:01:03 CST 2009
 */
package com.gmcc.pboss.control.channel.fdaudit;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.fdaudit.FdauditDBParam;
import com.gmcc.pboss.business.channel.fdaudit.FdauditVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Fdaudit </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public interface Fdaudit extends AbstractControl {
    public FdauditVO doCreate(FdauditVO vo) throws Exception;

    public void doRemoveByVO(FdauditVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public FdauditVO doUpdate(FdauditVO vo) throws Exception;

    public FdauditVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(FdauditDBParam params) throws Exception;
    
    public Object doGetorgVO(Object vo, DBAccessUser user) throws Exception;

}
