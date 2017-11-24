package com.gmcc.pboss.biz.index.service.impl;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.gmcc.pboss.biz.communi.CPDictionary;
import com.gmcc.pboss.biz.communi.support.CommunicatePlateauParameter;
import com.gmcc.pboss.biz.communi.support.processor.CommunicateInterlocutionParameterProcessor;
import com.gmcc.pboss.biz.communi.support.processor.CommunicatePlateauParameterProcessor;
import com.gmcc.pboss.biz.index.IndexBean;
import com.gmcc.pboss.biz.index.service.IndexService;
import com.gmcc.pboss.biz.index.support.IndexParameter;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.config.CommunicateConfigLoader;
import com.gmcc.pboss.common.dictionary.CommunicateConfig;
import com.gmcc.pboss.common.dictionary.Role;
import com.gmcc.pboss.common.file.bean.ServerInfoBean;
import com.gmcc.pboss.common.file.util.FtpAccess;
import com.gmcc.pboss.common.log.Log;
import com.gmcc.pboss.common.service.ServiceCode;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceRetCode;
import com.gmcc.pboss.common.service.impl.QueryBaseServiceImpl;
import com.gmcc.pboss.common.support.QueryAction;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.model.communi.ChPwAdvinfo;
import com.gmcc.pboss.biz.basic.goods.service.IbGlSysparamService;
//import com.gmcc.pboss.biz.index.support.AdvinfoPendingParameterProcessor;

/**
 * 从兴公司电子渠道业务部
 * @author tangzhu
 * @date 2009-12-14
 * 所属项目：PBOSS
 * 所属模块：门户网站
 * 描述：
 */
public class IndexServiceImpl extends QueryBaseServiceImpl implements IndexService{
	
	private static Logger logger = Logger.getLogger(IndexServiceImpl.class);
	
	public IndexServiceImpl() {
		this.serviceCode = ServiceCode.COMMUNICATE_INDEX;
		this.serviceName = "沟通平台_首页";

	}
	
	//获取系统参数——数据库表IB_GL_SYSPARAM
	//获取系统参数，根据系统参数来过滤‘待办任务’查询结果
	private IbGlSysparamService ibGlSysparamService;
	public void setIbGlSysparamService(IbGlSysparamService ibGlSysparamService){
		this.ibGlSysparamService = ibGlSysparamService;
	}
	

	@Override
	public ServiceResult other(LoginMember member, QueryParameter parameter) {
		IndexParameter indexParameter = (IndexParameter)parameter;
		
		IndexBean bean = new IndexBean();
		ServiceResult result = new ServiceResult();
		result.setSuccess(true);
		result.setRetCode(ServiceRetCode.SUCCESS);
		
		//只查公告
		if(indexParameter.isBlnFlashImage()){
			List list = queryInfos(member, getIndexParameter(member,CPDictionary.AFFICHE, indexParameter.getPsOfAffiche()));
			if(list!=null && list.size()>0){
				//flash图片数量
				int count = 5;
				try{
					count = Integer.parseInt(CommunicateConfigLoader.PROPS.getProperty(CommunicateConfig.DOWNLOAD_QTY));	
				}catch (Exception e) {
					count = 5;
				}
				String cityid = member.getCityid();
				String imgPath = CommunicateConfigLoader.PROPS.getProperty(CommunicateConfig.FLASH_IMAGE_PATH);
				String path = getClass().getResource("").getPath();
				path = path.substring(0,path.indexOf("/WEB-INF/classes/")) + imgPath+"/"+cityid;
				
				//@@ add by yuwenjun
				//判断文件夹是否存在
				File imgDir = new File(path); 
				if (!imgDir.isDirectory() || !imgDir.exists() ){
					//路径不是目录和不存在，建立此目录
					boolean mkRslt = imgDir.mkdirs();
					if (!mkRslt) {
						logger.error("公告图片目录不存在或创建失败!");
						Log.errorLog("", "","", "IndexAction", "公告图片", (short) -1,1, "公告图片目录不存在或创建失败!");
					}
				}
				
				try {
					ServerInfoBean ftpInfo = ServerInfoBean.getInstance();
					FtpAccess ftpAccess = new FtpAccess(ftpInfo);
					
					for(Iterator<ChPwAdvinfo> it = list.iterator();it.hasNext();){
						ChPwAdvinfo cpa = it.next();
						if(cpa.getImgLogoPath()!=null && !"".equals(cpa.getImgLogoPath().trim())){
							count--;
							if(count>=0){
								String ext = cpa.getImgLogoPath().substring(cpa.getImgLogoPath().lastIndexOf("."));
								//图片以advinfoid_1为名
								File file = new File(path +"/"+  cpa.getAdvinfoid()+"_1"+ext);
								//图片不存在ftp下载
								if (!file.exists()){
									try {
										ftpAccess.downloadFileWithFileName(path +"/"+  cpa.getAdvinfoid()+"_1"+ext, cpa.getImgLogoPath());
										logger.info(cpa.getImgLogoPath()+"图片从ftp下载成功！");
									} catch (Exception e) {
										logger.error(cpa.getImgLogoPath()+"下载失败:"+e.getMessage());
										Log.cacheLog(serviceCode, serviceName, cpa.getImgLogoPath()+"下载失败:"+e.getMessage());
										e.printStackTrace();
										continue;
									}
						        }
							}
						}
					}
				} catch (Exception e) {
					logger.error("FTP服务器连接失败");
					Log.cacheLog(serviceCode, serviceName, "FTP服务器连接失败");
				}
			}
			result.setRetObject(list);
		}else{
			bean.setAffiche(queryInfos(member, getIndexParameter(member,CPDictionary.AFFICHE, indexParameter.getPsOfAffiche())));
			bean.setKnowledge(queryInfos(member, getIndexParameter(member,CPDictionary.KNOWLEDGE, indexParameter.getPsOfKnowledge())));
			bean.setOperationinfo(queryInfos(member, getIndexParameter(member,CPDictionary.OPERATIONINFO, indexParameter.getPsOfOperation())));
			bean.setQuestionnaire(queryInfos(member, getIndexParameter(member,CPDictionary.QUESTIONNAIRE, indexParameter.getPsOfQuestion())));
			bean.setPendingRequest(queryInfos(member, getIndexParameter(member,CPDictionary.PENDING_REQUEST, indexParameter.getPsOfPendinReq())));
			bean.setInterlocution(queryInfos(member, getIndexParameter(member,CPDictionary.INTERLOCUTION, indexParameter.getPsOfInterlocu())));
			result.setRetObject(bean);
		}
		return result;
	}
	/**
	 * 公告/业务/知识库/待办任务/在线问答/调查问卷查询
	 * @return
	 */
	public List<ChPwAdvinfo> queryInfos(LoginMember member, CommunicatePlateauParameter parameter){
		logger.debug("首页信息查询类型："+parameter.getType());
		
		List<ChPwAdvinfo> infos = null;
		
		//在线问答
		if(parameter.getType().equals(CPDictionary.INTERLOCUTION)){
			setProcessor(new CommunicateInterlocutionParameterProcessor());
			
		}
		//待办任务
		else if(parameter.getType().equals((CPDictionary.PENDING_REQUEST))){
			//需要查询系统参数，做"待办任务"的屏蔽处理
			String systemParam = this.ibGlSysparamService.getSysValue(5, "pboss_Web");
			if(systemParam!=null){
				//setProcessor(new AdvinfoPendingParameterProcessor(systemParam));
				setProcessor(new CommunicatePlateauParameterProcessor(systemParam));
			}
			else{
				setProcessor(new CommunicatePlateauParameterProcessor());
			}
		}
		else{
			setProcessor(new CommunicatePlateauParameterProcessor());
		}
		
		ServiceResult result = this.query(member, parameter);
		if(result.isSuccess()){
			infos = result.getRetResult().getData();
		}
		
		return infos;
	}
	
	/**
	 * 得到首页查询是所需参数
	 * @param type	信息类型
	 * @param size	信息个数
	 * @return
	 */
	public CommunicatePlateauParameter getIndexParameter(LoginMember member,String type, int size){
		CommunicatePlateauParameter parameter =  new CommunicatePlateauParameter();
		
		
		parameter.setType(type);
		parameter.setNet(member.getIsnet() == Role.SHOP_MASTER);
		parameter.setEmployeeid(member.getEmployeeid());
		parameter.setAll_size(size);
		
		//默认值
		parameter.setAction(QueryAction.ALL);
		parameter.setIndexPage(true);
		
		
		return parameter;
	}
}
