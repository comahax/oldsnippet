/**
 * auto-generated code
 * Wed Jun 01 09:15:31 GMT 2011
 */
package com.gmcc.pboss.control.sales.vstockalarm;

import java.io.Serializable;

import com.gmcc.pboss.business.sales.vstockalarm.VstockalarmDBParam;
import com.gmcc.pboss.business.sales.vstockalarm.VstockalarmVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Vstockalarm </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public interface Vstockalarm extends AbstractControl {
    public VstockalarmVO doCreate(VstockalarmVO vo) throws Exception;

    public void doRemoveByVO(VstockalarmVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public VstockalarmVO doUpdate(VstockalarmVO vo) throws Exception;

    public VstockalarmVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(VstockalarmDBParam params) throws Exception;

}
