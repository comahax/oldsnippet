/**
 * auto-generated code
 * Thu Sep 17 15:14:35 CST 2009
 */
package com.gmcc.pboss.web.promotion.ppzlnptnr;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.gmcc.pboss.business.channel.way.WayDBParam;
import com.gmcc.pboss.business.promotion.ppzlnptnr.PpzlnptnrDBParam;
import com.gmcc.pboss.business.promotion.ppzlnptnr.PpzlnptnrVO;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.promotion.ppzlnptnr.Ppzlnptnr;
import com.gmcc.pboss.control.promotion.ppzlnptnr.PpzlnptnrBO;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.struts2.BaseAction;

/**
 * <p>
 * Title: PpzlnptnrAction
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
 * @author
 * @version 1.0
 */
public class PpzlnptnrAction extends BaseAction {

	public PpzlnptnrAction() {
		super();

		// ���¼��������Ǳ����
		this.setForm(new PpzlnptnrForm());
		this.setParam(new PpzlnptnrWebParam());

		// ָ��VO��
		setClsVO(PpzlnptnrVO.class);
		// ָ���������飬����Ǹ�������������ָ��ȫ�������������ֶ�����
		this.pkNameArray = new String[] { "pid", "wayid" };
		this.setClsControl(Ppzlnptnr.class);
		this.setClsQueryParam(PpzlnptnrDBParam.class);

		/**
		 * ���ָ�������������ԣ���ôBaseAction��CRUD�������ָ����Delegate��һ������²���ָ��
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}

	/**
	 * ��ѯ��Ӧ������ʶ�µķ��������������
	 */
	public String doList() throws Exception {
		try {

			PpzlnptnrForm form = (PpzlnptnrForm) getForm();
			PpzlnptnrDBParam ptnrparam =(PpzlnptnrDBParam) getParam();
			PpzlnptnrBO ptnrbo = (PpzlnptnrBO) BOFactory.build(
					PpzlnptnrBO.class, getDBAccessUser());

			if (form.getPid() == null) {
				form.setPid(new Long(ServletActionContext.getRequest()
						.getParameter("param._pk")));
				form.setIsEnabled(ServletActionContext.getRequest()
						.getParameter("isActive"));
			}
			ptnrparam.set_ne_pid(form.getPid().toString());
			DataPackage ptnrdp = ptnrbo.doQuery(ptnrparam);
			if (ptnrdp != null && ptnrdp.getDatas().size() > 0) {
				this.setDp(ptnrdp);
				return "list";
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			super.addActionError(ex.getMessage());
		}
		return "list";
	}

	@Override
	public String doNew() throws Exception {
		setCMD(WEB_CMD_NEW);
		return WEB_RESULT_CONTENT;
	}

	/**
	 * ����
	 */
	public String doSave() throws Exception {

		try {
			WayBO waybo = (WayBO) BOFactory.build(WayBO.class, getDBAccessUser());
			WayDBParam wayparam = new WayDBParam();
			PpzlnptnrForm form = (PpzlnptnrForm) super.getForm();
			if ("-1".equals(form.getForMode())) {
				setActionMessage("����ѡ������ģʽ!");
				return WEB_RESULT_CONTENT;
			}
			if ("0".equals(form.getForMode())) {
				PpzlnptnrVO vo = new PpzlnptnrVO();
				PpzlnptnrBO bo = (PpzlnptnrBO) BOFactory.build(
						PpzlnptnrBO.class, getDBAccessUser());
				vo.setPid(form.getPid());
				if(("").equals(form.getWayid())){
					setActionMessage("�������벻����Ϊ��!");
					this.setCMD(WEB_CMD_NEW);
					form.setForMode("-1");
					return "content";
				}else{
					//��������
					wayparam.set_se_wayid(form.getWayid());
					wayparam.set_se_waytype("AG");
					wayparam.set_se_cityid(getDBAccessUser().getCityid());
					DataPackage waydp = waybo.doQuery(wayparam);
					if(waydp==null||waydp.getDatas().size()==0){
						setActionMessage("�������벻�Ϸ�,���Ǳ����е������������!");
						this.setCMD(WEB_CMD_NEW);
						form.setForMode("-1");
						return "content";
					}
					
						vo.setWayid(form.getWayid());
					if(bo.doFindByVO(vo)==null){
						bo.doCreate(vo);
					}else{
						setActionMessage("��ͬ�ļ�¼�Ѵ���!");
						this.setCMD(WEB_CMD_NEW);
						form.setForMode("-1");
						return "content";
					}
				}
				setActionMessage("�����ɹ�!");
				this.setCMD(WEB_CMD_SAVE);
				return "content";
			}
			if ("1".equals(form.getForMode())) {
				List<String> list = new ArrayList<String>();
				PpzlnptnrVO ppzlnptnrvo = new PpzlnptnrVO();
				PpzlnptnrBO ppzlnptnrbo = (PpzlnptnrBO) BOFactory.build(
						PpzlnptnrBO.class, getDBAccessUser());
				String countyid = form.getCountyid();
				String starlevel = form.getStarlevel();
				list = ppzlnptnrbo.doQueryWayVo(countyid, starlevel);
				if (!list.isEmpty()) {
					ppzlnptnrvo.setPid(form.getPid());
					int j = 0;
					//��������
					for (j = 0; j < list.size(); j++) {
						ppzlnptnrvo.setWayid(list.get(j).toString());
						if (ppzlnptnrbo.doFindByPk(ppzlnptnrvo) == null) {
							ppzlnptnrbo.doCreate(ppzlnptnrvo);
						}
					}
					setActionMessage("�����ɹ�!");
					this.setCMD(WEB_CMD_SAVE);
				} else {
					setActionMessage("û�з���������������ʶ!");
					return "content";
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			super.addActionError(ex.getMessage());
		}
		return "content";
	}

	/**
	 * ɾ����Ӧ������ʶ�µķ��������������
	 */
	public String doDelete() throws Exception {
		try {

			String[] selectArray = ((DBQueryParam) getParam()).get_selectitem();
			PpzlnptnrForm form = (PpzlnptnrForm) super.getForm();
			PpzlnptnrBO ptnrbo = (PpzlnptnrBO) BOFactory.build(
					PpzlnptnrBO.class, getDBAccessUser());
			PpzlnptnrDBParam ptnrparam = new PpzlnptnrDBParam();
			PpzlnptnrVO ptnrvo = new PpzlnptnrVO();
            //���û�й�ѡ��¼, ��¼��ȫ��ɾ��, ��ҳ����javascript����
			if (selectArray == null) {
				ptnrparam.set_pagesize("0");
				ptnrparam.set_ne_pid(form.getPid().toString());
				DataPackage ptnrdp = ptnrbo.doQuery(ptnrparam);
				if (ptnrdp != null && ptnrdp.getDatas().size() > 0) {
					int j = 0;
					for (j = 0; j < ptnrdp.getDatas().size(); j++) {
						ptnrvo = (PpzlnptnrVO) ptnrdp.getDatas().get(j);
						ptnrbo.doRemoveByVO(ptnrvo);
					}
					setActionMessage("��¼��ȫ��ɾ��!");
				}
				return doList();
			}
			//��ɾ���ѹ�ѡ�ļ�¼
			int i = 0;
			for (i = 0; i < selectArray.length; i++) {
				ptnrvo.setPid(form.getPid());
				ptnrvo.setWayid(selectArray[i]);
				ptnrbo.doRemoveByVO(ptnrvo);
			}
			setActionMessage("ɾ���ɹ�!");
			return doList();
		} catch (Exception ex) {
			ex.printStackTrace();
			super.addActionError(ex.getMessage());
		}
		return "list";
	}
}