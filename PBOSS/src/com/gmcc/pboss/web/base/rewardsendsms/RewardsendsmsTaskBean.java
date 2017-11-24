package com.gmcc.pboss.web.base.rewardsendsms;

import java.util.Date; 
import org.apache.commons.lang.StringUtils;
import com.gmcc.pboss.business.base.rewardsendsms.RewardsendsmsDBParam;
import com.gmcc.pboss.business.base.rewardsendsms.RewardsendsmsVO;
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.control.base.rewardsendsms.Rewardsendsms;
import com.gmcc.pboss.control.base.rewardsendsms.RewardsendsmsBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;

public class RewardsendsmsTaskBean extends BaseBatchTaskBean{ 
	
	public RewardsendsmsTaskBean() throws Exception {
		super.setBatchName("�����������¼����������");
		super.setOprtype("����");
		super.setWriteLog(true); 
	}

	protected String doStart() {
		return "�к�||���긺���˺���|����������|������|  \r\n";
	}
	//��������  ���˷�ʽ  �������� ��������
	@Override
	protected ResultVO processLine(String line, int rowCount) {
		 
		ResultVO resultVO = new ResultVO();
		try {
			String items[] = StringUtils.splitPreserveAllTokens(line, "|");  
			Rewardsendsms rewardsendsms = (Rewardsendsms)BOFactory.build(RewardsendsmsBO.class, DBAccessUser.getInnerUser()) ;
			RewardsendsmsDBParam param =  new RewardsendsmsDBParam(); 
			param.set_se_sendtel(items[0]);
			param.set_se_type(items[1]);
			DataPackage dp=rewardsendsms.doQuery(param);
			if(dp.getRowCount()==0){
				RewardsendsmsVO   vo = new RewardsendsmsVO();
				vo.setCityid(user.getCityid());
				vo.setCreatetime(new Date());
				vo.setSendtel(items[0]);
				vo.setType(Short.parseShort(items[1]));
				rewardsendsms.doCreate(vo);
			}else{
				throw new Exception("�Ѵ��ں���" + items[0] + "����������Ϊ" + items[1] + "������");
			}
			 
 			line = rowCount + "|" + items[0] + "|" + items[1]+ "|"+ "|"+"�����ɹ�"+"|";
			resultVO.setInfo(line);
			resultVO.setOk(true);
		} catch (Exception e) { 
			line = rowCount + "   " + line + "|������Ϣ:" + e.getMessage();
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		return resultVO;
	} 
}
