package test.com.gmcc.pboss.biz.communi.service;

import java.util.List;

import test.com.gmcc.pboss.common.BaseTest;

import com.gmcc.pboss.biz.basic.node.dao.ChPwRcvobjDao;
import com.gmcc.pboss.biz.communi.dao.hibernate.CommunicatePlateauDaoHibernate;
import com.gmcc.pboss.biz.communi.service.CommunicatePlateauOperation;
import com.gmcc.pboss.biz.communi.service.CommunicatePlateauService;
import com.gmcc.pboss.biz.communi.support.CommunicatePlateauParameter;
import com.gmcc.pboss.common.bean.BaseModel;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.exception.TransactionProcessionException;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceType;
import com.gmcc.pboss.common.support.SessionFactoryContextHolder;
import com.gmcc.pboss.model.communi.ChPwAdvaffix;
import com.gmcc.pboss.model.communi.ChPwAdvinfo;
import com.gmcc.pboss.model.communi.ChPwRcvobj;
import com.gmcc.pboss.model.communi.CommunicatePlateauVO;

public class CommunicatePlateauServiceTest extends BaseTest {

	private CommunicatePlateauService communicatePlateauService;

	public CommunicatePlateauService getCommunicatePlateauService() {
		return communicatePlateauService;
	}

	public void setCommunicatePlateauService(
			CommunicatePlateauService communicatePlateauService) {
		this.communicatePlateauService = communicatePlateauService;
	}
	
	private CommunicatePlateauDaoHibernate communicatePlateauDao ;
	
	public CommunicatePlateauDaoHibernate getCommunicatePlateauDao() {
		return communicatePlateauDao;
	}

	public void setCommunicatePlateauDao(
			CommunicatePlateauDaoHibernate communicatePlateauDao) {
		this.communicatePlateauDao = communicatePlateauDao;
	}
	
	private ChPwRcvobjDao chPwRcvobjDao;
	

	public ChPwRcvobjDao getChPwRcvobjDao() {
		return chPwRcvobjDao;
	}

	public void setChPwRcvobjDao(ChPwRcvobjDao chPwRcvobjDao) {
		this.chPwRcvobjDao = chPwRcvobjDao;
	}

	public ServiceResult testQuery() {
		SessionFactoryContextHolder.setSessionFactoryContext("ZS");
		LoginMember member = new LoginMember();
//		member.setCityid("ZS");
//		member.setWayid("CH_2323");
		
		CommunicatePlateauParameter param = new CommunicatePlateauParameter();
		param.setType("2");
		param.setEmployeeid("1");
		param.setIndexPage(false);
//		param.setStartDate("");
		param.setAccountDate("2010-10-01");
//		param.setTitle("rwftrefgdsaf");
		param.setState("3");
		ServiceResult result = communicatePlateauService.query(member, param);
		
		System.out.println("********************************"+result.getRetResult().getData());
		List data = result.getRetResult().getData();
		for(int i=0;i<data.size();i++) {
			BaseModel bm = (BaseModel)data.get(i);
			System.out.println("---------------------------"+bm);
			System.out.println("---------------------------"+bm.getDatas());
		}
		return result;
		
	}
	
	public ServiceResult testTransactionProcessing() {
		SessionFactoryContextHolder.setSessionFactoryContext("ZS");
		LoginMember member = new LoginMember();
		CommunicatePlateauParameter param = new CommunicatePlateauParameter();
		param.setAdvinfoid(new Long("84"));
		param.setEmployeeid("1");
		param.setType("2");
		ServiceResult result = communicatePlateauService.transactionProcessing(member, param, ServiceType.QUERY_ONE);
		CommunicatePlateauVO cpVo = (CommunicatePlateauVO)result.getRetObject();
		System.out.println("---------------"+cpVo);
		System.out.println("---------------"+cpVo.getAdvinfo().getAdvinfoid());
		
		List<ChPwAdvaffix> affixs = cpVo.getAdvaffixs();
		for(ChPwAdvaffix affix: affixs) {
			System.out.println("¸½¼þÃû³Æ: "+affix.getAffixname());
		}
		return result;
	}
//	
//	public void testGetAdvinfoAndAffix() {
//		SessionFactoryContextHolder.setSessionFactoryContext("ZS");
//		CommunicatePlateauParameter param = new CommunicatePlateauParameter();
//		param.setAdvinfoid(new Long("101"));
//		ChPwAdvinfo advinfo = ((CommunicatePlateauDaoHibernate)communicatePlateauDao).getAdvinfoAndAffix(param);
//		System.out.println("==============================="+advinfo);
//		System.out.println(advinfo.getAffixs());
//		for(Iterator it = advinfo.getReplys().iterator(); it.hasNext();) {
//			ChPwReply reply = (ChPwReply)it.next();
//			System.out.println(reply.getReplyid()+":   "+reply.getReplytime());
//		}
//	}
//	
//	public void testGetAdvinfoAffixReply() {
//		SessionFactoryContextHolder.setSessionFactoryContext("ZS");
//		CommunicatePlateauParameter param = new CommunicatePlateauParameter();
//		param.setAdvinfoid(new Long("96"));
//		param.setEmployeeid("1");
//		ChPwAdvinfo advinfo = ((CommunicatePlateauDaoHibernate)communicatePlateauDao).getAdvinfoAffixReply(param);
//		System.out.println("=============================== advinfo: "+advinfo);
//		System.out.println("=============================== affix:"+advinfo.getAffixs());
////		System.out.println("replys"+advinfo.getReplys());
//		for(Iterator it = advinfo.getReplys().iterator(); it.hasNext();) {
//			ChPwReply reply = (ChPwReply)it.next();
//			System.out.println(reply.getReplyid()+":   "+reply.getReplytime());
//		}
//		
//	}
//	
	public void testUpdateRcvobj() {
		SessionFactoryContextHolder.setSessionFactoryContext("ZS");
		CommunicatePlateauParameter param = new CommunicatePlateauParameter();
		param.setAdvinfoid(new Long("101"));
		param.setEmployeeid("3");
//		ChPwAdvinfo advinfo = ((CommunicatePlateauDaoHibernate)communicatePlateauDao).getAdvinfoAffixReply(param);
		ChPwRcvobj obj = (ChPwRcvobj)(communicatePlateauDao.getRcvobjByIds(param));
		System.out.println("------------------------------"+obj);
		obj.setChecktime(new java.util.Date());
		chPwRcvobjDao.update(obj);
	}
//	
	public void testSaveRcvobj() {
		SessionFactoryContextHolder.setSessionFactoryContext("ZS");
		CommunicatePlateauParameter param = new CommunicatePlateauParameter();
		param.setAdvinfoid(new Long("84"));
		param.setEmployeeid("1");
		ChPwAdvinfo advinfo = (ChPwAdvinfo)communicatePlateauDao.get(param.getAdvinfoid());
		ChPwRcvobj obj = new ChPwRcvobj();
//		obj.setAdvinfoid(param.getAdvinfoid());
		obj.setAdvinfo(advinfo);
		obj.setObjid(param.getEmployeeid());
		obj.setChecktime(new java.util.Date());
		obj.setState(Long.valueOf("1"));
		obj.setStatetime(new java.util.Date());
		((CommunicatePlateauDaoHibernate)communicatePlateauDao).save(obj);
	}
	
	public void testCloseQuestion() {
		SessionFactoryContextHolder.setSessionFactoryContext("ZS");
		LoginMember member = new LoginMember();
		CommunicatePlateauParameter param = new CommunicatePlateauParameter();
		param.setAdvinfoid(new Long("122"));
		param.setOperation(CommunicatePlateauOperation.CLOSE_QUESTION);
		ServiceResult result = 
			communicatePlateauService.transactionProcessing(member, param, ServiceType.OTHER);
		
	}
	
	public void testReadPendingTask() {
		SessionFactoryContextHolder.setSessionFactoryContext("ZS");
		LoginMember member = new LoginMember();
		CommunicatePlateauParameter param = new CommunicatePlateauParameter();
		param.setAdvinfoid(Long.valueOf("361"));
		param.setEmployeeid("5");
		param.setOperation(CommunicatePlateauOperation.READ_PENDING_TASK);
		try {
		ServiceResult result = 
			communicatePlateauService.transactionProcessing(member, param, ServiceType.OTHER);
		}catch(TransactionProcessionException ex) {
			System.out.println("------------------------"+ex.getMessage());
		}
	}
	
}
