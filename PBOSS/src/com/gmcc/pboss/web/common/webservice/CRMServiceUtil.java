package com.gmcc.pboss.web.common.webservice;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import net.gmcc.ngcrm.Msgreqheader;
import net.gmcc.ngcrm.Msgreqheader.Channelinfo;
import net.gmcc.ngcrm.Msgreqheader.Route;

public class CRMServiceUtil {
	public static Msgreqheader getMsgreqheader(String menuid, String processCode, String perifyCode,String reqTime,
			String reqSeq, String unicontact, String testflag, String routeType, 
			String routeValue, String operatorid, String channelid, String unitid){
		Msgreqheader msgreqheader = new Msgreqheader();
		
		msgreqheader.setMenuid(menuid);//��Դƽ̨��Ĭ��PBOSS
		msgreqheader.setProcessCode(processCode);//ҵ���ʶ�����ε��ýӿڵ�ҵ���ʶ
		msgreqheader.setVerifyCode(perifyCode);//��֤˫��ͨ�Ű�ȫ�ԣ�Ԥ���գ���
		msgreqheader.setReqTime(reqTime);//������д����ʽYYYYMMDDHH24MISS
		msgreqheader.setReqSeq(reqSeq);//������ˮ��Ԥ���գ������ε���������ˮ���ɵ��÷����ɡ�
		msgreqheader.setUnicontact(unicontact);//�ɵ��÷���д�����գ���
		msgreqheader.setTestflag(testflag);//1��ʾ���ԣ�0���߲�����ʾ����
		
		Route route = new Route();//����
		route.setRouteType(routeType);
		//0��������
		//1��������
		//���������Ϣ�а����ֻ����룬�˽ڵ���1�����������δ�����ֻ��ŵ��ǰ������ţ��˽ڵ���0��
		//��������мȲ������ֻ������ֲ��������ţ��˽ڵ���1��·���ֶ�ֵ��999����ʾʹ��CRM��ȱʡ·�ɡ�
		route.setRouteValue(routeValue);//�ֻ����������
		msgreqheader.setRoute(route);//
		
		//user.getOprcode()
		//user.getWayid()
		Channelinfo channelinfo = new Channelinfo();//������Ϣ
		channelinfo.setOperatorid(operatorid);//������Ĳ���ԱID���뱣֤����Ա��ȷ
		channelinfo.setChannelid(channelid);//����Ա����
		channelinfo.setUnitid(unitid);//������id
		msgreqheader.setChannelinfo(channelinfo);
		
		return msgreqheader;
	}
	
	public static net.gmcc.ngcrm.pboss.Msgreqheader getMsgreqheader_CX(String menuid, String processCode, String perifyCode,String reqTime,
			String reqSeq, String unicontact, String testflag, String routeType, 
			String routeValue, String operatorid, String channelid, String unitid){
		net.gmcc.ngcrm.pboss.Msgreqheader msgreqheader = new net.gmcc.ngcrm.pboss.Msgreqheader();
		
		msgreqheader.setMenuid(menuid);//��Դƽ̨��Ĭ��PBOSS
		msgreqheader.setProcessCode(processCode);//ҵ���ʶ�����ε��ýӿڵ�ҵ���ʶ
		msgreqheader.setVerifyCode(perifyCode);//��֤˫��ͨ�Ű�ȫ�ԣ�Ԥ���գ���
		msgreqheader.setReqTime(reqTime);//������д����ʽYYYYMMDDHH24MISS
		msgreqheader.setReqSeq(reqSeq);//������ˮ��Ԥ���գ������ε���������ˮ���ɵ��÷����ɡ�
		msgreqheader.setUnicontact(unicontact);//�ɵ��÷���д�����գ���
		msgreqheader.setTestflag(testflag);//1��ʾ���ԣ�0���߲�����ʾ����
		
		net.gmcc.ngcrm.pboss.Msgreqheader.Route route = new net.gmcc.ngcrm.pboss.Msgreqheader.Route();//����
		route.setRouteType(routeType);
		//0��������
		//1��������
		//���������Ϣ�а����ֻ����룬�˽ڵ���1�����������δ�����ֻ��ŵ��ǰ������ţ��˽ڵ���0��
		//��������мȲ������ֻ������ֲ��������ţ��˽ڵ���1��·���ֶ�ֵ��999����ʾʹ��CRM��ȱʡ·�ɡ�
		route.setRouteValue(routeValue);//�ֻ����������
		msgreqheader.setRoute(route);//
		
		//user.getOprcode()
		//user.getWayid()
		net.gmcc.ngcrm.pboss.Msgreqheader.Channelinfo channelinfo = new net.gmcc.ngcrm.pboss.Msgreqheader.Channelinfo();//������Ϣ
		channelinfo.setOperatorid(operatorid);//������Ĳ���ԱID���뱣֤����Ա��ȷ
		channelinfo.setChannelid(channelid);//����Ա����
		channelinfo.setUnitid(unitid);//������id
		msgreqheader.setChannelinfo(channelinfo);
		
		return msgreqheader;
	}
	
	/**
	 * ��objectת�����ԡ�����ֵ���
	 * @param object
	 * @return
	 * @throws Exception
	 */
	public static String getAllString(Object object) throws Exception{
		StringBuffer sb = new StringBuffer();
		
		Class classType = object.getClass();
		Field[] fields = classType.getDeclaredFields();
		for(int i=0; i<fields.length; i++){
			Field field = fields[i];
			//��̬����getter��setter����
			String fieldName = field.getName();
			String firstChar = fieldName.substring(0,1).toUpperCase();
			String getterName = "get" + firstChar + fieldName.substring(1);
			Method getter = classType.getMethod(getterName);
			
			//ִ��getter������ȡ��ǰ���ֵ
			Object result = getter.invoke(object);
			if(result instanceof String){
				sb.append(fieldName + "-->" + result + "\n");
			}else{
				getAllString(result, sb);
			}
		}
		
		return sb.toString();
	}
	
	public static String getAllString(Object object, StringBuffer sb) throws Exception{
		StringBuffer sb1 = new StringBuffer();
		
		Class classType = object.getClass();
		Field[] fields = classType.getDeclaredFields();
		for(int i=0; i<fields.length; i++){
			Field field = fields[i];
			//��̬����getter��setter����
			String fieldName = field.getName();
			String firstChar = fieldName.substring(0,1).toUpperCase();
			String getterName = "get" + firstChar + fieldName.substring(1);
			Method getter = classType.getMethod(getterName);
			
			//ִ��getter������ȡ��ǰ���ֵ
			Object result = getter.invoke(object);
			if(result instanceof String){
				System.out.println("11111111111111111111111");
				sb1.append(fieldName + "-->" + result + "\n");
			}else{
				System.out.println("22222222222222222222222");
				sb1.append(fieldName + "-->");
				getAllString(result);
			}
		}
		System.out.println("sb.toString():"+sb1.toString());
		return sb1.toString();
	}
}
