package com.gmcc.pboss.biz.index.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.gmcc.pboss.biz.basic.dictItem.service.DictItemService;
import com.gmcc.pboss.biz.communi.service.CommunicatePlateauService;
import com.gmcc.pboss.biz.communi.service.CommunicatePublicService;
import com.gmcc.pboss.biz.index.IndexBean;
import com.gmcc.pboss.biz.index.service.IndexService;
import com.gmcc.pboss.biz.index.support.IndexParameter;
import com.gmcc.pboss.biz.info.node.service.DbBankService;
import com.gmcc.pboss.biz.info.reward.service.AdtService;
import com.gmcc.pboss.biz.info.reward.service.OperationService;
import com.gmcc.pboss.common.action.AbstractAction;
import com.gmcc.pboss.common.bean.LoginMember;
import com.gmcc.pboss.common.config.CommunicateConfigLoader;
import com.gmcc.pboss.common.constant.service.ConstantService;
import com.gmcc.pboss.common.dictionary.CommunicateConfig;
import com.gmcc.pboss.common.dictionary.HttpDictionary;
import com.gmcc.pboss.common.service.ServiceResult;
import com.gmcc.pboss.common.service.ServiceType;
import com.gmcc.pboss.common.support.QueryParameter;
import com.gmcc.pboss.member.service.IDelayLoadService;
import com.gmcc.pboss.model.communi.ChPwAdvinfo;
/**
 * �Ż���ҳ
 * @author Jimmy
 *
 */
public class IndexAction extends AbstractAction {
	
	private static final long serialVersionUID = -6901255601265735617L;
	
	private IndexService indexService;
	
	private IndexBean bean;

    //* ϵͳ����Service *
    /**
     * ҵ����뻺��-�������
     */
    private OperationService operationService;
    /**
     * ҵ����뻺��-��վ����
     */
    private OperationService bbcOperationService;
    /**
     * ���ʧЧ���뻺��
     */
    private AdtService adtService;
    /**
     * ��Ʒ���໺��
     */
    private DictItemService dictItemService;
    /**
     * ��ͨƽ̨����
     */
	private CommunicatePlateauService communicatePlateauService;
	/**
	 * ���๺���������б�ʶ
	 */
	private DbBankService dbBankService;
	/** ��ҳFlashͼƬ*/
	private CommunicatePublicService communicatePublicService;
	/**
	 * �̶��������� constantService
	 */
	private ConstantService constantService;
	/**
	 * �ӳټ��ز��ֵ�¼��Ϣ�����������ϡ��ϼ����������˵���
	 */
	private IDelayLoadService delayLoadService;

	
	/**
	 * ����/ҵ��/֪ʶ��/��������/�����ʾ��ѯ(��ҳ)/���ߴ���
	 * @return
	 */
	public String doIndex(){
		LoginMember member = this.getMember();
		if( !member.isInfoloaded()){//���ӳټ��ص���Ϣ��δ���أ�������Щ��Ϣ
			member = this.delayLoadService.fillMember(member);
			//��ȡ�˵���
			Map<String,ArrayList> menuMap = member.getMenuMap();
	 		this.getSession().setAttribute("menuMap", menuMap);//���˵���Ϣ����session��
	 		member.setMenuMap(null);//������session�з���2��
	 		this.getSession().setAttribute(HttpDictionary.USER_NAME, member);
	 			
	 		ServiceResult result = indexService.transact(member, this.getParameter(), ServiceType.OTHER);
	 		if(result.isSuccess()){
	 			this.setBean((IndexBean)result.getRetObject());
	 		}
		}else{
			ServiceResult result = indexService.transact(member, this.getParameter(), ServiceType.OTHER);
 			if(result.isSuccess()){
 				this.setBean((IndexBean)result.getRetObject());
 			}
		}		
		
		return this.execute();
	}
	/**
	 * flash xml
	 * @return
	 */
	public String doFlashParameter() throws Exception{
		IndexParameter param = (IndexParameter)getParameter();
		param.setBlnFlashImage(true);
		ServiceResult result = indexService.transact(getMember(),param,ServiceType.OTHER);
		
		try {
			List<ChPwAdvinfo> list = (List<ChPwAdvinfo>)result.getRetObject();
			
			String cityid = getMember().getCityid();
			String imgPath = CommunicateConfigLoader.PROPS.getProperty(CommunicateConfig.FLASH_IMAGE_PATH);
			String path = getClass().getResource("").getPath();
			path = path.substring(0,path.indexOf("/WEB-INF/classes/")) + imgPath+"/"+cityid;
			
			getResponse().setContentType("text/xml; charset=UTF-8");
			
			XMLWriter xmlWriter = new XMLWriter(getResponse().getOutputStream());
			
			SAXReader reader = new SAXReader();
			
			Document doc = reader.read(getClass().getClassLoader().getResourceAsStream("com/gmcc/pboss/common/flash/bcastr.xml"));
			Element root = doc.getRootElement();
			Element channel = root.element("channel");
			if(list!=null){
				for(Iterator<ChPwAdvinfo> it = list.iterator();it.hasNext();){
					ChPwAdvinfo cpa = it.next();
					if(cpa.getImgLogoPath()!=null && !"".equals(cpa.getImgLogoPath().trim())){
						String ext = cpa.getImgLogoPath().substring(cpa.getImgLogoPath().lastIndexOf("."));
						
						Element item = DocumentHelper.createElement("item");
						Element link = DocumentHelper.createElement("link");
						Element image = DocumentHelper.createElement("image");
						Element title = DocumentHelper.createElement("title");
						
						link.addText(cpa.getAdvinfoid().toString());
						image.addText(getRequest().getContextPath() +imgPath+"/"+ cityid+"/"+ cpa.getAdvinfoid()+"_1"+ext);
						title.addText(cpa.getTitle());
						
						item.add(link);
						item.add(image);
						item.add(title);
						channel.add(item);	
					}
				}
			}
			xmlWriter.write(doc);
		} catch (Exception e) {
			throw e;
		}
		return null;
	}

    /**
     * ˢ�»���
     */
    public void doRefresh(){
            logger.info(":doRefresh:�������ҵ�����");
            String br = "\n";
            this.operationService.refresh();//ҵ����뻺��-�������
            this.renderText("�������ҵ�����...OK"+ br);
            
            logger.info(":doRefresh:��վ����ҵ�����");
            this.bbcOperationService.refresh();//ҵ����뻺��-��վ����
            this.renderText("��վ����ҵ�����...OK"+ br);
            
            logger.info(":doRefresh:���ʧЧ���뻺��");
            this.adtService.refresh();//���ʧЧ���뻺��
            this.renderText("���ʧЧ���뻺��...OK"+ br);
            
            logger.info(":doRefresh:���ʧЧ���뻺��");
            this.dictItemService.refresh();//���ʧЧ���뻺��
            this.renderText("���ʧЧ���뻺��...OK"+ br);
            
            logger.info(":doRefresh:��ͨƽ̨����");
            this.communicatePlateauService.refresh();//��ͨƽ̨����
            this.renderText("��ͨƽ̨����...OK"+ br);
            
            logger.info(":doRefresh:���๺���������б�ʶ����");
            this.dbBankService.refresh();//��ͨƽ̨����
            this.renderText("���๺���������б�ʶ����...OK"+ br);
            
            logger.info(":doRefresh:�̶���������");
            this.constantService.refresh();//��ͨƽ̨����
            this.renderText("�̶���������...OK"+ br);
            
            //��ҳFlashˢ��
            logger.info(":doRefresh:��ҳFlashˢ��");
            this.communicatePublicService.clear();//��ҳFlash���
            this.communicatePublicService.refresh();//��ҳFlash����
            this.renderText("��ҳFlashˢ��...OK"+ br);
    }
    
	public QueryParameter getParameter() {
		return  new IndexParameter();
	}
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	public IndexService getIndexService() {
		return indexService;
	}

	public void setIndexService(IndexService indexService) {
		this.indexService = indexService;
	}

	public IndexBean getBean() {
		return bean;
	}

	public void setBean(IndexBean bean) {
		this.bean = bean;
	}

	public OperationService getOperationService() {
		return operationService;
	}

	public void setOperationService(OperationService operationService) {
		this.operationService = operationService;
	}

	public OperationService getBbcOperationService() {
		return bbcOperationService;
	}

	public void setBbcOperationService(OperationService bbcOperationService) {
		this.bbcOperationService = bbcOperationService;
	}

	public AdtService getAdtService() {
		return adtService;
	}

	public void setAdtService(AdtService adtService) {
		this.adtService = adtService;
	}

	public DictItemService getDictItemService() {
		return dictItemService;
	}

	public void setDictItemService(DictItemService dictItemService) {
		this.dictItemService = dictItemService;
	}

	public CommunicatePlateauService getCommunicatePlateauService() {
		return communicatePlateauService;
	}

	public void setCommunicatePlateauService(
			CommunicatePlateauService communicatePlateauService) {
		this.communicatePlateauService = communicatePlateauService;
	}

	/**
	 * @return the dbBankService
	 */
	public DbBankService getDbBankService() {
		return dbBankService;
	}

	/**
	 * @param dbBankService the dbBankService to set
	 */
	public void setDbBankService(DbBankService dbBankService) {
		this.dbBankService = dbBankService;
	}

	/**
	 * @return the communicatePublicService
	 */
	public CommunicatePublicService getCommunicatePublicService() {
		return communicatePublicService;
	}

	/**
	 * @param communicatePublicService the communicatePublicService to set
	 */
	public void setCommunicatePublicService(
			CommunicatePublicService communicatePublicService) {
		this.communicatePublicService = communicatePublicService;
	}

	/**
	 * @return the constantService
	 */
	public ConstantService getConstantService() {
		return constantService;
	}

	/**
	 * @param constantService the constantService to set
	 */
	public void setConstantService(ConstantService constantService) {
		this.constantService = constantService;
	}
	
	public void setDelayLoadService(IDelayLoadService delayLoadService) {
		this.delayLoadService = delayLoadService;
	}
	
	
}
