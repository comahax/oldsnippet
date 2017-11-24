/**
 * @author He Kun (Henry He), Guangzhou, China
 * 2006-8-31
 */
package com.sunrise.boss.business.cms.waytype.persistent;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

/**
 * WayTypeConstant
 * <br> Description: class WayTypeConstant
 * <br> Company: Maywide,Guangzhou</br>
 * @author He Kun
 * @since 1.0
 * @version 1.0
 * 2006-8-31
 */
public class WayTypes {

	private static final String WAYTYPE_ET = "ET";  //ʵ������
	private static final String WAYTYPE_ET_G100 = "G100";  //��ͨ100������
	private static final String WAYTYPE_ET_BAND = "BAND";  //Ʒ�Ƶ�
	private static final String WAYTYPE_ET_TOP = "TOP";  //�콢��
	private static final String WAYTYPE_ET_SFSV = "SFSV";  //���������
	private static final String WAYTYPE_ET_EXPE = "EXPE";  //���˿ͻ�����վ
	
	private static final String WAYTYPE_AG = "AG";  //��ͨ��������
	private static final String WAYTYPE_AG_DIS = "DIS";  //������
	private static final String WAYTYPE_AG_DIS_BRANCH = "DISB";  //������
	
	private static final String WAYTYPE_AG_STRT = "STRT";  //ֱ����
	private static final String WAYTYPE_AG_STRT_BRANCH = "STRB";  //������
	private static final String WAYTYPE_AG_BANK = "BANK";  //��������
	private static final String WAYTYPE_AG_TEMI = "TEMI";  //�ն˳���
	private static final String WAYTYPE_AG_ITF = "ITF";  //IT����	
	
	private static final String WAYTYPE_EC = "EC";  //��������
	private static final String WAYTYPE_SA = "SA";  //ֱ������
	private static final String WAYTYPE_AV = "AV";  //��ֵ��������
	
	private static Map fixedWayTypes;
	private static Map entityBranchTypes;
	private static Map agentBranchTypes;
	
	static  {
		fixedWayTypes = new HashMap(32);
		entityBranchTypes = new HashMap(16);
		agentBranchTypes = new HashMap(16);
		
		Field[] fields = WayTypes.class.getDeclaredFields();		
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];			
			if( Modifier.isStatic(field.getModifiers() ) && Modifier.isFinal(field.getModifiers())
					&& field.getType().equals(String.class)) {
				try {
					fixedWayTypes.put(field.get(field.getName()), field.getName());
					
					if(field.getName().indexOf("WAYTYPE_ET_")>-1) {
						entityBranchTypes.put(field.get(field.getName()), field.getName());
					}else if(field.getName().indexOf("WAYTYPE_AG_")>-1) {
						agentBranchTypes.put(field.get(field.getName()), field.getName());
					}
				} catch (Exception e) {				 
					e.printStackTrace();
				}
			}
		}
		
		
		
	}
	/**
	 * �ж��Ƿ���ʵ������
	 * @param type
	 * @return
	 */
	public static boolean isET(String type,String subType) {
		return WAYTYPE_ET.equals(type) && StringUtils.isEmpty(subType);
	}
	
	public static boolean isETBranch(String type) {
		return entityBranchTypes.containsKey(type);
	}
	/**
	 * �ж��Ƿ�����ͨ��������
	 * @param type
	 * @return
	 */
	public static boolean isAG(String type,String subType) {
		return WAYTYPE_AG.equals(type) && !WAYTYPE_AG_DIS_BRANCH.equals(subType) && !WAYTYPE_AG_STRT_BRANCH.equals(subType);
	}
	
	public static boolean isAGBranch(String subType) {
		return WAYTYPE_AG_DIS_BRANCH.equals(subType) || WAYTYPE_AG_STRT_BRANCH.equals(subType);
	}
	
	public static Map getFixedWayTypes() {
		return Collections.unmodifiableMap(fixedWayTypes);
	}
	
	/**
	 * �ж�һ�������Ƿ�Ϊ�̶�����
	 * @param type
	 * @return
	 */
	public static boolean isFiexdWayType(String type) {
		return fixedWayTypes.containsKey(type);
	}
	
	public static void main(String[] args) {
		System.out.println("consts " + getFixedWayTypes());
	}
}
