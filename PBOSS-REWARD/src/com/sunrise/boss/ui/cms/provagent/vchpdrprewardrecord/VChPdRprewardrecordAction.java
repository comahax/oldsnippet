/**
* auto-generated code
* Wed Sep 04 21:16:54 CST 2013
*/
package com.sunrise.boss.ui.cms.provagent.vchpdrprewardrecord;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.sunrise.boss.business.cms.provagent.chpdrprewardrecord.persistent.ChPdRprewardrecordListVO;
import com.sunrise.boss.business.cms.provagent.chpdrprewardrecord.persistent.ChPdRprewardrecordVO;
import com.sunrise.boss.business.cms.provagent.vchpdrprewardrecord.persistent.VChPdRprewardrecordListVO;
import com.sunrise.boss.business.cms.provagent.vchpdrprewardrecord.persistent.VChPdRprewardrecordVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.cms.provagent.chpdrprewardrecord.ChPdRprewardrecordDelegate;
import com.sunrise.boss.delegate.cms.provagent.vchpdrprewardrecord.VChPdRprewardrecordDelegate;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
 

/**
 * <p>Title: ChPdRprewardrecordAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public class VChPdRprewardrecordAction extends BaseDelegateAction {
    public VChPdRprewardrecordAction() {
            setVoClass(VChPdRprewardrecordVO.class);
        // TODO: ������������������
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "rpseqid"; 
    }
    //��ѯ
    public ActionForward doList(ActionMapping actionMapping,ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception{  
    	
    	 VChPdRprewardrecordForm Form = ( VChPdRprewardrecordForm) actionForm;
    	if (Form.isQuery()) {
    		VChPdRprewardrecordListVO params = new  VChPdRprewardrecordListVO();
  			setListVO(params, Form);
  		    VChPdRprewardrecordDelegate delegate = new  VChPdRprewardrecordDelegate();
  			User realuser = new User();
  			BeanUtils.copyProperties(realuser, user);
  			realuser.setCityid(SessionFactoryRouter.conversionCityid2Num(Form.get_se_cityid()));
  			DataPackage dp = delegate.doQuery(params, realuser);
  			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
    	}
    	return (actionMapping.findForward("list"));
    }
    
    //����excel
	public ActionForward doExcel(ActionMapping actionMapping,ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("����������");  
		export.appendHeadLine(new String[] { "��������:", user.getOpercode() });
		export.appendHeadLine(new String[] { "����ʱ��:", format.format(new Date()) });  
		export.addOutputProperty("rpseqid", "���");
		export.addOutputProperty("cityid", "���б�ʶ", export.CODE2NAME, "#REGIONNAME"); 
		export.addOutputProperty("provagentid", "�����̱���");
		export.addOutputProperty("provagentid", "����������", export.CODE2NAME, "#CH_PD_AGENT");
		export.addOutputProperty("prodno", "���Ų�Ʒ���");
		export.addOutputProperty("prodid", "���Ų�Ʒ��ʶ");
		export.addOutputProperty("prodid", "���Ų�Ʒ����", export.CODE2NAME, "#CH_PD_ENTPRODUCT");   
		export.addOutputProperty("phase", "����");
		export.addOutputProperty("rewardmonth", "�Ƴ��·�"); 
		export.addOutputProperty("rpmoney", "�������"); 
		export.addOutputProperty("adcrewardid", "�·�ADC������"); 
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		export.voClassArray = new Class[] {VChPdRprewardrecordVO.class};
		export.queryMethodName = "doList";
		if (export.headtitle == null) {
			export.headtitle = export.getFileName();
		}
		export.buildExcelPage(actionMapping, actionForm, request, response, user, this);
    	return null;
	}
	//����
	 public ActionForward doNew(ActionMapping actionMapping,ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception{   
	    	return (actionMapping.findForward("content"));
	    }
	
	
	 public ActionForward doSave(ActionMapping actionMapping,ActionForm actionForm, HttpServletRequest request,
				HttpServletResponse response, User user) throws Exception{ 
	    	
		    VChPdRprewardrecordForm Form = (VChPdRprewardrecordForm) actionForm;
		    User realuser = new User();
			BeanUtils.copyProperties(realuser, user);
			realuser.setCityid(SessionFactoryRouter.conversionCityid2Num(Form.getCityid()));
			ChPdRprewardrecordDelegate delegate = new ChPdRprewardrecordDelegate(); 
			ChPdRprewardrecordVO vo = new ChPdRprewardrecordVO();
			BeanUtils.copyProperties(vo, Form);
			//��2�������߼������ݵ��б�ʶ���л�����Ӧ���п⣬���ݽ����ύ�Ĵ����̱��롢
			//���Ų�Ʒ��š��Ƴ��·ݡ����������б�ʶ��ѯCH_PD_RPREWARDRECORD�����·�ADC������Ϊ�յ����ݣ�
			//������������������ۼӽ������������ݲ�����������һ�����ݣ������������ȡ����ֵ���·�ADC���������ա�
			//��齱��  
			    double  rp = Form.getRpmoney();
		      //	double num=Double.parseDouble("1.88888888E8");
				DecimalFormat df = new DecimalFormat("########.####");
				String rpmoney= df.format(rp); 
			    // if(this.CheckRpmoney(request,rpmoney)){
			        if (Form.getRpseqid() != null && Form.getRpseqid() > 0){ 
				          delegate.doUpdate(vo, realuser);
				          request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����ɹ�"); 
			        }else{
				          ChPdRprewardrecordListVO listVO = new ChPdRprewardrecordListVO();
				          listVO.set_se_cityid(Form.getCityid());
				          listVO.set_ne_phase(Form.getPhase());
				          listVO.set_se_prodno(Form.getProdno());
				          listVO.set_se_provagentid(Form.getProvagentid());
				          listVO.set_se_rewardmonth(Form.getRewardmonth()); 
				          DataPackage dp=delegate.doQuery(listVO, realuser); 
				   if (dp.getRowCount() > 0){
					   ArrayList<ChPdRprewardrecordVO>  rplist= (ArrayList<ChPdRprewardrecordVO>) dp.getDatas();
					for (ChPdRprewardrecordVO chPdRprewardrecordVO : rplist) {
						if (chPdRprewardrecordVO.getAdcrewardid() == null || chPdRprewardrecordVO.getAdcrewardid() <= 0) {
							chPdRprewardrecordVO.setRpmoney(chPdRprewardrecordVO.getRpmoney() + Form.getRpmoney());
							delegate.doUpdate(chPdRprewardrecordVO, realuser);
						}else{
						   chPdRprewardrecordVO.setAdcrewardid(null);
						   delegate.doCreate(chPdRprewardrecordVO, realuser);
						}
					}
				} else {
					delegate.doCreate(vo, realuser);
				}
				   request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "����ɹ�"); 
			   }
			// }
//			      else{
//				 request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "��������������ֲ��ܳ���8λ���������š�-������С����λ���ܳ���4λ");  
//			      }
			        
	    	return (actionMapping.findForward("content"));
	    }
	//�޸�
	 public ActionForward doEdit(ActionMapping actionMapping,ActionForm actionForm, HttpServletRequest request,
				HttpServletResponse response, User user) throws Exception{  
		    VChPdRprewardrecordForm Form = (VChPdRprewardrecordForm) actionForm;
		    ChPdRprewardrecordDelegate delegate = new ChPdRprewardrecordDelegate(); 
		    User realuser = new User();
 			BeanUtils.copyProperties(realuser, user);
 			realuser.setCityid(SessionFactoryRouter.conversionCityid2Num(Form.getCityid()));
		    ChPdRprewardrecordVO vo = delegate.doFindByPk(Form.getRpseqid(), realuser);
		    if (null!= vo.getAdcrewardid() &&!("").equals(vo.getAdcrewardid())){
		       request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "�·�ADC�����Ų�Ϊ��,�������޸�����");  
		       return doList(actionMapping, actionForm, request, response, user); 
		    }else{
	    	   BeanUtils.copyProperties(Form, vo); 
	    		return (actionMapping.findForward("content"));
		    }
	    
	    }
	 //ɾ��
	 public ActionForward doDelete(ActionMapping actionMapping,ActionForm actionForm, HttpServletRequest request,
				HttpServletResponse response, User user) throws Exception{  
		 	String[] selectArray = ((BaseActionForm) actionForm).get_selectitem();
		  
		 	VChPdRprewardrecordForm Form = (VChPdRprewardrecordForm) actionForm;
		    User realuser = new User();
			BeanUtils.copyProperties(realuser, user);
			realuser.setCityid(SessionFactoryRouter.conversionCityid2Num(Form.get_se_cityid()));
			ChPdRprewardrecordDelegate delegate = new ChPdRprewardrecordDelegate(); 
			for (int i = 0; i < selectArray.length; i++) {
				ChPdRprewardrecordVO vo = delegate.doFindByPk(Long.parseLong(selectArray[i]), realuser);
				if (null!= vo.getAdcrewardid() &&!("").equals(vo.getAdcrewardid())) {
					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "�·�ADC�����Ų�Ϊ��,������ɾ������"); 
				}else{ 
				    delegate.doRemove(vo, realuser);
				    request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "ɾ���ɹ�"); 
				}
			}
		
			return doList(actionMapping, actionForm, request, response, user); 
	    }
	 //����
		public ActionForward doImport(ActionMapping actionMapping,
				ActionForm actionForm, HttpServletRequest request,
				HttpServletResponse response, User user) throws Exception {
			return actionMapping.findForward("batch");
		} 
		
		
		private  boolean  CheckRpmoney(HttpServletRequest request,String rpmoney) {     //�������������λ���4λ��С�����4λ��8λ
			boolean flag = true;
			if(rpmoney!=null && !"".equals(rpmoney.trim())){
				String s = rpmoney.trim();
				double jf = 0;
				try{
					jf = Double.parseDouble(s);
				}catch(NumberFormatException ex){ 
					flag=false;
					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "��������ֶα��������֣����ܳ��ַ������ַ�");
				}			
				int index = s.indexOf(".");
				if(index!=-1){
					if(s.substring(index).length()>5){
						flag=false;
						request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "��������ֶ�С������������4λ");
					}
					if ((jf > 0 && s.substring(0, index).length() > 8)
							|| (jf < 0 && s.substring(0, index).length() > 8)) {
						flag=false;
						request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "��������ֶ������������8λ");
					}
				}else{
					if((jf > 0 && s.length()>8) || (jf < 0 && s.length()>8)){
						flag=false;
						request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "��������ֶ������������8λ");
					}
				}
				
			}
			return flag;
		}
		
		
		
}
