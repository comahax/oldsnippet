package com.gmcc.pboss.BgProcess.resource.resource;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import com.sunrise.jop.common.utils.lang.LoggerUtils;


public abstract class BaseProcess {
	
	private Logger log = Logger.getLogger(BaseProcess.class);
	
	public abstract ResultVO processLine(String line, int rowCount);
	
	protected int success;
	protected int fail;
	
	public int getSuccess() {
		return success;
	}
	public void setSuccess(int success) {
		this.success = success;
	}

	public int getFail() {
		return fail;
	}
	public void setFail(int fail) {
		this.fail = fail;
	}


	/**
	 * 文件处理
	 * @param file 待处理文件
	 * @param errorDir	错误文件记录目录
	 * @throws Exception
	 */
	public void processFile(File file,String errorDir) throws Exception{
		
		String fileName = file.getName();
		fileName = fileName.substring(0, fileName.lastIndexOf("."));
		String outputFile = errorDir+File.separator+fileName+".ERR";

		BufferedReader reader = new BufferedReader(new FileReader(file));
		BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
		int rowCount = 0;
		String line = null;
		ResultVO resultVO = null;
		try{
			rowCount++;
			while((line = reader.readLine()) != null && !line.contains(ResourceDeploy.LINE_END_FLAG)){
				try{
					resultVO = processLine(line,rowCount);
					if(!resultVO.isOk()){//
						fail++;
						log.error("错误:"+resultVO.getInfo()+"\n");
						writer.write(resultVO.getInfo()+"\n");
					}else{
						success++;
					}
				}catch(Exception e){
					fail++;
					writer.write(rowCount+"|"+line+"|"+e.getMessage()+"\n");
					LoggerUtils.error(e, log);	
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			LoggerUtils.error(e, log);
		}finally{
			if( null != reader )
				reader.close();
			if( null != writer )
				writer.close();
		}
	}
	
	
	public static Date formatDate (String dateString,String format)throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.parse(dateString);
	}
	
}
