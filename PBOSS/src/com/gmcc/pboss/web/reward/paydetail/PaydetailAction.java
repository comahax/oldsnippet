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

	// ���pagesizeΪ0����ʾ����ҳ��ֻ��1ҳ
	private final static String NG_PAGESIZE = "0";

	// Ĭ�ϵķ�ҳ��С
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
			setErrorLog("���ݿ����Ӵ��� \n" + e.getMessage());
		} catch (Exception e) {
			setErrorLog("�������� \n" + e.getMessage());
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
			setErrorLog("���ݿ����Ӵ��� \n" + e.getMessage());
		} catch (Exception e) {
			setErrorLog("�������� \n" + e.getMessage());
		}
		
		
		
		return doList();
	}

	public String doSave() {

		PaydetailForm form = (PaydetailForm)getForm();
		
		
		String wayid = form.getWayid();
		
		if (StringUtils.isEmpty(wayid)) {
			super.addActionError("�������벻��Ϊ��");
			this.CMD = getCMD();
			return "content";
		}
		try {
			Way way = (Way)BOFactory.build(WayBO.class, getDBAccessUser());
			
			if (way.doFindByPk(wayid) == null) {
				super.addActionError("������������BOSS�������룬�������������Ƿ���ȷ");
				this.CMD = getCMD();
				return "content";
			}
			
			String opmonth = form.getOpmonth();
			boolean flag = DateUtil.chkIfYmFormat(opmonth);
			if (!flag) {
				super.addActionError("��ҵ���¡�" + opmonth + "����ʽ����,ӦΪyyyyMM");
				this.CMD = getCMD();
				return "content";
			}
			
			String calcmonth = form.getCalcmonth();
			flag = DateUtil.chkIfYmFormat(calcmonth);
			if (!flag) {
				super.addActionError("�ý����¡�" + calcmonth + "����ʽ����,ӦΪyyyyMM");
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
			setActionMessage("�����ɹ�!");
		} catch (SQLException e) {
			setErrorLog("���ݿ����Ӵ��� \n" + e.getMessage());
		} catch (Exception e) {
			setErrorLog("�������� \n" + e.getMessage());
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
		export.setFileName("�겹��ϸ������");
		
		export.addOutputProperty("wayid", "��������");
		//��������, ��δ֪����  ǰ�˲����Ѿ��޶�
		export.addOutputProperty("wayid", "��������",export.CODE2NAME,"#WAY");
		export.addOutputProperty("mobile", "IMEI/����");
		export.addOutputProperty("opmonth", "������");
		export.addOutputProperty("calcmonth", "������");
		
		export.voClassArray = new Class[] {PaydetailVO.class};
		
		prepareResponse(export.getFileName());
		
		export.writeTxtTitle(getResponse().getOutputStream(), new String[] {
				"��������", "��������", "IMEI/����", "������", "������"});
		super.ExportQuery(getForm(), getRequest(), getResponse(), user, export);
		return null;
		
	}
	
	/**
	 * ����ɾ��
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
			setErrorLog("���ݿ����Ӵ��� \n" + e.getMessage());
			return doList();
		} catch (Exception e) {
			setErrorLog("�������� \n" + e.getMessage());
			return doList();
		}

		PaydetailDBParam params = (PaydetailDBParam) getParam();
		//��ʹ�÷�ҳ
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
			setErrorLog("���ݿ����Ӵ��� \n" + e.getMessage());
		} catch (Exception e) {
			setErrorLog("�������� \n" + e.getMessage());
		}
		
		
		// ����ҳ��ʱ��¼�ղ���ɾ��ʱ������
		params.set_pagesize(DEFAULT_PAGESIZE);
		return doList();
	}
	
	private void setErrorLog(String error) {
		log.error(error);
		addActionError(error);
	}
			
}
