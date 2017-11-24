/**
 * auto-generated code
 * Wed Jul 28 14:29:18 CST 2010
 */
package com.gmcc.pboss.control.reward.rewardlocaldtl;

import java.io.Serializable;

import com.gmcc.pboss.business.reward.rewardlocaldtl.RewardlocaldtlDBParam;
import com.gmcc.pboss.business.reward.rewardlocaldtl.RewardlocaldtlVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Rewardlocaldtl </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public interface Rewardlocaldtl extends AbstractControl {
    public RewardlocaldtlVO doCreate(RewardlocaldtlVO vo) throws Exception;

    public void doRemoveByVO(RewardlocaldtlVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public RewardlocaldtlVO doUpdate(RewardlocaldtlVO vo) throws Exception;

    public RewardlocaldtlVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(RewardlocaldtlDBParam params) throws Exception;

}
