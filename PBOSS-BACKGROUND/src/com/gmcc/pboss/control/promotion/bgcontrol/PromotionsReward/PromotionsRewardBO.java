package com.gmcc.pboss.control.promotion.bgcontrol.PromotionsReward;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import open.tool.rule.data.VO;

import com.gmcc.pboss.business.promotion.elmttmpl.DefaultVO;
import com.gmcc.pboss.business.promotion.promotingwayid.PromotingwayidVO;
import com.gmcc.pboss.business.promotion.rewarddetail.RewarddetailVO;
import com.gmcc.pboss.business.promotion.rewardstd.RewardstdVO;
import com.gmcc.pboss.business.promotion.spproposal.SpproposalVO;
import com.gmcc.pboss.control.promotion.ppzlnrule.Ppzlnrule;
import com.gmcc.pboss.control.promotion.ppzlnrule.PpzlnruleBO;
import com.gmcc.pboss.control.promotion.promotingwayid.Promotingwayid;
import com.gmcc.pboss.control.promotion.promotingwayid.PromotingwayidBO;
import com.gmcc.pboss.control.promotion.rewarddetail.Rewarddetail;
import com.gmcc.pboss.control.promotion.rewarddetail.RewarddetailBO;
import com.gmcc.pboss.control.promotion.rewardstd.Rewardstd;
import com.gmcc.pboss.control.promotion.rewardstd.RewardstdBO;
import com.gmcc.pboss.control.promotion.ruleitem.Ruleitem;
import com.gmcc.pboss.control.promotion.ruleitem.RuleitemBO;
import com.gmcc.pboss.control.promotion.spproposal.Spproposal;
import com.gmcc.pboss.control.promotion.spproposal.SpproposalBO;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class PromotionsRewardBO extends AbstractControlBean implements
		PromotionsReward {

	public void doHandleReward(Map<VO, Object> srcData, long pid, long ruleid)
			throws Exception {
		
		if(srcData != null && srcData.size() <= 0) return;
		
		Set<VO> srcKeys = srcData.keySet();
		Iterator<VO> keysIt = srcKeys.iterator();
		Rewardstd rsBo = (RewardstdBO)BOFactory.build(RewardstdBO.class, user);
		Rewarddetail rdBo = (RewarddetailBO)BOFactory.build(RewarddetailBO.class, user);
		Promotingwayid pwBo = (PromotingwayidBO)BOFactory.build(PromotingwayidBO.class, user);
		
		Serializable rsPk = new RewardstdVO();
		BeanUtils.setProperty(rsPk, "ruleid", ruleid);
		
		List<RewardstdVO> rsList = null;
		// wayidSet记录即将要新增到已促销渠道表中的渠道ID
		Set<String> wayidSet = new HashSet<String>();
		try {
			while(keysIt.hasNext()) {
				DefaultVO vo = (DefaultVO)keysIt.next();
				HashMap<String,?> voMap = vo.getKeys();
				String wayId = (String)voMap.get("WAYID");
				
				if(voMap.containsKey("COMCATEGORY")) {
					String comCategory = (String)voMap.get("COMCATEGORY");
					if(comCategory != null) {
						BeanUtils.setProperty(rsPk, "comcategory", comCategory);
						RewardstdVO rsVo = rsBo.doFindByPk(rsPk);
						if(rsVo != null) {
							Double reward = rsVo.getReward();
							Double amount = reward*(Double)srcData.get(vo);
							Calendar cal = Calendar.getInstance();
							cal.add(Calendar.MONTH, -1);
							SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
							// 结算月
							String calcMonth = format.format(cal.getTime());
							
							// 添加一条酬金明细记录
							RewarddetailVO rdVo = new RewarddetailVO();
							rdVo.setCreatingtime(new java.util.Date());
							rdVo.setPid(pid);
							rdVo.setRuleid(ruleid);
							rdVo.setSourceid("-1");
							rdVo.setOpnid("-1");
							rdVo.setMobile("-1");
							rdVo.setOprtime(null);
							rdVo.setWayid(wayId);
							rdVo.setCalcmonth(calcMonth);
							rdVo.setComcategory(comCategory);
							rdVo.setRwdtype("-1");
							rdVo.setStdamount(reward);
							rdVo.setAmount(amount);
							
							rdBo.doCreate(rdVo);
							// 即将要新增到已促销渠道表中的渠道ID 放到wayid中存放
							wayidSet.add(wayId);
						}
					}
				}
				
				/*else {
					rsParam.getQueryConditions().put("_se_comcategory", "*");
					rsList = new ArrayList<RewardstdVO>(rsBo.doQuery(rsParam, cityid).getDatas());
					for(RewardstdVO rsVo : rsList) {
						Double reward = rsVo.getReward();
						Double amount = reward*(Double)srcData.get(vo);
						Calendar cal = Calendar.getInstance();
						cal.add(Calendar.MONTH, -1);
						SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
						// 结算月
						String calcMonth = format.format(cal.getTime());
						// 添加一条酬金明细记录
						RewarddetailVO rdVo = new RewarddetailVO();
						rdVo.setCreatingtime(new java.util.Date());
						rdVo.setPid(pid);
						rdVo.setRuleid(new Integer(ruleid));
						rdVo.setSourceid("-1");
						rdVo.setOpnid("-1");
						rdVo.setMobile("-1");
						rdVo.setOprtime(null);
						rdVo.setWayid(wayId);
						rdVo.setCalcmonth(calcMonth);
						rdVo.setComcategory("-1");
						rdVo.setRwdtype("-1");
						rdVo.setStdamount(rsVo.getReward());
						rdVo.setAmount(amount);
						
						rdBo.doCreate(rdVo, cityid);
					}
				}*/
			}
			// 批量保存已促销渠道
			for(Iterator<String> wayIt = wayidSet.iterator();wayIt.hasNext();) {
				String wayid = wayIt.next();
				PromotingwayidVO pwVo = new PromotingwayidVO();
				pwVo.setPid(pid);
				pwVo.setRuleid(ruleid);
				pwVo.setWayid(wayid);
				
				pwBo.doCreate(pwVo);
				
			}
		}catch(Exception ex) {
			throw new JOPException(ex);
		}

	}

	public void doProcess(long pid) throws Exception {

		Ruleitem riBo = (RuleitemBO)BOFactory.build(RuleitemBO.class, user);
		Spproposal spBo = (SpproposalBO)BOFactory.build(SpproposalBO.class, user);
		Ppzlnrule prBo = (PpzlnruleBO)BOFactory.build(PpzlnruleBO.class, user);
		Promotingwayid pwBo = (PromotingwayidBO)BOFactory.build(PromotingwayidBO.class, user);
		try {
		
			SpproposalVO spVo = spBo.doFindByPk(pid);
			String pfrtMode = spVo.getPfrtmode();
			DataPackage dp = prBo.doQueryRulesByPid(pid,true);
			Collection datas = dp.getDatas();
			if(datas!=null && datas.size()>0) {
				List list = new ArrayList(datas);
				for(int i=0;i<list.size();i++) {
					Map map = (Map)list.get(i);
					long ruleid = Long.parseLong((String)map.get("RULEID"));
					Map dataSet = riBo.doSrcDataFiltering(pid, ruleid);
					dataSet = riBo.doBenchmarkDataValidating(dataSet, ruleid);
					dataSet = pwBo.filterDataByPfrtMode(dataSet,pfrtMode,pid,ruleid);
					this.doHandleReward(dataSet, pid, ruleid);
				}
			}
		}catch(Exception ex) {
			throw new JOPException(ex);
		}

	}

}
