package com.gmcc.pboss.common.bankunite.model.base.request;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BaseRequest {

	public static String FIRSTELEMENT = "info";
	public static String SECONDELEMENT = "trans_Sum";
	public static String SECONDDEALDATAELEMENT = "query_trans";
	public static String THIRDELEMENT = "trans_Details";

	/**
	 * 把本类对象转换成xml报文形式
	 */
	public String toXml(BaseRequest recBatchRequest) throws Exception {
		StringBuffer sbu = new StringBuffer(
				"<?xml version=\"1.0\" encoding=\"GBK\"?><GZELINK>");

		StringBuffer sbuinfo = new StringBuffer();

		StringBuffer subtrans_Sum = new StringBuffer();

		StringBuffer subtrans_Details = new StringBuffer();

		// 属性和值的map
		Map<String, Object> map = this.methodsName(recBatchRequest);
		Map<String, Class> mapClass = this
				.methodsReturnValType(recBatchRequest);
		Set<String> set = map.keySet();
		for (Iterator<String> it = set.iterator(); it.hasNext();) {
			String name = it.next();
			Object objvalue = map.get(name);
			Class clss = mapClass.get(name);
			// 第二层
			if (name.equals(BaseRequest.FIRSTELEMENT.toLowerCase())) {// 基本信息

				sbuinfo.append(this.addBefoSign(name));

				Object baseInfoReq = null;
				if (objvalue == null) {
					baseInfoReq = clss.newInstance();
				} else {
					baseInfoReq = objvalue;
				}

				Map<String, Object> baseInfoReqmap = this
						.methodsName(baseInfoReq);

				Set<String> baseInfoReqset = baseInfoReqmap.keySet();
				for (Iterator<String> baseInfoReqit = baseInfoReqset.iterator(); baseInfoReqit
						.hasNext();) {

					String baseInfoReqname = baseInfoReqit.next();

					if (baseInfoReqmap.get(baseInfoReqname) != null) {
						sbuinfo.append(this.addBefoSign(baseInfoReqname));
						sbuinfo.append(baseInfoReqmap.get(baseInfoReqname));
						sbuinfo.append(this.addAfterSign(baseInfoReqname));
					} else {
						sbuinfo.append(this.addNoSign(baseInfoReqname));
					}

				}

				sbuinfo.append(this.addAfterSign(name));

			} else if (name.equals(BaseRequest.SECONDELEMENT.toLowerCase()) || name.equals(BaseRequest.SECONDDEALDATAELEMENT.toLowerCase())) {// 汇总信息
				subtrans_Sum.append(this.addBefoSign(name));

				Object baseSumReq = null;
				if (objvalue == null) {
					baseSumReq = clss.newInstance();
				} else {
					baseSumReq = objvalue;
				}

				Map<String, Object> baseSumReqmap = this
						.methodsName(baseSumReq);
				Set<String> baseSumReqReqset = baseSumReqmap.keySet();
				for (Iterator<String> baseSumReqReqit = baseSumReqReqset
						.iterator(); baseSumReqReqit.hasNext();) {

					String baseSumReqname = baseSumReqReqit.next();
					if (baseSumReqmap.get(baseSumReqname) != null) {
						subtrans_Sum.append(this.addBefoSign(baseSumReqname));
						subtrans_Sum.append(baseSumReqmap.get(baseSumReqname));
						subtrans_Sum.append(this.addAfterSign(baseSumReqname));
					} else {
						subtrans_Sum.append(this.addNoSign(baseSumReqname));
					}

				}

				subtrans_Sum.append(this.addAfterSign(name));

			} else if (name.equals(BaseRequest.THIRDELEMENT.toLowerCase())) {// 明细信息
				subtrans_Details.append(this.addBefoSign(name));

				List trans_Details = null;
				if (objvalue == null) {
					trans_Details = List.class.newInstance();
				} else {
					trans_Details = (List) objvalue;
				}

				for (Iterator trans_Detailsit = trans_Details.iterator(); trans_Detailsit
						.hasNext();) {
					Object baseDetailsReq = trans_Detailsit.next();
					Map<String, Object> BaseDetailsReqmap = this
							.methodsName(baseDetailsReq);
					Set<String> BaseDetailsReqReqset = BaseDetailsReqmap
							.keySet();
					subtrans_Details.append(this.addBefoSign("TRANS_DETAIL"));
					for (Iterator<String> BaseDetailsReqReqit = BaseDetailsReqReqset
							.iterator(); BaseDetailsReqReqit.hasNext();) {
						String BaseDetailsReqname = BaseDetailsReqReqit.next();

						if (BaseDetailsReqmap.get(BaseDetailsReqname) != null) {
							subtrans_Details.append(this
									.addBefoSign(BaseDetailsReqname));
							subtrans_Details.append(BaseDetailsReqmap
									.get(BaseDetailsReqname));
							subtrans_Details.append(this
									.addAfterSign(BaseDetailsReqname));
						} else {
							subtrans_Details.append(this
									.addNoSign(BaseDetailsReqname));
						}
					}
					subtrans_Details.append(this.addAfterSign("TRANS_DETAIL"));
				}

				subtrans_Details.append(this.addAfterSign(name));
			}

		}

		sbu.append(sbuinfo.toString()).append(this.addBefoSign("body")).append(
				subtrans_Sum.toString()).append(subtrans_Details.toString())
				.append(this.addAfterSign("body")).append("</GZELINK>");

		return sbu.toString();
	}

	/**
	 * 添加前标记
	 * 
	 * @param s
	 * @return
	 */
	private String addBefoSign(String s) {
		return "<" + s.toUpperCase() + ">";
	}

	/**
	 * 添加后标记
	 * 
	 * @param s
	 * @return
	 */
	private String addAfterSign(String s) {
		return "</" + s.toUpperCase() + ">";
	}

	/**
	 * 没有值的标记
	 * 
	 * @param s
	 * @return
	 */
	private String addNoSign(String s) {
		return "<" + s.toUpperCase() + "/>";
	}

	/**
	 * 根据提供的属性来查找对象中的值
	 * 
	 * @param fields
	 *            对象所有属性
	 * @param o
	 * @return
	 * @throws Exception
	 */
	private Map<String, Object> field2Value(Field[] fields, Object o)
			throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		Class classType = o.getClass();
		for (int i = 0; i < fields.length; i++) {
			String fieldName = fields[i].getName();
			String firstLetter = fieldName.substring(0, 1).toUpperCase();
			String getMethodName = "get" + firstLetter + fieldName.substring(1);
			Method getMethod = classType.getMethod(getMethodName,
					new Class[] {});
			map.put(fieldName, getMethod.invoke(o, new Object[] {}));
		}
		return map;
	}

	/**
	 * 根据已知对象得到对象的值的map键值对
	 * 
	 * @param obj
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */

	public Map<String, Object> methodsName(Object obj)
			throws IllegalArgumentException, IllegalAccessException,
			InvocationTargetException {

		Map<String, Object> map = new HashMap<String, Object>();

		Method methods[] = obj.getClass().getMethods();

		for (int i = 0; i < methods.length; i++) {
			if (methods[i].getName().substring(0, 3).equals("get")
					&& !methods[i].getName().equals("getClass")) {
				String name = methods[i].getName().substring(3).toLowerCase();
				map.put(name, methods[i].invoke(obj, new Object[] {}));
			}

		}
		return map;
	}

	/**
	 * 根据已知对象得到对象的属性名称和属性get方法返回值类型
	 * 
	 * @param obj
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public Map<String, Class> methodsReturnValType(Object obj)
			throws IllegalArgumentException, IllegalAccessException,
			InvocationTargetException {

		Map<String, Class> map = new HashMap<String, Class>();

		Method methods[] = obj.getClass().getMethods();

		for (int i = 0; i < methods.length; i++) {
			if (methods[i].getName().substring(0, 3).equals("get")
					&& !methods[i].getName().equals("getClass")) {
				String name = methods[i].getName().substring(3).toLowerCase();
				map.put(name, methods[i].getReturnType());
			}

		}
		return map;
	}

}
