/**
 * auto-generated code
 * Thu Jun 12 15:47:39 CST 2014
 */
package com.gmcc.pboss.control.sales.comrescarddetail;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.comrescarddetail.ComrescarddetailVO;
import com.gmcc.pboss.business.sales.waystocksnpt.WaystocksnptDBParam;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Comrescarddetail </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public interface Comrescarddetail extends AbstractControl {
    public ComrescarddetailVO doCreate(ComrescarddetailVO vo) throws Exception;

    public void doRemoveByVO(ComrescarddetailVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public ComrescarddetailVO doUpdate(ComrescarddetailVO vo) throws Exception;

    public ComrescarddetailVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(WaystocksnptDBParam params) throws Exception;

}
