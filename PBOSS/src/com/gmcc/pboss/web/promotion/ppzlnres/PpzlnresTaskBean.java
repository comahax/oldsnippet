package com.gmcc.pboss.web.promotion.ppzlnres;


import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.promotion.ppzlnres.PpzlnresVO;
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.control.promotion.ppzlnres.PpzlnresBO;
import com.sunrise.jop.infrastructure.control.BOFactory;

public class PpzlnresTaskBean extends BaseBatchTaskBean {

	public PpzlnresTaskBean() throws Exception {
		super.setBatchName("方案与资源批量导入");
		super.setWriteLog(true);
	}

	protected String doStart() {
		
		return "方案与资源批量导入结果  \r\n";
	}

	/**
	 * 处理一条记录
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
				line = rowCount + "   " + line + "    成功";
				resultVO.setInfo(line);
				resultVO.setOk(true);
			} else {
				line = rowCount + "   " + line + "    错误信息:" + "记录在系统已存在!";
				resultVO.setInfo(line);
				resultVO.setOk(false);
			}
		} catch (Exception e) {
			line = rowCount + "   " + line + "    错误信息:" + e.getMessage();
			e.printStackTrace();
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		return resultVO;
	}

}
