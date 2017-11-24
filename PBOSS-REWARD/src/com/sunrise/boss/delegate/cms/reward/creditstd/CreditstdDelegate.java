/**
* auto-generated code
* Wed May 18 15:47:28 CST 2011
*/
package com.sunrise.boss.delegate.cms.reward.creditstd;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.creditstd.persistent.CreditstdVO;
import com.sunrise.boss.business.cms.reward.creditstd.persistent.CreditstdListVO;
import com.sunrise.boss.business.cms.reward.creditstd.control.CreditstdControlBean;
import com.sunrise.boss.business.cms.reward.creditstd.control.CreditstdControl;

import java.io.Serializable;
import java.util.Map;

/**
 * <p>Title: CreditstdDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
public class CreditstdDelegate {

    private static CreditstdControl control;

    public CreditstdDelegate() throws Exception {
        control = (CreditstdControl) ControlFactory.build(CreditstdControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public CreditstdVO doCreate(CreditstdVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(CreditstdVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public CreditstdVO doUpdate(CreditstdVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public CreditstdVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (CreditstdVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(CreditstdListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }

    public DataPackage doQuery2(CreditstdListVO params, User user)
    throws Exception {
    return control.doQuery2(params, user);
    }
    
    public DataPackage doQuerystore(CreditstdListVO params, User user)
    throws Exception {
    return control.doQuerystore(params, user);
    }
    public DataPackage doQuerystar(CreditstdListVO params, User user)
    throws Exception {
    return control.doQuerystar(params, user);
    }
    
    public DataPackage doSave(Map  map, User user)
    throws Exception {
    return control.doSave(map, user);
    }
    
    public DataPackage doQueryPro(CreditstdListVO params, User user)
    throws Exception {
    return control.doQueryPro(params, user);
    }
    
    public Double doQuerysums(CreditstdListVO params, User user)
    throws Exception {
    return control.doQuerysums(params, user);
    }
    
    public Double doQuerysums4singlton(CreditstdListVO params, User user)
    throws Exception {
    return control.doQuerysums4singlton(params, user);
    }
    
    public boolean doCheckHasALevel(CreditstdListVO params, User user)
    throws Exception {
        return control.doCheckALevel(params, user);
     }
    public DataPackage doQuery4cqjl(CreditstdListVO params, User user)
    throws Exception {
    return control.doQuery4cqjl(params, user);
    }
    
    
    
}
