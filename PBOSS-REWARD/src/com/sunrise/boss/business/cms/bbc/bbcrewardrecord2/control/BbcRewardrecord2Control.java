/**
* auto-generated code
* Mon Jan 09 14:26:52 CST 2012
*/
package com.sunrise.boss.business.cms.bbc.bbcrewardrecord2.control;

import java.io.Serializable;

import com.sunrise.boss.business.cms.bbc.bbcrewardrecord2.persistent.BbcRewardrecord2ListVO;
import com.sunrise.boss.business.cms.bbc.bbcrewardrecord2.persistent.BbcRewardrecord2VO;
import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>Title: BbcRewardrecord2Control</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface BbcRewardrecord2Control extends AbstractControl {
    public BbcRewardrecord2VO doCreate(BbcRewardrecord2VO vo, User user)
        throws Exception;

    public void doRemove(BbcRewardrecord2VO vo, User user)
        throws Exception;

    public BbcRewardrecord2VO doUpdate(BbcRewardrecord2VO vo, User user)
        throws Exception;

    public BbcRewardrecord2VO doFindByPk(Serializable pk, User user)
        throws Exception;
    
    public DataPackage doQuery(BbcRewardrecord2ListVO params, User user)
		throws Exception;
    
    public DataPackage doQuery2(BbcRewardrecord2ListVO params, User user)
		throws Exception;
    public DataPackage doQuery3(BbcRewardrecord2ListVO params, User user)
	throws Exception;
    public DataPackage doQuery4ThreadTotal(BbcRewardrecord2ListVO params, User user)
	throws Exception;
    
}
