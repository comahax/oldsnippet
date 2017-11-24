package com.sunrise.boss.business.cms.common;

import com.sunrise.boss.business.admin.dictitem.persistent.DictitemListVO;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.admin.dictitem.DictitemDelegate;
import com.sunrise.boss.ui.commons.User;
import org.apache.commons.lang.StringUtils;

public class CheckUtil {
	DictitemDelegate delegate;

	static CheckUtil check;

	public static int preLineCount;

	private static String resultStr;

	public static int TotalCount;

	/**
	 * ��춌���rУ�̶�������ֵ�Ƿ����_
	 * 
	 * @param groupid
	 * @param dictid
	 * @return check
	 * @throws Exception
	 */
	public final boolean checkDictitem(String groupid, String dictid, User user) throws Exception {
		if (groupid == null || dictid == null) {
			throw new BusinessException("BOSS_DICTITEM_ERROR", "ȱ��ֵ:groupid��dictid");
		}
		DictitemListVO listVO = new DictitemListVO();
		listVO.set_se_groupid(groupid);
		listVO.set_se_dictid(dictid);
		return getDelegate().doQuery(listVO, user).getRowCount() > 0;
	}

	/**
	 * 
	 * @return CheckUtil
	 * @throws Exception
	 */
	public static CheckUtil getInstance() throws Exception {
		if (check != null) {
			return check;
		} else {
			return new CheckUtil();
		}
	}

	/**
	 * 
	 * @return delegate
	 * @throws Exception
	 */
	private DictitemDelegate getDelegate() throws Exception {
		if (delegate != null) {
			return delegate;
		} else {
			return new DictitemDelegate();
		}
	}

	/**
	 * 
	 * @param strBeChecked
	 * @return
	 * @throws Exception
	 */
	public static final boolean isEmpty(String strBeChecked) throws Exception {
		return StringUtils.isBlank(strBeChecked);
	}

	public static final String dealString(String str) throws Exception {
		if (str == null) {
			return "";
		} else {
			return str.trim();
		}
	}

	public static final boolean checkNum(String strNum, int length) throws Exception {
		if (isEmpty(strNum)) {
			return false;
		}
		String pattern = "^[-]?\\d{0," + length + "}$";
		return dealString(strNum).matches(pattern);
	}

	public static final boolean checkNum(String strNum, int length, boolean canBeNull)
			throws Exception {
		if (canBeNull) {
			if (isEmpty(strNum)) {
				return true;
			} else {
				return checkNum(strNum, length);
			}
		} else {
			return checkNum(strNum, length);
		}
	}

	public static final boolean checkString(String str, int length) throws Exception {
		if (isEmpty(str)) {
			return false;
		}
		// String pattern = "^\\w{0," + length + "}$";
		return length >= str.trim().getBytes("GBK").length;
	}

	public static final boolean checkString(String str, int length, boolean canBeNull)
			throws Exception {
		if (canBeNull) {
			if (isEmpty(str)) {
				return true;
			} else {
				return checkString(str, length);
			}
		} else {
			return checkString(str, length);
		}
	}

	public static final boolean checkNum(String strNum) throws Exception {
		if (isEmpty(strNum)) {
			return false;
		}
		String pattern = "^[-]?\\d+$";
		return strNum.trim().matches(pattern);
	}
	//by lyl ��֤����׼������
	public static final boolean checkDoubleNum(String doublestr) throws Exception {
		if (isEmpty(doublestr)) {
			return false;
		}
		String pattern = "^\\d+[.]?\\d+$";
		return doublestr.trim().matches(pattern);
	}
	public static final boolean checkDouble(String doublestr) throws Exception {
		if (isEmpty(doublestr)) {
			return false;
		}
		String pattern = "^[-]?\\d+[.]?\\d+$";
		return doublestr.trim().matches(pattern);
	}

	public static final boolean checkDouble(String doublestr, int len1, int len2) throws Exception {
		if (isEmpty(doublestr)) {
			return false;
		}
		
		/**
		 * 2013.5.23 by hejw
		 * �����������ַ����в�����С����ʱ����С��λ�����ȸ���������λ�����ȵ�����
		 * �磺CheckUtil.checkDouble("123456", 4, 2) Ҳ��ͨ����֤
		 */
		if (doublestr.indexOf(".") == -1) {
			return checkNum(doublestr, len1);
		}
		
		String pattern = "^[-]?\\d{0," + len1 + "}[.]?\\d{0," + len2 + "}$";
		return doublestr.trim().matches(pattern);
	}

	public static final Double setDouble(String strDouble) throws Exception {
		if (checkDouble(strDouble)) {
			return new Double(dealString(strDouble));
		} else {
			throw new Exception("���ָ�ʽ����ȷ�򳬳���Χ:" + strDouble);
		}
	}

	public static final Long setLong(String strLong) throws Exception {
		if (checkNum(strLong)) {
			return new Long(dealString(strLong));
		} else {
			throw new Exception("���ָ�ʽ����ȷ�򳬳���Χ:" + strLong);
		}
	}

	public static final Integer setInteger(String strInteger) throws Exception {
		if (checkNum(strInteger)) {
			return new Integer(dealString(strInteger));
		} else {
			throw new Exception("���ָ�ʽ����ȷ�򳬳���Χ:" + strInteger);
		}
	}

	public static final Double setNullDouble(String strDouble) throws Exception {
		if (checkNum(strDouble)) {
			return new Double(dealString(strDouble));
		} else {
			return null;
		}
	}

	public static final Long setNullLong(String strLong) throws Exception {
		if (checkNum(strLong)) {
			return new Long(dealString(strLong));
		} else {
			return null;
		}
	}

	public static final Integer setNullInteger(String strInteger) throws Exception {
		if (checkNum(strInteger)) {
			return new Integer(dealString(strInteger));
		} else {
			return null;
		}
	}

	/**
	 * 
	 * @param fields
	 * @param fixFields
	 * @param user
	 * @throws Exception
	 */
	public static final void checkHead(String[] fields, String[] fixFields, User user)
			throws Exception {
		// ��ս�����ϴμ���ֵ
		resultStr = "";
		preLineCount = fields.length;
		TotalCount = fixFields.length;
		for (int i = 0; i < fields.length; i++) {
			boolean find = false;
			for (int k = 0; k < fixFields.length; k++) {
				if ("".equals(fields[i].trim())) {
					throw new BusinessException("", "�Զ����ļ�ͷ�в������п�,�����һ��û������");
				}
				if (fields[i].trim().equals(fixFields[k])) {
					resultStr = resultStr + k + "|";
					find = true;
					continue;
				}
			}
			if (!find) {
				throw new BusinessException("", "�Զ����ļ�ͷ:" + fields[i] + "����ȷ!");
			}
		}
	}

	public static final String[] copyArr(String arr[], String str, String fields[])
			throws Exception {
		String temArr[] = StringUtils.splitPreserveAllTokens(str, "|");
		for (int i = 0; i < temArr.length - 1; i++) {
			int temp = -1;
			temp = new Integer(temArr[i]).intValue();
			arr[temp] = dealString(fields[i]);
		}
		return arr;
	}

	public static String[] checkLines(String[] fields, User user) throws Exception {
		if (CheckUtil.preLineCount != fields.length) {
			throw new BusinessException("", "�Զ����ļ�ͷ������������������һ��!");
		}
		String checkLine[] = new String[TotalCount];
		return CheckUtil.copyArr(checkLine, resultStr, fields);
	}

	/**
	 * 
	 * @param line
	 * @param seprator
	 * @return
	 * @throws Exception
	 */
	public static String delLastSeprator(String line, String seprator) throws Exception {
		if (line == null) {
			return "";
		} else {
			if (line.trim().lastIndexOf(seprator) == line.trim().length() - 1
					&& line.trim().length() > 1) {
				return line.trim().substring(0, line.trim().length() - 1);
			} else {
				return line;
			}
		}
	}

	/**
	 * 
	 * @param line
	 * @param seprator
	 * @return
	 * @throws Exception
	 */
	public static String delLastSeprator(String line) throws Exception {
		if (line == null) {
			return "";
		} else {
			if (line.trim().lastIndexOf("|") == line.trim().length() - 1
					&& line.trim().length() > 1) {
				return line.trim().substring(0, line.trim().length() - 1);
			} else {
				return line;
			}
		}
	}

	public static String[] splitPreserveAllTokens(String line) throws Exception {
		return StringUtils.splitPreserveAllTokens(delLastSeprator(line), "|");
	}

	/**
	 * 
	 * @param rags
	 * @throws Exception
	 */
	public static void main(String[] rags) throws Exception {
		String str = "10000000000.12";
		System.out.print(CheckUtil.checkDouble(str,10,2));
//		for (int i = 0; i < res.length; i++) {
//			System.out.print(i+ " ->" + res[i]+"\t");
//		}
	}
}
