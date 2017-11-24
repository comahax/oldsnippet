/**
* auto-generated code
* Thu Mar 15 09:32:40 CST 2012
*/
package com.sunrise.boss.ui.cms.reward.xjjlywjfmx;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.reward.xjjlywjfmx.persistent.XjjlywjfmxListVO;
import com.sunrise.boss.business.cms.reward.xjjlywjfmx.persistent.XjjlywjfmxVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.cms.reward.xjjlywjfmx.XjjlywjfmxDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: XjjlywjfmxAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public class XjjlywjfmxAction extends BaseAction {
    public XjjlywjfmxAction() {
            setVoClass(XjjlywjfmxVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[3]; 
           pkNameArray[0] = "busivalue"; 
           pkNameArray[1] = "flag"; 
           pkNameArray[2] = "wayid"; 
    }
    
public ActionForward doList(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception{		
    	
    	XjjlywjfmxDelegate ywjfbbDelegate=new XjjlywjfmxDelegate();
    	XjjlywjfmxListVO ywjfbbListVO =new XjjlywjfmxListVO();
    	XjjlywjfmxForm ywjfbbForm=(XjjlywjfmxForm)actionForm;
    	BeanUtils.copyProperties(ywjfbbListVO, ywjfbbForm);
    	DataPackage dp=ywjfbbDelegate.doQuery(ywjfbbListVO, user);
    	request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
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
		export.addOutputProperty("countycompid", "分公司");
		export.addOutputProperty("chainhead", "服务厅/连锁商家");
		export.addOutputProperty("wayid", "网点编码");
		export.addOutputProperty("wayname", "网点名称");
		export.addOutputProperty("starlevel", "星级",export.CODE2NAME,"$CH_STARLEVEL");
		export.addOutputProperty("calcmonth", "所属月份");
		export.addOutputProperty("dzzd", "3G业务笔数");
		export.addOutputProperty("sr", "收入型数据业务笔数");
		export.addOutputProperty("fsr", "非收入型数据业务笔数");
		export.addOutputProperty("czjf", "充值缴费金额");
		export.addOutputProperty("yckb", "预存捆绑业务笔数");
		export.addOutputProperty("jtdh", "家庭短号网笔数");
		export.addOutputProperty("dhjq", "短号集群网笔数");
		export.addOutputProperty("lxw", "老乡网亲情号码笔数");
		export.addOutputProperty("ajh", "A+计划笔数");
		export.addOutputProperty("creditaccount", "业务总积分");
		export.addOutputProperty("paysum", "业务积分奖励");
					
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		
		export.voClassArray = new Class[] { voClass };
		export.queryMethodName = "doList";
		if (export.headtitle == null) {
			export.headtitle = export.getFileName();
		}
		export.buildExcelPage(actionMapping, actionForm, request, response, user, this);
		
		return actionMapping.findForward(null);
	}
    
}
