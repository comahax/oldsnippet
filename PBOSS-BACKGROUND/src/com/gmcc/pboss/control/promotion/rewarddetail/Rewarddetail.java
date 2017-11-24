/**
 * auto-generated code
 * Tue Sep 15 15:37:05 CST 2009
 */
package com.gmcc.pboss.control.promotion.rewarddetail;

import java.io.Serializable;

import com.gmcc.pboss.business.promotion.rewarddetail.RewarddetailDBParam;
import com.gmcc.pboss.business.promotion.rewarddetail.RewarddetailVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Rewarddetail </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface Rewarddetail extends AbstractControl {
    public RewarddetailVO doCreate(RewarddetailVO vo) throws Exception;

    public void doRemoveByVO(RewarddetailVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public RewarddetailVO doUpdate(RewarddetailVO vo) throws Exception;

    public RewarddetailVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(RewarddetailDBParam params) throws Exception;

}
