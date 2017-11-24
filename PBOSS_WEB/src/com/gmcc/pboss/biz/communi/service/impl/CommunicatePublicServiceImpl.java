package com.gmcc.pboss.biz.communi.service.impl;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.LogFactory;

import com.gmcc.pboss.biz.communi.service.CommunicatePublicService;
import com.gmcc.pboss.biz.communi.support.CommunicatePlateauParameter;
import com.gmcc.pboss.biz.communi.support.processor.CommunicatePublicParameterProcessor;
import com.gmcc.pboss.common.config.CommunicateConfigLoader;
import com.gmcc.pboss.common.config.ConfigUtil;
import com.gmcc.pboss.common.constant.Constant;
import com.gmcc.pboss.common.dictionary.CommonConfig;
import com.gmcc.pboss.common.dictionary.CommunicateConfig;
import com.gmcc.pboss.common.dictionary.ConstantsType;
import com.gmcc.pboss.common.dictionary.FileDictionary;
import com.gmcc.pboss.common.file.bean.ServerInfoBean;
import com.gmcc.pboss.common.file.util.FtpAccess;
import com.gmcc.pboss.common.log.Log;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceRetCode;
import com.gmcc.pboss.common.service.impl.QueryBaseServiceImpl;
import com.gmcc.pboss.common.support.QueryResult;
import com.gmcc.pboss.common.support.SessionFactoryContextHolder;
import com.gmcc.pboss.model.communi.ChPwAdvinfo;

public class CommunicatePublicServiceImpl extends QueryBaseServiceImpl implements CommunicatePublicService {

	protected static final org.apache.commons.logging.Log logger = LogFactory.getLog(CommunicatePublicServiceImpl.class);
	
	private String branchName = ConfigUtil.getCommonConfig(FileDictionary.COMMON_NAME,CommonConfig.SYSSUPPORT_BRANCH);
	
	public CommunicatePublicServiceImpl(){
		this.isNeedLogin = false;
		this.serviceCode = ServiceCode.FLASH_IMAGE_LOAD;
		this.serviceName = "��ftp����flashͼƬ";
		this.setProcessor(new CommunicatePublicParameterProcessor());
	}
	/**
	 * ��ʱ���񣬶�ʱ��ftp���ع���ͼƬ
	 */
	public void refresh() {
	}

	public void clear() {
		String imgPath = CommunicateConfigLoader.PROPS.getProperty(CommunicateConfig.FLASH_IMAGE_PATH);
		//ȡ��ǰ��·��
		String path = CommunicatePublicServiceImpl.class.getResource("").getPath();
		path = path.substring(0,path.indexOf("/WEB-INF/classes/")) + imgPath;
		try{
			File file = new File(path);
			if(file.isDirectory()){
				File[] fs = file.listFiles();
				for(File f :fs)	{
					removeFile(f);
				}
				logger.info("������ͼƬ�ɹ���");
				Log.cacheLog(serviceCode, serviceName, "��"+path+"��������ͼƬ�ɹ���");
			}
		}catch(Exception e){
			logger.info("������ͼƬʧ�ܣ�");
			e.printStackTrace();
			Log.cacheLog(serviceCode, serviceName, "��"+path+"��������ͼƬʧ�ܣ�|"+e.getMessage());
		}
		init();
	}

	public void init() {
		new Thread(new Runnable() {
			public void run() {
				Log.cacheLog(serviceCode, serviceName, "**********��ʼ����flashͼƬ����**********");
				String[] cityids = null;
				if("ALL".equals(branchName)){
					Map<String,String> map = Constant.getConstantsMap(ConstantsType.BRANCH_NAME);
					Set<String> set = map.keySet();
					String[] e = new String[map.size()];
					int i = 0;
					for(Iterator<String> it = set.iterator();it.hasNext();){
						e[i++] = it.next();
					}
					cityids = e;
				}
				else
					cityids = branchName.split("\\|");
				for(String cityid:cityids){
					SessionFactoryContextHolder.setSessionFactoryContext(cityid);
					long systemTime = System.currentTimeMillis();
					try {
						ServiceResult result = new ServiceResult();
						result.setSuccess(false);
						result.setRetCode(ServiceRetCode.FAIL);
				
						CommunicatePlateauParameter param = new CommunicatePlateauParameter();
						param.setType("1");
						QueryResult queryResult = getAll(param);
						List list = queryResult.getData();
						
						int i = list!=null?list.size():0;
						if(list!=null && list.size()>0){
							
							String imgPath = CommunicateConfigLoader.PROPS.getProperty(CommunicateConfig.FLASH_IMAGE_PATH);
							//ȡ��ǰ��·��
							String path = CommunicatePublicServiceImpl.class.getResource("").getPath();
							path = path.substring(0,path.indexOf("/WEB-INF/classes/")) + imgPath+"/"+cityid;
							
							//�ж��ļ����Ƿ����
							File imgDir = new File(path); 
							if (!imgDir.isDirectory() || !imgDir.exists() ){
								//·������Ŀ¼�Ͳ����ڣ�������Ŀ¼
								boolean mkRslt = imgDir.mkdirs();
								if (!mkRslt) {
									logger.error("����ͼƬĿ¼�����ڻ򴴽�ʧ��!");
									Log.cacheLog(serviceCode, serviceName, "����ͼƬĿ¼�����ڻ򴴽�ʧ��!");
								}
							}
							
							ServerInfoBean ftpInfo = ServerInfoBean.getInstance();
							FtpAccess ftpAccess = new FtpAccess(ftpInfo);
							for(Iterator<ChPwAdvinfo> it =list.iterator();it.hasNext();){
								ChPwAdvinfo adv = it.next();
								String ext = adv.getImgLogoPath().substring(adv.getImgLogoPath().lastIndexOf("."));
						        File file = new File(path +"/"+  adv.getAdvinfoid()+"_1"+ext);
						        if (!file.exists()){
						        	ftpAccess.downloadFileWithFileName(path +"/"+  adv.getAdvinfoid()+"_1"+ext, adv.getImgLogoPath());
						        }
							}
							long needTime = System.currentTimeMillis()-systemTime;
							logger.info("["+cityid+"]���д�ftp������["+i+"]������ͼƬ�ɹ���");
							logger.info("["+cityid+"]���д�ftp������["+i+"]������ͼ��ʱ"+needTime+"ms!");
							Log.cacheLog(serviceCode, serviceName, "["+cityid+"]���д�ftp������["+i+"]������ͼƬ�ɹ���������"+path+"�������˹��滺�棡");
							Log.cacheLog(serviceCode, serviceName, "["+cityid+"]��������ͼƬ��ʱ"+needTime+"ms!");
						}
						if(i==0){
							logger.info("["+cityid+"]���в�������Ҫ���ص�ͼƬ");
							Log.cacheLog(serviceCode, serviceName, "["+cityid+"]���в�������Ҫ���ص�ͼƬ��");
						}
					} catch (Exception e) {
						e.printStackTrace();
						logger.error("["+cityid+"]���д�ftp���ع���ͼƬʧ�ܣ�");
						Log.cacheLog(serviceCode, serviceName, "["+cityid+"]���д�ftp���ع���ͼƬʧ�ܣ�|"+e.getMessage());
					}
				}
			}
		}).start();
	}
	
	private void removeFile(File file) {    
        if (file.isDirectory()) {    
            File[] child = file.listFiles();    
            if (child != null && child.length != 0) {    
                for (int i = 0; i < child.length; i++) {    
                    removeFile(child[i]);    
                    child[i].delete();    
                }    
            }    
        }    
        file.delete();    
    }   
}