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
					"要导入的文件类型不正确，本系统只导入指定的文件格式：txt文本文件!");
		}
	}

	public void checkLine(String line, int rowCount, User user)
			throws Exception {

		String[] content = StringSplit.split(line, "|");
		WayDelegate waydelegate = new WayDelegate();

		if (content.length != 2){
			throw new BusinessException("", "导入项应该为2列,请查看说明帮助!");
		}

		if (StringUtils.isEmpty(content[0]))
		{
			throw new BusinessException("", "导入【工号】不能为空!");
		}
		
		if ((content[0].length()>16))
		{
			throw new BusinessException("", "导入【工号】长度不能大于16位!");
		}
		
		if (StringUtils.isEmpty(content[1])) {
			throw new BusinessException("", "导入【渠道代码】不能为空!");
		}
		
		if ((content[1].length()>32))
		{
			throw new BusinessException("", "导入【渠道代码】长度不能大于32位!");
		}

		WayVO wayvo = waydelegate.doFindByPk(content[1], user);
		if (wayvo == null) {
			throw new BusinessException("", "导入【渠道代码】不存在");
		}
		
		WayListVO listvo = new WayListVO();
		listvo.set_se_wayid(content[1]);
		listvo.set_se_cityid(SessionFactoryRouter.conversionCityid(user.getCityid()));
		listvo.set_se_waytype("AG");
		DataPackage dp = waydelegate.doQuery(listvo, user);
		if(dp==null || dp.getDatas().size()==0){
			throw new BusinessException("", "导入【渠道代码】不是本地市的社会渠道代码!");
		}
	}
}
