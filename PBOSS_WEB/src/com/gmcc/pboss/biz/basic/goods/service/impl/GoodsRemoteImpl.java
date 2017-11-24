package com.gmcc.pboss.biz.basic.goods.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.gmcc.pboss.biz.basic.dictItem.service.DictItemService;
import com.gmcc.pboss.biz.basic.goods.bean.ComTypeInfo;
import com.gmcc.pboss.biz.basic.goods.bean.Goods;
import com.gmcc.pboss.biz.basic.goods.bean.ShoppingCar;
import com.gmcc.pboss.biz.basic.goods.service.GoodsRemote;
import com.gmcc.pboss.biz.basic.goods.service.GoodsServiceCode;
import com.gmcc.pboss.biz.basic.goods.service.GoodsServiceRetCode;
import com.gmcc.pboss.biz.basic.goods.supper.GoodsListQueryParameter;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.dictionary.HttpDictionary;
import com.gmcc.pboss.common.log.Log;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceRetCode;
import com.gmcc.pboss.common.service.ServiceType;
import com.gmcc.pboss.common.service.impl.BaseServiceImpl;
import com.gmcc.pboss.common.support.CommonConstants;
import com.gmcc.pboss.common.support.Page;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryResult;
import com.gmcc.pboss.common.util.Assert;
import com.gmcc.pboss.service.WebSiteService;
import com.gmcc.pboss.service.result.RetResult;
import com.gmcc.pboss.service.result.goods.BookBasicInfo;
import com.gmcc.pboss.service.result.goods.GoodsInfo;
import com.gmcc.pboss.service.result.goods.GoodsResource;
import com.gmcc.pboss.service.result.goods.SCPackage;
import com.gmcc.pboss.service.send.ComOrder;


public class GoodsRemoteImpl extends BaseServiceImpl implements GoodsRemote {
	//日志
	private static Logger logger = Logger.getLogger(GoodsRemoteImpl.class);

	//商品种类查询
	private DictItemService dictItemService;
	
	/**
	 * 远程接口
	 */
	private WebSiteService httpWebRemote;
	/**
	 * 资源
	 */
	private GoodsResource goodsResource;

	/**
	 * @return the httpWebRemote
	 */
	public WebSiteService getHttpWebRemote() {
		return httpWebRemote;
	}

	/**
	 * @param httpWebRemote the httpWebRemote to set
	 */
	public void setHttpWebRemote(WebSiteService httpWebRemote) {
		this.httpWebRemote = httpWebRemote;
	}

	/**
	 * @return the dictItemService
	 */
	public DictItemService getDictItemService() {
		return dictItemService;
	}

	/**
	 * @param dictItemService the dictItemService to set
	 */
	public void setDictItemService(DictItemService dictItemService) {
		this.dictItemService = dictItemService;
	}

	/**
	 * @return the goodsResource
	 */
	public GoodsResource getGoodsResource() {
		return goodsResource;
	}

	/**
	 * @param goodsResource the goodsResource to set
	 */
	public void setGoodsResource(GoodsResource goodsResource) {
		this.goodsResource = goodsResource;
	}

	public GoodsRemoteImpl() {
		//设置业务相关属性
		serviceName = "商品订购";
		serviceCode = ServiceCode.GOODSAPPLY;
		isNeedLogin = true;
		//设置参数处理器
//		setProcessor(new RegactInfoQueryParameterProcessor());
	}

	/**
	 * 商品订购资格检查
	 * @param wayId 渠道编码
	 * @return
	 */
	public ServiceResult chkQualification(LoginMember member) {
		// TODO Auto-generated method stub
		ServiceResult rtn = new ServiceResult();
		rtn.setSuccess(false);
		rtn.setRetCode(ServiceRetCode.FAIL);
		//调用接口
		//...
		try{
			logger.info("[GoodsServiceImpl商品订购资格检查]调用接口");
			RetResult result = httpWebRemote.bookQualificationCheck(member.getWayid());
			if (result.getRetCode()==RetResult.SUCCESS){//0-成功
				rtn.setSuccess(true);
				rtn.setRetCode(GoodsServiceRetCode.QUALIFICATION_SUCC);
			}else if (result.getRetCode()==RetResult.FAILURE){//1-不成功
				rtn.setSuccess(false);
				rtn.setRetCode(GoodsServiceRetCode.QUALIFICATION_FAIL);
				String rtnMsg = result.getMessage();
				logger.info("[商品订购-用户资格验证]:"+ rtnMsg);
				Log.remoteLog(serviceCode, serviceCode, "GoodsServiceImpl商品订购资格检查", member.getWayid(), result.getRetCode(), rtnMsg);
				if (StringUtils.isNotEmpty(rtnMsg)) rtnMsg = ":"+rtnMsg; else rtnMsg="";//封装返回信息
				rtn.setRetObject(rtnMsg);//出错信息写在RetObject中
			}else if (result.getRetCode()==RetResult.ERROR){//1-发生异常
				logger.error(">>>>>>>>调用第一个接口[bookQualificationCheck('"+ member.getWayid() +"')]商品订购资格检查有异常>>>>>>"+result.getMessage());

				Log.remoteLog(serviceCode, serviceCode, "GoodsServiceImpl商品订购资格检查", member.getWayid(), result.getRetCode(),result.getMessage());
				rtn.setSuccess(false);
				rtn.setRetCode(GoodsServiceRetCode.QUALIFICATION_ERROR);
				rtn.setRetObject(result.getMessage());//出错信息写在RetObject中
			}
		}catch(Exception e){
			logger.error("[GoodsServiceImpl.chkQualification]:"+ e.getMessage());
			//-1为运行错
			Log.remoteLog(serviceCode, serviceCode, "GoodsServiceImpl商品订购资格检查", member.getWayid(), -1,e.getMessage());
			//提取异常信息
			rtn.setSuccess(false);
			rtn.setRetCode(GoodsServiceRetCode.QUALIFICATION_ERROR);			
			rtn.setRetObject(e.getMessage());//出错信息写在RetObject中
		}
//		rtn.setSuccess(true);
//		rtn.setMessage("验证成功，用户有订购资格!");
		//处理返回信息
		this.finishProcessor(rtn, member, ServiceType.OTHER, GoodsServiceCode.Qualification);
		return rtn;
	}

	/**
	 * 基本信息查询
	 * @param wayId 渠道编码
	 * @return
	 */
	public ServiceResult getBaseInfo(LoginMember member) {
		// TODO Auto-generated method stub
		ServiceResult rtn = new ServiceResult();
		rtn.setSuccess(false);
		rtn.setRetCode(ServiceRetCode.FAIL);
		//调用接口
		logger.info("[GoodsServiceImpl基本信息查询]调用接口");
		try{
			//RetResult result = httpWebSiteService.bookQualificationCheck(member.getWayid());
			BookBasicInfo result = httpWebRemote.queryBookBasicInfo(member.getWayid());
//			result.setRetCode(3);
//			result.setMessage("本月已超过订购次数！");
			//用户基本信息
			if (result.getRetCode()==BookBasicInfo.SUCCESS){//0-成功
				rtn.setSuccess(true);
				rtn.setRetCode(GoodsServiceRetCode.QUERYBASEINFO_SUCC);
				rtn.setRetObject(result);
			}else if(result.getRetCode()==BookBasicInfo.NOT_PASS){//3-成功,但不能发起订购，返回本对象
				rtn.setSuccess(true);
				rtn.setRetCode(GoodsServiceRetCode.QUERYBASEINFO_SUCC);
				rtn.setRetObject(result);
			}else if(result.getRetCode()==BookBasicInfo.FAILURE){//1-成功,但无数据，设置Null值
				rtn.setSuccess(false);
				rtn.setRetCode(GoodsServiceRetCode.QUERYBASEINFO_FAIL);
				rtn.setRetObject(new BookBasicInfo());
				logger.warn("[GoodsServiceImpl.getBaseInfo('"+ member.getWayid() +"')==1]基本信息查询无数据,具体原因:"+result.getMessage());

				Log.remoteLog(serviceCode, serviceCode, "GoodsServiceImpl基本信息查询", member.getWayid(), result.getRetCode(),"基本信息查询无数据,具体原因:"+ result.getMessage());
			}else if (result.getRetCode()==RetResult.ERROR){//2-发生异常
				logger.error(">>>>>>>>调用第二个接口(queryBookBasicInfo('"+ member.getWayid() +"'))基本信息查询有异常>>>>>>"+result.getMessage());
				Log.remoteLog(serviceCode, serviceCode, "GoodsServiceImpl基本信息查询", member.getWayid(), result.getRetCode(),"基本信息查询有异常:"+ result.getMessage());
				rtn.setSuccess(false);
				rtn.setRetCode(GoodsServiceRetCode.QUERYBASEINFO_ERROR);			
				rtn.setRetObject(result.getMessage());//出错信息写在RetObject中
			}
		}catch(Exception e){
			logger.error("[GoodsServiceImpl.getBaseInfo]:"+ e.getMessage());
			//提取异常信息

			//-1为运行错
			Log.remoteLog(serviceCode, serviceCode, "GoodsServiceImpl基本信息查询", member.getWayid(), -1,e.getMessage());
			rtn.setSuccess(false);
			rtn.setRetCode(GoodsServiceRetCode.QUERYBASEINFO_ERROR);			
			rtn.setRetObject(e.getMessage());//出错信息写在RetObject中
		}
		//处理返回信息
		this.finishProcessor(rtn, member, ServiceType.OTHER, GoodsServiceCode.QueryBookBasicInfo);
		return rtn;
		//...
		/*
		 * 
		//手动加数
		BookBasicInfo test = new BookBasicInfo();
		//用户基本信息

		List baseInfo = new ArrayList();
//		//添加订购信息 与库存信息只能有一个
//		BookInfo bi = new BookInfo();
//		bi.setBrandName("神舟行");
//		bi.setCanBookNonceMonth(1000);//本月可订购量
//		bi.setBookedNonceMonth(800);//本月已订购量
//		bi.setSurBookNonceMonth(200);//本月剩余订购量
//		bi.setCanBookToday(100);//今天可订购量
//		bi.setBookedToday(80);//今天已订购量
//		bi.setSurBookToday(20);//今天剩余订购量
//		baseInfo.add(bi);
//		
//		bi = new BookInfo();
//		bi.setBrandName("动感地带");
//		bi.setCanBookNonceMonth(2000);//本月可订购量
//		bi.setBookedNonceMonth(1800);//本月已订购量
//		bi.setSurBookNonceMonth(200);//本月剩余订购量
//		bi.setCanBookToday(200);//今天可订购量
//		bi.setBookedToday(180);//今天已订购量
//		bi.setSurBookToday(20);//今天剩余订购量
//		baseInfo.add(bi);
//		//合成
//		test.setBookInfos(baseInfo);
		//添加库存信息
		List stockInfos = new ArrayList();
		StockInfo si = new StockInfo();
		si.setBrandName("动感地带");//品牌
		si.setBasicStock(1000);//基准库存量
		si.setNonceStock(800);//当前库存量
		si.setNonceMaxStock(200);//当前最大库存量
		stockInfos.add(si);
		
		si = new StockInfo();
		si.setBrandName("神舟行");//品牌
		si.setBasicStock(200);//基准库存量
		si.setNonceStock(100);//当前库存量
		si.setNonceMaxStock(100);//当前最大库存量
		stockInfos.add(si);

		//合成
		test.setStockInfos(stockInfos);
		
		//品牌激活信息
		List actInfo = new ArrayList();
		ActiveInfo a = new ActiveInfo();
		a.setBrandName("动感地带");//品牌名
		a.setActRate(60);//激活率
		a.setFulfilStandard(false);//是否达标
		a.setFilStandardGap(3);//达标差距
		actInfo.add(a);
		
		a = new ActiveInfo();
		a.setBrandName("神州行");
		a.setActRate(100);
		a.setFulfilStandard(true);
		a.setFilStandardGap(0);
		actInfo.add(a);
		//合成数据
		test.setActiveInfos(actInfo);
		
		rtn.setSuccess(true);
		rtn.setRetObject(test);
		rtn.setMessage("查询成功!");
		 */
		
	}

	/* (non-Javadoc)
	 * @see com.gmcc.pboss.biz.basic.goods.service.GoodsService#getPriceRadix(java.lang.String, java.lang.String)
	 */
	/**
	 * 商品售价/订购基数查询
	 * @param wayId 渠道编码
	 * @param prdcClg 商品种类（不包括充值卡）
	 * @return
	 */
	public ServiceResult getPriceRadix(LoginMember member, String comType) {
		// TODO Auto-generated method stub
		ServiceResult rtn = new ServiceResult();
		rtn.setSuccess(false);
		rtn.setRetCode(ServiceRetCode.FAIL);
		//调用接口
		logger.info("[queryGoodsPriceRadix商品售价/订购基数查询]调用接口");

		try{
			//RetResult result = httpWebSiteService.bookQualificationCheck(member.getWayid());
			GoodsInfo result = httpWebRemote.queryGoodsPriceRadix(member.getWayid(), comType);
			//用户基本信息
			if (result.getRetCode()==BookBasicInfo.SUCCESS){//0-成功
				rtn.setSuccess(true);
				rtn.setRetCode(GoodsServiceRetCode.QUERYPRICERADIX_SUCC);
				//返回对象
				ComTypeInfo rtnObj = new ComTypeInfo(result);
				rtnObj.setRestype(dictItemService.getTypeByCode(comType));
				rtn.setRetObject(rtnObj);
			}else if(result.getRetCode()==BookBasicInfo.FAILURE){//1-成功,但无数据，设置Null值
				rtn.setSuccess(false);
				rtn.setRetCode(GoodsServiceRetCode.QUERYPRICERADIX_FAIL);
				rtn.setRetObject(result.getMessage());
//				System.out.println("[GoodsServiceImpl.queryGoodsPriceRadix()==1]基本信息查询无数据,具体原因:"+result.getMessage());
				logger.error("[GoodsServiceImpl.queryGoodsPriceRadix('"+member.getWayid()+"','"+  comType 
						+"')==1]商品售价/订购基数查询无数据,具体原因:"+result.getMessage());

				Log.remoteLog(serviceCode, serviceCode, "queryGoodsPriceRadix商品售价/订购基数查询", member.getWayid(), result.getRetCode(),
						"商品售价/订购基数查询无数据,具体原因:"+ result.getMessage());
			}else if (result.getRetCode()==RetResult.ERROR){//2-发生异常
				logger.error(">>>>>>>>调用第三个接口(queryGoodsPriceRadix('"+member.getWayid()+"','"+  comType 
						+"'))商品售价/订购基数查询有异常>>>>>>"+result.getMessage());

				Log.remoteLog(serviceCode, serviceCode, "queryGoodsPriceRadix商品售价/订购基数查询", member.getWayid(), result.getRetCode(),
						"商品售价/订购基数查询有异常,具体原因:"+ result.getMessage());
				rtn.setSuccess(false);
				rtn.setRetCode(GoodsServiceRetCode.QUERYPRICERADIX_ERROR);			
				rtn.setRetObject(result.getMessage());//出错信息写在RetObject中
			}
		}catch(Exception e){
			logger.error("[queryGoodsPriceRadix商品售价/订购基数查询]:"+ e.getMessage());
			Log.remoteLog(serviceCode, serviceCode, "queryGoodsPriceRadix商品售价/订购基数查询", member.getWayid(), -1,
					"商品售价/订购基数查询有异常,具体原因:"+ e.getMessage());
			//提取异常信息
			rtn.setSuccess(false);
			rtn.setRetCode(GoodsServiceRetCode.QUERYPRICERADIX_ERROR);			
			rtn.setRetObject(e.getMessage());//出错信息写在RetObject中
		}
		//处理返回信息
		this.finishProcessor(rtn, member, ServiceType.OTHER, GoodsServiceCode.GETPRICERADIX);
		return rtn;
	}

	/**
	 * 商品资源抽取
	 * @param wayId 渠道商编码
	 * @param comType 商品种类标识。
	 * @param orderCount 订购套数。
	 * @return
	 */
	public ServiceResult getProductList(String wayId,String comType,int orderCount,GoodsListQueryParameter param) {
		// TODO Auto-generated method stub
		ServiceResult rtn = new ServiceResult();
		rtn.setSuccess(false);
		rtn.setRetCode(ServiceRetCode.FAIL);
		List<Goods> allGoods = null;//使用对象
		boolean save = true;
		//缓存查询
		HttpSession session = param.getSession();
		//提取购物车
		ShoppingCar shoppingCar = (ShoppingCar)session.getAttribute(HttpDictionary.SHOPPINGCAR);
		
//		String saveComType= (String) session.getAttribute(HttpDictionary.Save_GoodsComType);
		if (param.getPageQuery()== CommonConstants.PAGEQUERY_TRUE ){
			//暂不做商品类型判断：&& comType.equals(saveComType)
			//点了翻页 并 查询的商品种类与缓存中一样
			//直接从缓在取数
			allGoods = (List<Goods>)session.getAttribute(HttpDictionary.GOODSLIST);
			save = false;
		}else{
			allGoods = this.getGoodsResource(wayId, comType, orderCount);
			//出错判断
			if (this.goodsResource.getRetCode() != GoodsResource.SUCCESS){
				if (this.goodsResource.getRetCode() == GoodsResource.FAILURE){
					logger.warn(">>>>>>>>调用第四个接口(getGoodsResource('"+wayId+"','"+  comType 
							+"','"+ orderCount +"'))商品资源抽取失败>>>>>>"+goodsResource.getMessage());
					Log.remoteLog(serviceCode, serviceCode, "getGoodsResource商品资源抽取失败", wayId, goodsResource.getRetCode(),goodsResource.getMessage());
					//查询失败
					rtn.setSuccess(false);
					rtn.setRetCode(GoodsServiceRetCode.GETGOODSRESOURCE_FAIL);
					rtn.setRetObject(goodsResource.getMessage());
				}else if (this.goodsResource.getRetCode() == GoodsResource.ERROR){
					logger.error(">>>>>>>>调用第四个接口(getGoodsResource('"+wayId+"','"+  comType 
							+"','"+ orderCount +"'))商品资源抽取有异常>>>>>>"+goodsResource.getMessage());

					Log.remoteLog(serviceCode, serviceCode, "getGoodsResource商品资源抽取有异常", wayId, goodsResource.getRetCode(),goodsResource.getMessage());
					//系统异常
					rtn.setSuccess(false);
					rtn.setRetCode(GoodsServiceRetCode.GETGOODSRESOURCE_ERROR);
					rtn.setRetObject(goodsResource.getMessage());
				}else if (this.goodsResource.getRetCode() == GoodsResource.OVER_QUERY_LIMIT_TIMES){
					logger.warn(">>>>>>>>调用第四个接口(getGoodsResource('"+wayId+"','"+  comType 
							+"','"+ orderCount +"'))商品资源抽取查询次数超出限制>>>>>>");

					Log.remoteLog(serviceCode, serviceCode, "getGoodsResource商品资源抽取", wayId, goodsResource.getRetCode(),"商品资源抽取查询次数超出限制");
					//查询次数超出限制
					rtn.setSuccess(false);
					rtn.setRetCode(GoodsServiceRetCode.GETGOODSRESOURCE_EXCEED);
					rtn.setRetObject(null);
				}
					
				return rtn;
			}//if
		}//if
		if (allGoods != null){
			//构造翻页
			Page thisPage = new Page(allGoods.size(),param.getSize(),param.getNo());
			//从内存中翻页
			int stat = thisPage.getFirstResult();
			List<Goods> showGoods = new ArrayList<Goods>(); 
			for (int i =0;i<param.getSize();i++){
				if (stat+i>=allGoods.size()) break;
				//处理单个商品
				Goods dtl = allGoods.get(stat+i);
				if (shoppingCar!=null) dtl.setInCar(shoppingCar.isInCar(dtl));
				showGoods.add(dtl);
				//@@ yuwenjun 可优化 购物车中加上所有的商品
				shoppingCar.addAllGoods(dtl);//业务上来说，每次操作都只是对本次查询进行保存，因此，每次增加（增加前不清空）
			}//for
			session.setAttribute(HttpDictionary.SHOPPINGCAR, shoppingCar);//保存购物车
			rtn.setRetResult(new QueryResult(thisPage,showGoods));
			rtn.setSuccess(true);
			rtn.setRetCode(ServiceRetCode.SUCCESS);
			//保存到缓存中
			if (save){
				session.setAttribute(HttpDictionary.Save_GoodsComType, comType);
				session.setAttribute(HttpDictionary.GOODSLIST, allGoods);
			}
		}
		return rtn;
	}
	/**
	 * 调用商品资源抽取接口并封装
	 * @param wayid
	 * @param comType
	 * @param orderCount
	 * @return
	 */
	private List<Goods> getGoodsResource(String wayid, String comType, int orderCount){
		logger.info("[getGoodsResource商品资源抽取]调用接口");
		List<SCPackage> rtnList = null;//返回值表
		//构造GOODS用于显示
		List<Goods> allGoods = null;
//		SCPackage rtnDtl;
		try{
			this.goodsResource = httpWebRemote.getGoodsResource(wayid,comType,orderCount);
		}catch(Exception e){
			//接口调用有异常处理
			this.goodsResource = new GoodsResource();
			goodsResource.setGoodsList(null);
			goodsResource.setRetCode(GoodsResource.ERROR);
			goodsResource.setMessage(e.getMessage());
		}
//		System.out.println(">>>>>>>>>>>>>>>>>>>调用第四个接口>>"+goodsResource.getRetCode()+"["+ goodsResource.getMessage() +"]");
		if (goodsResource.getRetCode() != GoodsResource.SUCCESS) return null;
		rtnList = this.goodsResource.getGoodsList();
		System.out.println("[getGoodsResource商品资源抽取]抽取成功,记录数："+rtnList.size()); 
//		while (it.hasNext()){
		if (rtnList!=null){
			allGoods = new ArrayList<Goods>();
			for(SCPackage rtnDtl:rtnList){
				Goods save = new Goods();
				save.setType(dictItemService.getNameByCode(comType));
				save.setId(rtnDtl.getBatchNo());//批次号
				save.setName(rtnDtl.getPackageNo());//包号
				save.setComType(comType);	//商品种类
				save.setOrderCount(orderCount);	//订购套数
				String allMobile [] = rtnDtl.getMobiles();
				String allTemp = "";
				if (allMobile != null){
					for (int i=0;i<allMobile.length;i++){
						allTemp +=allMobile[i]+(i<allMobile.length?",":"");
						//每五个自动换行
						if ((i+1)%5==0) allTemp+="<BR>";
					}
				}
				save.setMobiles(allTemp);
				//合并
				allGoods.add(save);
			}//for
		}//if
		return allGoods;
	}
	/**
	 * 商品订购订单提交
	 * @param wayId 渠道商编码
	 * @param sendObj 字符串数组,每个内容为：商品种类标识~订购套数
	 * @return
	 */
	public ServiceResult submitOrder(LoginMember member, List<Goods> sendObj,boolean isQueryDetail) {
		// TODO Auto-generated method stub
		ServiceResult rtn = new ServiceResult();
		rtn.setSuccess(false);
		rtn.setRetCode(ServiceRetCode.FAIL);
		//分解购物车List
		List<Goods> shoppingCar = sendObj;
		//构造提交对象
		List<ComOrder> comOrderList = new ArrayList<ComOrder>();
		for (int i=0;i<shoppingCar.size();i++){
			Goods dtl = (Goods)shoppingCar.get(i);
			//构造新的提交参数
			ComOrder comOrder = new ComOrder();
			comOrder.setComType(dtl.getComType());//商品种类
			comOrder.setOrderCount(dtl.getOrderCount());//订购套数
			comOrder.setBatchNo(dtl.getId());//批次号
			comOrder.setPackageNo(dtl.getName());//包号
			comOrderList.add(comOrder);
		}
		//调用接口
		try{
			System.out.println(">>>>>>>>商品订购订单提交comOrderCommit()调用 ");
			RetResult result = this.httpWebRemote.comOrderCommit(member.getWayid(), isQueryDetail, comOrderList);

			if (result.getRetCode()==RetResult.SUCCESS){//0-成功
				rtn.setSuccess(true);
				rtn.setRetCode(GoodsServiceRetCode.ORDERCOMMIT_SUCC);
				rtn.setRetObject(result.getMessage());
				System.out.println("订购成功，订单号："+result.getMessage());
			}else if(result.getRetCode()==RetResult.FAILURE){//1-失败
				rtn.setSuccess(false);
				rtn.setRetCode(GoodsServiceRetCode.ORDERCOMMIT_FAIL);
				rtn.setRetObject(result.getMessage());
				logger.warn("[GoodsServiceImpl.submitOrder('"+ member.getWayid() +"','"+ isQueryDetail +"')==1]订购失败,具体原因:"+result.getMessage());
				Log.remoteLog(serviceCode, serviceCode, "商品订购订单提交comOrderCommit", member.getWayid(), result.getRetCode(),"订购失败,具体原因:"+result.getMessage());
			}else if (result.getRetCode()==RetResult.ERROR){//2-发生异常
				logger.error(">>>>>>>>调用第五个接口[GoodsServiceImpl.submitOrder('"+ member.getWayid() +"','"+ isQueryDetail +"')]商品订购订单提交>>>>>>"+result.getMessage());
				Log.remoteLog(serviceCode, serviceCode, "商品订购订单提交comOrderCommit", member.getWayid(), result.getRetCode(),"订单提交发生异常,具体原因:"+result.getMessage());
				rtn.setSuccess(false);
				rtn.setRetCode(GoodsServiceRetCode.ORDERCOMMIT_ERROR);			
				rtn.setRetObject(result.getMessage());//出错信息写在RetObject中
			}
		}catch(Exception e){
			//调用异常
			logger.error(">>>>>>>>调用第五个接口[GoodsServiceImpl.submitOrder('"+ member.getWayid() +"','"+ isQueryDetail +"')]商品订购订单提交>>>>>>"+e.getMessage());
			Log.remoteLog(serviceCode, serviceCode, "商品订购订单提交comOrderCommit", member.getWayid(), -1,"订单提交发生异常,具体原因:"+e.getMessage());
			rtn.setSuccess(false);
			rtn.setRetCode(GoodsServiceRetCode.ORDERCOMMIT_ERROR);			
			rtn.setRetObject(e.getMessage());//出错信息写在RetObject中
		}
		//处理返回信息
		this.finishProcessor(rtn, member, ServiceType.OTHER, GoodsServiceCode.ComOrderCommit);
		return rtn;
	}

	
	/* (non-Javadoc)
	 * @see com.gmcc.pboss.common.service.impl.QueryBaseServiceImpl#query(com.gmcc.pboss.common.bean.LoginMember, com.gmcc.pboss.common.support.QueryParameter)
	 */
	public ServiceResult query(LoginMember member, QueryParameter parameter) {
		
		GoodsListQueryParameter param = (GoodsListQueryParameter) parameter;
		//参数判断
//		if (CommonUtil.isEmptyOrNull(member.getWayid())) Ass
		Assert.notBlank(member.getWayid(),GoodsServiceRetCode.GETGOODSRESOURCE_WAYIDNULL,"WAYID不能为空!");
		Assert.notBlank(param.getComType(),GoodsServiceRetCode.GETGOODSRESOURCE_COMTYPENULL,"ComType 不能为空!");
		Assert.isTrue(param.getOrderCount()>0,GoodsServiceRetCode.GETGOODSRESOURCE_ORDERCOUNTNULL,"OrderCount 不能为空!");
		
		return this.getProductList(member.getWayid(), param.getComType(),param.getOrderCount(),(GoodsListQueryParameter) parameter);
	}
	
}
