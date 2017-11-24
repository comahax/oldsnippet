/**
 * auto-generated code
 * Mon Sep 14 14:51:11 CST 2009
 */
package com.gmcc.pboss.control.promotion.spproposal;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import open.tool.rule.data.VO;

import com.gmcc.pboss.business.promotion.daemon.DaemonDBParam;
import com.gmcc.pboss.business.promotion.daemon.DaemonVO;
import com.gmcc.pboss.business.promotion.elmttmpl.DefaultVO;
import com.gmcc.pboss.business.promotion.ppzlncom.PpzlncomDBParam;
import com.gmcc.pboss.business.promotion.ppzlncom.PpzlncomVO;
import com.gmcc.pboss.business.promotion.ppzlnptnr.PpzlnptnrDBParam;
import com.gmcc.pboss.business.promotion.ppzlnptnr.PpzlnptnrVO;
import com.gmcc.pboss.business.promotion.ppzlnres.PpzlnresDBParam;
import com.gmcc.pboss.business.promotion.ppzlnres.PpzlnresVO;
import com.gmcc.pboss.business.promotion.ppzlnrule.PpzlnruleDBParam;
import com.gmcc.pboss.business.promotion.ppzlnrule.PpzlnruleVO;
import com.gmcc.pboss.business.promotion.pquantity.PquantityDBParam;
import com.gmcc.pboss.business.promotion.pquantity.PquantityVO;
import com.gmcc.pboss.business.promotion.presentinga.PresentingaDBParam;
import com.gmcc.pboss.business.promotion.presentinga.PresentingaVO;
import com.gmcc.pboss.business.promotion.presentingb.PresentingbDBParam;
import com.gmcc.pboss.business.promotion.presentingb.PresentingbVO;
import com.gmcc.pboss.business.promotion.rewardstd.RewardstdDBParam;
import com.gmcc.pboss.business.promotion.rewardstd.RewardstdVO;
import com.gmcc.pboss.business.promotion.rule.RuleDBParam;
import com.gmcc.pboss.business.promotion.ruleitem.RuleitemDBParam;
import com.gmcc.pboss.business.promotion.ruleitem.RuleitemVO;
import com.gmcc.pboss.business.promotion.spproposal.SpproposalDAO;
import com.gmcc.pboss.business.promotion.spproposal.SpproposalDBParam;
import com.gmcc.pboss.business.promotion.spproposal.SpproposalVO;
import com.gmcc.pboss.business.promotion.tieinsale.TieinsaleDBParam;
import com.gmcc.pboss.business.promotion.tieinsale.TieinsaleVO;
import com.gmcc.pboss.common.utils.tools.TiedComInfo;
import com.gmcc.pboss.control.promotion.daemon.Daemon;
import com.gmcc.pboss.control.promotion.daemon.DaemonBO;
import com.gmcc.pboss.control.promotion.ppzlncom.PpzlncomBO;
import com.gmcc.pboss.control.promotion.ppzlnptnr.PpzlnptnrBO;
import com.gmcc.pboss.control.promotion.ppzlnres.PpzlnresBO;
import com.gmcc.pboss.control.promotion.ppzlnrule.Ppzlnrule;
import com.gmcc.pboss.control.promotion.ppzlnrule.PpzlnruleBO;
import com.gmcc.pboss.control.promotion.pquantity.PquantityBO;
import com.gmcc.pboss.control.promotion.presentinga.PresentingaBO;
import com.gmcc.pboss.control.promotion.presentingb.Presentingb;
import com.gmcc.pboss.control.promotion.presentingb.PresentingbBO;
import com.gmcc.pboss.control.promotion.rewardstd.RewardstdBO;
import com.gmcc.pboss.control.promotion.rule.RuleBO;
import com.gmcc.pboss.control.promotion.ruleitem.Ruleitem;
import com.gmcc.pboss.control.promotion.ruleitem.RuleitemBO;
import com.gmcc.pboss.control.promotion.tieinsale.Tieinsale;
import com.gmcc.pboss.control.promotion.tieinsale.TieinsaleBO;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>
 * Title: SpproposalBO
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
 * @ejb.bean local-jndi-name="com/sunrise/jop/business/promotion/spproposal/control/SpproposalBO"
 *           name="Spproposal" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class SpproposalBO extends AbstractControlBean implements Spproposal {

	public SpproposalVO doCreate(SpproposalVO vo) throws Exception {
		try {
			SpproposalDAO dao = (SpproposalDAO) DAOFactory.build(
					SpproposalDAO.class, user);
			// TODO set the pk */
			return (SpproposalVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(SpproposalVO vo) throws Exception {
		try {
			SpproposalDAO dao = (SpproposalDAO) DAOFactory.build(
					SpproposalDAO.class, user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			SpproposalDAO dao = (SpproposalDAO) DAOFactory.build(
					SpproposalDAO.class, user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}
	
	/**
	 * ȫ��ɾ����Ӧ���������µ�������ؼ�¼
	 */
	public void doBatchDelete(Long pid) throws Exception{
		try {
			SpproposalBO sppbo = (SpproposalBO) BOFactory.build(
					SpproposalBO.class, getUser());
			PpzlnruleBO ppzlnbo = (PpzlnruleBO) BOFactory.build(
					PpzlnruleBO.class, getUser());
			PpzlnruleDBParam ppzlnruleparam = new PpzlnruleDBParam();
			PpzlnruleVO ppzlnrulevo = new PpzlnruleVO();
			PpzlnruleVO ppzlnrulevo2 = new PpzlnruleVO();
			RuleitemDBParam itemparam = new RuleitemDBParam();
			RuleitemVO itemvo = new RuleitemVO();
			List<Long> itemidlist = new ArrayList<Long>();
			RuleitemBO itembo = (RuleitemBO) BOFactory.build(RuleitemBO.class,
					getUser());
			RuleitemBO ruleitembo = (RuleitemBO) BOFactory.build(
					RuleitemBO.class, getUser());
			
			ppzlnruleparam.set_ne_pid(pid.toString());
			DataPackage ppzlnruledp = ppzlnbo.doQuery(ppzlnruleparam);
			//����ô����������з���������¼, ���ȴ���
			if(ppzlnruledp!=null && ppzlnruledp.getDatas().size()>0){
				for(int i=0;i<ppzlnruledp.getDatas().size();i++){
					ppzlnrulevo = (PpzlnruleVO) ppzlnruledp.getDatas().get(i);
					ppzlnruleparam.set_ne_ruleid(ppzlnrulevo.getRuleid().toString());
					ppzlnruleparam.set_ne_pid(pid.toString());
					itemparam.set_ne_ruleid(ppzlnrulevo.getRuleid().toString());
					DataPackage ppzlnruledp2 = ppzlnbo.doQuery(ppzlnruleparam);
					DataPackage itemdp = itembo.doQuery(itemparam);
					if (ppzlnruledp2 != null && ppzlnruledp2.getDatas().size() > 0) {
						ppzlnrulevo2 = (PpzlnruleVO) ppzlnruledp2.getDatas().get(0);
						if(itemdp != null && itemdp.getDatas().size() > 0){
						for (int j = 0; j < itemdp.getDatas().size(); j++) {
							itemvo = (RuleitemVO) itemdp.getDatas().get(j);
							itemidlist.add(new Long(itemvo.getItemid()));
							}
						}
					}
					//ɾ��������ϸ��¼Ruleitem
					if(itemidlist.size()>0){
						for (int k = 0; k < itemidlist.size(); k++) {
							ruleitembo.doRemoveByPK(new Long(itemidlist.get(k)));
						}
					}
					sppbo.doBatchRuleDelete(ppzlnrulevo.getRuleid());
					ppzlnbo.doRemoveByVO(ppzlnrulevo);
				}
				sppbo.doBatchCxDelete(pid);
				sppbo.doRemoveByPK(pid);
			//���û�з���������¼, ����
			}else{
				sppbo.doBatchCxDelete(pid);
				sppbo.doRemoveByPK(pid);
			}
		}catch (Exception ex) {
			throw new JOPException(ex);
		}
	}
	
	/**
	 * ɾ�������������س��,����,������,����(��ǰ),����(�ۺ�)
	 */
	public void doBatchRuleDelete(Long ruleid) throws Exception{
		try {
			PquantityVO pquantityvo = new PquantityVO();
			PquantityDBParam pquantityparam = new PquantityDBParam();
			PquantityBO pquantitybo = (PquantityBO) BOFactory.build(
					PquantityBO.class, getUser());
			PresentingaVO presentingavo = new PresentingaVO();
			PresentingaDBParam presentingaparam = new PresentingaDBParam();
			PresentingaBO presentingabo = (PresentingaBO) BOFactory.build(
					PresentingaBO.class, getUser());
			PresentingbVO presentingbvo = new PresentingbVO();
			PresentingbDBParam presentingbparam = new PresentingbDBParam();
			PresentingbBO presentingbbo = (PresentingbBO) BOFactory.build(
					PresentingbBO.class, getUser());
			RewardstdVO rewardstdvo = new RewardstdVO();
			RewardstdDBParam rewardstddbparam = new RewardstdDBParam();
			RewardstdBO rewardstdbo = (RewardstdBO) BOFactory.build(
					RewardstdBO.class, getUser());
			TieinsaleVO tieinsalevo = new TieinsaleVO();
			TieinsaleDBParam tieinsaledbparam = new TieinsaleDBParam();
			TieinsaleBO tieinsalebo = (TieinsaleBO) BOFactory.build(
					TieinsaleBO.class, getUser());
			RuleBO rulebo = (RuleBO) BOFactory.build(RuleBO.class, getUser());
			RuleDBParam ruleparam = new RuleDBParam();

			pquantityparam.set_ne_ruleid(ruleid.toString());
			pquantityparam.setQueryAll(true);
			presentingaparam.set_ne_ruleid(ruleid.toString());
			presentingaparam.setQueryAll(true);
			presentingbparam.set_ne_ruleid(ruleid.toString());
			presentingbparam.setQueryAll(true);
			rewardstddbparam.set_ne_ruleid(ruleid.toString());
			rewardstddbparam.setQueryAll(true);
			tieinsaledbparam.set_ne_ruleid(ruleid.toString());
			tieinsaledbparam.setQueryAll(true);
			ruleparam.set_ne_ruleid(ruleid.toString());
			ruleparam.setQueryAll(true);

			//ɾ�����ж�������¼
			DataPackage pquantitydp = pquantitybo.doQuery(pquantityparam);
			if (pquantitydp != null && pquantitydp.getDatas().size() > 0) {
				for (int i = 0; i < pquantitydp.getDatas().size(); i++) {
					pquantityvo = (PquantityVO) pquantitydp.getDatas().get(i);
					pquantitybo.doRemoveByVO(pquantityvo);
				}
			}
			
			//ɾ����������(�ۺ�)��¼
			DataPackage presentingadp = presentingabo.doQuery(presentingaparam);
			if (presentingadp != null && presentingadp.getDatas().size() > 0) {
				for (int i = 0; i < presentingadp.getDatas().size(); i++) {
					presentingavo = (PresentingaVO) presentingadp.getDatas()
							.get(i);
					presentingabo.doRemoveByVO(presentingavo);
				}
			}
			
			//ɾ����������(��ǰ)��¼
			DataPackage presentingbdp = presentingbbo.doQuery(presentingbparam);
			if (presentingbdp != null && presentingbdp.getDatas().size() > 0) {
				for (int i = 0; i < presentingbdp.getDatas().size(); i++) {
					presentingbvo = (PresentingbVO) presentingbdp.getDatas()
							.get(i);
					presentingbbo.doRemoveByVO(presentingbvo);
				}
			}
			
			//ɾ�����г���׼��¼
			DataPackage rewardstddp = rewardstdbo.doQuery(rewardstddbparam);
			if (rewardstddp != null && rewardstddp.getDatas().size() > 0) {
				for (int i = 0; i < rewardstddp.getDatas().size(); i++) {
					rewardstdvo = (RewardstdVO) rewardstddp.getDatas().get(i);
					rewardstdbo.doRemoveByVO(rewardstdvo);
				}
			}
			
			//ɾ�����д��ۼ�¼
			DataPackage tieinsaledp = tieinsalebo.doQuery(tieinsaledbparam);
			if (tieinsaledp != null && tieinsaledp.getDatas().size() > 0) {
				for (int i = 0; i < tieinsaledp.getDatas().size(); i++) {
					tieinsalevo = (TieinsaleVO) tieinsaledp.getDatas().get(i);
					tieinsalebo.doRemoveByVO(tieinsalevo);
				}
			}
			
			//ɾ�����й����¼
			DataPackage ruledp = rulebo.doQuery(ruleparam);
			if(ruledp !=null && ruledp.getDatas().size()>0){
				for (int i = 0; i < ruledp.getDatas().size(); i++){
					rulebo.doRemoveByPK(ruleid);
				}
			}
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}
	
	/**
	 * ɾ�������µķ����������, ��������Ʒ�ͷ�������Դ
	 */
	public void doBatchCxDelete(Long pid) throws Exception {
		try {
			PpzlnptnrVO ptnrvo = new PpzlnptnrVO();
			PpzlnptnrDBParam ptnrparam = new PpzlnptnrDBParam();
			PpzlnptnrBO ptnrbo = (PpzlnptnrBO) BOFactory.build(
					PpzlnptnrBO.class, getUser());
			PpzlncomVO comvo = new PpzlncomVO();
			PpzlncomDBParam comparam = new PpzlncomDBParam();
			PpzlncomBO combo = (PpzlncomBO) BOFactory.build(PpzlncomBO.class,
					getUser());
			PpzlnresVO resvo = new PpzlnresVO();
			PpzlnresDBParam resparam = new PpzlnresDBParam();
			PpzlnresBO resbo = (PpzlnresBO) BOFactory.build(PpzlnresBO.class,
					getUser());

			ptnrparam.set_ne_pid(pid.toString());
			ptnrparam.setQueryAll(true);
			comparam.set_ne_pid(pid.toString());
			comparam.setQueryAll(true);
			resparam.set_ne_pid(pid.toString());
			resparam.setQueryAll(true);

			//ɾ�����з�����������¼
			DataPackage ptnrdp = ptnrbo.doQuery(ptnrparam);
			if (ptnrdp != null && ptnrdp.getDatas().size() > 0) {
				for (int i = 0; i < ptnrdp.getDatas().size(); i++) {
					ptnrvo = (PpzlnptnrVO) ptnrdp.getDatas().get(i);
					ptnrbo.doRemoveByVO(ptnrvo);
				}
			}
			
			//ɾ�����з�������Ʒ�����¼
			DataPackage comdp = combo.doQuery(comparam);
			if (comdp != null && comdp.getDatas().size() > 0) {
				for (int i = 0; i < comdp.getDatas().size(); i++) {
					comvo = (PpzlncomVO) comdp.getDatas().get(i);
					combo.doRemoveByVO(comvo);
				}
			}
			
			//ɾ�����з�������Դ��¼
			DataPackage resdp = resbo.doQuery(resparam);
			if (resdp != null && resdp.getDatas().size() > 0) {
				for (int i = 0; i < resdp.getDatas().size(); i++) {
					resvo = (PpzlnresVO) resdp.getDatas().get(i);
					resbo.doRemoveByVO(resvo);
				}
			}
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public SpproposalVO doUpdate(SpproposalVO vo) throws Exception {
		try {
			SpproposalDAO dao = (SpproposalDAO) DAOFactory.build(
					SpproposalDAO.class, user);
			return (SpproposalVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public SpproposalVO doFindByPk(Serializable pk) throws Exception {
		SpproposalDAO dao = (SpproposalDAO) DAOFactory.build(
				SpproposalDAO.class, user);
		return (SpproposalVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(SpproposalDBParam params) throws Exception {
		SpproposalDAO dao = (SpproposalDAO) DAOFactory.build(
				SpproposalDAO.class, user);
		return dao.query(params);
	}

	public void doBatchEdit(SpproposalVO vo, List deamonList) throws Exception {
		try {
			Spproposal spp = (Spproposal) BOFactory.build(SpproposalBO.class, user);
			spp.doUpdate(vo);
			int type = Integer.parseInt(vo.getPtype());
			
			//����daemon
			Daemon daemon = (Daemon) BOFactory.build(DaemonBO.class, user);
			DaemonDBParam params = new DaemonDBParam();
			params.set_se_params(vo.getPid()+",");
			params.setQueryAll(true);
			DataPackage dp = daemon.doQuery(params);
			for(Iterator itt = dp.getDatas().iterator(); itt.hasNext();){
				DaemonVO daemonvo = (DaemonVO)itt.next();
				daemon.doRemoveByVO(daemonvo);
			}
			
			DaemonVO daemonVO = new DaemonVO();
			Calendar c = Calendar.getInstance();
			switch (type) {
			case 0: // ���
				c.setTime(vo.getPendtime());
				c.add(Calendar.MONTH, 1);
				c.set(Calendar.DAY_OF_MONTH, 10);
				daemonVO.setProcessid((long) 1);
				daemonVO.setModule("1");
				daemonVO.setStartingdate(c.getTime());
				daemonVO.setParams(vo.getPid() + ",");
				daemon.doCreate(daemonVO);
				break;
			case 1: // ������
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				for (Iterator itt = deamonList.iterator(); itt.hasNext();) {
					DaemonVO daemonVO2 = new DaemonVO();
					daemonVO2.setProcessid((long) 2);
					daemonVO2.setModule("1");
					daemonVO2.setParams(vo.getPid() + ",");
					daemonVO2.setStartingdate(sdf.parse((String) itt.next()));
					daemon.doCreate(daemonVO2);
				}
				break;
			case 4: // ���ͣ��ۺ�
				c.setTime(vo.getPendtime());
				c.add(Calendar.MONTH, 1);
				c.set(Calendar.DAY_OF_MONTH, 10);
				daemonVO.setProcessid((long) 3);
				daemonVO.setModule("1");
				daemonVO.setStartingdate(c.getTime());
				daemonVO.setParams(vo.getPid() + ",");
				daemon.doCreate(daemonVO);
				break;
			default:
				break;
		}
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}
	

	public void doBatchCreate(SpproposalVO vo, List deamonList) throws Exception {
		// TODO Auto-generated method stub
		try {
			Spproposal spp = (Spproposal) BOFactory.build(SpproposalBO.class, user);
			spp.doCreate(vo);
			int type = Integer.parseInt(vo.getPtype());
			Daemon daemon = (Daemon) BOFactory.build(DaemonBO.class, user);
			DaemonVO daemonVO = new DaemonVO();
			Calendar c = Calendar.getInstance();
			switch (type) {
				case 0: // ���
					c.setTime(vo.getPendtime());
					c.add(Calendar.MONTH, 1);
					c.set(Calendar.DAY_OF_MONTH, 10);
					daemonVO.setProcessid((long) 1);
					daemonVO.setModule("1");
					daemonVO.setStartingdate(c.getTime());
					daemonVO.setParams(vo.getPid() + ",");
					daemon.doCreate(daemonVO);
					break;
				case 1: // ������
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
					for (Iterator itt = deamonList.iterator(); itt.hasNext();) {
						DaemonVO daemonVO2 = new DaemonVO();
						daemonVO2.setProcessid((long) 2);
						daemonVO2.setModule("1");
						daemonVO2.setParams(vo.getPid() + ",");
						daemonVO2.setStartingdate(sdf.parse((String) itt.next()));
						daemon.doCreate(daemonVO2);
					}
					break;
				case 4: // ���ͣ��ۺ�
					c.setTime(vo.getPendtime());
					c.add(Calendar.MONTH, 1);
					c.set(Calendar.DAY_OF_MONTH, 10);
					daemonVO.setProcessid((long) 3);
					daemonVO.setModule("1");
					daemonVO.setStartingdate(c.getTime());
					daemonVO.setParams(vo.getPid() + ",");
					daemon.doCreate(daemonVO);
					break;
				default:
					break;
			}
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public Map<VO, Object> doGetDescartesMap() throws Exception {
		SpproposalDAO dao = (SpproposalDAO) DAOFactory.build(SpproposalDAO.class, user);
		return dao.getDescartesMap();
	}
	
	public List doTieInSale(String wayId, String comCategory, List resids)
			throws Exception {
		List<TiedComInfo> resultList = new ArrayList<TiedComInfo>();
		
		SpproposalDBParam spParam = new SpproposalDBParam();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String curDate = format.format(new java.util.Date());
		spParam.set_dnm_pstarttime(curDate);
		spParam.set_dnl_pendtime(curDate);
		spParam.set_se_ptype("2");
		spParam.set_pagesize("0");
		spParam.setDataOnly(true);
		List<SpproposalVO> proposalList = 
			new ArrayList<SpproposalVO>(this.doQuery(spParam).getDatas());
		
		Ppzlnrule prBo = (PpzlnruleBO)BOFactory.build(PpzlnruleBO.class, user);
		Tieinsale tsBo = (TieinsaleBO)BOFactory.build(TieinsaleBO.class, user);
		Ruleitem riBo = (RuleitemBO)BOFactory.build(RuleitemBO.class,user);
		PpzlnptnrBO ptnrBo = (PpzlnptnrBO) BOFactory.build(PpzlnptnrBO.class, user);
		for (SpproposalVO proVo : proposalList) {
			// ��������
			try {
				long pId = proVo.getPid();
				String pfrtMode = proVo.getPfrtmode();
				DataPackage dp = null;
				if ("0".equals(pfrtMode)) {
					dp = prBo.doQueryRulesByPid(pId, true);
				} else {
					dp = prBo.doQueryRulesByPid(pId, false);
				}
				Collection datas = dp.getDatas();
				if(datas==null || datas.size() <=0)
					continue;
				List list = new ArrayList(datas);
				for(int i=0;i<list.size();i++) {
					// ��������
					try {
						Map map = (Map)list.get(i);
						long ruleId = Long.parseLong((String)map.get("RULEID"));
						Map<VO, Object> dataSet = riBo.doSrcDataFiltering(pId, ruleId);
						dataSet = riBo.doBenchmarkDataValidating(dataSet, ruleId);
						dataSet = filterDataSet(dataSet, wayId, comCategory, resids);
						if (dataSet.size() > 0) {
							Serializable tsPk = new TieinsaleVO();
							BeanUtils.setProperty(tsPk, "ruleid", ruleId);
							BeanUtils.setProperty(tsPk, "comcategory", comCategory);
							TieinsaleVO tsVo = tsBo.doFindByPk(tsPk);
							if(tsVo==null)
								continue;
							// ��Ʒ����
							short quantity = tsVo.getQuantity();
							// ������Ʒ����
							short tQuantity = tsVo.getTquantity();
							// ������Ʒ����
							String tComCategory = tsVo.getTcomcategory();
							// ��Ʒ����
							int comTotal = (int)statTotal(dataSet);
							int tQuantityForRule = (comTotal / quantity) * tQuantity;
							TiedComInfo tcInfo = new TiedComInfo();
							tcInfo.setPid(pId);
							tcInfo.setRuleid(ruleId);
							tcInfo.setTComCategory(tComCategory);
							tcInfo.setTQuantity(tQuantityForRule);
							if(tQuantityForRule > 0){
								resultList.add(tcInfo);
							}
							if ("0".equals(pfrtMode) && resultList.size() > 0) {
								// ����÷������Żݷ�ʽ[PFRTMODE]��Ϊ������[0]����
								// �Ҹ���������������Ӧ�Żݣ��������������
								break;
							}
						}else{
							//1�����ݷ���ID�Ͳ��������ж�CH_CX_PPZLNPTNR�Ƿ�������ݣ��������,���򷵻�
							PpzlnptnrDBParam ppzlnptnrDBParam = new PpzlnptnrDBParam();
							ppzlnptnrDBParam.set_ne_pid(""+pId);
							ppzlnptnrDBParam.set_se_wayid(wayId);
							DataPackage ppzlnptnrDp = ptnrBo.doQuery(ppzlnptnrDBParam);
							if(ppzlnptnrDp.getRowCount() <= 0){
								//����
								continue;
							}
							
							//2����ѯ��Ӧ����Ʒ����Ĵ�����Ϣ
							Serializable tsPk = new TieinsaleVO();
							BeanUtils.setProperty(tsPk, "ruleid", ruleId);
							BeanUtils.setProperty(tsPk, "comcategory", comCategory);
							TieinsaleVO tsVo = tsBo.doFindByPk(tsPk);
							if(tsVo==null)
								continue;
							// ��Ʒ����							
							short quantity = tsVo.getQuantity();
							// ������Ʒ����
							short tQuantity = tsVo.getTquantity();
							// ������Ʒ����
							String tComCategory = tsVo.getTcomcategory();
							// ��Ʒ����
							int comTotal = resids.size();
							int tQuantityForRule = (comTotal / quantity) * tQuantity;
							TiedComInfo tcInfo = new TiedComInfo();
							tcInfo.setPid(pId);
							tcInfo.setRuleid(ruleId);
							tcInfo.setTComCategory(tComCategory);
							tcInfo.setTQuantity(tQuantityForRule);
							if(tQuantityForRule > 0){
								resultList.add(tcInfo);
							}
							if ("0".equals(pfrtMode) && resultList.size() > 0) {
								// ����÷������Żݷ�ʽ[PFRTMODE]��Ϊ������[0]����
								// �Ҹ���������������Ӧ�Żݣ��������������
								break;
							}
						}					
					}catch(Exception ex) {
						// ��ĳһ�������쳣������ȫ�ֻع������������ù������������һ����
						ex.printStackTrace();
						continue;
					}
				}
			}catch(Exception ex) {
				//  ��ĳһ���������쳣������ȫ�ֻع������������÷�������������һ����
				ex.printStackTrace();
				continue;
			}
		}
		return resultList;
	}
	
	public List doPresentingB(String wayId, String comCategory, List resids)
			throws Exception {
		List<TiedComInfo> resultList = new ArrayList<TiedComInfo>();
		
		SpproposalDBParam spParam = new SpproposalDBParam();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String curDate = format.format(new java.util.Date());
		spParam.set_dnm_pstarttime(curDate);
		spParam.set_dnl_pendtime(curDate);
		spParam.set_se_ptype("3");
		spParam.set_pagesize("0");
		spParam.setDataOnly(true);
		List<SpproposalVO> proposalList = 
			new ArrayList<SpproposalVO>(this.doQuery(spParam).getDatas());
		Ppzlnrule prBo = (PpzlnruleBO)BOFactory.build(PpzlnruleBO.class, user);
		Presentingb pbBo = (PresentingbBO)BOFactory.build(PresentingbBO.class, user);
		Ruleitem riBo = (RuleitemBO)BOFactory.build(RuleitemBO.class,user);
		
		for (SpproposalVO proVo : proposalList) {
			// ��������
			try {
				long pId = proVo.getPid();
				String pfrtMode = proVo.getPfrtmode();
				DataPackage dp = null;
				if ("0".equals(pfrtMode)) {
					dp = prBo.doQueryRulesByPid(pId, true);
				} else {
					dp = prBo.doQueryRulesByPid(pId, false);
				}
				Collection datas = dp.getDatas();
				if(datas==null || datas.size() <=0)
					continue;
				List list = new ArrayList(datas);
				for(int i=0;i<list.size();i++) {
					// ��������
					try {
						Map map = (Map)list.get(i);
						long ruleId = Long.parseLong((String)map.get("RULEID"));
						Map<VO, Object> dataSet = riBo.doSrcDataFiltering(pId, ruleId);
						dataSet = riBo.doBenchmarkDataValidating(dataSet, ruleId);
						dataSet = filterDataSet(dataSet, wayId, comCategory, resids);
						if (dataSet.size() > 0) {
							Serializable pbPk = new PresentingbVO();
							BeanUtils.setProperty(pbPk, "ruleid", ruleId);
							BeanUtils.setProperty(pbPk, "comcategory", comCategory);
							PresentingbVO pbVo = pbBo.doFindByPk(pbPk);
							if(pbVo==null)
								continue;
							short quantity = pbVo.getQuantity();
							short pQuantity = pbVo.getPquantity();
							String pComCategory = pbVo.getPcomcategory();
							// ��Ʒ����
							int comTotal = (int)statTotal(dataSet);
							int pQuantityForRule = (comTotal / quantity) * pQuantity;
							TiedComInfo tcInfo = new TiedComInfo();
							tcInfo.setPid(pId);
							tcInfo.setRuleid(ruleId);
							tcInfo.setTComCategory(pComCategory);
							tcInfo.setTQuantity(pQuantityForRule);
							if(pQuantityForRule > 0){
								resultList.add(tcInfo);
							}
							if ("0".equals(pfrtMode) && resultList.size()>0) {
								// ����÷������Żݷ�ʽ[PFRTMODE]��Ϊ������[0]����
								// �Ҹ���������������Ӧ�Żݣ��������������
								break;
							}
						}
					}catch(Exception ex) {
						// ��ĳһ�������쳣������ȫ�ֻع������Ǽ���������һ����
						ex.printStackTrace();
						continue;
					}
				}
			}catch(Exception ex) {
				//  ��ĳһ���������쳣������ȫ�ֻع������������÷�������������һ����
				ex.printStackTrace();
				continue;
			}
		}
		return resultList;
	}

	private Map<VO, Object> filterDataSet(Map<VO, Object> srcData,
			String wayId, String comCategory, List resids) throws Exception {
		
		Set<VO> srcKeys = srcData.keySet();
		Iterator<VO> keysIt = srcKeys.iterator();
		boolean resEqual = false;
		while (keysIt.hasNext()) {
			DefaultVO vo = (DefaultVO) keysIt.next();
			HashMap<String, ?> voMap = vo.getKeys();
			if (wayId != null && !wayId.equals((String) voMap.get("WAYID"))&& !wayId.equals((String) voMap.get("��������"))) {
				keysIt.remove();
				continue;
			}
			if (comCategory != null && 
					!comCategory.equals((String) voMap.get("COMCATEGORY")) 
					&& !comCategory.equals((String) voMap.get("��Ʒ����"))) {
				keysIt.remove();
				continue;
			}
			String resID = (String) voMap.get("RESID");
			if(resID == null)
				resID = (String) voMap.get("��Դ��ʶ");
			if(resID == null)
				continue;
			for (int i = 0; resids !=null && i < resids.size(); i++) {
				String resid = (String) resids.get(i);
				if (resID.equals(resid)) {
					resEqual = true;
					break;
				}
			}
			if (!resEqual) {
				keysIt.remove();
			} else {
				resEqual = false;
			}
		}
		return srcData;
	}
	
	/**
	 * ͳ��Դ�����е�ҵ����
	 * 
	 * @param srcData
	 * @return
	 * @throws Exception
	 */
	private double statTotal(Map<VO, Object> srcData) throws Exception {
		Iterator<VO> it = srcData.keySet().iterator();
		    double sum=0;
		while(it.hasNext()){
		        DefaultVO vo = (DefaultVO)it.next();
		        sum = sum +((Double)vo.getValue()).doubleValue();
		}
		return sum;
		}
	
}
