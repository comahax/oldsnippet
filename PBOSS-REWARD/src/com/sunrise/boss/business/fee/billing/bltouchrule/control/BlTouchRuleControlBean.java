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
	 * ���ʼ��
	 * �̶���: 101  Fix
	 * �û�����: 102  Usrbill
	 * �ʻ����ʣ�103   Accbill
	 * ����ȷ�ϣ�104   Cfmbill
	 */
	public Map doSupervise(BlTouchRuleListVO params, User user)throws Exception {
		
		BlTouchRuleDAO dao = (BlTouchRuleDAO) DAOFactory.build(BlTouchRuleDAO.class, user.getCityid());
		BlTouchRuleVO btrvo = new BlTouchRuleVO();
		params.set_pagesize("0");
		Long status = new Long(0);
		
		DataPackage dp =  dao.query(params,false);
		
		/*****��ʼ�������״̬******/
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
		
		/***��ø������ӽ��״̬***/
		getStatues(params,user,map);

		return map;
	}
	
	/**
	 * ȡ�ø������ӽ��״̬
	 * �̶���: 101  �ӽ�㣨�̶��Ѽ��㣺G11����
	 * �û�����: 102  �ӽ�㣨�ϲ��̶��ѣ�G25���û��𿨼��⣺G26���û�������Ѵ���G27��
	 * �ʻ����ʣ�103  �ӽ�㣨�ʻ����ʣ�G31���ʻ��ʵ�ȡ����G32����
	 * ����ȷ�ϣ�104  �ӽ�㣨����ȷ�ϣ�G41����
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
			
			/***����ӽ��״̬***/
			getStatus(dp,map,"G11","0","101");
			
			listvo.set_se_billingphase("102");
			listvo.set_se_subphase("0");
			dp = dao.query(listvo,false);
			
			/***����ӽ��״̬***/
			getStatus(dp,map,"G25","0","102");
			
			listvo.set_se_subphase("1");
			dp = dao.query(listvo,false);
			
			/***����ӽ��״̬***/
			getStatus(dp,map,"G26","1","102");
			
			
			listvo.set_se_subphase("2");
			dp = dao.query(listvo,false);
			
			/***����ӽ��״̬***/
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
			
			/***����ӽ��״̬***/
			getStatus(dp,map,"G41","0","104");
		}
		
		
		
		
	}

	/**
	 * ��ȡ��Ӧ��״̬��ʶ
	 */
	private void getStatus(DataPackage dp,Map map,String statusKey,String subphaseKsy, String phaseKey) {
		
		long status = 0;
		
		if (null != dp && dp.getDatas() != null && dp.getDatas().size() > 0) {
			status = ((BillingLogVO) dp.getDatas().iterator().next()).getStatus();
			if(status < 0 || status > 4)  status = 0;
		}	
		
			
		map.put(statusKey,new Long(status));
		
		/****ȡ��״̬Ϊ[������]���ӽ��****/
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
			throw new Exception("�Ǽǳ���������־����:  " + ex.getMessage(),ex);
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
			bslvo.setStartrsn("ǰ̨����");
			bslvo.setBatchnum("01");
			bslvo.setStartstep("106");
			bslvo.setStarttime(vo.getFilestarttime());
			bslvo.setRuleid(ruleid);
			
			billdao.create(bslvo);
			
			
		} catch (Exception e) {
			sessionContext.setRollbackOnly();
			throw new Exception("�����������ɳ���:  " + e.getMessage(),e);
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
			bslvo.setStartrsn("ǰ̨����");
			bslvo.setBatchnum("01");
			bslvo.setStartstep("107");
			bslvo.setStarttime(vo.getFilestarttime());
			bslvo.setRuleid(ruleid);
			billdao.create(bslvo);
			
		} catch (Exception e) {
			sessionContext.setRollbackOnly();
			throw new Exception("�������ŷ��ͳ���:  " + e.getMessage(),e);
		}
	}

	public void doResetsms(Long validbillcyc, Long ruleid, User user) throws Exception {
		try {
			FeeNotifyStateDAO dao = (FeeNotifyStateDAO) DAOFactory.build(FeeNotifyStateDAO.class, user.getCityid());
			FeeNotifyStateVO vo = (FeeNotifyStateVO) dao.findByPk(validbillcyc);
			if(vo != null){
				if(vo.getSmsfilestate().intValue() == 1){
					throw new Exception("�����ļ����ɴ���[������]״̬���������ã�");
				}
				
				if(vo.getSmssendstate().intValue() != 0){
					throw new Exception("�����ļ����Ͳ�����[������]״̬���������ã�");
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
				bslvo.setStartrsn("ǰ̨���ö����ļ�����");
				bslvo.setBatchnum("01");
				bslvo.setStartstep("106");
				bslvo.setStarttime(vo.getFilestarttime());
				bslvo.setRuleid(ruleid);
				billdao.create(bslvo);
			}
		} catch (Exception e) {
			sessionContext.setRollbackOnly();
			throw new Exception("���ö����ļ����ɳ���:  " + e.getMessage(),e);
		}
	}
	
	
}
