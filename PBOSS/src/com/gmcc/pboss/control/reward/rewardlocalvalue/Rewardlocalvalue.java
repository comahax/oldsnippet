/**
 * auto-generated code
 * Wed Jul 28 14:30:16 CST 2010
 */
package com.gmcc.pboss.control.reward.rewardlocalvalue;

import java.io.Serializable;

import com.gmcc.pboss.business.reward.rewardlocalvalue.RewardlocalvalueDBParam;
import com.gmcc.pboss.business.reward.rewardlocalvalue.RewardlocalvalueVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Rewardlocalvalue </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public interface Rewardlocalvalue extends AbstractControl {
    public RewardlocalvalueVO doCreate(RewardlocalvalueVO vo) throws Exception;

    public void doRemoveByVO(RewardlocalvalueVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public RewardlocalvalueVO doUpdate(RewardlocalvalueVO vo) throws Exception;

    public RewardlocalvalueVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(RewardlocalvalueDBParam params) throws Exception;

}
