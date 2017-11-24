package com.asisinfo.staff.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.asisinfo.common.jdbc.PageJdbcTemplate;
import com.asisinfo.common.jdbc.RowMapperFactory;
import com.asisinfo.staff.bean.EmployeesNumber;
import com.asisinfo.staff.bean.StaffLog;
import com.asisinfo.staff.querybean.EmployeeQueryBean;
import com.asisinfo.staff.utils.RoleDecisionDevice;
import com.mysql.jdbc.ResultSet;
import com.skywin.webserviceclients.uip.UimUserInfo;

public class EmployeesService {
private Logger log = Logger.getLogger(this.getClass());
	
	private PageJdbcTemplate jdbcTemplate;

	public PageJdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(PageJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	/**
	 * 登录员工账号
	 * @param svrnum
	 * @return
	 */

	public EmployeesNumber login(String svrnum) {
		String sql="select a.staffid,a.StaffName,a.StaffAttr,a.Dept,a.Status,b.svrnum,b.NumberAttr from sa_st_staff a,sa_st_svrnum b where b.svrnum=? and a.staffid=b.staffid";
		
		Object[] params = new Object[] { svrnum };
		EmployeesNumber auth = null;
		try {
			auth = (EmployeesNumber) jdbcTemplate.queryForObject(sql, params,
					RowMapperFactory.createObjectRowMapper(EmployeesNumber.class));
			//getEmployeesByID("21016048");
		} catch (Exception e) {
			log.info("login error:" + e.getMessage());
		}
		return auth;
	}
	
	
	public EmployeesNumber getEmployeesByID(String staffid) {
		String sql="select a.staffid,a.StaffName,a.StaffAttr,a.Dept,a.Status,b.svrnum,b.NumberAttr  from sa_st_staff a,sa_st_svrnum b where b.staffid=? and a.staffid = b.staffid and b.isprimary = 1 limit 1 ";
		
		Object[] params = new Object[] { staffid };
		EmployeesNumber auths = new EmployeesNumber();
		try {
			log.info(" sql st!");
			auths =  (EmployeesNumber) jdbcTemplate.queryForObject(sql, params,
					RowMapperFactory.createObjectRowMapper(EmployeesNumber.class));
			if(auths != null ){
				log.info(" sql end!");
				//EmployeesNumber infos = auths.get(0);
				return auths;
			}			
		} catch (Exception e) {
			log.info("login error:" + e.getMessage());
		}
		return null;
	}
	

	
	
	
	
	public String getPermit(String staffid) {
		String sql="select permit from  sa_st_permit where staffid = ?";
		Object[] params = new Object[] { staffid };

		try {
			List<Map<String,String>> list = jdbcTemplate.queryForList(sql, params);
			if( list.size() > 0 ) {
				Map<String,String> map = list.get(0);
				log.info((String)map.get("permit"));
				return (String)map.get("permit");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "staff";
		}
		return "staff";
	}
	
	//查询是否存在该号码
	public boolean selectSvrnum(String svrnum){
		int count = jdbcTemplate.queryForInt("select count(*) from sa_st_staff a,sa_st_svrnum b where"
				+ " a.staffid=b.staffid and b.svrnum="+"'"+svrnum+"'");
		return count==0;
	}
    //根据号码查询员工归属
	public List selectNumber(String svrnums){
		String sql="select a.staffattr,a.staffid from sa_st_staff a,sa_st_svrnum b where a.staffid=b.staffid  and b.svrnum=?";
		Object[] params = new Object[] { svrnums };
		List number= new ArrayList();
		try {
			number =  jdbcTemplate.query(sql, params,
					RowMapperFactory.createObjectRowMapper(EmployeesNumber.class));
		} catch (Exception e) {

		}
		return  number;
	}
	/**
	 * 判断该号码是否属于该id
	 * @param staffid id
	 * @param svrnum 手机号码
	 * @return
	 */
	public boolean isMyNumber(String staffid,String svrnum){
		String sql = "select count(*) from sa_st_svrnum where staffid = ? and svrnum = ?";
		Object[] queryParm = {staffid,svrnum};
		int result = jdbcTemplate.queryForInt(sql,queryParm);
		return result==1;
	}
	
	/**
	 * 员工集群号码信息查询
	 * @param 
	 * @return
	 */
	public List<EmployeesNumber> queryEmployeeAndNumberList(EmployeeQueryBean bean){
		StringBuilder sql = new StringBuilder();
		sql.append("select a.staffid,a.staffname,a.staffattr,a.dept,a.status,a.chgtime,");
		sql.append("CASE b.IsPrimary when  0 then 0 ELSE a.position  END as position,");
		sql.append("b.svrnum,b.states,b.numberattr,b.isprimary,b.subsid,a.createtime,b.chgtime from sa_st_staff a,sa_st_svrnum b ");
		sql.append(" where a.staffid=b.staffid ");
		List<Object> queryParam = new ArrayList<Object>();
		if(StringUtils.isNotBlank(bean.getStaffid())){
			sql.append(" and a.staffid = ? ");
			queryParam.add(bean.getStaffid());
		}
		if(StringUtils.isNotBlank(bean.getStaffname())){
			sql.append(" and a.staffname like ? ");
			queryParam.add("%"+bean.getStaffname()+"%");
		}
		if(StringUtils.isNotBlank(bean.getSvrnum())){
			sql.append(" and b.svrnum = ? ");
			queryParam.add(bean.getSvrnum());
		}
		if(StringUtils.isNotBlank(bean.getStaffattr())){
			sql.append(" and a.staffattr = ? ");
			queryParam.add(bean.getStaffattr());
		}
		if(StringUtils.isNotBlank(bean.getDept())){
			sql.append(" and a.dept = ? ");
			queryParam.add(bean.getDept());
		}
		if(StringUtils.isNotBlank(bean.getNumberattr())){
			sql.append(" and b.numberattr = ? ");
			queryParam.add(bean.getNumberattr());
		}
		if(bean.getStatus()!=null){
			sql.append(" and a.status = ? ");
			queryParam.add(bean.getStatus());
		}
		sql.append(" order by a.staffid asc limit " + (bean.getPage() - 1)*bean.getRows() + "," + bean.getRows());
		List<EmployeesNumber> list = jdbcTemplate.query(sql.toString(),queryParam.toArray(),RowMapperFactory.createObjectRowMapper(EmployeesNumber.class));
		
		return list;
	}
	
	
	/**
	 * 员工集群号码总记录数查询
	 * @param 
	 * @return
	 */
	public int queryEmployeeAndNumberCount(EmployeeQueryBean bean){
		StringBuilder sql = new StringBuilder();
		sql.append("select count(*) from sa_st_staff a,sa_st_svrnum b ");
		sql.append(" where a.staffid=b.staffid ");
		List<Object> queryParam = new ArrayList<Object>();
		if(StringUtils.isNotBlank(bean.getStaffid())){
			sql.append(" and a.staffid = ? ");
			queryParam.add(bean.getStaffid());
		}
		if(StringUtils.isNotBlank(bean.getStaffname())){
			sql.append(" and a.staffname like ? ");
			queryParam.add("%"+bean.getStaffname()+"%");
		}
		if(StringUtils.isNotBlank(bean.getSvrnum())){
			sql.append(" and b.svrnum = ? ");
			queryParam.add(bean.getSvrnum());
		}
		if(StringUtils.isNotBlank(bean.getStaffattr())){
			sql.append(" and a.staffattr = ? ");
			queryParam.add(bean.getStaffattr());
		}
		if(StringUtils.isNotBlank(bean.getDept())){
			sql.append(" and a.dept = ? ");
			queryParam.add(bean.getDept());
		}
		if(StringUtils.isNotBlank(bean.getNumberattr())){
			sql.append(" and b.numberattr = ? ");
			queryParam.add(bean.getNumberattr());
		}
		if(bean.getStatus()!=null){
			sql.append(" and a.status = ? ");
			queryParam.add(bean.getStatus());
		}
		int count = jdbcTemplate.queryForInt(sql.toString(),queryParam.toArray());
		return count;
	}
	
	
	
	/**
	 * 为员工添加号码
	 * @param bean
	 * @param staff
	 */
	public void saveNumber(EmployeesNumber bean,StaffLog staff){
		EmployeesNumber emp = RoleDecisionDevice.getLoginUser();
		StringBuilder insertSql = new StringBuilder();
		insertSql.append(" insert into sa_st_svrnum (SVRNUM,StaffID,subsid,States,NumberAttr,IsPrimary,ChgTime) ");
		insertSql.append(" select ?,?,?,?,?,?,? from dual ");
		insertSql.append(" where not exists( select SVRNUM from sa_st_svrnum where ? = 1 and IsPrimary = 1 and StaffID = ?) ");
		List<Object> params = new ArrayList<Object>();
		params.add(bean.getSvrnum());
		params.add(bean.getStaffid());
		params.add(bean.getSubsid());
		params.add(bean.getStates());
		params.add(bean.getNumberattr());
		params.add(bean.getIsprimary());
		params.add(new Date());
		params.add(bean.getIsprimary());
		params.add(bean.getStaffid());
		switch (RoleDecisionDevice.getLoginUserRole()) {
		//省级管理员：直接进入下一步
		case gdadmin:
			break;
		//市级管理员:确认添加号码的员工是否是本地市员工
		case cityadmin:
			insertSql.append("and exists (select StaffID  from sa_st_staff where StaffID = ? and  Staffattr = ?)");
			params.add(bean.getStaffid());
			params.add(emp.getStaffattr());
			break;
		//普通职员
		case staff:
			throw new RuntimeException("普通员工没有该权限!");
		}
		int i = 0;
		try {
			i = jdbcTemplate.update(insertSql.toString(), params.toArray());
		} catch (Exception e) {
			log.error("保存失败！"+e.getMessage());
			throw new RuntimeException("保存失败！请检查该手机号码是否已经存在或者输入非法信息！");
		}
		if (i==0) {
			throw new RuntimeException("保存失败！请检查该员工是否已经存在主号！");
		}
		if (i==1) {
			String logSql = "INSERT INTO sa_wl_svrnumlog(operid,operdate,opertype,svrnum,states,"
					+ "numberattr,isprimary,chgtime) VALUES (?,?,0,?,?,?,?,now())";
			Object[] param=new Object[]{staff.getOperid(),staff.getOperdate(),staff.getSvrnum(),
					staff.getStates(),staff.getNumberattr(),staff.getIsprimary()};
			jdbcTemplate.update(logSql, param);
		}
	}
	
	/**
	 * 为员工添加信息
	 * @param bean
	 * @param staff
	 */
	public void saveEmployeeAndNumber(EmployeesNumber bean,StaffLog staff) throws SQLException{
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement statement = null;
		PreparedStatement stat = null;
		try {
			con = jdbcTemplate.getDataSource().getConnection();
			con.setAutoCommit(false);
		
			//添加员工信息
			String sql="insert into sa_st_staff (staffid,staffname,staffattr,dept,status,position,createtime,chgtime) values(?,?,?,?,?,?,now(),now())";
			String sql1="insert into sa_st_svrnum (SVRNUM,StaffID,subsid,States,NumberAttr,IsPrimary,ChgTime) values(?,?,null,?,?,?,now())";
			statement= con.prepareStatement(sql);
			stat= con.prepareStatement(sql1);
			statement.setString(1, bean.getStaffid());
			statement.setString(2, bean.getStaffname());
			statement.setString(3, bean.getStaffattr());
			statement.setString(4, bean.getDept());
			statement.setInt(5, bean.getStatus());
			statement.setInt(6, bean.getPosition());
			stat.setString(1,bean.getSvrnum());
			stat.setString(2, bean.getStaffid());
//			stat.setInt(3, bean.getSubsid());
			stat.setInt(3, bean.getStates());
			stat.setString(4, bean.getNumberattr());
			stat.setInt(5, bean.getIsprimary());
			statement.execute();
			stat.execute();
			saveLog(staff);
				con.commit();
			} catch (Exception e) {
				con.rollback();
				log.error("保存失败！"+e.getMessage());
				throw new RuntimeException("保存失败！");
			}finally {  
		           // 关闭Statement 
		           try { 
		        	   rs.close();
		        	   statement.close(); 
		        	   stat.close();

		           } catch (Exception e) {} 
		           // 关闭Connection 
		           try { 
		              con.close(); 

		           } catch (Exception e) {} 
		       } 
	}
	
	/**
	 * 根据员工编号
	 * @param bean
	 * @param staff
	 */
	public int  queryStaffid(EmployeesNumber bean){
		int count = jdbcTemplate.queryForInt("select count(*) from sa_st_staff a,sa_st_svrnum b where"
				+ " a.staffid=b.staffid and b.staffid="+"'"+bean.getStaffid()+"'");
		return count;
	}
	
	
	/**
	 * 删除员工信息
	 * @param bean
	 * @param staff
	 */
	public void deleteEmployeeAndNumber(EmployeesNumber bean,StaffLog staff,int i) throws SQLException{
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement statement = null;
		PreparedStatement stat = null;
		try {
			con = jdbcTemplate.getDataSource().getConnection();
			con.setAutoCommit(false);
			String sql_svr="delete from sa_st_svrnum where svrnum="+"'"+bean.getSvrnum()+"'";
			statement=con.prepareStatement(sql_svr);
			 statement.executeUpdate();
			saveDesvrnumLog(staff,bean);
			if(i==1){
				String sql="delete from sa_st_staff where staffid="+"'"+bean.getStaffid()+"'";
				stat=con.prepareStatement(sql);
				stat.executeUpdate();
				saveDestaffLog(staff,bean);
			}
				con.commit();
				con.setAutoCommit(true);// 恢复JDBC事务的默认提交方式
			} catch (Exception e) {
				con.rollback();
				log.error("删除失败！"+e.getMessage());
				throw new RuntimeException("删除失败！");
			}finally {  
		           // 关闭Statement 
		           try { 
		        	   rs.close();
		        	   statement.close(); 
		        	   stat.close();

		           } catch (Exception e) {} 
		           // 关闭Connection 
		           try { 
		              con.close(); 

		           } catch (Exception e) {} 
		       } 
	}
	
	/**
	 * 记录删除添加员工日志
	 * @param staffLog 日志对象
	
	 */
	public void saveDestaffLog(StaffLog staff,EmployeesNumber bean){
		String sql="INSERT INTO sa_wl_stafflog(operid,operdate,opertype,staffid,staffname,"
				+ "staffattr,dept,status,position,createtime,chgtime) VALUES (?,?,2,?,?,?,?,?,?,?,?)";
		Object[] params = new Object[]{bean.getStaffid(),staff.getOperdate(),staff.getStaffid(),
				staff.getStaffname(),staff.getStaffattr(),staff.getDept(),staff.getStatus(),
				staff.getPosition(),bean.getCreatetime(),bean.getChgtime()};
		try {
			//日志表
			int r =jdbcTemplate.update(sql,params);
			
			if(r != 1){
				throw new RuntimeException("插入失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("记录日志失败!"+e.getMessage());
		}
		
	}
	/**
	 * 记录删除添加员工号码日志
	 * @param svrnumLog 日志对象
	 */
	public void saveDesvrnumLog(StaffLog staff,EmployeesNumber bean){
		
		String sqls="INSERT INTO sa_wl_svrnumlog(operid,operdate,opertype,svrnum,states,"
				+ "numberattr,isprimary,chgtime) VALUES (?,?,2,?,?,?,?,?)";
		Object[] param = new Object[]{bean.getStaffid(),staff.getOperdate(),
				staff.getSvrnum(),staff.getStates(),staff.getNumberattr(),staff.getIsprimary(),bean.getChgtime()};
		try {
			int t =jdbcTemplate.update(sqls,param);
			if(t !=1){
				throw new RuntimeException("插入失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("记录日志失败!"+e.getMessage());
		}
		
	}
	
	
	/**
	 * 记录更新日志
	 * @param staffLog 日志对象
	
	 */
	public void saveLog(StaffLog staff){
		String sql="INSERT INTO sa_wl_stafflog(operid,operdate,opertype,staffid,staffname,"
				+ "staffattr,dept,status,position,createtime,chgtime) VALUES (?,?,0,?,?,?,?,?,?,now(),now())";
		
		String sqls="INSERT INTO sa_wl_svrnumlog(operid,operdate,opertype,svrnum,states,"
				+ "numberattr,isprimary,chgtime) VALUES (?,?,0,?,?,?,?,now())";
		
		Object[] params = new Object[]{staff.getOperid(),staff.getOperdate(),staff.getStaffid(),
				staff.getStaffname(),staff.getStaffattr(),staff.getDept(),staff.getStatus(),staff.getPosition()};
		
		Object[] param = new Object[]{staff.getOperid(),staff.getOperdate(),
				staff.getSvrnum(),staff.getStates(),staff.getNumberattr(),staff.getIsprimary()};
		try {
			
			//日志表
			int r =jdbcTemplate.update(sql,params);
			int t =jdbcTemplate.update(sqls,param);
			
			if(r != 1 && t !=1){
				
				throw new RuntimeException("插入失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("记录日志失败!"+e.getMessage());
		}
		
	}
	/**
	 * 判断该员工是否不存在
	 * @param staffid 
	 * @param 
	 * @return
	 */
	public boolean isMyStaffid(String staffid){
		String sql = "select count(*) from sa_st_svrnum where staffid = ?";
		Object[] queryParm = {staffid};
		int result = jdbcTemplate.queryForInt(sql,queryParm);
		return result==0;
	}
	
	/**
	 * 主号唯一性校验
	 * @param bean
	 * @return true 可以使用，false 不可以使用
	 */
	public boolean checkPrimaryPhone(EmployeesNumber bean) {
		String sql = "select count(*) from sa_st_svrnum where SVRNUM <> ? and StaffID = ? and IsPrimary=1";
		Object [] params = {bean.getSvrnum(),bean.getStaffid()};
		int i = jdbcTemplate.queryForInt(sql,params);
		return i==0;
	}
	/**
	 * 更新
	 * @param bean
	 * @param staffLog
	 */
	public void updateEmployeeAndNumber(EmployeesNumber bean,StaffLog staffLog){
		Connection con = null;
		PreparedStatement prs = null;
		try {
			StringBuilder staffUpdateSql = new StringBuilder();
			StringBuilder numberUpdateSql = new StringBuilder();
			staffUpdateSql.append("update sa_st_staff set StaffName = ?,StaffAttr = ?,Dept = ?,Status = ?,ChgTime = now()");
			if (bean.getPosition()!=null) {
				staffUpdateSql.append(" ,Position = ? ");
			}
			staffUpdateSql.append(" where StaffID = ?");
			numberUpdateSql.append("update sa_st_svrnum set States = ?,IsPrimary = ? ,ChgTime = now() ");
			numberUpdateSql.append(" where SVRNUM = ? and StaffID = ?");
			con = jdbcTemplate.getDataSource().getConnection();
			con.setAutoCommit(false);
			prs = con.prepareStatement(staffUpdateSql.toString()); 
			int i = 1;
			prs.setString(i++, bean.getStaffname());
			prs.setString(i++, bean.getStaffattr());
			prs.setString(i++, bean.getDept());
			prs.setInt(i++, bean.getStatus());
			if (bean.getPosition()!=null) {
				prs.setInt(i++, bean.getPosition());
			}
			prs.setString(i++, bean.getStaffid());
			int staffResult = prs.executeUpdate();
			prs = con.prepareStatement(numberUpdateSql.toString());
			i = 1;
//			prs.setInt(i++, bean.getSubsid());
			prs.setInt(i++, bean.getStates());
//			prs.setString(i++, bean.getNumberattr());
			prs.setInt(i++, bean.getIsprimary());
			prs.setString(i++, bean.getSvrnum());
			prs.setString(i++, bean.getStaffid());
			int numberResult = prs.executeUpdate();
			UpdateLog(staffLog, staffResult, numberResult,bean);
			con.commit();
			
		} catch (SQLException e) {
			if (con!=null) {
				try {
					con.rollback();
				} catch (SQLException e1) {
					log.error(e1);
				}
			}
			log.error(e);
			throw new RuntimeException("更新失败！");
		}finally {  
	           // 关闭Statement 
	           try { 
	        	   prs.close();
	        	   con.close(); 

	           } catch (Exception e) {} 
	           // 关闭Connection 
	           try { 
	              con.close(); 

	           } catch (Exception e) {} 
	       }
	}
	/**
	 * 记录更新日志
	 * @param staffLog 日志对象
	 * @param staffResult 更新员工表记录数
	 * @param numberResult 更新号码表记录数
	 */
	public void UpdateLog(StaffLog staff,int staffResult,int numberResult,EmployeesNumber bean){
		String sqls="INSERT INTO sa_wl_stafflog(operid,operdate,opertype,staffid,staffname,"
				+ "staffattr,dept,status,position,createtime,chgtime) VALUES (?,?,1,?,?,?,?,?,?,?,?)";
		
		String sqlt="INSERT INTO sa_wl_svrnumlog(operid,operdate,opertype,svrnum,states,"
				+ "numberattr,isprimary,chgtime) VALUES (?,?,1,?,?,?,?,?)";
		
		Object[] pa = new Object[]{staff.getOperid(),staff.getOperdate(),staff.getStaffid(),
				staff.getStaffname(),staff.getStaffattr(),staff.getDept(),staff.getStatus(),staff.getPosition(),
				bean.getCreatetime(),staff.getChgtime()};
		
		Object[] para = new Object[]{staff.getOperid(),staff.getOperdate(),
				staff.getSvrnum(),staff.getStates(),staff.getNumberattr(),staff.getIsprimary(),staff.getChgtime()};
		
		try {
			//日志表
			jdbcTemplate.update(sqls,pa);
			jdbcTemplate.update(sqlt,para);
			if (staffResult!=1 && numberResult!=1) {
				throw new RuntimeException("插入失败！");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("记录日志失败!"+e.getMessage());
		}
		
		
	}
	
	//写个方法用于条件查询service
		public List<UimUserInfo>  getUserInfoUserID(String userid){
			String sql="select * from UUM_USERINFO where userid = ?";
			Object[] params = new Object[] { userid };
			List<UimUserInfo> logins = new ArrayList<UimUserInfo>();
			try {
				logins =  jdbcTemplate.query(sql, params,
						RowMapperFactory.createObjectRowMapper(UimUserInfo.class));
			} catch (Exception e) {

			}
			return logins;
			
		}
		//查询费项表中是否存在该数据
		public boolean queryacct(int acctid,String acctname,float discount,String staffattr){
			int count = jdbcTemplate.queryForInt("select count(*) from ib_st_acct d where"
					+ "  d.acctid="+"'"+acctid+"' and d.acctname="+"'"+acctname+"'"
							+ " and d.discount="+"'"+discount+"' and d.staffattr="+"'"+staffattr+"'");
			return count==0;
		}
		
		//通过员工id查询数据
		public List<EmployeesNumber> queryStaffid(){
			String sql="";
			
			return null;
		}
		
	
}
