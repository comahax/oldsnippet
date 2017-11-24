package com.common.util.validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ���˹�˾��������ҵ��
 * @author tangzhu
 * ������
 * 	��֤������
 */
public class ValidateUtil {
	/**
     * �����ж��Ƿ�Ϊ�й��ƶ������������ʽ
     */
    public static String CHINAMOBILE_REGEX = "^1(3[4-9]|47|5[0-27-9]|87|88)\\d{8}$";
    
    /**
     * �жϺ����Ƿ�Ϊ�й��ƶ��ĺ��룬�жϹ��򣬷�������������ʽ�ĺ��붼Ϊ�й��ƶ��ĺ���
     * ������ʽ��^1(3[4-9]|5[0-27-9]|88)\\d{8}$
     * @param mobile Ҫ�жϵ��ֻ�����
     * @return trueΪ���й��ƶ��ĺ��룬false����
     */
    public static boolean isChinaMobile(String mobile) {
		if (mobile == null) {
		    return false;
		}
		return Pattern.matches(CHINAMOBILE_REGEX, mobile);
    }
    
    /**
     * �������֤�� �ж��û��Ƿ�����������Ƿ���ȷ
     * @param email
     * @return	false�����ʽ����ȷ; true:�����ʽ��ȷ
     */
    public static boolean isEmail(String email) {
		boolean tag = true;
		String pattern1 = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
		Pattern pattern = Pattern.compile(pattern1);
		Matcher mat = pattern.matcher(email);
		if (!mat.find()) {
		    tag = false;
		}
		return tag;
    }
}
