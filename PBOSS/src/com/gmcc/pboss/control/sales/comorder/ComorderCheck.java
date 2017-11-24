package com.gmcc.pboss.control.sales.comorder;

import java.util.List;

import com.gmcc.pboss.business.base.dictitem.DictitemVO;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaVO;
import com.sunrise.jop.infrastructure.control.AbstractControl;

/**
 * <pre>
 * @version 1.1
 * 用来做订购检查的辅助类
 * @version 1.2
 * 把所有方法名修改成不以do*开头的形式，使ComorderCheck的事务不由Spring托管;
 * 因为若其事务由Spring托管，检查不通过时抛出运行时异常将导致外层事务回滚，从
 * 而不能提交。而本辅助类的作用仅仅是检查不通过后抛出异常，让外层(调用方)捕获后
 * 进行相应业务处理，而不是回滚。
 * </pre>
 * @author Linli
 * @author zhangsiwei 
 */
public interface ComorderCheck extends AbstractControl {
	
	/**
	 * 对订购时段进行检查
	 * @throws Exception
	 */
	public void checkLimitTime(WayVO vo) throws Exception;

	/**
	 * 商品种类订购基数检查
	 * @param orderamount 订购数量
	 * @param comcategory 订购种类
	 * @throws Exception
	 */
	public void checkComcategoryUnitageMod(String comcategory,Long orderamount) throws Exception;
	
	/**
	 * 商品种类订购状态检查
	 * @param comcategory 订购种类
	 * @throws Exception
	 */
	public void checkComcategoryState(String comcategory) throws Exception;

	/**
	 * 所有辅助信息在这里面的存储
	 * @return
	 */
	public ComorderCheckHandle getHelpHandle(WayVO wayvo,List<DictitemVO> brandlist, String mode) throws Exception;
	
	/**
	 * 商品种类是否套卡
	 * @param comcategory 订购种类
	 * @return
	 * @throws Exception
	 */
	public ComcategoryrelaVO checkIsComressmp(String comcategory) throws Exception;
	
	/**
	 * 	套卡激活率检查（区分品牌/不区分品牌）
		1 区分品牌
		0 不区分品牌
	 * @param brand 品牌
	 * @param wayvo 渠道
	 * @throws Exception
	 */
	public void checkActiverate(String brand,	WayVO wayvo) throws Exception;
	
	/**
	 * 第5步要用到保底量,这里先获取保底量
	 * @param brand 品牌
	 * @param orderamount 订购数量
	 * @param wayvo 渠道
	 */
	public boolean checkBaseAmount(String brand, Long orderamount, String storarea, WayVO wayvo) throws Exception;
	
	/**
	 * 6) 当月可订购量检查
	 */
	public void checkOrderedmonthAndLimitCheck(String brand, Long orderamount, WayVO wayvo, String mode) throws Exception;
	
	/**
	 * 基准库存上限检查
	 */
	public void checkOrderedNowstock(String brand, String restype, Long orderamount, WayVO wayvo, String mode) throws Exception;
			
	/**
	 * 最高库存检查（预警库存模式）
	 */
	public void checkOrderedStockalarm(String brand, String restype, Long orderamount, WayVO wayvo, String mode) throws Exception;
	
	/**
	 * 限量订购检查
	 */
	public void checkLimit(String comcategory, Long orderamount, WayVO wayvo) throws Exception;
	
	public void checkResStock(String comcategory, Long orderamount, WayVO wayvo) throws Exception;
	
	
	/**
	 * 获取品牌
	 */
	public String getBrand(String comcategory) throws Exception;
	
	public void checkOrderedCardLimit(String comcategory, String restype, Long orderamount, WayVO wayvo, String mode) throws Exception;
	
	public void checkOrderedEmptySimLimit(ComorderCheckHandle handle,String comcategory, String restype, Long orderamount, WayVO wayvo, String mode) throws Exception;
	
}
