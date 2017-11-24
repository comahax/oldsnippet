package com.sunrise.boss.ui.cms.reward.chadtbaseprodid;

import java.util.Date;
import org.apache.commons.lang.StringUtils;
import com.sunrise.boss.business.cms.reward.chadtbaseprodid.persistent.ChAdtBaseprodidVO;
import com.sunrise.boss.delegate.cms.reward.chadtbaseprodid.ChAdtBaseprodidDelegate;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;

public class ChAdtBaseprodidTaskBean extends BaseBatchTaskBean{

	public ChAdtBaseprodidTaskBean() {
		super.setBatchName("�ײͲ�Ʒ�б����õ���");
		super.setWriteLog(true);
	}

	protected String doStart() {
		return "�к�|��Ʒ��ʶ|���б�ʶ|�ײ�����|��Ʒ����|�ײ����|��������|�ײ�ֵ|��ע|������ \r\n";
	}

	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		try {
			String[] content = StringUtils.splitPreserveAllTokens(line, "|"); 
			ChAdtBaseprodidVO vo = new ChAdtBaseprodidVO();
			ChAdtBaseprodidDelegate delegate = new ChAdtBaseprodidDelegate();
			vo.setProdid(content[0].trim()); 
			vo.setCityid(content[1].trim());
			vo.setType(content[2]); 
			vo.setProdname(StringUtils.isEmpty(content[3])? "" : content[3]);
			vo.setOprtype(content[4]);
			vo.setTertype(StringUtils.isEmpty(content[5])? "" : content[5]); 
			vo.setWrapfee(Double.parseDouble(content[6].trim())); 
			vo.setAdtremark(StringUtils.isEmpty(content[7])? "" : content[7]);
			vo.setCreatetime(new Date());
			delegate.doCreate(vo, user);
			
			line = rowCount + "|" + line + "�����ɹ�";
			resultVO.setOk(true);
			resultVO.setInfo(line);
			return resultVO;
		} catch (Exception e) {
			line = rowCount + "|" + line + "������Ϣ:" + e.getMessage();
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		return resultVO;
	}
}
