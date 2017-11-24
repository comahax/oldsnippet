package com.sunrise.boss.ui.cms.zjty.chzjtyterewardstd;

import java.util.HashMap;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;
import com.sunrise.boss.business.cms.common.CheckUtil;
import com.sunrise.boss.business.cms.zjty.chzjtyterewardstd.persistent.ChZjtyTerewardstdVO;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.cms.zjty.chzjtyterewardstd.ChZjtyTerewardstdDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;

public class ChZjtyTerewardstdCheck extends BaseCheckFormat {
	private String region;

	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		region = parameterMap.get("_region").toString();
		if (!"text/plain".equalsIgnoreCase(file.getContentType())) {
			throw new BusinessException("", "Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}

	public void checkLine(String line, int rowCount, User user) throws Exception {
		if (null == line || "".equals(line)) {
			return;
		} 
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		if (content.length != 7) {
			throw new Exception("�ϴ�������������,ӦΪ6��,��鿴˵������!");
		} 
		if (StringUtils.isEmpty(content[0]) || content[0].getBytes("GBK").length > 18) {
			throw new Exception("[�ն˻���]����Ϊ�գ����ҳ������Ϊ18");
		}
		if ( StringUtils.isEmpty((content[1])) || !CheckUtil.checkDoubleNum((content[1]))) {
			throw new Exception("[��׼��]����Ϊ��,����ֻ�ܴ��ڵ���0");
		}    
		if (StringUtils.isEmpty(content[2])) {
			throw new Exception("[����׼]����Ϊ�գ����ұ���Ϊ����");
		} else if (!CheckUtil.checkDouble(content[1], 16, 4)) {
			throw new Exception("[����׼]����Ϊ���֣������������ֲ��ܳ���12λ,С�����ֲ��ܳ���4λ");
		}
		if (StringUtils.isEmpty(content[3])) {
			throw new Exception("[�������]����Ϊ�գ����ұ���Ϊ����");
		} else if (!content[3].trim().matches("(1|2|3|4|5|6|11|12|13|14)")) {
			throw new Exception("[�������]����Ϊ����,Ӧ��Ϊ1��2��3��4��5��6��11��12��13|14�е�һ����ֵ");
		}
		if (StringUtils.isEmpty(content[4])) {
			throw new Exception("[�Ƴ�����]����Ϊ�գ����ұ���Ϊ����");
		} else if (!content[4].trim().matches("[1-2]")) {
			throw new Exception("[�Ƴ�����]����Ϊ����,�ҳ��Ȳ��ܴ���3");
		}
		if (StringUtils.isNotEmpty(content[5]) && content[5].getBytes("GBK").length > 128) {
			throw new Exception("[��ע]�������Ϊ128");
		}
		
		ChZjtyTerewardstdVO newVo = new ChZjtyTerewardstdVO();
		newVo.setComid(content[0].trim());
		newVo.setRewardtype(Short.parseShort(content[3].trim()));
		if (region.equals("999")) {
			newVo.setCitycode(Short.parseShort("999"));
		} else {
			newVo.setCitycode(Short.parseShort(user.getCityid()));
		}
		ChZjtyTerewardstdDelegate delegate = new ChZjtyTerewardstdDelegate();
		ChZjtyTerewardstdVO vo = delegate.doFindByPk(newVo, user);
		if (vo != null) {
			throw new Exception("ͬ���ն˻��͡�ͬ����������Ѵ�����ͬ��¼!");
		}
	}

}
