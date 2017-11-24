/**
* auto-generated code
* Tue Aug 22 21:42:23 CST 2006
*/
package com.sunrise.boss.delegate.common.subscriber;

import java.io.Serializable;

import com.sunrise.boss.business.common.subscriber.control.SubscriberControl;
import com.sunrise.boss.business.common.subscriber.control.SubscriberControlBean;
import com.sunrise.boss.business.common.subscriber.persistent.SubscriberListVO;
import com.sunrise.boss.business.common.subscriber.persistent.SubscriberVO;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: SubscriberDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author xqy
 * @version 1.0
 */
public class SubscriberDelegate {

    private SubscriberControl control;

    public SubscriberDelegate() throws Exception {
        control = (SubscriberControl) ControlFactory.build(SubscriberControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public SubscriberVO doFindByPk(Serializable pk, User user)
        throws Exception {
		if (pk != null) {
        	return (SubscriberVO) control.doFindByPk(pk, user);
		}
		return null;
    }

	public String GetServnumByAcctid(Long acctid, User user) throws Exception {
		return control.GetServnumByAcctid(acctid, user);
	}

	public String GetServnumBySubsid(Long subsid, User user) throws Exception {
		return control.GetServnumBySubsid(subsid, user);
	}
	
    public Long GetAcctidByServnum(java.lang.String servnumber, User user) throws Exception{
    	return control.GetAcctidByServnum(servnumber, user);
    }

    public Long GetSubsidByServnum(java.lang.String servnumber, User user) throws Exception{
    	return control.GetSubsidByServnum(servnumber, user);
    }
    
    /*       add by xiefufeng       */
    public Long GetCustidByServnum(java.lang.String servnumber, User user) throws Exception{
    	return control.GetCustidByServnum(servnumber, user);
    }

    public SubscriberVO doFindByServnum(java.lang.String servnumber, User user) throws Exception{
    	return control.doFindByServnum(servnumber, user);
    }
    
    public SubscriberVO doFindByGServnum(java.lang.String servnumber, User user) throws Exception{
    	return control.doFindByGServnum(servnumber, user);
    }
    
    public DataPackage doQueryByNo(SubscriberListVO listvo, User user) throws Exception {
    	return control.doQueryByNo(listvo, user);
    }
    
    public String GetServnumByCustid(Long custid, User user) throws Exception {
    	return control.GetServnumByCustid(custid, user); 
    }
    
    public Long getValidSusbidByServnumber(Object params ,User user) throws Exception{
    	return control.getValidSusbidByServnumber(params, user);
   }
    
    public long doQueryMainSubs(SubscriberListVO listvo, User user) throws Exception {
    	return control.doQueryMainSubs(listvo, user);
    }
}
