/**
* auto-generated code
* Tue Aug 22 21:42:23 CST 2006
*/
package com.sunrise.boss.business.common.subscriber.control;

import java.io.Serializable;

import com.sunrise.boss.business.common.subscriber.persistent.SubscriberListVO;
import com.sunrise.boss.business.common.subscriber.persistent.SubscriberVO;
import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: SubscriberControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author xqy
 * @version 1.0
 */
public interface SubscriberControl extends AbstractControl {

    public SubscriberVO doFindByPk(Serializable pk, User user)
        throws Exception;
    
    public String GetServnumBySubsid(java.lang.Long subsid, User user) 
    	throws Exception;
   
    public String GetServnumByAcctid(java.lang.Long acctid, User user)
    	throws Exception;
    
    public Long GetAcctidByServnum(java.lang.String servnumber, User user) 
    	throws Exception;
    
    public Long GetSubsidByServnum(java.lang.String servnumber, User user) 
    	throws Exception;
    
    public Long GetCustidByServnum(java.lang.String servnumber, User user) 
    	throws Exception;
    
    public SubscriberVO doFindByServnum(java.lang.String servnumber, User user) 
    	throws Exception;
    
    public SubscriberVO doFindByGServnum(java.lang.String servnumber, User user) 
    	throws Exception;
    
    public DataPackage doQueryByNo(SubscriberListVO listvo, User user) 
	throws Exception;
    
    public String GetServnumByCustid(Long custid, User user) throws Exception ;
    
    public Long getValidSusbidByServnumber(Object params ,User user) throws Exception;
    
    public long doQueryMainSubs(SubscriberListVO listvo, User user) throws Exception ;
    
}
