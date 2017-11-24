package com.gmcc.pboss.web.channel.way;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.base.dictitem.DictitemDBParam;
import com.gmcc.pboss.business.channel.bchcontact.BchcontactVO;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.channel.wayaccount.WayaccountDBParam;
import com.gmcc.pboss.business.channel.wayaccount.WayaccountVO;
import com.gmcc.pboss.business.channel.waycompact.WaycompactVO;
import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.gmcc.pboss.common.utils.tools.CheckUtil;
import com.gmcc.pboss.control.base.dictitem.Dictitem;
import com.gmcc.pboss.control.base.dictitem.DictitemBO;
import com.gmcc.pboss.control.channel.bchcontact.Bchcontact;
import com.gmcc.pboss.control.channel.bchcontact.BchcontactBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.channel.wayaccount.Wayaccount;
import com.gmcc.pboss.control.channel.wayaccount.WayaccountBO;
import com.gmcc.pboss.control.channel.waycompact.Waycompact;
import com.gmcc.pboss.control.channel.waycompact.WaycompactBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

public class LogiswayCheck extends BaseCheckFormat {

	private Way delegate;

	private Bchcontact bchdelegate;

	private Waycompact comdelegate;

	private Wayaccount accdelegate;
	
	

	public void checkFile(File file, HashMap parameterMap, String contentType)
	throws Exception {
	if (!"text/plain".equalsIgnoreCase(contentType)) {
		throw new Exception("Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
	}
}
	
	
	public void checkLine(String line, int rowCount, User user)
	throws Exception {
// TODO Auto-generated method stub
		delegate = (WayBO) BOFactory.build(WayBO.class,user);
		bchdelegate = (BchcontactBO) BOFactory.build(BchcontactBO.class, user);
		comdelegate = (WaycompactBO) BOFactory.build(WaycompactBO.class, user);
		accdelegate = (WayaccountBO) BOFactory.build(WayaccountBO.class,user);
		if (null == line || "".equals(line)) {
			return;
		}

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String[] items = StringUtils.splitPreserveAllTokens(line, "|");
		for (int i = 0; i < items.length; i++) {
			items[i] = items[i] == null ? "" : items[i].trim();
		}
		// �������
		if (items.length != 16) {
			throw new Exception("�ϴ�������������,ӦΪ15��");
		}
		WayVO wayVO = new WayVO();
		BchcontactVO bchcontactVO = new BchcontactVO();
		WaycompactVO waycompactVO = new WaycompactVO();
		WayaccountVO wayaccountVO = new WayaccountVO();
		// ��������0
		String regex="^[a-zA-Z][a-zA-z0-9-]{0,18}$";
		if (StringUtils.isBlank(items[0]) || !items[0].matches(regex)) {
			throw new Exception("���������ʽ����ȷ�򳤶ȳ�����ȷ��ΧΪ1~18");
		}
		wayVO.setWayid(items[0]);
		bchcontactVO.setWayid(items[0]);
		waycompactVO.setWayid(items[0]);
		wayaccountVO.setWayid(items[0]);

		wayVO = delegate.doFindByPk(wayVO.getWayid());
		
		WayVO uppvo=null;
		if(StringUtils.isNotBlank(items[2]))
		{
			uppvo=delegate.doFindByPk(items[2].trim());
		if(uppvo==null)
		{
			throw new Exception("�ϼ���������"+items[2]+"������");
		}
		}
		if (wayVO == null) {
			// ��������1
			// ��������1
			if (StringUtils.isEmpty(items[1])
					|| items[1].getBytes().length >256) {
				throw new Exception("�������Ʋ���Ϊ���ҳ��Ȳ��ܴ���256");
			}

			// �ϼ���������2
			if (items[2].getBytes().length>18 || "".equals(items[2])) {
				throw new Exception("�ϼ����������ʽ������ȷ���ȷ�ΧΪ1~18");
			}
			
			// ������3
			if (!items[3].matches("\\d{0,2}")) {
				throw new Exception("������������ȷΪ0-2λ����");
			}

			// ���й�˾4
			if (items[4].getBytes().length > 14) {
				throw new Exception("���й�˾���Ȳ��ܴ���14");
			}
			// �ֹ�˾5
			if (items[5].getBytes().length > 14) {
				throw new Exception("�ֹ�˾���Ȳ��ܴ���14");
			}

			// ������������6
			if (items[6].getBytes().length > 14) {
				throw new Exception("�����������ĳ��Ȳ��ܴ���14");
			}

			// ΢����7
			if (items[7].getBytes().length > 14) {
				throw new Exception("΢���򳤶Ȳ��ܴ���14");
			}

			// ��������8
			if (items[8].getBytes().length > 18) {
				throw new Exception("�����������Ȳ��ܴ���18");
			}

			// ����ֵ11
			if (!StringUtils.isEmpty(items[9])) {
				int i = items[9].indexOf(".");
				String flatitude = items[9].substring(0, i);
				String blatitude = items[9].substring(i + 1);
				if (!items[9].matches("[\\d.\\d]{1,10}")
						|| flatitude.length() != 3
						|| Double.valueOf(items[9]).doubleValue() <= 100
						|| Double.valueOf(items[9]).doubleValue() >= 130) {
					throw new Exception(
							"���ȸ�ʽ����ֵ��Χ���ԣ�����Ϊ100��130֮�䣬������Ϊ3λ��С��Ϊ6λ��");
				}
			} else {
				throw new Exception("���ȸ�ʽ����ֵ��Χ���ԣ�����Ϊ100��130֮�䣬������Ϊ3λ��С��Ϊ6λ��");
			}

			// γ��ֵ12
			if (!StringUtils.isEmpty(items[10])) {
				int i = items[10].indexOf(".");
				String flongtitude = items[10].substring(0, i);
				String blongtitude = items[10].substring(i + 1);
				if (!items[10].matches("[\\d.\\d]{1,9}")
						|| flongtitude.length() != 2
						|| blongtitude.length() != 6
						|| Double.valueOf(items[10]).doubleValue() <= 18
						|| Double.valueOf(items[10]).doubleValue() >= 26) {
					throw new Exception("γ�ȸ�ʽ����ֵ��Χ���ԣ�����Ϊ18��26֮�䣬������Ϊ2λ��С��Ϊ6λ��");
				}
			} else {
				throw new Exception("γ�ȸ�ʽ����ֵ��Χ���ԣ�����Ϊ18��26֮�䣬������Ϊ2λ��С��Ϊ6λ��");
			}

			// ��ϸ��ַ9
			if (items[11].getBytes().length > 128) {
				throw new Exception("��ϸ��ַ���Ȳ��ܴ���128");
			}
		} else {
			// ��������1
			if (!StringUtils.isEmpty(items[1])
					&& items[1].getBytes().length > 256) {
				throw new Exception("�������Ʋ���Ϊ���ҳ��Ȳ��ܴ���256");
			}

			// �ϼ���������2
			if (!CheckUtil.checkString(items[2], 18, false)) {
				throw new Exception("�ϼ��������볤�ȳ�����ȷ��ΧΪ1~18");
			}

			// ������3
			if (!items[3].matches("\\d{0,2}")) {
				throw new Exception("������������ȷΪ0-2λ����");
			}

			// ���й�˾4
			if (items[4].getBytes().length > 14) {
				throw new Exception("���й�˾���Ȳ��ܴ���14");
			}

			// �ֹ�˾5
			if (items[5].getBytes().length > 14) {
				throw new Exception("�ֹ�˾���Ȳ��ܴ���14");
			}

			// ������������6
			if (items[6].getBytes().length > 14) {
				throw new Exception("�����������ĳ��Ȳ��ܴ���14");
			}

			// ΢����7
			if (items[7].getBytes().length > 14) {
				throw new Exception("΢���򳤶Ȳ��ܴ���14");
			}

			// ��������8
			if (items[8].getBytes().length > 18) {
				throw new Exception("�����������Ȳ��ܴ���18");
			}

			// ����ֵ11
			if (!StringUtils.isEmpty(items[9])) {
				int i = items[9].indexOf(".");
				String flatitude = items[9].substring(0, i);
				String blatitude = items[9].substring(i + 1);
				if (!items[9].matches("[\\d.\\d]{1,10}")
						|| flatitude.length() != 3
						|| Double.valueOf(items[9]).doubleValue() <= 100
						|| Double.valueOf(items[9]).doubleValue() >= 130) {
					throw new Exception(
							"���ȸ�ʽ����ֵ��Χ���ԣ�����Ϊ100��130֮�䣬������Ϊ3λ��С��Ϊ6λ��");
				}
			}

			// γ��ֵ12
			if (!StringUtils.isEmpty(items[10])) {
				int i = items[10].indexOf(".");
				String flongtitude = items[10].substring(0, i);
				String blongtitude = items[10].substring(i + 1);
				if (!items[10].matches("[\\d.\\d]{1,9}")
						|| flongtitude.length() != 2
						|| blongtitude.length() != 6
						|| Double.valueOf(items[10]).doubleValue() <= 18
						|| Double.valueOf(items[10]).doubleValue() >= 26) {
					throw new Exception("γ�ȸ�ʽ����ֵ��Χ���ԣ�����Ϊ18��26֮�䣬������Ϊ2λ��С��Ϊ6λ��");
				}
			}

			// ��ϸ��ַ9
			if (items[11].getBytes().length > 128) {
				throw new Exception("��ϸ��ַ���Ȳ��ܴ���128");
			}
		}

		//  -------------------- ����ch_pw_employee�����Ϣ  -----------------------
		if (!StringUtils.isEmpty(items[12])
				&& items[12].getBytes().length > 64) {
			throw new Exception("�������������Ȳ���Ϊ���Ҳ��ܴ���64");
		}

		// ��������ϵ�绰13
		if (!StringUtils.isEmpty(items[13])
				&& items[13].getBytes().length > 20) {
			throw new Exception("��������ϵ�绰��ʽ�����Ҳ���Ϊ��");
		}

		// �����˵�������14
		if (!StringUtils.isEmpty(items[14])
				&& !items[14]
						.matches("[_a-zA-Z\\d\\-\\.]+@[_a-zA-Z\\d\\-]+(\\.[_a-zA-Z\\d\\-]+)+")) {
			throw new Exception("�����˵��������ʽ����");
		}


	}

	// ��龭Ӫ�������ͱ���
	public void checkJYQY(String item, User user) throws Exception {
		if ("".equals(item)) {
			return;
		}
		Dictitem delegate = (DictitemBO) BOFactory.build(DictitemBO.class,user);
		DictitemDBParam listVO = new DictitemDBParam();
		listVO.set_se_groupid("CH_ORGTYPE");
		listVO.set_se_dictid(item);
		if (delegate.doQuery(listVO).getRowCount() <= 0) {
			throw new Exception("�̶�����[�������ͱ���]��ֵ����ȷ");
		}

}

}
