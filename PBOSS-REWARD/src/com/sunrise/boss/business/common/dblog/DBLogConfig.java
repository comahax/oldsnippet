package com.sunrise.boss.business.common.dblog;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * <p>Title: DbLogConfig</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Sunrise </p>
 * @author yjr
 * @version 1.0
 */
public class DBLogConfig {

	private static final Logger log = Logger.getRootLogger();

	private final static String _TABLE = "table";

	private final static String _ID = "id";

	private final static String _NAME = "name";

	private final static String _LOGNAME = "logname";

	private final static String _COLUMN = "column";

	private final static String _LOGCOLUMN = "logcolumn";
	
	private final static String _ACTION = "action";
	
	private final static String _DBLOG_FILEPATH = "/com/sunrise/boss/resource/dblog/dblog.xml";

	private static List dblogList;

	static {
		init();
	}

	public static List getDblogList() {
		return dblogList;
	}

	/**
	 * 根据表名查找得到一个DBLogBean
	 */
	public static DBLogBean getBeanByName(String tablename) throws Exception{
		Iterator iter = dblogList.iterator();
		while (iter.hasNext()){
			DBLogBean bean = (DBLogBean)iter.next();
			if (bean.getTablename()!=null && bean.getTablename().equalsIgnoreCase(tablename)){
				return bean;
			}
		}
		return null;
	}

	/**
	 * 读取XML配置文件
	 */
	private static void init() {
		dblogList = new ArrayList();
		SAXReader saxReader = new SAXReader();
		try {
			InputStream in = DBLogConfig.class.getResourceAsStream(_DBLOG_FILEPATH);
			Document document = saxReader.read(in);
			Element node = document.getRootElement(); // get root Element;
			Iterator iterator = node.elementIterator();

			while (iterator.hasNext()) {
				DBLogBean bean = new DBLogBean();
				HashMap hash = new HashMap();
				
				Element element = (Element) iterator.next();
				if (element.getName().trim().equalsIgnoreCase(_TABLE)) {
					// 记录表名和日志表名称
					Iterator iter = element.attributeIterator();
					while (iter.hasNext()) {
						Attribute attribute = (Attribute) iter.next();
						if (attribute.getName().trim().equalsIgnoreCase(_NAME)) {
							bean.setTablename(attribute.getValue().trim());
						}
						if (attribute.getName().trim().equalsIgnoreCase(_LOGNAME)) {
							bean.setLogname(attribute.getValue().trim());
						}
						if (attribute.getName().trim().equalsIgnoreCase(_ACTION)) {
							bean.setAction(attribute.getValue().trim());
						}
					}

					// 记录对应的字段
					Iterator eleiter = element.elementIterator();
					while (eleiter.hasNext()) {
						Element subelement = (Element) eleiter.next();
						
						if (subelement.getName().trim().equalsIgnoreCase(_ID)) {
							Iterator subiter = subelement.attributeIterator();
							String key = "";
							String value = "";
							while (subiter.hasNext()) {
								Attribute subattribute = (Attribute) subiter.next();
								if (subattribute.getName().trim().equalsIgnoreCase(_COLUMN)) {
									key = subattribute.getValue();
								}
								if (subattribute.getName().trim().equalsIgnoreCase(_LOGCOLUMN)) {
									value = subattribute.getValue();
								}
							}
							
							if (!key.equalsIgnoreCase("")&&value.equalsIgnoreCase("")){
							   hash.put(key, value);
							}
						}
					}
				}
				bean.setMapping(hash);
				dblogList.add(bean);
			}
		} catch (DocumentException e) {
			log.fatal("dblog config init error", e);
			e.printStackTrace();
		}
	}

}
