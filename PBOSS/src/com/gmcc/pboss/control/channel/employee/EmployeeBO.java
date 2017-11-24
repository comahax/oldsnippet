/**
 * auto-generated code
 * Wed Jul 08 11:39:56 CST 2009
 */
package com.gmcc.pboss.control.channel.employee;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.beanutils.BeanUtils;
import com.gmcc.pboss.business.base.operator.OperatorVO;
import com.gmcc.pboss.business.base.sysparam.SysparamDAO;
import com.gmcc.pboss.business.channel.employee.EmployeeDAO;
import com.gmcc.pboss.business.channel.employee.EmployeeDBParam;
import com.gmcc.pboss.business.channel.employee.EmployeeVO;
import com.gmcc.pboss.business.channel.way.AGWayVO;
import com.gmcc.pboss.business.channel.way.WayDBParam;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.common.utils.tools.CheckUtil;
import com.gmcc.pboss.control.base.operator.Operator;
import com.gmcc.pboss.control.base.operator.OperatorBO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.nosect.Nosect;
import com.gmcc.pboss.control.channel.nosect.NosectBO;
import com.gmcc.pboss.control.channel.way.AGWay;
import com.gmcc.pboss.control.channel.way.AGWayBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.web.channel.common.CMSUtils;
import com.sunrise.jop.common.utils.lang.StringUtils;
import com.sunrise.jop.exception.JOPException;
import com.sunrise.jop.infrastructure.control.AbstractControlBean;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DBAccessUser;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

/**
 * <p>Title: EmployeeBO </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
/**
 * @ejb.bean local-jndi-name=
 *           "com/sunrise/jop/business/channel/employee/control/EmployeeBO"
 *           name="Employee" view-type="local" type="Stateless"
 * 
 * @ejb.interface pattern="{0}"
 * @ejb.transaction type="Required"
 */
public class EmployeeBO extends AbstractControlBean implements Employee {

	public EmployeeVO doCreate(EmployeeVO vo) throws Exception {
		try {
			EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
					user);
			// TODO set the pk */
			if( null == vo.getEmployeeid()){
				Long sequence = (Long) dao.getSequence("CH_PW_EMPLOYEE_SEQ");
				vo.setEmployeeid(user.getCityid() + String.valueOf(sequence));
			}
			// 渠道经理管理时
			if ("1".equals(vo.getPosittype())) {
				if (!"".equals(vo.getOprcode2()) && vo.getOprcode2() != null) {
					vo.setEmployeeid(vo.getOprcode2());
				} else {
					String seq = "0000000" + dao.getSequence("CH_PW_EMPLOYEEMAG_SEQ");
					int len = seq.length();
					seq = user.getCityid() + "PBOSS" + seq.substring(len-7, len);
					vo.setEmployeeid(seq);
				}
				EmployeeVO oldVO = (EmployeeVO) dao.findByPk(vo.getEmployeeid());
				if (oldVO != null) {
					throw new Exception("错误： 该人员["+ vo.getEmployeeid() + "]已经存在");
				}
			}
			return (EmployeeVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByVO(EmployeeVO vo) throws Exception {
		try {
			EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
					user);
			dao.remove(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public void doRemoveByPK(Serializable pk) throws Exception {
		try {
			EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
					user);
			dao.removeByPk(pk);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public EmployeeVO doUpdate(EmployeeVO vo) throws Exception {
		try {
			EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
					user);
			return (EmployeeVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex);
		}
	}

	public EmployeeVO doFindByPk(Serializable pk) throws Exception {
		EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
				user);
		return (EmployeeVO) dao.findByPk(pk);
	}

	public DataPackage doQuery(EmployeeDBParam params) throws Exception {
		EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
				user);
		return dao.query(params);
	}

	/**
	 * 渠道经理查询
	 * 
	 * @param wayid
	 *            登录的用户所在渠道
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public DataPackage doManagerQuery(String wayid, EmployeeDBParam params)
			throws Exception {
		EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
				user);
//		params
//				.setSelectFieldsString("employeeid,oprcode,employeename,sex,telephone,cityid,countyid,svccode,wayid,station,intime,employtype,");
		Map conditionMap = new HashMap();
		conditionMap.put("WAYID", wayid);
		params.setQueryConditions(conditionMap);
		return dao
				.queryByNamedSqlQuery(
						"com.gmcc.pboss.business.channel.employee.managerQuery",
						params);
	}
	
	//社会渠道人员管理查询
	public DataPackage doQuerybywayid(String wayid,EmployeeDBParam params) throws Exception{
		EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,user);
		params.getQueryConditions().put("basewayid", wayid);
		params.set_orderby("employeeid"); 
		params.set_desc("0");
		return dao.queryByNamedSqlQuery("com.gmcc.pboss.business.channel.employee.querybywayid",params);
	}
	

	/*
	 * 新增社会渠道人员
	 * //去掉检验逻辑,下个版本渠道这两个字段
	 */
	public EmployeeVO doCreateSociety(EmployeeVO vo, DBAccessUser user)
			throws Exception {
		try {
			EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
					user);
			Way way = (Way) BOFactory.build(WayBO.class, user);
			WayVO wayVO = way.doFindByPk2(vo.getWayid());
			if (wayVO == null) {
				throw new Exception("[所属网点/渠道编码]:" + vo.getWayid() + "在系统中不存在");
			}
			//
			if(vo.getWaytype()==null || "".equals(vo.getWaytype()))
			{
				vo.setWaytype("AG");
			}
			//
			if(vo.getIsopen()==null)
			{
				vo.setIsopen(new Short("0"));
			}
			if (!"AG".equals(wayVO.getWaytype())) {
				throw new Exception("[所属网点]不是社会渠道");
			} else {
				//放弃单个新增检验.
//				if (vo.getSvccode() != null
//						&& !"".equals(vo.getSvccode().trim())) {
//					ServcentDBParam listVO = new ServcentDBParam();
//					listVO.set_se_countyid(vo.getCountyid());
//					listVO.set_se_svccode(vo.getSvccode());
//					Servcent servcent = (Servcent) BOFactory.build(
//							ServcentBO.class, user);
//					if (servcent.doQuery(listVO).getRowCount() == 0) {
//						throw new Exception("[服务销售中心]不属于该分公司");
//					}
//				}
			}
			vo.setEmployeeid( doAutoCreateEmployee(1000) );// 人员编号后台自动生成
			if (vo.getIsopen() == null) {// 网点服务标志填写 0（未开通）
				vo.setIsopen(new Short("0"));
			}
			vo.setWaytype("AG");// 默认为社会渠道
			if (vo.getEmpstatus() == null) { // 设置默认在岗
				vo.setEmpstatus(new Short("0"));
			}
			//检测网点逻辑
			EmployeeVO checkVO=checkWaynet(null,vo,user,true);
			return (EmployeeVO) dao.create(checkVO);
		} catch (Exception ex) {
			throw new JOPException(ex.getMessage());
		}
	}
	
	/**
	 * 检查手机号码是否重复,
	 * @param vo
	 * @throws Exception
	 */
	public void checkSelectmobile(EmployeeVO vo) throws Exception
	{
		if(vo.getSelectmobile()!=null && vo.getSelectmobile().trim().length()==11){
			EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
					user);
			EmployeeDBParam listVO = new EmployeeDBParam();
			listVO.set_orderby("selectmobile");
			listVO.set_ne_empstatus("0");
			listVO.set_se_selectmobile(vo.getSelectmobile());
			if (dao.query(listVO).getRowCount() > 0) {
				throw new Exception("空中选号/写卡专用号码必须在系统唯一");
			}
		}
	}
	/*
	 * 检测是否修改了店主和捆绑手机号码的修改方法. 
	 */
	public EmployeeVO doUpdate(EmployeeVO vo, DBAccessUser user) throws Exception {
		try {
			EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
					user);
			// 判断手机号码和离职条件是否改动，有改动则把该号码置为离职，并复制一条新记录
			EmployeeVO dbVO = doFindByPk(vo.getEmployeeid());
			if (dbVO == null) {
				throw new Exception("没有该PK:" + vo.getEmployeeid() + "对应VO的记录");
			}
		
			//去掉检验逻辑,下个版本渠道这两个字段
//			if (vo.getSvccode() != null
//					&& !"".equals(vo.getSvccode().trim())) {
//				ServcentDBParam listVO = new ServcentDBParam();
//				listVO.set_se_countyid(vo.getCountyid());
//				listVO.set_se_svccode(vo.getSvccode());
//				Servcent servcent = (Servcent) BOFactory.build(
//						ServcentBO.class, user);
//				if (servcent.doQuery(listVO).getRowCount() == 0) {
//					throw new Exception("[服务销售中心]不属于该分公司");
//				}
//			}
			
// 			如果某条记录是在职状态改成离职,并且是店主或者店员,并且信息服务属于开通状态.则给店员/店主自动退订服务.
			boolean csFlag = false;
			int csCount = 0;
			if (vo.getEmpstatus() != null && dbVO.getEmpstatus() != null && vo.getIsopen()!=null
					&& vo.getEmpstatus().shortValue() == (short) 1
					&& dbVO.getEmpstatus().shortValue() == (short) 0
					&& vo.getIsopen().shortValue() == (short) 1) {
				if (vo.getIsnet().shortValue() == (short) 0
						|| vo.getIsnet().shortValue() == (short) 1) {
					AGWay control = (AGWayBO) BOFactory.build(AGWayBO.class,
							user);
					csFlag = control.doCancelService(dbVO.getEmployeeid(), user, "update");
					csCount = 1;
				}
			}
			//如果在岗人员的捆绑平台手机号码发生变动.则复制一条记录为新记录,原来记录改为离职状态,新号码自动开通手机渠道信息服务
			if (vo.getOfficetel() != null
					&& dbVO.getOfficetel() != null
					&& !dbVO.getOfficetel().trim().equals(
							vo.getOfficetel().trim()) && dbVO.getEmpstatus().shortValue()==(short)0) {
				//检查是否本地手机号码
//				checkTelCity(vo.getOfficetel(), user);
				EmployeeVO newVO = new EmployeeVO();
				BeanUtils.copyProperties(newVO, vo);
				newVO.setEmpstatus(new Short("0"));
				newVO.setIsopen(new Short("0"));// 增加设置未开通状态
				EmployeeVO creatEmployeeVO = this.doSocietyCopy(newVO, user);
				dbVO.setEmpstatus(new Short("1"));

				// 如果修改过手机号码的是店主/店员,则要给旧手机号退订服务,给新店主手机号开通服务,店员则不自动开通
				if (vo.getIsnet() != null && (vo.getIsnet().shortValue() == 1 || vo.getIsnet().shortValue()==(short)0)) {
					AGWay control = (AGWayBO) BOFactory.build(AGWayBO.class,user);
					//必须服务是已开通才能退订
					if(vo.getIsopen()!=null && vo.getIsopen().byteValue()==(byte)1){
						if(csCount == 0){//调用过服务后，这里不再调用
							csFlag = control.doCancelService(dbVO.getEmployeeid(), user, "update");
						}
					}else if(vo.getIsopen()==null)
					{
						throw new Exception("不能获取[开通服务标志]值");
					}
					//店主才开通服务
					if(vo.getIsnet().shortValue()==(short)1)
					{	
						control.doSetservice(vo.getWayid(), user);
					}
				}
				if(csFlag){
					dbVO.setIsopen((short)0);
				}
				dao.update(dbVO);
				return creatEmployeeVO;
			}
			if(csFlag){
				dbVO.setIsopen((short)0);
				vo.setIsopen((short)0);
			}
			// 改造数据源源后，渠道修改状态时，coms前台报超时异常 by lyl 2013-09-16
			EmployeeVO updateVO=checkWaynet(dbVO,vo,user,false);
			EmployeeVO newVO = null; 
//			InputStream in = net.gmcc.ngcrm.pboss.GDProdServ.class.getResourceAsStream("/coreconfiginfo.properties");
//			Properties p = new Properties();
//			p.load(in);
//			in.close();
//			String path = (String) p.get("way.update.test"); 
//			
//			if(("ONE").equals(path)){ 
				BeanUtils.copyProperties(dbVO, updateVO);
				newVO = (EmployeeVO)dao.update(dbVO);
//			}else if(("TWO").equals(path)){
//				Session session = SessionUtils.currentSession(user.getCityid());
//				newVO = (EmployeeVO) session.merge(updateVO);
//				//session.flush();
//			}else{
//				Session session = SessionUtils.currentSession(user.getCityid());
//				newVO = (EmployeeVO) session.merge(updateVO);
//				session.flush();
//			}  //  2013-09-16 by lyl
			return newVO;
			// return (EmployeeVO) dao.update(vo);
		} catch (Exception ex) {
			throw new JOPException(ex.getMessage());
		}
	}
	
	/*
	 * 由于修改号码导致的新增社会渠道人员（复制）
	 */
	public EmployeeVO doSocietyCopy(EmployeeVO vo, DBAccessUser user) throws Exception {
		try {
			EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
					user);
			checkOfficeTel(vo.getOfficetel(), user);
			checkSelectmobile(vo);
			String oldemployeeid=vo.getEmployeeid();
			if(!jdugeIsNetChange(vo.getWayid(),user,oldemployeeid) && vo.getIsnet().shortValue()==(short)1){
				throw new Exception("一个网点只能有一个店主!");
			}
			String newemployeeid=doAutoCreateEmployee(1000);
			vo.setEmployeeid(newemployeeid);// 人员编号后台自动生成
			return (EmployeeVO) dao.create(vo);
		} catch (Exception ex) {
			throw new JOPException(ex.getMessage());
		}
	}
	
	/**
	 * 修改时要把店员改成店主时和修改离职状态时调用。
	 * 
	 * @param wayid
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public boolean jdugeIsNetChange(String wayid, DBAccessUser user) throws Exception {
		Employee employeeControl = (EmployeeBO) BOFactory.build(EmployeeBO.class,user);
		EmployeeDBParam listVO = new EmployeeDBParam();
		listVO.set_se_wayid(wayid);
		listVO.set_ne_empstatus("0");
		listVO.set_ne_isnet("1");
		return employeeControl.doQuery(listVO).getRowCount() <= 0;
	}
	/**
	 * 修改时要修改店主的手机号码时候检测店主是否唯一,这个时候老店主状态还未改变
	 * 
	 * @param wayid
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public boolean jdugeIsNetChange(String wayid, DBAccessUser user,String oldemployeeid) throws Exception {
		Employee employeeControl = (EmployeeBO) BOFactory.build(EmployeeBO.class,user);
		EmployeeDBParam listVO = new EmployeeDBParam();
		listVO.set_se_wayid(wayid);
		listVO.set_ne_empstatus("0");
		listVO.set_ne_isnet("1");
		listVO.set_sne_employeeid(oldemployeeid);
		return employeeControl.doQuery(listVO).getRowCount() <= 0;
	}
	private void checkOpercode(EmployeeVO vo, DBAccessUser user) throws Exception {
		if (vo.getOprcode2() == null || "".equals(vo.getOprcode2().trim())) {
			return;
		} else {
			Operator control = (OperatorBO) BOFactory
					.build(OperatorBO.class,user);
			OperatorVO opVO=control.doFindByPk(vo.getOprcode2());
			if ( opVO== null) {
				throw new Exception("系统不存在录入工号");
			}else  
			{
				if(opVO.getRegion()!=null){
					String hwRegion=String.valueOf(opVO.getRegion());
					if(!hwRegion.equals(((User)user).getHwcityid()))
					{
						throw new Exception("所选工号地市标志:"+hwRegion+" 与系统登录工号地市标志"+((User)user).getHwcityid()+"不一致!");
					}
				}else
				{
					throw new Exception("所选工号地市标志缺失! 工号:"+vo.getOprcode2());
				}
			}
		}
	}

	/*
	 * 生成人员编号
	 */
	public String getEmployeeid(DBAccessUser user) throws Exception {
		EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
				user);
		return user.getCityid() + dao.getSequence("CH_PW_EMPLOYEE_SEQ");
	}

	public EmployeeVO doFindByOprcode(String oprcode, DBAccessUser user)
			throws Exception {
		EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
				user);
		return (EmployeeVO) dao.findByProperty("oprcode2", oprcode);
	}
	
	/**
	 * 检测手机号码是否在本地市内唯一
	 * 
	 * @param officetel
	 * @param user
	 */
	//注:刚开发的人员不知道这个逻辑.漏掉了.下个版本补上.
	private void checkTelCity(String officetel, DBAccessUser user)
			throws Exception {
		Nosect control = (Nosect) BOFactory.build(NosectBO.class, user);
		String cityid = control.doQueryCityID(officetel);
		if (!user.getCityid().equals(cityid)) {
			throw new Exception("手机号码所属地市: "+cityid+" 与登录工号所属地市不一致");
		}
	}
	/**
	 * 查询在职手机号码是否唯一
	 * 
	 * @param vo
	 * @param user
	 * @throws Exception
	 */
	public void checkOfficeTel(String officetel, DBAccessUser user) throws Exception {
		EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
				user);
		EmployeeDBParam listvo = new EmployeeDBParam();
		listvo.set_se_officetel(officetel);
		// 0-在职
		listvo.set_ne_empstatus("0");
		DataPackage pack = dao.query(listvo);
		if (pack.getDatas().size() > 0) {
			throw new Exception("系统已存在该[公务机号码]，请用其它手机号！");
		}
	}
	
	/**
	 * 查询在职手机号码是否唯一(新增配送商信息检查)
	 * 
	 * @param vo
	 * @param user
	 * @throws Exception
	 */
	public void checkOfficeTel1(String officetel, DBAccessUser user) throws Exception {
		EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
				user); 
		SysparamDAO  sysparamDAO = (SysparamDAO) DAOFactory.build(SysparamDAO.class,
				user);
		
		EmployeeDBParam listvo = new EmployeeDBParam(); 
		listvo.set_se_officetel(officetel); 
		// 系统参数76，1:渠道经理参与了配送 0:渠道经理没有参与配送 空:渠道经理没有参与配送 
		String sysstr = sysparamDAO.doFindByID(76L, "channel"); 
	 
		// 0-在职
		listvo.set_ne_empstatus("0"); 
	
		if(("1").equals(sysstr)){ 
			// 4-渠道经理
			listvo.set_nne_isnet("4");
			  
		} 
		  DataPackage  pack = dao.query(listvo);
			if(pack.getDatas().size()>0){
				throw new Exception("系统已存在该[公务机号码]，请用其它手机号！");
			}  
 	}
	
	/**
	 * 查询在职手机号码是否唯一(配送商手机信息更新检查)
	 * 
	 * @param vo
	 * @param user
	 * @throws Exception
	 */
	public void checkOfficeTel2(String officetel, String employeeid,DBAccessUser user) throws Exception {
		
		EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
				user); 
		SysparamDAO  sysparamDAO = (SysparamDAO) DAOFactory.build(SysparamDAO.class,
				user);
		
		EmployeeDBParam listvo = new EmployeeDBParam();  
		listvo.set_se_officetel(officetel); 
		listvo.set_sne_employeeid(employeeid);
		
		// 系统参数76，1:渠道经理参与了配送 0:渠道经理没有参与配送 空:渠道经理没有参与配送 
		String sysstr = sysparamDAO.doFindByID(76L, "channel"); 
 	   // 0-在职
		listvo.set_ne_empstatus("0"); 
 	 
		if(("1").equals(sysstr)){ 
			
		 listvo.set_nne_isnet("4");	
		 
		} 
		  DataPackage  pack = dao.query(listvo);
			if(pack.getDatas().size()>0){
				throw new Exception("系统已存在该[公务机号码]，请用其它手机号！");
			} 
  
 	}
	
	/**
	 * 查询在职手机号码是否唯一(渠道经理信息检查)
	 * 
	 * @param vo
	 * @param user
	 * @throws Exception
	 */
	public void checkOfficeTel3(String officetel, DBAccessUser user) throws Exception {
		EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,
				user); 
		SysparamDAO  sysparamDAO = (SysparamDAO) DAOFactory.build(SysparamDAO.class,
				user);
		
		EmployeeDBParam listvo = new EmployeeDBParam(); 
		listvo.set_se_officetel(officetel); 
		// 系统参数76，1:渠道经理参与了配送 0:渠道经理没有参与配送 空:渠道经理没有参与配送 
		String sysstr = sysparamDAO.doFindByID(76L, "channel"); 
	 
		// 0-在职
		listvo.set_ne_empstatus("0"); 
	
		if(("1").equals(sysstr)){ 
			// 3-配送商
			listvo.set_nne_isnet("3");
			  
		} 
		  DataPackage  pack = dao.query(listvo);
			if(pack.getDatas().size()>0){
				throw new Exception("系统已存在该[公务机号码]，请用其它手机号！");
			}  
 	}
	
    
//    /**
//     * 删除渠道经理:修改用工状态为1（离职）
//     * @param pkArray
//     * @throws Exception
//     */
//    public void doDeleteManager(String[] pkArray) throws Exception{
//    	for(int i=0;i<pkArray.length;i++){
//    		EmployeeVO vo = this.doFindByPk(pkArray[i]);
//    		if(vo != null)
//    			vo.setEmpstatus(new Short("1"));
//    	}
//    }
	
	//渠道经理导入
	public void  doManagerImport(String[] item ,String loginwayid) throws Exception{
		EmployeeVO vo = this.doFindByOprcode(item[0], user);
		if(vo != null &&   vo.getEmpstatus()==1)
			throw new Exception("工号为:"+item[0] +" 的渠道经理已经存在 ");
		Operator operator = (Operator) BOFactory.build(OperatorBO.class, user);
		//验证人员是否在操作员表中
		if (item[0] != null && !"".equals(item[0])) {
		if( null == operator.doFindByPk(item[0])){
			throw new Exception("错误： 该人员["
					+ item[0] + "] 不在工号表中 ");
		}
		}
		vo = new EmployeeVO();
		vo.setWaytype("ET");
		vo.setEmployeeid(item[0]);
		vo.setOprcode2(item[0]);
		vo.setEmployeename(item[1]);
		vo.setBirthday(StringUtils.isNotEmpty(item[2])?stringToDate(item[2],"yyyy-MM-dd"):null);
		vo.setSex(StringUtils.isNotEmpty(item[3])?new Short(item[3]):null);
		vo.setNativehome(item[4]);
		vo.setPolivisage(StringUtils.isNotEmpty(item[5])?new Short(item[5]):null);
		vo.setHomeaddr(item[6]);
		vo.setCardid(item[7]);
		vo.setTelephone(item[8]);
		vo.setPvtemail(item[9]);
		vo.setOfcphone(item[10]);
		vo.setEdulevel(StringUtils.isNotEmpty(item[11])?new Short(item[11]):null);
		vo.setSpeciality(item[12]);
		vo.setCityid(item[13]);
		vo.setCountyid(item[14]);
		vo.setSvccode(item[15]);
		vo.setMareacode(item[16]);//新增微区域
		vo.setWayid(item[17]);
		vo.setCompany(item[18]);
		vo.setStation(StringUtils.isNotEmpty(item[19])?new Long(item[19]):null);
		vo.setPosittype("1");//岗位级别默认经理
		vo.setIsnet(new Short("4"));//默认经理
		vo.setJoblevel(StringUtils.isNotEmpty(item[21])?new Short(item[21]):null);
		vo.setDepartment(item[22]);
		vo.setGradtime(StringUtils.isNotEmpty(item[23])?stringToDate(item[23],"yyyy-MM-dd"):null);
		vo.setGradschool(item[24]);
		vo.setIntime(StringUtils.isNotEmpty(item[25])?stringToDate(item[25],"yyyy-MM-dd"):null);
		vo.setContacttype(StringUtils.isNotEmpty(item[26])?new Short(item[26]):null);
		vo.setEmploytype(StringUtils.isNotEmpty(item[27])?new Short(item[27]):null);
		vo.setEmpstatus(StringUtils.isNotEmpty(item[28])?new Short(item[28]):null);
		vo.setWorktime(StringUtils.isNotEmpty(item[29])?new Short(item[29]):null);
		vo.setHereworktime(StringUtils.isNotEmpty(item[30])?new Short(item[30]):null);
		vo.setIsmarried(StringUtils.isNotEmpty(item[31])?new Short(item[31]):null);
		//vo.setSelectmobile(item[31]);
		if(!checkWayid(item[17],loginwayid)){
			throw new Exception("服务厅(所属渠道)不是登录渠道或者登录渠道下级渠道");
		}
		// 验证公务手机号码有效性
		this.checkOfficeTel3(item[32], user);
		this.checkTelCity(item[32], user);
		vo.setOfficetel(item[32]);
		EmployeeBO bo = (EmployeeBO)BOFactory.build(EmployeeBO.class,user);
		bo.doCreate(vo);
	}
	
	/*
	 * 管辖网点查询
	 */
	public DataPackage doQueryEmployee(EmployeeDBParam params,User user) throws Exception {
		List collection = new ArrayList();
		DataPackage dp = new DataPackage();
		Way wayBO = (WayBO) BOFactory.build(WayBO.class,user);
		WayDBParam wayParam = new WayDBParam();
		wayParam.set_se_waymagcode(params.get_se_employeeid());
		
		DataPackage dataPackage = wayBO.doQueryEmployee(wayParam, user);
		List list = (List) dataPackage.getDatas();
		for (int i = 0; i < list.size(); i++) {
			WayVO wayVO = (WayVO) list.get(i);
			AGWayVO agway = new AGWayVO();
			BeanUtils.copyProperties(agway, wayVO);
			params.set_se_wayid(wayVO.getWayid());
			params.set_ne_isnet("1");
			params.set_ne_empstatus("0");
			Iterator employee = this.doQuery(params).getDatas().iterator();
			if (employee.hasNext()) {
				EmployeeVO employeevo = (EmployeeVO) employee.next();
				agway.setIsopen(employeevo.getIsopen());
				agway.setOfficetel(employeevo.getOfficetel());
			}
			collection.add(agway);
		}
		dp.setDatas(collection);
		dp.setRowCount(dataPackage.getRowCount());
		dp.setPageNo(dataPackage.getPageNo());
		dp.setPageSize(dataPackage.getPageSize());
		return dp;
	}
	
	/**
	 * 更新人员用工状态
	 * @param employeeIDs 人员列表（标识）
	 * @param empstatus	更新为的状态
	 * @throws Exception
	 */
	public void doUpdateEmpstatus(String[] employeeIDs,Short empstatus) throws Exception{
		for(String employeeid:employeeIDs){
			EmployeeVO employeevo = this.doFindByPk(employeeid);
			employeevo.setEmpstatus(empstatus);
			Employee bo = (EmployeeBO) BOFactory.build(
					EmployeeBO.class,user);
			bo.doUpdate(employeevo);
		}
	}
	public Date stringToDate(String dateStr,String dateFormat) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat(dateFormat);
		return format.parse(dateStr);
	}
	
	// 自定义社会渠道人员导入
	public void doCustomPeopleImport(String[] item) throws Exception {
		Employee employee = (Employee) BOFactory.build(EmployeeBO.class, user);
		EmployeeVO employeeVO = new EmployeeVO();
		EmployeeVO dbVO = this.doFindByPk(item[0]);
		if( null == dbVO) {
			throw new Exception ("系统不存在该人员id，请检查核对");
		}
		BeanUtils.copyProperties(employeeVO, dbVO);
		employeeVO.setEmployeeid(item[0]);
		if (item[1] != null && "".equals(item[1])) {
			employeeVO.setOfficetel(null);
		} else if (item[1] != null && !"".equals(item[1])) { 
			checkTelCity( item[1], user);
			employeeVO.setOfficetel(item[1]);
		}
		if (item[2] != null && "".equals(item[2])) {
			employeeVO.setEmployeename(null);
		} else if (item[2] != null && !"".equals(item[2])) {
			employeeVO.setEmployeename(item[2]);
		}
		if (item[3] != null && "".equals(item[3])) {
			employeeVO.setBirthday(null);
		} else if (item[3] != null && !"".equals(item[3])) {
			employeeVO.setBirthday(stringToDate(item[3], "yyyy-MM-dd"));
		}
		if (item[4] != null && "".equals(item[4])) {
			employeeVO.setSex(null);
		} else if (item[4] != null && !"".equals(item[4])) {
			employeeVO.setSex(new Short(item[4]));
		}
		if (item[5] != null && "".equals(item[5])) {
			employeeVO.setCardid(null);
		} else if (item[5] != null && !"".equals(item[5])) {
			employeeVO.setCardid(item[5]);
		}
		if (item[6] != null && "".equals(item[6])) {
			employeeVO.setCityid(null);
		} else if (item[6] != null && !"".equals(item[6])) {
			employeeVO.setCityid(item[6]);
		}
		if (item[7] != null && "".equals(item[7])) {
			employeeVO.setCountyid(null);
		} else if (item[7] != null && !"".equals(item[7])) {
			employeeVO.setCountyid(item[7]);
		}
		if (item[8] != null && "".equals(item[8])) {
			employeeVO.setWayid(null);
		} else if (item[8] != null && !"".equals(item[8])) {
			employeeVO.setWayid(item[8]);
		}
		if (item[9] != null && "".equals(item[9])) {
			employeeVO.setIntime(null);
		} else if (item[9] != null && !"".equals(item[9])) {
			employeeVO.setIntime(stringToDate(item[9], "yyyy-MM-dd"));
		}
		if (item[10] != null && "".equals(item[10])) {
			employeeVO.setContacttype(null);
		} else if (item[10] != null && !"".equals(item[10])) {
			employeeVO.setContacttype(new Short(item[10]));
		}
		if (item[11] != null && "".equals(item[11])) {
			employeeVO.setEmploytype(null);
		} else if (item[11] != null && !"".equals(item[11])) {
			employeeVO.setEmploytype(new Short(item[11]));
		}
		if (item[12] != null && "".equals(item[12])) {
			employeeVO.setEmpstatus(null);
		} else if (item[12] != null && !"".equals(item[12])) {
			employeeVO.setEmpstatus(new Short(item[12]));
		}
		if (item[13] != null && "".equals(item[13])) {
			employeeVO.setIsnet(new Short("0"));
		} else if (item[13] != null && !"".equals(item[13])) {
			employeeVO.setIsnet(new Short(item[13]));
		}
		if (item[14] != null && "".equals(item[14])) {
			employeeVO.setTelephone(null);
		} else if (item[14] != null && !"".equals(item[14])) {
			employeeVO.setTelephone(item[14]);
		}
		if (item[15] != null && "".equals(item[15])) {
			employeeVO.setSvccode(null);
		} else if (item[15] != null && !"".equals(item[15])) {
			employeeVO.setSvccode(item[15]);
		}
		if (item[16] != null && "".equals(item[16])) {
			employeeVO.setBail(null);
		} else if (item[16] != null && !"".equals(item[16])) {
			employeeVO.setBail(new Double(item[16]));
		}
		if (item[17] != null && "".equals(item[17])) {
			employeeVO.setSelectmobile(null);
		} else if (item[17] != null && !"".equals(item[17])) {
			employeeVO.setSelectmobile(item[17]);
		}
		// 检测固定参数
		User tuser = (User) user;
		if(employeeVO.getContacttype() != null && !CheckUtil.getInstance().
				checkDictitem("CH_CONTACTTYPE", (""+employeeVO.getContacttype()), tuser)) {
			throw new JOPException("[劳动关系]:"+employeeVO.getContacttype()+" 固定参数不正确");
		}
		if(employeeVO.getEmploytype() != null && !CheckUtil.getInstance().
				checkDictitem("CH_EMPLOYTYPE", (""+employeeVO.getEmploytype()), tuser)) {
			throw new JOPException("[用工性质]:"+employeeVO.getEmploytype()+" 固定参数不正确");
		}
		if(employeeVO.getEmpstatus() != null && !CheckUtil.getInstance().
				checkDictitem("CH_EMPSTATUS", (""+employeeVO.getEmpstatus()), tuser)) {
			throw new JOPException("[用工状态]:"+employeeVO.getEmpstatus()+" 固定参数不正确");
		}
		// 检测逻辑
		employeeVO=checkWaynet(dbVO, employeeVO, user, false);
		employee.doUpdate(employeeVO, user);
	}

	//社会渠道人员导入
	public void  doSocietypeopleImport(String[] item) throws Exception{
//		导入时判断输入的第一列是否为空，如果为空，按照新增处理逻辑导入，如果不为空，根据人员id查询人员表，
//		判断记录是否存在，如果不存在，提示“系统不存在该人员id，请检查核对”
		Sysparam sysparamBO = (SysparamBO)BOFactory.build(SysparamBO.class, user);
		String param92 = sysparamBO.doFindByID("92", "channel");
		Way way = (Way) BOFactory.build(WayBO.class, user); 
		
		boolean isCreate=false;
		EmployeeVO employeeVO = new EmployeeVO();
		EmployeeVO dbVO=null;
		Employee emp = (Employee) BOFactory.build(EmployeeBO.class, user);
		if(item[0].trim().length()==0){//新增	
			employeeVO.setIsnet(new Short("0"));//导入时默认是店员，“是否为店主”赋值为0（店员）。
			if(item[1] != null && !"".equals(item[1])){
				checkTelCity( item[1], user);
				employeeVO.setOfficetel(item[1]);
			} 
			employeeVO.setEmployeename(item[2]);
			employeeVO.setBirthday(item[3].trim().length() == 0? null:stringToDate(item[3],"yyyy-MM-dd"));
			employeeVO.setSex(new Short(item[4]));
			employeeVO.setCardid(item[5].trim().length() == 0?null:item[5]);
//			vo.setTelephone(item[6].trim().length() == 0?null:item[6]);
			employeeVO.setPvtemail(item[6].trim().length() == 0 ? null:item[6]);
			employeeVO.setEdulevel(item[7].trim().length() == 0?null:new Short(item[7]));
			employeeVO.setCityid(item[8]);
			employeeVO.setCountyid(item[9]);
			employeeVO.setSvccode(item[10].trim().length() == 0?null:item[10]);
		    if (null != item[11] && !("").equals(item[11])){
			   WayVO wayVO = way.doFindByPk2(item[11]);
			   if(null==wayVO){
			       throw new Exception("此渠道编码" +item[11] + "不存在");
			    }else{
			    	employeeVO.setWayid(item[11]);	
			    }
			 } 
			employeeVO.setIntime(stringToDate(item[12],"yyyy-MM-dd"));
			employeeVO.setContacttype(new Short(item[13]));
			employeeVO.setEmploytype(new Short(item[14]));
			employeeVO.setBail(item[15].trim().length() ==0?null:new Double(item[15]));
			employeeVO.setEmpstatus(new Short(item[16])); 
			employeeVO.setSelectmobile(item[17].trim().length()==0?null:item[17]);
			employeeVO.setOprcode2(item[18].trim().length() == 0?null:item[18]);
			employeeVO.setWaytype("AG");//赋值为AG
			employeeVO.setIsopen(new Short("0"));
			isCreate=true;
			
			if (param92 != null && param92.equals("1") 
					&& item[19] != null && item[19].trim().equals("1")) {
				employeeVO.setIsnet(new Short("1"));
			}
		}else{//修改
			dbVO= this.doFindByPk(item[0]);
			if( null == dbVO)
				throw new Exception ("系统不存在该人员id，请检查核对");
			BeanUtils.copyProperties(employeeVO,dbVO);
			employeeVO.setEmployeeid(item[0]); 
			if(item[1] != null && !"".equals(item[1])){
			 checkTelCity( item[1], user);
			 employeeVO.setOfficetel(item[1]);
			}
			employeeVO.setEmployeename(item[2]);
			employeeVO.setBirthday(item[3].trim().length() == 0? null:stringToDate(item[3],"yyyy-MM-dd"));
			employeeVO.setSex(new Short(item[4]));
			employeeVO.setCardid(item[5].trim().length() == 0?null:item[5]);
//			employeeVO.setTelephone(item[6].trim().length() == 0?null:item[6]);
			employeeVO.setPvtemail(item[6].trim().length() == 0 ? null:item[6]);
			employeeVO.setEdulevel(item[7].trim().length() == 0?null:new Short(item[7]));
			employeeVO.setCityid(item[8]);
			employeeVO.setCountyid(item[9]);
			employeeVO.setSvccode(item[10].trim().length() == 0?null:item[10]);
		    if (null != item[11] && !("").equals(item[11])){
		    	WayVO wayVO = way.doFindByPk2(item[11]);
		    	if(null==wayVO){
		    	throw new Exception("此渠道编码" +item[11] + "不存在");
		    	}else{
			    	employeeVO.setWayid(item[11]);	
			    }
		    }
			employeeVO.setIntime(stringToDate(item[12],"yyyy-MM-dd"));
			employeeVO.setContacttype(new Short(item[13]));
			employeeVO.setEmploytype(new Short(item[14]));
			employeeVO.setBail(item[15].trim().length() ==0?null:new Double(item[15].trim()));
			employeeVO.setEmpstatus(new Short(item[16]));
			if ("1"==item[16] || ("1").equals(item[16])){
			    employeeVO.setOuttime(new Date());
				}
			employeeVO.setSelectmobile(item[17].trim().length()==0?null:item[17]);
			employeeVO.setOprcode2(item[18].trim().length() == 0?null:item[18]);
			
			if (param92 != null && param92.equals("1") 
					&& item[19] != null && item[19].trim().equals("1")) {
				employeeVO.setIsnet(new Short("1"));
			}
		}
			//检测固定参数
			User tuser=(User)user;
			if(!CheckUtil.getInstance().checkDictitem("CH_SEX",(""+employeeVO.getSex()), tuser))
			{
				throw new JOPException("[性别]:"+employeeVO.getSex()+"\t固定参数不正确");
			}
			if(employeeVO.getContacttype()!=null && !CheckUtil.getInstance().checkDictitem("CH_CONTACTTYPE", (""+employeeVO.getContacttype()), tuser))
			{
				throw new JOPException("[劳动关系]:"+employeeVO.getContacttype()+"固定参数不正确");
			}
			if(employeeVO.getEmploytype()!=null && !CheckUtil.getInstance().checkDictitem("CH_EMPLOYTYPE", (""+employeeVO.getEmploytype()), tuser))
			{
				throw new JOPException("[用工性质]:"+employeeVO.getEmploytype()+"固定参数不正确");
			}
			if(employeeVO.getEmpstatus()!=null && !CheckUtil.getInstance().checkDictitem("CH_EMPSTATUS", (""+employeeVO.getEmpstatus()), tuser))
			{
				throw new JOPException("[用工状态]:"+employeeVO.getEmpstatus()+"固定参数不正确");
			}
			//检测逻辑
			employeeVO=checkWaynet(dbVO, employeeVO, user, isCreate);
			if(isCreate)
			{   
				 WayVO wayVO = null;
				//批量新增暂时不放开地市公司和分公司的检测
				if(null != employeeVO.getWayid() || !("").equals(employeeVO.getWayid())){ 
				   wayVO = way.doFindByPk2(employeeVO.getWayid());
				}else{
					throw new Exception("此渠道编码" +item[11] + "不存在");
				}
				if (employeeVO.getCityid() != null
						&& wayVO.getCityid() != null
						&& !employeeVO.getCityid().trim().equals(
								wayVO.getCityid().trim())) {
					throw new Exception("[地市公司]" + employeeVO.getCityid()
							+ "和所选渠道的地市公司" + wayVO.getCityid() + "不一致");
				}
				if (employeeVO.getCountyid() != null
						&& !employeeVO.getCountyid().trim().equals(wayVO.getCountyid())) {
					throw new Exception("[分公司]:" + employeeVO.getCountyid()
							+ "和所选渠道的分公司" + wayVO.getCountyid() + "不一致");
				}
				emp.doCreateSociety(employeeVO, user);		
			}
			else{
				emp.doUpdate(employeeVO, user);
			}
		
	}
	
	/**
	 * 自动分配人员ID
	 * @return 格式:地市标识+Sequence  一次请求如果经过100000次分配都找不到满足条件的ID则抛出异常
	 * @param i 最多经过多少次分配,i<0表无限请求,否则超过请求次数还未找到满足的ID则抛出异常
	 * @throws Exception 
	 */
	public String doAutoCreateEmployee(int i) throws Exception {
		// TODO Auto-generated method stub
/*		为避免生成的人员编码与之前已有的编码发生冲突，先检查生成的人员编码是否在系统已经存在，
		如果不存在说明不重复成功，如果已经存在，取地市标志+序列号的下一值，继续判断是否在库表已经存在，
		直到生成的人员编码不与数据库已有编码重复为止。
		例如：当前序列号是10000007，取下一个值是10000008，数据库已存在人员编码FS10000007，FS10000008，FS10000009，
		由于FS10000008在库表已经存在，继续判断FS10000009也在库表存在，
		继续判断FS10000010不存在，最终生成的人员编码是FS10000010.
*/		
		String newemployeeid=null;
		if(null == user.getCityid())
		{	
			throw new Exception(" 地市标识为空 ");
		}
		EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,user);
		newemployeeid=getEmployeeid(user);
		//查找次数,已经查找了一次
		int n=1;
		EmployeeVO oldVO = (EmployeeVO) dao.findByPk(newemployeeid);
		while (oldVO != null) {
			if(n>i && i>0)
			{
				throw new Exception(" 经 "+n+" 次分配 未找到满足人员的标识 ");
			}
			newemployeeid = getEmployeeid(user);
			oldVO = (EmployeeVO) dao.findByPk(newemployeeid);
			n++;
		}
		return newemployeeid;
	}
	
	/**
	 * 网点新增,修改检测公用逻辑方法,注意在修改完所有的值以后调用(新增的时候oldVO传空进来
	 * @param oldvo
	 * @param updateVO
	 * @param user
	 * @throws Exception
	 */
	public EmployeeVO checkWaynet(EmployeeVO dbVO,EmployeeVO updateVO,DBAccessUser user,boolean isCreate) throws Exception
	{
		//如果是店主,并且修改后的值是在岗状态
		if (updateVO.getIsnet()!=null && updateVO.getIsnet() == 1 && updateVO.getEmpstatus() == 0) {
			if (isCreate) {

				if (!jdugeIsNetChange(updateVO.getWayid(), user)) {
					throw new Exception("一个网点只能有一个店主");
				}
				// 只有店主才生成网点确认码
				updateVO.setNetpass(CMSUtils.genRandomNumer(6));// 网点确认码六位随机数
			} else {
				if (!jdugeIsNetChange(updateVO.getWayid(), user,updateVO.getEmployeeid())) {
					throw new Exception("一个网点只能有一个店主");
				}
			}

		}
		if(updateVO.getEmpstatus()!=null && updateVO.getEmpstatus().shortValue()==(short)0)
		{
		// 判断采集平台捆绑手机号码,前提是前台限制了11位数字
		// 判断空中选号手机号码
		if (updateVO.getOfficetel() != null
				&& updateVO.getOfficetel().trim().length() == 11) {
			if (isCreate) {
				checkOfficeTel(updateVO.getOfficetel(), user);
				checkSelectmobile(updateVO);
			}
			//手机号码发生变动需要同时检测
			else if (dbVO.getOfficetel() != null
					&& !updateVO.getOfficetel().equals(dbVO.getOfficetel())) {
				checkOfficeTel(updateVO.getOfficetel(), user);
				checkSelectmobile(updateVO);
			}
			//离职状态改成在岗状态需要检测
			else if(dbVO.getEmpstatus()!=null && dbVO.getEmpstatus().shortValue()==(short)1){
				checkOfficeTel(updateVO.getOfficetel(), user);
				checkSelectmobile(updateVO);
			}
		}
			
		}
		//判断是否同地市.
		checkTelCity(updateVO.getOfficetel(), user);
		//
		if (updateVO.getOprcode2() != null && !updateVO.getOprcode2().trim().equals("")) {
			// 判断工号是否在工号表存在
			checkOpercode(updateVO,user);
			// 判断工号是否已经存在
			if (isCreate
					|| (!isCreate && dbVO.getOprcode2() != null
							&& updateVO.getOprcode2() != null && !updateVO
							.getOprcode2().equals(dbVO.getOprcode2()))) {
				if (doFindByOprcode(updateVO.getOprcode2(), user) != null)
					throw new Exception("员工档案信息表已经存在该工号");
			} 
		}
	return updateVO;
	}
	
	//检查输入渠道是否是当前登录工号所在渠道或者及其下属渠道
	private boolean checkWayid(String wayid,String loginwayid) throws Exception{
		EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,user);
		EmployeeDBParam params = new EmployeeDBParam();
		params.getQueryConditions().put("loginwayid", loginwayid);
		params.getQueryConditions().put("wayid",wayid);
		Integer result = (Integer)dao.queryUniqueByNamedSqlQuery("com.gmcc.pboss.business.channel.employee.checkwayid", params);
		return result>0;
	}

	public DataPackage doZjtyQuery(String wayid, EmployeeDBParam params)
			throws Exception {
		EmployeeDAO dao = (EmployeeDAO) DAOFactory.build(EmployeeDAO.class,user);
		params.getQueryConditions().put("basewayid", wayid);
		return dao.queryByNamedSqlQuery("com.gmcc.pboss.business.channel.employee.zjtyquerybywayid",params);
	}
}
