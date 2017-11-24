package com.sunrise.boss.ui.cms.chadtwaymod;

import java.util.HashMap;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;
import com.sunrise.boss.business.cms.common.CheckUtil;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;

public class ChAdtWaymodCheck extends BaseCheckFormat {

	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		if (!"text/plain".equalsIgnoreCase(file.getContentType())) {
			throw new BusinessException("", "Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}

	@Override
	public void checkLine(String line, int rowCount, User user) throws Exception {
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");

		if (content.length != 7) {
			throw new Exception("�ϴ�������������,ӦΪ6��,��鿴˵������!");
		}
		if(StringUtils.isEmpty(content[0])){
			throw new BusinessException("","�������벻��Ϊ��");
		}
		if(StringUtils.isEmpty(content[1])){
			throw new BusinessException("","[VI����]����Ϊ��");
		}
		if(StringUtils.isEmpty(content[2])){
			throw new BusinessException("","[���]����Ϊ��");
		}
		if(StringUtils.isEmpty(content[3])){
			throw new BusinessException("","[��ͷ��棨������]����Ϊ��");
		}
		if(StringUtils.isEmpty(content[4])){
			throw new BusinessException("","[�ֻ����壨������]����Ϊ��");
		}
		if(StringUtils.isEmpty(content[5])){
			throw new BusinessException("","[���������ࣨ������]����Ϊ��");
		}

		for (int i = 0; i < content.length - 1; i++) {
			switch (i) {
			case 0:
				if (!CheckUtil.checkString(content[i], 18, true)) {
					throw new Exception("[��������]���ܴ���18λ");
				}
				break;
			case 1:
				if (!CheckUtil.checkDouble(content[i], 3, 2)) {
					throw new Exception("[VI����]�������ֲ��ܳ���3λ,С�����ֲ��ܳ���2λ");
				}
				break;
			case 2:
				if (!CheckUtil.checkDouble(content[i], 3, 2)) {
					throw new Exception("[���]�������ֲ��ܳ���3λ,С�����ֲ��ܳ���2λ");
				}
				break;
			case 3:
				if (!CheckUtil.checkDouble(content[i], 3, 2)) {
					throw new Exception("[��ͷ��棨������]�������ֲ��ܳ���3λ,С�����ֲ��ܳ���2λ");
				}
				break;
			case 4:
				if (!CheckUtil.checkDouble(content[i], 3, 2)) {
					throw new Exception("[�ֻ����壨������]�������ֲ��ܳ���3λ,С�����ֲ��ܳ���2λ");
				}
				break;
			case 5:
				if (!CheckUtil.checkDouble(content[i], 3, 2)) {
					throw new Exception("[���������ࣨ������]�������ֲ��ܳ���3λ,С�����ֲ��ܳ���2λ");
				}
				break;
			}
		}
	}

}
