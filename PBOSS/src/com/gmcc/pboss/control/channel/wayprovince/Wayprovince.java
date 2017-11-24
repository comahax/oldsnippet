/**
 * auto-generated code
 * Fri Aug 05 08:51:02 CST 2011
 */
package com.gmcc.pboss.control.channel.wayprovince;

import java.io.Serializable;
import java.util.List;

import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.channel.wayprovince.WayprovinceDBParam;
import com.gmcc.pboss.business.channel.wayprovince.WayprovinceVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Wayprovince </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxingxin
 * @version 1.0
 */
public interface Wayprovince extends AbstractControl {
    public WayprovinceVO doCreate(WayprovinceVO vo) throws Exception;

    public void doRemoveByVO(WayprovinceVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public WayprovinceVO doUpdate(WayprovinceVO vo) throws Exception;

    public WayprovinceVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(WayprovinceDBParam params) throws Exception;
    
    public List doQueryWpByWayid(String wayid) throws Exception;
    
    public List doQueryWpByUniquewayid(String uniquewayid) throws Exception;

}
