/**
* auto-generated code
* Tue Nov 22 15:32:38 CST 2011
*/
package com.sunrise.boss.ui.cms.reward.ywjfjlmxb;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.sunrise.boss.business.admin.dictitem.persistent.DictitemListVO;
import com.sunrise.boss.business.admin.dictitem.persistent.DictitemVO;
import com.sunrise.boss.business.cms.reward.salepointflag.persistent.SalepointflagListVO;
import com.sunrise.boss.business.cms.reward.salepointflag.persistent.SalepointflagVO;
import com.sunrise.boss.business.cms.reward.ywjfbb.persistent.YwjfbbListVO;
import com.sunrise.boss.business.cms.reward.ywjfjlmxb.persistent.YwjfjlmxbListVO;
import com.sunrise.boss.business.cms.reward.ywjfjlmxb.persistent.YwjfjlmxbVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.admin.dictitem.DictitemDelegate;
import com.sunrise.boss.delegate.cms.reward.salepointflag.SalepointflagDelegate;
import com.sunrise.boss.delegate.cms.reward.ywjfbb.YwjfbbDelegate;
import com.sunrise.boss.delegate.cms.reward.ywjfjlmxb.YwjfjlmxbDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.cms.reward.ywjfbb.YwjfbbForm;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: YwjfjlmxbAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public class YwjfjlmxbAction extends BaseAction {
    public YwjfjlmxbAction() {
            setVoClass(YwjfjlmxbVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[3]; 
           pkNameArray[0] = "wayid";
           pkNameArray[1] = "flag"; 
           pkNameArray[2] = "busivalue"; 
    }
    
    public ActionForward doShow(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user)throws Exception {		
    	
    	try {
    		
    		DictitemDelegate dddelegate =new DictitemDelegate();
        	DictitemListVO dictitemListVO=new DictitemListVO();
        	dictitemListVO.set_se_groupid("CH_SALEPOINT");
        	
//        	List<SalepointflagVO> list=new ArrayList<SalepointflagVO>();
        	Map map=new HashMap();
        	DataPackage dataPackage=dddelegate.doQuery(dictitemListVO, user);
        	if(dataPackage!=null&&dataPackage.getDatas().size()>0){
        		Iterator it=dataPackage.getDatas().iterator();
        		while(it.hasNext()){
        			DictitemVO ywjfjlmxbVO=(DictitemVO)it.next();
        			map.put(ywjfjlmxbVO.getDictid(), ywjfjlmxbVO.getDictname());
        		}
        	}
    		
			SalepointflagDelegate delegate=new SalepointflagDelegate();
			SalepointflagListVO listVO =new SalepointflagListVO();
			listVO.set_se_cityid(SessionFactoryRouter.conversionCityid(user.getCityid()));
			String queryflag="";
			DataPackage dp=delegate.doQuery(listVO, user);
			if(dp!=null&&dp.getDatas().size()>0){
				Iterator it=dp.getDatas().iterator();
				while(it.hasNext()){
					SalepointflagVO  salepointflagVO=(SalepointflagVO)it.next();
//					queryflag=queryflag+salepointflagVO.getFlag()+"|";
					if((String)map.get(salepointflagVO.getFlag())!=null){
						queryflag=queryflag+(String)map.get(salepointflagVO.getFlag())+"|";
					}else{
						queryflag=queryflag+salepointflagVO.getFlag()+"|";
					}
					
				}
			}
			
			
			
			YwjfjlmxbForm ywjfbbForm=(YwjfjlmxbForm)actionForm;
			ywjfbbForm.set_se_flag(queryflag);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
//    	this.addErrors(request, errors)
    	
    	return (actionMapping.findForward("list"));
    }
    
    public ActionForward doList(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception{		
    	
    	YwjfjlmxbForm ywjfbbForm=(YwjfjlmxbForm)actionForm;
    	ywjfbbForm.set_pagesize("15");
    	
    	if("".equals(ywjfbbForm.get_se_flag().trim())){
//    		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,"业务类型不能为空！");
    		throw new Exception("业务类型不能为空！");
    	}
    	
//    	Set set=new HashSet();
//    	for(int i=0;i<ids.length;i++){
//    		set.add(ids[i]);
//    	}
    	
    	DictitemDelegate delegate =new DictitemDelegate();
    	DictitemListVO dictitemListVO=new DictitemListVO();
    	dictitemListVO.set_se_groupid("CH_SALEPOINT");
    	dictitemListVO.set_pagesize("0");
    	
    	List<SalepointflagVO> list=new ArrayList<SalepointflagVO>();
    	Map map=new HashMap();
    	Map revmap=new HashMap();
    	DataPackage dataPackage=delegate.doQuery(dictitemListVO, user);
    	
    	if(dataPackage!=null&&dataPackage.getDatas().size()>0){
    		Iterator it=dataPackage.getDatas().iterator();
    		while(it.hasNext()){
    			DictitemVO ywjfjlmxbVO=(DictitemVO)it.next();
    			map.put(ywjfjlmxbVO.getDictid(), ywjfjlmxbVO.getDictname());
    			revmap.put(ywjfjlmxbVO.getDictname(), ywjfjlmxbVO.getDictid());
    		}
    	}
    	
    	String[] revids=ywjfbbForm.get_se_flag().split("\\|");
    	String[] ids=new String[revids.length];
    	for(int i=0;i<revids.length;i++){
    		if((String)revmap.get(revids[i])!=null){
    			ids[i]=(String)revmap.get(revids[i]);
    		}else{
    			throw new Exception("业务类型在字典表找不到业务类型:"+revids[i]);
    		}
		}
    	
    	
    	
//    	ywjfbbForm.set_se_flag("DZZD");
    	//保存每个地市自己的 CH_ADT_SALEPOINTFLAG,必须删除以前的数据,当前地市的
    	SalepointflagDelegate salepointflagDelegate=new SalepointflagDelegate();
    	SalepointflagListVO salepointflagListVO=new SalepointflagListVO();
    	salepointflagListVO.set_se_cityid(SessionFactoryRouter.conversionCityid(user.getCityid()));
    	salepointflagListVO.set_pagesize("0");
    	DataPackage dp2=salepointflagDelegate.doQuery(salepointflagListVO, user);
    	if(dp2!=null&&dp2.getDatas().size()>0){
    		Iterator it=dp2.getDatas().iterator();
    		while(it.hasNext()){
    			SalepointflagVO salepointflagVO=(SalepointflagVO)it.next();
    			salepointflagDelegate.doRemove(salepointflagVO, user);
    		}
    	}
    	
    	
    	for(int i=0;i<ids.length;i++){
    		SalepointflagVO salepointflagVO=new SalepointflagVO();
    		salepointflagVO.setCityid(SessionFactoryRouter.conversionCityid(user.getCityid()));
    		salepointflagVO.setFlag(ids[i]);
    		if((String)map.get(ids[i])!=null){
    			salepointflagVO.setFlagname((String)map.get(ids[i]));
    		}else{
    			salepointflagVO.setFlagname(ids[i]);
    		}
    		salepointflagDelegate.doCreate(salepointflagVO, user);
    	}
    	
    	YwjfjlmxbDelegate ywjfbbDelegate=new YwjfjlmxbDelegate();
    	YwjfjlmxbListVO ywjfbbListVO =new YwjfjlmxbListVO();
//    	YwjfjlmxbForm ywjfbbForm=(YwjfjlmxbForm)actionForm;
    	BeanUtils.copyProperties(ywjfbbListVO, ywjfbbForm);
    	ywjfbbListVO.set_pagesize("15");
    	DataPackage dp=ywjfbbDelegate.doQuery(ywjfbbListVO, user,ids);
    	/*
    	List newlist=new ArrayList();;
    	
    	if(dp!=null&&dp.getDatas().size()>0){
    		Iterator it=dp.getDatas().iterator();
    		while(it.hasNext()){
    			YwjfjlmxbVO ywjfjlmxbVO=(YwjfjlmxbVO)it.next();
    			if(set.contains(ywjfjlmxbVO.getFlag())){
    				newlist.add(ywjfjlmxbVO);
    			}
    			
    		}
    	}
    	DataPackage dataPack = new DataPackage();
    	dataPack.setDatas(newlist);
    	dataPack.setPageNo(1);
		dataPack.setPageSize(20);
		dataPack.setRowCount(newlist.size());
    	*/
    	request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
//		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dataPack);
		return (actionMapping.findForward("list"));
    	
    }
    
    /**
	 * 导出Excel文件
	 */
	public ActionForward doExcel(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("业务积分奖励明细表");
		export.appendHeadLine(new String[] { "导出工号:", user.getOpercode() });
		export.appendHeadLine(new String[] { "导出时间:",format.format(new Date()) });
		export.addOutputProperty("wayid", "网点编码");
		export.addOutputProperty("wayname", "网点名称");
		export.addOutputProperty("starlevel", "星级",export.CODE2NAME,"$CH_STARLEVEL");
		export.addOutputProperty("calcmonth", "所属月份");
		export.addOutputProperty("flag", "业务名称",export.CODE2NAME,"$CH_SALEPOINT");
		export.addOutputProperty("busivalue", "业务量");
		export.addOutputProperty("creditstd", "积分标准");
		export.addOutputProperty("creditaccount", "积分");
					
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		
		export.voClassArray = new Class[] { voClass };
		export.queryMethodName = "doExcel22";
		if (export.headtitle == null) {
			export.headtitle = export.getFileName();
		}
		export.buildExcelPage(actionMapping, actionForm, request, response, user, this);
		
		return actionMapping.findForward(null);
	}
	
    public ActionForward doExcel22(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception{		
    	
    	YwjfjlmxbForm ywjfbbForm=(YwjfjlmxbForm)actionForm;
//    	ywjfbbForm.set_pagesize("15");
    	
    	if("".equals(ywjfbbForm.get_se_flag().trim())){
//    		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,"业务类型不能为空！");
    		throw new Exception("业务类型不能为空！");
    	}
    	
//    	Set set=new HashSet();
//    	for(int i=0;i<ids.length;i++){
//    		set.add(ids[i]);
//    	}
    	
    	DictitemDelegate delegate =new DictitemDelegate();
    	DictitemListVO dictitemListVO=new DictitemListVO();
    	dictitemListVO.set_se_groupid("CH_SALEPOINT");
    	dictitemListVO.set_pagesize("0");
    	
    	List<SalepointflagVO> list=new ArrayList<SalepointflagVO>();
    	Map map=new HashMap();
    	Map revmap=new HashMap();
    	DataPackage dataPackage=delegate.doQuery(dictitemListVO, user);
    	
    	if(dataPackage!=null&&dataPackage.getDatas().size()>0){
    		Iterator it=dataPackage.getDatas().iterator();
    		while(it.hasNext()){
    			DictitemVO ywjfjlmxbVO=(DictitemVO)it.next();
    			map.put(ywjfjlmxbVO.getDictid(), ywjfjlmxbVO.getDictname());
    			revmap.put(ywjfjlmxbVO.getDictname(), ywjfjlmxbVO.getDictid());
    		}
    	}
    	
    	String[] revids=ywjfbbForm.get_se_flag().split("\\|");
    	String[] ids=new String[revids.length];
    	for(int i=0;i<revids.length;i++){
    		if((String)revmap.get(revids[i])!=null){
    			ids[i]=(String)revmap.get(revids[i]);
    		}else{
    			throw new Exception("业务类型在字典表找不到业务类型:"+revids[i]);
    		}
		}
    	
    	
    	
//    	ywjfbbForm.set_se_flag("DZZD");
    	//保存每个地市自己的 CH_ADT_SALEPOINTFLAG,必须删除以前的数据,当前地市的
    	SalepointflagDelegate salepointflagDelegate=new SalepointflagDelegate();
    	SalepointflagListVO salepointflagListVO=new SalepointflagListVO();
    	salepointflagListVO.set_se_cityid(SessionFactoryRouter.conversionCityid(user.getCityid()));
    	salepointflagListVO.set_pagesize("0");
    	DataPackage dp2=salepointflagDelegate.doQuery(salepointflagListVO, user);
    	if(dp2!=null&&dp2.getDatas().size()>0){
    		Iterator it=dp2.getDatas().iterator();
    		while(it.hasNext()){
    			SalepointflagVO salepointflagVO=(SalepointflagVO)it.next();
    			salepointflagDelegate.doRemove(salepointflagVO, user);
    		}
    	}
    	
    	
    	for(int i=0;i<ids.length;i++){
    		SalepointflagVO salepointflagVO=new SalepointflagVO();
    		salepointflagVO.setCityid(SessionFactoryRouter.conversionCityid(user.getCityid()));
    		salepointflagVO.setFlag(ids[i]);
    		if((String)map.get(ids[i])!=null){
    			salepointflagVO.setFlagname((String)map.get(ids[i]));
    		}else{
    			salepointflagVO.setFlagname(ids[i]);
    		}
    		salepointflagDelegate.doCreate(salepointflagVO, user);
    	}
    	
    	YwjfjlmxbDelegate ywjfbbDelegate=new YwjfjlmxbDelegate();
    	YwjfjlmxbListVO ywjfbbListVO =new YwjfjlmxbListVO();
//    	YwjfjlmxbForm ywjfbbForm=(YwjfjlmxbForm)actionForm;
    	BeanUtils.copyProperties(ywjfbbListVO, ywjfbbForm);
//    	ywjfbbListVO.set_pagesize("15");
    	DataPackage dp=ywjfbbDelegate.doQuery(ywjfbbListVO, user,ids);
    	/*
    	List newlist=new ArrayList();;
    	
    	if(dp!=null&&dp.getDatas().size()>0){
    		Iterator it=dp.getDatas().iterator();
    		while(it.hasNext()){
    			YwjfjlmxbVO ywjfjlmxbVO=(YwjfjlmxbVO)it.next();
    			if(set.contains(ywjfjlmxbVO.getFlag())){
    				newlist.add(ywjfjlmxbVO);
    			}
    			
    		}
    	}
    	DataPackage dataPack = new DataPackage();
    	dataPack.setDatas(newlist);
    	dataPack.setPageNo(1);
		dataPack.setPageSize(20);
		dataPack.setRowCount(newlist.size());
    	*/
    	request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
//		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dataPack);
		return (actionMapping.findForward("list"));
    	
    }
    
}
