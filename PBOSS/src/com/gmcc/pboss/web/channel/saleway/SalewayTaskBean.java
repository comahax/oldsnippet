package com.gmcc.pboss.web.channel.saleway;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.gmcc.pboss.business.channel.bchcontact.BchcontactVO;
import com.gmcc.pboss.business.channel.changelog.ChangelogVO;
import com.gmcc.pboss.business.channel.common.AuditUtils;
import com.gmcc.pboss.business.channel.employee.EmployeeDBParam;
import com.gmcc.pboss.business.channel.employee.EmployeeVO;
import com.gmcc.pboss.business.channel.way.AGWayVO;
import com.gmcc.pboss.business.channel.way.WayDAO;
import com.gmcc.pboss.business.channel.way.WayDBParam;
import com.gmcc.pboss.business.channel.way.WayVO;
import com.gmcc.pboss.business.channel.wayaccount.WayaccountVO;
import com.gmcc.pboss.business.channel.waybusicircle.WaybusicircleDBParam;
import com.gmcc.pboss.business.channel.waybusicircle.WaybusicircleVO;
import com.gmcc.pboss.business.channel.waycompact.WaycompactVO;
import com.gmcc.pboss.business.channel.wayprovince.WayprovinceVO;
import com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean;
import com.gmcc.pboss.common.batch.processfile.ResultVO;
import com.gmcc.pboss.control.base.sysparam.Sysparam;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.channel.bchcontact.Bchcontact;
import com.gmcc.pboss.control.channel.bchcontact.BchcontactBO;
import com.gmcc.pboss.control.channel.changelog.Changelog;
import com.gmcc.pboss.control.channel.changelog.ChangelogBO;
import com.gmcc.pboss.control.channel.employee.Employee;
import com.gmcc.pboss.control.channel.employee.EmployeeBO;
import com.gmcc.pboss.control.channel.way.AGWay;
import com.gmcc.pboss.control.channel.way.AGWayBO;
import com.gmcc.pboss.control.channel.way.Way;
import com.gmcc.pboss.control.channel.way.WayBO;
import com.gmcc.pboss.control.channel.wayaccount.Wayaccount;
import com.gmcc.pboss.control.channel.wayaccount.WayaccountBO;
import com.gmcc.pboss.control.channel.waybusicircle.Waybusicircle;
import com.gmcc.pboss.control.channel.waybusicircle.WaybusicircleBO;
import com.gmcc.pboss.control.channel.waycompact.Waycompact;
import com.gmcc.pboss.control.channel.waycompact.WaycompactBO;
import com.gmcc.pboss.control.channel.wayprovince.Wayprovince;
import com.gmcc.pboss.control.channel.wayprovince.WayprovinceBO;
import com.sunrise.jop.common.utils.bean.BeanUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DAOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;

public class SalewayTaskBean extends BaseBatchTaskBean {
	
	//private AGWay delegate;

	//private Way wayDelegate;

	public static long lineArrIndex[] = null;

	private boolean customeFlag = false;

	private String resStr = "";
	private String param75 = "";
	
	public SalewayTaskBean() throws Exception {
		try {
			super.setBatchName("社会网点信息管理批量导入");
			super.setOprtype("导入");
			super.setWriteLog(true);
			//delegate = (AGWay)BOFactory.build(AGWayBO.class, user);
			//wayDelegate = (Way)BOFactory.build(WayBO.class, user);
		} catch (Exception ex) {
			ex.printStackTrace(System.err);
		}
	}

	protected String doStart() {
		return "社会网点信息管理批量导入结果  \r\n";
	}

	/**
	 * 处理一条记录
	 */
	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		String msg = "";
		String[] items = StringUtils.splitPreserveAllTokens(line, "|");
		for(int i=0;i<items.length;i++)
		{
			items[i]=items[i].trim();
		}
		String op = "增加";
		// 检查列数,判断是否自定义新增
		try {
			Sysparam sysparamBO = (SysparamBO)BOFactory.build(SysparamBO.class,user);
			//1:退出时需要填写原因 0:不用填写退出原因 空:不用填写退出原因
			 param75 = sysparamBO.doFindByID("75", "channel"); 
			 
			AGWay delegate = (AGWay)BOFactory.build(AGWayBO.class, user);
			Way wayDelegate = (Way)BOFactory.build(WayBO.class, user); 
			 
			if (("1").equals(param75)) {
				if (rowCount == 1 && SalewayCheck.lineArr1[0].equals(items[0])) {
					if (SalewayCheck.lineArr1[0].equals(items[0])) {
						customeFlag = true;
						checkHead(items, user);
						resultVO.setInfo("自定义导入修改:序号|"+line+" |出错信息");
		 //				resultVO.setOk(true);
		//				ok--;
						fail--;
						countrecord--;
						currentrecord--;
						return resultVO;
					} else {
						customeFlag = false;
					}
				} else if (rowCount > 1 && customeFlag) {
					if (delegate.doFindByPk(items[0], user) == null) {
						throw new Exception("需要更新的渠道编码不存在:"+items[0]);
					}
					items=checkLines(items, user);
				}
			}else {
				if (rowCount == 1 && SalewayCheck.lineArr[0].equals(items[0])) {
					if (SalewayCheck.lineArr[0].equals(items[0])) {
						customeFlag = true;
						checkHead(items, user);
						resultVO.setInfo("自定义导入修改:序号|"+line+" |出错信息");
						resultVO.setOk(true); 
						countrecord--;
						return resultVO;
					} else {
						customeFlag = false;
					}
				} else if (rowCount > 1 && customeFlag) {
					if (delegate.doFindByPk(items[0], user) == null) {
						throw new Exception("需要更新的渠道编码不存在:"+items[0]);
					}
					items=checkLines(items, user);
				}
				
			}

			int cando = 0;
			String[] propertyname = new String[] { "wayid", "wayname",
					"waysubtype", "upperwayid", "starlevel", "pt", "waystate",
					"cityid", "countyid", "svccode", "mareacode",
					"isstraitprd", "adtypecode", "adacode", "formtype",
					"buzarea", "logiscode", "waymagcode", "bchlevel",
					"officetel", "alarmbizamount", "address", "latitude",
					"longtitude", "principal", "principaltel",
					"principalphone", "principalemail", "sendaddr", "recpers",
					"recconntel", "reccertno", "compacttype", "compactno",
					"compactname", "signtime", "begintime", "cmpendtime",
					"licenceno", "licvalidate", "bail", "bailstatus",
					"baillwrlmt", "bankname", "acctno", "acctname", "acctfid",
					"signstatus", "bailtype", "servbound", "provcode",
					"deacctno", "deacctname", "debankname", "chainhead",
					"isb2m", "accttype", "debankid", "destate", "custtype",
					"regid", "isKzcz", "isunpb", "buztypecode", "istop",
					"rewardkind", "buscno", "wayattr", "waymod", "creditlevel",
					"taxcertificate", "checked" };
			
			String wayid = items[0];
			AGWayVO vo = new AGWayVO();
			WayVO waytemp = wayDelegate.doFindByPk(wayid);
			if("1".equals(param75)){
				if(!"1".equals(items[6])){
					Changelog changelogBO = (ChangelogBO)BOFactory.build(ChangelogBO.class, user);
					ChangelogVO clVO = new ChangelogVO();
					clVO.setOptime(new Date());//操作时间
					clVO.setOprcode(user.getOprcode());//操作员工号
					clVO.setOprtype("update");//操作类型
					clVO.setWayid(wayid);//渠道编码
					clVO.setChangetype(Short.parseShort("2"));//变动类型
					if (waytemp != null) {
						clVO.setOldvalue(""+waytemp.getWaystate());//变动前值  修改by ydr
					} else {
						clVO.setOldvalue("");
					}
					if ("".equals(items[6])) {
						if (waytemp != null) {
							clVO.setNowvalue(""+waytemp.getWaystate());//自定义导入变动后的值
						}						
					} else {
						clVO.setNowvalue(items[6]);//变动后值
					}
					/* star uppdate for (2013)NBBOSS- D0019 渠道优化概要设计     by feng */
					clVO.setMemo(items[80]);//备注：新增字段后需要更改此序号！
					/* end uppdate for (2013)NBBOSS- D0019 渠道优化概要设计     by feng */
										
					changelogBO.doCreate(clVO);
					
				}
			}
			
			if (waytemp != null) {
				op = "修改";
				AGWayVO oldvo = new AGWayVO();
				
				vo=setAGWayVO(items,op);
				doUpdatews(vo.getWayid(),vo.getWaystate());
				doSaveOrUpdateWP(vo);
				Bchcontact bchcontactDelegate = (Bchcontact)BOFactory.build(BchcontactBO.class, user);
				Waycompact waycompactDelegate = (Waycompact)BOFactory.build(WaycompactBO.class,user);
				Wayaccount wayaccountDelegate = (Wayaccount)BOFactory.build(WayaccountBO.class, user);
				Employee employeeDelegate = (Employee)BOFactory.build(EmployeeBO.class, user);
				BchcontactVO bchcontactVO = bchcontactDelegate.doFindByPk(
						wayid);
				WaycompactVO waycompactVO = waycompactDelegate.doFindByPk(
						wayid);
				WayaccountVO wayaccountVO = new WayaccountVO();
				wayaccountVO.setWayid(wayid);
				wayaccountVO.setAccid(new Integer(0));
				wayaccountVO = wayaccountDelegate
						.doFindByPk(wayaccountVO);
				
				BeanUtils.copyProperties(oldvo, waytemp);
				if (bchcontactVO != null) {
					BeanUtils.copyProperties(oldvo, bchcontactVO);
				}
				if (waycompactVO != null) {
					BeanUtils.copyProperties(oldvo, waycompactVO);
					oldvo.setCmpendtime(waycompactVO.getEndtime());
				}
				if (wayaccountVO != null) {
					BeanUtils.copyProperties(oldvo, wayaccountVO);
				}
				
				//判断导入状态是否有效状态
				if("0".equals(items[6])){
					//渠道状态设置为失效时，更新渠道下的所有人员数据为离职
					ArrayList<Short> _nin_isnet = new ArrayList<Short>();
					_nin_isnet.add(Short.valueOf("0"));
					_nin_isnet.add(Short.valueOf("1"));
					
					EmployeeDBParam params = new EmployeeDBParam();
					params.set_se_wayid(wayid);
					params.set_ne_empstatus("0");
					params.set_nin_isnet(_nin_isnet);
					
					EmployeeBO employeeBO = (EmployeeBO) BOFactory.build(EmployeeBO.class, user);
					DataPackage empdp = employeeBO.doQuery(params);
					if (empdp != null && empdp.getDatas() != null && empdp.getDatas().size() > 0) {
						EmployeeVO empVO = null;
						for (int i = 0; i < empdp.getDatas().size(); i++) {
							empVO = (EmployeeVO) empdp.getDatas().get(i);
							empVO.setEmpstatus(Short.valueOf("1"));
							empVO.setOuttime(new Date());
							employeeBO.doUpdate(empVO);
						}
					}
												
						AuditUtils.copyPropertiesSetNull(oldvo, vo, propertyname, items);
						WayDAO dao = (WayDAO) DAOFactory.build(WayDAO.class, user);
						WayVO newVO = null;
						BeanUtils.copyProperties(oldvo, vo);
						
						cando = delegate.doUpdateState(oldvo, user);
						
					resultVO.setOk(true);
					resultVO.setInfo(showInfo(resultVO, items, rowCount, op));
					return resultVO;
				}
				//商圈信息
				Waybusicircle waybusicircleBO = (WaybusicircleBO)BOFactory.build(WaybusicircleBO.class,user);
				WaybusicircleDBParam waybusicircleDBParam = new WaybusicircleDBParam();
				waybusicircleDBParam.set_se_wayid(wayid);
				DataPackage WaybusicircleDP = waybusicircleBO.doQuery(waybusicircleDBParam);
				if(WaybusicircleDP != null && !"".equals(WaybusicircleDP)
						&& WaybusicircleDP.getDatas() != null && !"".equals(WaybusicircleDP.getDatas())
						&& WaybusicircleDP.getDatas().size() > 0){
					WaybusicircleVO wbVO = (WaybusicircleVO)WaybusicircleDP.getDatas().get(0);
					BeanUtils.copyProperties(oldvo, wbVO);
				}
				
				// 查找公务机号码
				EmployeeDBParam listVO = new EmployeeDBParam();
				listVO.set_se_wayid(wayid);
				listVO.set_ne_isnet("1");
				listVO.set_ne_empstatus("0");
				Iterator iterator = employeeDelegate.doQuery(listVO)
						.getDatas().iterator();
				if (iterator.hasNext()) {
					oldvo.setOfficetel(((EmployeeVO) iterator.next())
							.getOfficetel());
				}
				AuditUtils
						.copyPropertiesSetNull(oldvo, vo, propertyname, items);

				SalewayAction salewayaction = new SalewayAction();
				salewayaction.checkUpdateStartLevel(oldvo,user);
				
				cando = delegate.doUpdate(oldvo, user);
			} else {
				vo=setAGWayVO(items,op);
				doUpdatews(vo.getWayid(),vo.getWaystate());
				doSaveOrUpdateWP(vo);
				SalewayAction salewayaction = new SalewayAction();
				salewayaction.checkAddStartLevel(vo);
				
				cando = delegate.doCreate(vo, user);
			}
			
			if(vo.getWaystate() == 0){
				ArrayList<Short> _nin_isnet = new ArrayList<Short>();
				_nin_isnet.add(Short.valueOf("0"));
				_nin_isnet.add(Short.valueOf("1"));
				
				EmployeeDBParam params = new EmployeeDBParam();
				params.set_se_wayid(wayid);
				params.set_ne_empstatus("0");
				params.set_nin_isnet(_nin_isnet);
				
				EmployeeBO employeeBO = (EmployeeBO) BOFactory.build(EmployeeBO.class, user);
				DataPackage empdp = employeeBO.doQuery(params);
				if (empdp != null && empdp.getDatas() != null && empdp.getDatas().size() > 0) {
					EmployeeVO empVO = null;
					for (int i = 0; i < empdp.getDatas().size(); i++) {
						empVO = (EmployeeVO) empdp.getDatas().get(i);
						empVO.setEmpstatus(Short.valueOf("1"));
						employeeBO.doUpdate(empVO);
					}
				}
			}
			
			resultVO.setOk(true);
			resultVO.setInfo(showInfo(resultVO, items, rowCount, op));
			return resultVO;
		} catch (Exception ex) { // 插入失败
			ex.printStackTrace();
			msg = ex.getMessage();
			resultVO.setOk(false);
			resultVO.setInfo(showInfo(resultVO, items, rowCount, op) + msg);
			return resultVO;
		}
	}
	
	public void doSaveOrUpdateWP(AGWayVO vo) throws Exception{		
		WayprovinceVO wpVO = new WayprovinceVO();
		BeanUtils.copyProperties(wpVO, vo);
		
		Wayprovince wayprovince = (Wayprovince) BOFactory.build(WayprovinceBO.class, user);			
		List wList = wayprovince.doQueryWpByWayid(vo.getWayid());
		
		if(wList != null && !"".equals(wList) && wList.size()>0){
			WayprovinceVO wVO = (WayprovinceVO)wList.get(0);
			BeanUtils.copyProperties(wVO, vo);
			wayprovince.doUpdate(wVO);
		}else{
			wayprovince.doCreate(wpVO);	
		}
	}
	
	/**
	 * dengxingxin add
	 * 渠道状态   上级渠道状态字段设置为‘0:暂停营业、-1:已关店’时，要更新其子渠道都为相应状态。
	 */
	public void doUpdatews(String wayid, Short waystate ) throws Exception{
		
		Way way = (Way) BOFactory.build(WayBO.class, user);
		DataPackage dp=null;
		WayDBParam wparams = new WayDBParam();
		wparams.set_se_wayid(wayid);
		wparams.setDataOnly(true);
		wparams.set_pagesize("0");
		dp = way.doQuerySubSaleway(wparams, user);
		if(dp != null && !"".equals(dp)
				&& dp.getDatas() != null && !"".equals(dp.getDatas())
				&& dp.getDatas().size() > 0){
			Way wwayBO = (WayBO) BOFactory.build(WayBO.class, user);
			for(int k=0 ; k<dp.getDatas().size() ; k++){
				WayVO wayVO = (WayVO)dp.getDatas().get(k);
				if(waystate == 0){
					wayVO.setWaystate(waystate);
					wwayBO.doUpdateNotCon(wayVO);
				}else{
					
				}
			}
		}
	}
	
	/**
	 * 结果文件格式
	 */
	public String showInfo(ResultVO resultVO, String[] items, int rowCount,
			String op) {
		final String COMPART = " | "; // 分隔
		StringBuffer resultStr = new StringBuffer();
		// 序号
		if(this.customeFlag){
			resultStr.append(rowCount - 1).append(COMPART);
		} else {
			if (rowCount == 1) {
				resultStr.append("序号 |").append(SalewayCheck.lineHead)
						.append(" |出错信息\r\n");
			}
			resultStr.append(rowCount).append(COMPART);
		}
		for (int i = 0; i < items.length; i++) {
			if (!"".equals(items[i])) {
				resultStr.append(items[i]).append(COMPART);
			}
		}
		resultStr.append(op);
		// 办理结果
		if (resultVO.isOk()) {
			resultStr.append("成功");
		} else {
			resultStr.append("失败");
		}
		resultStr.append(COMPART);
		return resultStr.toString();
	}

	private AGWayVO setAGWayVO(String items[],String op) throws Exception {
		AGWayVO vo = new AGWayVO();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Way wayDelegate = (Way)BOFactory.build(WayBO.class, user);
			if (!"".equals(items[3])) {
				WayVO upperVO = wayDelegate.doFindByPk(items[3]);
				if (upperVO == null) {
					throw new Exception("上级渠道不存在：" + items[3]);
				}

				if (!"GMPT".equals(upperVO.getWaysubtype())
						&& !"DIS".equals(upperVO.getWaysubtype())
						&& !"G100".equals(upperVO.getWaysubtype())
						&& !"D4S".equals(upperVO.getWaysubtype())
						&& !"D5S".equals(upperVO.getWaysubtype())
						&& !"D6S".equals(upperVO.getWaysubtype())) {
					throw new Exception("录入的上级渠道只能是连锁经营合作商，移动部门/科室或服务厅");
				}
				if ("DIS".equals(upperVO.getWaysubtype())) {
					vo.setCatetype(new Short((short) 0));
				} else {
					vo.setCatetype(new Short((short) 1));
				}
			}
			/**
			 * 渠道编码0|渠道名称1|零售渠道类别2|上级渠道编码3|星级4|排他性5|状态6|地市公司7|分公司8|服务销售中心9|
			 * 微区域10|合作层级11|是否直供12|区域类型13|行政区划14|业态类型15|开业时间16|营业面积17|所属物流商18|所属渠道经理19|
			 * 分级20|活动手机号码21|业务预警量22|详细地址23|地理纬度24|地理经度25
			 */

			vo.setWayid(items[0]);
			vo.setWayname(items[1]);
			vo.setWaysubtype(items[2]);
			vo.setUpperwayid(items[3]);
			if (!isNull(items[4])) {
				vo.setStarlevel(new Long(items[4]));
			}
			if (!isNull(items[5])) {
				vo.setPt(new Long(items[5]));
			}
			if (!isNull(items[6])) {
				vo.setWaystate(new Short(items[6]));
			} else {
				if (!("").equals(wayDelegate.doFindByPk(items[0]).getWaystate().toString())){ 
				     vo.setWaystate((short)wayDelegate.doFindByPk(items[0]).getWaystate());
				} else {
					 vo.setWaystate(new Short((short) 1));
				}
			}
			vo.setCityid(items[7]);
			vo.setCountyid(items[8]);
			vo.setSvccode(items[9]);
			vo.setMareacode(items[10]);
			vo.setIsstraitprd(isNull(items[11]) ? null : new Short(items[11]));
			if (!isNull(items[12])) {
				vo.setAdtypecode(new Short(items[12]));
			}
			vo.setAdacode(items[13]);
			if (!isNull(items[14])) {
				vo.setFormtype(new Short(items[14]));
			}
//			if (!isNull(items[15])) {
//				try {
//					vo.setStarttime(format.parse(items[15]));
//				} catch (ParseException e) {
//					throw new Exception("[开业时间]格式不对,应为yyyy-MM-dd");
//				}
//			}
			if (!isNull(items[15])) {
				vo.setBuzarea(new Long(items[15]));
			}
			vo.setLogiscode(items[16]);
			vo.setWaymagcode(items[17]);
			vo.setBchlevel(items[18]);
			vo.setOfficetel(items[19]);
			if (!isNull(items[20])) {
				vo.setAlarmbizamount(new Integer(items[20]));
			}
			vo.setAddress(items[21]);
			vo.setLatitude(items[22]);
			vo.setLongtitude(items[23]);
			vo.setWaytype("AG");

			/**
			 * 业主姓名26|业主电话27|
			 * 业主固定电话28|业主电子信箱29|送货地址30|收货联系人31|收货联系号码32|收货人证件号码33
			 */
			vo.setPrincipal(items[24]);
			vo.setPrincipaltel(items[25]);
			vo.setLinkman(items[24]);
			vo.setLinkmantel(items[25]);
			vo.setPrincipalphone(items[26]);
			vo.setPrincipalemail(items[27]);
			vo.setSendaddr(items[28]);
			vo.setRecpers(items[29]);
			vo.setRecconntel(items[30]);
			vo.setReccertno(items[31]);

			/**
			 * 签约类型34|合同编码35|合同协议名称36|签署合同时间37|合同协议生效时间38|
			 * 合同到期日39|营业执照编号40|营业执照有效期41|保证金押金42|保证金押金状态43|保证金下限44
			 */
			if (!isNull(items[32])) {
				vo.setCompacttype(new Short(items[32]));
			}
			vo.setCompactno(items[33]);
			vo.setCompactname(items[34]);
			try {
				vo.setSigntime(isNull(items[35]) ? null : new Date(format
						.parse(items[35]).getTime()));
			} catch (ParseException e) {
				throw new Exception("[签署合同时间]格式不对,应为yyyy-MM-dd");
			}
			try {
				vo.setBegintime(isNull(items[36]) ? null : new Date(format
						.parse(items[36]).getTime()));
			} catch (ParseException e) {
				throw new Exception("[合同生效日]格式不对,应为yyyy-MM-dd");
			}
			try {
				vo.setCmpendtime(isNull(items[37]) ? null : new Date(format
						.parse(items[37]).getTime()));
			} catch (ParseException e) {
				throw new Exception("[合同到期日]格式不对,应为yyyy-MM-dd");
			}
			vo.setLicenceno(items[38]);
			try {
				vo.setLicvalidate(isNull(items[39]) ? null : new Date(format
						.parse(items[39]).getTime()));
			} catch (ParseException e) {
				throw new Exception("[营业执照有效期]格式不对,应为yyyy-MM-dd");
			}
			if (!isNull(items[40])) {
				vo.setBail(new Double(items[40]));
			}
			if (!isNull(items[41])) {
				vo.setBailstatus(new Short(items[41]));
			}
			if (!isNull(items[42])) {
				vo.setBaillwrlmt(new Double(items[42]));
			}

			/**
			 * 开户银行45|银行帐号46|开户账号名称47|开户人身份证号码48
			 */
			vo.setAccid(new Integer(0));
			vo.setChargetype(new Short((short) 0));
			/* star uppdate for (2013)NBBOSS- D0019 渠道优化概要设计     by feng */
			if (op.equals("增加")){
				vo.setAccttype(new Short((short) 0));
			}
			/* end uppdate for (2013)NBBOSS- D0019 渠道优化概要设计     by feng */
			vo.setBankname(items[43]);
			vo.setAcctno(items[44]);
			vo.setAcctname(items[45]);
			vo.setAcctfid(items[46]);
			if (!isNull(items[47])) {
				vo.setSignstatus(new Long(items[47]));
			}
			if (!isNull(items[48])) {
				vo.setBailtype(new Short(items[48]));
			}
			if (!isNull(items[49])) {
				vo.setServbound(new Short(items[49]));
			}
			if (!isNull(items[50])) {
				vo.setProvcode(items[50]);
			}
			if (!isNull(items[51])) {
				vo.setDeacctno(items[51]);
			}
			if (!isNull(items[52])) {
				vo.setDeacctname(items[52]);
			}
			if (!isNull(items[53])) {
				vo.setDebankname(items[53]);
			}
			if (!isNull(items[54])) {
				vo.setChainhead(items[54]);
			}
			if (!isNull(items[55])) {
				vo.setIsb2m(new Short(items[55]));
			}
			if (!isNull(items[56])) {
				vo.setAccttype(new Short(items[56]));
			}
			if (!isNull(items[57])) {
				vo.setDebankid(items[57]);
			}
			if (!isNull(items[58])) {
				vo.setDestate(new Byte(items[58]));
			}
			if (!isNull(items[59])) {
				vo.setCusttype(items[59]);
			}
			if (!isNull(items[60])) {
				vo.setRegid(items[60]);
			}
			//新增时，设置【是否授权网点】为否
			/*WayVO oVO = wayDelegate.doFindByPk(items[0]);
			if(oVO == null || "".equals(oVO))
				vo.setChecked("N");*/
			//是否授权网点
			/*if (!isNull(items[61])) {
				vo.setChecked(items[61]);
			}*/
			//主要业务支撑方式
			if(items[61] != null && !"".equals(items[61]))
				vo.setConnecttype(Long.parseLong(items[61]));
			//是否接入空中充值平台
			if(items[62] != null && !"".equals(items[62]))
				vo.setIsKzcz(Long.parseLong(items[62]));
			//全网统一渠道编码
			vo.setUniquewayid(items[63]);
			//乡镇
			vo.setTown(items[64]);
			//渠道基础类型
			if(items[65] != null && !"".equals(items[65]))
				vo.setProvtype(Short.parseShort(items[65]));
			//是否手机卖场
			if(items[66] != null && !"".equals(items[66]))
				vo.setMobilemall(Short.parseShort(items[66]));
			//前台营业面积（㎡）
			if(items[67] != null && !"".equals(items[67]))
				vo.setFrontarea(Double.parseDouble(items[67]));
			//运营商ISP接入方式
			if(items[68] != null && !"".equals(items[68]))
				vo.setIspconntype(Short.parseShort(items[68]));
			//是否加入全员代理模式
			if(items[69] != null && !"".equals(items[69]))
				vo.setIsunpb(Short.parseShort(items[69]));
			//星级分层
			if(items[70] != null && !"".equals(items[70]))
				vo.setStarlev(items[70]);
			// 上级渠道编码3|地市公司7|分公司8|服务销售中心9|微区域10| 根据上级渠道编码来给5678字段给值
			if (!isNull(items[3])) {
				WayVO checkVO = wayDelegate.doFindByPk(items[3]);
				if (checkVO == null) {
					throw new Exception("[上级渠道编码]不存在!");
				} else {
					vo.setCityid(checkVO.getCityid());
					if(checkVO.getCountyid()!=null)
					{
					vo.setCountyid(checkVO.getCountyid());
					}
				}
			}
			//检查经度纬度
			if(!isNull(items[22])||!isNull(items[23])){
				checkLongtitude(items[22],items[23],items[0],op);
				}
			//商圈类型
			if(items[71] != null && !"".equals(items[71]))
				vo.setBuztypecode(Short.parseShort(items[71]));
			//是否TOP网点
			vo.setIstop(items[72]);
			/* star uppdate for (2013)NBBOSS- D0019 渠道优化概要设计     by feng */
			//社会渠道类型
			if(items[73] != null && !"".equals(items[73])){
				vo.setRewardkind(items[73]);
			}
			//商圈编码
			if(items[74] != null && !"".equals(items[74])){
				vo.setBuscno(items[74]);
			}
			//连锁加盟渠道属性
			if(items[75] != null && !"".equals(items[75])){
				vo.setWayattr(items[75]);
			}
			//连锁加盟渠道系数
			if(items[76] != null && !"".equals(items[76])){
				vo.setWaymod(items[76]);
			}
			//信用等级
			if(items[77] != null && !"".equals(items[77])){
				vo.setCreditlevel(items[77]);
			}
			//税务资质
			if(items[78] != null && !"".equals(items[78])){
				vo.setTaxcertificate(Short.parseShort(items[78]));
			}
			//是否授权网点
			if(items[79] != null && !"".equals(items[79])){
				vo.setChecked(items[79]);
			}
			/* end uppdate for (2013)NBBOSS- D0019 渠道优化概要设计     by feng */
		} catch (NumberFormatException e) {
			throw new Exception("数字格式不对，请检查");
		} catch (Exception e) {e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return vo;
	}

	private boolean isNull(String item) {
		return "".equals(item) || "null".equals(item) || "空".equals(item)||item==null;
	}

	private String [] checkLines(String[] fields, User user) throws Exception {
		// 系统参数查询
		Sysparam sysparam = (Sysparam)BOFactory.build(SysparamBO.class, user);
		String paramvalue = sysparam.doFindByID(new Long("75"), "channel");
		if ("1".equals(paramvalue)) {
			String checkLine[] = new String[81];
			return copyArr(checkLine, resStr, fields);
		} else {
			String checkLine[] = new String[80];
			return copyArr(checkLine, resStr, fields);
		}
		
	}

	private String[] copyArr(String arr[], String str, String fields[]) {
		String temArr[] = StringUtils.splitPreserveAllTokens(str, "|");
		for (int i = 0; i < temArr.length - 1; i++) {
			int temp = -1;
			temp = new Integer(temArr[i]).intValue();
			arr[temp] = fields[i];
		}
		// 把null值转换成""
		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr[i] == null ? "" : arr[i];
		}
		return arr;
	}

	private void checkHead(String[] fields, User user) throws Exception {
		for (int i = 0; i < fields.length; i++) {
			boolean find = false;
			if (("1").equals(param75)) {
				for (int k = 0; k < SalewayCheck.lineArr1.length; k++) {
					if ("".equals(fields[i])) {
						throw new Exception("自定义文件头中不允许有空,且最后一行没有竖线");
					}
					if (fields[i].equals(SalewayCheck.lineArr1[k])) {
						resStr = resStr + k + "|";
						find = true;
						continue;
					}
				}
			}else {
				
				for (int k = 0; k < SalewayCheck.lineArr.length; k++) {
					if ("".equals(fields[i])) {
						throw new Exception("自定义文件头中不允许有空,且最后一行没有竖线");
					}
					if (fields[i].equals(SalewayCheck.lineArr[k])) {
						resStr = resStr + k + "|";
						find = true;
						continue;
					}
				}
				
			}
			
			
			if (!find) {
				throw new Exception("自定义文件头:" + fields[i] + "不正确!");
			}
		}
	}
	public void checkLongtitude(String latitude, String longtitude,
			String wayid,String op) throws Exception {
		Way wayDelegate = (Way)BOFactory.build(WayBO.class, user);
		if(wayDelegate==null)
		{
			wayDelegate=(Way)BOFactory.build(WayBO.class, user);
		}
		WayDBParam waylistvo = new WayDBParam();
		if("增加".equals(op))
		{
			if(!"".equals(latitude) && !"".equals(longtitude) & !"".equals(wayid))
			{
				waylistvo.set_se_latitude(latitude);
				waylistvo.set_se_longtitude(longtitude);
				waylistvo.set_ne_waystate("1");
				if(wayDelegate.doQuery(waylistvo).getRowCount()>0){
					throw new Exception( op + "操作:[纬度值,经度值]:["
							+ latitude + "," + longtitude + "]已经在数据库中存在");
				}
			}
		}else if("修改".equals(op))
		{
			if ("".equals(latitude)) {
				latitude = ((WayVO) wayDelegate.doFindByPk(wayid)).getLatitude() == null ? ""
						: ((WayVO)wayDelegate.doFindByPk(wayid)).getLatitude();
			}
			if ("".equals(longtitude)) {
				longtitude = ((WayVO) wayDelegate.doFindByPk(wayid)).getLongtitude() == null ? ""
						: ((WayVO) wayDelegate.doFindByPk(wayid)).getLongtitude();
			}
			waylistvo.set_se_latitude(latitude);
			waylistvo.set_se_longtitude(longtitude);
			waylistvo.set_ne_waystate("1");
			List waylist = (ArrayList) wayDelegate.doQuery(waylistvo).getDatas();
			for (Iterator wayit = waylist.iterator(); wayit.hasNext();) {
				WayVO wayVO = (WayVO) wayit.next();
				if (!wayVO.getWayid().equals(wayid)) {
					throw new Exception(op + "操作:[纬度值,经度值]:["
							+ latitude + "," + longtitude + "]已经在数据库中存在");
				}
			}
		}
	}
}
