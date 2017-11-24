/**
 * auto-generated code
 * Thu Sep 17 15:12:35 CST 2009
 */
package com.gmcc.pboss.control.promotion.ppzlnrule;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.gmcc.pboss.business.promotion.ppzlnrule.PpzlnruleDBParam;
import com.gmcc.pboss.business.promotion.ppzlnrule.PpzlnruleDAO;
import com.gmcc.pboss.business.promotion.ppzlnrule.PpzlnruleVO;
import com.gmcc.pboss.business.promotion.rule.RuleVO;
import com.gmcc.pboss.control.promotion.rule.RuleBO;
import com.gmcc.pboss.control.promotion.ruleitem.RuleitemBO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>
 * Title: PpzlnruleBO
 * </p>;
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author LiZhaoLiang
 * @version 1.0
 */
/**
 * @ejb.bean local-jndi-name="com/sunrise/jop/business/promotion/ppzlnrule/control/PpzlnruleBO"
 *           name="Ppzlnrule" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class PpzlnruleBO extends AbstractControlBean implements Ppzlnrule {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PpzlnruleVO doCreate(PpzlnruleVO vo) throws Exception {
		try {
			PpzlnruleDAO dao = (PpzlnruleDAO) DAOFactory.build(
					PpzlnruleDAO.class, user);
			// TODO set the pk */
			return (PpzlnruleVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(PpzlnruleVO vo) throws Exception {
		try {
			PpzlnruleDAO dao = (PpzlnruleDAO) DAOFactory.build(
					PpzlnruleDAO.class, user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			PpzlnruleDAO dao = (PpzlnruleDAO) DAOFactory.build(
					PpzlnruleDAO.class, user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public PpzlnruleVO doUpdate(PpzlnruleVO vo) throws Exception {
		try {
			PpzlnruleDAO dao = (PpzlnruleDAO) DAOFactory.build(
					PpzlnruleDAO.class, user);
			return (PpzlnruleVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public PpzlnruleVO doFindByPk(Serializable pk) throws Exception {
		PpzlnruleDAO dao = (PpzlnruleDAO) DAOFactory.build(PpzlnruleDAO.class,
				user);
		return (PpzlnruleVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(PpzlnruleDBParam params) throws Exception {
		PpzlnruleDAO dao = (PpzlnruleDAO) DAOFactory.build(PpzlnruleDAO.class,
				user);
		return dao.query(params);
	}

	/**
	 * 获取对应方案标识下的所有规则标识
	 * @param pid
	 * @return
	 * @throws Exception
	 */
	public List<Long> doQueryPpzlnruleVo(Long pid) throws Exception {
		try {
			PpzlnruleDBParam ppzlnruleparam = new PpzlnruleDBParam();
			PpzlnruleBO ppzlnrulebo = (PpzlnruleBO) BOFactory.build(
					PpzlnruleBO.class, user);
			PpzlnruleVO ppzlnrulevo = new PpzlnruleVO();
			List<Long> list = new ArrayList<Long>();
			ppzlnruleparam.set_ne_pid(pid.toString());
			DataPackage ppzlnruledp = ppzlnrulebo.doQuery(ppzlnruleparam);
			if (ppzlnruledp != null && ppzlnruledp.getDatas().size() > 0) {
				int i = 0;
				for (i = 0; i < ppzlnruledp.getDatas().size(); i++) {
					ppzlnrulevo = (PpzlnruleVO) ppzlnruledp.getDatas().get(i);
					// 查询方案对应的ruleid
					list.add(ppzlnrulevo.getRuleid());
				}
			}
			return list;
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	/**
	 * 配置保存方案与规则的关系
	 */
	public void doBatchSave(String rulename, String pri, String memo, Long pid)
			throws Exception {
		try {
			RuleBO rulebo = (RuleBO) BOFactory.build(RuleBO.class, getUser());
			PpzlnruleBO ppzlnbo = (PpzlnruleBO) BOFactory.build(PpzlnruleBO.class, getUser());
			RuleVO rulevo = new RuleVO();
			PpzlnruleVO ppzlnrulevo = new PpzlnruleVO();
			/**
			 * 新增规则
			 */
			rulevo.setRulename(rulename);
			rulevo.setPri(pri);
			rulevo.setMemo(memo);
			rulebo.doCreate(rulevo);

			/**
			 * 新增方案与规则关系
			 */
			Long ruleid = rulevo.getRuleid();
			ppzlnrulevo.setPid(pid);
			ppzlnrulevo.setRuleid(ruleid);
			ppzlnbo.doCreate(ppzlnrulevo);
			
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	/**
	 * 全量删除相关方案与规则下的所有规则明细
	 */
	public void doDeleteRule(Long ruleid, Long pid, List<Long> itemidlist)
			throws Exception {
		try {
			RuleBO rulebo = (RuleBO) BOFactory.build(RuleBO.class, getUser());
			PpzlnruleBO ppzlnbo = (PpzlnruleBO) BOFactory.build(PpzlnruleBO.class, getUser());
			RuleitemBO ruleitembo = (RuleitemBO) BOFactory.build(RuleitemBO.class, getUser());
			PpzlnruleVO ppzlnrulevo = new PpzlnruleVO();
			RuleVO rulevo = new RuleVO();
			/**
			 * 删除方案与规则
			 */
			ppzlnrulevo.setPid(pid);
			ppzlnrulevo.setRuleid(ruleid);
			ppzlnbo.doRemoveByVO(ppzlnrulevo);
			/**
			 * 删除规则
			 */
			rulevo.setRuleid(ruleid);
			rulebo.doRemoveByPK(rulevo.getRuleid());
			/**
			 * 删除规则明细
			 */
			if(itemidlist.size()>0){
			for (int i = 0; i < itemidlist.size(); i++) {
				ruleitembo.doRemoveByPK(new Long(itemidlist.get(i)));
				}
			}
		} catch (Exception ex) {
			throw new JOPException(ex);
		}

	}

	public DataPackage doQueryRulesByPid(long pid, boolean orderBy)
			throws Exception {
		PpzlnruleDAO dao = (PpzlnruleDAO) DAOFactory.build(PpzlnruleDAO.class,
				user);
		return dao.queryRulesByPid(pid, orderBy);
	}

}
