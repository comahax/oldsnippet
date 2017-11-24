/**
 * auto-generated code
 * Wed Oct 07 16:55:22 CST 2009
 */
package com.gmcc.pboss.business.channel.employeelog;

import com.sunrise.jop.infrastructure.db.AbstractDAO;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

/**
 * <p>
 * Title: EmployeelogDAO
 * </p>
 * <p>
 * Description: Data Access Object for CompanyVO
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author wefrogll
 * @version 1.0
 */
public class EmployeelogDAO extends AbstractDAO {

	/**
	 * default constructor
	 */
	public EmployeelogDAO() {
		super(EmployeelogVO.class);
	}

	// 社会渠道人员信息日志查询
	public DataPackage societyEmployeeLogQuery(EmployeelogDBParam params,
			User user) throws Exception {
		String sql = " wayid in (select wayid from ch_pw_way start with wayid='"
			+ user.getWayid()
			+ "' connect by prior   wayid   = upperwayid) "; // 数据权限限制
		params.set_sql_waycondition(sql);
		return queryByNamedSqlQuery("societyEmployeeLogQuery", params);
	}

	// 移动渠道渠道经理信息查询
	public DataPackage ditchmgrEmployeeLogQuery(EmployeelogDBParam params,
			User user, int i) throws Exception {
		if (i == 0) {// 渠道经理,只能看到并修改自己
			String sql = " wayid in (select wayid from ch_pw_way start with wayid='"
					+ user.getWayid()
					+ "' connect by prior   wayid   = upperwayid) and waytype = 'ET' and station in(60,64,65)";// 数据权限限制

			params.set_sql_waycondition(sql);

		} else {// 服务厅营业员,只能看到并修改自己
			String sql2 = " oprcode2 ='" + user.getOprcode()
					+ "' and  waytype = 'ET' and station in(60,64,65)";
			params.set_sql_waycondition(sql2);
		}
		return queryByNamedSqlQuery("societyEmployeeLogQuery", params);
	}
}
