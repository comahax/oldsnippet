/**
* auto-generated code
* Thu Dec 15 07:12:07 GMT 2011
*/
package com.sunrise.boss.business.cms.cityrecord.control;

import com.sunrise.boss.common.base.control.AbstractControl;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.cityrecord.persistent.CityrecordVO;
import com.sunrise.boss.business.cms.cityrecord.persistent.CityrecordListVO;
import com.sunrise.boss.business.cms.reward.rewardrecord.persistent.RewardrecordDAO;
import com.sunrise.boss.business.cms.reward.rewardrecord.persistent.RewardrecordListVO;

import java.io.Serializable;

/**
 * <p>Title: CityrecordControl</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public interface CityrecordControl extends AbstractControl {
    public CityrecordVO doCreate(CityrecordVO vo, User user)
        throws Exception;

    public void doRemove(CityrecordVO vo, User user)
        throws Exception;

    public CityrecordVO doUpdate(CityrecordVO vo, User user)
        throws Exception;

    public CityrecordVO doFindByPk(Serializable pk, User user)
        throws Exception;

    public DataPackage doQuery(CityrecordListVO params, User user)
        throws Exception;
    
    public DataPackage doThreeQuery(CityrecordListVO params, User user)
    	throws Exception;
    
    public void doIssue(String[] pkValueArray, User user)
		throws Exception;
      
    public String[] doIssue(CityrecordListVO params, User user) throws Exception;
    
    /**
     * 2012-8-11 shixiaolong
     * 不使用此方法
     * @param vo
     * @param user
     * @throws Exception
     */
    @Deprecated
    public void doIssuecheck(CityrecordVO vo, User user)
	throws Exception;
    
    public void doAllissue(CityrecordListVO params, User user)
		throws Exception ;
    public void doOnlyissue(CityrecordListVO params, User user)
	throws Exception ;
    public DataPackage doListstat(CityrecordListVO params, User user)
    	throws Exception;
    public DataPackage doListstatenhance(CityrecordListVO params, User user)
	throws Exception;
    public DataPackage doListstatenhancecount(CityrecordListVO params, User user)
	throws Exception;
    
    public int doAllConfirm(CityrecordListVO params, User user)
		throws Exception;
    
    public DataPackage doListdetail(CityrecordListVO params,String opnid2,String rewardtype,String oprmonth, String isflag,User user)
		throws Exception;
    
    public int doConfirmone(CityrecordListVO params,String opnid2,String rewardtype,String oprmonth, User user)
		throws Exception;
    public DataPackage doQueryDetail(CityrecordListVO params, User user)
	throws Exception ;
    
    public DataPackage doThreeQueryEhance(CityrecordListVO params, User user)
	throws Exception ;
    public DataPackage doThreeQueryEhanceCount(CityrecordListVO params, User user) throws Exception;
    
	/**
	 * 单笔删除，该方法不再使用
	 * 20120914 将该功能从[地市酬金明细上传管理]迁移到[酬金明细数据查询]菜单
	 */
    //public void doDeletepart(CityrecordListVO params, User user)throws Exception;
   
    public int doDeleteall(CityrecordListVO params, User user) throws Exception;
    
    public DataPackage doThreeQuery4Thread(CityrecordListVO params, User user)
	throws Exception;

    public DataPackage doOnlysum(CityrecordListVO params, User user)
	throws Exception;
    
    public DataPackage doListstatenhanceexcel(CityrecordListVO params, User user)
	throws Exception ;
    
    /**
	 * 查询opnid 非0403开头和非07开头特种业务的数据
	 * @param params
	 * @param user
	 * @param querytype 1查询数据、2统计总数、3查询数据和统计总数
	 * @return
	 */
    public DataPackage doQueryMainopn(CityrecordListVO params, User user, int querytype)throws Exception;
    /**
	 * 社会渠道酬金发布 opnid非0403、非07开头的特种业务
	 * @param params
	 * @param user
	 * @param datestamp 任务号
	 * @return
	 * @throws Exception
	 */
    public int doSaveMainopn(CityrecordListVO params, User user, long datestamp, int batchsize)throws Exception;

    /**
	 * 查询opnid 07开头的特种业务
	 * @param params
	 * @param user
	 * @param querytype 1查询数据、2统计总数、3查询数据和统计总数
	 * @return
	 * @throws Exception
	 */
	public DataPackage doQuerySpecialopn07(CityrecordListVO params, User user, int querytype)throws Exception;
	/**
	 * 社会渠道酬金发布 opnid 07开头的特种业务
	 * @param params
	 * @param user
	 * @param datestamp 任务号
	 * @return
	 * @throws Exception
	 */
	public int doSaveSpecialopn07(CityrecordListVO params, User user, long datestamp, int batchsize)throws Exception;

	/**
	 * 查询opnid 0403开头的特种业务
	 * @param params
	 * @param user
	 * @param querytype 1查询数据、2统计总数、3查询数据和统计总数
	 * @return
	 * @throws Exception
	 */
	public DataPackage doQuerySpecialopn0403(CityrecordListVO params, User user, int querytype)throws Exception;
	/**
	 * 社会渠道酬金发布 opnid 0403开头的特种业务
	 * @param params
	 * @param user
	 * @param datestamp 任务号
	 * @return
	 * @throws Exception
	 */	
	public int doSaveSpecialopn0403(CityrecordListVO params, User user, long datestamp, int batchsize)throws Exception;
	
	/**
	 * COMS明细到处查询
	 * @param params
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public DataPackage doQueryexceldetail(CityrecordListVO params, User user) throws Exception;
	
	/**
	 * 根据CH_ADT_CITYRECORD表DCORDID字段，将ISFLAG字段改为指定状态
	 * @param isflag
	 * @param dcordid
	 * @return
	 * @throws Exception
	 */
	public int updateIsflagByDcordid(Short isflag, Long dcordid, User user) throws Exception;
}

