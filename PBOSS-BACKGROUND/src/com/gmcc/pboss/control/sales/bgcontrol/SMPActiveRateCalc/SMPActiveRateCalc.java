package com.gmcc.pboss.control.sales.bgcontrol.SMPActiveRateCalc;

import java.math.BigDecimal;
import java.util.Map;

import com.gmcc.pboss.business.sales.bgbusiness.PartnerSMPBrandVO;
import com.gmcc.pboss.business.sales.noactinfo.NoactinfoDBParam;
import com.gmcc.pboss.business.sales.partnerres.PartnerresDBParam;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.infrastructure.db.DataPackage;

public interface SMPActiveRateCalc extends AbstractControl {

	 /**
     *  <p>用于7.5.38 套卡激活率计算</p>
     *  <p>不区分品牌</p>
     * 	<p>按照合作商编码分组统计合作商资源表（FX_SW_PARTNERRES）中未激活和已激活的套卡数量</p>
     * @param activeOrderDay   已激活套卡订购天数
     * @param activeDay        已激活套卡激活天数
     * @param inActiveOrderDay 未激活套卡订购天数
     * @return
     */
    public Map<String,String> doStatSMPNotWithBrand(int activeOrderDay,int activeDay,int inActiveOrderDay) throws Exception;
    /**
     * <p>用于套卡激活率计算</p>
     * <p>区分品牌</p>
     * <p>按照合作商编码、套卡品牌分组统计合作商资源表（FX_SW_PARTNERRES）中未激活和已激活的套卡数量</p>
     * @param activeOrderDay   已激活套卡订购天数
     * @param activeDay        已激活套卡激活天数
     * @param inActiveOrderDay 未激活套卡订购天数
     * @param cityid
     * @return
     * @throws Exception
     */
    public Map<PartnerSMPBrandVO,Long[]> doStatSMPWithBrand(int activeOrderDay,int activeDay,int inActiveOrderDay) throws Exception;
    
    public Map<PartnerSMPBrandVO,BigDecimal> doStatInActiveSMPWithBrand() throws Exception;
    
    /**
     * <pre>
     * 用于7.5.38 套卡激活率计算
     * 区分品牌
     * 根据合作商编码，套卡品牌 分组统计合作商资源表（FX_SW_PARTNERRES）中某时间段里的激活量和订购量
     * </pre>
     * @param activeOrderDay 已激活套卡订购天数
     * @param activeDay      已激活套卡激活天数
     * @param orderDay       订购量订购天数
     * @return
     * @throws Exception
     */
    public Map<PartnerSMPBrandVO,String> doStatActiveAndOrderSMPWithBrand(int activeOrderDay,
			int activeDay,int orderDay) throws Exception ;
    /**
     * <pre>
     * 用于7.5.38 套卡激活率计算
     * 不区分品牌
     * 根据合作商编码 分组统计合作商资源表（FX_SW_PARTNERRES）中某时间段里的激活量和订购量
     * </pre>
     * @param activeOrderDay 已激活套卡订购天数
     * @param activeDay      已激活套卡激活天数
     * @param orderDay       订购量订购天数
     * @return
     * @throws Exception
     */
    public Map<String,String> doStatActiveAndOrderSMPNotWithBrand(int activeOrderDay,
			int activeDay,int orderDay) throws Exception ;
    
    /**
     * <pre>
     * 用于7.5.39 合作商套卡月订购量计算 
     * 区分品牌
     * 根据合作商编码，套卡品牌 对合作商资源表（FX_SW_PARTNERRES）数据分组统计上月的订购量和激活量
     * </pre> 
     * @param wayid
     * @param brand
     * @param firstDayOfMonth
     * @param endDayOfMonth
     * @return
     * @throws Exception
     */
    public BigDecimal[] doStatOrderAndActiveSMPWithBrand(String wayid,String brand,java.util.Date firstDayOfMonth,java.util.Date endDayOfMonth) throws Exception;
    /**
     * <pre>
     * 用于7.5.39 合作商套卡月订购量计算 
     * 不区分品牌
     * 根据合作商编码 对合作商资源表（FX_SW_PARTNERRES）数据分组统计上月的订购量和激活量
     * </pre>
     * @param wayid
     * @param firstDayOfMonth
     * @param endDayOfMonth
     * @return
     * @throws Exception
     */
    public BigDecimal[] doStatOrderAndActiveSMPNotWithBrand(String wayid,java.util.Date firstDayOfMonth,java.util.Date endDayOfMonth) throws Exception;
    
    /**
     * 统计上个月各个渠道的套卡激活量
     * @param cityid
     * @return 返回渠道标识及其上月套卡激活量的映射
     * @throws Exception
     */
    public Map<String,BigDecimal> doStatActiveSMPLastMonth() throws Exception;
    
    /**
     * 合作商套卡激活数据更新
     * @param intervalDay 合作商资源表中的创建时间和号码激活记录表中的激活时间的间隔天数
     * @return
     * @throws Exception
     */
    public int doSMPActiveUpdate(int intervalDay) throws Exception;
    
    /**
	 * 按照不同模式进行套卡激活率计算
	 * @throws Exception
	 */
    public void doSMPActiveRateCalc() throws Exception;
    
    /**
     * 联合查询 合作商资源表（FX_SW_PARTNERRES）和 号码激活记录表（FX_SN_NOACTINFO）,
     * 查出同时存在于两个表中的未激活的套卡
     * @param param1
     * @param param2
     * @return
     * @throws Exception
     */
    public DataPackage doUnionQuerySmpInfo(PartnerresDBParam param1, NoactinfoDBParam param2) throws Exception;
    
    /**
     * 套卡激活率计算的入口方法
     * @throws Exception
     */
    public void doProcess() throws Exception;
}
