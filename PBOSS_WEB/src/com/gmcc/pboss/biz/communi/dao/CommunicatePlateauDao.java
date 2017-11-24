package com.gmcc.pboss.biz.communi.dao;

import java.util.List;

import com.gmcc.pboss.biz.communi.support.CommunicatePlateauParameter;
import com.gmcc.pboss.common.dao.BaseDao;
import com.gmcc.pboss.model.communi.ChPwAdvinfo;
import com.gmcc.pboss.model.communi.ChPwRcvobj;

public interface CommunicatePlateauDao extends BaseDao {
	public ChPwRcvobj getRcvobjByIds(CommunicatePlateauParameter parameter);
	public List<ChPwAdvinfo> queryCityPublicInfo(int maxRows);
}
