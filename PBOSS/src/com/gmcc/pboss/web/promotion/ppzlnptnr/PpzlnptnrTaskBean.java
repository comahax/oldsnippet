package com.gmcc.pboss.web.promotion.ppzlnptnr;


import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.promotion.ppzlnptnr.PpzlnptnrVO;
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.control.promotion.ppzlnptnr.PpzlnptnrBO;
import com.sunrise.jop.infrastructure.control.BOFactory;

public class PpzlnptnrTaskBean extends BaseBatchTaskBean {
	public PpzlnptnrTaskBean() throws Exception {
		super.setBatchName("������������������");
		super.setWriteLog(true);
	}

	protected String doStart() {
		
		return "��������������������  \r\n";
	}

	/**
	 * ����һ����¼
	 */
	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		try {
			PpzlnptnrBO ptnrbo = (PpzlnptnrBO) BOFactory.build(PpzlnptnrBO.class, user);
			String items[] = StringUtils.splitPreserveAllTokens(line, "|");
			PpzlnptnrVO vo = new PpzlnptnrVO();
			PpzlnptnrVO createvo = new PpzlnptnrVO();
			
			vo.setWayid(items[0]);
			vo.setPid(new Long((String)getParameterMap().get("pk")));
			createvo = ptnrbo.doFindByVO(vo);
			
			if (createvo==null) {
				ptnrbo.doCreate(vo);
				line = rowCount + "   " + line + "    �ɹ�";
				resultVO.setInfo(line);
				resultVO.setOk(true);
			} else {
				line = rowCount + "   " + line + "    ������Ϣ:" + "��¼��ϵͳ�Ѵ���!";
				resultVO.setInfo(line);
				resultVO.setOk(false);
			}
		} catch (Exception e) {
			line = rowCount + "   " + line + "    ������Ϣ:" + e.getMessage();
			e.printStackTrace();
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		return resultVO;
	}

}
