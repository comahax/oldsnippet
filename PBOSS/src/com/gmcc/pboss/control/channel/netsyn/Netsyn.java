/**
 * auto-generated code
 * Wed Jul 01 17:32:06 CST 2009
 */
package com.gmcc.pboss.control.channel.netsyn;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.netsyn.NetsynDBParam;
import com.gmcc.pboss.business.channel.netsyn.NetsynVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Netsyn </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public interface Netsyn extends AbstractControl {
    public NetsynVO doCreate(NetsynVO vo) throws Exception;

    public void doRemoveByVO(NetsynVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public NetsynVO doUpdate(NetsynVO vo) throws Exception;

    public NetsynVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(NetsynDBParam params) throws Exception;

}
