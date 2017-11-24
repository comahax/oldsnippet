/**
 * auto-generated code
 * Tue Aug 10 16:43:27 CST 2010
 */
package com.gmcc.pboss.control.resource.stkalarmct;

import java.io.Serializable;

import com.gmcc.pboss.business.resource.stkalarmct.StkalarmctDBParam;
import com.gmcc.pboss.business.resource.stkalarmct.StkalarmctVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Stkalarmct </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author zhangsiwei
 * @version 1.0
 */
public interface Stkalarmct extends AbstractControl {
    public StkalarmctVO doCreate(StkalarmctVO vo) throws Exception;

    public void doRemoveByVO(StkalarmctVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public StkalarmctVO doUpdate(StkalarmctVO vo) throws Exception;

    public StkalarmctVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(StkalarmctDBParam params) throws Exception;

}
