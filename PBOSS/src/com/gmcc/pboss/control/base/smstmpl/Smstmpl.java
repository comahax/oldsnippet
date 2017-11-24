/**
 * auto-generated code
 * Mon Dec 21 09:15:59 CST 2009
 */
package com.gmcc.pboss.control.base.smstmpl;

import java.io.Serializable;
import java.util.Map;

import com.gmcc.pboss.business.base.smstmpl.SmstmplDBParam;
import com.gmcc.pboss.business.base.smstmpl.SmstmplVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Smstmpl </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Smstmpl extends AbstractControl {
    public SmstmplVO doCreate(SmstmplVO vo) throws Exception;

    public void doRemoveByVO(SmstmplVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public SmstmplVO doUpdate(SmstmplVO vo) throws Exception;

    public SmstmplVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(SmstmplDBParam params) throws Exception;

    public String doGenSMS(String sId, Map<String,String> keyAndValue) throws Exception;
    
    public String doGenSMS(String sId, String sContent, Map<String,String> keyAndValue) throws Exception;

}
