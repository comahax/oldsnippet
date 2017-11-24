package com.gmcc.pboss.biz.info.missioner.realtimeaccounting.succ.dao.hibernate;

import com.gmcc.pboss.biz.info.missioner.realtimeaccounting.succ.dao.RealtimesuccDao;
import com.gmcc.pboss.common.dao.hibernate.BaseHqlQueryDao;
import com.gmcc.pboss.model.reward.chbbcrealtimesucc.Chbbcrealtimesucc;

public class RealtimesuccDaoHibernate extends BaseHqlQueryDao implements
		RealtimesuccDao {
	
	public RealtimesuccDaoHibernate(){
		super(Chbbcrealtimesucc.class);
	}

}
