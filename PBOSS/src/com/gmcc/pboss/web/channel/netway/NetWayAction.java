package com.gmcc.pboss.web.channel.netway;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

import com.gmcc.pboss.business.channel.property.PropertyDBParam;
import com.gmcc.pboss.business.channel.property.PropertyVO;
import com.gmcc.pboss.business.channel.way.WayDBParam;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.control.channel.property.Property;
import com.gmcc.pboss.control.channel.property.PropertyBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.web.channel.saleway.SalewayForm;
import com.gmcc.pboss.web.channel.way.WayForm;
import com.gmcc.pboss.web.channel.way.WayWebParam;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DBQueryParam;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;
import com.sunrise.jop.ui.struts2.BaseAction;
import com.sunrise.jop.ui.struts2.WebConstant;

/**
 * <p>Title: NetWayAction </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * @author a-biao
 * @version 1.0
 */
public class NetWayAction extends BaseAction {
	public NetWayAction() {
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
		DataPackage dp = way.doQueryNetWay(params, user);
		setDp(dp);
		return "list";
	}
	
	public String doDelete() throws Exception{
		String[] selectArray = ((DBQueryParam) getParam()).get_selectitem();
		Way way = (Way) BOFactory.build(WayBO.class, getDBAccessUser());
		for (int i = 0; i < selectArray.length; i++) {
			WayVO vo = way.doFindByPk(getSelectedPK(selectArray[i]));
			vo.setWaystate(new Short("0"));
			way.doRemoveNetWay(vo);
		}
		return doList();
	}
	
	public String doSave() throws Exception{
		WayForm wayForm = (WayForm) getForm();
		Way way = (Way) BOFactory.build(WayBO.class, getDBAccessUser());
		Property property = (Property) BOFactory.build(PropertyBO.class, getDBAccessUser());
		// 判断渠道编码格式
		String path = "^[a-zA-Z][a-zA-z0-9-]{0,18}$";
		Pattern pattern = Pattern.compile(path);
		Matcher matcher = pattern.matcher(wayForm.getWayid());
		if (!matcher.find()) {
			super.addActionError("渠道编码格式不正确,只能是字母+数字或者-");
			return "content";
		}
		// 判断渠道编码唯一性
		WayVO vo = way.doFindByPk(getSelectedPK(wayForm.getWayid()));
		if (vo != null && !CMD.equals("EDIT")) {
			super.addActionError("【" + wayForm.getWayid() + "】已存在该渠道编码");
			return "content";
			
		}

		WayDBParam params = new WayDBParam();
		
		//归属于电子渠道EC下面
		wayForm.setWaytype("EC");
		String upperwayid = wayForm.getUpperwayid();
//		WayVO upperVO = way.doFindByPk(upperwayid);
//		if (!"NET".equals(upperVO.getWaysubtype())) {
//			throw new Exception("录入的上级渠道只能是互联网渠道");
//		}
		if (CMD.equals("NEW")) {
			wayForm.setWaystate(new Short("1"));
			wayForm.setCreatetime(new Date());
			WayVO wayVO = new WayVO();  
			PropertyVO propertyVO =new PropertyVO();
			BeanUtils.copyProperties(wayVO, wayForm);
			wayVO = way.doCreateNetWay(wayVO);
			
			propertyVO.setWayid(wayForm.getWayid());
			propertyVO.setNetwaylevel(wayForm.getNetwaylevel());
			
			//propertyVO=property.doCreate(propertyVO);
			BeanUtils.copyProperties(getForm(), wayVO);
		} else if (CMD.equals("EDIT")) {
			WayVO wayVO = way.doFindByPk(getSelectedPK(wayForm.getWayid()));
			BeanUtils.copyProperties(wayVO, wayForm);
			wayVO = way.doUpdateNetWay(wayVO);
			
			PropertyVO propertyVO =new PropertyVO();
			propertyVO.setWayid(wayForm.getWayid());
			propertyVO.setNetwaylevel(wayForm.getNetwaylevel());
			
			propertyVO=property.doUpdate(propertyVO);
			BeanUtils.copyProperties(getForm(), wayVO);
		}
		this.CMD = WEB_CMD_SAVE;
		setActionMessage("操作成功!");
		return "content";
	}
	
	public String doEdit() throws Exception {
		HttpServletRequest request = getRequest();
		User user = (User) request.getSession().getAttribute(WebConstant.SESSION_ATTRIBUTE_USER);
		String wayid = request.getParameter("param._pk");
		WayForm wayForm = (WayForm) getForm();
		Way way = (Way) BOFactory.build(WayBO.class, getDBAccessUser());
		WayDBParam params = (WayDBParam)getParam();
		WayVO wayVO = (WayVO) way.doFindByPk3(wayid);
		
		Property property = (Property) BOFactory.build(PropertyBO.class, getDBAccessUser());
			//重新查询//渠道层级		
			PropertyDBParam PropertyParam = new PropertyDBParam();
			PropertyParam.set_se_wayid(wayVO.getWayid());
			DataPackage propertyDP = property.doQuery(PropertyParam);
			if(propertyDP != null && !"".equals(propertyDP)
					&& propertyDP.getDatas() != null && !"".equals(propertyDP.getDatas())
					&& propertyDP.getDatas().size() > 0){
				PropertyVO propertyVO = (PropertyVO)propertyDP.getDatas().get(0);
				
				if(propertyVO.getNetwaylevel() != null && !"".equals(propertyVO.getNetwaylevel()))
				wayVO.setNetwaylevel(propertyVO.getNetwaylevel());
			}
			
			BeanUtils.copyProperties(wayForm, wayVO);
	
			this.CMD = WEB_CMD_EDIT;
			return "content";
	}
	

}
