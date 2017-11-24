package com.gmcc.pboss.BgProcess.examine;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.log4j.Logger;

import com.gmcc.pboss.BgProcess.base.BgBase;
import com.gmcc.pboss.control.examine.importcoefficient.ImportCoefficient;
import com.gmcc.pboss.control.examine.importcoefficient.ImportCoefficientBO;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.CityMappingUtil;
import com.sunrise.jop.ui.User;
/**
 * 酬金考核系数后台导入
 * @author Administrator
 *
 */
public class ImportCoefficientProcess extends BgBase {
	private static Logger logger = Logger.getLogger(ImportCoefficientProcess.class);
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
	public static void main(String[] args){
		long start = System.currentTimeMillis();
		try{
			System.out.println("=================process start===========================");
			String exmnperiod = null;
			ImportCoefficientProcess process = new ImportCoefficientProcess();
			boolean isPass = process.checkArgs(args);
			if (!isPass) {
				return;
			}
			
			if(args.length>1){
				exmnperiod = args[1];
			}else{//考核周期默认为上个月
				Calendar calendar = Calendar.getInstance();
				calendar.add(Calendar.MONTH, -1);
				exmnperiod = sdf.format(calendar.getTime());
			}
			
			User user = process.getUser(args[0]);
			process.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/examine/hibernate.cfg.xml");
			process.init(args);
			ImportCoefficient bo = (ImportCoefficient)BOFactory.build(ImportCoefficientBO.class,user);
			bo.doImport(exmnperiod);
			
			System.out.println("=================process end==========================="+(System.currentTimeMillis()-start)/1000);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("=================process end==========================="+(System.currentTimeMillis()-start)/1000);
			LoggerUtils.error(e, logger);
		}	
	}
	
	
	@Override
	protected boolean checkArgs(String[] args) {
		// TODO Auto-generated method stub
		if (args.length < 1) {
			System.out.println(getHelp());
			return false;
		}
		if (!CityMappingUtil.contain(args[0])) {
			System.out.println("cityid is not exist");
			return false;
		}
		
		if(args.length >1 ){
			try{
				sdf.parse(args[1]);
			}catch(Exception e){
				System.out.println("日期["+args[1]+"]格式不正确 yyyyMM");
				return false;
			}
		}
		return true;
	}


	public void process(){
		
	}
	
	
}
