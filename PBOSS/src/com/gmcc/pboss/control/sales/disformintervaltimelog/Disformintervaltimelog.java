/**
 * auto-generated code
 * Sat Mar 31 19:18:17 CST 2012
 */
package com.gmcc.pboss.control.sales.disformintervaltimelog;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.disformintervaltimelog.DisformintervaltimelogDBParam;
import com.gmcc.pboss.business.sales.disformintervaltimelog.DisformintervaltimelogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Disformintervaltimelog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public interface Disformintervaltimelog extends AbstractControl {
    public DisformintervaltimelogVO doCreate(DisformintervaltimelogVO vo) throws Exception;

    public void doRemoveByVO(DisformintervaltimelogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public DisformintervaltimelogVO doUpdate(DisformintervaltimelogVO vo) throws Exception;

    public DisformintervaltimelogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(DisformintervaltimelogDBParam params) throws Exception;

}
