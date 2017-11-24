package com.sunrise.boss.ui.cms.chadtsales;

import java.util.HashMap;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;
import com.sunrise.boss.business.cms.common.CheckUtil;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;

public class ChAdtSalesCheck extends BaseCheckFormat {

	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		if (!"text/plain".equalsIgnoreCase(file.getContentType())) {
			throw new BusinessException("", "Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}

	@Override
	public void checkLine(String line, int rowCount, User user) throws Exception {
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");

		if (content.length != 5) {
			throw new Exception("�ϴ�������������,ӦΪ4��,��鿴˵������!");
		}
		if(StringUtils.isEmpty(content[0])){
			throw new BusinessException("","[ҵ�����]����Ϊ��");
		}
		if(StringUtils.isEmpty(content[1])){
			throw new BusinessException("","[����������������]����Ϊ��");
		}
		if(StringUtils.isEmpty(content[2])){
			throw new BusinessException("","[����]����Ϊ��");
		}
		if(StringUtils.isEmpty(content[3])){
			throw new BusinessException("","[����׼]����Ϊ��");
		}


		for (int i = 0; i < content.length - 1; i++) {
			switch (i) {
			case 0:
				if (!CheckUtil.checkString(content[i], 18, true)) {
					throw new Exception("[ҵ�����]���ܴ���18λ");
				}
				break;
			case 1:
				if (!CheckUtil.checkString(content[i], 2, true)) {
					throw new Exception("[����������������]���ܴ���2λ");
				}
				break;
			case 2:
				if (!CheckUtil.checkNum(content[i], 10)) {
					throw new Exception("[����]ӦΪ������С��11λ");
				}
				break;
			case 3:
				if (!CheckUtil.checkDouble(content[i], 16, 4)) {
					throw new Exception("[����׼]�������ֲ��ܳ���16λ,С�����ֲ��ܳ���4λ");
				}
				break;
			}
		}
	}

}
