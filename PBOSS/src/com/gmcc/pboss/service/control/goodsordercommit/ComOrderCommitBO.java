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
	
	public static final int EXIT = -1; //退出
	public static final int START = 1; //开始
	public static final int NEXT = 1; //下一步
	
	private String orderid; //从头走到尾的订单号
	
	//step1
	private void doBasicQualification(String wayid) throws Exception{
		Way way = (Way) BOFactory.build(WayBO.class, user);
		WayDBParam params = new WayDBParam();
		params.set_se_wayid(wayid);
		params.set_se_waytype("AG");
		DataPackage dp = way.doQuery(params);
		if(dp.getDatas() == null || dp.getDatas().size() == 0){
			throw new WebSiteException("该合作商["+wayid+"]基本信息不存在",RetResult.FAILURE);
		}
		user.setCityid(((WayVO)dp.getDatas().get(0)).getCityid());
	}
	//step2
	private void doSetOrderId() throws Exception{
		Comorder comorder = (Comorder)BOFactory.build(ComorderBO.class, user);
		orderid = comorder.doGetOrderId();
	}
	
	/**
	 * isQueryDetail为true时,需要进行资源抽取,主要用于重组ComOrderList
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
		
		Map<String,Long> map = new HashMap<String,Long>(); //累计商品种类和订购数量
		List<String> residList = new ArrayList<String>();
		String storea = null;
		
		for (ComOrder comordervo : comOrderList) {
			//获取资源类别
			ComcategoryrelaVO comcategoryrelavo = comorderCheck.checkIsComressmp(comordervo.getComType());
			if("COMRESCARD".equals(comcategoryrelavo.getRestype())){//充值卡资源抽取
				
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
				List<Object[]> comrescardList=comrescard.doQueryByComcategory(comrescardDBParam, comordervo.getComType(),null,null,null).getDatas();//充值卡资源查询集合
				if (null == comrescardList || comrescardList.size() == 0) {
					throw new WebSiteException("商品资源["+comordervo.getComType()+"]已售完",RetResult.FAILURE);
				}else if(comrescardList.size() != comordervo.getOrderCount()){
					throw new WebSiteException("商品资源["+comordervo.getComType()+"]库存不足",RetResult.FAILURE);
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
						residList.add(String.valueOf(orderresdetVO.getDetid()));//记录订单明细ID
					}*/
					ComrescardVO comrescardVO=null;//充值卡VO
					OrderresdetVO orderresdetVO=null;//订单资源明细VO
					Com com=(Com)BOFactory.build(ComBO.class, user);
					Ordercomcate orderComcate=(Ordercomcate)BOFactory.build(OrdercomcateBO.class, user);
					for(Object[] objArray:comrescardList){
						comrescardVO=(ComrescardVO)objArray[1];//充值卡
						//修改充值卡资源状态为抽取态
						comrescardVO.setComstate((short)10);
						comrescard.doUpdate(comrescardVO);
						orderresdetVO=new OrderresdetVO();
						orderresdetVO.setOrderid(orderid);//订单编号
						orderresdetVO.setOrdercomtype("CUSTORDER");//订单商品类型
						orderresdetVO.setComcategory(comordervo.getComType());//商品种类
						orderresdetVO.setRestype("COMRESCARD");//资源类别
						orderresdetVO.setComid(comrescardVO.getComid());
						orderresdetVO.setComresid(comrescardVO.getComresid());//商品资源编号
						orderresdetVO.setBatchno(comrescardVO.getBatchno());//批次
						orderresdetVO.setWayid(comrescardVO.getWayid());//渠道ID
						orderresdetVO.setBrand((String)objArray[0]);
						if(orderresdetVO.getComid()!=null){
						//商品原价:根据商品标识查询商品数据表（IM_PR_COM）获取商品原价
						ComVO comVO=com.doFindByPk(comrescardVO.getComid());
						if(comVO!=null && comVO.getComprice()!=null)
						{
							//将商品单价从分转化为元
							long price=comVO.getComprice().longValue()/100;
							orderresdetVO.setComprice(new Double(""+price));
						}
						/*//实际售价:根据订单编号、订单商品类型和商品种类查询订单商品种类表
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
						residList.add(String.valueOf(comrescardVO.getComresid()));//记录资源ID（商品标识，手机号码）
					}
					if(map.get(comordervo.getComType()) == null){
						map.put(comordervo.getComType(), new Long(comordervo.getOrderCount()));
					}else{
						map.put(comordervo.getComType(), map.get(comordervo.getComType())+comordervo.getOrderCount());
					}
				}
			}else if("COMRESSMP".equals(comcategoryrelavo.getRestype())){//套卡资源
				CompackDBParam compackDBParam = new CompackDBParam();
				compackDBParam.set_se_batchno(comordervo.getBatchNo());
				compackDBParam.set_se_boxnum(comordervo.getPackageNo());
				compackDBParam.set_se_packstate("5");
				DataPackage compackDp = compack.doQuery(compackDBParam);
				if (null == compackDp || compackDp.getDatas().size() == 0) {
					throw new WebSiteException("操作超时，预定资源已释放",RetResult.FAILURE);
				}
				CompackVO compackVO = (CompackVO)compackDp.getDatas().get(0);
				
				if(storea == null){//否则，记录商品资源库区（只记录一次），并继续。
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
							//商品原价:根据商品标识查询商品数据表（IM_PR_COM）获取商品原价
							Com com=(Com)BOFactory.build(ComBO.class, user);
							Ordercomcate orderComcate=(Ordercomcate)BOFactory.build(OrdercomcateBO.class, user);
							ComVO comVO=com.doFindByPk(comressmpVO.getComid());
							if(comVO!=null && comVO.getComprice()!=null)
							{
								//将商品单价从分转化为元
								long price=comVO.getComprice().longValue()/100;
								orderresdetVO.setComprice(new Double(""+price));
							}
							/*//实际售价:根据订单编号、订单商品类型和商品种类查询订单商品种类表
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
						residList.add(String.valueOf(orderresdetVO.getComresid()));//记录订单明细ID
					}
					if(map.get(comordervo.getComType()) == null){
						map.put(comordervo.getComType(), new Long(comressmpDp.getDatas().size()));
					}else{
						map.put(comordervo.getComType(), map.get(comordervo.getComType())+comressmpDp.getDatas().size());
					}
				}
			}
		}
		
		List<ComOrder> list = new ArrayList<ComOrder>(); //适用杨捷小叶那边的逻辑
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
	 * isQueryDetail为false时,不需要进行资源抽取,主要用于重组ComOrderList
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
	 * isQueryDetail为true时,接口参数只有商品种类,批次号,包号
	 * @param wayid 渠道ID
	 * @comOrderList 
	 * @throws Exception
	 */
	private void doPromotionalTieins(String wayid,List<ComorderVO> comOrderList,List<String> residList) throws Exception{
		Way way = (Way) BOFactory.build(WayBO.class, user);
		WayVO wayvo = way.doFindByPk(wayid);
		
		Comcategoryrela comcategoryrela = (Comcategoryrela)BOFactory.build(ComcategoryrelaBO.class,user);
		Orderresdet orderresdet = (Orderresdet)BOFactory.build(OrderresdetBO.class, user);
		//搭售/赠送资源抽取
		OrderVO ordervo = new OrderVO();
		ordervo.setOrderid(orderid);
		ordervo.setWayid(wayvo.getWayid());
		ordervo.setCountyid(wayvo.getCountyid());
		ordervo.setCooptype(wayvo.getCusttype());
		
		//订购资源是否管理配送商
		Sysparam sysparam = (Sysparam) BOFactory.build(SysparamBO.class, user);
		String sysparamvalue21=sysparam.doFindByID("21", "pboss_fx");
		if(StringUtils.isEmpty(sysparamvalue21)){
			throw new WebSiteException("订购资源是否关联配送商参数未设置",RetResult.FAILURE);
		}
		//是否限定分公司资源
		String sysparamvalue38=sysparam.doFindByID("38", "pboss_fx");
		if(StringUtils.isEmpty(sysparamvalue38)){
			throw new SaleException("SALE-201005");
		}
		//载入套卡品牌包大小
		String sysparamvalue5=sysparam.doFindByID("5", "pboss_fx");
		if(StringUtils.isEmpty(sysparamvalue5)){
			throw new WebSiteException("套卡品牌包大小参数未设置",RetResult.FAILURE);
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
		//促销方案--搭售
		List<TiedComInfo> tiedComInfos=null;
		List<ComcategoryrelaVO> comcategList=null;//商品组合关系查询集合
		String message = null;
		for (ComorderVO comorderVO : comOrderList) {
			ComcategoryrelaDBParam comcategoryrelaDBParam = new ComcategoryrelaDBParam();
			comcategoryrelaDBParam.set_se_comcategory(comorderVO.getComcategory());
			comcategList = comcategoryrela.doQuery(comcategoryrelaDBParam).getDatas();//商品种类
			for(ComcategoryrelaVO comcateg:comcategList){
				if("COMRESCARD".equals(comcateg.getRestype())){
					tiedComInfos=spproposal.doTieInSale(wayvo.getWayid(), comorderVO.getComcategory(), residList);
					//促销方案--搭售
					if(tiedComInfos!=null && tiedComInfos.size()>0){
						message=orderresdet.doTiedComResdraw(tiedComInfos, "SYSTIEIN", brandMap, sysparamvalue21,sysparamvalue38, ordervo, comcateg, false);
						if(!"".equals(message))
							throw new WebSiteException(message,RetResult.FAILURE);
					}
					//促销方案--赠送
					tiedComInfos=spproposal.doPresentingB(ordervo.getWayid(), comcateg.getComcategory(), residList);
					if(tiedComInfos!=null && tiedComInfos.size()>0){
						message=orderresdet.doTiedComResdraw(tiedComInfos, "SYSTIEIN", brandMap, sysparamvalue21,sysparamvalue38, ordervo, comcateg, false);
						if(!"".equals(message))
							throw new WebSiteException(message,RetResult.FAILURE);
					}
				}else if("COMRESSMP".equals(comcateg.getRestype())){
					//促销方案--搭售
					tiedComInfos=spproposal.doTieInSale(ordervo.getWayid(), comcateg.getComcategory(), residList);
					if(tiedComInfos!=null && tiedComInfos.size()>0){
						message=orderresdet.doTiedComResdraw(tiedComInfos, "SYSTIEIN", brandMap, sysparamvalue21, sysparamvalue38,ordervo, comcateg, false);
						if(!"".equals(message))
							throw new WebSiteException(message,RetResult.FAILURE);
					}
					//促销方案--赠送
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
	 * 商品订购检查
	 * 不建议使用些方法 
	 * 替代方法:com.gmcc.pboss.control.sales.comorder.ComorderBO.comOrderCheck()方法
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
//		// 首先对订购时段进行检查
//		comorderCheck.checkLimitTime(wayvo);
//		// 然后，载入订购检查辅助信息
//		ComorderCheckHandle handle = comorderCheck.getHelpHandle(wayvo,brandlist, mode);
//		
//		for (ComorderVO comordervo : comOrderList) {
//			int i = START;
//			ComcategoryrelaVO comcategoryrelavo = null;
//			while(i != EXIT){
//				switch(i){
//					case 1: // 1) 商品种类订购基数检查
//						comorderCheck.checkComcategoryUnitageMod(comordervo.getComcategory(),comordervo.getOrderamount());
//						i += NEXT;
//						break;
//					case 2: // 2) 商品种类订购状态检查
//						comorderCheck.checkComcategoryState(comordervo.getComcategory());
//						i += NEXT;
//						break;
//					case 3: // 3) 商品种类是否套卡
//						comcategoryrelavo = comorderCheck.checkIsComressmp(comordervo.getComcategory());
//						if (comcategoryrelavo != null && comcategoryrelavo.getRestype().equals("COMRESSMP")) {
//							i += NEXT;
//						}else{
//							i = EXIT;
//						}
//						break;
//					case 4: //套卡激活率检查（区分品牌/不区分品牌）
//						comorderCheck.checkActiverate(comorderCheck.getBrand(comordervo.getComcategory()), wayvo);
//						i += NEXT;
//						break;
//					case 5: //第5步要用到保底量,这里先获取保底量
//						if(comorderCheck.checkBaseAmount(comorderCheck.getBrand(comordervo.getComcategory()), comordervo.getOrderamount(), storarea, wayvo)){
//							i = EXIT;
//						}else{
//							i += NEXT;
//						}
//						break;
//					case 6: // 6) 当月可订购量检查 7)  日/月订购量上限检查  9) 累加订购量  进行合并
//						comorderCheck.checkOrderedmonthAndLimitCheck(comorderCheck.getBrand(comordervo.getComcategory()), comordervo.getOrderamount(), wayvo, mode);
//						i += NEXT;
//						break;
//					case 7: // 8) 基准库存上限检查
//						comorderCheck.checkOrderedNowstock(comorderCheck.getBrand(comordervo.getComcategory()), comordervo.getOrderamount(), wayvo, mode);
//						i += NEXT;
//						break;
//					case 8: //  预警库存检查
//						comorderCheck.checkOrderedStockalarm(comorderCheck.getBrand(comordervo.getComcategory()), comordervo.getOrderamount(), wayvo, mode);
//						i = EXIT;
//						break;
//				}
//			}
//		}
//		return handle.getBrandSet();
//	}
	
	/**
	 * 组建订单
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
	 * 调用订单下一步处理公共方法
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
		// 获取当前flush 模式
		FlushMode preMode = session.getFlushMode();
		
		// 由于此事务中有可能对同一个表(或持久化对象)进行“更新后再查询”操作，当持久化对象改变后，
		// Hibernate将该对象标志为脏数据(即与数据库不同步了),当flush模式为默认的AUTO时，
		// Hibernate在进行查询之前会判断缓存中的持久化对象是否脏数据，是则同步(flush)到数据库，不是
		// 则不同步数据库。
		// 若同步到数据库，则查询操作将会读到还没有实际提交的脏数据。
		
		// 将当前session的flush模式由AUTO设置成MANUAL，禁止Hibernate自动同步数据库，改为手工flush
		session.setFlushMode(FlushMode.MANUAL);
		*/
		try{
			doBasicQualification(wayid);
			doSetOrderId();
			
			ComOrderCommitHandle commitHandle = null; //辅助类
			
			//isQueryDetail组建不同的订购列表
			if(isQueryDetail){
				commitHandle = doBuildComorderListWithResourcePick(wayid, comOrderList); 
			}else{
				commitHandle = doBuildComorderList(wayid, comOrderList);
			}
			
			// 套卡订购信息采用模式
			Comorder comorder = (Comorder)BOFactory.build(ComorderBO.class, user);
			String mode = comorder.doGetOrderMode();
			//订购检查
			Comorder comorderBO = (Comorder)BOFactory.build(ComorderBO.class,user);
			
			Set<String> brandSet = comorderBO.comOrderCheck(wayid,commitHandle.getComorderList(),commitHandle.getStorea());
			//组建订单
			doBuildOrder(wayid,commitHandle.getComorderList(), brandSet);
			
			
			if(isQueryDetail){
				doCreateDisform();//新增配送单
				doPromotionalTieins(wayid,commitHandle.getComorderList(),commitHandle.getResidList());//搭售促销
			}
			
			try{
				//调用订单下一步处理公共方法,报错不做任何异常操作
				doUpdateNextProcess();
			}catch (Exception e) {
				
			}
			/*
			// 本事务提交之前显式调用flush
			session.flush();
			// 将session的flush模式重置为AUTO
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
			 * 新增数据到分销资源配送单（FX_SW_DISFORM）
			 */
			Disform disformBO = (DisformBO)BOFactory.build(DisformBO.class,user);
			DisformVO disformVO = new DisformVO();
			disformVO.setOrderid(orderVO.getOrderid());//订单编号
			disformVO.setRecewayid(orderVO.getWayid());//收货网点取合作商编码
			Way wayBO = (WayBO)BOFactory.build(WayBO.class,user);
			WayVO wayVO = wayBO.doFindByPk(orderVO.getWayid());
			disformVO.setDiscomcode(wayVO.getLogiscode() == null ?" ":wayVO.getLogiscode());
			//根据合作商编码查询分销合作商资料表
			Cooperator cooperatorBO = (Cooperator)BOFactory.build(CooperatorBO.class,user);
			CooperatorVO cooperatorVO=cooperatorBO.doFindByPk(orderVO.getWayid());
			
			if(cooperatorVO!=null){
				disformVO.setReceadd(cooperatorVO.getSendaddr()==null?" ":cooperatorVO.getSendaddr());//获取收货人地址（即送货地址）
				disformVO.setRecename(cooperatorVO.getRecpers()==null?" ":cooperatorVO.getRecpers());//收货人姓名（即收货联系人
				disformVO.setRecetel(cooperatorVO.getRecconntel()==null?" ":cooperatorVO.getRecconntel());//收货人电话（即收货联系号码）
			}else{
				disformVO.setReceadd(" ");//留空
				disformVO.setRecename(" ");//留空
				disformVO.setRecetel(" ");//留空
			}
			//创建时间取当前时间，要求送达时间取当前时间加48小时，配送单状态取待发货，备注、发货人和发货时间留空
			Calendar calenDar = Calendar.getInstance();
			disformVO.setCreatetime(calenDar.getTime());
			calenDar.add(Calendar.HOUR, 48);
			disformVO.setArrivetime(calenDar.getTime());
			disformVO.setDisstate("WAITOUT");//配送单状态取待发货
			disformBO.doCreate(disformVO);
		}
	}

}
