/**
 * auto-generated code
 * Thu Apr 10 14:34:42 CST 2014
 */
package com.gmcc.pboss.control.base.rewardsendsms;

import java.io.Serializable;

import com.gmcc.pboss.business.base.rewardsendsms.RewardsendsmsDBParam;
import com.gmcc.pboss.business.base.rewardsendsms.RewardsendsmsVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Rewardsendsms </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Rewardsendsms extends AbstractControl {
    public RewardsendsmsVO doCreate(RewardsendsmsVO vo) throws Exception;

    public void doRemoveByVO(RewardsendsmsVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public RewardsendsmsVO doUpdate(RewardsendsmsVO vo) throws Exception;

    public RewardsendsmsVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(RewardsendsmsDBParam params) throws Exception;

}
