package com.gmcc.pboss.web.resource.comressmp;


import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.resource.comressmp.ComressmpDBParam;
import com.gmcc.pboss.business.resource.comressmp.ComressmpVO;
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.control.resource.comressmp.Comressmp;
import com.gmcc.pboss.control.resource.comressmp.ComressmpBO;
import com.gmcc.pboss.web.sales.stockalarm.AlarmUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;

public class ComressmpBoxnumTaskBean extends BaseBatchTaskBean{
	
	public ComressmpBoxnumTaskBean() throws Exception {
		super.setBatchName("�׿��ִ�������������");
		super.setWriteLog(true);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected String doStart() {
		return "��Ʒ����|����|��Դ����|������Ϣ|  \r\n";
	}

	@Override
	protected String preProcessLine(String line, int rowCount) throws Exception  {
		String items[] = AlarmUtils.getStrArr(StringUtils.splitPreserveAllTokens(line, "|"));
		try {
			Comressmp ComressmpBO = (Comressmp) BOFactory.build(ComressmpBO.class, user);
			//��Դ���|����|����|
			//���ݺ�������θ����׿���Դ��(IM_FX_COMRESSMP)�İ������Ϊ�ա�
			ComressmpDBParam fristParams=new ComressmpDBParam();
			fristParams.set_se_batchno(items[1]);
			fristParams.set_se_comresid(items[0]);
			List<ComressmpVO> fristList=ComressmpBO.doQuery(fristParams).getDatas();
			if(fristList!=null){
				for(ComressmpVO vo:fristList){
					vo.setInsideseq(null);
					ComressmpBO.doUpdate(vo);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception(items[0]+"|"+items[1]+"|"+items[2]+"|Ԥ���ʧ��|");
		}
		return null;
	}

	@Override
	protected ResultVO processLine(String line, int rowCount) {
		
		ResultVO resultVO= null;
			try {
				Comressmp ComressmpBO = (Comressmp) BOFactory.build(ComressmpBO.class, user);
				resultVO = ComressmpBO.doBoxNumUpdate(line, user, rowCount);
			} catch (Exception e) {
			}
			return resultVO;

	}
	
	


}
