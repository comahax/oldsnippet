package com.common.util.string;
/**
 * ���˹�˾��������ҵ��
 * @author tangzhu
 * ������
 * 	�����ַ����Ĵ�����
 */
public class CharacterStrUtil {
	
	/**
	 * ���strΪ�ջ�Ϊnull������true�����򷵻�false
	 * @param str
	 * @return trueΪ�գ�false��Ϊ��
	 */
	public static boolean isBlank(String str){
		return (str == null || str.equals(""))?true:false;
	}
}
