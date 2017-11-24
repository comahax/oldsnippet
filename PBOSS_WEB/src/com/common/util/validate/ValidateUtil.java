package com.common.util.validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 从兴公司电子渠道业务部
 * @author tangzhu
 * 描述：
 * 	验证工具类
 */
public class ValidateUtil {
	/**
     * 用于判断是否为中国移动号码的正则表达式
     */
    public static String CHINAMOBILE_REGEX = "^1(3[4-9]|47|5[0-27-9]|87|88)\\d{8}$";
    
    /**
     * 判断号码是否为中国移动的号码，判断规则，符合以下正则表达式的号码都为中国移动的号码
     * 正则表达式：^1(3[4-9]|5[0-27-9]|88)\\d{8}$
     * @param mobile 要判断的手机号码
     * @return true为是中国移动的号码，false不是
     */
    public static boolean isChinaMobile(String mobile) {
		if (mobile == null) {
		    return false;
		}
		return Pattern.matches(CHINAMOBILE_REGEX, mobile);
    }
    
    /**
     * 邮箱的验证， 判断用户是否输入的邮箱是否正确
     * @param email
     * @return	false邮箱格式不正确; true:邮箱格式正确
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
