/**
 * auto-generated code
 * Thu Jun 12 15:45:43 CST 2014
 */
package com.gmcc.pboss.control.sales.comressdetail;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.comressdetail.ComressdetailVO;
import com.gmcc.pboss.business.sales.waystocksnpt.WaystocksnptDBParam;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Comressdetail </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public interface Comressdetail extends AbstractControl {
    public ComressdetailVO doCreate(ComressdetailVO vo) throws Exception;

    public void doRemoveByVO(ComressdetailVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public ComressdetailVO doUpdate(ComressdetailVO vo) throws Exception;

    public ComressdetailVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(WaystocksnptDBParam params) throws Exception;

}
