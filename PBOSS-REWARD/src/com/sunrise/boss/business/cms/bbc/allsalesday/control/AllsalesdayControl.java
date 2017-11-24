/**
* auto-generated code
* Fri Dec 09 10:35:29 CST 2011
*/
package com.sunrise.boss.business.cms.bbc.allsalesday.control;

import java.util.Map;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.allsalesday.persistent.AllsalesdayVO;
import com.sunrise.boss.business.cms.bbc.allsalesday.persistent.AllsalesdayListVO;

import java.io.Serializable;

/**
 * <p>Title: AllsalesdayControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public interface AllsalesdayControl extends AbstractControl {
    public AllsalesdayVO doCreate(AllsalesdayVO vo, User user)
        throws Exception;

    public void doRemove(AllsalesdayVO vo, User user)
        throws Exception;

    public AllsalesdayVO doUpdate(AllsalesdayVO vo, User user)
        throws Exception;

    public AllsalesdayVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(AllsalesdayListVO params, User user)
        throws Exception;
    
    public DataPackage doQueryWithEmpinfo(AllsalesdayListVO params, User user) 
    	throws Exception;
    
    public Map doStatistic(AllsalesdayListVO params, User user)
    	throws Exception;
    
    public DataPackage doStatisticBusiDetail(AllsalesdayListVO params, User user)
	throws Exception;
    
    public DataPackage doStatisticWayBusiDetail(AllsalesdayListVO params, User user)
	throws Exception;

}
