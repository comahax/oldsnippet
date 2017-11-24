package com.gmcc.pboss.web.reward.payway;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.reward.payway.PaywayDBParam;
import com.gmcc.pboss.business.reward.payway.PaywayVO;
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.control.reward.payway.Payway;
import com.gmcc.pboss.control.reward.payway.PaywayBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class PaywayTaskBean extends BaseBatchTaskBean {
	public PaywayTaskBean() throws Exception {
		super.setBatchName("�տλ���ϵ���");
		super.setOprtype("����");
		super.setWriteLog(true);
	}

	protected String doStart() {
		return "�տλ����|��������|  \r\n";
	}

	@Override
	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		try {
			String content[] = StringUtils.splitPreserveAllTokens(line, "|");
			Payway payway = (Payway) BOFactory.build(PaywayBO.class, user);

			String cityid = user.getCityid();

			// һ����������ֻ�ܹ���һ���տλ��һ���տλ�����ж����������
			// ���ֻ��Ҫ�ж�������������Ψһ��
			PaywayDBParam params = new PaywayDBParam();
			params.set_se_cityid(cityid);
			String wayid = content[1].trim();
			params.set_se_wayid(wayid);
			DataPackage dp = payway.doQuery(params);

			int size = dp.getDatas().size();
			if (size > 0) {
				StringBuilder strb = new StringBuilder();
				strb.append(rowCount);
				strb.append("|");
				strb.append(line);
				strb.append("|����ԭ��:һ����������ֻ�ܶ�Ӧһ���տλ�����������롾");
				strb.append(wayid);
				strb.append("���Ѵ���|");

				resultVO.setInfo(strb.toString());
				resultVO.setOk(false);
			} else {
				PaywayVO vo = new PaywayVO();
				vo.setPayee(content[0].trim());
				vo.setWayid(wayid);
				vo.setCityid(cityid);
				payway.doCreate(vo);

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
			strb.append("|����ԭ��:");
			strb.append(e.getMessage());
			strb.append("|");

			resultVO.setInfo(strb.toString());
			resultVO.setOk(false);
		}

		return resultVO;
	}
}
