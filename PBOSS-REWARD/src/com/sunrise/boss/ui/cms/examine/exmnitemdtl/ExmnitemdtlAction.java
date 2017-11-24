/**
* auto-generated code
* Wed Nov 25 11:16:38 CST 2009
*/
package com.sunrise.boss.ui.cms.examine.exmnitemdtl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.examine.examine.persistent.ExamineVO;
import com.sunrise.boss.business.cms.examine.exmnitem.persistent.ExmnitemVO;
import com.sunrise.boss.business.cms.examine.exmnitemdtl.persistent.ExmnitemdtlListVO;
import com.sunrise.boss.business.cms.examine.exmnitemdtl.persistent.ExmnitemdtlVO;
import com.sunrise.boss.business.cms.provincialright.persistent.ProvincialrightListVO;
import com.sunrise.boss.business.cms.provincialright.persistent.ProvincialrightVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.cms.examine.examine.ExamineDelegate;
import com.sunrise.boss.delegate.cms.examine.exmnitem.ExmnitemDelegate;
import com.sunrise.boss.delegate.cms.examine.exmnitemdtl.ExmnitemdtlDelegate;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: ExmnitemdtlAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ExmnitemdtlAction extends BaseDelegateAction {
    public ExmnitemdtlAction() {
            setVoClass(ExmnitemdtlVO.class);
        // TODO: ������������������
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "seqid"; 
    }

	protected ActionForward doDelete(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		String[] selectArray = ((ExmnitemdtlForm) actionForm).get_selectitem();
		try {
			ExmnitemdtlDelegate delegate =(ExmnitemdtlDelegate) getDelegate();		
			String cityid=request.getParameter("cityid");
		   for (int i = 0; i < selectArray.length; i++) {
			   delegate.doRemoveDtl(Long.valueOf(selectArray[i]), cityid, user);
		   }
		}catch(BusinessException e) {
        	 request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.toString());
        }catch(Exception e) {
        	throw e;
        } 
	   
	    return doList(actionMapping, actionForm, request, response, user);// TODO Auto-generated method stub
	}

	protected ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		// TODO Auto-generated method stub
		ExmnitemdtlListVO listVO = (ExmnitemdtlListVO)getListVO(); 
		ExmnitemdtlForm form =(ExmnitemdtlForm) actionForm;
		form.set_nn_pseqid("null");//�������[PSEQID]��Ϊ��ȥ��ѯ
    	setListVO(listVO, form); //���ú�listVO����Ϊ��ѯ����
    	
    	ExmnitemdtlDelegate delegate = (ExmnitemdtlDelegate)getDelegate();
    	DataPackage dp=delegate.doQuery(listVO, user);
    	request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		
		ExamineDelegate examinedelegate = new ExamineDelegate();
		
    	ExamineVO examineVO=examinedelegate.doFindByPk(Long.valueOf(form.get_ne_exmnid()), user);
    	request.setAttribute("exmncityid", examineVO.getCityid());
    	
		CommonDelegate comdelegate = new CommonDelegate(ProvincialrightVO.class);
        ProvincialrightListVO provincialrightList=new ProvincialrightListVO();
        provincialrightList.set_se_proopr(user.getOpercode());
        provincialrightList.set_se_rightid("CH_PROFOREXAMINE");
        if(comdelegate.doQuery(provincialrightList, user).getDatas().size()>0){
        	request.setAttribute("provincialright", "YES");
        }else{
        	/**
        	 * ��û��ʡ��˾Ȩ�ޣ�����ʡ��˾��������ϸ�б�ʱ����ѯ��Ӧ�ĵ��й�˾���õ������Сֵ
        	 */
        	if("GD".equals(examineVO.getCityid())){
        		Iterator it=dp.getDatas().iterator();
        		ExmnitemdtlVO vo=null;
        		List seqidlist=new ArrayList();
        		while(it.hasNext()){
        			vo =(ExmnitemdtlVO)it.next();
        			seqidlist.add(vo.getSeqid()+"");
        		}
        		ExmnitemdtlListVO params = new ExmnitemdtlListVO();
        		params.set_nin_pseqid(seqidlist);
        		params.set_se_cityid(SessionFactoryRouter.conversionCityid(user.getCityid()));
        		Map map=new HashMap();
        		Iterator data=delegate.doQuery(params, user).getDatas().iterator();
        		Double[] stcrtcls=null;
        		while(data.hasNext()){
        			vo =(ExmnitemdtlVO)data.next();
        			stcrtcls=new Double[2];
        			stcrtcls[0]=vo.getLeastcrtcl();
        			stcrtcls[1]=vo.getLargestcrtcl();
        			map.put(vo.getPseqid(), stcrtcls);
        		}
        		request.setAttribute("MAP", map);
        	}
        }
        
        
		return (actionMapping.findForward("list"));
	}
	public ActionForward doCitylist(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		ExmnitemdtlDelegate delegate = (ExmnitemdtlDelegate)getDelegate();
		ExmnitemdtlForm form =(ExmnitemdtlForm) actionForm;
		ExmnitemdtlListVO listVO=new ExmnitemdtlListVO();
		listVO.set_ne_pseqid(form.get_ne_pseqid());
		DataPackage pack =delegate.doQuery(listVO, user);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, pack);
		
        
		return (actionMapping.findForward("citylist"));
	}

	protected ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		// TODO Auto-generated method stub
		ExmnitemdtlDelegate delegate = (ExmnitemdtlDelegate)getDelegate();
		ExmnitemdtlForm form =(ExmnitemdtlForm) actionForm;
		
		CommonDelegate comdelegate = new CommonDelegate(ProvincialrightVO.class);
        ProvincialrightListVO provincialrightList=new ProvincialrightListVO();
        provincialrightList.set_se_proopr(user.getOpercode());
        provincialrightList.set_se_rightid("CH_PROFOREXAMINE");
        if(comdelegate.doQuery(provincialrightList, user).getDatas().size()>0){
        	request.setAttribute("provincialright", "YES");
        	((ExmnitemdtlForm)actionForm).setCityid("GD");
        }else{
        	((ExmnitemdtlForm)actionForm).setCityid(SessionFactoryRouter.conversionCityid(user.getCityid()));
        	
        }
        ExmnitemdtlVO vo =new ExmnitemdtlVO();
        BeanUtils.copyProperties(vo, form);
		if(delegate.doCheckBeingstcrtcl(vo, user)){//���ڿ�������ϸ�Ľ���
			request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "�÷�Χ�ڵ�ָ��ֵ�Ѵ���");
			return (actionMapping.findForward("content"));
		}
		ExmnitemDelegate itemDelegate = new ExmnitemDelegate();
		Serializable pkVO=new ExmnitemVO();
		BeanUtils.setProperty(pkVO, "exmnid",form.getExmnid());
		BeanUtils.setProperty(pkVO, "exmnstdid",form.getExmnstdid());
		ExmnitemVO exmnitemVO=itemDelegate.doFindByPk(pkVO, user);
		double mk=form.getBasemk().doubleValue();
		if("1".equals(form.getMarktype()))
			mk=form.getBasemk().doubleValue()+form.getDynamicmk().doubleValue();
		if(mk>exmnitemVO.getExmnscore().doubleValue()){
			request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "�������������������ܷ�");
			return (actionMapping.findForward("content"));
		}
    	
		//������Ϊʡ��˾��Ȩ�޲�����ʡ��˾����Ϊ�½���û�и����ʱ��
    	//����ԭ��ʡ��˾ָ������,���ѡ����б�ʶ[CITYID]���滻Ϊ��ǰ���Ź������У�����С/���ָ��ֵ��Ϊ�ı�������дֵ���������б�ʶ[PSEQID]��Ϊʡ��˾��Ӧ���õġ�����[SEQID]��
		ExamineDelegate examinedelegate = new ExamineDelegate();
    	ExamineVO examineVO=examinedelegate.doFindByPk(Long.valueOf(form.get_ne_exmnid()), user);
    	if("GD".equals(examineVO.getCityid())&& !"GD".equals(form.getCityid()) && form.getSeqid()!=null && form.getPseqid()==null){
    		((ExmnitemdtlForm)actionForm).setPseqid(form.getSeqid());
    		ExmnitemdtlListVO listVO=new ExmnitemdtlListVO();
        	listVO.set_ne_pseqid(form.getSeqid()+"");
        	listVO.set_se_cityid(SessionFactoryRouter.conversionCityid(user.getCityid()));
        	Collection coll=delegate.doQuery(listVO, user).getDatas();
        	if(coll.size()==0){
        		((ExmnitemdtlForm)actionForm).setSeqid(null);
        		((ExmnitemdtlForm)actionForm).setCmdState(WebConstant.COMMAND_STRING_NEW);
        	}else{
        		Iterator it=coll.iterator();
        		((ExmnitemdtlForm)actionForm).setSeqid(((ExmnitemdtlVO)it.next()).getSeqid());
        	}
    	}
        
		return super.doSave(actionMapping, actionForm, request, response, user);
	}

	protected ActionForward doEdit(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		// TODO Auto-generated method stub
		ExamineDelegate examinedelegate = new ExamineDelegate();
		ExmnitemdtlForm form =(ExmnitemdtlForm) actionForm;
    	ExamineVO examineVO=examinedelegate.doFindByPk(Long.valueOf(form.get_ne_exmnid()), user);
    	request.setAttribute("exmncityid", examineVO.getCityid());
    	
		CommonDelegate comdelegate = new CommonDelegate(ProvincialrightVO.class);
        ProvincialrightListVO provincialrightList=new ProvincialrightListVO();
        provincialrightList.set_se_proopr(user.getOpercode());
        provincialrightList.set_se_rightid("CH_PROFOREXAMINE");
        if(comdelegate.doQuery(provincialrightList, user).getDatas().size()>0){
        	request.setAttribute("provincialright", "YES");
        }else{
        	if("GD".equals(examineVO.getCityid())){
        		String pk = request.getParameter(WebConstant.REQUEST_ATTRIBUTE_PK);
        		ExmnitemdtlDelegate exmnitemdtldelegate = new ExmnitemdtlDelegate();
        		ExmnitemdtlListVO exmnitemdtlListVO=new ExmnitemdtlListVO();
        		exmnitemdtlListVO.set_ne_pseqid(pk);
        		exmnitemdtlListVO.set_se_cityid(SessionFactoryRouter.conversionCityid(user.getCityid()));
        		Iterator it=exmnitemdtldelegate.doQuery(exmnitemdtlListVO, user).getDatas().iterator();
        		ExmnitemdtlVO cityexmnitemdtl=null;
        		while(it.hasNext()){
        			cityexmnitemdtl=(ExmnitemdtlVO)it.next();
        			request.setAttribute("cityexmnitemdtl", cityexmnitemdtl);
        			continue;
        		}
        	}
        }
		return super.doEdit(actionMapping, actionForm, request, response, user);
	}

	protected ActionForward doNew(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		// TODO Auto-generated method stub
		return super.doNew(actionMapping, actionForm, request, response, user);
	}
    
}
