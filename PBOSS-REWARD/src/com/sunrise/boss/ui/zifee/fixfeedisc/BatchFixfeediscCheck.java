package com.sunrise.boss.ui.zifee.fixfeedisc;

import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.cms.common.CheckUtil;
import com.sunrise.boss.delegate.zifee.yxplan.YxPlanDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;
import com.sunrise.pub.tools.PublicUtils;

/**
 * �̳�BaseCheckFormat����ʵ��ICheckFormat�ӿ�
 * 
 * @author yangxuehong
 */
public class BatchFixfeediscCheck extends BaseCheckFormat {
	/*
	 * �����ϴ��������ͣ�0������1�޸ġ�2ɾ����
	 */
	private int operType = 0;

	public BatchFixfeediscCheck() {
		super();
	}

	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		this.operType = Integer.parseInt(parameterMap.get("operType")
				.toString());
		if (!file.getContentType().equals("text/plain")) {
			throw new Exception("Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}

	public void checkLine(String line, int rowCount,User user) throws Exception {
		if (rowCount > 10000) {
			throw new Exception("�ļ��������ܳ���10000��");
		}
		if (null == line || "".equals(line)) {
			return;
		}
		String[] items = StringUtils.splitPreserveAllTokens(line, "|");

		/*
		 * ���ݲ�ͬ�Ĳ������ϴ��ļ�������ͬ��
		 */
		if (this.operType == 0 && items.length != 5) {
			throw new Exception("�ϴ�������������,ӦΪ5��,��鿴˵������!");
		} else if (this.operType == 1 && items.length != 6) {
			throw new Exception("�ϴ�������������,ӦΪ6��,��鿴˵������!");
		}

		isNull(items, rowCount,user);
		checkColumnsTypeAndLength(items, rowCount);
	}

	/*
	 * Ӫ��������ʶ���ʵ���Ŀ��ʶ���Żݷ�ʽ����Ϊ��
	 */
	private void isNull(String[] items, int rowCount,User user) throws Exception {
		if (StringUtils.isBlank(items[0 + this.operType]))
		{
			throw new Exception("��" + rowCount + "��Ӫ��������ʶΪ�գ�"+items[0+operType]);
		}
		else
		{
			if(!CheckUtil.checkNum(items[0+this.operType],14))
			{
				throw new Exception("Ӫ��������ʶΪ������14λ���ȵ����ֲ��Ҳ���Ϊ��:"+items[0+operType]);
			}
			String areacode=new YxPlanDelegate().getAreacode(new Long(StringUtils.trim(items[0+this.operType])), user);
			if(areacode==null)
			{
				throw new Exception("Ӫ��������ʶ�������в�����!"+items[0+operType]);
			}
			if(user.isProvinceUser())
			{
				if(!"999".equals(areacode) && !"100".equals(areacode))
				{
					throw new Exception("ʡ������ֻ�ܲ���ʡ��Ӫ������! ������Ϣ:<font color=red>"+items[0+this.operType]+"<font>");
				}
			}
			else
			{
				if(!areacode.equals(user.getCityid()))
				{
					throw new Exception("�õ�¼�û�ֻ�ܲ���������Ӫ������! ������Ϣ:<font color=red>"+items[0+this.operType]+"<font>");
				}
			}
		}
		if (StringUtils.isBlank(items[1 + this.operType]))
			throw new Exception("��" + rowCount + "���ʵ���Ŀ��ʶΪ�գ�");
		if (StringUtils.isBlank(items[2 + this.operType]))
			throw new Exception("��" + rowCount + "�Żݷ�ʽΪ�գ�");
	}

	/*
	 * �Ե�����ֶα�֤�������ݿ���Ƶ����ͺ���������󳤶�����
	 */
	private void checkColumnsTypeAndLength(String[] items, int rowCount)
			throws Exception {
		if (this.operType == 1
				&& (!PublicUtils.isInteger(items[0]) || StringUtils
						.trimToEmpty(items[0]).length() > 10))
			throw new Exception("��" + rowCount + "�й̶����Żݱ�ʶ��Ϊ����" + "�򳤶ȳ�������14��");
		if (!PublicUtils.isInteger(items[0 + this.operType])
				|| StringUtils.trimToEmpty(items[0 + this.operType]).length() > 14)
			throw new Exception("��" + rowCount + "��Ӫ��������ʶ��Ϊ����" + "�򳤶ȳ�������14��");
		if (!PublicUtils.isInteger(items[1 + this.operType])
				|| StringUtils.trimToEmpty(items[1 + this.operType]).length() > 14)
			throw new Exception("��" + rowCount + "���ʵ���Ŀ��ʶ��Ϊ����" + "�򳤶ȳ�������14��");
		if (!PublicUtils.isInteger(items[2 + this.operType])
				|| !(Integer.parseInt(StringUtils
						.trimToEmpty(items[2 + this.operType])) == 1 || Integer
						.parseInt(StringUtils
								.trimToEmpty(items[2 + this.operType])) == 0))
			throw new Exception("��" + rowCount + "���Żݷ�ʽ��Ϊ�����򳬹�����"
					+ "��ֻ��Ϊ0����1����");
		if (StringUtils.trimToEmpty(items[2 + this.operType]).equals("0")) {
			if (!PublicUtils.isDecimal(items[3 + this.operType], 2, 1))
				throw new Exception("��" + rowCount
						+ "���Żݷ�ʽΪ[�ۿ�]ʱ���ۿ۱���ΪС��������Ϊ2���Ҳ��ܴ���1��");
			double item5=-1;
			try{
			item5=Double.parseDouble(StringUtils
					.trimToEmpty(items[4 + this.operType]));
			}catch(Exception ex)
			{
				throw new Exception("[�ֽ��Ż�]����Ϊ����");
			}
			if (item5 != 0) {
				throw new Exception("��" + rowCount + "���Żݷ�ʽΪ���ۿۣ�ʱ��"
						+ "�ֽ��Żݱ���Ϊ0��");
			}
		} else {
			if (!PublicUtils.isDecimal(items[4 + this.operType], 2, 999999))
				throw new Exception("��" + rowCount
						+ "���Żݷ�ʽΪ[�ֽ�]ʱ���ֽ��Żݱ���Ϊ���ֲ��Ҳ��ܴ���999999��");
			double item4 = -1;
			try {
				item4 = Double.parseDouble(StringUtils
						.trimToEmpty(items[3 + this.operType]));
			} catch (Exception ex) {
				throw new Exception("[�ۿ�]����Ϊ����");
			}
			if (item4 != 1) {
				throw new Exception("��" + rowCount + "���Żݷ�ʽΪ[�ֽ�]ʱ��" + "�ۿ۱���Ϊ1");
			}
		}
	}
}