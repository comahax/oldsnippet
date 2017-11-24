package com.gmcc.pboss.web.reward.payment;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.reward.payment.PaymentDBParam;
import com.gmcc.pboss.business.reward.payment.PaymentVO;
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.control.reward.payment.Payment;
import com.gmcc.pboss.control.reward.payment.PaymentBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class PaymentTaskBean extends BaseBatchTaskBean {

	private static final long serialVersionUID = 1504968971275250333L;

	public PaymentTaskBean() throws Exception {
		super.setBatchName("付款数据上传（财务部）导入");
		super.setOprtype("导入");
		super.setWriteLog(true);
	}

	protected String doStart() {
		return "业务类型|酬金大类|酬金小类|收款单位名称|银行账户名称|银行名称|开户行（XX支行）|银行账号|对应报账单号|分公司|付款月份|实发金额|批次|对公/对私|备注|结算（出账）月份| \r\n";
	}

	@Override
	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		String optype = "";
		String stype = "";
		String payeeName = "";
		String payMonth = "";

		String batch = "";
		String calcMonth = "";
		String countryId = "";
		String paysum = "";

		try {
			String content[] = StringUtils.splitPreserveAllTokens(line, "|");
			Payment payment = (Payment) BOFactory.build(PaymentBO.class, user);

			optype = content[0].trim();
			stype = content[2];
			payeeName = content[3].trim();

			countryId = content[9];
			payMonth = content[10].trim();
			paysum = content[11];
			batch = content[12];
			calcMonth = content[15];

			// 判断业务类型、付款月、收款单位、小类名称（可为空）、批次（可为空）、结算月份（可为空）, 分公司, 金额的组合唯一性
			PaymentDBParam params = new PaymentDBParam();
			params.set_se_optype(optype);
			params.set_se_paymonth(payMonth);
			params.set_se_payee(payeeName);

			if (StringUtils.isNotBlank(stype)) {
				params.set_se_stype(stype.trim());
			}

			if (StringUtils.isNotBlank(calcMonth)) {
				params.set_se_calcmonth(calcMonth.trim());
			}

			if (StringUtils.isNotBlank(batch)) {
				params.set_se_batch(batch.trim());
			}

			if (StringUtils.isNotBlank(countryId)) {
				params.set_se_countyid(countryId.trim());
			}

			if (StringUtils.isNotBlank(paysum)) {
				params.set_ne_paysum(paysum.trim());
			}

			params.setCountOnly(true);

			DataPackage dp = payment.doQuery(params);
			// 判断会不会是已有数据,如果已有则不覆盖
			if (dp.getRowCount() > 0) {
				StringBuilder strb = new StringBuilder();
				strb.append(rowCount);
				strb.append("|");
				strb.append(line);
				strb.append("|");
				strb.append("出错原因:重复数据");
				strb.append("|");

				resultVO.setInfo(strb.toString());
				resultVO.setOk(false);
			} else {
				PaymentVO vo = new PaymentVO();

				// 业务类型|酬金大类|酬金小类|收款单位名称|银行账户名称|银行名称|开户行（XX支行）|
				// 银行账号|对应报账单号|分公司|付款月份|实发金额|批次|对公/对私|备注|结算（出账）月份|

				// 业务类型 0
				vo.setOptype(optype);

				// 酬金大类 1
				if (StringUtils.isNotBlank(content[1])) {
					vo.setLtype(content[1].trim());
				}

				// 酬金小类 2
				if (StringUtils.isNotBlank(stype)) {
					vo.setStype(stype.trim());
				}

				// 收款单位名称 3
				vo.setPayee(payeeName);

				// 银行账户名称 4
				vo.setBkactname(content[4].trim());

				// 银行名称 5
				vo.setBank(content[5].trim());

				// 开户行（XX支行）6
				vo.setDepositbank(content[6].trim());

				// 银行账号 7
				vo.setAccount(content[7].trim());

				// 对应报账单号 8
				if (StringUtils.isNotBlank(content[8])) {
					vo.setBillnumber(content[8].trim());
				}

				// 分公司 9
				if (StringUtils.isNotBlank(content[9])) {
					vo.setCountyid(content[9].trim());
				}

				// 付款月份 10
				vo.setPaymonth(payMonth);

				// 实发金额 11
				vo.setPaysum(new Double(content[11]));

				// 批次 12
				if (StringUtils.isNotBlank(batch)) {
					vo.setBatch(batch.trim());
				}

				// 对公/对私 13
				if (StringUtils.isNotBlank(content[13])) {
					vo.setPubpri(content[13].trim());
				}

				// 备注 14
				if (StringUtils.isNotBlank(content[14])) {
					vo.setNote(content[14].trim());
				}

				// 结算月份 15
				if (StringUtils.isNotBlank(calcMonth)) {
					vo.setCalcmonth(calcMonth.trim());
				}

				// 设置默认值
				vo.setUpoprcode(user.getOprcode());
				// vo.setCheckedflag("UNCHECKED");

				payment.doCreate(vo);

				StringBuilder strb = new StringBuilder();
				strb.append(rowCount);
				strb.append("|");
				strb.append(line);
				strb.append("|导入成功|");

				resultVO.setInfo(strb.toString());
				resultVO.setOk(true);
			}
		} catch (Exception e) {
			StringBuilder strb = new StringBuilder();
			strb.append(rowCount);
			strb.append("|");
			strb.append(line);
			strb.append("|");
			strb.append("出错原因:");
			strb.append(e.getMessage());

			resultVO.setInfo(strb.toString());
			resultVO.setOk(false);
		}

		return resultVO;
	}
}
