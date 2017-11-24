/**
 * auto-generated code
 * Wed Oct 14 17:29:02 CST 2009
 */
package com.gmcc.pboss.web.sales.disform;

import java.text.SimpleDateFormat;
import java.util.ArrayList; 
import java.util.Date; 
import java.util.List; 
import javax.servlet.http.HttpServletRequest; 
import org.apache.struts2.ServletActionContext; 
import com.gmcc.pboss.business.channel.employee.EmployeeDBParam;
import com.gmcc.pboss.business.channel.employee.EmployeeVO; 
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.sales.disform.DisformDBParam;
import com.gmcc.pboss.business.sales.disform.DisformVO;
import com.gmcc.pboss.business.sales.disform.GDisformVO;
import com.gmcc.pboss.business.sales.disform.PDisformVO;
import com.gmcc.pboss.business.sales.disform.SDisformVO;
import com.gmcc.pboss.business.sales.disform.VDisformVO; 
import com.gmcc.pboss.business.sales.order.OrderVO;
import com.gmcc.pboss.business.sales.orderresdet.OrderresdetDBParam; 
import com.gmcc.pboss.common.export.CommonExportBean;  
import com.gmcc.pboss.control.channel.employee.EmployeeBO; 
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.sales.disform.Disform;
import com.gmcc.pboss.control.sales.disform.DisformBO;
import com.gmcc.pboss.control.sales.order.OrderBO;
import com.gmcc.pboss.control.sales.orderresdet.OrderresdetBO; 
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.common.utils.lang.Code2NameUtils;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

/**
 * <p>
 * Title: DisformAction
 * </p>;
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
 * @author LiZhaoLiang
 * @version 1.0
 */
public class DisformAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String DISFORM_WAIT_OUT = "WAITOUT";

	public static final String DISFORM_WATT_DIS = "WAITDIS";

	public static final String DISFORM_DIS_ING = "DISING";

	public static final String DISFORM_DIS_OVER = "DISOVER";

	public static final String DISFORM_CANCEL = "CANCEL";

	public static final String DISFORM_WAIT_SIGN = "WAITSIGN";

	public static final String DISFORM_SIGNED = "SIGNED";

	public static final String DISFORM_REFUSE = "REFUSE";

	private boolean isValid = true;

	public DisformAction() {
		super();

		// ���¼��������Ǳ����
		this.setForm(new DisformForm());
		this.setParam(new DisformDBParam());

		// ָ��VO��
		setClsVO(DisformVO.class);
		// ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
		this.pkNameArray = new String[] { "recid" };
		this.setClsControl(Disform.class);
		this.setClsQueryParam(DisformDBParam.class);

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}

	/**
	 * ���ý���Ĭ�����͵�״̬Ϊ������
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doShow() throws Exception {
		DisformDBParam params = (DisformDBParam) getParam();
		User user = (User) super.getRequest().getSession().getAttribute(
				WebConstant.SESSION_ATTRIBUTE_USER);
		Way wayBO = (WayBO) BOFactory.build(WayBO.class, super
				.getDBAccessUser());
		WayVO wayvo = wayBO.doFindByPk(user.getWayid());

		if (null != wayvo.getCountyid() && !"".equals(wayvo.getCountyid())) {
			params.set_se_countyid(wayvo.getCountyid());
		}

		/**
		 * �޸Ĵ���ʱ��ΪĬ����ʾΪ�����00:00:00��23:59:59 modify by wangsheng 
		 * modified by LiZhaoLiang 2010-9-16
		 */
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String currentDate = format.format(new Date());
		params.set_dnl_createtime(currentDate + " 00:00:00");
		params.set_dnm_createtime(currentDate + " 23:59:59");

		params.set_se_disstate(DISFORM_WAIT_OUT);

		return this.doList();
	}

	/**
	 * ����������Դ���͵�(FX_SW_DISFORM)�Ͷ�����(FX_SW_ORDER)���в�ѯ�������ս����ʽ����չʾ��
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doList() throws Exception {
		// TODO Auto-generated method stub
		try {
			DisformDBParam params = (DisformDBParam) getParam();
			DisformBO disbo = (DisformBO) BOFactory.build(DisformBO.class,
					getDBAccessUser());
			OrderBO orderbo = (OrderBO) BOFactory.build(OrderBO.class,
					getDBAccessUser());
			DataPackage dp = disbo.doQuerydp(params);
			if (dp != null && dp.getDatas().size() > 0) {
				List<VDisformVO> list = dp.getDatas();
				for (VDisformVO vo : list) {
					// doGetOrderInfo()��ͬ��Ʒ����Ķ������������ۼӣ������ա���Ʒ����A������������Ʒ����B����������������ϡ�
					vo.setOrderinfo(orderbo.doGetOrderInfo(vo.getOrderid()));
					if (vo.getRecordtime() == null) {
						vo.setIsrecord("��");
					} else {
						vo.setIsrecord("��");
					}
				}
			}
			super.getRequest().getSession().setAttribute("DISFORMPARAMS",
					params);
			this.setDp(dp);
		} catch (Exception ex) {
			ex.printStackTrace();
			setActionMessage(ex.getMessage());
		}
		return WEB_RESULT_LIST;
	}

	/**
	 * �ֹܷ���-�������͵�Ϊ������״̬
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doConsignment() throws Exception {
		try {
			String faildisform = "";
			String faildislist = "";

			DisformBO dfbo = (DisformBO) BOFactory.build(DisformBO.class,
					getDBAccessUser());
			String[] selectArray = ((DBQueryParam) getParam()).get_selectitem();
			if (selectArray == null) {
				addActionError("�޷���ȡѡ����Ŀ��");
				return "list";
			}
			// ������ѡ�ļ�¼, �ж�״̬�Ƿ�Ϊ������
			for (int i = 0; i < selectArray.length; i++) {
				DisformVO dfvo = dfbo.doFindByPk(new Long(selectArray[i]));
				if (dfvo != null) {
					if (!DISFORM_WAIT_OUT.equals(dfvo.getDisstate())) {
						isValid = false;
						faildisform = "[" + selectArray[i] + "]";
						faildislist = faildislist + faildisform + " ";
					}
				}
			}
			// ͨ����������
			if (isValid) {
				for (int i = 0; i < selectArray.length; i++) {
					DisformVO updatevo = dfbo.doFindByPk(new Long(
							selectArray[i]));
					if (updatevo != null) {
						updatevo.setDisstate(DISFORM_WATT_DIS);
						updatevo.setStoresman(getDBAccessUser().getOprcode());
						updatevo.setOuttime(new Date());
						dfbo.doUpdateOrder(updatevo);
					}
				}
			}

			if (StringUtils.isEmpty(faildislist)) {
				setActionMessage("�����ɹ���");
			} else {
				setActionMessage("ֻ�е����͵�״̬Ϊ������ʱ��������ִ�з������������͵� " + faildislist
						+ "״̬�Ǵ�������");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			setActionMessage(ex.getMessage());
		}
		return this.doList();
	}

	/**
	 * ��������-�������͵�Ϊ������״̬
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doStartdis() throws Exception {
		try {
			String faildisform = "";
			String faildislist = "";

			DisformBO dfbo = (DisformBO) BOFactory.build(DisformBO.class,
					getDBAccessUser());
			String[] selectArray = ((DBQueryParam) getParam()).get_selectitem();
			if (selectArray == null) {
				addActionError("�޷���ȡѡ����Ŀ��");
				return "list";
			}
			// ������ѡ�ļ�¼, �ж�״̬�Ƿ�Ϊ������
			for (int i = 0; i < selectArray.length; i++) {
				DisformVO dfvo = dfbo.doFindByPk(new Long(selectArray[i]));
				if (dfvo != null) {
					if (!DISFORM_WATT_DIS.equals(dfvo.getDisstate())) {
						isValid = false;
						faildisform = "[" + selectArray[i] + "]";
						faildislist = faildislist + faildisform + " ";
					}
				}
			}
			// ͨ����������
			if (isValid) {
				for (int i = 0; i < selectArray.length; i++) {
					DisformVO updatevo = dfbo.doFindByPk(new Long(
							selectArray[i]));
					if (updatevo != null) {
						updatevo.setDisstate(DISFORM_DIS_ING);
						dfbo.doUpdate(updatevo);
					}
				}
			}

			if (StringUtils.isEmpty(faildislist)) {
				setActionMessage("�����ɹ���");
			} else {
				setActionMessage("ֻ�е����͵�״̬Ϊ������ʱ���������������Ͳ��������͵� " + faildislist
						+ "״̬�Ǵ����ͣ�");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			setActionMessage(ex.getMessage());
		}
		return this.doList();
	}

	/**
	 * �������-�������͵�Ϊ�������״̬
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doDisover() throws Exception {
		try {
			String faildisform = "";
			String faildislist = "";

			DisformBO dfbo = (DisformBO) BOFactory.build(DisformBO.class,
					getDBAccessUser());
			OrderBO orderbo = (OrderBO) BOFactory.build(OrderBO.class,
					getDBAccessUser());
			String[] selectArray = ((DBQueryParam) getParam()).get_selectitem();
			if (selectArray == null) {
				addActionError("�޷���ȡѡ����Ŀ��");
				return "list";
			}
			// ������ѡ�ļ�¼, �ж�״̬�Ƿ�Ϊ������
			for (int i = 0; i < selectArray.length; i++) {
				DisformVO dfvo = dfbo.doFindByPk(new Long(selectArray[i]));
				if (!DISFORM_DIS_ING.equals(dfvo.getDisstate())) {
					isValid = false;
					faildisform = "[" + selectArray[i] + "]";
					faildislist = faildislist + faildisform + " ";
				}
			}
			// ͨ����������
			if (isValid) {				
				for (int i = 0; i < selectArray.length; i++) {
					DisformVO updatevo = dfbo.doFindByPk(new Long(
							selectArray[i]));
					if (updatevo != null) {
						updatevo.setDisstate(DISFORM_DIS_OVER);
						dfbo.doUpdate(updatevo);
						OrderVO ordervo = orderbo.doFindByPk(updatevo
								.getOrderid());
						if (ordervo != null) {
							ordervo.setDisovertime(new Date());
							orderbo.doUpdate(ordervo);
						} 
						dfbo.dosSendMsg(updatevo);
					}
				}
			}

			if (StringUtils.isEmpty(faildislist)) {
				setActionMessage("�����ɹ���");
			} else {
				setActionMessage("ֻ�е����͵�״̬Ϊ������ʱ��������������Ͳ��������͵� " + faildislist
						+ "״̬�������У�");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			setActionMessage(ex.getMessage());
		}
		return this.doList();
	}

	/**
	 * ȷ��ǩ��
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doComfirmSign() throws Exception {
		try {
			String faildisform = "";
			String faildislist = "";
			String[] selectArray = ((DBQueryParam) getParam()).get_selectitem();
			DisformBO dfbo = (DisformBO) BOFactory.build(DisformBO.class,
					getDBAccessUser());
			OrderBO orderbo = (OrderBO) BOFactory.build(OrderBO.class,
					getDBAccessUser());
			if (selectArray == null) {
				addActionError("�޷���ȡѡ����Ŀ��");
				return "list";
			}
			for (int i = 0; i < selectArray.length; i++) {
				DisformVO dfvo = dfbo.doFindByPk(new Long(selectArray[i]));
				OrderVO ordervo = orderbo.doFindByPk(dfvo.getOrderid());
				if (ordervo != null) {
					if (!DISFORM_WAIT_SIGN.equals(ordervo.getSignstate())
							&& !DISFORM_REFUSE.equals(ordervo.getSignstate())) {
						isValid = false;
						faildisform = "[" + selectArray[i] + "]";
						faildislist = faildislist + faildisform + " ";
					}
				}
			}
			if (isValid) {
				for (int i = 0; i < selectArray.length; i++) {
					DisformVO dfvo = dfbo.doFindByPk(new Long(selectArray[i]));
					OrderVO ordervo = orderbo.doFindByPk(dfvo.getOrderid());
					if (ordervo != null) {
						ordervo.setSignstate(DISFORM_SIGNED);
						ordervo.setSigntime(new Date());
						ordervo.setSigntype("SYS");
						orderbo.doUpdate(ordervo);
						
						dfbo.doUpdateWayassistant(ordervo);
					}
				} 
				dfbo.doDealOrderBySys(selectArray);
			}   
			if (StringUtils.isEmpty(faildislist)) {
				setActionMessage("�����ɹ���");
			} else {
				setActionMessage("ֻ�д�ǩ�ջ�ܾ�ǩ��״̬������ȷ��ǩ�գ����͵�[" + faildislist
						+ "] ״̬�������飡");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			setActionMessage(ex.getMessage());
		}
		return this.doList();
	}

	/**
	 * ���͵�����
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doExcel() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) getDBAccessUser();
		CommonExportBean export = new CommonExportBean(user);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		export.setFileName("������Դ���͵�");
		export.appendHeadLine(new String[] { "��������:", user.getOprcode() });
		export
				.appendHeadLine(new String[] { "����ʱ��",
						format.format(new Date()) });
		export.addOutputProperty("recid", "���͵����");
		export.addOutputProperty("orderid", "�������");
		export.addOutputProperty("paytype", "�ɷѷ�ʽ", export.CODE2NAME,
				"$FX_PAYTYPE");
		export.addOutputProperty("discomcode", "����������", export.CODE2NAME,
				"#WAYIDINFO");
		export.addOutputProperty("countyid", "�ֹ�˾", export.CODE2NAME,
				"#CNTYCOMPANY");
		export.addOutputProperty("recewayid", "�ջ�����", export.CODE2NAME,
				"#WAYIDINFO");
		export.addOutputProperty("recewayid", "�������");
		export.addOutputProperty("recename", "�ջ�������");
		export.addOutputProperty("recetel", "�ջ��˵绰");
		export.addOutputProperty("receadd", "�ջ��˵�ַ");
		export.addOutputProperty("createtime", "����ʱ��", export.DATE,
				"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("arrivetime", "Ҫ���ʹ�ʱ��", export.DATE,
				"yyyy-MM-dd HH:mm:ss");
		export.addOutputProperty("disstate", "���͵�״̬", export.CODE2NAME,
				"$FX_DISFORMSTATE");
		export.addOutputProperty("signstate", "ǩ��״̬", export.CODE2NAME,
				"$FX_SIGNSTATE");
		export.addOutputProperty("orderinfo", "������Ϣ");
		export.addOutputProperty("actamt", "���");
		export.addOutputProperty("disovertime", "�������ʱ��");
		export.addOutputProperty("isrecord", "�Ƿ�����");
		export.addOutputProperty("memo", "��ע");

		export.voClassArray = new Class[] { VDisformVO.class };
		DisformDBParam params = (DisformDBParam) super.getParam();
		params.set_pagesize("0");
		super.setParam(params);
		request.setAttribute(WebConstant.PAGE_ATTRIBUTE_EXPORT, export);
		return super.doExcel();
	}

	/**
	 * ���͵���ϸ����
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doExportExcel() throws Exception {
		DisformForm form = (DisformForm) getForm();
		DisformBO dfBo = (DisformBO) BOFactory.build(DisformBO.class,
				getDBAccessUser());
		DisformDBParam dfParam = new DisformDBParam();
		OrderBO orderbo = (OrderBO) BOFactory.build(OrderBO.class,
				getDBAccessUser());
		OrderresdetDBParam odparam = new OrderresdetDBParam();
		OrderresdetBO odbo = (OrderresdetBO) BOFactory.build(
				OrderresdetBO.class, getDBAccessUser());
		String pk = getParam().get_pk();
		dfParam.set_ne_recid(pk);
		dfParam.set_pageno("1");
		DataPackage dp = dfBo.doQuerydp(dfParam);
		if (dp != null && dp.getDatas().size() > 0) {
			List<VDisformVO> list = dp.getDatas();
			for (VDisformVO vo : list) {
				// doGetOrderInfo()��ͬ��Ʒ����Ķ������������ۼӣ������ա���Ʒ����A������������Ʒ����B����������������ϡ�
				vo.setOrderinfo(orderbo.doGetOrderInfo(vo.getOrderid()));
			}
		}
		VDisformVO dfvo = (VDisformVO) dp.getDatas().get(0);
		BeanUtils.copyProperties(form, dfvo);

		odparam.set_se_orderid(form.getOrderid());
		odparam.set_pageno(super.getParam().get_pageno());
		// ȫ������
		odparam.setQueryAll(true);
		DataPackage detdp = odbo.doQuery(odparam);
		this.setForm(form);
		this.setDp(detdp);
		return "excelexport";
	}

	/**
	 * ��ʾ/�༭��Ӧ���͵���Ϣ�����Ӧ����ϸ��¼
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doEdit() throws Exception {
		try {
			HttpServletRequest request = getRequest();
			DisformForm form = (DisformForm) getForm();
			DisformBO dfBo = (DisformBO) BOFactory.build(DisformBO.class,
					getDBAccessUser());
			DisformDBParam dfParam = (DisformDBParam) getParam();
			OrderBO orderbo = (OrderBO) BOFactory.build(OrderBO.class,
					getDBAccessUser());
			OrderresdetDBParam odparam = new OrderresdetDBParam();
			OrderresdetBO odbo = (OrderresdetBO) BOFactory.build(
					OrderresdetBO.class, getDBAccessUser());
			String pk = getParam().get_pk();
			dfParam.set_ne_recid(pk);
			DataPackage dp = dfBo.doQuerydp(dfParam);
			if (dp != null && dp.getDatas().size() > 0) {
				List<VDisformVO> list = dp.getDatas();
				for (VDisformVO vo : list) {
					// doGetOrderInfo()��ͬ��Ʒ����Ķ������������ۼӣ������ա���Ʒ����A������������Ʒ����B����������������ϡ�
					vo.setOrderinfo(orderbo.doGetOrderInfo(vo.getOrderid()));
				}
			}
			if (dp.getDatas().size() > 0) {
				VDisformVO dfvo = (VDisformVO) dp.getDatas().get(0);
				BeanUtils.copyProperties(form, dfvo);
			}

			dfParam.set_ne_recid(null);

			odparam.set_se_orderid(form.getOrderid());
			odparam.set_pageno(super.getParam().get_pageno());
			odparam.set_pagesize("10");
			DataPackage detdp = odbo.doQuery(odparam);
			// ���͵���Ϣ��ʾ
			this.setForm(form);
			// ������ѯ����,��Session��ȡ��DBParam��ֵ
			DisformDBParam temparam = (DisformDBParam) request.getSession()
					.getAttribute("DISFORMPARAMS");
			BeanUtils.copyProperties(dfParam, temparam);
			// �趨��ҳ��Ϣ
			dfParam.set_pageno(odparam.get_pageno());
			dfParam.set_pagesize(odparam.get_pagesize());
			// ���͵���ϸ��ʾ
			this.setDp(detdp);
			this.setCMD(WEB_CMD_EDIT);
		} catch (Exception ex) {
			ex.printStackTrace();
			setActionMessage(ex.getMessage());
		}
		return WEB_RESULT_CONTENT;
	}

	/**
	 * �������͵���Ž��������ݣ��ջ����������ջ��˵绰���ջ��˵�ַ����ע�� ���µ�������Դ���͵�(FX_SW_DISFORM)
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doSave() throws Exception {
		try {
			DisformForm form = (DisformForm) getForm();
			DisformBO dfBo = (DisformBO) BOFactory.build(DisformBO.class,
					getDBAccessUser());
			OrderresdetDBParam odparam = new OrderresdetDBParam();
			OrderresdetBO odbo = (OrderresdetBO) BOFactory.build(
					OrderresdetBO.class, getDBAccessUser());

			DisformVO vo = dfBo.doFindByPk(form.getRecid());
			if (vo != null) {
				vo.setMemo(form.getMemo());
				vo.setReceadd(form.getReceadd());
				vo.setRecename(form.getRecename());
				vo.setRecetel(form.getRecetel());
				vo.setLogisticsno(form.getLogisticsno());
				vo = dfBo.doUpdate(vo);
				// ����ҳ����ʾ
				BeanUtils.copyProperties(form, vo);
				odparam.set_se_orderid(form.getOrderid());
				odparam.set_pageno(super.getParam().get_pageno());
				DataPackage detdp = odbo.doQuery(odparam);
				// ���͵���Ϣ��ʾ
				this.setForm(form);
				// ���͵���ϸ��ʾ
				this.setDp(detdp);
				this.setCMD(WEB_CMD_SAVE);
				setActionMessage("����ɹ�!");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			setActionMessage(ex.getMessage());
		}
		return "content";
	}

	/**
	 * ������ӡҳ��
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doPrint() throws Exception {
		try {
			DisformForm form = (DisformForm) getForm();
			DisformBO dfBo = (DisformBO) BOFactory.build(DisformBO.class,
					getDBAccessUser());
			DisformDBParam params = new DisformDBParam();
			params.set_se_orderid(form.getOrderid());
			DataPackage dp = dfBo.doQueryPrint(params);
			PDisformVO dfvo = (PDisformVO) dp.getDatas().get(0);
			// ҳ����ʾ
			BeanUtils.copyProperties(form, dfvo);
			DataPackage printdp = dfBo.doQueryPrintDp(params);
			List<PDisformVO> list = printdp.getDatas();
			for (PDisformVO vo : list) {
				if ("COMRESSMP".equals(vo.getRestype())
						&& "CUSTORDER".equals(vo.getOrdercomtype())) {
					vo.setComnum(dfBo.doGetBatchnoBoxnum(vo));
				} else if ("COMRESSMP".equals(vo.getRestype())
						&& !"CUSTORDER".equals(vo.getOrdercomtype())) {
					vo.setComnum(dfBo.doGetMinMaxComresid(vo));
					vo.setMemo(vo.getOrdercomtype());
				} else if ("COMRESCARD".equals(vo.getRestype())
						&& "CUSTORDER".equals(vo.getOrdercomtype())) {
					vo.setComnum(dfBo.doGetMinMaxComresid(vo));
				} else if ("COMRESCARD".equals(vo.getRestype())
						&& !"CUSTORDER".equals(vo.getOrdercomtype())) {
					vo.setComnum(dfBo.doGetMinMaxComresid(vo));
					vo.setMemo(vo.getOrdercomtype());
				}
			}
			this.setDp(printdp);
		} catch (Exception ex) {
			ex.printStackTrace();
			setActionMessage(ex.getMessage());
		}
		return "print";
	}

	/**
	 * ������ӡ����
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doBatchPrint() throws Exception {
		try {
			String[] selectArray = ((DBQueryParam) getParam()).get_selectitem();
			DisformBO dfbo = (DisformBO) BOFactory.build(DisformBO.class,
					getDBAccessUser());
			DisformDBParam params = new DisformDBParam();
			List plist = (List) new ArrayList();
			if (selectArray == null) {
				addActionError("�޷���ȡѡ����Ŀ��");
				return "list";
			}

			for (int i = 0; i < selectArray.length; i++) {
				DisformVO dfvo = dfbo.doFindByPk(new Long(selectArray[i]));
				params.set_se_orderid(dfvo.getOrderid());
				DataPackage dp = dfbo.doQueryPrint(params);
				PDisformVO pdfvo = (PDisformVO) dp.getDatas().get(0);
				DataPackage printdp = dfbo.doQueryPrintDp(params);
				List<PDisformVO> list = printdp.getDatas();
				for (PDisformVO vo : list) {
					// �Բ�ѯ�������ֵ
					vo.setOrderid(pdfvo.getOrderid());
					vo.setRecid(pdfvo.getRecid());
					vo.setDiscomcode(pdfvo.getDiscomcode());
					vo.setOrdercreatetime(pdfvo.getOrdercreatetime());
					vo.setDiscreatetime(pdfvo.getDiscreatetime());
					vo.setArrivetime(pdfvo.getArrivetime());
					vo.setRecewayid(pdfvo.getRecewayid());
					vo.setRecename(pdfvo.getRecename());
					vo.setRecetel(pdfvo.getRecetel());
					vo.setReceadd(pdfvo.getReceadd());
					vo.setStoresman(pdfvo.getStoresman());
					vo.setOuttime(pdfvo.getOuttime());
					vo.setTotalorderamt(pdfvo.getTotalorderamt());
					vo.setAllprice(pdfvo.getAllprice());
					if ("COMRESSMP".equals(vo.getRestype())
							&& "CUSTORDER".equals(vo.getOrdercomtype())) {
						vo.setComnum(dfbo.doGetBatchnoBoxnum(vo));
					} else if ("COMRESSMP".equals(vo.getRestype())
							&& !"CUSTORDER".equals(vo.getOrdercomtype())) {
						vo.setComnum(dfbo.doGetMinMaxComresid(vo));
						vo.setMemo(vo.getOrdercomtype());
					} else if ("COMRESCARD".equals(vo.getRestype())
							&& "CUSTORDER".equals(vo.getOrdercomtype())) {
						vo.setComnum(dfbo.doGetMinMaxComresid(vo));
					} else if ("COMRESCARD".equals(vo.getRestype())
							&& !"CUSTORDER".equals(vo.getOrdercomtype())) {
						vo.setComnum(dfbo.doGetMinMaxComresid(vo));
						vo.setMemo(vo.getOrdercomtype());
					}
				}
				plist.add(printdp);
			}

			DataPackage printdata = new DataPackage();
			// ������ӡ�ܽ����
			printdata.setDatas(plist);
			super.getRequest().setAttribute("dp2", printdata);
			super.getRequest().setAttribute("isPrint", true);

		} catch (Exception ex) {
			ex.printStackTrace();
			setActionMessage(ex.getMessage());
		}
		return this.doList();
	}

	/**
	 * ���ͻ��ܵ���ѯ����
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doGather() throws Exception {
		try {

			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String date = format.format(new Date());
			DisformDBParam params = (DisformDBParam) getParam();
			params.set_de_createtime(date+" 00:00:00");
			params.set_de_createtime1(date+" 23:59:59");

			User user = (User) super.getRequest().getSession().getAttribute(
					WebConstant.SESSION_ATTRIBUTE_USER);
			if(params.get_se_countyid()==null || "".equals(params.get_se_countyid())){ 
				Way wayBO = (WayBO) BOFactory.build(WayBO.class, super
						.getDBAccessUser());
				WayVO wayvo = wayBO.doFindByPk(user.getWayid());
				params.set_se_countyid(wayvo.getCountyid());
			}
		} catch (Exception ex) {
			setActionMessage(ex.getMessage());
		}
		return "gather";
	}

	/**
	 * ���ͻ��ܵ���ӡ
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doGatherPrint() throws Exception {
		try {
			Long totalnum = new Long(0);
			Long totalorincomprice = new Long(0);
			Double totalorinsellprice = new Double(0);
			User user = (User) super.getRequest().getSession().getAttribute(
					WebConstant.SESSION_ATTRIBUTE_USER);
			DisformDBParam params = (DisformDBParam) super.getParam();
			DisformForm form = (DisformForm) getForm();
			
			DisformBO dfbo = (DisformBO) BOFactory.build(DisformBO.class,
					getDBAccessUser());
			if (null == params.get_se_countyid()
					|| "".equals(params.get_se_countyid())) {
				setActionMessage("�ֹ�˾��ϢΪ�գ�������ִ�д�ӡ������");
				return "gather";
			}/*else{
					if(params.get_se_countyid().length()>0 && params.get_se_countyid().indexOf(",")!=-1){
						    int pos=params.get_se_countyid().lastIndexOf(",");
							params.set_se_countyid(params.get_se_countyid().substring(pos+1));
							params.set_se_countyid(params.get_se_countyid().trim());
					}
			}*/
			// �ֹ�˾
			form.setCountyid(params.get_se_countyid());
			// ������
			form.setDiscomcode(params.get_se_discomcode());
			// �趨��ǰ���ڷ�Χ
			if (params.get_de_createtime().equals(params.get_de_createtime1())) {
				form.setGathercreatetime(params.get_de_createtime());
				params.set_dnm_createtime(params.get_de_createtime1().trim());
				params.set_dnl_createtime(params.get_de_createtime().trim());
				params.set_de_createtime(null);
				params.set_de_createtime1(null);
			} else {
				Date ldate = new Date();
				Date mdate = new Date();
				SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-dd");
				ldate = myformat.parse(params.get_de_createtime());
				mdate = myformat.parse(params.get_de_createtime1());
				Long day = (mdate.getTime() - ldate.getTime())
						/ (1000 * 60 * 60 * 24);
				if (day >30) {
					setActionMessage("����ʱ�������ܳ���30�졣");
					return "gather";
				} else {
					form.setGathercreatetime(params.get_de_createtime() + " �� "
							+ params.get_de_createtime1());
					params.set_dnm_createtime(params.get_de_createtime1().trim());
					params.set_dnl_createtime(params.get_de_createtime().trim());
					params.set_de_createtime(null);
					params.set_de_createtime1(null);
				}
			}

			DataPackage dp = dfbo.doGatherPrintDp(params);
			if (dp != null && dp.getDatas().size() > 0) {
				List<GDisformVO> list = dp.getDatas();
				for (GDisformVO vo : list) {
					String comid = vo.getComid().toString();
					totalnum = totalnum + vo.getNum();
					vo.setComprice(dfbo.getQueryComprice(comid));
					vo.setOrincomprice(vo.getComprice() * vo.getNum());
					totalorincomprice = totalorincomprice
							+ vo.getOrincomprice();
//					vo.setSellprice(new Double(dfbo.doQuerySellingprice(vo)));
					vo.setOrinsellprice(vo.getSellprice() * vo.getNum());
					totalorinsellprice = totalorinsellprice
							+ vo.getOrinsellprice();
					vo.setMemo("");
				}
				this.setDp(dp);
			}
			EmployeeBO empbo = (EmployeeBO) BOFactory.build(EmployeeBO.class,
					getDBAccessUser());
			EmployeeDBParam empparams = new EmployeeDBParam();
			empparams.set_se_wayid(form.getDiscomcode());
			empparams.set_ne_isnet("3");
			empparams.set_ne_empstatus("0");
			DataPackage empdp = empbo.doQuery(empparams);
			if (empdp != null && empdp.getDatas().size() > 0) {
				EmployeeVO empvo = (EmployeeVO) empdp.getDatas().get(0);
				// ����������
				form.setStoresman(Code2NameUtils.code2Name("#OPERATOR", user
						.getOprcode(), user.getCityid()));
				// �ջ�������
				form.setRecename(empvo.getEmployeename());
			}
			// �ϼ�����
			form.setTotalnum(totalnum);
			// �ϼ�ԭ�۽��
			form.setTotalorincomprice(totalorincomprice);
			// �ϼ����ۼ۽��
			form.setTotalorinsellprice(totalorinsellprice);
			// ����ʱ��Ϊ��ǰĬ��ʱ��
			form.setOuttime(new Date());

		} catch (Exception ex) {
			setActionMessage(ex.getMessage());
			ex.printStackTrace();
		}
		return "gatherprint";
	}

	/**
	 * ���͵�״̬ͳ��
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doDisstateList() throws Exception {
		try {
			Long totalDisformNum = new Long(0);
			Long totalSignNum = new Long(0);
			Long totalUnsignNum = new Long(0);
			DisformForm form = (DisformForm) getForm();
			DisformDBParam params = (DisformDBParam) getParam();
			DisformDBParam signparams = new DisformDBParam();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String currentDate = format.format(new Date());
			if (StringUtils.isEmpty(params.get_dnl_createtime())
					&& StringUtils.isEmpty(params.get_dnm_createtime())) {
				params.set_dnl_createtime(currentDate + " 00:00:00");
				params.set_dnm_createtime(currentDate + " 23:59:59");
			} else {
				// ����ʱ����, ��Χ��������30��
				Date ldate = new Date();
				Date mdate = new Date();
				SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-dd");
				ldate = myformat.parse(params.get_dnl_createtime());
				mdate = myformat.parse(params.get_dnm_createtime());
				Long day = (mdate.getTime() - ldate.getTime())
						/ (1000 * 60 * 60 * 24);
				if (day > 30) {
					setActionMessage("����ʱ�������ܳ���30�졣");
					return "disstatelist";
				}
			}
			Disform dfbo = (DisformBO) BOFactory.build(DisformBO.class,
					getDBAccessUser());
			params.set_pagesize("0");
			DataPackage dp = dfbo.doQueryDisState(params);
			List<SDisformVO> list = dp.getDatas();
			if (dp.getDatas().size() > 0) {
				BeanUtils.copyProperties(signparams, params);
				for (SDisformVO vo : list) {
					signparams.set_se_countyid(vo.getCountyid());
					signparams.set_se_svccode(vo.getSvccode());
					signparams.set_se_mareacode(vo.getMareacode());
					signparams.set_se_disstate(vo.getDisstate());
					signparams.set_se_signstate("SIGNED");
					// ��ȡ��ǩ����
					DataPackage signdp = dfbo.doQuerySignnum(signparams);
					Long signnum = (Long) signdp.getDatas().get(0);
					vo.setSignnum(signnum);
					// �õ�δǩ����
					vo.setUnsignnum(vo.getNum() - signnum);
					totalDisformNum = totalDisformNum + vo.getNum();
					totalSignNum = totalSignNum + signnum;
					totalUnsignNum = totalUnsignNum + vo.getUnsignnum();
				}
				form.setTotaldisformnum(totalDisformNum);
				form.setTotalsignnum(totalSignNum);
				form.setTotalunsignnum(totalUnsignNum);
			}
			this.setForm(form);
			this.setDp(dp);
		} catch (Exception e) {
			setActionMessage(e.getMessage());
		}
		return "disstatelist";
	}

	/**
	 * ���͵�״̬ͳ��-����EXCEL
	 * 
	 * @return
	 * @throws Exception
	 */
	public String doExcelDisstate() throws Exception {
		try{
		Long totalDisformNum = new Long(0);
		Long totalSignNum = new Long(0);
		Long totalUnsignNum = new Long(0);
		Disform dfbo = (DisformBO) BOFactory.build(DisformBO.class,
				getDBAccessUser());
		DisformForm form = (DisformForm) getForm();
		DisformDBParam params = (DisformDBParam) getParam();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String currentDate = format.format(new Date());
		if (StringUtils.isEmpty(params.get_dnl_createtime())
				&& StringUtils.isEmpty(params.get_dnm_createtime())) {
			params.set_dnl_createtime(currentDate + " 00:00:00");
			params.set_dnm_createtime(currentDate + " 23:59:59");
		} else {
			// ����ʱ����, ��Χ��������30��
			Date ldate = new Date();
			Date mdate = new Date();
			SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-dd");
			ldate = myformat.parse(params.get_dnl_createtime());
			mdate = myformat.parse(params.get_dnm_createtime());
			Long day = (mdate.getTime() - ldate.getTime())
					/ (1000 * 60 * 60 * 24);
			if (day > 30) {
				return this.doDisstateList();
			}
		}
		params.set_pagesize("0");
		DataPackage dp = dfbo.doQueryDisState(params);
		List<SDisformVO> list = dp.getDatas();
		if (dp.getDatas().size() > 0) {
			for (SDisformVO vo : list) {
				params.set_se_countyid(vo.getCountyid());
				params.set_se_svccode(vo.getSvccode());
				params.set_se_mareacode(vo.getMareacode());
				params.set_se_disstate(vo.getDisstate());
				params.set_se_signstate("SIGNED");
				DataPackage signdp = dfbo.doQuerySignnum(params);
				Long signnum = (Long) signdp.getDatas().get(0);
				vo.setSignnum(signnum);
				vo.setUnsignnum(vo.getNum() - signnum);
				totalDisformNum = totalDisformNum + vo.getNum();
				totalSignNum = totalSignNum + signnum;
				totalUnsignNum = totalUnsignNum + vo.getUnsignnum();
			}
			form.setTotaldisformnum(totalDisformNum);
			form.setTotalsignnum(totalSignNum);
			form.setTotalunsignnum(totalUnsignNum);
		}
		this.setForm(form);
		this.setDp(dp);
		}catch(Exception e){
			setActionMessage(e.getMessage());
		}
		return "exceldisstate";
	}
}