/**
* auto-generated code
* Mon Dec 08 10:50:04 CST 2008
*/
package com.sunrise.boss.business.cms.bbc.bbcrewardrecord.control;

import java.io.Serializable;

import com.sunrise.boss.business.cms.bbc.bbcrewardrecord.persistent.BbcRewardrecordListVO;
import com.sunrise.boss.business.cms.bbc.bbcrewardrecord.persistent.BbcRewardrecordVO;
import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: BbcRewardrecordControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: SUNRISE Tech Ltd.</p>
 * @author Zhang Fengchao
 * @version 1.0
 */
public interface BbcRewardrecordControl extends AbstractControl {
    public BbcRewardrecordVO doCreate(BbcRewardrecordVO vo, User user)
        throws Exception;

    public void doRemove(BbcRewardrecordVO vo, User user)
        throws Exception;

    public BbcRewardrecordVO doUpdate(BbcRewardrecordVO vo, User user)
        throws Exception;

    public BbcRewardrecordVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(BbcRewardrecordListVO params, User user)
        throws Exception;

}
