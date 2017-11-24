/**
* auto-generated code
* Tue Jan 05 15:32:41 CST 2010
*/
package com.sunrise.boss.delegate.cms.zjty.zjtydataquery;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtydataquery.persistent.ZjtyDataqueryVO;
import com.sunrise.boss.business.cms.zjty.zjtydataquery.persistent.ZjtyDataqueryListVO;
import com.sunrise.boss.business.cms.zjty.zjtydataquery.control.ZjtyDataqueryControlBean;
import com.sunrise.boss.business.cms.zjty.zjtydataquery.control.ZjtyDataqueryControl;

import java.io.Serializable;

/**
 * <p>Title: ZjtyDataqueryDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class ZjtyDataqueryDelegate {

    private static ZjtyDataqueryControl control;

    public ZjtyDataqueryDelegate() throws Exception {
        control = (ZjtyDataqueryControl) ControlFactory.build(ZjtyDataqueryControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public ZjtyDataqueryVO doCreate(ZjtyDataqueryVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(ZjtyDataqueryVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public ZjtyDataqueryVO doUpdate(ZjtyDataqueryVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public ZjtyDataqueryVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (ZjtyDataqueryVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(ZjtyDataqueryListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
    
    public DataPackage doQueryBosssucc(ZjtyDataqueryListVO params, User user)
    	throws Exception{
    	return control.doQueryBosssucc(params, user);
    }
    
    public DataPackage doQueryBossfail(ZjtyDataqueryListVO params, User user)
		throws Exception{
    	return control.doQueryBossfail(params, user);
    }
    
    public DataPackage doQueryBossjlsucc(ZjtyDataqueryListVO params, User user)
		throws Exception{
    	return control.doQueryBossjlsucc(params, user);
    }
    
    public DataPackage doQueryBossjlfail(ZjtyDataqueryListVO params, User user)
		throws Exception{
    	return control.doQueryBossjlfail(params, user);
    }
    
    public DataPackage doQuerySalesucc(ZjtyDataqueryListVO params, User user)
		throws Exception{
    	return control.doQuerySalesucc(params, user);
    }
    
    public DataPackage doQuerySalefail(ZjtyDataqueryListVO params, User user)
		throws Exception{
    	return control.doQuerySalefail(params, user);
    }
    
    public DataPackage doQueryTmnalsucc(ZjtyDataqueryListVO params, User user)
		throws Exception{
    	return control.doQueryTmnalsucc(params, user);
    }

    public DataPackage doQueryTmnalfail(ZjtyDataqueryListVO params, User user)
		throws Exception{
    	return control.doQueryTmnalfail(params, user);
    }
}
