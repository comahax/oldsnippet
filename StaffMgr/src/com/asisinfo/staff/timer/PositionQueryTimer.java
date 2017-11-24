package com.asisinfo.staff.timer;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.sql.PreparedStatement;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.jfree.util.Log;
import org.springframework.jdbc.core.RowMapper;

import com.asisinfo.common.jdbc.PageJdbcTemplate;
import com.asisinfo.common.jdbc.RowMapperFactory;
import com.asisinfo.staff.bean.Bill;
import com.asisinfo.staff.service.EmployeesService;

public class PositionQueryTimer implements Serializable{
	private PageJdbcTemplate jdbcTemplate;
	private static final long serialVersionUID = -8937620183371049301L;
	private Logger logger = Logger.getLogger(PositionQueryTimer.class);
	private EmployeesService employeesService;
	private static Properties pro = new Properties();
	private String positionQuery;
	private String billAdd;
	private String acct;
	
	{
		positionQuery="select a.staffid,b.subsid,b.svrnum,a.position,b.numberattr from sa_st_staff a,sa_st_svrnum b where a.staffid=b.staffid and b.isprimary=1 and a.position<>0";
		billAdd="insert into ib_st_bill(billcyc,subsid,mainsubsid,flag,acctid,acctname,amt) values(?,?,?,?,?,?,?)";
		acct="insert into ib_st_acct(acctid,acctname,discount,staffattr) values (?,?,?,?)";
	    init();
	}
	
	private void init() {
		BufferedInputStream is = null;
		String path = null;
		try {
			URL url = PositionQueryTimer.class.getResource("/pathinfo.properties");
			path = url.getPath();
			path = URLDecoder.decode(path, "GBK");
			path = path.replace('/', File.separatorChar).replace('\\',File.separatorChar);
			File f = new File(path);
			boolean b = f.exists();
			if (b) {
				is = new BufferedInputStream(new FileInputStream(f));
				pro.load(is);
			} else {
				logger.error("pathinfo.properties===配置文件不存在:" + f);
			}
		} catch (UnsupportedEncodingException e) {
			logger.error("pathinfo.properties ===" + e.toString(), e);
		} catch (IOException e) {
			logger.error("pathinfo.properties ===" + e.toString(), e);
		} catch (Exception e) {
			logger.error("pathinfo.properties ===" + e.toString(), e);
		} finally {
			IOUtils.closeQuietly(is);
		}
	}
	
	//edu
	public void positionQueryExport(){
        LinkedList list = new LinkedList(); 
//        File dir = new File("D:\\staff\\"); 
      String filess= pro.getProperty("uploadFile.oldfilePath")+ File.separator;
      File fi =new File(filess);    
      //如果文件夹不存在则创建    
      if  (!fi.exists()  && !fi.isDirectory())      
      {       
         fi.mkdir();    
      }
      
      //bill
      String disfile= pro.getProperty("downloadFile.newfilePath")+ File.separator;
      File disfiles =new File(disfile);    
      //如果文件夹不存在则创建    
      if  (!disfiles.exists()  && !disfiles.isDirectory())      
      {       
         fi.mkdir();    
      }
        
        String filename = pro.getProperty("uploadFile.newfilePath")+ File.separator;
        File dir = new File(filename); 
        File file[] = dir.listFiles(); 
        for (int i = 0; i < file.length; i++) { 
            if (file[i].isDirectory()) 
                list.add(file[i]); 
            else 
                file[i].delete(); 
        } 
        File tmp; 
        while (!list.isEmpty()) { 
            tmp = (File) list.removeFirst(); 
            if (tmp.isDirectory()) { 
                file = tmp.listFiles(); 
                if (file == null) 
                    continue; 
                for (int i = 0; i < file.length; i++) { 
                    if (file[i].isDirectory()) 
                        list.add(file[i]); 
                    else 
                        file[i].delete(); 
                } 
            } else { 
                tmp.delete(); 
            } 
        } 
		
	    List lists=null;
	    try {
			RowMapper rowMapper =RowMapperFactory.createObjectRowMapper(Bill.class);
			lists=jdbcTemplate.query(positionQuery, rowMapper);
			
			Calendar now = Calendar.getInstance();  
			int month = now.get(Calendar.MONTH) + 1;
			String billcyc = "";
			if(month > 9){
				billcyc = "" + now.get(Calendar.YEAR) + month;
			}else{
				billcyc = now.get(Calendar.YEAR) + "0" + month;
			}
			//System.out.println("billcyc:"+ billcyc);
			
			String path=pro.getProperty("uploadFile.newfilePath")+"STAFF_EDCHG_"+billcyc;
			String files=pro.getProperty("uploadFile.oldfilePath")+ File.separator;
			File myFilePath = new File(files);
			File f2 = null;
			if (!myFilePath.exists()) { // 如果该文件不存在,则创建
                myFilePath.mkdirs();
                 f2=new File(path);
                f2.createNewFile();
            }
			FileWriter writer = new FileWriter(path);
			
			String staffid="";
			String subsid ="";
			String svrnum ="";
			int position = 0;
			String numberattr="";
				 for(int j=0;j<lists.size();j++){
					 StringBuilder result = new StringBuilder();
					 Bill bill=(Bill) lists.get(j);
					 staffid=bill.getStaffid();
					 subsid=(null == bill.getSubsid() ? "" : bill.getSubsid());
					 svrnum=bill.getSvrnum();
					 position=bill.getPosition();
					 numberattr=bill.getNumberattr();
					 result.append(billcyc).append("|").append(staffid).append("|").append(subsid).append("|")
					 .append(svrnum).append("|").append(position).append("|").append(numberattr).append("|").append("\r\n");
					 writer.write(result.toString());
		        }
				 
				 writer.flush();
				 writer.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	    
	}
	
	public void readTxtFile(){
		Bill bill=new Bill();
	try {
		String encoding = "GBK";
//		File file = new File("\\uar\\StaffMgr\\bill");
		String file1 = pro.getProperty("downloadFile.newfilePath")+ File.separator;
		File file = new File(file1);
		 String test[];
		 if(file.exists()){
		    test=file.list();
		    for(int i=0;i<test.length;i++)
		    {
		     if(test[i].startsWith("STAFF_BILL")){
		    	 String b=test[i];
		    	 InputStreamReader read = new InputStreamReader(
		                    new FileInputStream(file+"\\"+b), encoding);//考虑到编码格式
		    	 
		            BufferedReader bufferedReader = new BufferedReader(read);
		            String lineTxt ="";
		            PreparedStatement pstmt = null;
		           // String p=null;
		            while ((lineTxt=bufferedReader.readLine()) != null) {
		            	System.out.println("yyyyyyyy"+lineTxt);
		            	String[] s=lineTxt.split("\\|");
		            	bill.setBillcyc(Integer.valueOf(s[0]));
		                bill.setSubsid(s[1].toString());
		                bill.setMainsubsid(s[2].toString());
		                bill.setFlag(Integer.valueOf(s[3]));
		                bill.setAcctid(Integer.valueOf(s[4]));
		                bill.setAcctname(s[5].toString());
		                bill.setAmt(Float.valueOf(s[6]));
		                bill.setNumberattr(s[7].toString());
		                jdbcTemplate.update(billAdd, new Object[]{bill.getBillcyc(),bill.getSubsid(),bill.getMainsubsid(),
		        				bill.getFlag(),bill.getAcctid(),bill.getAcctname(),bill.getAmt()});
		                
		                boolean isMyNumber = getEmployeesService().queryacct(bill.getAcctid(),bill.getAcctname(),bill.getDiscount(),bill.getStaffattr());
		                if(isMyNumber){
		                	jdbcTemplate.update(acct,new Object[]{bill.getAcctid(),bill.getAcctname(),bill.getDiscount(),bill.getStaffattr()});
				          }
		                }
		            
		            read.close();
		            deleteFiles();
		     }else{
            	 System.out.println("找不到指定的文件");

            	}
		    } 
		 }else{
			 System.out.println("找不到指定的路径");
		 }
            
            } catch (Exception e) {
                System.out.println("读取文件内容出错");
                e.printStackTrace();
            }

	}
	
	//数据添加完成之后删除该文件
	 public static void deleteFiles(){
		 LinkedList list = new LinkedList(); 
//	        File dir = new File("\\uar\\StaffMgr\\bill\\"); 
		 String filename2=pro.getProperty("downloadFile.newfilePath")+ File.separator;
		 File dir = new File(filename2); 
	        File file[] = dir.listFiles(); 
	        for (int i = 0; i < file.length; i++) { 
	            if (file[i].isDirectory()) 
	                list.add(file[i]); 
	            else 
	                file[i].delete(); 
	        } 
	        File tmp; 
	        while (!list.isEmpty()) { 
	            tmp = (File) list.removeFirst(); 
	            if (tmp.isDirectory()) { 
	                file = tmp.listFiles(); 
	                if (file == null) 
	                    continue; 
	                for (int i = 0; i < file.length; i++) { 
	                    if (file[i].isDirectory()) 
	                        list.add(file[i]); 
	                    else 
	                        file[i].delete(); 
	                } 
	            } else { 
	                tmp.delete(); 
	            } 
	        } 
	     }

	

	public EmployeesService getEmployeesService() {
		return employeesService;
	}


	public void setEmployeesService(EmployeesService employeesService) {
		this.employeesService = employeesService;
	}


	public PageJdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(PageJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	

}
