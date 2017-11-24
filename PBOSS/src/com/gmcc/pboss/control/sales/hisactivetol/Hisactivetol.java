/**
 * auto-generated code
 * Tue Apr 24 17:19:54 CST 2012
 */
package com.gmcc.pboss.control.sales.hisactivetol;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.hisactivetol.HisactivetolDBParam;
import com.gmcc.pboss.business.sales.hisactivetol.HisactivetolVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Hisactivetol </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxingxin
 * @version 1.0
 */
public interface Hisactivetol extends AbstractControl {
    public HisactivetolVO doCreate(HisactivetolVO vo) throws Exception;

    public void doRemoveByVO(HisactivetolVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public HisactivetolVO doUpdate(HisactivetolVO vo) throws Exception;

    public HisactivetolVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(HisactivetolDBParam params) throws Exception;
    
    public void doProcess(DBAccessUser user) throws Exception;
    
    public DataPackage doHisWayDetail(String begintime, String endtime, String wayid,String brand) throws Exception ;

}
