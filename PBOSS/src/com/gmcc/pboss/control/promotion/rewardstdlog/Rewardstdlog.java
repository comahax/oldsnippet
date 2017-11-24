/**
 * auto-generated code
 * Mon Sep 14 16:40:25 CST 2009
 */
package com.gmcc.pboss.control.promotion.rewardstdlog;

import java.io.Serializable;

import com.gmcc.pboss.business.promotion.rewardstdlog.RewardstdlogDBParam;
import com.gmcc.pboss.business.promotion.rewardstdlog.RewardstdlogVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Rewardstdlog </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public interface Rewardstdlog extends AbstractControl {
    public RewardstdlogVO doCreate(RewardstdlogVO vo) throws Exception;

    public void doRemoveByVO(RewardstdlogVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public RewardstdlogVO doUpdate(RewardstdlogVO vo) throws Exception;

    public RewardstdlogVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(RewardstdlogDBParam params) throws Exception;

}
