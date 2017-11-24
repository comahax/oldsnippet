package com.gmcc.pboss.web.promotion.ppzlncom;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.promotion.ppzlncom.PpzlncomVO;
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.control.promotion.ppzlncom.PpzlncomBO;
import com.sunrise.jop.infrastructure.control.BOFactory;

public class PpzlncomTaskBean extends BaseBatchTaskBean {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PpzlncomTaskBean() throws Exception {
		super.setBatchName("��������Ʒ������������");
		super.setWriteLog(true);
	}

	protected String doStart() {

		return "��������Ʒ��������������  \r\n";
	}

	/**
	 * ����һ����¼
	 */
	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		try {
			PpzlncomBO combo = (PpzlncomBO) BOFactory.build(PpzlncomBO.class,
					user);
			String items[] = StringUtils.splitPreserveAllTokens(line, "|");
			PpzlncomVO vo = new PpzlncomVO();
			PpzlncomVO queryvo = new PpzlncomVO();

			vo.setComcategory(items[0]);
			vo.setPid(new Long((String) getParameterMap().get("pk")));
			queryvo = combo.doFindByVO(vo);
			if (queryvo == null) {
				combo.doCreate(vo);
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
