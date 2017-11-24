/**
* auto-generated code
* Fri Aug 03 11:10:45 CST 2007
*/
package com.sunrise.boss.delegate.cms.cardsalebusi;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.cardsalebusi.control.CardsalebusiControl;
import com.sunrise.boss.business.cms.cardsalebusi.control.CardsalebusiControlBean;
import com.sunrise.boss.business.cms.cardsalebusi.persistent.CardsalebusiVO;
import com.sunrise.boss.business.cms.cardsalebusi.persistent.CardsalebusiListVO;

import java.io.Serializable;

/**
 * <p>Title: CardsalebusiDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class CardsalebusiDelegate {

    private static CardsalebusiControl control;

    public CardsalebusiDelegate() throws Exception {
        control = (CardsalebusiControl) ControlFactory.build(CardsalebusiControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }
    public CardsalebusiVO doCreate(CardsalebusiVO vo, User user )
        throws Exception {
        return control.doCreate(vo, user);
    }
    public void doRemove(CardsalebusiVO vo, User user )
        throws Exception {
        control.doRemove(vo, user);
    }
    public CardsalebusiVO doUpdate(CardsalebusiVO vo, User user )
        throws Exception {
        return control.doUpdate(vo, user);
    }
    public CardsalebusiVO doFindByPk(Serializable pk, User user )
        throws Exception {
        return (CardsalebusiVO) control.doFindByPk(pk, user);
    }
    public DataPackage doQuery(CardsalebusiListVO params, User user )
        throws Exception {
        return control.doQuery(params, user);
    }
}
