package com.sunrise.boss.ui.zifee.yxplan;

import java.text.SimpleDateFormat;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.admin.dictitem.persistent.DictitemListVO;
import com.sunrise.boss.business.cms.common.CheckUtil;
import com.sunrise.boss.delegate.admin.dictitem.DictitemDelegate;
import com.sunrise.boss.delegate.zifee.yxplan.YxPlanDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;

public class YxplanCheck extends BaseCheckFormat {

	public YxplanCheck() {
		super();
	}

	public void checkFile(FormFile file, HashMap parameterMap) throws Exception {
		if (!file.getContentType().equals("text/plain")) {
			throw new Exception("Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}

	/**
	 * �ļ��е����ݼ��
	 */
	public void checkLine(String line, int rowCount, boolean iscustom, User user)
			throws Exception {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (rowCount > 10000) {
			throw new Exception("�ļ��������ܳ���10000��");
		}
		if (null == line || "".equals(line)) {
			return;
		}
		String[] fields = StringUtils.splitPreserveAllTokens(line, "|");
		// �������
		if (fields.length != 36 && !iscustom) {
			throw new Exception("�ϴ�������������,ӦΪ36��,��鿴˵������!");
		}
		String startime="";
		// ���ֶ���һ���м��
		for (int i = 0; i < fields.length; i++) {
			switch (i) {

			// Ӫ��������ʶ0
			case 0:
				
				if (!fields[i].trim().matches("[0-9]{14}")) {
					throw new Exception("[Ӫ��������ʶ]��������Ϊ14λ����: "+fields[i]);
				}
				String areacode=new YxPlanDelegate().getAreacode(new Long(StringUtils.trim(fields[0])), user);
				if(areacode!=null)
				{
				if (user.isProvinceUser()) {
						if (!"999".equals(areacode) && !"100".equals(areacode)) {
							throw new Exception("ʡ������ֻ�ܲ���ʡ��Ӫ������! ������Ϣ:"
									+ fields[0]);
						}
					} else if (!user.isProvinceUser()) {
						if (!areacode.equals(user.getCityid())) {
							throw new Exception("�õ�¼�û�ֻ�ܲ���������Ӫ������! ������Ϣ:"
									+ fields[0]);
						}
					}
				}
				break;
			// Ӫ����������1
			case 1:
				if (!iscustom) {
					if (fields[i].trim().length() < 1
							|| fields[i].trim().length() > 128) {
						throw new Exception("[Ӫ����������]���Ȳ�����Ҫ�󣬷�ΧӦ����(1~128)");
					}
				} else {
					if (!(fields[i] == null || "".equals(fields[i].trim()))) {
						if (fields[i].trim().length() < 1
								|| fields[i].trim().length() > 128) {
							throw new Exception("[Ӫ����������]���Ȳ�����Ҫ�󣬷�ΧӦ����(1~128)");
						}
					}
				}
				break;
			// ȫʡ��ʶ2
			case 2:
				if (!fields[i].trim().equals("")
						&& !fields[i]
								.matches("^([a-z|A-Z]{2})([01]{4})([012]{1})(20\\d{2}(0[0-9]{1}|1[012]{1})(0[0-9]{1}|[12]{1}\\d{1}|3[01]{1}))(\\d{3})(\\d{6})(\\d{2})$")) {
					throw new Exception("ȫʡ��ʶ����������Ҫ�󣬾�����ο������ļ�");
				}
				break;

			// ��������3
			case 3:
				if (!iscustom) {
					try {
						format.parse(fields[i].trim());
					} catch (Exception e) {
						throw new Exception(
								"[��������]��ʽ���ԣ���ȷ��ʽΪ[yyyy-MM-dd HH:mm:ss]");
					}
				} else {
					if (!(fields[i] == null || "".equals(fields[i].trim()))) {
						try {
							format.parse(fields[i].trim());
						} catch (Exception e) {
							throw new Exception(
									"[��������]��ʽ���ԣ���ȷ��ʽΪ[yyyy-MM-dd HH:mm:ss]");
						}
					}
				}
				startime=fields[i].trim();
				break;

			// ͣ������4
			case 4:
				if (!iscustom) {
					try {
						format.parse(fields[i].trim());
					} catch (Exception e) {
						throw new Exception(
								"[ͣ������]��ʽ���ԣ���ȷ��ʽΪ[yyyy-MM-dd HH:mm:ss]");
					}

				} else {
					if (!(fields[i] == null || "".equals(fields[i].trim()))) {
						try {
							format.parse(fields[i].trim());
						} catch (Exception e) {
							throw new Exception(
									"[ͣ������]��ʽ���ԣ���ȷ��ʽΪ[yyyy-MM-dd HH:mm:ss]");
						}
					}
				}
				if(StringUtils.isNotEmpty(startime) && StringUtils.isNotEmpty(fields[i])){
					if(format.parse(fields[i].trim()).getTime()<format.parse(startime).getTime()){
						throw new Exception("[ͣ������]����С��[��������]");
					}
				}
				break;

			// �����ʶ5
			case 5:
				if (!iscustom) {
					if (fields[i].trim().length() > 32
							|| fields[i].trim().length() < 1) {
						throw new Exception("[�����ʶ]���Ȳ���,��ΧӦ����(1~32)");
					}
				} else {
					if (!(fields[i] == null || "".equals(fields[i].trim()))) {
						if (fields[i].trim().length() > 32
								|| fields[i].trim().length() < 1) {
							throw new Exception("[�����ʶ]���Ȳ���,��ΧӦ����(1~32)");
						}
					}
				}
				break;

			// // ������Ѷ�6
			// case 6:
			// if (!fields[i].trim().equals("")) {
			// try {
			// new Double(fields[i]);
			// } catch (Exception e) {
			// throw new Exception("[������Ѷ�]��ʽ����");
			// }
			// }
			// break;
			//
			// // ������ѿ�Խ����7
			// case 7:
			// if (!fields[i].trim().equals("")
			// && !fields[i].trim().matches("[0-9\\-]+")) {
			// throw new Exception("[������ѿ�Խ����]��ʽ����,Ӧ��Ϊ������");
			// }
			// break;

			// �Ƿ���Ҫ�����ײ�8
			case 8 - 2:
				if (!fields[i].trim().equals("") && !fields[i].trim().matches("[0-1]")) {
					throw new Exception("[�Ƿ���Ҫ�����ײ�]��ʽ����,ֻ��Ϊ����0��1");
				}
				break;

			// ������9
			case 9 - 2:
				if (!fields[i].trim().equals("")
						&& !fields[i].trim().matches("[0-9\\-]+")) {
					throw new Exception("[������]��ʽ����,Ӧ��Ϊ������");
				}
				break;

			// �Ƿ�����ԤԼ10 $PC_BOOKFLAG
			case 10 - 2:
				if (!fields[i].trim().equals("")
						&& !CheckUtil.getInstance().checkDictitem(
								"PC_BOOKFLAG", fields[i].trim(), user)) {
					throw new Exception("[�Ƿ�����ԤԼ]��ֵ:" + fields[i] + "����ȷ,����������");
				}
				break;

			// �Ƿ�Ԥ������11
			// case 11:if
			// (!fields[i].trim().equals("")&&!fields[i].trim().matches("[0-1]")){
			// result.setCode(77);
			// result.setInfo("[�Ƿ�Ԥ������]��ʽ����,ֻ��Ϊ����0��1");
			// };break;

			// �����ô���11
			case 11 - 2:
				if (!fields[i].trim().equals("")
						&& !fields[i].trim().matches("[0-9\\-]+")) {
					throw new Exception("[�����ô���]��ʽ����,ֻ��Ϊ����0��1");
				}
				break;

			// ��С�Ż�������12
			case 12 - 2:
				if (!fields[i].trim().equals("")
						&& !fields[i].trim().matches("[0-9\\-]+")) {
					throw new Exception("[��С�Ż�������]��ʽ����,Ӧ��Ϊ������");
				}
				break;

			// �Ż�����ƫ����13
			case 13 - 2:
				if (!fields[i].trim().equals("")
						&& !fields[i].trim().matches("[0-9\\-]+")) {
					throw new Exception("[�Ż�����ƫ����]��ʽ����,Ӧ��Ϊ������");
				}
				break;

			// ����ʱ�䵥Ԫ14
			case 14 - 2:
				if (fields[i].trim().length() > 32) {
					throw new Exception("[����ʱ�䵥Ԫ]���Ȳ���,��ΧӦ����0~32");
				}
				break;

			// ��Чʱ�����15
			case 15 - 2:
				if (!fields[i].trim().equals("") && !fields[i].trim().matches("[0-1]")) {

					throw new Exception("[��Чʱ�����]��ʽ����,ֻ��Ϊ����0��1");
				}
				;
				break;

			// Ӫ�����������ʶ16
			case 16 - 2:
				if (!fields[i].trim().equals("")
						&& !fields[i].trim().matches("[0-9\\-]+")) {
					throw new Exception("[Ӫ�����������ʶ]��ʽ����,Ӧ��Ϊ������");
				}
				break;

			// �Ƿ񱸷�17
			case 17 - 2:
				if (!fields[i].trim().equals("") && !fields[i].trim().matches("[0-1]")) {
					throw new Exception("[�Ƿ񱸷�]��ʽ����,ֻ��Ϊ����0��1");
				}
				break;

			// �Ƿ��ӡ������18
			case 18 - 2:
				if (!fields[i].trim().equals("") && !fields[i].trim().matches("[0-1]")) {
					throw new Exception("[�Ƿ��ӡ������]��ʽ����,ֻ��Ϊ����0��1");
				}
				break;

			// �Ƿ�����Ż�19
			case 19 - 2:
				if (!fields[i].trim().equals("") && !fields[i].trim().matches("[0-1]")) {
					throw new Exception("[�Ƿ�����Ż�]��ʽ����,ֻ��Ϊ����0��1");
				}
				break;

			// �Ƿ�Ӫҵ���Ż�20
			case 20 - 2:
				if (!fields[i].trim().equals("") && !fields[i].trim().matches("[0-1]")) {
					throw new Exception("[�Ƿ�Ӫҵ���Ż�]��ʽ����,ֻ��Ϊ����0��1");
				}
				break;

			// ͣ��״̬�Ƿ���ȡ�����22
			// case 22:if
			// (!fields[i].trim().equals("")&&!fields[i].trim().matches("[0-1]")){
			// throw new Exception("[ͣ��״̬�Ƿ���ȡ�����]��ʽ����,ֻ��Ϊ����0��1");
			// };break;

			// �Ƿ������Ա�Ż�21
			case 21 - 2:
				if (!fields[i].trim().equals("") && !fields[i].trim().matches("[0-1]")) {
					throw new Exception("[�Ƿ������Ա�Ż�]��ʽ����,ֻ��Ϊ����0��1");
				}
				break;

			// ��Դ22
			case 22 - 2:
				if (fields[i].trim().length() > 255) {
					throw new Exception("[��Դ]���Ȳ���,��ΧӦ����0~255");
				}
				break;

			// Ӫ�����23
			case 23 - 2:
				if (!fields[i].trim().equals("")
						&& !fields[i].trim().matches("[0-1]{1,2}")) {
					throw new Exception("[Ӫ�����]��ʽ���ԣ���ȷΪ����0��1�������ֵ���λ�����");
				}
				break;

			// Ӫ���������24
			case 24 - 2:
				if (fields[i].trim().length() > 32) {
					throw new Exception("[Ӫ���������]���Ȳ���,��ΧӦ����0~32");
				}
				break;

			// �ϴ���ѷ������25
			case 25 - 2:
				if (!iscustom) {
					if ("".equals(fields[i].trim())) {
						throw new Exception("[�ϴ���ѷ������]��������Ϊ��");
					}
					if (!fields[i].trim().matches("[012345]")) {
						throw new Exception(
								"[�ϴ���ѷ������]��ʽ����,Ӧ��Ϊ0��1��2��3��4��5�е�һ����ֵ");
					}
				} else {
					if (!(fields[i] == null || "".equals(fields[i].trim()))) {

						if (!fields[i].trim().matches("[012345]")) {
							throw new Exception(
									"[�ϴ���ѷ������]��ʽ����,Ӧ��Ϊ0��1��2��3��4��5�е�һ����ֵ");
						}
					}
				}
				break;

			// �Żݷ�Χ27-1
			case 26 - 2:
				if (fields[i].trim().length() > 8) {
					throw new Exception("[�Żݷ�Χ]���Ȳ���,��ΧӦ����0~8");
				}
				break;
			// 5��11������|�ײ�����|�½�۷����ȼ�|�����ֶ�
			// �ײ�����28-1
			case 27 - 2:
				if (!iscustom) {
					if (fields[i].trim().length() > 32) {
						throw new Exception("[�ײ�����]���Ȳ���,��ΧӦ����0~32");
					}
					if ("".equals(fields[i].trim())) {
						throw new Exception("[�ײ�����]����Ϊ��");
					}
				} else {
					if (!(fields[i] == null || "".equals(fields[i].trim()))) {
						if (fields[i].trim().length() > 32) {
							throw new Exception("[�ײ�����]���Ȳ���,��ΧӦ����0~32");
						}
						if ("".equals(fields[i].trim())) {
							throw new Exception("[�ײ�����]����Ϊ��");
						}
					}
				}
				break;
			// �½�۷����ȼ�29-1
			case 28 - 2:
				if (!"".equals(fields[i].trim())
						&& !fields[i].trim().matches("[12]")) {
					throw new Exception("[�½�۷����ȼ�]��ʽ����,Ӧ��Ϊ1��2");
				}
				break;
			// �̶��������ʶ30-1
			case 29 - 2:
				if (!iscustom) {
					if (fields[i].trim().length() < 9
							|| !fields[i].trim().matches("[0-1]{9}")
							|| fields[i].trim().length() > 32) {
						throw new Exception("[�̶��������ʶ]���Ȳ���,ֻ��Ϊ9λ0��1������");
					}
				} else {
					if (!(fields[i] == null || "".equals(fields[i].trim()))) {
						if (fields[i].trim().length() < 9
								|| !fields[i].trim().matches("[0-1]{9}")
								|| fields[i].trim().length() > 32) {
							throw new Exception("[�̶��������ʶ]���Ȳ���,ֻ��Ϊ9λ0��1������");
						}
					}
				}
				break;
			// ���ⷽ����־31-1 (11-22by Jeirmy)
			case 30 - 2:
				if (fields[i].trim().length() > 32) {
					throw new Exception("[���ⷽ����־]���Ȳ���,��ΧӦ����0~32");
				}
				checkFlag(fields[i].trim(), "PC_SPECIALPLAN", "����Ӫ��������־", user);
				break;
			// �����û�״̬���&�ɰ����û�״̬
			// �Ƿ��û�״̬���
			case 31 - 2:
				if (!iscustom) {
					if (!("0".equals(fields[i].trim()) || "1".equals(fields[i]
							.trim()))) {
						throw new Exception("[�Ƿ��û�״̬���]��ֵ������0(��)��1(��)");
					}
				} else {
					if (!(fields[i] == null || "".equals(fields[i].trim()))) {
						if (!("0".equals(fields[i].trim()) || "1"
								.equals(fields[i].trim()))) {
							throw new Exception("[�Ƿ��û�״̬���]��ֵ������0(��)��1(��)");
						}
					}
				}
				break;
			// �ɰ���״̬
			case 32 - 2:
				if (fields[i].trim().length() > 32) {
					throw new Exception("[�ɰ���״̬]���Ȳ���,��ΧӦ����0~128");
				}
				checkFlag(fields[i].trim(), "US", "�ɰ����û�״̬", user);
				break;

			// �ʷ�˵��32-1
			case 33 - 2:
				if (fields[i].trim().length() > 255) {
					throw new Exception("[�ʷ�˵��]���Ȳ���,��ΧӦ����0~255");
				}
				break;

			// ˵��33-1
			case 34 - 2:
				if (fields[i].trim().length() > 2000) {
					throw new Exception("[˵��]���Ȳ���,��ΧӦ����0~2000");
				}
				break;
			case 33:
				if ("".equals(fields[i].trim()) && !iscustom) {
					throw new Exception("[�Ż�����]����Ϊ��,���ȷ�ΧӦ����1~2֮��");
				} else if (fields[i].trim().getBytes().length > 2) {
					throw new Exception("[�Ż�����]���Ȳ��ܴ���2!");
				} else if (!"".equals(fields[i].trim())) {
					checkDictitem(fields[i].trim(), "PC_PRIVELGEPRO", "�Ż�����",
							user);
				}
				break;
			case 34:
				if(!"".equals(fields[i].trim()) && fields[i].trim().getBytes("GBK").length>256)
				{
					throw new Exception("[�Żݻ������]���ܳ���256λ");
				}
				break;
			case 35:
				if (!fields[i].trim().equals("")
						&& !fields[i].trim().matches("[0-9]+$")) {
					throw new Exception("[�ײ���Ч����]��ʽ����,Ӧ��Ϊ������");
				}
				break;
			}
		}
	}

	public boolean checkAmtFormat(String amt, int length) {
		amt = amt.trim();
		if (amt.indexOf(".") != -1) {
			if (amt.indexOf(".") == 0)
				return false;
			if (amt.indexOf(".") > length)
				return false;
			if ((amt.length() - amt.indexOf(".")) != 3)
				return false;
		} else {
			if (amt.length() > length)
				return false;
		}
		return true;
	}

	// ���̶����� ����Ӫ��������־,�ɰ����û�״̬��ֵ
	public void checkFlag(String item, String groupid, String name, User user)
			throws Exception {
		if (item.indexOf(",") != -1) {
			String[] itemArr = StringUtils.splitPreserveAllTokens(item, ",");
			for (int i = 0; i < itemArr.length; i++) {
				checkDictitem(itemArr[i], groupid, name, user);
			}
		} else {
			checkDictitem(item, groupid, name, user);
		}
	}

	private void checkDictitem(String str, String groupid, String name,
			User user) throws Exception {
		if ("".equals(str)) {
			return;
		}
		DictitemDelegate delegate = new DictitemDelegate();
		DictitemListVO listVO = new DictitemListVO();
		listVO.set_se_groupid(groupid);
		listVO.set_se_dictid(str);
		if (delegate.doQuery(listVO, user).getRowCount() <= 0) {
			throw new Exception("�̶�����[" + name + "]��ֵ����ȷ:" + str + "������ȷ�Ĺ̶�����");
		}
	}

	public static void main(String[] args) {
		YxplanCheck check = new YxplanCheck();
		System.out.println("123456".matches("[0-9]+$"));
	}
}
