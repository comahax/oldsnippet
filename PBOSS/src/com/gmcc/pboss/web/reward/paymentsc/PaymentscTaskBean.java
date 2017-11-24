package com.gmcc.pboss.web.reward.paymentsc;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.reward.paymentsc.PaymentscDBParam;
import com.gmcc.pboss.business.reward.paymentsc.PaymentscVO;
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.control.reward.paymentsc.Paymentsc;
import com.gmcc.pboss.control.reward.paymentsc.PaymentscBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class PaymentscTaskBean extends BaseBatchTaskBean {

	private static final long serialVersionUID = -7901998453696759262L;

	public PaymentscTaskBean() throws Exception {
		super.setBatchName("出账数据上传（市场部）导入");
		super.setOprtype("导入");
		super.setWriteLog(true);
	}

	protected String doStart() {
		return "渠道编码|结算月份（出账月份）|业务月份（办理月份）|业务类型|酬金大类|酬金小类|手机号码|IMEI号|酬金金额（出账金额）|结算期数（第*期）|备注|\r\n";
	}

	@Override
	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		String wayid = "";
		String calcmonth = "";
		String paymonth = "";
		String optype = "";
		String ltype = "";
		String stype = "";
		String mobile = "";
		String imei = "";
		double paysum = 0;
		String settleperiods = "";
		String note = "";

		try {
			String content[] = StringUtils.splitPreserveAllTokens(line, "|");
			Paymentsc paymentsc = (Paymentsc) BOFactory.build(
					PaymentscBO.class, user);

			// wayid、calcmonth、paymonth、optype、ltype、stype、mobile、imei、paysum、settleperiods、note
			wayid = content[0].trim();
			calcmonth = content[1].trim();
			paymonth = content[2].trim();
			optype = content[3].trim();
			ltype = content[4].trim();
			stype = content[5].trim();

			if (StringUtils.isNotBlank(content[6])) {
				mobile = content[6].trim();
			}
			if (StringUtils.isNotBlank(content[7])) {
				imei = content[7].trim();
			}

			paysum = Double.parseDouble(content[8].trim());
			settleperiods = content[9].trim();

			if (StringUtils.isNotBlank(content[10])) {
				note = content[10].trim();
			}

			PaymentscDBParam params = new PaymentscDBParam();
			params.set_se_wayid(wayid);
			params.set_se_calcmonth(calcmonth);
			params.set_se_paymonth(paymonth);
			params.set_se_optype(optype);
			params.set_se_ltype(ltype);
			params.set_se_stype(stype);
			params.set_se_settleperiods(settleperiods);

			if (StringUtils.isNotBlank(mobile)) {
				params.set_se_mobile(mobile);
			}
			if (StringUtils.isNotBlank(imei)) {
				params.set_se_imei(imei);
			}

			params.set_se_paysum(String.valueOf(paysum));

			params.setCountOnly(true);

			DataPackage dp = paymentsc.doQuery(params);
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
				PaymentscVO vo = new PaymentscVO();

				vo.setWayid(wayid);
				vo.setCalcmonth(calcmonth);
				vo.setPaymonth(paymonth);
				vo.setOptype(optype);
				vo.setLtype(ltype);
				vo.setStype(stype);
				vo.setMobile(mobile);
				vo.setImei(imei);

				vo.setPaysum(new Double(paysum));
				vo.setSettleperiods(settleperiods);
				vo.setNote(note);

				// 设置默认值
				vo.setUpoprcode(user.getOprcode());
				// vo.setCheckedflag("UNCHECKED");

				paymentsc.doCreate(vo);

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
