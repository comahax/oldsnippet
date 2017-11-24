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
	//��־
	private static Logger logger = Logger.getLogger(GoodsRemoteImpl.class);

	//��Ʒ�����ѯ
	private DictItemService dictItemService;
	
	/**
	 * Զ�̽ӿ�
	 */
	private WebSiteService httpWebRemote;
	/**
	 * ��Դ
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
		//����ҵ���������
		serviceName = "��Ʒ����";
		serviceCode = ServiceCode.GOODSAPPLY;
		isNeedLogin = true;
		//���ò���������
//		setProcessor(new RegactInfoQueryParameterProcessor());
	}

	/**
	 * ��Ʒ�����ʸ���
	 * @param wayId ��������
	 * @return
	 */
	public ServiceResult chkQualification(LoginMember member) {
		// TODO Auto-generated method stub
		ServiceResult rtn = new ServiceResult();
		rtn.setSuccess(false);
		rtn.setRetCode(ServiceRetCode.FAIL);
		//���ýӿ�
		//...
		try{
			logger.info("[GoodsServiceImpl��Ʒ�����ʸ���]���ýӿ�");
			RetResult result = httpWebRemote.bookQualificationCheck(member.getWayid());
			if (result.getRetCode()==RetResult.SUCCESS){//0-�ɹ�
				rtn.setSuccess(true);
				rtn.setRetCode(GoodsServiceRetCode.QUALIFICATION_SUCC);
			}else if (result.getRetCode()==RetResult.FAILURE){//1-���ɹ�
				rtn.setSuccess(false);
				rtn.setRetCode(GoodsServiceRetCode.QUALIFICATION_FAIL);
				String rtnMsg = result.getMessage();
				logger.info("[��Ʒ����-�û��ʸ���֤]:"+ rtnMsg);
				Log.remoteLog(serviceCode, serviceCode, "GoodsServiceImpl��Ʒ�����ʸ���", member.getWayid(), result.getRetCode(), rtnMsg);
				if (StringUtils.isNotEmpty(rtnMsg)) rtnMsg = ":"+rtnMsg; else rtnMsg="";//��װ������Ϣ
				rtn.setRetObject(rtnMsg);//������Ϣд��RetObject��
			}else if (result.getRetCode()==RetResult.ERROR){//1-�����쳣
				logger.error(">>>>>>>>���õ�һ���ӿ�[bookQualificationCheck('"+ member.getWayid() +"')]��Ʒ�����ʸ������쳣>>>>>>"+result.getMessage());

				Log.remoteLog(serviceCode, serviceCode, "GoodsServiceImpl��Ʒ�����ʸ���", member.getWayid(), result.getRetCode(),result.getMessage());
				rtn.setSuccess(false);
				rtn.setRetCode(GoodsServiceRetCode.QUALIFICATION_ERROR);
				rtn.setRetObject(result.getMessage());//������Ϣд��RetObject��
			}
		}catch(Exception e){
			logger.error("[GoodsServiceImpl.chkQualification]:"+ e.getMessage());
			//-1Ϊ���д�
			Log.remoteLog(serviceCode, serviceCode, "GoodsServiceImpl��Ʒ�����ʸ���", member.getWayid(), -1,e.getMessage());
			//��ȡ�쳣��Ϣ
			rtn.setSuccess(false);
			rtn.setRetCode(GoodsServiceRetCode.QUALIFICATION_ERROR);			
			rtn.setRetObject(e.getMessage());//������Ϣд��RetObject��
		}
//		rtn.setSuccess(true);
//		rtn.setMessage("��֤�ɹ����û��ж����ʸ�!");
		//��������Ϣ
		this.finishProcessor(rtn, member, ServiceType.OTHER, GoodsServiceCode.Qualification);
		return rtn;
	}

	/**
	 * ������Ϣ��ѯ
	 * @param wayId ��������
	 * @return
	 */
	public ServiceResult getBaseInfo(LoginMember member) {
		// TODO Auto-generated method stub
		ServiceResult rtn = new ServiceResult();
		rtn.setSuccess(false);
		rtn.setRetCode(ServiceRetCode.FAIL);
		//���ýӿ�
		logger.info("[GoodsServiceImpl������Ϣ��ѯ]���ýӿ�");
		try{
			//RetResult result = httpWebSiteService.bookQualificationCheck(member.getWayid());
			BookBasicInfo result = httpWebRemote.queryBookBasicInfo(member.getWayid());
//			result.setRetCode(3);
//			result.setMessage("�����ѳ�������������");
			//�û�������Ϣ
			if (result.getRetCode()==BookBasicInfo.SUCCESS){//0-�ɹ�
				rtn.setSuccess(true);
				rtn.setRetCode(GoodsServiceRetCode.QUERYBASEINFO_SUCC);
				rtn.setRetObject(result);
			}else if(result.getRetCode()==BookBasicInfo.NOT_PASS){//3-�ɹ�,�����ܷ��𶩹������ر�����
				rtn.setSuccess(true);
				rtn.setRetCode(GoodsServiceRetCode.QUERYBASEINFO_SUCC);
				rtn.setRetObject(result);
			}else if(result.getRetCode()==BookBasicInfo.FAILURE){//1-�ɹ�,�������ݣ�����Nullֵ
				rtn.setSuccess(false);
				rtn.setRetCode(GoodsServiceRetCode.QUERYBASEINFO_FAIL);
				rtn.setRetObject(new BookBasicInfo());
				logger.warn("[GoodsServiceImpl.getBaseInfo('"+ member.getWayid() +"')==1]������Ϣ��ѯ������,����ԭ��:"+result.getMessage());

				Log.remoteLog(serviceCode, serviceCode, "GoodsServiceImpl������Ϣ��ѯ", member.getWayid(), result.getRetCode(),"������Ϣ��ѯ������,����ԭ��:"+ result.getMessage());
			}else if (result.getRetCode()==RetResult.ERROR){//2-�����쳣
				logger.error(">>>>>>>>���õڶ����ӿ�(queryBookBasicInfo('"+ member.getWayid() +"'))������Ϣ��ѯ���쳣>>>>>>"+result.getMessage());
				Log.remoteLog(serviceCode, serviceCode, "GoodsServiceImpl������Ϣ��ѯ", member.getWayid(), result.getRetCode(),"������Ϣ��ѯ���쳣:"+ result.getMessage());
				rtn.setSuccess(false);
				rtn.setRetCode(GoodsServiceRetCode.QUERYBASEINFO_ERROR);			
				rtn.setRetObject(result.getMessage());//������Ϣд��RetObject��
			}
		}catch(Exception e){
			logger.error("[GoodsServiceImpl.getBaseInfo]:"+ e.getMessage());
			//��ȡ�쳣��Ϣ

			//-1Ϊ���д�
			Log.remoteLog(serviceCode, serviceCode, "GoodsServiceImpl������Ϣ��ѯ", member.getWayid(), -1,e.getMessage());
			rtn.setSuccess(false);
			rtn.setRetCode(GoodsServiceRetCode.QUERYBASEINFO_ERROR);			
			rtn.setRetObject(e.getMessage());//������Ϣд��RetObject��
		}
		//��������Ϣ
		this.finishProcessor(rtn, member, ServiceType.OTHER, GoodsServiceCode.QueryBookBasicInfo);
		return rtn;
		//...
		/*
		 * 
		//�ֶ�����
		BookBasicInfo test = new BookBasicInfo();
		//�û�������Ϣ

		List baseInfo = new ArrayList();
//		//��Ӷ�����Ϣ ������Ϣֻ����һ��
//		BookInfo bi = new BookInfo();
//		bi.setBrandName("������");
//		bi.setCanBookNonceMonth(1000);//���¿ɶ�����
//		bi.setBookedNonceMonth(800);//�����Ѷ�����
//		bi.setSurBookNonceMonth(200);//����ʣ�ඩ����
//		bi.setCanBookToday(100);//����ɶ�����
//		bi.setBookedToday(80);//�����Ѷ�����
//		bi.setSurBookToday(20);//����ʣ�ඩ����
//		baseInfo.add(bi);
//		
//		bi = new BookInfo();
//		bi.setBrandName("���еش�");
//		bi.setCanBookNonceMonth(2000);//���¿ɶ�����
//		bi.setBookedNonceMonth(1800);//�����Ѷ�����
//		bi.setSurBookNonceMonth(200);//����ʣ�ඩ����
//		bi.setCanBookToday(200);//����ɶ�����
//		bi.setBookedToday(180);//�����Ѷ�����
//		bi.setSurBookToday(20);//����ʣ�ඩ����
//		baseInfo.add(bi);
//		//�ϳ�
//		test.setBookInfos(baseInfo);
		//��ӿ����Ϣ
		List stockInfos = new ArrayList();
		StockInfo si = new StockInfo();
		si.setBrandName("���еش�");//Ʒ��
		si.setBasicStock(1000);//��׼�����
		si.setNonceStock(800);//��ǰ�����
		si.setNonceMaxStock(200);//��ǰ�������
		stockInfos.add(si);
		
		si = new StockInfo();
		si.setBrandName("������");//Ʒ��
		si.setBasicStock(200);//��׼�����
		si.setNonceStock(100);//��ǰ�����
		si.setNonceMaxStock(100);//��ǰ�������
		stockInfos.add(si);

		//�ϳ�
		test.setStockInfos(stockInfos);
		
		//Ʒ�Ƽ�����Ϣ
		List actInfo = new ArrayList();
		ActiveInfo a = new ActiveInfo();
		a.setBrandName("���еش�");//Ʒ����
		a.setActRate(60);//������
		a.setFulfilStandard(false);//�Ƿ���
		a.setFilStandardGap(3);//�����
		actInfo.add(a);
		
		a = new ActiveInfo();
		a.setBrandName("������");
		a.setActRate(100);
		a.setFulfilStandard(true);
		a.setFilStandardGap(0);
		actInfo.add(a);
		//�ϳ�����
		test.setActiveInfos(actInfo);
		
		rtn.setSuccess(true);
		rtn.setRetObject(test);
		rtn.setMessage("��ѯ�ɹ�!");
		 */
		
	}

	/* (non-Javadoc)
	 * @see com.gmcc.pboss.biz.basic.goods.service.GoodsService#getPriceRadix(java.lang.String, java.lang.String)
	 */
	/**
	 * ��Ʒ�ۼ�/����������ѯ
	 * @param wayId ��������
	 * @param prdcClg ��Ʒ���ࣨ��������ֵ����
	 * @return
	 */
	public ServiceResult getPriceRadix(LoginMember member, String comType) {
		// TODO Auto-generated method stub
		ServiceResult rtn = new ServiceResult();
		rtn.setSuccess(false);
		rtn.setRetCode(ServiceRetCode.FAIL);
		//���ýӿ�
		logger.info("[queryGoodsPriceRadix��Ʒ�ۼ�/����������ѯ]���ýӿ�");

		try{
			//RetResult result = httpWebSiteService.bookQualificationCheck(member.getWayid());
			GoodsInfo result = httpWebRemote.queryGoodsPriceRadix(member.getWayid(), comType);
			//�û�������Ϣ
			if (result.getRetCode()==BookBasicInfo.SUCCESS){//0-�ɹ�
				rtn.setSuccess(true);
				rtn.setRetCode(GoodsServiceRetCode.QUERYPRICERADIX_SUCC);
				//���ض���
				ComTypeInfo rtnObj = new ComTypeInfo(result);
				rtnObj.setRestype(dictItemService.getTypeByCode(comType));
				rtn.setRetObject(rtnObj);
			}else if(result.getRetCode()==BookBasicInfo.FAILURE){//1-�ɹ�,�������ݣ�����Nullֵ
				rtn.setSuccess(false);
				rtn.setRetCode(GoodsServiceRetCode.QUERYPRICERADIX_FAIL);
				rtn.setRetObject(result.getMessage());
//				System.out.println("[GoodsServiceImpl.queryGoodsPriceRadix()==1]������Ϣ��ѯ������,����ԭ��:"+result.getMessage());
				logger.error("[GoodsServiceImpl.queryGoodsPriceRadix('"+member.getWayid()+"','"+  comType 
						+"')==1]��Ʒ�ۼ�/����������ѯ������,����ԭ��:"+result.getMessage());

				Log.remoteLog(serviceCode, serviceCode, "queryGoodsPriceRadix��Ʒ�ۼ�/����������ѯ", member.getWayid(), result.getRetCode(),
						"��Ʒ�ۼ�/����������ѯ������,����ԭ��:"+ result.getMessage());
			}else if (result.getRetCode()==RetResult.ERROR){//2-�����쳣
				logger.error(">>>>>>>>���õ������ӿ�(queryGoodsPriceRadix('"+member.getWayid()+"','"+  comType 
						+"'))��Ʒ�ۼ�/����������ѯ���쳣>>>>>>"+result.getMessage());

				Log.remoteLog(serviceCode, serviceCode, "queryGoodsPriceRadix��Ʒ�ۼ�/����������ѯ", member.getWayid(), result.getRetCode(),
						"��Ʒ�ۼ�/����������ѯ���쳣,����ԭ��:"+ result.getMessage());
				rtn.setSuccess(false);
				rtn.setRetCode(GoodsServiceRetCode.QUERYPRICERADIX_ERROR);			
				rtn.setRetObject(result.getMessage());//������Ϣд��RetObject��
			}
		}catch(Exception e){
			logger.error("[queryGoodsPriceRadix��Ʒ�ۼ�/����������ѯ]:"+ e.getMessage());
			Log.remoteLog(serviceCode, serviceCode, "queryGoodsPriceRadix��Ʒ�ۼ�/����������ѯ", member.getWayid(), -1,
					"��Ʒ�ۼ�/����������ѯ���쳣,����ԭ��:"+ e.getMessage());
			//��ȡ�쳣��Ϣ
			rtn.setSuccess(false);
			rtn.setRetCode(GoodsServiceRetCode.QUERYPRICERADIX_ERROR);			
			rtn.setRetObject(e.getMessage());//������Ϣд��RetObject��
		}
		//��������Ϣ
		this.finishProcessor(rtn, member, ServiceType.OTHER, GoodsServiceCode.GETPRICERADIX);
		return rtn;
	}

	/**
	 * ��Ʒ��Դ��ȡ
	 * @param wayId �����̱���
	 * @param comType ��Ʒ�����ʶ��
	 * @param orderCount ����������
	 * @return
	 */
	public ServiceResult getProductList(String wayId,String comType,int orderCount,GoodsListQueryParameter param) {
		// TODO Auto-generated method stub
		ServiceResult rtn = new ServiceResult();
		rtn.setSuccess(false);
		rtn.setRetCode(ServiceRetCode.FAIL);
		List<Goods> allGoods = null;//ʹ�ö���
		boolean save = true;
		//�����ѯ
		HttpSession session = param.getSession();
		//��ȡ���ﳵ
		ShoppingCar shoppingCar = (ShoppingCar)session.getAttribute(HttpDictionary.SHOPPINGCAR);
		
//		String saveComType= (String) session.getAttribute(HttpDictionary.Save_GoodsComType);
		if (param.getPageQuery()== CommonConstants.PAGEQUERY_TRUE ){
			//�ݲ�����Ʒ�����жϣ�&& comType.equals(saveComType)
			//���˷�ҳ �� ��ѯ����Ʒ�����뻺����һ��
			//ֱ�Ӵӻ���ȡ��
			allGoods = (List<Goods>)session.getAttribute(HttpDictionary.GOODSLIST);
			save = false;
		}else{
			allGoods = this.getGoodsResource(wayId, comType, orderCount);
			//�����ж�
			if (this.goodsResource.getRetCode() != GoodsResource.SUCCESS){
				if (this.goodsResource.getRetCode() == GoodsResource.FAILURE){
					logger.warn(">>>>>>>>���õ��ĸ��ӿ�(getGoodsResource('"+wayId+"','"+  comType 
							+"','"+ orderCount +"'))��Ʒ��Դ��ȡʧ��>>>>>>"+goodsResource.getMessage());
					Log.remoteLog(serviceCode, serviceCode, "getGoodsResource��Ʒ��Դ��ȡʧ��", wayId, goodsResource.getRetCode(),goodsResource.getMessage());
					//��ѯʧ��
					rtn.setSuccess(false);
					rtn.setRetCode(GoodsServiceRetCode.GETGOODSRESOURCE_FAIL);
					rtn.setRetObject(goodsResource.getMessage());
				}else if (this.goodsResource.getRetCode() == GoodsResource.ERROR){
					logger.error(">>>>>>>>���õ��ĸ��ӿ�(getGoodsResource('"+wayId+"','"+  comType 
							+"','"+ orderCount +"'))��Ʒ��Դ��ȡ���쳣>>>>>>"+goodsResource.getMessage());

					Log.remoteLog(serviceCode, serviceCode, "getGoodsResource��Ʒ��Դ��ȡ���쳣", wayId, goodsResource.getRetCode(),goodsResource.getMessage());
					//ϵͳ�쳣
					rtn.setSuccess(false);
					rtn.setRetCode(GoodsServiceRetCode.GETGOODSRESOURCE_ERROR);
					rtn.setRetObject(goodsResource.getMessage());
				}else if (this.goodsResource.getRetCode() == GoodsResource.OVER_QUERY_LIMIT_TIMES){
					logger.warn(">>>>>>>>���õ��ĸ��ӿ�(getGoodsResource('"+wayId+"','"+  comType 
							+"','"+ orderCount +"'))��Ʒ��Դ��ȡ��ѯ������������>>>>>>");

					Log.remoteLog(serviceCode, serviceCode, "getGoodsResource��Ʒ��Դ��ȡ", wayId, goodsResource.getRetCode(),"��Ʒ��Դ��ȡ��ѯ������������");
					//��ѯ������������
					rtn.setSuccess(false);
					rtn.setRetCode(GoodsServiceRetCode.GETGOODSRESOURCE_EXCEED);
					rtn.setRetObject(null);
				}
					
				return rtn;
			}//if
		}//if
		if (allGoods != null){
			//���췭ҳ
			Page thisPage = new Page(allGoods.size(),param.getSize(),param.getNo());
			//���ڴ��з�ҳ
			int stat = thisPage.getFirstResult();
			List<Goods> showGoods = new ArrayList<Goods>(); 
			for (int i =0;i<param.getSize();i++){
				if (stat+i>=allGoods.size()) break;
				//��������Ʒ
				Goods dtl = allGoods.get(stat+i);
				if (shoppingCar!=null) dtl.setInCar(shoppingCar.isInCar(dtl));
				showGoods.add(dtl);
				//@@ yuwenjun ���Ż� ���ﳵ�м������е���Ʒ
				shoppingCar.addAllGoods(dtl);//ҵ������˵��ÿ�β�����ֻ�ǶԱ��β�ѯ���б��棬��ˣ�ÿ�����ӣ�����ǰ����գ�
			}//for
			session.setAttribute(HttpDictionary.SHOPPINGCAR, shoppingCar);//���湺�ﳵ
			rtn.setRetResult(new QueryResult(thisPage,showGoods));
			rtn.setSuccess(true);
			rtn.setRetCode(ServiceRetCode.SUCCESS);
			//���浽������
			if (save){
				session.setAttribute(HttpDictionary.Save_GoodsComType, comType);
				session.setAttribute(HttpDictionary.GOODSLIST, allGoods);
			}
		}
		return rtn;
	}
	/**
	 * ������Ʒ��Դ��ȡ�ӿڲ���װ
	 * @param wayid
	 * @param comType
	 * @param orderCount
	 * @return
	 */
	private List<Goods> getGoodsResource(String wayid, String comType, int orderCount){
		logger.info("[getGoodsResource��Ʒ��Դ��ȡ]���ýӿ�");
		List<SCPackage> rtnList = null;//����ֵ��
		//����GOODS������ʾ
		List<Goods> allGoods = null;
//		SCPackage rtnDtl;
		try{
			this.goodsResource = httpWebRemote.getGoodsResource(wayid,comType,orderCount);
		}catch(Exception e){
			//�ӿڵ������쳣����
			this.goodsResource = new GoodsResource();
			goodsResource.setGoodsList(null);
			goodsResource.setRetCode(GoodsResource.ERROR);
			goodsResource.setMessage(e.getMessage());
		}
//		System.out.println(">>>>>>>>>>>>>>>>>>>���õ��ĸ��ӿ�>>"+goodsResource.getRetCode()+"["+ goodsResource.getMessage() +"]");
		if (goodsResource.getRetCode() != GoodsResource.SUCCESS) return null;
		rtnList = this.goodsResource.getGoodsList();
		System.out.println("[getGoodsResource��Ʒ��Դ��ȡ]��ȡ�ɹ�,��¼����"+rtnList.size()); 
//		while (it.hasNext()){
		if (rtnList!=null){
			allGoods = new ArrayList<Goods>();
			for(SCPackage rtnDtl:rtnList){
				Goods save = new Goods();
				save.setType(dictItemService.getNameByCode(comType));
				save.setId(rtnDtl.getBatchNo());//���κ�
				save.setName(rtnDtl.getPackageNo());//����
				save.setComType(comType);	//��Ʒ����
				save.setOrderCount(orderCount);	//��������
				String allMobile [] = rtnDtl.getMobiles();
				String allTemp = "";
				if (allMobile != null){
					for (int i=0;i<allMobile.length;i++){
						allTemp +=allMobile[i]+(i<allMobile.length?",":"");
						//ÿ����Զ�����
						if ((i+1)%5==0) allTemp+="<BR>";
					}
				}
				save.setMobiles(allTemp);
				//�ϲ�
				allGoods.add(save);
			}//for
		}//if
		return allGoods;
	}
	/**
	 * ��Ʒ���������ύ
	 * @param wayId �����̱���
	 * @param sendObj �ַ�������,ÿ������Ϊ����Ʒ�����ʶ~��������
	 * @return
	 */
	public ServiceResult submitOrder(LoginMember member, List<Goods> sendObj,boolean isQueryDetail) {
		// TODO Auto-generated method stub
		ServiceResult rtn = new ServiceResult();
		rtn.setSuccess(false);
		rtn.setRetCode(ServiceRetCode.FAIL);
		//�ֽ⹺�ﳵList
		List<Goods> shoppingCar = sendObj;
		//�����ύ����
		List<ComOrder> comOrderList = new ArrayList<ComOrder>();
		for (int i=0;i<shoppingCar.size();i++){
			Goods dtl = (Goods)shoppingCar.get(i);
			//�����µ��ύ����
			ComOrder comOrder = new ComOrder();
			comOrder.setComType(dtl.getComType());//��Ʒ����
			comOrder.setOrderCount(dtl.getOrderCount());//��������
			comOrder.setBatchNo(dtl.getId());//���κ�
			comOrder.setPackageNo(dtl.getName());//����
			comOrderList.add(comOrder);
		}
		//���ýӿ�
		try{
			System.out.println(">>>>>>>>��Ʒ���������ύcomOrderCommit()���� ");
			RetResult result = this.httpWebRemote.comOrderCommit(member.getWayid(), isQueryDetail, comOrderList);

			if (result.getRetCode()==RetResult.SUCCESS){//0-�ɹ�
				rtn.setSuccess(true);
				rtn.setRetCode(GoodsServiceRetCode.ORDERCOMMIT_SUCC);
				rtn.setRetObject(result.getMessage());
				System.out.println("�����ɹ��������ţ�"+result.getMessage());
			}else if(result.getRetCode()==RetResult.FAILURE){//1-ʧ��
				rtn.setSuccess(false);
				rtn.setRetCode(GoodsServiceRetCode.ORDERCOMMIT_FAIL);
				rtn.setRetObject(result.getMessage());
				logger.warn("[GoodsServiceImpl.submitOrder('"+ member.getWayid() +"','"+ isQueryDetail +"')==1]����ʧ��,����ԭ��:"+result.getMessage());
				Log.remoteLog(serviceCode, serviceCode, "��Ʒ���������ύcomOrderCommit", member.getWayid(), result.getRetCode(),"����ʧ��,����ԭ��:"+result.getMessage());
			}else if (result.getRetCode()==RetResult.ERROR){//2-�����쳣
				logger.error(">>>>>>>>���õ�����ӿ�[GoodsServiceImpl.submitOrder('"+ member.getWayid() +"','"+ isQueryDetail +"')]��Ʒ���������ύ>>>>>>"+result.getMessage());
				Log.remoteLog(serviceCode, serviceCode, "��Ʒ���������ύcomOrderCommit", member.getWayid(), result.getRetCode(),"�����ύ�����쳣,����ԭ��:"+result.getMessage());
				rtn.setSuccess(false);
				rtn.setRetCode(GoodsServiceRetCode.ORDERCOMMIT_ERROR);			
				rtn.setRetObject(result.getMessage());//������Ϣд��RetObject��
			}
		}catch(Exception e){
			//�����쳣
			logger.error(">>>>>>>>���õ�����ӿ�[GoodsServiceImpl.submitOrder('"+ member.getWayid() +"','"+ isQueryDetail +"')]��Ʒ���������ύ>>>>>>"+e.getMessage());
			Log.remoteLog(serviceCode, serviceCode, "��Ʒ���������ύcomOrderCommit", member.getWayid(), -1,"�����ύ�����쳣,����ԭ��:"+e.getMessage());
			rtn.setSuccess(false);
			rtn.setRetCode(GoodsServiceRetCode.ORDERCOMMIT_ERROR);			
			rtn.setRetObject(e.getMessage());//������Ϣд��RetObject��
		}
		//��������Ϣ
		this.finishProcessor(rtn, member, ServiceType.OTHER, GoodsServiceCode.ComOrderCommit);
		return rtn;
	}

	
	/* (non-Javadoc)
	 * @see com.gmcc.pboss.common.service.impl.QueryBaseServiceImpl#query(com.gmcc.pboss.common.bean.LoginMember, com.gmcc.pboss.common.support.QueryParameter)
	 */
	public ServiceResult query(LoginMember member, QueryParameter parameter) {
		
		GoodsListQueryParameter param = (GoodsListQueryParameter) parameter;
		//�����ж�
//		if (CommonUtil.isEmptyOrNull(member.getWayid())) Ass
		Assert.notBlank(member.getWayid(),GoodsServiceRetCode.GETGOODSRESOURCE_WAYIDNULL,"WAYID����Ϊ��!");
		Assert.notBlank(param.getComType(),GoodsServiceRetCode.GETGOODSRESOURCE_COMTYPENULL,"ComType ����Ϊ��!");
		Assert.isTrue(param.getOrderCount()>0,GoodsServiceRetCode.GETGOODSRESOURCE_ORDERCOUNTNULL,"OrderCount ����Ϊ��!");
		
		return this.getProductList(member.getWayid(), param.getComType(),param.getOrderCount(),(GoodsListQueryParameter) parameter);
	}
	
}
