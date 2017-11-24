/**
 * auto-generated code
 * Wed Jul 01 17:31:42 CST 2009
 */
package com.gmcc.pboss.control.channel.netsynlog;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.netsynlog.NetsynlogDBParam;
import com.gmcc.pboss.business.channel.netsynlog.NetsynlogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Netsynlog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public interface Netsynlog extends AbstractControl {
    public NetsynlogVO doCreate(NetsynlogVO vo) throws Exception;

    public void doRemoveByVO(NetsynlogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public NetsynlogVO doUpdate(NetsynlogVO vo) throws Exception;

    public NetsynlogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(NetsynlogDBParam params) throws Exception;

}
