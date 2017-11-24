/**
 * auto-generated code Wed Oct 18 16:14:47 CST 2006
 */
package com.sunrise.boss.business.cms.employeelog.persistent;

import com.sunrise.boss.common.base.db.BaseDAO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>
 * Title: EmployeelogDAO
 * </p>
 * <p>
 * Description: Data Access Object for EmployeelogVO
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author He Kun
 * @version 1.0
 */
public class EmployeelogDAO extends BaseDAO {

	/**
	 * default constructor
	 */
	public EmployeelogDAO() {
		super(EmployeelogVO.class);
	}

	// ���������Ա��Ϣ��־��ѯ
	public DataPackage societyEmployeeLogQuery(EmployeelogListVO params)
			throws Exception {
		return queryByNamedSqlQuery("societyEmployeeLogQuery", params);
	}

	// �ƶ�������������Ա��Ϣ��ѯ
	public DataPackage serverhallEmployeeLogQuery(EmployeelogListVO params,
			User user, int i) throws Exception {
		if (i == 0) {
			String sql = " wayid in (select wayid from ch_pw_way start with wayid='"
					+ user.getWayid()
					+ "' connect by prior   wayid  = upperwayid) and (empstatus is null or empstatus <> -1) and "
					+" waytype = 'ET' and (station not in(60,64,65) or station is null)"; // ����Ȩ������
			params.set_sql_waycondition(sql);

		} else {// ������ӪҵԱ,ֻ�ܿ������޸��Լ�
			String sql2 = " oprcode2='"+user.getOpercode()+"' and  waytype = 'ET' and (station not in(60,64,65) or station is null)";
			params.set_sql_waycondition(sql2);
		}
		return queryByNamedSqlQuery("societyEmployeeLogQuery", params);
	}

	// �ƶ���������������Ϣ��ѯ
	public DataPackage ditchmgrEmployeeLogQuery(EmployeelogListVO params,
			User user, int i) throws Exception {	
		if (i == 0) {// ��������,ֻ�ܿ������޸��Լ�
			String sql = " wayid in (select wayid from ch_pw_way start with wayid='"
					+ user.getWayid()
					+ "' connect by prior   wayid   = upperwayid) and waytype = 'ET' and station in(60,64,65)";// ����Ȩ������
					
			params.set_sql_waycondition(sql);

		} else {// ������ӪҵԱ,ֻ�ܿ������޸��Լ�
			String sql2 = " oprcode2 ='"+user.getOpercode()+"' and  waytype = 'ET' and station in(60,64,65)";
			params.set_sql_waycondition(sql2);
		}
		return queryByNamedSqlQuery("societyEmployeeLogQuery", params);
	}
}
