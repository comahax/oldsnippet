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
	//��Ʒ�����ѯ
	private DictItemService dictItemService;

	/**
	 * ������Ϣ
	 */
	private String errMSG;
	
	/**
	 * �Ƿ������𶩹�
	 */
	private boolean canOrder = false;
	
	private String _backURL;
	private boolean canQuery;
	private Map<String,String> dictItem;
	private BookBasicInfo bookBasicInfo;
	private GoodsListQueryParameter param;
	
	private Goods saveGoods;
	//��ϸ
	private String carKey;
	private LoginMember member;
	//��Ʒ���Ͳ�ѯ
	private String comType;
	/**
	 * ����������ȡ
	 */
	private IbGlSysparamService ibGlSysparamService;
	/**
	 * �Ƿ����μ�������Ϣ
	 */
	private boolean isActivationInfoShow = true;
	public void setIsActivationInfoShow(boolean yesORnot){
		this.isActivationInfoShow = yesORnot;
	}
	public boolean isIsActivationInfoShow(){
		return this.isActivationInfoShow;
	}
	
	private int goodsResourseSize = 5;//Ĭ��Ϊ5��
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
			param.setNo(getPageNo().intValue());// ����ҳ��
		if (this.getPageSize() != null)
			param.setSize(getPageSize().intValue());// ���ô�С
		
		if (this.getPageQuery() != null)
			param.setPageQuery(getPageQuery().intValue());// ��ҳ��ѯ��ʶ
		
//		LoginMember member = getMember();
		//����Session
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
		//��¼����Ϣ
		this.member = getMember();
		
		//�ж��Ƿ���Ҫ��ѯ��Դ��ϸ
//		String getConfig = Constant.getConstantName(ConstantsType.ISQUERY, member.getCityid());
		//�ӿ������ȡ
		String getConfig = this.ibGlSysparamService.getIsQuery(member);
		if (getConfig == null) {
			logger.error("ϵͳ����������");
		}
//		System.out.println(">>>"+ member.getCityid() +">>�Ƿ���Ҫ��ѯ��Դ��ϸ>>"+getConfig);
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
		//�û���Ʒ�����ʸ���֤
		ServiceResult chkQlfc = service.chkQualification(member);
		if (!chkQlfc.isSuccess()){
			if (GoodsServiceRetCode.QUALIFICATION_ERROR == chkQlfc.getRetCode()){
				//ϵͳ�쳣
				this.setMessage(chkQlfc.getMessage());
			}else{				
				//û�ж����ʸ�
				this.setMessage(chkQlfc.getMessage()+chkQlfc.getRetObject());
//				System.out.println("[��Ʒ����-�û��ʸ���֤]:"+ chkQlfc.getRetObject());
			}
			this.set_backURL(INDEX);
			return ERROR;
		}
		chkQlfc = null;//�������
		//��ѯ�û�������Ϣ

		//��ȡ������Ϣ
		ServiceResult getBaseInfo = service.getBaseInfo(member);
		if (!getBaseInfo.isSuccess()){
			//��ѯʧ��
			this.setMessage("��ȡ������Ϣʧ��:"+getBaseInfo.getMessage());
//			logger.warn("[��Ʒ����-��ȡ������Ϣ]:"+ getBaseInfo.getRetObject());
			this.set_backURL(INDEX);
			return ERROR;	
		}
		this.setBookBasicInfo((BookBasicInfo)getBaseInfo.getRetObject());
		//�ж��Ƿ������𶩹�
		if (this.bookBasicInfo.getRetCode() == BookBasicInfo.NOT_PASS){
			this.setCanOrder(false);
			this.setMessage(this.bookBasicInfo.getMessage());
		}else{
			this.setCanOrder(true);
		}
		getBaseInfo = null;//�������
		//��ȡ������Ϣ
		
		//��ȡ��Ʒ����
		Map<String,String> c =(Map<String, String>) dictItemService.transact(member, new DictItemQueryParameter(), ServiceType.QUERY).getRetObject();
		//(null, getParameter()).getRetObject();
		this.setDictItem(c);

		//��ʼ�����ﳵ
		HttpSession session = this.getSession();
		ShoppingCar shoppingCar = (ShoppingCar)session.getAttribute(HttpDictionary.SHOPPINGCAR);
		if (shoppingCar == null){
			shoppingCar = new ShoppingCar(getMember().getEmployeeid());
			shoppingCar.setCreateTime(0);
		}
		session.setAttribute(HttpDictionary.SHOPPINGCAR, shoppingCar);
		
		//��ѯϵͳ������ȷ����������Ϣ�Ƿ���ʾ����½�û�
		String systemParam = this.ibGlSysparamService.getSysValue(3, "pboss_Web");
		if(systemParam!=null && systemParam.equals("1"))
			this.isActivationInfoShow = false;
		return execute();
	}
	/**
	 * ��Ʒ�ۼ۶���������ѯ
	 * @return null ʹ��writeJSONServiceData��дJSON���� (дisSuccess��price��radix) 
	 */
	public String doGetPriceRadix(){
		//��ȡ������Ϣ
		ServiceResult getPriceRadix = service.getPriceRadix(member, comType);
		//дJSON
		this.writeJSONServiceData(getPriceRadix);
		return null;
	}
	/**
	 * ��ѯ��Ʒ
	 * @return
	 */
	public String doQuery(){
		//�������ѯ�����
		if (!this.isCanQuery()){
			ServiceResult result = new ServiceResult();
			result.setSuccess(false);
			result.setMessage("��ǰϵͳ�����������Դ��ȡ");
			
			//�ж��Ƿ�AJAX����
			String requestedWith = this.getRequest().getHeader("x-requested-with");
		    if (requestedWith != null && "XMLHttpRequest".equals(requestedWith)){   
				//ajax���󣬷��ش�����Ϣ
		    	this.writeJSONServicePage(result, getsetCols());
				return null;
		    }else{
		    	//��ajax���󣬷��ص�ҳ����
		    	this.setMessage("��ǰϵͳ�����������Դ��ȡ");
		    	this.set_backURL("/goods/begin.do");
		    	return ERROR;
		    }
		}
		ServiceResult result = service.transact(getMember(), getParameter(), ServiceType.QUERY);
		if (!result.isSuccess() && result.getRetCode()!= GoodsServiceRetCode.GETGOODSRESOURCE_EXCEED
			){
			//����װʧ�ܵ�ԭ��	&& result.getRetCode()== GoodsServiceRetCode.FAIL
			//���ǲ�ѯ���ࡢ������ʱ����װʧ��ԭ��
			result.setMessage(result.getMessage()+result.getRetObject());
		}

		this.writeJSONServicePage(result, getsetCols());
		return null;
	}
	/**
	 * ���ӵ����ﳵ
	 * @return null ʹ��writeJSONServiceData��дJSON���� (ֻ��Message��isSuccess) 
	 */
	public String doAddGoods(){
		//���ù��ﳵ
		HttpSession session = this.getSession();
		ShoppingCar shoppingCar = (ShoppingCar)session.getAttribute(HttpDictionary.SHOPPINGCAR);
		if (shoppingCar == null){
			this.writeJSONError(ConfigUtil.getMessage(ServiceCode.GOODSAPPLY, GoodsServiceRetCode.CAREMPTY));//����109 ���ﳵΪ��
			return null;
		}
		
		if (this.saveGoods!=null){
			//����ϵͳ����ȷ���Ƿ������϶���
			String systemParam = this.ibGlSysparamService.getSysValue(63, "pboss_fx");
			boolean enable = true;
			if(systemParam!=null && "0".equals(systemParam)){
				enable = false;
			}
			
			//��¼��Ʒ����
			saveGoods.setType(dictItemService.getNameByCode(saveGoods.getComType()));
			if(enable){//�����϶���,ֱ�Ӽ��빺�ﳵ
				shoppingCar.addGoods(saveGoods,this.canQuery,this.dictItemService.isComrescard(saveGoods.getComType()));
			}else{//�������϶���				
				/**��Ʒ�����б�*/
				Map<String,Goods> goodsMark = shoppingCar.getGoodsMark();
				if(goodsMark.size()<1){//���ﳵΪ�գ�ֱ�Ӽ���
					shoppingCar.addGoods(saveGoods,this.canQuery,this.dictItemService.isComrescard(saveGoods.getComType()));
				}
				else{//���ﳵ��Ϊ�գ�����������Ʒ���������Ʒ��Դ�����Ƿ���ͬ
					//��ѯIM_PR_COMCATEGORYRELA����ȡ��Ʒ����-��Դ������
					//key-��Ʒ���࣬value-��Դ�б�
					Map<String,String> comcatoAndRes = this.dictItemService.getComcatoAndRestype();
					
					String oneKey = goodsMark.keySet().iterator().next();
					Goods goodInCar = goodsMark.get(oneKey);
					String restype1 = comcatoAndRes.get(goodInCar.getComType());
					String restype2 = comcatoAndRes.get(saveGoods.getComType());
					if(restype1.equals(restype2)){//��Դ������ͬ������
						shoppingCar.addGoods(saveGoods,this.canQuery,this.dictItemService.isComrescard(saveGoods.getComType()));
					}
					else{//��Դ���Ͳ�ͬ������
						this.writeJSONError("���ܶ��������Դ���Ķ���");
						return null;
					}
				}
			}			
			
			//int result= shoppingCar.addGoods(saveGoods,this.canQuery,this.dictItemService.isComrescard(saveGoods.getComType()),enable);
			//if(result<1){//���ܶ��������Դ���Ķ���,��������Ʒ���Ͳ�����Ҫ��
			//	this.writeJSONError("���ܶ��������Դ���Ķ���");
			//	return null;
			//}
			session.setAttribute(HttpDictionary.SHOPPINGCAR, shoppingCar);
			this.writeJSONShoppingCar(shoppingCar);
		}else{
			this.writeJSONError(ConfigUtil.getMessage(ServiceCode.GOODSAPPLY, GoodsServiceRetCode.CAREMPTY));//����108 ������Ʒ���쳣
		}
//		this.writeJSONServiceList(serviceResult);
		return null;
	}

	/**
	 * �ӹ��ﳵ��ɾ��
	 * @return null ʹ��writeJSONServiceData��дJSON���� (ֻ��Message��isSuccess) 
	 */
	public String doDelGoods(){
		//���ù��ﳵ
		HttpSession session = this.getSession();
		ShoppingCar shoppingCar = (ShoppingCar)session.getAttribute(HttpDictionary.SHOPPINGCAR);
		if (shoppingCar == null){
			this.writeJSONError(ConfigUtil.getMessage(ServiceCode.GOODSAPPLY, GoodsServiceRetCode.CAREMPTY));//����109 ���ﳵΪ��
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
	 * ��ѯ���ﳵ��ϸ��Ϣ
	 * @return null ʹ��writeJSONServiceData��дJSON���� (ֻ��Message��isSuccess) 
	 */
	public String doCarDetail(){
		//��ȡ���ﳵ
		HttpSession session = this.getSession();
		ShoppingCar shoppingCar = (ShoppingCar)session.getAttribute(HttpDictionary.SHOPPINGCAR);
		if (shoppingCar!=null){ 
			
			this.setSaveGoods(shoppingCar.getGoods(this.carKey));
			if (this.saveGoods==null){
				this.setMessage(ConfigUtil.getMessage(ServiceCode.GOODSAPPLY, GoodsServiceRetCode.CARNOTFIND));//����107 ���ﳵ�����ڴ���Ʒ
				return ERROR;
			}else{
				return this.execute();
			}
		}else{
			this.setMessage(ConfigUtil.getMessage(ServiceCode.GOODSAPPLY, GoodsServiceRetCode.CAREMPTY));//����109 ���ﳵΪ��
			return ERROR;
		}
	}
	/**
	 * ��д���ﳵ��ϸ��JSON
	 * @param shoppingCar
	 */
	public void writeJSONShoppingCar(ShoppingCar shoppingCar) {
		try {
			// Assert.notEmpty(args);
			JSONObject jsonObject = new JSONObject();
			//��ȡ���ﳵ
			Map<String, Goods> map = shoppingCar.getGoodsMark();
			   //ʹ�õ���������Map�ļ������ݼ�ȡֵ
			Iterator<String> it = map.keySet().iterator();
			//дGoods��JSON
			List<Goods> goods = new ArrayList<Goods>();
			Object key,value;
			while (it.hasNext()){
				key = it.next();
				value = map.get(key);
				goods.add((Goods) value);
			}
			
			//��ȡ������Ϣ
			Map<String, GoodsStat>mapStat = shoppingCar.getGoodsStat();
			//ʹ�õ���������Map�ļ������ݼ�ȡֵ
			it = mapStat.keySet().iterator();
			//дGoodsStat��JSON
			List<GoodsStat> stats = new ArrayList<GoodsStat>();
			while (it.hasNext()){
				key = it.next();
				value = mapStat.get(key);
				stats.add((GoodsStat) value);
			}

			//�Ƿ�ɹ�
			jsonObject.put(JSONKey.IS_SUCCESS, Boolean.valueOf(true));
			//������Ϣ
//			jsonObject.put(JSONKey.MESSAGE, "OK");
			//���ﳵ��ϸ
			jsonObject.put(JSONKey.DATAS, JSONArray.fromObject(goods));
			//������Ϣ
			jsonObject.put(JSONKey.STATS, JSONArray.fromObject(stats));
			
			renderHtml(jsonObject.toString());			
		} catch (Exception e) {
			writeJSONError(e.getMessage());
		}
	}
	public String doSubmit(){
		//��ȡ���ﳵList
		HttpSession session = this.getSession();
		ShoppingCar shoppingCar = (ShoppingCar)session.getAttribute(HttpDictionary.SHOPPINGCAR);
		//��ȡ���ﳵ
		Map<String, Goods> map = shoppingCar.getGoodsMark();
		   //ʹ�õ���������Map�ļ������ݼ�ȡֵ
		if (map.size()<1) {
//			this.setErrMSG("���ﳵ����Ϊ��!");
//			return "error";//���ﳵ����0

			this.setMessage("���ﳵ����Ϊ��!");
			this.set_backURL("/goods/begin.do");
			return execute();
		}
		Iterator<String> it = map.keySet().iterator();
		//дGoods��JSON
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
			//�����ɹ������Session
			session.removeAttribute(HttpDictionary.SHOPPINGCAR);
			session.removeAttribute(HttpDictionary.GOODSLIST);
		}else{
//			this.setMessage(rtn.getMessage()+":"+rtn.getRetObject());
			if (GoodsServiceRetCode.ORDERCOMMIT_FAIL == rtn.getRetCode()){
				//�Ѷ���ʧ�ܵ���Ϣֱ�����ڸ��û�
				this.setMessage(rtn.getMessage() + (String)rtn.getRetObject());
			}else{
				this.setMessage(rtn.getMessage());
			}
			this.set_backURL("/goods/begin.do");
		};
		return execute();
	}
	/**
	 * ������ﳵ�б�
	 */
	public List<Goods> getCarGoods(){
		ShoppingCar shoppingCar = (ShoppingCar)this.getSession().getAttribute(HttpDictionary.SHOPPINGCAR);
		if (shoppingCar != null){
			//��ȡ���ﳵ
			Map<String, Goods> map = shoppingCar.getGoodsMark();
			   //ʹ�õ���������Map�ļ������ݼ�ȡֵ
			Iterator<String> it = map.keySet().iterator();
			//дGoods��JSON
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
	 * ���������Ϣ�б�
	 */
	public List<GoodsStat> getCarStats(){
		ShoppingCar shoppingCar = (ShoppingCar)this.getSession().getAttribute(HttpDictionary.SHOPPINGCAR);
		if (shoppingCar != null){
			//��ȡ���ﳵ
			Map<String, GoodsStat> map = shoppingCar.getGoodsStat();
			   //ʹ�õ���������Map�ļ������ݼ�ȡֵ
			Iterator<String> it = map.keySet().iterator();
			//дGoods��JSON
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
	 * �ж��Ƿ���Ҫ��ѯ��Դ��ϸ
	 * @return
	 */
	public boolean isCanQuery() {
		return canQuery;
	}
	/**
	 * ��ȡ��Ʒ����
	 * @return
	 */
	public Map<String,String> getDictItem() {
		Map<String, String> t = new LinkedHashMap<String, String>();
		t.put("", "��ѡ��");
		t.putAll(dictItem);
		return t;
	}

	/**
	 * ��ñ�ͷ
	 * @return
	 */
	public List<ColumnSet> getsetCols() {

		List<ColumnSet> setCols = new ArrayList<ColumnSet>();
		setCols.add(new ColumnSet("id", "���κ�",false,true));//����ʾ
		setCols.add(new ColumnSet("comType", "��Ʒ����",false,true));//����ʾ
		setCols.add(new ColumnSet("orderCount", "��������",false,true));//����ʾ
		setCols.add(new ColumnSet("inCar", "�Ƿ��Ѿ��ڹ��ﳵ",false,true));//����ʾ
		setCols.add(new ColumnSet("addCar","���빺�ﳵ",true,"15%"));
		setCols.add(new ColumnSet("type", "������","20%"));
		setCols.add(new ColumnSet("name", "����","10%"));
//		setCols.add(new ColumnSet("intime", "����ʱ��","20%"));
		setCols.add(new ColumnSet("mobiles", "������ϸ"));
		
		return setCols;
	}
	/**
	 * ��ȡ��Ʒ��Դһҳ��¼��
	 * @return the goodsResourseSize
	 */
	public int getGoodsResourseSize() {
		try{
			this.goodsResourseSize = Integer.parseInt(ConfigUtil.getCommonConfig(FileDictionary.COMMON_NAME, 
					CommonConfig.GOODSRESOURCE_PAGESIZE));
		}catch(Exception e){
			logger.error("[getGoodsResourseSize��ȡ��Ʒ��Դһҳ��¼��]���쳣:"+e.getMessage());
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
