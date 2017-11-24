package com.gmcc.pboss.model.delivery;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.LogFactory;

import com.gmcc.pboss.biz.info.delivery.bean.OrderState;
import com.gmcc.pboss.biz.info.delivery.dao.DeliveryDao;
import com.gmcc.pboss.common.action.AbstractAction;
import com.gmcc.pboss.common.bean.CodeReverse;
import com.gmcc.pboss.common.context.ContextUtil;
import com.gmcc.pboss.common.dictionary.CodeReverseKey;
import com.gmcc.pboss.common.log.Log;
import com.gmcc.pboss.common.service.CodeService;
import com.gmcc.pboss.common.util.CommonUtil;

/**
 * 配送单主表映射
 * @author Yuwenjun
 * @date 20100505
 */
public class DeliveryMainVo extends CodeReverse implements Serializable {
	private DeliveryDao deliveryDao;
	
	/**
	 * 提取缴费方式
	 * --从datas中提取
	 */
	public String getPaytypeName() {
		try {
			Object value = CommonUtil.getProperty(this.getDatas(),"paytype");
			return this.getPropertyByValue(CodeReverseKey.PAYTYPE, value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			short code = -1;
			Log.errorLog("", "", "", "", "DeliveryMainVo", code, -1, "反射错误:"+e.getMessage());
			return null;
		}
	}
	

	/**
	 * 提取签收状态
	 * --从datas中提取
	 */
	public String getSignstateName() {
		try {
			Object value = CommonUtil.getProperty(this.getDatas(),"signstate");
			return this.getPropertyByValue(CodeReverseKey.SIGNSTATE, value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			short code = -1;
			Log.errorLog("", "", "", "", "DeliveryMainVo", code, -1, "反射错误:"+e.getMessage());
			return null;
		}
	}
	/**
	 * 提取订单信息
	 * @return 订单信息汇总
	 */
	public String getOrderInfo(){
		//提取本身的订单号
		try {
			String orderId = (String)CommonUtil.getProperty(this,"orderid");

			if (deliveryDao == null) {
				deliveryDao = (DeliveryDao) ContextUtil.getContext().getBean("deliveryDao");
				if (deliveryDao ==null){
					logger.error("反射注入出错!");
					return null;
				}
			}
			List<OrderState> ordLst = this.deliveryDao.getOrderInfo(orderId);
			StringBuffer sb = new StringBuffer();
			boolean fst = true;
			for (OrderState dtl:ordLst){
				sb.append((fst?"":","));
				sb.append(dtl.getDictItemName());
				sb.append('(');
				sb.append(dtl.getNum());
				sb.append(')');
				fst = false;
			}
			
			return sb.toString();
		}catch(Exception e){

			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			short code = -1;
			Log.errorLog("", "", "", "", "DeliveryMainVo", code, -1, "反射错误:"+e.getMessage());
			return null;
		}
	}

	/**
	 * @return the deliveryDao
	 */
	public DeliveryDao getDeliveryDao() {
		return deliveryDao;
	}


	/**
	 * @param deliveryDao the deliveryDao to set
	 */
	public void setDeliveryDao(DeliveryDao deliveryDao) {
		this.deliveryDao = deliveryDao;
	}
	
}
