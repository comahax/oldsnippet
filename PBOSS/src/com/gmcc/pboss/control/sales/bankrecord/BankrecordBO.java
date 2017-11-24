/**
 * auto-generated code
 * Tue Jan 17 09:52:22 CST 2012
 */
package com.gmcc.pboss.control.sales.bankrecord;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.gmcc.pboss.business.sales.bankdeduct.BankdeductDBParam;
import com.gmcc.pboss.business.sales.bankdeduct.BankdeductVO;
import com.gmcc.pboss.business.sales.bankrecord.BankrecordDBParam;
import com.gmcc.pboss.business.sales.bankrecord.BankrecordDAO;
import com.gmcc.pboss.business.sales.bankrecord.BankrecordVO;
import com.gmcc.pboss.business.sales.bankrecord.VBankrecordDAO;
import com.gmcc.pboss.control.sales.bankdeduct.Bankdeduct;
import com.gmcc.pboss.control.sales.bankdeduct.BankdeductBO;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.exception.JOPException;

/**
 * <p>Title: BankrecordBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author dengxingxin
 * @version 1.0
 */
public class BankrecordBO extends AbstractControlBean implements
		Bankrecord {

	public BankrecordVO doCreate(BankrecordVO vo) throws Exception {
		try {
			BankrecordDAO dao = (BankrecordDAO) DAOFactory.build(BankrecordDAO.class, user);
			// TODO set the pk */
			return (BankrecordVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(BankrecordVO vo) throws Exception {
		try {
			BankrecordDAO dao = (BankrecordDAO) DAOFactory.build(BankrecordDAO.class,user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			BankrecordDAO dao = (BankrecordDAO) DAOFactory.build(BankrecordDAO.class,user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public BankrecordVO doUpdate(BankrecordVO vo) throws Exception {
		try {
			BankrecordDAO dao = (BankrecordDAO) DAOFactory.build(BankrecordDAO.class,user);
			return (BankrecordVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public BankrecordVO doFindByPk(Serializable pk) throws Exception {
		BankrecordDAO dao = (BankrecordDAO) DAOFactory.build(BankrecordDAO.class,user);
		return (BankrecordVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(BankrecordDBParam params)
			throws Exception {
		BankrecordDAO dao = (BankrecordDAO) DAOFactory.build(BankrecordDAO.class,user);
		return dao.query(params);
	}

	public DataPackage doQueryBankRecordDetail(String deductid)
			throws Exception {
		BankrecordDBParam params = new BankrecordDBParam();
		BankrecordDAO dao = (BankrecordDAO) DAOFactory.build(BankrecordDAO.class, user);
		params.setDataOnly(true);
		Map<String, String> queryConditions = new HashMap<String, String>();
		queryConditions.put("deductid", deductid);
		params.setQueryConditions(queryConditions);
		params.setSelectFieldsString("a_deductid,b_deductid,a_shopnum,b_shopnum" +
				",a_acctnum,b_account,a_acctname,b_accountname" +
				",a_deductamt,b_amount,a_statechgtime,b_completetime" +
				",a_respcode,b_retcode,a_errmsg,b_errmsg" +
				",recordstate,recordinfo,orderid");
		
		return dao.doQueryBankRecordDetail(params);
	}

	public void doDeduct(String deductid) throws Exception {
		//银行划扣记录表[FX_SW_BANKDEDUCT]
		Bankdeduct bankdeductBO = (BankdeductBO) BOFactory.build(BankdeductBO.class,user);
		BankdeductDBParam bankdeductDBParam = new BankdeductDBParam();
		bankdeductDBParam.set_ne_deductid(deductid);
		DataPackage bdDP = bankdeductBO.doQuery(bankdeductDBParam);
		if(bdDP.getRowCount() > 0){
			BankdeductVO ebdVO = (BankdeductVO)bdDP.getDatas().get(0);
			
			BankdeductVO nbdVO = new BankdeductVO();
			BeanUtils.copyProperties(nbdVO, ebdVO);
			
			//处理状态为待处理[WAITPROC]，
			//创建时间和状态变更时间为当前时间，响应吗，错误信息为空。
			nbdVO.setDeductid(null);
			nbdVO.setState("WAITPROC");
			nbdVO.setCreatdate(new Date());
			nbdVO.setStatechgtime(new Date());
			nbdVO.setRespcode("");
			nbdVO.setErrmsg("");
			nbdVO.setReqsn("");
			
			bankdeductBO.doCreate(nbdVO);
		}
		
		//修改银行划扣交易记录表(FX_SW_BANKRECORD)的状态为4重新划扣
		Bankrecord bankrecordBO = (BankrecordBO) BOFactory.build(BankrecordBO.class,user);
		BankrecordDBParam bankrecordDBParam = new BankrecordDBParam();
		bankrecordDBParam.set_ne_deductid(deductid);
		DataPackage brDP = bankrecordBO.doQuery(bankrecordDBParam);
		if(brDP.getRowCount() > 0){
			BankrecordVO ebrVO = (BankrecordVO)brDP.getDatas().get(0);
			ebrVO.setRecordstate(Short.parseShort("4"));
			
			bankrecordBO.doUpdate(ebrVO);
		}
	}

	public DataPackage doDetail(BankrecordDBParam params) throws Exception {
		VBankrecordDAO dao = (VBankrecordDAO) DAOFactory.build(VBankrecordDAO.class, user);
		return dao.doDetail(params);
	}
}
