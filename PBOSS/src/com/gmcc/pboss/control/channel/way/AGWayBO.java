package com.gmcc.pboss.control.channel.way;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.gmcc.pboss.business.channel.bchcontact.BchcontactVO;
import com.gmcc.pboss.business.channel.cooperator.CooperatorVO;
import com.gmcc.pboss.business.channel.employee.EmployeeDBParam;
import com.gmcc.pboss.business.channel.employee.EmployeeVO;
import com.gmcc.pboss.business.channel.netsyn.NetsynDAO;
import com.gmcc.pboss.business.channel.netsyn.NetsynDBParam;
import com.gmcc.pboss.business.channel.netsyn.NetsynVO;
import com.gmcc.pboss.business.channel.way.AGWayVO;
import com.gmcc.pboss.business.channel.way.WayDAO;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.channel.wayaccount.WayaccountVO;
import com.gmcc.pboss.business.channel.waybusicircle.WaybusicircleDBParam;
import com.gmcc.pboss.business.channel.waybusicircle.WaybusicircleVO;
import com.gmcc.pboss.business.channel.waycompact.WaycompactVO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.bchcontact.Bchcontact;
import com.gmcc.pboss.control.channel.bchcontact.BchcontactBO;
import com.gmcc.pboss.control.channel.cooperator.Cooperator;
import com.gmcc.pboss.control.channel.cooperator.CooperatorBO;
import com.gmcc.pboss.control.channel.employee.Employee;
import com.gmcc.pboss.control.channel.employee.EmployeeBO;
import com.gmcc.pboss.control.channel.netsyn.Netsyn;
import com.gmcc.pboss.control.channel.netsyn.NetsynBO;
import com.gmcc.pboss.control.channel.wayaccount.Wayaccount;
import com.gmcc.pboss.control.channel.wayaccount.WayaccountBO;
import com.gmcc.pboss.control.channel.waybusicircle.Waybusicircle;
import com.gmcc.pboss.control.channel.waybusicircle.WaybusicircleBO;
import com.gmcc.pboss.control.channel.waycompact.Waycompact;
import com.gmcc.pboss.control.channel.waycompact.WaycompactBO;
import com.gmcc.pboss.web.common.webservice.CRMService;
import com.gmcc.pboss.web.common.webservice.ICRMService;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.exception.BusinessException;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

public class AGWayBO extends AbstractControlBean implements AGWay {

	private static Log log = LogFactory.getLog(AGWayBO.class);
	private static String smsMsgPattern = "尊敬的合作伙伴，您所属的网点编号{0}，网点名称是{1}信息已发生变更，变更后信息:{2}中国移动";
	private static int smsMsgPatternLen = 40;

	public int doCreate(AGWayVO vo, DBAccessUser user) throws Exception {
		int cando = 0;
		try {
			/*渠道表割接过来的数据是人员ID.
			 * //检查“所属渠道经理工号”是否在工号表（SA_SO_OPERATOR）存在。如工号不存在提示：该工号为无效工号请核对。*/
			if(vo.getWaymagcode() != null && !"".equals(vo.getWaymagcode().trim())){
				checkWayManager(vo.getWaymagcode(), user);
			}
			Cooperator coperator = (Cooperator) BOFactory.build(
					CooperatorBO.class, user);
			Way control = (Way) BOFactory.build(WayBO.class,user);
			Bchcontact bchcontactControl = (Bchcontact) BOFactory
					.build(BchcontactBO.class,user);
			Waycompact waycompactControl = (Waycompact) BOFactory
					.build(WaycompactBO.class,user);
			Wayaccount wayaccountControl = (Wayaccount) BOFactory
					.build(WayaccountBO.class,user);
			Employee employeeControl = (Employee) BOFactory
					.build(EmployeeBO.class,user);
			Netsyn netsynControl = (Netsyn) BOFactory
					.build(NetsynBO.class,user);
			WayVO wayVO = new WayVO();
			BchcontactVO bchcontactVO = new BchcontactVO();
			WaycompactVO waycompactVO = new WaycompactVO();
			WayaccountVO wayaccountVO = new WayaccountVO();
			CooperatorVO cooperatorVO = new CooperatorVO();
			EmployeeVO employeeVO = new EmployeeVO();
			NetsynVO netsynVO = new NetsynVO();

			if (vo.getOfficetel() == null
					|| StringUtils.isBlank(vo.getOfficetel())) {
				throw new Exception("公务机号码必须填写");
			}
			EmployeeDBParam employeeListVO = new EmployeeDBParam();
			employeeListVO.set_ne_empstatus("0");
			employeeListVO.set_se_officetel(vo.getOfficetel());
			if (employeeControl.doQuery(employeeListVO).getRowCount() > 0) { 
				     throw new Exception("系统已存在该公务机号码，请用其它手机号");
				
			}
			// 如果没有设置状态，默认为1（生效）
			if (vo.getWaystate() == null) {
				vo.setWaystate(new Short((short) 1));
			}

			// 合作商不对待审批字段进行处理
			setCoopVO(cooperatorVO, vo, user);
			String[] pk = new String[] { "wayid" };
			//AuditUtils utils = new AuditUtils();

			BeanUtils.copyProperties(wayVO, vo);
			BeanUtils.copyProperties(bchcontactVO, vo);
			BeanUtils.copyProperties(waycompactVO, vo);
			waycompactVO.setEndtime(vo.getCmpendtime());
			BeanUtils.copyProperties(wayaccountVO, vo);

			bchcontactVO.setLinkman(vo.getPrincipal());
			bchcontactVO.setLinkmantel(vo.getPrincipaltel());
			// 零售渠道是单账户，默认为0
			wayaccountVO.setAccid(new Integer(0));
			// 缴费类型，帐号类型都填固定值 0
			//wayaccountVO.setAccttype(new Short((short) 0));
			wayaccountVO.setChargetype(new Short((short) 0));
			if (control.doFindByPk(wayVO.getWayid()) != null) {
				throw new BusinessException("已经存在该渠道编码:"
						+ vo.getWayid());
			}
			control.doCreate(wayVO,user);
			bchcontactControl.doCreate(bchcontactVO);
			waycompactControl.doCreate(waycompactVO);
			wayaccountControl.doCreate(wayaccountVO);
			coperator.doCreate(cooperatorVO);
			// 记录店主信息
			employeeVO = setEmployVO(vo);
			boolean iscanSetservice = this.canSetservice(user);
			employeeControl.doCreateSociety(employeeVO, user);
			
			doDealBusicircle(vo);

		} catch (Exception e) {
			log.error(e);
			throw new JOPException(e.getMessage());
		}
		return cando;
	}
	
	private void doDealBusicircle(AGWayVO vo) throws Exception {
		//【社会渠道类型】，处理逻辑
		String rewardkind = vo.getRewardkind();		
		Waybusicircle waybusicircleBO = (WaybusicircleBO)BOFactory.build(WaybusicircleBO.class,user);
		WaybusicircleDBParam waybusicircleDBParam = new WaybusicircleDBParam();
		waybusicircleDBParam.set_se_wayid(vo.getWayid());
		DataPackage WaybusicircleDP = waybusicircleBO.doQuery(waybusicircleDBParam);
		if("0".equals(rewardkind)){//2G
			if(vo.getBuscno() == null || "".equals(vo.getBuscno())){
				vo.setBuscno("0000");
			}
			
			if(WaybusicircleDP != null && !"".equals(WaybusicircleDP)
					&& WaybusicircleDP.getDatas() != null && !"".equals(WaybusicircleDP.getDatas())
					&& WaybusicircleDP.getDatas().size() > 0){//存在
				WaybusicircleVO wbVO = (WaybusicircleVO)WaybusicircleDP.getDatas().get(0);
				
				wbVO.setRewardkind(Short.parseShort("0"));
				wbVO.setBuscno(vo.getBuscno());
				wbVO.setWaymod(null);
				wbVO.setWayattr(null);
				
				waybusicircleBO.doUpdate(wbVO);
			}else{//不存在
				WaybusicircleVO wbVO = new WaybusicircleVO();
				
				wbVO.setWayid(vo.getWayid());
				wbVO.setBuscno(vo.getBuscno());
				wbVO.setRewardkind(Short.parseShort("0"));
				wbVO.setCreatetime(new Date());
				
				waybusicircleBO.doCreate(wbVO);
			}
		}
		
		if("1".equals(rewardkind)){//3G
			if(WaybusicircleDP != null && !"".equals(WaybusicircleDP)
					&& WaybusicircleDP.getDatas() != null && !"".equals(WaybusicircleDP.getDatas())
					&& WaybusicircleDP.getDatas().size() > 0){//存在
				WaybusicircleVO wbVO = (WaybusicircleVO)WaybusicircleDP.getDatas().get(0);
				
				wbVO.setRewardkind(Short.parseShort("1"));
				wbVO.setBuscno(vo.getBuscno());
				
				if(vo.getWaymod() != null && !"".equals(vo.getWaymod()))
					wbVO.setWaymod(Float.parseFloat(vo.getWaymod()));
				
				wbVO.setWayattr(vo.getWayattr());
				
				waybusicircleBO.doUpdate(wbVO);
			}else{//不存在
				WaybusicircleVO wbVO = new WaybusicircleVO();
				
				wbVO.setWayid(vo.getWayid());
				wbVO.setRewardkind(Short.parseShort("1"));
				wbVO.setBuscno(vo.getBuscno());
				
				if(vo.getWaymod() != null && !"".equals(vo.getWaymod()))
					wbVO.setWaymod(Float.parseFloat(vo.getWaymod()));
				
				wbVO.setCreatetime(new Date());
				wbVO.setWayattr(vo.getWayattr());
				
				waybusicircleBO.doCreate(wbVO);
			}
		}
		if("2".equals(rewardkind)){//连锁加盟渠道类别
			if(WaybusicircleDP != null && !"".equals(WaybusicircleDP)
					&& WaybusicircleDP.getDatas() != null && !"".equals(WaybusicircleDP.getDatas())
					&& WaybusicircleDP.getDatas().size() > 0){//存在
				WaybusicircleVO wbVO = (WaybusicircleVO)WaybusicircleDP.getDatas().get(0);
				
				wbVO.setRewardkind(Short.parseShort("2"));
				wbVO.setBuscno(vo.getBuscno());
				
					//连锁加盟渠道类别时连锁加盟渠道属性清空
					wbVO.setWaymod(null);
					//连锁加盟渠道类别时 连锁加盟渠道系数清空
					wbVO.setWayattr(null);
				
				waybusicircleBO.doUpdate(wbVO);
			}else{//不存在
				WaybusicircleVO wbVO = new WaybusicircleVO();
				
				wbVO.setWayid(vo.getWayid());
				wbVO.setRewardkind(Short.parseShort("2"));
				wbVO.setBuscno(vo.getBuscno());
				
				//连锁加盟渠道类别时连锁加盟渠道属性清空
				wbVO.setWaymod(null);
				//连锁加盟渠道类别时 连锁加盟渠道系数清空
				wbVO.setWayattr(null);
				
				wbVO.setCreatetime(new Date());
				
				waybusicircleBO.doCreate(wbVO);
			}
	}
		if("3".equals(rewardkind)){//4G
			if(WaybusicircleDP != null && !"".equals(WaybusicircleDP)
					&& WaybusicircleDP.getDatas() != null && !"".equals(WaybusicircleDP.getDatas())
					&& WaybusicircleDP.getDatas().size() > 0){//存在
				WaybusicircleVO wbVO = (WaybusicircleVO)WaybusicircleDP.getDatas().get(0);
				
				wbVO.setRewardkind(Short.parseShort("3"));
				wbVO.setBuscno(vo.getBuscno());
				
				if(vo.getWaymod() != null && !"".equals(vo.getWaymod()))
					wbVO.setWaymod(Float.parseFloat(vo.getWaymod()));
				
				wbVO.setWayattr(vo.getWayattr());
				
				waybusicircleBO.doUpdate(wbVO);
			}else{//不存在
				WaybusicircleVO wbVO = new WaybusicircleVO();
				
				wbVO.setWayid(vo.getWayid());
				wbVO.setRewardkind(Short.parseShort("3"));
				wbVO.setBuscno(vo.getBuscno());
				
				if(vo.getWaymod() != null && !"".equals(vo.getWaymod()))
					wbVO.setWaymod(Float.parseFloat(vo.getWaymod()));
				
				wbVO.setCreatetime(new Date());
				wbVO.setWayattr(vo.getWayattr());
				
				waybusicircleBO.doCreate(wbVO);
			}
		}
	}

	public void doDelete(WayVO vo, DBAccessUser user) throws Exception {
		try {
			Way control = (Way) BOFactory.build(WayBO.class,user);
			Cooperator cooperator = (Cooperator) BOFactory.build(
					CooperatorBO.class, user);
			Employee employeeControl = (Employee) BOFactory
					.build(EmployeeBO.class,user);
			Netsyn netsynControl = (Netsyn) BOFactory
					.build(NetsynBO.class,user);
			CooperatorVO cooperatorVO = (CooperatorVO) cooperator
					.doFindByPk(vo.getWayid());
			WayVO wayVO = (WayVO) control.doFindByPk(vo.getWayid());
			wayVO.setWaystate(new Short((short) 0));
			control.doUpdate(wayVO);
			if (cooperatorVO != null) {
				cooperatorVO.setState(new Short((short) 0));
				cooperator.doUpdate(cooperatorVO);
			}
			EmployeeDBParam listVO = new EmployeeDBParam();
			listVO.set_se_wayid(wayVO.getWayid());
			listVO.set_ne_isnet("1");
			listVO.set_ne_empstatus("0");
			Iterator iterator = employeeControl.doQuery(listVO)
					.getDatas().iterator();
			if (iterator.hasNext()) {
				EmployeeVO employeeVO = (EmployeeVO) iterator.next();
				if (employeeVO != null) {
					employeeVO.setEmpstatus(new Short((short) 1));// 修改成离职状态
					employeeVO.setOuttime(new Date());
					// 0：在岗 1：离职
					employeeControl.doUpdate(employeeVO);
				}
			}
		} catch (Exception e) {
			log.error(e);
			throw new JOPException(e.getMessage());
		}
	}
	
	public void checkWayManager(String employeeid ,DBAccessUser user) throws Exception 
	{
		
			EmployeeBO employeeBO = (EmployeeBO) BOFactory.build(EmployeeBO.class,user);
			EmployeeDBParam list=new EmployeeDBParam();
			list.set_se_employeeid(employeeid);
			list.set_ne_isnet("4");
			list.set_ne_empstatus("0");
			if(  employeeBO.doQuery(list).getRowCount()<=0)
			{
				throw new Exception("该所属渠道经理工号["+employeeid+"]无效,请核对");
			}
	}

	public int doUpdate(AGWayVO vo, DBAccessUser user) throws Exception {
		int cando = 0;
		try {
			
			//检查“所属渠道经理工号”是否在工号表（SA_SO_OPERATOR）存在。如工号不存在提示：该工号为无效工号请核对。
			//割接过来的数据这个字段保存的是EMPLOYEEID的数据.
			if(vo.getWaymagcode() != null && !"".equals(vo.getWaymagcode().trim())){
				checkWayManager(vo.getWaymagcode(),user);
			}
			Cooperator cooperator = (Cooperator) BOFactory.build(
					CooperatorBO.class, user);
			Way control = (Way) BOFactory
					.build(WayBO.class,user);
			Bchcontact bchcontactControl = (Bchcontact) BOFactory
					.build(BchcontactBO.class,user);
			Waycompact waycompactControl = (Waycompact) BOFactory
					.build(WaycompactBO.class,user);
			Wayaccount wayaccountControl = (Wayaccount) BOFactory
					.build(WayaccountBO.class,user);
			Employee employeeControl = (Employee) BOFactory
					.build(EmployeeBO.class,user);
			Netsyn netsynControl = (Netsyn) BOFactory
					.build(NetsynBO.class,user);
			//先从数据库里面查询出旧的数据,然后再把新值覆盖旧值,避免数据丢失(页面可以少写hidden字段)
			WayVO oldVO =(WayVO)control.doFindByPk(vo.getWayid());
			if(oldVO==null)
			{
				throw new Exception("渠道编码不存在:"+vo.getWayid());
			}
			BchcontactVO bchcontactVO = new BchcontactVO();
			WaycompactVO waycompactVO = new WaycompactVO();
			WayaccountVO wayaccountVO = new WayaccountVO();
			CooperatorVO cooperatorVO = new CooperatorVO();
			EmployeeVO employeeVO = new EmployeeVO();
			NetsynVO netsynVO = new NetsynVO();

			// 批量修改时从渠道表获取原渠道状态（null当作1）
			if (vo.getOldstate() == null) {
				WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
				Short oldState = (Short) dao.getMaxid("wayid", vo
						.getWayid(), "waystate");
				if (oldState == null) {
					oldState = new Short((short) 1);
				}
				vo.setOldstate(oldState);
			}
			String[] pk = new String[] { "wayid" };
			//AuditUtils utils = new AuditUtils();
			setCoopVO(cooperatorVO, vo, user);
			BeanUtils.copyProperties(oldVO, vo,true);
			BeanUtils.copyProperties(bchcontactVO, vo);
			BeanUtils.copyProperties(waycompactVO, vo);
			waycompactVO.setEndtime(vo.getCmpendtime());
			BeanUtils.copyProperties(wayaccountVO, vo);
			// 零售渠道是单账户，默认为0
			wayaccountVO.setAccid(new Integer(0));
			// 缴费类型，帐号类型都填固定值 0
			wayaccountVO.setChargetype(new Short((short) 0));

			bchcontactVO.setLinkman(vo.getPrincipal());
			bchcontactVO.setLinkmantel(vo.getPrincipaltel());
			
			control.doUpdate(oldVO,user);
			CooperatorVO cooperatorvo2 = (CooperatorVO) cooperator
					.doFindByPk(cooperatorVO.getCooperauid());
			if (cooperatorvo2 == null) {
				cooperator.doCreate(cooperatorVO);
			} else {
				if(cooperatorVO.getLicvalidate() == null) {
					// 批量更新时若Licvalidate属性为null值，从用户角度来看表示不必修改该属性
					cooperatorVO.setLicvalidate(cooperatorvo2.getLicvalidate());
				}
				BeanUtils.copyProperties(cooperatorvo2, cooperatorVO);
				cooperator.doUpdate(cooperatorvo2);
			}
			WaycompactVO waycompactvo2 = (WaycompactVO) waycompactControl
					.doFindByPk(waycompactVO.getWayid());
			if (waycompactvo2 == null) {
				waycompactControl.doCreate(waycompactVO);
			} else {
				BeanUtils.copyProperties(waycompactvo2, waycompactVO);
				waycompactControl.doUpdate(waycompactvo2);
			}
			WayaccountVO pkVO = new WayaccountVO();
			pkVO.setAccid(new Integer(0));
			pkVO.setWayid(wayaccountVO.getWayid());
			WayaccountVO wayaccountvo2 = (WayaccountVO) wayaccountControl
					.doFindByPk(pkVO);
			if (wayaccountvo2 == null) {
				wayaccountControl.doCreate(wayaccountVO);
			} else {
				BeanUtils.copyProperties(wayaccountvo2, wayaccountVO);
				wayaccountControl.doUpdate(wayaccountvo2);
			}
			BchcontactVO bchcontactvo2 = (BchcontactVO) bchcontactControl
					.doFindByPk(bchcontactVO.getWayid());
			if (bchcontactvo2 == null) {
				bchcontactControl.doCreate(bchcontactVO);
			} else {
				//旧: BeanUtils.copyProperties(bchcontactvo2, bchcontactVO);
				BeanUtils.copyProperties(bchcontactvo2, bchcontactVO, true);
				bchcontactControl.doUpdate(bchcontactvo2);
			}

			// 检查是否已存在捆绑手机号
			if (StringUtils.isBlank(vo.getOfficetel())) {
				throw new Exception("修改失败,公务机号码为空，请录入再进行修改操作");
			}
			EmployeeDBParam employeeListVO = new EmployeeDBParam();
			employeeListVO.set_se_officetel(vo.getOfficetel());
			employeeListVO.set_ne_empstatus("0");
			employeeListVO.getQueryConditions()
					.put("_sne_wayid", vo.getWayid());
			Iterator iterator = employeeControl.doQuery(employeeListVO)
					.getDatas().iterator();
			if (iterator.hasNext()) {
				throw new Exception("系统已存在该公务机号码，请用其它手机号");
			}
			
//			//根据配置文件切换crm还是boss接口
//			ICRMService crmService=new CRMService();
//			Object objService=crmService.getServicePort(user.getCityid());
			
			// 检查修改的渠道是否存在店主信息
			EmployeeDBParam listVO = new EmployeeDBParam();
			listVO.set_se_wayid(vo.getWayid());
			listVO.set_ne_empstatus("0");
			listVO.set_ne_isnet("1");

			Iterator itr = employeeControl.doQuery(listVO).getDatas()
					.iterator();
			// 如果不存在，则新增
			if (!itr.hasNext()) {//修改渠道为失效时，如果该渠道没有店主
				if (0 != oldVO.getWaystate() && -1 != oldVO.getWaystate()) {
					employeeVO = setEmployVO(vo);
					employeeControl.doCreateSociety(employeeVO, user);
				}
			} else {// 如果存在，修改人员信息
				employeeVO = (EmployeeVO) itr.next();
				String oldOfficetel = employeeVO.getOfficetel(); // 原来手机号
				EmployeeVO newEmployeeVO = new EmployeeVO();
				BeanUtils.copyProperties(newEmployeeVO, employeeVO);
				newEmployeeVO.setOfficetel(vo.getOfficetel());
				// 修改人员表信息
				if ((vo.getWaystate().intValue() == 0 || vo.getWaystate()
						.intValue() == -1)
						&& vo.getOldstate().intValue() == 1) { // 修改渠道状态：生效 改为 失效或删除
					//----渠道状态设置为失效时，更新渠道下的所有人员数据为离职 by lyl 单号：(2013)NBBOSS-D0036【社会网点信息管理】菜单优化  
					EmployeeDBParam UpdateVO = new EmployeeDBParam();
					UpdateVO.set_se_wayid(vo.getWayid());
					UpdateVO.set_ne_empstatus("0"); 
					ArrayList<EmployeeVO> empvo= (ArrayList<EmployeeVO>)employeeControl.doQuery(UpdateVO).getDatas();
					for (int i = 0; i < empvo.size(); i++) {
						EmployeeVO employeeVO2 = (EmployeeVO)empvo.get(i);
					  if ( (("0").equals(employeeVO2.getIsnet().toString()) || ("1").equals(employeeVO2.getIsnet().toString())) && 
							  (null!=employeeVO2.getOfficetel() && !("").equals(employeeVO2.getOfficetel()))) {
						employeeVO2.setEmpstatus(new Short((short) 1)); // 更新为离职
						employeeVO2.setOuttime(new Date());
						employeeControl.doUpdate(employeeVO2,user);
					  }
 
					}  
					//  ------渠道状态设置为失效时，更新渠道下的所有人员数据为离职 by lyl 单号：(2013)NBBOSS-D0036【社会网点信息管理】菜单优化  
				} else if (!StringUtils.equals(newEmployeeVO.getOfficetel(),
						oldOfficetel)) {      //修改公务机号码
					employeeVO.setEmpstatus(new Short((short) 1)); // 更新为离职
					employeeControl.doUpdate(employeeVO);
					employeeControl.doCreateSociety(newEmployeeVO, user);
				} 
			} 
			doDealBusicircle(vo);
			
			// 向采集平台登记变更通知短信
			if ("1".equals(vo.getSendFlag())) {
				sendMessage(vo, user);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
			throw new JOPException(e.getMessage());
		}
		return cando;
	}

	public void doSetservice(String wayid, DBAccessUser user) throws Exception {
		
		WayVO wayvo = doFindByPk((Serializable)wayid,user);
		Short waystate = wayvo.getWaystate();
		if (waystate!=1){
			throw new Exception("该渠道不允许开通渠道信息服务，请确认渠道状态是否为生效");
		}
		Employee employeeControl = (Employee) BOFactory
				.build(EmployeeBO.class,user);
		EmployeeVO employeeVO = getEmployee(wayid, user);
		String officetel = employeeVO.getOfficetel();
		if(StringUtils.isEmpty(officetel)){
			throw new Exception("请先录入公务机号码，然后再开通服务。");
		}
		ICRMService crmService=new CRMService();
		Object objService=crmService.getServicePort(user.getCityid());
		if(objService==null){//调用BOSS接口
			Netsyn netsynControl = (Netsyn) BOFactory.build(NetsynBO.class,
					user);
			NetsynVO netsynVO = setNetsynVO(officetel, new Short((short) 0),
					user.getOprcode());
			netsynControl.doCreate(netsynVO);
			employeeVO.setIsopen(new Short((short) 2));
			employeeControl.doUpdate(employeeVO);
		}else{//调用CRM接口
			//已取消服务费，不需要再调用服务
		}
	}

	public boolean doCancelService(String employeeID, DBAccessUser user, String flag)
			throws Exception {
		Employee employeeControl = (Employee) BOFactory
				.build(EmployeeBO.class,user);
		EmployeeVO employeeVO = employeeControl.doFindByPk(employeeID);
		String officetel = employeeVO.getOfficetel();
		//店员也允许退订服务.
		if (employeeVO.getIsnet().shortValue() == (short) 1 || employeeVO.getIsnet().shortValue()==(short)0) {
			ICRMService crmService=new CRMService();
			Object objService=crmService.getServicePort(user.getCityid());
			if(objService==null){//调用BOSS接口
				Netsyn netsynControl = (Netsyn) BOFactory.build(NetsynBO.class,
						user);
				NetsynVO netsynVO = setNetsynVO(officetel,
						new Short((short) 1), user.getOprcode());
				netsynControl.doCreate(netsynVO);
				return true;
			}else{//调用CRM接口
				//已取消服务费，不需要再调用服务
				return true;
			}
		} else {
			throw new Exception("该店员：" + employeeID + " 不是店主/店员");
		}
	}

	/**
	 * 查看系统参数，是否配置了该地市能开通渠道服务
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	private boolean canSetservice(DBAccessUser user) throws Exception {
		Sysparam control = (Sysparam) BOFactory
				.build(SysparamBO.class,user);
		String value = control.doFindByID(new Long(5), "channel");
		return "1".equals(value) ? true : false;
	}

	/**
	 * 根据渠道编码得到店主信息
	 * 
	 * @param wayid
	 * @param user
	 * @return
	 * @throws Exception
	 */
	private EmployeeVO getEmployee(String wayid, DBAccessUser user) throws Exception {
		Employee employeeControl = (Employee) BOFactory
				.build(EmployeeBO.class,user);
		EmployeeDBParam listVO = new EmployeeDBParam();
		listVO.set_se_wayid(wayid);
		listVO.set_ne_empstatus("0");
		listVO.set_ne_isnet("1");
		Iterator iterator = employeeControl.doQuery(listVO).getDatas()
				.iterator();
		if (iterator.hasNext()) {
			EmployeeVO tempvo = (EmployeeVO) iterator.next();
			return tempvo;
		} else {
			throw new Exception("对应的公务机号码为空,请先录入");
		}

	}

	private void setCoopVO(CooperatorVO cooperatorvo, AGWayVO wayVO, DBAccessUser user)
			throws Exception {
		BeanUtils.copyProperties(cooperatorvo, wayVO);
		cooperatorvo.setCooperauid(wayVO.getWayid());
		cooperatorvo.setCooperaname(wayVO.getWayname());
		if (wayVO.getShortname() == null || "".equals(wayVO.getShortname())) {
			cooperatorvo.setCpabbrname(wayVO.getWayname());
		} else {
			cooperatorvo.setCpabbrname(wayVO.getShortname());
		}
		cooperatorvo.setCocheckname(wayVO.getShortname());
		cooperatorvo.setCustmanager(wayVO.getWaymagcode());
		if (wayVO.getBuzarea() != null) {
			cooperatorvo.setArea(new Double(wayVO.getBuzarea().longValue()));
		}
		cooperatorvo.setMemo(wayVO.getFunction());
		cooperatorvo.setState(wayVO.getWaystate());
		cooperatorvo.setOldcoopera(wayVO.getBusicode());
		cooperatorvo.setSmsmobileno(wayVO.getBuzphoneno());
		cooperatorvo.setServman(wayVO.getPrincipal());
		cooperatorvo.setCooperadel(wayVO.getPrincipal());
		cooperatorvo.setConntel(wayVO.getPrincipaltel());
		cooperatorvo.setUsremail(wayVO.getPrincipalemail());
		cooperatorvo.setConnpers(wayVO.getPrincipal());
		cooperatorvo.setBusconntel(wayVO.getPrincipaltel());
		cooperatorvo.setLicenceid(wayVO.getLicenceno());
		User hwUser=(User)user;
		cooperatorvo.setDistrictid(hwUser.getHwcityid()); // 营业区域填写市公司标志
	}

	/**
	 * employeeID,NETPASS在EmployeeControlBean设置
	 * 
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	private EmployeeVO setEmployVO(AGWayVO vo) throws Exception {
		EmployeeVO employeeVO = new EmployeeVO();
		employeeVO.setWayid(vo.getWayid());
		employeeVO.setWaytype("AG");
		employeeVO.setCityid(vo.getCityid());
		employeeVO.setCountyid(vo.getCountyid());
		employeeVO.setSvccode(vo.getSvccode());
		employeeVO.setEmpstatus(new Short((short) 0));
		employeeVO.setOfficetel(vo.getOfficetel());
		employeeVO.setIsnet(new Short((short) 1));
		employeeVO.setIsopen(new Short((short) 0));
		employeeVO.setEmployeename(vo.getPrincipal());
		// 店主的身份证号码和电子邮箱
		employeeVO.setPvtemail(vo.getPrincipalemail());
		employeeVO.setCardid(vo.getAcctfid());
		return employeeVO;
	}

	private NetsynVO setNetsynVO(String officetel, Short opract, String oprcode)
			throws Exception {
		NetsynVO netsynVO = new NetsynVO();
		netsynVO.setMobile(officetel);
		netsynVO.setOpract(opract);
		netsynVO.setOprcode(oprcode);
		return netsynVO;
	}

	public WayVO doFindByPk(Serializable pk, DBAccessUser user) throws Exception {
		WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);

		return (WayVO) dao.findByPk(pk);
	}

	/**
	 * 新增社会渠道信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean doAgcreate(WayVO newVO, CooperatorVO cooperatorvo,
			WaycompactVO waycompactvo, WayaccountVO wayaccountvo,
			BchcontactVO bchcontactvo, DBAccessUser user) throws Exception {
		boolean falg = false;
		try {

			// 重组VO
			//AuditUtils utils = new AuditUtils();
			String[] waypk = { "wayid" };
			String[] newwayfield = { "address" };

			String[] cooperaupk = { "cooperauid" };
			String[] cooperatorfield = { "sendaddr" };

			String[] wayaccountpk = { "accid", "wayid" };
			String[] wayaccountfield = { "acctno", "bankname" };

			Way control = (Way) BOFactory
					.build(WayBO.class,user);
			Wayaccount wayaccountcontrol = (Wayaccount) BOFactory
					.build(WayaccountBO.class,user);
			Waycompact waycompactcontrol = (Waycompact) BOFactory
					.build(WaycompactBO.class,user);
			Bchcontact bchcontactcontrol = (Bchcontact) BOFactory
					.build(BchcontactBO.class,user);

			Cooperator cooperator = (Cooperator) BOFactory.build(
					CooperatorBO.class, user);

			control.doCreate(newVO,user);

			waycompactcontrol.doCreate(waycompactvo);
			wayaccountcontrol.doCreate(wayaccountvo);
			bchcontactcontrol.doCreate(bchcontactvo);
			cooperator.doCreate(cooperatorvo);
			falg = true;
		} catch (Exception ex) {
			throw new JOPException(ex);
		}

		return falg;
	}

	/**
	 * 修改社会渠道信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean doAgupdate(WayVO oldVO, WayVO newVO,
			CooperatorVO cooperatorvo, WaycompactVO waycompactvo,
			WayaccountVO wayaccountvo, BchcontactVO bchcontactvo,
			boolean upperwayfalg, DBAccessUser user) throws Exception {
		boolean falg = false;
		try {
			// 重组VO
			//AuditUtils utils = new AuditUtils();
			String[] waypk = { "wayid" };
			String[] newwayfield = { "address" };

			String[] cooperaupk = { "cooperauid" };
			String[] cooperatorfield = { "sendaddr" };

			String[] wayaccountpk = { "accid", "wayid" };
			String[] wayaccountfield = { "acctno", "bankname" };

			Way control = (Way) BOFactory
					.build(WayBO.class,user);
			Wayaccount wayaccountcontrol = (Wayaccount) BOFactory
					.build(WayaccountBO.class,user);
			Waycompact waycompactcontrol = (Waycompact) BOFactory
					.build(WaycompactBO.class,user);
			Bchcontact bchcontactcontrol = (Bchcontact) BOFactory
					.build(BchcontactBO.class,user);

			Cooperator cooperator = (Cooperator) BOFactory.build(
					CooperatorBO.class, user);
			if (upperwayfalg) {
				control.doRemove(oldVO,user);
				control.doCreate(newVO,user);
			} else {
				control.doUpdate(newVO,user);
			}

			CooperatorVO cooperatorvo2 = (CooperatorVO) cooperator
					.doFindByPk(cooperatorvo.getCooperauid());
			if (cooperatorvo2 == null) {
				cooperator.doCreate(cooperatorvo);
			} else {
				BeanUtils.copyProperties(cooperatorvo2, cooperatorvo);
				cooperator.doUpdate(cooperatorvo2);
			}
			WaycompactVO waycompactvo2 = (WaycompactVO) waycompactcontrol
					.doFindByPk(waycompactvo.getWayid());
			if (waycompactvo2 == null) {
				waycompactcontrol.doCreate(waycompactvo);
			} else {
				BeanUtils.copyProperties(waycompactvo2, waycompactvo);
				waycompactcontrol.doUpdate(waycompactvo2);
			}
			WayaccountVO pkVO = new WayaccountVO();
			pkVO.setAccid(wayaccountvo.getAccid());
			pkVO.setWayid(wayaccountvo.getWayid());
			WayaccountVO wayaccountvo2 = (WayaccountVO) wayaccountcontrol
					.doFindByPk(pkVO);
			if (wayaccountvo2 == null) {
				wayaccountcontrol.doCreate(wayaccountvo);
			} else {
				BeanUtils.copyProperties(wayaccountvo2, wayaccountvo);
				wayaccountcontrol.doUpdate(wayaccountvo2);
			}
			BchcontactVO bchcontactvo2 = (BchcontactVO) bchcontactcontrol
					.doFindByPk(bchcontactvo.getWayid());
			if (bchcontactvo2 == null) {
				bchcontactcontrol.doCreate(bchcontactvo);
			} else {
				BeanUtils.copyProperties(bchcontactvo2, bchcontactvo);
				bchcontactcontrol.doUpdate(bchcontactvo2);
			}
			falg = true;
		} catch (Exception ex) {
			throw new JOPException(ex);
		}

		return falg;
	}

	public boolean doHasRecords(String officeTel, DBAccessUser user) throws Exception {
		NetsynDAO dao = (NetsynDAO) DAOFactory.build(NetsynDAO.class, user);
		NetsynDBParam listvo = new NetsynDBParam();
		listvo.set_se_mobile(officeTel);
		listvo.set_ne_opract("1");
		if (dao.query(listvo).getRowCount() <= 0) {
			return false;
		} else {
			return true;
		}
	}

	private void sendMessage(AGWayVO vo, DBAccessUser user) throws Exception {
		try {
			int len = vo.getWayid().length() + vo.getWayname().length()
					+ smsMsgPatternLen;
			String msg = vo.getSmsMsg();
			String chgInfo = msg;
			if (msg != null) {
				if ((msg.length() + len) > 134) {
					int legalLen = 134 - len;
					chgInfo = msg.substring(0, legalLen - 17)
							+ "...。详情请与您的渠道经理联系。";
				}
			}
			msg = MessageFormat.format(smsMsgPattern, new Object[] {
					vo.getWayid(), vo.getWayname(), chgInfo });
			if (msg.length() > 67) {
				insertMessage(msg.substring(0, 67), vo, user);
				insertMessage(msg.substring(67), vo, user);
			} else {
				insertMessage(msg.substring(0), vo, user);
			}
		} catch (Exception e) {
			throw new Exception("向采集平台登记变更通知短信出错，出错代码：" + e.getMessage());
		}

	}

	private void insertMessage(String message, AGWayVO vo, DBAccessUser user)
			throws Exception {
		
	}
	
	//新增配送商
	public WayVO doLogsCreate(AGWayVO vo, DBAccessUser user) throws Exception {
		try {
			WayVO wayvo = new WayVO();
			BeanUtils.copyProperties(wayvo, vo);
			Way way = (Way)BOFactory.build(WayBO.class, user);
			WayVO newwayvo = way.doCreate(wayvo, user);
			Employee employeeControl = (Employee)BOFactory.build(EmployeeBO.class, user);
			EmployeeDBParam listVO = new EmployeeDBParam();
			listVO.set_se_wayid(vo.getWayid());
			listVO.set_ne_isnet("3");
			listVO.set_ne_empstatus("0");
			Iterator iterator = employeeControl.doQuery(listVO)
					.getDatas().iterator();
			if (iterator.hasNext()) {
				EmployeeVO empvo = (EmployeeVO)iterator.next();
				empvo.setOfficetel(vo.getOfficetel());
				empvo.setEmployeename(vo.getEmployeename());
				employeeControl.doUpdate(empvo);
			}else{
				employeeControl.checkOfficeTel1(vo.getOfficetel(), user);
				EmployeeVO empvo = new EmployeeVO();
				empvo.setEmployeeid(employeeControl.getEmployeeid(user));
				empvo.setEmployeename(vo.getEmployeename());
				empvo.setWayid(vo.getWayid());
				empvo.setEmpstatus(new Short("0"));
				empvo.setOfficetel(vo.getOfficetel());
				empvo.setIsnet(new Short("3"));
				empvo.setIsopen(new Short("0"));
				empvo.setWaytype("AG");
				empvo.setCityid(vo.getCityid());
				empvo.setCountyid(vo.getCountyid());
				empvo.setSvccode(StringUtils.isNotEmpty(vo.getSvccode())?vo.getSvccode():null);
				employeeControl.doCreate(empvo);
			}
			return newwayvo;			
		} catch (Exception ex) {
			if (log.isInfoEnabled()){
				log.info("create way failed, wayid:" + vo.getWayid(), ex);
			}
			throw new JOPException(ex.getMessage());
		}
	}
	
	//修改配送商
	public WayVO doLogsUpdate(AGWayVO vo, DBAccessUser user) throws Exception {
		try {
			WayVO wayvo = new WayVO();
			BeanUtils.copyProperties(wayvo, vo);
			Way way = (Way)BOFactory.build(WayBO.class, user);
			WayVO newwayvo = way.doUpdate(wayvo, user);
			Employee employeeControl = (Employee)BOFactory.build(EmployeeBO.class, user);
			EmployeeDBParam listVO = new EmployeeDBParam();
			listVO.set_se_wayid(vo.getWayid());
			listVO.set_ne_isnet("3");
			listVO.set_ne_empstatus("0");
			Iterator iterator = employeeControl.doQuery(listVO)
					.getDatas().iterator();
			if (iterator.hasNext()) {
				EmployeeVO empvo = (EmployeeVO)iterator.next(); 
				if(vo.getOfficetel()!=null && empvo.getOfficetel()!=null )
				{
				employeeControl.checkOfficeTel2(vo.getOfficetel(),empvo.getEmployeeid(), user);
				}
				empvo.setEmployeename(vo.getEmployeename());
				empvo.setOfficetel(vo.getOfficetel());
				employeeControl.doUpdate(empvo);
			}else{
				employeeControl.checkOfficeTel1(vo.getOfficetel(), user);
				EmployeeVO empvo = new EmployeeVO();
				empvo.setEmployeeid(employeeControl.getEmployeeid(user));
				empvo.setEmployeename(vo.getEmployeename());
				empvo.setWayid(vo.getWayid());
				empvo.setEmpstatus(new Short("0"));
				empvo.setOfficetel(vo.getOfficetel());
				empvo.setIsnet(new Short("3"));
				empvo.setIsopen(new Short("0"));
				empvo.setWaytype("AG");
				empvo.setCityid(vo.getCityid());
				empvo.setCountyid(vo.getCountyid());
				empvo.setSvccode(StringUtils.isNotEmpty(vo.getSvccode())?vo.getSvccode():null);
				employeeControl.doCreate(empvo);
			}
			return newwayvo;			
		} catch (Exception ex) {
			if (log.isInfoEnabled()){
				log.info("create way failed, wayid:" + vo.getWayid(), ex);
			}
			throw new JOPException(ex.getMessage());
		}
	}
	
	public WayVO doEditLogs(WayVO oldVO, AGWayVO agvo, DBAccessUser user) throws Exception {
		try {
			Way way = (Way)BOFactory.build(WayBO.class, user);
			way.doRemove(oldVO, user);
			this.doLogsCreate(agvo, user);
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			throw new JOPException(e.getMessage());
		}
	}
	
	
	public int doUpdateState(AGWayVO vo, DBAccessUser user) throws Exception {
		int cando = 0;
		try {
			Way control = (Way) BOFactory
					.build(WayBO.class,user);
			//先从数据库里面查询出旧的数据,然后再把新值覆盖旧值,避免数据丢失(页面可以少写hidden字段)
			WayVO oldVO =(WayVO)control.doFindByPk(vo.getWayid());
			if(oldVO==null)
			{
				throw new Exception("渠道编码不存在:"+vo.getWayid());
			}
			//AuditUtils utils = new AuditUtils();
			BeanUtils.copyProperties(oldVO, vo,true);
			
			control.doUpdate(oldVO,user);
			
			
			// 向采集平台登记变更通知短信
			if ("1".equals(vo.getSendFlag())) {
				sendMessage(vo, user);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
			throw new JOPException(e.getMessage());
		}
		return cando;
	}
}
