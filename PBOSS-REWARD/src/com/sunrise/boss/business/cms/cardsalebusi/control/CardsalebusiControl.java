/**
* auto-generated code
* Fri Aug 03 11:10:45 CST 2007
*/
package com.sunrise.boss.business.cms.cardsalebusi.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.cardsalebusi.persistent.CardsalebusiVO;
import com.sunrise.boss.business.cms.cardsalebusi.persistent.CardsalebusiListVO;

import java.io.Serializable;

/**
 * <p>Title: CardsalebusiControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface CardsalebusiControl extends AbstractControl {
    public CardsalebusiVO doCreate(CardsalebusiVO vo, User user)
        throws Exception;

    public void doRemove(CardsalebusiVO vo, User user)
        throws Exception;

    public CardsalebusiVO doUpdate(CardsalebusiVO vo, User user)
        throws Exception;

    public CardsalebusiVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(CardsalebusiListVO params, User user)
        throws Exception;

}
