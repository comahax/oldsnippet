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
		super.setBatchName("���������ϴ������񲿣�����");
		super.setOprtype("����");
		super.setWriteLog(true);
	}

	protected String doStart() {
		return "ҵ������|������|���С��|�տλ����|�����˻�����|��������|�����У�XX֧�У�|�����˺�|��Ӧ���˵���|�ֹ�˾|�����·�|ʵ�����|����|�Թ�/��˽|��ע|���㣨���ˣ��·�| \r\n";
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

			// �ж�ҵ�����͡������¡��տλ��С�����ƣ���Ϊ�գ������Σ���Ϊ�գ��������·ݣ���Ϊ�գ�, �ֹ�˾, �������Ψһ��
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
			// �жϻ᲻������������,��������򲻸���
			if (dp.getRowCount() > 0) {
				StringBuilder strb = new StringBuilder();
				strb.append(rowCount);
				strb.append("|");
				strb.append(line);
				strb.append("|");
				strb.append("����ԭ��:�ظ�����");
				strb.append("|");

				resultVO.setInfo(strb.toString());
				resultVO.setOk(false);
			} else {
				PaymentVO vo = new PaymentVO();

				// ҵ������|������|���С��|�տλ����|�����˻�����|��������|�����У�XX֧�У�|
				// �����˺�|��Ӧ���˵���|�ֹ�˾|�����·�|ʵ�����|����|�Թ�/��˽|��ע|���㣨���ˣ��·�|

				// ҵ������ 0
				vo.setOptype(optype);

				// ������ 1
				if (StringUtils.isNotBlank(content[1])) {
					vo.setLtype(content[1].trim());
				}

				// ���С�� 2
				if (StringUtils.isNotBlank(stype)) {
					vo.setStype(stype.trim());
				}

				// �տλ���� 3
				vo.setPayee(payeeName);

				// �����˻����� 4
				vo.setBkactname(content[4].trim());

				// �������� 5
				vo.setBank(content[5].trim());

				// �����У�XX֧�У�6
				vo.setDepositbank(content[6].trim());

				// �����˺� 7
				vo.setAccount(content[7].trim());

				// ��Ӧ���˵��� 8
				if (StringUtils.isNotBlank(content[8])) {
					vo.setBillnumber(content[8].trim());
				}

				// �ֹ�˾ 9
				if (StringUtils.isNotBlank(content[9])) {
					vo.setCountyid(content[9].trim());
				}

				// �����·� 10
				vo.setPaymonth(payMonth);

				// ʵ����� 11
				vo.setPaysum(new Double(content[11]));

				// ���� 12
				if (StringUtils.isNotBlank(batch)) {
					vo.setBatch(batch.trim());
				}

				// �Թ�/��˽ 13
				if (StringUtils.isNotBlank(content[13])) {
					vo.setPubpri(content[13].trim());
				}

				// ��ע 14
				if (StringUtils.isNotBlank(content[14])) {
					vo.setNote(content[14].trim());
				}

				// �����·� 15
				if (StringUtils.isNotBlank(calcMonth)) {
					vo.setCalcmonth(calcMonth.trim());
				}

				// ����Ĭ��ֵ
				vo.setUpoprcode(user.getOprcode());
				// vo.setCheckedflag("UNCHECKED");

				payment.doCreate(vo);

				StringBuilder strb = new StringBuilder();
				strb.append(rowCount);
				strb.append("|");
				strb.append(line);
				strb.append("|����ɹ�|");

				resultVO.setInfo(strb.toString());
				resultVO.setOk(true);
			}
		} catch (Exception e) {
			StringBuilder strb = new StringBuilder();
			strb.append(rowCount);
			strb.append("|");
			strb.append(line);
			strb.append("|");
			strb.append("����ԭ��:");
			strb.append(e.getMessage());

			resultVO.setInfo(strb.toString());
			resultVO.setOk(false);
		}

		return resultVO;
	}
}
