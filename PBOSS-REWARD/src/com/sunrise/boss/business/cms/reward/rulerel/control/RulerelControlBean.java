/**
 * auto-generated code
 * Wed Sep 10 11:22:49 CST 2008
 */
package com.sunrise.boss.business.cms.reward.rulerel.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Session;

import com.sunrise.boss.business.cms.reward.ruleitem.persistent.RuleitemListVO;
import com.sunrise.boss.business.cms.reward.ruleitem.persistent.RuleitemVO;
import com.sunrise.boss.business.cms.reward.rulerel.persistent.RulerelDAO;
import com.sunrise.boss.business.cms.reward.rulerel.persistent.RulerelListVO;
import com.sunrise.boss.business.cms.reward.rulerel.persistent.RulerelVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionUtil;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>
 * Title: RulerelControlBean
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author
 * @version 1.0
 */
/**
 * @ejb.bean local-jndi-name="com/sunrise/boss/business/cms/reward/rulerel/control/RulerelControlBean"
 * name="RulerelControl" 
 * view-type="local" 
 * type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class RulerelControlBean extends AbstractControlBean implements
		RulerelControl {

	public RulerelVO doCreate(RulerelVO vo, User user) throws Exception {
		try {
			// TODO set the pk */
			RulerelDAO dao = (RulerelDAO) DAOFactory.build(RulerelDAO.class,
					user);
			return (RulerelVO) dao.create(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public void doRemove(RulerelVO vo, User user) throws Exception {
		try {
			RulerelDAO dao = (RulerelDAO) DAOFactory.build(RulerelDAO.class,
					user);
			dao.remove(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	/**
	 * @deprecated 该方法已经废弃
	 */
	public RulerelVO doUpdate(RulerelVO vo, User user) throws Exception {
		try {
			RulerelDAO dao = (RulerelDAO) DAOFactory.build(RulerelDAO.class,
					user);

			RulerelListVO listvo = new RulerelListVO();
			listvo.set_se_ruleitemid(vo.getRuleitemid());
			listvo.set_se_ruleid(vo.getRuleid());
			DataPackage pack = new DataPackage();
			pack = doQuery(listvo, user);
			List list = new ArrayList();
			list = pack.toList(RulerelVO.class);
			Iterator it = list.iterator();
			Session session = SessionUtil.currentSession(dao.getDbFlag());
			while (it.hasNext()) {
				RulerelVO ob = (RulerelVO) it.next();
				session.clear();
				session.evict(ob);
				ob.setState(vo.getState());
				dao.update(ob);
			}
			return null;
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}

	public RulerelVO doUpdate2(RulerelVO vo, User user) throws Exception {
		try {
			RulerelDAO dao = (RulerelDAO) DAOFactory.build(RulerelDAO.class,
					user);
			
			return (RulerelVO)dao.update(vo);
		} catch (Exception ex) {
			sessionContext.setRollbackOnly();
			throw ex;
		}
	}
	
	public RulerelVO doFindByPk(Serializable pk, User user) throws Exception {
		RulerelDAO dao = (RulerelDAO) DAOFactory.build(RulerelDAO.class, user);
		return (RulerelVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(RulerelListVO params, User user)
			throws Exception {
		RulerelDAO dao = (RulerelDAO) DAOFactory.build(RulerelDAO.class, user);
		return dao.query(params);
	}

	public DataPackage doQuery2(RulerelListVO params1, RuleitemListVO params2,
			User user) throws Exception {
		RulerelDAO dao = (RulerelDAO) DAOFactory.build(RulerelDAO.class, user);
		return dao.query2(new Object[] { params1, params2 }, new Class[] {
				RulerelVO.class, RuleitemVO.class }, new String[][] { {
				"ruleitemid", "ruleitemid" } });
	}
	
	public List doCheckRulerelOrder(String ruleid, User user) throws Exception{
		RulerelDAO dao = (RulerelDAO) DAOFactory.build(RulerelDAO.class, user);
		return dao.checkRulerelOrder(ruleid);
	}
	 
	public DataPackage doQuery4(RulerelListVO params1,User user)
	throws Exception{
		RulerelDAO dao = (RulerelDAO) DAOFactory.build(RulerelDAO.class, user);
		return dao.showRulerel(params1);
	}

	public DataPackage doQuery5(RulerelListVO params1,User user)
	throws Exception{
		RulerelDAO dao = (RulerelDAO) DAOFactory.build(RulerelDAO.class, user);
		return dao.showRulerel2(params1);
	}

	public DataPackage doQueryByRuleid(RulerelListVO params1, User user)
			throws Exception {
		RulerelDAO dao = (RulerelDAO) DAOFactory.build(RulerelDAO.class, user);
		return dao.showRulerelByRuleid(params1);
	}

	public DataPackage doSave(List params1,String ruleid,  User user) throws Exception {
		try {
			// TODO Auto-generated method stub
			RulerelDAO dao = (RulerelDAO) DAOFactory.build(RulerelDAO.class, user);
			RulerelListVO rulerelListVO=new RulerelListVO();
			rulerelListVO.set_se_cityid(user.getCityid());
			rulerelListVO.set_se_ruleid(ruleid);
			DataPackage dp=dao.query(rulerelListVO);
			Iterator it = dp.getDatas().iterator();
			while(it.hasNext()){
				RulerelVO vo=(RulerelVO)(it.next());
//			RulerelVO newvo = new RulerelVO();
//			BeanUtils.copyProperties(newvo, vo);
				dao.remove(vo);
			}
			
			for (int i = 0; i <params1.size(); i++) {
				
				//查询"999"的paramer ,有几个分隔符"|",输入的参数是否有同样的个数
				RulerelListVO rulerelListVO1=new RulerelListVO();
				rulerelListVO1.set_se_ruleid(ruleid);
				rulerelListVO1.set_se_cityid("999");
				String[] ss=params1.get(i).toString().split(";");
				rulerelListVO1.set_se_ruleitemid(ss[0]);
				DataPackage dp2=dao.query(rulerelListVO1);
				String sp1=((RulerelVO)dp2.getDatas().iterator().next()).getParamer();
				Short isdafault=((RulerelVO)dp2.getDatas().iterator().next()).getIsdefault();
				Short state=((RulerelVO)dp2.getDatas().iterator().next()).getState();
				//如果没有填写值,ss的长度就是1,必须报错
				if(ss.length==1){
					throw new Exception( ss[0] + "的参数值没有填写!");
				}else{
					RulerelVO rulerelVO=new RulerelVO();
					rulerelVO.setRuleid(ruleid);
					rulerelVO.setRulemodeid(Long.parseLong("0"));
					rulerelVO.setCityid(user.getCityid());
					rulerelVO.setRuleitemid(ss[0]);
					rulerelVO.setIsdefault(isdafault);
					rulerelVO.setState(state);
					//说明这条规则没有参数就不用插入参数的值在对应的地市的规则中
					if(sp1!=null){
						String sp2=ss[1];
						int length1=StringUtils.splitPreserveAllTokens(sp1, "|").length;
						int length2=StringUtils.splitPreserveAllTokens(sp2, "|").length;
						if( length1!=length2|| !("".equals(StringUtils.splitPreserveAllTokens(sp2.trim(), "|")[length2-1]))  ){
////					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "输入的参数值个数不一致,并且要以'|'分隔和结尾!");
							throw new Exception( ss[0] + "输入的参数值个数不一致,并且要以'|'分隔和结尾!");
							
						}
						//保存地市的参数值
						rulerelVO.setParamer(ss[1]);
					}else{
						//省的没有参数,地市不可能有参数值
					}
					dao.create(rulerelVO);
				}
			}
			return null;
		} catch (Exception e) {
			sessionContext.setRollbackOnly();
            throw e;
		}
	}
}
