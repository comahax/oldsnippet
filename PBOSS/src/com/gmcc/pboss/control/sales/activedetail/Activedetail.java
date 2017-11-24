/**
 * auto-generated code
 * Thu Jun 12 15:48:34 CST 2014
 */
package com.gmcc.pboss.control.sales.activedetail;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.activedetail.ActivedetailVO;
import com.gmcc.pboss.business.sales.waystocksnpt.WaystocksnptDBParam;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Activedetail </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public interface Activedetail extends AbstractControl {
    public ActivedetailVO doCreate(ActivedetailVO vo) throws Exception;

    public void doRemoveByVO(ActivedetailVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public ActivedetailVO doUpdate(ActivedetailVO vo) throws Exception;

    public ActivedetailVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(WaystocksnptDBParam params) throws Exception;

}
