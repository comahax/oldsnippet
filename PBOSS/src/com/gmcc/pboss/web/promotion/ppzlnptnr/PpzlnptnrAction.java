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

		// 以下几个方法是必须的
		this.setForm(new PpzlnptnrForm());
		this.setParam(new PpzlnptnrWebParam());

		// 指定VO类
		setClsVO(PpzlnptnrVO.class);
		// 指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称
		this.pkNameArray = new String[] { "pid", "wayid" };
		this.setClsControl(Ppzlnptnr.class);
		this.setClsQueryParam(PpzlnptnrDBParam.class);

		/**
		 * 如果指定以下两个属性，那么BaseAction的CRUD将会调用指定的Delegate，一般情况下不必指定
		 * this.setClsDelegate(ExampleDelegate.class);
		 * this.setClsQueryParam(ExampleDBParam.class);
		 */
	}

	/**
	 * 查询对应方案标识下的方案与参与者数据
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
	 * 保存
	 */
	public String doSave() throws Exception {

		try {
			WayBO waybo = (WayBO) BOFactory.build(WayBO.class, getDBAccessUser());
			WayDBParam wayparam = new WayDBParam();
			PpzlnptnrForm form = (PpzlnptnrForm) super.getForm();
			if ("-1".equals(form.getForMode())) {
				setActionMessage("请先选择新增模式!");
				return WEB_RESULT_CONTENT;
			}
			if ("0".equals(form.getForMode())) {
				PpzlnptnrVO vo = new PpzlnptnrVO();
				PpzlnptnrBO bo = (PpzlnptnrBO) BOFactory.build(
						PpzlnptnrBO.class, getDBAccessUser());
				vo.setPid(form.getPid());
				if(("").equals(form.getWayid())){
					setActionMessage("渠道代码不允许为空!");
					this.setCMD(WEB_CMD_NEW);
					form.setForMode("-1");
					return "content";
				}else{
					//单笔新增
					wayparam.set_se_wayid(form.getWayid());
					wayparam.set_se_waytype("AG");
					wayparam.set_se_cityid(getDBAccessUser().getCityid());
					DataPackage waydp = waybo.doQuery(wayparam);
					if(waydp==null||waydp.getDatas().size()==0){
						setActionMessage("渠道代码不合法,不是本地市的社会渠道代码!");
						this.setCMD(WEB_CMD_NEW);
						form.setForMode("-1");
						return "content";
					}
					
						vo.setWayid(form.getWayid());
					if(bo.doFindByVO(vo)==null){
						bo.doCreate(vo);
					}else{
						setActionMessage("相同的记录已存在!");
						this.setCMD(WEB_CMD_NEW);
						form.setForMode("-1");
						return "content";
					}
				}
				setActionMessage("操作成功!");
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
					//条件新增
					for (j = 0; j < list.size(); j++) {
						ppzlnptnrvo.setWayid(list.get(j).toString());
						if (ppzlnptnrbo.doFindByPk(ppzlnptnrvo) == null) {
							ppzlnptnrbo.doCreate(ppzlnptnrvo);
						}
					}
					setActionMessage("操作成功!");
					this.setCMD(WEB_CMD_SAVE);
				} else {
					setActionMessage("没有符合条件的渠道标识!");
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
	 * 删除对应方案标识下的方案与参与者数据
	 */
	public String doDelete() throws Exception {
		try {

			String[] selectArray = ((DBQueryParam) getParam()).get_selectitem();
			PpzlnptnrForm form = (PpzlnptnrForm) super.getForm();
			PpzlnptnrBO ptnrbo = (PpzlnptnrBO) BOFactory.build(
					PpzlnptnrBO.class, getDBAccessUser());
			PpzlnptnrDBParam ptnrparam = new PpzlnptnrDBParam();
			PpzlnptnrVO ptnrvo = new PpzlnptnrVO();
            //如果没有勾选记录, 记录将全部删除, 在页面用javascript控制
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
					setActionMessage("记录已全部删除!");
				}
				return doList();
			}
			//仅删除已勾选的记录
			int i = 0;
			for (i = 0; i < selectArray.length; i++) {
				ptnrvo.setPid(form.getPid());
				ptnrvo.setWayid(selectArray[i]);
				ptnrbo.doRemoveByVO(ptnrvo);
			}
			setActionMessage("删除成功!");
			return doList();
		} catch (Exception ex) {
			ex.printStackTrace();
			super.addActionError(ex.getMessage());
		}
		return "list";
	}
}