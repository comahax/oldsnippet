package com.gmcc.pboss.web.channel.employee;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.common.batch.upload.BaseCheckFormat;
import com.gmcc.pboss.common.utils.tools.CheckUtil;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.employee.Employee;
import com.gmcc.pboss.control.channel.employee.EmployeeBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.User;

/**
 * ���������Ա������
 * @author wefrogll
 * @version 1.0 2009-11-20
 */
public class SocietyPeopleCheck extends BaseCheckFormat{
	private String param92 = "";
	private String resultStr = "";
	private long preLineCount = 0;
	private boolean customeFlag = false;
	
	public static String[] lineHead = { "��ԱID", "���������", "����", "��������", "�Ա�",
			"���֤����", "���й�˾", "�ֹ�˾", "��������", "��ְʱ��", "�Ͷ���ϵ", "�ù�����", 
			"�ù�״̬", "�Ƿ�Ϊ����", "�ֻ���", "������������", "��֤��", "����ѡ���ֻ���" };

	public void checkFile(File file, HashMap parameterMap, String contentType)
			throws Exception {
		User user = (User) parameterMap.get("user");
		Sysparam sysparamBO = (SysparamBO)BOFactory.build(SysparamBO.class, user);
		param92 = sysparamBO.doFindByID("92", "channel");
		if (!"text/plain".equalsIgnoreCase(contentType)) {
			throw new Exception("Ҫ������ļ����Ͳ���ȷ����ϵͳֻ����ָ�����ļ���ʽ��txt�ı��ļ�!");
		}
	}
	

	public void checkLine(String line, int rowCount, User user) throws Exception {
		if (null == line || "".equals(line)) {
			return;
		}
		String[] content = StringUtils.splitPreserveAllTokens(line, "|");
		for (int i = 0; i < content.length; i++) {
			content[i] = content[i].trim();
		}
		
		if (rowCount == 1 && param92.equals("1")) {
			if (lineHead[0].equals(content[0])) {
				customeFlag = true;
				checkHead(content);
				return;
			} else {
				customeFlag = false;
			}
		}
		if (!customeFlag) {
			int length = 19;
			if (param92.equals("1")) {
				length = 20;
			}
			
			if (content.length != length) {
				throw new Exception("��" + rowCount + "��:[ " + line + " ] ,��������ȷ,��ȷ����Ϊ" + length);
			}
			if (!CheckUtil.checkString(content[1], 11, false)) {
				throw new Exception("[���������]����Ϊ1~11");
			}
			if (!CheckUtil.checkString(content[2], 30, false)) {
				throw new Exception("[����]����Ϊ1~30");
			}
			// ��������
			if (StringUtils.isNotBlank(content[3])) {
				try {
					stringToDate(content[3], "yyyy-MM-dd");
				} catch (Exception ex) {
					throw new Exception("[��������]��ʽ����ȷ");
				}
			}
			if (!CheckUtil.checkNum(content[4], 3, false)) {
				throw new Exception("[�Ա�]Ϊ����,����Ϊ1~3");
			}
			// �����֤���룧�޸�Ϊ����ҳ��ȱ���Ϊ15/18λ
			if (content[5].trim().length() != 15 && content[5].trim().length() != 18) {
				throw new Exception("[���֤����]���ȱ���Ϊ15/18λ");
			}
			if (!CheckUtil.checkString(content[8], 14, false)) {
				throw new Exception("[���й�˾]����Ϊ1~14");
			}
			if (!CheckUtil.checkString(content[9], 14, false)) {
				throw new Exception("[�ֹ�˾]����Ϊ1~14");
			}
			if (!CheckUtil.checkString(content[11], 18, false)) {
				throw new Exception("[��������]����Ϊ1~18");
			}
			if (!CheckUtil.checkString(content[12], 10, false)) {
				throw new Exception("[��ְʱ��]����Ϊ1~10");
			} else {
				try {
					stringToDate(content[12], "yyyy-MM-dd");
				} catch (Exception ex) {
					throw new Exception("[��ְʱ��]��ʽ����ȷ");
				}
			}
			if (!CheckUtil.checkNum(content[13], 3, false)) {
				throw new Exception("[�Ͷ���ϵ]Ϊ����,����Ϊ1~3");
			}
			if (!CheckUtil.checkString(content[14], 3, false)) {
				throw new Exception("[�ù�����]Ϊ����,����Ϊ1~3");
			}
			if (!CheckUtil.checkString(content[16], 3, false)) {
				throw new Exception("[�ù�״̬]Ϊ����,����Ϊ1~3");
			}
			if (param92.equals("1")) {
				if (StringUtils.isNotBlank(content[19]) && !content[19].trim().equals("0") && !content[19].trim().equals("1")) {
					throw new Exception("[�Ƿ�Ϊ����]ֻ��Ϊ0��1");
				}
			}
		} else if (rowCount > 1 && customeFlag) {
			if ("".equals(content[0])) {
				throw new Exception("�Զ��嵼����ԱID����Ϊ��");
			}
			if (preLineCount != content.length) {
				throw new Exception("�Զ��嵼�����������������ļ�ͷ��������һ��!");
			}
			int count = lineHead.length;
			String checkLine[] = new String[count];
			content = copyArr(checkLine, content);
			updatecheck(content, user);
		}
	}
	
	public Date stringToDate(String dateStr,String dateFormat) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat(dateFormat);
		return format.parse(dateStr);
	}
	
	private void checkHead(String[] content) throws Exception {
		preLineCount = content.length;
		// ��ս�����ϴμ��Ľ��
		this.resultStr = "";
		for (int i = 0; i < content.length; i++) {
			boolean find = false;
			for (int j = 0; (!find && j < lineHead.length); j++) {
				if ("".equals(content[i])) {
					throw new Exception("�Զ��嵼���ļ�ͷ�в������п�,�����û������");
				}
				if (content[i].equals(lineHead[j])) {
					resultStr = resultStr + j + "|";
					find = true;
					continue;
				}
			}
			if (!find) {
				throw new Exception("�Զ����ļ�ͷ:[" + content[i] + "]����ȷ!");
			}
		}
	}
	
	private String[] copyArr(String[] arr, String[] content) {
		String temArr[] = StringUtils.splitPreserveAllTokens(resultStr, "|");
		for (int i = 0; i < temArr.length - 1; i++) {
			int temp = new Integer(temArr[i]).intValue();
			arr[temp] = content[i];
		}
		return arr;
	}
	
	private void updatecheck(String[] content, User user) throws Exception {
		for (int i = 0; i < content.length; i++) {
			Employee delegate = (EmployeeBO) BOFactory.build(EmployeeBO.class, user);
			switch (i) {
			// ��ԱID
			case 0:
				if (delegate.doFindByPk(content[i]) == null) {
					throw new Exception("ϵͳ�����ڸ���ԱID:" + content[0] + " ����˶�");
				}
				break;
			// ���������
			case 1:
				if (content[i] != null) {
					if (content[i].getBytes("GBK").length != 11) {
						throw new Exception("[���������]���ȱ���Ϊ11λ");
					} else {
						delegate.checkOfficeTel(content[i], user);
					}
				}
				break;
			// ����
			case 2:
				if (content[i] != null && content[i].getBytes("GBK").length > 30) {
					throw new Exception("[����]���Ȳ��ܴ���30λ");
				}
				break;
			// ��������
			case 3:
				if (content[i] != null && !CheckUtil.checkDate(content[i], "yyyy-MM-dd")) {
					throw new Exception("[��������]��ʽ����ȷ��Ӧ��Ϊyyyy-MM-dd");
				}
				break;
			// �Ա�
			case 4:
				if (content[i] != null && !content[i].equals("0")
						&& !content[i].equals("1")) {
					throw new Exception("[�Ա�]����Ϊ���֣��ұ���Ϊ0��1");
				}
				break;
			// ���֤����
			case 5:
				if (content[i] != null && content[i].length() != 15 && content[i].length() != 18) {
					throw new Exception("[���֤����]���ȱ���Ϊ15��18λ");
				}
				break;
			// ���й�˾
			case 6:
				if (content[i] != null && content[i].getBytes("GBK").length > 14) {
					throw new Exception("[���й�˾]���ȱ���Ϊ1-14λ");
				}
				break;
			// �ֹ�˾
			case 7:
				if (content[i] != null && content[i].getBytes("GBK").length > 14) {
					throw new Exception("[�ֹ�˾]���ȱ���Ϊ1-14λ");
				}
				break;
			// ��������
			case 8:
				if (content[i] != null) {
					Way bo = (WayBO) BOFactory.build(WayBO.class, user);
					WayVO vo = bo.doFindByPk(content[i]);
					if (vo == null) {
						throw new Exception("[��������]�����������벻����");
					}
				}
				break;
			// ��ְʱ��
			case 9:
				if (content[i] != null && !CheckUtil.checkDate(content[i], "yyyy-MM-dd")) {
					throw new Exception("[��ְʱ��]��ʽ����ȷ��Ӧ��Ϊyyyy-MM-dd");
				}
				break;
			// �Ͷ���ϵ
			case 10:
				if (content[i] != null && !content[i].equals("0") && !content[i].equals("1")) {
					throw new Exception("[�Ͷ���ϵ]����Ϊ���֣��ұ���Ϊ0��1");
				}
				break;
			// �ù�����
			case 11:
				if (content[i] != null && !content[i].equals("0") 
						&& !content[i].equals("1") && !content[i].equals("2") 
						&& !content[i].equals("3") && !content[i].equals("99")) {
					throw new Exception("[�ù�����]����Ϊ���֣���ֵ����Ϊ0��1��2��3��99");
				}
				break;
			// �ù�״̬
			case 12:
				if (content[i] != null && !content[i].equals("0") && !content[i].equals("1")) {
					throw new Exception("[�ù�״̬]����Ϊ���֣��ұ���Ϊ0��1");
				}
				break;
			// �Ƿ�Ϊ����
			case 13:
				if (content[i] != null && !content[i].equals("0") && !content[i].equals("1")) {
					throw new Exception("[�Ƿ�Ϊ����]����Ϊ���֣��ұ���Ϊ0��1");
				}
				break;
			// ��֤��
			case 16:
				if (content[i] != null && !CheckUtil.checkDouble(content[i])) {
					throw new Exception("[��֤��]����Ϊ����");
				}
				break;
			}
		}
	}
}
