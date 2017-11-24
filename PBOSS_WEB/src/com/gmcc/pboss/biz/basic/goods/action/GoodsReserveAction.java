package com.gmcc.pboss.biz.basic.goods.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.gmcc.pboss.biz.basic.dictItem.service.DictItemService;
import com.gmcc.pboss.biz.basic.dictItem.support.DictItemQueryParameter;
import com.gmcc.pboss.biz.basic.goods.bean.Goods;
import com.gmcc.pboss.biz.basic.goods.bean.GoodsStat;
import com.gmcc.pboss.biz.basic.goods.bean.ShoppingCar;
import com.gmcc.pboss.biz.basic.goods.service.GoodsRemote;
import com.gmcc.pboss.biz.basic.goods.service.GoodsServiceRetCode;
import com.gmcc.pboss.biz.basic.goods.service.IbGlSysparamService;
import com.gmcc.pboss.biz.basic.goods.supper.GoodsListQueryParameter;
import com.gmcc.pboss.common.action.AbstractAction;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.config.ConfigUtil;
import com.gmcc.pboss.common.constant.Constant;
import com.gmcc.pboss.common.dictionary.CommonConfig;
import com.gmcc.pboss.common.dictionary.ConstantsType;
import com.gmcc.pboss.common.dictionary.FileDictionary;
import com.gmcc.pboss.common.dictionary.HttpDictionary;
import com.gmcc.pboss.common.dictionary.JSONKey;
import com.gmcc.pboss.common.dictionary.PageLoction;
import com.gmcc.pboss.common.log.Log;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceType;
import com.gmcc.pboss.common.support.ColumnSet;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.service.result.goods.BookBasicInfo;

public class GoodsReserveAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1;
	
	private GoodsRemote service;
	//商品种类查询
	private DictItemService dictItemService;

	/**
	 * 错误信息
	 */
	private String errMSG;
	
	/**
	 * 是否允许发起订购
	 */
	private boolean canOrder = false;
	
	private String _backURL;
	private boolean canQuery;
	private Map<String,String> dictItem;
	private BookBasicInfo bookBasicInfo;
	private GoodsListQueryParameter param;
	
	private Goods saveGoods;
	//明细
	private String carKey;
	private LoginMember member;
	//商品类型查询
	private String comType;
	/**
	 * 公共参数提取
	 */
	private IbGlSysparamService ibGlSysparamService;
	/**
	 * 是否屏蔽激活率信息
	 */
	private boolean isActivationInfoShow = true;
	public void setIsActivationInfoShow(boolean yesORnot){
		this.isActivationInfoShow = yesORnot;
	}
	public boolean isIsActivationInfoShow(){
		return this.isActivationInfoShow;
	}
	
	private int goodsResourseSize = 5;//默认为5条
	/**
	 * @param canQuery the canQuery to set
	 */
	public void setCanQuery(boolean canQuery) {
		this.canQuery = canQuery;
	}
	/**
	 * @return the _backURL
	 */
	public String get_backURL() {
		return _backURL;
	}
	public void set_backURL(String _backurl) {
		_backURL = _backurl;
	}
	/**
	 * @param dictItem the dictItem to set
	 */
	public void setDictItem(Map<String, String> dictItem) {
		this.dictItem = dictItem;
	}
	/**
	 * @return the service
	 */
	public GoodsRemote getService() {
		return service;
	}
	/**
	 * @param service the service to set
	 */
	public void setService(GoodsRemote service) {
		this.service = service;
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
	
	public QueryParameter getParameter() {
		// TODO Auto-generated method stub
		if (this.getPageNo() != null)
			param.setNo(getPageNo().intValue());// 设置页码
		if (this.getPageSize() != null)
			param.setSize(getPageSize().intValue());// 设置大小
		
		if (this.getPageQuery() != null)
			param.setPageQuery(getPageQuery().intValue());// 翻页查询标识
		
//		LoginMember member = getMember();
		//设置Session
		param.setSession(getSession());
		return param;
	}
	/**
	 * @return the bookBasicInfo
	 */
	public BookBasicInfo getBookBasicInfo() {
		return bookBasicInfo;
	}
	/**
	 * @param bookBasicInfo the bookBasicInfo to set
	 */
	public void setBookBasicInfo(BookBasicInfo bookBasicInfo) {
		this.bookBasicInfo = bookBasicInfo;
	}
	/**
	 * @return the param
	 */
	public GoodsListQueryParameter getParam() {
		return param;
	}
	/**
	 * @param param the param to set
	 */
	public void setParam(GoodsListQueryParameter param) {
		this.param = param;
	}
	
	/**
	 * @return the saveGoods
	 */
	public Goods getSaveGoods() {
		return saveGoods;
	}
	/**
	 * @param saveGoods the saveGoods to set
	 */
	public void setSaveGoods(Goods saveGoods) {
		this.saveGoods = saveGoods;
	}
	/**
	 * @return the comType
	 */
	public String getComType() {
		return comType;
	}
	/**
	 * @param comType the comType to set
	 */
	public void setComType(String comType) {
		this.comType = comType;
	}
	
	/**
	 * @return the carKey
	 */
	public String getCarKey() {
		return carKey;
	}
	/**
	 * @param carKey the carKey to set
	 */
	public void setCarKey(String carKey) {
		this.carKey = carKey;
	}
	public void prepare() throws Exception {
		//登录者信息
		this.member = getMember();
		
		//判断是否需要查询资源明细
//		String getConfig = Constant.getConstantName(ConstantsType.ISQUERY, member.getCityid());
		//从库表中提取
		String getConfig = this.ibGlSysparamService.getIsQuery(member);
		if (getConfig == null) {
			logger.error("系统参数不存在");
		}
//		System.out.println(">>>"+ member.getCityid() +">>是否需要查询资源明细>>"+getConfig);
		if (ConstantsType.QueryTrue.equals(getConfig)){
			this.setCanQuery(true);
		}else{
			this.setCanQuery(false);
		}
	}
	
	@SuppressWarnings("unchecked")
	public String doBegin() {
//		System.out.println("DDD");
		this.setTitle(PageLoction.GoodsReserve);
		//用户商品订购资格验证
		ServiceResult chkQlfc = service.chkQualification(member);
		if (!chkQlfc.isSuccess()){
			if (GoodsServiceRetCode.QUALIFICATION_ERROR == chkQlfc.getRetCode()){
				//系统异常
				this.setMessage(chkQlfc.getMessage());
			}else{				
				//没有订购资格
				this.setMessage(chkQlfc.getMessage()+chkQlfc.getRetObject());
//				System.out.println("[商品订购-用户资格验证]:"+ chkQlfc.getRetObject());
			}
			this.set_backURL(INDEX);
			return ERROR;
		}
		chkQlfc = null;//对象回收
		//查询用户基本信息

		//提取基本信息
		ServiceResult getBaseInfo = service.getBaseInfo(member);
		if (!getBaseInfo.isSuccess()){
			//查询失败
			this.setMessage("提取基本信息失败:"+getBaseInfo.getMessage());
//			logger.warn("[商品订购-提取基本信息]:"+ getBaseInfo.getRetObject());
			this.set_backURL(INDEX);
			return ERROR;	
		}
		this.setBookBasicInfo((BookBasicInfo)getBaseInfo.getRetObject());
		//判断是否允许发起订购
		if (this.bookBasicInfo.getRetCode() == BookBasicInfo.NOT_PASS){
			this.setCanOrder(false);
			this.setMessage(this.bookBasicInfo.getMessage());
		}else{
			this.setCanOrder(true);
		}
		getBaseInfo = null;//对象回收
		//提取基本信息
		
		//提取商品类型
		Map<String,String> c =(Map<String, String>) dictItemService.transact(member, new DictItemQueryParameter(), ServiceType.QUERY).getRetObject();
		//(null, getParameter()).getRetObject();
		this.setDictItem(c);

		//初始化购物车
		HttpSession session = this.getSession();
		ShoppingCar shoppingCar = (ShoppingCar)session.getAttribute(HttpDictionary.SHOPPINGCAR);
		if (shoppingCar == null){
			shoppingCar = new ShoppingCar(getMember().getEmployeeid());
			shoppingCar.setCreateTime(0);
		}
		session.setAttribute(HttpDictionary.SHOPPINGCAR, shoppingCar);
		
		//查询系统参数表，确定激活率信息是否显示给登陆用户
		String systemParam = this.ibGlSysparamService.getSysValue(3, "pboss_Web");
		if(systemParam!=null && systemParam.equals("1"))
			this.isActivationInfoShow = false;
		return execute();
	}
	/**
	 * 商品售价订购基数查询
	 * @return null 使用writeJSONServiceData回写JSON对象 (写isSuccess和price、radix) 
	 */
	public String doGetPriceRadix(){
		//提取基本信息
		ServiceResult getPriceRadix = service.getPriceRadix(member, comType);
		//写JSON
		this.writeJSONServiceData(getPriceRadix);
		return null;
	}
	/**
	 * 查询商品
	 * @return
	 */
	public String doQuery(){
		//不允许查询的情况
		if (!this.isCanQuery()){
			ServiceResult result = new ServiceResult();
			result.setSuccess(false);
			result.setMessage("当前系统不允许进行资源抽取");
			
			//判断是否AJAX请求
			String requestedWith = this.getRequest().getHeader("x-requested-with");
		    if (requestedWith != null && "XMLHttpRequest".equals(requestedWith)){   
				//ajax请求，返回错误信息
		    	this.writeJSONServicePage(result, getsetCols());
				return null;
		    }else{
		    	//非ajax请求，返回到页面上
		    	this.setMessage("当前系统不允许进行资源抽取");
		    	this.set_backURL("/goods/begin.do");
		    	return ERROR;
		    }
		}
		ServiceResult result = service.transact(getMember(), getParameter(), ServiceType.QUERY);
		if (!result.isSuccess() && result.getRetCode()!= GoodsServiceRetCode.GETGOODSRESOURCE_EXCEED
			){
			//不封装失败的原因	&& result.getRetCode()== GoodsServiceRetCode.FAIL
			//不是查询过多、无数据时，封装失败原因
			result.setMessage(result.getMessage()+result.getRetObject());
		}

		this.writeJSONServicePage(result, getsetCols());
		return null;
	}
	/**
	 * 增加到购物车
	 * @return null 使用writeJSONServiceData回写JSON对象 (只有Message和isSuccess) 
	 */
	public String doAddGoods(){
		//设置购物车
		HttpSession session = this.getSession();
		ShoppingCar shoppingCar = (ShoppingCar)session.getAttribute(HttpDictionary.SHOPPINGCAR);
		if (shoppingCar == null){
			this.writeJSONError(ConfigUtil.getMessage(ServiceCode.GOODSAPPLY, GoodsServiceRetCode.CAREMPTY));//错误109 购物车为空
			return null;
		}
		
		if (this.saveGoods!=null){
			//根据系统参数确定是否允许混合订单
			String systemParam = this.ibGlSysparamService.getSysValue(63, "pboss_fx");
			boolean enable = true;
			if(systemParam!=null && "0".equals(systemParam)){
				enable = false;
			}
			
			//记录商品类型
			saveGoods.setType(dictItemService.getNameByCode(saveGoods.getComType()));
			if(enable){//允许混合订单,直接加入购物车
				shoppingCar.addGoods(saveGoods,this.canQuery,this.dictItemService.isComrescard(saveGoods.getComType()));
			}else{//不允许混合订单				
				/**商品对象列表*/
				Map<String,Goods> goodsMark = shoppingCar.getGoodsMark();
				if(goodsMark.size()<1){//购物车为空，直接加入
					shoppingCar.addGoods(saveGoods,this.canQuery,this.dictItemService.isComrescard(saveGoods.getComType()));
				}
				else{//购物车不为空，需检查已有商品与待加入商品资源类型是否相同
					//查询IM_PR_COMCATEGORYRELA表，获取商品种类-资源类别组合
					//key-商品种类，value-资源列别
					Map<String,String> comcatoAndRes = this.dictItemService.getComcatoAndRestype();
					
					String oneKey = goodsMark.keySet().iterator().next();
					Goods goodInCar = goodsMark.get(oneKey);
					String restype1 = comcatoAndRes.get(goodInCar.getComType());
					String restype2 = comcatoAndRes.get(saveGoods.getComType());
					if(restype1.equals(restype2)){//资源类型相同，加入
						shoppingCar.addGoods(saveGoods,this.canQuery,this.dictItemService.isComrescard(saveGoods.getComType()));
					}
					else{//资源类型不同，报错
						this.writeJSONError("不能订购混合资源类别的订单");
						return null;
					}
				}
			}			
			
			//int result= shoppingCar.addGoods(saveGoods,this.canQuery,this.dictItemService.isComrescard(saveGoods.getComType()),enable);
			//if(result<1){//不能订购混合资源类别的订单,待加入商品类型不符合要求
			//	this.writeJSONError("不能订购混合资源类别的订单");
			//	return null;
			//}
			session.setAttribute(HttpDictionary.SHOPPINGCAR, shoppingCar);
			this.writeJSONShoppingCar(shoppingCar);
		}else{
			this.writeJSONError(ConfigUtil.getMessage(ServiceCode.GOODSAPPLY, GoodsServiceRetCode.CAREMPTY));//错误108 增加商品有异常
		}
//		this.writeJSONServiceList(serviceResult);
		return null;
	}

	/**
	 * 从购物车中删除
	 * @return null 使用writeJSONServiceData回写JSON对象 (只有Message和isSuccess) 
	 */
	public String doDelGoods(){
		//设置购物车
		HttpSession session = this.getSession();
		ShoppingCar shoppingCar = (ShoppingCar)session.getAttribute(HttpDictionary.SHOPPINGCAR);
		if (shoppingCar == null){
			this.writeJSONError(ConfigUtil.getMessage(ServiceCode.GOODSAPPLY, GoodsServiceRetCode.CAREMPTY));//错误109 购物车为空
			return null;
		}

		if (this.saveGoods!=null){
			shoppingCar.deleteGoods(saveGoods);
			session.setAttribute(HttpDictionary.SHOPPINGCAR, shoppingCar);
			this.writeJSONShoppingCar(shoppingCar);
		}
		return null;
	}

	/**
	 * 查询购物车明细信息
	 * @return null 使用writeJSONServiceData回写JSON对象 (只有Message和isSuccess) 
	 */
	public String doCarDetail(){
		//提取购物车
		HttpSession session = this.getSession();
		ShoppingCar shoppingCar = (ShoppingCar)session.getAttribute(HttpDictionary.SHOPPINGCAR);
		if (shoppingCar!=null){ 
			
			this.setSaveGoods(shoppingCar.getGoods(this.carKey));
			if (this.saveGoods==null){
				this.setMessage(ConfigUtil.getMessage(ServiceCode.GOODSAPPLY, GoodsServiceRetCode.CARNOTFIND));//错误107 购物车不存在此商品
				return ERROR;
			}else{
				return this.execute();
			}
		}else{
			this.setMessage(ConfigUtil.getMessage(ServiceCode.GOODSAPPLY, GoodsServiceRetCode.CAREMPTY));//错误109 购物车为空
			return ERROR;
		}
	}
	/**
	 * 回写购物车明细到JSON
	 * @param shoppingCar
	 */
	public void writeJSONShoppingCar(ShoppingCar shoppingCar) {
		try {
			// Assert.notEmpty(args);
			JSONObject jsonObject = new JSONObject();
			//提取购物车
			Map<String, Goods> map = shoppingCar.getGoodsMark();
			   //使用迭代器遍历Map的键，根据键取值
			Iterator<String> it = map.keySet().iterator();
			//写Goods到JSON
			List<Goods> goods = new ArrayList<Goods>();
			Object key,value;
			while (it.hasNext()){
				key = it.next();
				value = map.get(key);
				goods.add((Goods) value);
			}
			
			//提取汇总信息
			Map<String, GoodsStat>mapStat = shoppingCar.getGoodsStat();
			//使用迭代器遍历Map的键，根据键取值
			it = mapStat.keySet().iterator();
			//写GoodsStat到JSON
			List<GoodsStat> stats = new ArrayList<GoodsStat>();
			while (it.hasNext()){
				key = it.next();
				value = mapStat.get(key);
				stats.add((GoodsStat) value);
			}

			//是否成功
			jsonObject.put(JSONKey.IS_SUCCESS, Boolean.valueOf(true));
			//描述信息
//			jsonObject.put(JSONKey.MESSAGE, "OK");
			//购物车明细
			jsonObject.put(JSONKey.DATAS, JSONArray.fromObject(goods));
			//汇总信息
			jsonObject.put(JSONKey.STATS, JSONArray.fromObject(stats));
			
			renderHtml(jsonObject.toString());			
		} catch (Exception e) {
			writeJSONError(e.getMessage());
		}
	}
	public String doSubmit(){
		//提取购物车List
		HttpSession session = this.getSession();
		ShoppingCar shoppingCar = (ShoppingCar)session.getAttribute(HttpDictionary.SHOPPINGCAR);
		//提取购物车
		Map<String, Goods> map = shoppingCar.getGoodsMark();
		   //使用迭代器遍历Map的键，根据键取值
		if (map.size()<1) {
//			this.setErrMSG("购物车不能为空!");
//			return "error";//购物车少于0

			this.setMessage("购物车不能为空!");
			this.set_backURL("/goods/begin.do");
			return execute();
		}
		Iterator<String> it = map.keySet().iterator();
		//写Goods到JSON
		List<Goods> goods = new ArrayList<Goods>();
		Object key,value;
		while (it.hasNext()){
			key = it.next();
			value = map.get(key);
			goods.add((Goods) value);
		}
		ServiceResult rtn = this.service.submitOrder(member, goods,isCanQuery());
		if (rtn.isSuccess()){
			String rtnMsg = rtn.getMessage();
			rtnMsg = rtnMsg.replaceAll("\\$\\{orderCode\\}", (String) rtn.getRetObject());
			this.setMessage(rtnMsg);
			this.set_backURL(INDEX);
			//订购成功，清除Session
			session.removeAttribute(HttpDictionary.SHOPPINGCAR);
			session.removeAttribute(HttpDictionary.GOODSLIST);
		}else{
//			this.setMessage(rtn.getMessage()+":"+rtn.getRetObject());
			if (GoodsServiceRetCode.ORDERCOMMIT_FAIL == rtn.getRetCode()){
				//把订购失败的信息直接现在给用户
				this.setMessage(rtn.getMessage() + (String)rtn.getRetObject());
			}else{
				this.setMessage(rtn.getMessage());
			}
			this.set_backURL("/goods/begin.do");
		};
		return execute();
	}
	/**
	 * 输出购物车列表
	 */
	public List<Goods> getCarGoods(){
		ShoppingCar shoppingCar = (ShoppingCar)this.getSession().getAttribute(HttpDictionary.SHOPPINGCAR);
		if (shoppingCar != null){
			//提取购物车
			Map<String, Goods> map = shoppingCar.getGoodsMark();
			   //使用迭代器遍历Map的键，根据键取值
			Iterator<String> it = map.keySet().iterator();
			//写Goods到JSON
			List<Goods> goods = new ArrayList<Goods>();
			Object key,value;
			while (it.hasNext()){
				key = it.next();
				value = map.get(key);
				goods.add((Goods) value);
			}
			return goods;
		}
		return null;
	}
	/**
	 * 输出汇总信息列表
	 */
	public List<GoodsStat> getCarStats(){
		ShoppingCar shoppingCar = (ShoppingCar)this.getSession().getAttribute(HttpDictionary.SHOPPINGCAR);
		if (shoppingCar != null){
			//提取购物车
			Map<String, GoodsStat> map = shoppingCar.getGoodsStat();
			   //使用迭代器遍历Map的键，根据键取值
			Iterator<String> it = map.keySet().iterator();
			//写Goods到JSON
			List<GoodsStat> stats = new ArrayList<GoodsStat>();
			Object key,value;
			while (it.hasNext()){
				key = it.next();
				value = map.get(key);
				stats.add((GoodsStat) value);
			}
			return stats;
		}
		return null;
	}
	/**
	 * 判断是否需要查询资源明细
	 * @return
	 */
	public boolean isCanQuery() {
		return canQuery;
	}
	/**
	 * 提取商品类型
	 * @return
	 */
	public Map<String,String> getDictItem() {
		Map<String, String> t = new LinkedHashMap<String, String>();
		t.put("", "请选择");
		t.putAll(dictItem);
		return t;
	}

	/**
	 * 获得表头
	 * @return
	 */
	public List<ColumnSet> getsetCols() {

		List<ColumnSet> setCols = new ArrayList<ColumnSet>();
		setCols.add(new ColumnSet("id", "批次号",false,true));//不显示
		setCols.add(new ColumnSet("comType", "商品种类",false,true));//不显示
		setCols.add(new ColumnSet("orderCount", "订购套数",false,true));//不显示
		setCols.add(new ColumnSet("inCar", "是否已经在购物车",false,true));//不显示
		setCols.add(new ColumnSet("addCar","加入购物车",true,"15%"));
		setCols.add(new ColumnSet("type", "卡类型","20%"));
		setCols.add(new ColumnSet("name", "包号","10%"));
//		setCols.add(new ColumnSet("intime", "发布时间","20%"));
		setCols.add(new ColumnSet("mobiles", "号码明细"));
		
		return setCols;
	}
	/**
	 * 提取商品资源一页记录数
	 * @return the goodsResourseSize
	 */
	public int getGoodsResourseSize() {
		try{
			this.goodsResourseSize = Integer.parseInt(ConfigUtil.getCommonConfig(FileDictionary.COMMON_NAME, 
					CommonConfig.GOODSRESOURCE_PAGESIZE));
		}catch(Exception e){
			logger.error("[getGoodsResourseSize提取商品资源一页记录数]有异常:"+e.getMessage());
		}
		return goodsResourseSize;
	}
	/**
	 * @return the errMSG
	 */
	public String getErrMSG() {
		return errMSG;
	}
	/**
	 * @param errMSG the errMSG to set
	 */
	public void setErrMSG(String errMSG) {
		this.errMSG = errMSG;
	}
	/**
	 * @return the ibGlSysparamService
	 */
	public IbGlSysparamService getIbGlSysparamService() {
		return ibGlSysparamService;
	}
	/**
	 * @param ibGlSysparamService the ibGlSysparamService to set
	 */
	public void setIbGlSysparamService(IbGlSysparamService ibGlSysparamService) {
		this.ibGlSysparamService = ibGlSysparamService;
	}
	/**
	 * @return the canOrder
	 */
	public boolean isCanOrder() {
		return canOrder;
	}
	/**
	 * @param canOrder the canOrder to set
	 */
	public void setCanOrder(boolean canOrder) {
		this.canOrder = canOrder;
	}
	
}
