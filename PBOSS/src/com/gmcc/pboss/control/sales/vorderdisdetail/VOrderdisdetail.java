/**
 * auto-generated code
 * Tue Apr 03 12:44:47 CST 2012
 */
package com.gmcc.pboss.control.sales.vorderdisdetail;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.vorderdisdetail.VOrderdisdetailDBParam;
import com.gmcc.pboss.business.sales.vorderdisdetail.VOrderdisdetailVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: VOrderdisdetail </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public interface VOrderdisdetail extends AbstractControl {
    public DataPackage doQuery(VOrderdisdetailDBParam params) throws Exception;

}
