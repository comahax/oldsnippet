package com.sunrise.boss.ui.commons.combineinput;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

//配置信息map
/**
 * <p>Title: ConfigMap </p>
 * <p>Description: 读取并存放配置信息的Map </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: Sunrise Tech Ltd.</p>
 * @author Zhang Fengchao
 * @since 1.0
 * @version 1.0
 * @date 2007-11-16
 */
public class ConfigMap {
	private final static String CONFIG_FILEPATH = "/com/sunrise/boss/resource/combineinput/combineinput.xml";
	private static HashMap map;
	
	private static String XML_ROOT = "dataconfig";
	private static String XML_NODE = "config";
	private static String XML_DEFINITION = "definition";
	private static String XML_CLASSNAME = "classname";
	private static String XML_TITLE = "title";
	private static String XML_TYPENAME1 = "typename1";
	private static String XML_TYPENAME2 = "typename2";
	private static String XML_DESC = "description";
	private static String XML_RELATEFLAG = "relateflag";
	private static String XML_SYMBOL_MID = "symbol_mid";
	private static String XML_SYMBOL_TAIL = "symbol_tail";
	private static String XML_RETURN_PAGE = "return_page";
	
	private static String RELATEFLAG_TRUE = "true";
	private static String RELATEFLAG_FALSE = "false";
	private static String SYMBOL_DEFAULT = "";
	
	static {
		loadConfig(); 
	}
	
	//获取配置信息
	public static void loadConfig () {
		if (map == null) {
			map = new HashMap();
		}
		try {
			InputStream in = ConfigMap.class.getResourceAsStream(CONFIG_FILEPATH);
			SAXReader saxReader = new SAXReader();
			Document document = saxReader.read(in);
			List list = document.selectNodes(XML_ROOT + "/" + XML_NODE);
	        Iterator iterator = list.iterator();
			while (iterator.hasNext()) {
				Element element = (Element) iterator.next();
				if (element.getName().trim().equalsIgnoreCase(XML_NODE)) {
					Element definition = element.element(XML_DEFINITION);
					Element classname = element.element(XML_CLASSNAME);
					Element title = element.element(XML_TITLE);
					Element typename1 = element.element(XML_TYPENAME1);
					Element typename2 = element.element(XML_TYPENAME2);
					Element description = element.element(XML_DESC);
					Element relateflag = element.element(XML_RELATEFLAG);
					Element symbol_mid = element.element(XML_SYMBOL_MID);
					Element symbol_tail = element.element(XML_SYMBOL_TAIL);
					Element return_page = element.element(XML_RETURN_PAGE);
					
					ConfigBean bean = new ConfigBean();
					bean.setDefinition(definition.getTextTrim()); //定义
					bean.setClassname(classname.getTextTrim()); //对应class名
					bean.setTitle(title.getTextTrim()); //标题
					bean.setTypename1(typename1.getTextTrim()); //类型名
					bean.setTypename2(typename2.getTextTrim()); //类型名
					bean.setDescription(description.getTextTrim()); //说明
					bean.setReturn_page(return_page.getTextTrim()); //说明
					
					//类型关联，默认为true
					bean.setRelateflag(true);
					if (RELATEFLAG_FALSE.equalsIgnoreCase(relateflag.getTextTrim())) {
						bean.setRelateflag(false);
					}
					
					//分割符
					if (symbol_mid.getTextTrim() == null) {
						bean.setSymbol_mid(SYMBOL_DEFAULT);
					} else {
						bean.setSymbol_mid(symbol_mid.getTextTrim());
					}
					
					if (symbol_tail.getTextTrim() == null) {
						bean.setSymbol_tail(SYMBOL_DEFAULT);
					} else {
						bean.setSymbol_tail(symbol_tail.getTextTrim());
					}
					
					map.put(definition.getTextTrim(), bean);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//重新读取配置
	public static void refresh () {
		map.clear();
		loadConfig();
	}
	
	//获取对应配置bean类
	public static ConfigBean getConfigBean(String definition) {
		try {
			return (ConfigBean) map.get(definition);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
