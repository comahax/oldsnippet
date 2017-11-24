package com.gmcc.pboss.control.reward.payment;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.gmcc.pboss.business.reward.chcwemployee.ChCwEmployeeDAO;
import com.gmcc.pboss.business.reward.chcwemployee.ChCwEmployeeVO;
import com.gmcc.pboss.business.reward.chcwpaymentsend.ChCwPaymentsendDAO;
import com.gmcc.pboss.business.reward.chcwpaymentsend.ChCwPaymentsendVO;
import com.gmcc.pboss.business.reward.payment.PaymentDAO;
import com.gmcc.pboss.business.reward.payment.PaymentDBParam;
import com.gmcc.pboss.business.reward.payment.PaymentVO;
import com.gmcc.pboss.business.reward.payment.VPaymentDAO;
import com.gmcc.pboss.business.reward.payment.VPaymentVO;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

/**
 * <p>
 * Title: PaymentBO
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2010
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author a-biao
 * @version 1.0
 */
public class PaymentBO extends AbstractControlBean implements Payment {

	private static final long serialVersionUID = 5555005851453079238L;

	// 如果pagesize为0，表示不分页，只有1页
	//private final String NG_PAGESIZE = "0";
	// 已审核状态
	private final String ISCHECKED = "CHECKED";
	private final String NOTCHECKED = "UNCHECKED";

	private String selFields = "seq,optype,ltype,stype,payee,bkactname,bank,depositbank,account,billnumber,countyid,paymonth,paysum,batch,pubpri,note,upoprcode,checkedflag,calcmonth,sendstate";

	// 已发送状态
	private final String ISSENT = "SENT";

	public PaymentVO doCreate(PaymentVO vo) throws Exception {
		try {
			PaymentDAO dao = (PaymentDAO) DAOFactory.build(PaymentDAO.class,
					user);
			return (PaymentVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(PaymentVO vo) throws Exception {
		try {
			PaymentDAO dao = (PaymentDAO) DAOFactory.build(PaymentDAO.class,
					user);
			vo = doFindByPk(vo);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			PaymentDAO dao = (PaymentDAO) DAOFactory.build(PaymentDAO.class,
					user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public PaymentVO doUpdate(PaymentVO vo) throws Exception {
		try {
			PaymentDAO dao = (PaymentDAO) DAOFactory.build(PaymentDAO.class,
					user);
			return (PaymentVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public PaymentVO doFindByPk(Serializable pk) throws Exception {
		try {
			PaymentDAO dao = (PaymentDAO) DAOFactory.build(PaymentDAO.class,
					user);
			return (PaymentVO) dao.findByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public DataPackage doQuery(PaymentDBParam params) throws Exception {
		try {
			PaymentDAO dao = (PaymentDAO) DAOFactory.build(PaymentDAO.class,
					user);
			return dao.query(params);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	/**
	 * 查询和导出时根据审核开关赋不同的查询语句
	 * 
	 * @param switchflag
	 * @return
	 */
	private String setQrySql(boolean switchflag) {
		String qrySql;
		if (switchflag) {
			qrySql = "com.gmcc.pboss.business.reward.payment.doShowQueryByOprcodeSql";
		} else {
			qrySql = "com.gmcc.pboss.business.reward.payment.doShowQueryBySql";
		}

		return qrySql;
	}

	/**
	 * 导出excel时根据审核开关赋不同的查询语句
	 * 
	 * @param switchflag
	 * @return
	 */
	private String setExportSql(boolean switchflag) {
		String qrySql;
		if (switchflag) {
			qrySql = "com.gmcc.pboss.business.reward.payment.doExportQueryByOprcodeSql";
		} else {
			qrySql = "com.gmcc.pboss.business.reward.payment.doExportQueryBySql";
		}

		return qrySql;
	}

	/**
	 * 统计总金额时根据审核开关赋不同的查询语句
	 * 
	 * @param switchflag
	 * @return
	 */
	private String setQrySumSql(boolean switchflag) {
		String qrySql;
		if (switchflag) {
			qrySql = "com.gmcc.pboss.business.reward.payment.doShowQuerySumByOprcodeSql";
		} else {
			qrySql = "com.gmcc.pboss.business.reward.payment.doShowQuerySumBySql";
		}

		return qrySql;
	}

	/**
	 * 发送和删除时根据审核开关赋不同的查询语句 <br />
	 * 已发送，不可删除/发送
	 * 
	 * @param switchflag
	 * @return
	 */
	private String setSendSql(boolean switchflag) {
		String qrySql;
		if (switchflag) {
			qrySql = "com.gmcc.pboss.business.reward.payment.doSendQueryByOprcodeSql";
		} else {
			qrySql = "com.gmcc.pboss.business.reward.payment.doSendQuerySql";
		}

		return qrySql;
	}

	private String setDelSql(boolean switchflag) {
		String qrySql;
		if (switchflag) {
			qrySql = "com.gmcc.pboss.business.reward.payment.doDeleteQueryByOprcodeSql";
		} else {
			qrySql = "com.gmcc.pboss.business.reward.payment.doDeleteQuerySql";
		}

		return qrySql;
	}
	
	private String setDelSqlFromStyle(boolean switchflag) {
		String qrySql;
		if (switchflag) {
			qrySql = "com.gmcc.pboss.business.reward.payment.doDeleteQueryByOprcodeSqlFromStyle";
		} else {
			qrySql = "com.gmcc.pboss.business.reward.payment.doDeleteQuerySqlFromStyle";
		}

		return qrySql;
	}
	

	private String setDelSqlFromLtyle(boolean switchflag) {
		String qrySql;
		if (switchflag) {
			qrySql = "com.gmcc.pboss.business.reward.payment.doDeleteQueryByOprcodeSqlFromLtyle";
		} else {
			qrySql = "com.gmcc.pboss.business.reward.payment.doDeleteQuerySqlFromLtyle";
		}

		return qrySql;
	}
	
	public DataPackage doQueryBySql(PaymentDBParam params, boolean switchflag)
			throws Exception {
		try {
			String qrySql = setQrySql(switchflag);

			VPaymentDAO dao = (VPaymentDAO) DAOFactory.build(VPaymentDAO.class,
					user);
			DataPackage dp = dao.queryByNamedSqlQuery(qrySql, params);
			return dp;
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public DataPackage doExportBySql(PaymentDBParam params, boolean switchflag)
			throws Exception {
		try {
			String qrySql = setExportSql(switchflag);

			VPaymentDAO dao = (VPaymentDAO) DAOFactory.build(VPaymentDAO.class,
					user);
			DataPackage dp = dao.queryByNamedSqlQuery(qrySql, params);
			return dp;
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public DataPackage doPaymentsendQryBySql(String sql) throws Exception {
		try {
			ChCwPaymentsendDAO dao = (ChCwPaymentsendDAO) DAOFactory.build(
					ChCwPaymentsendDAO.class, user);
			DataPackage dp = dao.queryByNamedSqlQuery(sql);
			return dp;
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doSend(String[] selectArray, boolean switchflag,
			String employeeNum, String sbatch) throws Exception {
		try {
			VPaymentDAO dao = (VPaymentDAO) DAOFactory.build(VPaymentDAO.class,
					user);
			ChCwPaymentsendDAO sendao = (ChCwPaymentsendDAO) DAOFactory.build(
					ChCwPaymentsendDAO.class, user);
			ChCwEmployeeDAO emdao = (ChCwEmployeeDAO) DAOFactory.build(
					ChCwEmployeeDAO.class, user);

			for (int i = 0; i < selectArray.length; i++) {
				String param = selectArray[i];
				if (StringUtils.isEmpty(param)) {
					continue;
				}

				PaymentDBParam params = new PaymentDBParam();
				params.getQueryConditions().put("cityid", user.getCityid());
				params.getQueryConditions().put("oprcode", user.getOprcode());

				String seq = "";
				String checkedflag = "";
				if (param.contains("_")) {
					String[] array = StringUtils.splitPreserveAllTokens(param,
							"_");
					if (array.length == 2) {
						seq = array[0];
						checkedflag = array[1];
					} else {
						seq = array[0];
						checkedflag = NOTCHECKED;
					}

					// 审核开关已开，必须为已审核过的才可以发送
					if (switchflag) {
						if (checkedflag.equals(ISCHECKED)) {
							params.set_ne_seq(seq);
						} else {
							// 非已审核的数据跳过
							continue;
						}
					} else {
						// 审核开关未开，可以直接发送
						params.set_ne_seq(seq);
					}
				} else {
					// 在页面需要事先设定查询条件必须包含审核标识等于‘已审核’
					params.set_ne_seq(param);
				}

				String qrySql = setSendSql(switchflag);
				params.setDataOnly(true);
				params.setSelectFieldsString(selFields);
				DataPackage dp = dao.queryByNamedSqlQuery(qrySql, params);
				if (dp != null && dp.getDatas() != null) {
					// 主键查询，只应该有第一条数据
					Map<String, Object> map = (Map<String, Object>) dp
							.getDatas().get(0);
					VPaymentVO vobj = new VPaymentVO();
					vobj.setSeq((Long) map.get("seq"));
					vobj.setOptype((String) map.get("optype"));
					vobj.setLtype((String) map.get("ltype"));
					vobj.setStype((String) map.get("stype"));
					vobj.setPayee((String) map.get("payee"));
					vobj.setBkactname((String) map.get("bkactname"));
					vobj.setBank((String) map.get("bank"));
					vobj.setDepositbank((String) map.get("depositbank"));
					vobj.setAccount((String) map.get("account"));
					vobj.setBillnumber((String) map.get("billnumber"));
					vobj.setCountyid((String) map.get("countyid"));
					vobj.setPaymonth((String) map.get("paymonth"));
					vobj.setPaysum((Double) map.get("paysum"));
					vobj.setBatch((String) map.get("batch"));
					vobj.setPubpri((String) map.get("pubpri"));
					vobj.setNote((String) map.get("note"));
					vobj.setUpoprcode((String) map.get("upoprcode"));
					vobj.setCheckedflag((String) map.get("checkedflag"));
					vobj.setCalcmonth((String) map.get("calcmonth"));
					vobj.setSendstate((String) map.get("sendstate"));

					String sendstate = vobj.getSendstate();
					if (StringUtils.isNotEmpty(sendstate)
							&& sendstate.equalsIgnoreCase(ISSENT)) {
						// 该记录已发送，不可重复发送
						continue;
					}

					ChCwPaymentsendVO sendvo = new ChCwPaymentsendVO();
					BeanUtils.copyProperties(sendvo, vobj);
					sendvo.setSbatch(sbatch);
					sendvo.setState(new Byte("0"));
					ChCwEmployeeVO emvo = (ChCwEmployeeVO) emdao
							.findByPk(employeeNum);
					if (emvo != null) {
						sendvo.setDeptId(emvo.getDeptId());
						sendvo.setEmployeeName(emvo.getEmployeeName());
					}
					sendvo.setEmployeeNum(employeeNum);
					sendvo.setCityid(user.getCityid());
					sendao.create(sendvo);

					// 更新发送状态 SENDSTATE置为SENT
					PaymentVO vo = doFindByPk(vobj.getSeq());
					vo.setSendstate(ISSENT);
					doUpdate(vo);
				}
			}
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doBatchsend(PaymentDBParam params, boolean switchflag,
			String employeeNum, String sbatch) throws Exception {
		try {
			VPaymentDAO dao = (VPaymentDAO) DAOFactory.build(VPaymentDAO.class,
					user);
			ChCwPaymentsendDAO sendao = (ChCwPaymentsendDAO) DAOFactory.build(
					ChCwPaymentsendDAO.class, user);
			ChCwEmployeeDAO emdao = (ChCwEmployeeDAO) DAOFactory.build(
					ChCwEmployeeDAO.class, user);

			String qrySql = setSendSql(switchflag);
			DataPackage dp = dao.queryByNamedSqlQuery(qrySql, params);

			if (dp != null && dp.getDatas() != null
					&& dp.getDatas().size() > 200) {
				throw new Exception("单个报账单不能超过200条数据");
			}

			if (dp != null && dp.getDatas() != null) {
				List<Map<String, Object>> list = (List<Map<String, Object>>) dp
						.getDatas();
				for (int k = 0; k < list.size(); k++) {
					Map<String, Object> map = list.get(k);
					VPaymentVO vobj = new VPaymentVO();
					vobj.setSeq((Long) map.get("seq"));
					vobj.setOptype((String) map.get("optype"));
					vobj.setLtype((String) map.get("ltype"));
					vobj.setStype((String) map.get("stype"));
					vobj.setPayee((String) map.get("payee"));
					vobj.setBkactname((String) map.get("bkactname"));
					vobj.setBank((String) map.get("bank"));
					vobj.setDepositbank((String) map.get("depositbank"));
					vobj.setAccount((String) map.get("account"));
					vobj.setBillnumber((String) map.get("billnumber"));
					vobj.setCountyid((String) map.get("countyid"));
					vobj.setPaymonth((String) map.get("paymonth"));
					vobj.setPaysum((Double) map.get("paysum"));
					vobj.setBatch((String) map.get("batch"));
					vobj.setPubpri((String) map.get("pubpri"));
					vobj.setNote((String) map.get("note"));
					vobj.setUpoprcode((String) map.get("upoprcode"));
					vobj.setCheckedflag((String) map.get("checkedflag"));
					vobj.setCalcmonth((String) map.get("calcmonth"));
					vobj.setSendstate((String) map.get("sendstate"));

					String sendstate = vobj.getSendstate();
					if (StringUtils.isNotEmpty(sendstate)
							&& sendstate.equalsIgnoreCase(ISSENT)) {
						// 该记录已发送，不可重复发送
						continue;
					}

					ChCwPaymentsendVO sendvo = new ChCwPaymentsendVO();
					BeanUtils.copyProperties(sendvo, vobj);
					sendvo.setSbatch(sbatch);
					sendvo.setState(new Byte("0"));
					ChCwEmployeeVO emvo = (ChCwEmployeeVO) emdao
							.findByPk(employeeNum);
					if (emvo != null) {
						sendvo.setDeptId(emvo.getDeptId());
						sendvo.setEmployeeName(emvo.getEmployeeName());
					}
					sendvo.setEmployeeNum(employeeNum);
					sendvo.setCityid(user.getCityid());

					sendao.create(sendvo);

					// 更新发送状态 SENDSTATE置为SENT
					PaymentVO vo = doFindByPk(vobj.getSeq());
					vo.setSendstate(ISSENT);
					doUpdate(vo);
				}
			}
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public String doSendCountByNamedSql(PaymentDBParam params,
			boolean switchflag) throws Exception {
		String counts = "0";

		String qrySql = setSendSql(switchflag);
		VPaymentDAO dao = (VPaymentDAO) DAOFactory.build(VPaymentDAO.class,
				user);
		DataPackage dp = dao.queryByNamedSqlQuery(qrySql, params);
		counts = String.valueOf(dp.getRowCount());

		return counts;
	}

	public DataPackage doQueryDelByNamedSql(PaymentDBParam params,
			boolean switchflag) throws Exception {
		String qrySql = setDelSql(switchflag);
		VPaymentDAO dao = (VPaymentDAO) DAOFactory.build(VPaymentDAO.class,
				user);

		return dao.queryByNamedSqlQuery(qrySql, params);
	}

	public String doDelCountByNamedSql(PaymentDBParam params, boolean switchflag)
			throws Exception {
		String counts = "0";

		String qrySql = setDelSql(switchflag);
		VPaymentDAO dao = (VPaymentDAO) DAOFactory.build(VPaymentDAO.class,
				user);
		DataPackage dp = dao.queryByNamedSqlQuery(qrySql, params);
		counts = String.valueOf(dp.getRowCount());
		return counts;
	}

	public String doQuerySumByNamedSql(PaymentDBParam params, boolean switchflag)
			throws Exception {
		String amounts = "-1.0";

		try {
			String sumSql = setQrySumSql(switchflag);

			VPaymentDAO dao = (VPaymentDAO) DAOFactory.build(VPaymentDAO.class,
					user);
			amounts = dao.querySumByNamedSql(sumSql, params);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}

		return amounts;
	}

	public DataPackage doQueryDelByNamedSqlFromLtyle(PaymentDBParam params,
			boolean switchflag) throws Exception {
		String qrySql = setDelSqlFromLtyle(switchflag);
		VPaymentDAO dao = (VPaymentDAO) DAOFactory.build(VPaymentDAO.class,
				user);

		return dao.queryByNamedSqlQuery(qrySql, params);
	}

	public DataPackage doQueryDelByNamedSqlFromStyle(PaymentDBParam params,
			boolean switchflag) throws Exception {
		String qrySql = setDelSqlFromStyle(switchflag);
		VPaymentDAO dao = (VPaymentDAO) DAOFactory.build(VPaymentDAO.class,
				user);

		return dao.queryByNamedSqlQuery(qrySql, params);
	}
}
