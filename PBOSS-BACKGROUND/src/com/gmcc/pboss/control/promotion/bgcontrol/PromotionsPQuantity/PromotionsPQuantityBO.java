package com.gmcc.pboss.control.promotion.bgcontrol.PromotionsPQuantity;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
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
import com.gmcc.pboss.business.promotion.pquantity.PquantityDBParam;
import com.gmcc.pboss.business.promotion.pquantity.PquantityVO;
import com.gmcc.pboss.business.promotion.pquantity.PromotionPquantityDAO;
import com.gmcc.pboss.business.promotion.promotingwayid.PromotingwayidVO;
import com.gmcc.pboss.business.promotion.spproposal.SpproposalVO;
import com.gmcc.pboss.business.sales.incqttdtl.IncqttdtlVO;
import com.gmcc.pboss.control.promotion.ppzlnrule.Ppzlnrule;
import com.gmcc.pboss.control.promotion.ppzlnrule.PpzlnruleBO;
import com.gmcc.pboss.control.promotion.pquantity.Pquantity;
import com.gmcc.pboss.control.promotion.pquantity.PquantityBO;
import com.gmcc.pboss.control.promotion.promotingwayid.Promotingwayid;
import com.gmcc.pboss.control.promotion.promotingwayid.PromotingwayidBO;
import com.gmcc.pboss.control.promotion.ruleitem.Ruleitem;
import com.gmcc.pboss.control.promotion.ruleitem.RuleitemBO;
import com.gmcc.pboss.control.promotion.spproposal.Spproposal;
import com.gmcc.pboss.control.promotion.spproposal.SpproposalBO;
import com.gmcc.pboss.control.sales.incqttdtl.Incqttdtl;
import com.gmcc.pboss.control.sales.incqttdtl.IncqttdtlBO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class PromotionsPQuantityBO extends AbstractControlBean 
	implements PromotionsPQuantity {

	public Map<String, BigDecimal> doStatActiveSMPLastMonth()
			throws Exception {
		PromotionPquantityDAO dao = (PromotionPquantityDAO)DAOFactory.build(PromotionPquantityDAO.class, user);
		return dao.statActiveSMPLastMonth();
	}

	public void doHandlePQuantity(Map<VO, Object> srcData, long pid,long ruleid) throws Exception {

		if(srcData != null && srcData.size() <= 0) return;
		
		Set<VO> srcKeys = srcData.keySet();
		Iterator<VO> keysIt = srcKeys.iterator();

		Pquantity pBo = (PquantityBO)BOFactory.build(PquantityBO.class,user);
		Incqttdtl iqdBo = (IncqttdtlBO)BOFactory.build(IncqttdtlBO.class, user);
		Promotingwayid pwBo = (PromotingwayidBO)BOFactory.build(PromotingwayidBO.class,user);

		PquantityDBParam pqParam = new PquantityDBParam();
		pqParam.set_ne_ruleid(String.valueOf(ruleid));
		pqParam.set_pagesize("0");
		pqParam.setDataOnly(true);
		List<PquantityVO> pVoList = new ArrayList<PquantityVO>(pBo.doQuery(
				pqParam).getDatas());

		// wayidSet记录即将要新增到已促销渠道表中的渠道ID
		Set<String> wayidSet = new HashSet<String>();
		
		// 获得上个月各个渠道的套卡激活量
		Map<String,BigDecimal> wayAndActiveSMP = this.doStatActiveSMPLastMonth();
		try {
			while (keysIt.hasNext()) {
				DefaultVO vo = (DefaultVO) keysIt.next();
				HashMap<String, ?> voMap = vo.getKeys();
				String wayid = (String) voMap.get("WAYID");
				if(!wayAndActiveSMP.containsKey(wayid)) {
					continue;
				}
				if(wayAndActiveSMP.get(wayid) == null) {
					continue;
				}
				// 只有一种提升基准：上个月激活量(参照概要设计V2.0修订)
				int inCat = ((BigDecimal)wayAndActiveSMP.get(wayid)).intValue();
				for (PquantityVO pVo : pVoList) {
					float inCratio = pVo.getIncratio().floatValue();
					String prodId = pVo.getProdid();
					int quantity = (int) (inCat * inCratio);
					String effectmonth = new SimpleDateFormat("yyyyMM")
							.format(new java.util.Date());
	
					// 添加“订货量提升明细”记录
					IncqttdtlVO iqdVo = new IncqttdtlVO();
					iqdVo.setCreatingtime(new java.util.Date());
					iqdVo.setPid((int)pid);
					iqdVo.setRuleid((int)ruleid);
					iqdVo.setWayid(wayid);
					iqdVo.setProdid(prodId);
					iqdVo.setEffectmonth(effectmonth);
					iqdVo.setQuantity(quantity);
	
					iqdBo.doCreate(iqdVo);
	
				}
				// 某个渠道的订货量提升明细已经生成后，从wayAndActiveSMP中删除该渠道，避免重复数据
				wayAndActiveSMP.remove(wayid);
				if(pVoList.size() > 0) {
					// 即将要新增到已促销渠道表中的渠道ID 放到wayid中存放
					wayidSet.add(wayid);
				}
			}
			// 批量保存已促销渠道
			for(Iterator<String> wayIt = wayidSet.iterator();wayIt.hasNext();) {
				String wayid = wayIt.next();
				PromotingwayidVO pwVo = new PromotingwayidVO();
				pwVo.setPid((long)pid);
				pwVo.setRuleid((long)ruleid);
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
					this.doHandlePQuantity(dataSet, pid, ruleid);
				}
			}
		}catch(Exception ex) {
			throw new JOPException(ex);
		}
	}

}
