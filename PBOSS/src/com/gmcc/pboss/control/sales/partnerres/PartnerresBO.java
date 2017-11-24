/**
 * auto-generated code
 * Tue Oct 20 17:13:30 CST 2009
 */
package com.gmcc.pboss.control.sales.partnerres;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import com.gmcc.pboss.business.sales.partnerres.PartnerresDBParam;
import com.gmcc.pboss.business.sales.partnerres.PartnerresDAO;
import com.gmcc.pboss.business.sales.partnerres.PartnerresVO;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>Title: PartnerresBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class PartnerresBO extends AbstractControlBean implements
		Partnerres {

	public PartnerresVO doCreate(PartnerresVO vo) throws Exception {
		try {
			PartnerresDAO dao = (PartnerresDAO) DAOFactory.build(PartnerresDAO.class, user);
			// TODO set the pk */
			return (PartnerresVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(PartnerresVO vo) throws Exception {
		try {
			PartnerresDAO dao = (PartnerresDAO) DAOFactory.build(PartnerresDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			PartnerresDAO dao = (PartnerresDAO) DAOFactory.build(PartnerresDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public PartnerresVO doUpdate(PartnerresVO vo) throws Exception {
		try {
			PartnerresDAO dao = (PartnerresDAO) DAOFactory.build(PartnerresDAO.class,user);
			return (PartnerresVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public PartnerresVO doFindByPk(Serializable pk) throws Exception {
		PartnerresDAO dao = (PartnerresDAO) DAOFactory.build(PartnerresDAO.class,user);
		return (PartnerresVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(PartnerresDBParam params)
			throws Exception {
		PartnerresDAO dao = (PartnerresDAO) DAOFactory.build(PartnerresDAO.class,user);
		return dao.query(params);
	}
	public Integer doStatSMPActiveQty(String countyid, String comcategory,
			int targetDay) throws Exception {
		PartnerresDAO dao = (PartnerresDAO) DAOFactory.build(PartnerresDAO.class,user);
		PartnerresDBParam params = new PartnerresDBParam();
		params.getQueryConditions().put("countyid", countyid);
		params.getQueryConditions().put("comcategory",comcategory);
		params.getQueryConditions().put("targetDay", targetDay);
		Integer result = (Integer)dao.queryUniqueByNamedSqlQuery("com.gmcc.pboss.business.sales.partnerres.doStatSMPActiveQty", params);
		return result;
	}

	public Integer doStatSMPSoldQty(String countyid, String comcategory,
			int targetDay) throws Exception {
		PartnerresDAO dao = (PartnerresDAO) DAOFactory.build(PartnerresDAO.class,user);
		PartnerresDBParam params = new PartnerresDBParam();
		params.getQueryConditions().put("countyid", countyid);
		params.getQueryConditions().put("comcategory",comcategory);
		params.getQueryConditions().put("targetDay", targetDay);
		Integer result = (Integer)dao.queryUniqueByNamedSqlQuery("com.gmcc.pboss.business.sales.partnerres.doStatSMPSoldQty", params);
		return result;
	}
	
	public DataPackage doStatSMPActiveQtyInMonths(Date begintime,Date endtime,int intervalMonth) throws Exception {
		PartnerresDAO dao = (PartnerresDAO) DAOFactory.build(PartnerresDAO.class,user);
		PartnerresDBParam params = new PartnerresDBParam();
		params.setSelectFieldsString("wayid,brand,starlevel,activeQty");
		params.getQueryConditions().put("begintime",begintime);
		params.getQueryConditions().put("endtime",endtime);
		params.getQueryConditions().put("intervalMonth",intervalMonth);
		params.setDataOnly(true);
		params.set_pagesize("0");
		DataPackage dp = dao.queryByNamedSqlQuery("com.gmcc.pboss.business.sales.partnerres.doStatSMPActiveQtyInMonths", params);
		return dp;
	}
	
	public DataPackage doStatCountyQty(int isactive,String restype) throws Exception {
		PartnerresDAO dao = (PartnerresDAO) DAOFactory.build(PartnerresDAO.class,user);
		PartnerresDBParam params = new PartnerresDBParam();
		params.setSelectFieldsString("countyid,brand,Qty");
		params.getQueryConditions().put("isactive",isactive);
		params.getQueryConditions().put("restype",restype);
		params.setDataOnly(true);
		params.set_pagesize("0");
		DataPackage dp = dao.queryByNamedSqlQuery("com.gmcc.pboss.business.sales.partnerres.doStatCountyQty", params);
		return dp;
	}
	
	public DataPackage doStatCountyReceivedQty(int days, String restype) throws Exception {
		PartnerresDAO dao = (PartnerresDAO) DAOFactory.build(PartnerresDAO.class,user);
		PartnerresDBParam params = new PartnerresDBParam();
		params.setSelectFieldsString("countyid,brand,Qty");
		params.getQueryConditions().put("restype",restype);
		
		Calendar ca = Calendar.getInstance();
		ca.add(Calendar.DAY_OF_YEAR, -1);//前一天23:59:59
		ca.set(Calendar.HOUR_OF_DAY, 23);
		ca.set(Calendar.MINUTE, 59);
		ca.set(Calendar.SECOND, 59);
		Date end = ca.getTime();
		//ca = Calendar.getInstance();
		//ca.add(Calendar.DAY_OF_YEAR, -days);
		ca.add(Calendar.DAY_OF_YEAR, 1-days);//前N天00:00:00
		ca.set(Calendar.HOUR_OF_DAY, 0);
		ca.set(Calendar.MINUTE, 0);
		ca.set(Calendar.SECOND, 0);
		Date begin = ca.getTime();
		params.getQueryConditions().put("begintime", begin);
		params.getQueryConditions().put("endtime", end);
		
		params.setDataOnly(true);
		params.set_pagesize("0");
		DataPackage dp = dao.queryByNamedSqlQuery("com.gmcc.pboss.business.sales.partnerres.doStatCountyReceivedQty", params);
		return dp;
	}

	public DataPackage doStatWayActiveAmount(Date begintime, Date endtime)
			throws Exception {
		PartnerresDAO dao = (PartnerresDAO) DAOFactory.build(PartnerresDAO.class,user);
		PartnerresDBParam params = new PartnerresDBParam();
		params.setSelectFieldsString("wayid,brand,Qty");
		params.getQueryConditions().put("begintime",begintime);
		params.getQueryConditions().put("endtime",endtime);
		params.setDataOnly(true);
		params.set_pagesize("0");
		DataPackage dp = dao.queryByNamedSqlQuery("com.gmcc.pboss.business.sales.partnerres.doStatWayActiveAmount", params);
		return dp;
	}

	public DataPackage doStatActiveAmount_2(Date begintime, Date endtime)
			throws Exception {
		PartnerresDAO dao = (PartnerresDAO) DAOFactory.build(PartnerresDAO.class,user);
		PartnerresDBParam params = new PartnerresDBParam();
		params.setSelectFieldsString("wayid,brand,Qty");
		params.getQueryConditions().put("begintime",begintime);
		params.getQueryConditions().put("endtime",endtime);
		params.setDataOnly(true);
		params.set_pagesize("0");
		DataPackage dp = dao.queryByNamedSqlQuery("com.gmcc.pboss.business.sales.partnerres.doStatWayActiveAmount_2", params);
		return dp;
	}

	public DataPackage doStatWayLHAmount(Date begintime, Date endtime)
			throws Exception {
		PartnerresDAO dao = (PartnerresDAO) DAOFactory.build(PartnerresDAO.class,user);
		PartnerresDBParam params = new PartnerresDBParam();
		params.setSelectFieldsString("wayid,brand,Qty");
		params.getQueryConditions().put("begintime",begintime);
		params.getQueryConditions().put("endtime",endtime);
		params.setDataOnly(true);
		params.set_pagesize("0");
		DataPackage dp = dao.queryByNamedSqlQuery("com.gmcc.pboss.business.sales.partnerres.doStatWayLHAmount", params);
		return dp;
	}

	public DataPackage doStatWayStdAmount() throws Exception {
		PartnerresDAO dao = (PartnerresDAO) DAOFactory.build(PartnerresDAO.class,user);
		PartnerresDBParam params = new PartnerresDBParam();
		params.setSelectFieldsString("wayid,brand,Qty");
		params.setDataOnly(true);
		params.set_pagesize("0");
		DataPackage dp = dao.queryByNamedSqlQuery("com.gmcc.pboss.business.sales.partnerres.doStatWayStdAmount", params);
		return dp;
	}

	public DataPackage doStatWayOrderForSnapShot(String restype)
			throws Exception {
		PartnerresDAO dao = (PartnerresDAO) DAOFactory.build(PartnerresDAO.class,user);
		String queryStrName = "";
		String selectFields = "";
		if("STOCK".equalsIgnoreCase(restype)) {
			queryStrName = "com.gmcc.pboss.business.sales.partnerres.doStatWaySMPOrderForSnapShot";
			selectFields = "countyid,svccode,mareacode,orderid,wayid,wayname,starlevel,brand,comcategory,cnt1";
		}else if("RECORD".equals(restype)){
			queryStrName = "com.gmcc.pboss.business.sales.partnerres.doStatWayRecordOrderForSnapShot";
			selectFields = "countyid,svccode,mareacode,orderid,wayid,wayname,comresid,starlevel,brand,comcategory,emptyno";
		}else if("SIMSTOCK".equals(restype)){
			queryStrName = "com.gmcc.pboss.business.sales.partnerres.doStatWaySMPOrderForSnapShot_SIM";
			selectFields = "countyid,svccode,mareacode,orderid,wayid,wayname,starlevel,comcategory,cnt1";
		}else if("SIMRECORD".equals(restype)){
			queryStrName = "com.gmcc.pboss.business.sales.partnerres.doStatWayRecordOrderForSnapShot_SIM";
			selectFields = "countyid,svccode,mareacode,orderid,wayid,wayname,comresid,starlevel,brand,comcategory,emptyno";
		}
		PartnerresDBParam params = new PartnerresDBParam();
		params.setSelectFieldsString(selectFields);
//		params.getQueryConditions().put("restype",restype);
		params.setDataOnly(true);
		params.set_pagesize("0");
		
		DataPackage dp = dao.queryByNamedSqlQuery(queryStrName,params);
		return dp;
	}

	/**
	 * <!-- 获取库存量 -->
	 */
	public DataPackage doComcategoryQty(String wayid) throws Exception {
		PartnerresDAO dao = (PartnerresDAO) DAOFactory.build(
				PartnerresDAO.class, user);
		PartnerresDBParam params = new PartnerresDBParam();
		params.setSelectFieldsString("comcategory,count");
		params.getQueryConditions().put("wayid", wayid);

		DataPackage dp = dao.queryByNamedSqlQuery("com.gmcc.pboss.business.sales.partnerres.doComcategoryQty", params);
		return dp;
	}

	/**
	 * 获取空白SIM卡已使用量
	 */
	public DataPackage doEmptySimUseCount(String wayid) throws Exception {
		PartnerresDAO dao = (PartnerresDAO) DAOFactory.build(PartnerresDAO.class, user);
		PartnerresDBParam params = new PartnerresDBParam();
		params.setSelectFieldsString("comcategory,count");
		params.getQueryConditions().put("wayid", wayid);
		DataPackage dp = dao.queryByNamedSqlQuery("com.gmcc.pboss.business.sales.partnerres.doEmptySimUseCount", params);
		return dp;
	}
}
