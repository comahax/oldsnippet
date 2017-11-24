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
     * �ļ����õ�����޸�ʱ��
     */
    private static long fileConfigModifeid = 0;
    
    /**
     * �����ļ����õ���Ϣ
     */
    private static Hashtable fileConfigHash = null;
    
    private static Hashtable fileModifeid = new Hashtable();
    
    private static Hashtable fileHash = new Hashtable();
    
    private static FileConfigAdapter fileConfigAdapter;
    
    private FileConfigAdapter(){}
    
    /**
     * ��ʼ���������
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
     * ���ͨ��CommonPath
     * @return
     */
    public static String getCommonPath(){
    	return getPath("COMMON_PATH");
    }
    
    /**
     * �����־����·��
     * @return
     */
    public static String getLogPath(){
    	return getPath("LOG_PATH");
    }
    
    /**
     * �����֤��ͼƬ����·��
     * @return
     */
    public static String getImagePath(){
    	return getPath("IMAGE_PATH");
    }
    
    /**
     * ��Hashtable��ȡ������·��������
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
     * ���FileConfig.xml����·��
     * @return
     */
    private static String getFileConfigPath(){
    	String path = FileConfigAdapter.class.getResource("FileConfig.xml").getPath();
    	//System.out.println("PATH>>>"+path);
    	return path;
    }
    
    /**
     * @description: �����ļ����ã��õ����������õ������ļ�
     * @param: 
     * @return: 
     * @throws: FileConfigException-����ʱ�׳����쳣
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
     * @description: �����ļ������ȡ�ļ�����
     * @param: fileCode-�ļ������е��ļ�����<p>
     * @return: File �ļ������Ӧ���ļ�����
     * @throws: FileConfigException-�׳��ļ������쳣
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
     * @description: �����ļ��������������ȡ����ֵ
     * @param: fileCode-�ļ������е��ļ�����<p>
     *         property-�����ļ��е�������<p>
     *         handle-XML���ص�ʵ����
     * @return: Object ����ֵ
     * @throws: FileConfigException-�׳��ļ������쳣
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
     * @description: ���ض�Ӧ���ļ�
     * @param: bean-�ļ����ö���<p>
     *         handle-XML���ص�ʵ����
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
        
        //�õ��������ļ�������޸�ʱ��
        Long lastModified = (Long)fileModifeid.get(bean.getCode());
        if(lastModified==null){
            lastModified = new Long(0);
        }
        
        if(FileConfigDictionary.FILE_TYPE_XML.equals(bean.getType())){
            //����XML�ļ�
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
            //���������ļ�
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
     * @description: �ж��ļ��Ƿ�Ҫ���¼������ݣ�����trueʱ���¼��أ�����falseʱ�����¼���
     * @param: bean �ļ����ö���<p>
     *          fileModified �ļ����޸�ʱ��<p>
     *          lastModified �ϴ����ݵļ���ʱ��
     * @return: boolean ����trueʱ���¼��أ�����falseʱ�����¼���
     * @throws:
     */
    private boolean isUpdateTime(FileConfigBean bean,long fileModified,long lastModified) throws FileConfigException{
        if(bean == null){
            throw new FileConfigException(FileConfigExceptionDictionary.FILE_NOT_FOUND);
        }
        long updateTime = 0;
        if(FileConfigDictionary.UPDATE_TYPE_ONCE_DAY.equals(bean.getUpdateType())){
            //ÿ�����һ��
            updateTime = bean.getUpdateTime();
            if(updateTime > 23 || updateTime < 0){
                //������ʱ�����23���С��0��ʱ����ÿ���賿������
                updateTime = 0;
            }
            long now = Long.parseLong(new java.text.SimpleDateFormat("MMddhh").format(new java.util.Date()));
            updateTime = now/100 * 100 + updateTime; //Ӧ�ø��µ�ʱ��
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
            //ÿСʱ����һ��
            updateTime = bean.getUpdateTime();
            if(updateTime < 0 || updateTime > 59){
                //���趨ʱ��С��0�ֻ��59����ʱ��Ĭ��Ϊ0��ʱ����
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
            //ֻ����һ��
            if(lastModified != 0){
                return false;
            }else{
                bean.setLastModified(System.currentTimeMillis());
                return true;
            }
            
        }else if(FileConfigDictionary.UPDATE_TYPE_FILE_MODIFIED.equals(bean.getUpdateType())){
            //����ļ����޸�ʱ��������
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
