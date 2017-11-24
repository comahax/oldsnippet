package com.sunrise.boss.ui.zifee.minconsume;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.cms.common.CheckUtil;
import com.sunrise.boss.business.cms.operation.persistent.OperationVO;
import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.business.zifee.yxplan.persistent.YxPlanVO;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.cms.operation.OperationDelegate;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;
import com.sunrise.boss.delegate.zifee.minconsume.MinconsumeDelegate;
import com.sunrise.boss.delegate.zifee.yxplan.YxPlanDelegate;

public class BatchMinconsumeCheck extends BaseCheckFormat {
	private MinconsumeDelegate minconsumeDelegate;

	private final String fixFields[] = { "Ӫ��������ʶ", "��Чʱ����", "������ѿ�Խ����",
			"�������������", "���������Ч����", "������Ѷ�" };

	private int batchaction = 0;

	private String resultStr = "";

	public BatchMinconsumeCheck() {
		super();
	}

	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		this.batchaction = Integer.parseInt(parameterMap.get("batchaction")
				.toString());
		if (!file.getContentType().equals("text/plain")) {
			throw new Exception("Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}

	private MinconsumeDelegate getMinconsumeDelegate() throws Exception {
		if (minconsumeDelegate == null) {
			return new MinconsumeDelegate();
		} else {
			return minconsumeDelegate;
		}
	}

	public void checkLine(String line, int rowCount, User user)
			throws Exception {
		if (rowCount > 50000) {
			throw new Exception("�ļ��������ܳ���50000��");
		}
		if (null == line || "".equals(line)) {
			return;
		}
		try {
			String[] items = StringUtils.splitPreserveAllTokens(line, "|");
			// �������
			if (items.length != 6 && batchaction ==0) {
				throw new Exception("�ϴ�������������,ӦΪ6��,��鿴˵������!");
			}
			String[] columns = { "[Ӫ��������ʶ]", "[��Чʱ����]", "[������ѿ�Խ����]",
					"[�������������]", "[���������Ч����]", "[������Ѷ�]" };
			if(!CheckUtil.checkNum(items[0],14))
			{
				throw new Exception("Ӫ��������ʶΪ������14λ���ȵ����ֲ��Ҳ���Ϊ��:"+items[0]);
			}
			String areacode=new YxPlanDelegate().getAreacode(new Long(StringUtils.trim(items[0])), user);
			if(areacode==null)
			{
				throw new Exception("Ӫ��������ʶ�������в�����!"+items[0]);
			}
			if (user.isProvinceUser() && StringUtils.isNotBlank(items[0])) {
				if (!"999".equals(areacode)
						&& !"100".equals(areacode)) {
					throw new Exception("ʡ������ֻ�ܲ���ʡ��Ӫ������! ������Ϣ:<font color=red>"
							+ items[0] + "<font>");
				}
			} else if (!user.isProvinceUser()
					&& StringUtils.isNotBlank(items[0])) {
				if (!areacode.equals(user.getCityid())) {
					throw new Exception(
							"�õ�¼�û�ֻ�ܲ���������Ӫ������! ������Ϣ:<font color=red>"
									+ items[0] + "<font>");
				}
			}
			if (batchaction == 0) {
				for (int i = 0; i <= items.length - 1; i++) {
					if ("".equals(items[i].trim()) || items[i] == null) {
						throw new Exception(columns[i] + "����Ϊ��");
					}
				}
				checkNewVO(items,user);
			} else if (batchaction == 1) {
				checkUpdateVO(items,user);
			} else if (batchaction == 2) {
				if (rowCount == 1) {
					CheckUtil.checkHead(items, fixFields, user);
				} else {
					items = CheckUtil.checkLines(items, user);
					checkUpdateVO(items,user);
				}
			}
		} catch (Exception ex) {
			throw new Exception(ex.getMessage());
		}
	}

	private void checkNewVO(String[] items,User user) throws Exception {
		if (!CheckUtil.checkNum(items[0], 18)) {
			throw new Exception("[Ӫ��������ʶ]����Ϊ�ջ���18λ,����ֻ��Ϊ����!");
		}else
		{
			//�ж�[Ӫ��������ʶ]��ϵͳ���Ƿ����
			checkYxplnaid(StringUtils.trim(items[0]),user);
		}
		if (!CheckUtil.checkNum(items[1], 8)) {
			throw new Exception("[��Чʱ����]����Ϊ�ջ���8λ����ֻ��Ϊ����!");
		}
		if (!CheckUtil.checkNum(items[2], 14)) {
			throw new Exception("[������ѿ�Խ����]����Ϊ�ջ���14λ����ֻ��Ϊ����!");
		}else if(new Long(items[2].trim()).longValue()-1<0)
		{
			throw new Exception("[������ѿ�Խ����]Ϊ���ڵ���1������");
		}
		if (!CheckUtil.checkNum(items[3], 8)) {
			throw new Exception("[�������������]����Ϊ�ջ���8λ����ֻ��Ϊ����!");
		}else if(new Long(items[3].trim()).longValue()-1<0 && items[3].trim()!="-1")
		{
			throw new Exception("[�������������]Ϊ���ڵ���1������");
		}
		if (!CheckUtil.checkString(items[4], 32)) {
			throw new Exception("[���������Ч����]����Ϊ�ջ���32λ!");
		}
		if(StringUtils.isNotBlank(items[4]))
		{
			if(!CheckUtil.getInstance().checkDictitem("PC_CONSUMEEFFECTIVETYPE", items[4].trim(), user))
			{
				throw new Exception("[���������Ч����]�̶�����ֵ����ȷ,��ο�'z'��'x'");
			}
		}
		if (!CheckUtil.checkNum(items[5], 8)) {
			throw new Exception("[������Ѷ�]����Ϊ�ջ���8λ����ֻ��Ϊ����!");
		}else if(new Long(items[5].trim()).longValue()<0)
		{
			throw new Exception("[������Ѷ�]Ϊ���ڵ���0������");
		}
	}

	private void checkUpdateVO(String[] items,User user) throws Exception {
		if (!CheckUtil.checkNum(items[0], 18)) {
			throw new Exception("[Ӫ��������ʶ]����Ϊ�ջ���18λ����ֻ��Ϊ����!");
		}else
		{
			checkYxplnaid(CheckUtil.dealString(items[0]),user);
		}
		if (!CheckUtil.checkNum(items[1], 8)) {
			throw new Exception("[��Чʱ����]����Ϊ�ջ���8λ����ֻ��Ϊ����!");
		}
		if (!CheckUtil.checkNum(items[2], 14, true)) {
			throw new Exception("[������ѿ�Խ����]���ܳ���14λ����ֻ��Ϊ����!");
		}
		if (!CheckUtil.checkNum(items[3], 8, true)) {
			throw new Exception("[�������������]���ܳ���8λ����ֻ��Ϊ����!");
		}
		if (!CheckUtil.checkString(items[4], 32, true)) {
			throw new Exception("[���������Ч����]���ܳ���32λ!");
		}
		if(StringUtils.isNotBlank(items[4]))
		{
			if(!CheckUtil.getInstance().checkDictitem("PC_CONSUMEEFFECTIVETYPE", items[4], user))
			{
				throw new Exception("[���������Ч����]�̶�����ֵ����ȷ,��ο�'z'��'x'");
			}
		}
		if (!CheckUtil.checkNum(items[5], 8, true)) {
			throw new Exception("[������Ѷ�]���ܳ���8λ����ֻ��Ϊ����!");
		}
	}
	private void checkYxplnaid(String yxplanid,User user)throws Exception
	{
		if(CheckUtil.isEmpty(yxplanid))
		{
			throw new Exception("yxplanidΪ��!");
		}
		YxPlanVO vo=new YxPlanDelegate().doFindByPk(CheckUtil.setLong(yxplanid),user);
		if(vo==null)
		{
			throw new Exception("yxplanid:"+yxplanid+"��ϵͳ�в�����!");
		}
		if (vo != null
				&& !StringUtils.equals(vo.getAreacode(), user.getCityid())) {
			throw new Exception("yxplanid:" + yxplanid + "��ϵͳ�ж�Ӧ��CITYID:"
					+ vo.getAreacode() + "�뵱ǰ���ŵ�½��CITYID:" + user.getCityid()
					+ "��һ��!");
		}
	}
}
