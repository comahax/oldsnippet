package com.gmcc.pboss.BgProcess.resource.resource;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.gmcc.pboss.BgProcess.base.BgBase;
import com.gmcc.pboss.business.base.sysparam.SysparamVO;
import com.gmcc.pboss.business.resource.resimport.ResimportVO;
import com.gmcc.pboss.control.base.sysparam.SysparamBO;
import com.gmcc.pboss.control.resource.resimport.Resimport;
import com.gmcc.pboss.control.resource.resimport.ResimportBO;
import com.sunrise.jop.common.utils.lang.LoggerUtils;
import com.sunrise.jop.infrastructure.control.BOFactory;
import com.sunrise.jop.ui.User;


/**
 * 资源入库
 * @author wefrogll
 * @version 1.0 2009-12-18
 */
public class ResourceDeploy  extends BgBase{

	public  final static String LINE_END_FLAG = "HDR2";//尾行标识
	private final static String SPLIT_SYMBOL = "&&";//字段分隔符
	
	private String interval; //程序暂停时间
	private String srcpath;  //程序扫描文件目录
	private String bakpath;  //程序备份文件目录
	private String errpath;  //程序错误日志文件目录
	
	private String defaultState;	//默认商品状态
	private String resourceUse;		//默认资源用途
	private String storage;			//默认存储库区
	private String comrescardState;	//充值卡商品状态
	private String simrescardState;	//空白SIM商品状态
	
		
	public static void main(String[] args){
		try{
			ResourceDeploy resourceDeploy = new ResourceDeploy();
			boolean isPass = resourceDeploy.checkArgs(args);
			if (!isPass) {
				return;
			}
			User user = resourceDeploy.getUser(args[0]);
			resourceDeploy.setHibernateConfigPath("/com/gmcc/pboss/BgProcess/resource/resource/hibernate.cfg.xml");
			resourceDeploy.setMyProfilePath("/resource_resource.properties");
			resourceDeploy.init(args);	
			long start = 0;
			while(true){
				try{
					log.info("========资源入库开始====================");
					start = System.currentTimeMillis();
					resourceDeploy.addResource(user);
				}catch(Exception e){
					e.printStackTrace();
				}
				log.info("========资源入库结束===========耗时（秒）："+(System.currentTimeMillis()-start)/1000);
				System.out.println("==============休眠 "+resourceDeploy.interval+" 分钟=====================");
				Thread.sleep(Integer.parseInt(resourceDeploy.interval)*60000);						
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	@Override
	protected void init(String[] args) throws Exception {
		// TODO Auto-generated method stub
		super.init(args);
		String cityid=args[0];
		interval = properties.getProperty(cityid+"_intervalMin");
		srcpath = properties.getProperty(cityid+"_file_receive");
		bakpath = properties.getProperty(cityid+"_file_bak");
		errpath = properties.getProperty(cityid+"_file_err");
		
		User user = super.getUser(args[0]);
		SysparamBO sysparamBO = (SysparamBO)BOFactory.build(SysparamBO.class,user);
		SysparamVO sysparamVO = new SysparamVO();
		sysparamVO.setSystemid(new Long(1));
		sysparamVO.setParamtype("pboss_fx");
		sysparamVO = sysparamBO.doFindByPk(sysparamVO);
		if(sysparamVO == null || sysparamVO.getParamvalue() == null || "".equals(sysparamVO.getParamvalue().trim()))
			throw new Exception("套卡入库默认商品状态");
		defaultState = sysparamVO.getParamvalue();
		
		sysparamVO = new SysparamVO();
		sysparamVO.setSystemid(new Long(7));
		sysparamVO.setParamtype("pboss_fx");
		sysparamVO = sysparamBO.doFindByPk(sysparamVO);
		if(sysparamVO == null || sysparamVO.getParamvalue() == null || "".equals(sysparamVO.getParamvalue().trim()))
			throw new Exception("充值卡入库默认商品状态");
		comrescardState = sysparamVO.getParamvalue();
		
		sysparamVO = new SysparamVO();
		sysparamVO.setSystemid(new Long(83));
		sysparamVO.setParamtype("pboss_fx");
		sysparamVO = sysparamBO.doFindByPk(sysparamVO);
		if(sysparamVO == null || sysparamVO.getParamvalue() == null || "".equals(sysparamVO.getParamvalue().trim()))
			throw new Exception("空白SIM商品状态");
		simrescardState = sysparamVO.getParamvalue();
		
		sysparamVO = new SysparamVO();
		sysparamVO.setSystemid(new Long(2));
		sysparamVO.setParamtype("pboss_fx");
		sysparamVO = sysparamBO.doFindByPk(sysparamVO);
		if(sysparamVO == null || sysparamVO.getParamvalue() == null || "".equals(sysparamVO.getParamvalue().trim()))
			throw new Exception("套卡入库默认资源用途");
		resourceUse = sysparamVO.getParamvalue();
		
		sysparamVO = new SysparamVO();
		sysparamVO.setSystemid(new Long(3));
		sysparamVO.setParamtype("pboss_fx");
		sysparamVO = sysparamBO.doFindByPk(sysparamVO);
		if(sysparamVO == null || sysparamVO.getParamvalue() == null || "".equals(sysparamVO.getParamvalue().trim()))
			throw new Exception("套卡入库默认所属库区");
		storage = sysparamVO.getParamvalue();
	}



	
	/**
	 * 资源入库
	 * @param user	//运行程序的用户包含地市标识
	 * @return
	 * @throws Exception 
	 */
	public void addResource(User user) throws Exception {
		try{
						
			//==========================后台系统统一工号为 用户里设置的,所以下面取系统工号不用 
//			sysparamVO = new SysparamVO();
//			sysparamVO.setSystemid(new Long(4));
//			sysparamVO.setParamtype("pboss");
//			sysparamVO = sysparamBO.doFindByPk(sysparamVO);
//			if(sysparamVO == null || sysparamVO.getParamvalue() == null || "".equals(sysparamVO.getParamvalue().trim()))
//				throw new Exception("资系统后台工号为空");
			String operator = user.getOprcode();
			
			this.processFile(srcpath, defaultState, resourceUse, storage,user);
		}catch(Exception e){
			LoggerUtils.error(e, log);
		}	
	}
	
	/**
	 * 处理入库的文件
	 * @param file	文件完整目录
	 * @param defaultState	默认商品状态
	 * @param resourceUse	默认资源用途
	 * @param storage		默认存储库区	
	 * @param user			操作用户（包含系统工号）
	 */
	private void processFile(String file,String defaultState,String resourceUse,String storage,User user ){
//		扫描指定文件目录，获取文件列表，如果无文件存在，程序进入休眠状态，休眠指定时间后重新开始扫描文件。如果有文件存在，对逐个文件进行处理：
		File processFile = new File(file);
		String line = null;
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		String batchNo = df.format(new Date());
		BufferedReader reader = null;
		File files[] = processFile.listFiles();
		for(File tempFile: files){
			FileReader fileReader = null;
			int lineCount = 0;
			int count = 0;//文件尾的记录数
			try{
				
//				1）	文件名匹配。按照协议内容匹配资源类型和地市标识，如果匹配失败，则返回处理下一个文件；如果匹配成功，则进入下一步处理。
				if(isProcessFile(tempFile,user.getCityid())){
					fileReader = new FileReader(tempFile);
					reader = new BufferedReader(fileReader);
					
					while((line = reader.readLine()) != null && !line.contains(LINE_END_FLAG) ){
						lineCount++;
					}
//					2）	文件完整性检查。检查文件最后一行是否存在尾行标记，如果不存在则认为文件不完整，将当前文件移入出错文件目录，
//					返回处理下一个文件；如果存在尾行标记，则获取文件体总行数（不包括尾行），将总行数与文件尾的记录数进行对比，
//					如果两者不一致，则认为文件不完整，将当前文件移入出错文件目录，返回处理下一个文件。如果文件体总行数和文件尾的记录数相同
//					，则通过文件完整性检查，进入下一步处理。
					if(null == line){
						log.info("==========文件 "+tempFile.getName()+" 不存在尾行标记==============");
						cutPaste(tempFile,errpath);
					}else{
						String[] endItems = line.trim().split("&&");
						count = Integer.parseInt(endItems[1]);
						if(count != lineCount){//将总行数与文件尾的记录数进行对比，如果两者不一致，则认为文件不完整，将当前文件移入出错文件目录，
							log.info("==========文件 "+tempFile.getName()+" 文件记录数与文件尾的记录数不一致==============");
							fileReader.close();
							reader.close();
							cutPaste(tempFile,errpath);
						}else{//返回处理下一个文件。如果文件体总行数和文件尾的记录数相同，则通过文件完整性检查，进入下一步处理。
//							3）	登记资源入库记录表
//							新增记录到资源入库记录表（IM_PR_RESIMPORT），编号取序列（IM_PR_RESIMPORT_SEQ），文件名为当前处理文件
//							，开始时间取当前时间，其他字段留空。记录新增记录的编号。
							Resimport resimportBO = (ResimportBO)BOFactory.build(ResimportBO.class,user);
							ResimportVO resimportVO = new ResimportVO();
							resimportVO.setFilename(tempFile.getName());
							resimportVO.setBegintime(new Date());
							resimportVO = resimportBO.doCreate(resimportVO);
//							4）	按照资源类型分别处理
//							文件处理过程中需要累计文件总记录数、成功记录数和失败记录数。
							BaseProcess bp = null;
							if(tempFile.getName().startsWith("COMRESSMP")){//套卡
								bp = new ComressmpProcess(user,defaultState,resourceUse,storage,batchNo);
								bp.processFile(tempFile,errpath);
							}else if(tempFile.getName().startsWith("COMRESCARD")){//充值卡
								bp = new ComrescardProcess(user,comrescardState,batchNo);
								bp.processFile(tempFile,errpath);
							}else if(tempFile.getName().startsWith("EMPTYSIM")){//空白SIM卡
								bp = new EmptysimProcess(user,simrescardState,batchNo);
								bp.processFile(tempFile,errpath);
							}else{//未定义
								throw new Exception("未知文件类型"+tempFile.getName());
							}
//							5）	更新资源入库记录表
//							单个文件处理完毕，将文件搬移到备份目录。根据编号更新资源入库记录表，完成时间取当前时间，资源总数、成功数、失败数取文件处理过程累计数据。

							resimportVO.setAmount(new Long(lineCount));
							resimportVO.setSuccessamt(new Long(bp.getSuccess()));
							resimportVO.setFailamt(new Long(bp.getFail()));
							resimportVO.setOvertime(new Date());
							resimportBO.doUpdate(resimportVO);
						}
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
			try {
				if(isProcessFile(tempFile,user.getCityid()))
				cutPaste(tempFile,bakpath);//备份文件
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.error("备份文件["+tempFile+"]出错:"+e.getMessage());
			}
		}
	}
	
	
	/**
	 * 判断文件是否为满足需要处理的文件
	 * @param file 
	 * @return
	 */
	private boolean isProcessFile(File file,String cityid){
//		采用“资源类型+地市+时间”的格式：
//		套卡（COMRESSMP_XX_YYYYMMDDHHMISS.DAT）
//		充值卡（COMRESCARD_XX_YYYYMMDDHHMISS.DAT）
//		空白SIM卡（EMPTYSIM_XX_YYYYMMDDHHMISS.DAT）

		if(file.isDirectory())
			return false;
		String reg = "(COMRESSMP|COMRESCARD|EMPTYSIM)_["+cityid+"]{2}_\\d{14}\\.DAT";
		return file.getName().matches(reg);
	}
	
	/**
	 * 剪切文件
	 * @param file		被剪切的文件
	 * @param destDir	粘贴到的文件目录
	 * @throws Exception
	 */
	private void cutPaste(File file,String destDir) throws Exception{
		log.info("==========资源文件移至目录=========="+destDir);
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



	public String getInterval() {
		return interval;
	}

	public void setInterval(String interval) {
		this.interval = interval;
	}

	public String getSrcpath() {
		return srcpath;
	}

	public void setSrcpath(String srcpath) {
		this.srcpath = srcpath;
	}

	public String getBakpath() {
		return bakpath;
	}

	public void setBakpath(String bakpath) {
		this.bakpath = bakpath;
	}

	public String getErrpath() {
		return errpath;
	}

	public void setErrpath(String errpath) {
		this.errpath = errpath;
	}
	
	
}
