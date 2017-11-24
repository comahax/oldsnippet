package com.sunrise.jop.infrastructure.sysadmin;


/**
 * ExtendOperationLog
 * <br> Description: ������־�ӿ�. ��Ҫ�Ǽǲ�����־��VO���ԭ�������ִ�����־�������,��Ҫ����ָ�����Ե�,��Ҫʵ�ִ˽ӿ�.
 * <br> Company: Sunrise,Guangzhou</br>
 * @author Linli
 * @since 1.0
 * @version 1.0
 * 2009��11��24��16:46:36
 */
public interface BusinessRepointLog extends BusinessLog{

	/**
	 * ���logProperties����,��logvo����ָ�������ı��ʱ��,��ס�ı��logvo����˳��һ��Ҫ����5�����Ե�˳��һ��
	 */
	public static final String[] logProperties = new String[]{"logid","optime","oprcode","oprtype","success"};

	public static final int logid = 0;
	public static final int optime = 1;
	public static final int oprcode = 2;
	public static final int oprtype = 3;
	public static final int success = 4;
	
	public String[] repointLogProperites();
 	
}
