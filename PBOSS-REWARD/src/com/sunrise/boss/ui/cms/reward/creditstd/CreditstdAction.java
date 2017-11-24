/**
* auto-generated code
* Wed May 18 15:47:28 CST 2011
*/
package com.sunrise.boss.ui.cms.reward.creditstd;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.common.CheckUtil;
import com.sunrise.boss.business.cms.reward.creditstd.persistent.CreditstdListVO;
import com.sunrise.boss.business.cms.reward.creditstd.persistent.CreditstdVO;
import com.sunrise.boss.business.cms.reward.creditstd.persistent.VCreditstdVO;
import com.sunrise.boss.business.cms.reward.ruleitem.persistent.RuleitemListVO;
import com.sunrise.boss.business.cms.reward.ruleitem.persistent.RuleitemVO;
import com.sunrise.boss.business.cms.reward.rulerel.persistent.RulerelListVO;
import com.sunrise.boss.business.cms.reward.rulerel.persistent.RulerelVO;
import com.sunrise.boss.business.cms.reward.stdrewardcq.persistent.StdrewardcqListVO;
import com.sunrise.boss.business.cms.reward.stdrewardcq.persistent.StdrewardcqVO;
import com.sunrise.boss.business.cms.stdreward.persistent.StdrewardListVO;
import com.sunrise.boss.business.cms.stdreward.persistent.StdrewardVO;
import com.sunrise.boss.business.cms.stdrewardbs.persistent.StdrewardbsListVO;
import com.sunrise.boss.business.cms.stdrewardbs.persistent.StdrewardbsVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.delegate.cms.reward.creditstd.CreditstdDelegate;
import com.sunrise.boss.delegate.cms.reward.ruleitem.RuleitemDelegate;
import com.sunrise.boss.delegate.cms.reward.rulerel.RulerelDelegate;
import com.sunrise.boss.delegate.cms.reward.stdrewardcq.StdrewardcqDelegate;
import com.sunrise.boss.delegate.cms.stdreward.StdrewardDelegate;
import com.sunrise.boss.delegate.cms.stdrewardbs.StdrewardbsDelegate;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.cms.reward.stdrewardut.StdrewardutForm;
import com.sunrise.boss.ui.cms.stdrewardbs.StdrewardbsForm;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: CreditstdAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
public class CreditstdAction extends BaseDelegateAction {
    public CreditstdAction() {
            setVoClass(CreditstdVO.class);
        // TODO: ������������������
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "seq"; 
    }
    
    // ��ѯ
	public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		// �趨��ѯ����
		CreditstdForm form = (CreditstdForm)actionForm;
		form.set_ne_cityid(user.getCityid());
//		return super.doList(actionMapping, actionForm, request, response, user);
		CreditstdDelegate creditstdDelegate=new CreditstdDelegate();
		CreditstdListVO creditstdListVO=new CreditstdListVO();
		if(!"".equals(form.get_ne_adtypecode())){
			creditstdListVO.set_ne_adtypecode(form.get_ne_adtypecode());
		}
		if(!"".equals(form.get_ne_slv())){
			creditstdListVO.set_ne_slv(form.get_ne_slv());
		}
		if(!"".equals(form.get_ne_slvlev())){
			creditstdListVO.set_ne_slvlev(form.get_ne_slvlev());
		}
		creditstdListVO.set_pagesize("");
		DataPackage dp= creditstdDelegate.doQuery2(creditstdListVO, user);
		
		request.setAttribute("dp", dp);
		return (actionMapping.findForward("list"));
		
	}
	
	// ����
	public ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		
		CreditstdForm form = (CreditstdForm)actionForm;
		form.setCityid(Short.valueOf(user.getCityid()));
		if("54".equals(form.getRewardtype())){
			form.setRewardstd(Double.valueOf(form.getRewardstd11()));
		}
		
		//��������ݽ�����֤
		
		CreditstdDelegate creditstdDelegate1 = new CreditstdDelegate();
		
		//���rewardid�ֶ�,Select REWARDID,REWARDNAME from CH_PW_STDREWARD where REWARDTYPE in('54','55');
		StdrewardDelegate stdrewardDelegate=new StdrewardDelegate();
		StdrewardListVO stdrewardlistvo =new StdrewardListVO();
		//�����Ѿ�ȷ��,Select REWARDID,REWARDNAME from CH_PW_STDREWARD where REWARDTYPE in('54','55');
		stdrewardlistvo.set_ne_rewardtype(form.getRewardtype());
		DataPackage dataPackage2=stdrewardDelegate.doQuery(stdrewardlistvo, user);
		if (dataPackage2 != null && dataPackage2.getDatas().size() > 0) {
			Iterator it = dataPackage2.getDatas().iterator();
			while(it.hasNext()) {
				StdrewardVO VO=(StdrewardVO)it.next();
				form.setRewardid(VO.getRewardid());
				form.setRewardname(VO.getRewardname());
			}
		}else{
			request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
       		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "û�в鵽��ǰ������Ͷ�Ӧ�ĳ���ʶ,����ϵcomsά����Ա."); 
       		load4exh(request,user) ;
       		return (actionMapping.findForward("content"));
		}
		
		//ȡ��ʡ��˾�ı�׼,�н�or �����ı�׼
		Double cityorcountrystd=0.0;
		Long cityorcountycore=0L;
		Long cityorcountyaccount=0L;
		StdrewardbsDelegate stdrewardbsDelegate=new StdrewardbsDelegate();
		StdrewardbsListVO stdrewardbsListVO=new StdrewardbsListVO();
		stdrewardbsListVO.set_se_region(user.getCityid());
		if("1".equals(form.getSlv().toString()))
			stdrewardbsListVO.set_se_slv("100000");
		if("2".equals(form.getSlv().toString()))
			stdrewardbsListVO.set_se_slv("010000");
		if("3".equals(form.getSlv().toString()))
			stdrewardbsListVO.set_se_slv("001000");
		if("4".equals(form.getSlv().toString()))
			stdrewardbsListVO.set_se_slv("000100");
		if("5".equals(form.getSlv().toString()))
			stdrewardbsListVO.set_se_slv("000010");
		if("6".equals(form.getSlv().toString()))
			stdrewardbsListVO.set_se_slv("000001");
		stdrewardbsListVO.set_ne_islimt("1");
//		stdrewardbsListVO.set_ne_rewardid(form.getRewardid().toString());
		DataPackage dataPackage=stdrewardbsDelegate.doQuery(stdrewardbsListVO, user);
		
		if (dataPackage != null && dataPackage.getDatas().size() > 0) {
			Iterator it = dataPackage.getDatas().iterator();
			if (it.hasNext()) {
				StdrewardbsVO stdrewardbsVO=(StdrewardbsVO)it.next();
				//0,��ʾ����;1,��ʾ�ǽ�
				if("1".equals(form.getAdtypecode().toString())){
					if(stdrewardbsVO.getCountrystd()!=null){
						cityorcountrystd=stdrewardbsVO.getCountrystd();
					}else{
						request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
			       		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "���Ǽ���ʡ��׼Ϊ��,����ϵʡ��˾��������ʡ��׼."); 
			       		load4exh(request,user) ;
			       		return (actionMapping.findForward("content"));
					}
					if("55".equals(form.getRewardtype())){
						if(stdrewardbsVO.getCountycorelimit()!=null){
							cityorcountycore=stdrewardbsVO.getCountycorelimit();
						}else{
							request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
							request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "���Ǽ���ʡ��׼Ϊ��,����ϵʡ��˾��������ʡ��׼."); 
							load4exh(request,user) ;
							return (actionMapping.findForward("content"));
						}
						if(stdrewardbsVO.getCountyaccountlimit()!=null){
							cityorcountyaccount=stdrewardbsVO.getCountyaccountlimit();
						}else{
							request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
							request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "���Ǽ���ʡ��׼Ϊ��,����ϵʡ��˾��������ʡ��׼."); 
							load4exh(request,user) ;
							return (actionMapping.findForward("content"));
						}
					}
//					cityorcountycore=stdrewardbsVO.getCountycorelimit();
//					cityorcountyaccount=stdrewardbsVO.getCountyaccountlimit();
				}
				if("0".equals(form.getAdtypecode().toString())){
//					cityorcountrystd=stdrewardbsVO.getCitystd();
//					cityorcountyaccount=stdrewardbsVO.getCityaccountlimit();
//					cityorcountycore=stdrewardbsVO.getCitycorelimit();
					if(stdrewardbsVO.getCitystd()!=null){
						cityorcountrystd=stdrewardbsVO.getCitystd();
					}else{
						request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
			       		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "���Ǽ���ʡ��׼Ϊ��,����ϵʡ��˾��������ʡ��׼."); 
			       		load4exh(request,user) ;
			       		return (actionMapping.findForward("content"));
					}
					if("55".equals(form.getRewardtype())){
						if(stdrewardbsVO.getCityaccountlimit()!=null){
							cityorcountyaccount=stdrewardbsVO.getCityaccountlimit();
						}else{
							request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
							request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "���Ǽ���ʡ��׼Ϊ��,����ϵʡ��˾��������ʡ��׼."); 
							load4exh(request,user) ;
							return (actionMapping.findForward("content"));
						}
						if(stdrewardbsVO.getCitycorelimit()!=null){
							cityorcountycore=stdrewardbsVO.getCitycorelimit();
						}else{
							request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
							request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "���Ǽ���ʡ��׼Ϊ��,����ϵʡ��˾��������ʡ��׼."); 
							load4exh(request,user) ;
							return (actionMapping.findForward("content"));
						}
					}
				}
				
			}
		}
		
		/*  */
		
		form.setCityid(Short.valueOf(user.getCityid()));			
		CreditstdListVO listvo = new CreditstdListVO();
		listvo.set_ne_cityid(user.getCityid());
		listvo.set_ne_slv(form.getSlv().toString());
		listvo.set_ne_adtypecode(form.getAdtypecode().toString());
		listvo.set_ne_slvlev(form.getSlvlev().toString());
		listvo.set_se_ruleid(form.getRuleid());
		listvo.set_ne_intvmonth(form.getIntvmonth().toString());
		DataPackage dp = creditstdDelegate1.doQuery(listvo, user);
		if (dp != null && dp.getDatas().size() > 0) {
			request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
       		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "ͬ������ͬһ�������ʶ��ͬһ���Ǽ���ͬһ���Ǽ��ֲ㣬ͬһ������·ݣ�ͬһ��������룬���ܴ���������¼"); 
       		load4exh(request,user) ;
       		return (actionMapping.findForward("content"));
		}
		
		//�����Ǽ�,�����ʶ,����,�õ���Ӧ����Ǯ��,ǰ�����õ��ܵ�Ǯ��,��ѯ���ǵ�ǰ�Ǽ���ε��ܺ�
		Double hadtotalmoney=0.0;
		CreditstdDelegate creditstdDelegate=new CreditstdDelegate();
		CreditstdListVO creditstdListVO=new CreditstdListVO();
		creditstdListVO.set_ne_cityid(user.getCityid());
		creditstdListVO.set_ne_slv(form.getSlv().toString());
		creditstdListVO.set_ne_slvlev(form.getSlvlev().toString());
		creditstdListVO.set_ne_adtypecode(form.getAdtypecode().toString());
		creditstdListVO.set_nne_intvmonth(form.getIntvmonth().toString());
		creditstdListVO.set_nne_ruleid(form.getRuleid());
		Double dppp=creditstdDelegate.doQuerysums4singlton(creditstdListVO, user);
		if(dppp!=null){
			hadtotalmoney=dppp;
		}
		if((form.getRewardstd()+hadtotalmoney)>cityorcountrystd){
			request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
       		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "���ŵ겹�����߻��ֽ�����׼�����ܴ���ʡ��˾�趨�Ǽ�������׼����["+cityorcountrystd+"]��"); 
       		
       		load4exh(request,user) ;
       		
       		return (actionMapping.findForward("content"));
		}
		// 55 ��ʾ�Ǽ����,Ҫ�Ƚ��׿����۱�׼������ҵ������׼����CARDSTD���ͻ���
		if("55".equals(form.getRewardtype())){
			
			if((form.getCardstd())<cityorcountycore){
				request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
	       		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����ҵ������׼����С��ʡ��˾�趨����ҵ������׼����["+cityorcountycore+"]��"); 
	       		
	       		load4exh(request,user) ;
	       		return (actionMapping.findForward("content"));
			}
			
			if((form.getCreditstd())<cityorcountyaccount){
				request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
	       		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "���ۻ��ֱ�׼����С��ʡ��˾�趨���ۻ��ֱ�׼����["+cityorcountyaccount+"]��"); 
	       		
	       		load4exh(request,user) ;
	       		return (actionMapping.findForward("content"));
			}
			
		}
		
		
		// �й�˾����������A�Ǽ��ֲ��׼�ſ������������Ǽ�����׼
		form.setCityid(Short.valueOf(user.getCityid()));			
		CreditstdListVO listvo123 = new CreditstdListVO();
		listvo123.set_ne_cityid(user.getCityid());
		listvo123.set_ne_slv(form.getSlv().toString());
		listvo123.set_ne_adtypecode(form.getAdtypecode().toString());
		listvo123.set_ne_slvlev("1");
		if("55".equals(form.getRewardtype())){
			listvo123.set_ne_rewardtype("55");
		}else{
			listvo123.set_ne_rewardtype("54");
		}
		
		boolean dp123 = creditstdDelegate1.doCheckHasALevel(listvo123, user);
		if (dp123) {				
		} else {
			if (form.getSlvlev().intValue() != 1) {
				request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
           		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "�й�˾û������A�Ǽ��ֲ��׼���й�˾Ҫ������A�Ǽ��ֲ��׼�ſ������������Ǽ�����׼��"); 
           		
           		load4exh(request,user) ;
           		return (actionMapping.findForward("content"));
			}
		}
		
		//�����doSave()����,��д,load�������ݼ�
		
		Object contentVO = voClass.newInstance();
	       setSaveVO(contentVO, actionForm); //�ڴ˸�ʽ������� vo �Ա���
	       
	       //if(pkNameArray.length > 1)
	       //   throw new RuntimeException("Multiple pk not supported by default doSave. Try to implement this method.");
	       
	       //Object pk = PropertyUtils.getProperty(contentVO, pkNameArray[0]);
	       Object delegate = getDelegate();
	       String methodName = "doFindByPk";
	       
	       Object existObj = null;
	       
	   	    if(pkNameArray.length==1){ //��һ����
			   Object pk = (Object)BeanUtils.getProperty(contentVO, pkNameArray[0]);
			   if(pk!=null){
				   existObj = invokeDelegateMethod(delegate,methodName,new Object[]{(Serializable)pk, user});
			   }
		      }else{//��������
			     Object pkVO = voClass.newInstance();
			     BeanUtils.copyProperties(pkVO, contentVO);
			     existObj = invokeDelegateMethod(delegate,methodName,new Object[]{pkVO, user});
		     } 
	       
	       
	 	   if(existObj!=null) {
	 		   org.apache.commons.beanutils.BeanUtils.copyProperties(existObj, contentVO);
	    	   contentVO = existObj;
		   }  
	       
	       
	       String cmdState = ((BaseActionForm)actionForm).getCmdState();
		   try {
		       if (WebConstant.COMMAND_STRING_EDIT.equals(cmdState)) {
		    	   
		    	   methodName = "doUpdate";
		    	   contentVO = invokeDelegateMethod(delegate,methodName,new Object[]{contentVO, user});
		          
		       } else {
		    	   if(existObj!=null) {
		    		    request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
		           		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "��ͬ��¼�Ѵ���"); 
		           		onDuplicatePk(actionMapping,actionForm, request, response, user);
		           		
		           		load4exh(request,user) ;
		           		
		           		return (actionMapping.findForward("content"));
		    	   }else {
		    		   methodName = "doCreate";
		        	   contentVO = invokeDelegateMethod(delegate,methodName,new Object[]{contentVO, user});  
		    	   }
		       }
		       BeanUtils.copyProperties(actionForm, contentVO); //�Ѹ��º��ֵ����form������web��ʾ
		       ((BaseActionForm)actionForm).setCmdState(WebConstant.COMMAND_STRING_EDIT);
		       
		       
		       request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����ɹ�");
			}catch(BusinessException e) {
	        	 request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.toString());
	        }catch(Exception e) {
	        	throw e;
	        } 
	       
	        load4exh(request,user) ;
	        
	       return (actionMapping.findForward("content"));
		
//		return super.doSave(actionMapping, actionForm, request, response, user);
	}
	protected ActionForward doEdit(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		
		CreditstdListVO listvo = new CreditstdListVO();
		CreditstdForm form = (CreditstdForm)actionForm;
//		String pk = request.getParameter("PK");
		String pk ="";
		if(request.getParameter("PK")==null){
			pk = (String)request.getAttribute("PK");
		}
		else{
			pk = request.getParameter("PK");
		}
		String[] pks=pk.split("\\|");
		listvo.set_ne_slv(pks[0]);
		listvo.set_ne_slvlev(pks[1]);
		listvo.set_ne_adtypecode(pks[2]);
		listvo.set_ne_cityid(user.getCityid());
		CreditstdDelegate delegate = new CreditstdDelegate();
		DataPackage dp=new DataPackage();
		if("55".equals(pks[3])){
			dp = delegate.doQuerystar(listvo, user);
			request.setAttribute("opnidss", "0701010100002");
		}
		if("54".equals(pks[3])){
			dp = delegate.doQuerystore(listvo, user);
			request.setAttribute("opnidss", "0701010100003");
		}
		
		//������ҳ����ʾ,�н�or �����ı�׼
		String cityorcountrystd="";
		String cityorcountrycore="";
		String cityorcountryaccount="";
		StdrewardbsDelegate stdrewardbsDelegate=new StdrewardbsDelegate();
		StdrewardbsListVO stdrewardbsListVO=new StdrewardbsListVO();
		stdrewardbsListVO.set_se_region(user.getCityid());
//		stdrewardbsListVO.set_se_slv(pks[0]);
		
		if("1".equals(pks[0]))
			stdrewardbsListVO.set_se_slv("100000");
		if("2".equals(pks[0]))
			stdrewardbsListVO.set_se_slv("010000");
		if("3".equals(pks[0]))
			stdrewardbsListVO.set_se_slv("001000");
		if("4".equals(pks[0]))
			stdrewardbsListVO.set_se_slv("000100");
		if("5".equals(pks[0]))
			stdrewardbsListVO.set_se_slv("000010");
		if("6".equals(pks[0]))
			stdrewardbsListVO.set_se_slv("000001");
		
		stdrewardbsListVO.set_ne_islimt("1");
		DataPackage dataPackage=stdrewardbsDelegate.doQuery(stdrewardbsListVO, user);
		
		if (dataPackage != null && dataPackage.getDatas().size() > 0) {
			Iterator it = dataPackage.getDatas().iterator();
			if (it.hasNext()) {
				StdrewardbsVO stdrewardbsVO=(StdrewardbsVO)it.next();
				//0,��ʾ����;1,��ʾ�ǽ�;
				if("1".equals(pks[2])){
					if(stdrewardbsVO.getCountrystd()!=null){
						cityorcountrystd="�ǽ�����Ϊ:"+stdrewardbsVO.getCountrystd().toString();
					}else{
						cityorcountrystd="�ǽ�����û������";
					}
					if(stdrewardbsVO.getCountycorelimit()!=null){
						cityorcountrycore="�ǽ�����Ϊ:"+stdrewardbsVO.getCountycorelimit().toString();
					}else{
						cityorcountrycore="�ǽ�����û������";
					}
					if(stdrewardbsVO.getCountyaccountlimit()!=null){
						cityorcountryaccount="�ǽ�����Ϊ:"+stdrewardbsVO.getCountyaccountlimit().toString();
					}else{
						cityorcountryaccount="�ǽ�����û������";
					}
				}
				if("0".equals(pks[2])){
					if(stdrewardbsVO.getCitystd()!=null){
						cityorcountrystd="��������Ϊ:"+stdrewardbsVO.getCitystd().toString();
					}else{
						cityorcountrystd="��������û������";
					}
					if(stdrewardbsVO.getCitycorelimit()!=null){
						cityorcountrycore="��������Ϊ:"+stdrewardbsVO.getCitycorelimit().toString();
					}else{
						cityorcountrycore="�ǽ�����û������";
					}
					if(stdrewardbsVO.getCityaccountlimit()!=null){
						cityorcountryaccount="��������Ϊ:"+stdrewardbsVO.getCityaccountlimit().toString();
					}else{
						cityorcountryaccount="��������û������";
					}
				}
					
				
			}
		}else{
			if("1".equals(pks[2])){
				cityorcountrystd="�ǽ�����û������";
				cityorcountrycore="�ǽ�����û������";
				cityorcountryaccount="�ǽ�����û������";
			}
			if("0".equals(pks[2])){
				cityorcountrystd="��������û������";
				cityorcountrycore="��������û������";
				cityorcountryaccount="��������û������";
			}
				
		}
		
		dp.setRowCount(dp.getDatas().size());
		request.setAttribute("dp", dp);
		request.setAttribute("slv", pks[0]);
		request.setAttribute("slvlev", pks[1]);
		request.setAttribute("adtypecode", pks[2]);
		request.setAttribute("id", pks[3]);
		request.setAttribute("cityorcountrystd", cityorcountrystd);
		request.setAttribute("cityorcountrycore", cityorcountrycore);
		request.setAttribute("cityorcountryaccount", cityorcountryaccount);
		if("55".equals(pks[3])){
			return (actionMapping.findForward("listascontent"));
		}
		if("54".equals(pks[3])){
			return (actionMapping.findForward("listascontent4mendian"));
		}
		return (actionMapping.findForward("listascontent"));
		
	}
	
	public ActionForward doSave2(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		
		CreditstdForm creditstdForm=(CreditstdForm)actionForm;
		
		String a=request.getParameter("a");
		String[] idAndValue=a.split(",");
		List list=new ArrayList();
		for(int i=0;i<idAndValue.length;i++){
				list.add(idAndValue[i]);
		}
		
		String slv=request.getParameter("slv");
		String adtypecode=request.getParameter("adtypecode");
		String slvlev=request.getParameter("slvlev");
		String rewardtype=request.getParameter("rewardtype");
		
		
		for (int i = 0; i <list.size(); i++) {
			if("55".equals(rewardtype)){
				if("".equals(creditstdForm.getRewardstds()[i])){
					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "���ֽ�������׼����Ϊ�ա�");
					request.setAttribute("PK", slv+"|"+slvlev+"|"+adtypecode+"|"+55);
					return doEdit(actionMapping,actionForm, request,response,user);
				}else{
					if (!CheckUtil.checkDouble(creditstdForm.getRewardstds()[i], 8, 2)) {
						request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "���ֽ�������׼�������ֲ��ܳ���8λ,С�����ֲ��ܳ���2λ");
						request.setAttribute("PK", slv+"|"+slvlev+"|"+adtypecode+"|"+55);
						return doEdit(actionMapping,actionForm, request,response,user);
					}
				}
				if("".equals(creditstdForm.getCardstds()[i])){
					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����ҵ������׼����Ϊ�ա�");
					request.setAttribute("PK", slv+"|"+slvlev+"|"+adtypecode+"|"+55);
					return doEdit(actionMapping,actionForm, request,response,user);
				}else{
					if (!CheckUtil.checkDouble(creditstdForm.getCardstds()[i], 8, 2)) {
						request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����ҵ������׼�������ֲ��ܳ���8λ,С�����ֲ��ܳ���2λ");
						request.setAttribute("PK", slv+"|"+slvlev+"|"+adtypecode+"|"+55);
						return doEdit(actionMapping,actionForm, request,response,user);
					}
				}
				if("".equals(creditstdForm.getCreditstds()[i])){
					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "�Ǽ����ֱ�׼����Ϊ�ա�");
					request.setAttribute("PK", slv+"|"+slvlev+"|"+adtypecode+"|"+55);
					return doEdit(actionMapping,actionForm, request,response,user);
				}else{
					if (!CheckUtil.checkDouble(creditstdForm.getCreditstds()[i], 8, 2)) {
						request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "�Ǽ����ֱ�׼�������ֲ��ܳ���8λ,С�����ֲ��ܳ���2λ");
						request.setAttribute("PK", slv+"|"+slvlev+"|"+adtypecode+"|"+55);
						return doEdit(actionMapping,actionForm, request,response,user);
					}
				}
				if("".equals(creditstdForm.getRuleids()[i])){
					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "������벻��Ϊ�ա�");
					request.setAttribute("PK", slv+"|"+slvlev+"|"+adtypecode+"|"+55);
					return doEdit(actionMapping,actionForm, request,response,user);
				}else{
					if (!CheckUtil.checkString(creditstdForm.getRuleids()[i], 30, true)) {
						request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "������벻�ܴ���30λ");
						request.setAttribute("PK", slv+"|"+slvlev+"|"+adtypecode+"|"+55);
						return doEdit(actionMapping,actionForm, request,response,user);
					}
				}
				if("".equals(creditstdForm.getIntvmonths()[i])){
					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����·ݲ���Ϊ�ա�");
					request.setAttribute("PK", slv+"|"+slvlev+"|"+adtypecode+"|"+55);
					return doEdit(actionMapping,actionForm, request,response,user);
				}else{
					if(!NumberUtils.isDigits(creditstdForm.getIntvmonths()[i])){
						request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����·ݱ���Ϊ���ֲ��ܳ���10λ��");
						request.setAttribute("PK", slv+"|"+slvlev+"|"+adtypecode+"|"+55);
						return doEdit(actionMapping,actionForm, request,response,user);
					}
					if(creditstdForm.getIntvmonths()[i].length()>10){
						request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����·ݱ���Ϊ���ֲ��ܳ���10λ��");
						request.setAttribute("PK", slv+"|"+slvlev+"|"+adtypecode+"|"+55);
						return doEdit(actionMapping,actionForm, request,response,user);
					}
				}
			}else{
				if("".equals(creditstdForm.getRewardstds()[i])){
					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "�ŵ겹������׼����Ϊ�ա�");
					request.setAttribute("PK", slv+"|"+slvlev+"|"+adtypecode+"|"+54);
					return doEdit(actionMapping,actionForm, request,response,user);
				}else{
					if (!CheckUtil.checkDouble(creditstdForm.getRewardstds()[i], 8, 2)) {
						request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "�ŵ겹������׼�������ֲ��ܳ���8λ,С�����ֲ��ܳ���2λ");
						request.setAttribute("PK", slv+"|"+slvlev+"|"+adtypecode+"|"+54);
						return doEdit(actionMapping,actionForm, request,response,user);
					}
				}
				if("".equals(creditstdForm.getRuleids()[i])){
					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "������벻��Ϊ�ա�");
					request.setAttribute("PK", slv+"|"+slvlev+"|"+adtypecode+"|"+54);
					return doEdit(actionMapping,actionForm, request,response,user);
				}else{
					if (!CheckUtil.checkString(creditstdForm.getRuleids()[i], 30, true)) {
						request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "������벻�ܴ���30λ");
						request.setAttribute("PK", slv+"|"+slvlev+"|"+adtypecode+"|"+54);
						return doEdit(actionMapping,actionForm, request,response,user);
					}
				}
				if("".equals(creditstdForm.getIntvmonths()[i])){
					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����·ݲ���Ϊ�ա�");
					request.setAttribute("PK", slv+"|"+slvlev+"|"+adtypecode+"|"+54);
					return doEdit(actionMapping,actionForm, request,response,user);
				}else{
					if(!NumberUtils.isDigits(creditstdForm.getIntvmonths()[i])){
						request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����·ݱ���Ϊ���ֲ��ܳ���10λ��");
						request.setAttribute("PK", slv+"|"+slvlev+"|"+adtypecode+"|"+54);
						return doEdit(actionMapping,actionForm, request,response,user);
					}
					if(creditstdForm.getIntvmonths()[i].length()>10){
						request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����·ݱ���Ϊ���ֲ��ܳ���10λ��");
						request.setAttribute("PK", slv+"|"+slvlev+"|"+adtypecode+"|"+54);
						return doEdit(actionMapping,actionForm, request,response,user);
					}
				}
				
			}
		}
		
		//ͬ������ͬһ�������ʶ��ͬһ���Ǽ���ͬһ���Ǽ��ֲ㣬ͬһ������·ݣ�ͬһ��������룬���ܴ���ͬһ����¼��
//		Map<String, String > ruleidandintvmonthmap = new HashMap<String,String >();
		Map<String, String > map = new HashMap<String,String >();
		for (int i = 0; i <list.size(); i++) {
			String ss="";
			if(creditstdForm.getCardstds()!=null){
				ss=creditstdForm.getRewardstds()[i]+
				","+creditstdForm.getCardstds()[i]+
				","+creditstdForm.getCreditstds()[i]+
				","+creditstdForm.getRuleids()[i]+
				","+creditstdForm.getIntvmonths()[i];
			}else{
				ss=creditstdForm.getRewardstds()[i]+
				","+0+
				","+0+
				","+creditstdForm.getRuleids()[i]+
				","+creditstdForm.getIntvmonths()[i];
			}
			
			map.put(list.get(i).toString(), ss);
			
		}
		
		ArrayList al=new ArrayList();
		for (int i = 0; i <list.size(); i++) {
			String str=creditstdForm.getRuleids()[i].trim()+"#"+creditstdForm.getIntvmonths()[i].trim();
			if(al.contains(str)){
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "ͬ������ͬһ�������ʶ��ͬһ���Ǽ���ͬһ���Ǽ��ֲ㣬ͬһ������·ݣ�ͬһ��������룬���ܴ���ͬһ����¼��");
				if(creditstdForm.getCardstds()!=null){
	    			request.setAttribute("PK", slv+"|"+slvlev+"|"+adtypecode+"|"+55);
	    		}else{
	    			request.setAttribute("PK", slv+"|"+slvlev+"|"+adtypecode+"|"+54);
	    		}
	    		
	    		return doEdit(actionMapping,actionForm, request,response,user);
			}else{
				al.add(str);
			}
		}
		
		
		//�����Ǽ�,�����ʶ,����,�õ���Ӧ����Ǯ��,ǰ�����õ��ܵ�Ǯ��,��ѯ���ǵ�ǰ�Ǽ���ε��ܺ�
		Double hadtotalmoney=0.0;
		CreditstdDelegate creditstdDelegate=new CreditstdDelegate();
		CreditstdListVO creditstdListVO=new CreditstdListVO();
		creditstdListVO.set_ne_cityid(user.getCityid());
		creditstdListVO.set_ne_slv(slv);
		creditstdListVO.set_ne_slvlev(slvlev);
		creditstdListVO.set_ne_adtypecode(adtypecode);
		if(creditstdForm.getCardstds()!=null){
			creditstdListVO.set_ne_rewardtype("54");
		}else{
			creditstdListVO.set_ne_rewardtype("55");
		}
		Double dppp=creditstdDelegate.doQuerysums(creditstdListVO, user);
		if(dppp!=null){
			hadtotalmoney=dppp;
		}
		
		StdrewardbsDelegate stdrewardbsDelegate=new StdrewardbsDelegate();
		StdrewardbsListVO stdrewardbsListVO=new StdrewardbsListVO();
		stdrewardbsListVO.set_se_region(user.getCityid());
		if("1".equals(slv))
			stdrewardbsListVO.set_se_slv("100000");
		if("2".equals(slv))
			stdrewardbsListVO.set_se_slv("010000");
		if("3".equals(slv))
			stdrewardbsListVO.set_se_slv("001000");
		if("4".equals(slv))
			stdrewardbsListVO.set_se_slv("000100");
		if("5".equals(slv))
			stdrewardbsListVO.set_se_slv("000010");
		if("6".equals(slv))
			stdrewardbsListVO.set_se_slv("000001");
//		stdrewardbsListVO.set_se_slv(slv);
		stdrewardbsListVO.set_ne_islimt("1");
		
		
		Double cityorcountrystd=0.0;
		Long cityorcountycore=0L;
		Long cityorcountyaccount=0L;
		DataPackage dataPackage=stdrewardbsDelegate.doQuery(stdrewardbsListVO, user);
		if (dataPackage != null && dataPackage.getDatas().size() > 0) {
			Iterator it = dataPackage.getDatas().iterator();
			if (it.hasNext()) {
				StdrewardbsVO stdrewardbsVO=(StdrewardbsVO)it.next();
				//0,��ʾ����;1,��ʾ�ǽ�
				if("1".equals(adtypecode)){
//					cityorcountrystd=stdrewardbsVO.getCountrystd();
//					cityorcountyaccount=stdrewardbsVO.getCountyaccountlimit();
//					cityorcountycore=stdrewardbsVO.getCountycorelimit();
					
					if(stdrewardbsVO.getCountrystd()!=null){
						cityorcountrystd=stdrewardbsVO.getCountrystd();
					}else{
						request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
			       		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "���Ǽ���ʡ��׼Ϊ��,����ϵʡ��˾��������ʡ��׼."); 
			       		if(creditstdForm.getCardstds()!=null){
			    			request.setAttribute("PK", slv+"|"+slvlev+"|"+adtypecode+"|"+55);
			    		}else{
			    			request.setAttribute("PK", slv+"|"+slvlev+"|"+adtypecode+"|"+54);
			    		}
			    		
			    		return doEdit(actionMapping,actionForm, request,response,user);
					}
					if(creditstdForm.getCardstds()!=null){
						if(stdrewardbsVO.getCountycorelimit()!=null){
							cityorcountycore=stdrewardbsVO.getCountycorelimit();
						}else{
							request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
							request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "���Ǽ���ʡ��׼Ϊ��,����ϵʡ��˾��������ʡ��׼."); 
							request.setAttribute("PK", slv+"|"+slvlev+"|"+adtypecode+"|"+55);
							return doEdit(actionMapping,actionForm, request,response,user);
						}
						if(stdrewardbsVO.getCountyaccountlimit()!=null){
							cityorcountyaccount=stdrewardbsVO.getCountyaccountlimit();
						}else{
							request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
							request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "���Ǽ���ʡ��׼Ϊ��,����ϵʡ��˾��������ʡ��׼."); 
							request.setAttribute("PK", slv+"|"+slvlev+"|"+adtypecode+"|"+55);
							return doEdit(actionMapping,actionForm, request,response,user);
						}
					}
					
				}
				if("0".equals(adtypecode)){
//					cityandcountrystd=stdrewardbsVO.getCitystd();
//					cityorcountycore=stdrewardbsVO.getCitycorelimit();
//					cityorcountyaccount=stdrewardbsVO.getCityaccountlimit();
					
					if(stdrewardbsVO.getCitystd()!=null){
						cityorcountrystd=stdrewardbsVO.getCitystd();
					}else{
						request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
			       		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "���Ǽ���ʡ��׼Ϊ��,����ϵʡ��˾��������ʡ��׼."); 
			       		if(creditstdForm.getCardstds()!=null){
			    			request.setAttribute("PK", slv+"|"+slvlev+"|"+adtypecode+"|"+55);
			    		}else{
			    			request.setAttribute("PK", slv+"|"+slvlev+"|"+adtypecode+"|"+54);
			    		}
			    		
			    		return doEdit(actionMapping,actionForm, request,response,user);
					}
					if(creditstdForm.getCardstds()!=null){
						if(stdrewardbsVO.getCityaccountlimit()!=null){
							cityorcountyaccount=stdrewardbsVO.getCityaccountlimit();
						}else{
							request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
							request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "���Ǽ���ʡ��׼Ϊ��,����ϵʡ��˾��������ʡ��׼."); 
							request.setAttribute("PK", slv+"|"+slvlev+"|"+adtypecode+"|"+55);
							return doEdit(actionMapping,actionForm, request,response,user);
						}
						if(stdrewardbsVO.getCitycorelimit()!=null){
							cityorcountycore=stdrewardbsVO.getCitycorelimit();
						}else{
							request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
							request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "���Ǽ���ʡ��׼Ϊ��,����ϵʡ��˾��������ʡ��׼."); 
							request.setAttribute("PK", slv+"|"+slvlev+"|"+adtypecode+"|"+55);
							return doEdit(actionMapping,actionForm, request,response,user);
						}
					}
					
				}
//				prostd=countrystd/corelimit;
				
			}
		}else{
			request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
       		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "ʡ��˾�����ͱ�׼û���趨�������趨ʡ��˾��׼��");
//       		if(creditstdForm.getCardstds()!=null){
//       			return (actionMapping.findForward("listascontent"));
//       		}else{
//       			return (actionMapping.findForward("listascontent4mendian"));
//       		}
       		if(creditstdForm.getCardstds()!=null){
    			request.setAttribute("PK", slv+"|"+slvlev+"|"+adtypecode+"|"+55);
    		}else{
    			request.setAttribute("PK", slv+"|"+slvlev+"|"+adtypecode+"|"+54);
    		}
    		
    		return doEdit(actionMapping,actionForm, request,response,user);
		}
		Double rewardstdsum=0.0;
		for (int i = 0; i <list.size(); i++) {
			
//			Double subsidy=Double.valueOf(creditstdForm.getSubsidys()[i]);
			Double rewardstd=Double.valueOf(creditstdForm.getRewardstds()[i]);
			
			rewardstdsum+=rewardstd;
//			cardstdsum+=cardstd;
//			creditstdsum+=creditstd;
//			if((subsidy+rewardstd)>cityandcountrystd){
		}
		if((rewardstdsum+hadtotalmoney)>cityorcountrystd){
			request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "���ŵ겹������ֽ�����׼�����ܴ���ʡ��˾�趨�Ǽ�������׼����["+cityorcountrystd+"]��"); 
			if(creditstdForm.getCardstds()!=null){
				request.setAttribute("PK", slv+"|"+slvlev+"|"+adtypecode+"|"+55);
			}else{
				request.setAttribute("PK", slv+"|"+slvlev+"|"+adtypecode+"|"+54);
			}
			
			return doEdit(actionMapping,actionForm, request,response,user);
		}
		for (int i = 0; i <list.size(); i++) {
			if(creditstdForm.getCardstds()!=null){
				Double cardstd=0.0;
				Double creditstd=0.0;
				cardstd=Double.valueOf(creditstdForm.getCardstds()[i]);
				creditstd=Double.valueOf(creditstdForm.getCreditstds()[i]);
				
				if(creditstd<cityorcountyaccount){
					request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "�й�˾�������ۻ��ֱ�׼���ܵ���ʡ��˾�������ۻ��ֱ�׼"+cityorcountyaccount+"]��"); 
					request.setAttribute("PK", slv+"|"+slvlev+"|"+adtypecode+"|"+55);
					return doEdit(actionMapping,actionForm, request,response,user);
				}
				if(cardstd<cityorcountycore){
					request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "�й�˾���� �׿����۱�׼���ܵ���ʡ��˾�������� �׿����۱�׼"+cityorcountycore+"]��"); 
					request.setAttribute("PK", slv+"|"+slvlev+"|"+adtypecode+"|"+55);
					return doEdit(actionMapping,actionForm, request,response,user);
				}
			}
		}
		
		creditstdDelegate.doSave(map, user);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����ɹ�");
		
		if(creditstdForm.getCardstds()!=null){
			request.setAttribute("PK", slv+"|"+slvlev+"|"+adtypecode+"|"+55);
		}else{
			request.setAttribute("PK", slv+"|"+slvlev+"|"+adtypecode+"|"+54);
		}
		
		return doEdit(actionMapping,actionForm, request,response,user);
	}
	
	public ActionForward doNew(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		CreditstdForm form = (CreditstdForm) actionForm;
		
//		CreditstdDelegate creditstdDelegate =new CreditstdDelegate();
//		CreditstdListVO params=new CreditstdListVO();
//		params.set_pagesize("");
//		DataPackage dp=creditstdDelegate.doQueryPro(params, user);
		
		load4exh(request,user) ;
		
		
		String command = getCommandString(request);
		((BaseActionForm) actionForm).setCmdState(command);
		request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,
				WebConstant.COMMAND_STRING_EDIT);
		return (actionMapping.findForward("content"));
	}
	
	public static void load4exh(HttpServletRequest request, User user) throws Exception{
		//��ʾʡ��׼�����ݼ�
   		StdrewardbsDelegate stdrewardbsDelegate1=new StdrewardbsDelegate();
		StdrewardbsListVO stdrewardbsListVO1=new StdrewardbsListVO();
		stdrewardbsListVO1.set_se_region(user.getCityid());
		stdrewardbsListVO1.set_ne_islimt("1");
		DataPackage dp1=stdrewardbsDelegate1.doQuery(stdrewardbsListVO1, user);
		
		if(dp1.getDatas().size()!=0){
			
			request.setAttribute("dp", dp1);
		}
		
		
		//��������ʾ�����ݼ�
		StdrewardDelegate stdrewardDelegate1=new StdrewardDelegate();
		StdrewardListVO stdrewardListVO1=new StdrewardListVO();
		stdrewardListVO1.set_pagesize("");
		DataPackage dpselected=stdrewardDelegate1.doQueryfor5455(stdrewardListVO1, user);
		request.setAttribute("dpselected", dpselected);
	}

	//��ת������ϸ������ҳ��
	
	public ActionForward doShowruledetail(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		
			String pk ="";
			if(request.getParameter("PK")==null){
				pk = (String)request.getAttribute("PK");
			}
			else{
				pk = request.getParameter("PK");
			}
		
//			String pk = request.getParameter("PK");
			String[] pks=pk.split("\\|");
		
			List ruleitemlist=new ArrayList();
	   		
	//		��ӵĲ���
			RulerelDelegate rulerelDelegate=new RulerelDelegate();
	//		RulerelListVO rulerellistvo = new RulerelListVO();
	//		DataPackage dp2= rulerelDelegate.doQuery5(rulerellistvo, user);
			RulerelListVO rulerellistvo = new RulerelListVO();
			rulerellistvo.set_pagesize("");
			rulerellistvo.set_se_ruleid(pks[4]);
			//ASSESSPOINT, ����һ��ruleid��Ϊ����
//			rulerellistvo.set_se_ruleid("ASSESSPOINT");
			DataPackage dp2= rulerelDelegate.doQueryByRuleid(rulerellistvo, user);
	//		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
			Iterator it = dp2.getDatas().iterator();
			while(it.hasNext()){
				RulerelVO vo=(RulerelVO)(it.next());
				
				ruleitemlist.add(vo.getRuleitemid());
				
				rulerellistvo.set_se_ruleitemid(vo.getRuleitemid());
				rulerellistvo.set_se_ruleid(vo.getRuleid());
				rulerellistvo.set_se_cityid(user.getCityid());
				DataPackage dp3=rulerelDelegate.doQuery(rulerellistvo, user);
				Iterator itor = dp3.getDatas().iterator();
				if (itor.hasNext()) {
	//				RulerelVO vo=(RulerelVO)(itor.next());
					String vvv = ((RulerelVO)(itor.next())).getParamer();
				if(!"".equals(vvv)&&null!=vvv){
					
	//				System.out.println("======rr===="+vvv.trim()+"GGG");
					vo.setParamercityvalue(vvv.trim());
				}
					vo.setIsSelected(new Short("1"));
				}
			}
			Set ruleitemsetnew=new HashSet();
		for(int i=0;i<ruleitemlist.size();i++){
			Set set =new HashSet();
			RuleitemDelegate delegate =new RuleitemDelegate();
			RuleitemListVO listVO=new RuleitemListVO();
			listVO.set_pagesize("");
			listVO.set_se_ruleitemid((String)ruleitemlist.get(i));
			DataPackage ruleitemdp=delegate.doQuery(listVO, user);
			Iterator it1 = ruleitemdp.getDatas().iterator();
			if(it1.hasNext()){
				String vvv = ((RuleitemVO)(it1.next())).getVcityid();
				if(!"".equals(vvv)&&null!=vvv){
					String[] vcityid=vvv.trim().split("\\|");
					for(int j=0;j<vcityid.length;j++){
						set.add(vcityid[j]);
					}
				}
			}
			if(set.contains("999")||set.contains(user.getCityid())){
				ruleitemsetnew.add(ruleitemlist.get(i));
			}
			
		}
		DataPackage newdp=new DataPackage();
		
		Collection datas=new ArrayList();
		Iterator it3 = dp2.getDatas().iterator();
		while(it3.hasNext()){
			RulerelVO vo=(RulerelVO)(it3.next());
			if(ruleitemsetnew.contains(vo.getRuleitemid())){
				datas.add(vo);
			}
		}
		newdp.setDatas(datas);
		request.setAttribute("dp2", newdp);
		
		if("55".equals(pks[3])){
			request.setAttribute("PK", pks[0]+"|"+pks[1]+"|"+pks[2]+"|"+55+"|"+pks[4]);
		}else{
			request.setAttribute("PK", pks[0]+"|"+pks[1]+"|"+pks[2]+"|"+54+"|"+pks[4]);
		}
		
		return (actionMapping.findForward("listdetails"));
			
		
	}
	
	// ����ruleid, ������,ÿһ����ͬ�Ĺ���ϸ��
	public ActionForward doSave3(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
//   		StdrewardbsForm form = (StdrewardbsForm)actionForm;
   		
   		String a=request.getParameter("a");
		String[] idAndValue=a.split(",");
		
		List list=new ArrayList();
		for(int i=0;i<idAndValue.length;i++){
			if(!"".equals(idAndValue[i]))
				list.add(idAndValue[i]);
				
		}
		
		String pk = (String)request.getParameter("PK");
	    String[] pks=pk.split("\\|");
		
		RulerelDelegate rulerelDelegate = new RulerelDelegate();
		try {
			
			for (int i = 0; i <list.size(); i++) {
				
				//��ѯ"999"��paramer ,�м����ָ���"|",����Ĳ����Ƿ���ͬ���ĸ���
				RulerelListVO rulerelListVO1=new RulerelListVO();
				rulerelListVO1.set_pagesize("");
				//ASSESSPOINT, ����һ��ruleid��Ϊ����
//				rulerellistvo.set_se_ruleid("ASSESSPOINT");
				rulerelListVO1.set_se_ruleid(pks[4]);
//				rulerelListVO1.set_se_ruleid("ASSESSPOINT");
				rulerelListVO1.set_se_cityid("999");
				String[] ss=list.get(i).toString().split(";");
				rulerelListVO1.set_se_ruleitemid(ss[0]);
				DataPackage dp2=rulerelDelegate.doQuery(rulerelListVO1,user);
				String sp1=((RulerelVO)dp2.getDatas().iterator().next()).getParamer();
				//���û����дֵ,ss�ĳ��Ⱦ���1,���뱨��
				if(ss.length==1){
//					throw new Exception( ss[0] + "�Ĳ���ֵû����д!");
					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ss[0]+"�Ĳ���ֵû����д!");
					request.setAttribute("PK", request.getParameter("PK"));
					return doShowruledetail(actionMapping,actionForm, request,response,user);
				}else{
					//˵����������û�в����Ͳ��ò��������ֵ�ڶ�Ӧ�ĵ��еĹ�����
					if(sp1!=null){
						String sp2=ss[1];
						int length1=StringUtils.splitPreserveAllTokens(sp1, "|").length;
						int length2=StringUtils.splitPreserveAllTokens(sp2, "|").length;
						if( length1!=length2|| !("".equals(StringUtils.splitPreserveAllTokens(sp2.trim(), "|")[length2-1]))  ){
////					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����Ĳ���ֵ������һ��,����Ҫ��'|'�ָ��ͽ�β!");
//							throw new Exception( ss[0] + "����Ĳ���ֵ������һ��,����Ҫ��'|'�ָ��ͽ�β!");
							request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ss[0]+"����Ĳ���ֵ������һ��,����Ҫ��'|'�ָ��ͽ�β!");
							request.setAttribute("PK", request.getParameter("PK"));
							return doShowruledetail(actionMapping,actionForm, request,response,user);
							
						}
					}
				}
			}
			//ASSESSPOINT, ����һ��ruleid��Ϊ����
//			rulerellistvo.set_se_ruleid("ASSESSPOINT");
		rulerelDelegate.doSave(list,pks[4], user);
//		rulerelDelegate.doSave(list,"ASSESSPOINT", user);
		
		
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����ɹ�");
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
		}
		
//		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����ɹ�");
		request.setAttribute("PK", request.getParameter("PK"));
		return doShowruledetail(actionMapping,actionForm, request,response,user);
	}
	
	// ���ڼ�������׼����---��ѯ
	public ActionForward doFind(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		// �趨��ѯ����
		CreditstdForm form = (CreditstdForm)actionForm;
		form.set_ne_cityid(user.getCityid());
//		return super.doList(actionMapping, actionForm, request, response, user);
		CreditstdDelegate creditstdDelegate=new CreditstdDelegate();
		CreditstdListVO creditstdListVO=new CreditstdListVO();
		if(!"".equals(form.get_ne_slv())){
			creditstdListVO.set_ne_slv(form.get_ne_slv());
		}
		creditstdListVO.set_pagesize("");
		DataPackage dp= creditstdDelegate.doQuery4cqjl(creditstdListVO, user);
		
		request.setAttribute("dp", dp);
		return (actionMapping.findForward("list1"));
		
	}
	
	public ActionForward doContent(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		
		CreditstdForm form = (CreditstdForm)actionForm;
		form.setIsstar("true");
		return (actionMapping.findForward("content1"));
	}
	
	// ����  ���ڼ�������׼����
	public ActionForward doCqjl(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		
		CreditstdForm form = (CreditstdForm)actionForm;
		form.setCityid(Short.parseShort(user.getCityid()));
		
		StdrewardDelegate stdrewardDelegate=new StdrewardDelegate();
		StdrewardListVO stdrewardListVO=new StdrewardListVO();
		stdrewardListVO.set_ne_rewardtype("60");
		DataPackage dataPackage=stdrewardDelegate.doQuery(stdrewardListVO, user);
		
		if (dataPackage != null && dataPackage.getDatas().size() > 0) {
			Iterator it = dataPackage.getDatas().iterator();
			if (it.hasNext()) {
				StdrewardVO stdrewardVO=(StdrewardVO)it.next();
				form.setRewardid(stdrewardVO.getRewardid());
			}
		}else{
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "û�в�ѯ����Ӧ��rewardid.");
			return (actionMapping.findForward("content1"));
		}
		
		CreditstdDelegate creditstdDelegate=new CreditstdDelegate();
		CreditstdListVO creditstdListVO=new CreditstdListVO();
		creditstdListVO.set_ne_rewardid(form.getRewardid().toString());
		creditstdListVO.set_ne_rewardstd(form.getRewardstd().toString());
		if(form.getSlv()!=null){
			creditstdListVO.set_ne_slv(form.getSlv().toString());
		}
		DataPackage dp=creditstdDelegate.doQuery(creditstdListVO, user);
		
		if (dp != null && dp.getDatas().size() > 0 ) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "��ͬrewardid,�Ǽ���rewardstd��¼�Ѵ���,�������������.");
			return (actionMapping.findForward("content1"));
		}
		
		StdrewardcqDelegate stdrewardcqDelegate=new StdrewardcqDelegate();
		StdrewardcqListVO listVO=new StdrewardcqListVO();
		listVO.set_ne_rewardid(form.getRewardid().toString());
		listVO.set_se_region(user.getCityid());
		DataPackage dataPackage2=stdrewardcqDelegate.doQuery(listVO, user);
		
		if (dataPackage2 != null && dataPackage2.getDatas().size() > 0 ) {
//			throw new Exception("��ͬrewardid��region��¼�Ѵ���,�������������.");
			Iterator it = dataPackage2.getDatas().iterator();
			if (it.hasNext()) {
				StdrewardcqVO stdrewardcqVO=(StdrewardcqVO)it.next();
				if(stdrewardcqVO.getCitystd()<form.getRewardstd()){
					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "���еĳ��ڼ�����׼С�ڻ��ߵ���ʡ��˾���ڼ�������׼.");
					return (actionMapping.findForward("content1"));
				}
			}
		}else{
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "û���ҵ��ĵ��ж�Ӧ��ʡ��׼.");
			return (actionMapping.findForward("content1"));
		}
		
	   Object contentVO = voClass.newInstance();
//       setSaveVO(contentVO, actionForm); //�ڴ˸�ʽ������� vo �Ա���
	   setSaveVO(contentVO, form); //�ڴ˸�ʽ������� vo �Ա���
       
       //if(pkNameArray.length > 1)
       //   throw new RuntimeException("Multiple pk not supported by default doSave. Try to implement this method.");
       
       //Object pk = PropertyUtils.getProperty(contentVO, pkNameArray[0]);
       Object delegate = getDelegate();
       String methodName = "doFindByPk";
       
       Object existObj = null;
       
   	    if(pkNameArray.length==1){ //��һ����
		   Object pk = (Object)BeanUtils.getProperty(contentVO, pkNameArray[0]);
		   if(pk!=null){
			   existObj = invokeDelegateMethod(delegate,methodName,new Object[]{(Serializable)pk, user});
		   }
	      }else{//��������
		     Object pkVO = voClass.newInstance();
		     BeanUtils.copyProperties(pkVO, contentVO);
		     existObj = invokeDelegateMethod(delegate,methodName,new Object[]{pkVO, user});
	     } 
       
       
 	   if(existObj!=null) {
 		   org.apache.commons.beanutils.BeanUtils.copyProperties(existObj, contentVO);
    	   contentVO = existObj;
	   }  
       
       
       String cmdState = ((BaseActionForm)actionForm).getCmdState();
	   try {
	       if (WebConstant.COMMAND_STRING_EDIT.equals(cmdState)) {
	    	   
	    	   methodName = "doUpdate";
	    	   contentVO = invokeDelegateMethod(delegate,methodName,new Object[]{contentVO, user});
	          
	       } else {
	    	   if(existObj!=null) {
	    		    request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
	           		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "��ͬ��¼�Ѵ���"); 
	           		onDuplicatePk(actionMapping,actionForm, request, response, user);
	           		return (actionMapping.findForward("content"));
	    	   }else {
	    		   methodName = "doCreate";
	        	   contentVO = invokeDelegateMethod(delegate,methodName,new Object[]{contentVO, user});  
	    	   }
	       }
	       BeanUtils.copyProperties(actionForm, contentVO); //�Ѹ��º��ֵ����form������web��ʾ
	       ((BaseActionForm)actionForm).setCmdState(WebConstant.COMMAND_STRING_EDIT);
	       request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����ɹ�");
		}catch(BusinessException e) {
        	 request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.toString());
        }catch(Exception e) {
        	throw e;
        } 
		
		return (actionMapping.findForward("content1"));
		
	}
	// �й�˾���ڼ�������׼���� ɾ��
	public ActionForward doOut(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		String[] selectArray = ((BaseActionForm) actionForm).get_selectitem();
		try {
			   Object delegate = getDelegate();		
		
			   String findByPK = "doFindByPk";
			   String methodName = "doRemove";
			   
			   for (int i = 0; i < selectArray.length; i++) {
				   Object vo = null;
		            if (selectArray[0].indexOf('|') == -1) { //��һ����
		            	vo = invokeDelegateMethod(delegate,findByPK,new Object[]{getDeletePK(selectArray[i]), user});
		            } else { //��������
		            	vo = invokeDelegateMethod(delegate,findByPK,new Object[]{getDeletePkVO(selectArray[i]), user});
		            }
				   
				   Object ret = invokeDelegateMethod(delegate,methodName,new Object[]{vo, user});
			   }
		}catch(BusinessException e) {
        	 request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.toString());
        }catch(Exception e) {
        	throw e;
        } 
	   
	    return doFind(actionMapping, actionForm, request, response, user);
	}
	
}
