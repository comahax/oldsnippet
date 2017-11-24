/**
* auto-generated code
* Wed Dec 24 11:06:41 CST 2008
*/
package com.sunrise.boss.ui.cms.rewardadjust;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.admin.dictitem.persistent.DictitemListVO;
import com.sunrise.boss.business.cms.rewardadjust.persistent.RewardadjustVO;
import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.delegate.admin.dictitem.DictitemDelegate;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.pub.tools.StringSplit;

/**
 * <p>Title: RewardadjustAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class RewardadjustAction extends BaseDelegateAction {
    public RewardadjustAction() {
           //以下几个方法是必须的 
           //指定VO类 
            setVoClass(RewardadjustVO.class);
            //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称 
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "seq"; 
    }
    
    public ActionForward doList(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
    	RewardadjustForm form = (RewardadjustForm) actionForm;
    	String adjusttype = form.get_se_adjustkind();
    	if (adjusttype==null || "".equals(adjusttype)) {
			form.setDictid("");
		}else if ("PUNISH".equals(adjusttype)) {
			form.setDictid("P-");
		}else if ("RETURN".equals(adjusttype)) {
			form.setDictid("R-");
			form.setDictid2("EFTCURMONTH");
		}else if ("BONUS".equals(adjusttype)) {
			form.setDictid("B-");
			form.setDictid2("EFTCURMONTH");
		}
		
        if (((RewardadjustForm)actionForm).get_sk_reasontype()!=null && !"".equals(((RewardadjustForm)actionForm).get_sk_reasontype())) {	
        	((RewardadjustForm)actionForm).set_sk_reasontype(((RewardadjustForm)actionForm).get_sk_reasontype()+",");
        }
        form.set_nne_islock("-2");
        //System.out.println(((RewardadjustForm)actionForm).get_sk_reasontype());
        super.doList(actionMapping, actionForm, request, response, user);
        if (((RewardadjustForm)actionForm).get_sk_reasontype()!=null && !"".equals(((RewardadjustForm)actionForm).get_sk_reasontype())) {	
        	((RewardadjustForm)actionForm).set_sk_reasontype(((RewardadjustForm)actionForm).get_sk_reasontype().substring(0,((RewardadjustForm)actionForm).get_sk_reasontype().length()-1));
        }
        
        //System.out.println(((RewardadjustForm)actionForm).get_sk_reasontype());
        return actionMapping.findForward("list");
	}
    
    public ActionForward doNew(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
        	((RewardadjustForm)actionForm).setDictid("P-");
        	((RewardadjustForm)actionForm).setAdjustkind("PUNISH");
        	((RewardadjustForm)actionForm).setCreateoprcode(user.getOpercode());
        	((RewardadjustForm)actionForm).setCreatetime(new Date());
        	((RewardadjustForm)actionForm).setUpdateoprcode(user.getOpercode());
        	((RewardadjustForm)actionForm).setUpdatetime(new Date());
        	((RewardadjustForm)actionForm).setWayid(user.getWayid());
        	((RewardadjustForm)actionForm).setIslock(new Short("1"));
        	((RewardadjustForm)actionForm).setRewardtype(new Short("-1"));
        	
        	DictitemListVO ditlistvo = new DictitemListVO();
        	DictitemDelegate dd = new DictitemDelegate();
        	ditlistvo.set_pagesize("0");
        	ditlistvo.set_sk_dictid("P-");
        	ditlistvo.set_se_groupid("CH_RWADJUSTREASON");
        	DataPackage ddp = dd.doQuery(ditlistvo, user);
        	//_selecttype
        	request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, ddp);
        return super.doNew(actionMapping, actionForm, request, response, user);
	}
    
    public ActionForward doLoadnew(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
    	RewardadjustForm form = (RewardadjustForm) actionForm;
    	String adjusttype = form.getAdjustkind();
    	if (adjusttype==null || "".equals(adjusttype)) {
			form.setDictid2("");
			form.setDictid("");
		}else if ("PUNISH".equals(adjusttype)) {
			form.setDictid("P-");
			form.setAdjusttype("");
		}else if ("RETURN".equals(adjusttype)) {
			form.setDictid("R-");
			form.setDictid2("EFTCURMONTH");
		}else if ("BONUS".equals(adjusttype)) {
			form.setDictid("B-");
			form.setDictid2("EFTCURMONTH");
		}
    	
    	((RewardadjustForm)actionForm).setCreateoprcode(user.getOpercode());
    	((RewardadjustForm)actionForm).setCreatetime(new Date());
    	((RewardadjustForm)actionForm).setUpdateoprcode(user.getOpercode());
    	((RewardadjustForm)actionForm).setUpdatetime(new Date());
    	((RewardadjustForm)actionForm).setWayid(user.getWayid());
    	((RewardadjustForm)actionForm).setIslock(new Short("1"));
    	((RewardadjustForm)actionForm).setRewardtype(new Short("-1"));
    	
    	DictitemListVO ditlistvo = new DictitemListVO();
    	DictitemDelegate dd = new DictitemDelegate();
    	ditlistvo.set_pagesize("0");
    	ditlistvo.set_sk_dictid(form.getDictid());
    	ditlistvo.set_se_groupid("CH_RWADJUSTREASON");
    	DataPackage ddp = dd.doQuery(ditlistvo, user);
    	//_selecttype
    	request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, ddp);
    return super.doNew(actionMapping, actionForm, request, response, user);
    }
    
    public ActionForward doSave(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
    	RewardadjustForm form = (RewardadjustForm) actionForm;
    	String[] sel = form.get_selecttype();
    	 String[] sel2=sel; 
    	
    	String adjusttype = form.getAdjustkind();
			if (adjusttype==null || "".equals(adjusttype)) {
				form.setDictid2("");
				form.setDictid("");
			}else if ("PUNISH".equals(adjusttype)) {
				form.setDictid("P-");
			}else if ("RETURN".equals(adjusttype)) {
				form.setDictid("R-");
				form.setDictid2("EFTCURMONTH");
			}else if ("BONUS".equals(adjusttype)) {
				form.setDictid("B-");
				form.setDictid2("EFTCURMONTH");
			}
		DictitemListVO ditlistvo = new DictitemListVO();
    	DictitemDelegate dd = new DictitemDelegate();
    	ditlistvo.set_pagesize("0");
    	ditlistvo.set_sk_dictid(form.getDictid());
    	ditlistvo.set_se_groupid("CH_RWADJUSTREASON");
    	DataPackage ddp = dd.doQuery(ditlistvo, user);
    	
    	request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, ddp);
    	request.setAttribute("SEL", sel2);
    			
    	if (sel==null || sel.length==0) {
    		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "要选择一个调整原因类型！");
    		return actionMapping.findForward("content");
    	}
    	StringBuffer sb = new StringBuffer();
    	for (int i=0;i<sel.length;i++) {
    		sb.append(sel[i]).append(",");
    	}
    	form.setReasontype(sb.toString());
    	WayDelegate waydelegate=new WayDelegate();
    	WayVO wayvo=waydelegate.doFindByPk(form.getWayid(), user);
		if(wayvo==null){
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "网点代码不存在");
			return actionMapping.findForward("content");
		}
		if (form.getCreateoprcode()!=null && "REWARD-SYSTEM".equals(form.getCreateoprcode())) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "该记录为系统创建记录，不允许修改!");
			return actionMapping.findForward("content");
		}
		form.setUpdatetime(new Date());
		form.setUpdateoprcode(user.getOpercode());
		
		
    	super.doSave(actionMapping, form, request, response, user);
    	
    	return actionMapping.findForward("content");
    }
    
    public ActionForward doLoadedit(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
    	RewardadjustForm form = (RewardadjustForm) actionForm;
    	form = (RewardadjustForm) actionForm;
    	String[] sel = form.get_selecttype();
    	String adjusttype = form.getAdjustkind();
			if (adjusttype==null || "".equals(adjusttype)) {
				form.setDictid2("");
				form.setDictid("");
			}else if ("PUNISH".equals(adjusttype)) {
				form.setDictid("P-");
			}else if ("RETURN".equals(adjusttype)) {
				form.setDictid("R-");
				form.setDictid2("EFTCURMONTH");
			}else if ("BONUS".equals(adjusttype)) {
				form.setDictid("B-");
				form.setDictid2("EFTCURMONTH");
			}
		DictitemListVO ditlistvo = new DictitemListVO();
    	DictitemDelegate dd = new DictitemDelegate();
    	ditlistvo.set_pagesize("0");
    	ditlistvo.set_sk_dictid(form.getDictid());
    	ditlistvo.set_se_groupid("CH_RWADJUSTREASON");
    	DataPackage ddp = dd.doQuery(ditlistvo, user);
    	
    	request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, ddp);
    	request.setAttribute("SEL", sel);
    	return actionMapping.findForward("content");
    }
    
    public ActionForward doEdit(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
    	RewardadjustForm form = (RewardadjustForm) actionForm;
    	
    	super.doEdit(actionMapping, actionForm, request, response, user);
    	form = (RewardadjustForm) actionForm;
    	String[] sel = StringSplit.split(form.getReasontype(),",");
    	String adjusttype = form.getAdjustkind();
			if (adjusttype==null || "".equals(adjusttype)) {
				form.setDictid2("");
				form.setDictid("");
			}else if ("PUNISH".equals(adjusttype)) {
				form.setDictid("P-");
			}else if ("RETURN".equals(adjusttype)) {
				form.setDictid("R-");
				form.setDictid2("EFTCURMONTH");
			}else if ("BONUS".equals(adjusttype)) {
				form.setDictid("B-");
				form.setDictid2("EFTCURMONTH");
			}
		DictitemListVO ditlistvo = new DictitemListVO();
    	DictitemDelegate dd = new DictitemDelegate();
    	ditlistvo.set_pagesize("0");
    	ditlistvo.set_sk_dictid(form.getDictid());
    	ditlistvo.set_se_groupid("CH_RWADJUSTREASON");
    	DataPackage ddp = dd.doQuery(ditlistvo, user);
    	
    	request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, ddp);
    	request.setAttribute("SEL", sel);
    	return actionMapping.findForward("content");
    }
    public ActionForward doBatch(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		return actionMapping.findForward("batch");
	}
}
