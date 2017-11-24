package com.gmcc.pboss.web.promotion.ppzlnres;


import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.promotion.ppzlnres.PpzlnresVO;
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.control.promotion.ppzlnres.PpzlnresBO;
import com.sunrise.jop.infrastructure.control.BOFactory;

public class PpzlnresTaskBean extends BaseBatchTaskBean {

	public PpzlnresTaskBean() throws Exception {
		super.setBatchName("��������Դ��������");
		super.setWriteLog(true);
	}

	protected String doStart() {
		
		return "��������Դ����������  \r\n";
	}

	/**
	 * ����һ����¼
	 */
	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		try {
			PpzlnresBO resbo = (PpzlnresBO) BOFactory.build(PpzlnresBO.class, user);
			String items[] = StringUtils.splitPreserveAllTokens(line, "|");
			PpzlnresVO vo = new PpzlnresVO();
			PpzlnresVO createvo = new PpzlnresVO();
			
			vo.setResid(items[0]);
			vo.setPid(new Long((String)getParameterMap().get("pk")));
			createvo = resbo.doFindByVO(vo);
			
			if (createvo==null) {
				resbo.doCreate(vo);
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
