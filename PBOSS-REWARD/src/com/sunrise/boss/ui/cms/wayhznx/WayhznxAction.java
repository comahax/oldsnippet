/**
* auto-generated code
* Thu Feb 12 10:06:59 CST 2009
*/
package com.sunrise.boss.ui.cms.wayhznx;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.way.persistent.WayListVO;
import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.business.cms.wayhznx.persistent.WayhznxListVO;
import com.sunrise.boss.business.cms.wayhznx.persistent.WayhznxVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.cms.wayhznx.WayhznxDelegate;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;



/**
 * <p>Title: WayhznxAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Li ZhaoLiang
 * @version 1.0
 */
public class WayhznxAction extends BaseDelegateAction {
    public WayhznxAction() {
        this.voClass = WayhznxVO.class;       
        this.pkNameArray=new String[]{"wayid"};        
    } 
    
    public ActionForward doList(ActionMapping actionMapping,
    		ActionForm actionForm, HttpServletRequest request,
    		HttpServletResponse response, User user) throws Exception {
    	WayhznxForm form = (WayhznxForm)actionForm;
    	// TODO Auto-generated method stub
    	Page.setPageSize(request, form);
    	try{
    		WayListVO wayListvo = new WayListVO();
    		BeanUtils.copyProperties(wayListvo, form);
    		WayhznxListVO hznxListvo = new WayhznxListVO();
    		
    		Object[] params = new Object[]{wayListvo,hznxListvo};
    		Class[] cls = new Class[]{WayVO.class,WayhznxVO.class};
    		String[][] joins = new String[][]{
    								{"wayid","wayid"}
    							};
    		
    		WayhznxDelegate delegate = new WayhznxDelegate();
    		DataPackage dp = delegate.doQuery2(params, cls, joins, user);
    		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
    	}catch (Exception e) {
    		e.printStackTrace();
    		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e.getMessage());
			// TODO: handle exception
		}
    	return (actionMapping.findForward("list"));
    }
    
    public ActionForward doTxt(ActionMapping actionMapping,
    		ActionForm actionForm, HttpServletRequest request,
    		HttpServletResponse response, User user) throws Exception {
    	// TODO Auto-generated method stub
    	CommonExportBean export = new CommonExportBean(user);
		export.setFileName("合作年限奖管理查询");
		           
		export.addOutputProperty(0,"wayid",null,null);
		export.addOutputProperty(0,"wayname",null,null);
		export.addOutputProperty(0,"starlevel",CommonExportBean.CODE2NAME,"$CH_STARLEVEL");
		
		export.addOutputProperty(1,"laststarttime",CommonExportBean.DATE,"yyyy-MM-dd");
		export.addOutputProperty(1,"years",null,null);
		export.addOutputProperty(1,"yearstime",CommonExportBean.DATE,"yyyy-MM-dd");
		export.addOutputProperty(1,"calcmonth",null,null);
		export.addOutputProperty(1,"cleartime",CommonExportBean.DATE,"yyyy-MM-dd");
		export.addOutputProperty(1,"oprcode",null,null);
		export.addOutputProperty(1,"oprtime",CommonExportBean.DATE,"yyyy-MM-dd");
		export.addOutputProperty(1,"remark",null,null);
		
		export.voClassArray=new Class[]{WayVO.class,WayhznxVO.class};
		response.setHeader("pragma", "no-cache");
        response.setHeader("Cache-control","public");
        response.setHeader("Expires", "01 Apr 1995 01:10:10 GMT");
        String fn = "attachment; filename="+export.getFileName()+".txt";
        response.setHeader("Content-Disposition", new String(fn.getBytes("GBK"),
                                        "ISO-8859-1"));
        response.setContentType("text/plain");
        export.writeTxtTitle(response.getOutputStream(), new String[] { "渠道编码", "渠道名称", "星级", "最近一次计算使用的合作开始时间", "最近一次统计的合作年限", "最近一次统计合作年限的时间",
				"最近一次结算合作年限奖的结算月", "下次计算使用的合作开始时间", "下次计算使用的合作开始时间更新人", "更新时间", "备注"});
		super.ExportQuery(actionMapping, actionForm, request, response, user, export);
		return actionMapping.findForward(null);
    }
    
}
