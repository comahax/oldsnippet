package com.gmcc.pboss.common.utils.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.base.dictitem.DictitemDBParam;
import com.gmcc.pboss.control.base.dictitem.Dictitem;
import com.gmcc.pboss.control.base.dictitem.DictitemBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.User;

public class CheckUtil {

	static CheckUtil check;

	// public static int preLineCount;

	// private static String resultStr;

	// public static int TotalCount;

	private Dictitem dictitem;

	/**
	 * 用於導入時校驗固定參數的值是否正確
	 * 
	 * @param groupid
	 * @param dictid
	 * @return check
	 * @throws Exception
	 */
	public final boolean checkDictitem(String groupid, String dictid, User user)
			throws Exception {
		if (groupid == null || dictid == null) {
			throw new Exception("缺少值:groupid或dictid");
		}
		DictitemDBParam listVO = new DictitemDBParam();
		listVO.set_se_groupid(groupid);
		listVO.set_se_dictid(dictid);

		return getControl(user).doQuery(listVO).getRowCount() > 0;
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

	public static final boolean checkNum(String strNum, int length)
			throws Exception {
		if (isEmpty(strNum)) {
			return false;
		}
		String pattern = "^[-]?\\d{0," + length + "}$";
		return dealString(strNum).matches(pattern);
	}

	public static final boolean checkNum(String strNum, int length,
			boolean canBeNull) throws Exception {
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

	public static final boolean checkString(String str, int length)
			throws Exception {
		if (isEmpty(str)) {
			return false;
		}
		// String pattern = "^\\w{0," + length + "}$";
		return length >= str.trim().getBytes("GBK").length;
	}

	public static final boolean checkString(String str, int length,
			boolean canBeNull) throws Exception {
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

	/**
	 * 检查是否为非负的浮点数
	 * 
	 * @param doublestr
	 * @return
	 * @throws Exception
	 */
	public static final boolean checkNonnegativeDouble(String doublestr)
			throws Exception {
		if (isEmpty(doublestr)) {
			return false;
		}
		String pattern = "^\\d+(\\.\\d+)?$";
		return doublestr.trim().matches(pattern);
	}

	public static final boolean checkDecimals(String doublestr)
			throws Exception {
		if (isEmpty(doublestr)) {
			return false;
		}
		String pattern = "^0(\\.\\d+)?$";
		return doublestr.trim().matches(pattern);
	}

	/**
	 * 检查是否为浮点数
	 * 
	 * @param doublestr
	 * @return
	 * @throws Exception
	 */
	public static final boolean checkDouble(String doublestr) throws Exception {
		if (isEmpty(doublestr)) {
			return false;
		}
		String pattern = "^(-?\\d+)(\\.\\d+)?$";
		return doublestr.trim().matches(pattern);
	}

	public static final boolean checkDouble(String doublestr, int len1, int len2)
			throws Exception {
		if (isEmpty(doublestr)) {
			return false;
		}
		String pattern = "^[-]?\\d{0," + len1 + "}[.]?\\d{0," + len2 + "}$";
		return doublestr.trim().matches(pattern);
	}

	public static final Double setDouble(String strDouble) throws Exception {
		if (checkDouble(strDouble)) {
			return new Double(dealString(strDouble));
		} else {
			throw new Exception("数字格式不正确或超出范围:" + strDouble);
		}
	}

	public static final boolean checkDate(String strDate, String pattern,
			boolean canBeNull) throws Exception {
		if (canBeNull) {
			if (isEmpty(strDate)) {
				return true;
			} else {
				return checkDate(strDate, pattern);
			}
		} else {
			return checkDate(strDate, pattern);
		}
	}

	public static final boolean checkDate(String strDate, String pattern)
			throws Exception {
		boolean checked = false;
		SimpleDateFormat fmt = new SimpleDateFormat(pattern);
		try {
			Date date = fmt.parse(strDate);
			checked = true;
		} catch (Exception ex) {
			// checked=false;
			// throw new Exception("日期格式不对,应该为:" + pattern);
		}
		return checked;
	}

	public static final Long setLong(String strLong) throws Exception {
		if (checkNum(strLong)) {
			return new Long(dealString(strLong));
		} else {
			throw new Exception("数字格式不正确或超出范围:" + strLong);
		}
	}

	public static final Integer setInteger(String strInteger) throws Exception {
		if (checkNum(strInteger)) {
			return new Integer(dealString(strInteger));
		} else {
			throw new Exception("数字格式不正确或超出范围:" + strInteger);
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

	public static final Integer setNullInteger(String strInteger)
			throws Exception {
		if (checkNum(strInteger)) {
			return new Integer(dealString(strInteger));
		} else {
			return null;
		}
	}

	public static final String[] copyArr(String arr[], String str,
			String fields[]) throws Exception {
		String temArr[] = StringUtils.splitPreserveAllTokens(str, "|");
		for (int i = 0; i < temArr.length - 1; i++) {
			int temp = -1;
			temp = new Integer(temArr[i]).intValue();
			arr[temp] = dealString(fields[i]);
		}
		return arr;
	}

	/**
	 * 
	 * @param line
	 * @param seprator
	 * @return
	 * @throws Exception
	 */
	public static String delLastSeprator(String line, String seprator)
			throws Exception {
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
	 * 删除无用或者多余的提示信息
	 * 
	 * @param smsg
	 * @return
	 * @throws Exception
	 */
	public static String delMsg(String smsg) throws Exception {
		if (smsg == null || smsg.length() <= 0) {
			smsg = "";
		} else {
			if ((smsg.indexOf("java.") != -1 && smsg.indexOf("Exception") != -1)
					|| (smsg.indexOf("com.sunrise") != -1 && smsg
							.indexOf("Exception") != -1)) {
				int index = smsg.lastIndexOf("Exception");
				smsg = smsg.substring(index + 10, smsg.length());
			}
		}
		return smsg;
	}

	/**
	 * 
	 * @return delegate
	 * @throws Exception
	 */
	private Dictitem getControl(User user) throws Exception {
		if (dictitem != null) {
			return dictitem;
		} else {
			dictitem = (Dictitem) BOFactory.build(DictitemBO.class, user);
			return dictitem;
		}
	}

	/**
	 * 
	 * @param rags
	 * @throws Exception
	 */
	public static void main(String[] rags) throws Exception {
		// String str = "abceff ";
		// String[] res = CheckUtil.splitPreserveAllTokens(str);
		//
		// for (int i = 0; i < res.length; i++) {
		// System.out.print(i + " ->" + res[i] + "\t");
		// }

		String dStr = "8.09905";
		boolean flag = checkDouble(dStr, 14, 4);
		if (flag) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
	}
}
