/**
 * auto-generated code
 * Fri Aug 28 11:17:48 CST 2009
 */
package com.sunrise.boss.ui.cms.reward.busitocom;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.operation.persistent.OperationListVO;
import com.sunrise.boss.business.cms.provincialright.persistent.ProvincialrightVO;
import com.sunrise.boss.business.cms.reward.busitocom.persistent.BusitocomListVO;
import com.sunrise.boss.business.cms.reward.busitocom.persistent.BusitocomVO;
import com.sunrise.boss.business.resmanage.com.persistent.ComListVO;
import com.sunrise.boss.business.resmanage.com.persistent.ComVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.cms.operation.OperationDelegate;
import com.sunrise.boss.delegate.cms.reward.busitocom.BusitocomDelegate;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.pub.tools.StringSplit;

/**
 * <p>Title: BusitocomAction</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class BusitocomAction extends BaseDelegateAction {
	public BusitocomAction() {
		setVoClass(BusitocomVO.class);
		// TODO: 给出主键的名字数组
		this.pkNameArray = new String[5];
		pkNameArray[0] = "cityid";
		pkNameArray[1] = "comid";
		pkNameArray[2] = "comresid";
		pkNameArray[3] = "comtype";
		pkNameArray[4] = "opnid";
	}

	/**
	 * 适配comid的bug
	 */
	public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		BusitocomForm form = (BusitocomForm) actionForm;
		if(!StringUtils.isEmpty(form.get_ne_comid())){
			String[] comids = StringSplit.split(form.get_ne_comid()," ");
			form.set_ne_comid(comids[0]);
		}
		form.set_sql_cityid("cityid = 'GD' or cityid is null or cityid ='' or cityid = '"+SessionFactoryRouter.conversionCityid(user.getCityid())+"'");
		return super.doList(actionMapping, form, request, response, user);
	}
	/**
	 * 导出为EXCEL格式。
	 */
	public ActionForward doExcel(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("业务与商品资源关联设置");
		export.appendHeadLine(new String[] { "导出工号:", user.getOpercode() });
		export
				.appendHeadLine(new String[] { "导出时间",
						format.format(new Date()) });
		export.addOutputProperty("opnid", "业务编码");
		export.addOutputProperty("cityid", "地市标志",CommonExportBean.CODE2NAME,"#CITYNAME");
		export.addOutputProperty("comtype", "商品类型",CommonExportBean.CODE2NAME,"$IM_COMTYPE");
		export.addOutputProperty("comid", "商品标志");
		export.addOutputProperty("comid", "商品名称",CommonExportBean.CODE2NAME,"#COMSYSTEM");
		export.addOutputProperty("pricelow", "商品协议价（元）");
		export.addOutputProperty("busitype", "业务组编码",CommonExportBean.CODE2NAME,"$CH_TOCOMBUSITYPE");
		
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super
				.doExcel(actionMapping, actionForm, request, response, user);
	}
	
	public ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		BusitocomForm form = (BusitocomForm) actionForm;
		//检验OPNID
		OperationDelegate operDele = new OperationDelegate();
		OperationListVO operListVO = new OperationListVO();
		operListVO.set_se_opnid(form.getOpnid());
		operListVO.set_ne_isbusi("1");
		if(operDele.doQuery(operListVO, user).getDatas().size()==0){
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存失败，业务编码["+form.getOpnid()+"]不存在");
			return actionMapping.findForward("content");
		}
		
		//校验是否有权限处理'0403'开头的业务
		if(form.getOpnid().toString().trim().substring(0, 4).equals("0403")){
			ProvincialrightVO rightvo = new ProvincialrightVO();
			rightvo.setProopr(user.getOpercode());
			rightvo.setRightid("CH_PW_TERMINALSELL");
			CommonDelegate delegate = new CommonDelegate(ProvincialrightVO.class);
			rightvo = (ProvincialrightVO) delegate.doFindByPk(rightvo, user);
			if (rightvo == null) {
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存失败，当前工号没有权限增加/编辑此业务!");
				return actionMapping.findForward("content");
			}
		}
		
		//校验COMID
		if(!StringUtils.isEmpty(form.getComid().toString())){
			String[] comids = StringSplit.split(form.getComid().toString()," ");
			form.setComid(new Long(comids[0]));
		}
		CommonDelegate comDele = new CommonDelegate(ComVO.class);
		ComListVO comListVO = new ComListVO();
		comListVO.set_ne_comid(form.getComid().toString());
		DataPackage comDp = comDele.doQuery(comListVO, user);
		if(comDp.getDatas().size()==0){
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存失败，商品标识["+form.getComid()+"]不存在");
			return actionMapping.findForward("content");
		}
		
		ComVO comvo = (ComVO) ((List) comDp.getDatas()).get(0);
		if(form.getPricelow().longValue() <= comvo.getComprice().longValue() &&
				comvo.getComprice().longValue() <= form.getPricetop().longValue()){
			
		}else{
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存失败，商品标识["+form.getComid()+"]的商品价格["+comvo.getComprice().longValue()/100+"]必须在区间内!");
			return actionMapping.findForward("content");
		}
		
		if(WebConstant.COMMAND_STRING_NEW.equals(form.getCmdState())){
			BusitocomDelegate delegate = new BusitocomDelegate();
			BusitocomListVO listvo = new BusitocomListVO();
			listvo.set_ne_comid(comvo.getComid().toString());
			DataPackage dp = delegate.doQuery(listvo, user);
			if(dp.getDatas() != null && dp.getDatas().size() != 0){
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存失败，商品标识["+form.getComid()+"]只能对应一个对应一个业务编码!");
				return actionMapping.findForward("content");
			}
		}
		
		form.setCityid(comvo.getCityid());
		form.setComclassid(new Integer(comvo.getComclassid().intValue()));
		form.setComtype(new Integer(comvo.getComtype().intValue()));
		form.setComresid("0");
			
		return super.doSave(actionMapping, form, request, response, user);
	}
	
	
	protected ActionForward doDelete(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		BusitocomForm form = (BusitocomForm) actionForm;
		String[]  selectArray = ((BusitocomForm) actionForm).get_selectitem();
		for (int i = 0; i < selectArray.length; i++) {
			String[] str = selectArray[i].split("\\|");
			if(str[4].toString().trim().substring(0, 4).equals("0403")){
				ProvincialrightVO rightvo = new ProvincialrightVO();
				rightvo.setProopr(user.getOpercode());
				rightvo.setRightid("CH_PW_TERMINALSELL");
				CommonDelegate delegate = new CommonDelegate(ProvincialrightVO.class);
				rightvo = (ProvincialrightVO) delegate.doFindByPk(rightvo, user);
				if (rightvo == null) {
					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "删除失败，当前工号没有权限删除此业务!");
					return actionMapping.findForward("list");
				}
			}
		}
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "操作成功!");
		return super.doDelete(actionMapping, actionForm, request, response, user);
	}
}
