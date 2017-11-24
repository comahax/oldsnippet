package test.com.gmcc.pboss.biz.communi.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import test.com.gmcc.pboss.common.BaseTest;

import com.gmcc.pboss.biz.communi.dao.AdvaffixDao;
import com.gmcc.pboss.biz.communi.dao.CommunicatePlateauDao;
import com.gmcc.pboss.biz.communi.dao.hibernate.AdvaffixDaoHibernate;
import com.gmcc.pboss.biz.communi.dao.hibernate.CommunicatePlateauDaoHibernate;
import com.gmcc.pboss.biz.communi.support.CommunicatePlateauParameter;
import com.gmcc.pboss.common.support.SessionFactoryContextHolder;
import com.gmcc.pboss.model.communi.ChPwAdvaffix;
import com.gmcc.pboss.model.communi.ChPwAdvinfo;

public class CommunicatePlateauDaoTest extends BaseTest {

	private AdvaffixDao advaffixDao;
	
	private CommunicatePlateauDao communicatePlateauDao;

	public AdvaffixDao getAdvaffixDao() {
		return advaffixDao;
	}

	public void setAdvaffixDao(AdvaffixDao advaffixDao) {
		this.advaffixDao = advaffixDao;
	}
	
	
	public CommunicatePlateauDao getCommunicatePlateauDao() {
		return communicatePlateauDao;
	}

	public void setCommunicatePlateauDao(CommunicatePlateauDao communicatePlateauDao) {
		this.communicatePlateauDao = communicatePlateauDao;
	}

	public void testDoQueryAffixByAdvinfoid() {
		SessionFactoryContextHolder.setSessionFactoryContext("ZS");
		AdvaffixDaoHibernate affixDao = (AdvaffixDaoHibernate)advaffixDao;
		List<ChPwAdvaffix> result = affixDao.doQueryAffixByAdvinfoid(new Long("101"));
		for(ChPwAdvaffix affix : result) {
			System.out.println("¸½¼þÃû³Æ: "+affix.getAffixname());
		}
		
	}
	
	public void testQueryCityPublicInfo() {
		SessionFactoryContextHolder.setSessionFactoryContext("ZS");
		CommunicatePlateauDaoHibernate cpDao = (CommunicatePlateauDaoHibernate)communicatePlateauDao;
		CommunicatePlateauParameter parameter = new CommunicatePlateauParameter();
		List<ChPwAdvinfo> infos = cpDao.queryCityPublicInfo(2);
		for(ChPwAdvinfo info : infos) {
			System.out.println("------------infoid: "+info.getAdvinfoid()+" title: "+info.getTitle());
			Set affixs = info.getAffixs();
			for(Iterator it = affixs.iterator();it.hasNext();) {
				ChPwAdvaffix affix = (ChPwAdvaffix)it.next();
				System.out.println("---------affixName: "+affix.getAffixname()+"affixPath:"+affix.getAffixpath());
			}
			
		}
	}
	
}
