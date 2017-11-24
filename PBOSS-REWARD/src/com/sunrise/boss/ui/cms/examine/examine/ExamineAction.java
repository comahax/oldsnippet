/**
* auto-generated code
* Wed Nov 18 16:17:06 CST 2009
*/
package com.sunrise.boss.ui.cms.examine.examine;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.admin.dictitem.persistent.DictitemListVO;
import com.sunrise.boss.business.admin.dictitem.persistent.DictitemVO;
import com.sunrise.boss.business.cms.citycompany.persistent.CitycompanyListVO;
import com.sunrise.boss.business.cms.citycompany.persistent.CitycompanyVO;
import com.sunrise.boss.business.cms.examine.examine.persistent.ExamineListVO;
import com.sunrise.boss.business.cms.examine.examine.persistent.ExamineVO;
import com.sunrise.boss.business.cms.provincialright.persistent.ProvincialrightListVO;
import com.sunrise.boss.business.cms.provincialright.persistent.ProvincialrightVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.cms.examine.examine.ExamineDelegate;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.ui.commons.taglib.code2name.Code2NameConfiger;

/**
 * <p>Title: ExamineAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ExamineAction extends BaseDelegateAction {
    public ExamineAction() {
            setVoClass(ExamineVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "exmnid"; 
    }

	protected ActionForward doNew(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		this.loadContent(request, user);//加载编辑页面参数
		
		return super.doNew(actionMapping, actionForm, request, response, user);
	}
	
	protected ActionForward doEdit(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		this.loadContent(request, user);//加载编辑页面参数
		return super.doEdit(actionMapping, actionForm, request, response, user);
	}
	
	protected ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		
		this.loadContent(request, user);//加载编辑页面参数
		if(((ExamineForm)actionForm).getCityid()==null || "".equals(((ExamineForm)actionForm).getCityid())){
			if("YES".equals(request.getAttribute("provincialright")))
				((ExamineForm)actionForm).setCityid("GD");
			else
				((ExamineForm)actionForm).setCityid(SessionFactoryRouter.conversionCityid(user.getCityid()));
		}
		return super.doSave(actionMapping, actionForm, request, response, user);
	}
	/**
	 * 加载编辑页面的参数
	 * @param request
	 * @param user
	 * @throws Exception
	 */
	private void loadContent(HttpServletRequest request,User user) throws Exception{
		CommonDelegate comdelegate = new CommonDelegate(ProvincialrightVO.class);
        ProvincialrightListVO provincialrightList=new ProvincialrightListVO();
        provincialrightList.set_se_proopr(user.getOpercode());
        provincialrightList.set_se_rightid("CH_PROFOREXAMINE");
        if(comdelegate.doQuery(provincialrightList, user).getDatas().size()>0){
        	request.setAttribute("provincialright", "YES");
        }
        
        Map startLevelMap=getStartLevel(user);//获取星级
        Map adtypeMap=getAdtype(user);//获取类型
        Map applycityMap=Code2NameConfiger.valueList("CITYNAME",user.getCityid());//获取地市公司MAP
        applycityMap.remove("GD");
        request.setAttribute("startLevelMap", startLevelMap);
        request.setAttribute("adtypeMap", adtypeMap);
        request.setAttribute("applycityMap", applycityMap);
	}
	//获取星级MAP
	public Map getStartLevel(User user){
		Map map = null;
		try{
			CommonDelegate comdelegate = new CommonDelegate(DictitemVO.class);
			DictitemListVO dictitemParam = new DictitemListVO();
			dictitemParam.set_pagesize("0");
			dictitemParam.set_se_groupid("CH_STARLEVEL");
			dictitemParam.set_orderby("dictid");
			DataPackage dictitemDP = comdelegate.doQuery(dictitemParam,user);
			DictitemVO vo=null;
			if( null != dictitemDP && null != dictitemDP.getDatas() && 0<dictitemDP.getDatas().size()){
				map = new TreeMap();
				Iterator it = dictitemDP.getDatas().iterator();
				while(it.hasNext()){
					vo=(DictitemVO)it.next();
					map.put(vo.getDictid(), vo.getDictname());
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
	/**
	 * 获取地市公司MAP
	 * @param user
	 * @return
	 */
	public Map getCitycompany(User user){
		Map map = null;
		try{
			CommonDelegate comdelegate = new CommonDelegate(CitycompanyVO.class);
			CitycompanyListVO param = new CitycompanyListVO();
			param.set_pagesize("0");
			param.set_orderby("citycompid");
			DataPackage dp = comdelegate.doQuery(param,user);
			CitycompanyVO vo=null;
			if( null != dp && null != dp.getDatas() && 0<dp.getDatas().size()){
				map = new TreeMap();
				Iterator it = dp.getDatas().iterator();
				while(it.hasNext()){
					vo=(CitycompanyVO)it.next();
					map.put(vo.getCitycompid(), vo.getCitycompname());
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
	
	//区域类型MAP
	public Map getAdtype(User user){
		Map map = null;
		try{
			CommonDelegate comdelegate = new CommonDelegate(DictitemVO.class);
			DictitemListVO dictitemParam = new DictitemListVO();
			dictitemParam.set_pagesize("0");
			dictitemParam.set_se_groupid("CH_ADTYPE");
			dictitemParam.set_orderby("dictid");
			DataPackage dictitemDP = comdelegate.doQuery(dictitemParam,user);
			DictitemVO vo=null;
			if( null != dictitemDP && null != dictitemDP.getDatas() && 0<dictitemDP.getDatas().size()){
				map = new TreeMap();
				Iterator it = dictitemDP.getDatas().iterator();
				while(it.hasNext()){
					vo=(DictitemVO)it.next();
					map.put(vo.getDictid(), vo.getDictname());
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}

	protected ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		 try {
	        	Page.setPageSize(request, (ExamineForm) actionForm);        	
	        	ExamineListVO listVO = (ExamineListVO)getListVO(); 
	        	setListVO(listVO, actionForm); //设置好listVO，作为查询条件
	        	
	        	ExamineDelegate delegate = (ExamineDelegate)getDelegate();
	            
	            DataPackage pack = null;
	            CommonDelegate comdelegate = new CommonDelegate(ProvincialrightVO.class);
	            ProvincialrightListVO provincialrightList=new ProvincialrightListVO();
	            provincialrightList.set_se_proopr(user.getOpercode());
	            provincialrightList.set_se_rightid("CH_PROFOREXAMINE");
	            if(comdelegate.doQuery(provincialrightList, user).getDatas().size()>0){
	            	request.setAttribute("provincialright", "YES");
	            	pack = delegate.doQuery(listVO, user);
	            }else{
	            	pack = delegate.doQueryExamineList(listVO, user);
	            }
	            request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, pack);
	        }catch(BusinessException e) {
	        	 request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
	        }catch(Exception e) {
	        	throw e;
	        } 
	        return (actionMapping.findForward("list"));
	}
	 protected ActionForward doDelete(ActionMapping actionMapping,
				ActionForm actionForm, HttpServletRequest request,
				HttpServletResponse response, User user) throws Exception {
			String[] selectArray = ((ExamineForm) actionForm).get_selectitem();
			try {
				ExamineDelegate delegate =(ExamineDelegate) getDelegate();		
				for (int i = 0; i < selectArray.length; i++) {
				   delegate.doRemoveExamine(selectArray[i], user);
			   }
				
			}catch(BusinessException e) {
	        	 request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.toString());
	        }catch(Exception e) {
	        	throw e;
	        } 
		   
		    return doList(actionMapping, actionForm, request, response, user);// TODO Auto-generated method stub
	}
	public ActionForward doExaminelist(ActionMapping actionMapping,
					ActionForm actionForm, HttpServletRequest request,
					HttpServletResponse response, User user) throws Exception {
		ExamineDelegate delegate = new ExamineDelegate();
		Page.setPageSize(request, (ExamineForm) actionForm);
		ExamineListVO listVO = (ExamineListVO)getListVO(); 
		setListVO(listVO, actionForm); 
		DataPackage pack =delegate.doQueryExamineList(listVO, user);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, pack);
		return (actionMapping.findForward("examinelist"));
	}
    
}
