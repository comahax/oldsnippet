package com.sunrise.boss.ui.cms.cityrewardad;

import org.apache.commons.beanutils.BeanUtils;
import com.sunrise.boss.business.cms.cityrewardad.persistent.CityrewardadVO;
import com.sunrise.boss.delegate.cms.cityrewardad.CityrewardadDelegate;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;
import com.sunrise.pub.tools.StringSplit;

public class CityrewardadTaskBean extends BaseBatchTaskBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 384641381499210907L;
	private CityrewardadDelegate delegate;

	public CityrewardadTaskBean() throws Exception {
		// TODO Auto-generated constructor stub
		try {
			delegate = new CityrewardadDelegate();
			batchName = "���ж���������ݵ���";
			setWriteLog(true);
		} catch (Exception ex) {
			ex.printStackTrace(System.err);
		}
	}

	protected String doStart() {
		return "���ж���������ݵ����� \r\n";
	}
	
	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		String[] content = StringSplit.split(line, "|");

		try {
			CityrewardadVO createvo = new CityrewardadVO();
			createvo.setCityid(user.getCityid());
			//createvo.setCityid(SessionFactoryRouter.conversionCityid(user.getCityid()));
			createvo.setWayid(content[0]);
			createvo.setRewardtype(new Short(content[1]));
			createvo.setPaymonth(content[2]);
			createvo.setAmt(new Double(content[3]));
			CityrewardadVO queryvo = (CityrewardadVO) BeanUtils
				.cloneBean(createvo);
			if (delegate.doFindByPk(queryvo, user) == null) {
				delegate.doCreate(createvo, user);
				line = rowCount + "   " + line + "    �����ɹ�";
			} else {
				delegate.doUpdate(createvo, user);
				line = rowCount + "   " + line + "    ���³ɹ�";
			}
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
