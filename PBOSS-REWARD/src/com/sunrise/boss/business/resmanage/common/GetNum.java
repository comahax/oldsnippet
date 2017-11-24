package com.sunrise.boss.business.resmanage.common;

/**
 * 
 * Title: GetNum<br>
 * Description: ȡ���ַ���֮������ֵ<br>
 * Company: sunrise,Guangzhou</br>
 * 
 * @author Cao Wei
 * @version 1.0
 */
public class GetNum {

	private String s = "";

	/**
	 * @description �ַ����Լ� 1
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
			return -1; // Խ��
		return 0;
	}

	/**
	 * @description ������ʼ��ź���ֹ���ȡ��֮��Ĳ�ֵ
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
