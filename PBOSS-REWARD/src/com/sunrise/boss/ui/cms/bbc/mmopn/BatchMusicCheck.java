package com.sunrise.boss.ui.cms.bbc.mmopn;

import java.text.SimpleDateFormat;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.cms.common.CheckUtil;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;

public class BatchMusicCheck extends BaseCheckFormat {

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public BatchMusicCheck() {
		super();
	}

	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		if (!file.getContentType().equals("text/plain")) {
			throw new BusinessException("",
					"Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}

	public void checkLine(String line, int rowCount, User user)
			throws Exception {
		if (rowCount > 10000) {
			throw new Exception("�ļ��������ܳ���10000��");
		}
		if (null == line || "".equals(line)) {
			return;
		}
		String[] items = StringUtils.splitPreserveAllTokens(line, "|");

		// �������
		if (items.length != 10) {
			throw new Exception("�ϴ�������������,ӦΪ9��,��鿴˵������!");
		}
		if (!CheckUtil.checkString(items[0], 18, false)) {
			throw new Exception("[ҵ�����]���Ȳ��ܳ���18λ�Ҳ���Ϊ��");
		}
		if (!CheckUtil.checkString(items[1], 22, false)) {
			throw new Exception("[ҵ������]���Ȳ��ܳ���22λ�Ҳ���Ϊ��");
		}
		if (!CheckUtil.checkString(items[2], 6, false)) {
			throw new Exception("[��ҵ����]���Ȳ��ܳ���6λ�Ҳ���Ϊ��");
		}
		if (!CheckUtil.checkString(items[3], 10, false)) {
			throw new Exception("[�Ʒ�ҵ�����]���Ȳ��ܳ���10λ�Ҳ���Ϊ��");
		}
		if (!CheckUtil.checkDouble(items[4], 10, 4)) {
			throw new Exception("[����׼]�������ֲ��ܳ���10λ,С�����ֲ��ܳ���4λ,�Ҳ���Ϊ��");
		}
		if (!CheckUtil.checkNum(items[5], 1, false)) {
			throw new Exception("[��Ч״̬]���Ȳ��ܳ���1λ,����Ϊ�����Ҳ���Ϊ��");
		}
		if(!"0".equals(items[5].trim()) && !"1".equals(items[5].trim()))
		{
			throw new Exception("�̶�����[��Ч״̬]��ֵ����ȷ");
		}
		if (!CheckUtil.checkString(items[6], 12, false)) {
			throw new Exception("[����]���Ȳ��ܳ���12λ�Ҳ���Ϊ��");
		}
		if (!CheckUtil.checkString(items[7], 128, true)) {
			throw new Exception("[WAPӦ��URL]���Ȳ��ܳ���128λ");
		}
		if (!CheckUtil.checkString(items[8], 512, true)) {
			throw new Exception("[ҵ����]���Ȳ��ܳ���512λ");
		}
	}
}
