package com.gmcc.pboss.web.channel.financeway;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import com.gmcc.pboss.business.channel.way.WayDBParam;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.common.export.CommonExportBean;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.web.channel.way.WayForm;
import com.gmcc.pboss.web.channel.way.WayWebParam;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

/**
 * <p>Title: FinanceWayAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author a-biao
 * @version 1.0
 */
public class FinanceWayAction extends BaseAction {
	public FinanceWayAction() {
		super();

		this.setForm(new WayForm());
		this.setParam(new WayWebParam());

		setClsVO(WayVO.class);
		this.pkNameArray = new String[] { "wayid" };
		this.setClsControl(Way.class);
		this.setClsQueryParam(WayDBParam.class);
	}
	
	public String doList() throws Exception {
		HttpServletRequest request = getRequest();
		User user = (User) request.getSession().getAttribute(WebConstant.SESSION_ATTRIBUTE_USER);
		Way way = (Way) BOFactory.build(WayBO.class, getDBAccessUser());
		WayDBParam params = (WayDBParam)getParam();
		DataPackage dp = way.doQueryFinanceWay(params, user);
		setDp(dp);
		return "list";
	}
	
	public String doDelete() throws Exception{
		String[] selectArray = ((DBQueryParam) getParam()).get_selectitem();
		Way way = (Way) BOFactory.build(WayBO.class, getDBAccessUser());
		for (int i = 0; i < selectArray.length; i++) {
			WayVO vo = way.doFindByPk(getSelectedPK(selectArray[i]));
			vo.setWaystate(new Short("0"));
			way.doRemoveFinanc(vo);
		}
		return doList();
	}
	
	public String doSave() throws Exception{
		WayForm wayForm = (WayForm) getForm();
		Way way = (Way) BOFactory.build(WayBO.class, getDBAccessUser());
		// �ж����������ʽ
		String path = "^[a-zA-Z][a-zA-z0-9-]{0,18}$";
		Pattern pattern = Pattern.compile(path);
		Matcher matcher = pattern.matcher(wayForm.getWayid());
		if (!matcher.find()) {
			super.addActionError("���������ʽ����ȷ,ֻ������ĸ+���ֻ���-");
			return "content";
		}
		// �ж���������Ψһ��
		WayVO vo = way.doFindByPk(getSelectedPK(wayForm.getWayid()));
		if (vo != null && !CMD.equals("EDIT")) {
			super.addActionError("��" + wayForm.getWayid() + "���Ѵ��ڸ���������");
			return "content";
			
		}

		WayDBParam params = new WayDBParam();
		
		
		// �ж��������ڹ������������Ƿ����
		if (wayForm.getChainhead() != null
				&& !wayForm.getChainhead().equals("")
				&& !wayForm.getChainhead().equals("0000")) {
			params = new WayDBParam();
			params.set_se_wayid(wayForm.getChainhead());
//			params.set_se_waytype("KF");
//			params.set_se_waysubtype("DIS");
			params.set_ne_waystate("1");
			DataPackage dp = way.doQueryWayByParams(params);
			if (dp.getDatas() == null || dp.getDatas().size() == 0) {
				super.addActionError("�������ڹ����������롾" + wayForm.getChainhead() + "��������");
				return "content";
			}
		}
		
		boolean flag = wayForm.getDisabletime().before(wayForm.getStarttime());
		
		if(flag){
			//����ʱ�������ڿ�ʼʱ��
			super.addActionError("����ʱ�������ڿ�ʼʱ��");
			return "content";
			}
		//�����ڵ�������EC����
		wayForm.setWaytype("EC");
		if (CMD.equals("NEW")) {
			wayForm.setWaystate(new Short("1"));
			wayForm.setCreatetime(new Date());
			WayVO wayVO = new WayVO();
			BeanUtils.copyProperties(wayVO, wayForm);
			wayVO = way.doCreateFinance(wayVO);
			BeanUtils.copyProperties(getForm(), wayVO);
		} else if (CMD.equals("EDIT")) {
			WayVO wayVO = way.doFindByPk(getSelectedPK(wayForm.getWayid()));
			BeanUtils.copyProperties(wayVO, wayForm);
			wayVO = way.doUpdateFinanceWay(wayVO);
			BeanUtils.copyProperties(getForm(), wayVO);
		}
		this.CMD = WEB_CMD_SAVE;
		setActionMessage("�����ɹ�!");
		return "content";
	}
	
}
