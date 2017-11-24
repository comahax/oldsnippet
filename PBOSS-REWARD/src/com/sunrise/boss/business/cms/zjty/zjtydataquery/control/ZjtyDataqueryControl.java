/**
* auto-generated code
* Tue Jan 05 15:32:41 CST 2010
*/
package com.sunrise.boss.business.cms.zjty.zjtydataquery.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtydataquery.persistent.ZjtyDataqueryVO;
import com.sunrise.boss.business.cms.zjty.zjtydataquery.persistent.ZjtyDataqueryListVO;

import java.io.Serializable;

/**
 * <p>Title: ZjtyDataqueryControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public interface ZjtyDataqueryControl extends AbstractControl {
    public ZjtyDataqueryVO doCreate(ZjtyDataqueryVO vo, User user)
        throws Exception;

    public void doRemove(ZjtyDataqueryVO vo, User user)
        throws Exception;

    public ZjtyDataqueryVO doUpdate(ZjtyDataqueryVO vo, User user)
        throws Exception;

    public ZjtyDataqueryVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ZjtyDataqueryListVO params, User user)
        throws Exception;
    
    public DataPackage doQueryBosssucc(ZjtyDataqueryListVO params, User user)
    	throws Exception;
    
    public DataPackage doQueryBossfail(ZjtyDataqueryListVO params, User user)
		throws Exception;
    
    public DataPackage doQueryBossjlsucc(ZjtyDataqueryListVO params, User user)
		throws Exception;
    
    public DataPackage doQueryBossjlfail(ZjtyDataqueryListVO params, User user)
		throws Exception;
    
    public DataPackage doQuerySalesucc(ZjtyDataqueryListVO params, User user)
		throws Exception;

    public DataPackage doQuerySalefail(ZjtyDataqueryListVO params, User user)
		throws Exception;
    
    public DataPackage doQueryTmnalsucc(ZjtyDataqueryListVO params, User user)
		throws Exception;

    public DataPackage doQueryTmnalfail(ZjtyDataqueryListVO params, User user)
		throws Exception;
}
