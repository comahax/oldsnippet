/**
 * auto-generated code
 * Thu Dec 01 02:07:15 GMT 2011
 */
package com.gmcc.pboss.control.channel.ctilog;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.ctilog.CtilogDBParam;
import com.gmcc.pboss.business.channel.ctilog.CtilogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Ctilog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public interface Ctilog extends AbstractControl {
    public CtilogVO doCreate(CtilogVO vo) throws Exception;

    public void doRemoveByVO(CtilogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public CtilogVO doUpdate(CtilogVO vo) throws Exception;

    public CtilogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(CtilogDBParam params) throws Exception;

}
