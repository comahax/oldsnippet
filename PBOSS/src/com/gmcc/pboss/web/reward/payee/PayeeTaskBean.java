package com.gmcc.pboss.web.reward.payee;


import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.reward.payee.PayeeDBParam;
import com.gmcc.pboss.business.reward.payee.PayeeVO;
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.control.reward.payee.Payee;
import com.gmcc.pboss.control.reward.payee.PayeeBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class PayeeTaskBean extends BaseBatchTaskBean{
	public PayeeTaskBean() throws Exception {
		super.setBatchName("�տλ���ϵ���"); 
		super.setOprtype("����");
		super.setWriteLog(true);
	}

	protected String doStart() {
		return "�տλ|�Թ���˽|  \r\n";
	}

	@Override
	protected ResultVO processLine(String line, int rowCount) {
 		ResultVO resultVO = new ResultVO();
		try {
			String content[] = StringUtils.splitPreserveAllTokens(line, "|");
			Payee payee = (Payee) BOFactory.build(PayeeBO.class, user);
			
			// �ж��տλ����Ψһ��
			PayeeDBParam params = new PayeeDBParam();
			params.set_se_cityid(user.getCityid());
			params.set_se_payee(content[0].trim()) ;
			DataPackage dp = payee.doQuery(params);
			PayeeVO vo = new PayeeVO();
			if (dp.getDatas().size()>0 ) {
				vo = (PayeeVO)dp.getDatas().get(0);
			}

			vo.setPayee(content[0].trim());
			vo.setPubpri(content[1].trim());
			vo.setCityid(user.getCityid());
				
			payee.doCreate(vo);
			line = rowCount + "|"+line+"|" + "����ɹ�" + "|";
			
			resultVO.setInfo(line);
			resultVO.setOk(true);
		} catch (Exception e) {
			line = rowCount + "|" + line + "|" + "����ԭ��:" + e.getMessage() + "|";
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		
		return resultVO;
	}
}
