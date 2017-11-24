/**
* auto-generated code
* Wed May 18 15:47:28 CST 2011
*/
package com.sunrise.boss.business.cms.reward.creditstd.control;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.creditstd.persistent.CreditstdVO;
import com.sunrise.boss.business.cms.reward.creditstd.persistent.CreditstdDAO;
import com.sunrise.boss.business.cms.reward.creditstd.persistent.CreditstdListVO;
import com.sunrise.boss.business.cms.reward.creditstd.persistent.VCreditstdDAO;
import com.sunrise.boss.business.cms.reward.creditstd.persistent.VproCreditstdDAO;

/**
 * <p>Title: CreditstdControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/reward/creditstd/control/CreditstdControlBean"
 name="CreditstdControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class CreditstdControlBean extends AbstractControlBean
    implements CreditstdControl {

    public CreditstdVO doCreate(CreditstdVO vo, User user)
        throws Exception {
        try{
			CreditstdDAO dao = (CreditstdDAO) DAOFactory.build(CreditstdDAO.class, user);
            // TODO  set the pk */
            return (CreditstdVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(CreditstdVO vo, User user)
        throws Exception {
        try{
			CreditstdDAO dao = (CreditstdDAO) DAOFactory.build(CreditstdDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public CreditstdVO doUpdate(CreditstdVO vo, User user)
        throws Exception {
        try{
			CreditstdDAO dao = (CreditstdDAO) DAOFactory.build(CreditstdDAO.class, user);
            return (CreditstdVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public CreditstdVO doFindByPk(Serializable pk, User user)
        throws Exception {
			CreditstdDAO dao = (CreditstdDAO) DAOFactory.build(CreditstdDAO.class, user);
        return (CreditstdVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(CreditstdListVO params, User user)
        throws Exception {
			CreditstdDAO dao = (CreditstdDAO) DAOFactory.build(CreditstdDAO.class, user);
        return dao.query(params);
    }

	public DataPackage doQuery2(CreditstdListVO params, User user)
			throws Exception {
		// TODO Auto-generated method stub
		VCreditstdDAO dao = (VCreditstdDAO) DAOFactory.build(VCreditstdDAO.class, user);
        return dao.query2(params);
	}

	public DataPackage doQuerystar(CreditstdListVO params, User user)
			throws Exception {
		CreditstdDAO dao = (CreditstdDAO) DAOFactory.build(CreditstdDAO.class, user);
        return dao.queryStar(params);
	}

	public DataPackage doQuerystore(CreditstdListVO params, User user)
			throws Exception {
		CreditstdDAO dao = (CreditstdDAO) DAOFactory.build(CreditstdDAO.class, user);
        return dao.queryStore(params);
	}

	public DataPackage doSave(Map map, User user) throws Exception {
		
		try {
			CreditstdDAO dao = (CreditstdDAO) DAOFactory.build(CreditstdDAO.class, user);
			CreditstdListVO creditstdListVO=new CreditstdListVO();
//			for(int i=0;i<map.size();i++){
				String rewardstd="";
				String creditstd="";
				String cardstd="";
				String intvmonth="";
				String ruleid="";
				Set<String> set = map.keySet(); 
			    Iterator itor = set.iterator();
				for(int j=0;j<set.size();j++){
					String aa=itor.next().toString();
					creditstdListVO.set_ne_seq(aa);
					String[] all=((String)map.get(aa)).split(",");
					rewardstd=all[0];
					cardstd=all[1];
					creditstd=all[2];
					ruleid=all[3];
					intvmonth=all[4];
					
					DataPackage dp=dao.query(creditstdListVO);
					Iterator it = dp.getDatas().iterator();
					if(it.hasNext()){
						CreditstdVO creditstdVO=(CreditstdVO)it.next();
						creditstdVO.setCreditstd(Double.valueOf(creditstd));
						creditstdVO.setCardstd(Double.valueOf(cardstd));
						creditstdVO.setIntvmonth(Long.valueOf(intvmonth));
						creditstdVO.setRewardstd(Double.valueOf(rewardstd));
						creditstdVO.setRuleid(ruleid);
						dao.update(creditstdVO);
					}
				}
				
				
//			}
			return null;
		} catch (  Exception e) {
			sessionContext.setRollbackOnly();
            throw e;
		}
	}

	public DataPackage doQueryPro(CreditstdListVO params, User user)
			throws Exception {
		VproCreditstdDAO dao = (VproCreditstdDAO) DAOFactory.build(VproCreditstdDAO.class, user);
        return dao.query2(params);
	}

	public Double doQuerysums(CreditstdListVO params, User user)
			throws Exception {
		CreditstdDAO dao = (CreditstdDAO) DAOFactory.build(CreditstdDAO.class, user);
        return dao.sumOpprewardtype(params);
	}

	public Double doQuerysums4singlton(CreditstdListVO params, User user)
			throws Exception {
		CreditstdDAO dao = (CreditstdDAO) DAOFactory.build(CreditstdDAO.class, user);
        return dao.sumOpprewardtype4singlton(params);
	}

	public boolean doCheckALevel(CreditstdListVO params, User user)
			throws Exception {
		CreditstdDAO dao = (CreditstdDAO) DAOFactory.build(CreditstdDAO.class, user);
        return dao.checkhasALevel(params);
	}
	
	public DataPackage doQuery4cqjl(CreditstdListVO params, User user)
    throws Exception {
		CreditstdDAO dao = (CreditstdDAO) DAOFactory.build(CreditstdDAO.class, user);
    return dao.doQuery4cqjl(params);
}
}
