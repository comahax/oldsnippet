package com.sunrise.boss.business.fee.billing.billstatus.control;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.sunrise.boss.business.fee.acccounting.control.AccountingUtils;
import com.sunrise.boss.business.fee.billing.billparam.persistent.BillParamDAO;
import com.sunrise.boss.business.fee.billing.billparam.persistent.BillParamVO;
import com.sunrise.boss.business.fee.billing.billresult.persistent.BillResultDAO;
import com.sunrise.boss.business.fee.billing.billresult.persistent.BillResultVO;
import com.sunrise.boss.business.fee.billing.billstatus.persistent.BillStatusDAO;
import com.sunrise.boss.business.fee.billing.billstatus.persistent.BillStatusDBParam;
import com.sunrise.boss.business.fee.billing.billstatus.persistent.BillStatusVO;
import com.sunrise.boss.business.fee.billing.bltouchrule.persistent.BlTouchRuleDAO;
import com.sunrise.boss.business.fee.billing.bltouchrule.persistent.BlTouchRuleVO;
import com.sunrise.boss.business.fee.billing.validbillcyc.persistent.ValidBillCycDAO;
import com.sunrise.boss.business.fee.billing.validbillcyc.persistent.ValidBillCycDBParam;
import com.sunrise.boss.business.fee.billing.validbillcyc.persistent.ValidBillCycVO;
import com.sunrise.boss.web.fee.billing.billstatus.RegionData;
import com.sunrise.boss.web.fee.billing.billstatus.StatusBean;

import org.apache.commons.beanutils.BeanUtils;
import com.sunrise.jop.common.utils.lang.Code2NameUtils;
import com.sunrise.jop.infrastructure.component.impl.LocalNote;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.CityMappingUtil;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DBConstant;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;





public class BillStatusBO extends AbstractControlBean implements
		BillStatus {
	private static Logger log = Logger.getLogger(BillStatusBO.class) ;

	public String[] doShow(BillStatusDBParam params) throws Exception {
		
    	String[] states = new String[14];
    	
    	String[] citys = AccountingUtils.getcitys(params.getRegiongroup()); //  通信费确认由D101 改为 106
    	// 2013-12月25问题 反馈 由于月切和出帐导数登记的阶段冲突了 都是F101，月切改用B100
    	// 2014-05-20 增加 出账前导数E100
    	// 2014-12-16增加积分计算Q101和积分入库R101两阶段  YinGP
    	String[] phase = {"B100","B101","B103","C101","C102","E100","E101","A105","Q101","R101"};
//    	String[] phase = {"F101","B101","B103","C101","C102","D101","E101","A105","50","51","102","103","104","105"};//变更后各步骤编号
//    	String[] phase = {"A101","A102","A103","A104","A106","B101","C101","D101","G101","E101","F101"};//变更前各步骤编号
    	for(int i = 0 ; i < phase.length ; i++){
    		List list = new ArrayList();
    		for(int j = 0 ; j < citys.length ; j++){
    			try {
//    				if(phase[i].equals("50") || phase[i].equals("106") || phase[i].equals("102") || phase[i].equals("103") || phase[i].equals("104") || phase[i].equals("105")){
//    					doQueryRh(params, list, phase[i], citys[j]);
//    				}else{
    					doQueryStat(params, list, phase[i], citys[j]);
//    				}
				} catch (Exception e) {
					e.printStackTrace();
				}
    		}
    		states[i] = chkState(list);
    	}    	
    	
    	return states;
	}

	private void doQueryRh(BillStatusDBParam params, List list, String phase, String city) throws Exception {
		
		BillStatusVO vo = doQueryVO(phase, "0", params.get_ne_validbillcyc(), city);
		if(vo == null){
			list.add(new Short("2"));
		}else{
			int state = vo.getState().intValue();
			if(state != 2 && state != 3 && state != 4){
				list.add(new Short("2"));
			}else{
				list.add(vo.getState());
			}
		}
	}

	//月切只查广州一个地市
	public String doQueryYueqie(String validbillcyc) throws Exception {
//		BillParamDAO paramdao = (BillParamDAO) DAOFactory.build(BillParamDAO.class, "200");
		BillParamDAO paramdao = (BillParamDAO) DAOFactory.build(BillParamDAO.class, super.getUser().getDbFlag());
		BillParamVO paramvo = (BillParamVO) paramdao.findByPk(new Long(1));
//		判断帐期是否已经完成出帐
//		ValidBillCycVO vbcvo = AccountingUtils.getVbcVO(new Long(validbillcyc), "200");
		ValidBillCycVO vbcvo = AccountingUtils.getVbcVO(new Long(validbillcyc), AccountingUtils.getCityid(super.getUser().getCityid()));
		
		boolean ispassvbc = false ;
		if(null != vbcvo.getState() && vbcvo.getState().intValue() == 1){
			ispassvbc = true; 
		}

		if(!ispassvbc && paramvo.getPvalue().equals("0")){//出帐未完成，要取计费的月切状态
			BillParamVO paramvo1 = (BillParamVO) paramdao.findByPk(new Long(2));
			HashMap localMap = getMonitorMap(paramvo1.getPvalue());		
			LocalNote local = (LocalNote) localMap.get("YUEQIE");
			String status = local.getValue("H101");
			if(status == null || "".equals(status)){
				return "0";
			}else{
				return status;
			}
		}else if(vbcvo == null && paramvo.getPvalue().equals("0")){//帐期未开始情况下
			return "0";
		}else if(!ispassvbc && paramvo.getPvalue().equals("1")){//出帐未完成，且查oracle库
//			BillStatusVO vo = doQueryVO("H101", "0", validbillcyc, "200");
			BillStatusVO vo = doQueryVO("H101", "0", validbillcyc, super.getUser().getCityid());
			if(vo == null){
				return "0";
			}else{
				return vo.getState().toString();
			}
		}else{//出帐完成情况下
//			BillStatusVO vo = doQueryVO("H101", "0", validbillcyc, "200");
			BillStatusVO vo = doQueryVO("H101", "0", validbillcyc, super.getUser().getCityid());
			if(vo == null){
				BillStatusVO newvo = doInsertYueQie(new Short("3"), new Long(validbillcyc), super.getUser().getCityid());
				return newvo.getState().toString();
			}else{
				return vo.getState().toString();
			}
		}
	}

	private BillStatusVO doInsertYueQie(Short state, Long validbillcyc, String cityid) {
		
		BillStatusVO newvo = new BillStatusVO();
		newvo.setPhase("H101");
		newvo.setSubphase(new Short("0"));
		newvo.setPhasename("月切");
		newvo.setValidbillcyc(validbillcyc);
		newvo.setState(state);
		newvo.setStarttime(new Date(System.currentTimeMillis()));
		newvo.setEndtime(new Date(System.currentTimeMillis()));
		//  FS +BILL
		String mergeDBFlag = AccountingUtils.getCityid(cityid)+DBConstant.DB_FLAG_BILL;
		BillStatusDAO dao = (BillStatusDAO) DAOFactory.build(BillStatusDAO.class, cityid);
		try {
			dao.create(newvo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newvo;
	}

	public List doShowProc(BillStatusDBParam params) throws Exception {
		String[] citys = AccountingUtils.getcitys(params.getRegiongroup());
		String steps[] = params.get_se_phase().split(",");
		List list = new ArrayList();
		for(int i = 0 ; i < citys.length ; i++){
			RegionData databean = new RegionData();
			List statuslist = new ArrayList();
			for(int j = 1 ; j < steps.length ; j++){
				try {
					
					// 零点余额和零点欠费自步骤只有珠海显示 add by 2012-12-28
					// 步骤对应关系  零点余额-10   零点欠费-11
					if(!citys[i].equalsIgnoreCase("ZH")){
						if(steps[0].equalsIgnoreCase("E101") && (steps[j].equals("10") || steps[j].equals("11"))){							
							continue;
						}
					}
					// 只有梅州，显示出“固定费入库” add by pmf 2014-03-06 
					if(!citys[i].equalsIgnoreCase("MZ")){
						if(steps[0].equalsIgnoreCase("E101") && steps[j].equals("12")){							
							continue;
						}
					}
					
					StatusBean bean = new StatusBean();
					bean.setStepname(steps[0] + steps[j]);
					bean.setSubphase(new Short(steps[j]));
					BillStatusVO vo = doQueryVO(steps[0], steps[j], params.get_ne_validbillcyc(), citys[i]);
					
					if(vo == null){						
						bean.setStatus(new Short("0"));
					}else if(vo.getState().intValue() > 4 || vo.getState().intValue() < 0){					
						
						bean.setStatus(new Short("0"));
					}else{						
						bean.setStatus(vo.getState());
					}				
					
					statuslist.add(bean);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}			
			String cityid = AccountingUtils.regionmap.get(citys[i]).toString();
			databean.setRegion(cityid);
			databean.setStatusdata(statuslist);
			list.add(databean);			
		}
		return list;
	}
	
	private void doQueryStat(BillStatusDBParam params, List list, String phase, String city) throws Exception{
		BillStatusVO vo = this.doQueryVO(phase, "0", params.get_ne_validbillcyc(), city);
		if(vo == null){
			list.add(new Short("0"));
		}else{
			if(vo.getState().intValue() < 0 || vo.getState().intValue() > 4){
				list.add(new Short("0"));
			}else{
				list.add(vo.getState());
			}
		}
	}

	public void doStart(int type, BillStatusVO vo, User user) throws Exception {//type:0,新建 1，更新
		
//		ExcelCodeToName et = new ExcelCodeToName();
//		String stepname = et.codeToName("#SUBPHASENAME", vo.getPhase() + vo.getSubphase().toString() , user);
		String stepname = Code2NameUtils.code2Name("#SUBPHASENAME", vo.getPhase() + vo.getSubphase().toString(),user.getCityid());
		
		try {
			BillStatusDAO dao = (BillStatusDAO) DAOFactory.build(BillStatusDAO.class, user);
			if(type == 0){
				dao.create(vo);
			}else{
				dao.update(vo);
			}
			
			BillResultDAO resdao = (BillResultDAO) DAOFactory.build(BillResultDAO.class, user);
			BillResultVO resvo = new BillResultVO();
			BeanUtils.copyProperties(resvo, vo);
			resvo.setIntime(new Date(System.currentTimeMillis()));

			resvo.setResult(stepname + "前台启动成功!");
			resdao.create(resvo);
		} catch (Exception e) {
			throw new Exception(stepname + "前台启动失败，失败原因：" + e.getMessage());
		}
	}

	private HashMap getMonitorMap(String pvalue) throws Exception{
		
		SAXReader saxReader = new SAXReader(); 
		HashMap localMap = new HashMap();
		try{
			URL url = new URL(pvalue);		
			Document doc = saxReader.read(url);
			List dynamicList = doc.selectNodes("syscode-local");			
			
	        Iterator iter = dynamicList.iterator();
	        while(iter.hasNext()){
	            Element localElement = (Element)iter.next();
	            LocalNote local = new LocalNote();
	            Element definition = localElement.element("definition");
	            local.setDefinition(definition.getTextTrim());   //注意，要去除空格
	            Iterator iterItems = localElement.element("items").elementIterator("itemvalue");
	            Map itemvalue = new HashMap();
	            while( iterItems.hasNext() ){
	            	Element item = (Element)iterItems.next();
	            	itemvalue.put( item.attribute("code").getValue(),item.getTextTrim() );
	            }
	            local.setItems(itemvalue);
	            localMap.put(local.getDefinition(), local);
	        }
        } catch (Exception ex) {	
        	log.error("获取计费出帐步骤信息出错:" + ex.getMessage(),ex);        	
			throw new Exception("获取计费出帐步骤信息出错:  " + ex.getMessage(),ex);
		}
        
        return localMap;
	}
	
	public BillStatusVO doQueryVO(String phase, String subphase, String validbillcyc, String city) throws Exception{

		// city 有二种形态  FS ,757  需要转换为字母形态	
		if(AccountingUtils.cityGroup.containsKey(city)){
			city = AccountingUtils.getCityid(city);
		}		
		
		String mergecity = city+DBConstant.DB_FLAG_BILL;
//		//begin 2013-12-12 包级对账数据保存在FS库 所以做以下改造，现在不限制
//		if(phase !=null && phase.equals("B101")){
//			mergecity= "FS"+DBConstant.DB_FLAG_BILL;
//		}
//		// end
		BillStatusDAO dao = (BillStatusDAO) DAOFactory.build(BillStatusDAO.class, mergecity);
		
		BillStatusDBParam listVO = new BillStatusDBParam();
		listVO.set_ne_validbillcyc(validbillcyc);
		listVO.set_se_phase(phase);
		listVO.set_ne_subphase(subphase);
		//begin 2013-12-12 包级对账数据保存在FS库 所以做以下改造 
//		if(phase !=null && !phase.equals("B101")){
		listVO.set_ne_region(AccountingUtils.regionmap.get(city).toString()); // 新增地市标识，2012.05
//		}
		
		DataPackage dp = dao.query(listVO);
		if(dp == null || dp.getDatas() == null || dp.getDatas().size() == 0){
			return null ;
		}else{
			BillStatusVO vo = (BillStatusVO) dp.toList(BillStatusVO.class).get(0);
			return vo;
		}
	}
	
	public String chkState(List list) {
		String state = "0";
		StringBuffer _strBState = new StringBuffer();

		if (null != list) {

			for (int i = 0; i < list.size(); i++) {

				Object ob = (Object) list.get(i);
				String _state = ob == null ? "0" : ob.toString();
				_strBState.append(_state);

				if ("4".equals(_state)) {//错误
					return _state;
				}
				if ("2".equals(_state)) {//运行中
					state = _state;
				}
			}
			if ("2".equals(state)) {
				return state;
			}

			String _strState = _strBState.toString();
			
			if ( _strState.indexOf("1") == -1) {//只有0 未启动
				if (_strState.indexOf("3") == -1){
					return "0";
				}
			}
			if ( _strState.indexOf("1") == -1) {//只有3 已完成
				if (_strState.indexOf("0") == -1){
					return "3";
				}
			}
			if ( _strState.indexOf("3") == -1) {//只有1 可启动
				if (_strState.indexOf("0") == -1){
					return "1";
				}
			}
			
			//其余组合返回启动中
			return "2";
		}

		return state;
	}

	public String doQueryConfirmBill(BillStatusDBParam listVO) throws Exception {
		List list = new ArrayList();
		String[] citys = AccountingUtils.getcitys(listVO.getRegiongroup());
		
		for(int i = 0 ; i < citys.length ; i++){
			BlTouchRuleDAO dao = (BlTouchRuleDAO) DAOFactory.build(BlTouchRuleDAO.class,citys[i]+DBConstant.DB_FLAG_BILL );
			listVO.set_ne_region(AccountingUtils.regionmap.get(citys[i]).toString()); 
			DataPackage dp = dao.query(listVO);
			String str = "0";
			if(dp != null && dp.getDatas() != null && dp.getDatas().size() > 0){
				BlTouchRuleVO vo = (BlTouchRuleVO) dp.toList(BlTouchRuleVO.class).get(0);
				Long state = vo.getCfmbillstate();
				if(state != null && !"".equals(state.toString()) && state.intValue() >=0 && state.intValue() <= 4){
					str = vo.getCfmbillstate().toString();
				}
			}
			list.add(str);
			
		}
		
		return AccountingUtils.chkState(list);
	}
	
	/** 获取第一条有效账期 **/
	public ValidBillCycVO getValidBillCyc(String cityid) throws Exception {
		ValidBillCycVO vbcvo = null;
		try {
			//地市数据源拼接 
			String mergedbFlag = CityMappingUtil.getCity(cityid)+DBConstant.DB_FLAG_BILL;
			ValidBillCycDBParam param = new ValidBillCycDBParam();
			param.set_se_state("0");
			param.set_orderby("validbillcyc");
			param.set_desc("0");
			param.set_ne_region(cityid);
			
			ValidBillCycDAO vbcdao = (ValidBillCycDAO) DAOFactory.build(
					ValidBillCycDAO.class, mergedbFlag);		

			DataPackage dp = (DataPackage) vbcdao.query(param, 20); //只查数据不查记录数
			if(null != dp && null != dp.getDatas() && dp.getDatas().size()>0) {
				vbcvo =  (ValidBillCycVO)dp.getDatas().get(0);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return vbcvo;
	}
	
	
	public String[] doShowPrepaidFee(BillStatusDBParam params) throws Exception {
    	String[] states = new String[14];
    	String[] citys = AccountingUtils.getcitys(params.getRegiongroup());
    	//月切B100、累帐对账B101、无主回捞B102、账单优惠C100、预付费合账数据准备E102、预付费固定费生成A100、预付费低销计算G100、预付费低销确认H100、预付费低消入ABM库 I100
    	String[] phase = {"B100","B101","B103","C100","E102","A100","G100","H100","I100"};
    	for(int i = 0 ; i < phase.length ; i++){
    		List list = new ArrayList();
    		for(int j = 0 ; j < citys.length ; j++){
    			try {
					doQueryStat(params, list, phase[i], citys[j]);
				} catch (Exception e) {
					e.printStackTrace();
				}
    		}
    		states[i] = chkState(list);
    	}    	
    	return states;
	}
}
