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
		this.serviceName = "从ftp下载flash图片";
		this.setProcessor(new CommunicatePublicParameterProcessor());
	}
	/**
	 * 定时任务，定时从ftp下载公告图片
	 */
	public void refresh() {
	}

	public void clear() {
		String imgPath = CommunicateConfigLoader.PROPS.getProperty(CommunicateConfig.FLASH_IMAGE_PATH);
		//取当前类路径
		String path = CommunicatePublicServiceImpl.class.getResource("").getPath();
		path = path.substring(0,path.indexOf("/WEB-INF/classes/")) + imgPath;
		try{
			File file = new File(path);
			if(file.isDirectory()){
				File[] fs = file.listFiles();
				for(File f :fs)	{
					removeFile(f);
				}
				logger.info("清理公告图片成功！");
				Log.cacheLog(serviceCode, serviceName, "从"+path+"中清理公告图片成功！");
			}
		}catch(Exception e){
			logger.info("清理公告图片失败！");
			e.printStackTrace();
			Log.cacheLog(serviceCode, serviceName, "从"+path+"中清理公告图片失败！|"+e.getMessage());
		}
		init();
	}

	public void init() {
		new Thread(new Runnable() {
			public void run() {
				Log.cacheLog(serviceCode, serviceName, "**********开始下载flash图片缓存**********");
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
							//取当前类路径
							String path = CommunicatePublicServiceImpl.class.getResource("").getPath();
							path = path.substring(0,path.indexOf("/WEB-INF/classes/")) + imgPath+"/"+cityid;
							
							//判断文件夹是否存在
							File imgDir = new File(path); 
							if (!imgDir.isDirectory() || !imgDir.exists() ){
								//路径不是目录和不存在，建立此目录
								boolean mkRslt = imgDir.mkdirs();
								if (!mkRslt) {
									logger.error("公告图片目录不存在或创建失败!");
									Log.cacheLog(serviceCode, serviceName, "公告图片目录不存在或创建失败!");
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
							logger.info("["+cityid+"]地市从ftp下载了["+i+"]副公告图片成功！");
							logger.info("["+cityid+"]地市从ftp下载了["+i+"]副公告图用时"+needTime+"ms!");
							Log.cacheLog(serviceCode, serviceName, "["+cityid+"]地市从ftp下载了["+i+"]副公告图片成功！保存在"+path+"并加载了公告缓存！");
							Log.cacheLog(serviceCode, serviceName, "["+cityid+"]地市下载图片用时"+needTime+"ms!");
						}
						if(i==0){
							logger.info("["+cityid+"]地市不存在需要下载的图片");
							Log.cacheLog(serviceCode, serviceName, "["+cityid+"]地市不存在需要下载的图片！");
						}
					} catch (Exception e) {
						e.printStackTrace();
						logger.error("["+cityid+"]地市从ftp下载公告图片失败！");
						Log.cacheLog(serviceCode, serviceName, "["+cityid+"]地市从ftp下载公告图片失败！|"+e.getMessage());
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