package net.gmcc.pboss.domain.additional.xmldispatch;

import java.io.BufferedWriter;
import java.io.File;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import net.gmcc.pboss.pboss4crmservice.Msgreqheader;
import net.gmcc.pboss.domain.business.syshelper.SerializeHelper;
import net.gmcc.pboss.utils.FileUtil;
import net.gmcc.pboss.utils.StringUtil;

@Component
public class XMLDispatcher {
	
	private static final Logger log = Logger.getLogger(XMLDispatcher.class);
	
	//文件分发相关参数
	//将对象序列化为XML格式的内容并写入文件
//	public static String OCEFilePath = "OCE/";//OCE文件目录
	public static String AccountPath = "Account/";//账务文件目录
	public static String OffLinePath = "OffLine/";//离线文件目录
	public static Long OffLineSubPathNum = 10L;//离线子文件夹数
	
	//根据协议组文件内容,具体处理在每个接口中
	public static String ProvincePath = "Province/";//省中心文件目录
	
	public static String dispatchType = "";//分发开关 0:OCE,1:离线,2:OCE+离线,3或其他:不分发;十分钟加载一次
	public static boolean isInit = false;
	
	//对象映射为XML
	private static JAXBContext jc;
//	private static Unmarshaller u;
//	private static Marshaller m; //Marshaller 多线程处理会出错.JAXB不给力啊 - -!

	static{
    	try {
			jc = JAXBContext.newInstance("net.gmcc.pboss.pboss4crmservice" );//  com.gmcc.hsc.webservice
//			u = jc.createUnmarshaller();
//			m = jc.createMarshaller();
		} catch (JAXBException e) {
			log.info("初始化映射对象失败!"+e.getMessage());
		}
    }
	
	public static void createAccountPath(){
		try {
			File file = new File(AccountPath);
			if(!file.isDirectory()){
				file.mkdirs();
			}
			log.info("账务文件夹创建成功");
		} catch (Exception e) {
			log.info("账务文件夹创建失败"+e.getMessage());
		}
	}
	
	
	public static void createOffLinePath(){
		try {
			File file;
			for(int i=0;i<OffLineSubPathNum; i++){
				file = new File(OffLinePath + i + "/");//e.g : OffLine/1/
				if(!file.isDirectory()){
					file.mkdirs();
				}
			}
			log.info("离线文件夹创建成功");
		} catch (Exception e) {
			log.info("离线文件夹创建失败"+e.getMessage());
		}
	}
	
	public static void createProvincePath(){
		try {
			File file = new File(ProvincePath);
			if(!file.isDirectory()){
				file.mkdirs();
			}
			log.info("省中心文件夹创建成功");
		} catch (Exception e) {
			log.info("省中心文件夹创建失败"+e.getMessage());
		}
	}
	
	
	/**
	 * 文件分发处理
	 */
	public void  dispatch(Object obj, Msgreqheader reqHeader){
		//System.out.println("-----I am in XMLDispatcher.dispatch()");
//		String transID = reqHeader.getTransID();
//		String transIdLog = "["+transID+"]---->";
//		if("2".equals(dispatchType) || "0".equals(dispatchType) || "1".equals(dispatchType)){
//			String commandID = reqHeader.getCommandId(); 
//			String msisdn = reqHeader.getMsisdn();
//			Long offLineSubPath = 0L;//手机号码为空 或 模为0
//			if(StringUtil.checkNullAndBlank(msisdn)){
//				offLineSubPath = (Long.valueOf(msisdn)%OffLineSubPathNum);
//			}
//			String tmpOffLinePath = OffLinePath + offLineSubPath + "/";//写到子目录
//			try {
//				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
//				log.info(transIdLog+simpleDateFormat.format(new Date()));
//				
//				//将对象映射为XML
//				StringWriter stringWriter = new StringWriter();
//				
//				if(null == obj){
//					log.info(transIdLog+"待处理对象为空,不进行对象转换为文件的处理");
//					return;
//				}
//
//				String offlinexml = null;
//				if("2".equals(dispatchType) || "1".equals(dispatchType)){//离线文件内容
//					try {
//						Marshaller m = jc.createMarshaller();//Marshaller 多线程处理有问题,每次都要用新的shaller对象来处理
//						m.marshal(obj, stringWriter);//离线
//					} catch (Exception e) {
//						log.info(transIdLog+"对象映射为XML报文出错."+e.getMessage());
//						log.info(transIdLog+"初始化MARSHALLER.");
//						//有时会出现 java.lang.ArrayIndexOutOfBoundsException 的错误(多线程处理问题),Marshaller要进行重新初始化.
//						Marshaller m = jc.createMarshaller();
//						m.marshal(obj, stringWriter);//离线
//					}
//					stringWriter.flush();//因为这个出现空文件? 
//					offlinexml = getRequestMessage(stringWriter.toString());//GBK
//					log.info(transIdLog+"OffLine:"+offlinexml.length());
//				}
//				
//				//将对象序列化
//				String accountxml = null;
//				if("2".equals(dispatchType) || "0".equals(dispatchType)){//账务文件内容
//					try {
//						accountxml = SerializeHelper.serializeToXml(obj);
//						log.info(transIdLog+"Acount:"+accountxml.length());//GBK
//					} catch (Exception e) {
//						log.info(transIdLog+"对象序列化为XML报文出错."+e.getMessage());
//						e.printStackTrace();
//					}
//				}
//				log.info(transIdLog+"开始进行文件分发.");
//				String fileName = commandID+"_"+transID+".xml";
//				if("2".equals(dispatchType)){
//					log.info(transIdLog+"XML报文文件分发开关为:"+ dispatchType+" 将写账务和离线文件");
//					FileUtil.writeFileUTF8(AccountPath+fileName,accountxml,false);//GBK - -!! 悲剧,转了半天,还是要UTF-8,反序列化才不会有乱码 TIHS!
//					FileUtil.writeFileUTF8(tmpOffLinePath+fileName,offlinexml,false);//UTF-8
//				}else if("0".equals(dispatchType)){
//					log.info(transIdLog+"XML报文文件分发开关为:"+ dispatchType+" 将只写账务文件");
//					FileUtil.writeFileUTF8(AccountPath+fileName,accountxml,false);//GBK  --> UTF-8
//				}else if("1".equals(dispatchType)){
//					log.info(transIdLog+"XML报文文件分发开关为:"+ dispatchType+" 将只写离线文件");
//					FileUtil.writeFileUTF8(tmpOffLinePath+fileName,offlinexml,false);//UTF-8
//				}
//				log.info(transIdLog+"文件("+fileName+")分发成功.");
//				log.info(transIdLog+simpleDateFormat.format(new Date()));
//				
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				log.info(transIdLog+"文件生成过程出错."+e.getMessage());
//				e.printStackTrace();
//			}
//		}else if("3".equals(dispatchType)){//不发送
//			log.info(transIdLog+"XML报文文件分发开关为:"+ dispatchType+",不进行文件分发.");
//		}else{
//			log.info(transIdLog+"文件分发开关无法识别,不进行文件分发.");
//		}
		//System.out.println("-----I am out XMLDispatcher.dispatch()");
	}
	
	/**
	 * 截取离线需要的报文
	 * 
	 * @param request
	 * @return
	 */
	public String getRequestMessage(String request){
		String retRequestMessage = request;
		try {
			int start = request.indexOf("<RequestMessage>");
			int end = request.indexOf("</RequestMessage>");
			if(start>0 && end > 0 && start< end){
				retRequestMessage = request.substring(start,end+"</RequestMessage>".length());
			}
		} catch (Exception e) {
			log.info("截取报文内容出错."+e.getMessage()+ " ### " +request);
		}
		return retRequestMessage;
	}               
}
