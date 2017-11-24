package com.gmcc.pboss.common.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Properties;

import com.gmcc.pboss.common.config.exception.FileConfigException;
import com.gmcc.pboss.common.config.exception.FileConfigExceptionDictionary;
import com.gmcc.pboss.common.config.xml.IXmlHandle;

public class FileConfigAdapter implements IConfigHandle {
    /**
     * 文件配置的最近修改时间
     */
    private static long fileConfigModifeid = 0;
    
    /**
     * 保存文件配置的信息
     */
    private static Hashtable fileConfigHash = null;
    
    private static Hashtable fileModifeid = new Hashtable();
    
    private static Hashtable fileHash = new Hashtable();
    
    private static FileConfigAdapter fileConfigAdapter;
    
    private FileConfigAdapter(){}
    
    /**
     * 初始化方法入口
     * @return
     * @throws FileConfigException
     */
    public static FileConfigAdapter init() throws FileConfigException{
        if(fileConfigAdapter == null){
            fileConfigAdapter = new FileConfigAdapter();
        }
        initFileConfig();
        return fileConfigAdapter;
    }
    
    /**
     * 获得通用CommonPath
     * @return
     */
    public static String getCommonPath(){
    	return getPath("COMMON_PATH");
    }
    
    /**
     * 获得日志保存路径
     * @return
     */
    public static String getLogPath(){
    	return getPath("LOG_PATH");
    }
    
    /**
     * 获得验证码图片保存路径
     * @return
     */
    public static String getImagePath(){
    	return getPath("IMAGE_PATH");
    }
    
    /**
     * 从Hashtable中取出关于路径的配置
     * @param code
     * @return
     */
    private static String getPath(String code){
    	try {
			initFileConfig();
		} 
    	catch (FileConfigException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return (String)fileConfigHash.get(code);
    }
    
    /**
     * 获得FileConfig.xml保存路径
     * @return
     */
    private static String getFileConfigPath(){
    	String path = FileConfigAdapter.class.getResource("FileConfig.xml").getPath();
    	//System.out.println("PATH>>>"+path);
    	return path;
    }
    
    /**
     * @description: 加载文件配置，得到所有有配置的配置文件
     * @param: 
     * @return: 
     * @throws: FileConfigException-加载时抛出的异常
     */
    private static void initFileConfig()throws FileConfigException{
    	
    	StringBuffer path = new StringBuffer();
    	path.append(getFileConfigPath());
    	//
        File file = new File(path.toString());
        if (!file.isFile()) {
            throw new FileConfigException(FileConfigExceptionDictionary.FILE_CONFIG_NOT_FOUND 
            		+ " : " +path.toString());
        }
        
        long modified = file.lastModified();
        if(modified != fileConfigModifeid || fileConfigHash==null){
            IXmlHandle xmlHandle = new FileConfigXmlHandle();
            try {
                fileConfigHash = new Hashtable();
                xmlHandle.load(file, fileConfigHash);
                fileConfigModifeid = modified;
            } catch (Exception e) {
                throw new FileConfigException(FileConfigExceptionDictionary.FILE_CONFIG_LOAD_ERROR);
            }
        }
    }
    
    /**
     * @description: 根据文件编码获取文件对象
     * @param: fileCode-文件配置中的文件编码<p>
     * @return: File 文件编码对应的文件对象
     * @throws: FileConfigException-抛出文件配置异常
     */
    public File loadFile(String fileCode) throws FileConfigException {
        FileConfigBean bean = (FileConfigBean)fileConfigHash.get(fileCode);
        if(bean == null){
            throw new FileConfigException(FileConfigExceptionDictionary.NO_SUCH_CONFIG);
        }
        File file = new File(bean.getPath()+bean.getName());
        if(!file.isFile()){
            throw new FileConfigException(FileConfigExceptionDictionary.FILE_NOT_FOUND);
        }
        return file;
    }
    
    /**
     * @description: 根据文件编码和属性名获取属性值
     * @param: fileCode-文件配置中的文件编码<p>
     *         property-配置文件中的属性名<p>
     *         handle-XML加载的实现类
     * @return: Object 属性值
     * @throws: FileConfigException-抛出文件配置异常
     */
    public Object loadProperty(String fileCode, String property,
            IXmlHandle handle) throws FileConfigException{
        FileConfigBean bean = (FileConfigBean)fileConfigHash.get(fileCode);
        if(bean == null){
            throw new FileConfigException(FileConfigExceptionDictionary.NO_SUCH_CONFIG);
        }
        initConfigFile(bean,handle);
        
        Object object = null;
        
        if(FileConfigDictionary.FILE_TYPE_XML.equals(bean.getType())){
            object = ((Hashtable)fileHash.get(bean.getCode())).get(property);
        }else if(FileConfigDictionary.FILE_TYPE_PROPERTIES.equals(bean.getType())){
            object = ((Properties)fileHash.get(bean.getCode())).getProperty(property);
        }
        return object;
    }
    
    /**
     * @description: 加载对应的文件
     * @param: bean-文件配置对象<p>
     *         handle-XML加载的实现类
     * @return: 
     * @throws: FileConfigException
     */
    private void initConfigFile(FileConfigBean bean,IXmlHandle handle)throws FileConfigException{
        File file = new File(bean.getPath()+bean.getName());
        if(!file.isFile()){
            throw new FileConfigException(FileConfigExceptionDictionary.FILE_NOT_FOUND +": "
            			+ bean.getPath() + bean.getName());
        }
        long modified = file.lastModified();
        
        //得到该配置文件最近的修改时间
        Long lastModified = (Long)fileModifeid.get(bean.getCode());
        if(lastModified==null){
            lastModified = new Long(0);
        }
        
        if(FileConfigDictionary.FILE_TYPE_XML.equals(bean.getType())){
            //加载XML文件
            Hashtable config = (Hashtable)fileHash.get(bean.getCode());
            if(this.isUpdateTime(bean, modified, lastModified.longValue()) || config==null){
                config = new Hashtable();
                try {
                    handle.load(file, config);
                    fileModifeid.put(bean.getCode(), new Long(bean.getLastModified()));
                    fileHash.put(bean.getCode(), config);
                } catch (Exception e) {
                	System.out.println(e.getMessage());
                    throw new FileConfigException(FileConfigExceptionDictionary.CONFIG_LOAD_ERROR);
                }
            }
        }else if(FileConfigDictionary.FILE_TYPE_PROPERTIES.equals(bean.getType())){
            //加载属性文件
            Properties prop = (Properties)fileHash.get(bean.getCode());
            if(this.isUpdateTime(bean, modified, lastModified.longValue()) || prop == null){
                prop = new Properties();
                try {
                    FileInputStream is = new FileInputStream(file);
                    prop.load(is);
                    fileModifeid.put(bean.getCode(), new Long(bean.getLastModified()));
                    fileHash.put(bean.getCode(), prop);
                } catch (IOException e) {
                    throw new FileConfigException(FileConfigExceptionDictionary.CONFIG_LOAD_ERROR);
                }
            }
        }else{
            throw new FileConfigException(FileConfigExceptionDictionary.NO_SUCH_CONFIG_TYPE);
        } 
    }
    
    /**
     * @description: 判断文件是否要重新加载数据，返回true时重新加载；返回false时不重新加载
     * @param: bean 文件配置对象<p>
     *          fileModified 文件的修改时间<p>
     *          lastModified 上次数据的加载时间
     * @return: boolean 返回true时重新加载；返回false时不重新加载
     * @throws:
     */
    private boolean isUpdateTime(FileConfigBean bean,long fileModified,long lastModified) throws FileConfigException{
        if(bean == null){
            throw new FileConfigException(FileConfigExceptionDictionary.FILE_NOT_FOUND);
        }
        long updateTime = 0;
        if(FileConfigDictionary.UPDATE_TYPE_ONCE_DAY.equals(bean.getUpdateType())){
            //每天更新一次
            updateTime = bean.getUpdateTime();
            if(updateTime > 23 || updateTime < 0){
                //当更新时间大于23点或小于0点时，就每天凌晨零点更新
                updateTime = 0;
            }
            long now = Long.parseLong(new java.text.SimpleDateFormat("MMddhh").format(new java.util.Date()));
            updateTime = now/100 * 100 + updateTime; //应该更新的时间
            if(lastModified == updateTime){
                return false;
            }else{
                if( now >= lastModified && now < updateTime){
                    return false;
                }else{
                    bean.setLastModified(updateTime);
                    return true;
                }
            }
            
        }else if(FileConfigDictionary.UPDATE_TYPE_ONCE_HOUR.equals(bean.getUpdateType())){
            //每小时更新一次
            updateTime = bean.getUpdateTime();
            if(updateTime < 0 || updateTime > 59){
                //当设定时间小于0分或大59分钟时，默认为0分时更新
                updateTime = 0;
            }
            long now = Long.parseLong(new java.text.SimpleDateFormat("ddHHmm").format(new java.util.Date()));
            updateTime = now/100 * 100 + updateTime;
            if(lastModified == updateTime){
                return false;
            }else{
                if( now >= lastModified && now < updateTime){
                    return false;
                }else{
                    bean.setLastModified(updateTime);
                    return true;
                }
            }
            
        }else if(FileConfigDictionary.UPDATE_TYPE_ONCE_ONLY.equals(bean.getUpdateType())){
            //只加载一次
            if(lastModified != 0){
                return false;
            }else{
                bean.setLastModified(System.currentTimeMillis());
                return true;
            }
            
        }else if(FileConfigDictionary.UPDATE_TYPE_FILE_MODIFIED.equals(bean.getUpdateType())){
            //根椐文件的修改时间来更新
            if(fileModified != lastModified){
                bean.setLastModified(fileModified);
                return true;
            }else{
                return false;
            }
            
        }else{
            throw new FileConfigException(FileConfigExceptionDictionary.NO_SUCH_UPDATE_TYPE);
        }
    }
    
    public static void main(String[] args) {
    	System.out.println(FileConfigAdapter.getImagePath());
    }
    
}
