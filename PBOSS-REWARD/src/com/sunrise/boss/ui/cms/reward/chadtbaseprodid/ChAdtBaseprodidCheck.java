package com.sunrise.boss.ui.cms.reward.chadtbaseprodid;

import java.util.HashMap;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;
import com.sunrise.boss.business.cms.common.CheckUtil;
import com.sunrise.boss.business.cms.reward.chadtbaseprodid.persistent.ChAdtBaseprodidListVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.cms.reward.chadtbaseprodid.ChAdtBaseprodidDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;

public class ChAdtBaseprodidCheck extends BaseCheckFormat{
	
	
	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		 
		if (!"text/plain".equalsIgnoreCase(file.getContentType())) {
			throw new BusinessException("", "Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}
	
	public void checkLine(String line, int rowCount, User user) throws Exception {
		if (null == line || "".equals(line)) {
			return;
		} 
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		if (content.length != 9) {
			throw new Exception("�ϴ�������������,ӦΪ8��,��鿴˵������!");
		} 
		if (StringUtils.isEmpty(content[0]) || content[0].getBytes("GBK").length > 32) {
			throw new Exception("[��Ʒ��ʶ]����Ϊ�գ����ҳ������Ϊ32");
		}
		if ( StringUtils.isEmpty(content[1])) {
			throw new Exception("[���б�ʶ]����Ϊ��");
		}else{
			String  cityid = SessionFactoryRouter.conversionCityid(user.getCityid());
			if(!cityid.equals(content[1]))
				throw new Exception("��ֻ�ܲ������Ŷ�Ӧ�ĵ���"+cityid+"������ĵ��б�ʶΪ����"+content[1]+"��,���޸�");
		} 
 
		if (StringUtils.isEmpty(content[2])) {
			throw new Exception("[�ײ�����]����Ϊ��");
		}  else if (!content[2].trim().matches("(3G|4G)")) {  
			throw new Exception("��������Ч�ġ��ײ����͡�");
		}
		 
		if (StringUtils.isEmpty(content[4])) {
			throw new Exception("[�ײ����]����Ϊ�գ����ұ���Ϊ����");
		} else if (!content[4].trim().matches("(1|2|3)")) {
			throw new Exception("��������Ч���ײ�����[�ײ����]");
		}
		if (StringUtils.isEmpty(content[6]) || !CheckUtil.checkDouble(content[6], 14, 2)) {
			throw new Exception("[�ײ�ֵ]����Ϊ��,�����ֻ����2��С��");
		}
		
		ChAdtBaseprodidListVO newVo = new ChAdtBaseprodidListVO();
		 newVo.set_se_cityid(content[1]);
		 newVo.set_se_prodid(content[0]);
		 ChAdtBaseprodidDelegate delegate = new ChAdtBaseprodidDelegate();
		DataPackage dp = delegate.doQuery(newVo, user);
		
		if ( dp.getRowCount()>0) {
			throw new Exception("���С�"+content[1]+"����Ʒ��ʶΪ����"+content[0]+"���Ѵ�����ͬ��¼!");
		}
	}
}
