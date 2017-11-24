package com.asisinfo.staff.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.asisinfo.common.jdbc.PageJdbcTemplate;
import com.asisinfo.common.jdbc.RowMapperFactory;
import com.asisinfo.staff.bean.Bill;

public class BillService {
private Logger log = Logger.getLogger(this.getClass());
	
		private PageJdbcTemplate jdbcTemplate;

		public PageJdbcTemplate getJdbcTemplate() {
			return jdbcTemplate;
		}

		public void setJdbcTemplate(PageJdbcTemplate jdbcTemplate) {
			this.jdbcTemplate = jdbcTemplate;
		}
	
		public List querybill(int page, int rows,String staffid,int billcycr){
			String sql="select a.staffid,b.svrnum,b.isprimary,b.numberattr,c.amt as verification,c.amt as pay,"
					+ "c.amt as cumulative,c.amt as balance,c.flag,c.acctid,c.amt"
					+ " from sa_st_staff a,sa_st_svrnum b,ib_st_bill c where "
					+ " a.staffid=b.staffid and b.subsid=c.subsid and b.states=0 and a.staffid='"+staffid+"' and c.billcyc='"+billcycr+"'";
			sql = sql + " order by a.staffid desc limit " + (page - 1)*rows + "," + rows;
				
			List bill= jdbcTemplate.query(sql,RowMapperFactory.createObjectRowMapper(Bill.class));
			return bill;
		}
	
		public int queryCount(String staffid,int billcycr) {
			String sql="select count(*) from sa_st_staff a,sa_st_svrnum b,ib_st_bill c where"
					+ " a.staffid=b.staffid and b.subsid=c.subsid and b.states=0 and "
					+ "a.staffid='"+staffid+"' and c.billcyc='"+billcycr+"'";
		
			int count = jdbcTemplate.queryForInt(sql);
			return count;
		}
	
	//根据号码查询员工归属
		public List selectStaff(String svrnum){
			String sql="select a.staffattr,a.staffid from sa_st_staff a,sa_st_svrnum b where a.staffid=b.staffid  and b.svrnum=?";
			Object[] params = new Object[] { svrnum };
			List staff=null;
			try {
				staff =  jdbcTemplate.query(sql, params,
						RowMapperFactory.createObjectRowMapper(Bill.class));
			} catch (Exception e) {

			}
			return  staff;
		}
	
		//cityadmin条件查询所有
		public List querysPageCity(int page, int rows,String staffid,int billcycr){
			String sql="select a.staffid,b.svrnum,b.isprimary,b.numberattr,c.amt as verification,c.amt as pay,"
					+ "c.amt as cumulative,c.amt as balance,c.flag,c.acctid,c.amt"
					+ " from sa_st_staff a,sa_st_svrnum b,ib_st_bill c where  a.staffid=b.staffid"
					+ " and b.subsid=c.subsid and b.states=0 and a.staffid='"+staffid+"' and c.billcyc='"+billcycr+"'";
				sql = sql + " order by a.staffid desc limit " + (page - 1)*rows + "," + rows;
					
				List bill= jdbcTemplate.query(sql,RowMapperFactory.createObjectRowMapper(Bill.class));
				return bill;
		}
	
		//cityadmin条件查询所有
		public int querysCountCity(String staffid,int billcycr) {
			String sql="select count(*) from sa_st_staff a,sa_st_svrnum b,ib_st_bill c where"
					+ " a.staffid=b.staffid and b.subsid=c.subsid and b.states=0 and"
					+ " a.staffid='"+staffid+"' and c.billcyc='"+billcycr+"'";
			
			int count = jdbcTemplate.queryForInt(sql);
			return count;
		}
		
		
		//staff条件查询所有
		public List querysPageStaff(int page, int rows,String staffids,int billcycr){
			String sql="select a.staffid,b.svrnum,b.isprimary,b.numberattr,c.amt as verification,c.amt as pay,"
					+ "c.amt as cumulative,c.amt as balance,c.flag,c.acctid,c.amt"
					+ " from sa_st_staff a,sa_st_svrnum b,ib_st_bill c where  a.staffid=b.staffid "
					+ "and b.subsid=c.subsid and b.states=0 and a.staffid='"+staffids+"' and c.billcyc='"+billcycr+"'";
				sql = sql + " order by a.staffid desc limit " + (page - 1)*rows + "," + rows;
					
				List bill= jdbcTemplate.query(sql,RowMapperFactory.createObjectRowMapper(Bill.class));
				return bill;
		}
		//staff条件查询所有
		public int querysCountStaff(String staffids,int billcycr) {
			String sql="select count(*) from sa_st_staff a,sa_st_svrnum b,ib_st_bill c where"
					+ " a.staffid=b.staffid and b.subsid=c.subsid and b.states=0 and"
					+ " a.staffid='"+staffids+"' and c.billcyc='"+billcycr+"'";
			
				int count = jdbcTemplate.queryForInt(sql);
				return count;
				}
		
		public List selectAcct(String staffid,int billcycrr){
			String sql="select c.acctid,c.acctname,b.svrnum from sa_st_staff a,sa_st_svrnum b,ib_st_bill c where a.staffid=b.staffid"
					+ " and b.subsid=c.subsid and a.status=0 and b.states=0  and c.flag=0 and a.staffid='"+staffid+"'and"
							+ " c.billcyc ='"+billcycrr+"'";
			List acctName=null;
			try {
				acctName =  jdbcTemplate.query(sql,RowMapperFactory.createObjectRowMapper(Bill.class));
			} catch (Exception e) {
	
			}
			return  acctName;
			
		}
		
		public List queryAccts(String number){
			String sql="select d.acctid,d.acctname from sa_st_svrnum b,ib_st_bill c,"
					+ "ib_st_acct d where b.subsid=c.subsid and c.acctid=d.acctid and b.svrnum='"+number+"'";
			List list=null;
			try {
				list =  jdbcTemplate.query(sql,RowMapperFactory.createObjectRowMapper(Bill.class));
			} catch (Exception e) {
	
			}
			return  list;
		}
		
		//根据手机号码去询
		public int querySvrnum(String svrnum) {
			String sql="select count(*) from sa_st_svrnum b,ib_st_bill c where"
					+ " b.subsid=c.subsid  and b.svrnum='"+svrnum+"'";
			
			int count = jdbcTemplate.queryForInt(sql);
			return count;
		}
	
		public List querysPageSvrnum(int page, int rows,String svrnum){
			String sql="select b.staffid,b.svrnum,c.billcyc,c.flag,c.acctid,c.acctname,c.amt"
					+ " from sa_st_svrnum b,ib_st_bill c where"
					+ " b.subsid=c.subsid and b.svrnum='"+svrnum+"'";
				sql = sql + " order by c.subsid desc limit " + (page - 1)*rows + "," + rows;
					
				List bill= jdbcTemplate.query(sql,RowMapperFactory.createObjectRowMapper(Bill.class));
				
				return bill;
		}
	
}
