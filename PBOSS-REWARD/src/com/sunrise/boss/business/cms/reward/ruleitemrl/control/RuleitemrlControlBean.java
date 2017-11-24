/**
* auto-generated code
* Thu Sep 11 19:35:20 CST 2008
*/
package com.sunrise.boss.business.cms.reward.ruleitemrl.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.pub.tools.Sequence;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.SessionUtil;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.reward.ruleitemrl.persistent.RuleitemrlVO;
import com.sunrise.boss.business.cms.reward.ruleitemrl.persistent.RuleitemrlDAO;
import com.sunrise.boss.business.cms.reward.ruleitemrl.persistent.RuleitemrlListVO;
import com.sunrise.boss.business.cms.reward.rulerel.persistent.RulerelDAO;

/**
 * <p>Title: RuleitemrlControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/reward/ruleitemrl/control/RuleitemrlControlBean"
 name="RuleitemrlControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class RuleitemrlControlBean extends AbstractControlBean
    implements RuleitemrlControl {

    public RuleitemrlVO doCreate(RuleitemrlVO vo, User user)
        throws Exception {
        try{
            // TODO  set the pk */
         RuleitemrlDAO dao = (RuleitemrlDAO) DAOFactory.build(RuleitemrlDAO.class, user);
            return (RuleitemrlVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public void doRemove(RuleitemrlVO vo, User user)
        throws Exception {
        try{
         RuleitemrlDAO dao = (RuleitemrlDAO) DAOFactory.build(RuleitemrlDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public RuleitemrlVO doUpdate(RuleitemrlVO vo, User user)
        throws Exception {
        try{
         RuleitemrlDAO dao = (RuleitemrlDAO) DAOFactory.build(RuleitemrlDAO.class, user);
            return (RuleitemrlVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }
    public RuleitemrlVO doFindByPk(Serializable pk, User user)
        throws Exception {
         RuleitemrlDAO dao = (RuleitemrlDAO) DAOFactory.build(RuleitemrlDAO.class, user);
        return (RuleitemrlVO) dao.findByPk(pk);
    }
    public DataPackage doQuery(RuleitemrlListVO params, User user)
        throws Exception {
         RuleitemrlDAO dao = (RuleitemrlDAO) DAOFactory.build(RuleitemrlDAO.class, user);
        return dao.query(params);
    }
    public DataPackage doQueryRuleItemRl(String ruleid,String ruleitemid,String rltype,User user)
		throws Exception {
    	RuleitemrlDAO dao = (RuleitemrlDAO) DAOFactory.build(RuleitemrlDAO.class, user);
    	return dao.doQueryRuleItemRl(ruleid,ruleitemid,rltype);
    }
    public DataPackage doQueryRuleItemRlTypeChain(String ruleid,String ruleitemid,short rltype,User user)
		throws Exception {
    	RuleitemrlDAO dao = (RuleitemrlDAO) DAOFactory.build(RuleitemrlDAO.class, user);
    	Session session=SessionUtil.currentSession(dao.getDbFlag());
    	Query query;
    	query=session.getNamedQuery("cms.reward.ruleitemrl.queryRuleItemRlTypeChain");
    	query.setString("ruleid", ruleid);
    	query.setShort("rltype",rltype);
    	query.setString("ruleitemid",ruleitemid);
    	List list=query.list();
    	DataPackage datapackage=new DataPackage();
    	datapackage.setDatas(list);
    	datapackage.setPageSize(list.size());
    	return datapackage;
    }
    public DataPackage doQueryRuleItemRlIsleaderChain(String ruleid,String ruleitemid,short rltype,short isleader,User user)
		throws Exception {
    	RuleitemrlDAO dao = (RuleitemrlDAO) DAOFactory.build(RuleitemrlDAO.class, user);
    	Session session=SessionUtil.currentSession(dao.getDbFlag());
    	Query query=session.getNamedQuery("cms.reward.ruleitemrl.queryRuleItemRlIsleaderChain");
    	query.setString("ruleid", ruleid);
    	query.setShort("isleader",isleader);
    	query.setString("ruleitemid",ruleitemid);
    	query.setShort("rltype",rltype);
    	List list=query.list();
    	DataPackage datapackage=new DataPackage();
    	datapackage.setDatas(list);
    	datapackage.setPageSize(list.size());
    	return datapackage;
    }
    
    public DataPackage doQueryRuleItemRlMutex(String ruleid,String ruleitemid,short rltype,User user)
		throws Exception {
		RuleitemrlDAO dao = (RuleitemrlDAO) DAOFactory.build(RuleitemrlDAO.class, user);
		Session session=SessionUtil.currentSession(dao.getDbFlag());
		Query query;
		query=session.getNamedQuery("cms.reward.ruleitemrl.queryRuleItemRlMutex");
		query.setString("ruleid", ruleid);
		query.setShort("rltype",rltype);
		query.setString("ruleitemid",ruleitemid);
		List list=query.list();
		DataPackage datapackage=new DataPackage();
		datapackage.setDatas(list);
		datapackage.setPageSize(list.size());
		return datapackage;
    }
}
