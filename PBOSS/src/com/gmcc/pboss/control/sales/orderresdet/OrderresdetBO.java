/**
 * auto-generated code
 * Tue Oct 13 15:13:34 CST 2009
 */
package com.gmcc.pboss.control.sales.orderresdet;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.channel.cooperator.CooperatorVO;
import com.gmcc.pboss.business.channel.way.WayDBParam;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.resource.com.ComVO;
import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaDBParam;
import com.gmcc.pboss.business.resource.comcategoryrela.ComcategoryrelaVO;
import com.gmcc.pboss.business.resource.compack.CompackDAO;
import com.gmcc.pboss.business.resource.compack.CompackDBParam;
import com.gmcc.pboss.business.resource.compack.CompackVO;
import com.gmcc.pboss.business.resource.comrescard.ComrescardDBParam;
import com.gmcc.pboss.business.resource.comrescard.ComrescardVO;
import com.gmcc.pboss.business.resource.comressmp.ComressmpDBParam;
import com.gmcc.pboss.business.resource.comressmp.ComressmpVO;
import com.gmcc.pboss.business.resource.emptysim.EmptysimDBParam;
import com.gmcc.pboss.business.resource.emptysim.EmptysimVO;
import com.gmcc.pboss.business.sales.disform.DisformVO;
import com.gmcc.pboss.business.sales.extraexent.ExtraexentVO;
import com.gmcc.pboss.business.sales.order.OrderVO;
import com.gmcc.pboss.business.sales.ordercomcate.OrdercomcateDBParam;
import com.gmcc.pboss.business.sales.ordercomcate.OrdercomcateVO;
import com.gmcc.pboss.business.sales.orderpackdet.OrderpackdetVO;
import com.gmcc.pboss.business.sales.orderplan.OrderplanVO;
import com.gmcc.pboss.business.sales.orderproce.OrderproceDBParam;
import com.gmcc.pboss.business.sales.orderproce.OrderproceVO;
import com.gmcc.pboss.business.sales.orderresdet.OrderresdetDAO;
import com.gmcc.pboss.business.sales.orderresdet.OrderresdetDBParam;
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
import com.gmcc.pboss.control.resource.emptysim.Emptysim;
import com.gmcc.pboss.control.resource.emptysim.EmptysimBO;
import com.gmcc.pboss.control.sales.comorder.Comorder;
import com.gmcc.pboss.control.sales.comorder.ComorderBO;
import com.gmcc.pboss.control.sales.disform.Disform;
import com.gmcc.pboss.control.sales.disform.DisformBO;
import com.gmcc.pboss.control.sales.extraexent.Extraexent;
import com.gmcc.pboss.control.sales.extraexent.ExtraexentBO;
import com.gmcc.pboss.control.sales.order.Order;
import com.gmcc.pboss.control.sales.order.OrderBO;
import com.gmcc.pboss.control.sales.ordercomcate.Ordercomcate;
import com.gmcc.pboss.control.sales.ordercomcate.OrdercomcateBO;
import com.gmcc.pboss.control.sales.orderpackdet.Orderpackdet;
import com.gmcc.pboss.control.sales.orderpackdet.OrderpackdetBO;
import com.gmcc.pboss.control.sales.orderplan.Orderplan;
import com.gmcc.pboss.control.sales.orderplan.OrderplanBO;
import com.gmcc.pboss.control.sales.orderproce.Orderproce;
import com.gmcc.pboss.control.sales.orderproce.OrderproceBO;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.common.utils.lang.Code2NameUtils;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.exception.business.SaleException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: OrderresdetBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class OrderresdetBO extends AbstractControlBean implements
		Orderresdet {

	public OrderresdetVO doCreate(OrderresdetVO vo) throws Exception {
		try {
			OrderresdetDAO dao = (OrderresdetDAO) DAOFactory.build(OrderresdetDAO.class, user);
			// TODO set the pk */
			return (OrderresdetVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(OrderresdetVO vo) throws Exception {
		try {
			OrderresdetDAO dao = (OrderresdetDAO) DAOFactory.build(OrderresdetDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			OrderresdetDAO dao = (OrderresdetDAO) DAOFactory.build(OrderresdetDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public OrderresdetVO doUpdate(OrderresdetVO vo) throws Exception {
		try {
			OrderresdetDAO dao = (OrderresdetDAO) DAOFactory.build(OrderresdetDAO.class,user);
			return (OrderresdetVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public OrderresdetVO doFindByPk(Serializable pk) throws Exception {
		OrderresdetDAO dao = (OrderresdetDAO) DAOFactory.build(OrderresdetDAO.class,user);
		return (OrderresdetVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(OrderresdetDBParam params)
			throws Exception {
		OrderresdetDAO dao = (OrderresdetDAO) DAOFactory.build(OrderresdetDAO.class,user);
		return dao.query(params);
	}
	 /**
     * 查询按商品种类，批次，包号分组订单资源明细信息
     * @return
     * @throws Exception
     */
    public DataPackage doQueryOrderresdetGroupView(OrderresdetDBParam param) throws Exception {
    	OrderresdetDAO dao = (OrderresdetDAO) DAOFactory.build(OrderresdetDAO.class,user);
    	
		return dao.doQueryOrderresdetGroupView(param);
    }
	/**
	 * 充值卡抽取
	 * @param comcate 订单商品种类
	 * @param comcateg 商品种类关系
	 * @param paramMap 参数MAP类
	 * @param drawPara 页面指定充值卡抽取范围
	 * @return
	 * @throws Exception
	 */
	private  Map doComrescardResdraw(OrdercomcateVO comcate,ComcategoryrelaVO comcateg,String sysparamvalue38,Map<String,Object> paramMap,Map drawPara) throws Exception {
		Map<String,Object> returnMap=new HashMap<String,Object>();
		List<String> residList=new ArrayList<String>();
		Long orderamt=comcate.getOrderamt();
		String comcategory=comcate.getComcategory();
		String camcategoryName = "";//商品种类名称
		String ordercomtype=comcate.getOrdercomtype();//订单商品类型
		camcategoryName = Code2NameUtils.code2Name("$IM_FXCOMCATEGORY", comcategory, user.getCityid());
		if(paramMap!=null){//paramMap
			orderamt=(Long)paramMap.get("orderamt");
			comcategory=(String)paramMap.get("comcategory");
		}
		Comrescard comrescardBO=(Comrescard)BOFactory.build(ComrescardBO.class,user);//充值卡资源BO
		ComrescardDBParam comrescardDBParam=new ComrescardDBParam();
		comrescardDBParam.set_ne_comstate((short)1);
		comrescardDBParam.set_pagesize(String.valueOf(orderamt));
		
		comrescardDBParam.setDrawPara(drawPara);
		
		String countyid=null;//订单所属分公司
		String svccode=null;//服务营销中心
		String upperwayid=null;//上级渠道
		String mareacode=null;//微区域
		Order orderbo = (Order)BOFactory.build(OrderBO.class,user);
		OrderVO orderVO=orderbo.doFindByPk(comcate.getOrderid());
		String extraexent=null;
		if("9".equals(sysparamvalue38)){
			Extraexent extraexentBO=(Extraexent)BOFactory.build(ExtraexentBO.class,user);//分公司资源抽取BO
			ExtraexentVO extraexentVO=new ExtraexentVO();
			extraexentVO.setCityid(user.getCityid());
			extraexentVO.setCountyid(orderVO.getCountyid());
			extraexentVO=extraexentBO.doFindByPk(extraexentVO);
			if(extraexentVO==null){
				String countyname=Code2NameUtils.code2Name("#CNTYCOMPANY", orderVO.getCountyid(), user.getCityid());
				returnMap.put("message", "分公司["+countyname+"]资源抽取范围信息缺失");
				returnMap.put("errorCode","SALE-203006");
				returnMap.put("value", countyname);
				return returnMap;
			}
			extraexent=extraexentVO.getExtraexent();
				
		}
		Way way = (Way) BOFactory.build(WayBO.class, user);
		if("1".equals(sysparamvalue38)||"1".equals(extraexent)){////限定分公司资源
			countyid=orderVO.getCountyid();
			if(countyid==null || "".equals(countyid)){
				returnMap.put("message", "订单分公司信息缺失");
				returnMap.put("errorCode","SALE-203004");
				return returnMap;
			}
		}else if("2".equals(sysparamvalue38)||"2".equals(extraexent)){
			
			WayVO wayvo=way.doFindByPk(orderVO.getWayid());
			svccode=wayvo.getSvccode();
			if(svccode==null || "".equals(svccode)){
				returnMap.put("message", "合作商归属服务营销中心信息缺失");
				returnMap.put("errorCode","SALE-203002");
				return returnMap;
			}
		}else if("3".equals(sysparamvalue38)||"3".equals(extraexent)){
			WayVO wayvo=way.doFindByPk(orderVO.getWayid());
			upperwayid=wayvo.getUpperwayid();
			if(upperwayid==null || "".equals(upperwayid)){
				returnMap.put("message", "合作商上级渠道信息缺失");
				returnMap.put("errorCode","SALE-203003");
				return returnMap;
			}
			comrescardDBParam.set_se_wayid(upperwayid);
			
		}else if("4".equals(sysparamvalue38)||"4".equals(extraexent)){
			/*WayVO wayvo=way.doFindByPk(orderVO.getWayid());
			mareacode=wayvo.getMareacode();*/
			mareacode=orderVO.getMareacode();
			if(mareacode==null || "".equals(mareacode)){
				returnMap.put("message", "订单微区域信息缺失");
				returnMap.put("errorCode","SALE-203005");
				return returnMap;
			}
		}
		
		//根据地市标识、商品状态（可售）、商品种类、订购套数查询充值卡资源表（IM_FX_COMRESCARD）和商品种类组合关系表，按批次和商品资源编号升序
		List<Object[]> comrescardList=comrescardBO.doQueryByComcategory(comrescardDBParam, comcategory,countyid,svccode,mareacode).getDatas();//充值卡资源查询集合
		if(comrescardList.size()==0){
			String memo = setComcate(comrescardDBParam, comcategory);
			returnMap.put("memo", memo);
			returnMap.put("ordercomcateVO", comcate);
			
			returnMap.put("message", "商品资源["+camcategoryName+"]已售完");
			returnMap.put("errorCode","SALE-202001");
			returnMap.put("value", comcategory);
			returnMap.put("comcode", comcategory);
			return returnMap;
		}
		if(comrescardList.size()<comcate.getOrderamt()){
			String memo = setComcate(comrescardDBParam, comcategory);
			returnMap.put("memo", memo);
			returnMap.put("ordercomcateVO", comcate);
			
			returnMap.put("message", "商品资源["+camcategoryName+"]库存不足");
			returnMap.put("errorCode","SALE-202004");
			returnMap.put("value", comcategory);
			returnMap.put("comcode", comcategory);
			return returnMap;
		}
		ComrescardVO comrescardVO=null;//充值卡VO
		OrderresdetVO orderresdetVO=null;//订单资源明细VO
		Com comBO=(Com)BOFactory.build(ComBO.class,user);//商品数据BO
		ComVO comVO=null;
		for(Object[] objArray:comrescardList){
			comrescardVO=(ComrescardVO)objArray[1];//充值卡
			comVO=comBO.doFindByPk(comrescardVO.getComid());
			//修改充值卡资源状态为抽取态
			comrescardVO.setComstate((short)10);
			comrescardBO.doUpdate(comrescardVO);
			orderresdetVO=new OrderresdetVO();
			orderresdetVO.setOrderid(comcate.getOrderid());//订单编号
			orderresdetVO.setOrdercomtype(ordercomtype);//订单商品类型
			orderresdetVO.setComcategory(comcategory);//商品种类
			orderresdetVO.setRestype(comcateg.getRestype());//资源类别
			orderresdetVO.setComid(comrescardVO.getComid());
			orderresdetVO.setComresid(comrescardVO.getComresid());//商品资源编号
			orderresdetVO.setBatchno(comrescardVO.getBatchno());//批次
			orderresdetVO.setWayid(comrescardVO.getWayid());//渠道ID
			orderresdetVO.setBrand((String)objArray[0]);
			orderresdetVO.setComprice(comVO.getComprice()==null?0:comVO.getComprice()*0.01);//商品原价
			orderresdetVO.setActprice(comcate.getUnitprice());//实际售价
			this.doCreate(orderresdetVO);
			residList.add(String.valueOf(comrescardVO.getComresid()));//记录资源ID（商品标识，手机号码）
		}
		returnMap.put("residList", residList);
		return returnMap;
	}
	
	/**
	 * 前台设定抽取范围时，记录到memo中
	 * 
	 * @param comcate
	 * @param comrescardDBParam
	 * @param comcategory
	 * @throws Exception
	 */
	private String setComcate(ComrescardDBParam comrescardDBParam,String comcategory) throws Exception {
		String memo = "";
				
		Map drawPara = comrescardDBParam.getDrawPara();
		if(drawPara != null && !"".equals(drawPara)){
			if(drawPara.containsKey(comcategory)){
				List numDou = (List)drawPara.get(comcategory);
				
				for (int i = 0; i < numDou.size(); i++) {
					String[] item = (String[])numDou.get(i);
					memo = memo + item[0] + "-" + item[1] + ",";
				}				
			}
		}
		if(!"".equals(memo))
			memo = memo.substring(0, memo.length() - 1);
		
		return memo;
		
	}
	/**
	 * 空白SIM卡抽取
	 * @param comcate 订单商品种类
	 * @param comcateg 商品种类关系
	 * @param paramMap 参数MAP类
	
	 * @return
	 * @throws Exception
	 */
	private  Map doEmptysimResdraw(OrdercomcateVO comcate,ComcategoryrelaVO comcateg,String sysparamvalue38,Map<String,Object> paramMap) throws Exception {
		Map<String,Object> returnMap=new HashMap<String,Object>();
		List<String> residList=new ArrayList<String>();
		Long orderamt=comcate.getOrderamt();
		String comcategory=comcate.getComcategory();
		String camcategoryName = "";//商品种类名称
		String ordercomtype=comcate.getOrdercomtype();//订单商品类型
		camcategoryName = Code2NameUtils.code2Name("$IM_FXCOMCATEGORY", comcategory, user.getCityid());
		if(paramMap!=null){//paramMap
			orderamt=(Long)paramMap.get("orderamt");
			comcategory=(String)paramMap.get("comcategory");
		}
		Emptysim emptysimBO=(Emptysim)BOFactory.build(EmptysimBO.class,user);//充值卡资源BO
		EmptysimDBParam emptysimDBParam=new EmptysimDBParam();
		emptysimDBParam.set_ne_comid(comcateg.getComid());
		emptysimDBParam.set_ne_usestate("1");
		emptysimDBParam.set_pagesize(String.valueOf(orderamt));
		
		
		
		String countyid=null;//订单所属分公司
		String svccode=null;//服务营销中心
		String upperwayid=null;//上级渠道
		String mareacode=null;//微区域
		Order orderbo = (Order)BOFactory.build(OrderBO.class,user);
		OrderVO orderVO=orderbo.doFindByPk(comcate.getOrderid());
		String extraexent=null;
		if("9".equals(sysparamvalue38)){
			Extraexent extraexentBO=(Extraexent)BOFactory.build(ExtraexentBO.class,user);//分公司资源抽取BO
			ExtraexentVO extraexentVO=new ExtraexentVO();
			extraexentVO.setCityid(user.getCityid());
			extraexentVO.setCountyid(orderVO.getCountyid());
			extraexentVO=extraexentBO.doFindByPk(extraexentVO);
			if(extraexentVO==null){
				String countyname=Code2NameUtils.code2Name("#CNTYCOMPANY", orderVO.getCountyid(), user.getCityid());
				returnMap.put("message", "分公司["+countyname+"]资源抽取范围信息缺失");
				returnMap.put("errorCode","SALE-203006");
				returnMap.put("value", countyname);
				return returnMap;
			}
			extraexent=extraexentVO.getExtraexent();
				
		}
		Way way = (Way) BOFactory.build(WayBO.class, user);
		if("1".equals(sysparamvalue38)||"1".equals(extraexent)){////限定分公司资源
			countyid=orderVO.getCountyid();
			if(countyid==null || "".equals(countyid)){
				returnMap.put("message", "订单分公司信息缺失");
				returnMap.put("errorCode","SALE-203004");
				return returnMap;
			}
		}else if("2".equals(sysparamvalue38)||"2".equals(extraexent)){
			
			WayVO wayvo=way.doFindByPk(orderVO.getWayid());
			svccode=wayvo.getSvccode();
			if(svccode==null || "".equals(svccode)){
				returnMap.put("message", "合作商归属服务营销中心信息缺失");
				returnMap.put("errorCode","SALE-203002");
				return returnMap;
			}
		}else if("3".equals(sysparamvalue38)||"3".equals(extraexent)){
			WayVO wayvo=way.doFindByPk(orderVO.getWayid());
			upperwayid=wayvo.getUpperwayid();
			if(upperwayid==null || "".equals(upperwayid)){
				returnMap.put("message", "合作商上级渠道信息缺失");
				returnMap.put("errorCode","SALE-203003");
				return returnMap;
			}
			emptysimDBParam.set_se_wayid(upperwayid);
			
		}else if("4".equals(sysparamvalue38)||"4".equals(extraexent)){
			/*WayVO wayvo=way.doFindByPk(orderVO.getWayid());
			mareacode=wayvo.getMareacode();*/
			mareacode=orderVO.getMareacode();
			if(mareacode==null || "".equals(mareacode)){
				returnMap.put("message", "订单微区域信息缺失");
				returnMap.put("errorCode","SALE-203005");
				return returnMap;
			}
		}
		
		//根据地市标识、商品状态（可售）、商品标识、订购套数查询空白SIM卡资源表，按批次号和空白SIM卡序列号升序
		List<EmptysimVO> emptysimList=emptysimBO.doQueryByComcategory(emptysimDBParam,countyid,svccode,mareacode).getDatas();//空白SIM卡资源查询集合
		if(emptysimList.size()==0){
			
			returnMap.put("message", "商品资源["+camcategoryName+"]已售完");
			returnMap.put("errorCode","SALE-202001");
			returnMap.put("value", comcategory);
			returnMap.put("comcode", comcategory);
			return returnMap;
		}
		if(emptysimList.size()<comcate.getOrderamt()){
			
			returnMap.put("message", "商品资源["+camcategoryName+"]库存不足");
			returnMap.put("errorCode","SALE-202004");
			returnMap.put("value", comcategory);
			returnMap.put("comcode", comcategory);
			return returnMap;
		}
		
		EmptysimVO emptysimVO=null;//空白SIM卡VO
		OrderresdetVO orderresdetVO=null;//订单资源明细VO
		Com comBO = (Com) BOFactory.build(ComBO.class, user);// 商品数据BO
		ComVO comVO = new ComVO();
		for(EmptysimVO obj:emptysimList){
			emptysimVO=obj;//空白SIM卡
			//修改空白SIM卡资源状态为抽取态
			emptysimVO.setUsestate((short)10);
			emptysimBO.doUpdate(emptysimVO);
			comVO = comBO.doFindByPk(emptysimVO.getComid());
			orderresdetVO=new OrderresdetVO();
			orderresdetVO.setOrderid(comcate.getOrderid());//订单编号
			orderresdetVO.setOrdercomtype(ordercomtype);//订单商品类型
			orderresdetVO.setComcategory(comcategory);//商品种类
			orderresdetVO.setComid(emptysimVO.getComid());//商品标识
			orderresdetVO.setRestype(comcateg.getRestype());//资源类别
			orderresdetVO.setWayid(emptysimVO.getWayid());//渠道ID
			orderresdetVO.setEmptyno(emptysimVO.getEmptyno());//空白卡序列号
			orderresdetVO.setBatchno(emptysimVO.getBatchno());//商品批次
			orderresdetVO.setComprice(comVO.getComprice() == null ? 0 : comVO.getComprice() * 0.01);//商品原价
			orderresdetVO.setActprice(comcate.getUnitprice());//实际售价
			this.doCreate(orderresdetVO);
			//residList.add(String.valueOf(comrescardVO.getComresid()));//记录资源ID（商品标识，手机号码）
		}
		//returnMap.put("residList", residList);
		return returnMap;
	}
	
	/**
	 * 套卡抽取
	 * @param brandMap 品牌MAP
	 * @param sysparamvalue21 关联配送商参数
	 * @param comcate 订单商品种类
	 * @param comcateg 商品种类关系
	 * @param nosect 所属号段（指定号段和循环号段才有，其他为NULL）
	 * @param isCycsect 是否循环号段查询
	 * @param isRandom	随机抽取
	 * @param paramMap 参数MAP类
	 * @return
	 * @throws Exception
	 */
	private Map doComressmpResdraw(Map brandMap,String sysparamvalue21,String sysparamvalue38,OrdercomcateVO comcate,ComcategoryrelaVO comcateg,String nosect,boolean isCycsect,boolean isRandom,Map<String,Object> paramMap) throws Exception{
		//boolean isRandom=true;
		Map<String,Object> returnMap=new HashMap<String,Object>();
		List<String> residList=new ArrayList<String>();
		OrderresdetVO orderresdetVO=null;//订单资源明细VO
		//CompackVO compackVO=null;//商品包VO
		//DiscomresVO discomresVO=null;//配送商资源VO
		OrderpackdetVO orderpackdetVO=null;
		CompackDBParam compackDBParam=new CompackDBParam();
		ComressmpDBParam comressmpDBParam=new ComressmpDBParam();
		Order orderbo = (Order)BOFactory.build(OrderBO.class,user);
		Compack compackBO=(Compack)BOFactory.build(CompackBO.class,user);//商品包BO
		Comressmp comressmpBO=(Comressmp)BOFactory.build(ComressmpBO.class,user);//套卡资源BO
		Orderpackdet orderpackdetBO=(Orderpackdet)BOFactory.build(OrderpackdetBO.class,user);//套卡资源BO
		OrderVO orderVO=orderbo.doFindByPk(comcate.getOrderid());
		List<ComressmpVO> comressmpList=null;//套卡查询集合
		List<CompackVO> compackListZ=null;//整数商品包查询集合
		List<CompackVO> compackListY=null;//余数商品包查询集合
		List<CompackVO> compackListRandom=null;//随机数商品包查询集合
		List<CompackVO> compackListZH=null;//组合匹配余数包查询集合
		Long orderamt=comcate.getOrderamt();
		String comcategory=comcate.getComcategory();
		String ordercomtype=comcate.getOrdercomtype();//订单商品类型
		if(paramMap!=null && paramMap.get("boxAmtY")==null){//paramMap
			orderamt=(Long)paramMap.get("orderamt");
			comcategory=(String)paramMap.get("comcategory");
		}
		String resuse="";
		//客户订购对应日常订购
		if("CUSTORDER".equals(comcate.getOrdercomtype())){
			resuse="NORMAL";
		}
		//系统搭售对应配号专用
		else if("SYSTIEIN".equals(comcate.getOrdercomtype())){
			resuse="TIEIN";
		}
		//系统赠送对应赠送专用。
		else if("SYSGIFT".equals(comcate.getOrdercomtype())){
			resuse="PRESENT";
		}
		//订购途径为紧急时，对应紧急
		if("URGENT".equals(orderVO.getOrderave())){
			resuse="URGENT";
		}
		
		//根据套卡品牌查询品牌包大小MAP，如果无数据则提示“套卡品牌[xxx]包大小参数未设置”并返回。
		String brandName = Code2NameUtils.code2Name("$FX_SMPBRAND", comcateg.getBrand(), user.getCityid());
		if(!brandMap.containsKey(comcateg.getBrand())){
			returnMap.put("message", "套卡品牌包大小["+brandName+"]参数未设置");
			returnMap.put("errorCode","SALE-201003");
			returnMap.put("value", brandName);
			returnMap.put("brandName", brandName);
			return returnMap;
		}
		Long brandamt=(Long)brandMap.get(comcateg.getBrand());
		long boxAmtZ=orderamt/brandamt;//商品包数量
		long boxAmtY=orderamt%brandamt;//余数
		if(isCycsect){//为循环号段抽取的时候整包抽取为1,余包则抽取余数
			if(paramMap!=null && paramMap.get("boxAmtY")!=null){//余包
				boxAmtZ=0;
				boxAmtY=(Long)paramMap.get("boxAmtY");
			}else{//整包
				boxAmtZ=1;
				boxAmtY=0;
			}
		}
		
		//根据商品种类、商品数量（等于套卡品牌包大小）、包状态（可售）、资源用途、所属库区、归属配送商（不关联时省略）、
		//抽取包数量查询商品包（IM_PR_COMPACK），按批次和包号升序
		compackDBParam.set_se_comcategory(comcategory);//商品种类
		compackDBParam.set_se_packstate("1");//包状态
		
		
		compackDBParam.set_se_resuse(resuse);//资源用途
		compackDBParam.set_orderby("batchno,boxnum");
		compackDBParam.set_desc("0");
		if("1".equals(sysparamvalue21)){//订购资源是否关联配送商
			compackDBParam.set_se_discomcode(sysparamvalue21);//配送商
			Way way = (Way) BOFactory.build(WayBO.class, user);
			WayDBParam params = new WayDBParam();
			params.set_se_wayid(orderVO.getWayid());
			params.set_se_waytype("AG");
			DataPackage dp = way.doQuery(params);
			compackDBParam.set_se_discomcode(((WayVO)dp.getDatas().get(0)).getLogiscode()==null?" ":((WayVO)dp.getDatas().get(0)).getLogiscode()); 
		}
		String countyid=null;//订单所属分公司
		String svccode=null;//服务营销中心
		String upperwayid=null;//上级渠道
		String mareacode=null;//微区域
		String extraexent=null;
		if("9".equals(sysparamvalue38)){//订购资源是否限定资源,9--查询分公司资源抽取范围表 (FX_EXTRAEXENT)，获取抽取范围值
			Extraexent extraexentBO=(Extraexent)BOFactory.build(ExtraexentBO.class,user);//分公司资源抽取BO
			ExtraexentVO extraexentVO=new ExtraexentVO();
			extraexentVO.setCityid(user.getCityid());
			extraexentVO.setCountyid(orderVO.getCountyid());
			extraexentVO=extraexentBO.doFindByPk(extraexentVO);
			if(extraexentVO==null){
				String countyname=Code2NameUtils.code2Name("#CNTYCOMPANY", orderVO.getCountyid(), user.getCityid());
				returnMap.put("message", "分公司["+countyname+"]资源抽取范围信息缺失");
				returnMap.put("errorCode","SALE-203006");
				returnMap.put("value", countyname);
				return returnMap;
			}
			extraexent=extraexentVO.getExtraexent();
				
		}
		Way way = (Way) BOFactory.build(WayBO.class, user);
		if("1".equals(sysparamvalue38)||"1".equals(extraexent)){//限定分公司资源
			countyid=orderVO.getCountyid();
			if(countyid==null || "".equals(countyid)){
				returnMap.put("message", "订单分公司信息缺失");
				returnMap.put("errorCode","SALE-203004");
				return returnMap;
			}
		}else if("2".equals(sysparamvalue38)||"2".equals(extraexent)){//限定服务营销中心
			WayVO wayvo=way.doFindByPk(orderVO.getWayid());
			svccode=wayvo.getSvccode();
			if(svccode==null || "".equals(svccode)){
				returnMap.put("message", "合作商归属服务营销中心信息缺失");
				returnMap.put("errorCode","SALE-203002");
				return returnMap;
			}
		}else if("3".equals(sysparamvalue38)||"3".equals(extraexent)){//限定资源归属渠道为订单合作商的上级渠道
			WayVO wayvo=way.doFindByPk(orderVO.getWayid());
			upperwayid=wayvo.getUpperwayid();
			if(upperwayid==null || "".equals(upperwayid)){
				returnMap.put("message", "合作商上级渠道信息缺失");
				returnMap.put("errorCode","SALE-203003");
				return returnMap;
			}
			compackDBParam.set_se_wayid(upperwayid);
		}else if("4".equals(sysparamvalue38)||"4".equals(extraexent)){//限定微区域
			mareacode=orderVO.getMareacode();
			if(mareacode==null || "".equals(mareacode)){
				returnMap.put("message", "订单微区域信息缺失");
				returnMap.put("errorCode","SALE-203005");
				return returnMap;
			}
		}
		if(nosect!=null){
			compackDBParam.set_se_nosect(nosect);//归属号段
		}
		compackDBParam.set_se_storarea(orderVO.getStorarea());//所属库区
		String camcategoryName = "";//商品种类名称
		camcategoryName = Code2NameUtils.code2Name("$IM_FXCOMCATEGORY", comcategory, user.getCityid());
		long boxZcount=0;
		long random=0;
		if(boxAmtZ>0){
			compackDBParam.set_ne_amount(new Short(brandamt+""));//商品数量（等于套卡品牌包大小）
			
			if(isRandom){ //是随机抽取时
				/*根据商品种类、商品数量（等于套卡品牌包大小）、包状态（可售）、资源用途、所属库区、归属配送商（不关联时省略）、
				 * 资源归属渠道（不限定分公司时省略，限定分公司时限定资源归属渠道的分公司为订单信息的分公司）对商品包（IM_PR_COMPACK）进行统计查询
				 */
				compackDBParam.setCountOnly(true);
				if(countyid==null && svccode==null && mareacode==null){//否限定分公司和否限定服务营销中心\微区域资源查询商品包
					boxZcount=compackBO.doQuery(compackDBParam).getRowCount();
				}else{//限定分公司资源查询商品包
					boxZcount= compackBO.doQueryCompackResdraw(compackDBParam, countyid,svccode,mareacode).getRowCount();
				}
				if(boxZcount==0){//如果总数等于0则提示（错误码取“SALE-202001”，将商品种类编码传入）并返回，
					returnMap.put("message","商品资源["+camcategoryName+"]已售完");
					returnMap.put("errorCode","SALE-202001");
					returnMap.put("value", comcategory);
					returnMap.put("comcode", comcategory);
					return returnMap;
				}else if(boxZcount<boxAmtZ){//如果商品包统计数量小于待抽取包数量则提示（错误码取“SALE-202004”，将商品种类编码传入）并返回。
					returnMap.put("message", "商品资源["+camcategoryName+"]库存不足");
					returnMap.put("errorCode","SALE-202004");
					returnMap.put("value", comcategory);
					returnMap.put("comcode", comcategory);
					return returnMap;
				}
				random=new Random().nextInt((int)(boxZcount-boxAmtZ+1));
				compackDBParam.setCountOnly(false);
				
			}
			compackDBParam.set_pagesize(String.valueOf(random+boxAmtZ));//查询记录数
			
			if(countyid==null && svccode==null && mareacode==null){//否限定分公司和否限定服务营销中心\微区域资源查询商品包
				compackListZ=compackBO.doQuery(compackDBParam).getDatas();
			}else{//限定分公司资源查询商品包
				compackListZ= compackBO.doQueryCompackResdraw(compackDBParam, countyid,svccode,mareacode).getDatas();
			}
			//如果无数据则提示“商品资源[商品种类编码]已售完”并返回
			if(compackListZ.size()==0 ){
				returnMap.put("message","商品资源["+camcategoryName+"]已售完");
				returnMap.put("errorCode","SALE-202001");
				returnMap.put("value", comcategory);
				returnMap.put("comcode", comcategory);
				return returnMap;
			}
			//如果包数量不足则提示“商品资源[商品种类编码]库存不足”并返回
			if(compackListZ.size()<boxAmtZ){
				returnMap.put("message", "商品资源["+camcategoryName+"]库存不足");
				returnMap.put("errorCode","SALE-202004");
				returnMap.put("value", comcategory);
				returnMap.put("comcode", comcategory);
				return returnMap;
			}
		}
		
		//如果商品资源存在有余数的情况\
		boolean isBoxYZ=false;//标记是否余整包
		Map<Long,Long> drawMap = new HashMap<Long, Long>();//组合匹配余数方法所返回的map
		Set<Long> keySet = null;
		long totalsum = 0;//返回MAP的总商品数量
		
		if(boxAmtY>0){
			//按照商品数量等于余数、包数量等于1（其他条件同）进行抽取
			compackDBParam.set_ne_amount(new Short(boxAmtY+""));
			compackDBParam.set_pagesize("1");
			//compackListY=compackBO.doQuery(compackDBParam).getDatas();
			if(countyid==null && svccode==null && mareacode==null){//否限定分公司和否限定服务营销中心\微区域资源查询商品包
				compackListY=compackBO.doQuery(compackDBParam).getDatas();
			}else{//限定分公司资源查询商品包
				compackListY= compackBO.doQueryCompackResdraw(compackDBParam, countyid,svccode,mareacode).getDatas();
			}
			
			
			if(compackListY.size()==0){
				//如果没有余数数量商品包则进行组合匹配余数抽取方法
				CompackDBParam cpdbparam = new CompackDBParam();
				BeanUtils.copyProperties(cpdbparam, compackDBParam);//复制一份compackDBParam供组合匹配余数方法使用，以防破坏原有的compackDBParam
				cpdbparam.set_ne_amount(null);
				drawMap = this.getResdrawMapByCombinMatchRemainder(comcategory, boxAmtY, brandamt,cpdbparam,countyid,svccode,mareacode);
				//根据返回MAP总商品数量是否等于余数，等于则按照MAP数量进行抽取，
				keySet=drawMap.keySet();
				for(Long key : keySet){
					totalsum = totalsum + drawMap.get(key);
				}
				//如果不等于余数则按照商品数量等于套卡品牌包大小、包数量等于1进行抽取
				if(!(totalsum==boxAmtY)){
					compackDBParam.set_ne_amount(new Short(brandamt+""));//商品数量（等于套卡品牌包大小）
					if(isRandom){ //是随机抽取时
						if((random==boxZcount-boxAmtZ)&& random!=0){
							random--;
						}
					}
					compackDBParam.set_pagesize(String.valueOf(random+boxAmtZ+1));//查询记录数+1
					
					//compackListZ=compackBO.doQuery(compackDBParam).getDatas();
					if(countyid==null && svccode==null && mareacode==null){//否限定分公司和否限定服务营销中心\微区域资源查询商品包
						compackListZ=compackBO.doQuery(compackDBParam).getDatas();
					}else{//限定分公司资源查询商品包
						compackListZ= compackBO.doQueryCompackResdraw(compackDBParam, countyid,svccode,mareacode).getDatas();
					}
					if(compackListZ.size()<(boxAmtZ+1)){
						returnMap.put("message", "商品资源["+camcategoryName+"]库存不足");
						returnMap.put("errorCode","SALE-202004");
						returnMap.put("value", comcategory);
						returnMap.put("comcode", comcategory);
						return returnMap;
					}
					isBoxYZ=true;
				}
			}
		}
		if(isRandom){//随机抽取时
			if(random!=0){
				compackDBParam.set_ne_amount(new Short(brandamt+""));
				compackDBParam.set_pagesize(random+"");//查询随机数
				if(countyid==null && svccode==null && mareacode==null){//否限定分公司和否限定服务营销中心\微区域资源查询商品包
					compackListRandom=compackBO.doQuery(compackDBParam).getDatas();
				}else{//限定分公司资源查询商品包
					compackListRandom= compackBO.doQueryCompackResdraw(compackDBParam, countyid,svccode,mareacode).getDatas();
				}
			}
		}
		Com comBO=(Com)BOFactory.build(ComBO.class,user);//商品数据BO
		ComVO comVO=null;
		if(compackListZ!=null  && compackListZ.size()>0){//有整数包的时候
			if(compackListRandom!=null)
				compackListZ.removeAll(compackListRandom);//去除随机数包集合
			int count=1;
			for(CompackVO compackVO:compackListZ){
				if(!isBoxYZ || (isBoxYZ && count!=compackListZ.size())){//处理整包部分
					compackVO.setPackstate("10");
					compackBO.doUpdate(compackVO);
					comressmpDBParam.set_se_batchno(compackVO.getBatchno());//批次
					comressmpDBParam.set_se_boxnum(compackVO.getBoxnum());//包号
					comressmpDBParam.set_ne_comstate((short)1);
					comressmpDBParam.set_pagesize(brandamt+"");//查询套卡品牌包大小数量的记录
					comressmpList=comressmpBO.doQuery(comressmpDBParam).getDatas();
					if(comressmpList==null || comressmpList.size()==0 ){
						returnMap.put("errorCode","SALE-203001");
						returnMap.put("value", brandName);
						returnMap.put("message", "商品包资源数量与实际套卡资源数量不一致！");
						return returnMap;
					}
					for(ComressmpVO comressmpVO:comressmpList){
						comVO=comBO.doFindByPk(comressmpVO.getComid());
						comressmpVO.setComstate((short)10);//更新为抽取态
						comressmpBO.doUpdate(comressmpVO);
						orderresdetVO=new OrderresdetVO();
						orderresdetVO.setOrderid(comcate.getOrderid());//订单编号
						orderresdetVO.setOrdercomtype(comcate.getOrdercomtype());//订单商品类型
						orderresdetVO.setComcategory(comcategory);//商品种类
						orderresdetVO.setRestype(comcateg.getRestype());//资源类别
						orderresdetVO.setComid(comressmpVO.getComid());//商品标识
						orderresdetVO.setWayid(comressmpVO.getWayid());//渠道ID
						orderresdetVO.setComresid(comressmpVO.getComresid());//商品资源编号
						orderresdetVO.setBatchno(comressmpVO.getBatchno());//批次
						orderresdetVO.setBoxnum(comressmpVO.getBoxnum());//包号
						orderresdetVO.setBrand(comressmpVO.getBrand());//品牌
						orderresdetVO.setComprice(comVO.getComprice()==null?0:comVO.getComprice()*0.01);//商品原价
						orderresdetVO.setActprice(comcate.getUnitprice());//实际售价
						this.doCreate(orderresdetVO);
						residList.add(String.valueOf(comressmpVO.getComresid()));//记录资源ID（商品标识，手机号码）
					}
					//订单商品包明细
					orderpackdetVO=new OrderpackdetVO();
					orderpackdetVO.setOrderid(orderVO.getOrderid());//订单编号
					orderpackdetVO.setComcategory(comcategory);//商品种类
					orderpackdetVO.setBatchno(compackVO.getBatchno());//商品批次
					orderpackdetVO.setBoxnum(compackVO.getBoxnum());//包号
					orderpackdetBO.doCreate(orderpackdetVO);
					count++;
				}else{//遍历到最后有余数时
					compackVO.setAmount((short) (compackVO.getAmount()-boxAmtY));//更新商品包数量等于原数量-抽取余数数量
					compackBO.doUpdate(compackVO);
					comressmpDBParam.set_se_batchno(compackVO.getBatchno());//批次
					comressmpDBParam.set_se_boxnum(compackVO.getBoxnum());//包号
					comressmpDBParam.set_ne_comstate((short)1);//可售状态
					comressmpDBParam.set_pagesize(String.valueOf(boxAmtY));//查询余数数量的记录
					comressmpDBParam.set_orderby("insideseq");//按包内序号升序
					comressmpDBParam.set_desc("0");
					comressmpList=comressmpBO.doQuery(comressmpDBParam).getDatas();
					if(comressmpList==null || comressmpList.size()==0){
						returnMap.put("errorCode","SALE-203001");
						returnMap.put("value", brandName);
						returnMap.put("message", "商品包资源数量与实际套卡资源数量不一致！");
						return returnMap;
					}
					for(ComressmpVO comressmpVO:comressmpList){
						comVO=comBO.doFindByPk(comressmpVO.getComid());
						comressmpVO.setComstate((short)10);//更新为抽取态
						comressmpBO.doUpdate(comressmpVO);
						orderresdetVO=new OrderresdetVO();
						orderresdetVO.setOrderid(comcate.getOrderid());//订单编号
						orderresdetVO.setOrdercomtype(comcate.getOrdercomtype());//订单商品类型
						orderresdetVO.setComcategory(comcategory);//商品种类
						orderresdetVO.setRestype(comcateg.getRestype());//资源类别
						orderresdetVO.setComid(comressmpVO.getComid());//商品标识
						orderresdetVO.setComresid(comressmpVO.getComresid());//商品资源编号
						orderresdetVO.setBatchno(comressmpVO.getBatchno());//批次
						orderresdetVO.setBoxnum(comressmpVO.getBoxnum());//包号
						orderresdetVO.setWayid(comressmpVO.getWayid());//渠道ID
						orderresdetVO.setBrand(comressmpVO.getBrand());//品牌
						orderresdetVO.setComprice(comVO.getComprice()==null?0:comVO.getComprice()*0.01);//商品原价
						orderresdetVO.setActprice(comcate.getUnitprice());//实际售价
						this.doCreate(orderresdetVO);
						residList.add(String.valueOf(comressmpVO.getComresid()));//记录资源ID（商品标识，手机号码）
					}
				}
			}
		}
		if(compackListY!=null && compackListY.size()>0){//有余数整包的时候
			for(CompackVO compackVO:compackListY){
				compackVO.setPackstate("10");
				compackVO.setAmount((short)0);
				compackBO.doUpdate(compackVO);
				comressmpDBParam.set_se_batchno(compackVO.getBatchno());//批次
				comressmpDBParam.set_se_boxnum(compackVO.getBoxnum());//包号
				comressmpDBParam.set_ne_comstate((short)1);
				comressmpDBParam.set_pagesize(String.valueOf(boxAmtY));//查询余数数量的记录
				comressmpList=comressmpBO.doQuery(comressmpDBParam).getDatas();
				if(comressmpList==null || comressmpList.size()==0 ){
					returnMap.put("errorCode","SALE-203001");
					returnMap.put("value", brandName);
					returnMap.put("message", "商品包资源数量与实际套卡资源数量不一致！");
					return returnMap;
				}
				for(ComressmpVO comressmpVO:comressmpList){
					comVO=comBO.doFindByPk(comressmpVO.getComid());
					comressmpVO.setComstate((short)10);//更新为抽取态
					comressmpBO.doUpdate(comressmpVO);
					orderresdetVO=new OrderresdetVO();
					orderresdetVO.setOrderid(comcate.getOrderid());//订单编号
					orderresdetVO.setOrdercomtype(comcate.getOrdercomtype());//订单商品类型
					orderresdetVO.setComcategory(comcategory);//商品种类
					orderresdetVO.setRestype(comcateg.getRestype());//资源类别
					orderresdetVO.setComid(comressmpVO.getComid());//商品标识
					orderresdetVO.setComresid(comressmpVO.getComresid());//商品资源编号
					orderresdetVO.setBatchno(comressmpVO.getBatchno());//批次
					orderresdetVO.setBoxnum(comressmpVO.getBoxnum());//包号
					orderresdetVO.setWayid(comressmpVO.getWayid());//渠道ID
					orderresdetVO.setBrand(comressmpVO.getBrand());//品牌
					orderresdetVO.setComprice(comVO.getComprice()==null?0:comVO.getComprice()*0.01);//商品原价
					orderresdetVO.setActprice(comcate.getUnitprice());//实际售价
					this.doCreate(orderresdetVO);
					residList.add(String.valueOf(comressmpVO.getComresid()));//记录资源ID（商品标识，手机号码）
				}
				/*//订单商品包明细--余数包不需要登记到商品包明细
				orderpackdetVO=new OrderpackdetVO();
				orderpackdetVO.setOrderid(orderVO.getOrderid());//订单编号
				orderpackdetVO.setComcategory(comcategory);//商品种类
				orderpackdetVO.setBatchno(compackVO.getBatchno());//商品批次
				orderpackdetVO.setBoxnum(compackVO.getBoxnum());//包号
				orderpackdetBO.doCreate(orderpackdetVO);*/
			}
		}
		//根据组合匹配余数map抽取
		if(totalsum==boxAmtY && boxAmtY>0){
			for(Long key : keySet){
				compackDBParam.set_ne_amount(new Short(key+""));
				boolean flagtemp = (drawMap.get(key)/key == 0);//drawMap中要抽取的数量是否小于此散包的大小,true-是，false-否
				compackDBParam.set_pagesize(flagtemp?"1":String.valueOf(drawMap.get(key)/key));//如果要抽取的数量是否小于此散包的大小，取1，否则取它们的商
				compackDBParam.setSelectFields(null);
				if(countyid==null && svccode==null && mareacode==null){//否限定分公司和否限定服务营销中心\微区域资源查询商品包
					compackListZH=compackBO.doQuery(compackDBParam).getDatas();
				}else{//限定分公司资源查询商品包
					compackListZH= compackBO.doQueryCompackResdraw(compackDBParam, countyid,svccode,mareacode).getDatas();
				}
				if(compackListZH!=null && compackListZH.size()>0){//有组合匹配余数抽取包的时候
					for(CompackVO compackVO:compackListZH){
						if(!flagtemp){
							compackVO.setPackstate("10");
						}
						compackVO.setAmount(flagtemp?new Short((key-drawMap.get(key))+""):0);
						compackBO.doUpdate(compackVO);
						comressmpDBParam.set_se_batchno(compackVO.getBatchno());//批次
						comressmpDBParam.set_se_boxnum(compackVO.getBoxnum());//包号
						comressmpDBParam.set_ne_comstate((short)1);
						comressmpDBParam.set_pagesize(flagtemp?String.valueOf(drawMap.get(key)):String.valueOf(key));//如果抽取数量小于散包大小，则查出抽取数量的记录，否则，按散包大小来查
						comressmpList=comressmpBO.doQuery(comressmpDBParam).getDatas();
						if(comressmpList==null || comressmpList.size()==0 ){
							returnMap.put("errorCode","SALE-203001");
							returnMap.put("value", brandName);
							returnMap.put("message", "商品包资源数量与实际套卡资源数量不一致！");
							return returnMap;
						}
						for(ComressmpVO comressmpVO:comressmpList){
							comVO=comBO.doFindByPk(comressmpVO.getComid());
							comressmpVO.setComstate((short)10);//更新为抽取态
							comressmpBO.doUpdate(comressmpVO);
							orderresdetVO=new OrderresdetVO();
							orderresdetVO.setOrderid(comcate.getOrderid());//订单编号
							orderresdetVO.setOrdercomtype(comcate.getOrdercomtype());//订单商品类型
							orderresdetVO.setComcategory(comcategory);//商品种类
							orderresdetVO.setRestype(comcateg.getRestype());//资源类别
							orderresdetVO.setComid(comressmpVO.getComid());//商品标识
							orderresdetVO.setComresid(comressmpVO.getComresid());//商品资源编号
							orderresdetVO.setBatchno(comressmpVO.getBatchno());//批次
							orderresdetVO.setBoxnum(comressmpVO.getBoxnum());//包号
							orderresdetVO.setWayid(comressmpVO.getWayid());//渠道ID
							orderresdetVO.setBrand(comressmpVO.getBrand());//品牌
							orderresdetVO.setComprice(comVO.getComprice()==null?0:comVO.getComprice()*0.01);//商品原价
							orderresdetVO.setActprice(comcate.getUnitprice());//实际售价
							this.doCreate(orderresdetVO);
							residList.add(String.valueOf(comressmpVO.getComresid()));//记录资源ID（商品标识，手机号码）
						}
					}
				}
			}
		}
		
		returnMap.put("residList", residList);
		return returnMap;
	}
	public boolean deal(OrderVO order, DBAccessUser user){
		try {
			OrderresdetDBParam orderresdetDBParam=new OrderresdetDBParam();
			orderresdetDBParam.set_se_orderid(order.getOrderid());
			String retMes=this.doResdraw(orderresdetDBParam,true);//抽取方法
			if("订单资源抽取成功！".equals(retMes)){
				return true;
			}else{
				Order orderBO = (Order)BOFactory.build(OrderBO.class,user);
				order.setMemo(retMes);
				orderBO.doUpdate(order);
				return false;
			}
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}
	/**
	 * 订单资源抽取
	 * @param orderresdetDBParam
	 * @return 返回信息
	 * @throws Exception
	 */
	public String doResdraw(OrderresdetDBParam orderresdetDBParam,boolean isUpdateOrder) throws Exception {
		Map returnMap=null;
		try {
			Sysparam sysparamBO=(Sysparam)BOFactory.build(SysparamBO.class,user);
			//订购资源是否管理配送商
			String sysparamvalue21=sysparamBO.doFindByID("21", "pboss_fx");
			if(StringUtils.isEmpty(sysparamvalue21)){
				//throw new Exception( "订购资源是否关联配送商参数未设置");
				throw new SaleException("SALE-201001");
			}
			//是否限定分公司资源
			String sysparamvalue38=sysparamBO.doFindByID("38", "pboss_fx");
			if(StringUtils.isEmpty(sysparamvalue38)){
				throw new SaleException("SALE-201008");
			}
			//载入套卡品牌包大小
			String sysparamvalue5=sysparamBO.doFindByID("5", "pboss_fx");
			if(StringUtils.isEmpty(sysparamvalue5)){
				//throw new Exception(  "套卡品牌包大小参数未设置");
				throw new SaleException("SALE-201002");
			}
			
			String[] values= StringUtils.splitPreserveAllTokens(sysparamvalue5, "|");
			Map<String,Long> brandMap=new HashMap<String,Long>();
			String[] vals=null;
			for(String val:values){
				if(!"".equals(val)){
					vals=val.split(":");
					if(vals[1] == null || "".equals(vals[1]) || !PublicUtils.isInteger(String.valueOf(vals[1])) || Long.valueOf(vals[1])<=0 ){
						//throw new Exception(  "套卡品牌包大小设置错误，要求为大于0的整数");
						throw new SaleException("SALE-201004");
					}
					brandMap.put(vals[0],Long.valueOf(vals[1]));
				}
			}
			//载入资源抽取模式
			String sysparamvalue24=sysparamBO.doFindByID("24", "pboss_fx");
			if(StringUtils.isEmpty(sysparamvalue24)|| "".equals(sysparamvalue24)){
				sysparamvalue24="SEQUENCE";//如果无记录则默认取“SEQUENCE”
			}
			//载入指定号段
			String sysparamvalue25=sysparamBO.doFindByID("25", "pboss_fx");
			if((StringUtils.isEmpty(sysparamvalue25)||"".equals(sysparamvalue25)) &&(sysparamvalue24.equals("FIXSECT") || sysparamvalue24.equals("CYCSECT"))){
				throw new SaleException("SALE-201006");
			}
			//获取商品种类信息
			Ordercomcate ordercomcateBO = (Ordercomcate)BOFactory.build(OrdercomcateBO.class,user);
			OrdercomcateDBParam ordercomcateDBParam=new OrdercomcateDBParam();
			ordercomcateDBParam.set_se_orderid(orderresdetDBParam.get_se_orderid());
			DataPackage comdp =ordercomcateBO.doQuery(ordercomcateDBParam);
			Order orderBO = (Order)BOFactory.build(OrderBO.class,user);
			OrderVO orderVO=orderBO.doFindByPk(orderresdetDBParam.get_se_orderid());
			List<OrdercomcateVO> comdpList=comdp.getDatas();//订单商品种类集合
			
			ComcategoryrelaDBParam comcategoryrelaDBParam=new ComcategoryrelaDBParam();
			List<ComcategoryrelaVO> comcategList=null;//商品组合关系查询集合
			Comcategoryrela comcategoryrelaBO= (Comcategoryrela)BOFactory.build(ComcategoryrelaBO.class,user);//商品组合关系BO
			Orderresdet orderresdetBO=(Orderresdet)BOFactory.build(OrderresdetBO.class,user);//订单资源明细BO
			
			List<TiedComInfo> tiedComInfos=null;
			Spproposal spproposalBO= (Spproposal)BOFactory.build(SpproposalBO.class,user);//促销方案BO
			String message=null;
			for(OrdercomcateVO comcate:comdpList){
				comcategoryrelaDBParam.set_se_comcategory(comcate.getComcategory());
				comcategList=comcategoryrelaBO.doQuery(comcategoryrelaDBParam).getDatas();//商品种类
				if(comcategList.size()==0){
					throw new SaleException("SALE-201008");
				}
				if(comcategList.size()>0){
					ComcategoryrelaVO comcateg=comcategList.get(0);//取第一个商品种类
					//充值卡
					if("COMRESCARD".equals(comcateg.getRestype())){
						returnMap=this.doComrescardResdraw(comcate, comcateg,sysparamvalue38,null,orderresdetDBParam.getDrawPara());//充值卡抽取
						if(returnMap.get("message")!=null){//返回错误信息
							//throw new Exception((String)returnMap.get("message"));
							String value=(String)returnMap.get("value");
							SaleException se = new SaleException((String)returnMap.get("errorCode"),value);
							if(returnMap.get("comcode")!=null){
								if(returnMap.get("memo")!=null && !"".equals(returnMap.get("memo"))){
									if(returnMap.get("ordercomcateVO") != null && 
											!"".equals(returnMap.get("ordercomcateVO"))){
										OrdercomcateVO ordercomcateVO = (OrdercomcateVO)returnMap.get("ordercomcateVO");
										ordercomcateVO.setMemo((String)returnMap.get("memo"));
										se.setRtnObject(ordercomcateVO);
									}
								}
								se.setComcode((String)returnMap.get("comcode"));
							}
							throw se;
							
						}
						List residList=(List)returnMap.get("residList");//订单资源明细ID集合
						
						//促销方案--搭售
						tiedComInfos=spproposalBO.doTieInSale(orderVO.getWayid(), comcateg.getComcategory(), residList);
						if(tiedComInfos!=null && tiedComInfos.size()>0){
							message=this.doTiedComResdraw(tiedComInfos, "SYSTIEIN", brandMap, sysparamvalue21, sysparamvalue38,orderVO, comcateg, false);
							/*if(!"".equals(message))
								throw new Exception(message);*/
						}
						//促销方案--赠送
						tiedComInfos=spproposalBO.doPresentingB(orderVO.getWayid(), comcateg.getComcategory(), residList);
						if(tiedComInfos!=null && tiedComInfos.size()>0){
							message=this.doTiedComResdraw(tiedComInfos, "SYSGIFT", brandMap, sysparamvalue21, sysparamvalue38,orderVO, comcateg, false);
							/*if(!"".equals(message))
								throw new Exception(message);*/
						}
						
						
					}
					//套卡
					else if("COMRESSMP".equals(comcateg.getRestype())){
						List residList=null;
						if("SEQUENCE".equals(sysparamvalue24)){//顺序抽取
							returnMap=this.doComressmpResdraw( brandMap, sysparamvalue21,sysparamvalue38, comcate, comcateg,null,false,false,null);
						}else if("RANDOM".equals(sysparamvalue24)){//随机抽取
							returnMap=this.doComressmpResdraw( brandMap, sysparamvalue21,sysparamvalue38, comcate, comcateg, null,false,true,null);
						}else if("FIXSECT".equals(sysparamvalue24)){//指定号段
							if(sysparamvalue25.split(",").length>1){
								throw new SaleException("SALE-201007");
							}
							returnMap=this.doComressmpResdraw( brandMap, sysparamvalue21, sysparamvalue38,comcate, comcateg,sysparamvalue25,false,false,null);
						}else if("CYCSECT".equals(sysparamvalue24)){//循环号段
							String[] cycsectNums=sysparamvalue25.split(",");
							List<String> cycsectNumList=new ArrayList<String>();
							for(String cycsectNum:cycsectNums){
								cycsectNumList.add(cycsectNum);
							}
							Long brandamt=(Long)brandMap.get(comcateg.getBrand());
							long boxAmtZ=comcate.getOrderamt()/brandamt;
							long boxAmtY=comcate.getOrderamt()%brandamt;
							returnMap=this.doCycsectResdraw( brandMap, sysparamvalue21,sysparamvalue38, comcate, comcateg,cycsectNumList,new ArrayList(),boxAmtZ,boxAmtY);//循环号段抽取
						}
						
						if(returnMap!=null){
							if(returnMap.get("message")!=null){//返回错误信息
								String value=(String)returnMap.get("value");
								SaleException se = new SaleException((String)returnMap.get("errorCode"),value);
								if(returnMap.get("comcode")!=null)
									se.setComcode((String)returnMap.get("comcode"));
								if(returnMap.get("brandName")!=null)
									se.setBrandname((String)returnMap.get("brandName"));
								throw se;
							}
							residList=(List)returnMap.get("residList");//订单资源明细ID集合
						}
						

						//促销方案--搭售
						tiedComInfos=spproposalBO.doTieInSale(orderVO.getWayid(), comcateg.getComcategory(), residList);
						if(tiedComInfos!=null && tiedComInfos.size()>0){
							message=this.doTiedComResdraw(tiedComInfos, "SYSTIEIN", brandMap, sysparamvalue21,sysparamvalue38, orderVO, comcateg, false);
							/*if(!"".equals(message))
								throw new Exception(message);*/
						}
						//促销方案--赠送
						tiedComInfos=spproposalBO.doPresentingB(orderVO.getWayid(), comcateg.getComcategory(), residList);
						if(tiedComInfos!=null && tiedComInfos.size()>0){
							message=this.doTiedComResdraw(tiedComInfos, "SYSGIFT", brandMap, sysparamvalue21,sysparamvalue38, orderVO, comcateg, false);
							/*if(!"".equals(message))
								throw new Exception(message);*/
						}
					}
					//空白SIM卡
					else if("EMPTYSIM".equals(comcateg.getRestype())){
						returnMap=this.doEmptysimResdraw(comcate, comcateg,sysparamvalue38,null);//空白SIM卡卡抽取
						if(returnMap.get("message")!=null){//返回错误信息
							//throw new Exception((String)returnMap.get("message"));
							String value=(String)returnMap.get("value");
							SaleException se = new SaleException((String)returnMap.get("errorCode"),value);
							if(returnMap.get("comcode")!=null){
								se.setComcode((String)returnMap.get("comcode"));
							}
							throw se;
							
						}
					/*	List residList=(List)returnMap.get("residList");//订单资源明细ID集合
						
						//促销方案--搭售
						tiedComInfos=spproposalBO.doTieInSale(orderVO.getWayid(), comcateg.getComcategory(), residList);
						if(tiedComInfos!=null && tiedComInfos.size()>0){
							message=this.doTiedComResdraw(tiedComInfos, "SYSTIEIN", brandMap, sysparamvalue21, sysparamvalue38,orderVO, comcateg, false);
							if(!"".equals(message))
								throw new Exception(message);
						}
						//促销方案--赠送
						tiedComInfos=spproposalBO.doPresentingB(orderVO.getWayid(), comcateg.getComcategory(), residList);
						if(tiedComInfos!=null && tiedComInfos.size()>0){
							message=this.doTiedComResdraw(tiedComInfos, "SYSGIFT", brandMap, sysparamvalue21, sysparamvalue38,orderVO, comcateg, false);
							if(!"".equals(message))
								throw new Exception(message);
						}*/
						
						
					}
				}
			}
			
			if(isUpdateOrder){
				comdp = ordercomcateBO.doQuery(ordercomcateDBParam);
				comdpList = comdp.getDatas();// 订单商品种类集合
				Double sumTotalprice = 0d;
				for (OrdercomcateVO comcate : comdpList) {
					sumTotalprice += comcate.getTotalprice();// 汇总订单商品种类的总价
				}
				orderVO.setRecamt(sumTotalprice);//订单应收金额
				orderVO.setOrderstate("EXTRAED");//订单状态为已抽取
				orderVO.setStatechgtime(new Date());//变更时间为当前时间
				orderBO.doUpdate(orderVO);
				/*
				 * 新增数据到分销资源配送单（FX_SW_DISFORM）
				 
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
				disformBO.doCreate(disformVO);*/
			}
			return "订单资源抽取成功！";
		} catch (SaleException ex) {
			/*if(returnMap != null && returnMap.get("comcode")!=null
					&& returnMap.get("memo")!=null && !"".equals(returnMap.get("memo"))){
				OrdercomcateVO ordercomcateVO = (OrdercomcateVO)returnMap.get("ordercomcateVO");
				if(ordercomcateVO != null && !"".equals(ordercomcateVO)){
					
				}
			}*/
			throw ex;
		}catch (Exception ex) {
			throw new JOPException(ex.getMessage());
		}
	}
	

	/**
	 * 处理搭售/赠送的抽取方法
	 * 促销方案匹配：商品资源抽取完成后，调用促销方案（搭售/赠送）接口方法。
	 * 搭售/赠送资源抽取：如果存在搭售/赠送资源，则需要再次进行抽取，抽取逻辑参考上面的充值卡或商品包抽取逻辑。
	 * 同时新增数据到订单商品种类表（FX_SW_ORDERCOMCATE）和订单适用促销方案表（FX_SW_ORDERPLAN）。
	 * @param brandMap 品牌MAP
	 * @param sysparamvalue21 关联配送商参数
	 * @param comcateg 商品种类关系
	 * @param comcate 订单商品种类
	 * @param nosect 所属号段（指定号段和循环号段才有，其他为NULL）
	 * @param isCycsect 是否循环号段查询
	 * @param paramMap 参数MAP类
	 * @throws Exception
	 */
	public  String doTiedComResdraw(List<TiedComInfo> tiedComInfos,String ordercomtype,Map brandMap,String sysparamvalue21,String sysparamvalue38,OrderVO orderVo,ComcategoryrelaVO comcateg, boolean isbatchResdraw) throws Exception{
		try {
			Map<String,Long> tiedComMap=disposalTiedComInfo(orderVo.getOrderid(),tiedComInfos);
			Map<String,Object> paramMap=new HashMap<String,Object>();
			Set<String> keySet=tiedComMap.keySet();
			Map returnMap=null;
			OrdercomcateVO ordercomcateVO=null;
			Ordercomcate ordercomcateBO = (Ordercomcate)BOFactory.build(OrdercomcateBO.class,user);
			Comorder comorderBO = (Comorder)BOFactory.build(ComorderBO.class,user);
			ComcategoryrelaDBParam comcategoryrelaDBParam=new ComcategoryrelaDBParam();
			List<ComcategoryrelaVO> comcategList=null;//商品组合关系查询集合
			Comcategoryrela comcategoryrelaBO= (Comcategoryrela)BOFactory.build(ComcategoryrelaBO.class,user);//商品组合关系BO
			for(String key:keySet){
				//新增数据到订单商品种类表
				ordercomcateVO=new OrdercomcateVO();
				ordercomcateVO.setOrderid(orderVo.getOrderid());
				ordercomcateVO.setComcategory(key);
				ordercomcateVO.setOrdercomtype(ordercomtype);
				ordercomcateVO.setOrderamt(tiedComMap.get(key));
				ordercomcateVO.setUnitprice(comorderBO.doGetUnitprice(orderVo.getWayid(), key));
				String mestype="搭售";
				if(!"SYSGIFT".equals(ordercomtype)){
					ordercomcateVO.setTotalprice(ordercomcateVO.getUnitprice()*tiedComMap.get(key));
				}else{
					ordercomcateVO.setTotalprice(0d);
					mestype="赠送";
				}
				ordercomcateBO.doCreate(ordercomcateVO);
				
				paramMap.put("comcategory", key);
				paramMap.put("orderamt",tiedComMap.get(key));
				comcategoryrelaDBParam.set_se_comcategory(ordercomcateVO.getComcategory());
				comcategList=comcategoryrelaBO.doQuery(comcategoryrelaDBParam).getDatas();//商品种类
				if(comcategList.size()>0){
					ComcategoryrelaVO tiedComInfoComcateg=comcategList.get(0);//取第一个商品种类
					if("COMRESCARD".equals(tiedComInfoComcateg.getRestype())){
						returnMap=this.doComrescardResdraw(ordercomcateVO, tiedComInfoComcateg,sysparamvalue38,paramMap,null);
					}else if("COMRESSMP".equals(tiedComInfoComcateg.getRestype())){
						returnMap=this.doComressmpResdraw(brandMap, sysparamvalue21,sysparamvalue38, ordercomcateVO, tiedComInfoComcateg,  null, false,false, paramMap);
					}
					
					if(returnMap.get("message")!=null){//返回错误信息
						if(isbatchResdraw){//是批量抽取的时候
							return mestype+(String)returnMap.get("message");
						}
						//正常抽取时
						String value=(String)returnMap.get("value");
						String errorCode=(String)returnMap.get("errorCode");
						SaleException se =null;
						if("搭售".equals(mestype)){
							if("SALE-202001".equals(errorCode)){
								se= new SaleException("SALE-202002",value);
							}else{
								se= new SaleException("SALE-202005",value);
							}
						}else{
							if("SALE-202001".equals(errorCode)){
								se= new SaleException("SALE-202003",value);
							}else{
								se= new SaleException("SALE-202006",value);
							}
						}
						if(returnMap.get("comcode")!=null)
							se.setComcode((String)returnMap.get("comcode"));
						if(returnMap.get("brandName")!=null)
							se.setBrandname((String)returnMap.get("brandName"));
						throw se;
					}
				}
				
			}
		} catch (SaleException ex) {
			throw ex;
		}catch (Exception ex) {
			throw new JOPException(ex.getMessage());
		}
		return "";
	}

	/**
	 * 处理搭售/赠送资源的商品种类与商品数量的数据
	 * @param tiedComInfos
	 * @returns
	 */
	private Map<String,Long> disposalTiedComInfo(String orderid,List<TiedComInfo> tiedComInfos)throws Exception{
		Orderplan orderplanBO = (Orderplan)BOFactory.build(OrderplanBO.class,user);
		OrderplanVO orderplanVO=null;
		Map<String,Long> map=new HashMap<String,Long>();
		for(TiedComInfo tiedComInfo:tiedComInfos){
			if(map.containsKey(tiedComInfo.getTComCategory())){
				map.put(tiedComInfo.getTComCategory(), map.get(tiedComInfo.getTComCategory())+tiedComInfo.getTQuantity());
			}else{
				map.put(tiedComInfo.getTComCategory(),Long.valueOf(tiedComInfo.getTQuantity()));
			}
			//订单适用促销方案表（FX_SW_ORDERPLAN）
			orderplanVO=new OrderplanVO();
			orderplanVO.setOrderid(orderid);
			orderplanVO.setRuleid(tiedComInfo.getRuleid());
			orderplanVO.setSaleplan(tiedComInfo.getPid());
			orderplanBO.doCreate(orderplanVO);
		}
		return map;
	}
	/**
	 * 订单资源批量抽取
	 * @param parameterMap 批量抽取参数
	 * @param orderid  订单号
	 * @return 返回信息
	 * @throws Exception
	 */
	public String doBatchResdraw(Map parameterMap,String orderid) throws Exception {
		
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
		/**
		 * 本业务是否允许读到脏数据要看具体情况而定，因此不在代码中限定session的自动flush.
		 */
		try {
			Sysparam sysparamBO=(Sysparam)BOFactory.build(SysparamBO.class,user);
			//订购资源是否管理配送商
			String sysparamvalue21=sysparamBO.doFindByID("21", "pboss_fx");
			if(StringUtils.isEmpty(sysparamvalue21)){
				throw new Exception(orderid+"|订购资源是否关联配送商参数未设置|");
			}
			//是否限定分公司资源
			String sysparamvalue38=sysparamBO.doFindByID("38", "pboss_fx");
			if(StringUtils.isEmpty(sysparamvalue38)){
				throw new Exception(orderid+"|是否限定分公司资源参数未设置|");
			}
			//载入套卡品牌包大小
			String sysparamvalue5=sysparamBO.doFindByID("5", "pboss_fx");
			if(StringUtils.isEmpty(sysparamvalue5)){
				throw new Exception(orderid+"|套卡品牌包大小参数未设置|");
			}
			String[] values= StringUtils.splitPreserveAllTokens(sysparamvalue5, "|");
			Map<String,Long> brandMap=new HashMap<String,Long>();
			String[] vals=null;
			for(String val:values){
				if(!"".equals(val)){
					vals=val.split(":");
					if(vals[1] == null || "".equals(vals[1]) || !PublicUtils.isInteger(String.valueOf(vals[1])) || Long.valueOf(vals[1])<=0 ){
						throw new Exception(  "套卡品牌包大小设置错误，要求为大于0的整数");
					}
					brandMap.put(vals[0],Long.valueOf(vals[1]));
				}
			}
			
			Order orderBO = (Order)BOFactory.build(OrderBO.class,user);
			OrderVO orderVO=orderBO.doFindByPk(orderid);
			if(orderVO==null){
				throw new Exception(orderid+"|订单不存在|");
			}
			Orderproce orderproceBO = (Orderproce)BOFactory.build(OrderproceBO.class,user);
			OrderproceDBParam orderproceDBParam=new OrderproceDBParam();
			orderproceDBParam.set_ne_flowid(String.valueOf(orderVO.getFlowid()));
			orderproceDBParam.set_se_outstate("EXTRAED");//已抽取
			DataPackage data=orderproceBO.doQuery(orderproceDBParam);
			List<OrderproceVO> list=data.getDatas();
			String instate="";
			for(OrderproceVO obj:list){
				instate=obj.getInstate();
				break;
			}
			if(!instate.equals(orderVO.getOrderstate())){
				throw new Exception(orderid+"|订单状态不正确|");
			}
			
			//获取商品种类信息
			Ordercomcate ordercomcateBO = (Ordercomcate)BOFactory.build(OrdercomcateBO.class,user);
			OrdercomcateDBParam ordercomcateDBParam=new OrdercomcateDBParam();
			OrderresdetDBParam orderresdetDBParam=new OrderresdetDBParam();
			orderresdetDBParam.set_se_orderid(orderid);
			ordercomcateDBParam.set_se_orderid(orderresdetDBParam.get_se_orderid());
			DataPackage comdp =ordercomcateBO.doQuery(ordercomcateDBParam);
			List<OrdercomcateVO> comdpList=comdp.getDatas();
			
			ComcategoryrelaDBParam comcategoryrelaDBParam=new ComcategoryrelaDBParam();
			List<ComcategoryrelaVO> comcategList=null;//商品组合关系查询集合
			Comcategoryrela comcategoryrelaBO= (Comcategoryrela)BOFactory.build(ComcategoryrelaBO.class,user);//商品组合关系BO
			Orderresdet orderresdetBO=(Orderresdet)BOFactory.build(OrderresdetBO.class,user);//订单资源明细BO
			Map returnMap=null;
			List<TiedComInfo> tiedComInfos=null;
			Spproposal spproposalBO= (Spproposal)BOFactory.build(SpproposalBO.class,user);//促销方案BO
			String message=null;
			for(OrdercomcateVO comcate:comdpList){
				comcategoryrelaDBParam.set_se_comcategory(comcate.getComcategory());
				comcategList=comcategoryrelaBO.doQuery(comcategoryrelaDBParam).getDatas();//商品种类
				if(comcategList.size()>0){
					ComcategoryrelaVO comcateg=comcategList.get(0);//取第一个商品种类
					//充值卡
					if("COMRESCARD".equals(comcateg.getRestype())){
						returnMap=this.doComrescardResdraw(comcate, comcateg,sysparamvalue38, null,null);//充值卡抽取
						if(returnMap.get("message")!=null){//返回错误信息
							throw new Exception(orderid+"|"+(String)returnMap.get("message")+"|");
						}
						List residList=(List)returnMap.get("residList");//订单资源明细ID集合
						//促销方案--搭售
						tiedComInfos=spproposalBO.doTieInSale(orderVO.getWayid(), comcateg.getComcategory(), residList);
						if(tiedComInfos!=null && tiedComInfos.size()>0){
							message=this.doTiedComResdraw(tiedComInfos, "SYSTIEIN", brandMap, sysparamvalue21,sysparamvalue38, orderVO, comcateg, true);
							if(!"".equals(message))
								throw new Exception(orderid+"|"+message+"|");
						}
						//促销方案--赠送
						tiedComInfos=spproposalBO.doPresentingB(orderVO.getWayid(), comcateg.getComcategory(), residList);
						if(tiedComInfos!=null && tiedComInfos.size()>0){
							message=this.doTiedComResdraw(tiedComInfos, "SYSGIFT", brandMap, sysparamvalue21,sysparamvalue38, orderVO, comcateg, true);
							if(!"".equals(message))
								throw new Exception(orderid+"|"+message+"|");
						}
					}
					//套卡
					else if("COMRESSMP".equals(comcateg.getRestype())){
						returnMap=null;
						List residList=null;
						if("SEQUENCE".equals(parameterMap.get("resextratype"))){//顺序抽取
							returnMap=this.doComressmpResdraw( brandMap, sysparamvalue21,sysparamvalue38, comcate, comcateg,null,false,false,null);
						}else if("RANDOM".equals(parameterMap.get("resextratype"))){//随机抽取
							returnMap=this.doComressmpResdraw( brandMap, sysparamvalue21,sysparamvalue38, comcate, comcateg, null,false,true,null);
						}else if("FIXSECT".equals(parameterMap.get("resextratype"))){//指定号段
							if(((String) parameterMap.get("fixsectNum")).split(",").length>1){
								throw new Exception(orderid+"|参数[资源抽取指定号段]设置错误，请联系管理员|");
							}
							returnMap=this.doComressmpResdraw( brandMap, sysparamvalue21, sysparamvalue38,comcate, comcateg,(String) parameterMap.get("fixsectNum"),false,false,null);
						}else if("CYCSECT".equals(parameterMap.get("resextratype"))){//循环号段
							String[] cycsectNums=((String) parameterMap.get("cycsectNum")).split(",");
							List<String> cycsectNumList=new ArrayList<String>();
							for(String cycsectNum:cycsectNums){
								cycsectNumList.add(cycsectNum);
							}
							Long brandamt=(Long)brandMap.get(comcateg.getBrand());
							long boxAmtZ=comcate.getOrderamt()/brandamt;
							long boxAmtY=comcate.getOrderamt()%brandamt;
							returnMap=this.doCycsectResdraw( brandMap, sysparamvalue21,sysparamvalue38, comcate, comcateg,cycsectNumList,new ArrayList(),boxAmtZ,boxAmtY);//循环号段抽取
						}
						
						if(returnMap!=null){
							if(returnMap.get("message")!=null){//返回错误信息
								throw new Exception(orderid+"|"+(String)returnMap.get("message")+"|");
							}
							residList=(List)returnMap.get("residList");//订单资源明细ID集合
						}
						
						//促销方案--搭售
						tiedComInfos=spproposalBO.doTieInSale(orderVO.getWayid(), comcateg.getComcategory(), residList);
						if(tiedComInfos!=null && tiedComInfos.size()>0){
							message=this.doTiedComResdraw(tiedComInfos, "SYSTIEIN", brandMap, sysparamvalue21,sysparamvalue38, orderVO, comcateg, true);
							if(!"".equals(message))
								throw new Exception(orderid+"|"+message+"|");
						}
						//促销方案--赠送
						tiedComInfos=spproposalBO.doPresentingB(orderVO.getWayid(), comcateg.getComcategory(), residList);
						if(tiedComInfos!=null && tiedComInfos.size()>0){
							message=this.doTiedComResdraw(tiedComInfos, "SYSGIFT", brandMap, sysparamvalue21, sysparamvalue38,orderVO, comcateg, true);
							if(!"".equals(message))
								throw new Exception(orderid+"|"+message+"|");
						}
						
					}
					//空白SIM卡
					else if("EMPTYSIM".equals(comcateg.getRestype())){
						returnMap=this.doEmptysimResdraw(comcate, comcateg,sysparamvalue38,null);//空白SIM卡卡抽取
						if(returnMap.get("message")!=null){//返回错误信息
							throw new Exception(orderid+"|"+(String)returnMap.get("message")+"|");
						}
					}
					
				}
			}
			
			comdp = ordercomcateBO.doQuery(ordercomcateDBParam);
			comdpList = comdp.getDatas();// 订单商品种类集合
			Double sumTotalprice = 0d;
			for (OrdercomcateVO comcate : comdpList) {
				sumTotalprice += comcate.getTotalprice();// 汇总订单商品种类的总价
			}
			orderVO.setRecamt(sumTotalprice);//订单应收金额
			orderVO.setOrderstate("EXTRAED");//订单状态为已抽取
			orderVO.setStatechgtime(new Date());//变更时间为当前时间
			orderBO.doUpdate(orderVO);
			
			/*
			 * 新增数据到分销资源配送单（FX_SW_DISFORM）
			 
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
			disformBO.doCreate(disformVO);*/
			
			return "订单资源抽取成功";
		} catch (SaleException ex) {
			throw ex;
		}catch (Exception ex) {
			throw new JOPException(ex.getMessage());
		}
		
	}
	/**
	 * 循环号段抽取方法
	 * @param brandMap 品牌MAP
	 * @param sysparamvalue21 关联配送商参数
	 * @param comcate 订单商品种类
	 * @param comcateg 商品种类关系
	 * @param cycsectNumList 循环号段LIST
	 * @param residList 成功资源号LIST
	 * @param boxAmtZ  整包数量
	 * @param boxAmtY  余包数量
	 * @return
	 */
	public Map doCycsectResdraw(Map brandMap,String sysparamvalue21,String sysparamvalue38,OrdercomcateVO comcate,ComcategoryrelaVO comcateg,List<String> cycsectNumList,List residList,long boxAmtZ,long boxAmtY){
		try {
			Map map=null;
			Map<String,Object> paramMap=null;
			List<String> list=new ArrayList<String>();
			list.addAll(cycsectNumList);
			for(String cycsectNum:cycsectNumList){
				if(boxAmtZ==0){
					if(boxAmtY>0){
						paramMap=new HashMap<String,Object>();
						paramMap.put("boxAmtY", boxAmtY);
					}else{
						break;//当正包抽取完时跳出号码段循环
					}
				}
				map=this.doComressmpResdraw( brandMap, sysparamvalue21, sysparamvalue38, comcate, comcateg,cycsectNum,true,false,paramMap);
				if(map.get("message")!=null){//返回错误信息
					list.remove(cycsectNum);
					if(list.size()==0){
						return map;
						//throw new Exception(comcate.getOrderid()+"|"+(String)map.get("message")+"|");
					}
				}else{
					if(boxAmtZ>0)
						boxAmtZ--;
					else
						boxAmtY=0;//将余数包置0
					residList.addAll((List)map.get("residList"));//对循环的集合进行封装
				}
			}
			if(boxAmtZ==0 && boxAmtY==0){
				map.put("residList", residList);
				return map;
			}else{
				return this.doCycsectResdraw(brandMap, sysparamvalue21,sysparamvalue38, comcate, comcateg, list, residList,boxAmtZ,boxAmtY);
			}
		} catch (Exception ex) {
			throw new JOPException(ex.getMessage());
		}
	}
	
	/**
	 * 组合匹配余数方法
	 * @param comcategory 商品种类
	 * @param boxAmtY 余数
	 * @param brandamt 品牌包大小
	 * @param compackDBParam  查询条件
	 * @return
	 */
	private Map getResdrawMapByCombinMatchRemainder(String comcategory,long boxAmtY,Long brandamt,CompackDBParam compackDBParam,String countyid,String svccode,String mareacode) throws Exception{
		Map<Long,Long> sanMap = new HashMap<Long,Long>();//散包
		
		CompackDAO dao = (CompackDAO) DAOFactory.build(CompackDAO.class,user);
		//CompackDBParam param = new CompackDBParam();
		compackDBParam.setQueryAll(true);
		compackDBParam.setDataOnly(true);
		Map<String,String> conditionMap = new HashMap<String,String>();
		conditionMap.put("BRANDAMT", String.valueOf(brandamt));
		compackDBParam.setQueryConditions(conditionMap);
		compackDBParam.setSelectFieldsString("AMOUNT,NUM");
		DataPackage dp = dao.querySanMapByCount(compackDBParam,brandamt,countyid,svccode,mareacode);
		if( null != dp && dp.getDatas().size()>0 ){
			String amount = null;
			String num = null;
			for(Map<String,String> map:(List<Map<String,String>>) dp.getDatas()){
				amount =map.get("AMOUNT");
				num = map.get("NUM");
				sanMap.put(new Long(amount), new Long(num)*new Long(amount));
			}
		}
		
		Map<Long,Long> drawMap = new HashMap<Long,Long>();//最后要返回的抽取包
		Comorder comorder = (Comorder)BOFactory.build(ComorderBO.class, user);
		String unitagetemp = comorder.doGetUnitage(user.getCityid(), comcategory);//订购基数
		Short unitage = new Short(unitagetemp);//订购基数
		
		for(int i=1;i<=(boxAmtY/unitage);i++){
			for(int j=1;j<=(brandamt/unitage-1);j++){
				if(sanMap.containsKey(Long.parseLong(unitage*j+""))){
					long n=sanMap.get(Long.parseLong(unitage*j+"")).longValue();
					if(n-unitage.longValue()==0){
						sanMap.remove(Long.parseLong(unitage*j+""));
					}else{
						sanMap.put(new Long(unitage*j), (Long)(n-unitage));
					}
					if(drawMap.containsKey(Long.parseLong(unitage*j+""))){
						long n2 = drawMap.get(Long.parseLong(unitage*j+"")).longValue();
						drawMap.put(new Long(unitage*j), (Long)(n2+unitage));
					}else{
						drawMap.put(new Long(unitage*j), (Long)(unitage.longValue()));
					}
					break;
				}else{
					continue;
				}
			}
		}
		return drawMap;
	}

	public DataPackage doQueryExp(OrderresdetDBParam params) throws Exception {
		OrderresdetDAO dao = (OrderresdetDAO) DAOFactory.build(OrderresdetDAO.class,user);
		params.setSelectFieldsString("orderid, wayid, detid, comid, comcategory, batchno, boxnum, comresid");
		return dao.queryByNamedSqlQuery("sales.orderresdet.resdetbatchexport", params);
	}
	
}
