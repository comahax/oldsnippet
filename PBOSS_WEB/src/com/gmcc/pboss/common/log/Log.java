package com.gmcc.pboss.common.log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.gmcc.pboss.common.config.FileConfigAdapter;
import com.gmcc.pboss.common.dictionary.Regex;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.util.CommonUtil;

/**
 * ���˹�˾��������ҵ��
 * @author tangzhu
 * @date Jun 12, 2009
 * ������Ŀ��
 * ����ģ�飺
 * ������������־ͳһ��¼
 */
public class Log {
	/**ҵ����־*/
	public static final String BIZ = "biz";
	/**������־*/
	public static final String ERROR = "error";
	/**��¼��־*/
	public static final String LOGIN = "login";
	/**������־*/
	public static final String CACHE = "cache";
	/**��Ʒ����ר����־*/
	public static final String GOODSREMOTE = "goosremote";
	
	/**
	 * ҵ����־
	 * ��־��ʽ��ʱ��|���������|��������|��Ա����|ҵ�����|ҵ������|ҵ������|��ҵ������|������|������|������Ϣ
	 * 
	 */
	public static void bizLog(String officeTel, String wayid, String employeeid, String serviceCode, 
							String serviceName, short serviceType, int operation, ServiceResult result){
		
        String currDate = CommonUtil.getToday("yyyy-MM-dd HH:mm:ss.SSS");
      //ʱ��|���������|��������|ҵ�����|ҵ������|ҵ������|��ҵ������|������|������|������Ϣ
        StringBuffer content = new StringBuffer();
        content.append(currDate);//ʱ��
        content.append(Regex.UPRIGHT_LOG);
      //���������
        content.append(officeTel);
        content.append(Regex.UPRIGHT_LOG);
      //��������
        content.append(wayid);
        content.append(Regex.UPRIGHT_LOG);
      //��Ա����
        content.append(employeeid);
        content.append(Regex.UPRIGHT_LOG);
      //ҵ�����
        content.append(serviceCode);
        content.append(Regex.UPRIGHT_LOG);
      //ҵ������
        content.append(serviceName);
        content.append(Regex.UPRIGHT_LOG);
        
      //ҵ������
        content.append(serviceType);
        content.append(Regex.UPRIGHT_LOG);
      //��ҵ������
        content.append(operation);
        content.append(Regex.UPRIGHT_LOG);
       
      //��¼���(0�ɹ���1ʧ��)
        content.append((result.isSuccess())?0:1);
        content.append(Regex.UPRIGHT_LOG);
      //������
        content.append(result.getRetCode());
        content.append(Regex.UPRIGHT_LOG);
      //�������
        content.append(result.getMessage());
        content.append("\n");
        
        saveLog(content.toString(),BIZ);
	}
	
	/**
	 * ��¼��־
	 * ��־��ʽ��ʱ��|�ֻ�����|�Ƿ�ɹ�|������|����
	 */
	public static void loginLog(String officeTel, ServiceResult result){
        
        String currDate = CommonUtil.getToday("yyyy-MM-dd HH:mm:ss.SSS");
        //��־��ʽ��ʱ��|�ֻ�����|��¼��ʽ|�Ƿ�ɹ�|������|����
        StringBuffer content = new StringBuffer();
        content.append(currDate);//ʱ��
        content.append(Regex.UPRIGHT_LOG);
        
        content.append(officeTel);//�ֻ�����
        content.append(Regex.UPRIGHT_LOG);
        
        //content.append(loginType);//��¼��ʽ
        //content.append(Regex.UPRIGHT_LOG);
        
        content.append((result.isSuccess())?0:1);//��¼���(0�ɹ���1ʧ��)
        content.append(Regex.UPRIGHT_LOG);
        
        content.append(result.getRetCode());//������
        content.append(Regex.UPRIGHT_LOG);
        
        content.append(result.getMessage());//�������
        content.append("\n");
       
        saveLog(content.toString(),LOGIN);
	}
	
	/**
	 * ��¼��־
	 * ��־��ʽ��ʱ��|�ֻ�����|�Ƿ�ɹ�|����|������|����|����ʱ��
	 */
	public static void loginLog(String officeTel, ServiceResult result, long starttime, String cityid){
        
        String currDate = CommonUtil.getToday("yyyy-MM-dd HH:mm:ss.SSS");
        //��־��ʽ��ʱ��|�ֻ�����|��¼��ʽ|�Ƿ�ɹ�|������|����
        StringBuffer content = new StringBuffer();
        content.append(currDate);//ʱ��
        content.append(Regex.UPRIGHT_LOG);
        
        content.append(officeTel);//�ֻ�����
        content.append(Regex.UPRIGHT_LOG);
        
        //content.append(loginType);//��¼��ʽ
        //content.append(Regex.UPRIGHT_LOG);
        
        content.append((result.isSuccess())?0:1);//��¼���(0�ɹ���1ʧ��)
        content.append(Regex.UPRIGHT_LOG);
        
        content.append(cityid);//���б�ʶ
        content.append(Regex.UPRIGHT_LOG);
                
        content.append(result.getRetCode());//������
        content.append(Regex.UPRIGHT_LOG);
        
        content.append(result.getMessage());//�������
        content.append(Regex.UPRIGHT_LOG);
        
        long endtime = System.currentTimeMillis();
        content.append(endtime-starttime);
        
        content.append("\n");
       
        saveLog(content.toString(),LOGIN);
	}
	
	/**
	 * �쳣��־
	 * ��־��ʽ��ʱ��|���������|��������|��Ա����|ҵ�����|ҵ������|ҵ������|��ҵ������|Exception+Message
	 */
	public static void errorLog(String officeTel, String wayid, String employeeid, String serviceCode, String serviceName, 
			short serviceType, int operation ,String msg ){

		String currDate = CommonUtil.getToday("yyyy-MM-dd HH:mm:ss.SSS");
		
        StringBuffer content = new StringBuffer();
        content.append(currDate);//ʱ��
        content.append(Regex.UPRIGHT_LOG);
      //���������
        content.append(officeTel);
        content.append(Regex.UPRIGHT_LOG);
      //��������
        content.append(wayid);
        content.append(Regex.UPRIGHT_LOG);
      //��Ա����
        content.append(employeeid);
        content.append(Regex.UPRIGHT_LOG);
      //ҵ�����
        content.append(serviceCode);
        content.append(Regex.UPRIGHT_LOG);
      //ҵ������
        content.append(serviceName);
        content.append(Regex.UPRIGHT_LOG);
      //��������
        content.append(serviceType);
        content.append(Regex.UPRIGHT_LOG);
        
        content.append(operation);
        content.append(Regex.UPRIGHT_LOG);
        
      //MSG
        content.append(msg);
        content.append("\n");
        
        saveLog(content.toString(),ERROR);
	}
	/**
	 * ������־
	 * ��־��ʽ��ʱ��|ҵ�����|ҵ������|ִ�н��
	 * @param serviceCode
	 * @param serviceName
	 * @param msg
	 */
	public static void cacheLog(String serviceCode,String serviceName,String msg){
		String currDate = CommonUtil.getToday("yyyy-MM-dd HH:mm:ss.SSS");
		
		StringBuffer content = new StringBuffer();
        content.append(currDate);//ʱ��
        content.append(Regex.UPRIGHT_LOG);
		
      //ҵ�����
        content.append(serviceCode);
        content.append(Regex.UPRIGHT_LOG);
      //ҵ������
        content.append(serviceName);
        content.append(Regex.UPRIGHT_LOG);
//      //���ؽ����
//        content.append(retCode);
//        content.append(Regex.UPRIGHT_LOG);
      //MSG
        content.append(msg);
        content.append("\n");
        
        saveLog(content.toString(),CACHE);
	}
	
	/**
	 * �ӿڵ�����־
	 * @param serviceCode :ServiceCode
	 * @param serviceName :ServiceName
	 * @param intetfaceName:�ӿ���
	 * @param wayid: ����Wayid
	 * @param rtnCode :�ӿڷ�����
	 * @param msg:��Ϣ
	 */
	public static void remoteLog(String serviceCode,String serviceName,
			String intetfaceName,String wayid,int rtnCode,String msg){

		String currDate = CommonUtil.getToday("yyyy-MM-dd HH:mm:ss.SSS");
		
		StringBuffer content = new StringBuffer();
        content.append(currDate);//ʱ��
        content.append(Regex.UPRIGHT_LOG);

        //ҵ�����
          content.append(serviceCode);
          content.append(Regex.UPRIGHT_LOG);
        //ҵ������
          content.append(serviceName);
          content.append(Regex.UPRIGHT_LOG);

          content.append(intetfaceName);
          content.append(Regex.UPRIGHT_LOG);
          
          content.append(wayid);
          content.append(Regex.UPRIGHT_LOG);

          content.append("[������:"+ rtnCode +"]");
          content.append(Regex.UPRIGHT_LOG);
          
          content.append(msg);
          content.append("\n");
        
		saveLog(content.toString(),GOODSREMOTE);
	}
	/**
	 * ������־
	 * @param content 	��־����
	 * @param type		��־����
	 */
	private static void saveLog(String content, String type){
		//���·��
		String path = getLogPath(type);
		
		//����Ŀ¼
    	createDirs(path);
    	
    	StringBuffer logFile = new StringBuffer();
    	String suffixion = ".log";
    	//ȫ·��
    	//String pattern = (type.equalsIgnoreCase(CACHE))?"yyyyMM":"yyyyMMdd";
    	logFile.append(path).append(getPrefixion(type))
    		   .append(Regex.UNDERLINE).append(CommonUtil.getToday("yyyyMMdd"))
    		   .append(suffixion);
    	
    	try {
			//д��
			FileWriter writer = new FileWriter(logFile.toString(), true);
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * �����־ǰ׺
	 * @param type ��־����
	 * @return
	 */
	private static String getPrefixion(String type){
		StringBuffer p = new StringBuffer();
		if(type.equals(BIZ))
			p.append('b').append('i').append('z');
		else if(type.equals(ERROR))
			p.append('e').append('r').append('r').append('o').append('r');
		else if(type.equals(LOGIN))
			p.append('l').append('o').append('g').append('i').append('n');
		else if(type.equals(CACHE))
			p.append('c').append('a').append('c').append('h').append('e');
		else if(type.equals(GOODSREMOTE))
			p.append('r').append('e').append('m').append('o').append('t').append('e');
		return p.toString();
	}
	
	/**
	 * ����·�������ļ���
	 * @param path
	 */
	private static void createDirs(String path){
		File file = new File(path);
		if(!file.exists()){
			file.mkdirs();
		}
	}
	
	/**
	 * �����־����·��
	 * @param type
	 * @return
	 */
	private static String getLogPath(String type){
		String path = FileConfigAdapter.getLogPath();
		StringBuffer sb = new StringBuffer();
		sb.append(path).append(type).append(Regex.SKEWLINE);
		return sb.toString();
	}
}
