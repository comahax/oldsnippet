/**
 * auto-generated code
 * Wed Jul 28 14:27:43 CST 2010
 */
package com.gmcc.pboss.control.reward.rewardlocaltitle;

import java.io.Serializable;

import com.gmcc.pboss.business.reward.rewardlocaltitle.RewardlocaltitleDBParam;
import com.gmcc.pboss.business.reward.rewardlocaltitle.RewardlocaltitleVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Rewardlocaltitle </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public interface Rewardlocaltitle extends AbstractControl {
    public RewardlocaltitleVO doCreate(RewardlocaltitleVO vo) throws Exception;

    public void doRemoveByVO(RewardlocaltitleVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public RewardlocaltitleVO doUpdate(RewardlocaltitleVO vo) throws Exception;

    public RewardlocaltitleVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(RewardlocaltitleDBParam params) throws Exception;

}
