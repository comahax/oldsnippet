/**
 * auto-generated code
 * Thu Dec 01 02:42:27 GMT 2011
 */
package com.gmcc.pboss.control.channel.waitchange;

import java.io.Serializable;
import java.util.Map;

import com.gmcc.pboss.business.channel.waitchange.WaitchangeDBParam;
import com.gmcc.pboss.business.channel.waitchange.WaitchangeVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Waitchange </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public interface Waitchange extends AbstractControl {
    public WaitchangeVO doCreate(WaitchangeVO vo) throws Exception;

    public void doRemoveByVO(WaitchangeVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public WaitchangeVO doUpdate(WaitchangeVO vo) throws Exception;

    public WaitchangeVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(WaitchangeDBParam params) throws Exception;
    
    public WaitchangeVO doInsertForCj(String sId, Map<String,String> keyAndValue, String recno) 
	throws Exception;

}
