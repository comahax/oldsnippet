/**
* auto-generated code
* Mon Mar 05 15:38:34 CST 2012
*/
package com.sunrise.boss.business.cms.zjty.zjtyimportrec.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.zjty.zjtyimportrec.persistent.ZjtyImportrecVO;
import com.sunrise.boss.business.cms.zjty.zjtyimportrec.persistent.ZjtyImportrecListVO;

import java.io.Serializable;

/**
 * <p>Title: ZjtyImportrecControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author qiuzhi
 * @version 1.0
 */
public interface ZjtyImportrecControl extends AbstractControl {
    public ZjtyImportrecVO doCreate(ZjtyImportrecVO vo, User user)
        throws Exception;

    public void doRemove(ZjtyImportrecVO vo, User user)
        throws Exception;

    public ZjtyImportrecVO doUpdate(ZjtyImportrecVO vo, User user)
        throws Exception;

    public ZjtyImportrecVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(ZjtyImportrecListVO params, User user)
        throws Exception;

}
