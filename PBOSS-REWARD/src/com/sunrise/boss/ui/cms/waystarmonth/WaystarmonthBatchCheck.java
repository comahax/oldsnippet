package com.sunrise.boss.ui.cms.waystarmonth;

import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;
import com.sunrise.pub.tools.PublicUtils;
import com.sunrise.pub.tools.StringSplit;

public class WaystarmonthBatchCheck extends BaseCheckFormat{
	
	private static final String SLVS = "0123456";
	
	public WaystarmonthBatchCheck() {
		// TODO Auto-generated constructor stub
	}
	
	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		if (!"text/plain".equalsIgnoreCase(file.getContentType())) {
			throw new BusinessException("","Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}
	
	public void checkLine(String line, int rowCount, User user) throws Exception {
		
		String[] content = StringSplit.split(line, "|");
		WayDelegate waydelegate = new WayDelegate();
		if (content.length != 3) {
			throw new BusinessException("","�ϴ�ʧ��,�ļ���ʽ����ȷ,�����ʽ����Ϊ3��");
		}
		
		if(StringUtils.isEmpty(content[0])){
			throw new BusinessException("","�������벻��Ϊ��");
		}else{
			WayVO wayvo = waydelegate.doFindByPk(content[0], user);
			if(wayvo == null || !SessionFactoryRouter.conversionCityid(user.getCityid()).equals(wayvo.getCityid())){
				throw new BusinessException("","�������벻�Ϸ��򲻴���");
			}
		}
		
		if(StringUtils.isEmpty(content[1])){
			throw new BusinessException("","�·�(YYYYMM)����Ϊ��");
		}else{
			if(!PublicUtils.checkDateTime(1, content[1], null, null, null)){
				throw new BusinessException("","�·�(YYYYMM)ӦΪ6λ��������");
			}
		}
		
		if(StringUtils.isEmpty(content[2])){
			throw new BusinessException("","�׿���������Ϊ��");
		}else{
			if(!PublicUtils.isInteger(content[2])){
				throw new BusinessException("","�׿�����ֻ����������");
			}
		}
	}
	
}
