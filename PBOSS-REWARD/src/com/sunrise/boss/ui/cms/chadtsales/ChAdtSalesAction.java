/**
* auto-generated code
* Mon Jan 14 14:13:07 CST 2013
*/
package com.sunrise.boss.ui.cms.chadtsales;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.chadtsales.persistent.ChAdtSalesVO;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.cms.chadtsales.ChAdtSalesDelegate;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: ChAdtSalesAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author limin
 * @version 1.0
 */
public class ChAdtSalesAction extends BaseAction {
    public ChAdtSalesAction() {
            setVoClass(ChAdtSalesVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[4]; 
           pkNameArray[0] = "cityid"; 
           pkNameArray[1] = "opnid"; 
           pkNameArray[2] = "wayattr"; 
           pkNameArray[3] = "sales"; 
    }

	@Override
	protected ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		((ChAdtSalesForm)actionForm).setCityid(Short.parseShort(SessionFactoryRouter.conversionCityid2Num(user.getCityid())));
		ChAdtSalesVO contentVO = new ChAdtSalesVO();
		setSaveVO(contentVO, actionForm); // 在此格式化处理好 vo 以保存

		ChAdtSalesDelegate chadtsalesdelegate = new ChAdtSalesDelegate();
		String cmdState = ((BaseActionForm) actionForm).getCmdState();
		if (WebConstant.COMMAND_STRING_EDIT.equals(cmdState)) {// 更新
			chadtsalesdelegate.doUpdate(contentVO, user);
			BeanUtils.copyProperties(actionForm, contentVO); // 把更新后的值赋给form，用于web显示
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存成功");
		} else {// 新增
			Object vo = null;
			
				Object pkVO = voClass.newInstance();
				BeanUtils.copyProperties(pkVO, contentVO);
				vo = chadtsalesdelegate.doFindByPk((Serializable) pkVO, user);
		
			if (vo == null) {
				chadtsalesdelegate.doCreate(contentVO, user);
				BeanUtils.copyProperties(actionForm, contentVO); // 把更新后的值赋给form，用于web显示
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存成功");
			} else {
				request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, WebConstant.COMMAND_STRING_EDIT);
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "主键重复");
				onDuplicatePk(actionMapping, actionForm, request, response, user);
			}
		}
		return (actionMapping.findForward("content"));
	}
	
	
	public ActionForward doTxt(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("商圈门店补贴销量达标奖励标准");  
		export.addOutputProperty("cityid",CommonExportBean.CODE2NAME,"#CITYIDNUM2NMAME");
		export.addOutputProperty("opnid");
		export.addOutputProperty("wayattr");
		export.addOutputProperty("sales");
		export.addOutputProperty("rewardstd");
		
		export.voClassArray = new Class[] { ChAdtSalesVO.class };
		response.setHeader("pragma", "no-cache");
		response.setHeader("Cache-control", "public");
		response.setHeader("Expires", "01 Apr 1995 01:10:10 GMT");
		String fn = "attachment; filename=" + export.getFileName() + ".txt";
		response.setHeader("Content-Disposition", new String(
				fn.getBytes("GBK"), "ISO-8859-1"));
		response.setContentType("text/plain");
		export.writeTxtTitle(response.getOutputStream(), new String[] {"地市", "业务编码", "连锁加盟渠道属性","销量", "酬金标准"});
		super.ExportQuery(actionMapping, actionForm, request, response, user,
				export);
		return actionMapping.findForward(null);
	}

	@Override
	protected ActionForward doDelete(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		String[] selectArray = ((BaseActionForm) actionForm).get_selectitem();
		ChAdtSalesDelegate chadtsalesdelegate = new ChAdtSalesDelegate();
		
		for (int i = 0; i < selectArray.length; i++) {
			chadtsalesdelegate.doRemove(getDeletePkVO(selectArray[i],chadtsalesdelegate,user), user);
		}

		return doList(actionMapping, actionForm, request, response, user);
	}
	
	protected ChAdtSalesVO getDeletePkVO(String pkValue,ChAdtSalesDelegate chadtsalesdelegate,User user) throws Exception {
		String[] pkValueArray = pkValue.split("\\|");
		ChAdtSalesVO vo = new ChAdtSalesVO();
		
		for (int j = 0; j < pkValueArray.length; j++) {
			BeanUtils.setProperty(vo, pkNameArray[j], pkValueArray[j]);
		}
		vo = chadtsalesdelegate.doFindByPk((Serializable) vo, user);
		return vo;
	}
    
    
}
