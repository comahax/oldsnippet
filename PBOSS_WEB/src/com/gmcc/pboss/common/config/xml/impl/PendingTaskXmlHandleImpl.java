package com.gmcc.pboss.common.config.xml.impl;

import java.io.File;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.gmcc.pboss.common.config.FileConfigAdapter;
import com.gmcc.pboss.common.config.bean.PendingTaskConfigBean;
import com.gmcc.pboss.common.config.exception.FileConfigException;
import com.gmcc.pboss.common.config.xml.IXmlHandle;
import com.gmcc.pboss.common.file.bean.FileHandleConfig;
import com.gmcc.pboss.common.util.CommonUtil;

/**
 * 从兴公司电子渠道业务部
 * @author tangzhu
 * @date 2009-11-17
 * 所属项目：PBOSS
 * 所属模块：门户网站
 * 描述：待办任务配置文件处理
 */
public class PendingTaskXmlHandleImpl implements IXmlHandle {
	
	private static Logger logger = Logger.getLogger(PendingTaskXmlHandleImpl.class);
	
	public void load(File file, Hashtable hashtable) throws Exception {
		// TODO Auto-generated method stub
		logger.info(">>>解析待办任务配置文件");
		
		SAXReader reader = new SAXReader();
        Document doc = reader.read(file);
        Element root = doc.getRootElement();
//        
        Map<String,PendingTaskConfigBean> taskes = new Hashtable<String,PendingTaskConfigBean>();
        
        Element foo;
        for(Iterator i = root.elementIterator("TASK"); i.hasNext();){
        	foo = (Element) i.next();
        	PendingTaskConfigBean bean = new PendingTaskConfigBean();
        	
        	String name = foo.elementText("NAME").trim();
        	String titel = foo.elementText("TITEL").trim();
        	String url = foo.elementText("URL").trim();
        	String plantime = foo.elementText("PLANTIME").trim();
        	String desttype = foo.elementText("DESTTYPE").trim();
        	String smsnotify = foo.elementText("SMSNOTIFY").trim();
        	String ndapproval = foo.elementText("NDAPPROVAL").trim();
        	String state = foo.elementText("STATE").trim();
        	
        	bean.setName(name);
        	bean.setTitel(titel);
        	bean.setUrl(url);
        	
        	if(!CommonUtil.isEmptyOrNull(plantime)	)
        		bean.setPlantime(Integer.parseInt(plantime));
        	if(!CommonUtil.isEmptyOrNull(desttype))
        		bean.setDesttype(Integer.parseInt(desttype));
        	if(!CommonUtil.isEmptyOrNull(smsnotify))
        		bean.setSmsnotify(Integer.parseInt(smsnotify));
        	if(!CommonUtil.isEmptyOrNull(ndapproval))
        		bean.setNdapproval(Integer.parseInt(ndapproval));
        	if(!CommonUtil.isEmptyOrNull(state))
        		bean.setState(Integer.parseInt(state));
        	
        	taskes.put(name, bean);
        }//end for
        
        hashtable.put("PENDINGTASK_FILE", taskes);
	}
	/**
	public static void main(String[] args) {
		IXmlHandle handle = new PendingTaskXmlHandleImpl();
		
		FileConfigAdapter fileConfig;
		try {
			fileConfig = FileConfigAdapter.init();
			fileConfig.loadProperty("PENDINGTASK_FILE", "PENDINGTASK_FILE", handle);
			
			//System.out.println(bean.getUploadFiles().get("INDAGATE_QUESTIONNAIRE").toString());
		} catch (FileConfigException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/
}
