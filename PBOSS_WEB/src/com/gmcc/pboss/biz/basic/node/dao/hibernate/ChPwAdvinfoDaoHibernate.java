package com.gmcc.pboss.biz.basic.node.dao.hibernate;

import com.gmcc.pboss.biz.basic.node.dao.ChPwAdvinfoDao;
import com.gmcc.pboss.common.dao.hibernate.BaseDaoHibernate;
import com.gmcc.pboss.model.communi.ChPwAdvinfo;

/**
 * 从兴公司电子渠道业务部
 * @author tangzhu
 * @date 2009-10-28
 * 所属项目：PBOSS
 * 所属模块：门户网站
 * 描述：
 */
public class ChPwAdvinfoDaoHibernate extends BaseDaoHibernate implements
	ChPwAdvinfoDao {

	public ChPwAdvinfoDaoHibernate() {
		super(ChPwAdvinfo.class);
		// TODO Auto-generated constructor stub
	}
	
}
