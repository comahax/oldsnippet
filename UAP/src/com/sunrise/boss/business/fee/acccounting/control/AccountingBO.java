/**
 * 
 */
package com.sunrise.boss.business.fee.acccounting.control;

import java.net.URL;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.sunrise.boss.business.fee.acccounting.persistent.AccountingVO;
import com.sunrise.boss.business.fee.billing.billinglog.control.BillingLog;
import com.sunrise.boss.business.fee.billing.billinglog.control.BillingLogBO;
import com.sunrise.boss.business.fee.billing.billinglog.persistent.BillingLogDAO;
import com.sunrise.boss.business.fee.billing.billinglog.persistent.BillingLogDBParam;
import com.sunrise.boss.business.fee.billing.billinglog.persistent.BillingLogVO;
import com.sunrise.boss.business.fee.billing.billstartlog.persistent.BillStartLogDAO;
import com.sunrise.boss.business.fee.billing.billstartlog.persistent.BillStartLogDBParam;
import com.sunrise.boss.business.fee.billing.billstartlog.persistent.BillStartLogVO;
import com.sunrise.boss.business.fee.billing.billstatus.persistent.BillStatusDAO;
import com.sunrise.boss.business.fee.billing.billstatus.persistent.BillStatusVO;
import com.sunrise.boss.business.fee.billing.billstepstatus.persistent.BillStepStatusDAO;
import com.sunrise.boss.business.fee.billing.billstepstatus.persistent.BillStepStatusDBParam;
import com.sunrise.boss.business.fee.billing.bltouchrule.persistent.BlTouchRuleDAO;
import com.sunrise.boss.business.fee.billing.bltouchrule.persistent.BlTouchRuleVO;
import com.sunrise.boss.business.fee.billing.validbillcyc.persistent.ValidBillCycVO;

import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.common.utils.lang.StringSplit;
import com.sunrise.jop.infrastructure.component.impl.LocalNote;
import com.sunrise.jop.infrastructure.config.CoreConfigInfo;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DBConstant;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;



/**
 * Title: GDIBOSS
 * Description:
 * Copyright: Copyright (c) 2005
 * Company: sunrise Tech Ltd.
 * @author mys
 * @version 1.0
 */

public class AccountingBO extends AbstractControlBean implements
		Accounting {

	

	private static final Logger log = Logger.getLogger(AccountingBO.class);
	
	
	public List doTJAccounting(AccountingVO params, User user) throws Exception {
		
		List list = new ArrayList();

		if("*".equals(params.getCitygroup()[0]) || "*,".equals(params.getCitygroup()[0])){
			params.setCitygroup(AccountingUtils.REGION);
		}
		//params.setCitygroup(new String[]{"750","750","750","750","750","750","750","750","750","750","750","750","750","750","750"}); //测试语句		
		AccountingVO _params = new AccountingVO();
		_params.set_se_batchnum(params.get_se_batchnum());
		_params.set_ne_validbillcyc(params.get_ne_validbillcyc());	
		String[] billingphase = StringSplit.split(params.getIsshowlog(), ",");
		
		for(int i = 0 ; i < params.getCitygroup().length; i++ ){
			String cityid="";
			//地市转换 FS-757
			if(AccountingUtils.regionmap.containsKey(params.getCitygroup()[i]))
				cityid = AccountingUtils.regionmap.get(params.getCitygroup()[i]).toString();
			
			AccountingVO vo = new AccountingVO();
			vo.setCityid(cityid);
			vo.setCity(AccountingUtils.getCityCompid(cityid));
//			vo.setCityname((AccountingUtils.getCityName(cityid)));			
			vo.setCityname(AccountingUtils.cityGroup.get(cityid).toString());	
			params.set_ne_region(cityid);	//新增地市，201205

			BlTouchRuleVO btrvo = AccountingUtils.getBtrVO(params, cityid);
			vo.setBtrvo(null == btrvo ? new BlTouchRuleVO() : btrvo);	
			
			_params.setCityid(cityid);	
			for(int j = 0 ; j < billingphase.length; j++ ){
				_params.set_se_billingphase(billingphase[j]);
				if("101".equals(billingphase[j])){
					vo.setFixlist(doShowLog(_params, user));
				}
				if("102".equals(billingphase[j])){
					vo.setUsrlist(doShowLog(_params, user));
				}
				if("103".equals(billingphase[j])){
					vo.setAcclist(doShowLog(_params, user));
				}
				if("104".equals(billingphase[j])){
					vo.setCfmlist(doShowLog(_params, user));
				}
				
	
			}			
			
			vo.setIsrestart(isRestart(_params));
		
			
			list.add(vo);
		}
		return list;
		
	}
	
	public List doAccounting(AccountingVO params, User user) throws Exception {
		
		List list = new ArrayList();

		if("*".equals(params.getCitygroup()[0]) || "*,".equals(params.getCitygroup()[0])){
			params.setCitygroup(AccountingUtils.CITYID);
		}
		for(int i = 0 ; i < params.getCitygroup().length; i++ ){
			
			String cityid = AccountingUtils.getCityid(params.getCitygroup()[i]);
			AccountingVO vo = new AccountingVO();
			vo.setCityid(cityid);
			vo.setCityname((AccountingUtils.getCityName(cityid)));
			  
			
			vo.setVbcvo(AccountingUtils.getVbcVO(new Long(params.get_ne_validbillcyc()),cityid));						
			if(null != params.getOnlybrt() && !"".equals(params.getOnlybrt().trim())){
				/** 只有有效帐务周期显示用到 **/
				if(null == vo.getVbcvo().getValidbillcyc()){
					vo.setMessage("没有找到有效帐务周期!");
				}										
			}
			
			/****/
			if(null == params.getOnlybrt() || "".equals(params.getOnlybrt().trim())){
				BlTouchRuleVO btrvo = AccountingUtils.getBtrVO(params, cityid);				
				if(null == btrvo){
					vo.setMessage("没有找到出帐触发规则!");
				}else {
					vo.setBtrvo(btrvo);
				}										
			}	
			list.add(vo);
		}
		return list;
		
	}
	
	
	/**
	 * 参数必须保证cityid(哪个地市),和StepKey(出帐过程的哪个节点),出帐触发规则
	 */
	public AccountingVO doStartUp(AccountingVO params, User user) throws Exception {
		
		try{
			// 接拼地市数据源,如果在USER中修改,所有引用USER 的DAO层有影响，导致地市ID引用混乱
			String cityid = AccountingUtils.getCityid(params.getCityid());
			String mergedbFlag =cityid+DBConstant.DB_FLAG_BILL;
			
			BlTouchRuleDAO btrdao = (BlTouchRuleDAO) DAOFactory.build(BlTouchRuleDAO.class, mergedbFlag);
			
			ValidBillCycVO vbcvo = AccountingUtils.getVbcVO(new Long(params.get_ne_validbillcyc()), cityid);
			//出账确认后State这个状态就会改为1
			//前台在点“销账信控”的时候，这个值如果为1的话，那就是报下面这个错误了：
			//“该计费月有效账务周期已经完成，不允许启动”
			//为不影响其他步骤的操作，在触发“销账信控”时直接跳过State==1的判断
			//2012.4.23 panmeifa
			if(!"WOF".equals(params.getStepKey()) && null != vbcvo.getState() && vbcvo.getState().intValue() == 1){
				throw new Exception("该计费月有效账务周期已经完成，不允许启动!"); 
			}
			
			//用户出帐户启动要做合账数据准备E101和出账前导数E100是否完成的判断 2014-05-19 pmf
			if(params.getStepKey() != null && "USR".equals(params.getStepKey())){
				BillStatusDAO dao = (BillStatusDAO) DAOFactory.build(BillStatusDAO.class, mergedbFlag);
				BillStatusVO pkvo = new BillStatusVO();
				pkvo.setPhase("E101");
				pkvo.setSubphase(new Short("0"));
				pkvo.setValidbillcyc(new Long(params.get_ne_validbillcyc()));
				pkvo.setRegion(Integer.valueOf(params.getCityid())); //?新增地市,201311
				
				BillStatusVO statusvo = (BillStatusVO) dao.findByPk(pkvo);
				if(statusvo == null || (statusvo != null && (statusvo.getState() == null || statusvo.getState().intValue() != 3))){
					throw new Exception("合账数据准备未完成，不可以启动用户出账！");
				}
				
				pkvo.setPhase("E100");
				pkvo.setSubphase(new Short("0"));
				pkvo.setValidbillcyc(new Long(params.get_ne_validbillcyc()));
				pkvo.setRegion(Integer.valueOf(params.getCityid())); //?新增地市,201311
				
				statusvo = (BillStatusVO) dao.findByPk(pkvo);
				if(statusvo == null || (statusvo != null && (statusvo.getState() == null || statusvo.getState().intValue() != 3))){
					throw new Exception("出账前导数未完成，不可以启动用户出账！");
				}
			}
			
			BlTouchRuleVO btrvo = params.getBtrvo();			
			AccountingUtils.setState(btrvo, params.getStepKey(),user);	
			
			btrdao.update(btrvo);
			
			BillStartLogVO bslvo = new BillStartLogVO();
			BeanUtils.copyProperties(bslvo, btrvo);
			
			bslvo.setStartrsn(params.getStartrsn());
			bslvo.setStartstep(AccountingUtils.startStep2Num(params.getStepKey()));
			bslvo.setOpercode(user.getOprcode());
			
			bslvo.setRegion(Integer.valueOf(params.getCityid())); 
			bslvo.setStarttime(new Date(System.currentTimeMillis()));
			
			doBillStartLog(bslvo, user);
			
		}catch(Exception ex){
			log.error("启动出错:" + ex.getMessage(),ex);
			// // sessionContext.setRollbackOnly();
			throw ex;
		}		
		
		return params;
	}
	
	public AccountingVO doBatchStartUp(AccountingVO params, User user) throws Exception {
		
		try{
			doStartUp(params, user);
		}catch(Exception ex){
			log.error("批量启动出错:" + ex.getMessage(),ex);
			// // sessionContext.setRollbackOnly();
			throw ex;
		}		
		return params;
	}
	
	public List doShowLog(AccountingVO params, User user) throws Exception {		
		int billingphase = new Integer(params.get_se_billingphase()).intValue();	
		
		switch (billingphase) {
			case 101:
				return getBillingLog(params,2); 
			case 102:
				return getBillingLog(params,3);	//由3改为4，2010-01-07用户出帐增加子步骤"指定费项或费项组用户最低消费"  //由4改为3 2013-11-07 用户出账减少子步骤
			case 103:			
				return getBillingLog(params,3);//由2改为3////////////////////////////////////////////////////
			case 104:
				return getBillingLog(params,2);//出账确认-欠费入库0-赠送处理1
			case 80:
				return getBillingLog(params,0);	
		}
		return null;					
	}
	

	private List getBillingLog(AccountingVO params, int step) throws Exception {
		
		List list = new ArrayList();
		
		
		
		String cityid = AccountingUtils.getCityid(params.getCityid());
		
		
		BillingLogDAO dao = (BillingLogDAO) DAOFactory.build(BillingLogDAO.class, cityid+DBConstant.DB_FLAG_BILL);
		params.set_ne_region(params.getCityid());  //新增地市，201205 
//		params.set_orderby("logid");
//		params.set_desc("1");
		User user = (User) super.getUser();
		for (int i = 0 ; i < step; i++ ){
			params.set_se_subphase(String.valueOf(i));
			DataPackage dp = null;
			
			try{			
				BillingLogDBParam listvo =new BillingLogDBParam();			
				BeanUtils.copyProperties(listvo, params);

				dp = dao.query(listvo);
				
			} catch (Exception ex) {
				log.error("查询出帐日志出错:" + ex.getMessage(),ex);
			}			
			if (null != dp && dp.getDatas() != null && dp.getDatas().size() > 0) {
				BillingLogVO blvo = ((BillingLogVO) dp.getDatas().iterator().next());				
				list.add(blvo);
				continue;
			}
			BillingLogVO blvo = new BillingLogVO(); 
			blvo.setSubphase(String.valueOf(i));
			list.add(blvo);
		}		
		return list;
	}
	

	private void doBillStartLog(BillStartLogVO bslvo, User user) throws Exception {		
		try {			
			
			BillStartLogDAO dao = (BillStartLogDAO) DAOFactory.build(BillStartLogDAO.class, user);	
			
			dao.create(bslvo);			
			
		} catch (Exception ex) {
			//// sessionContext.setRollbackOnly();
			throw new Exception("登记出帐启动日志出错:  " + ex.getMessage(),ex);
		}
	}

	public Map doAccBill(AccountingVO params, User user) throws Exception {
		
		HashMap localMap = getAccBillMap(params);		
		LocalNote local = (LocalNote) localMap.get("main");
		if(null != local){
			return local.getItems();
		}		
		return new HashMap();

	}
	
	
	public Map doAccBillDet(AccountingVO params, User user) throws Exception {
		
		
		HashMap localMap = getAccBillMap(params);		
		LocalNote local = (LocalNote) localMap.get("outBill");
		if(null != local){
			return local.getItems();
		}		
		return new HashMap();
	}
	
	//营帐出账全省进度
	public List doAccBilling(AccountingVO params, User user) throws Exception {	
		
		List list = doTJAccounting(params, user);
		
		List newlist = new ArrayList();
		
		newlist.add(AccountingUtils.chkState(AccountingUtils.getState(list, 101)));
		newlist.add(AccountingUtils.chkState(AccountingUtils.getState(list, 50)));	
		newlist.add(AccountingUtils.chkState(AccountingUtils.getState(list, 106)));
		newlist.add(AccountingUtils.chkState(AccountingUtils.getState(list, 102)));
		newlist.add(AccountingUtils.chkState(AccountingUtils.getState(list, 103)));
		newlist.add(AccountingUtils.chkState(AccountingUtils.getState(list, 104)));
		newlist.add(AccountingUtils.chkState(AccountingUtils.getState(list, 105)));
		newlist.add(AccountingUtils.chkState(AccountingUtils.getState(list, 80)));
		newlist.add(AccountingUtils.chkState(AccountingUtils.getState(list, 75)));
		newlist.add(AccountingUtils.chkState(AccountingUtils.getState(list, 1010)));
		return newlist;
	}
	
	// 固定费确认与 销账信控 状态检查  人个与集团确认完毕后，固定费确认与销账信控状态才能认定已完成
	private String  confirmChartState(List list,AccountingVO params,String step) throws Exception {
		String citysource="";			
		citysource = AccountingUtils.getCityid(params.get_ne_region());
		String mergedbFlag =citysource+DBConstant.DB_FLAG_BILL;
		
		BillingLogDAO dao = (BillingLogDAO) DAOFactory.build(BillingLogDAO.class,mergedbFlag);
		
		BillingLogDBParam BillingLogVO = new BillingLogDBParam();
		
		BillingLogVO.set_ne_region(params.get_ne_region());
		
		BillingLogVO.set_ne_validbillcyc(params.get_ne_validbillcyc());
		
		BillingLogVO.set_se_billingphase(step);
		
		DataPackage dp =  dao.query(BillingLogVO); 
		
		String state[] = new String[2];
		
		List<BillingLogVO> BillingLogs = dp.toList(BillingLogVO.class);
		
		for (BillingLogVO vo : BillingLogs){
				   //个人确认状态			
				if(vo.getBillingphase().equals(step) && vo.getSubphase().equals("0")){
					
					state[0] = vo.getSubphase();
					// 集团确认状态
				}else if(vo.getBillingphase().equals(step) && vo.getSubphase().equals("1")){
					state[1] = vo.getSubphase();
				}
				
		}	
		// 此处 step 只作 50 与 105 判断
		String chkState = AccountingUtils.chkState(AccountingUtils.getState(list, Integer.valueOf(step)));
		
		if(!chkState.equals("3")) return chkState;
		else{
			if(!state[0].equals("3") || !state[1].equals("3")){
				return "2"; // 启动中 如果个人与集团未完成出账 ,则显示启动中
			}else{
				return chkState; // 已完成
			}
		}	
		
	}
	
	
	//解析计费服务的XML
	private HashMap getAccBillMap(AccountingVO params) throws Exception{
		
		SAXReader saxReader = new SAXReader(); 
		HashMap localMap = new HashMap();
		try{
			URL url = new URL(CoreConfigInfo.ACCBILL_SOP_URL);		
			Document doc = saxReader.read(url);  		
			List dynamicList = doc.selectNodes("syscode-config/syscode-local");			
			
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
	
	
	
	
	//查询当月出账步骤是否有重启记录
	private List isRestart(AccountingVO params) throws Exception{		
		
		int[] isrestart = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		List list = new ArrayList();
		
		try {			
			// 需要修改 user 
			BillStartLogDAO dao = (BillStartLogDAO) DAOFactory.build(BillStartLogDAO.class, super.getUser().getDbFlag());				

			BillStartLogDBParam listvo = new BillStartLogDBParam();
			listvo.set_ne_validbillcyc(params.get_ne_validbillcyc());
			// 启动日志无需用批次号查询，因部分批次号可能存在为空的现象
		    //listvo.set_se_batchnum(params.get_se_batchnum());
			listvo.set_pagesize("0");
			
			listvo.set_ne_region(params.get_ne_region());  //新增地市，201205
			
			DataPackage dp = dao.query(listvo);
			if(dp != null && dp.getDatas() != null && dp.getDatas().size() > 0){
				
				List dlist = (List) dp.getDatas();
				for(int i = 0; i < dlist.size() ; i++){
					
					BillStartLogVO vo = (BillStartLogVO) dlist.get(i);
					String startstep = vo.getStartstep() ;
					
					if(null == startstep || "".equals(startstep)){
						continue;
					} else if("100".equals(startstep))	{
						isrestart[0]++;
					}else if("50".equals(startstep))	{
						isrestart[1]++;
					}else if("101".equals(startstep))	{
						isrestart[2]++;
					}else if("102".equals(startstep))	{
						isrestart[3]++;
					}else if("103".equals(startstep))	{
						isrestart[4]++;
					}else if("104".equals(startstep))	{
						isrestart[5]++;
					}else if("105".equals(startstep))	{
						isrestart[6]++;
					}else if("80".equals(startstep))	{
						isrestart[7]++;
					}else if("75".equals(startstep))	{
						isrestart[8]++;
					}else if("1010".equals(startstep))	{
						isrestart[9]++;
					}else if("106".equals(startstep))	{
						isrestart[10]++;
					}
				}
				
			}		
			for(int i = 0; i < isrestart.length ; i++){
				
				int startconut = isrestart[i];
				list.add(startconut > 1 ? "1" : "0");											
			}
			
		} catch (Exception ex) {

			throw new Exception("查询出帐启动日志出错:  " + ex.getMessage(),ex);
		}
		return list;
	}
	
    /**
     * 根据结束任务编号获取前置任务编号
     */
    public Date getStartdate(AccountingVO params,User user) throws Exception{
    	try{
    		BillStepStatusDAO dao = (BillStepStatusDAO) DAOFactory.build(BillStepStatusDAO.class, user.getDbFlag());
    		Date enddate = null;
    		BillStepStatusDBParam param = new BillStepStatusDBParam();
    		param.getQueryConditions().put("endstepno", params.getEndstepno());    	
			if (null != params) {
				enddate=(Date)dao.queryUniqueByNamedSqlQuery("boss.fee.billstepstatus.querydatas", param, Timestamp.class);
			}
			return enddate;
		} catch(Exception ex){	
			throw ex;
		}
    }
	
}
