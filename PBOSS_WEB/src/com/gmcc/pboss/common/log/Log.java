package com.gmcc.pboss.common.log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.gmcc.pboss.common.config.FileConfigAdapter;
import com.gmcc.pboss.common.dictionary.Regex;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.util.CommonUtil;

/**
 * 从兴公司电子渠道业务部
 * @author tangzhu
 * @date Jun 12, 2009
 * 所属项目：
 * 所属模块：
 * 描述：关于日志统一记录
 */
public class Log {
	/**业务日志*/
	public static final String BIZ = "biz";
	/**错误日志*/
	public static final String ERROR = "error";
	/**登录日志*/
	public static final String LOGIN = "login";
	/**缓存日志*/
	public static final String CACHE = "cache";
	/**商品订购专项日志*/
	public static final String GOODSREMOTE = "goosremote";
	
	/**
	 * 业务日志
	 * 日志格式：时间|公务机号码|渠道编码|人员编码|业务编码|业务名称|业务类型|子业务类型|办理结果|返回码|描述信息
	 * 
	 */
	public static void bizLog(String officeTel, String wayid, String employeeid, String serviceCode, 
							String serviceName, short serviceType, int operation, ServiceResult result){
		
        String currDate = CommonUtil.getToday("yyyy-MM-dd HH:mm:ss.SSS");
      //时间|公务机号码|渠道编码|业务编码|业务名称|业务类型|子业务类型|办理结果|返回码|描述信息
        StringBuffer content = new StringBuffer();
        content.append(currDate);//时间
        content.append(Regex.UPRIGHT_LOG);
      //公务机号码
        content.append(officeTel);
        content.append(Regex.UPRIGHT_LOG);
      //渠道编码
        content.append(wayid);
        content.append(Regex.UPRIGHT_LOG);
      //人员编码
        content.append(employeeid);
        content.append(Regex.UPRIGHT_LOG);
      //业务编码
        content.append(serviceCode);
        content.append(Regex.UPRIGHT_LOG);
      //业务名称
        content.append(serviceName);
        content.append(Regex.UPRIGHT_LOG);
        
      //业务类型
        content.append(serviceType);
        content.append(Regex.UPRIGHT_LOG);
      //子业务类型
        content.append(operation);
        content.append(Regex.UPRIGHT_LOG);
       
      //登录结果(0成功，1失败)
        content.append((result.isSuccess())?0:1);
        content.append(Regex.UPRIGHT_LOG);
      //返回码
        content.append(result.getRetCode());
        content.append(Regex.UPRIGHT_LOG);
      //描述结果
        content.append(result.getMessage());
        content.append("\n");
        
        saveLog(content.toString(),BIZ);
	}
	
	/**
	 * 登录日志
	 * 日志格式：时间|手机号码|是否成功|返回码|描述
	 */
	public static void loginLog(String officeTel, ServiceResult result){
        
        String currDate = CommonUtil.getToday("yyyy-MM-dd HH:mm:ss.SSS");
        //日志格式：时间|手机号码|登录方式|是否成功|返回码|描述
        StringBuffer content = new StringBuffer();
        content.append(currDate);//时间
        content.append(Regex.UPRIGHT_LOG);
        
        content.append(officeTel);//手机号码
        content.append(Regex.UPRIGHT_LOG);
        
        //content.append(loginType);//登录方式
        //content.append(Regex.UPRIGHT_LOG);
        
        content.append((result.isSuccess())?0:1);//登录结果(0成功，1失败)
        content.append(Regex.UPRIGHT_LOG);
        
        content.append(result.getRetCode());//返回码
        content.append(Regex.UPRIGHT_LOG);
        
        content.append(result.getMessage());//描述结果
        content.append("\n");
       
        saveLog(content.toString(),LOGIN);
	}
	
	/**
	 * 登录日志
	 * 日志格式：时间|手机号码|是否成功|地市|返回码|描述|处理时长
	 */
	public static void loginLog(String officeTel, ServiceResult result, long starttime, String cityid){
        
        String currDate = CommonUtil.getToday("yyyy-MM-dd HH:mm:ss.SSS");
        //日志格式：时间|手机号码|登录方式|是否成功|返回码|描述
        StringBuffer content = new StringBuffer();
        content.append(currDate);//时间
        content.append(Regex.UPRIGHT_LOG);
        
        content.append(officeTel);//手机号码
        content.append(Regex.UPRIGHT_LOG);
        
        //content.append(loginType);//登录方式
        //content.append(Regex.UPRIGHT_LOG);
        
        content.append((result.isSuccess())?0:1);//登录结果(0成功，1失败)
        content.append(Regex.UPRIGHT_LOG);
        
        content.append(cityid);//地市标识
        content.append(Regex.UPRIGHT_LOG);
                
        content.append(result.getRetCode());//返回码
        content.append(Regex.UPRIGHT_LOG);
        
        content.append(result.getMessage());//描述结果
        content.append(Regex.UPRIGHT_LOG);
        
        long endtime = System.currentTimeMillis();
        content.append(endtime-starttime);
        
        content.append("\n");
       
        saveLog(content.toString(),LOGIN);
	}
	
	/**
	 * 异常日志
	 * 日志格式：时间|公务机号码|渠道编码|人员编码|业务编码|业务名称|业务类型|子业务类型|Exception+Message
	 */
	public static void errorLog(String officeTel, String wayid, String employeeid, String serviceCode, String serviceName, 
			short serviceType, int operation ,String msg ){

		String currDate = CommonUtil.getToday("yyyy-MM-dd HH:mm:ss.SSS");
		
        StringBuffer content = new StringBuffer();
        content.append(currDate);//时间
        content.append(Regex.UPRIGHT_LOG);
      //公务机号码
        content.append(officeTel);
        content.append(Regex.UPRIGHT_LOG);
      //渠道编码
        content.append(wayid);
        content.append(Regex.UPRIGHT_LOG);
      //人员编码
        content.append(employeeid);
        content.append(Regex.UPRIGHT_LOG);
      //业务编码
        content.append(serviceCode);
        content.append(Regex.UPRIGHT_LOG);
      //业务名称
        content.append(serviceName);
        content.append(Regex.UPRIGHT_LOG);
      //办理类型
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
	 * 缓存日志
	 * 日志格式：时间|业务编码|业务名称|执行结果
	 * @param serviceCode
	 * @param serviceName
	 * @param msg
	 */
	public static void cacheLog(String serviceCode,String serviceName,String msg){
		String currDate = CommonUtil.getToday("yyyy-MM-dd HH:mm:ss.SSS");
		
		StringBuffer content = new StringBuffer();
        content.append(currDate);//时间
        content.append(Regex.UPRIGHT_LOG);
		
      //业务编码
        content.append(serviceCode);
        content.append(Regex.UPRIGHT_LOG);
      //业务名称
        content.append(serviceName);
        content.append(Regex.UPRIGHT_LOG);
//      //返回结果码
//        content.append(retCode);
//        content.append(Regex.UPRIGHT_LOG);
      //MSG
        content.append(msg);
        content.append("\n");
        
        saveLog(content.toString(),CACHE);
	}
	
	/**
	 * 接口调用日志
	 * @param serviceCode :ServiceCode
	 * @param serviceName :ServiceName
	 * @param intetfaceName:接口名
	 * @param wayid: 调用Wayid
	 * @param rtnCode :接口返回码
	 * @param msg:信息
	 */
	public static void remoteLog(String serviceCode,String serviceName,
			String intetfaceName,String wayid,int rtnCode,String msg){

		String currDate = CommonUtil.getToday("yyyy-MM-dd HH:mm:ss.SSS");
		
		StringBuffer content = new StringBuffer();
        content.append(currDate);//时间
        content.append(Regex.UPRIGHT_LOG);

        //业务编码
          content.append(serviceCode);
          content.append(Regex.UPRIGHT_LOG);
        //业务名称
          content.append(serviceName);
          content.append(Regex.UPRIGHT_LOG);

          content.append(intetfaceName);
          content.append(Regex.UPRIGHT_LOG);
          
          content.append(wayid);
          content.append(Regex.UPRIGHT_LOG);

          content.append("[返回码:"+ rtnCode +"]");
          content.append(Regex.UPRIGHT_LOG);
          
          content.append(msg);
          content.append("\n");
        
		saveLog(content.toString(),GOODSREMOTE);
	}
	/**
	 * 保存日志
	 * @param content 	日志内容
	 * @param type		日志类型
	 */
	private static void saveLog(String content, String type){
		//获得路径
		String path = getLogPath(type);
		
		//创建目录
    	createDirs(path);
    	
    	StringBuffer logFile = new StringBuffer();
    	String suffixion = ".log";
    	//全路径
    	//String pattern = (type.equalsIgnoreCase(CACHE))?"yyyyMM":"yyyyMMdd";
    	logFile.append(path).append(getPrefixion(type))
    		   .append(Regex.UNDERLINE).append(CommonUtil.getToday("yyyyMMdd"))
    		   .append(suffixion);
    	
    	try {
			//写入
			FileWriter writer = new FileWriter(logFile.toString(), true);
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 获得日志前缀
	 * @param type 日志类型
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
	 * 根据路径创建文件夹
	 * @param path
	 */
	private static void createDirs(String path){
		File file = new File(path);
		if(!file.exists()){
			file.mkdirs();
		}
	}
	
	/**
	 * 获得日志保存路径
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
