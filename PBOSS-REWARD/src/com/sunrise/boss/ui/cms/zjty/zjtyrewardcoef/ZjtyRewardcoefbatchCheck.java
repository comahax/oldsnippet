package com.sunrise.boss.ui.cms.zjty.zjtyrewardcoef;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;
import com.sunrise.pub.tools.StringSplit;

public class ZjtyRewardcoefbatchCheck extends BaseCheckFormat {

	protected static String[] rewardasstype = new String[] { "0", "1", "2", "3" };

	public ZjtyRewardcoefbatchCheck() {
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

		if (content.length == 3 || content.length == 5) {
			;
		} else {
			throw new BusinessException("", "����������.����Ӧ��3�����5��");
		}

		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
		if (StringUtils.isEmpty(content[0]) || content[0].length() > 6) {
			throw new BusinessException("", "�����²���Ϊ���ҳ��Ȳ��ܳ���6λ");
		}
		try {
			format.parse(content[0]);
		} catch (Exception e) {
			throw new BusinessException("", "�����¸�ʽ����ȷ����ȷ�ĸ�ʽӦ��ΪYYYYMM");
		}

		if (StringUtils.isEmpty(content[1])
				|| !NumberUtils.isNumber(content[1])) {
			throw new BusinessException("", "���ϵ������Ϊ�ղ��ұ���Ϊ����");
		}
		if (StringUtils.isEmpty(content[1])
				|| !Arrays.asList(rewardasstype).contains(content[1])) {
			throw new BusinessException("", "���ϵ������Ϊ�ջ��߲���������");
		}

		if (StringUtils.isEmpty(content[2])) {
			throw new BusinessException("", "�������벻��Ϊ��");
		}
		WayVO wayvo = waydelegate.doFindByPk(content[2], user);
		if (wayvo == null) {
			throw new BusinessException("", "�������벻����");
		}

		if (content.length == 5) {
			if (StringUtils.isEmpty(content[3])
					|| !NumberUtils.isNumber(content[3])) {
				throw new BusinessException("", "����ϵ������Ϊ�ղ��ұ���Ϊ����");
			}
			if (content[3].substring(content[3].indexOf('.') + 1).length() > 2) {
				throw new BusinessException("", "����ϵ��������Χ,ֻ֧�ֵ�С�������λ");
			}

			// if(StringUtils.isEmpty(content[4])){
			// throw new BusinessException("","���˽������Ϊ��");
			// }
		}

		// Double double1=new Double(content[3]);
		// if(double1.doubleValue()<0.0000 || double1.doubleValue()>2){
		// throw new BusinessException("","����ϵ����ʽ����Ϊ0.00~2.00");
		//		}
	}
}
