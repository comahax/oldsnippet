package net.gmcc.pboss.domain.business.interceptor;

import java.io.InputStream;

import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.interceptor.AbstractLoggingInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.interceptor.LoggingMessage;
import org.apache.cxf.io.CachedOutputStream;
import org.apache.cxf.message.Message;
import org.apache.log4j.Logger;


/**  
 * 自定义拦截器,获取报文内容  
 */  
public class SoapInInterceptor extends AbstractLoggingInterceptor {   
	private static final Logger log = Logger.getLogger(SoapInInterceptor.class);
    private static String soapBodyStartTag = "<soap:Body>";
    private static String soapBodyEndTag = "</soap:Body>";
       
    public SoapInInterceptor() {   
    	super("receive"); 
    }   
  
    public void handleMessage(Message message) throws Fault {   
        try {   
            log.info("---------------------------记录webservice日志---------------------------");
            LoggingMessage buffer = new LoggingMessage("","");
            String encoding = (String) message.get(Message.ENCODING);
            if (encoding != null){
    			buffer.getEncoding().append(encoding);
            }
    		String ct = (String) message.get("Content-Type");
    		if (ct != null){
    			buffer.getContentType().append(ct);
    		}
    		InputStream is = (InputStream) message.getContent(InputStream.class);
    		if (is != null) {
    			CachedOutputStream bos = new CachedOutputStream();
    			try {
    				IOUtils.copy(is, bos);
    				bos.flush();
    				is.close();
    				message.setContent(InputStream.class, bos.getInputStream());
    				writePayload(buffer.getPayload(), bos, encoding, ct);
    				bos.close();
    			} catch (Exception e) {
    				throw new Fault(e);
    			}
//    			System.out.println(buffer.getPayload());//打印返回报文
    			log.info("接收报文内容为:"+getSoapBody(buffer.getPayload().toString()));
    		}
        } catch (Exception e) {   
            e.printStackTrace();   
        }   
    }   
    
    /**
     * 获取报文体
     * 
     * @param soapEnvelope
     * @return
     */
    public String getSoapBody(String soapEnvelope){
    	String soapBody = null;
    	int start = soapEnvelope.indexOf(soapBodyStartTag);
    	int end = soapEnvelope.indexOf(soapBodyEndTag);
    	if(start > 0 && end >0){
    		soapBody = soapEnvelope.substring(start+soapBodyStartTag.length(),end);
    	}
    	return soapBody != null ? soapBody:soapEnvelope;
    }
} 
