/**
 * auto-generated code Sun Aug 27 13:31:54 CST 2006
 */
package com.sunrise.boss.business.cms.employee.persistent;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.sunrise.boss.business.common.dblog.OperationLog;
import com.sunrise.boss.common.base.db.BaseLogDAO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionUtil;
import com.sunrise.boss.ui.commons.User;

/**
 * <p>
 * Title: EmployeeDAO
 * </p>
 * <p>
 * Description: Data Access Object for EmployeeVO
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author yjr
 * @version 1.0
 */
public class EmployeeDAO extends BaseLogDAO {

	/**
	 * default constructor
	 */
	public EmployeeDAO() {
		super(EmployeeVO.class);
	}

	// ���������Ա��Ϣ��ѯ
	public DataPackage societyEmployeeQuery(EmployeeListVO params)
			throws Exception {
		return queryByNamedSqlQuery("societyEmployeeQuery", params);
	}

	/**
	 * ��ѯ����typeΪ10ʱ��ֻ���¼���������������� ��typeΪ0ʱ������������
	 * ����OR������ϲ�ѯ,�÷��͸��෽����ֻ࣬��������orStr���AND��ѯ����
	 */
	public DataPackage query(Object params, String orStr, int type, User user)
			throws Exception {
		StringBuffer countHQL = new StringBuffer("SELECT count(*) FROM ")
				.append(EmployeeVO.class.getName()).append(" this ");

		int _pagesize = 20, _pageno = 1;
		String _orderby = null, _desc = null;
		try {
			_pagesize = Integer.parseInt((String) BeanUtils.getProperty(params,
					"_pagesize"));
		} catch (Exception ex) {
			_pagesize = Integer.MAX_VALUE;
		}

		try {
			_pageno = Integer.parseInt((String) BeanUtils.getProperty(params,
					"_pageno"));
		} catch (Exception ex) {
			_pageno = 1;
		}

		try {
			_orderby = (String) BeanUtils.getProperty(params, "_orderby");
		} catch (Exception ex) {
			_orderby = "";
		}

		try {
			_desc = (String) BeanUtils.getProperty(params, "_desc");
		} catch (Exception ex) {
			_desc = "";
		}
		if (_desc == null) {
			_desc = "0"; // Ĭ�ϵ���
		}

		StringBuffer whereOr = new StringBuffer(" ( ");
		String[] strArray = orStr.split(",");

		if (strArray.length > 1) {
			for (int i = 0; i < strArray.length - 1; i++) {
				whereOr.append(" this.employeeid!='").append(strArray[i])
						.append("' AND ");
			}

			whereOr.append(" this.employeeid!='").append(
					strArray[strArray.length - 1]).append("'");
		} else {
			for (int i = 0; i < strArray.length; i++) {
				whereOr.append(" this.employeeid!='").append(strArray[i])
						.append("'");
			}
		}
		whereOr.append(" ) ");

		Map placeholders = new HashMap();
		List dateParamList = new ArrayList();
		StringBuffer whereClause = new StringBuffer(buildHQL(params, "this",
				placeholders, dateParamList));
		if (whereClause.length() > 4) {
			countHQL = countHQL.append(" WHERE ").append(whereClause).append(
					" AND ").append(whereOr.toString());
		} else if (whereOr.length() > 6) {
			countHQL = countHQL.append(" WHERE ").append(whereOr.toString());
		}

		// ��ѯ���
		DataPackage result = new DataPackage();
		result.setPageNo(_pageno);
		result.setPageSize(_pagesize);

		Session session = SessionUtil.currentSession(user.getCityid());
		try {
			// ȡ�ܼ�¼��
			if (type == QUERY_TYPE_ALL || type == QUERY_TYPE_COUNT) {

				Query query = session.createQuery(countHQL.toString());
				if (placeholders != null && placeholders.size() > 0) {
					Set keyset = placeholders.keySet();
					for (Iterator it = keyset.iterator(); it.hasNext();) {
						String key = (String) it.next();
						Object value = placeholders.get(key);
						// ��������������ж�
						if (dateParamList.indexOf(key) != -1) {
							if (value.toString().length() == 10) {// yyyy-MM-dd
								query.setDate(key, (new SimpleDateFormat(
										"yyyy-MM-dd")).parse(value.toString()));
							} else {// yyyy-MM-dd HH:mm:ss
								java.util.Date date = new SimpleDateFormat(
										"yyyy-MM-dd HH:mm:ss").parse(value
										.toString());
								Timestamp ts = new Timestamp(date.getTime());
								query.setTimestamp(key, ts);
							}
						} else {
							query.setParameter(key, value);
						}
					}
				}

				Iterator iter = query.iterate(); // hibernate3��д��
				if (iter != null && iter.hasNext()) {
					result.setRowCount(((Integer) iter.next()).intValue());
				} else {
					result.setRowCount(0);
				}
			}

			// ȡָ��ҳ������
			if (type == QUERY_TYPE_ALL || type == QUERY_TYPE_DATA) {
				StringBuffer selectHQL = new StringBuffer("FROM ").append(
						EmployeeVO.class.getName()).append(" this ");

				if (whereClause.toString().trim().length() > 0) {
					selectHQL = selectHQL.append(" WHERE ").append(whereClause)
							.append(" AND ").append(whereOr.toString());
				} else if (whereOr.toString().trim().length() > 4) {
					selectHQL = selectHQL.append(" WHERE ").append(
							whereOr.toString());
				}

				// if (whereClause.toString().trim().length() > 0) {
				// selectHQL = selectHQL.append(" WHERE ").append(whereClause);
				// }

				if (_orderby != null && _orderby.trim().length() > 0
						&& _desc != null) {
					if (_desc.equals("1")) {
						selectHQL = selectHQL.append(" order by this.").append(
								_orderby).append(" desc ");
					} else {
						selectHQL = selectHQL.append(" order by this.").append(
								_orderby).append(" asc ");
					}
				}

				Query query = session.createQuery(selectHQL.toString());
				if (placeholders != null && placeholders.size() > 0) {
					Set keyset = placeholders.keySet();
					for (Iterator it = keyset.iterator(); it.hasNext();) {
						String key = (String) it.next();
						Object value = placeholders.get(key);
						// ��������������ж�
						if (dateParamList.indexOf(key) != -1) {
							if (value.toString().length() == 10) {// yyyy-MM-dd
								query.setDate(key, (new SimpleDateFormat(
										"yyyy-MM-dd")).parse(value.toString()));
							} else {// yyyy-MM-dd HH:mm:ss
								java.util.Date date = new SimpleDateFormat(
										"yyyy-MM-dd HH:mm:ss").parse(value
										.toString());
								Timestamp ts = new Timestamp(date.getTime());
								query.setTimestamp(key, ts);
							}
						} else {
							query.setParameter(key, value);
						}
					}
				}

				if (_pagesize != 0) {
					query.setMaxResults(_pagesize);
					query.setFirstResult(_pagesize * (_pageno - 1));
				}
				result.setDatas(query.list());
			}
		} catch (HibernateException ex) {
			if (ex.getCause() != null) {
				throw new Exception(ex.getCause());
			} else {
				throw ex;
			}
		}
		return result;
	}

	// �ƶ�������������Ա��Ϣ��ѯ
	public DataPackage serverhallEmployeeQuery(EmployeeListVO params,
			User user, int i) throws Exception {
		if (i == 0) {
			String sql = " wayid in (select wayid from ch_pw_way start with wayid='"
					+ user.getWayid()
					+ "' connect by prior   wayid  = upperwayid) and (empstatus is null or empstatus <> -1) and "
					+" waytype = 'ET' and (posittype <> '1' or posittype is null)"; // ����Ȩ������
			params.set_sql_waycondition(sql);

		} else {//������ӪҵԱ,ֻ�ܿ������޸��Լ�
			String sql2 = " oprcode ='"+user.getOpercode()+"' and (empstatus is null or empstatus <> -1) and  waytype = 'ET' and (posittype <> '1' or posittype is null)";
			params.set_sql_waycondition(sql2);
		}
		return queryByNamedSqlQuery("societyEmployeeQuery", params);
	}

	// �ƶ���������������Ϣ��ѯ
	public DataPackage ditchmgrEmployeeQuery(EmployeeListVO params, User user,
			int i) throws Exception {
		if (i == 0) {//��������,ֻ�ܿ������޸��Լ�
			String sql = " wayid in (select wayid from ch_pw_way start with wayid='"
					+ user.getWayid()
					+ "' connect by prior   wayid   = upperwayid) and (empstatus is null or empstatus <> -1) and "
					+ " waytype = 'ET' and posittype ='1' "; // ����Ȩ������

			params.set_sql_waycondition(sql);

		} else {//������ӪҵԱ,ֻ�ܿ������޸��Լ�
			String sql2 = " oprcode ='"+user.getOpercode()+"' and (empstatus is null or empstatus <> -1) and  waytype = 'ET' and posittype ='1'";
			params.set_sql_waycondition(sql2);
		}
		return queryByNamedSqlQuery("societyEmployeeQuery", params);
	}
	/**
     * ����SEQUENCE����ȡ��seq nextval��ֵ
     * @param seq
     */
    public String getSequence() throws Exception {    	   
        StringBuffer sql = new StringBuffer("SELECT ").append("CH_PW_EMPLOYEE_SEQ").append(".NEXTVAL val FROM dual");        
        String seq = queryUniqueBySql(sql.toString(), null, Long.class).toString();
        return seq;        
    }
	public void registerLog(String methodName, Object vo ,User user) throws Exception {				
		Class voClass = vo.getClass();
		if(vo instanceof OperationLog) {
			OperationLog operationLog = (OperationLog)vo;
			Class logVOClass = operationLog.logVOClass();
			Object logvo = logVOClass.newInstance();
			registerOperationLog(methodName, vo, logvo,user);
		}		
	}
	
	// ���ݹ���������ѯ
	public DataPackage mobileEmployeeQuery(EmployeeListVO params)
			throws Exception {
		params.getQueryConditions().put("MOBILE", params.get_se_officetel());
		return queryByNamedSqlQuery("boss.cms.employee.querybymobile", params);
	}
}
