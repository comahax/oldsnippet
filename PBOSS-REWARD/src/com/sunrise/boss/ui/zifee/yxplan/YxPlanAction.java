package com.sunrise.boss.ui.zifee.yxplan;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ajaxanywhere.AAUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.sunrise.boss.business.admin.dictitem.persistent.DictitemListVO;
import com.sunrise.boss.business.admin.dictitem.persistent.DictitemVO;
import com.sunrise.boss.business.zifee.yxplan.persistent.YxPlanListVO;
import com.sunrise.boss.business.zifee.yxplan.persistent.YxPlanVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.common.utils.bean.BeanUtils;
import com.sunrise.boss.delegate.admin.dictitem.DictitemDelegate;
import com.sunrise.boss.delegate.zifee.yxplan.YxPlanDelegate;
import com.sunrise.boss.delegate.zifee.yxplangroup.YxPlanGroupDelegate;
import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.ui.base.BaseDelegateAction;
import com.sunrise.boss.ui.base.Page;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.WebConstant;
import com.sunrise.boss.ui.commons.batch.upload.BaseCheckFormat;
import com.sunrise.boss.ui.commons.integration.IntegrationBean;
import com.sunrise.boss.ui.zifee.commons.BatchProcess;
import com.sunrise.boss.ui.zifee.commons.ResultBean;

public class YxPlanAction extends BaseDelegateAction {
	private String[] specialflagValue;

	private String[] specialflagName;

	private DictitemDelegate dictDelegate;

	public YxPlanAction() {
		this.voClass = YxPlanVO.class;
		this.pkNameArray = new String[1];
		pkNameArray[0] = "yxplanid";

	}

	protected void onDuplicatePk(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) {

		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
				"相同营销方案标识已经存在, 请输入其他编码");

	}

	/**
	 * 查询
	 */
	public ActionForward doList(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		YxPlanActionForm form = (YxPlanActionForm) actionForm;

		try {
			Page.setPageSize(request, form);
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			YxPlanListVO listVO = new YxPlanListVO();
			setListVO(listVO, actionForm); // 设置好listVO，作为查询条件
			listVO.set_ne_groupflag("0"); // 1 是, 0
			// 否（如果“是”营销方案组，则在[营销方案管理]中不可见，在[营销方案分组管理]中对营销方案组管理）

			// 限制查询本工号所属市公司以及全省性营销方案，全国性营销方案 modify by luozhoujie 2006-11-29
			if (form.get_se_areacode() == null
					|| "".equals(form.get_se_areacode())) {
				// 集团统一营销案,全省,市公司,区域标识为空也在查询范围内
				String _sql_areacode = " (areacode is null or  areacode in ('865','100','999','','"
						+ user.getCityid() + "')) ";
				listVO.set_sql_areacode(_sql_areacode);
			}

			YxPlanDelegate delegate = new YxPlanDelegate();
			DataPackage dp = delegate.doQuery(listVO, user);
			// 翻译营销方案标志
			// DataPackage dp2 = dealDate(dp, user);
			// form.setPage(dp.getPageNo());
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		} catch (BusinessException e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
		} catch (Exception e) {
			throw e;
		}
		return (actionMapping.findForward("list"));
	}

	public ActionForward doSelectyxplanid(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		YxPlanActionForm form = (YxPlanActionForm) actionForm;
		try {
			Page.setPageSize(request, form);
			YxPlanListVO listVO = new YxPlanListVO();
			YxPlanDelegate delegate = new YxPlanDelegate();
			setListVO(listVO, form);
			DataPackage dp = delegate.doQuery(listVO, user);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
		}
		return actionMapping.findForward("selectyxplanid");
	}

	public Long getYxplanSeq(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {

		YxPlanDelegate delegate = new YxPlanDelegate();
		Long dbSeq = delegate.getYxplanSeq(user);
		return dbSeq;
	}

	public String formatYxplanID(String yxplanid) {

		return yxplanid;
	}

	public ActionForward doSelect(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		YxPlanActionForm form = (YxPlanActionForm) actionForm;
		try {
			Page.setPageSize(request, form);
			YxPlanListVO listVO = new YxPlanListVO();
			setListVO(listVO, actionForm); // 设置好listVO，作为查询条件
			listVO.set_ne_groupflag("0"); // 1 是, 0
			// 否（如果“是”营销方案组，则在[营销方案管理]中不可见，在[营销方案分组管理]中对营销方案组管理）

			// 限制查询本工号所属市公司以及全省性营销方案，全国性营销方案 modify by luozhoujie 2006-11-29
			if (form.get_se_areacode() == null
					|| "".equals(form.get_se_areacode())) {
				// 集团统一营销案,全省,市公司,区域标识为空也在查询范围内
				String _sql_areacode = " (areacode is null or  areacode in ('865','100','999','','"
						+ user.getCityid() + "')) ";
				listVO.set_sql_areacode(_sql_areacode);
			}
			YxPlanDelegate delegate = new YxPlanDelegate();
			DataPackage dp = delegate.doQuery(listVO, user);

			// form.setPage(dp.getPageNo());
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
		}
		return (actionMapping.findForward("select"));
	}

	protected ActionForward doNew(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		// TODO Auto-generated method stub
		String str;
		java.util.Date date = new java.util.Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		// str = "GD10000" + dateFormat.format(date) + "001" + "-" + "000000"+
		// "-" + "00";
		str = "GD10000" + dateFormat.format(date) + "001" + "000000" + "00";// 修改为：去掉"-"
		YxPlanActionForm form = (YxPlanActionForm) actionForm;
		form.setYxplancode(str);
		form.setOperatorcode(user.getOpercode());
		form.setCheckercode(user.getOpercode());
		//默认值 是否预订 否
		form.setBookflag(new Byte("0"));
		// 设置特殊方案标志的值
		getValues(user);
		form.setSpecialflagName(this.specialflagName);
		request.setAttribute("VALUE", this.specialflagValue);
		
		//获取yxplanid
		Long seq = getYxplanSeq(actionMapping, actionForm, request, response,
				user);
		String seqString = String.valueOf(seq);
		String areacode=user.getCityid();
		if("999".equals(areacode))
			areacode="100";
		String yxplanid = areacode
				+ StringUtils.repeat("0", 11 - seqString.length()) + seq;
		form.setYxplanid(Long.valueOf(yxplanid));
		form.setAreacode(areacode);
		return super.doNew(actionMapping, actionForm, request, response, user);
	}

	public ActionForward doNewyxplanid(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		// TODO Auto-generated method stub

		String areacode = request.getParameter("hWnd");
		Long seq = getYxplanSeq(actionMapping, actionForm, request, response,
				user);
		String seqString = String.valueOf(seq);
		String yxplanid = areacode
				+ StringUtils.repeat("0", 11 - seqString.length()) + seq;
		YxPlanActionForm form = (YxPlanActionForm) actionForm;
		form.setYxplanid(Long.valueOf(yxplanid));
		form.setAreacode(areacode);
		getValues(user);
		form.setSpecialflagName(this.specialflagName);
		request.setAttribute("VALUE", this.specialflagValue);
		return (actionMapping.findForward("content"));
	}

	/**
	 * 根据营销方案区域标识生成营销方案ID，在复制页面使用
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doGenyxplanid(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		// TODO Auto-generated method stub
		try {
			String areacode = request.getParameter("hWnd");
			Long seq = getYxplanSeq(actionMapping, actionForm, request,
					response, user);
			String seqString = String.valueOf(seq);
			String yxplanid = areacode
					+ StringUtils.repeat("0", 11 - seqString.length()) + seq;
			YxPlanActionForm form = (YxPlanActionForm) actionForm;
			form.setYxplanid(Long.valueOf(yxplanid));
			form.setAreacode(areacode);
		} catch (Exception e) {
			request
					.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
							"生成营销标识出错");
		} finally {
			if (request.getAttribute("detail") == null) {
				DataPackage dp = getCopyDetail(user);
				request.setAttribute("detail", dp);
			}
		}
		// 设置特殊方案标志的值

		return (actionMapping.findForward("single"));
	}

	public ActionForward doEdit(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		getContentVO(request, user, actionForm);
		String command = getCommandString(request);
		((BaseActionForm) actionForm).setCmdState(command);
		request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,
				WebConstant.COMMAND_STRING_EDIT);
		// 设置特殊方案标志的值
		getValues(user);
		((YxPlanActionForm) actionForm)
				.setSpecialflagName(this.specialflagName);
		request.setAttribute("VALUE", this.specialflagValue);
		// 设置可办理用户状态
		if (!(((YxPlanActionForm) actionForm).getUserstausflag() == null || ""
				.equals(((YxPlanActionForm) actionForm).getUserstausflag()))) {
			((YxPlanActionForm) actionForm)
					.setSelectuserstausflag(((YxPlanActionForm) actionForm)
							.getUserstausflag().split(","));
		}
		return (actionMapping.findForward("content"));
	}

	/**
	 * 营销方案组列表显示
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 * @author added by yijianrong
	 */
	public ActionForward doGrouplist(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {

		YxPlanActionForm form = (YxPlanActionForm) actionForm;
		doQueryGroup(form, request, false, user);
		return (actionMapping.findForward("grouplist"));
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
	 * @author added by yijianrong
	 */
	public ActionForward doTree(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {

		YxPlanActionForm form = (YxPlanActionForm) actionForm;
		doQueryGroup(form, request, true, user);
		return (actionMapping.findForward("tree"));
	}

	/**
	 * 删除营销方案组
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 * @author added by yijianrong
	 */
	public ActionForward doDeletegroup(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {

		YxPlanActionForm form = (YxPlanActionForm) actionForm;
		YxPlanDelegate delegate = new YxPlanDelegate();
		YxPlanGroupDelegate groupdelegate = new YxPlanGroupDelegate();
		String[] selectArray = form.get_selectitem();

		try {
			for (int i = 0; i < selectArray.length; i++) {
				YxPlanVO vo = delegate.doFindByPk(new Long(selectArray[i]),
						user);
				groupdelegate.deleteByGroupid(vo.getYxplanid(), user);
				delegate.doRemove(vo, user);
			}
		} catch (BusinessException e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.toString());
		} catch (Exception e) {
			throw e;
		}

		return doGrouplist(actionMapping, actionForm, request, response, user);
	}

	/**
	 * 新增营销方案组
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 * @author added by yijianrong
	 */
	public ActionForward doNewgroup(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {

		YxPlanActionForm form = (YxPlanActionForm) actionForm;
		String command = getCommandString(request);
		form.setCmdState(command);
		request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, command);

		return (actionMapping.findForward("groupcontent"));
	}

	/**
	 * 编辑营销方案组
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 * @author added by yijianrong
	 */
	public ActionForward doEditgroup(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {

		YxPlanActionForm form = (YxPlanActionForm) actionForm;
		getContentVO(request, user, form);
		String command = getCommandString(request);
		form.setCmdState(command);
		request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE, command);

		return (actionMapping.findForward("groupcontent"));
	}

	/**
	 * 保存营销方案组
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 * @author added by yijianrong
	 */
	public ActionForward doSavegroup(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {

		YxPlanActionForm form = (YxPlanActionForm) actionForm;
		YxPlanVO contentVO = new YxPlanVO();
		YxPlanDelegate delegate = new YxPlanDelegate();
		setSaveVO(contentVO, form);
		// 给VO加一些必须的信息

		contentVO.setStartdate(new Date(System.currentTimeMillis()));
		contentVO.setStopdate(new Date(System.currentTimeMillis()));
		contentVO.setGroupflag(new Byte("1"));

		YxPlanVO existVO = delegate.doFindByPk(contentVO.getYxplanid(), user);
		;

		if (existVO != null) {
			BeanUtils.copyProperties(existVO, contentVO);
			contentVO = existVO;
		}

		String cmdState = form.getCmdState();
//		if(contentVO.getAreacode()==null)
//		{
//			contentVO.setAreacode(user.getCityid());
//		}
		if (existVO != null) {
			
			delegate.doUpdate(contentVO, user);
			request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,
					"EDITGROUP");
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "修改成功");
			return (actionMapping.findForward("groupcontent"));
		} else {
			delegate.doCreate(contentVO, user);
		}

		BeanUtils.copyProperties(form, contentVO);
		form.setCmdState("EDITGROUP");
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, "保存成功");
		return (actionMapping.findForward("groupcontent"));
	}

	/**
	 * 查询营销方案组，条件为groupflag=1
	 * 
	 * @param form
	 * @param request
	 * @param queryall
	 * @param user
	 * @return
	 * @throws Exception
	 * @author added by yijianrong
	 */
	private void doQueryGroup(YxPlanActionForm form,
			HttpServletRequest request, boolean queryall, User user)
			throws Exception {

		try {
			Page.setPageSize(request, form);
			YxPlanListVO listVO = new YxPlanListVO();

			if (queryall) {
				listVO.set_pagesize(null); // 全部一次性查询出来，_pagesize等参数设置为Integer.MAX_VALUE或NULL
			} else {
				setListVO(listVO, form);
			}
			listVO.set_ne_groupflag("1"); // 1为营销方案组

			YxPlanDelegate delegate = new YxPlanDelegate();
			DataPackage dp = delegate.doQuery(listVO, user);
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_LIST, dp);
		} catch (BusinessException e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * 批量导入营销方案
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 * @author added by yijianrong
	 */
	public ActionForward doBatch(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {

		return (actionMapping.findForward("batch"));
	}

	/**
	 * 上传并处理批量营销方案文件
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 * @author added by yijianrong
	 */
	public ActionForward doUpload(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {

		YxPlanActionForm form = (YxPlanActionForm) actionForm;
		FormFile inputFile = form.getInputFile();
		if (inputFile == null) {
			request
					.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
							"上传文件不能为空");
			return (actionMapping.findForward("batch"));
		}

		int sum = 0;
		int success = 0;
		int failure = 0;
		String elements = null;
		String restr = null;
		Iterator iterator = BatchProcess.getData(inputFile);
		StringBuffer result = new StringBuffer("");
		StringBuffer tmp = new StringBuffer("");
		YxPlanDelegate delegate = new YxPlanDelegate();

		while (iterator.hasNext()) {
			elements = (String) iterator.next();

			// 检查字串合法性
			String[] fields = BatchProcess.getInResult(elements);
			ResultBean resultBean = delegate.doCheck(fields, user);

			// 返回码为0表示检查通过
			if (resultBean.getCode() == 0) {
				try {
					YxPlanVO vo = delegate.buildVO(fields, user);
					if (vo != null) {
						delegate.doCreate(vo, user);
					} else {
						restr = "第" + String.valueOf(sum + 1) + "行构造营销方案对象失败";
					}
				} catch (Exception ex) {
					restr = "第" + String.valueOf(sum + 1) + "行插入数据库失败! ";
				}

				if (restr == null) {
					success++;
				} else {
					tmp.append("第").append(sum + 1).append("行记录入库时出现错误！\r\n");
					tmp.append("原因：").append(restr).append("\r\n\r\n");
					failure++;
				}
			} else {
				tmp.append("第").append(sum + 1).append("行记录入库时出现错误！\r\n");
				tmp.append("原因：").append(resultBean.getInfo()).append(
						"\r\n\r\n");
				failure++;
			}
			sum++;
		}

		result.append("总共").append(sum).append("条记录，成功").append(success)
				.append("条,失败").append(failure).append("条.\r\n\r\n");
		result.append(tmp.toString());
		form.setReInfo(result.toString());
		return (actionMapping.findForward("batch"));
	}

	/**
	 * 营销方案批量导出Excel
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
	public ActionForward doExcelout(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		BaseActionForm form = (BaseActionForm) actionForm;
		// 建立查询BEAN
		ExcelOutYxPlan export = new ExcelOutYxPlan(user);

		export.setFileName("营销方案基本信息");
		request.setAttribute("creator", export);

		request.setAttribute("queryVO", actionForm);
		return actionMapping.findForward("excelout");
	}

	/**
	 * 营销方案基本信息保存
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
	public ActionForward doSave(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		YxPlanActionForm form = (YxPlanActionForm) actionForm;
		// 如果营销方案区域标识不是当前工号所在渠道,则不允许修改
		if (!user.isProvinceUser()) {
			if (null == form.getAreacode()
					|| !form.getAreacode().trim().equalsIgnoreCase(
							user.getCityid().trim())) {
				request.setAttribute(WebConstant.REQUEST_ATTRIBUTE_CMDSTATE,
						WebConstant.COMMAND_STRING_EDIT);
				String msginfo = "保存失败,当前营销方案区域标识为空或与当前工号所在区域标识不一致,不允许保存";
				request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
						msginfo);
				return (actionMapping.findForward("content"));
			}
		}
		String[] temp = form.getSelectSpecialflag();
		String result = "";
		for (int i = 0; i < temp.length; i++) {
			if (i != temp.length - 1) {
				result = result + temp[i] + ",";
			} else {
				result = result + temp[i];
			}
		}

		String[] selectuserstausflag = form.getSelectuserstausflag();
		String userstausflag = "";
		int lenght = selectuserstausflag == null ? 0
				: selectuserstausflag.length;
		for (int i = 0; i < lenght; i++) {
			if (i != lenght - 1) {
				userstausflag = userstausflag + selectuserstausflag[i] + ",";
			} else {
				userstausflag = userstausflag + selectuserstausflag[i];
			}
		}
		getValues(user);
		form.setSpecialflagName(this.specialflagName);
		request.setAttribute("VALUE", this.specialflagValue);
		form.setSpecialflag(result);
		form.setUserstausflag(userstausflag);
		return super.doSave(actionMapping, actionForm, request, response, user);
	}

	/**
	 * 上传并处理批量营销方案文件(新增)
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 * @author added by yijianrong
	 */
	public ActionForward doBatchadd(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {

		YxPlanActionForm form = (YxPlanActionForm) actionForm;
		FormFile inputFile = form.getInputFile();
		BaseCheckFormat iCheckFormat = new YxplanCheck();
		// 检查文件类型大小,表单数据类型等
		if (inputFile == null || inputFile.getFileSize() == 0) {

			form.setReInfo("上传文件不能为空");
			return (actionMapping.findForward("batch"));
		}
		iCheckFormat.checkFile(inputFile, null);
		// 检查文件每行格式
		String result = batchDisposal(inputFile, iCheckFormat, true, false,
				user);
		form.setReInfo(result);
		return (actionMapping.findForward("batch"));
	}

	/**
	 * 上传并处理批量营销方案文件
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 * @author added by yijianrong
	 */
	// public ActionForward doUpload(ActionMapping actionMapping,
	// ActionForm actionForm, HttpServletRequest request,
	// HttpServletResponse response, User user) throws Exception {
	// }
	/**
	 * 通过原始营销方案标识获得营销方案信息，生成新的营销方案标识，设置默认时间等
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 * @author Cai Jianhui
	 */
	public ActionForward doGetyxplandt(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.AM_PM, 0);
			calendar.set(Calendar.HOUR, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			Date startdate = calendar.getTime();
			calendar.add(Calendar.YEAR, 1);
			calendar.set(Calendar.HOUR, 23);
			calendar.set(Calendar.MINUTE, 59);
			calendar.set(Calendar.SECOND, 59);
			Date stopdate = calendar.getTime();

			YxPlanActionForm form = (YxPlanActionForm) actionForm;
			YxPlanDelegate delegate = new YxPlanDelegate();
			YxPlanVO planVO = delegate.doFindByPk(form.getOrgyxplanid(), user);
			String areacode = user.getCityid();
			if (areacode == null || areacode.trim().length() == 0) {
				throw new BusinessException("", "营销方案区域标识为空");
			}
			Long seq = getYxplanSeq(actionMapping, actionForm, request,
					response, user);
			String seqString = String.valueOf(seq);
			if("999".equals(areacode))
				areacode="100";
			String yxplanid = areacode
					+ StringUtils.repeat("0", 11 - seqString.length()) + seq;

			BeanUtils.copyProperties(form, planVO);
			form.setAreacode(areacode);
			form.setYxplanid(new Long(yxplanid));
			form.setYxplanname("");
			form.setStartdate(startdate);
			form.setStopdate(stopdate);
			// 还原特殊方案标志的值
			getValues(user);
			form.setSpecialflagName(this.specialflagName);
			request.setAttribute("VALUE", this.specialflagValue);
			String[] strResult = revertValues(form.getSpecialflag());
			form.setSelectSpecialflag(strResult);
			
			if (!(((YxPlanActionForm) actionForm).getUserstausflag() == null || ""
					.equals(((YxPlanActionForm) actionForm).getUserstausflag()))) {
				((YxPlanActionForm) actionForm)
						.setSelectuserstausflag(((YxPlanActionForm) actionForm)
								.getUserstausflag().split(","));
			}
			
			if (!(form.getSpecialflag() == null || ""
					.equals(form.getSpecialflag()))) {
				if(form.getSpecialflag().indexOf(",")>0){
					form
					.setSelectSpecialflag(((YxPlanActionForm) actionForm)
							.getSpecialflag().split(","));
				}else{
					form
					.setSelectSpecialflag(new String[]{form.getSpecialflag()});
				}
				
			}
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
		} finally {
			if (request.getAttribute("detail") == null) {
				DataPackage dp = getCopyDetail(user);
				request.setAttribute("detail", dp);
			}
		}
		return actionMapping.findForward("single");
	}

	/**
	 * 营销方案单个复制
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ActionForward doSinglecopy(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		try {
			YxPlanDelegate delegate = new YxPlanDelegate();
			YxPlanVO vo = new YxPlanVO();
			YxPlanActionForm form = (YxPlanActionForm) actionForm;
			String oldid = form.getOrgyxplanid().toString();
			String copyitem = form.getCopyitem();
			/*
			 * 处理[特殊方案标志]的值
			 */
			String[] temp = form.getSelectSpecialflag();
			String result = "";
			for (int i = 0; i < temp.length; i++) {
				if (i != temp.length - 1) {
					result = result + temp[i] + ",";
				} else {
					result = result + temp[i];
				}
			}
			// 处理[可办理用户状态]的值
			String[] selectuserstausflag = form.getSelectuserstausflag();
			String userstausflag = "";
			int lenght = selectuserstausflag == null ? 0
					: selectuserstausflag.length;
			for (int i = 0; i < lenght; i++) {
				if (i != lenght - 1) {
					userstausflag = userstausflag + selectuserstausflag[i]
							+ ",";
				} else {
					userstausflag = userstausflag + selectuserstausflag[i];
				}
			}
			form.setUserstausflag(userstausflag);

			getValues(user);
			form.setSpecialflagName(this.specialflagName);
			request.setAttribute("VALUE", this.specialflagValue);
			form.setSpecialflag(result);

			BeanUtils.copyProperties(vo, form);
			vo.setOperatorcode(user.getOpercode());
			delegate.doSinglecopy(oldid, copyitem, vo, true, "", user);

			IntegrationBean integrationBean = new IntegrationBean(user);

			String huaweiIP = integrationBean.getHuaweiIP();
			String huaweiPort = integrationBean.getHuaweiPort();
			String huaweiWebRoot = integrationBean.getHuaweiWebRoot();

			if (huaweiWebRoot == null)
				huaweiWebRoot = "/boss";
			String huaweiContextPath = huaweiIP != null ? "http://" + huaweiIP
					: ""; /* fixed value by huawei */
			if (huaweiIP != null && huaweiPort != null
					&& !"80".equals(huaweiPort))
				huaweiContextPath = huaweiContextPath + ":" + huaweiPort;
			huaweiContextPath = huaweiContextPath + huaweiWebRoot;

			String url = huaweiContextPath + "/product/privilegeCopyAction.do"
					+ "?actionType=queryInit&yxplanid=" + oldid.toString()
					+ "&newyxplanid=" + vo.getYxplanid().toString();
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
					"主表已复制完成，部分明细表未复制完成，结果如下，请点击下一步继续进行余下的复制操作");
			request.setAttribute("copyitem", copyitem.split(","));
			request.setAttribute("url", url);
		} catch (Exception e) {
			request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE, e
					.getMessage());
			return actionMapping.findForward("single");
		} finally {
			if (request.getAttribute("detail") == null) {
				DataPackage dp = getCopyDetail(user);
				request.setAttribute("detail", dp);
			}
		}
		return actionMapping.findForward("copyresult");
	}

	public ActionForward doSingle(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		if (request.getAttribute("detail") == null) {
			DataPackage dp = getCopyDetail(user);
			request.setAttribute("detail", dp);
		}
//		默认值 是否预订 否
		((YxPlanActionForm)actionForm).setBookflag(new Byte("0"));
		// 设置特殊方案标志
		getValues(user);
		((YxPlanActionForm) actionForm)
				.setSpecialflagName(this.specialflagName);
		request.setAttribute("VALUE", this.specialflagValue);
		return actionMapping.findForward("single");
	}

	public DataPackage getCopyDetail(User user) throws Exception {
		DictitemDelegate delegate = new DictitemDelegate();
		DictitemListVO listVO = new DictitemListVO();
		listVO.set_se_groupid("PC_YXPLANCOPYITEM");
		listVO.set_pageno(null);
		listVO.set_pagesize(null);
		DataPackage dp = delegate.doQuery(listVO, user);
		return dp;
	}

	/**
	 * 上传并处理批量营销方案文件(修改)
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 * @author added by yijianrong
	 */
	public ActionForward doBatchupdate(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		YxPlanActionForm form = (YxPlanActionForm) actionForm;
		FormFile inputFile = form.getInputFile();
		BaseCheckFormat iCheckFormat = new YxplanCheck();
		// 检查文件类型大小,表单数据类型等
		if (inputFile == null || inputFile.getFileSize() == 0) {
			// iCheckFormat.checkFile(inputFile,null);
			// request.setAttribute(WebConstant.PAGE_ATTRIBUTE_MESSAGE,
			// "上传文件不能为空");
			form.setReInfo("上传文件不能为空");
			return (actionMapping.findForward("batch"));
		}
		iCheckFormat.checkFile(inputFile, null);
		// 检查文件每行格式
		String result = "";
		// 判断是否为自定义更新
		if ("2".equals(form.getBatchaction())) {
			result = batchDisposal(inputFile, iCheckFormat, false, true, user);
		} else {
			result = batchDisposal(inputFile, iCheckFormat, false, false, user);
		}
		form.setReInfo(result);
		return (actionMapping.findForward("batch"));
	}

	/**
	 * 批量处理
	 */
	private String batchDisposal(FormFile file, BaseCheckFormat iCheckFormat,
			boolean iscreate, boolean iscustom, User user) throws Exception {
		InputStream stream = file.getInputStream();
		InputStreamReader read = new InputStreamReader(stream, "gbk");
		BufferedReader rin = new BufferedReader(read);
		String line;
		String filetitle = null;// 文件头
		int count = 0;// 记录当前检查到的行数
		StringBuffer result = new StringBuffer("");
		YxPlanDelegate delegate = new YxPlanDelegate();
		try {
			while ((line = rin.readLine()) != null) {
				if (line.trim().length() > 0) {
					++count;
					if (count == 1 && iscustom) {// 如果是第一行给文件头赋值
						filetitle = line;
					}
					try {
						// 自定义更新
						if (iscustom && count == 1) {
							 checkHead(line);
						}
						if (iscustom && count > 1) {
							line = buildLine(filetitle, line);
							iCheckFormat.checkLine(line, count, iscustom, user);
						}
						// 检查数据格式
						if (!iscustom || (iscustom && count > 1)) {
							iCheckFormat.checkLine(line, count, iscustom, user);
						}
					} catch (Exception ex) {
						result.append("第 " + count + " 条记录格式不正确："
								+ ex.getMessage() + "\r\n");
						continue;
					}
					// 新增营销方案分组成员
					try {
						if (iscreate)
							delegate.doBatchCreate(buildVO(line, user,
									new YxPlanVO()), user);
						else if (!iscustom || (iscustom && count > 1)) {
							String pk=line.substring(0,line.indexOf("|"));
							YxPlanVO vo = delegate.doFindByPk(new Long(pk.trim()), user);
							if(vo==null)
							{
								throw new Exception("营销方案ID: "+pk+"在库表中不存在");
							}
							delegate.doBatchUpdate(buildVO(line, user, vo),
									user);
						}
					} catch (Exception ex) {
						result.append("第 " + count + " 条" + ex.getMessage()
								+ "\r\n");
						ex.printStackTrace();
					}
				}
			}
		} catch (Exception ex) {

		} finally {
			rin.close();
			read.close();
		}
		if (result.toString().equals(""))
			if (iscreate)
				result.append("记录已全部新增成功");
			else
				result.append("记录已全部更新成功");
		return result.toString();
	}
	/**
	 * 自定义修改时检查文件头
	 * 
	 * @param filetitle
	 * @param line
	 * @param count
	 * @return 
	 * @throws Exception
	 */
	public void checkHead(String line) throws Exception {
		String batchtile = "营销方案标识|营销方案名称|全省标识|启动日期|停用日期|区域标识|是否需要捆绑套餐|捆绑期|是否允许预约|可享用次数|最小优惠周期数|优惠起算偏移量|起算时间单元|生效时间规则|营销方案分组标识|是否备份|是否打印到受理单|是否算费优惠|是否营业费优惠|是否网外成员优惠|来源|营销类别|营销方案类别|上传算费方案类别|优惠范围|套餐类型|月结扣费优先级|固定费特殊标识|特殊方案标志|是否用户状态检查|可办理用户状态|资费说明|说明|优惠属性|优惠活动短名称|套餐有效周期";
		String []batchtiles=StringUtils.splitPreserveAllTokens(batchtile, "|");
		String []beCheckedLine= StringUtils.splitPreserveAllTokens(line, "|");
		for(int i=0;i<beCheckedLine.length;i++)
		{
			boolean find = false;
			for(int j=0;j<batchtiles.length;j++)
			{
				if ("".equals(beCheckedLine[i].trim())) {
					throw new BusinessException("", "自定义文件头中不允许有空,且最后一行没有竖线");
				}
				if (beCheckedLine[i].trim().equals(batchtiles[j])) {
					find = true;
					continue;
				}
			}
			if (!find) {
				throw new BusinessException("", "自定义文件头: " + beCheckedLine[i] + " 不正确!");
			}
		}
	}
	/**
	 * 自定义修改时根据文件头构建与批量修改一致的字符串
	 * 
	 * @param filetitle
	 * @param line
	 * @param count
	 * @return String
	 * @throws Exception
	 */
	public String buildLine(String filetitle, String line) throws Exception {
		String result = "";
		// 全量文件头
		String batchtile = "营销方案标识|营销方案名称|全省标识|启动日期|停用日期|区域标识|是否需要捆绑套餐|捆绑期|是否允许预约|可享用次数|最小优惠周期数|优惠起算偏移量|起算时间单元|生效时间规则|营销方案分组标识|是否备份|是否打印到受理单|是否算费优惠|是否营业费优惠|是否网外成员优惠|来源|营销类别|营销方案类别|上传算费方案类别|优惠范围|套餐类型|月结扣费优先级|固定费特殊标识|特殊方案标志|是否用户状态检查|可办理用户状态|资费说明|说明|优惠属性|优惠活动短名称|套餐有效周期";
		String[] batchtiles = StringUtils
				.splitPreserveAllTokens(batchtile, "|");
		String[] resultline = new String[batchtiles.length];
		try {
			String[] filetitles = StringUtils.splitPreserveAllTokens(filetitle,
					"|");
			String[] lines = StringUtils.splitPreserveAllTokens(line, "|");
			if (filetitles.length == lines.length) {
				for (int i = 0; i < filetitles.length; i++) {
					for (int j = 0; j < batchtiles.length; j++) {
						if (filetitles[i].trim().equals(batchtiles[j].trim())) {
							resultline[j] = lines[i];
						}
					}
				}
			} else {
				throw new BusinessException("", "长度与文件头定义长度不一致!");
			}
			// 构建返回字符串
			for (int i = 0; i < resultline.length; i++) {
				String str = resultline[i] == null ? "" : resultline[i];
				if (i != resultline.length - 1) {
					result = result + str + "|";
				} else {
					result = result + str;
				}

			}
		} catch (Exception e) {
			String msg = e.getMessage();
			e.printStackTrace();
			throw new BusinessException("", msg);

		}
		return result;
	}

	private DictitemDelegate gotDelegate() throws Exception {
		if (dictDelegate == null) {
			return new DictitemDelegate();
		} else {
			return dictDelegate;
		}
	}

	/**
	 * 根据字符串构造YxPlanVO
	 * 
	 * @param fields
	 * @param user
	 * @return
	 * @throws Exception
	 *             营销方案标识0|营销方案名称1|全省标识2|启动日期3|停用日期4|区域标识5|
	 *             是否需要捆绑套餐8|捆绑期9|是否允许预约10|可享用次数11|最小优惠周期数12|优惠起算偏移量13|
	 *             起算时间单元14|生效时间规则15|营销方案分组标识16|是否备份17|是否打印到受理单18|
	 *             是否算费优惠19|是否营业费优惠20|是否网外成员优惠21|来源22|营销类别23|
	 *             营销方案类别24|上传算费方案类别25|@特殊方案标志26@|优惠范围27| *新加字段:05-11* 28
	 *             套餐类型|29 月结扣费优先级| 固定费特殊标识30|资费说明31|说明32|优惠属性33
	 *             最低消费额6|最低消费跨越周期7|
	 */
	public YxPlanVO buildVO(String line, User user,YxPlanVO result) throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			String[] fields = StringUtils.splitPreserveAllTokens(line, "|");
			if(hasValue(fields[0]))
			result.setYxplanid(new Long(fields[0].trim()));// 营销方案标识
			if(hasValue(fields[1]))
			result.setYxplanname(fields[1].trim());// 营销方案名称
			if(hasValue(fields[2]))
			result.setYxplancode(fields[2].trim());// 全省标识
			if (!"".equals(fields[3].trim())) {
				result.setStartdate(format.parse(fields[3].trim()));// 启动日期
			}
			if (!"".equals(fields[4].trim())) {
				result.setStopdate(format.parse(fields[4].trim()));// 停用日期
			}
			result.setCheckercode(user.getOpercode());// 审批人工号
			result.setOperatorcode(user.getOpercode());// 操作员工号
			if (fields[5].trim().length() > 0)
				result.setAreacode(fields[5].trim());// 区域标识
//			if (fields[6].trim().length() > 0)
//				result.setMinconsume(new Double(fields[6].trim()));// 最低消费额
//			if (fields[7].trim().length() > 0)
//				result.setConsumecycle(new Long(fields[7].trim()));// 最低消费跨越周期
			if (fields[8-2].trim().length() > 0)
				result.setBindpackageflag(new Byte(fields[8-2].trim()));// 是否需要捆绑套餐
			if (fields[9-2].trim().length() > 0)
				result.setBindmonths(new Long(fields[9-2].trim()));// 捆绑期
			if (fields[10-2].trim().length() > 0)
				result.setBookflag(new Byte(fields[10-2].trim()));// 是否允许预约
			// if (fields[11].trim().length()>0) result.setRcprepayflag(new
			// Byte(fields[11]));//是否预收月租
			if (fields[11-2].trim().length() > 0)
				result.setCouldusetimes(new Long(fields[11-2].trim()));// 可享用次数
			if (fields[12-2].trim().length() > 0)
				result.setMindisccycle(new Long(fields[12-2].trim()));// 最小优惠周期数
			if (fields[13-2].trim().length() > 0)
				result.setDiscoffset(new Long(fields[13-2].trim()));// 优惠起算偏移量
			if (fields[14-2].trim().length() > 0)
				result.setTimeunit(fields[14-2].trim());// 起算时间单元
			if (fields[15-2].trim().length() > 0)
				result.setStarttimetype(new Byte(fields[15-2].trim()));// 生效时间规则
			if (fields[16-2].trim().length() > 0)
				result.setYxplangroupid(new Long(fields[16-2].trim()));// 营销方案分组标识
			result.setGroupflag(new Byte("0"));// 是否营销方案组
			if (fields[17-2].trim().length() > 0)
				result.setBackupflag(new Byte(fields[17-2].trim()));// 是否备份
			if (fields[18-2].trim().length() > 0)
				result.setPrintflag(new Byte(fields[18-2].trim()));// 是否打印到受理单
			if (fields[19-2].trim().length() > 0)
				result.setFeecalcprivflag(new Byte(fields[19-2].trim()));// 是否算费优惠
			if (fields[20-2].trim().length() > 0)
				result.setRecfeeprivflag(new Byte(fields[20-2].trim()));// 是否营业费优惠
			// if (fields[22].trim().length()>0) result.setStopuserrentflag(new
			// Byte(fields[22]));//停机状态是否收取月租费
			if (fields[21-2].trim().length() > 0)
				result.setIsoutmemberpriv(new Byte(fields[21-2].trim()));// 是否网外成员优惠
			if (fields[22-2].trim().length() > 0)
				result.setSource(fields[22].trim());// 来源
			if (fields[23-2].trim().length() > 0)
				result.setSalestype(new Long(fields[23-2].trim()));// 营销类别
			if (fields[24-2].trim().length() > 0)
				result.setPlankind(fields[24-2].trim());// 营销方案类别
			if (fields[24-2].trim().length() > 0) {
				result.setPlanbigkind(getDescription(fields[24-2].trim(), user));
			} else if ("".equals(fields[24-2].trim())) {
				result.setPlanbigkind(null);
			}
			if (fields[25-2].trim().length() > 0)
				result.setUploadcalcfeekind(new Byte(fields[25-2].trim()));// 上传算费方案类别
			if (fields[26-2].trim().length() > 0)
				result.setDiscscope(fields[26-2].trim());// 优惠范围
			// 5-11 add
			if (fields[27-2].trim().length() > 0)
				result.setPlantype(fields[27-2].trim());// 优惠范围
			if (fields[28-2].trim().length() > 0)
				result.setFeeprio(new Byte(fields[28-2].trim()));// 优惠范围
			if (fields[29-2].trim().length() > 0)
				result.setFixfeespecflag(fields[29-2].trim());// 固定费特殊标识
			if (fields[30-2].trim().length() > 0)
				result.setSpecialflag(fields[30-2].trim());// 特殊方案标志

			// 增加是否用户状态检查&可办理用户状态检查
			if (fields[31-2].trim().length() > 0)
				result.setCheckus(new Short(fields[31-2].trim()));// 是否用户状态检查
			if (fields[32-2].trim().length() > 0)
				result.setUserstausflag(fields[32-2].trim());// 可办理用户状态

			if (fields[33-2].trim().length() > 0)
				result.setFeecomment(fields[33-2].trim());// 资费说明
			if (fields[34-2].trim().length() > 0)
				result.setRemark(fields[34-2].trim());// 说明
			if(fields[33].trim().length()>0)
				result.setPrivelgepro(fields[33].trim());
			if(fields[34].trim().length()>0)
				result.setYxplanshortname(fields[34].trim());
			if(fields[35].trim().length()>0)
				result.setUsedbillcyc(Long.valueOf(fields[35].trim()));
			return result;
		} catch (Exception e) {
			String msg = "内部错误，buildVO组装异常!" + e.getMessage();
			e.printStackTrace();
			throw new BusinessException("", msg);

		}
	}

	private Short getDescription(String dictid, User user) throws Exception {
		DictitemListVO listVO = new DictitemListVO();
		listVO.set_se_dictid(dictid);
		listVO.set_se_groupid("PC_YXPLANKIND");
		Collection col = gotDelegate().doQuery(listVO, user).getDatas();
		Iterator it = col.iterator();
		if (it.hasNext()) {
			DictitemVO dictVO = (DictitemVO) it.next();
			return new Short(dictVO.getDescription());
		} else {
			throw new Exception("固定参数[营销方案类别]的值: " + dictid + " 不正确:");
		}

	}

	/**
	 * 填充固定参数[特殊方案标志]$PC_SPECIALPLAN为一个数组
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public String[] listName(User user, String ValueOrName) throws Exception {
		String[] strResult;
		DictitemListVO listVO = new DictitemListVO();
		listVO.set_se_groupid("PC_SPECIALPLAN");
		listVO.set_orderby("dictid");
		listVO.set_desc("0");
		DataPackage dataPack = gotDelegate().doQuery(listVO, user);
		if (dataPack.getRowCount() >= 0) {
			Collection col = dataPack.getDatas();
			Iterator it = col.iterator();
			strResult = new String[dataPack.getRowCount()];
			if ("value".equals(ValueOrName)) {
				for (int i = 0; i < dataPack.getRowCount(); i++) {
					strResult[i] = ((DictitemVO) it.next()).getDictid();
				}
			} else if ("name".equals(ValueOrName))
				for (int i = 0; i < dataPack.getRowCount(); i++) {
					strResult[i] = ((DictitemVO) it.next()).getDictname();
				}
			else {
				throw new BusinessException("", "调用参数传递错误!");
			}
			return strResult;
		} else {
			throw new BusinessException("", "固定参数[特殊方案标志]没有值!");
		}

	}

	/**
	 * 取值
	 * 
	 * @param user
	 * @throws Exception
	 */
	private void getValues(User user) throws Exception {
		if (this.specialflagValue == null) {
			this.specialflagValue = listName(user, "value");
		}
		if (this.specialflagName == null) {
			this.specialflagName = listName(user, "name");
		}
	}

	/**
	 * 把传到checkBox的值特殊处理一下,还原 [特殊方案标志]值到原来的位置并且把空位置填充上" " 值
	 * 
	 * @param aStr
	 * @return
	 */
	private String[] revertValues(String aStr) {
		if (aStr != null) {
			String strTmp[] = StringUtils.split(aStr, ",");
			String result[] = new String[this.specialflagValue.length];
			for (int i = 0; i < this.specialflagValue.length; i++) {
				boolean abool = false;
				for (int j = 0; j < strTmp.length; j++) {
					if (this.specialflagValue[i].equals(strTmp[j])) {
						result[i] = specialflagValue[i];
						abool = true;
					}
				}
				if (!abool) {
					result[i] = " ";
				}
				abool = false;
			}
			return result;
		} else {
			String[] strNoValues = new String[this.specialflagValue.length];
			return strNoValues;
		}

	}

	/*
	 * 屏蔽掉，用时再放开 protected void getContentVO(HttpServletRequest request, User
	 * user, ActionForm actionForm) throws Exception {
	 * 
	 * String pk = request.getParameter(WebConstant.REQUEST_ATTRIBUTE_PK); if
	 * (pk == null) throw new NullPointerException("pk is required."); YxPlanVO
	 * contentVO = (YxPlanVO) (getContentVO(request, user)); if (contentVO ==
	 * null) throw new NullPointerException("VO not found, pk " + pk + " of " +
	 * ClassUtils.getShortClassName(actionForm.getClass())); YxPlanActionForm
	 * form = (YxPlanActionForm) actionForm; // 还原[特殊方案标志]的值 getValues(user);
	 * form.setSpecialflagName(this.specialflagName);
	 * request.setAttribute("VALUE", this.specialflagValue); String[] strResult =
	 * revertValues(contentVO.getSpecialflag());
	 * form.setSelectSpecialflag(strResult);
	 * BeanUtils.copyProperties(actionForm, contentVO); }
	 */
	/**
	 * 翻译[特殊方案标志]
	 * 
	 * @param values
	 * @param user
	 * @return
	 * @throws Exception
	 */
	private String transSpecialFlag(String values, User user) throws Exception {
		getValues(user);
		String result = "";
		if (values != null) {
			String strValue[] = StringUtils.split(values, ",");
			for (int i = 0; i < strValue.length; i++) {
				for (int j = 0; j < this.specialflagValue.length; j++) {
					if (this.specialflagValue[j].equals(strValue[i])) {
						result = result + this.specialflagName[j] + ",";
					}
				}
			}
			return result.substring(0, result.length() - 1);
		} else {
			return "";
		}
	}

	/**
	 * 取出dp的值来做翻译
	 * 
	 * @param dp
	 * @param user
	 * @return
	 * @throws Exception
	 */
	private DataPackage dealDate(DataPackage dp, User user) throws Exception {
		DataPackage dp2 = new DataPackage();
		dp2.setPageNo(dp.getPageNo());
		dp2.setPageSize(dp.getPageSize());
		dp2.setRowCount(dp.getRowCount());
		Collection col = dp.getDatas();
		Iterator it = col.iterator();
		Collection col2 = new ArrayList();
		while (it.hasNext()) {
			YxPlanVO vo = (YxPlanVO) it.next();
			if (vo.getSpecialflag() != null
					&& !"".equals(vo.getSpecialflag().trim())) {
				vo.setSpecialflag(transSpecialFlag(vo.getSpecialflag(), user));
			}
			col2.add(vo);
		}
		dp2.setDatas(col2);
		return dp2;
	}

	public ActionForward doChangebig(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		YxPlanActionForm form = (YxPlanActionForm) actionForm;
		request.setAttribute("FLAG", form.get_ne_planbigkind());
		if (AAUtils.isAjaxRequest(request)) {
			AAUtils.addZonesToRefresh(request, "big");
		}
		return (actionMapping.findForward("list"));
	}

	public ActionForward doChangebig2(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		YxPlanActionForm form = (YxPlanActionForm) actionForm;
		request.setAttribute("FLAG", form.getPlanbigkind());
		if (AAUtils.isAjaxRequest(request)) {
			AAUtils.addZonesToRefresh(request, "big");
		}
		return (actionMapping.findForward("content"));
	}
	public static void main(String []args)
	{
		String str="营销方案标识|营销方案名称|全省标识|启动日期|停用日期|区域标识|是否需要捆绑套餐|捆绑期|是否允许预约|可享用次数|最小优惠";
		String pk=str.substring(0,str.indexOf("|"));
		System.out.println(str.indexOf("|"));
		System.out.println(pk);
	}
	private boolean hasValue(String str)
	{
		return !StringUtils.isBlank(str);
	}
}
