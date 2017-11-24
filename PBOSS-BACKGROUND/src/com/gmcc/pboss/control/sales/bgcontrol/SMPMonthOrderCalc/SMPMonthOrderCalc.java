package com.gmcc.pboss.control.sales.bgcontrol.SMPMonthOrderCalc;

import java.util.Map;

import com.gmcc.pboss.business.sales.bgbusiness.PartnerSMPBrandVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;
import com.sunrise.jop.ui.User;

public interface SMPMonthOrderCalc extends AbstractControl {

	/**
	 * 删除month指定月份的订购量数据
	 * @param destMonth
	 * @return
	 * @throws Exception
	 */
	 public int doDeleteMonthOrder(String destMonth) throws Exception;
	    
	    /**
	     * 获取 在months指定月份中发生订购业务的所有渠道的套卡品牌的总激活量
	     * @param months
	     * @param cityid
	     * @return 映射中的 key = PartnerSMPBrandVO(包含渠道id和套卡品牌); value = 总月份数|总激活量|渠道星级
	     * @throws Exception
	     */
	 public Map<PartnerSMPBrandVO,String> doStatMonthOrder(String[] months) throws Exception;
	 
	 /**
	  * 更新上月实际订购量和激活量
	  * @param destMonth 目标月份 yyyyMM 
	  * destMonth为null值时默认取当前月
	  * @throws Exception
	  */
	 public void doUpdateLMOrderAndActive(String destMonth) throws Exception;
	 
	 /**
	  * 新增本月订购量数据
	  * @param destMonth
	  * @throws Exception
	  */
	 public void doCreateMonthOrder(String destMonth) throws Exception;
	 
	 /**
	  * “合作商套卡月订购量计算”入口方法
	  * @param destMonth
	  * @throws Exception
	  */
	 public void doProcess(String destMonth) throws Exception;
}
