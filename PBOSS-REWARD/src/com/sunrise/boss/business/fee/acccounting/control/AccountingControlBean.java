/**
 * 
 */
package com.sunrise.boss.business.fee.acccounting.control;

import java.net.URL;
import java.sql.Timestamp;
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

import com.sunrise.boss.business.fee.acccounting.persistent.AccountingVO;
import com.sunrise.boss.business.fee.billing.billinglog.persistent.BillingLogDAO;
import com.sunrise.boss.business.fee.billing.billinglog.persistent.BillingLogVO;
import com.sunrise.boss.business.fee.billing.billstartlog.persistent.BillStartLogDAO;
import com.sunrise.boss.business.fee.billing.billstartlog.persistent.BillStartLogListVO;
import com.sunrise.boss.business.fee.billing.billstartlog.persistent.BillStartLogVO;
import com.sunrise.boss.business.fee.billing.bltouchrule.persistent.BlTouchRuleDAO;
import com.sunrise.boss.business.fee.billing.bltouchrule.persistent.BlTouchRuleVO;
import com.sunrise.boss.business.fee.billing.validbillcyc.persistent.ValidBillCycVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.common.utils.sysinfo.SysInfo;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.taglib.code2name.LocalNote;
import com.sunrise.pub.tools.StringSplit;

/**
 * Title: GDIBOSS
 * Description:
 * Copyright: Copyright (c) 2005
 * Company: sunrise Tech Ltd.
 * @author mys
 * @version 1.0
 */
/**
* @ejb.bean
*    local-jndi-name="com/sunrise/boss/business/fee/acccounting/control/AccountingControlBean"
*    name="AccountingControl"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class AccountingControlBean extends AbstractControlBean implements
		AccountingControl {

	

	private static final Logger log = Logger.getLogger(AccountingControlBean.class);
	
	
	public List doTJAccounting(AccountingVO params, User user) throws Exception {
		
		List list = new ArrayList();

		if("*".equals(params.getCitygroup()[0]) || "*,".equals(params.getCitygroup()[0])){
			params.setCitygroup(AccountingUtils.CITYID);
		}
		//params.setCitygroup(new String[]{"750","750","750","750","750","750","750","750","750","750","750","750","750","750","750"}); //测试语句		
		AccountingVO _params = new AccountingVO();
		_params.set_se_batchnum(params.get_se_batchnum());
		_params.set_ne_validbillcyc(params.get_ne_validbillcyc());	
		String[] billingphase = StringSplit.split(params.getIsshowlog(), ",");
		
		for(int i = 0 ; i < params.getCitygroup().length; i++ ){			
			String cityid = AccountingUtils.getCityid(params.getCitygroup()[i]);
			AccountingVO vo = new AccountingVO();
			vo.setCityid(cityid);
			vo.setCityname((AccountingUtils.getCityName(cityid)));			
			
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
			String cityid = AccountingUtils.getCityid(params.getCityid());
			BlTouchRuleDAO btrdao = (BlTouchRuleDAO) DAOFactory.build(BlTouchRuleDAO.class, cityid);
			
			ValidBillCycVO vbcvo = AccountingUtils.getVbcVO(new Long(params.get_ne_validbillcyc()), cityid);
			if(null != vbcvo.getState() && vbcvo.getState().intValue() == 1){
				throw new Exception("该计费月有效账务周期已经完成，不允许启动!"); 
			}
			
			BlTouchRuleVO btrvo = params.getBtrvo();			
			AccountingUtils.setState(btrvo, params.getStepKey());	
			
			btrdao.update(btrvo);
			
			BillStartLogVO bslvo = new BillStartLogVO();
			BeanUtils.copyProperties(bslvo, btrvo);
			
			bslvo.setStartrsn(params.getStartrsn());
			bslvo.setStartstep(AccountingUtils.startStep2Num(params.getStepKey()));
			bslvo.setOpercode(user.getOpercode());
			bslvo.setRegion(AccountingUtils.getCityCompid(cityid));
			bslvo.setStarttime(new Date(System.currentTimeMillis()));
			
			doBillStartLog(bslvo, cityid);
			
		}catch(Exception ex){
			log.error("启动出错:" + ex.getMessage(),ex);
			sessionContext.setRollbackOnly();
			throw ex;
		}		
		
		return params;
	}
	
	public AccountingVO doBatchStartUp(AccountingVO params, User user) throws Exception {
		
		try{
			doStartUp(params, user);
		}catch(Exception ex){
			log.error("批量启动出错:" + ex.getMessage(),ex);
			sessionContext.setRollbackOnly();
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
				return getBillingLog(params,3);	
			case 103:			
				return getBillingLog(params,3);//由2改为3////////////////////////////////////////////////////
			case 104:
				return getBillingLog(params,1);
			case 80:
				return getBillingLog(params,0);	
		}
		return null;					
	}
	

	private List getBillingLog(AccountingVO params, int step) throws Exception {
		
		List list = new ArrayList();
		String cityid = AccountingUtils.getCityid(params.getCityid());
		BillingLogDAO dao = (BillingLogDAO) DAOFactory.build(BillingLogDAO.class, cityid);		
		params.set_orderby("logid");
		params.set_desc("1");
		
		for (int i = 0 ; i < step; i++ ){
			params.set_se_subphase(String.valueOf(i));
			DataPackage dp = null;
			
			try{
				dp = dao.query(params,false);
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
	
	
	
	

	

	private void doBillStartLog(BillStartLogVO bslvo, String cityid) throws Exception {		
		try {			
			
			BillStartLogDAO dao = (BillStartLogDAO) DAOFactory.build(BillStartLogDAO.class, cityid);			
			dao.create(bslvo);			
			
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
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
		newlist.add(AccountingUtils.chkState(AccountingUtils.getState(list, 51)));
		newlist.add(AccountingUtils.chkState(AccountingUtils.getState(list, 102)));
		newlist.add(AccountingUtils.chkState(AccountingUtils.getState(list, 103)));
		newlist.add(AccountingUtils.chkState(AccountingUtils.getState(list, 104)));
		newlist.add(AccountingUtils.chkState(AccountingUtils.getState(list, 105)));
		newlist.add(AccountingUtils.chkState(AccountingUtils.getState(list, 80)));
		newlist.add(AccountingUtils.chkState(AccountingUtils.getState(list, 75)));
		newlist.add(AccountingUtils.chkState(AccountingUtils.getState(list, 1010)));
		return newlist;
	}
	
	
	//解析计费服务的XML
	private HashMap getAccBillMap(AccountingVO params) throws Exception{
		
		SAXReader saxReader = new SAXReader(); 
		HashMap localMap = new HashMap();
		try{
			URL url = new URL(SysInfo.ACCBILL_SOP_URL);		
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
			
			BillStartLogDAO dao = (BillStartLogDAO) DAOFactory.build(BillStartLogDAO.class, params.getCityid());			
			BillStartLogListVO listvo = new BillStartLogListVO();
			listvo.set_ne_validbillcyc(params.get_ne_validbillcyc());
			listvo.set_se_batchnum(params.get_se_batchnum());
			listvo.set_pagesize("0");
			DataPackage dp = dao.query(listvo,false);
			if(dp != null && dp.getDatas() != null && dp.getDatas().size() > 0){
				
				List dlist = (List) dp.getDatas();
				for(int i = 0; i < dlist.size() ; i++){
					
					BillStartLogVO vo = (BillStartLogVO) dlist.get(i);
					String startstep = vo.getStartstep() ;
					
					if(null == startstep || "".equals(startstep)){
						continue;
					} else if("100".equals(startstep))	{
						isrestart[0]++;
					}else if("1011".equals(startstep))	{
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
					}
				}
				
			}		
			for(int i = 0; i < isrestart.length ; i++){
				
				int startconut = isrestart[i];
				list.add(startconut > 1 ? "1" : "0");											
			}
			
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw new Exception("查询出帐启动日志出错:  " + ex.getMessage(),ex);
		}
		return list;
	}
	
}
