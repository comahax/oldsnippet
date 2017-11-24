package com.gmcc.pboss.web.base.batchsmsrc;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.base.batchsmsrc.BatchsmsrcVO;
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.control.base.batchsmsrc.Batchsmsrc;
import com.gmcc.pboss.control.base.batchsmsrc.BatchsmsrcBO;
import com.sunrise.jop.infrastructure.control.BOFactory;

public class BatchsmsrcTaskBean  extends BaseBatchTaskBean{

	Batchsmsrc BatchsmsrcBO = null;
	public BatchsmsrcTaskBean() throws Exception {
		super.setBatchName("�����������·����պ�����������");
		super.setOprtype("����");
		super.setWriteLog(true);
		// TODO Auto-generated constructor stub
		
	}

	@Override
	protected ResultVO processLine(String line, int rowCount) {
		String loginwayid = user.getWayid();
		ResultVO resultVO = new ResultVO();
		try{
			String items[] = StringUtils.splitPreserveAllTokens(line, "|");
			BatchsmsrcBO = (BatchsmsrcBO) BOFactory.build(BatchsmsrcBO.class,user);
			BatchsmsrcVO vo = new BatchsmsrcVO();
			vo.setMobile(items[0]);
			vo.setSmscode(items[1]);
			if (BatchsmsrcBO.doFindByPk(vo) != null)
				throw new Exception("���������Ѿ����ڡ�");
			vo.setSdt(items[2]);
			BatchsmsrcBO.doCreate(vo);
			line = rowCount + "   " + line + "    �ɹ�";
			resultVO.setInfo(line);
			resultVO.setOk(true);
		}catch(Exception e){
			e.printStackTrace();
			line = rowCount + "   " + line + "    ������Ϣ:" + e.getMessage();
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		return resultVO;
	}
}
