package com.gmcc.pboss.biz.basic.node.dao.hibernate;

import com.gmcc.pboss.biz.basic.node.dao.ChPwRcvobjDao;
import com.gmcc.pboss.common.dao.hibernate.BaseHqlQueryDao;
import com.gmcc.pboss.model.communi.ChPwRcvobj;

/**
 * 从兴公司电子渠道业务部
 * @author tangzhu
 * @date 2009-10-28
 * 所属项目：PBOSS
 * 所属模块：门户网站
 * 描述：
 */
public class ChPwRcvobjDaoHibernate extends BaseHqlQueryDao implements
		ChPwRcvobjDao {

	public ChPwRcvobjDaoHibernate() {
		super(ChPwRcvobj.class);
		// TODO Auto-generated constructor stub
	}

}
