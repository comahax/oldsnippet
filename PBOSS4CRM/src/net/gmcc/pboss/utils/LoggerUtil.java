package net.gmcc.pboss.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import net.gmcc.pboss.common.dao.IBaseDao;
import net.gmcc.pboss.pboss4crmservice.Msgreqheader;
import net.gmcc.pboss.pboss4crmservice.Msgrspheader;
//import net.gmcc.pboss.webservice.RequestHeader;
//import net.gmcc.pboss.webservice.ResultHeader;
//import net.gmcc.pboss.webservice.domain.additional.cics.protocol.CNode;
//import net.gmcc.pboss.webservice.domain.additional.syslog.Syslog;


public class LoggerUtil {
	private static final Logger log = Logger.getLogger(LoggerUtil.class);
	
	/**
	 * 列出VO中所有属性键和值，做为日志打印时使用
	 * 
	 * @param vo
	 * @return
	 * @throws Exception
	 *             反射出错则会抛出异常
	 */
	//此方法不实用PBOSS4CRM，需要改造
	@SuppressWarnings("unchecked")
	public static String listVOProperty(Object vo ,boolean cycle) {
		StringBuffer buff = new StringBuffer();
		try {
			Class<?> voClass = vo.getClass();
			if(cycle){
			    buff.append("当前VO名:").append(voClass.getName()).append(";");
			}else{
				//子复杂属性,输出简化
				buff.append("属性:").append(voClass.getSimpleName()).append(";");
			}
			Field[] fields = voClass.getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				if(isSimpleType(fields[i].getType())){
					String fieldName = fields[i].getName();
					buff.append(fields[i].getName()).append("=").append("\"");
					//对于属性名称有下划线的,要进行把下划线去掉(函数名不能有下划线)
					if(fieldName.contains("_")){
						fieldName = fieldName.replace("_", "");
					}
					try {
						String value = BeanUtils.getProperty(vo, fieldName);
						
						//下面的处理方式不使用于PBOSS4CRM协议，需要修改？？？？？？？？？？？？？？？？？？？？？？？？
						if (null != value && fields[i].getType().getName().endsWith("Date")//日期
								    && Pattern.compile("(?i)[a-z]").matcher(value).find()){//包含字母
							//Sat Nov 12 01:52:04 GMT+08:00 2011
							//Sun Nov 20 11:51:44 CST 2011
							value = StringUtil.changeAreaDateToStr19(value);
						}
						buff.append(value).append("\";");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						//属性没有对应的get方法(可能是属性名有问题)
						log.info(voClass.getSimpleName()+ "对象,读取属性("+fields[i].getName()+")出错."+e.getMessage());
					}
				}else{
					//递归解释复杂属性对象
					Class<?>[] classes = null;
					Method method = voClass.getDeclaredMethod("get"+fields[i].getName().
							substring(0,1).toUpperCase()+fields[i].getName().substring(1), classes);
					Object[] objs = null;
					Object obj = method.invoke(vo, objs);
					if(obj == null){//null判断,防止出现异常
						//简化日志,属性为空的不输出
//						buff.append("属性:").append(fields[i].getName()).append("=\"null\";");
					}else{
//						System.out.println(obj.getClass().getName());
						if(obj.getClass().getName().contains("ArrayList")){//遍历ArrayList对象
							List tmp = (ArrayList)obj;
							for(int j=0; j<tmp.size();j++){
								buff.append(listVOProperty(tmp.get(j), false));
							}
						}else{
					        buff.append(listVOProperty(obj, false));
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "不能遍历VO:"+vo.getClass().getName();
		}
		return buff.toString();
	}
	
	/**
	 * 判断是否为普通类型,此方法暂时由上面的 listVOProperty 使用
	 * 
	 * @param classType
	 * @return
	 * @throws Exception
	 */
	public static boolean isSimpleType(Class<?> classType) throws Exception{
		String typeName = classType.getName();
		if(typeName.endsWith("String")){
			return true;
		}else if(typeName.endsWith("Date")){
			return true;
		}else if(typeName.endsWith("Integer")||typeName.equals("int")){
			return true;
		}else if(typeName.endsWith("Long")||typeName.equals("long")){
			return true;
		}else if(typeName.endsWith("Float")||typeName.equals("float")){
			return true;
		}else if(typeName.endsWith("Double")||typeName.equals("double")){
			return true;
		}else if(typeName.endsWith("Byte")||typeName.equals("byte")){
			return true;
		}else if(typeName.endsWith("Character")||typeName.equals("char")){
			return true;
		}else if(typeName.endsWith("Boolean")||typeName.equals("boolean")){
			return true;
		}else{
			return false;
		}
	}
	
	public static String buildLoggerID(Msgreqheader reqHeader) {
		return "[" + reqHeader.getMenuid() + "]---->";//此处有待确认选择那个字段最合适？？？
	}
	
	public static String buildLoggerTime() {
		SimpleDateFormat simleDateFromat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss SSS");
		return simleDateFromat.format(new Date());
	}
	
//	/**
//	 * 登记系统日志1
//	 * 
//	 * @param reqHeader
//	 * @param tradeType
//	 * @param orderID
//	 */
//	public static void insertSysLog(RequestHeader reqHeader,String tradeType, String orderID, ResultHeader resHeader, Date intime ,IBaseDao dao) throws Exception{
//		try {
//			Syslog syslog = ServiceUtil.ac.getBean(Syslog.class);
//			syslog.insertSysLog(reqHeader,tradeType, orderID,resHeader,intime,dao);
//		} catch (Exception e) {
//			if(e.toString().contains("ConstraintViolationException")){//流水号冲突,直接返回给CRM
//				throw new Exception("流水号("+reqHeader.getTransID()+")冲突.");
//			}
//			//do nothing
//			//日志记录不影响业务处理.
//		}
//	}
	
//	/**
//	 * 登记系统日志
//	 * 
//	 * @param reqHeader
//	 * @param tradeType
//	 * @param orderID
//	 */
//	public static void insertSysLog(RequestHeader reqHeader,String tradeType, String orderID ,IBaseDao dao) throws Exception{
//		try {
//			Syslog syslog = ServiceUtil.ac.getBean(Syslog.class);
//			syslog.insertSysLog(reqHeader,tradeType,orderID,dao);
//		} catch (Exception e) {
//			if(e.toString().contains("ConstraintViolationException")){//流水号冲突,直接返回给CRM
//				throw new Exception("流水号("+reqHeader.getTransID()+")冲突.");
//			}
//			//do nothing
//			//日志记录不影响业务处理.
//		}
//	}
	public static void insertSysLog(Msgreqheader reqHeader,String tradeType, String orderID ,IBaseDao dao) throws Exception{
		try {
//			Syslog syslog = ServiceUtil.ac.getBean(Syslog.class);
//			syslog.insertSysLog(reqHeader,tradeType,orderID,dao);
		} catch (Exception e) {
			if(e.toString().contains("ConstraintViolationException")){//流水号冲突,直接返回给CRM
				throw new Exception("流水号("+reqHeader.getMenuid()+")冲突.");
			}
			//do nothing
			//日志记录不影响业务处理.
		}
	}
	
//	/**
//	 * 登记CICS日志
//	 * 
//	 * @param reqHeader
//	 * @param tradeType
//	 * @param orderID
//	 */
//	public static void insertSysCICSLog(RequestHeader reqHeader,String tradeType, CNode dataNode, IBaseDao dao){
//		try {
//			Syslog syslog = ServiceUtil.ac.getBean(Syslog.class);//传说中的,一个请求两个数据库连接?Syslog改为使用Service中的dao
//			syslog.insertSysCICSLog(reqHeader,tradeType,dataNode,dao);
//		} catch (Exception e) {
//			//do nothing
//			//日志记录不影响业务处理.
//		}
//	}
}