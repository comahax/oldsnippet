package net.gmcc.pboss.domain.business.syshelper;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;

import org.apache.log4j.Logger;

import com.thoughtworks.xstream.XStream;

/**
 * 对象的序列化处理与反序列化处理类
 * 将请求对象序列化为XML文件,后续进行反序列化处理
 * 
 * @time 2011-8-8 下午04:19:20
 *
 */
public class SerializeHelper {

	protected static final Logger log = Logger.getLogger(SerializeHelper.class);
	
	/**
	 * 对象序列化为XML数据
	 * fileName: CommandId_TransID.xml
	 * 
	 * @param obj
	 * @param fileName
	 */
	public static String serializeToXml(Object obj){
		String retXML = null;
        XStream xstream = new XStream();  
        try{
        	ByteArrayOutputStream bos = new ByteArrayOutputStream();
            xstream.toXML(obj,bos);
            bos.flush();
            retXML = bos.toString();
            bos.close();
         } catch (Exception e) {
            log.info(obj.getClass()+"对象序列化出错!"+e.getMessage());
         }
         return retXML;
    }

	/**
	 * 将XML文件反序列化为对象
	 * 
	 * @param fileName
	 * @return
	 */
    public static Object deSerializeFromXml(String fileName) throws Exception{
         XStream xstream = new XStream();
         Object obj = null;
         try {
	         BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileName));
	         obj = xstream.fromXML(bis);
	         bis.close();
         } catch (Exception e) {
        	// log.info(fileName+" XML文件反序列化出错!"+e.getMessage());
        	 throw new Exception(fileName+" XML文件反序列化出错!"+e.getMessage());
         }
         return obj;
    }
    
}
