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

	// ���������Ա��Ϣ��־��ѯ
	public DataPackage societyEmployeeLogQuery(EmployeelogDBParam params,
			User user) throws Exception {
		String sql = " wayid in (select wayid from ch_pw_way start with wayid='"
			+ user.getWayid()
			+ "' connect by prior   wayid   = upperwayid) "; // ����Ȩ������
		params.set_sql_waycondition(sql);
		return queryByNamedSqlQuery("societyEmployeeLogQuery", params);
	}

	// �ƶ���������������Ϣ��ѯ
	public DataPackage ditchmgrEmployeeLogQuery(EmployeelogDBParam params,
			User user, int i) throws Exception {
		if (i == 0) {// ��������,ֻ�ܿ������޸��Լ�
			String sql = " wayid in (select wayid from ch_pw_way start with wayid='"
					+ user.getWayid()
					+ "' connect by prior   wayid   = upperwayid) and waytype = 'ET' and station in(60,64,65)";// ����Ȩ������

			params.set_sql_waycondition(sql);

		} else {// ������ӪҵԱ,ֻ�ܿ������޸��Լ�
			String sql2 = " oprcode2 ='" + user.getOprcode()
					+ "' and  waytype = 'ET' and station in(60,64,65)";
			params.set_sql_waycondition(sql2);
		}
		return queryByNamedSqlQuery("societyEmployeeLogQuery", params);
	}
}
