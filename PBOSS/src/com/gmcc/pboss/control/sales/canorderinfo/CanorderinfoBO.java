/**
 * auto-generated code
 * Wed Aug 10 10:50:17 CST 2011
 */
package com.gmcc.pboss.control.sales.canorderinfo;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import com.gmcc.pboss.business.base.dictitem.DictitemVO;
import com.gmcc.pboss.business.base.smstmpl.SmstmplDBParam;
import com.gmcc.pboss.business.base.smstmpl.SmstmplVO;
import com.gmcc.pboss.business.channel.employee.EmployeeDBParam;
import com.gmcc.pboss.business.channel.employee.EmployeeVO;
import com.gmcc.pboss.business.channel.way.WayDBParam;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.resource.cityrescode.CityrescodeDBParam;
import com.gmcc.pboss.business.resource.cityrescode.CityrescodeVO;
import com.gmcc.pboss.business.resource.comcatebrand.ComcatebrandDBParam;
import com.gmcc.pboss.business.sales.canorderinfo.CanorderinfoDAO;
import com.gmcc.pboss.business.sales.canorderinfo.CanorderinfoDBParam;
import com.gmcc.pboss.business.sales.canorderinfo.CanorderinfoVO;
import com.gmcc.pboss.business.sales.comorder.OrderCardVO;
import com.gmcc.pboss.business.sales.comorder.OrderStockalarmVO;
import com.gmcc.pboss.control.base.smstmpl.Smstmpl;
import com.gmcc.pboss.control.base.smstmpl.SmstmplBO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.employee.EmployeeBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.resource.cityrescode.CityrescodeBO;
import com.gmcc.pboss.control.resource.comcatebrand.ComcatebrandBO;
import com.gmcc.pboss.control.sales.comorder.Comorder;
import com.gmcc.pboss.control.sales.comorder.ComorderBO;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.common.utils.lang.Code2NameUtils;
import com.sunrise.jop.common.utils.lang.PublicUtils;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: canorderinfoBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxingxin
 * @version 1.0
 */
public class CanorderinfoBO extends AbstractControlBean implements
		Canorderinfo {

	public CanorderinfoVO doCreate(CanorderinfoVO vo) throws Exception {
		try {
			CanorderinfoDAO dao = (CanorderinfoDAO) DAOFactory.build(CanorderinfoDAO.class, user);
			// TODO set the pk */
			return (CanorderinfoVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(CanorderinfoVO vo) throws Exception {
		try {
			CanorderinfoDAO dao = (CanorderinfoDAO) DAOFactory.build(CanorderinfoDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			CanorderinfoDAO dao = (CanorderinfoDAO) DAOFactory.build(CanorderinfoDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public CanorderinfoVO doUpdate(CanorderinfoVO vo) throws Exception {
		try {
			CanorderinfoDAO dao = (CanorderinfoDAO) DAOFactory.build(CanorderinfoDAO.class,user);
			return (CanorderinfoVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public CanorderinfoVO doFindByPk(Serializable pk) throws Exception {
		CanorderinfoDAO dao = (CanorderinfoDAO) DAOFactory.build(CanorderinfoDAO.class,user);
		return (CanorderinfoVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(CanorderinfoDBParam params)
			throws Exception {
		CanorderinfoDAO dao = (CanorderinfoDAO) DAOFactory.build(CanorderinfoDAO.class,user);
		return dao.query(params);
	}

	public List doStatPartnerres(CanorderinfoDBParam params)
			throws Exception {
		CanorderinfoDAO dao = (CanorderinfoDAO) DAOFactory.build(CanorderinfoDAO.class,user);
		return dao.doStatPartnerres(params);
	}
	
	public CanorderinfoVO doNotceOne(DBAccessUser user, WayVO wayvo) throws Exception {
		CanorderinfoVO coiVO = new CanorderinfoVO();
		List brandList = new ArrayList<CanorderinfoVO>();
		List cardList = new ArrayList<CanorderinfoVO>();
		List emptyList = new ArrayList<CanorderinfoVO>();
		
		//获取短信模板
		String sContentString = getSmsContent();
		if(sContentString == null || "".equals(sContentString)){
			String errStr1 = "商品订购短信提醒短信模板未设置，请联系系统管理员检查。";
			
			throw new Exception(errStr1);
		}
		//获取分销订购短信端口
		Sysparam sysparamBO=(Sysparam)BOFactory.build(SysparamBO.class,user);
		String sysparamvalue42=sysparamBO.doFindByID("42", "pboss_fx");
		if(sysparamvalue42 == null || "".equals(sysparamvalue42)){
			String errStr2 = "分销订购短信端口未设置，请联系系统管理员检查";
			
			throw new Exception(errStr2);
		}
		coiVO.setSendNum(sysparamvalue42);
		
		//获取套卡品牌集合
		doQueryBrand(brandList, user, wayvo);
		
		//获取充值卡订购信息
		doQueryStock(cardList, user, wayvo);
		
		//获取空白SIM卡订购信息
		doQueryEmpty(emptyList, user, wayvo);
		
		ComcatebrandBO comcatebrandBO = (ComcatebrandBO) BOFactory.build(ComcatebrandBO.class, user);
		ComcatebrandDBParam comcatebrandDBParam = new ComcatebrandDBParam();
		comcatebrandDBParam.setDataOnly(true);
		comcatebrandDBParam.setQueryAll(true);
		comcatebrandDBParam.setSelectFieldsString("cityrescode,comcategory,brand");
		DataPackage res2ComcateDP = comcatebrandBO.doQueryRes2Comcate(comcatebrandDBParam,user.getCityid());	
				
		//对可订购量集合进行遍历(套卡)
		Map<String,String> brand2Comcategory = new HashMap<String,String>();//套卡品牌-->商品种类，对应关系
		Map<String,String> brand2Res = new HashMap<String,String>();//套卡品牌-->地市资源代码，对应关系
		for(int i = 0;i<brandList.size();i++){
			boolean brandFlag = false;
			CanorderinfoVO bvo = (CanorderinfoVO)brandList.get(i);
			String rcBrand = bvo.getBrand();
			if(rcBrand != null && !"".equals(rcBrand) && rcBrand.indexOf(",")>=0){
				//共享品牌处理
				String rcBrands[] = rcBrand.split(",");
				String allBr = "";
				if(rcBrands != null && !"".equals(rcBrands) && rcBrands.length > 0){
					
					for(int j=0 ; j<rcBrands.length ; j++){
						String inBra = rcBrands[j];//共享品牌中每个品牌
						boolean innerBrandFlag_j = false;//共享品牌中每个品牌是否在在地市资源代码
						String inBraRes = "";
						
						if(res2ComcateDP != null && !"".equals(res2ComcateDP) 
								&& res2ComcateDP.getDatas() != null && !"".equals(res2ComcateDP.getDatas())
								&& res2ComcateDP.getDatas().size() > 0){
							for(int k=0 ; k<res2ComcateDP.getDatas().size() ; k++){
								Map obj = (Map)res2ComcateDP.getDatas().get(k);
								
								if(obj != null && obj.get("brand") != null && obj.get("brand").equals(inBra)){
									innerBrandFlag_j = true;
									inBraRes = (String)obj.get("cityrescode") ;
									if(!brand2Comcategory.containsKey(rcBrand))
										brand2Comcategory.put(inBra, (String)obj.get("comcategory"));
									if(!brand2Res.containsKey(rcBrand)){
										brand2Res.put(inBra, (String)obj.get("cityrescode"));
									}
									break;
								}
							}
						}
						
						allBr = allBr + inBraRes + ",";
						if(!innerBrandFlag_j){
							//共享品牌中某个品牌不在在地市资源代码
							String errStr3 = "品牌["+inBra+"]未设置[所有品牌都要有的地市资源代码？]对应的地市资源代码，请联系系统管理员检查。";
							
							throw new Exception(errStr3);
						}
					}
					if(allBr != null && !"".equals(allBr)){
						allBr = allBr.substring(0, (allBr.length()-1));
					}
				}
				
				brand2Res.put(rcBrand, allBr);
			}else{
				//非共享品牌处理
				if(res2ComcateDP != null && !"".equals(res2ComcateDP) 
						&& res2ComcateDP.getDatas() != null && !"".equals(res2ComcateDP.getDatas())
						&& res2ComcateDP.getDatas().size() > 0){
					for(int j=0 ; j<res2ComcateDP.getDatas().size() ; j++){
						Map obj = (Map)res2ComcateDP.getDatas().get(j);
						
						if(obj != null && obj.get("brand") != null && obj.get("brand").equals(rcBrand)){
							brandFlag = true;
							if(!brand2Comcategory.containsKey(rcBrand))
								brand2Comcategory.put(rcBrand, (String)obj.get("comcategory"));
							if(!brand2Res.containsKey(rcBrand)){
								brand2Res.put(rcBrand, (String)obj.get("cityrescode"));
								break;
							}
						}						
					}
				}
				if(!brandFlag){
					String errStr3 = "品牌["+rcBrand+"]未设置[所有品牌都要有的地市资源代码？]对应的地市资源代码，请联系系统管理员检查。";
					
					throw new Exception(errStr3);
				}
			}
			
		}
		
		//对可订购量集合进行遍历(充值卡)
		CityrescodeBO cityrescodeBO = (CityrescodeBO) BOFactory.build(CityrescodeBO.class, user);
		CityrescodeDBParam cityrescodeDBParam = new CityrescodeDBParam();
		cityrescodeDBParam.setDataOnly(true);
		cityrescodeDBParam.setQueryAll(true);
		cityrescodeDBParam.set_se_cityid(user.getCityid());
		DataPackage crDP = cityrescodeBO.doQuery(cityrescodeDBParam);
		Map<String,String> category2Res = new HashMap<String,String>();//商品种类-->地市资源代码，对应关系
		for(int i = 0;i<cardList.size();i++){
			boolean brandFlag = false;
			CanorderinfoVO cvo = (CanorderinfoVO)cardList.get(i);
			if (null == crDP
					|| null == crDP.getDatas()
					|| crDP.getDatas().size() < 1){
				
			}else{
				List litTmp = crDP.getDatas();
				if(litTmp != null && !"".equals(litTmp) 
						&& litTmp.size() > 0){
					for(int j=0 ; j<litTmp.size() ; j++){
						CityrescodeVO cityrescodeVO = (CityrescodeVO)litTmp.get(j);
						if(cityrescodeVO.getComcategory().equals(cvo.getCardtype())){
							brandFlag = true;
							if(!category2Res.containsKey(cvo.getCardtype()))
								category2Res.put(cvo.getCardtype(), cityrescodeVO.getCityrescode());
						}
					}
				}
			}
			if(!brandFlag){
				String errStr4 = "充值卡["+cvo.getCardtype()+"]未设置对应的地市资源代码，请联系系统管理员检查。";
				
				throw new Exception(errStr4);
			}
		}
		
		//对可订购量集合进行遍历(空白SIM卡)
		CityrescodeBO cityrescodeBO1 = (CityrescodeBO) BOFactory.build(CityrescodeBO.class, user);
		CityrescodeDBParam cityrescodeDBParam1 = new CityrescodeDBParam();
		cityrescodeDBParam1.setDataOnly(true);
		cityrescodeDBParam1.setQueryAll(true);
		cityrescodeDBParam1.set_se_cityid(user.getCityid());
		DataPackage crDP1 = cityrescodeBO.doQuery(cityrescodeDBParam1);
		Map<String,String> category3Res = new HashMap<String,String>();//商品种类-->地市资源代码，对应关系
		for(int i = 0;i<emptyList.size();i++){
			boolean brandFlag = false;
			CanorderinfoVO cvo = (CanorderinfoVO)emptyList.get(i);
			if (null == crDP1
					|| null == crDP1.getDatas()
					|| crDP1.getDatas().size() < 1){
				
			}else{
				List litTmp = crDP1.getDatas();
				if(litTmp != null && !"".equals(litTmp) 
						&& litTmp.size() > 0){
					for(int j=0 ; j<litTmp.size() ; j++){
						CityrescodeVO cityrescodeVO = (CityrescodeVO)litTmp.get(j);
						if(cityrescodeVO.getComcategory().equals(cvo.getCardtype())){
							brandFlag = true;
							if(!category3Res.containsKey(cvo.getCardtype()))
								category3Res.put(cvo.getCardtype(), cityrescodeVO.getCityrescode());
						}
					}
				}
			}
			if(!brandFlag){
				String errStr4 = "空白SMIN卡["+cvo.getCardtype()+"]未设置对应的地市资源代码，请联系系统管理员检查。";
				
				throw new Exception(errStr4);
			}
		}
		
		//获取订购基数和最终订购量
		Map<String,Long> brandRes2Canorder = new HashMap<String,Long>();//地市资源代码（套卡品牌）-->最终订购量，对应关系
		Map<String,Long> cityRes2Canorder = new HashMap<String,Long>();//地市资源代码（充值卡）-->最终订购量，对应关系
		Map<String,Long> cityRes3Canorder = new HashMap<String,Long>();//地市资源代码（充值卡）-->最终订购量，对应关系
		Comorder comorder = (Comorder) BOFactory.build(ComorderBO.class,user);
		for(int i = 0;i<brandList.size();i++){//套卡品牌
			CanorderinfoVO bvo = (CanorderinfoVO)brandList.get(i);
			
			if(bvo.getBrand() != null && !"".equals(bvo.getBrand()) && bvo.getBrand().indexOf(",")>=0){
				//共享品牌，取第一个品牌的订购基数为默认的订购基数
				String rcBrands[] = bvo.getBrand().split(",");
				String unitage = comorder.doGetUnitage(user.getCityid(), 
						(String)brand2Comcategory.get(rcBrands[0]));
				long lastOrder = 0;
				if(unitage != null && !"".equals(unitage) && !"0".equals(unitage)
						&& bvo.getCanorder() != null && !"".equals(bvo.getCanorder()))
					lastOrder = ((long)(bvo.getCanorder()/Long.parseLong(unitage)))*Long.parseLong(unitage);
				
				brandRes2Canorder.put((String)brand2Res.get(bvo.getBrand()), lastOrder);
			}else{
				//非共享品牌
				String unitage = comorder.doGetUnitage(user.getCityid(), 
						(String)brand2Comcategory.get(bvo.getBrand()));
				long lastOrder = 0;
				if(unitage != null && !"".equals(unitage) && !"0".equals(unitage)
						&& bvo.getCanorder() != null && !"".equals(bvo.getCanorder()))
					lastOrder = ((long)(bvo.getCanorder()/Long.parseLong(unitage)))*Long.parseLong(unitage);
				brandRes2Canorder.put((String)brand2Res.get(bvo.getBrand()), new Long(lastOrder));
			}
		}
		for(int i = 0;i<cardList.size();i++){//充值卡
			CanorderinfoVO cvo = (CanorderinfoVO)cardList.get(i);
			
			String unitage = comorder.doGetUnitage(user.getCityid(), 
					cvo.getCardtype());
			long lastOrder = 0;
			if(unitage != null && !"".equals(unitage) && !"0".equals(unitage)
					&& cvo.getCardcanorder() != null && !"".equals(cvo.getCardcanorder()))
				lastOrder = ((long)(cvo.getCardcanorder()/Long.parseLong(unitage)))*Long.parseLong(unitage);
			cityRes2Canorder.put(category2Res.get(cvo.getCardtype()), new Long(lastOrder));
			
		}
		
		for(int i = 0;i<emptyList.size();i++){//空白SIM卡
			CanorderinfoVO cvo = (CanorderinfoVO)emptyList.get(i);
			
			String unitage = comorder.doGetUnitage(user.getCityid(), 
					cvo.getCardtype());
			long lastOrder = 0;
			if(unitage != null && !"".equals(unitage) && !"0".equals(unitage)
					&& cvo.getCardcanorder() != null && !"".equals(cvo.getCardcanorder()))
				lastOrder = ((long)(cvo.getCardcanorder()/Long.parseLong(unitage)))*Long.parseLong(unitage);
			cityRes3Canorder.put(category3Res.get(cvo.getCardtype()), new Long(lastOrder));
			
		}
		
		//获取短信接收号码和客户名称
		EmployeeBO employeeBO = (EmployeeBO) BOFactory.build(EmployeeBO.class, user);
		EmployeeDBParam employeeDBParam = new EmployeeDBParam();
		employeeDBParam.set_se_wayid(wayvo.getWayid());//匹配渠道编码等于合作商编码
		employeeDBParam.set_se_isnet(Short.parseShort("1"));//是否为店主字段为是（即ISNET=1）
		employeeDBParam.set_se_empstatus(Short.parseShort("0"));//用工状态为在岗（即EMPSTATUS=0）
		DataPackage employeeDP = employeeBO.doQuery(employeeDBParam);
		String employeename = "客户";
		String officetel = "";
		String errStr5 = "获取合作商["+wayvo.getWayid()+"]公务机号码失败，请检查该合作商基础资料。";
		if (null != employeeDP && !"".equals(employeeDP)
				&& null != employeeDP.getDatas() && !"".equals(employeeDP.getDatas())
				&& employeeDP.getDatas().size() > 0){
			EmployeeVO employeeVO = (EmployeeVO)employeeDP.getDatas().get(0);
			if(employeeVO.getEmployeename() != null 
					&& !"".equals(employeeVO.getEmployeename())){
				employeename = employeeVO.getEmployeename();
			}
			if(employeeVO.getOfficetel() != null 
					&& !"".equals(employeeVO.getOfficetel())){
				officetel = employeeVO.getOfficetel();
				if(officetel.length() != 11){					
					throw new Exception(errStr5);
				}
			}else{
				throw new Exception(errStr5);
			}			
		}else{			
			throw new Exception(errStr5);
		}
		String orderCom = "";
		
		Iterator iter = brandRes2Canorder.keySet().iterator();
		while (iter.hasNext()) {
		    String key = (String)iter.next();
		    Long val = brandRes2Canorder.get(key);
		    if(val != null && val.longValue() > 0){
			    if(key != null && !"".equals(key) && key.indexOf(",")>=0){
			    	//共享品牌
			    	String key1 = "(" + key.replaceAll(",", "+") + ")";
			    	orderCom = orderCom + key1 + val;
			    }else{
			    	//非共享品牌
			    	orderCom = orderCom + key + val;
			    }
		    }
		}
		iter = cityRes2Canorder.keySet().iterator();
		while (iter.hasNext()) {
		    Object key = iter.next();
		    Long val = cityRes2Canorder.get(key);
		    if(val != null && val.longValue() > 0){
		    	orderCom = orderCom + key + val;
		    }
		}
		
		sContentString = new String(sContentString);
		Map<String,String> keyAndValue = new HashMap<String,String>();
		keyAndValue.put("CUSTNAME", employeename);
		keyAndValue.put("WAYID", wayvo.getWayid());
		keyAndValue.put("ORDERCOM", orderCom);
		Smstmpl smstmplBO = (SmstmplBO)BOFactory.build(SmstmplBO.class,user);
		String content = smstmplBO.doGenSMS("FX_ORDER_NOTICE",sContentString,keyAndValue);
		
		coiVO.setSmsContent(content);
		coiVO.setOfficetel(officetel);
		
		return coiVO;
	}
	
	/**
	 * 根据标识（FX_ORDER_NOTICE）、生效状态（1）查询短信模板表
	 * （CH_SMS_SMSTMPL），获取模板内容，如果无数据或内容为空，则提示并退出
	 */	
	public String getSmsContent() throws Exception{
			
		Smstmpl smstmplBO = (SmstmplBO) BOFactory.build(SmstmplBO.class, user);
		SmstmplDBParam param = new SmstmplDBParam();
		param.setDataOnly(true);
		param.set_se_sid("FX_ORDER_NOTICE");
		param.set_se_sstate("1");
		DataPackage dp = smstmplBO.doQuery(param);
		if (null == dp
				|| null == dp.getDatas()
				|| dp.getDatas().size() < 1){
			
			return "";
		}
			
		SmstmplVO smstmplVO = (SmstmplVO) dp.getDatas().get(0);
		
		return smstmplVO.getScontent();
	}

	public List doQueryBrand(List brandList, DBAccessUser user,WayVO wayvo) throws Exception {
		String wayid = wayvo.getWayid();
		Comorder comorder = (Comorder) BOFactory.build(ComorderBO.class,user);
		//参数载入-->获取套卡品牌集合
		List<DictitemVO> brandlist1 = comorder.doGetBrandList(wayid);
				
		//获取套卡订购信息（预警库存）
		List<OrderStockalarmVO> orderStockalarmList = comorder
			.doGetOrderInfoByStockalarm(wayvo,brandlist1);			
		if(orderStockalarmList != null 
				&& !"".equals(orderStockalarmList)
				&& orderStockalarmList.size()>0){
			for(int i=0; i<orderStockalarmList.size(); i++){
				OrderStockalarmVO orderStockalarmVO = (OrderStockalarmVO)orderStockalarmList.get(i);
				
				CanorderinfoVO bvo = new CanorderinfoVO();
				bvo.setBrand(orderStockalarmVO.getBrand());
				bvo.setBrandName(orderStockalarmVO.getBrandsName());
				bvo.setCanorder(0L);	//可订购量
				bvo.setMaxorder(0L);	//最高库存
				bvo.setCurorder(0L);	//当前库存
				bvo.setThrmonavg(0d);	//前三月平均激活量
				bvo.setSixmonavg(0d);	//前六月平均激活量 
				bvo.setReferdata("");	//参考数据 
				bvo.setCanorder((orderStockalarmVO.getMaxStock()
						-orderStockalarmVO.getNowstock()));
				if(bvo.getCanorder()<0){
					bvo.setCanorder(0L);
				}
				bvo.setMaxorder(orderStockalarmVO.getMaxStock());
				bvo.setCurorder(orderStockalarmVO.getNowstock());
				
				brandList.add(bvo);
				
			}
		}
					
		//获取参考数据
		int intervalThr = 3;
		doStat(brandList,intervalThr,wayid,user);
		int intervalSix = 6;
		doStat(brandList,intervalSix,wayid,user);
		List brandListTmp = new ArrayList<CanorderinfoVO>();
		for(int j = 0;j<brandList.size();j++){
			CanorderinfoVO bvo = (CanorderinfoVO)brandList.get(j);
			brandListTmp.add(bvo);
		}
		for(int j = 0;j<brandListTmp.size();j++){
			CanorderinfoVO bvo = (CanorderinfoVO)brandListTmp.get(j);
			if(bvo.getCanorder() == 0 && bvo.getMaxorder() == 0
					&& bvo.getCurorder() == 0 && bvo.getThrmonavg() == 0
					&& bvo.getSixmonavg() == 0 ){
				brandList.remove(bvo);
			}
		}
		
		return brandList;
	}
	
	/**
	 * 前三月平均激活量、或前六月平均激活量 ；统计
	 * 
	 * 
	 * @param brandList	品牌列表
	 * @param interval	前推6个月、或前推3个月
	 * @param wayid		合作商编码
	 * @throws Exception
	 */
	public void doStat(List brandList,int interval,String wayid,DBAccessUser user) throws Exception{
		Date[] periodTime = PublicUtils.getMonthPeriod(new Date(), interval);			
		CanorderinfoDBParam canorderinfoParams = new CanorderinfoDBParam();
		canorderinfoParams.setDataOnly(true);
		canorderinfoParams.setQueryAll(true);
		canorderinfoParams.setWayid(wayid);
		canorderinfoParams.setBegintime(periodTime[0]);
		canorderinfoParams.setEndtime(periodTime[1]);
		canorderinfoParams.setSelectFieldsString("month,brand,count");
		Canorderinfo canorderinfoBO = (Canorderinfo)BOFactory.build(CanorderinfoBO.class,user);
		List canorderinfoList= canorderinfoBO.doStatPartnerres(canorderinfoParams);
		Map<String,List> brandGroup = new HashMap<String,List>();//按品牌分组后的套卡激活量进行统计
		if (null == canorderinfoList || "".equals(canorderinfoList)
				|| canorderinfoList.size() < 1){
			//不处理
		}else{
			for(int i=0; i<canorderinfoList.size(); i++){
				Object[] tmpList = (Object[])canorderinfoList.get(i);
					if(brandGroup.containsKey(tmpList[1])){
						List ll = brandGroup.get((String)tmpList[1]);
						ll.add(tmpList);
					}else{
						List ll = new ArrayList();
						ll.add(tmpList);
						
						brandGroup.put((String)tmpList[1], ll);
					}
			}
		}
		for(int j = 0; j<brandList.size(); j++){
			CanorderinfoVO bvo = (CanorderinfoVO)brandList.get(j);
			if(bvo.getBrand().indexOf(",")>=0){//共享品牌
				Map brandMap = Code2NameUtils.valueList("$FX_SMPBRAND", user.getCityid());
				
				List referdataList = new ArrayList();
				String rcBrands[] = bvo.getBrand().split(",");
				String allBr = "";
				long count = 0;
				if(rcBrands != null && !"".equals(rcBrands) && rcBrands.length > 0){
					for(int k=0 ; k<rcBrands.length ; k++){
						String inBra = rcBrands[k];//共享品牌中每个品牌
						if(brandGroup.containsKey(inBra)){
							List ll = brandGroup.get(inBra);
							
							SimpleDateFormat sdf0 = new SimpleDateFormat("yyyyMM");
							SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy年MM月 ");
							
							for(int l = 0; l<ll.size(); l++){
								Object[] tmpList = (Object[])ll.get(l);
								if(tmpList[2] != null && !"".equals(tmpList[2])){
									count = count + Integer.parseInt(tmpList[2].toString());
								}
								//参考数据，处理
								if(tmpList[0] != null && !"".equals(tmpList[0])){
									Date date = sdf0.parse(tmpList[0].toString());
									String rd = sdf1.format(date) + (String)brandMap.get(inBra) + " " + tmpList[2] ;
									CanorderinfoVO cv = new CanorderinfoVO();
									cv.setReferdata(rd);
									referdataList.add(cv);
								}
							}
						}
					}
				}
				
//				NumberFormat nf = NumberFormat.getIntegerInstance();
//				nf.setMinimumFractionDigits(2);//指定小数位数
				DecimalFormat df = new DecimalFormat("#.##");
				if(interval == 3){
					bvo.setThrmonavg(new Double(df.format((double)(1.0*count/rcBrands.length/interval))));
				}
				if(interval == 6){
					//参考数据，处理
					bvo.setReferdataList(referdataList);
					bvo.setSixmonavg(new Double(df.format((double)(1.0*count/rcBrands.length/interval))));
				}
			}else{
				doStat1(brandGroup, bvo.getBrand(), bvo, interval);
			}
		}
	}
	
	public void doStat1(Map<String,List> brandGroup, String brand, CanorderinfoVO bvo, int interval) throws Exception{
		if(brandGroup.containsKey(brand)){
			List ll = brandGroup.get(brand);
			long count = 0;
			SimpleDateFormat sdf0 = new SimpleDateFormat("yyyyMM");
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy年MM月 ");
			
			List referdataList = new ArrayList();
			for(int k = 0; k<ll.size(); k++){
				Object[] tmpList = (Object[])ll.get(k);
				if(tmpList[2] != null && !"".equals(tmpList[2])){
					count = count + Integer.parseInt(tmpList[2].toString());
				}
				//参考数据，处理
				if(tmpList[0] != null && !"".equals(tmpList[0])){
					Date date = sdf0.parse(tmpList[0].toString());
					String rd = sdf1.format(date) + tmpList[2] ;
					CanorderinfoVO cv = new CanorderinfoVO();
					cv.setReferdata(rd);
					referdataList.add(cv);
				}
			}
			
//			NumberFormat nf = NumberFormat.getIntegerInstance();
//			nf.setMinimumFractionDigits(2);//指定小数位数
			DecimalFormat df = new DecimalFormat("#.##");
			if(interval == 3){
				bvo.setThrmonavg(new Double(df.format((double)(1.0*count/interval))));
			}
			if(interval == 6){
				//参考数据，处理
				bvo.setReferdataList(referdataList);
				bvo.setSixmonavg(new Double(df.format((double)(1.0*count/interval))));
			}
		}
	}
	
	public List doQueryStock(List cardList, DBAccessUser user, WayVO wayvo) throws Exception {
		// TODO Auto-generated method stub
		String wayid = wayvo.getWayid();
		Comorder comorder = (Comorder) BOFactory.build(ComorderBO.class,user);
		
		List<OrderCardVO> orderCardList = comorder.doGetOrderInfoByCard(wayvo);
		if(orderCardList != null && !"".equals(orderCardList)
				&& orderCardList.size() > 0){
			for(int i = 0;i<orderCardList.size();i++){
				OrderCardVO ocVO = orderCardList.get(i);
				CanorderinfoVO cvo = new CanorderinfoVO();
				
				cvo.setCardtype(ocVO.getComcategory());				//充值卡种类
				
				/*
				 * 在获取oncelimit时限制了为null时为0, 我们这里处理的时候 如果oncelimit为0时，
				 * 可订购量就取ocVO.getOrderRemainMonth()  ocVO.getOrderRemainDay() 
				 * 中的最小值
				 * 
				 * 可订购量取当月剩余订购量、当天剩余订购量和单次订购上限三者中最小值
				 */				
				//cvo.setCardcanorder(ocVO.getOrderRemainMonth());	//可订购量
				if(ocVO.getOncelimit() == null || "".equals(ocVO.getOncelimit())
						|| ocVO.getOncelimit() == 0){
					if(ocVO.getOrderRemainMonth() < ocVO.getOrderRemainDay()){
						cvo.setCardcanorder(ocVO.getOrderRemainMonth());	//可订购量
					}else{
						cvo.setCardcanorder(ocVO.getOrderRemainDay());	//可订购量
					}
				}else{
					if(ocVO.getOrderRemainMonth() < ocVO.getOrderRemainDay()){
						if(ocVO.getOrderRemainMonth() < ocVO.getOncelimit()){
							cvo.setCardcanorder(ocVO.getOrderRemainMonth());	//可订购量
						}else{
							cvo.setCardcanorder(ocVO.getOncelimit());	//可订购量
						}
					}else{
						if(ocVO.getOrderRemainDay() < ocVO.getOncelimit()){
							cvo.setCardcanorder(ocVO.getOrderRemainDay());	//可订购量
						}else{
							cvo.setCardcanorder(ocVO.getOncelimit());	//可订购量
						}
					}
				}
				
				cvo.setCardmonlim(ocVO.getOrderMaxMonth());			//月订购上限
				cvo.setCarddaylim(ocVO.getOrderMaxDay());			//日订购上限 
				cvo.setCardtimelim(ocVO.getOncelimit());		//单次订购上限
				cvo.setCardmonordered(ocVO.getOrderedMonth());		//当月已订购
				cvo.setCarddayordered(ocVO.getOrderedDay());		//当日已订购 
				
				if(cvo.getCardcanorder()<0){
					cvo.setCardcanorder(0L);
				}
				
				cardList.add(cvo);
			}
		}
		
		return cardList;
	}

	//获取空白SIM卡订购信息
	public List doQueryEmpty(List emptyList, DBAccessUser user, WayVO wayvo) throws Exception {
		// TODO Auto-generated method stub
		String wayid = wayvo.getWayid();
		Comorder comorder = (Comorder) BOFactory.build(ComorderBO.class,user);
		
		List<OrderCardVO> orderCardList = comorder.doGetOrderInfoByEmptyCard(wayvo);
		if(orderCardList != null && !"".equals(orderCardList)
				&& orderCardList.size() > 0){
			for(int i = 0;i<orderCardList.size();i++){
				OrderCardVO ocVO = orderCardList.get(i);
				CanorderinfoVO cvo = new CanorderinfoVO();
				
				cvo.setCardtype(ocVO.getComcategory());				//充值卡种类
				
				/*
				 * 在获取oncelimit时限制了为null时为0, 我们这里处理的时候 如果oncelimit为0时，
				 * 可订购量就取ocVO.getOrderRemainMonth()  ocVO.getOrderRemainDay() 
				 * 中的最小值
				 * 
				 * 可订购量取当月剩余订购量、当天剩余订购量和单次订购上限三者中最小值
				 */				
				//cvo.setCardcanorder(ocVO.getOrderRemainMonth());	//可订购量
				if(ocVO.getOncelimit() == null || "".equals(ocVO.getOncelimit())
						|| ocVO.getOncelimit() == 0){
					if(ocVO.getOrderRemainMonth() < ocVO.getOrderRemainDay()){
						cvo.setCardcanorder(ocVO.getOrderRemainMonth());	//可订购量
					}else{
						cvo.setCardcanorder(ocVO.getOrderRemainDay());	//可订购量
					}
				}else{
					if(ocVO.getOrderRemainMonth() < ocVO.getOrderRemainDay()){
						if(ocVO.getOrderRemainMonth() < ocVO.getOncelimit()){
							cvo.setCardcanorder(ocVO.getOrderRemainMonth());	//可订购量
						}else{
							cvo.setCardcanorder(ocVO.getOncelimit());	//可订购量
						}
					}else{
						if(ocVO.getOrderRemainDay() < ocVO.getOncelimit()){
							cvo.setCardcanorder(ocVO.getOrderRemainDay());	//可订购量
						}else{
							cvo.setCardcanorder(ocVO.getOncelimit());	//可订购量
						}
					}
				}
				
				cvo.setCardmonlim(ocVO.getOrderMaxMonth());			//月订购上限
				cvo.setCarddaylim(ocVO.getOrderMaxDay());			//日订购上限 
				cvo.setCardtimelim(ocVO.getOncelimit());		//单次订购上限
				cvo.setCardmonordered(ocVO.getOrderedMonth());		//当月已订购
				cvo.setCarddayordered(ocVO.getOrderedDay());		//当日已订购 
				
				if(cvo.getCardcanorder()<0){
					cvo.setCardcanorder(0L);
				}
				
				emptyList.add(cvo);
			}
		}
		
		return emptyList;
	}
	
	public String doCheckWayAndModel(DBAccessUser user, WayVO wayvo, String wayid)
			throws Exception {
		//合作商检查
		Way way = (Way)BOFactory.build(WayBO.class, user);
		WayDBParam wayParams = new WayDBParam();
		wayParams.set_se_cityid(user.getCityid());
		wayParams.set_se_wayid(wayid);
		wayParams.set_se_waytype("AG");//社会渠道（即WAYTYPE=AG)
		DataPackage wayDp= way.doQuery(wayParams);
		//WayVO wayvo = null;//合作商信息
		if (null == wayDp
				|| null == wayDp.getDatas()
				|| wayDp.getDatas().size() < 1){
			//不处理
			String errStr1 = "合作商信息不存在，请检查合作商编码是否正确";
			
			throw new Exception(errStr1);
			
			
		}else{
			WayVO wayvo1 = (WayVO)wayDp.getDatas().get(0);
			BeanUtils.copyProperties(wayvo, wayvo1);
		}
		
		if (wayvo.getWaystate() != 1) {
			throw new Exception("合作商状态不为开店状态");
		}
		
		if(wayvo.getCountyid() == null || "".equals(wayvo.getCountyid()) ||
				wayvo.getStarlevel() == null || "".equals(wayvo.getStarlevel())){
			String errStr2 = "合作商信息不完整，请检查。";
			
			throw new Exception(errStr2);
			
		}
		
		//参数载入-->获取订购量约束模式
		Sysparam sysparamBO=(Sysparam)BOFactory.build(SysparamBO.class,user);
		String sysparamvalue45 = sysparamBO.doFindByID("45", "pboss_fx");
		String errStr2 = "订购量约束模式参数无数据，请联系系统管理员进行检查。";
		if(sysparamvalue45 == null || "".equals(sysparamvalue45)){			
			
			throw new Exception(errStr2);
			
			
		}else{
			if(!sysparamvalue45.equals("STOCKALARM")){
				errStr2 = "订购量约束非预警库存模式，请联系系统管理员进行检查。";
				
				throw new Exception(errStr2);
								
			}
		}
		
		return "";
	}
}
