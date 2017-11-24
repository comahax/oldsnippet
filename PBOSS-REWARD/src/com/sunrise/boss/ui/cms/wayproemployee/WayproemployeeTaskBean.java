package com.sunrise.boss.ui.cms.wayproemployee;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;

import com.sunrise.boss.business.cms.audit.common.CityIDMap;
import com.sunrise.boss.business.cms.employee.persistent.EmployeeListVO;
import com.sunrise.boss.business.cms.employee.persistent.EmployeeVO;
import com.sunrise.boss.business.cms.empmodel.persistent.EmpmodelListVO;
import com.sunrise.boss.business.cms.empmodel.persistent.EmpmodelVO;
import com.sunrise.boss.business.cms.nores.persistent.NoresListVO;
import com.sunrise.boss.business.cms.way.persistent.WayListVO;
import com.sunrise.boss.business.cms.way.persistent.WayVO;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.SessionFactoryRouter;
import com.sunrise.boss.common.exception.business.BusinessException;
import com.sunrise.boss.delegate.cms.employee.EmployeeDelegate;
import com.sunrise.boss.delegate.cms.empmodel.EmpmodelDelegate;
import com.sunrise.boss.delegate.cms.nores.NoresDelegate;
import com.sunrise.boss.delegate.cms.way.WayDelegate;
import com.sunrise.boss.delegate.resmanage.nores.nosect.NosectDelegate;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean;
import com.sunrise.boss.ui.commons.batch.processfile.ResultVO;
import com.sunrise.pub.tools.StringSplit;

public class WayproemployeeTaskBean extends BaseBatchTaskBean {
	public WayproemployeeTaskBean() throws Exception {
		super.setBatchName("推广专员信息管理批量导入结果");
		super.setWriteLog(true);
		// TODO Auto-generated constructor stub
	}

	protected String doStart() {
		return "推广专员信息管理批量导入结果 \r\n";
	}

	protected ResultVO processLine(String line, int rowCount) {
		ResultVO resultVO = new ResultVO();
		try {
			String[] content = StringUtils.splitPreserveAllTokens(line, "|");
			
			
			// 是否还需要区分地市,暂时屏蔽.??
			//区分地市
			NosectDelegate nosectDelegate = new NosectDelegate();
			String cityid = nosectDelegate.doQueryCityID(content[1],user);
			User userNew = new User();
			BeanUtils.copyProperties(userNew, user);
			userNew.setCityid(SessionFactoryRouter.conversionCityid2Num(cityid));
			
			//1、判断所属代理商是否存在
			WayDelegate waydelegate=new WayDelegate();
			WayListVO wayListVO = new WayListVO();
			wayListVO.set_se_wayid(content[2]);
			wayListVO.set_ne_waystate(Short.valueOf("1"));
			DataPackage waydp = waydelegate.doQuery(wayListVO, userNew);
			if(waydp.getRowCount()==0){
				throw new BusinessException("","所属代理商不存在");
			}else{
				Collection col = waydp.getDatas();
				Iterator it = col.iterator();
				WayVO wayvo =(WayVO)it.next();
				if(!("GD".equals(wayvo.getCityid())||wayvo.getCityid()==null)){
					if(!wayvo.getCityid().equals(cityid)){
						throw new BusinessException("","手机号码号段所属区域与渠道所属地市不一致!");
					}
				}
			}
			
			// 20111116 add by liuchao 根据导入的每行手机号码的值在im_pr_nores表中查询
//			NoresDelegate noresDelegate=new NoresDelegate();
//			NoresListVO noresListVO=new NoresListVO();
//			noresListVO.set_se_mobileno(content[1]);
//			DataPackage noreDataPackage = noresDelegate.doQuery(noresListVO, userNew);
//			if(noreDataPackage.getRowCount()==0){
//				throw new BusinessException("","导入的手机号码有误");
//			}

			EmployeeDelegate employeeDelegate = new EmployeeDelegate();
			
			//查询人员的渠道编码
			EmployeeListVO listVO=new EmployeeListVO();
			listVO.set_se_telephone(content[1]);
			listVO.set_ne_isnet("2");
			listVO.set_desc("1");
			listVO.set_orderby("regdate");
			DataPackage dp=employeeDelegate.doQuery(listVO, userNew);
			// 操作模式为“0”新增
			if (null != content[0] && ("0".equals(content[0]))) {
				//对于个人推广专员渠道的处理
				//如果存在记录
				if(dp.getRowCount()>0){
					EmployeeVO employeeVO = (EmployeeVO)((List)dp.getDatas()).get(0);
					String wayid = employeeVO.getWayid();
					if(StringUtils.isEmpty(wayid)){
						throw new BusinessException("","推广专员所属渠道编码不存在");
					}
					String wayid2 = CityIDMap.conversionCityid(userNew.getCityid()) + "U_00000";
					//原有渠道等于个人推广专员渠道
					if(wayid.equals(wayid2) || employeeVO.getEmpstatus()==1){
//						throw new BusinessException("", "推广专员已经注册!");
					}
					else{
						throw new BusinessException("", "推广专员已经注册!");
					}
					
					EmployeeVO empVO = buildEmpVO(content, "Update");
					EmployeeVO oldVO = (EmployeeVO) ((List) dp.getDatas())
					.get(0);
					empVO.setEmployeeid(oldVO.getEmployeeid());
					//比较人员状态和渠道编码是否变动.看是否要发短信.
					if(!empVO.getWayid().equals(oldVO.getWayid()) || !empVO.getEmpstatus().equals(oldVO.getEmpstatus()))
						empVO.setChanged(true);
					
					employeeDelegate.doUpdateWaypro(empVO, userNew);
					if(employeeDelegate.doMessage(userNew)){
						if(empVO.isChanged()){
						line = rowCount + "   " + line + "    操作成功,数据正等待用户确认，如需查询，请点击\"短信二次确认数据查询\"";
						}else
						{
							line = rowCount + "   " + line + "    操作成功";
						}
					}else{
						line = rowCount + "   " + line + "    操作成功";
					}
					resultVO.setInfo(line);
					resultVO.setOk(true);
					
				}else{
					
					employeeDelegate.doCreateWaypro(buildEmpVO(content, "NEW"),
							userNew);
					if(employeeDelegate.doMessage(userNew)){
						line = rowCount + "   " + line + "    操作成功,数据正等待用户确认，如需查询，请点击\"短信二次确认数据查询\"";
					}else{
						line = rowCount + "   " + line + "    操作成功";
					}
					resultVO.setInfo(line);
					resultVO.setOk(true);
				}
				
				
			} else if (null != content[0] && content[0].equals("1")) {
				EmployeeVO empVO = buildEmpVO(content, "Update");
//				//查询人员的渠道编码
//				EmployeeListVO listVO=new EmployeeListVO();
//				listVO.set_se_telephone(empVO.getTelephone());
//				listVO.set_ne_isnet("2");
//				listVO.set_desc("1");
//				listVO.set_orderby("regdate");
//				DataPackage dp=employeeDelegate.doQuery(listVO, userNew);
				if (dp.getRowCount() == 0) {
					throw new Exception("找不到所要修改的记录");
					} else {
						EmployeeVO oldVO = (EmployeeVO) ((List) dp.getDatas())
								.get(0);
						empVO.setEmployeeid(oldVO.getEmployeeid());
						
						
						//比较人员状态和渠道编码是否变动.看是否要发短信.
						if(!empVO.getWayid().equals(oldVO.getWayid()) || !empVO.getEmpstatus().equals(oldVO.getEmpstatus())){
							empVO.setChanged(true);
						}
						if(!empVO.getWayid().equals(oldVO.getWayid())){
							String wayid2 = CityIDMap.conversionCityid(userNew.getCityid()) + "U_00000";
							//原有渠道等于个人推广专员渠道
							if(oldVO.getWayid().equals(wayid2)){
								//更新在后面做
							}
							//原有渠道不等于个人推广专员渠道
							else{
								throw new BusinessException("","推广专员已经注册");
							}
							
						}
						employeeDelegate.doUpdateWaypro(empVO, userNew);
						if(employeeDelegate.doMessage(userNew)){
							if(empVO.isChanged()){
								line = rowCount + "   " + line + "    操作成功,数据正等待用户确认，如需查询，请点击\"短信二次确认数据查询\"";
							}else
							{
								line = rowCount + "   " + line + "    操作成功";
							}
						}else{
							line = rowCount + "   " + line + "    操作成功";
						}
						resultVO.setInfo(line);
						resultVO.setOk(true);
					}
			}
		} catch (Exception e) {
			line = rowCount + "   " + line + "    错误信息:" + e.getMessage();
			resultVO.setInfo(line);
			resultVO.setOk(false);
		}
		return resultVO;
	}

	private EmployeeVO buildEmpVO(String content[], String operate)
			throws Exception {
		// ??注册日期难道可以修改吗?
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		EmployeeVO employeeVO = new EmployeeVO();
		employeeVO.setIsnet(new Short("2"));
		employeeVO.setWaytype("AG");
		employeeVO.setTelephone(content[1]);
		employeeVO.setWayid(content[2]);
		employeeVO.setEmployeename(content[3]);
		employeeVO.setSubname(content[4]);
		employeeVO.setEmpstatus(Short.valueOf(content[5]));
		employeeVO.setCardid(content[6]);
		employeeVO.setPvtemail(content[7]);
		employeeVO.setRegdate(new Date(format.parse(content[8]).getTime()));
		employeeVO.setIntime(new Date(format.parse(content[8]).getTime()));
		employeeVO.setOuttime(new Date(format.parse(content[9]).getTime()));
		if (StringUtils.isNotBlank(content[10])) {
			if("0".equals(content[10]))
			{
				employeeVO.setIsunpb(true);
			}else if("1".equals(content[10]))
			{
				employeeVO.setIsunpb(false);
			}
		}
		if (StringUtils.isNotBlank(content[11])) {
			employeeVO.setIstenseed(new Short(content[11]));
		}
		if (StringUtils.isNotBlank(content[12])) {
			employeeVO.setIsinternal(new Short(content[12]));
		}
		employeeVO.setEmpattr(content[13]);
		employeeVO.setEmpattrmemo(content[14]);
		if(StringUtils.isNotBlank(content[15])){
			employeeVO.setEmpattr2(new Short(content[15]));
		}
		return employeeVO;
	}

}