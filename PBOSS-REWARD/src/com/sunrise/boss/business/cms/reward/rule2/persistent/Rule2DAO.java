/**
 * auto-generated code
 * Mon Feb 04 12:03:22 CST 2008
 */
package com.sunrise.boss.business.cms.reward.rule2.persistent;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.BaseListVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.bean.BeanUtils;

/**
 * <p>
 * Title: Rule2DAO
 * </p>
 * <p>
 * Description: Data Access Object for Rule2VO
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
public class Rule2DAO extends BaseDAO {

	/**
	 * default constructor
	 */
	public Rule2DAO() {
		super(Rule2VO.class);
	}

	public DataPackage queryRuleIn2Tables(Rule2ListVO listvo) throws Exception {
		String cityid = listvo.get_se_region().trim();
		if(cityid.equals("999")){//如果是999全省的情况
			return queryByNamedSqlQuery("queryRuleIn2Tables_999", listvo);
		}else{
			if(StringUtils.isNotEmpty(cityid)){//如果是非全省的情况
				listvo.getQueryConditions().put("cityid", "%"+cityid+"%");
				return queryByNamedSqlQuery("queryRuleIn2Tables_not999", listvo);
			}else{//如果是选择空的情况
				listvo.getQueryConditions().put("cityid", "%%");
				return queryByNamedSqlQuery("queryRuleIn2Tables_all", listvo);
			}
		}
	}
	
	/**
	 * 获取RuleID组合
	 * @param listVO
	 * @return
	 * @throws Exception
	 */
	public DataPackage getDistinctRule(Rule2ListVO listVO) throws Exception {
		String opnid = "";
		String ruleid = "";
		if (null != listVO && null != listVO.get_se_opnid()
				&& listVO.get_se_opnid().trim().length() > 0) {
			opnid = listVO.get_se_opnid().trim();
		}
		if (null != listVO && null != listVO.get_se_ruleid()
				&& listVO.get_se_ruleid().trim().length() > 0) {
			ruleid = listVO.get_se_ruleid().trim();
		}

		BaseListVO baseListVO = new BaseListVO();
		BeanUtils.copyProperties(baseListVO, listVO);

		// opnid = :opnid and ruleid = :ruleid
		if (opnid.length() > 0 && ruleid.length() > 0) {
			baseListVO.getQueryConditions().put("opnid", opnid);
			baseListVO.getQueryConditions().put("ruleid", ruleid);
			return queryByNamedSqlQuery(
					"cms.reward.rule2.queryRule_OPNID_RULEID", baseListVO);
		}

		// opnid = :opnid
		if (opnid.length() > 0) {
			baseListVO.getQueryConditions().put("opnid", opnid);
			return queryByNamedSqlQuery("cms.reward.rule2.queryRule_OPNID",
					baseListVO);
		}

		return new DataPackage();
	}
	
	public DataPackage getDistinctBBCRule(Rule2ListVO listVO) throws Exception {
		return queryByNamedSqlQuery(
				"cms.bbcRuleQuery", listVO);
	}
	
	public DataPackage getDistinctZjtyRule(Rule2ListVO listVO) throws Exception {
		return queryByNamedSqlQuery(
				"cms.zjtyRuleQuery", listVO);
	}
}
