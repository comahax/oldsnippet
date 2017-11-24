package com.sunrise.boss.ui.cms.provagent.vchpdrprewardrecord;

import java.util.ArrayList;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import com.sunrise.boss.business.cms.provagent.chpdrprewardrecord.persistent.ChPdRprewardrecordListVO;
import com.sunrise.boss.business.cms.provagent.chpdrprewardrecord.persistent.ChPdRprewardrecordVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.delegate.cms.provagent.chpdrprewardrecord.ChPdRprewardrecordDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;

public class VChPdRprewardrecordTaskBean extends BaseBatchTaskBean {

	public VChPdRprewardrecordTaskBean() {
		super.setBatchName("������������");
		super.setWriteLog(true);
	}

	protected String doStart() {
		return "�����̱���|���Ų�Ʒ���|�Ƴ��·�|����|���б�ʶ|���������|������ \r\n";
	}

	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		try {
			String[] content = StringUtils.splitPreserveAllTokens(line, "|");  
			ChPdRprewardrecordVO rpVo = new ChPdRprewardrecordVO();
			ChPdRprewardrecordDelegate delegate = new ChPdRprewardrecordDelegate(); 
			rpVo.setProvagentid(content[0]);
			rpVo.setProdno(content[1]);
			rpVo.setRewardmonth(content[2]);
			rpVo.setPhase(Short.parseShort(content[3]));
			rpVo.setCityid(content[4]);
			rpVo.setRpmoney(Double.parseDouble(content[5])); 
			/*���ݵ��б�ʶ���л�����Ӧ���п⣬���ݽ����ύ�Ĵ����̱��롢���Ų�Ʒ��š��Ƴ��·ݡ����������б�ʶ
			��ѯCH_PD_RPREWARDRECORD�����·�ADC������Ϊ�յ����ݣ�������������������ۼӽ������
			������ݲ�����������һ�����ݣ������������ȡ����ֵ���·�ADC���������ա�*/
			User realuser = new User();
			BeanUtils.copyProperties(realuser, user);
			ChPdRprewardrecordListVO listVO = new ChPdRprewardrecordListVO();
			listVO.set_se_cityid(content[4]);
			listVO.set_ne_phase(Short.parseShort(content[3]));
			listVO.set_se_prodno(content[1]);
			listVO.set_se_provagentid(content[0]);
			listVO.set_se_rewardmonth(content[2]); 
			DataPackage dp=delegate.doQuery(listVO, realuser);
			
			if (dp.getRowCount() > 0){
				ArrayList<ChPdRprewardrecordVO>  rplist= (ArrayList<ChPdRprewardrecordVO>) dp.getDatas();
				for (ChPdRprewardrecordVO chPdRprewardrecordVO : rplist) {
					if (chPdRprewardrecordVO.getAdcrewardid() == null || chPdRprewardrecordVO.getAdcrewardid() <= 0) {
						chPdRprewardrecordVO.setRpmoney(chPdRprewardrecordVO.getRpmoney() + Double.parseDouble(content[5]));
						delegate.doUpdate(chPdRprewardrecordVO, realuser);
					}else{
					   chPdRprewardrecordVO.setAdcrewardid(Long.parseLong(""));
					   delegate.doCreate(chPdRprewardrecordVO, realuser);
					}
				}
			} else {
				delegate.doCreate(rpVo, realuser);
			}
			
			
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
