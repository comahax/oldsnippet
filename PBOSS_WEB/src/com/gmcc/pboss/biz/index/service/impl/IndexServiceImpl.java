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
 * ���˹�˾��������ҵ��
 * @author tangzhu
 * @date 2009-12-14
 * ������Ŀ��PBOSS
 * ����ģ�飺�Ż���վ
 * ������
 */
public class IndexServiceImpl extends QueryBaseServiceImpl implements IndexService{
	
	private static Logger logger = Logger.getLogger(IndexServiceImpl.class);
	
	public IndexServiceImpl() {
		this.serviceCode = ServiceCode.COMMUNICATE_INDEX;
		this.serviceName = "��ͨƽ̨_��ҳ";

	}
	
	//��ȡϵͳ�����������ݿ��IB_GL_SYSPARAM
	//��ȡϵͳ����������ϵͳ���������ˡ��������񡯲�ѯ���
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
		
		//ֻ�鹫��
		if(indexParameter.isBlnFlashImage()){
			List list = queryInfos(member, getIndexParameter(member,CPDictionary.AFFICHE, indexParameter.getPsOfAffiche()));
			if(list!=null && list.size()>0){
				//flashͼƬ����
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
				//�ж��ļ����Ƿ����
				File imgDir = new File(path); 
				if (!imgDir.isDirectory() || !imgDir.exists() ){
					//·������Ŀ¼�Ͳ����ڣ�������Ŀ¼
					boolean mkRslt = imgDir.mkdirs();
					if (!mkRslt) {
						logger.error("����ͼƬĿ¼�����ڻ򴴽�ʧ��!");
						Log.errorLog("", "","", "IndexAction", "����ͼƬ", (short) -1,1, "����ͼƬĿ¼�����ڻ򴴽�ʧ��!");
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
								//ͼƬ��advinfoid_1Ϊ��
								File file = new File(path +"/"+  cpa.getAdvinfoid()+"_1"+ext);
								//ͼƬ������ftp����
								if (!file.exists()){
									try {
										ftpAccess.downloadFileWithFileName(path +"/"+  cpa.getAdvinfoid()+"_1"+ext, cpa.getImgLogoPath());
										logger.info(cpa.getImgLogoPath()+"ͼƬ��ftp���سɹ���");
									} catch (Exception e) {
										logger.error(cpa.getImgLogoPath()+"����ʧ��:"+e.getMessage());
										Log.cacheLog(serviceCode, serviceName, cpa.getImgLogoPath()+"����ʧ��:"+e.getMessage());
										e.printStackTrace();
										continue;
									}
						        }
							}
						}
					}
				} catch (Exception e) {
					logger.error("FTP����������ʧ��");
					Log.cacheLog(serviceCode, serviceName, "FTP����������ʧ��");
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
	 * ����/ҵ��/֪ʶ��/��������/�����ʴ�/�����ʾ��ѯ
	 * @return
	 */
	public List<ChPwAdvinfo> queryInfos(LoginMember member, CommunicatePlateauParameter parameter){
		logger.debug("��ҳ��Ϣ��ѯ���ͣ�"+parameter.getType());
		
		List<ChPwAdvinfo> infos = null;
		
		//�����ʴ�
		if(parameter.getType().equals(CPDictionary.INTERLOCUTION)){
			setProcessor(new CommunicateInterlocutionParameterProcessor());
			
		}
		//��������
		else if(parameter.getType().equals((CPDictionary.PENDING_REQUEST))){
			//��Ҫ��ѯϵͳ��������"��������"�����δ���
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
	 * �õ���ҳ��ѯ���������
	 * @param type	��Ϣ����
	 * @param size	��Ϣ����
	 * @return
	 */
	public CommunicatePlateauParameter getIndexParameter(LoginMember member,String type, int size){
		CommunicatePlateauParameter parameter =  new CommunicatePlateauParameter();
		
		
		parameter.setType(type);
		parameter.setNet(member.getIsnet() == Role.SHOP_MASTER);
		parameter.setEmployeeid(member.getEmployeeid());
		parameter.setAll_size(size);
		
		//Ĭ��ֵ
		parameter.setAction(QueryAction.ALL);
		parameter.setIndexPage(true);
		
		
		return parameter;
	}
}
