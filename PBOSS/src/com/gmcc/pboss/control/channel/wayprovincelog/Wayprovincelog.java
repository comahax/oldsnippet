/**
 * auto-generated code
 * Fri Aug 05 08:57:56 CST 2011
 */
package com.gmcc.pboss.control.channel.wayprovincelog;

import java.io.Serializable;

import com.gmcc.pboss.business.channel.wayprovincelog.WayprovincelogDBParam;
import com.gmcc.pboss.business.channel.wayprovincelog.WayprovincelogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Wayprovincelog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxingxin
 * @version 1.0
 */
public interface Wayprovincelog extends AbstractControl {
    public WayprovincelogVO doCreate(WayprovincelogVO vo) throws Exception;

    public void doRemoveByVO(WayprovincelogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public WayprovincelogVO doUpdate(WayprovincelogVO vo) throws Exception;

    public WayprovincelogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(WayprovincelogDBParam params) throws Exception;

}
