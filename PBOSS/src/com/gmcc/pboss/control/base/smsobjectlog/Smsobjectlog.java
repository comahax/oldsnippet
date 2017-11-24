/**
 * auto-generated code
 * Tue Jul 05 10:51:39 CST 2011
 */
package com.gmcc.pboss.control.base.smsobjectlog;

import java.io.Serializable;

import com.gmcc.pboss.business.base.smsobjectlog.SmsobjectlogDBParam;
import com.gmcc.pboss.business.base.smsobjectlog.SmsobjectlogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Smsobjectlog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author lyl
 * @version 1.0
 */
public interface Smsobjectlog extends AbstractControl {
    public SmsobjectlogVO doCreate(SmsobjectlogVO vo) throws Exception;

    public void doRemoveByVO(SmsobjectlogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public SmsobjectlogVO doUpdate(SmsobjectlogVO vo) throws Exception;

    public SmsobjectlogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(SmsobjectlogDBParam params) throws Exception;

}
