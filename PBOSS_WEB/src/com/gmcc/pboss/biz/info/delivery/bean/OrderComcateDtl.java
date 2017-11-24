package com.gmcc.pboss.biz.info.delivery.bean;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.biz.basic.dictItem.service.DictItemService;
import com.gmcc.pboss.biz.info.delivery.dao.DeliveryDao;
import com.gmcc.pboss.common.bean.CodeReverse;
import com.gmcc.pboss.common.context.ContextUtil;
import com.gmcc.pboss.common.dictionary.CodeReverseKey;
import com.gmcc.pboss.common.dictionary.ConstantsType;
import com.gmcc.pboss.common.log.Log;
import com.gmcc.pboss.common.util.CommonUtil;

/**
 * 从兴公司营账部
 * @author yuwenjun
 * @date 2009-10-3
 * 所属项目：PBOSS
 * 所属模块：门户网站
 * 描述：订单商品统计信息
 */
public class OrderComcateDtl extends CodeReverse {
	private DictItemService dictItemService;
	
	/**
	 * 配送单查询DAO（包括商品明细查询包含在此DAO中）
	 */
	private DeliveryDao deliveryDao;
	/**
	 * 返回单位
	 * @return
	 */
	public String getComcateUtil(){
		try{
			if (dictItemService == null) {
				dictItemService = (DictItemService) ContextUtil.getContext().getBean("dictItemService");
				if (dictItemService ==null){
					logger.error("dictItemService反射注入出错!");
					return null;
				}
			}
			String comcategory =(String) CommonUtil.getProperty(this,"comcategory");
			String value = dictItemService.getTypeByCode(comcategory);
			return this.getPropertyByValue(CodeReverseKey.COMCATEGORY_UNIT,value);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			short code = -1;
			Log.errorLog("", "", "", "getComcateUtil方法", "OrderComcateDtl", code, -1, "反射错误:"+e.getMessage());
			return null;
		}
	}
	
	/**
	 * 返回 物品编号 （订单中的包号等信息）
	 * @return
	 */
	public String getOdrPackageInfo(){
		/**分三种（两个SQL）情况返回*/
		if (dictItemService == null) {
			dictItemService = (DictItemService) ContextUtil.getContext().getBean("dictItemService");
			if (dictItemService ==null){
				logger.error("dictItemService反射注入出错!");
				Log.errorLog("", "", "", "getOdrPackageInfo方法", "OrderComcateDtl", (short)0, -1, "dictItemService反射注入出错");
				return null;
			}
		}
		try{
			String comcategory =(String) CommonUtil.getProperty(this,"comcategory");
			String comctgType = dictItemService.getTypeByCode(comcategory);
			String ordercomtype = (String) CommonUtil.getProperty(this,"ordercomtype");
			String orderid = (String) CommonUtil.getProperty(this,"orderid");
			String rtn = "";
			//资源类型为[套卡] 且 订单商品类型为[客户订购]时
			if (ConstantsType.COMRESSMP.equals(comctgType)) {
				if (ConstantsType.ORDERCOMTYPE_CUSTORDER.equals(ordercomtype) ){
					rtn  = this.getPackageInfo(orderid, ordercomtype, comcategory);
				}
				//资源类型为[套卡]且订单商品类型[非客户订购]			
				else {
					rtn = this.getMaxMinInfo(orderid, ordercomtype, comcategory);
				}
				
			}
			//资源类型为充值卡
			else if (ConstantsType.COMRESCARD.equals(comctgType)){
				rtn = this.getMaxMinInfo(orderid, ordercomtype, comcategory);
			} 
			

			//为了返回给客户展示为HTML，把\n转码为<BR>（回车）
			rtn = rtn.replaceAll("\\n", "<br>");
			return rtn;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			short code = -2;
			Log.errorLog("", "", "", "getOdrPackageInfo方法", "OrderComcateDtl", code, -1, "反射错误:"+e.getMessage());
			return null;
		}
	}
	
	/**
	 * 返回包号、批次号封装信息
	 * @param orderid 订单号
	 * @param ordercomtype 订单订购类型
	 * @param category 商品种类 
	 * @return 返回形如：批次号-包号(数量)[分隔符]的格式
	 */
	private String getPackageInfo(String orderid,String ordercomtype,String category){
		short code = -3;
		if (deliveryDao == null) {
			deliveryDao = (DeliveryDao) ContextUtil.getContext().getBean("deliveryDao");
			if (deliveryDao ==null){
				logger.error("getPackageInfo:deliveryDao反射注入出错!");
				Log.errorLog("", "", "", "getOdrPackageInfo方法", "OrderComcateDtl", code, -1, "getPackageInfo:deliveryDao反射注入出错");
				return null;
			}
		}
		List<OrderPackageInfo> rtnLst = deliveryDao.getOrderBatchNoDtl(orderid, ordercomtype, category);
		StringBuffer sb = new StringBuffer();
		String rx = "\n";//分隔符
		boolean nonfirst = false;
		//对返回值进行封装，返回形如：批次号-包号(数量)[分隔符]的格式
		for(OrderPackageInfo info:rtnLst){
			//合并两个之间的连接符
			if (nonfirst) 
				sb.append(rx);
			else 
				nonfirst = true;
			
			sb.append(info.getBatchno());
			if (StringUtils.isNotEmpty(info.getBoxnum())){
				//包号可能为空
				sb.append('-');
				sb.append(info.getBoxnum());
			}
			sb.append('(');
			sb.append(info.getCount());
			sb.append(')');
			
			
		}
		return sb.toString();
	}//getPackageInfo
	
	/**
	 * 返回最大号码、最小号码封装信息
	 * @param orderid 订单号
	 * @param ordercomtype 订单订购类型
	 * @param category 商品种类 
	 * @return 返回形如：最小值~最大值（数量）格式
	 */
	private String getMaxMinInfo(String orderid,String ordercomtype,String category){
		short code = -3;
		if (deliveryDao == null) {
			deliveryDao = (DeliveryDao) ContextUtil.getContext().getBean("deliveryDao");
			if (deliveryDao ==null){
				logger.error("getPackageInfo:deliveryDao反射注入出错!");
				Log.errorLog("", "", "", "getMaxMinInfo方法", "OrderComcateDtl", code, -1, "getMaxMinInfo:deliveryDao反射注入出错");
				return null;
			}
		}
		OrderPackageInfo dtl = deliveryDao.getMaxMinDtl(orderid, ordercomtype, category);
		
		StringBuffer sb = new StringBuffer();
		
		if (dtl != null){
			if (dtl.getMinres() != null){
				sb.append(dtl.getMinres());
				if (dtl.getMaxres()!= null) 
					sb.append('~');
			}
			
			if (dtl.getMaxres()!= null) 
				sb.append(dtl.getMaxres());

			sb.append('(');
			sb.append(dtl.getCount());
			sb.append(')');
		}
		return sb.toString();
	}
}
