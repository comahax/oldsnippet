/**
 * auto-generated code
 * Tue Oct 20 17:13:30 CST 2009
 */
package com.gmcc.pboss.control.sales.partnerres;

import java.io.Serializable;
import java.util.Date;

import com.gmcc.pboss.business.sales.partnerres.PartnerresDBParam;
import com.gmcc.pboss.business.sales.partnerres.PartnerresVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: Partnerres </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public interface Partnerres extends AbstractControl {
    public PartnerresVO doCreate(PartnerresVO vo) throws Exception;

    public void doRemoveByVO(PartnerresVO vo) throws Exception;

    public void doRemoveByPK(Serializable pk) throws Exception;
    
    public PartnerresVO doUpdate(PartnerresVO vo) throws Exception;

    public PartnerresVO doFindByPk(Serializable pk) throws Exception;

    public DataPackage doQuery(PartnerresDBParam params) throws Exception;
    
    /**
     * 统计套卡已激活量 
     * @param countyid
     * @param comcategory
     * @param targetDay
     * @return
     * @throws Exception
     */
    public Integer doStatSMPActiveQty(String countyid,String comcategory,int targetDay) throws Exception;
    /**
     * 统计套卡已销售量
     * @param countyid
     * @param comcategory
     * @param targetDay
     * @return
     * @throws Exception
     */
    public Integer doStatSMPSoldQty(String countyid,String comcategory,int targetDay) throws Exception;
    
    /**
     * 分品牌统计各个渠道在指定间隔月内的套卡激活量,该品牌必须在指定间隔月份内每个月都要有激活量
     * @param begintime
     * @param endtime
     * @param intervalMonth 间隔月份数
     * @return
     * @throws Exception
     */
    public DataPackage doStatSMPActiveQtyInMonths(Date begintime,Date endtime,int intervalMonth) throws Exception ;
    
    /**
     * 按分公司，品牌统计某分公司的套卡资源总库存
     * @param isactive
     * @param restype
     * @return
     * @throws Exception
     */
    public DataPackage doStatCountyQty(int isactive,String restype) throws Exception ;
    
    /**
     * 按分公司，品牌统计某分公司前days天已领取的套卡资源量 后台[资源库存预警]使用
     * @param days
     * @param restype
     * @return
     * @throws Exception
     */
    public DataPackage doStatCountyReceivedQty(int days, String restype) throws Exception;
    
    /**
     * 按“合作商编码[WAYID]”、“品牌[BRAND]”分组统计，取得网点“库存量”
     * @return
     * @throws Exception
     */
    public DataPackage doStatWayStdAmount() throws Exception;

    /**
     * 按“合作商编码[WAYID]” 、“品牌[BRAND]”分组统计，取得指定时间内网点“领货量”
     * @param begintime
     * @param endtime
     * @return
     * @throws Exception
     */
    public DataPackage doStatWayLHAmount(Date begintime,Date endtime) throws Exception;
    
    /**
     * 按“合作商编码[WAYID]” 、“品牌[BRAND]”分组统计，取得指定时间内网点“激活量”。
     * @param begintime
     * @param endtime
     * @return
     * @throws Exception
     */
    public DataPackage doStatWayActiveAmount(Date begintime,Date endtime) throws Exception;
    
    /**
     * 按“合作商编码[WAYID]” 、“品牌[BRAND]”分组统计
     * 创建时间和激活时间在同一个时间段内的网点“激活量”
     * @param begintime
     * @param endtime
     * @return
     * @throws Exception
     */
    public DataPackage doStatActiveAmount_2(Date begintime,Date endtime) throws Exception;
    
    /**
     * 统计配送商垫资的订单以创建网点库存快照
     * @param restype
     * @return
     * @throws Exception
     */
    public DataPackage doStatWayOrderForSnapShot(String restype) throws Exception;
   
    public DataPackage doComcategoryQty(String wayid)throws Exception;
    
    /**
	 * 获取空白SIM卡已使用量
	 */
    public DataPackage doEmptySimUseCount(String wayid) throws Exception;
}
