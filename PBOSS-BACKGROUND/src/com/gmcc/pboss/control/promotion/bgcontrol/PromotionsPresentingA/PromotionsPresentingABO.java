package com.gmcc.pboss.control.promotion.bgcontrol.PromotionsPresentingA;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import open.tool.rule.data.VO;

import com.gmcc.pboss.business.promotion.elmttmpl.DefaultVO;
import com.gmcc.pboss.business.promotion.presentinga.PresentingaDBParam;
import com.gmcc.pboss.business.promotion.presentinga.PresentingaVO;
import com.gmcc.pboss.business.promotion.presentingdtl.PresentingdtlVO;
import com.gmcc.pboss.business.promotion.promotingwayid.PromotingwayidVO;
import com.gmcc.pboss.business.promotion.spproposal.SpproposalVO;
import com.gmcc.pboss.control.promotion.ppzlnrule.Ppzlnrule;
import com.gmcc.pboss.control.promotion.ppzlnrule.PpzlnruleBO;
import com.gmcc.pboss.control.promotion.presentinga.Presentinga;
import com.gmcc.pboss.control.promotion.presentinga.PresentingaBO;
import com.gmcc.pboss.control.promotion.presentingdtl.Presentingdtl;
import com.gmcc.pboss.control.promotion.presentingdtl.PresentingdtlBO;
import com.gmcc.pboss.control.promotion.promotingwayid.Promotingwayid;
import com.gmcc.pboss.control.promotion.promotingwayid.PromotingwayidBO;
import com.gmcc.pboss.control.promotion.ruleitem.Ruleitem;
import com.gmcc.pboss.control.promotion.ruleitem.RuleitemBO;
import com.gmcc.pboss.control.promotion.spproposal.Spproposal;
import com.gmcc.pboss.control.promotion.spproposal.SpproposalBO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class PromotionsPresentingABO extends AbstractControlBean implements
		PromotionsPresentingA {

	public void doHandlePresentingA(Map<VO, Object> srcData, long pid,
			long ruleid) throws Exception {

		if(srcData != null && srcData.size() <= 0) return;
		
		Set<VO> srcKeys = srcData.keySet();
		Iterator<VO> keysIt = srcKeys.iterator();

		Presentinga paBo = (PresentingaBO)BOFactory.build(PresentingaBO.class,user);
		Presentingdtl pdBo = (PresentingdtlBO)BOFactory.build(PresentingdtlBO.class, user);
		Promotingwayid pwBo = (PromotingwayidBO)BOFactory.build(PromotingwayidBO.class, user);

		PresentingaVO paVo = new PresentingaVO();
		paVo.setRuleid(ruleid);
		
		PresentingaDBParam paParam = new PresentingaDBParam();
		paParam.set_pagesize("0");
		paParam.setDataOnly(true);
		paParam.getQueryConditions().put("_ne_ruleid", ruleid);

		// wayidSet记录即将要新增到已促销渠道表中的渠道ID
		Set<String> wayidSet = new HashSet<String>();
		try {
			while (keysIt.hasNext()) {
				DefaultVO vo = (DefaultVO) keysIt.next();
				HashMap<String, ?> voMap = vo.getKeys();
				String wayid = (String)voMap.get("WAYID");
				
				if (voMap.containsKey("COMCATEGORY")) {
					String comCategory = (String) voMap.get("COMCATEGORY");
					if(comCategory != null) {
						paVo.setComcategory(comCategory);
						PresentingaVO presentingaVO = paBo.doFindByPk(paVo);
						if(presentingaVO != null) {
							short quantity = presentingaVO.getQuantity();
							short pQuantity = presentingaVO.getPquantity();
							String pComCategory = presentingaVO.getPcomcategory();
							// 最终赠送商品数量
							short pqAmount = (short)((Double)vo.getValue() / quantity * pQuantity);
							PresentingdtlVO pdVo = new PresentingdtlVO();
							pdVo.setCreatingtime(new java.util.Date());
							pdVo.setPid(pid);
							pdVo.setRuleid(ruleid);
							pdVo.setWayid(wayid);
							pdVo.setComcategory(comCategory);
							pdVo.setQuantity(pqAmount);
							
							pdBo.doCreate(pdVo);
							
							// 即将要新增到已促销渠道表中的渠道ID 放到wayid中存放
							wayidSet.add(wayid);
						}
					}
				} else {
					paParam.getQueryConditions().put("_se_comcategory", "*");
					
					List<PresentingaVO> paVoList = new ArrayList<PresentingaVO>(paBo.doQuery(paParam).getDatas());
					for(PresentingaVO preAVo : paVoList) {
						short quantity = preAVo.getQuantity();
						short pQuantity = preAVo.getPquantity();
						String pComCategory = preAVo.getPcomcategory();
						// 最终赠送商品数量
						short pqAmount = (short)((Double)vo.getValue() / quantity * pQuantity);
						PresentingdtlVO pdVo = new PresentingdtlVO();
						pdVo.setCreatingtime(new java.util.Date());
						pdVo.setPid(pid);
						pdVo.setRuleid(ruleid);
						pdVo.setWayid(wayid);
						pdVo.setComcategory("*");
						pdVo.setQuantity(pqAmount);
						
						pdBo.doCreate(pdVo);
					}
					if(paVoList.size() > 0) {
						// 即将要新增到已促销渠道表中的渠道ID 放到wayid中存放
						wayidSet.add(wayid);
					}
				}
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
					dataSet = pwBo.filterDataByPfrtMode(dataSet, pfrtMode, pid, ruleid);
					this.doHandlePresentingA(dataSet,pid,ruleid);
				}
			}
		}catch(Exception ex) {
			throw new JOPException(ex);
		}

	}

}
