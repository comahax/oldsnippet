package com.sunrise.boss.ui.cms.examine.oprnwayid;

import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.cms.way.persistent.WayListVO;
import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;
import com.sunrise.pub.tools.StringSplit;

public class OprnwayidBatchCheck extends BaseCheckFormat {

	protected static String[] rewardasstype = new String[] { "0", "1", "2", "3" };

	public OprnwayidBatchCheck() {
		// TODO Auto-generated constructor stub
	}

	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		if (!"text/plain".equalsIgnoreCase(file.getContentType())) {
			throw new BusinessException("",
					"Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}

	public void checkLine(String line, int rowCount, User user)
			throws Exception {

		String[] content = StringSplit.split(line, "|");
		WayDelegate waydelegate = new WayDelegate();

		if (content.length != 2){
			throw new BusinessException("", "������Ӧ��Ϊ2��,��鿴˵������!");
		}

		if (StringUtils.isEmpty(content[0]))
		{
			throw new BusinessException("", "���롾���š�����Ϊ��!");
		}
		
		if ((content[0].length()>16))
		{
			throw new BusinessException("", "���롾���š����Ȳ��ܴ���16λ!");
		}
		
		if (StringUtils.isEmpty(content[1])) {
			throw new BusinessException("", "���롾�������롿����Ϊ��!");
		}
		
		if ((content[1].length()>32))
		{
			throw new BusinessException("", "���롾�������롿���Ȳ��ܴ���32λ!");
		}

		WayVO wayvo = waydelegate.doFindByPk(content[1], user);
		if (wayvo == null) {
			throw new BusinessException("", "���롾�������롿������");
		}
		
		WayListVO listvo = new WayListVO();
		listvo.set_se_wayid(content[1]);
		listvo.set_se_cityid(SessionFactoryRouter.conversionCityid(user.getCityid()));
		listvo.set_se_waytype("AG");
		DataPackage dp = waydelegate.doQuery(listvo, user);
		if(dp==null || dp.getDatas().size()==0){
			throw new BusinessException("", "���롾�������롿���Ǳ����е������������!");
		}
	}
}
