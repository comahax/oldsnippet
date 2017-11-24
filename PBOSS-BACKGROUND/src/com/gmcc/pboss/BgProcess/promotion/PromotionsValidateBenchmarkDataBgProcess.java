package com.gmcc.pboss.BgProcess.promotion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import open.tool.rule.data.VO;

import com.gmcc.pboss.BgProcess.base.BgBase;
import com.gmcc.pboss.business.promotion.ruleitem.RuleitemDBParam;
import com.gmcc.pboss.business.promotion.ruleitem.RuleitemVO;
import com.gmcc.pboss.control.promotion.ruleitem.Ruleitem;
import com.gmcc.pboss.control.promotion.ruleitem.RuleitemBO;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.User;

/**
 * 基准数据校验模块
 * @author zhangsiwei
 * @version 1.0
 */
public class PromotionsValidateBenchmarkDataBgProcess extends BgBase{
	public static void main(String[] args) throws Exception{

	}

	/**
	 * 基准数据校验
	 * 
	 * @param srcData 	待校验的源数据
	 * @param ruleId	规则ID
	 * @param cityId
	 * @return			经基准数据校验后的源数据
	 * @throws Exception
	 */
	public Map<VO,Object> benchmarkDataValidating(Map<VO, Object> srcData, long ruleId,
			User user) throws Exception {
		
		Ruleitem riBo = (RuleitemBO)BOFactory.build(RuleitemBO.class, user);
		try {
			srcData = riBo.doBenchmarkDataValidating(srcData, ruleId);
		}catch(Exception ex) {
			LoggerUtils.error(ex, log);
		}
		return srcData;
	}

	/**
	 * 根据“规则标识[RULEID]”从“规则明细”表获取“数据类型[DATATYPE]”为“基准数据[1]”的规则集合，
	 * @param ruleId
	 * @param cityId
	 * @return
	 * @throws Exception
	 */
	public List<RuleitemVO> getRuleItemsByRuleId(long ruleId, User user)
			throws Exception {
		RuleitemDBParam ruleitemParam = new RuleitemDBParam();
		Ruleitem riBo = (Ruleitem)BOFactory.build(RuleitemBO.class,user);
		ruleitemParam.set_ne_ruleid(String.valueOf(ruleId));
		ruleitemParam.set_se_datatype("1");
		ruleitemParam.set_pagesize("0");
		List<RuleitemVO> resultList = new ArrayList<RuleitemVO>(riBo.doQuery(
				ruleitemParam).getDatas());
		return resultList;
	}

}
