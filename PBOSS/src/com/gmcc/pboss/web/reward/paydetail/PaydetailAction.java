package com.gmcc.pboss.web.reward.paydetail;

import java.sql.SQLException;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gmcc.pboss.business.reward.paydetail.PaydetailDBParam;
import com.gmcc.pboss.business.reward.paydetail.PaydetailVO;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.common.utils.tools.DateUtil;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.reward.paydetail.Paydetail;
import com.gmcc.pboss.control.reward.paydetail.PaydetailBO;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;

/**
 * 
 * @author liangjiayuan
 * 
 */
public class PaydetailAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final Logger log = LoggerFactory.getLogger(PaydetailAction.class);

	// 如果pagesize为0，表示不分页，只有1页
	private final static String NG_PAGESIZE = "0";

	// 默认的分页大小
	private final static String DEFAULT_PAGESIZE = "20";

	private final static String PAYMEN_TYPE = "DB";
	public PaydetailAction() {
		super();

		this.setForm(new PaydetailForm());
		this.setParam(new PaydetailDBParam());
		this.setClsVO(PaydetailVO.class);

		this.pkNameArray = new String[] { "seq" };
		this.setClsControl(Paydetail.class);
		this.setClsQueryParam(PaydetailDBParam.class);
	}

	@SuppressWarnings("unchecked")
	public String doList() {

		
		PaydetailDBParam params = (PaydetailDBParam) getParam();
		params.set_se_type(PAYMEN_TYPE);
		fillParam(params);

		User user = (User) getDBAccessUser();
		params.getQueryConditions().put("cityid", user.getCityid());
		
		try {
			Paydetail paydetail = (Paydetail) BOFactory.build(PaydetailBO.class,
					getDBAccessUser());
			DataPackage dp = paydetail.doQuery(params);
			setDp(dp);
		} catch (SQLException e) {
			setErrorLog("数据库连接错误 \n" + e.getMessage());
		} catch (Exception e) {
			setErrorLog("其他错误 \n" + e.getMessage());
		}
		
		
		return "list";
	}

	

	public String doDelete() {
		String[] selectArray = ((DBQueryParam) getParam()).get_selectitem();
		
		try {
			Paydetail paydetail = (Paydetail) BOFactory.build(PaydetailBO.class,
					getDBAccessUser());
			
			for (int i = 0; i < selectArray.length; i++) {
				paydetail.doRemoveByPK(getSelectedPK(selectArray[i]));
			}
		} catch (SQLException e) {
			setErrorLog("数据库连接错误 \n" + e.getMessage());
		} catch (Exception e) {
			setErrorLog("其他错误 \n" + e.getMessage());
		}
		
		
		
		return doList();
	}

	public String doSave() {

		PaydetailForm form = (PaydetailForm)getForm();
		
		
		String wayid = form.getWayid();
		
		if (StringUtils.isEmpty(wayid)) {
			super.addActionError("渠道编码不能为空");
			this.CMD = getCMD();
			return "content";
		}
		try {
			Way way = (Way)BOFactory.build(WayBO.class, getDBAccessUser());
			
			if (way.doFindByPk(wayid) == null) {
				super.addActionError("渠道编码须是BOSS渠道编码，请检查渠道编码是否正确");
				this.CMD = getCMD();
				return "content";
			}
			
			String opmonth = form.getOpmonth();
			boolean flag = DateUtil.chkIfYmFormat(opmonth);
			if (!flag) {
				super.addActionError("该业务月【" + opmonth + "】格式不对,应为yyyyMM");
				this.CMD = getCMD();
				return "content";
			}
			
			String calcmonth = form.getCalcmonth();
			flag = DateUtil.chkIfYmFormat(calcmonth);
			if (!flag) {
				super.addActionError("该结算月【" + calcmonth + "】格式不对,应为yyyyMM");
				this.CMD = getCMD();
				return "content";
			}
			
			
			Paydetail paydetail = (Paydetail) BOFactory.build(PaydetailBO.class,
					getDBAccessUser());
			
			
			
			if (CMD.equals("NEW")) {
				
				PaydetailVO paydetailVO = new PaydetailVO();
				BeanUtils.copyProperties(paydetailVO, form);
				paydetailVO.setType(PAYMEN_TYPE);
				paydetailVO = paydetail.doCreate(paydetailVO);
				BeanUtils.copyProperties(getForm(), paydetailVO);
				
			} else if (CMD.equals("EDIT")) { 
				
				PaydetailVO paydetailVO = paydetail.doFindByPk(form.getSeq());
				BeanUtils.copyProperties(paydetailVO, form);
				paydetailVO.setType(PAYMEN_TYPE);
				paydetailVO = paydetail.doUpdate(paydetailVO);
				BeanUtils.copyProperties(getForm(), paydetailVO);
			}
			
			
			this.CMD = WEB_CMD_SAVE;
			setActionMessage("操作成功!");
		} catch (SQLException e) {
			setErrorLog("数据库连接错误 \n" + e.getMessage());
		} catch (Exception e) {
			setErrorLog("其他错误 \n" + e.getMessage());
		}
		
		return "content";
	}

	public void fillParam(PaydetailDBParam params) {

		String wayid = params.get_se_wayid();
		if (StringUtils.isNotEmpty(wayid)) {
			params.set_se_wayid(wayid.trim());
		}

		String calcmonth = params.get_se_calcmonth();
		if (StringUtils.isNotEmpty(calcmonth)) {
			params.set_se_calcmonth(calcmonth.trim());
		}

		String opmonth = params.get_se_opmonth();
		if (StringUtils.isNotEmpty(opmonth)) {
			params.set_se_opmonth(opmonth.trim());
		}

		String mobile = params.get_sk_mobile();
		if (StringUtils.isNotEmpty(mobile)) {
			params.set_sk_mobile(mobile.trim());
		}
	}
	
	@SuppressWarnings("static-access")
	public String doTxt() throws Exception {
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		//SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		PaydetailDBParam paydetailDBParam = (PaydetailDBParam)super.getParam();
		paydetailDBParam.setQueryAll(true);
		export.setFileName("店补明细管理导出");
		
		export.addOutputProperty("wayid", "渠道编码");
		//关联不到, 填未知渠道  前端插入已经限定
		export.addOutputProperty("wayid", "渠道名称",export.CODE2NAME,"#WAY");
		export.addOutputProperty("mobile", "IMEI/号码");
		export.addOutputProperty("opmonth", "月务月");
		export.addOutputProperty("calcmonth", "结算月");
		
		export.voClassArray = new Class[] {PaydetailVO.class};
		
		prepareResponse(export.getFileName());
		
		export.writeTxtTitle(getResponse().getOutputStream(), new String[] {
				"渠道编码", "渠道名称", "IMEI/号码", "月务月", "结算月"});
		super.ExportQuery(getForm(), getRequest(), getResponse(), user, export);
		return null;
		
	}
	
	/**
	 * 批量删除
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doBatchDelete() {
		User user = (User) getDBAccessUser();
		Paydetail paydetail = null;
		try {
			paydetail = (Paydetail) BOFactory.build(PaydetailBO.class, user);
		} catch (SQLException e) {
			setErrorLog("数据库连接错误 \n" + e.getMessage());
			return doList();
		} catch (Exception e) {
			setErrorLog("其他错误 \n" + e.getMessage());
			return doList();
		}

		PaydetailDBParam params = (PaydetailDBParam) getParam();
		//不使用分页
		params.set_pagesize(NG_PAGESIZE);
		String wayid = params.get_se_wayid();
		if (StringUtils.isNotEmpty(wayid)) {
			params.set_se_wayid(wayid.trim());
		}

		String calcmonth = params.get_se_calcmonth();
		if (StringUtils.isNotEmpty(calcmonth)) {
			params.set_se_calcmonth(calcmonth.trim());
		}

		String opmonth = params.get_se_opmonth();
		if (StringUtils.isNotEmpty(opmonth)) {
			params.set_se_opmonth(opmonth.trim());
		}

		String mobile = params.get_sk_mobile();
		if (StringUtils.isNotEmpty(mobile)) {
			params.set_sk_mobile(mobile.trim());
		}
		
		if (StringUtils.isEmpty(wayid.trim()) && StringUtils.isEmpty(calcmonth.trim()) 
				&& StringUtils.isEmpty(opmonth.trim()) && StringUtils.isEmpty(mobile.trim())) {
			return doList();
		}
		
		params.set_se_type(PAYMEN_TYPE);
		
		try {
			DataPackage dp = paydetail.doQueryBySql(params);
			
			if (dp != null && dp.getDatas() != null && !dp.getDatas().isEmpty()) {
				
				
					for (int i = 0; i < dp.getDatas().size(); i++) {
						
						PaydetailVO vo = (PaydetailVO)dp.getDatas().get(i);
						
						paydetail.doRemoveByPK(vo.getSeq());
					}
			
				
			}
		}  catch (SQLException e) {
			setErrorLog("数据库连接错误 \n" + e.getMessage());
		} catch (Exception e) {
			setErrorLog("其他错误 \n" + e.getMessage());
		}
		
		
		// 返回页面时记录刚才做删除时的条件
		params.set_pagesize(DEFAULT_PAGESIZE);
		return doList();
	}
	
	private void setErrorLog(String error) {
		log.error(error);
		addActionError(error);
	}
			
}
