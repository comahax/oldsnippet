package com.gmcc.pboss.common.bankunite.model.base.response;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;


public class BaseResponse {

	

	/**
	 * 
	 * @param xml
	 * @param cls
	 * @throws Exception
	 */
	public Object readStringXml(String xml, Class cls) throws Exception {
		Document doc = null;
		// ��ȡ������XML�ĵ�
		// SAXReader����һ���ܵ�����һ�����ķ�ʽ����xml�ļ�������
		// 
		// SAXReader reader = new SAXReader(); //User.hbm.xml��ʾ��Ҫ������xml�ĵ�
		// Document document = reader.read(new File("User.hbm.xml"));
		// �������ͨ������xml�ַ�����
		doc = DocumentHelper.parseText(xml); // ���ַ���תΪXML

		Element rootElt = doc.getRootElement(); // ��ȡ���ڵ�
		Iterator iter = rootElt.elementIterator();

		Object obj = cls.newInstance();

		// ������ҳ�����ֵ
		List list = null;

		// ��������ϸ�����
		List arrlist = new ArrayList();

		Map<String,Class> map = this.fieldsNameAndParamType(cls);
		Set<String> kyset = map.keySet();
		
		for (Iterator<String> it = kyset.iterator();it.hasNext();) {
			String firname = it.next();
			Class clss = map.get(firname);


			if (clss == List.class) {
				// �õ�list���϶��������
				Method getMethod = cls.getMethod("getSubCls", new Class[] {});
				Class subcls = (Class) getMethod.invoke(obj, new Object[] {});

				// �õ������еĶ�����¼������ֵ��ÿ������
				List<Node> listnode = doc.selectNodes("//"
						+ firname.toUpperCase());
				// �����ѯ���ж�����¼�Ĵ��ڷ�װ����
				if (listnode.size() != 0) {
					Element firelement = (Element) listnode.get(0);
					for (Iterator<Element> el = firelement.elementIterator(); el
							.hasNext();) {
						Element secelement = el.next();

						// �����Ӷ���
						Object listobj = subcls.newInstance();

						// �Ѿ����ĳ���ڵ��װ��map��
						Map mapnode = this.getMap(secelement);

						// ��map�е�ֵ��ӵ�������
						listobj = this.nodeMapToObj(mapnode, subcls);

						arrlist.add(listobj);
					}
				}
				// �ѷ�װ�����ϸ��Ϣ��ӵ���������
				this.doValToObj(obj, arrlist, firname);
			} else {// ��������ֵ�����
				Object obj1 = map.get(firname).newInstance();
				Map<String,Class> map3 = this.fieldsNameAndParamType(map.get(firname));
				Set<String> kyset3 = map3.keySet();				
				for (Iterator<String> it3 = kyset3.iterator();it3.hasNext();) {
					String firname3 = it3.next();
					Class cl = map3.get(firname3);
				
					// �������Բ���xml�е�ֵ
					list = doc.selectNodes("//" + firname.toUpperCase() + "//"
							+ firname3.toUpperCase());
					if (list != null && list.size() > 0) {
						String node = ((Node) list.get(0)).getText();
						// ��Ӹ������Ե�ֵ
						if (cl == Short.class && node != null && !node.equals("")) {
							this.doSetVal(obj1, firname3, Short
									.parseShort(node), cl);
						} else if (cl == Long.class && node != null && !node.equals("")) {
							this.doSetVal(obj1, firname3, Long
									.parseLong(node), cl);
						} else if (cl == Integer.class && node != null && !node.equals("")) {
							this.doSetVal(obj1, firname3, Integer
									.parseInt(node), cl);
						} else if (cl == Float.class && node != null && !node.equals("")) {
							this.doSetVal(obj1, firname3, Float
									.parseFloat(node), cl);
						} else if (cl == Double.class && node != null && !node.equals("")) {
							this.doSetVal(obj1, firname3, Double
									.parseDouble(node), cl);
						} else if (cl == Boolean.class && node != null && !node.equals("")) {
							this.doSetVal(obj1, firname3, Boolean
									.parseBoolean(node), cl);
						} else if(node != null && !node.equals("")) {
							this.doSetVal(obj1, firname3, node,
									cl);
						}
						
					}					
				}
				// �ѷ�װ�õĶ���ӵ���������ȥ
				this.doValToObj(obj, obj1, firname);
			}
		}

		return obj;

	}

	/**
	 * �õ������set��������
	 * 
	 * @param obj
	 * @return
	 */
	public String[] fieldsName(Object obj) {
		String s[] = new String[] {};
		Method methods[] = obj.getClass().getMethods();
		for (int i = 0; i < methods.length; i++) {
			if (methods[i].getName().substring(0, 3).equals("set")) {
			String name = methods[i].getName().substring(3).toLowerCase();
			s[i] = name;
			}
		}
		return s;
	}

	/**
	 * �õ�������������� �� set�����������͡���
	 * 
	 * @param obj
	 * @return
	 */
	public Map<String, Class> fieldsNameAndParamType(Class obj) {

		Map<String, Class> map = new HashMap<String, Class>();

		Method methods[] = obj.getMethods();
		for (int i = 0; i < methods.length; i++) {
			if (methods[i].getName().substring(0, 3).equals("set")) {
				String name = methods[i].getName().substring(3).toLowerCase();
				map.put(name, methods[i].getParameterTypes()[0]);
			}
		}
		return map;
	}
	
	
	/**
	 * 
	 * @param obj ������
	 * @param Val  ֵ����
	 * @param fiedname  ��������
	 * @throws NoSuchMethodException 
	 * @throws SecurityException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	
	public void  doValToObj(Object obj,Object Val,String fiedname) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		
		String name = "set"+fiedname.substring(0, 1).toUpperCase()+fiedname.substring(1).toLowerCase();		
		Method methods [] = obj.getClass().getMethods();
		for(int i=0;i<methods.length;i++){
			if(methods[i].getName().toUpperCase().equals(name.toUpperCase())){
				methods[i].invoke(obj, Val);
			}
		}
		
		
	}
	
	
	

	/**
	 * ���ݴ���Ķ�������Ը������Ը�ֵ
	 * 
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	public void doSetVal(Object obj, String fieldName, Object val, Class fielclass)
			throws SecurityException, NoSuchMethodException,
			IllegalArgumentException, IllegalAccessException,
			InvocationTargetException {


		String firstLetter = fieldName.substring(0, 1).toUpperCase();
		String getMethodName = "set" + firstLetter + fieldName.substring(1);
		Method setMethod = obj.getClass().getMethod(getMethodName,
				new Class[] { fielclass });
		setMethod.invoke(obj, new Object[] { val });

	}

	/**
	 * �ѽڵ��װ��map��
	 * 
	 */
	public Map getMap(Element element) {
		Map map = new HashMap();
		for (Iterator<Element> it = element.elementIterator(); it.hasNext();) {
			Node element1 = it.next();
			map.put(element1.getName(), element1.getText());
		}
		return map;
	}

	/**
	 * ���ݴ����node map ����װ���� ������
	 * 
	 * @param args
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws InstantiationException 
	 */
	public Object nodeMapToObj(Map map, Class obj2)
			throws IllegalArgumentException, IllegalAccessException,
			SecurityException, NoSuchMethodException, InvocationTargetException, InstantiationException {
		Map<String,Class> map2 = this.fieldsNameAndParamType(obj2);
		Object obj1 = obj2.newInstance();
		
		Set<String> kyset = map.keySet();
		for (Iterator<String> it = kyset.iterator();it.hasNext();) {
			String firname = it.next();
			Class subfiled = map2.get(firname.toLowerCase());
			String node = map.get(firname.toUpperCase()) + "";
			if (node != null) {
				firname = firname.toLowerCase();
				if (subfiled == Short.class  && node != null && !node.equals("")) {
					this.doSetVal(obj1, firname, Short
							.parseShort(node), subfiled);
				} else if (subfiled == Long.class && node != null && !node.equals("")) {
					this.doSetVal(obj1, firname, Long.parseLong(node),
							subfiled);
				} else if (subfiled == Integer.class && node != null && !node.equals("")) {
					this.doSetVal(obj1, firname, Integer
							.parseInt(node), subfiled);
				} else if (subfiled == Float.class && node != null && !node.equals("")) {
					this.doSetVal(obj1, firname, Float
							.parseFloat(node), subfiled);
				} else if (subfiled == Double.class && node != null && !node.equals("")) {
					this.doSetVal(obj1, firname, Double
							.parseDouble(node),subfiled);
				} else if (subfiled == Boolean.class && node != null && !node.equals("")) {
					this.doSetVal(obj1, firname, Boolean
							.parseBoolean(node), subfiled);
				} else if(node != null && !node.equals("")){
					this.doSetVal(obj1, firname, node, subfiled);
				}

			}
		}
		return obj1;
	}

}

