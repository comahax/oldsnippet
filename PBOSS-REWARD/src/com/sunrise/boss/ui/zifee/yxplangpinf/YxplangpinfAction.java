/**
* auto-generated code
* Sat Jan 13 14:53:14 CST 2007
*/
package com.sunrise.boss.ui.zifee.yxplangpinf;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.zifee.yxplangpinf.persistent.YxplangpinfVO;
import com.sunrise.boss.business.zifee.yxplangpinf.persistent.YxplangpinfListVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.zifee.yxplangpinf.YxplangpinfDelegate;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.ui.zifee.yxplangpinf.YxplangpinfForm;

/**
 * <p>Title: YxplangpinfAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
public class YxplangpinfAction extends BaseDelegateAction {
    public YxplangpinfAction() {
        this.voClass = YxplangpinfVO.class;
        // TODO: 给出主键的名字数组
        this.pkNameArray=new String[1];
        this.pkNameArray[0]="groupid";
    }
    
	/**
	 * 查询
	 */
	public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		YxplangpinfForm form = (YxplangpinfForm)actionForm;
		try{
				YxplangpinfListVO listVO = new YxplangpinfListVO();
				setListVO(listVO, actionForm); // 设置好listVO，作为查询条件
		        //限制查询本工号所属市公司以及全省性，全国性的区域营销方案分组 modify by luozhoujie 
				if (form.get_se_areacode() == null || "".equals(form.get_se_areacode())) {				
					//集团统一营销案,全省,市公司,区域标识为空也在查询范围内
					String _sql_areacode = " (areacode is null or  areacode in ('865','100','999','','"+user.getCityid()+"')) ";
					listVO.set_sql_areacode(_sql_areacode);
				}
				YxplangpinfDelegate delegate = new YxplangpinfDelegate();
				DataPackage dp = delegate.doQuery(listVO, user);
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
			} catch (BusinessException e) {
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
						.getMessage());
			} catch (Exception e) {
				throw e;
			}
		return (actionMapping.findForward("list"));
	}	
	
	/**
	 * 新建
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 * @author added by luozhoujie
	 */
	public ActionForward doNew(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		YxplangpinfForm form = (YxplangpinfForm)actionForm;
		//如果营销方案区域分组标识空，默认当前用户所在区域
		if(null==form.getAreacode() || "".equals(form.getAreacode())){
			form.setAreacode(user.getCityid());
		}
		return super.doNew(actionMapping, actionForm, request, response, user);
	}
	
	public void onDuplicatePk(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) {

		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
				"保存失败，相同营销方案分组标识全省范围内已经存在");

	}
	
	/**
	 * 营销方案组以树目录显示
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 * @author added by luozhoujie
	 */
	public ActionForward doTree(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		YxplangpinfForm form = (YxplangpinfForm)actionForm;
		YxplangpinfListVO listVO = new YxplangpinfListVO();
		setListVO(listVO, actionForm); // 设置好listVO，作为查询条件
        //限制查询本工号所属市公司以及全省性，全国性的区域营销方案分组 modify by luozhoujie 
		if (form.get_se_areacode() == null || "".equals(form.get_se_areacode())) {				
			//集团统一营销案,全省,市公司,区域标识为空也在查询范围内
			String _sql_areacode = " (areacode is null or  areacode in ('865','100','999','','"+user.getCityid()+"')) ";
			listVO.set_sql_areacode(_sql_areacode);
		}
		YxplangpinfDelegate delegate = new YxplangpinfDelegate();
		DataPackage dp = delegate.doQuery(listVO, user);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		return (actionMapping.findForward("tree"));
	}
}
