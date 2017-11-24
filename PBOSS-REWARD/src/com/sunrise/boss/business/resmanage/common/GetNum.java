package com.sunrise.boss.business.resmanage.common;

/**
 * 
 * Title: GetNum<br>
 * Description: 取两字符串之间相差的值<br>
 * Company: sunrise,Guangzhou</br>
 * 
 * @author Cao Wei
 * @version 1.0
 */
public class GetNum {

	private String s = "";

	/**
	 * @description 字符串自加 1
	 * @param bb
	 * @return
	 */
	public int addChar(String bb) {
		char[] aa = bb.toCharArray();
		int i;
		for (i = aa.length - 1; i >= 0; i--) {
			if (aa[i] == '9')
				aa[i] = '0';
			else {
				if (aa[i] > '9' || aa[i] < '0')
					return -1;
				aa[i] += 1;
				s = String.valueOf(aa);
				return 0;
			}
		}
		if (i == -1)
			return -1; // 越界
		return 0;
	}

	/**
	 * @description 根据起始编号和终止编号取出之间的差值
	 * @param begno
	 * @param endno
	 * @return
	 */
	public long getNum(String begno, String endno) {
		int i = 1;
		while (endno.compareTo(begno) > 0 && i < 1000000) {
			if (addChar(begno) == -1) {
				i = -1;
				break;
			}
			begno = s;
			i++;
		}
		return i;
	}
}
