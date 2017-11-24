/**
* auto-generated code
* Mon Nov 16 17:27:59 CST 2009
*/
package com.sunrise.boss.business.cms.bbc.bbcyzrewarddet.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.bbc.bbcyzrewarddet.persistent.BbcYzrewarddetVO;
import com.sunrise.boss.business.cms.bbc.bbcyzrewarddet.persistent.BbcYzrewarddetListVO;

import java.io.Serializable;

/**
 * <p>Title: BbcYzrewarddetControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public interface BbcYzrewarddetControl extends AbstractControl {
    public BbcYzrewarddetVO doCreate(BbcYzrewarddetVO vo, User user)
        throws Exception;

    public void doRemove(BbcYzrewarddetVO vo, User user)
        throws Exception;

    public BbcYzrewarddetVO doUpdate(BbcYzrewarddetVO vo, User user)
        throws Exception;

    public BbcYzrewarddetVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(BbcYzrewarddetListVO params, User user)
        throws Exception;

}
