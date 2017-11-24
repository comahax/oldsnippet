/**
 * auto-generated code
 * Mon Sep 14 16:39:35 CST 2009
 */
package com.gmcc.pboss.control.promotion.rewardstd;

import java.io.Serializable;

import com.gmcc.pboss.business.promotion.rewardstd.RewardstdDBParam;
import com.gmcc.pboss.business.promotion.rewardstd.RewardstdVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Rewardstd </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public interface Rewardstd extends AbstractControl {
    public RewardstdVO doCreate(RewardstdVO vo) throws Exception;

    public void doRemoveByVO(RewardstdVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public RewardstdVO doUpdate(RewardstdVO vo) throws Exception;

    public RewardstdVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(RewardstdDBParam params) throws Exception;

}
