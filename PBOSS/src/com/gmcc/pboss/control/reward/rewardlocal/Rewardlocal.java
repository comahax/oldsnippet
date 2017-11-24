/**
 * auto-generated code
 * Wed Jul 28 14:21:59 CST 2010
 */
package com.gmcc.pboss.control.reward.rewardlocal;

import java.io.Serializable;

import com.gmcc.pboss.business.reward.rewardlocal.RewardlocalDBParam;
import com.gmcc.pboss.business.reward.rewardlocal.RewardlocalVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Rewardlocal </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public interface Rewardlocal extends AbstractControl {
    public RewardlocalVO doCreate(RewardlocalVO vo) throws Exception;

    public void doRemoveByVO(RewardlocalVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public RewardlocalVO doUpdate(RewardlocalVO vo) throws Exception;

    public RewardlocalVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(RewardlocalDBParam params) throws Exception;
    
    public Object doGetSequence(String sequenceName) throws Exception;
    /**
     * 本地酬金存在判断 逻辑 
     * @param rewardmonth	结算月份
     * @param prttype		报表类型
     * @return 存在：TRUREE 否则：FALSE
     */
    public boolean doIsExistReward(String rewardmonth,String prttype) throws Exception;
    
    /**
     * 本地酬金删除 逻辑 
     * @param rewardmonth	结算月份
     * @param prttype		报表类型
     */
    public void doRemoveReward(String rewardmonth,String prttype) throws Exception;

    /**
	 * 添加本地酬金字段定义
	 * @param rewardmonth 结算年月
	 * @param rpttype 报表类型
	 * @param items 需要添加的字段项
	 */
	public int[] doAddRewardlocaltitle(String rewardmonth,String rpttype,String[] items) throws Exception;
	
	/**
	 * 添加酬金(主表，值表)数据
	 * @param rewardmonth 结算年月
	 * @param rpttype 报表类型
	 * @param items 
	 * @param req 标识序号
	 */
	public void doAddRewardlocal(String rewardmonth,String rpttype,String[] items,int[] req) throws Exception;
}
