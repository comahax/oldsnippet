package com.gmcc.pboss.biz.info.reward.dao.hibernate;

import java.text.ParseException;
import java.util.List;

import org.hibernate.Query;

import com.gmcc.pboss.biz.communi.service.CommunicatePlateauRetCode;
import com.gmcc.pboss.biz.info.reward.dao.RewardRecordDao;
import com.gmcc.pboss.biz.info.reward.model.RewardRecord;
import com.gmcc.pboss.biz.info.reward.support.RewardQueryParameter;
import com.gmcc.pboss.common.config.ConfigUtil;
import com.gmcc.pboss.common.dao.hibernate.BaseDaoHibernate;
import com.gmcc.pboss.common.dictionary.CommonConfig;
import com.gmcc.pboss.common.dictionary.FileDictionary;
import com.gmcc.pboss.common.exception.AssertConditionException;
import com.gmcc.pboss.common.util.DateUtil;

public class RewardRecordDaoHibernate extends BaseDaoHibernate implements RewardRecordDao {

	public RewardRecordDaoHibernate() {
		super(RewardRecord.class);
	}

	/**
	 * 统计社会渠道网点酬金池余额 
	 * @param parameter
	 * @return
	 */
	public Long statRewardBalance(RewardQueryParameter parameter) {
		Query query = getSession().
						getNamedQuery("com.gmcc.pboss.biz.info.reward.model.statRewardBalance");
		
		String accountMonth = parameter.getMonth();
		java.util.Date monthDate = null;
		try {
			monthDate = DateUtil.convertStringToDate("yyyyMM", accountMonth);
		}catch (ParseException e) {
			throw new AssertConditionException(CommunicatePlateauRetCode.COMMUNICATE_DATE_FORMAT,"月份格式不正确！");
		}
		String term = parameter.getTerm();
		String rewardType = ConfigUtil.getCommonConfig(
								FileDictionary.COMMON_NAME, CommonConfig.REWARD_TYPE);
		String monthA = "";
		String monthB = "";
		String monthC = "";
		if("2".equals(term)) {
			// 二期
			monthA = DateUtil.getDateTime("yyyyMM", DateUtil.DateDiff("M", monthDate, -6));
			monthB = DateUtil.getDateTime("yyyyMM", DateUtil.DateDiff("M", monthDate, -5));
			monthC = DateUtil.getDateTime("yyyyMM", DateUtil.DateDiff("M", monthDate, -4));
		}else if("3".equals(term)) {
			// 三期
			monthA = DateUtil.getDateTime("yyyyMM", DateUtil.DateDiff("M", monthDate, -3));
			monthB = DateUtil.getDateTime("yyyyMM", DateUtil.DateDiff("M", monthDate, -2));
			monthC = DateUtil.getDateTime("yyyyMM", DateUtil.DateDiff("M", monthDate, -1));
		}
		query.setString("curMonth", accountMonth);
		query.setString ("monthA",monthA);
		query.setString("monthB", monthB);
		query.setString("monthC",monthC);
		query.setString("wayid", parameter.getWayid());
		query.setString("rewardtype", rewardType);
		Long balance = (Long)query.uniqueResult();
		return balance;
	}
}
