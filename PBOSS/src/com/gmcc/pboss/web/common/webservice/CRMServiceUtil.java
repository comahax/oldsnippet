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
		
		msgreqheader.setMenuid(menuid);//来源平台，默认PBOSS
		msgreqheader.setProcessCode(processCode);//业务标识，本次调用接口的业务标识
		msgreqheader.setVerifyCode(perifyCode);//保证双方通信安全性（预留空））
		msgreqheader.setReqTime(reqTime);//必须填写，格式YYYYMMDDHH24MISS
		msgreqheader.setReqSeq(reqSeq);//请求流水（预留空）。本次调用请求流水，由调用方生成。
		msgreqheader.setUnicontact(unicontact);//由调用方填写（留空）。
		msgreqheader.setTestflag(testflag);//1标示测试，0或者不传标示生产
		
		Route route = new Route();//区号
		route.setRouteType(routeType);
		//0：按地市
		//1：按号码
		//如果请求信息中包含手机号码，此节点填1，如果请求中未包含手机号但是包含区号，此节点填0。
		//如果请求中既不包含手机号码又不包含区号，此节点填1，路由字段值填999，表示使用CRM的缺省路由。
		route.setRouteValue(routeValue);//手机号码或区号
		msgreqheader.setRoute(route);//
		
		//user.getOprcode()
		//user.getWayid()
		Channelinfo channelinfo = new Channelinfo();//渠道信息
		channelinfo.setOperatorid(operatorid);//如果传的操作员ID必须保证操作员正确
		channelinfo.setChannelid(channelid);//操作员渠道
		channelinfo.setUnitid(unitid);//子渠道id
		msgreqheader.setChannelinfo(channelinfo);
		
		return msgreqheader;
	}
	
	public static net.gmcc.ngcrm.pboss.Msgreqheader getMsgreqheader_CX(String menuid, String processCode, String perifyCode,String reqTime,
			String reqSeq, String unicontact, String testflag, String routeType, 
			String routeValue, String operatorid, String channelid, String unitid){
		net.gmcc.ngcrm.pboss.Msgreqheader msgreqheader = new net.gmcc.ngcrm.pboss.Msgreqheader();
		
		msgreqheader.setMenuid(menuid);//来源平台，默认PBOSS
		msgreqheader.setProcessCode(processCode);//业务标识，本次调用接口的业务标识
		msgreqheader.setVerifyCode(perifyCode);//保证双方通信安全性（预留空））
		msgreqheader.setReqTime(reqTime);//必须填写，格式YYYYMMDDHH24MISS
		msgreqheader.setReqSeq(reqSeq);//请求流水（预留空）。本次调用请求流水，由调用方生成。
		msgreqheader.setUnicontact(unicontact);//由调用方填写（留空）。
		msgreqheader.setTestflag(testflag);//1标示测试，0或者不传标示生产
		
		net.gmcc.ngcrm.pboss.Msgreqheader.Route route = new net.gmcc.ngcrm.pboss.Msgreqheader.Route();//区号
		route.setRouteType(routeType);
		//0：按地市
		//1：按号码
		//如果请求信息中包含手机号码，此节点填1，如果请求中未包含手机号但是包含区号，此节点填0。
		//如果请求中既不包含手机号码又不包含区号，此节点填1，路由字段值填999，表示使用CRM的缺省路由。
		route.setRouteValue(routeValue);//手机号码或区号
		msgreqheader.setRoute(route);//
		
		//user.getOprcode()
		//user.getWayid()
		net.gmcc.ngcrm.pboss.Msgreqheader.Channelinfo channelinfo = new net.gmcc.ngcrm.pboss.Msgreqheader.Channelinfo();//渠道信息
		channelinfo.setOperatorid(operatorid);//如果传的操作员ID必须保证操作员正确
		channelinfo.setChannelid(channelid);//操作员渠道
		channelinfo.setUnitid(unitid);//子渠道id
		msgreqheader.setChannelinfo(channelinfo);
		
		return msgreqheader;
	}
	
	/**
	 * 把object转成属性、属性值输出
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
			//动态生成getter和setter方法
			String fieldName = field.getName();
			String firstChar = fieldName.substring(0,1).toUpperCase();
			String getterName = "get" + firstChar + fieldName.substring(1);
			Method getter = classType.getMethod(getterName);
			
			//执行getter方法获取当前域的值
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
			//动态生成getter和setter方法
			String fieldName = field.getName();
			String firstChar = fieldName.substring(0,1).toUpperCase();
			String getterName = "get" + firstChar + fieldName.substring(1);
			Method getter = classType.getMethod(getterName);
			
			//执行getter方法获取当前域的值
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
