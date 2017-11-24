package com.gmcc.pboss.BgProcess.resource.simcard;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;

import com.gmcc.pboss.BgProcess.base.BgBase;
import com.gmcc.pboss.business.resource.simnoactinfofile.SimnoactinfofileDBParam;
import com.gmcc.pboss.control.resource.simnoactinfofile.Simnoactinfofile;
import com.gmcc.pboss.control.resource.simnoactinfofile.SimnoactinfofileBO;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.infrastructure.db.DataPackage;
import com.sunrise.jop.ui.User;



/**
 * 新增【空白SIM卡状态导入】后台逻辑
 * @author dengxx
 * @version 
 */
public class SimStateImportProcess extends BgBase{
	
	private String srcpath;  //程序扫描文件目录
	private String bakpath;  //程序备份文件目录
	private String errpath;  //程序错误日志文件目录
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			SimStateImportProcess simStateImportProcess = new SimStateImportProcess();
			boolean isPass = simStateImportProcess.checkArgs(args);
			if (!isPass) {
				return;
			}
			User user = simStateImportProcess.getUser(args[0]);
			simStateImportProcess.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/resource/simcard/hibernate.cfg.xml");
			simStateImportProcess.setMyProfilePath("/resource_simStateImport.properties");
			simStateImportProcess.init(args);
			
			log.info("========空白SIM卡状态导入开始====================");
			try{
				simStateImportProcess.processFile(user);
			}catch(Exception e){
				e.printStackTrace();
			}
			log.info("========空白SIM卡状态导入结束===========");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void processFile(User user ) throws Exception{
		//扫描指定文件目录，获取文件列表。如果有文件存在，对逐个文件进行处理：
		File processFile = new File(srcpath);
		String line = null;
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		BufferedReader reader = null;
		File files[] = processFile.listFiles();
		for(File tempFile: files){
			String filename = tempFile.getName();
			Simnoactinfofile simnoactinfofileBO = (SimnoactinfofileBO)BOFactory.build(SimnoactinfofileBO.class, user);
			SimnoactinfofileDBParam simnoactinfofileDBParam = new SimnoactinfofileDBParam();
			simnoactinfofileDBParam.set_se_filename(filename);
			DataPackage snfDP = simnoactinfofileBO.doQuery(simnoactinfofileDBParam);
			FileReader fileReader = null;
			try{
				if(snfDP.getRowCount() > 0){//移走文件
					cutPaste(tempFile,bakpath);//备份文件
				}else{
					//1）	文件名匹配。
					if(isProcessFile(tempFile,user.getCityid())){
						StateImportProcess stateImportProcess = new StateImportProcess(user);
						stateImportProcess.processFile(tempFile,errpath);
						cutPaste(tempFile,bakpath);//备份文件
					}else{//移到错误目录
						cutPaste(tempFile,errpath);
					}
				}
			}catch(Exception ex){
				LoggerUtils.error(ex, log);
			}finally{
				if( null != fileReader){
					try {
						fileReader.close();
						fileReader = null;
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if( null != reader )
					try {
						reader.close();
						reader = null;
					} catch (IOException e) {
						// TODO Auto-generated catch block
						LoggerUtils.error(e, log);
					}	
			}
			
		}
		
	}
	
	/**
	 * 判断文件是否为满足需要处理的文件
	 * @param file 
	 * @return
	 */
	private boolean isProcessFile(File file,String cityid){
		//SIMNOACTINFO+地市+日期.txt，如 SIMNOACTINFOGZ20100216.txt

		if(file.isDirectory())
			return false;
		String reg = "(SIMNOACTINFO)["+cityid+"]{2}\\d{8}\\.txt";
		return file.getName().matches(reg);
	}
	
	protected void init(String[] args) throws Exception {
		// TODO Auto-generated method stub
		super.init(args);
		String cityid=args[0];
		srcpath = properties.getProperty(cityid+"_file_receive");
		bakpath = properties.getProperty(cityid+"_file_bak");
		errpath = properties.getProperty(cityid+"_file_err");
		
		User user = super.getUser(args[0]);
		
	}
	
	/**
	 * 剪切文件
	 * @param file		被剪切的文件
	 * @param destDir	粘贴到的文件目录
	 * @throws Exception
	 */
	private void cutPaste(File file,String destDir) throws Exception{
		String filename = "";
		if(file != null)
			filename = file.getName();
		log.info("==========资源文件："+filename+"移至目录：=========="+destDir);
		BufferedReader reader =null;
		BufferedWriter writer = null;
		try{
			if(!file.exists())
				return ;
			reader = new BufferedReader(new FileReader(file));
			destDir = destDir.replace('/', File.separatorChar).replace('\\', File.separatorChar);
			if(!destDir.endsWith(""+File.separatorChar));
				destDir = destDir+File.separatorChar;
			File destFile = new File(destDir+file.getName());
			if(!destFile.exists())
				destFile.createNewFile();
			writer = new BufferedWriter(new FileWriter(destFile));
			String line = null;
			while( (line = reader.readLine()) != null){
				writer.write(line+"\n");
			}

			reader.close();
			file.delete();
		}catch(Exception e){
			e.printStackTrace();
			log.error("资源文件移至目录时出错："+e.getMessage());
			throw  e;
		}finally{
			if( null != writer)
				writer.close();
			if( null != reader)
				reader.close();
		}
	}
	
}
