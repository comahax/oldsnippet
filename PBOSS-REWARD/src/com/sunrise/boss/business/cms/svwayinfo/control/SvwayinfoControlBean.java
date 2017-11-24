package com.sunrise.boss.business.cms.svwayinfo.control;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.business.cms.common.AuditUtils;
import com.sunrise.boss.business.cms.way.control.WayControl;
import com.sunrise.boss.business.cms.way.control.WayControlBean;
import com.sunrise.boss.business.cms.way.persistent.WayDAO;
import com.sunrise.boss.business.cms.way.persistent.WayListVO;
import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.control.ControlFactory;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.ui.commons.User;

/**
 * @ejb.bean local-jndi-name="com/sunrise/boss/business/cms/svwayinfo/control/SvwayinfoControlBean"
 *           name="SvwayinfoControl" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class SvwayinfoControlBean extends AbstractControlBean implements
		SvwayinfoControl {

	public SvwayinfoControlBean() {
		// TODO Auto-generated constructor stub
	}

	private WayDAO doGetwaydao(User user) throws Exception {
		return (WayDAO) DAOFactory.build(WayDAO.class, user);
	}
	
	private WayControl doGetwayControl(User user) throws Exception{
		return (WayControl)ControlFactory.build(WayControlBean.class);
	}

	public DataPackage doQuery(WayListVO waylistvo, User user) throws Exception {
		waylistvo.set_se_waytype("ET");
		if(waylistvo.get_ne_waystate()==null){
		waylistvo.set_sql_waystate("(waystate = 1 or waystate = 0)");
		}
		Map querycondition = new HashMap();
		String basewayid = StringUtils.isEmpty(waylistvo.getBasewayid()) ? user
				.getWayid() : waylistvo.getBasewayid();
		querycondition.put("basewayid", basewayid);
		waylistvo.setQueryConditions(querycondition);
		return this.doGetwaydao(user).queryByNamedSqlQuery(
				"boss.cms.querySvwayinfo", waylistvo);
	}

	public WayVO doCreate(WayVO vo, User user) throws Exception {
		WayControl control = this.doGetwayControl(user);
		AuditUtils utils = new AuditUtils();
		vo=(WayVO)utils.doSaveAudit(vo, "CH_PW_WAY", "CH_PW_SVWAY",
				new String[] { "address" }, new String[] { "wayid" }, "CH_PW_SVWAY_AUDIT",user);
		//vo.setAddress("");// 详细地址字段需要审核后才加入渠道表
		/**
		 * 这里需要调用新增审核信息接口
		 */
		return (WayVO) control.doCreate(vo, user);
	}

	public WayVO doUpdate(WayVO vo, User user) throws Exception {
		WayControl control = this.doGetwayControl(user);
		// WayVO oldvo=(WayVO)dao.findByPk(vo.getWayid());
		// BeanUtils.copyProperties(oldvo, vo,false);
		AuditUtils utils = new AuditUtils();
		vo = (WayVO) utils.doUpdateValue(vo, "CH_PW_WAY", "CH_PW_SVWAY",
				new String[] { "address" }, new String[] { "wayid" }, "CH_PW_SVWAY_AUDIT",user);
		return (WayVO) control.doUpdate(vo, user);
	}

	public void doRemove(WayVO vo, User user) throws Exception {
		WayControl control = this.doGetwayControl(user);
		vo.setWaystate(new Short("0"));
		control.doUpdate(vo,user);
	}

	public Object doFindByPk(String pk, User user) throws Exception {
		WayDAO dao = this.doGetwaydao(user);
		return dao.findByPk(pk);
	}

	public WayVO doZjtyway(WayVO vo, User user) throws Exception {
		WayDAO dao = this.doGetwaydao(user);
		return (WayVO) dao.update(vo);
	}
}
