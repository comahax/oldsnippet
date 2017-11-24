package com.gmcc.pboss.biz.communi.dao;

import java.util.List;

import com.gmcc.pboss.common.dao.BaseDao;
import com.gmcc.pboss.model.communi.ChPwAdvaffix;

public interface AdvaffixDao extends BaseDao {
	public List<ChPwAdvaffix> doQueryAffixByAdvinfoid(Long advinfoid);
}
