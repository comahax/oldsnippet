package net.gmcc.pboss.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.util.Assert;


/**
 * 常用的系统相关的工具类
 */
public class SystemUtil  {
	private static final Logger log = Logger.getLogger(SystemUtil.class);
	/**
	 * 获得当前Web应用的WEB-INF目录的全路径
	 * 
	 * @return 一个String类型的全路径
	 */
	public static String getWebInfPath() {
		return getClassPath("/../");
	}

	/**
	 * 获得普通java应用的classes目录的全路径
	 * 
	 * @return 一个String类型的全路径
	 */
	public static String getJavaApplicationPath() {
		return getClassPath("/");
	}

	/**
	 * 获得当前Web应用的classes目录的全路径
	 * 
	 * @return 一个String类型的全路径
	 */
	public static String getClassPath() {
		return getClassPath("");
	}

	/**
	 * 获得当前应用的classes目录的全路径
	 * 
	 * @param lastPath
	 *            路径最后加入指定的路径
	 * @return 一个String类型的全路径
	 */
	public static String getClassPath(String lastPath) {
		String s = Thread.currentThread().getContextClassLoader().getResource(
				"").toString();
		if (s.startsWith("file://")) {
			s = s.substring(6);
		} else if (s.startsWith("file:/")) {
			if ("/"
					.equals(System.getProperties()
							.getProperty("file.separator"))) {
				s = s.substring(5);
			} else {
				s = s.substring(6);
			}
		}
		if (s.endsWith("/")) {
			s = s.substring(0, s.length() - 1);
		}
		if (!(s.indexOf(":/") == 1) && !s.startsWith("/")) {
			s = "/" + s;
		}
		return s + lastPath;
	}

	/**
	 * 从Spring容器中获得由clazz指定的Service的实例
	 * 
	 * @param ctx
	 *            Spring应用上下文
	 * @param clazz
	 *            指定的Service实例的Class
	 * @return 由clazz指定的Service的实例, 如果没找到, 则返回null;
	 */
	public static <T> T getService(ApplicationContext ctx, Class<T> clazz) {
		String s = clazz.getSimpleName();
		String name = s.substring(0, 1).toLowerCase() + s.substring(1);
		if (ctx.containsBean(name)) {
			return (T) ctx.getBean(name, clazz);
		}
		return null;
	}

	/**
	 * 取得String类型的指定Field名的值
	 * 
	 * @param e
	 *            一个Map<String, Object>类型的集合, 其中Key为fieldname, Value为该字段的值
	 * @param field
	 *            指定的Field字段名
	 * @return String类型的值, 如果Value为null, 则返回null;
	 */
	public static String getFieldStringValue(Map<String, Object> e, String field) {
		return getFieldStringValue(e, field, null);
	}

	/**
	 * 取得Long类型的指定Field名的值
	 * 
	 * @param e
	 *            一个Map<String, Object>类型的集合, 其中Key为fieldname, Value为该字段的值
	 * @param field
	 *            指定的Field字段名
	 * @return Long类型的值, 如果Value为null, 则返回null;
	 */
	public static Long getFieldLongValue(Map<String, Object> e, String field) {
		String v = getFieldStringValue(e, field, null);
		if (v != null) {
			return Long.parseLong(v);
		}
		return null;
	}

	/**
	 * 取得Long类型的指定Field名的值, 具有指定的缺省值
	 * 
	 * @param e
	 *            一个Map<String, Object>类型的集合, 其中Key为fieldname, Value为该字段的值
	 * @param field
	 *            指定的Field字段名
	 * @param defaultValue
	 *            如果Value为null, 则返回该值
	 * @return Long类型的值, 如果Value为null, 则返回指定的defaultValue;
	 */
	public static Long getFieldLongValue(Map<String, Object> e, String field,
			Long defaultValue) {
		String v = getFieldStringValue(e, field, defaultValue.toString());
		if (v != null) {
			return Long.parseLong(v);
		}
		return null;
	}

	/**
	 * 取得String类型的指定Field名的值, 具有指定的缺省值
	 * 
	 * @param e
	 *            一个Map<String, Object>类型的集合, 其中Key为fieldname, Value为该字段的值
	 * @param field
	 *            指定的Field字段名
	 * @param defaultValue
	 *            如果Value为null, 则返回该值
	 * @return String类型的值, 如果Value为null, 则返回指定的defaultValue;
	 */
	public static String getFieldStringValue(Map<String, Object> e,
			String field, String defaultValue) {
		if (e != null) {
			Object o = null;
			if (e.containsKey(field)) {
				o = e.get(field);
			} else if (e.containsKey(field.toUpperCase())) {
				o = e.get(field.toUpperCase());
			}
			return o == null ? defaultValue : o.toString();
		}
		return null;
	}

	/**
	 * 将抛出的异常转化为一个String
	 * @param e
	 * @return
	 */
	public static String exception2String(Throwable e) {
		String retValue = null;
		StringWriter sw = null;
		PrintWriter pw = null;
		try {
			sw = new StringWriter();
			pw = new PrintWriter(sw, true);
			e.printStackTrace(pw);
			pw.flush();
		    sw.flush();
			retValue = sw.toString();
		} finally {
			try {
				if (pw != null){
					pw.close();
					pw = null;
				}
					
				if (sw != null){
					sw.close();
					sw = null;
				}
					
			} catch (IOException ignore) {
			}
		}
		return retValue;
	}
	
	/**
	 * 类似JavaScript的join, 将指定的字符串连接每个item
	 * @param objs
	 * @param str
	 * @return
	 */
	public static String join(Collection<?> objs, String str){
		return join(objs.toArray(), str);
	}

	/**
	 * 类似JavaScript的join, 将指定的字符串连接每个item
	 * @param objs
	 * @param str
	 * @return
	 */
	public static String join(Object[] objs, String str){
		if(objs.length==0) return "";
		StringBuffer sb = new StringBuffer();
		for (Object object : objs) {
			sb.append((object==null?"":object.toString())+str);
		}
		String s = sb.toString();
		return s.substring(0, s.lastIndexOf(str));
	}
	
	/**
	 * 获得指定Class的泛型类声明
	 * @param c
	 * @param index
	 * @return
	 */
	public static Class<?> getGenericClass(Class<?> c, int index){
		Type[] types = getGenericClass(c);
		if(index>=0 && types.length > index){
			return (Class<?>)types[index];
		}
		return Object.class;
	}
	
	/**
	 * 返回指定Class的泛型类声明数组
	 * @param c
	 * @return
	 */
	public static Type[] getGenericClass(Class<?> c) {
		Type type = c.getGenericSuperclass();
		if (type instanceof ParameterizedType) {
			return ((ParameterizedType)type).getActualTypeArguments();
		}
		return new Type[]{};
	}
	
	public static Field findFieldByMethod(Object instance, String methodname) throws Exception {
		Assert.notNull(instance);
		Assert.notNull(methodname);
		if(methodname.startsWith("get") || methodname.startsWith("set")){
			String name = methodname.substring(2, 3).toLowerCase() + methodname.substring(4);
			return instance.getClass().getDeclaredField(name);
		}
		return null;
	}
	
	public static Method[] findGetAndSetMethod(final Class<?> instanceClass, final Field field) {
		Assert.notNull(instanceClass);
		Assert.notNull(field);
		Method[] rs = new Method[2];
		try {
			String fieldname = field.getName();
			String methodname = fieldname.substring(0, 1).toUpperCase() + fieldname.substring(1);
			String getmethodname = "get" + methodname;
			String setmethodname = "set" + methodname;
			rs[0] = instanceClass.getMethod(getmethodname);
			rs[1] = instanceClass.getMethod(setmethodname, field.getType());
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return rs;
	}
	
	//检查指定的clazz是否是基本类型
	public static boolean isPrimitiveClass(Class<?> clazz){
		Assert.notNull(clazz);
		return clazz.isPrimitive() ||
			clazz.equals(String.class) || 
			clazz.equals(Long.class) || 
			clazz.equals(Integer.class) || 
			clazz.equals(Double.class) || 
			clazz.equals(Float.class) || 
			clazz.equals(Boolean.class) || 
			clazz.equals(Short.class) ||
			clazz.equals(Byte.class) || 
			clazz.equals(Character.class)||
			clazz.equals(Date.class);
			
	}
	
	/**
	 * 把新传过来的对象值(newObject),赋值给旧的对象,用于更新旧对象(UPDATE).
	 * 新旧对象为同一类型,属性应为基本类型.
	 * 
	 * @param newObject
	 * @param oldObject
	 */
	public static Object objectUpdate(Object newObject,Object oldObject) throws Exception{
		if(null == oldObject){
			throw new Exception(newObject.getClass().getSimpleName()+"待更新数据不存在.");
		}
		try {
			String getMethodName;
			Method getMethod;
			Object value;
			Class<?> clazz = newObject.getClass();
			Method[] methods = newObject.getClass().getDeclaredMethods();
			for(int i=0 ; i<methods.length;i++){
				if(methods[i].getName().startsWith("set")){
					getMethodName = "get" + methods[i].getName().substring("set".length());//构造新对象GET方法名
					getMethod = clazz.getDeclaredMethod(getMethodName, null);              //获取新对象GET方法
					value = getMethod.invoke(newObject, null);                             //调用新对象GET方法,取值
					if(null != value){
						methods[i].invoke(oldObject, value);                               //把上面取的新对象属性值赋给旧对象(非空)
					}
			    }
			}
		}  catch (Exception e) {
			//e.printStackTrace();
			log.info("调用SystemUtil.objectUpdate方法对象赋值出错:"+e.getMessage());
		}
		return oldObject;
	}
}
