/**
 * 
 */
package com.sunrise.boss.business.fee.billing.billlogdeta.control;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sunrise.boss.business.fee.billing.billlogdeta.persistent.BillLogDetaDAO;
import com.sunrise.boss.business.fee.billing.billlogdeta.persistent.BillLogDetaDBParam;
import com.sunrise.boss.business.fee.billing.billlogdeta.persistent.VBillLogDetaDAO;
import com.sunrise.boss.business.fee.common.SqlUtils;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

/**
 * <p>
 * Title: GDIBOSS
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2005
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author Hanny Yeung
 * @version 1.0
 */

public class BillLogDetaBO extends AbstractControlBean implements BillLogDeta {

	public DataPackage doQuery(BillLogDetaDBParam params, User user)
			throws Exception {
		
		BillLogDetaDAO dao = (BillLogDetaDAO)DAOFactory.build(BillLogDetaDAO.class,user.getDbFlag());
		
		return dao.query(params);
	}

	public Double getBillLogDetaAmt(String whereCaluse,Long validbilllcyc,User user) throws Exception
	{
		Double result = 0.00;
		// update by yangdaren start
		//String queryString = "select sum(acctamt),subphase from ib_wl_rhbilllogdeta where  subphase in ("+whereCaluse+") and validbillcyc="+validbilllcyc+" group by subphase";
		String queryString = "select sum(acctamt) from ib_wl_rhbilllogdeta where  subphase in ("+whereCaluse+") and validbillcyc="+validbilllcyc;
		// update by yangdaren end
		ResultSet rs = SqlUtils.getBSQLStatement(queryString, user.getDbFlag()).executeQuery();
		while( rs != null && rs.next() ){
			result = rs.getDouble(1);
		}
		return result;
	}
	 
	public Double getRHUNWFACCTRecvAmt(User user,Long validbillcyc) throws Exception {
		Double result = 0.00;
		String queryString = "select sum(RECAMT) from IB_CBTM_RHUNWFACCT where validbillcyc = ?";
		
		PreparedStatement ps = SqlUtils.getBSQLStatement(queryString, user.getDbFlag());
		ps.setLong(1,validbillcyc);
		ResultSet rs = ps.executeQuery();
		while( rs != null && rs.next() ){
			result = rs.getDouble(1);
		}
		rs.close();
		ps.close();
		return result;
	}
	
	public DataPackage doQueryBillLogDeta(BillLogDetaDBParam param,User user) throws Exception{
		VBillLogDetaDAO dao = (VBillLogDetaDAO)DAOFactory.build(VBillLogDetaDAO.class,user.getDbFlag());
		return dao.queryBillLogDeta(param);
	}

	/**
	 * 判断当前账期是否为往月账期。
	 */
	public boolean doValidBillValidbillcyc(Long region,Long validbillcyc,User user)
			throws Exception {
		BillLogDetaDAO dao = (BillLogDetaDAO)DAOFactory.build(BillLogDetaDAO.class,user.getDbFlag());
		BillLogDetaDBParam param = new BillLogDetaDBParam();
		param.setQueryAll(true);
		param.setDataOnly(true);
		param.getQueryConditions().put("_ne_region", region);
		param.getQueryConditions().put("_ne_validbillcyc", validbillcyc);
		param.setUseFixedParamOnly(true);
		param.setSelectFieldsString("validbillcyc");
		DataPackage dp = dao.queryByNamedSqlQuery("query.billValidbillcyc", param);
		if(dp !=null && dp.getDatas() !=null && !dp.getDatas().isEmpty()){
			return true;
		}
		return false;
	}
}
