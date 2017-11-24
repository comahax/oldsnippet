package com.gmcc.pboss.biz.info.reward.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import com.gmcc.pboss.biz.info.reward.dao.RewardTotalDao;
import com.gmcc.pboss.biz.info.reward.model.BbcRewardTotal;
import com.gmcc.pboss.common.dao.hibernate.BaseDaoHibernate;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.common.support.QueryParameterProcessor;
import com.gmcc.pboss.common.support.QueryResult;

public class BbcRewardTotalDaoHibernate extends BaseDaoHibernate implements RewardTotalDao {

	public BbcRewardTotalDaoHibernate() {
		super(BbcRewardTotal.class);
	}

	/**
	 * ��ȡ�²�����𱨱�
	 */
	@Override
	public QueryResult getAll(QueryParameterProcessor processor,
			QueryParameter parameter) {
		// TODO Auto-generated method stub
		QueryResult resl = super.getAll(processor, parameter);
		//��װ���
		//@@�ֹ�����
		//List<Object[]> reslList = resl.getData();
		//List<BbcRewardTotal> rtn=new ArrayList<BbcRewardTotal>();
		//for (Object[] obj:reslList ){
		//	if (obj.length>1){
		//		BbcRewardTotal set = new BbcRewardTotal();
		//		set.setPaymoney((Double)obj[0]);
		//		set.setRewardtype((Short) obj[1]);
		//		rtn.add(set);
		//	}
		//}
		//resl.setData(rtn);
		return resl;
	}
	
}
