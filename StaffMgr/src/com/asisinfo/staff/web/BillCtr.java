package com.asisinfo.staff.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.asisinfo.common.utils.RequestUtils;
import com.asisinfo.common.web.BaseController;
import com.asisinfo.common.web.ResultMap;
import com.asisinfo.staff.WebConstant;
import com.asisinfo.staff.bean.Bill;
import com.asisinfo.staff.bean.EmployeesNumber;
import com.asisinfo.staff.service.BillService;
import com.asisinfo.staff.service.EmployeesService;


public class BillCtr extends BaseController{
	private BillService billService;
	
	private EmployeesService employeesService;
	
	private String staffperm;
	
	public String index(HttpServletRequest request,
			HttpServletResponse response){
		return "bills/index";
	}
	
	
	public ResultMap querys(HttpServletRequest request,
			HttpServletResponse response){
		ResultMap result = ResultMap.defaultResultMap();
		ResultMap result2 = ResultMap.defaultResultMap();
		//查询数据库
		int page = RequestUtils.getIntParam(request, "page", 1);
		int rows = RequestUtils.getIntParam(request, "rows", 10);
			staffperm = (String) request.getSession().getAttribute("loginperm");
			//得到当前登录的账号
			EmployeesNumber emps=(EmployeesNumber)request.getSession().getAttribute(WebConstant.USER_IN_SESSION);
			String svrnum=RequestUtils.getStringParam(request, "svrnums", "");
			String billcycss=RequestUtils.getStringParam(request, "billcycs", "");
			int billcycrr=RequestUtils.getIntParam(request, "billcycs", -1);
			 String svrnums = null;
			 String staffattrs=null;
			 String staffids=null;
			 String staffattr=null;
			 String staffid=null;
		        if (emps != null) {
		        	svrnums=emps.getSvrnum();
		        }
		       
		        List lists= employeesService.selectNumber(svrnums);
		        for(int j=0;j<lists.size();j++){
		        	EmployeesNumber number=(EmployeesNumber)lists.get(j);
		        	staffattrs=number.getStaffattr(); 
		        	staffids=number.getStaffid();
		        }
		        
		        List staff=billService.selectStaff(svrnum);
		        for(int j=0;j<staff.size();j++){
		        	Bill bill=(Bill)staff.get(j);
		        	staffattr=bill.getStaffattr(); 
		        	staffid=bill.getStaffid();
		        }	
		        
		        List list = new ArrayList();
		        int count = 0; 
		        result.put("total", count);
				result.put("rows", list);
		       
		 if(svrnum != null  && billcycss !=null && !"".equals(svrnum) && !"".equals(billcycss)){
			 int billcycr=Integer.parseInt(billcycss);
			if(staffperm !=null && staffperm.equals("cityadmin")){
				if(staffattrs.equals(staffattr)){
					 count =getBillService().querysCountCity(staffid,billcycr);
					 list = getBillService().querysPageCity(page, rows,staffid,billcycr);
				}else{
					result.fails("地市管理员只允许查询本地市员工账单");
					return result;
				}
			}else if(staffperm !=null && staffperm.equals("staff")){
				if(staffattrs.equals(staffattr)){
				    count =getBillService().querysCountStaff(staffids,billcycr);
				    list = getBillService().querysPageStaff(page, rows,staffids,billcycr);
				}else{
					result.fails("只允许查询本人的账单数据");
					return result;
				}
			}else{
				 list=getBillService().querybill(page,rows,staffid,billcycr);
				 count=getBillService().queryCount(staffid,billcycr);
			}
		
			float cumulative = 0.00f;
			float cumulatives = 0.00f;
            float balances=0.00f;
			
			//查询出减免标记是1还是0
			for(int t=0;t<list.size();t++){
				Bill bills=(Bill) list.get(t);
				int flag=bills.getFlag();
				//核销
				float verification=bills.getVerification();
				//本月应缴话费
				float balance=bills.getBalance();
				//费项金额
				float amt=bills.getAmt();
				//自付
				float pay=bills.getPay();
				//费项  2代表超额话费 3代表非核销话费
				int  accts=bills.getAcctid();
				 String number =bills.getSvrnum();
				//费项
				int acctid = 0;
				//费项名称
				String acctName = null;
				int acctids = 0;
				String acctNames = null;
				if(flag==1){
					//核销
					bills.setVerification(verification);
					//非核销
					pay=0;
					bills.setPay(pay);
					//设置本月应缴话费
					balances=0;
					bills.setBalance(balances);
					//本月超额话费
					cumulatives=0;
					bills.setCumulative(cumulatives);
				}else{
					//核销
					verification=0;
					bills.setVerification(verification);
					//设置本月应缴话费
					bills.setBalance(balance);
					//根据减免标记为0，查询费项和费项名称
					List querys=billService.selectAcct(staffid, billcycrr);
					for(int j=0;j<querys.size();j++){
						Bill bill=(Bill) querys.get(j);
						acctid=bill.getAcctid();
						acctName=bill.getAcctname();
					}
					List listss=billService.queryAccts(number);
					for(int r=0;r<listss.size();r++){
						Bill billss=(Bill) listss.get(r);
						acctids=billss.getAcctid();
						acctNames=billss.getAcctname();
					}
					if(acctid==acctids && acctName.equals(acctNames)){
						if(accts==2){
							//本月超额话费
							bills.setCumulative(bills.getCumulative());
							//非核销
							pay=0;
							bills.setPay(pay);
						}else if(accts==3){
							//本月超额话费
							cumulatives=0;
							bills.setCumulative(cumulatives);
							//非核销
							bills.setPay(pay);
						}
					}
					
				}
			}
			result.put("total", count);
			result.put("rows", list);
		
		    return result;
			}else{
				
		    return result2;
			}
		 
	}	
	
	//根据号码去查询账单明细
	public Map querysBusiness(HttpServletRequest request,
			HttpServletResponse response){
		
		ResultMap result = ResultMap.defaultResultMap();
		//查询数据库
		int page = RequestUtils.getIntParam(request, "page", 1);
		int rows = RequestUtils.getIntParam(request, "rows", 10);
		String svrnum=RequestUtils.getStringParam(request, "svrnums", "");
		
		int count =getBillService().querySvrnum(svrnum);
        List list = getBillService().querysPageSvrnum(page,rows,svrnum);
        result.put("total", count);
		result.put("rows", list);
	    return result;
		
	}
	
	public BillService getBillService() {
		return billService;
	}

	public void setBillService(BillService billService) {
		this.billService = billService;
	}


	public String getStaffperm() {
		return staffperm;
	}


	public void setStaffperm(String staffperm) {
		this.staffperm = staffperm;
	}


	public EmployeesService getEmployeesService() {
		return employeesService;
	}


	public void setEmployeesService(EmployeesService employeesService) {
		this.employeesService = employeesService;
	}
	
	
}
