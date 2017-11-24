package com.sunrise.boss.common.utils;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.PropertyResourceBundle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import com.sunrise.boss.common.utils.sysinfo.SysInfo;

public class ResourceFactory {
	private static Log log = LogFactory.getLog(ResourceFactory.class);

	private static ResourceFactory rf = null;

	private Map msgMap = new HashMap();

	public static ResourceFactory getInstance() {
		if (rf == null)
			rf = new ResourceFactory();
		return rf;
	}

	public String getMessage(String key) {
		if (msgMap.get(key) == null)
			return "";
		return (String) msgMap.get(key);
	}

	public String getMessage(String key, Locale loc) {
		String lang = "";
		if (loc == Locale.CHINA || loc == Locale.CHINESE
				|| loc == Locale.SIMPLIFIED_CHINESE
				|| loc.getCountry().equals("CN"))
			lang = "cn";
		return (String) msgMap.get(key + "-" + lang);
	}

	private ResourceFactory() {
		try {
			URL xmlurl = getClass().getResource(SysInfo.RESOURCE_REG_PATH);
			SAXReader reader = new SAXReader();
			Document doc = reader.read(xmlurl);
			Element rootElement = doc.getRootElement();
			String lang = "en";
			for (Iterator i = rootElement.element("resfilelist")
					.elementIterator("resfile"); i.hasNext();) {
				Element resFileElm = (Element) i.next();
				PropertyResourceBundle prs = new PropertyResourceBundle(this
						.getClass().getResourceAsStream(
								SysInfo.RESOURCE_SAVE_PATH
										+ resFileElm.attributeValue("path")));
				// "/com/sunrise/boss/resource/"
				lang = resFileElm.attributeValue("lang");
				Enumeration e = prs.getKeys();
				while (e.hasMoreElements()) {
					String key = (String) e.nextElement();
					if (lang.equals("en"))
						msgMap.put(key, prs.getString(key));
					else
						msgMap.put(key + "-" + lang, prs.getString(key));
					log.info("key:" + key + "  value:" + prs.getString(key));
				}
			}
		} catch (IOException ioe) {
			log.error("IOException:", ioe);
		} catch (Exception e) {
			log.error("Exception:", e);
		}
	}

	public static void main(String[] args) {
		ResourceFactory rf = ResourceFactory.getInstance();
		log.info(rf.getMessage("lang", Locale.getDefault()));
	}
}
