package com.sunrise.boss.ui.cms.bbc.vstdreward;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ajaxanywhere.AAUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.ClassUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sunrise.boss.business.cms.bbc.operation.persistent.BBCoperationVO;
import com.sunrise.boss.business.cms.bbc.stdrewardbj.persistent.BBCstdrewardbjVO;
import com.sunrise.boss.business.cms.bbc.vstdreward.persistent.VstdrewardListVO;
import com.sunrise.boss.business.cms.bbc.vstdreward.persistent.VstdrewardVO;
import com.sunrise.boss.business.cms.provincialright.persistent.ProvincialrightListVO;
import com.sunrise.boss.business.cms.provincialright.persistent.ProvincialrightVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.utils.export.CommonExportBean;
import com.sunrise.boss.delegate.admin.acl.ACLDelegate;
import com.sunrise.boss.delegate.cms.bbc.operation.BBCoperationDelegate;
import com.sunrise.boss.delegate.cms.bbc.stdrewardbj.BBCstdrewardbjDelegate;
import com.sunrise.boss.delegate.cms.bbc.vstdreward.VstdrewardDelegate;
import com.sunrise.boss.delegate.common.CommonDelegate;
import com.sunrise.boss.ui.base.BaseAction;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.cms.commons.TimeUtil;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;

/**
 * <p>
 * Title: vstdrewardAction
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author Jerimy
 * @version 1.0
 */
public class VstdrewardAction extends BaseAction {
	// 省级权限令牌
	private static final String PROVINCE_PURVIEW_A = "CH_B2M_REWARD_PROVINCIAL";

	// 市级权限令牌
	private static final String PROVINCE_PURVIEW_B = "CH_B2M_REWARD_CIVIC";

	// 业务归属
	public final static String BUSIBELONG = "BUSIBELONG";

	public final static String SELL_BUSIBELONG = "SELL"; // 销售业务大类

	public final static String SELL_DATA_BUSIBELONG = "SELL_DATA";// 销售业务数据类

	public final static String SELL_SERVICE_BUSIBELONG = "SELL_SERVICE";// 销售业务服务类

	public final static String DATABUSI_BUSIBELONG = "DATABUSI"; // 数据销售类

	public final static String CZ_BUSIBELONG = "CZ"; // 充值销售类

	public final static String QUER_BUSIBELONG = "QUER"; // 查询类

	public final static String ACTV_BUSIBELONG = "ACTV"; // 活跃类

	public final static String ACTV_NEW_BUSIBELONG = "ACTV_NEW";// 新增网站活跃类

	public final static String ACTV_E100_BUSIBELONG = "ACTV_E100";// e100活跃类

	public final static String DEFAULT_ACCTYPE = "1"; // 计酬方式 默认按笔数计算

	public final static String SCALE_ACCTYPE = "2"; // 计酬方式 按比例计算

	public final static String PROVINCE_REGION = "999"; // 省工号
	
	// 区域标识 999-省公司 000-市公司
	public static String REGION_PRO = "999";
	public static String REGION_CIV = "000";
	public static String RIGHT;
	public static String RIGHT_CITY;

	public VstdrewardAction() throws Exception {
		setVoClass(VstdrewardVO.class);
		// TODO: 给出主键的名字数组
		this.pkNameArray = new String[3];
		pkNameArray[0] = "rewardid";
		pkNameArray[1] = "region";
		pkNameArray[2] = "ossrc";
		delegate = new CommonDelegate(ProvincialrightVO.class);
	}

	private String purview = "";

	private CommonDelegate delegate;
	
	/**
	 * 跳到一个tab页面
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	
	public ActionForward doShow(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
//		String select = (String) request.getParameter("select");
		String pk = (String) request
				.getParameter(WebConstant.REQUEST_ATTRIBUTE_PK);
//		request.setAttribute("select", select);
		request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_PK, pk);
		
//		getPurview(user);
//		if ("A".equals(this.purview)) {
////			request.setAttribute(RIGHT, "A");
//			request.setAttribute("RIGHT", "A");
//		} else if ("B".equals(this.purview)) {
////			request.setAttribute(RIGHT, "B");
//			request.setAttribute("RIGHT", "B");
//		}
		return actionMapping.findForward("frame");
	}

	/**
	 * 查询
	 */
	public ActionForward doList(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		Page.setPageSize(request, (BaseActionForm) actionForm);
		VstdrewardListVO listVO = new VstdrewardListVO();
		BaseActionForm baseForm = (BaseActionForm) actionForm;
		// BeanUtils.copyProperties(listVO, actionForm);
		// 设置好listVO，作Ordinary为查询条件
		VstdrewardForm form = (VstdrewardForm) actionForm;
		// if (form.get_ne_region() == null) {
		// form.set_ne_region("");
		// }
		BeanUtils.copyProperties(listVO, form);
		VstdrewardDelegate delegate = new VstdrewardDelegate();
		DataPackage dp =null;
		getPurview(user);
		if ("A".equals(this.purview)) {
			dp=delegate.doQueryDesc(listVO, user);
		} else{
			dp=delegate.doQuery(listVO, user);
		}
		
		
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		return (actionMapping.findForward("list"));
	}

	/**
	 * 编辑
	 */
	public ActionForward doEdit(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		/*
		 * 数据库取出来的值被放到actionform中去了
		 */
		getContentVO(request, user, actionForm);
		VstdrewardForm form = (VstdrewardForm) actionForm;
		
		//region获得是市公司还是省公司,跳转到不同的酬金设置页面
		String region = (String) request.getParameter("region");
		//如果是市公司过来就设置为市公司的id,省公司就不用设置
		if("000".equals(region))
			form.setRegion(user.getCityid());
		
		BBCoperationVO bbcVO = getBBCoperationVO(form.getOpnid(), user);
		if ("QUER".equals(bbcVO.getBusibelong())) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "业务归属等于查询类不允许编辑");
			return (actionMapping.findForward("list"));
		}
		String command = getCommandString(request);
		((BaseActionForm) actionForm).setCmdState(command);
		
		//根据是市公司还是省公司,采用不同的排序,如果是点击市公司的酬金设置标准,排序不变,如果是省公司,排序反过来
		if("000".equals(region)){
			doGetvalue(actionMapping, actionForm, request, response, user);
		}else{
			doGetvalueDesc(actionMapping, actionForm, request, response, user);
		}
		
		
		request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,
				WebConstant.COMMAND_STRING_EDIT);
//		//省公司,市公司跳到不同的页面
//		if ("A".equals(this.purview)) {
////			form.setRegion("999");
//			return (actionMapping.findForward("content"));
//		} else if ("B".equals(this.purview)) {
//			form.setRegion(user.getCityid());
//			return (actionMapping.findForward("content1"));
//		} 
		
		return (actionMapping.findForward("content"));
//		return actionMapping.findForward(getForward(region));
		
	}
	
	/**
	 * 根据区域标识定位跳转
	 * 
	 * @param region
	 * @return
	 */
	private String getForward(String region) {
		if (REGION_PRO.equals(region)) {
			return "contentpro";
		} else if (REGION_CIV.equals(region)) {
			return "contentciv";
		} else {
			return "contentpro";
		}
	}

	public void getContentVO(HttpServletRequest request, User user, ActionForm actionForm)
			throws Exception {

		String pk = request.getParameter(WebConstant.REQUEST_ATTRIBUTE_PK);
		if (pk == null)
			throw new NullPointerException("pk is required.");
		Object contentVO = getContentVO(request, user);
		if (contentVO == null)
			throw new NullPointerException("VO not found, pk " + pk + " of "
					+ ClassUtils.getShortClassName(actionForm.getClass()));
		BeanUtils.copyProperties(actionForm, contentVO);

	}

	public Object getContentVO(HttpServletRequest request, User user) throws Exception {
		String pk = "";
		String parameter = request.getParameter(WebConstant.REQUEST_ATTRIBUTE_PK);
		// list.jsp跳转过来的情况
		if (parameter != null) {
			pk = parameter;
		}
		
		//region获得是市公司还是省公司,跳转到不同的酬金设置页面
		String region = (String) request.getParameter("region");
//		VstdrewardVO contentVO=null;
//		if (REGION_PRO.equals(region)) {
//			contentVO = getSingVOPRO(user, pk);
//		} else if (REGION_CIV.equals(region)) {
//			contentVO = getSingVOCIV(user, pk);
//		} 
		VstdrewardVO contentVO = getSingVO(user, pk,region);
		return contentVO;
	}

	private VstdrewardVO getSingVO(User user, String pk) throws Exception {
		
		
		VstdrewardDelegate delegate = new VstdrewardDelegate();
		VstdrewardVO contentVO = null;
		VstdrewardListVO listVO = new VstdrewardListVO();
		String pks[] = StringUtils.splitPreserveAllTokens(pk, "|");
		listVO.set_ne_rewardid(pks[0]);
//		//省级酬金设置
//		listVO.set_se_region("999");
		listVO.set_se_region(pks[1]);
		listVO.set_ne_ossrc(pks[2]);
		listVO.set_se_opnid(pks[3]);
		if (!pk.trim().equalsIgnoreCase("")) { // 由list.jsp 传过来
			DataPackage dp = delegate.doQuery(listVO, user);
			contentVO = getVstdrewardVO(dp);
		}
		return contentVO;
	}
	
	
	private VstdrewardVO getSingVO(User user, String pk,String region) throws Exception {
		
		
		VstdrewardDelegate delegate = new VstdrewardDelegate();
		VstdrewardVO contentVO = null;
		VstdrewardListVO listVO = new VstdrewardListVO();
		String pks[] = StringUtils.splitPreserveAllTokens(pk, "|");
		listVO.set_ne_rewardid(pks[0]);
		if (REGION_PRO.equals(region)) {
			listVO.set_se_region("999");
		} else if (REGION_CIV.equals(region)) {
			listVO.set_se_region(region);
		} 
//		listVO.set_se_region(pks[1]);
		listVO.set_ne_ossrc(pks[2]);
		listVO.set_se_opnid(pks[3]);
		if (!pk.trim().equalsIgnoreCase("")) { // 由list.jsp 传过来
			DataPackage dp = delegate.doQuery(listVO, user);
			contentVO = getVstdrewardVO(dp);
		}
		return contentVO;
	}

	/**
	 * 取值
	 */
	public ActionForward doGetvalue(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		VstdrewardListVO listVO = new VstdrewardListVO();
		setListVO(listVO, actionForm); // 设置好listVO，作Ordinary为查询条件
		VstdrewardForm form = (VstdrewardForm) actionForm;
		VstdrewardDelegate delegate = new VstdrewardDelegate();
		listVO.set_se_opnid(form.getOpnid());
		listVO.set_ne_ossrc(String.valueOf(form.getOssrc()));
		// 取得权限
		getPurview(user);
		DataPackage dp = null;
			// 省级令牌
			dp = delegate.doQuery(listVO, user);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		if (dp.getRowCount() > 0) {
			request.setAttribute("SHOW", "TRUE");
		}
		request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, "EDIT");
		if (AAUtils.isAjaxRequest(request)) {
			AAUtils.addZonesToRefresh(request, "getvalue");
		}
		return actionMapping.findForward("content");
//		return actionMapping.findForward(getForward(form.getRegion()));
	}

	/**
	 * 取值
	 */
	public ActionForward doGetvalueDesc(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		VstdrewardListVO listVO = new VstdrewardListVO();
		setListVO(listVO, actionForm); // 设置好listVO，作Ordinary为查询条件
		VstdrewardForm form = (VstdrewardForm) actionForm;
		VstdrewardDelegate delegate = new VstdrewardDelegate();
		listVO.set_se_opnid(form.getOpnid());
		listVO.set_ne_ossrc(String.valueOf(form.getOssrc()));
		// 取得权限
		getPurview(user);
		DataPackage dp = null;
			// 省级令牌
			dp = delegate.doQueryDesc(listVO, user);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		if (dp.getRowCount() > 0) {
			request.setAttribute("SHOW", "TRUE");
		}
		request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, "EDIT");
		if (AAUtils.isAjaxRequest(request)) {
			AAUtils.addZonesToRefresh(request, "getvalue");
		}
		return actionMapping.findForward("content");
//		return actionMapping.findForward(getForward(form.getRegion()));
	}
	
	/**
	 * 获取省公司酬金上限
	 * 
	 * @param vo
	 * @param user
	 * @return
	 * @throws Exception
	 */
	/**
	 * 取值
	 */
	public ActionForward doGetprovincestd(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		try {
			getMaxRewardstd(actionForm, request, user);

			if (AAUtils.isAjaxRequest(request)) {
				AAUtils.addZonesToRefresh(request, "getprovincestd");
			}
			doGetvalue(actionMapping, actionForm, request, response, user);
		} catch (Exception ex) {
			request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, "EDIT");
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex.getMessage());
			request.setAttribute("DISABLE", "TRUE");
		}
		request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, "EDIT");
		return actionMapping.findForward("content");
	}

	private Double getMaxRewardstd(ActionForm actionForm, HttpServletRequest request, User user)
			throws Exception {
		VstdrewardVO contentVO = null;
		VstdrewardListVO listVO = new VstdrewardListVO();
		VstdrewardForm form = (VstdrewardForm) actionForm;
		VstdrewardDelegate delegate = new VstdrewardDelegate();
		listVO.set_se_opnid(form.getOpnid());
		listVO.set_se_region(PROVINCE_REGION);
		if (form.getOssrc() != null) {
			listVO.set_ne_ossrc(String.valueOf(form.getOssrc()));
		}
		listVO.set_dnm_startdate(TimeUtil.formatDate(form.getStartdate()));
		listVO.set_dnl_stopdate(TimeUtil.formatDate(form.getStopdate()));
		if (form.getIntvmonth() != null) {
			listVO.set_ne_intvmonth(String.valueOf(form.getIntvmonth()));
		}
		DataPackage dp = delegate.doQuery2(listVO, user);
		contentVO = getVstdrewardVO(dp);
		if (contentVO == null) {
			throw new Exception("省公司尚未设置该时间段的酬金标准，请联系省公司。");
		} else {
			form.setMax_pro_std(contentVO.getRewardstd());
			return contentVO.getRewardstd();
		}
	}

	/**
	 * 新建
	 */
	public ActionForward doNew(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		// 新建时设置form的默认值
		setNewForm(actionForm);
		String command = getCommandString(request);
		((BaseActionForm) actionForm).setCmdState(command);
		VstdrewardForm form = (VstdrewardForm) actionForm;
		form.setRegion(user.getCityid());
		form.setRewardproj(new Short("1"));
		getPurview(user);
		if ("A".equals(this.purview)) {
			form.setRegion("999");
		} else if ("B".equals(this.purview)) {
			form.setRegion(user.getCityid());
		} else {
			throw new Exception("该工号没有新增权限");
		}
		form.setAcctype(new Short(DEFAULT_ACCTYPE));
		request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,
				WebConstant.COMMAND_STRING_EDIT);
		return (actionMapping.findForward("content"));
	}

	/**
	 * A-省级权限，B-地市权限
	 * 
	 * @param user
	 */
	private void getPurview(User user) throws Exception {
		ProvincialrightListVO listVO = new ProvincialrightListVO();
		listVO.set_se_proopr(user.getOpercode());
		listVO.set_se_rightid(PROVINCE_PURVIEW_A);
		listVO.set_pagesize("0");

		if (delegate.doQuery(listVO, user).getDatas().size() > 0) {
			purview = "A";
			return;
		}
		ACLDelegate delegate2 = new ACLDelegate();
		if (delegate2.checkPermission(user.getOpercode(), PROVINCE_PURVIEW_A)) {
			purview = "A";
			return;
		}
		listVO.set_se_rightid(PROVINCE_PURVIEW_B);
		if (delegate.doQuery(listVO, user).getDatas().size() > 0) {
			purview = "B";
			return;
		}
		if (delegate2.checkPermission(user.getOpercode(), PROVINCE_PURVIEW_B)) {
			purview = "B";
			return;
		}
		purview = "";
	}

	/**
	 * 保存
	 */
	protected ActionForward doSave(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		try {
			VstdrewardDelegate delegate=new VstdrewardDelegate();
			VstdrewardVO contentVO = new VstdrewardVO();
			setSaveVO(contentVO, actionForm); // 在此格式化处理好 vo 以保存
			VstdrewardForm fm = (VstdrewardForm) actionForm;
			// 再次检查省酬金标准
			getPurview(user);
			//交叉权限的情况,用省公司的令牌改是公司的权限,如果是市公司的region,就检查一下
			if (("B".equals(this.purview))|| !("999".equals(fm.getRegion())) ) {
				Double max = getMaxRewardstd(actionForm, request, user);
				if (max != null && max.doubleValue() < contentVO.getRewardstd().doubleValue()) {
					if (fm.getAcctype().shortValue() == 2) {
						throw new Exception("地市酬金标准不能大于省酬金标准" + fm.getMax_pro_std().doubleValue()
								* 100 + "%");
					} else {
						throw new Exception("地市酬金标准不能大于省酬金标准" + fm.getMax_pro_std());
					}
				}
			}
				
			String cmdState = ((BaseActionForm) actionForm).getCmdState();
			if (WebConstant.COMMAND_STRING_EDIT.equals(cmdState)) {
				Object vo = null;
				BBCstdrewardbjVO pkVO = new BBCstdrewardbjVO();
				BeanUtils.copyProperties(pkVO, contentVO);
				BBCstdrewardbjDelegate bbcstdrewardbjdelegate= new BBCstdrewardbjDelegate();
				vo = bbcstdrewardbjdelegate.doFindByPk((Serializable) pkVO, user);
				if (vo == null) {
					bbcstdrewardbjdelegate.doCreate(pkVO, user);
				}else{
					// 更新是否要判断记录是否已经存在?
					delegate.doUpdate(contentVO, user);
				}
				
				BeanUtils.copyProperties(actionForm, contentVO); // 把更新后的值赋给form，用于web显示
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存成功");
			} else {// 新增
				Object vo = null;
				BBCstdrewardbjVO pkVO = new BBCstdrewardbjVO();
				BeanUtils.copyProperties(pkVO, contentVO);
				vo = new BBCstdrewardbjDelegate().doFindByPk((Serializable) pkVO, user);
				if (vo == null) {
					// 取得rewardtype的值
					getRewardtype(user, contentVO);
					//
					delegate.doCreate(contentVO, user);
					BeanUtils.copyProperties(actionForm, contentVO); // 把更新后的值赋给form，用于web显示
					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存成功");
				} else {
					request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,
							WebConstant.COMMAND_STRING_EDIT);
					request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "主键重复");
					onDuplicatePk(actionMapping, actionForm, request, response, user);
				}
			}
		} catch (Exception ex) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, ex.getMessage());
			request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,
					WebConstant.COMMAND_STRING_EDIT);
			return (actionMapping.findForward("content"));
		}
		return (actionMapping.findForward("content"));
	}

	/**
	 * 判断酬金类型
	 * 
	 * @param user
	 * @param contentVO
	 * @throws Exception
	 */
	private void getRewardtype(User user, VstdrewardVO contentVO) throws Exception {
		BBCoperationVO bbcVO = getBBCoperationVO(contentVO, user);
		if (contentVO.getIntvmonth().intValue() > 0) {
			if ("CZ".equals(bbcVO.getBusibelong()) || "DATABUSI".equals(bbcVO.getBusibelong())
					|| "DATABUSI2".equals(bbcVO.getBusibelong())
					|| "SELL".equals(bbcVO.getBusibelong())) {
				contentVO.setRewardtype(new Short("10"));
			}
			if ("030100047".equals(contentVO.getOpnid())) {
				contentVO.setRewardtype(new Short("12"));
			}
			if ("030100048".equals(contentVO.getOpnid())) {
				contentVO.setRewardtype(new Short("14"));
			}
		} else if (contentVO.getIntvmonth().intValue() == 0) {
			if ("CZ".equals(bbcVO.getBusibelong()) || "DATABUSI".equals(bbcVO.getBusibelong())
					|| "DATABUSI2".equals(bbcVO.getBusibelong())
					|| "SELL".equals(bbcVO.getBusibelong())) {
				contentVO.setRewardtype(new Short("9"));
			}
			if ("030100047".equals(contentVO.getOpnid())) {
				contentVO.setRewardtype(new Short("11"));
			}
			if ("030100048".equals(contentVO.getOpnid())) {
				contentVO.setRewardtype(new Short("13"));
			}
		}
	}

	private BBCoperationVO getBBCoperationVO(VstdrewardVO contentVO, User user) throws Exception {
		BBCoperationVO bbcVO = getBBCoperationVO(contentVO.getOpnid(), user);
		return bbcVO;
	}

	private BBCoperationVO getBBCoperationVO(String opnid, User user) throws Exception {
		BBCoperationDelegate bbcDelegate = new BBCoperationDelegate();
		BBCoperationVO bbcVO = bbcDelegate.doFindByPk(opnid, user);
		return bbcVO;
	}

	/**
	 * 删除
	 */
	protected ActionForward doDelete(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		getPurview(user);
		String[] selectArray = ((BaseActionForm) actionForm).get_selectitem();
		VstdrewardDelegate delegate = new VstdrewardDelegate();
		for (int i = 0; i < selectArray.length; i++) {
			{
				VstdrewardVO delVO = (VstdrewardVO) getSingVO(user, selectArray[i]);
				if ("A".equals(this.purview) && "999".equals(delVO.getRegion())) {
					delegate.doRemove(delVO, user);
				} else if("A".equals(this.purview) && !"999".equals(delVO.getRegion())){
					throw new Exception("省级令牌工号只能删除区域为[广东]的记录");
				}
				if ("B".equals(this.purview) && user.getCityid().equals(delVO.getRegion())) {
					delegate.doRemove(delVO, user);
				} else if("B".equals(this.purview) && !user.getCityid().equals(delVO.getRegion())){
					throw new Exception("地市令牌工号只能删除区域为本地市的记录");
				}
				if ("".equals(this.purview)) {
					throw new Exception("该工号没有删除权限");
				}
			}
		}
		return doList(actionMapping, actionForm, request, response, user);
	}

	/**
	 * 返回查询到的第一个VO.
	 */
	private VstdrewardVO getVstdrewardVO(DataPackage dp) throws Exception {
		VstdrewardVO contentVO = null;
		if (dp.getRowCount() > 0) {
			Collection col = dp.getDatas();
			Iterator it = col.iterator();
			if (it.hasNext()) {
				contentVO = (VstdrewardVO) it.next();
			}
		}
		return contentVO;
	}

	/**
	 * 导出为EXCEL格式。
	 */
	public ActionForward doExcel(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("酬金标准导出");
		export.appendHeadLine(new String[] { "导出工号:", user.getOpercode() });
		export.appendHeadLine(new String[] { "导出时间", format.format(new Date()) });
		export.addOutputProperty("rewardid", "酬金标志");
		export.addOutputProperty("rewardname", "酬金名称");
		export.addOutputProperty("opnid", "业务代码", CommonExportBean.CODE2NAME, "#BBC_OPERATION");
		export.addOutputProperty("region", "区域", CommonExportBean.CODE2NAME, "$region");
		export.addOutputProperty("ossrc", "业务平台来源", CommonExportBean.CODE2NAME, "$CH_OSSRC");
		export.addOutputProperty("rewardtype", "酬金类型", CommonExportBean.CODE2NAME,
				"#CH_BBCREWARDTYPE");
		export.addOutputProperty("intvmonth", "间隔月份(月)");
		export.addOutputProperty("rewardstd", "酬金标准");
		export.addOutputProperty("startdate", "启用时间", CommonExportBean.DATE, "yyyy-MM-dd");
		export.addOutputProperty("stopdate", "停用时间", CommonExportBean.DATE, "yyyy-MM-dd");
		export.addOutputProperty("acctype", "计酬方式", CommonExportBean.CODE2NAME, "$CH_ACCTYPE");
		export.addOutputProperty("ruleid", "校验规则标志", CommonExportBean.CODE2NAME, "#CH_ADT_RULE");
		export.addOutputProperty("memo", "备注");
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel(actionMapping, actionForm, request, response, user);
	}
}
