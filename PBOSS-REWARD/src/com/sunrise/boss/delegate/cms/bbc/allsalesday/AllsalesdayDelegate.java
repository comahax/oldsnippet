/**
* auto-generated code
* Fri Dec 09 10:35:29 CST 2011
*/
package com.sunrise.boss.delegate.cms.bbc.allsalesday;

import java.util.Map;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.allsalesday.persistent.AllsalesdayVO;
import com.sunrise.boss.business.cms.bbc.allsalesday.persistent.AllsalesdayListVO;
import com.sunrise.boss.business.cms.bbc.allsalesday.control.AllsalesdayControlBean;
import com.sunrise.boss.business.cms.bbc.allsalesday.control.AllsalesdayControl;

import java.io.Serializable;

/**
 * <p>Title: AllsalesdayDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public class AllsalesdayDelegate {

    private static AllsalesdayControl control;

    public AllsalesdayDelegate() throws Exception {
        control = (AllsalesdayControl) ControlFactory.build(AllsalesdayControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public AllsalesdayVO doCreate(AllsalesdayVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(AllsalesdayVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public AllsalesdayVO doUpdate(AllsalesdayVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public AllsalesdayVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (AllsalesdayVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(AllsalesdayListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
    
    public DataPackage doQueryWithEmpinfo(AllsalesdayListVO params, User user) 
    	throws Exception {    	
    	return control.doQueryWithEmpinfo(params, user);
    }
    
    public Map doStatistic(AllsalesdayListVO params, User user)
    	throws Exception {
    	return control.doStatistic(params, user);
    }
    
    public DataPackage doStatisticBusiDetail(AllsalesdayListVO params, User user) 
		throws Exception {    	
    	return control.doStatisticBusiDetail(params, user);
    }
    
    public DataPackage doStatisticWayBusiDetail(AllsalesdayListVO params, User user)
    	throws Exception {
    	return control.doStatisticWayBusiDetail(params, user);
    }

}
