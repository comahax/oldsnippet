/**
* auto-generated code
* Sat Nov 28 17:50:09 CST 2009
*/
package com.sunrise.boss.business.cms.examine.mappinglog.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.examine.mappinglog.persistent.MappinglogVO;
import com.sunrise.boss.business.cms.examine.mappinglog.persistent.MappinglogListVO;

import java.io.Serializable;

/**
 * <p>Title: MappinglogControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface MappinglogControl extends AbstractControl {
    public MappinglogVO doCreate(MappinglogVO vo, User user)
        throws Exception;

    public void doRemove(MappinglogVO vo, User user)
        throws Exception;

    public MappinglogVO doUpdate(MappinglogVO vo, User user)
        throws Exception;

    public MappinglogVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(MappinglogListVO params, User user)
        throws Exception;

}
