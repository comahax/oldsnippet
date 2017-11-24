package com.gmcc.pboss.business.sales.bgbusiness.ActiveNumberImport;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.gmcc.pboss.business.sales.noactinfo.NoactinfoVO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.sales.actrepair.Actrepair;
import com.gmcc.pboss.control.sales.actrepair.ActrepairBO;
import com.sunrise.jop.common.utils.lang.SessionUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.AbstractDAO;
import com.sunrise.jop.infrastructure.db.DBAccessUser;

public class ActiveNumberImportDAO extends AbstractDAO {

	public ActiveNumberImportDAO() {
		super(NoactinfoVO.class);
	}

	/**
	 * <pre>
	 * 查询CRM系统的业务日志表（CS_REC_RECEPTION）获取激活数据,
	 * 并将数据插入到号码激活记录表（FX_SN_NOACTINFO）
	 * </pre>
	 * 
	 * @param cityno
	 * @param beginTime
	 * @param endTime
	 * @return
	 * @throws Exception
	 */
	public int batchImportDataFromCRM(String cityno, Date beginTime,
			Date endTime, DBAccessUser user) throws Exception {

		int insertRow = 0;
		StringBuffer selectSb = new StringBuffer();

		StringBuffer insertSb = new StringBuffer();
		insertSb
				.append("insert into FX_SN_NOACTINFO (RECID,MOBILENO,ACTIVEDATE,CREATTIME,MEMO) values(?,?,?,?,?)");
		selectSb
				.append(
						"select FX_SN_NOACTINFO_SEQ.Nextval,servnumber,TO_CHAR(recdate,'yyyy-MM-dd HH24:mi:ss') as recdate,TO_CHAR(sysdate,'yyyy-MM-dd HH24:mi:ss') as usysdate from CRM_CS_REC_RECEPTION ")
				.append(
						"where recdate >= :BEGINTIME and recdate < :ENDTIME and region = :REGION ")
				.append("and recdefid = 'ActiveSmpUser' ");

		Session session = SessionUtils.currentSession();
		try {
//			List list = session.createSQLQuery(selectSb.toString())
//					.setTimestamp("BEGINTIME", beginTime).setTimestamp(
//							"ENDTIME", endTime).setInteger("REGION",
//							Integer.parseInt(cityno)).list();
			List list = session.createSQLQuery(selectSb.toString()).setTime("BEGINTIME", beginTime).setTime(
					"ENDTIME", endTime).setInteger("REGION",
					Integer.parseInt(cityno)).list();
			

			SQLQuery sqlquery = session.createSQLQuery(insertSb.toString());

			
			SimpleDateFormat fmt=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			Sysparam sys = (Sysparam) BOFactory.build(
					SysparamBO.class, user);
			String day = sys.doFindByID("75", "pboss_fx");
			if (day == null || day.equals("")) {
				day = "3";
			}
			for (Iterator it = list.iterator(); it.hasNext();) {
				try {
					Object[] obj = (Object[]) it.next();
					String mobileno = obj[1] + "";
					Actrepair actrepair = (Actrepair) BOFactory.build(
							ActrepairBO.class, user);
					boolean bo = actrepair.doCheckDate(mobileno, fmt.parse(obj[2]+""),day);
					if (bo) {
						if (obj[0] != null) {
							sqlquery.setLong(0, Long.parseLong(obj[0] + ""));
						}
						if (obj[1] != null) {
							sqlquery.setString(1, obj[1] + "");
						}
						if (obj[2] != null) {
							sqlquery.setTimestamp(2, fmt.parse(obj[2]+""));
						}
						if (obj[3] != null) {
							sqlquery.setTimestamp(3, fmt.parse(obj[3]+""));
						}
						sqlquery.setString(4,"CRM数据导入");
						sqlquery.executeUpdate();
						++insertRow;
					}else{
						
						
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (HibernateException ex) {
			throw ex;
		}
		return insertRow;
	}

	/**
	 * <pre>
	 * 查询BOSS系统的业务日志表（CS_REC_RECEPTION）获取激活数据,
	 * 并将数据插入到号码激活记录表（FX_SN_NOACTINFO）
	 * </pre>
	 * 
	 * @param cityno
	 * @param beginTime
	 * @param endTime
	 * @return
	 * @throws Exception
	 */
	public int batchImportDataFromBOSS(String cityno, Date beginTime,
			Date endTime,DBAccessUser user) throws Exception {

		int insertRow = 0;
		StringBuffer selectSb = new StringBuffer();

		StringBuffer insertSb = new StringBuffer();
		insertSb
				.append("insert into FX_SN_NOACTINFO (RECID,MOBILENO,ACTIVEDATE,CREATTIME,MEMO) values(?,?,?,?,?) ");

		selectSb
				.append(
						"select FX_SN_NOACTINFO_SEQ.Nextval,servnumber,TO_CHAR(recdate,'yyyy-MM-dd HH24:mi:ss') as recdate,TO_CHAR(sysdate,'yyyy-MM-dd HH24:mi:ss') as usysdate from CS_REC_RECEPTION ")
				.append(
						"where statusdate >= :BEGINTIME and statusdate < :ENDTIME and region = :REGION ")
				.append(
						"and recdefid in ('ActiveSmpUser','FirstActive_OCS','smpUserActive') and status = 'stcmNml'");

		Session session = SessionUtils.currentSession();
		try {
			List list = session.createSQLQuery(selectSb.toString())
					.setTime("BEGINTIME", beginTime).setTime(
							"ENDTIME", endTime).setInteger("REGION",
							Integer.parseInt(cityno)).list();

			SQLQuery sqlquery = session.createSQLQuery(insertSb.toString());

			SimpleDateFormat fmt=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			Sysparam sys = (Sysparam) BOFactory.build(
					SysparamBO.class, user);
			String day = sys.doFindByID("75", "pboss_fx");
			if (day == null || day.equals("")) {
				day = "3";
			}
			
			for (Iterator it = list.iterator(); it.hasNext();) {
				try {

					Object[] obj = (Object[]) it.next();
					String mobileno = obj[1] + "";
					Actrepair actrepair = (Actrepair) BOFactory.build(
							ActrepairBO.class, user);
					boolean bo = actrepair.doCheckDate(mobileno, fmt.parse(obj[2]+""),day);
					if (bo) {
						if (obj[0] != null) {
							sqlquery.setLong(0, Long.parseLong(obj[0] + ""));
						}
						if (obj[1] != null) {
							sqlquery.setString(1, obj[1] + "");
						}
						if (obj[2] != null) {
							sqlquery.setTimestamp(2,fmt.parse(obj[2]+""));
						}
						if (obj[3] != null) {
							sqlquery.setTimestamp(3, fmt.parse(obj[3]+""));
						}
						sqlquery.setString(4,"BOSS数据导入");
						sqlquery.executeUpdate();
						++insertRow;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		} catch (HibernateException ex) {
			throw ex;
		}
		return insertRow;
	}
}
