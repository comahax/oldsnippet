package com.gmcc.pboss.common.file.dictionary;
/**
 * 从兴公司电子渠道业务部
 * @author tangzhu
 * @date 2009-10-22
 * 所属项目：PBOSS
 * 所属模块：门户网站
 * 描述：文件处理返回码。从100开始递增。
 */
public class FileHandleRetCode {
	
	/**上传成功*/
	public static final int UPLOAD_SUCCESS = 101;
	
	/**上传异常*/
	public static final int UPLOAD_EXCEPTION = 102;
	
	/**上传文件格式错误*/
	public static final int UPLOAD_WSUFFIX  = 103;
	
	/**上传失败*/
	public static final int UPLOAD_FAIL = 104;
	
	/**未登录或Session失效*/
	public static final int UNLOGIN = 105;
	
	/**上传文件超过大小限制*/
	public static final int UPLOAD_OSIZE = 106;
	
	/**读取配置文件失败*/
	public static final int UPLOAD_LOADINGFAIL = 107;
}
