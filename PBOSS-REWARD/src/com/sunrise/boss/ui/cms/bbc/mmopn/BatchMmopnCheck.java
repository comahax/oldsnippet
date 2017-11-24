package com.sunrise.boss.ui.cms.bbc.mmopn;

import java.text.SimpleDateFormat;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.cms.common.CheckUtil;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;

public class BatchMmopnCheck extends BaseCheckFormat {

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public BatchMmopnCheck() {
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
		if (items.length != 13) {
			throw new Exception("�ϴ�������������,ӦΪ12��,��鿴˵������!");
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
		if (!CheckUtil.checkNum(items[4], 3, false)) {
			throw new Exception("[�Ƴ귽ʽ]���Ȳ��ܳ���3λ����Ϊ�����Ҳ���Ϊ��");
		}
		if(!CheckUtil.getInstance().checkDictitem("CH_ACCTYPE", items[4].trim(), user))
		{
			throw new Exception("�̶�����[�Ƴ귽ʽ]��ֵ����ȷ");
		}
		if (!CheckUtil.checkDouble(items[5], 10, 4)) {
			throw new Exception("[����׼]�������ֲ��ܳ���10λ,С�����ֲ��ܳ���4λ,�Ҳ���Ϊ��");
		}
		if("2".equals(items[4].trim()))
		{
			double rewardstd=new Double(items[5].trim()).doubleValue();
			if(rewardstd<=0 || rewardstd>1)
			{
				throw new Exception("[�Ƴ귽ʽ]Ϊ����������ʱ,[����׼]������0��1֮��");
			}
		}
		if (!CheckUtil.checkNum(items[6], 1, false)) {
			throw new Exception("[��Ч״̬]���Ȳ��ܳ���1λ,����Ϊ�����Ҳ���Ϊ��");
		}
		if(!"0".equals(items[6].trim()) && !"1".equals(items[6].trim()))
		{
			throw new Exception("�̶�����[��Ч״̬]��ֵ����ȷ");
		}
		if (!CheckUtil.checkNum(items[7], 2, true)) {
			throw new Exception("[����ƽ̨]���Ȳ��ܳ���2λ�ұ���������");
		}
		if(!CheckUtil.getInstance().checkDictitem("CH_MMOSSRC", items[7].trim(), user))
		{
			throw new Exception("�̶�����[����ƽ̨]��ֵ����ȷ");
		}
		if (!CheckUtil.checkString(items[8], 12, false)) {
			throw new Exception("[����]���Ȳ��ܳ���12λ�Ҳ���Ϊ��");
		}
		if (!CheckUtil.checkString(items[9], 128, true)) {
			throw new Exception("[WAPӦ��URL]���Ȳ��ܳ���128λ");
		}
		if (!CheckUtil.checkString(items[10], 512, true)) {
			throw new Exception("[ҵ����]���Ȳ��ܳ���512λ");
		}
		if (!CheckUtil.checkString(items[11], 256, true)) {
			throw new Exception("[ҵ���ʷ�]���Ȳ��ܳ���256λ");
		}
	}
}
