package com.gmcc.pboss.web.resource.comressmp;


import java.io.Serializable;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.resource.compack.CompackDBParam;
import com.gmcc.pboss.business.resource.compack.CompackVO;
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.control.resource.compack.Compack;
import com.gmcc.pboss.control.resource.compack.CompackBO;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.common.utils.lang.Code2NameUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;

public class ComressmpResuseTaskBean extends BaseBatchTaskBean{
	
	public ComressmpResuseTaskBean() throws Exception {
		super.setBatchName("�׿���Դ��;��������");
		super.setWriteLog(true);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected ResultVO processLine(String line, int rowCount) {
		// TODO Auto-generated method stub
		ResultVO resultVO = new ResultVO();
		try{
			String resuse=(String)this.parameterMap.get("resuse");
			Compack bo = (Compack) BOFactory.build(CompackBO.class, user);
			//��Ʒ����|����|
			String items[] = StringUtils.splitPreserveAllTokens(line, "|");
			CompackDBParam params=new CompackDBParam();
			Serializable pkVO=new CompackVO();
			BeanUtils.setProperty(pkVO, "batchno", items[0]);//��Ʒ����
			BeanUtils.setProperty(pkVO, "boxnum", items[1]);//����
			//params.set_se_comresid(items[0]);
			CompackVO compackVO=bo.doFindByPk(pkVO);
			String codeName = Code2NameUtils.code2Name("$IM_FXRESUSE",  resuse , user.getCityid());
			if(compackVO == null )
				throw new Exception(items[0]+"|"+items[1]+"|"+codeName+"|��Ʒ�����ݲ�����|");
			if(!"1".equals(compackVO.getPackstate())&&!"30".equals(compackVO.getPackstate()))
				throw new Exception(items[0]+"|"+items[1]+"|"+codeName+"|��Ʒ��״̬����ȷ|");
			compackVO.setResuse(resuse);
			bo.doUpdate(compackVO);
			line = items[0]+"|"+items[1]+"|"+codeName+"|  |";
			resultVO.setInfo(line);
			resultVO.setOk(true);
		}catch(Exception e){
			line = e.getMessage();
			//e.printStackTrace();
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
			return resultVO;
	}


}
