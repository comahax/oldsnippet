/**
 * 
 */
package com.sunrise.boss.business.fee.billing.bltouchrule.control;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.sunrise.boss.business.common.managelog.persistent.ManageLogDAO;
import com.sunrise.boss.business.common.managelog.persistent.OperAction;
import com.sunrise.boss.business.common.managelog.persistent.OperState;
import com.sunrise.boss.business.fee.acccounting.control.AccountingUtils;
import com.sunrise.boss.business.fee.billing.billinglog.persistent.BillingLogDAO;
import com.sunrise.boss.business.fee.billing.billinglog.persistent.BillingLogListVO;
import com.sunrise.boss.business.fee.billing.billinglog.persistent.BillingLogVO;
import com.sunrise.boss.business.fee.billing.billstartlog.persistent.BillStartLogDAO;
import com.sunrise.boss.business.fee.billing.billstartlog.persistent.BillStartLogVO;
import com.sunrise.boss.business.fee.billing.bltouchrule.persistent.BlTouchRuleDAO;
import com.sunrise.boss.business.fee.billing.bltouchrule.persistent.BlTouchRuleListVO;
import com.sunrise.boss.business.fee.billing.bltouchrule.persistent.BlTouchRuleVO;
import com.sunrise.boss.business.fee.billing.feenotifystate.persistent.FeeNotifyStateDAO;
import com.sunrise.boss.business.fee.billing.feenotifystate.persistent.FeeNotifyStateVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.ui.commons.User;

/**
 * Title: GDIBOSS
 * Description:
 * Copyright: Copyright (c) 2005
 * Company: sunrise Tech Ltd.
 * @author Hanny Yeung,mys
 * @version 1.0
 */

/** 
* @ejb.bean
*    local-jndi-name="com/sunrise/boss/business/fee/billing/bltouchrule/control/BlTouchRuleControlBean"
*    name="BlTouchRuleControl"
*    view-type="local"
*    type="Stateless"
*
* @ejb.interface pattern="{0}"
* @ejb.transaction type="Required"
*/
public class BlTouchRuleControlBean extends AbstractControlBean implements
		BlTouchRuleControl {

	
	
	/**
	 * 出帐监控
	 * 固定费: 101  Fix
	 * 用户出账: 102  Usrbill
	 * 帐户出帐：103   Accbill
	 * 出帐确认：104   Cfmbill
	 */
	public Map doSupervise(BlTouchRuleListVO params, User user)throws Exception {
		
		BlTouchRuleDAO dao = (BlTouchRuleDAO) DAOFactory.build(BlTouchRuleDAO.class, user.getCityid());
		BlTouchRuleVO btrvo = new BlTouchRuleVO();
		params.set_pagesize("0");
		Long status = new Long(0);
		
		DataPackage dp =  dao.query(params,false);
		
		/*****初始化各结点状态******/
		if (null != dp && dp.getDatas() != null && dp.getDatas().size() > 0) {
			btrvo = (BlTouchRuleVO) dp.getDatas().iterator().next();
	
			if(null == btrvo.getCfmbillstate() 
					|| btrvo.getCfmbillstate().longValue() < 0 
					|| btrvo.getCfmbillstate().longValue() > 5){
				btrvo.setCfmbillstate(status);
			}
			if(null == btrvo.getAccbillstate() 
					|| btrvo.getAccbillstate().longValue() < 0 
					|| btrvo.getAccbillstate().longValue() > 5){
				btrvo.setAccbillstate(status);
			}
			if(null == btrvo.getFixstate() 
					|| btrvo.getFixstate().longValue() < 0 
					|| btrvo.getFixstate().longValue() > 5){
				btrvo.setFixstate(status);
			}
			if(null == btrvo.getUsrbillstate() 
					|| btrvo.getUsrbillstate().longValue() < 0 
					|| btrvo.getUsrbillstate().longValue() > 5){
				btrvo.setUsrbillstate(status);
			}
		}else{
			btrvo = new BlTouchRuleVO();
			btrvo.setCfmbillstate(status);
			btrvo.setAccbillstate(status);
			btrvo.setFixstate(status);
			btrvo.setUsrbillstate(status);
		}

		Map map = new HashMap();
		map.put("SUPERVISE", btrvo);
		
		/***获得各结点的子结点状态***/
		getStatues(params,user,map);

		return map;
	}
	
	/**
	 * 取得各结点的子结点状态
	 * 固定费: 101  子结点（固定费计算：G11；）
	 * 用户出账: 102  子结点（合并固定费：G25；用户金卡减免：G26；用户最低消费处理：G27）
	 * 帐户出帐：103  子结点（帐户分帐：G31；帐户帐单取整：G32；）
	 * 出帐确认：104  子结点（出帐确认：G41；）
	 */
	public void getStatues(BlTouchRuleListVO params,User user,Map map) throws Exception{
		
		String validbillcyc = params.get_ne_validbillcyc();
		String batchnum = params.get_se_batchnum();
		if(null != validbillcyc && !"".equals(validbillcyc)
					&& null != batchnum && !"".equals(batchnum)){
			
			BillingLogDAO dao = (BillingLogDAO) DAOFactory.build(BillingLogDAO.class, user.getCityid());
			
			BillingLogListVO listvo = new BillingLogListVO();			
			
			listvo.set_ne_validbillcyc(validbillcyc);
			listvo.set_se_batchnum(batchnum);
			
			
			listvo.set_pagesize("0");
						listvo.set_orderby("logid");
			listvo.set_desc("1");

			
			listvo.set_se_billingphase("101");
			listvo.set_se_subphase("0");
			DataPackage dp = dao.query(listvo,false);
			
			/***获得子结点状态***/
			getStatus(dp,map,"G11","0","101");
			
			listvo.set_se_billingphase("102");
			listvo.set_se_subphase("0");
			dp = dao.query(listvo,false);
			
			/***获得子结点状态***/
			getStatus(dp,map,"G25","0","102");
			
			listvo.set_se_subphase("1");
			dp = dao.query(listvo,false);
			
			/***获得子结点状态***/
			getStatus(dp,map,"G26","1","102");
			
			
			listvo.set_se_subphase("2");
			dp = dao.query(listvo,false);
			
			/***获得子结点状态***/
			getStatus(dp,map,"G27","2","102");

			
			
			listvo.set_se_billingphase("103");
			listvo.set_se_subphase("0");
			dp = dao.query(listvo,false);
			getStatus(dp,map,"G31","0","103");

			
			listvo.set_se_subphase("1");
			dp = dao.query(listvo,false);
			getStatus(dp,map,"G32","1","103");
	
			
			listvo.set_se_subphase("2");
			dp = dao.query(listvo,false);
			getStatus(dp,map,"G33","2","103");
			

			
			
			listvo.set_se_billingphase("104");
			listvo.set_se_subphase("0");
			dp = dao.query(listvo,false);
			
			/***获得子结点状态***/
			getStatus(dp,map,"G41","0","104");
		}
		
		
		
		
	}

	/**
	 * 获取相应的状态标识
	 */
	private void getStatus(DataPackage dp,Map map,String statusKey,String subphaseKsy, String phaseKey) {
		
		long status = 0;
		
		if (null != dp && dp.getDatas() != null && dp.getDatas().size() > 0) {
			status = ((BillingLogVO) dp.getDatas().iterator().next()).getStatus();
			if(status < 0 || status > 4)  status = 0;
		}	
		
			
		map.put(statusKey,new Long(status));
		
		/****取得状态为[启动中]的子结点****/
		if(status == 2){
			if(!map.containsKey("CURRENTPHASE") && !map.containsKey("CURRENTSUBPHASE")){
				map.put("CURRENTPHASE",phaseKey);
				map.put("CURRENTSUBPHASE",subphaseKsy);
						
			}
		}		

	}
	
	
	
	public BlTouchRuleVO doCreate(BlTouchRuleVO vo, User user) throws Exception {
		try {
			BlTouchRuleDAO dao = (BlTouchRuleDAO) DAOFactory.build(BlTouchRuleDAO.class, user.getCityid());
			
			ManageLogDAO mdao = (ManageLogDAO) DAOFactory.build(ManageLogDAO.class, user.getCityid()); 			
			mdao.manageLog(user, vo.getClass().getName(), OperAction.INSERT, null,vo, OperState.SUCCESS);  
			
			return (BlTouchRuleVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemove(BlTouchRuleVO vo, User user) throws Exception {
		try {
			BlTouchRuleDAO dao = (BlTouchRuleDAO) DAOFactory.build(BlTouchRuleDAO.class, user.getCityid());
			
			ManageLogDAO mdao = (ManageLogDAO) DAOFactory.build(ManageLogDAO.class, user.getCityid()); 			
			mdao.manageLog(user, vo.getClass().getName(), OperAction.DELETE, null,vo, OperState.SUCCESS);
			
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public BlTouchRuleVO doUpdate(BlTouchRuleVO vo, User user) throws Exception {
		try {
			BlTouchRuleDAO dao = (BlTouchRuleDAO) DAOFactory.build(BlTouchRuleDAO.class, user.getCityid());
			
			ManageLogDAO mdao = (ManageLogDAO) DAOFactory.build(ManageLogDAO.class, user.getCityid()); 			
			mdao.manageLog(user, vo.getClass().getName(), OperAction.UPDATE, null,vo, OperState.SUCCESS); 
			
			return (BlTouchRuleVO) dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public BlTouchRuleVO doFindByPk(Serializable pk, User user)
			throws Exception {
		BlTouchRuleDAO dao = (BlTouchRuleDAO) DAOFactory.build(BlTouchRuleDAO.class, user.getCityid());
		
		return (BlTouchRuleVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(BlTouchRuleListVO params, User user)
			throws Exception {
		BlTouchRuleDAO dao = (BlTouchRuleDAO) DAOFactory.build(
				BlTouchRuleDAO.class, user.getCityid());
		return dao.query(params);
	}
	
	public BlTouchRuleVO doStartUp(BlTouchRuleVO vo, User user) throws Exception {
		try {
			doUpdate(vo, user);			
			doBillStartLog(vo, user);			
			return vo;
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}
	
	public void doBillStartLog(BlTouchRuleVO vo, User user) throws Exception {
		try {			
			
			BillStartLogDAO dao = (BillStartLogDAO) DAOFactory.build(BillStartLogDAO.class, user);
			BillStartLogVO bslvo = new BillStartLogVO();
			BeanUtils.copyProperties(bslvo, vo);
			
			bslvo.setOpercode(user.getOpercode());
			bslvo.setRegion(AccountingUtils.getCityCompid(user.getCityid()));
			bslvo.setStarttime(new Date(System.currentTimeMillis()));
			dao.create(bslvo);			
			
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw new Exception("登记出帐启动日志出错:  " + ex.getMessage(),ex);
		}
	}

	public void doGensms(Long validbillcyc, Long ruleid, User user) throws Exception {
		
		try {
			FeeNotifyStateDAO dao = (FeeNotifyStateDAO) DAOFactory.build(FeeNotifyStateDAO.class, user.getCityid());
			FeeNotifyStateVO vo = (FeeNotifyStateVO) dao.findByPk(validbillcyc);
			if(vo == null){
				vo = new FeeNotifyStateVO();
				vo.setValidbillcyc(validbillcyc);
				vo.setSmsfilestate(new Short("1"));
				vo.setSmssendstate(new Short("0"));
				vo.setFilestarttime(new Date(System.currentTimeMillis()));
				vo.setOprcode(user.getOpercode());
				dao.create(vo);
			}else{
				vo.setSmsfilestate(new Short("1"));
				vo.setFilestarttime(new Date(System.currentTimeMillis()));
				vo.setOprcode(user.getOpercode());
				dao.update(vo);
			}
			
			BillStartLogDAO billdao = (BillStartLogDAO) DAOFactory.build(BillStartLogDAO.class, user);
			BillStartLogVO bslvo = new BillStartLogVO();
			bslvo.setValidbillcyc(validbillcyc);
			bslvo.setOpercode(user.getOpercode());
			bslvo.setRegion(AccountingUtils.getCityCompid(user.getCityid()));//todo
			bslvo.setStartrsn("前台启动");
			bslvo.setBatchnum("01");
			bslvo.setStartstep("106");
			bslvo.setStarttime(vo.getFilestarttime());
			bslvo.setRuleid(ruleid);
			
			billdao.create(bslvo);
			
			
		} catch (Exception e) {
			sessionContext.setRollbackOnly();
			throw new Exception("启动短信生成出错:  " + e.getMessage(),e);
		}
		
	}

	public void doSendsms(Long validbillcyc, Long ruleid, User user) throws Exception {
		try {
			FeeNotifyStateDAO dao = (FeeNotifyStateDAO) DAOFactory.build(FeeNotifyStateDAO.class, user.getCityid());
			FeeNotifyStateVO vo = (FeeNotifyStateVO) dao.findByPk(validbillcyc);
			vo.setSmssendstate(new Short("1"));
			vo.setSmsstarttime(new Date(System.currentTimeMillis()));
			vo.setOprcode(user.getOpercode());
			dao.update(vo);
			
			BillStartLogDAO billdao = (BillStartLogDAO) DAOFactory.build(BillStartLogDAO.class, user);
			BillStartLogVO bslvo = new BillStartLogVO();
			bslvo.setValidbillcyc(validbillcyc);
			bslvo.setOpercode(user.getOpercode());
			bslvo.setRegion(AccountingUtils.getCityCompid(user.getCityid()));
			bslvo.setStartrsn("前台启动");
			bslvo.setBatchnum("01");
			bslvo.setStartstep("107");
			bslvo.setStarttime(vo.getFilestarttime());
			bslvo.setRuleid(ruleid);
			billdao.create(bslvo);
			
		} catch (Exception e) {
			sessionContext.setRollbackOnly();
			throw new Exception("启动短信发送出错:  " + e.getMessage(),e);
		}
	}

	public void doResetsms(Long validbillcyc, Long ruleid, User user) throws Exception {
		try {
			FeeNotifyStateDAO dao = (FeeNotifyStateDAO) DAOFactory.build(FeeNotifyStateDAO.class, user.getCityid());
			FeeNotifyStateVO vo = (FeeNotifyStateVO) dao.findByPk(validbillcyc);
			if(vo != null){
				if(vo.getSmsfilestate().intValue() == 1){
					throw new Exception("短信文件生成处于[启动中]状态，不能重置！");
				}
				
				if(vo.getSmssendstate().intValue() != 0){
					throw new Exception("短信文件发送不处于[启动中]状态，不能重置！");
				}
				vo.setSmsfilestate(new Short("0"));
				vo.setFilestarttime(new Date(System.currentTimeMillis()));
				vo.setOprcode(user.getOpercode());
				dao.update(vo);
				
				BillStartLogDAO billdao = (BillStartLogDAO) DAOFactory.build(BillStartLogDAO.class, user);
				BillStartLogVO bslvo = new BillStartLogVO();
				bslvo.setValidbillcyc(validbillcyc);
				bslvo.setOpercode(user.getOpercode());
				bslvo.setRegion(AccountingUtils.getCityCompid(user.getCityid()));//todo
				bslvo.setStartrsn("前台重置短信文件生成");
				bslvo.setBatchnum("01");
				bslvo.setStartstep("106");
				bslvo.setStarttime(vo.getFilestarttime());
				bslvo.setRuleid(ruleid);
				billdao.create(bslvo);
			}
		} catch (Exception e) {
			sessionContext.setRollbackOnly();
			throw new Exception("重置短信文件生成出错:  " + e.getMessage(),e);
		}
	}
	
	
}
