/**
 * auto-generated code
 * Sat Mar 31 17:39:07 CST 2012
 */
package com.gmcc.pboss.control.sales.disformintervaltime;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.disformintervaltime.DisformintervaltimeDBParam;
import com.gmcc.pboss.business.sales.disformintervaltime.DisformintervaltimeVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Disformintervaltime </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public interface Disformintervaltime extends AbstractControl {
    public DisformintervaltimeVO doCreate(DisformintervaltimeVO vo) throws Exception;

    public void doRemoveByVO(DisformintervaltimeVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public DisformintervaltimeVO doUpdate(DisformintervaltimeVO vo) throws Exception;

    public DisformintervaltimeVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(DisformintervaltimeDBParam params) throws Exception;
    
    //【分销管理】—>【配送单管理】 ->【配送单超时预警统计查询】
    public DataPackage doDisformStat(DisformintervaltimeDBParam params) throws Exception;

}
