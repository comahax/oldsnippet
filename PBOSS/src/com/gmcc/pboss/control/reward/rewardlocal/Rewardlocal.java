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
     * ���س������ж� �߼� 
     * @param rewardmonth	�����·�
     * @param prttype		��������
     * @return ���ڣ�TRUREE ����FALSE
     */
    public boolean doIsExistReward(String rewardmonth,String prttype) throws Exception;
    
    /**
     * ���س��ɾ�� �߼� 
     * @param rewardmonth	�����·�
     * @param prttype		��������
     */
    public void doRemoveReward(String rewardmonth,String prttype) throws Exception;

    /**
	 * ��ӱ��س���ֶζ���
	 * @param rewardmonth ��������
	 * @param rpttype ��������
	 * @param items ��Ҫ��ӵ��ֶ���
	 */
	public int[] doAddRewardlocaltitle(String rewardmonth,String rpttype,String[] items) throws Exception;
	
	/**
	 * ��ӳ��(����ֵ��)����
	 * @param rewardmonth ��������
	 * @param rpttype ��������
	 * @param items 
	 * @param req ��ʶ���
	 */
	public void doAddRewardlocal(String rewardmonth,String rpttype,String[] items,int[] req) throws Exception;
}
