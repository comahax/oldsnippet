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
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "rpseqid"; 
    }
    //查询
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
    
    //导出excel
	public ActionForward doExcel(ActionMapping actionMapping,ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("奖罚酬金管理");  
		export.appendHeadLine(new String[] { "导出工号:", user.getOpercode() });
		export.appendHeadLine(new String[] { "导出时间:", format.format(new Date()) });  
		export.addOutputProperty("rpseqid", "序号");
		export.addOutputProperty("cityid", "地市标识", export.CODE2NAME, "#REGIONNAME"); 
		export.addOutputProperty("provagentid", "代理商编码");
		export.addOutputProperty("provagentid", "代理商名称", export.CODE2NAME, "#CH_PD_AGENT");
		export.addOutputProperty("prodno", "集团产品编号");
		export.addOutputProperty("prodid", "集团产品标识");
		export.addOutputProperty("prodid", "集团产品名称", export.CODE2NAME, "#CH_PD_ENTPRODUCT");   
		export.addOutputProperty("phase", "期数");
		export.addOutputProperty("rewardmonth", "计酬月份"); 
		export.addOutputProperty("rpmoney", "奖罚金额"); 
		export.addOutputProperty("adcrewardid", "下发ADC酬金序号"); 
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		export.voClassArray = new Class[] {VChPdRprewardrecordVO.class};
		export.queryMethodName = "doList";
		if (export.headtitle == null) {
			export.headtitle = export.getFileName();
		}
		export.buildExcelPage(actionMapping, actionForm, request, response, user, this);
    	return null;
	}
	//新增
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
			//（2）处理逻辑：根据地市标识，切换到相应地市库，根据界面提交的代理商编码、
			//集团产品编号、计酬月份、期数、地市标识查询CH_PD_RPREWARDRECORD表且下发ADC酬金序号为空的数据，
			//如果存在则在数据上累加奖罚酬金；如果数据不存在则新增一条数据，新增数据序号取序列值，下发ADC酬金序号留空。
			//检查奖罚  
			    double  rp = Form.getRpmoney();
		      //	double num=Double.parseDouble("1.88888888E8");
				DecimalFormat df = new DecimalFormat("########.####");
				String rpmoney= df.format(rp); 
			    // if(this.CheckRpmoney(request,rpmoney)){
			        if (Form.getRpseqid() != null && Form.getRpseqid() > 0){ 
				          delegate.doUpdate(vo, realuser);
				          request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存成功"); 
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
				   request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存成功"); 
			   }
			// }
//			      else{
//				 request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "奖罚金额整数部分不能超过8位（包括负号‘-’），小数部位不能超过4位");  
//			      }
			        
	    	return (actionMapping.findForward("content"));
	    }
	//修改
	 public ActionForward doEdit(ActionMapping actionMapping,ActionForm actionForm, HttpServletRequest request,
				HttpServletResponse response, User user) throws Exception{  
		    VChPdRprewardrecordForm Form = (VChPdRprewardrecordForm) actionForm;
		    ChPdRprewardrecordDelegate delegate = new ChPdRprewardrecordDelegate(); 
		    User realuser = new User();
 			BeanUtils.copyProperties(realuser, user);
 			realuser.setCityid(SessionFactoryRouter.conversionCityid2Num(Form.getCityid()));
		    ChPdRprewardrecordVO vo = delegate.doFindByPk(Form.getRpseqid(), realuser);
		    if (null!= vo.getAdcrewardid() &&!("").equals(vo.getAdcrewardid())){
		       request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "下发ADC酬金序号不为空,不允许修改数据");  
		       return doList(actionMapping, actionForm, request, response, user); 
		    }else{
	    	   BeanUtils.copyProperties(Form, vo); 
	    		return (actionMapping.findForward("content"));
		    }
	    
	    }
	 //删除
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
					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "下发ADC酬金序号不为空,不允许删除数据"); 
				}else{ 
				    delegate.doRemove(vo, realuser);
				    request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "删除成功"); 
				}
			}
		
			return doList(actionMapping, actionForm, request, response, user); 
	    }
	 //导入
		public ActionForward doImport(ActionMapping actionMapping,
				ActionForm actionForm, HttpServletRequest request,
				HttpServletResponse response, User user) throws Exception {
			return actionMapping.findForward("batch");
		} 
		
		
		private  boolean  CheckRpmoney(HttpServletRequest request,String rpmoney) {     //奖罚金额整数部位最多4位，小数最多4位共8位
			boolean flag = true;
			if(rpmoney!=null && !"".equals(rpmoney.trim())){
				String s = rpmoney.trim();
				double jf = 0;
				try{
					jf = Double.parseDouble(s);
				}catch(NumberFormatException ex){ 
					flag=false;
					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "奖罚金额字段必须是数字，不能出现非数字字符");
				}			
				int index = s.indexOf(".");
				if(index!=-1){
					if(s.substring(index).length()>5){
						flag=false;
						request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "奖罚金额字段小数点后最多允许4位");
					}
					if ((jf > 0 && s.substring(0, index).length() > 8)
							|| (jf < 0 && s.substring(0, index).length() > 8)) {
						flag=false;
						request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "奖罚金额字段整数最多允许8位");
					}
				}else{
					if((jf > 0 && s.length()>8) || (jf < 0 && s.length()>8)){
						flag=false;
						request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "奖罚金额字段整数最多允许8位");
					}
				}
				
			}
			return flag;
		}
		
		
		
}
