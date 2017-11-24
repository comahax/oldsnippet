package com.gmcc.pboss.service.control.goodsordercommit;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import com.gmcc.pboss.business.channel.cooperator.CooperatorVO;
import com.gmcc.pboss.business.channel.way.WayDBParam;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.resource.com.ComVO;
import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaDBParam;
import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaVO;
import com.gmcc.pboss.business.resource.compack.CompackDBParam;
import com.gmcc.pboss.business.resource.compack.CompackVO;
import com.gmcc.pboss.business.resource.comrescard.ComrescardDBParam;
import com.gmcc.pboss.business.resource.comrescard.ComrescardVO;
import com.gmcc.pboss.business.resource.comressmp.ComressmpDBParam;
import com.gmcc.pboss.business.resource.comressmp.ComressmpVO;
import com.gmcc.pboss.business.sales.comorder.ComorderConstant;
import com.gmcc.pboss.business.sales.comorder.ComorderVO;
import com.gmcc.pboss.business.sales.disform.DisformVO;
import com.gmcc.pboss.business.sales.order.OrderVO;
import com.gmcc.pboss.business.sales.orderpackdet.OrderpackdetVO;
import com.gmcc.pboss.business.sales.orderresdet.OrderresdetVO;
import com.gmcc.pboss.common.utils.tools.TiedComInfo;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.cooperator.Cooperator;
import com.gmcc.pboss.control.channel.cooperator.CooperatorBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.promotion.spproposal.Spproposal;
import com.gmcc.pboss.control.promotion.spproposal.SpproposalBO;
import com.gmcc.pboss.control.resource.com.Com;
import com.gmcc.pboss.control.resource.com.ComBO;
import com.gmcc.pboss.control.resource.comcategoryrela.Comcategoryrela;
import com.gmcc.pboss.control.resource.comcategoryrela.ComcategoryrelaBO;
import com.gmcc.pboss.control.resource.compack.Compack;
import com.gmcc.pboss.control.resource.compack.CompackBO;
import com.gmcc.pboss.control.resource.comrescard.Comrescard;
import com.gmcc.pboss.control.resource.comrescard.ComrescardBO;
import com.gmcc.pboss.control.resource.comressmp.Comressmp;
import com.gmcc.pboss.control.resource.comressmp.ComressmpBO;
import com.gmcc.pboss.control.sales.comorder.Comorder;
import com.gmcc.pboss.control.sales.comorder.ComorderBO;
import com.gmcc.pboss.control.sales.comorder.ComorderCheck;
import com.gmcc.pboss.control.sales.comorder.ComorderCheckBO;
import com.gmcc.pboss.control.sales.disform.Disform;
import com.gmcc.pboss.control.sales.disform.DisformBO;
import com.gmcc.pboss.control.sales.order.Order;
import com.gmcc.pboss.control.sales.order.OrderBO;
import com.gmcc.pboss.control.sales.ordercomcate.Ordercomcate;
import com.gmcc.pboss.control.sales.ordercomcate.OrdercomcateBO;
import com.gmcc.pboss.control.sales.orderpackdet.Orderpackdet;
import com.gmcc.pboss.control.sales.orderpackdet.OrderpackdetBO;
import com.gmcc.pboss.control.sales.orderresdet.Orderresdet;
import com.gmcc.pboss.control.sales.orderresdet.OrderresdetBO;
import com.gmcc.pboss.service.exception.WebSiteException;
import com.gmcc.pboss.service.result.RetResult;
import com.gmcc.pboss.service.send.ComOrder;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.exception.business.SaleException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class ComOrderCommitBO extends AbstractControlBean implements ComOrderCommit{

	private static Logger logger = Logger.getLogger(ComOrderCommitBO.class);
	
	public static final int EXIT = -1; //�˳�
	public static final int START = 1; //��ʼ
	public static final int NEXT = 1; //��һ��
	
	private String orderid; //��ͷ�ߵ�β�Ķ�����
	
	//step1
	private void doBasicQualification(String wayid) throws Exception{
		Way way = (Way) BOFactory.build(WayBO.class, user);
		WayDBParam params = new WayDBParam();
		params.set_se_wayid(wayid);
		params.set_se_waytype("AG");
		DataPackage dp = way.doQuery(params);
		if(dp.getDatas() == null || dp.getDatas().size() == 0){
			throw new WebSiteException("�ú�����["+wayid+"]������Ϣ������",RetResult.FAILURE);
		}
		user.setCityid(((WayVO)dp.getDatas().get(0)).getCityid());
	}
	//step2
	private void doSetOrderId() throws Exception{
		Comorder comorder = (Comorder)BOFactory.build(ComorderBO.class, user);
		orderid = comorder.doGetOrderId();
	}
	
	/**
	 * isQueryDetailΪtrueʱ,��Ҫ������Դ��ȡ,��Ҫ��������ComOrderList
	 * @param comOrderList
	 * @return
	 * @throws Exception
	 */
	private ComOrderCommitHandle doBuildComorderListWithResourcePick(String wayid, List<ComOrder> comOrderList) throws Exception{
		Comrescard comrescard = (Comrescard)BOFactory.build(ComrescardBO.class, user);
		Compack compack = (Compack)BOFactory.build(CompackBO.class, user);
		Orderresdet orderresdet = (Orderresdet)BOFactory.build(OrderresdetBO.class, user);
		Orderpackdet orderpackdet = (Orderpackdet)BOFactory.build(OrderpackdetBO.class, user);
		Comressmp comressmp = (Comressmp)BOFactory.build(ComressmpBO.class, user);
		ComorderCheck comorderCheck = (ComorderCheck)BOFactory.build(ComorderCheckBO.class, user);
		
		ComOrderCommitHandle handle = new ComOrderCommitHandle();
		
		Map<String,Long> map = new HashMap<String,Long>(); //�ۼ���Ʒ����Ͷ�������
		List<String> residList = new ArrayList<String>();
		String storea = null;
		
		for (ComOrder comordervo : comOrderList) {
			//��ȡ��Դ���
			ComcategoryrelaVO comcategoryrelavo = comorderCheck.checkIsComressmp(comordervo.getComType());
			if("COMRESCARD".equals(comcategoryrelavo.getRestype())){//��ֵ����Դ��ȡ
				
				ComrescardDBParam comrescardDBParam = new ComrescardDBParam();
				comrescardDBParam.set_ne_comstate((short)1);
				comrescardDBParam.set_pagesize(String.valueOf(comordervo.getOrderCount()));
				comrescardDBParam.set_orderby("comresid");
				comrescardDBParam.set_desc("0");
				
				/*ComcategoryrelaDBParam comcategoryrelaDBParam = new ComcategoryrelaDBParam();
				comcategoryrelaDBParam.set_se_comcategory(comordervo.getComType());
				
				Class[] clazz = new Class[]{ComrescardVO.class,ComcategoryrelaVO.class};
				Object[] params = new Object[] { comrescardDBParam, comcategoryrelaDBParam };
				String[][] joins = new String[][] { { "comid", "comid" } };
				DataPackage comrescardDp = comrescard.doUnionQuery(params, clazz, joins);*/
				List<Object[]> comrescardList=comrescard.doQueryByComcategory(comrescardDBParam, comordervo.getComType(),null,null,null).getDatas();//��ֵ����Դ��ѯ����
				if (null == comrescardList || comrescardList.size() == 0) {
					throw new WebSiteException("��Ʒ��Դ["+comordervo.getComType()+"]������",RetResult.FAILURE);
				}else if(comrescardList.size() != comordervo.getOrderCount()){
					throw new WebSiteException("��Ʒ��Դ["+comordervo.getComType()+"]��治��",RetResult.FAILURE);
				}else{
					/*for (Iterator comrescardItt = comrescardDp.getDatas().iterator(); comrescardItt.hasNext();) {
						Object[] objs = ((Object[])comrescardItt.next());
						ComrescardVO comrescardVO = (ComrescardVO) objs[0];
						ComcategoryrelaVO comcategoryVO = (ComcategoryrelaVO)objs[1];
						comrescardVO.setComstate((short)10);
						comrescard.doUpdate(comrescardVO);
						OrderresdetVO orderresdetVO = new OrderresdetVO();
						orderresdetVO.setOrderid(orderid);
						orderresdetVO.setOrdercomtype("CUSTORDER");
						BeanUtils.copyProperties(orderresdetVO, comrescardVO);
						BeanUtils.copyProperties(orderresdetVO, comcategoryVO);
						orderresdet.doCreate(orderresdetVO);
						residList.add(String.valueOf(orderresdetVO.getDetid()));//��¼������ϸID
					}*/
					ComrescardVO comrescardVO=null;//��ֵ��VO
					OrderresdetVO orderresdetVO=null;//������Դ��ϸVO
					Com com=(Com)BOFactory.build(ComBO.class, user);
					Ordercomcate orderComcate=(Ordercomcate)BOFactory.build(OrdercomcateBO.class, user);
					for(Object[] objArray:comrescardList){
						comrescardVO=(ComrescardVO)objArray[1];//��ֵ��
						//�޸ĳ�ֵ����Դ״̬Ϊ��ȡ̬
						comrescardVO.setComstate((short)10);
						comrescard.doUpdate(comrescardVO);
						orderresdetVO=new OrderresdetVO();
						orderresdetVO.setOrderid(orderid);//�������
						orderresdetVO.setOrdercomtype("CUSTORDER");//������Ʒ����
						orderresdetVO.setComcategory(comordervo.getComType());//��Ʒ����
						orderresdetVO.setRestype("COMRESCARD");//��Դ���
						orderresdetVO.setComid(comrescardVO.getComid());
						orderresdetVO.setComresid(comrescardVO.getComresid());//��Ʒ��Դ���
						orderresdetVO.setBatchno(comrescardVO.getBatchno());//����
						orderresdetVO.setWayid(comrescardVO.getWayid());//����ID
						orderresdetVO.setBrand((String)objArray[0]);
						if(orderresdetVO.getComid()!=null){
						//��Ʒԭ��:������Ʒ��ʶ��ѯ��Ʒ���ݱ�IM_PR_COM����ȡ��Ʒԭ��
						ComVO comVO=com.doFindByPk(comrescardVO.getComid());
						if(comVO!=null && comVO.getComprice()!=null)
						{
							//����Ʒ���۴ӷ�ת��ΪԪ
							long price=comVO.getComprice().longValue()/100;
							orderresdetVO.setComprice(new Double(""+price));
						}
						/*//ʵ���ۼ�:���ݶ�����š�������Ʒ���ͺ���Ʒ�����ѯ������Ʒ�����
						OrdercomcateDBParam param=new OrdercomcateDBParam();
						param.set_se_orderid(orderresdetVO.getOrderid());
						param.set_se_ordercomtype(orderresdetVO.getOrdercomtype());
						param.set_se_comcategory(orderresdetVO.getComcategory());
						DataPackage dp=orderComcate.doQuery(param);
						if(dp.getRowCount()>0)
						{
							OrdercomcateVO vo=(OrdercomcateVO)(dp.toList(OrdercomcateVO.class)).get(0);
							if(vo!=null && vo.getUnitprice()!=null)
							{
								orderresdetVO.setActprice(vo.getUnitprice());
							}
						}*/
						}
						Comorder comorder = (Comorder)BOFactory.build(ComorderBO.class, user);
						Double price = comorder.doGetUnitprice(wayid, comordervo.getComType());
						orderresdetVO.setActprice(price);
						
						orderresdet.doCreate(orderresdetVO);
						residList.add(String.valueOf(comrescardVO.getComresid()));//��¼��ԴID����Ʒ��ʶ���ֻ����룩
					}
					if(map.get(comordervo.getComType()) == null){
						map.put(comordervo.getComType(), new Long(comordervo.getOrderCount()));
					}else{
						map.put(comordervo.getComType(), map.get(comordervo.getComType())+comordervo.getOrderCount());
					}
				}
			}else if("COMRESSMP".equals(comcategoryrelavo.getRestype())){//�׿���Դ
				CompackDBParam compackDBParam = new CompackDBParam();
				compackDBParam.set_se_batchno(comordervo.getBatchNo());
				compackDBParam.set_se_boxnum(comordervo.getPackageNo());
				compackDBParam.set_se_packstate("5");
				DataPackage compackDp = compack.doQuery(compackDBParam);
				if (null == compackDp || compackDp.getDatas().size() == 0) {
					throw new WebSiteException("������ʱ��Ԥ����Դ���ͷ�",RetResult.FAILURE);
				}
				CompackVO compackVO = (CompackVO)compackDp.getDatas().get(0);
				
				if(storea == null){//���򣬼�¼��Ʒ��Դ������ֻ��¼һ�Σ�����������
					storea = compackVO.getStorarea();
				}
				
				compackVO.setPackstate("10");
				compack.doUpdate(compackVO);
				OrderpackdetVO orderpackdetVO = new OrderpackdetVO();
				orderpackdetVO.setOrderid(orderid);
				orderpackdetVO.setBatchno(comordervo.getBatchNo());
				orderpackdetVO.setBoxnum(comordervo.getPackageNo());
				orderpackdetVO.setComcategory(comordervo.getComType());
				orderpackdet.doCreate(orderpackdetVO);
				
				ComressmpDBParam comressmpDBParam = new ComressmpDBParam();
				comressmpDBParam.set_se_batchno(comordervo.getBatchNo());
				comressmpDBParam.set_se_boxnum(comordervo.getPackageNo());
				comressmpDBParam.set_pagesize(""+comordervo.getOrderCount());
				DataPackage comressmpDp = comressmp.doQuery(comressmpDBParam);
				if (null == comressmpDp || comressmpDp.getDatas().size() == 0) {
					
				}else{
					for(Iterator itt = comressmpDp.getDatas().iterator(); itt.hasNext();){
						ComressmpVO comressmpVO = (ComressmpVO)itt.next();
						comressmpVO.setComstate((short)10);
						comressmp.doUpdate(comressmpVO);
						
						OrderresdetVO orderresdetVO = new OrderresdetVO();
						orderresdetVO.setOrderid(orderid);
						orderresdetVO.setOrdercomtype("CUSTORDER");
						orderresdetVO.setComcategory(comordervo.getComType());
						orderresdetVO.setRestype("COMRESSMP");
						BeanUtils.copyProperties(orderresdetVO, comressmpVO);
						
						if(orderresdetVO.getComid()!=null){
							//��Ʒԭ��:������Ʒ��ʶ��ѯ��Ʒ���ݱ�IM_PR_COM����ȡ��Ʒԭ��
							Com com=(Com)BOFactory.build(ComBO.class, user);
							Ordercomcate orderComcate=(Ordercomcate)BOFactory.build(OrdercomcateBO.class, user);
							ComVO comVO=com.doFindByPk(comressmpVO.getComid());
							if(comVO!=null && comVO.getComprice()!=null)
							{
								//����Ʒ���۴ӷ�ת��ΪԪ
								long price=comVO.getComprice().longValue()/100;
								orderresdetVO.setComprice(new Double(""+price));
							}
							/*//ʵ���ۼ�:���ݶ�����š�������Ʒ���ͺ���Ʒ�����ѯ������Ʒ�����
							OrdercomcateDBParam param=new OrdercomcateDBParam();
							param.set_se_orderid(orderresdetVO.getOrderid());
							param.set_se_ordercomtype(orderresdetVO.getOrdercomtype());
							param.set_se_comcategory(orderresdetVO.getComcategory());
							DataPackage dp=orderComcate.doQuery(param);
							if(dp.getRowCount()>0)
							{
								OrdercomcateVO vo=(OrdercomcateVO)(dp.toList(OrdercomcateVO.class)).get(0);
								if(vo!=null && vo.getUnitprice()!=null)
								{
									orderresdetVO.setActprice(vo.getUnitprice());
								}
							}*/
							Comorder comorder = (Comorder)BOFactory.build(ComorderBO.class, user);
							Double price = comorder.doGetUnitprice(wayid, comordervo.getComType());
							orderresdetVO.setActprice(price);
						}
						
						orderresdet.doCreate(orderresdetVO);
						residList.add(String.valueOf(orderresdetVO.getComresid()));//��¼������ϸID
					}
					if(map.get(comordervo.getComType()) == null){
						map.put(comordervo.getComType(), new Long(comressmpDp.getDatas().size()));
					}else{
						map.put(comordervo.getComType(), map.get(comordervo.getComType())+comressmpDp.getDatas().size());
					}
				}
			}
		}
		
		List<ComOrder> list = new ArrayList<ComOrder>(); //�������СҶ�Ǳߵ��߼�
		for(Iterator<String> itt = map.keySet().iterator(); itt.hasNext();){
			ComOrder vo = new ComOrder();
			String comtype = itt.next();
			vo.setComType(comtype);
			vo.setOrderCount(map.get(comtype).intValue());
			list.add(vo);
		}
		
		List<ComorderVO> orderList = doBuildComorderList(wayid, list).getComorderList();
		handle.setComorderList(orderList);
		handle.setResidList(residList);
		handle.setStorea(storea);
		return handle;
	}
	
	
	/**
	 * isQueryDetailΪfalseʱ,����Ҫ������Դ��ȡ,��Ҫ��������ComOrderList
	 * @param wayid
	 * @param derLicomOrderListst
	 * @return
	 * @throws Exception
	 */
	private ComOrderCommitHandle doBuildComorderList(String wayid,List<ComOrder> comOrderList) throws Exception{
		ComOrderCommitHandle commitHandle = new ComOrderCommitHandle();
		
		List<ComorderVO> list = new ArrayList<ComorderVO>();
		Way way = (Way)BOFactory.build(WayBO.class, user);
		WayVO wayvo = way.doFindByPk(wayid);
		Comorder comorder = (Comorder)BOFactory.build(ComorderBO.class, user);
		for(ComOrder vo : comOrderList){
			ComorderVO orderVO = new ComorderVO();
			orderVO.setComcategory(vo.getComType());
			Double price = comorder.doGetUnitprice(wayid, vo.getComType());
			orderVO.setUnitprice(price);
			String age = comorder.doGetUnitage(user.getCityid(), vo.getComType());
			if(Long.parseLong(age) > vo.getOrderCount()){
				orderVO.setOrderamount(Long.parseLong(age));
				orderVO.setTotalprice(price * Long.parseLong(age));
			}else{
				orderVO.setOrderamount((long)vo.getOrderCount());
				orderVO.setTotalprice(price * (long)vo.getOrderCount());
			}
			list.add(orderVO);
		}
		
		commitHandle.setComorderList(list);
		commitHandle.setStorea(comorder.doGetStorArea(wayvo));
		return commitHandle;
	}
	
	/**
	 * isQueryDetailΪtrueʱ,�ӿڲ���ֻ����Ʒ����,���κ�,����
	 * @param wayid ����ID
	 * @comOrderList 
	 * @throws Exception
	 */
	private void doPromotionalTieins(String wayid,List<ComorderVO> comOrderList,List<String> residList) throws Exception{
		Way way = (Way) BOFactory.build(WayBO.class, user);
		WayVO wayvo = way.doFindByPk(wayid);
		
		Comcategoryrela comcategoryrela = (Comcategoryrela)BOFactory.build(ComcategoryrelaBO.class,user);
		Orderresdet orderresdet = (Orderresdet)BOFactory.build(OrderresdetBO.class, user);
		//����/������Դ��ȡ
		OrderVO ordervo = new OrderVO();
		ordervo.setOrderid(orderid);
		ordervo.setWayid(wayvo.getWayid());
		ordervo.setCountyid(wayvo.getCountyid());
		ordervo.setCooptype(wayvo.getCusttype());
		
		//������Դ�Ƿ����������
		Sysparam sysparam = (Sysparam) BOFactory.build(SysparamBO.class, user);
		String sysparamvalue21=sysparam.doFindByID("21", "pboss_fx");
		if(StringUtils.isEmpty(sysparamvalue21)){
			throw new WebSiteException("������Դ�Ƿ���������̲���δ����",RetResult.FAILURE);
		}
		//�Ƿ��޶��ֹ�˾��Դ
		String sysparamvalue38=sysparam.doFindByID("38", "pboss_fx");
		if(StringUtils.isEmpty(sysparamvalue38)){
			throw new SaleException("SALE-201005");
		}
		//�����׿�Ʒ�ư���С
		String sysparamvalue5=sysparam.doFindByID("5", "pboss_fx");
		if(StringUtils.isEmpty(sysparamvalue5)){
			throw new WebSiteException("�׿�Ʒ�ư���С����δ����",RetResult.FAILURE);
		}
		String[] values= StringUtils.splitPreserveAllTokens(sysparamvalue5, "|");
		Map<String,Long> brandMap=new HashMap<String,Long>();
		String[] vals=null;
		for(String val:values){
			if(!"".equals(val)){
				vals=StringUtils.split(val, ":");
				brandMap.put(vals[0],Long.valueOf(vals[1]));
			}
		}
		
		Spproposal spproposal = (Spproposal)BOFactory.build(SpproposalBO.class, user);
		//��������--����
		List<TiedComInfo> tiedComInfos=null;
		List<ComcategoryrelaVO> comcategList=null;//��Ʒ��Ϲ�ϵ��ѯ����
		String message = null;
		for (ComorderVO comorderVO : comOrderList) {
			ComcategoryrelaDBParam comcategoryrelaDBParam = new ComcategoryrelaDBParam();
			comcategoryrelaDBParam.set_se_comcategory(comorderVO.getComcategory());
			comcategList = comcategoryrela.doQuery(comcategoryrelaDBParam).getDatas();//��Ʒ����
			for(ComcategoryrelaVO comcateg:comcategList){
				if("COMRESCARD".equals(comcateg.getRestype())){
					tiedComInfos=spproposal.doTieInSale(wayvo.getWayid(), comorderVO.getComcategory(), residList);
					//��������--����
					if(tiedComInfos!=null && tiedComInfos.size()>0){
						message=orderresdet.doTiedComResdraw(tiedComInfos, "SYSTIEIN", brandMap, sysparamvalue21,sysparamvalue38, ordervo, comcateg, false);
						if(!"".equals(message))
							throw new WebSiteException(message,RetResult.FAILURE);
					}
					//��������--����
					tiedComInfos=spproposal.doPresentingB(ordervo.getWayid(), comcateg.getComcategory(), residList);
					if(tiedComInfos!=null && tiedComInfos.size()>0){
						message=orderresdet.doTiedComResdraw(tiedComInfos, "SYSTIEIN", brandMap, sysparamvalue21,sysparamvalue38, ordervo, comcateg, false);
						if(!"".equals(message))
							throw new WebSiteException(message,RetResult.FAILURE);
					}
				}else if("COMRESSMP".equals(comcateg.getRestype())){
					//��������--����
					tiedComInfos=spproposal.doTieInSale(ordervo.getWayid(), comcateg.getComcategory(), residList);
					if(tiedComInfos!=null && tiedComInfos.size()>0){
						message=orderresdet.doTiedComResdraw(tiedComInfos, "SYSTIEIN", brandMap, sysparamvalue21, sysparamvalue38,ordervo, comcateg, false);
						if(!"".equals(message))
							throw new WebSiteException(message,RetResult.FAILURE);
					}
					//��������--����
					tiedComInfos=spproposal.doPresentingB(ordervo.getWayid(), comcateg.getComcategory(), residList);
					if(tiedComInfos!=null && tiedComInfos.size()>0){
						message=orderresdet.doTiedComResdraw(tiedComInfos, "SYSTIEIN", brandMap, sysparamvalue21,sysparamvalue38, ordervo, comcateg, false);
						if(!"".equals(message))
							throw new WebSiteException(message,RetResult.FAILURE);
					}
				}
			}
		}
	}
	

	
	/**
	 * ��Ʒ�������
	 * ������ʹ��Щ���� 
	 * �������:com.gmcc.pboss.control.sales.comorder.ComorderBO.comOrderCheck()����
	 */
//	@Deprecated
//	private Set<String> doComOrderCheck(String wayid,List<ComorderVO> comOrderList,String storarea, String mode) throws Exception {
//		Way way = (Way) BOFactory.build(WayBO.class, user);
//		WayVO wayvo = way.doFindByPk(wayid);
//		
//		ComorderBO comorder = (ComorderBO) BOFactory.build(ComorderBO.class,user);
//		List<DictitemVO> brandlist = comorder.doGetBrandList(wayid);
//		
//		ComorderCheck comorderCheck = (ComorderCheck)BOFactory.build(ComorderCheckBO.class, user);
//		// ���ȶԶ���ʱ�ν��м��
//		comorderCheck.checkLimitTime(wayvo);
//		// Ȼ�����붩����鸨����Ϣ
//		ComorderCheckHandle handle = comorderCheck.getHelpHandle(wayvo,brandlist, mode);
//		
//		for (ComorderVO comordervo : comOrderList) {
//			int i = START;
//			ComcategoryrelaVO comcategoryrelavo = null;
//			while(i != EXIT){
//				switch(i){
//					case 1: // 1) ��Ʒ���ඩ���������
//						comorderCheck.checkComcategoryUnitageMod(comordervo.getComcategory(),comordervo.getOrderamount());
//						i += NEXT;
//						break;
//					case 2: // 2) ��Ʒ���ඩ��״̬���
//						comorderCheck.checkComcategoryState(comordervo.getComcategory());
//						i += NEXT;
//						break;
//					case 3: // 3) ��Ʒ�����Ƿ��׿�
//						comcategoryrelavo = comorderCheck.checkIsComressmp(comordervo.getComcategory());
//						if (comcategoryrelavo != null && comcategoryrelavo.getRestype().equals("COMRESSMP")) {
//							i += NEXT;
//						}else{
//							i = EXIT;
//						}
//						break;
//					case 4: //�׿������ʼ�飨����Ʒ��/������Ʒ�ƣ�
//						comorderCheck.checkActiverate(comorderCheck.getBrand(comordervo.getComcategory()), wayvo);
//						i += NEXT;
//						break;
//					case 5: //��5��Ҫ�õ�������,�����Ȼ�ȡ������
//						if(comorderCheck.checkBaseAmount(comorderCheck.getBrand(comordervo.getComcategory()), comordervo.getOrderamount(), storarea, wayvo)){
//							i = EXIT;
//						}else{
//							i += NEXT;
//						}
//						break;
//					case 6: // 6) ���¿ɶ�������� 7)  ��/�¶��������޼��  9) �ۼӶ�����  ���кϲ�
//						comorderCheck.checkOrderedmonthAndLimitCheck(comorderCheck.getBrand(comordervo.getComcategory()), comordervo.getOrderamount(), wayvo, mode);
//						i += NEXT;
//						break;
//					case 7: // 8) ��׼������޼��
//						comorderCheck.checkOrderedNowstock(comorderCheck.getBrand(comordervo.getComcategory()), comordervo.getOrderamount(), wayvo, mode);
//						i += NEXT;
//						break;
//					case 8: //  Ԥ�������
//						comorderCheck.checkOrderedStockalarm(comorderCheck.getBrand(comordervo.getComcategory()), comordervo.getOrderamount(), wayvo, mode);
//						i = EXIT;
//						break;
//				}
//			}
//		}
//		return handle.getBrandSet();
//	}
	
	/**
	 * �齨����
	 * @param wayid
	 * @param comOrderList
	 * @throws Exception
	 */
	private void doBuildOrder(String wayid,List<ComorderVO> comOrderList, Set<String> dSetbrandSet) throws Exception {
		Comorder comorder = (Comorder)BOFactory.build(ComorderBO.class, user);
		WayVO wayvo = comorder.doCheckWay(wayid);
		for (int i = 0; i < comOrderList.size(); i++) {
			Map map = comorder.doGetUnitpriceAndPlancode(wayid, comOrderList.get(i).getComcategory());
			String planCode = (String)map.get("planCode");
			comOrderList.get(i).setPlanCode(planCode);
			String unitpriceString = (String)map.get("unitprice");
			Double unitprice = 0D;
			if(unitpriceString != null && !"".equals(unitpriceString)){
				unitprice = Double.parseDouble(unitpriceString);
			}
			comOrderList.get(i).setUnitprice(unitprice);
		}
		comorder.doBuildOrder(orderid, wayvo, comorder.doGetStorArea(wayvo), comOrderList,dSetbrandSet,ComorderConstant.ORDERAVE_WEB,null);
	}
	
	/**
	 * ���ö�����һ������������
	 * @param orderid
	 * @throws Exception
	 */
	private void doUpdateNextProcess() throws Exception{
		Order order = (Order)BOFactory.build(OrderBO.class, user);
		order.doNextProcess(orderid);
		// TODO Auto-generated method stub
	}
	
	private RetResult doReturnSuccVal() throws Exception{
		RetResult result = new RetResult();
		result.setRetCode(RetResult.SUCCESS);
		result.setMessage(orderid);
		return result;
	}
	
	public RetResult doCheck(String wayid, boolean isQueryDetail,List<ComOrder> comOrderList) throws Exception{
		/*
		Session session = SessionUtils.currentSession(user.getCityid());
		// ��ȡ��ǰflush ģʽ
		FlushMode preMode = session.getFlushMode();
		
		// ���ڴ��������п��ܶ�ͬһ����(��־û�����)���С����º��ٲ�ѯ�����������־û�����ı��
		// Hibernate���ö����־Ϊ������(�������ݿⲻͬ����),��flushģʽΪĬ�ϵ�AUTOʱ��
		// Hibernate�ڽ��в�ѯ֮ǰ���жϻ����еĳ־û������Ƿ������ݣ�����ͬ��(flush)�����ݿ⣬����
		// ��ͬ�����ݿ⡣
		// ��ͬ�������ݿ⣬���ѯ�������������û��ʵ���ύ�������ݡ�
		
		// ����ǰsession��flushģʽ��AUTO���ó�MANUAL����ֹHibernate�Զ�ͬ�����ݿ⣬��Ϊ�ֹ�flush
		session.setFlushMode(FlushMode.MANUAL);
		*/
		try{
			doBasicQualification(wayid);
			doSetOrderId();
			
			ComOrderCommitHandle commitHandle = null; //������
			
			//isQueryDetail�齨��ͬ�Ķ����б�
			if(isQueryDetail){
				commitHandle = doBuildComorderListWithResourcePick(wayid, comOrderList); 
			}else{
				commitHandle = doBuildComorderList(wayid, comOrderList);
			}
			
			// �׿�������Ϣ����ģʽ
			Comorder comorder = (Comorder)BOFactory.build(ComorderBO.class, user);
			String mode = comorder.doGetOrderMode();
			//�������
			Comorder comorderBO = (Comorder)BOFactory.build(ComorderBO.class,user);
			
			Set<String> brandSet = comorderBO.comOrderCheck(wayid,commitHandle.getComorderList(),commitHandle.getStorea());
			//�齨����
			doBuildOrder(wayid,commitHandle.getComorderList(), brandSet);
			
			
			if(isQueryDetail){
				doCreateDisform();//�������͵�
				doPromotionalTieins(wayid,commitHandle.getComorderList(),commitHandle.getResidList());//���۴���
			}
			
			try{
				//���ö�����һ������������,�������κ��쳣����
				doUpdateNextProcess();
			}catch (Exception e) {
				
			}
			/*
			// �������ύ֮ǰ��ʽ����flush
			session.flush();
			// ��session��flushģʽ����ΪAUTO
			session.setFlushMode(preMode);
			*/
			return doReturnSuccVal();
		}catch (SaleException e) {
			throw e;
		}
		catch (Exception e) {
			throw new JOPException(e);
		}
	}
	private void doCreateDisform() throws Exception{
		Order order = (Order)BOFactory.build(OrderBO.class, user);
		OrderVO orderVO=order.doFindByPk(orderid);
		if(orderVO!=null){
			/*
			 * �������ݵ�������Դ���͵���FX_SW_DISFORM��
			 */
			Disform disformBO = (DisformBO)BOFactory.build(DisformBO.class,user);
			DisformVO disformVO = new DisformVO();
			disformVO.setOrderid(orderVO.getOrderid());//�������
			disformVO.setRecewayid(orderVO.getWayid());//�ջ�����ȡ�����̱���
			Way wayBO = (WayBO)BOFactory.build(WayBO.class,user);
			WayVO wayVO = wayBO.doFindByPk(orderVO.getWayid());
			disformVO.setDiscomcode(wayVO.getLogiscode() == null ?" ":wayVO.getLogiscode());
			//���ݺ����̱����ѯ�������������ϱ�
			Cooperator cooperatorBO = (Cooperator)BOFactory.build(CooperatorBO.class,user);
			CooperatorVO cooperatorVO=cooperatorBO.doFindByPk(orderVO.getWayid());
			
			if(cooperatorVO!=null){
				disformVO.setReceadd(cooperatorVO.getSendaddr()==null?" ":cooperatorVO.getSendaddr());//��ȡ�ջ��˵�ַ�����ͻ���ַ��
				disformVO.setRecename(cooperatorVO.getRecpers()==null?" ":cooperatorVO.getRecpers());//�ջ������������ջ���ϵ��
				disformVO.setRecetel(cooperatorVO.getRecconntel()==null?" ":cooperatorVO.getRecconntel());//�ջ��˵绰�����ջ���ϵ���룩
			}else{
				disformVO.setReceadd(" ");//����
				disformVO.setRecename(" ");//����
				disformVO.setRecetel(" ");//����
			}
			//����ʱ��ȡ��ǰʱ�䣬Ҫ���ʹ�ʱ��ȡ��ǰʱ���48Сʱ�����͵�״̬ȡ����������ע�������˺ͷ���ʱ������
			Calendar calenDar = Calendar.getInstance();
			disformVO.setCreatetime(calenDar.getTime());
			calenDar.add(Calendar.HOUR, 48);
			disformVO.setArrivetime(calenDar.getTime());
			disformVO.setDisstate("WAITOUT");//���͵�״̬ȡ������
			disformBO.doCreate(disformVO);
		}
	}

}
