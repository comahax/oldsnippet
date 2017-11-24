package com.sunrise.boss.ui.cms.reward.disintegral;

import com.sunrise.boss.business.cms.reward.disintegral.persistent.DisintegralVO;
import com.sunrise.boss.business.cms.waitaudit.persistent.WaitauditVO;
import com.sunrise.boss.business.cms.way.persistent.WayListVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.delegate.cms.reward.disintegral.DisintegralDelegate;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;
import com.sunrise.pub.tools.StringSplit;

public class DisintegralTaskBean extends BaseBatchTaskBean {

	private DisintegralDelegate delegate;
	
	private WayDelegate waydelegate;

	public DisintegralTaskBean() throws Exception {
		// TODO Auto-generated constructor stub
		delegate = new DisintegralDelegate();
		waydelegate = new WayDelegate();
		super.setBatchName("������ʵ��ҵ���������������־��ѯ");
		super.setWriteLog(true);
	}

	public String doStart() {
		return "������ʵ��ҵ��������������� \r\n";
	}
	
	public String doEnd() throws Exception {
        return "";
    }

	public ResultVO processLine(String line, int rowCount, User user, WaitauditVO vo) {
		ResultVO resultVO = new ResultVO();
		String[] content = StringSplit.split(line, "|");

		try {
				DisintegralVO createvo = new DisintegralVO();
				DisintegralDelegate delegate = new DisintegralDelegate();
				WayListVO waylistvo = new WayListVO();
				
				if("0".equals(content[2])||"1".equals(content[2])){
					waylistvo.set_se_wayid(content[0]);
					waylistvo.set_se_cityid(SessionFactoryRouter.conversionCityid(user.getCityid()));
					waylistvo.set_se_waytype("AG");
					waylistvo.set_se_waysubtype("DIS");
					waylistvo.set_ne_waystate(new Short("1"));
					DataPackage dp = waydelegate.doQuery(waylistvo, user);
					if(dp.getDatas().size()==0){
						line = rowCount + "   " + line + "    ������Ϣ:" + "�����̲�����,�����ǵ�ǰ���е����������Ч�ĺ�����!";
						resultVO.setInfo(line);
						resultVO.setOk(false);
						return resultVO;
					}
				}
				
				createvo.setWayid(content[0]);
				createvo.setCalmonth(content[1]);
				createvo.setIntegraltype(new Short(content[2]));
				createvo.setIntegralnum(new Long(content[3]));
				
				delegate.doCreate(createvo, user);
				line = rowCount + "   " + line + "    �����ɹ�!";
				resultVO.setInfo(line);
				resultVO.setOk(true);
				
			
		} catch (Exception e) {
			line = rowCount + "   " + line + "    ������Ϣ:" + e.getMessage();
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		return resultVO;
	}
}
