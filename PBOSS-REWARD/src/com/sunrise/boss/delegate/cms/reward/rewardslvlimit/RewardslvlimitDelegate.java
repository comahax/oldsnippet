/**
* auto-generated code
* Wed Nov 02 19:11:53 CST 2011
*/
package com.sunrise.boss.delegate.cms.reward.rewardslvlimit;

import java.util.List;
import java.util.Iterator;

import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.delegate.DelegateException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.rewardslvlimit.persistent.RewardslvlimitVO;
import com.sunrise.boss.business.cms.reward.rewardslvlimit.persistent.RewardslvlimitListVO;
import com.sunrise.boss.business.cms.reward.rewardslvlimit.control.RewardslvlimitControlBean;
import com.sunrise.boss.business.cms.reward.rewardslvlimit.control.RewardslvlimitControl;

import java.io.Serializable;

/**
 * <p>Title: RewardslvlimitDelegate</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public class RewardslvlimitDelegate {

    private static RewardslvlimitControl control;

    public RewardslvlimitDelegate() throws Exception {
        control = (RewardslvlimitControl) ControlFactory.build(RewardslvlimitControlBean.class);
        if (null == control) {
            throw new DelegateException(this.getClass() + " initialize failed");
        }
    }

    public RewardslvlimitVO doCreate(RewardslvlimitVO vo, User user)
        throws Exception {
        return control.doCreate(vo, user);
    }

    public void doRemove(RewardslvlimitVO vo, User user)
        throws Exception {
        control.doRemove(vo, user);
    }

    public RewardslvlimitVO doUpdate(RewardslvlimitVO vo, User user)
        throws Exception {
        return control.doUpdate(vo, user);
    }

    public RewardslvlimitVO doFindByPk(Serializable pk, User user)
        throws Exception {
        return (RewardslvlimitVO) control.doFindByPk(pk, user);
    }

    public DataPackage doQuery(RewardslvlimitListVO params, User user)
        throws Exception {
        return control.doQuery(params, user);
    }
    
    public void doModifyuplimit(List list,User user)
    	throws Exception{
    	Iterator iter = list.iterator();
    	while(iter.hasNext()){
    		RewardslvlimitVO newVO = (RewardslvlimitVO)iter.next();
    		Serializable seria = new RewardslvlimitVO(newVO.getOpnid(),newVO.getRegion(),newVO.getRewardid(),newVO.getSlv());
    		RewardslvlimitVO oldVO = this.doFindByPk(seria, user);
    		if(oldVO==null){
    			if(newVO.getRewardlimit()!=null && newVO.getRewardlimit()!=0.0){
    				this.doCreate(newVO, user);
    			}
    		}else{
    			if(newVO.getRewardlimit()!=null && newVO.getRewardlimit()!=0.0){
    				this.doUpdate(newVO, user);
    			}else{
    				this.doRemove(newVO, user);
    			}
    		}    		
    	}
    }

}
