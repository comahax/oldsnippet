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
 * 门户首页
 * @author Jimmy
 *
 */
public class IndexAction extends AbstractAction {
	
	private static final long serialVersionUID = -6901255601265735617L;
	
	private IndexService indexService;
	
	private IndexBean bean;

    //* 系统缓存Service *
    /**
     * 业务代码缓存-社会渠道
     */
    private OperationService operationService;
    /**
     * 业务代码缓存-网站渠道
     */
    private OperationService bbcOperationService;
    /**
     * 酬金失效编码缓存
     */
    private AdtService adtService;
    /**
     * 商品种类缓存
     */
    private DictItemService dictItemService;
    /**
     * 沟通平台缓存
     */
	private CommunicatePlateauService communicatePlateauService;
	/**
	 * 卡类购销划扣银行标识
	 */
	private DbBankService dbBankService;
	/** 首页Flash图片*/
	private CommunicatePublicService communicatePublicService;
	/**
	 * 固定参数缓存 constantService
	 */
	private ConstantService constantService;
	/**
	 * 延迟加载部分登录信息：合作商资料、上级渠道经理、菜单栏
	 */
	private IDelayLoadService delayLoadService;

	
	/**
	 * 公告/业务/知识库/待办任务/调查问卷查询(首页)/在线答疑
	 * @return
	 */
	public String doIndex(){
		LoginMember member = this.getMember();
		if( !member.isInfoloaded()){//待延迟加载的信息尚未加载，加载这些信息
			member = this.delayLoadService.fillMember(member);
			//获取菜单项
			Map<String,ArrayList> menuMap = member.getMenuMap();
	 		this.getSession().setAttribute("menuMap", menuMap);//将菜单信息放入session中
	 		member.setMenuMap(null);//避免在session中放置2次
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
     * 刷新缓存
     */
    public void doRefresh(){
            logger.info(":doRefresh:社会渠道业务代码");
            String br = "\n";
            this.operationService.refresh();//业务代码缓存-社会渠道
            this.renderText("社会渠道业务代码...OK"+ br);
            
            logger.info(":doRefresh:网站渠道业务代码");
            this.bbcOperationService.refresh();//业务代码缓存-网站渠道
            this.renderText("网站渠道业务代码...OK"+ br);
            
            logger.info(":doRefresh:酬金失效编码缓存");
            this.adtService.refresh();//酬金失效编码缓存
            this.renderText("酬金失效编码缓存...OK"+ br);
            
            logger.info(":doRefresh:酬金失效编码缓存");
            this.dictItemService.refresh();//酬金失效编码缓存
            this.renderText("酬金失效编码缓存...OK"+ br);
            
            logger.info(":doRefresh:沟通平台缓存");
            this.communicatePlateauService.refresh();//沟通平台缓存
            this.renderText("沟通平台缓存...OK"+ br);
            
            logger.info(":doRefresh:卡类购销划扣银行标识缓存");
            this.dbBankService.refresh();//沟通平台缓存
            this.renderText("卡类购销划扣银行标识缓存...OK"+ br);
            
            logger.info(":doRefresh:固定参数缓存");
            this.constantService.refresh();//沟通平台缓存
            this.renderText("固定参数缓存...OK"+ br);
            
            //首页Flash刷新
            logger.info(":doRefresh:首页Flash刷新");
            this.communicatePublicService.clear();//首页Flash清除
            this.communicatePublicService.refresh();//首页Flash缓存
            this.renderText("首页Flash刷新...OK"+ br);
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
