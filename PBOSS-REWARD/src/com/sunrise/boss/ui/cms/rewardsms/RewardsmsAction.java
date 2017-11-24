/**
* auto-generated code
* Thu Jul 28 10:25:58 CST 2011
*/
package com.sunrise.boss.ui.cms.rewardsms;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.rewardsms.persistent.RewardsmsListVO;
import com.sunrise.boss.business.cms.rewardsms.persistent.RewardsmsVO;
import com.sunrise.boss.business.cms.smstmpl.persistent.SmstmplVO;
import com.sunrise.boss.business.cms.waitreq.persistent.WaitreqVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.delegate.cms.rewardsms.RewardsmsDelegate;
import com.sunrise.boss.delegate.cms.smstmpl.SmstmplDelegate;
import com.sunrise.boss.delegate.cms.waitreq.WaitreqDelegate;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>Title: RewardsmsAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
public class RewardsmsAction extends BaseDelegateAction {
    public RewardsmsAction() {
            setVoClass(RewardsmsVO.class);
        // TODO: 给出主键的名字数组
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "seq"; 
    }
    
	/**
	 * 新建
	 */
	protected ActionForward doNew(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		
		// 设置分公司的约束条件
		request.setAttribute("cityid", SessionFactoryRouter.conversionCityid(user.getCityid()));
		return super.doNew(actionMapping, actionForm, request, response, user);
	}
	
	/**
	 * 编辑
	 */
	protected ActionForward doEdit(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		
		// 设置分公司的约束条件
		request.setAttribute("cityid", SessionFactoryRouter.conversionCityid(user.getCityid()));
		return super.doEdit(actionMapping, actionForm, request, response, user);
	}
	
	/**
	 * 保存
	 */
	public ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {

		RewardsmsForm form = (RewardsmsForm) actionForm;
		RewardsmsVO contentVO = new RewardsmsVO();
		setSaveVO(contentVO, form);

		RewardsmsDelegate delegate = new RewardsmsDelegate();

		try {
			String cmdState = form.getCmdState();
			if (WebConstant.COMMAND_STRING_EDIT.equals(cmdState)) {
				RewardsmsVO existObj = delegate.doFindByPk(contentVO.getSeq(),
						user);
				if (existObj != null) {
					org.apache.commons.beanutils.BeanUtils.copyProperties(existObj,
							contentVO);
					contentVO = existObj;
				}
				// 设置操作类型为更新
				contentVO.setOpertype("U");
				// 设置操作日期为当天
				contentVO.setOpertime(new Date());
				// 设置操作工号为登录工号
				contentVO.setOpercode(user.getOpercode());
				contentVO = delegate.doUpdate(contentVO, user);
			} else {
				RewardsmsListVO listvo = new RewardsmsListVO();
				listvo.set_se_countyid(contentVO.getCountyid());
				listvo.set_se_calcmonth(contentVO.getCalcmonth());
				DataPackage dp = delegate.doQuery(listvo, user);
				if (contentVO.getCountyid() != null && dp != null && dp.getRowCount() != 0) {
					request.setAttribute(
							WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,
							WebConstant.COMMAND_STRING_EDIT);
					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
							"提示短信任务已经存在。");
					request.setAttribute("cityid", SessionFactoryRouter.conversionCityid(user.getCityid()));
					return (actionMapping.findForward("content"));
				} else {
					// 设置操作类型为新增
					contentVO.setOpertype("I");
					// 设置操作日期为当天
					contentVO.setOpertime(new Date());
					// 设置操作工号为登录工号
					contentVO.setOpercode(user.getOpercode());
					contentVO = delegate.doCreate1(contentVO, user);
				}
			}
			BeanUtils.copyProperties(actionForm, contentVO);
			((BaseActionForm) actionForm)
					.setCmdState(WebConstant.COMMAND_STRING_EDIT);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存成功");
		} catch (BusinessException e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.toString());
		} catch (Exception e) {
			throw e;
		}

		request.setAttribute("cityid", SessionFactoryRouter.conversionCityid(user.getCityid()));
		return (actionMapping.findForward("content"));
	}
	
    /**
     * 按下测试发送按钮，将输入的手机号的信息插入到短信待发送表
     * @param actionMapping
     * @param actionForm
     * @param request
     * @param response
     * @param user
     * @return
     * @throws Exception
     */
    public ActionForward doSendtest(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception{
    	
//    	RewardsmsForm form = (RewardsmsForm)actionForm;  	
    	// 取得短信内容
    	Map<String, String> map = new HashMap<String, String>();
    	String content = doGenSMS("CH_INFOTOWAY", map, user);
    	
    	// 取得店主手机号
    	String officetel = request.getParameter("no");//form.getOfficetel();
    	
    	// 插入短信待发送表
    	WaitreqDelegate wdelegate = new WaitreqDelegate();
    	WaitreqVO wvo = new WaitreqVO();
    	wvo.setSmstype(new Short("2"));
    	wvo.setAreacode(SessionFactoryRouter.conversionCityid(user.getCityid()));
    	wvo.setCreattime(new Date());
    	wvo.setDealtime(new Date());
    	wvo.setMessage(content);
    	wvo.setSendno("10086");
    	wvo.setRecno(officetel);
    	wvo.setDealcount(new Short("0"));
    	wvo.setIssuccess(new Short("0"));
    	wdelegate.doCreate(wvo, user);
    	
		return (actionMapping.findForward("list"));
    }
    
    /**
     * 短信模板接口
     */
	public static String doGenSMS(String sId, Map<String,String> keyAndValue, User user) throws Exception{

		SmstmplDelegate delegate = new SmstmplDelegate();
		SmstmplVO vo = delegate.doFindByPk(sId, user);
		//找到对应短信模板
		if(vo.getScontent() != null)
		{
			String content = vo.getScontent();
			
			//替换参数
			String key = new String();
			String value = new String();

			for(Iterator<String> iter = keyAndValue.keySet().iterator(); iter.hasNext();)
			{
				key = iter.next();
				value = keyAndValue.get(key);
				content = content.replaceAll("\\{" + key + "\\}", value);
			}
			return content;
		}
		else
		{
			return "";
		}
	}
}
